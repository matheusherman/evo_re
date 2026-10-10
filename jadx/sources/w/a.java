package w;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.ImageHeaderParser;
import com.stub.StubApp;
import e0.l;
import j.k;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class a implements k<ByteBuffer, c> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final C0382a f19997f = new C0382a();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final b f19998g = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f19999a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<ImageHeaderParser> f20000b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b f20001c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final C0382a f20002d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final w.b f20003e;

    /* JADX INFO: renamed from: w.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @VisibleForTesting
    static class C0382a {
        h.a a(h.a.InterfaceC0185a interfaceC0185a, h.c cVar, ByteBuffer byteBuffer, int i10) {
            return new h.e(interfaceC0185a, cVar, byteBuffer, i10);
        }

        C0382a() {
        }
    }

    public a(Context context, List<ImageHeaderParser> list, m.d dVar, m.b bVar) {
        this(context, list, dVar, bVar, f19998g, f19997f);
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @VisibleForTesting
    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Queue<h.d> f20004a = l.f(0);

        synchronized h.d a(ByteBuffer byteBuffer) {
            h.d dVarPoll;
            try {
                dVarPoll = this.f20004a.poll();
                if (dVarPoll == null) {
                    dVarPoll = new h.d();
                }
            } catch (Throwable th) {
                throw th;
            }
            return dVarPoll.p(byteBuffer);
        }

        synchronized void b(h.d dVar) {
            dVar.a();
            this.f20004a.offer(dVar);
        }

        b() {
        }
    }

    @VisibleForTesting
    a(Context context, List<ImageHeaderParser> list, m.d dVar, m.b bVar, b bVar2, C0382a c0382a) {
        this.f19999a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f20000b = list;
        this.f20002d = c0382a;
        this.f20003e = new w.b(dVar, bVar);
        this.f20001c = bVar2;
    }

    @Nullable
    private e c(ByteBuffer byteBuffer, int i10, int i11, h.d dVar, j.i iVar) {
        StringBuilder sb2;
        long jB = e0.g.b();
        try {
            h.c cVarC = dVar.c();
            if (cVarC.b() > 0 && cVarC.c() == 0) {
                Bitmap.Config config = iVar.c(i.f20044a) == j.b.PREFER_RGB_565 ? Bitmap.Config.RGB_565 : Bitmap.Config.ARGB_8888;
                h.a aVarA = this.f20002d.a(this.f20003e, cVarC, byteBuffer, e(cVarC, i10, i11));
                aVarA.e(config);
                aVarA.b();
                Bitmap bitmapA = aVarA.a();
                if (bitmapA == null) {
                    if (Log.isLoggable("BufferGifDecoder", 2)) {
                        sb2 = new StringBuilder();
                    }
                    return null;
                }
                e eVar = new e(new c(this.f19999a, aVarA, r.l.c(), i10, i11, bitmapA));
                if (Log.isLoggable("BufferGifDecoder", 2)) {
                    Log.v("BufferGifDecoder", "Decoded GIF from stream in " + e0.g.a(jB));
                }
                return eVar;
            }
            if (!Log.isLoggable("BufferGifDecoder", 2)) {
                return null;
            }
            sb2 = new StringBuilder();
            sb2.append("Decoded GIF from stream in ");
            sb2.append(e0.g.a(jB));
            Log.v("BufferGifDecoder", sb2.toString());
            return null;
        } catch (Throwable th) {
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                Log.v("BufferGifDecoder", "Decoded GIF from stream in " + e0.g.a(jB));
            }
            throw th;
        }
    }

    @Override // j.k
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public e b(@NonNull ByteBuffer byteBuffer, int i10, int i11, @NonNull j.i iVar) {
        h.d dVarA = this.f20001c.a(byteBuffer);
        try {
            return c(byteBuffer, i10, i11, dVarA, iVar);
        } finally {
            this.f20001c.b(dVarA);
        }
    }

    @Override // j.k
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull ByteBuffer byteBuffer, @NonNull j.i iVar) {
        return !((Boolean) iVar.c(i.f20045b)).booleanValue() && com.bumptech.glide.load.a.g(this.f20000b, byteBuffer) == ImageHeaderParser.ImageType.GIF;
    }

    private static int e(h.c cVar, int i10, int i11) {
        int iHighestOneBit;
        int iMin = Math.min(cVar.a() / i11, cVar.d() / i10);
        if (iMin == 0) {
            iHighestOneBit = 0;
        } else {
            iHighestOneBit = Integer.highestOneBit(iMin);
        }
        int iMax = Math.max(1, iHighestOneBit);
        if (Log.isLoggable("BufferGifDecoder", 2) && iMax > 1) {
            Log.v("BufferGifDecoder", "Downsampling GIF, sampleSize: " + iMax + ", target dimens: [" + i10 + "x" + i11 + "], actual dimens: [" + cVar.d() + "x" + cVar.a() + "]");
        }
        return iMax;
    }
}
