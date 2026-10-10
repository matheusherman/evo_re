package w6;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class b {
    public static String a(byte[] bArr, boolean z10) {
        String str = "";
        for (int i10 = 0; i10 < bArr.length; i10++) {
            String hexString = Integer.toHexString(bArr[i10] & 255);
            str = hexString.length() == 1 ? str + "0" + hexString : str + hexString;
            if (i10 < bArr.length - 1) {
                str = str + "";
            }
        }
        return z10 ? str.toUpperCase() : str.toLowerCase();
    }

    public static byte[] b(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("content is empty");
        }
        if (str.length() % 2 != 0) {
            throw new IllegalArgumentException();
        }
        char[] charArray = str.toCharArray();
        byte[] bArr = new byte[str.length() / 2];
        int length = str.length();
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            bArr[i11] = (byte) (Integer.parseInt("" + charArray[i10] + charArray[i10 + 1], 16) & 255);
            i10 += 2;
            i11++;
        }
        return bArr;
    }
}
