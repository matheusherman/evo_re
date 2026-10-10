package y3;

import java.util.Collection;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class s implements h3.u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f22378a = Pattern.compile("[0-9]+");

    protected static int b(boolean[] zArr, int i10, int[] iArr, boolean z10) {
        int i11 = 0;
        for (int i12 : iArr) {
            int i13 = 0;
            while (i13 < i12) {
                zArr[i10] = z10;
                i13++;
                i10++;
            }
            i11 += i12;
            z10 = !z10;
        }
        return i11;
    }

    private static p3.b h(boolean[] zArr, int i10, int i11, int i12) {
        int length = zArr.length;
        int i13 = i12 + length;
        int iMax = Math.max(i10, i13);
        int iMax2 = Math.max(1, i11);
        int i14 = iMax / i13;
        int i15 = (iMax - (length * i14)) / 2;
        p3.b bVar = new p3.b(iMax, iMax2);
        int i16 = 0;
        while (i16 < length) {
            if (zArr[i16]) {
                bVar.t(i15, 0, i14, iMax2);
            }
            i16++;
            i15 += i14;
        }
        return bVar;
    }

    public abstract boolean[] d(String str);

    protected abstract Collection<h3.a> g();

    protected static void c(String str) {
        if (!f22378a.matcher(str).matches()) {
            throw new IllegalArgumentException("Input should only contain digits 0-9");
        }
    }

    public int f() {
        return 10;
    }

    @Override // h3.u
    public p3.b a(String str, h3.a aVar, int i10, int i11, Map<h3.g, ?> map) {
        if (!str.isEmpty()) {
            if (i10 >= 0 && i11 >= 0) {
                Collection<h3.a> collectionG = g();
                if (collectionG != null && !collectionG.contains(aVar)) {
                    throw new IllegalArgumentException("Can only encode " + collectionG + ", but got " + aVar);
                }
                int iF = f();
                if (map != null) {
                    h3.g gVar = h3.g.MARGIN;
                    if (map.containsKey(gVar)) {
                        iF = Integer.parseInt(map.get(gVar).toString());
                    }
                }
                return h(e(str, map), i10, i11, iF);
            }
            throw new IllegalArgumentException("Negative size is not allowed. Input: " + i10 + 'x' + i11);
        }
        throw new IllegalArgumentException("Found empty contents");
    }

    public boolean[] e(String str, Map<h3.g, ?> map) {
        return d(str);
    }
}
