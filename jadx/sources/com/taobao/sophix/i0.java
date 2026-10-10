package com.taobao.sophix;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.taobao.sophix.listener.PatchLoadStatusListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class i0 extends SophixManager {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static i0 f8446g = new i0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f8447a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private PatchLoadStatusListener f8448b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private y f8451e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f8452f = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AtomicBoolean f8449c = new AtomicBoolean(false);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private v f8450d = new v();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f8453a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b0 f8454b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ PatchLoadStatusListener f8455c;

        a(String str, b0 b0Var, PatchLoadStatusListener patchLoadStatusListener) {
            this.f8453a = str;
            this.f8454b = b0Var;
            this.f8455c = patchLoadStatusListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            String strA = i0.this.f8450d.a(this.f8453a, this.f8454b, this.f8455c);
            if (TextUtils.isEmpty(strA)) {
                return;
            }
            i0.this.f8451e.a(strA, this.f8455c, this.f8454b);
        }
    }

    @Override // com.taobao.sophix.SophixManager
    public void cleanPatches() {
        a(true);
    }

    @Override // com.taobao.sophix.SophixManager
    public SophixManager setEnableClassLoaderLog() {
        this.f8452f = true;
        return this;
    }

    @Override // com.taobao.sophix.SophixManager
    public SophixManager setEnableFullLog() {
        s.a(true);
        s.b(s.a.V);
        return this;
    }

    @Override // com.taobao.sophix.SophixManager
    public SophixManager setHost(String str, boolean z10) {
        s.c("SophixManager", "setHost", new Object[0]);
        c.a(str, z10);
        return this;
    }

    @Override // com.taobao.sophix.SophixManager
    public SophixManager setUsingEnhance() {
        return setUsingEnhance(true);
    }

    private void a() {
        if (j.f8458b == null) {
            throw new RuntimeException("app is null");
        }
        if (this.f8449c.compareAndSet(false, true)) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            String absolutePath = i.a(j.f8458b.getFilesDir(), "sophix").getAbsolutePath();
            this.f8451e.a(absolutePath);
            j.f8457a = h0.a((Context) j.f8458b, "hpatch_version", 0);
            s.c("SophixManager", "Sophix starting...", "sdk", SophixManager.VERSION, "main process", Boolean.valueOf(d0.b(j.f8458b)), "fingerprint", Build.FINGERPRINT, "app version", this.f8447a, "patch version", Integer.valueOf(j.f8457a));
            c.a(0, true);
            this.f8450d.a(absolutePath, this.f8447a);
            this.f8451e.c(false);
            this.f8451e.d(false);
            this.f8451e.a(this.f8447a, this.f8448b);
            s.a("SophixManager", "initialize", "time consumed(ms)", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
        }
    }

    public boolean b() {
        return this.f8452f;
    }

    @Override // com.taobao.sophix.SophixManager
    public Object getPatchStateInfo() {
        return this.f8451e.f();
    }

    @Override // com.taobao.sophix.SophixManager
    public void killProcessSafely() {
        this.f8451e.i();
    }

    @Override // com.taobao.sophix.SophixManager
    public void queryAndLoadNewPatch() {
        if (!this.f8449c.get()) {
            s.e("SophixManager", "sophix not initialized", "abort query patch");
            return;
        }
        b0 b0Var = new b0(1);
        b0Var.f8420d = j.f8457a != -1 ? j.f8457a : 0;
        a(null, b0Var, this.f8448b);
    }

    @Override // com.taobao.sophix.SophixManager
    public SophixManager setAesKey(String str) {
        this.f8451e.b(str);
        return this;
    }

    @Override // com.taobao.sophix.SophixManager
    public SophixManager setAppVersion(String str) {
        this.f8447a = str;
        return this;
    }

    @Override // com.taobao.sophix.SophixManager
    public SophixManager setContext(Application application) {
        if (this.f8449c.get()) {
            s.a("SophixManager", "setContext", "can not set app again");
            return this;
        }
        j.f8458b = application;
        return this;
    }

    @Override // com.taobao.sophix.SophixManager
    public SophixManager setEnableDebug(boolean z10) {
        if (this.f8449c.get()) {
            s.a("SophixManager", "setEnableDebug", "can not set debug state again");
            return this;
        }
        this.f8451e.b(z10);
        if (z10) {
            s.b(s.a.D);
            return this;
        }
        s.b(s.a.I);
        return this;
    }

    @Override // com.taobao.sophix.SophixManager
    public void setOatSdkVersion(int i10) {
        if (this.f8449c.get()) {
            h0.b((Context) j.f8458b, "oat_sdk_int", i10);
        }
    }

    @Override // com.taobao.sophix.SophixManager
    public SophixManager setPatchLoadStatusStub(PatchLoadStatusListener patchLoadStatusListener) {
        if (patchLoadStatusListener != null) {
            this.f8448b = patchLoadStatusListener;
            j.f8463g = patchLoadStatusListener;
        }
        return this;
    }

    @Override // com.taobao.sophix.SophixManager
    public SophixManager setPreLoadedClass(Class cls) {
        this.f8451e.a(cls);
        return this;
    }

    @Override // com.taobao.sophix.SophixManager
    public SophixManager setProcessSpecialClass(Class cls) {
        this.f8451e.b(cls);
        return this;
    }

    @Override // com.taobao.sophix.SophixManager
    public SophixManager setSecretMetaData(String str, String str2, String str3) {
        this.f8450d.a(str, str2, str3);
        return this;
    }

    @Override // com.taobao.sophix.SophixManager
    public SophixManager setTags(List<String> list) {
        if (list != null && list.size() > 0) {
            this.f8450d.a(new ArrayList(list));
        }
        return this;
    }

    @Override // com.taobao.sophix.SophixManager
    public SophixManager setUnsupportedModel(String str, int i10) {
        this.f8451e.a(str, i10);
        return this;
    }

    @Override // com.taobao.sophix.SophixManager
    public SophixManager setUsingEnhance(boolean z10) {
        this.f8451e.e(z10);
        return this;
    }

    private i0() {
        y yVar = new y();
        this.f8451e = yVar;
        yVar.a(this.f8450d);
        this.f8448b = new f();
    }

    @Override // com.taobao.sophix.SophixManager
    public void initialize() {
        try {
            a();
        } catch (Throwable th) {
            s.a("SophixManager", "init", th, new Object[0]);
            if (!d.b()) {
                a(false);
                return;
            }
            throw th;
        }
    }

    public void a(String str, b0 b0Var, PatchLoadStatusListener patchLoadStatusListener) {
        if (!this.f8449c.get()) {
            s.e("SophixManager", "sophix not initialized", "abort query load patch");
            return;
        }
        Application application = j.f8458b;
        if (application != null) {
            if (!d0.b(application)) {
                s.e("SophixManager", "queryLoadPatch", "not in main progress, skip");
                return;
            } else {
                k0.a(new a(str, b0Var, patchLoadStatusListener));
                return;
            }
        }
        throw new RuntimeException("app is null");
    }

    public void a(String str, PatchLoadStatusListener patchLoadStatusListener) {
        if (!this.f8449c.get()) {
            s.e("SophixManager", "sophix not initialized", "abort add patch");
        } else {
            if (!this.f8451e.e()) {
                s.e("SophixManager", "addPatch", "forbid loading local patch for secure reason in release mode");
                return;
            }
            b0 b0Var = new b0(1);
            b0Var.f8420d = -1;
            this.f8451e.a(str, patchLoadStatusListener, b0Var);
        }
    }

    /* JADX WARN: Code duplicated, block: B:110:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:92:0x00e1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:99:0x00d7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r7v0, types: [android.net.Uri] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v15, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v18, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v22 */
    /* JADX WARN: Type inference failed for: r7v23 */
    /* JADX WARN: Type inference failed for: r7v24 */
    /* JADX WARN: Type inference failed for: r7v25 */
    /* JADX WARN: Type inference failed for: r7v26 */
    /* JADX WARN: Type inference failed for: r7v27 */
    /* JADX WARN: Type inference failed for: r7v28 */
    /* JADX WARN: Type inference failed for: r7v29 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v30 */
    /* JADX WARN: Type inference failed for: r7v31 */
    /* JADX WARN: Type inference failed for: r7v32 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v9 */
    public void a(Uri uri, PatchLoadStatusListener patchLoadStatusListener) throws Throwable {
        FileOutputStream fileOutputStream;
        ?? r10;
        ?? r11;
        ?? r12;
        if (!this.f8449c.get()) {
            s.e("SophixManager", "sophix not initialized", "abort add patch");
            return;
        }
        String absolutePath = null;
        absolutePath = null;
        ?? r13 = 0;
        absolutePath = null;
        absolutePath = null;
        absolutePath = null;
        if (j.f8458b != null && this.f8449c.get()) {
            try {
                try {
                    if (d0.b(j.f8458b)) {
                        try {
                            uri = j.f8458b.getContentResolver().openInputStream(uri);
                            try {
                                File file = new File(i.a(j.f8458b.getFilesDir(), "sophix").getAbsolutePath(), "download_local");
                                if (!file.exists()) {
                                    file.mkdirs();
                                } else {
                                    i.a(file);
                                }
                                File file2 = new File(file, "sophix-patch.jar");
                                fileOutputStream = new FileOutputStream(file2);
                                try {
                                    byte[] bArr = new byte[1024];
                                    while (true) {
                                        int i10 = uri.read(bArr);
                                        if (i10 <= 0) {
                                            break;
                                        } else {
                                            fileOutputStream.write(bArr, 0, i10);
                                        }
                                    }
                                    fileOutputStream.flush();
                                    absolutePath = file2.getAbsolutePath();
                                    try {
                                        uri.close();
                                    } catch (IOException e10) {
                                        e10.printStackTrace();
                                    }
                                    fileOutputStream.close();
                                } catch (FileNotFoundException e11) {
                                    e = e11;
                                    r12 = uri;
                                    e.printStackTrace();
                                    uri = r12;
                                    if (r12 != 0) {
                                        try {
                                            r12.close();
                                            uri = r12;
                                        } catch (IOException e12) {
                                            e12.printStackTrace();
                                            uri = e12;
                                        }
                                    }
                                    if (fileOutputStream != null) {
                                        fileOutputStream.close();
                                    }
                                } catch (IOException e13) {
                                    e = e13;
                                    r11 = uri;
                                    e.printStackTrace();
                                    uri = r11;
                                    if (r11 != 0) {
                                        try {
                                            r11.close();
                                            uri = r11;
                                        } catch (IOException e14) {
                                            e14.printStackTrace();
                                            uri = e14;
                                        }
                                    }
                                    if (fileOutputStream != null) {
                                        fileOutputStream.close();
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    r10 = uri;
                                    if (r10 != 0) {
                                        try {
                                            r10.close();
                                        } catch (IOException e15) {
                                            e15.printStackTrace();
                                        }
                                    }
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                            throw th;
                                        } catch (IOException e16) {
                                            e16.printStackTrace();
                                            throw th;
                                        }
                                    }
                                    throw th;
                                }
                            } catch (FileNotFoundException e17) {
                                e = e17;
                                fileOutputStream = null;
                                r12 = uri;
                            } catch (IOException e18) {
                                e = e18;
                                fileOutputStream = null;
                                r11 = uri;
                            } catch (Throwable th2) {
                                th = th2;
                                fileOutputStream = null;
                                r13 = uri;
                                r10 = r13;
                                if (r10 != 0) {
                                    r10.close();
                                }
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                    throw th;
                                }
                                throw th;
                            }
                        } catch (FileNotFoundException e19) {
                            e = e19;
                            r12 = 0;
                            fileOutputStream = null;
                        } catch (IOException e20) {
                            e = e20;
                            r11 = 0;
                            fileOutputStream = null;
                        } catch (Throwable th3) {
                            th = th3;
                            fileOutputStream = null;
                            r10 = r13;
                            if (r10 != 0) {
                                r10.close();
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                                throw th;
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
            } catch (IOException e21) {
                e21.printStackTrace();
            }
        }
        if (TextUtils.isEmpty(absolutePath)) {
            return;
        }
        a(absolutePath, patchLoadStatusListener);
    }

    public void a(Application application) {
        if (this.f8449c.get()) {
            this.f8451e.k();
        } else {
            s.e("SophixManager", "sophix not initialized, recover lifecycle", new Object[0]);
            y.b(application);
        }
    }

    public void a(boolean z10) {
        if (this.f8449c.get()) {
            this.f8451e.a(z10);
        }
    }
}
