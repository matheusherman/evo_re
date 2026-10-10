package com.taobao.sophix;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.taobao.sophix.core.dex.SophixNative;
import com.taobao.sophix.listener.PatchLoadStatusListener;
import dalvik.system.DexFile;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class b implements o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static PatchLoadStatusListener f8409b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f8410c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b0 f8411a;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ File f8412a;

        a(File file) {
            this.f8412a = file;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                b.this.c(this.f8412a);
                long length = 0;
                for (File file : this.f8412a.getParentFile().listFiles()) {
                    if (file.getName().endsWith(".dex") || file.getName().equals("sophix-merged.zip")) {
                        length += file.length();
                    }
                }
                b.this.f8411a.b();
                b.this.f8411a.f8423g = length;
                b.this.f8411a.f8421e = System.currentTimeMillis() - jCurrentTimeMillis;
                b.this.f8411a.f8419c = "181";
                z.a(b.this.f8411a);
                b.f8409b.onLoad(0, 100, "preload success", b.this.f8411a.f8420d);
                b.f8409b.onLoad(0, 12, "relaunch app", b.this.f8411a.f8420d);
            } catch (w e10) {
                b.this.f8411a.b();
                b.this.f8411a.f8419c = "182";
                b.this.f8411a.f8425i = e10.a();
                z.a(b.this.f8411a);
                s.a("ColdDexManager", "patch", e10, "code", Integer.valueOf(e10.a()), NotificationCompat.CATEGORY_MESSAGE, e10.getMessage());
                b.f8409b.onLoad(0, e10.a(), e10.getMessage(), b.this.f8411a.f8420d);
            } catch (Throwable th) {
                b.this.f8411a.b();
                b.this.f8411a.f8419c = "182";
                b.this.f8411a.f8425i = 101;
                z.a(b.this.f8411a);
                s.a("ColdDexManager", "patch", th, new Object[0]);
                b.f8409b.onLoad(0, 101, th.getMessage(), b.this.f8411a.f8420d);
            }
        }
    }

    /* JADX INFO: renamed from: com.taobao.sophix.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class C0157b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final List<Class> f8414a = b();

        private static List<Class> b() {
            List<Class> listE = b.e();
            PatchLoadStatusListener patchLoadStatusListener = j.f8463g;
            if (patchLoadStatusListener != null && !(patchLoadStatusListener instanceof f)) {
                b(listE, patchLoadStatusListener.getClass());
            }
            return listE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(List<Class> list, Class cls) {
            if (cls == null || list.contains(cls)) {
                return;
            }
            list.add(cls);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void c(File file) {
        s.c("ColdDexManager", "doOptPatch start", new Object[0]);
        if (!d0.b(j.f8458b)) {
            s.e("ColdDexManager", "doOptPatch", "skip in main process");
            return;
        }
        if (h.a()) {
            j(file);
        } else {
            d(file);
            h(file);
        }
        h0.b(j.f8458b, "sophix_system_fingerprint", Build.FINGERPRINT);
    }

    private void d(File file) throws Throwable {
        ZipFile zipFile;
        int i10 = 0;
        s.a("ColdDexManager", "extractAllBaseDexFiles start", new Object[0]);
        ZipFile zipFile2 = null;
        try {
            zipFile = new ZipFile(file);
            try {
                try {
                    ZipFile zipFile3 = new ZipFile(j.f8458b.getApplicationInfo().sourceDir);
                    try {
                        File parentFile = file.getParentFile();
                        ZipEntry entry = zipFile.getEntry("classes.dex");
                        if (entry != null) {
                            a(zipFile, entry, parentFile + File.separator + "classes.dex");
                        }
                        h0.b((Context) j.f8458b, "SP_BASE_DEX_COUNT", 0);
                        Enumeration<? extends ZipEntry> enumerationEntries = zipFile3.entries();
                        while (enumerationEntries.hasMoreElements()) {
                            ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                            String name = zipEntryNextElement.getName();
                            if (name.startsWith("classes") && name.endsWith(".dex")) {
                                if (name.equals("classes.dex")) {
                                    name = "classes1.dex";
                                }
                                a(zipFile3, zipEntryNextElement, parentFile + File.separator + name);
                                i10++;
                            }
                        }
                        h0.b((Context) j.f8458b, "SP_BASE_DEX_COUNT", i10);
                        i.a(zipFile);
                        i.a(zipFile3);
                    } catch (Throwable th) {
                        th = th;
                        zipFile2 = zipFile3;
                        i.a(zipFile);
                        i.a(zipFile2);
                        throw th;
                    }
                } catch (IOException e10) {
                    e = e10;
                    throw new w(103, e);
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e11) {
            e = e11;
            zipFile = null;
        } catch (Throwable th3) {
            th = th3;
            zipFile = null;
        }
    }

    private File e(File file) {
        if (Build.VERSION.SDK_INT < 26) {
            return file;
        }
        String name = file.getName();
        String str = name.substring(0, name.indexOf(".")) + ".odex";
        File parentFile = file.getParentFile();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("oat");
        String str2 = File.separator;
        sb2.append(str2);
        sb2.append(c());
        sb2.append(str2);
        sb2.append(str);
        return new File(parentFile, sb2.toString());
    }

    private boolean f(File file) throws w {
        String parent = file.getParent();
        if (h.a()) {
            if (Build.VERSION.SDK_INT < 29) {
                return g(e(new File(parent, a(file.getName()))));
            }
            if (this.f8411a.f8418b != 3) {
                s.c("ColdDexManager", "android version >= 29, preload, not apply patch under enhanced.", new Object[0]);
                return false;
            }
            boolean zExists = file.exists();
            s.c("ColdDexManager", "android version >= 29, check patch file exists: ", Boolean.valueOf(zExists));
            return zExists;
        }
        if (Build.VERSION.SDK_INT < 29) {
            return g(e(new File(parent, a("sophix-merged.zip"))));
        }
        boolean zExists2 = new File(parent, "sophix-merged.zip").exists();
        s.c("ColdDexManager", "android version >= 29, check zip exists: ", Boolean.valueOf(zExists2));
        if (!zExists2) {
            return false;
        }
        int iA = h0.a((Context) j.f8458b, "oat_sdk_int", -1);
        s.a("ColdDexManager", "oat sdk int: " + iA, new Object[0]);
        if (iA >= 29) {
            File fileE = e(new File(parent, a("sophix-merged.zip")));
            s.a("ColdDexManager", "opt file exists: " + fileE.exists(), new Object[0]);
            if (fileE.exists()) {
                return g(fileE);
            }
            return true;
        }
        h0.a(j.f8458b, "oat_sdk_int");
        File fileE2 = e(new File(parent, a("sophix-merged.zip")));
        s.a("ColdDexManager", "opt file exists: " + fileE2.exists(), new Object[0]);
        if (!fileE2.exists() || !d0.b(j.f8458b) || fileE2.delete()) {
            return false;
        }
        s.b("ColdDexManager", "hasValidOptPatches", "fail to delete illegal odex file.");
        throw new w(80, "fail to delete odex file.");
    }

    private void i(File file) throws Throwable {
        s.a("ColdDexManager", "optProcessedBaseDexFiles start", new Object[0]);
        j(new File(file.getParent(), "classes.dex"));
        for (int iA = h0.a((Context) j.f8458b, "SP_BASE_DEX_COUNT", 0); iA != 0; iA--) {
            File file2 = new File(file.getParent(), "classes" + String.valueOf(iA) + ".dex");
            if (!k(file2)) {
                throw new w(105, "processBaseDexFiles fail");
            }
            j(file2);
        }
    }

    private static void b(List<Class> list, Class cls) {
        for (Class<?> cls2 : cls.getInterfaces()) {
            a(list, cls2);
            b(list, cls2);
        }
    }

    private void h(File file) throws Throwable {
        ZipOutputStream zipOutputStream;
        s.a("ColdDexManager", "optMergedAllDexFiles start", new Object[0]);
        try {
            try {
                File fileCreateTempFile = File.createTempFile("sophix-merged.zip", ".tmp", file.getParentFile());
                zipOutputStream = new ZipOutputStream(new FileOutputStream(fileCreateTempFile));
                try {
                    zipOutputStream.putNextEntry(new ZipEntry("classes.dex"));
                    File file2 = new File(file.getParent(), "classes.dex");
                    FileInputStream fileInputStream = new FileInputStream(file2);
                    i.a(fileInputStream, zipOutputStream);
                    fileInputStream.close();
                    file2.delete();
                    File file3 = new File(file.getParent(), "classes" + String.valueOf(1) + ".dex");
                    if (Build.VERSION.SDK_INT < 27 && d() && !SophixNative.markKeptMethods(file3.getPath(), a(f()))) {
                        s.b("ColdDexManager", "fail to mark kept methods", new Object[0]);
                        throw new w(106, "fail to mark kept methods");
                    }
                    int i10 = 1;
                    while (file3.exists()) {
                        s.a("ColdDexManager", "append dex file " + file3.getName() + " to jar", new Object[0]);
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("classes");
                        i10++;
                        sb2.append(String.valueOf(i10));
                        sb2.append(".dex");
                        zipOutputStream.putNextEntry(new ZipEntry(sb2.toString()));
                        FileInputStream fileInputStream2 = new FileInputStream(file3);
                        i.a(fileInputStream2, zipOutputStream);
                        fileInputStream2.close();
                        file3.delete();
                        file3 = new File(file.getParent(), "classes" + String.valueOf(i10) + ".dex");
                    }
                    zipOutputStream.close();
                    File file4 = new File(file.getParentFile(), "sophix-merged.zip");
                    if (file4.exists()) {
                        s.a("ColdDexManager", "mergedFile", file4.getAbsolutePath() + " exist, delete first.");
                        file4.delete();
                    }
                    g0.a(e(new File(a(file4.getPath()))));
                    if (!fileCreateTempFile.renameTo(file4)) {
                        throw new IOException("fail to rename");
                    }
                    j(file4);
                    i.a(zipOutputStream);
                } catch (IOException e10) {
                    e = e10;
                    throw new w(107, e);
                } catch (Throwable th) {
                    th = th;
                    i.a(zipOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                zipOutputStream = null;
            }
        } catch (IOException e11) {
            e = e11;
        }
    }

    public b(PatchLoadStatusListener patchLoadStatusListener, b0 b0Var) {
        f8409b = patchLoadStatusListener;
        this.f8411a = b0Var;
    }

    private boolean g(File file) throws w {
        s.a("ColdDexManager", "isOptFileValid", "file", file.getName());
        if (file.exists()) {
            if (g0.c(file)) {
                s.d("ColdDexManager", "isOptFileValid", "odex is legal");
                return true;
            }
            if (d0.b(j.f8458b)) {
                s.e("ColdDexManager", "isOptFileValid", "odex is illegal");
                if (file.delete()) {
                    return false;
                }
                s.b("ColdDexManager", "isOptFileValid", "fail to delete illegal odex file.");
                throw new w(80, "fail to delete odex file.");
            }
            s.e("ColdDexManager", "isOptFileValid", "not main process");
            return false;
        }
        s.a("ColdDexManager", "isOptFileValid", "odex not exist");
        return false;
    }

    private void j(File file) throws Throwable {
        s.c("ColdDexManager", "preloadDex start", file.getName());
        long jCurrentTimeMillis = System.currentTimeMillis();
        File file2 = new File(a(file.getPath()));
        try {
            file.setReadOnly();
            int i10 = Build.VERSION.SDK_INT;
            if (i10 != 23 && i10 < 26 && file.length() > 2000000) {
                if (!a(file.getAbsolutePath(), file2.getPath())) {
                    s.e("ColdDexManager", "preloadDex switch to traditional odex", new Object[0]);
                    DexFile.loadDex(file.getAbsolutePath(), file2.getPath(), 0);
                }
            } else {
                DexFile.loadDex(file.getAbsolutePath(), file2.getPath(), 0);
            }
            File fileE = e(file2);
            String strA = t.a(fileE);
            long j10 = 1000;
            while (true) {
                if (!TextUtils.isEmpty(strA) && strA.equals(t.a(fileE))) {
                    break;
                }
                strA = t.a(fileE);
                try {
                    s.a("ColdDexManager", "preloadDex wait dexopt " + String.valueOf(j10) + "ms", new Object[0]);
                    Thread.sleep(j10);
                } catch (InterruptedException unused) {
                }
                if (j10 < 8000) {
                    j10 += 1000;
                } else if (TextUtils.isEmpty(strA)) {
                    s.e("ColdDexManager", "preloadDex signature is always empty, abandon.", new Object[0]);
                    break;
                }
            }
            s.c("ColdDexManager", "preloadDex end", "time consumed(ms)", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
            g0.a(fileE, strA);
            h0.b((Context) j.f8458b, "oat_sdk_int", Build.VERSION.SDK_INT);
        } catch (IOException e10) {
            throw new w(102, e10);
        }
    }

    private boolean k(File file) {
        return SophixNative.removeClassesInBase(file.getPath(), new File(file.getParent(), "classes.dex").getPath(), a(f()));
    }

    @Override // com.taobao.sophix.o
    public boolean a(File file) throws w {
        if (f(file)) {
            this.f8411a.b();
            b0 b0Var = this.f8411a;
            b0Var.f8419c = "181";
            z.a(b0Var);
            b(file);
            return true;
        }
        k0.a(new a(file));
        return false;
    }

    private void b(File file) throws w {
        s.c("ColdDexManager", "doApplyPatch", new Object[0]);
        com.taobao.sophix.a aVar = new com.taobao.sophix.a(getClass().getClassLoader());
        if (h.a()) {
            aVar.a(file);
        } else {
            aVar.a(new File(file.getParentFile(), "sophix-merged.zip"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<Class> e() {
        Class<?> cls = j.f8458b.getClass();
        ArrayList arrayList = new ArrayList();
        a(arrayList, cls);
        c(arrayList, cls);
        b(arrayList, cls);
        return arrayList;
    }

    private static void c(List<Class> list, Class cls) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Application.class);
        for (Class superclass = cls.getSuperclass(); !arrayList.contains(superclass); superclass = superclass.getSuperclass()) {
            a(list, superclass);
        }
    }

    private static void a(List<Class> list, Class cls) {
        if (list.contains(cls)) {
            return;
        }
        list.add(cls);
    }

    public static void b(Class cls) {
        s.d("ColdDexManager", "setClearPreVerified", "ignore in art.");
    }

    private static String[] a(List<Class> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<Class> it = list.iterator();
        while (it.hasNext()) {
            String str = "L" + it.next().getName().replace(".", "/") + ";";
            s.d("ColdDexManager", "exclude " + str, new Object[0]);
            arrayList.add(str);
        }
        String[] strArr = new String[arrayList.size()];
        arrayList.toArray(strArr);
        return strArr;
    }

    private static String c() {
        if (f8410c == null) {
            try {
                f8410c = (String) e0.a(Class.forName("dalvik.system.VMRuntime"), "getInstructionSet", String.class).invoke(null, (String) e0.a(ApplicationInfo.class, "primaryCpuAbi").get(j.f8458b.getApplicationInfo()));
            } catch (Exception e10) {
                s.a("ColdDexManager", "fail to get primary cpu abi", e10, new Object[0]);
            }
        }
        return f8410c;
    }

    private boolean a(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("dex2oat");
        if (Build.VERSION.SDK_INT >= 24) {
            arrayList.add("--runtime-arg");
            arrayList.add("-classpath");
            arrayList.add("--runtime-arg");
            arrayList.add("&");
        }
        arrayList.add("--dex-file=" + str);
        arrayList.add("--oat-file=" + str2);
        arrayList.add("--instruction-set=" + c());
        arrayList.add("--compiler-filter=interpret-only");
        ProcessBuilder processBuilder = new ProcessBuilder(arrayList);
        processBuilder.redirectErrorStream(true);
        try {
            int iWaitFor = processBuilder.start().waitFor();
            if (iWaitFor == 0) {
                return true;
            }
            s.b("ColdDexManager", "dex2oat exit un-normally: " + iWaitFor, new Object[0]);
            return false;
        } catch (IOException e10) {
            s.a("ColdDexManager", "dex2oat failed to start", e10, new Object[0]);
            return false;
        } catch (InterruptedException e11) {
            s.a("ColdDexManager", "dex2oat was interrupted: ", e11, new Object[0]);
            return false;
        }
    }

    static boolean d() {
        return Build.VERSION.SDK_INT >= 24 && !j.f8462f;
    }

    public static List<Class> f() {
        return C0157b.f8414a;
    }

    private void a(ZipFile zipFile, ZipEntry zipEntry, String str) throws Throwable {
        InputStream inputStream;
        IOException e10;
        Throwable th;
        FileOutputStream fileOutputStream = null;
        try {
            inputStream = zipFile.getInputStream(zipEntry);
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(str);
                try {
                    i.a(inputStream, fileOutputStream2);
                    i.a(inputStream);
                    i.a(fileOutputStream2);
                } catch (IOException e11) {
                    e10 = e11;
                    fileOutputStream = fileOutputStream2;
                    try {
                        throw new w(104, e10);
                    } catch (Throwable th2) {
                        th = th2;
                        th = th;
                        i.a(inputStream);
                        i.a(fileOutputStream);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = fileOutputStream2;
                    th = th;
                    i.a(inputStream);
                    i.a(fileOutputStream);
                    throw th;
                }
            } catch (IOException e12) {
                e10 = e12;
            } catch (Throwable th4) {
                th = th4;
                i.a(inputStream);
                i.a(fileOutputStream);
                throw th;
            }
        } catch (IOException e13) {
            e10 = e13;
            inputStream = null;
        } catch (Throwable th5) {
            th = th5;
            inputStream = null;
        }
    }

    static String a(String str) {
        return str + ".odex";
    }

    public static void a(Class cls) {
        C0157b.b(C0157b.f8414a, cls);
    }
}
