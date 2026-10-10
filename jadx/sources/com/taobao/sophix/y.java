package com.taobao.sophix;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.taobao.sophix.listener.PatchLoadStatusListener;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import java.util.zip.ZipFile;
import org.json.JSONArray;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f8507a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private File f8508b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private File f8509c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private File f8510d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private File f8511e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f8512f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f8513g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f8514h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Application f8515i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f8516j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private volatile c0 f8517k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private AtomicBoolean f8518l = new AtomicBoolean(false);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f8519m = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f8520n = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private List f8521o = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements FileFilter {
        a() {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return file.getName().endsWith(".jar");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            y.this.c();
        }
    }

    private boolean b() {
        String strA = h0.a(j.f8458b, "sophix_system_fingerprint", "INVALID_SYSTEM_FINGERPRINT");
        if (strA.equals("INVALID_SYSTEM_FINGERPRINT") || strA.equals(Build.FINGERPRINT)) {
            return true;
        }
        if (!this.f8516j) {
            s.a("PatchManager", "checkSystemOTAHappenedForContinue", "OTA happened");
            return false;
        }
        s.e("PatchManager", "checkSystemOTAHappenedForContinue", "OTA happened, so clear odex files");
        i.a(this.f8508b, new File[]{g()});
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (!d.b() || d.a()) {
            return;
        }
        d.a(false);
        h0.a(j.f8458b, "happ_crash_num");
        s.a("PatchManager", "clearCrashHandler", "clear crash flag");
    }

    private void d() {
        if (h0.a((Context) j.f8458b, "happ_ishotfix", false)) {
            s.a("PatchManager", "clearPreVerified", "skip clear at hot");
            return;
        }
        b(getClass());
        Iterator<Class> it = com.taobao.sophix.b.f().iterator();
        while (it.hasNext()) {
            b(it.next());
        }
    }

    public boolean e() {
        return this.f8514h;
    }

    public void i() {
        s.e("PatchManager", "killProcessSafely", new Object[0]);
        Process.killProcess(Process.myPid());
    }

    private void h() {
        try {
            Class cls = e0.f8443b;
            Object objInvoke = e0.a(cls, "currentActivityThread", new Class[0]).invoke(null, null);
            Object obj = e0.a(cls, "mBoundApplication").get(e0.a(cls, "currentActivityThread", new Class[0]).invoke(null, null));
            List list = (List) e0.a(obj.getClass(), "providers").get(obj);
            if (list != null) {
                list.addAll(this.f8521o);
                this.f8521o.clear();
                e0.a(cls, "installContentProviders", Context.class, List.class).invoke(objInvoke, this.f8515i, list);
            }
        } catch (Exception e10) {
            a("installProviders", e10);
        }
    }

    private void j() {
        if (!this.f8516j) {
            s.d("PatchManager", "prepareCrashHandler", "skip");
        } else {
            h0.b((Context) j.f8458b, "happ_crash_num", h0.a((Context) j.f8458b, "happ_crash_num", 0) + 1);
            d.a(true);
        }
    }

    private void l() {
        try {
            Class cls = e0.f8443b;
            Object obj = e0.a(cls, "mBoundApplication").get(e0.a(cls, "currentActivityThread", new Class[0]).invoke(null, null));
            List list = (List) e0.a(obj.getClass(), "providers").get(obj);
            if (list != null) {
                this.f8521o.addAll(list);
                list.clear();
            }
        } catch (Exception e10) {
            a("removeProvidersTemporarily", e10);
        }
    }

    private void m() {
        int i10 = this.f8507a | 2;
        this.f8507a = i10;
        h0.b((Context) j.f8458b, "SP_SOPHIX_DIR_STATE", i10);
    }

    public synchronized void a(String str, PatchLoadStatusListener patchLoadStatusListener) {
        try {
            if (TextUtils.isEmpty(str)) {
                throw new RuntimeException("app version is null");
            }
            if (j.f8458b == null) {
                throw new RuntimeException("app is null");
            }
            if (!this.f8518l.get()) {
                s.c("PatchManager", "init", "appVersion", str);
                if (j.f8458b instanceof SophixApplication) {
                    j.f8462f = true;
                } else if (Build.VERSION.SDK_INT >= 28) {
                    s.e("PatchManager", "should use stable initialize when android version >= 9.0.", new Object[0]);
                    return;
                }
                this.f8512f = str;
                this.f8516j = d0.b(j.f8458b);
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    s.e("PatchManager", "init recommend to best call in main thread", new Object[0]);
                }
                if (a() && b()) {
                    a(patchLoadStatusListener);
                } else {
                    s.e("PatchManager", "patch is not the newest, skip loading in sub-process", new Object[0]);
                }
                if (j.f8462f) {
                    l();
                    this.f8515i = a(j.f8458b);
                }
                this.f8518l.set(true);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void e(boolean z10) {
        h.a(z10);
    }

    public Object f() {
        return this.f8517k;
    }

    public File g() {
        File[] fileArrListFiles = this.f8508b.listFiles(new a());
        if (fileArrListFiles == null || fileArrListFiles.length <= 0) {
            return null;
        }
        return fileArrListFiles[0];
    }

    public void k() {
        if (!j.f8462f) {
            s.e("PatchManager", "do not call real App.onCreate", new Object[0]);
            return;
        }
        Application application = this.f8515i;
        if (application == null) {
            s.e("PatchManager", "real application is null, fail to call onCreate", new Object[0]);
            return;
        }
        a(j.f8458b, application);
        h();
        this.f8515i.onCreate();
    }

    public void c(boolean z10) {
        this.f8519m = z10;
    }

    public void d(boolean z10) {
        this.f8520n = z10;
    }

    public static void b(Application application) {
        Application applicationA = a(application);
        if (applicationA != null) {
            a(application, applicationA);
            applicationA.onCreate();
        } else {
            s.e("PatchManager", "real application is null, fail to recover", new Object[0]);
        }
    }

    public void b(String str) {
        this.f8513g = str;
    }

    public void b(boolean z10) {
        this.f8514h = z10;
    }

    public void b(Class cls) {
        com.taobao.sophix.b.b(cls);
    }

    public void a(String str) {
        File file = new File(str);
        this.f8507a = h0.a((Context) j.f8458b, "SP_SOPHIX_DIR_STATE", 0);
        boolean zB = d0.b(j.f8458b);
        if (zB && a(2)) {
            int i10 = (~this.f8507a) & 3;
            this.f8507a = i10;
            h0.b((Context) j.f8458b, "SP_SOPHIX_DIR_STATE", i10);
        }
        if (a(1)) {
            this.f8508b = i.a(file, "patch_");
            this.f8509c = i.a(file, "libs_");
            this.f8510d = i.a(file, "patch");
            this.f8511e = i.a(file, "libs");
        } else {
            this.f8508b = i.a(file, "patch");
            this.f8509c = i.a(file, "libs");
            this.f8510d = i.a(file, "patch_");
            this.f8511e = i.a(file, "libs_");
        }
        s.a("PatchManager", "initPatchDir", "patchDir", this.f8508b.getName(), "nativeLibDir", this.f8509c.getName());
        j.f8460d = this.f8508b;
        j.f8461e = this.f8509c;
        if (zB) {
            i.a(this.f8510d);
            i.a(this.f8511e);
        }
    }

    private boolean a(int i10) {
        return (this.f8507a & i10) == i10;
    }

    private boolean a() {
        if (h0.a(j.f8458b, "happ_version", "NO_FOUND_SOPHIX_APP_VERSION").equals(this.f8512f)) {
            return true;
        }
        if (this.f8516j) {
            s.e("PatchManager", "checkAppUpdatedForContinue", "app is updated. clean old patch.");
            a(false);
            return true;
        }
        s.a("PatchManager", "checkAppUpdatedForContinue", "app is updated");
        return false;
    }

    private void a(PatchLoadStatusListener patchLoadStatusListener) {
        if (this.f8516j) {
            if (h0.a((Context) j.f8458b, "happ_crash_num", 0) >= 5) {
                s.e("PatchManager", "handleLocalPatch", "continuous crash happened too mush, so cleaning patch by force");
                a(false);
            }
            if (h0.a((Context) j.f8458b, "hpatch_clear", false)) {
                s.e("PatchManager", "handleLocalPatch", "force cleaning patch as server require clear");
                a(true);
            }
        }
        File fileG = g();
        if (fileG != null) {
            b0 b0Var = new b0(3);
            b0Var.f8420d = j.f8457a;
            j.f8459c = fileG;
            a(fileG, patchLoadStatusListener, b0Var);
        } else {
            s.e("PatchManager", "handleLocalPatch", "no any patch exists");
        }
        if (this.f8516j) {
            new Handler().postDelayed(new b(), 3000L);
        }
    }

    /* JADX WARN: Not initialized variable reg: 12, insn: 0x0268: INVOKE (r12 I:java.util.zip.ZipFile) STATIC call: com.taobao.sophix.i.a(java.util.zip.ZipFile):void A[Catch: all -> 0x0032, MD:(java.util.zip.ZipFile):void (m), TRY_ENTER] (LINE:130), block:B:127:0x0268 */
    public synchronized void a(String str, PatchLoadStatusListener patchLoadStatusListener, b0 b0Var) {
        ZipFile zipFile;
        ZipFile zipFileA;
        boolean z10;
        s.d("PatchManager", "addPatch", "src patch", str);
        if (!this.f8518l.get()) {
            s.b("PatchManager", "addPatch", "did not init before!!");
            return;
        }
        File file = null;
        try {
            try {
                File file2 = new File(str);
                if (!TextUtils.isEmpty(str) && file2.exists() && file2.isFile() && file2.getName().endsWith(".jar")) {
                    if (j0.a()) {
                        boolean z11 = g() != null;
                        File file3 = z11 ? this.f8510d : this.f8508b;
                        i.a(file3);
                        File file4 = new File(file3, file2.getName());
                        try {
                            try {
                                i.a(file2, file4);
                                s.d("PatchManager", "addPatch", "dest patch", file4.getName());
                                j.a(b0Var.f8420d);
                                if (!TextUtils.isEmpty(this.f8513g)) {
                                    s.a("PatchManager", "addPatch", "aes key is set, do decrypt...");
                                    long jCurrentTimeMillis = System.currentTimeMillis();
                                    if (e.a(file4.getAbsolutePath(), this.f8513g) && file4.exists()) {
                                        s.d("PatchManager", "addPatch", "finish local aes decrypt patch(ms)", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                                    } else {
                                        throw new w(72, "aes decrypt fail");
                                    }
                                }
                                Attributes attributesA = a(file4);
                                String value = attributesA.getValue("Modified-So");
                                zipFile = new ZipFile(file4);
                                try {
                                    if (TextUtils.isEmpty(value)) {
                                        z10 = false;
                                    } else {
                                        long jCurrentTimeMillis2 = System.currentTimeMillis();
                                        s.d("PatchManager", "addPatch", "start unzip lib file");
                                        new u().a(value, zipFile, z11 ? this.f8511e : this.f8509c);
                                        s.d("PatchManager", "addPatch", "finish unzip lib file(ms)", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis2));
                                        z10 = true;
                                    }
                                    if (z11) {
                                        m();
                                    }
                                    boolean z12 = a(attributesA) && !this.f8520n && m.a();
                                    if (!this.f8519m && z11 && z12) {
                                        s.e("PatchManager", "addPatch is hotfix patch, but app exist old patch, please relaunch app", new Object[0]);
                                        patchLoadStatusListener.onLoad(0, 12, "relaunch app", b0Var.f8420d);
                                        i.a(zipFile);
                                        return;
                                    }
                                    boolean z13 = zipFile.getEntry("classes.dex") != null;
                                    boolean z14 = (!Boolean.valueOf(attributesA.getValue("Has-Res")).booleanValue() && zipFile.getEntry("resources.arsc") == null && zipFile.getEntry("assets") == null) ? false : true;
                                    if (!z13 && (z10 || (z14 && z11))) {
                                        s.e("PatchManager", "addPatch only need to patch so lib, please relaunch app", new Object[0]);
                                        patchLoadStatusListener.onLoad(0, 12, "relaunch app", b0Var.f8420d);
                                        i.a(zipFile);
                                    } else {
                                        a(file4, patchLoadStatusListener, b0Var);
                                        i.a(zipFile);
                                    }
                                } catch (w e10) {
                                    e = e10;
                                    file = file4;
                                    if (file != null) {
                                        file.delete();
                                    }
                                    b0Var.b();
                                    b0Var.f8419c = "201";
                                    b0Var.f8425i = e.a();
                                    z.a(b0Var);
                                    s.a("PatchManager", "addPatch fail", e, "code", Integer.valueOf(e.a()), NotificationCompat.CATEGORY_MESSAGE, e.getMessage());
                                    patchLoadStatusListener.onLoad(0, e.a(), e.getMessage(), b0Var.f8420d);
                                } catch (Throwable th) {
                                    th = th;
                                    file = file4;
                                    if (file != null) {
                                        file.delete();
                                    }
                                    b0Var.b();
                                    b0Var.f8419c = "201";
                                    b0Var.f8425i = 71;
                                    z.a(b0Var);
                                    s.a("PatchManager", "addPatch fail", th, new Object[0]);
                                    patchLoadStatusListener.onLoad(0, 71, th.getMessage(), b0Var.f8420d);
                                }
                            } catch (IOException e11) {
                                throw new w(74, e11);
                            }
                        } catch (w e12) {
                            e = e12;
                            zipFile = null;
                        } catch (Throwable th2) {
                            th = th2;
                            zipFile = null;
                        }
                    } else {
                        throw new w(4, "device is not support");
                    }
                } else {
                    throw new w(20, "patch is illegal");
                }
            } catch (Throwable th3) {
                i.a(zipFileA);
                throw th3;
            }
        } catch (w e13) {
            e = e13;
            zipFile = null;
        } catch (Throwable th4) {
            th = th4;
            zipFile = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:78:0x014f  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v10, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private synchronized void a(File file, PatchLoadStatusListener patchLoadStatusListener, b0 b0Var) {
        char c10;
        char c11;
        char c12;
        boolean zA;
        boolean z10;
        boolean zA2;
        boolean zA3;
        s.a("PatchManager", "loadPatch", "patchFile", file.getName());
        long jCurrentTimeMillis = System.currentTimeMillis();
        ZipFile zipFile = null;
        try {
            try {
                try {
                    if (!this.f8514h) {
                        if (!g0.d(file)) {
                            throw new w(75, "patch signInfo not match to apk");
                        }
                    } else {
                        s.e("PatchManager", "loadPatch", "skip verifyPatchLegal in debug mode");
                    }
                    try {
                        ZipFile zipFile2 = new ZipFile(file);
                        try {
                            try {
                                Attributes attributesA = a(file);
                                String value = attributesA.getValue("Modified-So");
                                boolean z11 = (!Boolean.valueOf(attributesA.getValue("Has-Res")).booleanValue() && zipFile2.getEntry("resources.arsc") == null && zipFile2.getEntry("assets") == null) ? false : true;
                                int i10 = zipFile2.getEntry("classes.dex") != null ? 1 : 0;
                                if (z11) {
                                    i10 |= 4;
                                }
                                if (!TextUtils.isEmpty(value)) {
                                    i10 |= 2;
                                }
                                b0Var.f8422f = i10;
                                ?? r11 = (a(attributesA) && !this.f8520n && m.a()) ? 1 : 0;
                                b0Var.f8424h = r11;
                                j();
                                try {
                                    if (zipFile2.getEntry("classes.dex") != null) {
                                        try {
                                            long jCurrentTimeMillis2 = System.currentTimeMillis();
                                            c10 = 3;
                                            c11 = 4;
                                            c12 = 0;
                                            s.c("PatchManager", "loadPatch", "start patch dex file");
                                            zA = new g().a(file, r11, patchLoadStatusListener, b0Var);
                                            if (zA) {
                                                try {
                                                    s.c("PatchManager", "loadPatch", "finish patch dex file(ms)", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis2));
                                                    d();
                                                } catch (w e10) {
                                                    e = e10;
                                                    zipFile = zipFile2;
                                                    b0Var.b();
                                                    b0Var.f8419c = "201";
                                                    b0Var.f8425i = e.a();
                                                    z.a(b0Var);
                                                    Integer numValueOf = Integer.valueOf(e.a());
                                                    String message = e.getMessage();
                                                    Object[] objArr = new Object[4];
                                                    objArr[0] = "code";
                                                    objArr[1] = numValueOf;
                                                    objArr[2] = NotificationCompat.CATEGORY_MESSAGE;
                                                    objArr[c10] = message;
                                                    s.a("PatchManager", "loadPatch fail", e, objArr);
                                                    patchLoadStatusListener.onLoad(0, e.a(), e.getMessage(), b0Var.f8420d);
                                                    i.a(zipFile);
                                                }
                                            } else {
                                                s.c("PatchManager", "loadPatch", "wait preload dex file complete");
                                                if (d0.b(j.f8458b)) {
                                                    c();
                                                }
                                            }
                                            z10 = false;
                                        } catch (w e11) {
                                            e = e11;
                                            c10 = 3;
                                        } catch (Throwable th) {
                                            th = th;
                                            zipFile = zipFile2;
                                            b0Var.b();
                                            b0Var.f8419c = "201";
                                            b0Var.f8425i = 71;
                                            z.a(b0Var);
                                            s.a("PatchManager", "loadPatch fail", th, new Object[0]);
                                            patchLoadStatusListener.onLoad(0, 71, th.getMessage(), b0Var.f8420d);
                                            i.a(zipFile);
                                        }
                                    } else {
                                        c10 = 3;
                                        c11 = 4;
                                        c12 = 0;
                                        s.e("PatchManager", "loadPatch", "no dex file found");
                                        zA = false;
                                        z10 = true;
                                    }
                                    if (!zA && !z10) {
                                        zA2 = false;
                                    } else if (z11) {
                                        long jCurrentTimeMillis3 = System.currentTimeMillis();
                                        Object[] objArr2 = new Object[1];
                                        objArr2[c12] = "start patch res file";
                                        s.c("PatchManager", "loadPatch", objArr2);
                                        zA2 = new f0().a(file);
                                        Long lValueOf = Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis3);
                                        Object[] objArr3 = new Object[2];
                                        objArr3[c12] = "finish patch res file(ms)";
                                        objArr3[1] = lValueOf;
                                        s.c("PatchManager", "loadPatch", objArr3);
                                    } else {
                                        zA2 = false;
                                    }
                                    if (zA) {
                                        if (TextUtils.isEmpty(value)) {
                                            zA3 = false;
                                        } else {
                                            long jCurrentTimeMillis4 = System.currentTimeMillis();
                                            Object[] objArr4 = new Object[1];
                                            objArr4[c12] = "start patch lib file";
                                            s.c("PatchManager", "loadPatch", objArr4);
                                            zA3 = new u().a(value, this.f8509c);
                                            Long lValueOf2 = Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis4);
                                            Object[] objArr5 = new Object[2];
                                            objArr5[c12] = "finish patch lib file(ms)";
                                            objArr5[1] = lValueOf2;
                                            s.c("PatchManager", "loadPatch", objArr5);
                                        }
                                        u.a();
                                    } else {
                                        zA3 = false;
                                    }
                                    if (zA || zA2 || zA3) {
                                        if (this.f8517k == null) {
                                            this.f8517k = new c0(zA, zA2, zA3, r11);
                                        }
                                        b0Var.b();
                                        b0Var.f8421e = System.currentTimeMillis() - jCurrentTimeMillis;
                                        b0Var.f8419c = "200";
                                        z.a(b0Var);
                                        Boolean boolValueOf = Boolean.valueOf(zA);
                                        Boolean boolValueOf2 = Boolean.valueOf(zA2);
                                        Boolean boolValueOf3 = Boolean.valueOf(zA3);
                                        Object[] objArr6 = new Object[6];
                                        objArr6[0] = "hasDexPatched";
                                        objArr6[1] = boolValueOf;
                                        objArr6[2] = "hasResPatched";
                                        objArr6[c10] = boolValueOf2;
                                        objArr6[c11] = "hasSOPatched";
                                        objArr6[5] = boolValueOf3;
                                        s.c("PatchManager", "loadPatch success", objArr6);
                                        patchLoadStatusListener.onLoad(0, 1, "load success", b0Var.f8420d);
                                    } else if (z10) {
                                        Object[] objArr7 = new Object[1];
                                        objArr7[c12] = "invalid patch";
                                        s.c("PatchManager", "loadPatch fail", objArr7);
                                        patchLoadStatusListener.onLoad(0, 20, "did not load anything", b0Var.f8420d);
                                    }
                                    i.a(zipFile2);
                                } catch (w e12) {
                                    e = e12;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        } catch (w e13) {
                            e = e13;
                            c10 = 3;
                        }
                    } catch (IOException e14) {
                        c10 = 3;
                        try {
                            throw new w(77, e14);
                        } catch (w e15) {
                            e = e15;
                            b0Var.b();
                            b0Var.f8419c = "201";
                            b0Var.f8425i = e.a();
                            z.a(b0Var);
                            Integer numValueOf2 = Integer.valueOf(e.a());
                            String message2 = e.getMessage();
                            Object[] objArr8 = new Object[4];
                            objArr8[0] = "code";
                            objArr8[1] = numValueOf2;
                            objArr8[2] = NotificationCompat.CATEGORY_MESSAGE;
                            objArr8[c10] = message2;
                            s.a("PatchManager", "loadPatch fail", e, objArr8);
                            patchLoadStatusListener.onLoad(0, e.a(), e.getMessage(), b0Var.f8420d);
                            i.a(zipFile);
                        }
                    }
                } catch (Throwable th3) {
                    i.a(zipFile);
                    throw th3;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (w e16) {
            e = e16;
            c10 = 3;
        }
    }

    private Attributes a(File file) throws Throwable {
        try {
            try {
                JarFile jarFile = new JarFile(file);
                try {
                    InputStream inputStream = jarFile.getInputStream(jarFile.getJarEntry("META-INF/SOPHIX.MF"));
                    Attributes mainAttributes = new Manifest(inputStream).getMainAttributes();
                    String value = mainAttributes.getValue("Sophix-Version");
                    if (!TextUtils.isEmpty(value) && "2.0".equals(value)) {
                        i.a(inputStream);
                        i.a((ZipFile) jarFile);
                        return mainAttributes;
                    }
                    throw new w(76, "require version:2.0 but patch version:" + value);
                } catch (IOException e10) {
                    e = e10;
                    throw new w(73, e);
                }
            } catch (Throwable th) {
                th = th;
                i.a((Closeable) null);
                i.a((ZipFile) null);
                throw th;
            }
        } catch (IOException e11) {
            e = e11;
        } catch (Throwable th2) {
            th = th2;
            i.a((Closeable) null);
            i.a((ZipFile) null);
            throw th;
        }
    }

    private boolean a(Attributes attributes) {
        boolean z10 = Boolean.parseBoolean(attributes.getValue("Support-Hot"));
        if (z10) {
            String value = attributes.getValue("System-Reference");
            if (!TextUtils.isEmpty(value)) {
                s.d("PatchManager", "checkSupportHotfix", "systemReferences", value);
                JSONArray jSONArray = new JSONArray(value);
                ClassLoader classLoader = getClass().getClassLoader();
                for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                    String str = (String) jSONArray.get(i10);
                    try {
                        if ((classLoader.loadClass(str).getModifiers() & 1) == 0) {
                            s.c("PatchManager", "checkSupportHotfix", "systemClzName", str, "not public");
                            return false;
                        }
                        continue;
                    } catch (ClassNotFoundException e10) {
                        s.b("PatchManager", "checkSupportHotfix", e10, new Object[0]);
                    }
                }
            }
        }
        return z10;
    }

    private static void a(Application application, Application application2) {
        try {
            Class cls = e0.f8442a;
            e0.a(cls, "mOuterContext").set(application.getBaseContext(), application2);
            Object obj = e0.a(cls, "mPackageInfo").get(application.getBaseContext());
            e0.a(obj.getClass(), "mApplication").set(obj, application2);
            Object obj2 = e0.a(obj.getClass(), "mActivityThread").get(obj);
            e0.a(obj2.getClass(), "mInitialApplication").set(obj2, application2);
            List list = (List) e0.a(obj2.getClass(), "mAllApplications").get(obj2);
            for (int i10 = 0; i10 < list.size(); i10++) {
                list.set(i10, application2);
            }
            s.a("PatchManager", "replaceRealApplication finish", new Object[0]);
        } catch (Exception e10) {
            a("replaceRealApplication fail", e10);
        }
    }

    private static Application a(Application application) {
        Class<?> clsLoadClass;
        try {
            String name = application.getClass().getName();
            try {
                clsLoadClass = application.getClassLoader().loadClass(name + "$RealApplicationStub");
            } catch (Exception unused) {
                clsLoadClass = application.getClassLoader().loadClass(name.replace("_modified_name", "") + "$RealApplicationStub");
            }
            Application application2 = (Application) ((SophixEntry) clsLoadClass.getAnnotation(SophixEntry.class)).value().newInstance();
            e0.a(Application.class, "attach", Context.class).invoke(application2, application.getBaseContext());
            s.a("PatchManager", "callRealAppAttach", "finish call real App.attach, app", application2.getClass().getName());
            return application2;
        } catch (Exception e10) {
            a("callRealAppAttach", e10);
            return null;
        }
    }

    public void a(String str, int i10) {
        j0.a(str, i10);
    }

    public synchronized void a(boolean z10) {
        try {
            s.e("PatchManager", "cleanPatches", "positive", Boolean.valueOf(z10));
            if (g() != null) {
                b0 b0Var = new b0(4);
                b0Var.f8420d = j.f8457a;
                b0Var.f8419c = z10 ? "300" : "301";
                z.a(b0Var);
            }
            i.a(this.f8508b);
            i.a(this.f8509c);
            boolean zA = h0.a((Context) j.f8458b, "happ_ishotfix", false);
            String strA = h0.a(j.f8458b, "SP_SOPHIX_DEVICE_ID", (String) null);
            h0.a(j.f8458b);
            j.a(j.f8457a);
            h0.b(j.f8458b, "happ_version", this.f8512f);
            h0.b(j.f8458b, "SP_SOPHIX_DEVICE_ID", strA);
            h0.b(j.f8458b, "happ_ishotfix", zA);
            s.e("PatchManager", "cleanPatches", "finish clean");
        } catch (Throwable th) {
            throw th;
        }
    }

    private static void a(String str, Throwable th) {
        throw new RuntimeException("abandon initialization: " + str, th);
    }

    public void a(p pVar) {
        z.a(pVar);
    }

    public void a(Class cls) {
        com.taobao.sophix.b.a(cls);
    }
}
