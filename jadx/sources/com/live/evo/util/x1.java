package com.live.evo.util;

import android.graphics.drawable.Drawable;
import android.net.TrafficStats;
import android.text.TextUtils;
import android.util.TypedValue;
import androidx.core.content.ContextCompat;
import com.live.evo.MyApplication;
import com.live.evo.R$mipmap;
import com.live.evo.R$string;
import java.util.Locale;
import java.util.regex.Pattern;
import org.apache.log4j.spi.Configurator;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class x1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f7378a = MyApplication.a().getApplicationInfo().uid;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static long f7379b = 0;

    public static long i() {
        try {
            if (TrafficStats.getUidRxBytes(f7378a) == -1) {
                return 0L;
            }
            return TrafficStats.getTotalRxBytes() / 1024;
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static long l() {
        try {
            long uidTxBytes = TrafficStats.getUidTxBytes(f7378a);
            return uidTxBytes == -1 ? TrafficStats.getTotalTxBytes() / 1024 : uidTxBytes / 1024;
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static void a(boolean z10) {
        if (z10) {
            com.live.evo.a.f5198r = R$mipmap.ic_launcher;
            com.live.evo.a.f5199s = R$string.freetrial_app_name;
        } else {
            com.live.evo.a.f5198r = R$mipmap.ic_launcher;
            com.live.evo.a.f5199s = 2131951743;
        }
    }

    public static int b(float f10) {
        return (int) TypedValue.applyDimension(1, f10, MyApplication.a().getResources().getDisplayMetrics());
    }

    public static String c(String str, int i10, int i11, String str2) {
        String strSubstring;
        if (TextUtils.isEmpty(str)) {
            return Configurator.NULL;
        }
        if (str.length() <= i11) {
            i10 = str.length() / 3;
        }
        if (i10 > 0) {
            String strSubstring2 = str.substring(0, i10);
            if (str.length() >= i10) {
                strSubstring = str.substring(str.length() - i10);
            } else {
                strSubstring = "";
            }
            return strSubstring2 + str2 + strSubstring;
        }
        return str.substring(0, 1) + str2;
    }

    public static String d(String str, String str2) {
        if (str.length() < 3) {
            if (str.length() == 2) {
                return str.substring(0, 1) + str2 + str.substring(1);
            }
            if (str.length() == 1) {
                return str + str2 + str;
            }
            return str;
        }
        int length = str.length() / 3;
        String strSubstring = str.substring(0, length);
        String strSubstring2 = str.substring(str.length() - length);
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < str.length() - (length * 2); i10++) {
            sb2.append(str2);
        }
        return strSubstring + ((Object) sb2) + strSubstring2;
    }

    public static int e(int i10) {
        return com.blankj.utilcode.util.e.a(i10);
    }

    public static Drawable f(int i10) {
        return ContextCompat.getDrawable(MyApplication.a(), i10);
    }

    public static String g(String str, boolean z10) {
        if (TextUtils.isEmpty(str)) {
            return Configurator.NULL;
        }
        if (Pattern.compile("[0-9]*").matcher(str).matches()) {
            if (z10) {
                return c(str, 4, 8, "********");
            }
            return d(str, "*");
        }
        int iIndexOf = str.indexOf("@");
        if (iIndexOf > 0) {
            String strSubstring = str.substring(0, iIndexOf);
            String strSubstring2 = str.substring(iIndexOf);
            if (strSubstring.length() > 0) {
                return d(strSubstring, "*") + strSubstring2;
            }
        } else if (str.indexOf("+") == 0 || str.indexOf("00") == 0) {
            return d(str, "*");
        }
        return str;
    }

    public static String h() {
        String language = Locale.getDefault().getLanguage();
        if (!"pt".equals(language) && !"en".equals(language) && !"es".equals(language)) {
            return "pt";
        }
        return language;
    }

    public static String j(int i10) {
        return MyApplication.a().getString(i10);
    }

    public static String k(int i10, String str) {
        return String.format(MyApplication.a().getString(i10), str);
    }

    public static boolean m(long j10) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (Math.abs(jCurrentTimeMillis - f7379b) < j10) {
            return true;
        }
        f7379b = jCurrentTimeMillis;
        return false;
    }
}
