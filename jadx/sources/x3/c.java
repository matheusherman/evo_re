package x3;

import h3.d;
import h3.h;
import java.util.Map;
import r3.e;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final r3.c f21807a = new r3.c(r3.a.f17799o);

    private int a(byte[] bArr, int i10, int i11, int i12, int i13) throws d {
        int i14 = i11 + i12;
        int i15 = i13 == 0 ? 1 : 2;
        int[] iArr = new int[i14 / i15];
        for (int i16 = 0; i16 < i14; i16++) {
            if (i13 == 0 || i16 % 2 == i13 - 1) {
                iArr[i16 / i15] = bArr[i16 + i10] & 255;
            }
        }
        try {
            int iA = this.f21807a.a(iArr, i12 / i15);
            for (int i17 = 0; i17 < i11; i17++) {
                if (i13 == 0 || i17 % 2 == i13 - 1) {
                    bArr[i17 + i10] = (byte) iArr[i17 / i15];
                }
            }
            return iA;
        } catch (e unused) {
            throw d.a();
        }
    }

    public p3.e b(p3.b bVar, Map<h3.e, ?> map) throws d, h {
        int iA;
        byte[] bArr;
        byte[] bArrA = new a(bVar).a();
        int iA2 = a(bArrA, 0, 10, 10, 0);
        int i10 = bArrA[0] & 15;
        if (i10 == 2 || i10 == 3 || i10 == 4) {
            iA = iA2 + a(bArrA, 20, 84, 40, 1) + a(bArrA, 20, 84, 40, 2);
            bArr = new byte[94];
        } else {
            if (i10 != 5) {
                throw h.a();
            }
            iA = iA2 + a(bArrA, 20, 68, 56, 1) + a(bArrA, 20, 68, 56, 2);
            bArr = new byte[78];
        }
        System.arraycopy(bArrA, 0, bArr, 0, 10);
        System.arraycopy(bArrA, 20, bArr, 10, bArr.length - 10);
        p3.e eVarA = b.a(bArr, i10);
        eVarA.n(Integer.valueOf(iA));
        return eVarA;
    }
}
