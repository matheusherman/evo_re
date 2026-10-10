package n7;

import android.annotation.SuppressLint;
import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f16075a = true;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class b extends AbstractC0310a {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final byte[] f16078j = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static final byte[] f16079k = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        static final /* synthetic */ boolean f16080l = true;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final byte[] f16081c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f16082d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f16083e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f16084f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f16085g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f16086h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final byte[] f16087i;

        /* JADX WARN: Code duplicated, block: B:12:0x0050  */
        public boolean a(byte[] bArr, int i10, int i11, boolean z10) {
            int i12;
            int i13;
            int i14;
            int i15;
            byte b10;
            int i16;
            byte b11;
            byte b12;
            int i17;
            int i18;
            byte[] bArr2 = this.f16087i;
            byte[] bArr3 = this.f16076a;
            int i19 = this.f16083e;
            int i20 = i11 + i10;
            int i21 = this.f16082d;
            int i22 = 0;
            if (i21 != 1) {
                if (i21 == 2 && (i18 = i10 + 1) <= i20) {
                    byte[] bArr4 = this.f16081c;
                    i13 = ((bArr4[1] & 255) << 8) | ((bArr4[0] & 255) << 16) | (bArr[i10] & 255);
                    this.f16082d = 0;
                    i12 = i18;
                } else {
                    i12 = i10;
                    i13 = -1;
                }
            } else if (i10 + 2 <= i20) {
                i12 = i10 + 2;
                i13 = (bArr[i10 + 1] & 255) | ((this.f16081c[0] & 255) << 16) | ((bArr[i10] & 255) << 8);
                this.f16082d = 0;
            } else {
                i12 = i10;
                i13 = -1;
            }
            if (i13 != -1) {
                bArr3[0] = bArr2[(i13 >> 18) & 63];
                bArr3[1] = bArr2[(i13 >> 12) & 63];
                bArr3[2] = bArr2[(i13 >> 6) & 63];
                bArr3[3] = bArr2[i13 & 63];
                i19--;
                if (i19 == 0) {
                    if (this.f16086h) {
                        bArr3[4] = 13;
                        i17 = 5;
                    } else {
                        i17 = 4;
                    }
                    i14 = i17 + 1;
                    bArr3[i17] = 10;
                    i19 = 19;
                } else {
                    i14 = 4;
                }
            } else {
                i14 = 0;
            }
            while (true) {
                i12 += 3;
                if (i12 > i20) {
                    break;
                }
                int i23 = ((bArr[i12 + 1] & 255) << 8) | ((bArr[i12] & 255) << 16) | (bArr[i12 + 2] & 255);
                bArr3[i14] = bArr2[(i23 >> 18) & 63];
                bArr3[i14 + 1] = bArr2[(i23 >> 12) & 63];
                bArr3[i14 + 2] = bArr2[(i23 >> 6) & 63];
                bArr3[i14 + 3] = bArr2[i23 & 63];
                int i24 = i14 + 4;
                i19--;
                if (i19 == 0) {
                    if (this.f16086h) {
                        bArr3[i24] = 13;
                        i24 = i14 + 5;
                    }
                    i14 = i24 + 1;
                    bArr3[i24] = 10;
                    i19 = 19;
                } else {
                    i14 = i24;
                }
            }
            if (z10) {
                int i25 = this.f16082d;
                if (i12 - i25 == i20 - 1) {
                    if (i25 > 0) {
                        b12 = this.f16081c[0];
                        i22 = 1;
                    } else {
                        byte b13 = bArr[i12];
                        i12++;
                        b12 = b13;
                    }
                    int i26 = (b12 & 255) << 4;
                    this.f16082d = i25 - i22;
                    bArr3[i14] = bArr2[(i26 >> 6) & 63];
                    int i27 = i14 + 2;
                    bArr3[i14 + 1] = bArr2[i26 & 63];
                    if (this.f16084f) {
                        bArr3[i27] = 61;
                        i27 = i14 + 4;
                        bArr3[i14 + 3] = 61;
                    }
                    if (this.f16085g) {
                        if (this.f16086h) {
                            bArr3[i27] = 13;
                            i27++;
                        }
                        i15 = i27 + 1;
                        bArr3[i27] = 10;
                        i14 = i15;
                    } else {
                        i14 = i27;
                    }
                } else if (i12 - i25 == i20 - 2) {
                    if (i25 > 1) {
                        b10 = this.f16081c[0];
                        i22 = 1;
                    } else {
                        byte b14 = bArr[i12];
                        i12++;
                        b10 = b14;
                    }
                    int i28 = (b10 & 255) << 10;
                    if (i25 > 0) {
                        i16 = i22 + 1;
                        b11 = this.f16081c[i22];
                    } else {
                        i16 = i22;
                        b11 = bArr[i12];
                        i12++;
                    }
                    int i29 = i28 | ((b11 & 255) << 2);
                    this.f16082d = i25 - i16;
                    bArr3[i14] = bArr2[(i29 >> 12) & 63];
                    bArr3[i14 + 1] = bArr2[(i29 >> 6) & 63];
                    int i30 = i14 + 3;
                    bArr3[i14 + 2] = bArr2[i29 & 63];
                    if (this.f16084f) {
                        bArr3[i30] = 61;
                        i30 = i14 + 4;
                    }
                    if (this.f16085g) {
                        if (this.f16086h) {
                            bArr3[i30] = 13;
                            i30++;
                        }
                        i15 = i30 + 1;
                        bArr3[i30] = 10;
                        i14 = i15;
                    } else {
                        i14 = i30;
                    }
                } else if (this.f16085g && i14 > 0 && i19 != 19) {
                    if (this.f16086h) {
                        bArr3[i14] = 13;
                        i14++;
                    }
                    i15 = i14 + 1;
                    bArr3[i14] = 10;
                    i14 = i15;
                }
                boolean z11 = f16080l;
                if (!z11 && this.f16082d != 0) {
                    throw new AssertionError();
                }
                if (!z11 && i12 != i20) {
                    throw new AssertionError();
                }
            } else if (i12 == i20 - 1) {
                byte[] bArr5 = this.f16081c;
                int i31 = this.f16082d;
                this.f16082d = i31 + 1;
                bArr5[i31] = bArr[i12];
            } else if (i12 == i20 - 2) {
                byte[] bArr6 = this.f16081c;
                int i32 = this.f16082d;
                int i33 = i32 + 1;
                this.f16082d = i33;
                bArr6[i32] = bArr[i12];
                this.f16082d = i32 + 2;
                bArr6[i33] = bArr[i12 + 1];
            }
            this.f16077b = i14;
            this.f16083e = i19;
            return true;
        }

        public b(int i10, byte[] bArr) {
            boolean z10;
            boolean z11;
            byte[] bArr2;
            int i11;
            this.f16076a = bArr;
            if ((i10 & 1) == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.f16084f = z10;
            if ((i10 & 2) == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            this.f16085g = z11;
            this.f16086h = (i10 & 4) != 0;
            if ((i10 & 8) == 0) {
                bArr2 = f16078j;
            } else {
                bArr2 = f16079k;
            }
            this.f16087i = bArr2;
            this.f16081c = new byte[2];
            this.f16082d = 0;
            if (z11) {
                i11 = 19;
            } else {
                i11 = -1;
            }
            this.f16083e = i11;
        }
    }

    public static byte[] a(byte[] bArr, int i10) {
        return b(bArr, 0, bArr.length, i10);
    }

    /* JADX INFO: renamed from: n7.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static abstract class AbstractC0310a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public byte[] f16076a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f16077b;

        AbstractC0310a() {
        }
    }

    @SuppressLint({"Assert"})
    public static byte[] b(byte[] bArr, int i10, int i11, int i12) {
        b bVar = new b(i12, null);
        int i13 = (i11 / 3) * 4;
        if (!bVar.f16084f) {
            int i14 = i11 % 3;
            if (i14 == 1) {
                i13 += 2;
            } else if (i14 == 2) {
                i13 += 3;
            }
        } else if (i11 % 3 > 0) {
            i13 += 4;
        }
        if (bVar.f16085g && i11 > 0) {
            i13 += (((i11 - 1) / 57) + 1) * (bVar.f16086h ? 2 : 1);
        }
        bVar.f16076a = new byte[i13];
        bVar.a(bArr, i10, i11, true);
        if (f16075a || bVar.f16077b == i13) {
            return bVar.f16076a;
        }
        throw new AssertionError();
    }

    public static String c(byte[] bArr, int i10) {
        try {
            return new String(a(bArr, i10), "US-ASCII");
        } catch (UnsupportedEncodingException e10) {
            throw new AssertionError(e10);
        }
    }
}
