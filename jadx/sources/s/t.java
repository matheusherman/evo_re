package s;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class t {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final j.h<j.b> f18196f = j.h.f("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", j.b.f11513c);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final j.h<j.j> f18197g = j.h.e("com.bumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Deprecated
    public static final j.h<n> f18198h = n.f18191h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final j.h<Boolean> f18199i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final j.h<Boolean> f18200j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Set<String> f18201k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final b f18202l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final Set<ImageHeaderParser.ImageType> f18203m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final Queue<BitmapFactory.Options> f18204n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final m.d f18205a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DisplayMetrics f18206b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final m.b f18207c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<ImageHeaderParser> f18208d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final y f18209e = y.b();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface b {
        void a();

        void b(m.d dVar, Bitmap bitmap);
    }

    private static void c(ImageHeaderParser.ImageType imageType, z zVar, b bVar, m.d dVar, n nVar, int i10, int i11, int i12, int i13, int i14, BitmapFactory.Options options) {
        int i15;
        int i16;
        int i17;
        int i18;
        int iFloor;
        double dFloor;
        int iRound;
        if (i11 <= 0 || i12 <= 0) {
            if (Log.isLoggable("Downsampler", 3)) {
                Log.d("Downsampler", "Unable to determine dimensions for: " + imageType + " with target [" + i13 + "x" + i14 + "]");
                return;
            }
            return;
        }
        if (r(i10)) {
            i16 = i11;
            i15 = i12;
        } else {
            i15 = i11;
            i16 = i12;
        }
        float fB = nVar.b(i15, i16, i13, i14);
        if (fB <= 0.0f) {
            throw new IllegalArgumentException("Cannot scale with factor: " + fB + " from: " + nVar + ", source: [" + i11 + "x" + i12 + "], target: [" + i13 + "x" + i14 + "]");
        }
        n.g gVarA = nVar.a(i15, i16, i13, i14);
        if (gVarA == null) {
            throw new IllegalArgumentException("Cannot round with null rounding");
        }
        float f10 = i15;
        float f11 = i16;
        int i19 = i15;
        int i20 = i16;
        int iX = i19 / x(fB * f10);
        int iX2 = i20 / x(fB * f11);
        n.g gVar = n.g.MEMORY;
        int iMax = gVarA == gVar ? Math.max(iX, iX2) : Math.min(iX, iX2);
        int i21 = Build.VERSION.SDK_INT;
        int i22 = iMax;
        if (i21 > 23 || !f18201k.contains(options.outMimeType)) {
            int iMax2 = Math.max(1, Integer.highestOneBit(i22));
            i17 = (gVarA != gVar || ((float) iMax2) >= 1.0f / fB) ? iMax2 : iMax2 << 1;
        } else {
            i17 = 1;
        }
        options.inSampleSize = i17;
        if (imageType == ImageHeaderParser.ImageType.JPEG) {
            float fMin = Math.min(i17, 8);
            i18 = 0;
            iFloor = (int) Math.ceil(f10 / fMin);
            iRound = (int) Math.ceil(f11 / fMin);
            int i23 = i17 / 8;
            if (i23 > 0) {
                iFloor /= i23;
                iRound /= i23;
            }
        } else {
            i18 = 0;
            if (imageType == ImageHeaderParser.ImageType.PNG || imageType == ImageHeaderParser.ImageType.PNG_A) {
                float f12 = i17;
                iFloor = (int) Math.floor(f10 / f12);
                dFloor = Math.floor(f11 / f12);
            } else if (imageType.isWebp()) {
                if (i21 >= 24) {
                    float f13 = i17;
                    iFloor = Math.round(f10 / f13);
                    iRound = Math.round(f11 / f13);
                } else {
                    float f14 = i17;
                    iFloor = (int) Math.floor(f10 / f14);
                    dFloor = Math.floor(f11 / f14);
                }
            } else if (i19 % i17 == 0 && i20 % i17 == 0) {
                iFloor = i19 / i17;
                iRound = i20 / i17;
            } else {
                int[] iArrM = m(zVar, options, bVar, dVar);
                iFloor = iArrM[0];
                iRound = iArrM[1];
            }
            iRound = (int) dFloor;
        }
        double dB = nVar.b(iFloor, iRound, i13, i14);
        options.inTargetDensity = a(dB);
        options.inDensity = l(dB);
        if (s(options)) {
            options.inScaled = true;
        } else {
            options.inTargetDensity = i18;
            options.inDensity = i18;
        }
        if (Log.isLoggable("Downsampler", 2)) {
            Log.v("Downsampler", "Calculate scaling, source: [" + i11 + "x" + i12 + "], degreesToRotate: " + i10 + ", target: [" + i13 + "x" + i14 + "], power of two scaled: [" + iFloor + "x" + iRound + "], exact scale factor: " + fB + ", power of 2 sample size: " + i17 + ", adjusted scale factor: " + dB + ", target density: " + options.inTargetDensity + ", density: " + options.inDensity);
        }
    }

    private static int[] m(z zVar, BitmapFactory.Options options, b bVar, m.d dVar) {
        options.inJustDecodeBounds = true;
        i(zVar, options, bVar, dVar);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    private static void w(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        if (Build.VERSION.SDK_INT >= 26) {
            options.inPreferredColorSpace = null;
            options.outColorSpace = null;
            options.outConfig = null;
        }
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    private boolean z(ImageHeaderParser.ImageType imageType) {
        return true;
    }

    public boolean p(InputStream inputStream) {
        return true;
    }

    public boolean q(ByteBuffer byteBuffer) {
        return true;
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements b {
        a() {
        }

        @Override // s.t.b
        public void a() {
        }

        @Override // s.t.b
        public void b(m.d dVar, Bitmap bitmap) {
        }
    }

    static {
        Boolean bool = Boolean.FALSE;
        f18199i = j.h.f("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", bool);
        f18200j = j.h.f("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", bool);
        f18201k = Collections.unmodifiableSet(new HashSet(Arrays.asList("image/vnd.wap.wbmp", "image/x-ico")));
        f18202l = new a();
        f18203m = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));
        f18204n = e0.l.f(0);
    }

    private void b(z zVar, j.b bVar, boolean z10, boolean z11, BitmapFactory.Options options, int i10, int i11) {
        boolean zHasAlpha;
        if (this.f18209e.i(i10, i11, options, z10, z11)) {
            return;
        }
        if (bVar == j.b.PREFER_ARGB_8888) {
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            return;
        }
        try {
            zHasAlpha = zVar.d().hasAlpha();
        } catch (IOException e10) {
            if (Log.isLoggable("Downsampler", 3)) {
                Log.d("Downsampler", "Cannot determine whether the image has alpha or not from header, format " + bVar, e10);
            }
            zHasAlpha = false;
        }
        Bitmap.Config config = zHasAlpha ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
        options.inPreferredConfig = config;
        if (config == Bitmap.Config.RGB_565) {
            options.inDither = true;
        }
    }

    private l.v<Bitmap> g(z zVar, int i10, int i11, j.i iVar, b bVar) {
        byte[] bArr = (byte[]) this.f18207c.d(65536, byte[].class);
        BitmapFactory.Options optionsK = k();
        optionsK.inTempStorage = bArr;
        j.b bVar2 = (j.b) iVar.c(f18196f);
        j.j jVar = (j.j) iVar.c(f18197g);
        n nVar = (n) iVar.c(n.f18191h);
        boolean zBooleanValue = ((Boolean) iVar.c(f18199i)).booleanValue();
        j.h<Boolean> hVar = f18200j;
        try {
            return f.c(h(zVar, optionsK, nVar, bVar2, jVar, iVar.c(hVar) != null && ((Boolean) iVar.c(hVar)).booleanValue(), i10, i11, zBooleanValue, bVar), this.f18205a);
        } finally {
            v(optionsK);
            this.f18207c.put(bArr);
        }
    }

    private Bitmap h(z zVar, BitmapFactory.Options options, n nVar, j.b bVar, j.j jVar, boolean z10, int i10, int i11, boolean z11, b bVar2) {
        String str;
        long jB = e0.g.b();
        int[] iArrM = m(zVar, options, bVar2, this.f18205a);
        int i12 = iArrM[0];
        int i13 = iArrM[1];
        String str2 = options.outMimeType;
        boolean z12 = (i12 == -1 || i13 == -1) ? false : z10;
        int iA = zVar.a();
        int i14 = h0.i(iA);
        boolean zL = h0.l(iA);
        int i15 = i10;
        if (i15 == Integer.MIN_VALUE) {
            i15 = r(i14) ? i13 : i12;
        }
        if (i11 == -2147483648) {
            i11 = r(i14) ? i12 : i13;
        }
        ImageHeaderParser.ImageType imageTypeD = zVar.d();
        c(imageTypeD, zVar, bVar2, this.f18205a, nVar, i14, i12, i13, i15, i11, options);
        int i16 = i15;
        int i17 = i11;
        b(zVar, bVar, z12, zL, options, i16, i17);
        int i18 = Build.VERSION.SDK_INT;
        if (z(imageTypeD)) {
            if (i12 < 0 || i13 < 0 || !z11) {
                float f10 = s(options) ? options.inTargetDensity / options.inDensity : 1.0f;
                int i19 = options.inSampleSize;
                float f11 = i19;
                int iCeil = (int) Math.ceil(i12 / f11);
                int iCeil2 = (int) Math.ceil(i13 / f11);
                int iRound = Math.round(iCeil * f10);
                int iRound2 = Math.round(iCeil2 * f10);
                str = "Downsampler";
                if (Log.isLoggable(str, 2)) {
                    Log.v(str, "Calculated target [" + iRound + "x" + iRound2 + "] for source [" + i12 + "x" + i13 + "], sampleSize: " + i19 + ", targetDensity: " + options.inTargetDensity + ", density: " + options.inDensity + ", density multiplier: " + f10);
                }
                i16 = iRound;
                i17 = iRound2;
            } else {
                str = "Downsampler";
            }
            if (i16 > 0 && i17 > 0) {
                y(options, this.f18205a, i16, i17);
            }
        } else {
            str = "Downsampler";
        }
        if (jVar != null) {
            if (i18 >= 28) {
                options.inPreferredColorSpace = ColorSpace.get((jVar == j.j.DISPLAY_P3 && options.outColorSpace != null && options.outColorSpace.isWideGamut()) ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB);
            } else if (i18 >= 26) {
                options.inPreferredColorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
            }
        }
        Bitmap bitmapI = i(zVar, options, bVar2, this.f18205a);
        bVar2.b(this.f18205a, bitmapI);
        if (Log.isLoggable(str, 2)) {
            t(i12, i13, str2, options, bitmapI, i10, i11, jB);
        }
        if (bitmapI == null) {
            return null;
        }
        bitmapI.setDensity(this.f18206b.densityDpi);
        Bitmap bitmapM = h0.m(this.f18205a, bitmapI, iA);
        if (!bitmapI.equals(bitmapM)) {
            this.f18205a.c(bitmapI);
        }
        return bitmapM;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:?, code lost:
    
        throw r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Bitmap i(z zVar, BitmapFactory.Options options, b bVar, m.d dVar) {
        Bitmap bitmapI;
        if (!options.inJustDecodeBounds) {
            bVar.a();
            zVar.c();
        }
        int i10 = options.outWidth;
        int i11 = options.outHeight;
        String str = options.outMimeType;
        h0.h().lock();
        try {
            try {
                bitmapI = zVar.b(options);
            } catch (IllegalArgumentException e10) {
                IOException iOExceptionU = u(e10, i10, i11, str, options);
                if (Log.isLoggable("Downsampler", 3)) {
                    Log.d("Downsampler", "Failed to decode with inBitmap, trying again without Bitmap re-use", iOExceptionU);
                }
                Bitmap bitmap = options.inBitmap;
                if (bitmap == null) {
                    throw iOExceptionU;
                }
                try {
                    dVar.c(bitmap);
                    options.inBitmap = null;
                    bitmapI = i(zVar, options, bVar, dVar);
                } catch (IOException unused) {
                    throw iOExceptionU;
                }
            }
            h0.h().unlock();
            return bitmapI;
        } catch (Throwable th) {
            h0.h().unlock();
            throw th;
        }
    }

    @Nullable
    @TargetApi(19)
    private static String j(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig() + (" (" + bitmap.getAllocationByteCount() + ")");
    }

    private static synchronized BitmapFactory.Options k() {
        BitmapFactory.Options optionsPoll;
        Queue<BitmapFactory.Options> queue = f18204n;
        synchronized (queue) {
            optionsPoll = queue.poll();
        }
        if (optionsPoll == null) {
            optionsPoll = new BitmapFactory.Options();
            w(optionsPoll);
        }
        return optionsPoll;
    }

    private static int l(double d10) {
        if (d10 > 1.0d) {
            d10 = 1.0d / d10;
        }
        return (int) Math.round(d10 * 2.147483647E9d);
    }

    private static String n(BitmapFactory.Options options) {
        return j(options.inBitmap);
    }

    private static boolean r(int i10) {
        return i10 == 90 || i10 == 270;
    }

    private static boolean s(BitmapFactory.Options options) {
        int i10;
        int i11 = options.inTargetDensity;
        return i11 > 0 && (i10 = options.inDensity) > 0 && i11 != i10;
    }

    private static void t(int i10, int i11, String str, BitmapFactory.Options options, Bitmap bitmap, int i12, int i13, long j10) {
        Log.v("Downsampler", "Decoded " + j(bitmap) + " from [" + i10 + "x" + i11 + "] " + str + " with inBitmap " + n(options) + " for [" + i12 + "x" + i13 + "], sample size: " + options.inSampleSize + ", density: " + options.inDensity + ", target density: " + options.inTargetDensity + ", thread: " + Thread.currentThread().getName() + ", duration: " + e0.g.a(j10));
    }

    private static IOException u(IllegalArgumentException illegalArgumentException, int i10, int i11, String str, BitmapFactory.Options options) {
        return new IOException("Exception decoding bitmap, outWidth: " + i10 + ", outHeight: " + i11 + ", outMimeType: " + str + ", inBitmap: " + n(options), illegalArgumentException);
    }

    private static int x(double d10) {
        return (int) (d10 + 0.5d);
    }

    @TargetApi(26)
    private static void y(BitmapFactory.Options options, m.d dVar, int i10, int i11) {
        Bitmap.Config config;
        if (Build.VERSION.SDK_INT < 26) {
            config = null;
        } else if (options.inPreferredConfig == Bitmap.Config.HARDWARE) {
            return;
        } else {
            config = options.outConfig;
        }
        if (config == null) {
            config = options.inPreferredConfig;
        }
        options.inBitmap = dVar.e(i10, i11, config);
    }

    @RequiresApi(21)
    public l.v<Bitmap> d(ParcelFileDescriptor parcelFileDescriptor, int i10, int i11, j.i iVar) {
        return g(new z.c(parcelFileDescriptor, this.f18208d, this.f18207c), i10, i11, iVar, f18202l);
    }

    public l.v<Bitmap> e(InputStream inputStream, int i10, int i11, j.i iVar, b bVar) {
        return g(new z.b(inputStream, this.f18208d, this.f18207c), i10, i11, iVar, bVar);
    }

    public l.v<Bitmap> f(ByteBuffer byteBuffer, int i10, int i11, j.i iVar) {
        return g(new z.a(byteBuffer, this.f18208d, this.f18207c), i10, i11, iVar, f18202l);
    }

    public t(List<ImageHeaderParser> list, DisplayMetrics displayMetrics, m.d dVar, m.b bVar) {
        this.f18208d = list;
        this.f18206b = (DisplayMetrics) e0.k.d(displayMetrics);
        this.f18205a = (m.d) e0.k.d(dVar);
        this.f18207c = (m.b) e0.k.d(bVar);
    }

    private static int a(double d10) {
        int iL = l(d10);
        int iX = x(((double) iL) * d10);
        return x((d10 / ((double) (iX / iL))) * ((double) iX));
    }

    private static void v(BitmapFactory.Options options) {
        w(options);
        Queue<BitmapFactory.Options> queue = f18204n;
        synchronized (queue) {
            queue.offer(options);
        }
    }

    public boolean o(ParcelFileDescriptor parcelFileDescriptor) {
        return ParcelFileDescriptorRewinder.c();
    }
}
