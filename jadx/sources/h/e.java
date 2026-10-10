package h;

import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class e implements a {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final String f10717u = "e";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @ColorInt
    private int[] f10718a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @ColorInt
    private final int[] f10719b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a.InterfaceC0185a f10720c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ByteBuffer f10721d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private byte[] f10722e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private short[] f10723f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private byte[] f10724g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private byte[] f10725h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private byte[] f10726i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @ColorInt
    private int[] f10727j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f10728k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private c f10729l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Bitmap f10730m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f10731n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f10732o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f10733p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f10734q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f10735r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    private Boolean f10736s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @NonNull
    private Bitmap.Config f10737t;

    public e(@NonNull a.InterfaceC0185a interfaceC0185a, c cVar, ByteBuffer byteBuffer, int i10) {
        this(interfaceC0185a);
        q(cVar, byteBuffer, i10);
    }

    @ColorInt
    private int i(int i10, int i11, int i12) {
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        for (int i18 = i10; i18 < this.f10733p + i10; i18++) {
            byte[] bArr = this.f10726i;
            if (i18 >= bArr.length || i18 >= i11) {
                break;
            }
            int i19 = this.f10718a[bArr[i18] & 255];
            if (i19 != 0) {
                i13 += (i19 >> 24) & 255;
                i14 += (i19 >> 16) & 255;
                i15 += (i19 >> 8) & 255;
                i16 += i19 & 255;
                i17++;
            }
        }
        int i20 = i10 + i12;
        for (int i21 = i20; i21 < this.f10733p + i20; i21++) {
            byte[] bArr2 = this.f10726i;
            if (i21 >= bArr2.length || i21 >= i11) {
                break;
            }
            int i22 = this.f10718a[bArr2[i21] & 255];
            if (i22 != 0) {
                i13 += (i22 >> 24) & 255;
                i14 += (i22 >> 16) & 255;
                i15 += (i22 >> 8) & 255;
                i16 += i22 & 255;
                i17++;
            }
        }
        if (i17 == 0) {
            return 0;
        }
        return ((i13 / i17) << 24) | ((i14 / i17) << 16) | ((i15 / i17) << 8) | (i16 / i17);
    }

    @Override // h.a
    @Nullable
    public synchronized Bitmap a() {
        try {
            if (this.f10729l.f10702c <= 0 || this.f10728k < 0) {
                String str = f10717u;
                if (Log.isLoggable(str, 3)) {
                    Log.d(str, "Unable to decode frame, frameCount=" + this.f10729l.f10702c + ", framePointer=" + this.f10728k);
                }
                this.f10732o = 1;
            }
            int i10 = this.f10732o;
            if (i10 != 1 && i10 != 2) {
                this.f10732o = 0;
                if (this.f10722e == null) {
                    this.f10722e = this.f10720c.e(255);
                }
                b bVar = this.f10729l.f10704e.get(this.f10728k);
                int i11 = this.f10728k - 1;
                b bVar2 = i11 >= 0 ? this.f10729l.f10704e.get(i11) : null;
                int[] iArr = bVar.f10699k;
                if (iArr == null) {
                    iArr = this.f10729l.f10700a;
                }
                this.f10718a = iArr;
                if (iArr == null) {
                    String str2 = f10717u;
                    if (Log.isLoggable(str2, 3)) {
                        Log.d(str2, "No valid color table found for frame #" + this.f10728k);
                    }
                    this.f10732o = 1;
                    return null;
                }
                if (bVar.f10694f) {
                    System.arraycopy(iArr, 0, this.f10719b, 0, iArr.length);
                    int[] iArr2 = this.f10719b;
                    this.f10718a = iArr2;
                    iArr2[bVar.f10696h] = 0;
                    if (bVar.f10695g == 2 && this.f10728k == 0) {
                        this.f10736s = Boolean.TRUE;
                    }
                }
                return r(bVar, bVar2);
            }
            String str3 = f10717u;
            if (Log.isLoggable(str3, 3)) {
                Log.d(str3, "Unable to decode frame, status=" + this.f10732o);
            }
            return null;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // h.a
    public void clear() {
        this.f10729l = null;
        byte[] bArr = this.f10726i;
        if (bArr != null) {
            this.f10720c.d(bArr);
        }
        int[] iArr = this.f10727j;
        if (iArr != null) {
            this.f10720c.f(iArr);
        }
        Bitmap bitmap = this.f10730m;
        if (bitmap != null) {
            this.f10720c.c(bitmap);
        }
        this.f10730m = null;
        this.f10721d = null;
        this.f10736s = null;
        byte[] bArr2 = this.f10722e;
        if (bArr2 != null) {
            this.f10720c.d(bArr2);
        }
    }

    @Override // h.a
    public void f() {
        this.f10728k = -1;
    }

    public synchronized void q(@NonNull c cVar, @NonNull ByteBuffer byteBuffer, int i10) {
        try {
            if (i10 <= 0) {
                throw new IllegalArgumentException("Sample size must be >=0, not: " + i10);
            }
            int iHighestOneBit = Integer.highestOneBit(i10);
            this.f10732o = 0;
            this.f10729l = cVar;
            this.f10728k = -1;
            ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
            this.f10721d = byteBufferAsReadOnlyBuffer;
            byteBufferAsReadOnlyBuffer.position(0);
            this.f10721d.order(ByteOrder.LITTLE_ENDIAN);
            this.f10731n = false;
            Iterator<b> it = cVar.f10704e.iterator();
            while (it.hasNext()) {
                if (it.next().f10695g == 3) {
                    this.f10731n = true;
                    break;
                }
            }
            this.f10733p = iHighestOneBit;
            int i11 = cVar.f10705f;
            this.f10735r = i11 / iHighestOneBit;
            int i12 = cVar.f10706g;
            this.f10734q = i12 / iHighestOneBit;
            this.f10726i = this.f10720c.e(i11 * i12);
            this.f10727j = this.f10720c.b(this.f10735r * this.f10734q);
        } catch (Throwable th) {
            throw th;
        }
    }

    private void j(b bVar) {
        int i10;
        int i11;
        int i12;
        int i13;
        int[] iArr = this.f10727j;
        int i14 = bVar.f10692d;
        int i15 = this.f10733p;
        int i16 = i14 / i15;
        int i17 = bVar.f10690b / i15;
        int i18 = bVar.f10691c / i15;
        int i19 = bVar.f10689a / i15;
        boolean z10 = this.f10728k == 0;
        int i20 = this.f10735r;
        int i21 = this.f10734q;
        byte[] bArr = this.f10726i;
        int[] iArr2 = this.f10718a;
        Boolean bool = this.f10736s;
        int i22 = 8;
        int i23 = 0;
        int i24 = 0;
        int i25 = 1;
        while (i24 < i16) {
            int[] iArr3 = iArr;
            if (bVar.f10693e) {
                if (i23 >= i16) {
                    int i26 = i25 + 1;
                    i10 = i16;
                    if (i26 == 2) {
                        i25 = i26;
                        i23 = 4;
                    } else if (i26 == 3) {
                        i25 = i26;
                        i23 = 2;
                        i22 = 4;
                    } else if (i26 != 4) {
                        i25 = i26;
                    } else {
                        i25 = i26;
                        i23 = 1;
                        i22 = 2;
                    }
                } else {
                    i10 = i16;
                }
                i11 = i23 + i22;
            } else {
                i10 = i16;
                i11 = i23;
                i23 = i24;
            }
            int i27 = i23 + i17;
            boolean z11 = i15 == 1;
            if (i27 < i21) {
                int i28 = i27 * i20;
                int i29 = i28 + i19;
                int i30 = i29 + i18;
                int i31 = i28 + i20;
                if (i31 < i30) {
                    i30 = i31;
                }
                i12 = i11;
                int i32 = i24 * i15 * bVar.f10691c;
                if (z11) {
                    int i33 = i29;
                    while (i33 < i30) {
                        int i34 = i33;
                        int i35 = iArr2[bArr[i32] & 255];
                        if (i35 != 0) {
                            iArr3[i34] = i35;
                        } else if (z10 && bool == null) {
                            bool = Boolean.TRUE;
                        }
                        i32 += i15;
                        i33 = i34 + 1;
                    }
                } else {
                    int i36 = ((i30 - i29) * i15) + i32;
                    i13 = i15;
                    int i37 = i29;
                    while (i37 < i30) {
                        int i38 = i30;
                        int i39 = i(i32, i36, bVar.f10691c);
                        if (i39 != 0) {
                            iArr3[i37] = i39;
                        } else if (z10 && bool == null) {
                            bool = Boolean.TRUE;
                        }
                        i32 += i13;
                        i37++;
                        i30 = i38;
                    }
                }
                i24++;
                i15 = i13;
                iArr = iArr3;
                i16 = i10;
                i23 = i12;
            } else {
                i12 = i11;
            }
            i13 = i15;
            i24++;
            i15 = i13;
            iArr = iArr3;
            i16 = i10;
            i23 = i12;
        }
        if (this.f10736s == null) {
            this.f10736s = Boolean.valueOf(bool == null ? false : bool.booleanValue());
        }
    }

    private void k(b bVar) {
        b bVar2 = bVar;
        int[] iArr = this.f10727j;
        int i10 = bVar2.f10692d;
        int i11 = bVar2.f10690b;
        int i12 = bVar2.f10691c;
        int i13 = bVar2.f10689a;
        boolean z10 = this.f10728k == 0;
        int i14 = this.f10735r;
        byte[] bArr = this.f10726i;
        int[] iArr2 = this.f10718a;
        int i15 = 0;
        byte b10 = -1;
        while (i15 < i10) {
            int i16 = (i15 + i11) * i14;
            int i17 = i16 + i13;
            int i18 = i17 + i12;
            int i19 = i16 + i14;
            if (i19 < i18) {
                i18 = i19;
            }
            int i20 = bVar2.f10691c * i15;
            int i21 = i17;
            while (i21 < i18) {
                byte b11 = bArr[i20];
                int[] iArr3 = iArr;
                int i22 = b11 & 255;
                if (i22 != b10) {
                    int i23 = iArr2[i22];
                    if (i23 != 0) {
                        iArr3[i21] = i23;
                    } else {
                        b10 = b11;
                    }
                }
                i20++;
                i21++;
                iArr = iArr3;
            }
            i15++;
            bVar2 = bVar;
        }
        Boolean bool = this.f10736s;
        this.f10736s = Boolean.valueOf((bool != null && bool.booleanValue()) || (this.f10736s == null && z10 && b10 != -1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v15, types: [short] */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    private void l(b bVar) {
        int i10;
        int i11;
        short s10;
        e eVar = this;
        if (bVar != null) {
            eVar.f10721d.position(bVar.f10698j);
        }
        if (bVar == null) {
            c cVar = eVar.f10729l;
            i10 = cVar.f10705f;
            i11 = cVar.f10706g;
        } else {
            i10 = bVar.f10691c;
            i11 = bVar.f10692d;
        }
        int i12 = i10 * i11;
        byte[] bArr = eVar.f10726i;
        if (bArr == null || bArr.length < i12) {
            eVar.f10726i = eVar.f10720c.e(i12);
        }
        byte[] bArr2 = eVar.f10726i;
        if (eVar.f10723f == null) {
            eVar.f10723f = new short[4096];
        }
        short[] sArr = eVar.f10723f;
        if (eVar.f10724g == null) {
            eVar.f10724g = new byte[4096];
        }
        byte[] bArr3 = eVar.f10724g;
        if (eVar.f10725h == null) {
            eVar.f10725h = new byte[FragmentTransaction.TRANSIT_FRAGMENT_OPEN];
        }
        byte[] bArr4 = eVar.f10725h;
        int iP = eVar.p();
        int i13 = 1 << iP;
        int i14 = i13 + 1;
        int i15 = i13 + 2;
        int i16 = iP + 1;
        int i17 = (1 << i16) - 1;
        for (int i18 = 0; i18 < i13; i18++) {
            sArr[i18] = 0;
            bArr3[i18] = (byte) i18;
        }
        byte[] bArr5 = eVar.f10722e;
        int i19 = i16;
        int i20 = i15;
        int i21 = i17;
        int i22 = 0;
        int iO = 0;
        int i23 = 0;
        int i24 = 0;
        int i25 = 0;
        int i26 = 0;
        int i27 = -1;
        int i28 = 0;
        int i29 = 0;
        while (i22 < i12) {
            if (iO == 0) {
                iO = eVar.o();
                if (iO <= 0) {
                    eVar.f10732o = 3;
                    break;
                }
                i23 = 0;
            }
            i25 += (bArr5[i23] & 255) << i24;
            i23++;
            iO--;
            int i30 = i24 + 8;
            i20 = i20;
            int i31 = i19;
            int i32 = i27;
            short[] sArr2 = sArr;
            int i33 = i28;
            while (true) {
                bArr3 = bArr3;
                if (i30 < i31) {
                    i28 = i33;
                    break;
                }
                int i34 = i25 & i21;
                i25 >>= i31;
                i30 -= i31;
                if (i34 == i13) {
                    i31 = i16;
                    i20 = i15;
                    i21 = i17;
                    i32 = -1;
                } else {
                    if (i34 == i14) {
                        i28 = i33;
                        break;
                    }
                    byte[] bArr6 = bArr4;
                    if (i32 == -1) {
                        bArr2[i26] = bArr3[i34];
                        i26++;
                        i22++;
                        i32 = i34;
                        i33 = i32;
                        bArr4 = bArr6;
                    } else {
                        if (i34 >= i20) {
                            bArr6[i29] = (byte) i33;
                            i29++;
                            s10 = i32;
                        } else {
                            s10 = i34;
                        }
                        while (s10 >= i13) {
                            bArr6[i29] = bArr3[s10];
                            i29++;
                            s10 = sArr2[s10];
                        }
                        int i35 = bArr3[s10] & 255;
                        byte b10 = (byte) i35;
                        bArr2[i26] = b10;
                        while (true) {
                            i26++;
                            i22++;
                            if (i29 <= 0) {
                                break;
                            }
                            i29--;
                            bArr2[i26] = bArr6[i29];
                        }
                        if (i20 < 4096) {
                            sArr2[i20] = (short) i32;
                            bArr3[i20] = b10;
                            i20++;
                            if ((i20 & i21) == 0 && i20 < 4096) {
                                i31++;
                                i21 += i20;
                            }
                        }
                        i32 = i34;
                        bArr4 = bArr6;
                        i33 = i35;
                    }
                }
            }
            i24 = i30;
            sArr = sArr2;
            bArr3 = bArr3;
            i27 = i32;
            i19 = i31;
            eVar = this;
        }
        Arrays.fill(bArr2, i26, i12, (byte) 0);
    }

    private Bitmap n() {
        Boolean bool = this.f10736s;
        Bitmap bitmapA = this.f10720c.a(this.f10735r, this.f10734q, (bool == null || bool.booleanValue()) ? Bitmap.Config.ARGB_8888 : this.f10737t);
        bitmapA.setHasAlpha(true);
        return bitmapA;
    }

    private int p() {
        return this.f10721d.get() & 255;
    }

    private Bitmap r(b bVar, b bVar2) {
        int i10;
        int i11;
        Bitmap bitmap;
        int[] iArr = this.f10727j;
        int i12 = 0;
        if (bVar2 == null) {
            Bitmap bitmap2 = this.f10730m;
            if (bitmap2 != null) {
                this.f10720c.c(bitmap2);
            }
            this.f10730m = null;
            Arrays.fill(iArr, 0);
        }
        if (bVar2 != null && bVar2.f10695g == 3 && this.f10730m == null) {
            Arrays.fill(iArr, 0);
        }
        if (bVar2 != null && (i11 = bVar2.f10695g) > 0) {
            if (i11 == 2) {
                if (!bVar.f10694f) {
                    c cVar = this.f10729l;
                    int i13 = cVar.f10711l;
                    if (bVar.f10699k == null || cVar.f10709j != bVar.f10696h) {
                        i12 = i13;
                    }
                }
                int i14 = bVar2.f10692d;
                int i15 = this.f10733p;
                int i16 = i14 / i15;
                int i17 = bVar2.f10690b / i15;
                int i18 = bVar2.f10691c / i15;
                int i19 = bVar2.f10689a / i15;
                int i20 = this.f10735r;
                int i21 = (i17 * i20) + i19;
                int i22 = (i16 * i20) + i21;
                while (i21 < i22) {
                    int i23 = i21 + i18;
                    for (int i24 = i21; i24 < i23; i24++) {
                        iArr[i24] = i12;
                    }
                    i21 += this.f10735r;
                }
            } else if (i11 == 3 && (bitmap = this.f10730m) != null) {
                int i25 = this.f10735r;
                bitmap.getPixels(iArr, 0, i25, 0, 0, i25, this.f10734q);
            }
        }
        l(bVar);
        if (bVar.f10693e || this.f10733p != 1) {
            j(bVar);
        } else {
            k(bVar);
        }
        if (this.f10731n && ((i10 = bVar.f10695g) == 0 || i10 == 1)) {
            if (this.f10730m == null) {
                this.f10730m = n();
            }
            Bitmap bitmap3 = this.f10730m;
            int i26 = this.f10735r;
            bitmap3.setPixels(iArr, 0, i26, 0, 0, i26, this.f10734q);
        }
        Bitmap bitmapN = n();
        int i27 = this.f10735r;
        bitmapN.setPixels(iArr, 0, i27, 0, 0, i27, this.f10734q);
        return bitmapN;
    }

    @Override // h.a
    public void b() {
        this.f10728k = (this.f10728k + 1) % this.f10729l.f10702c;
    }

    @Override // h.a
    public int c() {
        return this.f10729l.f10702c;
    }

    @Override // h.a
    public int d() {
        int i10;
        if (this.f10729l.f10702c <= 0 || (i10 = this.f10728k) < 0) {
            return 0;
        }
        return m(i10);
    }

    @Override // h.a
    public void e(@NonNull Bitmap.Config config) {
        Bitmap.Config config2;
        Bitmap.Config config3 = Bitmap.Config.ARGB_8888;
        if (config == config3 || config == (config2 = Bitmap.Config.RGB_565)) {
            this.f10737t = config;
            return;
        }
        throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + config3 + " or " + config2);
    }

    @Override // h.a
    public int g() {
        return this.f10728k;
    }

    @Override // h.a
    @NonNull
    public ByteBuffer getData() {
        return this.f10721d;
    }

    @Override // h.a
    public int h() {
        return this.f10721d.limit() + this.f10726i.length + (this.f10727j.length * 4);
    }

    public int m(int i10) {
        if (i10 < 0) {
            return -1;
        }
        c cVar = this.f10729l;
        if (i10 < cVar.f10702c) {
            return cVar.f10704e.get(i10).f10697i;
        }
        return -1;
    }

    public e(@NonNull a.InterfaceC0185a interfaceC0185a) {
        this.f10719b = new int[256];
        this.f10737t = Bitmap.Config.ARGB_8888;
        this.f10720c = interfaceC0185a;
        this.f10729l = new c();
    }

    private int o() {
        int iP = p();
        if (iP <= 0) {
            return iP;
        }
        ByteBuffer byteBuffer = this.f10721d;
        byteBuffer.get(this.f10722e, 0, Math.min(iP, byteBuffer.remaining()));
        return iP;
    }
}
