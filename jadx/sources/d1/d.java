package d1;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.Size;
import java.net.UnknownHostException;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f9571a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f9572b = true;

    public static void b(@Size(max = 23) String str, String str2) {
        if (f9571a <= 3) {
            Log.e(str, str2);
        }
    }

    @Nullable
    public static String d(@Nullable Throwable th) {
        if (th == null) {
            return null;
        }
        if (e(th)) {
            return "UnknownHostException (no network)";
        }
        return !f9572b ? th.getMessage() : Log.getStackTraceString(th).trim().replace("\t", "    ");
    }

    private static boolean e(@Nullable Throwable th) {
        while (th != null) {
            if (th instanceof UnknownHostException) {
                return true;
            }
            th = th.getCause();
        }
        return false;
    }

    public static void f(@Size(max = 23) String str, String str2) {
        if (f9571a <= 2) {
            Log.w(str, str2);
        }
    }

    private static String a(String str, @Nullable Throwable th) {
        String strD = d(th);
        if (!TextUtils.isEmpty(strD)) {
            String strValueOf = String.valueOf(str);
            String strReplace = strD.replace("\n", "\n  ");
            StringBuilder sb2 = new StringBuilder(strValueOf.length() + 4 + String.valueOf(strReplace).length());
            sb2.append(strValueOf);
            sb2.append("\n  ");
            sb2.append(strReplace);
            sb2.append('\n');
            return sb2.toString();
        }
        return str;
    }

    public static void c(@Size(max = 23) String str, String str2, @Nullable Throwable th) {
        b(str, a(str2, th));
    }
}
