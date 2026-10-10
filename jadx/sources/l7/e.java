package l7;

import android.content.Context;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class e {
    public static boolean c(Context context) {
        try {
            return !context.getFileStreamPath("3c9b584e65e6c983").exists();
        } catch (Exception unused) {
            return true;
        }
    }

    private static String a(Context context) {
        String str = context.getFilesDir().getAbsolutePath() + File.separator + ".7934039a7252be16";
        m7.f.h("", "UtdidAppRoot dir:" + str);
        m7.a.a(str);
        return str;
    }

    public static void b(String str) {
        try {
            m7.f.i();
            m7.a.b(d(), str);
        } catch (Throwable unused) {
        }
    }

    private static String d() {
        String str = a(j7.a.b().f()) + File.separator + "4635b664f789000d";
        m7.f.h("", str);
        return str;
    }

    public static String e() {
        return a(j7.a.b().f()) + File.separator + "9983c160aa044115";
    }

    public static String f() {
        try {
            return m7.a.c(d());
        } catch (Exception unused) {
            return null;
        }
    }
}
