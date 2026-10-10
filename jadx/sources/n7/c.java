package n7;

import android.content.Context;
import android.text.TextUtils;
import java.util.Random;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class c {
    public static String a(Context context) {
        String strC = d.c(null) ? c() : null;
        return d.c(strC) ? b() : strC;
    }

    private static String c() {
        String strA = e.a("ro.aliyun.clouduuid", "");
        if (TextUtils.isEmpty(strA)) {
            strA = e.a("ro.sys.aliyun.clouduuid", "");
        }
        return TextUtils.isEmpty(strA) ? d() : strA;
    }

    private static String d() {
        try {
            return (String) Class.forName("com.yunos.baseservice.clouduuid.CloudUUID").getMethod("getCloudUUID", null).invoke(null, null);
        } catch (Exception unused) {
            return "";
        }
    }

    public static String b() {
        int iCurrentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int iNanoTime = (int) System.nanoTime();
        int iNextInt = new Random().nextInt();
        int iNextInt2 = new Random().nextInt();
        byte[] bArrA = b.a(iCurrentTimeMillis);
        byte[] bArrA2 = b.a(iNanoTime);
        byte[] bArrA3 = b.a(iNextInt);
        byte[] bArrA4 = b.a(iNextInt2);
        byte[] bArr = new byte[16];
        System.arraycopy(bArrA, 0, bArr, 0, 4);
        System.arraycopy(bArrA2, 0, bArr, 4, 4);
        System.arraycopy(bArrA3, 0, bArr, 8, 4);
        System.arraycopy(bArrA4, 0, bArr, 12, 4);
        return a.c(bArr, 2);
    }
}
