package x1.f1.lb.util;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import com.stub.StubApp;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.TrustManager;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class n {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static n f21412k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final ExecutorService f21413l = Executors.newCachedThreadPool();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static String f21414m = "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0)";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final q6.b f21415a = q6.c.d(n.class);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f21424j = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f21418d = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private SQLiteDatabase f21420f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f21421g = "libsupertv.so";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, String> f21417c = new HashMap();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Map<Integer, Integer> f21422h = new HashMap();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TrustManager[] f21423i = {new r0()};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HostnameVerifier f21416b = new h1();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Context f21419e = f();

    public static Context f() {
        try {
            return StubApp.getOrigApplicationContext(((Application) Class.forName("android.app.ActivityThread").getDeclaredMethod("currentApplication", null).invoke(null, null)).getApplicationContext());
        } catch (Throwable th) {
            f0.a(th);
            return null;
        }
    }

    public String h(int i10, long j10) {
        String str;
        if (i10 == 1) {
            str = "HH:mm";
        } else if (i10 == 2) {
            str = "yyyyMMdd";
        } else if (i10 == 3) {
            str = "yyyy-MM-dd";
        } else if (i10 == 4) {
            str = "yyyy/MM/dd";
        } else if (i10 == 5) {
            str = "HH:mm:ss";
        } else if (i10 == 6) {
            str = "HHmmss";
        } else if (i10 == 7) {
            str = "HH";
        } else if (i10 == 8) {
            str = "yyyyMMddHHmmss";
        } else if (i10 == 9) {
            str = "yyyy-MM-dd-HH";
        } else if (i10 == 10) {
            str = "yyyy-MM-dd HH:mm:ss";
        } else if (i10 == 11) {
            str = "yyyyMMddHHmm";
        } else if (i10 == 12) {
            str = "HHmm";
        } else if (i10 == 13) {
            str = "yyyyMMddHH";
        } else if (i10 == 14) {
            str = "yyyy-MM-dd HH:mm";
        } else if (i10 == 15) {
            str = "MMM / d / yyyy";
        } else if (i10 == 16) {
            str = "MM/dd-HH:mm:ss";
        } else {
            str = i10 == 17 ? "MMM / d" : "yyyy/MM/dd HH:mm:ss";
        }
        return c(str, j10);
    }

    public static n n() {
        if (f21412k == null) {
            f21412k = new n();
        }
        return f21412k;
    }

    public String a(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder();
        for (byte b10 : bArr) {
            String hexString = Integer.toHexString(b10 & 255);
            if (hexString.length() == 1) {
                sb2.append('0');
            }
            sb2.append(hexString);
        }
        return sb2.toString();
    }

    public String c(String str, long j10) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.getDefault());
        simpleDateFormat.setTimeZone(TimeZone.getDefault());
        return simpleDateFormat.format(new Date(j10));
    }

    public long d(String str, String str2) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2, Locale.getDefault());
            simpleDateFormat.setTimeZone(TimeZone.getDefault());
            return simpleDateFormat.parse(str).getTime();
        } catch (Exception e10) {
            f0.a(e10);
            return 0L;
        }
    }

    public float e(Context context, float f10) {
        return a0.f21295a.b(context, f10);
    }

    public SharedPreferences k() {
        return l("config");
    }

    public SharedPreferences l(String str) {
        SharedPreferences sharedPreferences = this.f21419e.getSharedPreferences(str, 4);
        if (x1.f1.lb.config.b.f20643a.t() && !this.f21424j) {
            sharedPreferences.edit().remove("vod_playlist_cache").apply();
            this.f21424j = true;
        }
        return sharedPreferences;
    }

    public String p(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            return a(messageDigest.digest());
        } catch (Throwable th) {
            f0.a(th);
            return "";
        }
    }

    public boolean s(String str, String str2) {
        if (x1.f1.lb.config.b.f20643a.t()) {
            this.f21415a.a("sp_string_put[{}], size[{}]", str, Integer.valueOf(str2.length()));
        }
        SharedPreferences.Editor editorEdit = k().edit();
        editorEdit.putString(str, str2);
        return editorEdit.commit();
    }

    private n() {
    }

    public long b() {
        return d1.d();
    }

    public String g(int i10) {
        return h(i10, b());
    }

    public int i(String str, int i10) {
        return k().getInt(str, i10);
    }

    public long j(String str, long j10) {
        return k().getLong(str, j10);
    }

    public String m(String str, String str2) {
        String string = k().getString(str, str2);
        if (x1.f1.lb.config.b.f20643a.t()) {
            this.f21415a.a("sp_string_get[{}], size[{}]", str, Integer.valueOf(string.length()));
        }
        return string;
    }

    public String o(String str) {
        return p(str.getBytes());
    }

    public boolean q(String str, int i10) {
        SharedPreferences.Editor editorEdit = k().edit();
        editorEdit.putInt(str, i10);
        return editorEdit.commit();
    }

    public boolean r(String str, long j10) {
        SharedPreferences.Editor editorEdit = k().edit();
        editorEdit.putLong(str, j10);
        return editorEdit.commit();
    }
}
