package com.live.evo.util;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.LruCache;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import tv.danmaku.ijk.media.player.IMediaPlayer;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LruCache<String, BitmapDrawable> f7380a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b f7381b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Set<SoftReference<Bitmap>> f7382c;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a extends LruCache<String, BitmapDrawable> {
        a(int i10) {
            super(i10);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void entryRemoved(boolean z10, String str, BitmapDrawable bitmapDrawable, BitmapDrawable bitmapDrawable2) {
            if (g1.class.isInstance(bitmapDrawable)) {
                ((g1) bitmapDrawable).c(false);
            } else {
                y.this.f7382c.add(new SoftReference(bitmapDrawable.getBitmap()));
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public int sizeOf(String str, BitmapDrawable bitmapDrawable) {
            int iJ = y.j(bitmapDrawable) / 1024;
            if (iJ == 0) {
                return 1;
            }
            return iJ;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7384a = 5120;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f7385b = 70;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f7386c = true;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f7387d = false;
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class c extends Fragment {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Object f7388a;

        public Object R() {
            return this.f7388a;
        }

        public void S(Object obj) {
            this.f7388a = obj;
        }

        @Override // androidx.fragment.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setRetainInstance(true);
        }
    }

    @TargetApi(11)
    private static void c(BitmapFactory.Options options, y yVar) {
        if (yVar != null) {
            options.inMutable = true;
            Bitmap bitmapI = yVar.i(options);
            if (bitmapI != null) {
                options.inBitmap = bitmapI;
            }
        }
    }

    public static int d(BitmapFactory.Options options, int i10, int i11) {
        int i12 = options.outHeight;
        int i13 = options.outWidth;
        int i14 = 1;
        if (i12 <= i11 && i13 <= i10) {
            return 1;
        }
        int i15 = i12 / 2;
        int i16 = i13 / 2;
        while (i15 / i14 > i11 && i16 / i14 > i10) {
            i14 *= 2;
        }
        for (long j10 = (i13 / i14) * (i12 / i14); j10 > i10 * i11 * 4; j10 /= 2) {
            i14 *= 2;
        }
        return i14;
    }

    @TargetApi(19)
    private static boolean e(Bitmap bitmap, BitmapFactory.Options options) {
        int i10 = options.outWidth;
        int i11 = options.inSampleSize;
        return ((i10 / i11) * (options.outHeight / i11)) * k(bitmap.getConfig()) <= bitmap.getByteCount();
    }

    public static synchronized Bitmap f(URL url, int i10, int i11, y yVar) {
        Bitmap bitmapDecodeStream;
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(3000);
        httpURLConnection.setRequestMethod(IMediaPlayer.DRM_REQ_GET);
        bitmapDecodeStream = null;
        try {
            if (httpURLConnection.getResponseCode() == 200) {
                InputStream inputStream = httpURLConnection.getInputStream();
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                Bitmap bitmapDecodeStream2 = BitmapFactory.decodeStream(inputStream, null, options);
                try {
                    options.inSampleSize = d(options, i10, i11);
                    options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                    inputStream.close();
                    if (bitmapDecodeStream2 != null && !bitmapDecodeStream2.isRecycled()) {
                        bitmapDecodeStream2.recycle();
                    }
                    c(options, yVar);
                    options.inJustDecodeBounds = false;
                    HttpURLConnection httpURLConnection2 = (HttpURLConnection) url.openConnection();
                    httpURLConnection2.setConnectTimeout(2000);
                    httpURLConnection2.setRequestMethod(IMediaPlayer.DRM_REQ_GET);
                    InputStream inputStream2 = httpURLConnection2.getInputStream();
                    bitmapDecodeStream = httpURLConnection2.getResponseCode() == 200 ? BitmapFactory.decodeStream(inputStream2, null, options) : bitmapDecodeStream2;
                    inputStream2.close();
                } catch (Throwable unused) {
                    bitmapDecodeStream = bitmapDecodeStream2;
                }
            }
        } catch (Throwable unused2) {
        }
        return bitmapDecodeStream;
    }

    private static c g(FragmentManager fragmentManager) {
        c cVar = (c) fragmentManager.findFragmentByTag("ImageCache");
        if (cVar != null) {
            return cVar;
        }
        c cVar2 = new c();
        fragmentManager.beginTransaction().add(cVar2, "ImageCache").commitAllowingStateLoss();
        return cVar2;
    }

    private static int k(Bitmap.Config config) {
        if (config == Bitmap.Config.ARGB_8888) {
            return 4;
        }
        if (config == Bitmap.Config.RGB_565 || config == Bitmap.Config.ARGB_4444) {
            return 2;
        }
        Bitmap.Config config2 = Bitmap.Config.ALPHA_8;
        return 1;
    }

    private void m(b bVar) {
        this.f7381b = bVar;
        if (bVar.f7386c) {
            this.f7382c = Collections.synchronizedSet(new HashSet());
            this.f7380a = new a(this.f7381b.f7384a);
        }
    }

    public void b(String str, BitmapDrawable bitmapDrawable) {
        if (str == null || bitmapDrawable == null || this.f7380a == null) {
            return;
        }
        if (g1.class.isInstance(bitmapDrawable)) {
            ((g1) bitmapDrawable).c(true);
        }
        this.f7380a.put(str, bitmapDrawable);
    }

    public BitmapDrawable h(String str) {
        LruCache<String, BitmapDrawable> lruCache = this.f7380a;
        if (lruCache != null) {
            return lruCache.get(str);
        }
        return null;
    }

    protected Bitmap i(BitmapFactory.Options options) {
        Set<SoftReference<Bitmap>> set = this.f7382c;
        Bitmap bitmap = null;
        if (set == null || set.isEmpty()) {
            return null;
        }
        synchronized (this.f7382c) {
            try {
                Iterator<SoftReference<Bitmap>> it = this.f7382c.iterator();
                while (it.hasNext()) {
                    Bitmap bitmap2 = it.next().get();
                    if (bitmap2 == null || !bitmap2.isMutable()) {
                        it.remove();
                    } else if (e(bitmap2, options)) {
                        it.remove();
                        bitmap = bitmap2;
                        break;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return bitmap;
    }

    private y(b bVar) {
        m(bVar);
    }

    @TargetApi(19)
    public static int j(BitmapDrawable bitmapDrawable) {
        return bitmapDrawable.getBitmap().getByteCount();
    }

    public static y l(FragmentManager fragmentManager, b bVar) {
        c cVarG = g(fragmentManager);
        y yVar = (y) cVarG.R();
        if (yVar == null) {
            y yVar2 = new y(bVar);
            cVarG.S(yVar2);
            return yVar2;
        }
        return yVar;
    }
}
