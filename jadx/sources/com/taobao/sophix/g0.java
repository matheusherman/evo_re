package com.taobao.sophix;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import java.util.zip.ZipFile;
import org.apache.log4j.helpers.FileWatchdog;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class g0 {
    private static void a(JarFile jarFile, JarEntry jarEntry) throws Throwable {
        InputStream inputStream;
        try {
            inputStream = jarFile.getInputStream(jarEntry);
            try {
                do {
                } while (inputStream.read(new byte[8192]) > 0);
                i.a(inputStream);
            } catch (Throwable th) {
                th = th;
                i.a(inputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
        }
    }

    public static void b(File file) {
        h0.b(j.f8458b, file.getName() + "-md5", t.a(file));
    }

    public static boolean d(File file) throws Throwable {
        JarFile jarFile;
        JarFile jarFile2 = null;
        try {
            try {
                jarFile = new JarFile(file);
                try {
                    Manifest manifest = jarFile.getManifest();
                    if (manifest != null && manifest.getEntries() != null) {
                        Enumeration<JarEntry> enumerationEntries = jarFile.entries();
                        while (enumerationEntries.hasMoreElements()) {
                            JarEntry jarEntryNextElement = enumerationEntries.nextElement();
                            if (!jarEntryNextElement.isDirectory()) {
                                String name = jarEntryNextElement.getName();
                                if (!name.startsWith("META-INF") && (!name.endsWith(".dex") || name.equals("classes.dex"))) {
                                    JarEntry jarEntry = jarFile.getJarEntry(name);
                                    if (jarEntry == null) {
                                        s.a("SecurityUtils", "verifyPatchLegal", "jarEntry not exist in patch", name);
                                        i.a((ZipFile) jarFile);
                                        return false;
                                    }
                                    a(jarFile, jarEntry);
                                    Certificate[] certificates = jarEntry.getCertificates();
                                    if (certificates == null) {
                                        s.a("SecurityUtils", "verifyPatchLegal", "no certs in META-INF", name);
                                        i.a((ZipFile) jarFile);
                                        return false;
                                    }
                                    if (!a(file, certificates)) {
                                        s.a("SecurityUtils", "verifyPatchLegal", "certs no match in META-INF", name);
                                        i.a((ZipFile) jarFile);
                                        return false;
                                    }
                                }
                            }
                        }
                        i.a((ZipFile) jarFile);
                        return true;
                    }
                    s.a("SecurityUtils", "verifyPatchLegal", "no META-INF");
                    i.a((ZipFile) jarFile);
                    return false;
                } catch (IOException e10) {
                    e = e10;
                    jarFile2 = jarFile;
                    s.a("SecurityUtils", "verifyPatchLegal", e, new Object[0]);
                    i.a((ZipFile) jarFile2);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    i.a((ZipFile) jarFile);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                jarFile = jarFile2;
            }
        } catch (IOException e11) {
            e = e11;
        }
    }

    public static boolean c(File file) throws Throwable {
        boolean z10;
        String strA = t.a(file);
        String strA2 = h0.a(j.f8458b, file.getName() + "-md5", (String) null);
        if (strA != null && TextUtils.equals(strA, strA2)) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            long jLastModified = file.lastModified();
            long jA = h0.a((Context) j.f8458b, file.getName() + "-lm", 0L);
            if (jA > 0) {
                if (jLastModified - jA >= FileWatchdog.DEFAULT_DELAY) {
                    return false;
                }
                return true;
            }
        }
        return z10;
    }

    private static boolean a(File file, Certificate[] certificateArr) {
        PublicKey publicKeyA = a();
        if (certificateArr.length > 0) {
            for (int length = certificateArr.length - 1; length >= 0; length--) {
                try {
                    certificateArr[length].verify(publicKeyA);
                    return true;
                } catch (Exception e10) {
                    s.a("SecurityUtils", file.getAbsolutePath(), e10, new Object[0]);
                }
            }
        }
        return false;
    }

    private static PublicKey a() {
        try {
            return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(j.f8458b.getPackageManager().getPackageInfo(j.f8458b.getBaseContext().getPackageName(), 64).signatures[0].toByteArray()))).getPublicKey();
        } catch (PackageManager.NameNotFoundException e10) {
            Log.e("SecurityUtils", "getPublicKey", e10);
            return null;
        } catch (CertificateException e11) {
            Log.e("SecurityUtils", "getPublicKey", e11);
            return null;
        }
    }

    public static void a(File file, String str) {
        h0.b(j.f8458b, file.getName() + "-md5", str);
        if (file.exists()) {
            h0.b(j.f8458b, file.getName() + "-lm", file.lastModified());
        }
    }

    public static void a(File file) {
        h0.a(j.f8458b, file.getName() + "-md5");
    }
}
