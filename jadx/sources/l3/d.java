package l3;

import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final String[] f15185c = {"UPPER", "LOWER", "DIGIT", "MIXED", "PUNCT"};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final int[][] f15186d = {new int[]{0, 327708, 327710, 327709, 656318}, new int[]{590318, 0, 327710, 327709, 656318}, new int[]{262158, 590300, 0, 590301, 932798}, new int[]{327709, 327708, 656318, 0, 327710}, new int[]{327711, 656380, 656382, 656381, 0}};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int[][] f15187e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final int[][] f15188f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f15189a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Charset f15190b;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements Comparator<f> {
        a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(f fVar, f fVar2) {
            return fVar.f() - fVar2.f();
        }
    }

    static {
        Class cls = Integer.TYPE;
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) cls, 5, 256);
        f15187e = iArr;
        iArr[0][32] = 1;
        for (int i10 = 65; i10 <= 90; i10++) {
            f15187e[0][i10] = i10 - 63;
        }
        f15187e[1][32] = 1;
        for (int i11 = 97; i11 <= 122; i11++) {
            f15187e[1][i11] = i11 - 95;
        }
        f15187e[2][32] = 1;
        for (int i12 = 48; i12 <= 57; i12++) {
            f15187e[2][i12] = i12 - 46;
        }
        int[] iArr2 = f15187e[2];
        iArr2[44] = 12;
        iArr2[46] = 13;
        int[] iArr3 = {0, 32, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 27, 28, 29, 30, 31, 64, 92, 94, 95, 96, 124, 126, 127};
        for (int i13 = 0; i13 < 28; i13++) {
            f15187e[3][iArr3[i13]] = i13;
        }
        int[] iArr4 = {0, 13, 0, 0, 0, 0, 33, 39, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 58, 59, 60, 61, 62, 63, 91, 93, 123, 125};
        for (int i14 = 0; i14 < 31; i14++) {
            int i15 = iArr4[i14];
            if (i15 > 0) {
                f15187e[4][i15] = i14;
            }
        }
        int[][] iArr5 = (int[][]) Array.newInstance((Class<?>) cls, 6, 6);
        f15188f = iArr5;
        for (int[] iArr6 : iArr5) {
            Arrays.fill(iArr6, -1);
        }
        int[][] iArr7 = f15188f;
        iArr7[0][4] = 0;
        int[] iArr8 = iArr7[1];
        iArr8[4] = 0;
        iArr8[0] = 28;
        iArr7[3][4] = 0;
        int[] iArr9 = iArr7[2];
        iArr9[4] = 0;
        iArr9[0] = 15;
    }

    private static Collection<f> b(Iterable<f> iterable) {
        LinkedList linkedList = new LinkedList();
        for (f fVar : iterable) {
            Iterator it = linkedList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    linkedList.addFirst(fVar);
                    break;
                }
                f fVar2 = (f) it.next();
                if (fVar2.h(fVar)) {
                    break;
                }
                if (fVar.h(fVar2)) {
                    it.remove();
                }
            }
        }
        return linkedList;
    }

    private void c(f fVar, int i10, Collection<f> collection) {
        char c10 = (char) (this.f15189a[i10] & 255);
        boolean z10 = f15187e[fVar.g()][c10] > 0;
        f fVarD = null;
        for (int i11 = 0; i11 <= 4; i11++) {
            int i12 = f15187e[i11][c10];
            if (i12 > 0) {
                if (fVarD == null) {
                    fVarD = fVar.d(i10);
                }
                if (!z10 || i11 == fVar.g() || i11 == 2) {
                    collection.add(fVarD.i(i11, i12));
                }
                if (!z10 && f15188f[fVar.g()][i11] >= 0) {
                    collection.add(fVarD.j(i11, i12));
                }
            }
        }
        if (fVar.e() > 0 || f15187e[fVar.g()][c10] == 0) {
            collection.add(fVar.a(i10));
        }
    }

    private Collection<f> e(Iterable<f> iterable, int i10) {
        LinkedList linkedList = new LinkedList();
        Iterator<f> it = iterable.iterator();
        while (it.hasNext()) {
            c(it.next(), i10, linkedList);
        }
        return b(linkedList);
    }

    private static Collection<f> f(Iterable<f> iterable, int i10, int i11) {
        LinkedList linkedList = new LinkedList();
        Iterator<f> it = iterable.iterator();
        while (it.hasNext()) {
            d(it.next(), i10, i11, linkedList);
        }
        return b(linkedList);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0056  */
    public p3.a a() {
        int i10;
        f fVarB = f.f15194f;
        Charset charset = this.f15190b;
        if (charset != null) {
            p3.d dVarF = p3.d.f(charset);
            if (dVarF == null) {
                throw new IllegalArgumentException("No ECI code for character set " + this.f15190b);
            }
            fVarB = fVarB.b(dVarF.l());
        }
        Collection<f> collectionSingletonList = Collections.singletonList(fVarB);
        int i11 = 0;
        while (true) {
            byte[] bArr = this.f15189a;
            if (i11 >= bArr.length) {
                return ((f) Collections.min(collectionSingletonList, new a())).k(this.f15189a);
            }
            int i12 = i11 + 1;
            byte b10 = i12 < bArr.length ? bArr[i12] : (byte) 0;
            byte b11 = bArr[i11];
            if (b11 != 13) {
                if (b11 != 44) {
                    if (b11 != 46) {
                        if (b11 == 58 && b10 == 32) {
                            i10 = 5;
                        } else {
                            i10 = 0;
                        }
                    } else if (b10 == 32) {
                        i10 = 3;
                    } else {
                        i10 = 0;
                    }
                } else if (b10 == 32) {
                    i10 = 4;
                } else {
                    i10 = 0;
                }
            } else if (b10 == 10) {
                i10 = 2;
            } else {
                i10 = 0;
            }
            if (i10 > 0) {
                collectionSingletonList = f(collectionSingletonList, i11, i10);
                i11 = i12;
            } else {
                collectionSingletonList = e(collectionSingletonList, i11);
            }
            i11++;
        }
    }

    public d(byte[] bArr, Charset charset) {
        this.f15189a = bArr;
        this.f15190b = charset;
    }

    private static void d(f fVar, int i10, int i11, Collection<f> collection) {
        f fVarD = fVar.d(i10);
        collection.add(fVarD.i(4, i11));
        if (fVar.g() != 4) {
            collection.add(fVarD.j(4, i11));
        }
        if (i11 == 3 || i11 == 4) {
            collection.add(fVarD.i(2, 16 - i11).i(2, 1));
        }
        if (fVar.e() > 0) {
            collection.add(fVar.a(i10).a(i10 + 1));
        }
    }
}
