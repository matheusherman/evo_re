package com.taobao.sophix;

import java.io.File;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static boolean f8445a;

    public static void a(boolean z10) {
        s.c("EnhanceUtils", "setUsingEnhance", "force to treat as enhanced app", String.valueOf(z10));
        f8445a = z10;
    }

    public static boolean b(File file) {
        boolean z10;
        boolean zExists = true;
        try {
            Class.forName("com.SecShell.SecShell.ApplicationWrapper");
            z10 = true;
        } catch (ClassNotFoundException unused) {
            z10 = false;
        }
        if (z10) {
            zExists = z10;
        } else {
            try {
                Class.forName("com.secneo.apkwrapper.ApplicationWrapper");
            } catch (ClassNotFoundException unused2) {
                zExists = z10;
            }
        }
        if (!zExists) {
            zExists = new File(file, "lib/libDexHelper.so").exists();
        }
        if (!zExists) {
            zExists = new File(file, "lib/libSecShell.so").exists();
        }
        if (!zExists) {
            try {
                zExists = new File(j.f8458b.getApplicationInfo().nativeLibraryDir, "libDexHelper.so").exists();
            } catch (Exception unused3) {
            }
        }
        if (zExists) {
            return zExists;
        }
        try {
            return new File(j.f8458b.getApplicationInfo().nativeLibraryDir, "libSecShell.so").exists();
        } catch (Exception unused4) {
            return zExists;
        }
    }

    static {
        File filesDir = j.f8458b.getFilesDir();
        boolean zA = a(filesDir.getParentFile());
        boolean zB = b(filesDir.getParentFile());
        boolean zExists = new File(filesDir.getParentFile(), "tx_shell").exists();
        boolean zExists2 = new File(filesDir, "libexec.so").exists();
        boolean zExists3 = new File(filesDir.getParentFile(), ".cache/d3d3Lm5hZ2Fpbi5jb20=").exists();
        boolean zExists4 = new File(filesDir.getParent(), ".TestinGuard").exists();
        boolean zC = c(filesDir.getParentFile());
        boolean z10 = f8445a | zA | zB | zExists | zExists2 | zExists3 | zExists4 | zC;
        f8445a = z10;
        if (z10) {
            s.a("EnhanceUtils", "init", "36", Boolean.valueOf(zA), "bb", Boolean.valueOf(zB), "le", Boolean.valueOf(zExists), "ae", Boolean.valueOf(zExists2), "nj", Boolean.valueOf(zExists3), "yc", Boolean.valueOf(zExists4), "yd", Boolean.valueOf(zC));
        } else {
            s.d("EnhanceUtils", "init", "plain app");
        }
    }

    public static boolean c(File file) {
        boolean zExists;
        try {
            Class.forName("com.netease.nis.wrapper.MyApplication");
            zExists = true;
        } catch (ClassNotFoundException unused) {
            zExists = false;
        }
        if (!zExists) {
            zExists = new File(file, "lib/libnesec.so").exists();
        }
        if (zExists) {
            return zExists;
        }
        try {
            return new File(j.f8458b.getApplicationInfo().nativeLibraryDir, "libnesec.so").exists();
        } catch (Exception unused2) {
            return zExists;
        }
    }

    public static boolean a() {
        return f8445a;
    }

    public static boolean a(File file) {
        boolean zExists = new File(file, ".jiagu").exists();
        if (!zExists) {
            zExists = new File(file, "lib/libjiagu.so").exists();
        }
        if (!zExists) {
            try {
                return new File(j.f8458b.getApplicationInfo().nativeLibraryDir, "libjiagu.so").exists();
            } catch (Exception unused) {
            }
        }
        return zExists;
    }
}
