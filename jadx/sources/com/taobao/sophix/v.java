package com.taobao.sophix;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.app.NotificationCompat;
import com.taobao.sophix.listener.PatchLoadStatusListener;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class v implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f8490a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f8491b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f8492c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f8493d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f8494e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f8495f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f8496g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private List<String> f8497h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f8499j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f8500k;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile boolean f8498i = true;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private AtomicBoolean f8501l = new AtomicBoolean(false);

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b0 f8502a;

        a(b0 b0Var) {
            this.f8502a = b0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                n nVar = new n();
                v.this.a(nVar, (String) null, this.f8502a);
                nVar.d();
                s.d("NetworkManager", "commit success", Integer.valueOf(nVar.b()));
            } catch (Throwable th) {
                s.b("NetworkManager", "commit fail", th, new Object[0]);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private final class b {
        private b() {
        }

        /* synthetic */ b(v vVar, a aVar) {
            this();
        }

        public String a() {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                if (v.this.f8497h != null) {
                    Iterator it = v.this.f8497h.iterator();
                    while (it.hasNext()) {
                        jSONArray.put((String) it.next());
                    }
                }
                jSONObject.put("tags", jSONArray);
                jSONObject.put("network", "UNKNOWN");
                jSONObject.put("carrier", "UNKNOWN");
                jSONObject.put("stable", j.f8462f ? "1" : "0");
                String str = new String(Base64.encode(jSONObject.toString().getBytes(), 2));
                s.a("NetworkManager", "[EnvHeaderBuilder] encode: " + str, new Object[0]);
                return str;
            } catch (Exception e10) {
                e10.printStackTrace();
                return "";
            }
        }
    }

    private void b() {
        this.f8494e = "osversion=" + Build.VERSION.RELEASE + ",manufacturer=" + Build.MANUFACTURER + ",brand=" + Build.BRAND + ",model=" + Build.MODEL + ",os=android";
        this.f8495f = h0.a(j.f8458b, "SP_SOPHIX_DEVICE_ID", (String) null);
    }

    public synchronized void a(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str2)) {
                if (!this.f8501l.get()) {
                    s.c("NetworkManager", "init", "appVersion", str2);
                    this.f8490a = str2;
                    File file = new File(str, "download");
                    if (!file.exists()) {
                        file.mkdirs();
                    } else if (d0.b(j.f8458b)) {
                        i.a(file);
                    }
                    this.f8496g = new File(file, "sophix-patch.jar").getAbsolutePath();
                    try {
                        ApplicationInfo applicationInfo = j.f8458b.getPackageManager().getApplicationInfo(j.f8458b.getBaseContext().getPackageName(), 128);
                        if (TextUtils.isEmpty(this.f8491b) && applicationInfo.metaData.containsKey("com.taobao.android.hotfix.IDSECRET")) {
                            this.f8491b = String.valueOf(applicationInfo.metaData.get("com.taobao.android.hotfix.IDSECRET"));
                        }
                        if (TextUtils.isEmpty(this.f8492c) && applicationInfo.metaData.containsKey("com.taobao.android.hotfix.APPSECRET")) {
                            this.f8492c = String.valueOf(applicationInfo.metaData.get("com.taobao.android.hotfix.APPSECRET"));
                        }
                        if (TextUtils.isEmpty(this.f8493d) && applicationInfo.metaData.containsKey("com.taobao.android.hotfix.RSASECRET")) {
                            this.f8493d = String.valueOf(applicationInfo.metaData.get("com.taobao.android.hotfix.RSASECRET"));
                        }
                    } catch (Throwable th) {
                        s.b("NetworkManager", "init", th, new Object[0]);
                    }
                    b();
                    this.f8501l.set(true);
                }
            } else {
                throw new RuntimeException("app version is null");
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public void a(String str, String str2, String str3) {
        this.f8491b = str;
        this.f8492c = str2;
        this.f8493d = str3;
    }

    public synchronized String a(String str, b0 b0Var, PatchLoadStatusListener patchLoadStatusListener) {
        if (!this.f8501l.get()) {
            s.e("NetworkManager", "query fail as not init", new Object[0]);
            return null;
        }
        if (TextUtils.isEmpty(this.f8491b)) {
            s.e("NetworkManager", "query fail as appId is empty", new Object[0]);
            return null;
        }
        if (c.f8429d && (TextUtils.isEmpty(this.f8492c) || TextUtils.isEmpty(this.f8493d))) {
            s.e("NetworkManager", "query fail as appSecret/rsaSecret is empty", new Object[0]);
            return null;
        }
        if (TextUtils.isEmpty(str) && b0Var == null) {
            s.e("NetworkManager", "query fail as param is empty", new Object[0]);
            return null;
        }
        a();
        if (TextUtils.isEmpty(this.f8495f)) {
            s.e("NetworkManager", "query fail as can't get device id", new Object[0]);
            return null;
        }
        if (this.f8499j != 0 && System.currentTimeMillis() - this.f8499j <= 3000) {
            s.e("NetworkManager", "query fail as two consecutive query should not short than 3s", new Object[0]);
            return null;
        }
        this.f8499j = System.currentTimeMillis();
        try {
            s.c("NetworkManager", "query start", new Object[0]);
            long jCurrentTimeMillis = System.currentTimeMillis();
            a0 a0VarA = a(str, b0Var);
            s.a("NetworkManager", "query", "get remote patch", a0VarA);
            int i10 = b0Var.f8420d;
            if (i10 != -1 && a0VarA.f8402b <= i10) {
                throw new w(7, "patch version is smaller than current");
            }
            if (i10 != -1) {
                b0Var.f8420d = a0VarA.f8402b;
            }
            String strA = a(a0VarA, new File(this.f8496g).getParentFile().getAbsolutePath());
            s.a("NetworkManager", "query", "local server decrypt patch", strA);
            if (e.a(strA, this.f8496g, a0VarA.f8403c, this.f8493d) && new File(this.f8496g).exists()) {
                s.c("NetworkManager", "query", "download success");
                patchLoadStatusListener.onLoad(0, 9, "download success", a0VarA.f8402b);
                h0.b((Context) j.f8458b, "hpatch_clear", false);
                File file = new File(this.f8496g);
                b0Var.f8419c = "100";
                b0Var.f8423g = file.length();
                b0Var.f8421e = System.currentTimeMillis() - jCurrentTimeMillis;
                a(b0Var);
                return new File(this.f8496g).exists() ? this.f8496g : null;
            }
            throw new w(11, "server decrypt fail");
        } catch (w e10) {
            patchLoadStatusListener.onLoad(0, e10.a(), e10.getMessage(), b0Var.f8420d);
            if (e10.a() == 6) {
                s.c("NetworkManager", "query", e10.getMessage());
            } else if (e10.a() == 18) {
                s.e("NetworkManager", "query", e10.getMessage());
                h0.b((Context) j.f8458b, "hpatch_clear", true);
            } else {
                s.a("NetworkManager", "query fail", e10, "code", Integer.valueOf(e10.a()), NotificationCompat.CATEGORY_MESSAGE, e10.getMessage());
                b0Var.f8419c = "101";
                b0Var.f8425i = e10.a();
                a(b0Var);
            }
            return null;
        } catch (Throwable th) {
            patchLoadStatusListener.onLoad(0, 31, th.getMessage(), b0Var.f8420d);
            b0Var.f8419c = "101";
            b0Var.f8425i = 31;
            a(b0Var);
            return null;
        }
    }

    private void a() {
        try {
            String strEncode = URLEncoder.encode((String) j.f8458b.getClassLoader().loadClass("com.ta.utdid2.device.UTDevice").getDeclaredMethod("getUtdid", Context.class).invoke(null, j.f8458b.getBaseContext()), "UTF-8");
            String str = this.f8495f;
            if (str != null) {
                if (strEncode.equals(str)) {
                    return;
                }
                s.b("NetworkManager", "device id changed! " + strEncode + " " + this.f8495f, new Object[0]);
                return;
            }
            h0.b(j.f8458b, "SP_SOPHIX_DEVICE_ID", strEncode);
            this.f8495f = strEncode;
        } catch (Throwable th) {
            s.b("NetworkManager", "initDeviceId", th, new Object[0]);
            throw new RuntimeException("fail to include utdid");
        }
    }

    @Override // com.taobao.sophix.p
    public void a(b0 b0Var) {
        if (this.f8501l.get()) {
            s.d("NetworkManager", "commit", b0Var);
            if (!this.f8498i || !d0.b(j.f8458b) || b0Var == null || TextUtils.isEmpty(b0Var.f8419c) || b0Var.f8420d == -1) {
                return;
            }
            if (TextUtils.isEmpty(this.f8495f)) {
                s.e("NetworkManager", "commit", "device id is empty");
            } else {
                b0 b0Var2 = new b0(b0Var);
                k0.a(new a(b0Var2), "301".equals(b0Var2.f8419c) ? 0L : 3000L);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:150:0x0256  */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r8v6 */
    private a0 a(String str, b0 b0Var) throws Throwable {
        n nVar;
        Throwable th;
        Map<String, List<String>> mapE;
        InputStream inputStreamA;
        BufferedInputStream bufferedInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        int i10;
        int i11;
        String str2 = "x-hotfix-cur-time";
        ?? r10 = 0;
        n nVar2 = null;
        int i12 = 0;
        while (true) {
            try {
                nVar = new n();
                try {
                    a(nVar, str, b0Var);
                    nVar.d();
                    int iB = nVar.b();
                    try {
                        if (iB == 200) {
                            try {
                                try {
                                    mapE = nVar.e();
                                    if (mapE != null) {
                                        try {
                                            if (mapE.containsKey("x-hotfix-retcode") && (i10 = Integer.parseInt(mapE.get("x-hotfix-retcode").get(r10))) != 0) {
                                                StringBuilder sb2 = new StringBuilder();
                                                try {
                                                    sb2.append("query retCode:");
                                                    sb2.append(i10);
                                                    String string = sb2.toString();
                                                    if (i10 != 21) {
                                                        i11 = 22;
                                                        if (i10 != 22) {
                                                            switch (i10) {
                                                                case -102:
                                                                    if (mapE.containsKey(str2)) {
                                                                        String str3 = mapE.get(str2).get(r10);
                                                                        if (!TextUtils.isEmpty(str3) && !str3.equals(this.f8500k)) {
                                                                            String str4 = this.f8500k;
                                                                            Object[] objArr = new Object[4];
                                                                            objArr[r10] = "base date";
                                                                            objArr[1] = str4;
                                                                            objArr[2] = "correct date";
                                                                            objArr[3] = str3;
                                                                            s.e("NetworkManager", "getPatchRemote", objArr);
                                                                            this.f8500k = str3;
                                                                        }
                                                                    }
                                                                    i11 = 16;
                                                                    break;
                                                                case -101:
                                                                    i11 = 15;
                                                                    break;
                                                                case AppCompatDelegate.MODE_NIGHT_UNSPECIFIED /* -100 */:
                                                                    break;
                                                                default:
                                                                    switch (i10) {
                                                                        case 10:
                                                                            break;
                                                                        case 11:
                                                                            i11 = 17;
                                                                            break;
                                                                        case 12:
                                                                            string = "clear patch";
                                                                            i11 = 18;
                                                                            break;
                                                                        default:
                                                                            i11 = 31;
                                                                            break;
                                                                    }
                                                                    break;
                                                            }
                                                            throw new w(i11, string);
                                                        }
                                                        this.f8498i = true;
                                                    } else {
                                                        this.f8498i = r10;
                                                    }
                                                    string = "no update";
                                                    i11 = 6;
                                                    throw new w(i11, string);
                                                } catch (w e10) {
                                                    e = e10;
                                                }
                                            }
                                        } catch (w e11) {
                                            e = e11;
                                        }
                                        str2 = str2;
                                        nVar2 = nVar;
                                        i12++;
                                        if (i12 <= 2) {
                                            try {
                                                if (e.a() != 6 && e.a() != 18) {
                                                    try {
                                                        Thread.sleep(500L);
                                                    } catch (InterruptedException unused) {
                                                    }
                                                    s.e("NetworkManager", "getPatchRemote", "retry num", Integer.valueOf(i12));
                                                    if (nVar2 != null) {
                                                        nVar2.c();
                                                    }
                                                    str2 = str2;
                                                    r10 = 0;
                                                } else {
                                                    throw e;
                                                }
                                            } catch (Throwable th2) {
                                                th = th2;
                                                nVar = nVar2;
                                                if (nVar != null) {
                                                    nVar.c();
                                                }
                                                throw th;
                                            }
                                        } else {
                                            throw e;
                                        }
                                    }
                                } catch (w e12) {
                                    e = e12;
                                    str2 = str2;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                if (nVar != null) {
                                    nVar.c();
                                }
                                throw th;
                            }
                        } else {
                            throw new w(iB, "query fail as response code");
                        }
                    } catch (w e13) {
                        e = e13;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    nVar2 = nVar;
                    try {
                        throw new w(32, th);
                    } catch (w e14) {
                        e = e14;
                    }
                }
            } catch (Throwable th5) {
                th = th5;
            }
        }
        try {
            inputStreamA = nVar.a();
            try {
                bufferedInputStream = new BufferedInputStream(inputStreamA);
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        byte[] bArr = new byte[8192];
                        while (true) {
                            int i13 = bufferedInputStream.read(bArr);
                            String str5 = str2;
                            if (i13 != -1) {
                                try {
                                    try {
                                        byteArrayOutputStream.write(bArr, 0, i13);
                                        str2 = str5;
                                    } catch (IOException e15) {
                                        e = e15;
                                        throw new w(33, e);
                                    }
                                } catch (Throwable th6) {
                                    th = th6;
                                    i.a(inputStreamA);
                                    i.a(bufferedInputStream);
                                    i.a(byteArrayOutputStream);
                                    throw th;
                                }
                            } else {
                                String str6 = new String(byteArrayOutputStream.toByteArray());
                                i.a(inputStreamA);
                                i.a(bufferedInputStream);
                                i.a(byteArrayOutputStream);
                                if (!TextUtils.isEmpty(str6)) {
                                    if (c.f8429d) {
                                        String strA = k.a(str6, this.f8492c);
                                        if (mapE != null && mapE.containsKey("x-hotfix-hmac")) {
                                            String str7 = mapE.get("x-hotfix-hmac").get(0);
                                            if (TextUtils.isEmpty(strA) || !strA.equals(str7)) {
                                                throw new w(35, "query broken");
                                            }
                                        } else {
                                            s.e("NetworkManager", "getPatchRemote", "not found remote hmac");
                                        }
                                    }
                                    try {
                                        a0 a0Var = new a0();
                                        JSONObject jSONObject = new JSONObject(str6);
                                        a0Var.f8403c = jSONObject.optString("file_token");
                                        a0Var.f8401a = jSONObject.optString("file_url");
                                        a0Var.f8402b = jSONObject.getInt("patch_version");
                                        a0Var.f8404d = jSONObject.optString("file_hmac");
                                        if (!TextUtils.isEmpty(a0Var.f8403c) && !TextUtils.isEmpty(a0Var.f8401a)) {
                                            nVar.c();
                                            return a0Var;
                                        }
                                        throw new w(37, "query lack token or url");
                                    } catch (Throwable unused2) {
                                        throw new w(36, "query parse json fail");
                                    }
                                }
                                throw new w(34, "no content");
                            }
                            e = e15;
                            throw new w(33, e);
                        }
                    } catch (IOException e16) {
                        e = e16;
                    } catch (Throwable th7) {
                        th = th7;
                        i.a(inputStreamA);
                        i.a(bufferedInputStream);
                        i.a(byteArrayOutputStream);
                        throw th;
                    }
                } catch (IOException e17) {
                    e = e17;
                    byteArrayOutputStream = null;
                } catch (Throwable th8) {
                    th = th8;
                    byteArrayOutputStream = null;
                    i.a(inputStreamA);
                    i.a(bufferedInputStream);
                    i.a(byteArrayOutputStream);
                    throw th;
                }
            } catch (IOException e18) {
                e = e18;
                bufferedInputStream = null;
                byteArrayOutputStream = null;
                throw new w(33, e);
            } catch (Throwable th9) {
                th = th9;
                bufferedInputStream = null;
                byteArrayOutputStream = null;
                i.a(inputStreamA);
                i.a(bufferedInputStream);
                i.a(byteArrayOutputStream);
                throw th;
            }
        } catch (IOException e19) {
            e = e19;
            inputStreamA = null;
        } catch (Throwable th10) {
            th = th10;
            inputStreamA = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(q qVar, String str, b0 b0Var) {
        String strA;
        if (!TextUtils.isEmpty(str)) {
            s.a("NetworkManager", "openConnection", "cdn reqUrl", str);
            qVar.a(str);
            qVar.a("x-hotfix-os", "android");
            qVar.a("x-hotfix-sdk-version", SophixManager.VERSION);
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        if (TextUtils.isEmpty(b0Var.f8419c)) {
            sb2.append("/u/");
            sb2.append(this.f8491b);
            String str2 = File.separator;
            sb2.append(str2);
            sb2.append(this.f8495f);
            sb2.append(str2);
        } else {
            sb2.append("/r/");
            sb2.append(this.f8491b);
            String str3 = File.separator;
            sb2.append(str3);
            sb2.append(this.f8495f);
            sb2.append(str3);
            sb2.append(b0Var.f8419c);
            sb2.append(str3);
        }
        sb2.append(this.f8490a);
        String str4 = File.separator;
        sb2.append(str4);
        sb2.append(b0Var.f8420d);
        sb2.append(str4);
        String str5 = c.f8428c + c.f8427b + ((CharSequence) sb2);
        s.a("NetworkManager", "openConnection", "auth reqUrl", str5);
        qVar.a(str5);
        qVar.a("x-hotfix-os", "android");
        qVar.a("x-hotfix-sdk-version", SophixManager.VERSION);
        qVar.a("x-hotfix-info", this.f8494e);
        if (TextUtils.isEmpty(this.f8500k)) {
            this.f8500k = new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(new Date());
        }
        qVar.a("x-hotfix-token", k.a(sb2.toString() + this.f8500k, this.f8492c));
        if (TextUtils.isEmpty(b0Var.f8419c)) {
            strA = "cdate=" + this.f8500k;
        } else {
            strA = b0Var.a();
            int i10 = b0Var.f8425i;
            if (i10 != -9999) {
                qVar.a("x-hotfix-error", String.valueOf(i10));
            }
        }
        qVar.a("x-hotfix-request-id", b0Var.f8417a);
        qVar.a("x-hotfix-ext", strA);
        try {
            qVar.a("x-hotfix-env", new b(this, null).a());
        } catch (Exception e10) {
            s.a("NetworkManager", e10.getMessage(), e10);
        }
    }

    private String a(a0 a0Var, String str) throws Throwable {
        n nVar;
        BufferedInputStream bufferedInputStream;
        FileOutputStream fileOutputStream;
        InputStream inputStreamA;
        InputStream inputStream = null;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                nVar = new n();
                try {
                    try {
                        nVar.a(a0Var.f8401a);
                        nVar.d();
                        int iB = nVar.b();
                        if (iB == 200) {
                            File file = new File(str, a(a0Var.f8401a, a0Var.f8402b));
                            try {
                                inputStreamA = nVar.a();
                                try {
                                    bufferedInputStream = new BufferedInputStream(inputStreamA);
                                    try {
                                        if (file.exists()) {
                                            file.delete();
                                        }
                                        fileOutputStream = new FileOutputStream(file);
                                        try {
                                            byte[] bArr = new byte[8192];
                                            while (true) {
                                                int i10 = bufferedInputStream.read(bArr);
                                                if (i10 == -1) {
                                                    break;
                                                }
                                                fileOutputStream.write(bArr, 0, i10);
                                            }
                                            i.a(inputStreamA);
                                            i.a(bufferedInputStream);
                                            i.a(fileOutputStream);
                                            if (c.f8429d) {
                                                String strA = k.a(file, this.f8492c);
                                                String str2 = a0Var.f8404d;
                                                if (!TextUtils.isEmpty(str2) && !str2.equals(strA)) {
                                                    throw new w(10, "download broken");
                                                }
                                            }
                                            String absolutePath = file.getAbsolutePath();
                                            nVar.c();
                                            return absolutePath;
                                        } catch (IOException e10) {
                                            e = e10;
                                            inputStream = inputStreamA;
                                            try {
                                                throw new w(52, e);
                                            } catch (Throwable th) {
                                                th = th;
                                                inputStreamA = inputStream;
                                                fileOutputStream2 = fileOutputStream;
                                                i.a(inputStreamA);
                                                i.a(bufferedInputStream);
                                                i.a(fileOutputStream2);
                                                throw th;
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            fileOutputStream2 = fileOutputStream;
                                            i.a(inputStreamA);
                                            i.a(bufferedInputStream);
                                            i.a(fileOutputStream2);
                                            throw th;
                                        }
                                    } catch (IOException e11) {
                                        e = e11;
                                        fileOutputStream = null;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        i.a(inputStreamA);
                                        i.a(bufferedInputStream);
                                        i.a(fileOutputStream2);
                                        throw th;
                                    }
                                } catch (IOException e12) {
                                    e = e12;
                                    bufferedInputStream = null;
                                    fileOutputStream = null;
                                    inputStream = inputStreamA;
                                    throw new w(52, e);
                                } catch (Throwable th4) {
                                    th = th4;
                                    bufferedInputStream = null;
                                    fileOutputStream = null;
                                    inputStream = inputStreamA;
                                    inputStreamA = inputStream;
                                    fileOutputStream2 = fileOutputStream;
                                    i.a(inputStreamA);
                                    i.a(bufferedInputStream);
                                    i.a(fileOutputStream2);
                                    throw th;
                                }
                            } catch (IOException e13) {
                                e = e13;
                                inputStreamA = null;
                            } catch (Throwable th5) {
                                th = th5;
                                bufferedInputStream = null;
                                fileOutputStream = null;
                            }
                        } else {
                            throw new w(iB, "download fail as response code");
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        if (nVar != null) {
                            nVar.c();
                        }
                        throw th;
                    }
                } catch (IOException e14) {
                    e = e14;
                    throw new w(51, e);
                }
            } catch (Throwable th7) {
                th = th7;
                nVar = null;
            }
        } catch (IOException e15) {
            e = e15;
        }
    }

    private String a(String str, int i10) {
        String strSubstring = str.substring(str.lastIndexOf("/") + 1);
        String[] strArrSplit = strSubstring.split("\\.");
        if (strArrSplit != null && strArrSplit.length >= 2) {
            return strArrSplit[0] + "_" + i10 + "." + strArrSplit[1];
        }
        return strSubstring + "_" + i10 + ".patch";
    }

    public void a(List<String> list) {
        this.f8497h = list;
    }
}
