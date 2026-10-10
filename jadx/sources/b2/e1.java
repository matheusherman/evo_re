package b2;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class e1 {
    public static String a(String str, String[] strArr, String[] strArr2) {
        boolean zEquals;
        m1.g.k(strArr);
        m1.g.k(strArr2);
        int iMin = Math.min(strArr.length, strArr2.length);
        for (int i10 = 0; i10 < iMin; i10++) {
            String str2 = strArr[i10];
            if (str == null && str2 == null) {
                zEquals = true;
            } else if (str == null) {
                zEquals = false;
            } else {
                zEquals = str.equals(str2);
            }
            if (zEquals) {
                return strArr2[i10];
            }
        }
        return null;
    }
}
