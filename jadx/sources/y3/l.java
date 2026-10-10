package y3;

import java.util.Collection;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class l extends z {
    @Override // y3.s
    protected Collection<h3.a> g() {
        return Collections.singleton(h3.a.EAN_8);
    }

    @Override // y3.s
    public boolean[] d(String str) {
        int length = str.length();
        if (length != 7) {
            if (length == 8) {
                try {
                    if (!y.i(str)) {
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
                str = str + y.r(str);
            } catch (h3.h e10) {
                throw new IllegalArgumentException(e10);
            }
        }
        s.c(str);
        boolean[] zArr = new boolean[67];
        int iB = s.b(zArr, 0, y.f22389d, true);
        for (int i10 = 0; i10 <= 3; i10++) {
            iB += s.b(zArr, iB, y.f22392g[Character.digit(str.charAt(i10), 10)], false);
        }
        int iB2 = iB + s.b(zArr, iB, y.f22390e, false);
        for (int i11 = 4; i11 <= 7; i11++) {
            iB2 += s.b(zArr, iB2, y.f22392g[Character.digit(str.charAt(i11), 10)], true);
        }
        s.b(zArr, iB2, y.f22389d, true);
        return zArr;
    }
}
