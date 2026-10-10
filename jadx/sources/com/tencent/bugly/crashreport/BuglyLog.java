package com.tencent.bugly.crashreport;

import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.bugly.proguard.ao;
import com.tencent.bugly.proguard.p;
import org.apache.log4j.spi.Configurator;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class BuglyLog {
    public static void e(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = Configurator.NULL;
        }
        if (p.f9101c) {
            Log.e(str, str2);
        }
        ao.a(ExifInterface.LONGITUDE_EAST, str, str2);
    }

    public static void d(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = Configurator.NULL;
        }
        if (p.f9101c) {
            Log.d(str, str2);
        }
        ao.a("D", str, str2);
    }

    public static void i(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = Configurator.NULL;
        }
        if (p.f9101c) {
            Log.i(str, str2);
        }
        ao.a("I", str, str2);
    }

    public static void v(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = Configurator.NULL;
        }
        if (p.f9101c) {
            Log.v(str, str2);
        }
        ao.a(ExifInterface.GPS_MEASUREMENT_INTERRUPTED, str, str2);
    }

    public static void w(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = Configurator.NULL;
        }
        if (p.f9101c) {
            Log.w(str, str2);
        }
        ao.a(ExifInterface.LONGITUDE_WEST, str, str2);
    }

    public static void setCache(int i10) {
        ao.a(i10);
    }

    public static void e(String str, String str2, Throwable th) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = Configurator.NULL;
        }
        if (p.f9101c) {
            Log.e(str, str2, th);
        }
        ao.a(ExifInterface.LONGITUDE_EAST, str, th);
    }
}
