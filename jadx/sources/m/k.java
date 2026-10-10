package m;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class k implements d {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Bitmap.Config f15442k = Bitmap.Config.ARGB_8888;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l f15443a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<Bitmap.Config> f15444b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f15445c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final a f15446d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f15447e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f15448f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f15449g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f15450h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f15451i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f15452j;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private interface a {
        void a(Bitmap bitmap);

        void b(Bitmap bitmap);
    }

    k(long j10, l lVar, Set<Bitmap.Config> set) {
        this.f15445c = j10;
        this.f15447e = j10;
        this.f15443a = lVar;
        this.f15444b = set;
        this.f15446d = new b();
    }

    @Nullable
    private synchronized Bitmap m(int i10, int i11, @Nullable Bitmap.Config config) {
        Bitmap bitmapD;
        try {
            f(config);
            bitmapD = this.f15443a.d(i10, i11, config != null ? config : f15442k);
            if (bitmapD == null) {
                if (Log.isLoggable("LruBitmapPool", 3)) {
                    Log.d("LruBitmapPool", "Missing bitmap=" + this.f15443a.a(i10, i11, config));
                }
                this.f15450h++;
            } else {
                this.f15449g++;
                this.f15448f -= (long) this.f15443a.b(bitmapD);
                this.f15446d.a(bitmapD);
                p(bitmapD);
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                Log.v("LruBitmapPool", "Get bitmap=" + this.f15443a.a(i10, i11, config));
            }
            h();
        } catch (Throwable th) {
            throw th;
        }
        return bitmapD;
    }

    @TargetApi(19)
    private static void o(Bitmap bitmap) {
        bitmap.setPremultiplied(true);
    }

    private static void p(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
        o(bitmap);
    }

    private synchronized void q(long j10) {
        while (this.f15448f > j10) {
            try {
                Bitmap bitmapRemoveLast = this.f15443a.removeLast();
                if (bitmapRemoveLast == null) {
                    if (Log.isLoggable("LruBitmapPool", 5)) {
                        Log.w("LruBitmapPool", "Size mismatch, resetting");
                        i();
                    }
                    this.f15448f = 0L;
                    return;
                }
                this.f15446d.a(bitmapRemoveLast);
                this.f15448f -= (long) this.f15443a.b(bitmapRemoveLast);
                this.f15452j++;
                if (Log.isLoggable("LruBitmapPool", 3)) {
                    Log.d("LruBitmapPool", "Evicting bitmap=" + this.f15443a.e(bitmapRemoveLast));
                }
                h();
                bitmapRemoveLast.recycle();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // m.d
    @SuppressLint({"InlinedApi"})
    public void a(int i10) {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "trimMemory, level=" + i10);
        }
        if (i10 >= 40 || (Build.VERSION.SDK_INT >= 23 && i10 >= 20)) {
            b();
        } else if (i10 >= 20 || i10 == 15) {
            q(n() / 2);
        }
    }

    @Override // m.d
    public void b() {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "clearMemory");
        }
        q(0L);
    }

    @Override // m.d
    public synchronized void c(Bitmap bitmap) {
        try {
            if (bitmap == null) {
                throw new NullPointerException("Bitmap must not be null");
            }
            if (bitmap.isRecycled()) {
                throw new IllegalStateException("Cannot pool recycled bitmap");
            }
            if (bitmap.isMutable() && this.f15443a.b(bitmap) <= this.f15447e && this.f15444b.contains(bitmap.getConfig())) {
                int iB = this.f15443a.b(bitmap);
                this.f15443a.c(bitmap);
                this.f15446d.b(bitmap);
                this.f15451i++;
                this.f15448f += (long) iB;
                if (Log.isLoggable("LruBitmapPool", 2)) {
                    Log.v("LruBitmapPool", "Put bitmap in pool=" + this.f15443a.e(bitmap));
                }
                h();
                j();
                return;
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                Log.v("LruBitmapPool", "Reject bitmap from pool, bitmap: " + this.f15443a.e(bitmap) + ", is mutable: " + bitmap.isMutable() + ", is allowed config: " + this.f15444b.contains(bitmap.getConfig()));
            }
            bitmap.recycle();
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class b implements a {
        b() {
        }

        @Override // m.k.a
        public void a(Bitmap bitmap) {
        }

        @Override // m.k.a
        public void b(Bitmap bitmap) {
        }
    }

    @TargetApi(26)
    private static void f(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT >= 26 && config == Bitmap.Config.HARDWARE) {
            throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
        }
    }

    @NonNull
    private static Bitmap g(int i10, int i11, @Nullable Bitmap.Config config) {
        if (config == null) {
            config = f15442k;
        }
        return Bitmap.createBitmap(i10, i11, config);
    }

    private void h() {
        if (Log.isLoggable("LruBitmapPool", 2)) {
            i();
        }
    }

    private void i() {
        Log.v("LruBitmapPool", "Hits=" + this.f15449g + ", misses=" + this.f15450h + ", puts=" + this.f15451i + ", evictions=" + this.f15452j + ", currentSize=" + this.f15448f + ", maxSize=" + this.f15447e + "\nStrategy=" + this.f15443a);
    }

    private void j() {
        q(this.f15447e);
    }

    @TargetApi(26)
    private static Set<Bitmap.Config> k() {
        HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
        int i10 = Build.VERSION.SDK_INT;
        hashSet.add(null);
        if (i10 >= 26) {
            hashSet.remove(Bitmap.Config.HARDWARE);
        }
        return Collections.unmodifiableSet(hashSet);
    }

    private static l l() {
        return new o();
    }

    public long n() {
        return this.f15447e;
    }

    @Override // m.d
    @NonNull
    public Bitmap d(int i10, int i11, Bitmap.Config config) {
        Bitmap bitmapM = m(i10, i11, config);
        if (bitmapM != null) {
            bitmapM.eraseColor(0);
            return bitmapM;
        }
        return g(i10, i11, config);
    }

    @Override // m.d
    @NonNull
    public Bitmap e(int i10, int i11, Bitmap.Config config) {
        Bitmap bitmapM = m(i10, i11, config);
        if (bitmapM == null) {
            return g(i10, i11, config);
        }
        return bitmapM;
    }

    public k(long j10) {
        this(j10, l(), k());
    }
}
