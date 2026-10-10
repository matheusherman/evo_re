package y3;

import java.util.Collection;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class b0 extends z {
    @Override // y3.s
    protected Collection<h3.a> g() {
        return Collections.singleton(h3.a.UPC_E);
    }

    @Override // y3.s
    public boolean[] d(String str) {
        int length = str.length();
        if (length != 7) {
            if (length == 8) {
                try {
                    if (!y.i(a0.s(str))) {
                        throw new IllegalArgumentException("Contents do not pass checksum");
                    }
                } catch (h3.h unused) {
                    throw new IllegalArgumentException("Illegal contents");
                }
            } else {
                throw new IllegalArgumentException("Requested contents should be 7 or 8 digits long, but got " + length);
            }
        } else {
            try {
                str = str + y.r(a0.s(str));
            } catch (h3.h e10) {
                throw new IllegalArgumentException(e10);
            }
        }
        s.c(str);
        int iDigit = Character.digit(str.charAt(0), 10);
        if (iDigit != 0 && iDigit != 1) {
            throw new IllegalArgumentException("Number system must be 0 or 1");
        }
        int i10 = a0.f22326k[iDigit][Character.digit(str.charAt(7), 10)];
        boolean[] zArr = new boolean[51];
        int iB = s.b(zArr, 0, y.f22389d, true);
        for (int i11 = 1; i11 <= 6; i11++) {
            int iDigit2 = Character.digit(str.charAt(i11), 10);
            if (((i10 >> (6 - i11)) & 1) == 1) {
                iDigit2 += 10;
            }
            iB += s.b(zArr, iB, y.f22393h[iDigit2], false);
        }
        s.b(zArr, iB, y.f22391f, false);
        return zArr;
    }
}
