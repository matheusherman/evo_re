package com.taobao.sophix;

import android.annotation.TargetApi;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import dalvik.system.BaseDexClassLoader;
import dalvik.system.DexFile;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String[] f8489a;

    private void b(Object obj, String str, Object obj2) {
        ((List) a(obj, str).get(obj)).add(0, obj2);
    }

    public void a(String str, ZipFile zipFile, File file) throws IOException, w {
        BufferedOutputStream bufferedOutputStream;
        char c10;
        char c11;
        char c12;
        char c13;
        BufferedInputStream bufferedInputStream;
        file = file;
        int i10 = 4;
        int i11 = 1;
        char c14 = 2;
        int i12 = 3;
        s.a("NativeLibManager", "unZipLibFile", "libPath", str, "libDir", file);
        try {
            Map<String, String> mapA = a(str);
            Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
            while (enumerationEntries.hasMoreElements()) {
                ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                String name = zipEntryNextElement.getName();
                if (a(name, file, mapA)) {
                    String strSubstring = name.substring(name.lastIndexOf(File.separator) + i11);
                    Object[] objArr = new Object[i10];
                    objArr[0] = "entryName";
                    objArr[i11] = name;
                    objArr[c14] = "soName";
                    objArr[i12] = strSubstring;
                    s.d("NativeLibManager", "unZipLibFile", objArr);
                    int i13 = 0;
                    boolean z10 = false;
                    while (i13 < i12 && !z10) {
                        int i14 = i13 + 1;
                        BufferedInputStream bufferedInputStream2 = null;
                        try {
                            try {
                                c10 = 4;
                                try {
                                    c11 = 1;
                                    try {
                                        bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(file, strSubstring)));
                                        try {
                                            try {
                                                c12 = 2;
                                                try {
                                                    bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(zipEntryNextElement));
                                                    try {
                                                        try {
                                                            byte[] bArr = new byte[1024];
                                                            c13 = 3;
                                                            for (int i15 = bufferedInputStream.read(bArr); i15 != -1; i15 = bufferedInputStream.read(bArr)) {
                                                                try {
                                                                    bufferedOutputStream.write(bArr, 0, i15);
                                                                } catch (IOException e10) {
                                                                    e = e10;
                                                                    bufferedInputStream2 = bufferedInputStream;
                                                                    Integer numValueOf = Integer.valueOf(i14);
                                                                    Object[] objArr2 = new Object[6];
                                                                    objArr2[0] = "entryName";
                                                                    objArr2[c11] = name;
                                                                    objArr2[c12] = "libName";
                                                                    objArr2[c13] = strSubstring;
                                                                    objArr2[c10] = "numAttempts";
                                                                    objArr2[5] = numValueOf;
                                                                    s.b("NativeLibManager", "unZipLibFile", e, objArr2);
                                                                    i.a(bufferedOutputStream);
                                                                    bufferedInputStream = bufferedInputStream2;
                                                                    i.a(bufferedInputStream);
                                                                    file = file;
                                                                    i13 = i14;
                                                                    i12 = 3;
                                                                }
                                                            }
                                                            i.a(bufferedOutputStream);
                                                            z10 = true;
                                                        } catch (IOException e11) {
                                                            e = e11;
                                                            c13 = 3;
                                                        }
                                                    } catch (Throwable th) {
                                                        th = th;
                                                        bufferedInputStream2 = bufferedInputStream;
                                                        i.a(bufferedOutputStream);
                                                        i.a(bufferedInputStream2);
                                                        throw th;
                                                    }
                                                } catch (IOException e12) {
                                                    e = e12;
                                                    c13 = 3;
                                                    Integer numValueOf2 = Integer.valueOf(i14);
                                                    Object[] objArr3 = new Object[6];
                                                    objArr3[0] = "entryName";
                                                    objArr3[c11] = name;
                                                    objArr3[c12] = "libName";
                                                    objArr3[c13] = strSubstring;
                                                    objArr3[c10] = "numAttempts";
                                                    objArr3[5] = numValueOf2;
                                                    s.b("NativeLibManager", "unZipLibFile", e, objArr3);
                                                    i.a(bufferedOutputStream);
                                                    bufferedInputStream = bufferedInputStream2;
                                                    i.a(bufferedInputStream);
                                                    file = file;
                                                    i13 = i14;
                                                    i12 = 3;
                                                }
                                            } catch (Throwable th2) {
                                                th = th2;
                                            }
                                        } catch (IOException e13) {
                                            e = e13;
                                            c12 = 2;
                                        }
                                    } catch (IOException e14) {
                                        e = e14;
                                        c12 = 2;
                                        c13 = 3;
                                        bufferedOutputStream = null;
                                        Integer numValueOf3 = Integer.valueOf(i14);
                                        Object[] objArr4 = new Object[6];
                                        objArr4[0] = "entryName";
                                        objArr4[c11] = name;
                                        objArr4[c12] = "libName";
                                        objArr4[c13] = strSubstring;
                                        objArr4[c10] = "numAttempts";
                                        objArr4[5] = numValueOf3;
                                        s.b("NativeLibManager", "unZipLibFile", e, objArr4);
                                        i.a(bufferedOutputStream);
                                        bufferedInputStream = bufferedInputStream2;
                                        i.a(bufferedInputStream);
                                        file = file;
                                        i13 = i14;
                                        i12 = 3;
                                    }
                                } catch (IOException e15) {
                                    e = e15;
                                    c11 = 1;
                                    c12 = 2;
                                    c13 = 3;
                                    bufferedOutputStream = null;
                                    Integer numValueOf4 = Integer.valueOf(i14);
                                    Object[] objArr5 = new Object[6];
                                    objArr5[0] = "entryName";
                                    objArr5[c11] = name;
                                    objArr5[c12] = "libName";
                                    objArr5[c13] = strSubstring;
                                    objArr5[c10] = "numAttempts";
                                    objArr5[5] = numValueOf4;
                                    s.b("NativeLibManager", "unZipLibFile", e, objArr5);
                                    i.a(bufferedOutputStream);
                                    bufferedInputStream = bufferedInputStream2;
                                    i.a(bufferedInputStream);
                                    file = file;
                                    i13 = i14;
                                    i12 = 3;
                                }
                            } catch (IOException e16) {
                                e = e16;
                                c10 = 4;
                            }
                            i.a(bufferedInputStream);
                            file = file;
                            i13 = i14;
                            i12 = 3;
                        } catch (Throwable th3) {
                            th = th3;
                            bufferedOutputStream = null;
                        }
                    }
                    if (!z10) {
                        throw new w(PatchStatus.CODE_LOAD_LIB_UNZIP, "unZipLibFile entryName:" + name);
                    }
                    i10 = 4;
                    i11 = 1;
                    c14 = 2;
                    i12 = 3;
                } else {
                    c14 = 2;
                }
            }
        } catch (w e17) {
            throw e17;
        } catch (Throwable th4) {
            throw new w(PatchStatus.CODE_LOAD_LIB_UNDEFINED, th4);
        }
    }

    public u() {
        ApplicationInfo applicationInfo;
        if (f8489a != null) {
            return;
        }
        try {
            PackageManager packageManager = j.f8458b.getPackageManager();
            if (packageManager != null && (applicationInfo = packageManager.getApplicationInfo(j.f8458b.getBaseContext().getPackageName(), 0)) != null) {
                f8489a = new String[]{(String) e0.a(ApplicationInfo.class, "primaryCpuAbi").get(applicationInfo)};
            }
            s.a("NativeLibManager", "init", "primaryCpuAbis", Arrays.toString(f8489a));
        } catch (Throwable th) {
            s.a("NativeLibManager", "init", th, new Object[0]);
        }
    }

    private Object b(File file) throws Exception {
        Constructor constructorA = e0.a(Class.forName("dalvik.system.DexPathList$NativeLibraryElement"), File.class);
        if (constructorA != null) {
            constructorA.setAccessible(true);
            return constructorA.newInstance(file);
        }
        throw new Exception("make nativeElement fail no such constructor");
    }

    private static Map<String, String> a(String str) throws w {
        String[] strArr = f8489a;
        if (strArr != null && strArr.length != 0) {
            try {
                HashMap map = new HashMap();
                JSONObject jSONObject = new JSONObject(str);
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(next);
                    for (String str2 : f8489a) {
                        for (int i10 = 0; i10 < jSONArrayOptJSONArray.length(); i10++) {
                            String strOptString = jSONArrayOptJSONArray.optString(i10);
                            if (str2.equals(strOptString)) {
                                map.put(next, strOptString);
                                break;
                            }
                        }
                    }
                }
                s.d("NativeLibManager", "getLibPatchMap", "libPatchMap", map);
                return map;
            } catch (JSONException e10) {
                throw new w(PatchStatus.CODE_LOAD_LIB_JSON, e10);
            }
        }
        s.e("NativeLibManager", "getLibPatchMap", "primaryCpuAbis is null");
        throw new w(PatchStatus.CODE_LOAD_LIB_CPUABIS, "primaryCpuAbis is null");
    }

    private static boolean a(String str, File file, Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String str2 = entry.getValue() + File.separator + System.mapLibraryName(entry.getKey());
                if (new File(file, str2).exists()) {
                    return false;
                }
                if (str.endsWith(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean a(String str, File file) throws w {
        s.d("NativeLibManager", "patch", "libDir", file.getAbsolutePath());
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null && fileArrListFiles.length != 0) {
            Map<String, String> mapA = a(str);
            if (fileArrListFiles.length == mapA.keySet().size()) {
                for (String str2 : mapA.keySet()) {
                    int length = fileArrListFiles.length;
                    int i10 = 0;
                    while (true) {
                        if (i10 < length) {
                            if (fileArrListFiles[i10].getName().equals(System.mapLibraryName(str2))) {
                                break;
                            }
                            i10++;
                        }
                    }
                }
                try {
                    ClassLoader classLoader = getClass().getClassLoader();
                    s.d("NativeLibManager", "patch", "inject before classLoader", classLoader);
                    Object obj = a(classLoader, "pathList").get(classLoader);
                    if (!TextUtils.isEmpty(file.getAbsolutePath()) && file.exists()) {
                        int i11 = Build.VERSION.SDK_INT;
                        if (i11 >= 26) {
                            a(obj, "nativeLibraryPathElements", b(file));
                            b(obj, "nativeLibraryDirectories", file);
                        } else if (i11 >= 23) {
                            a(obj, "nativeLibraryPathElements", a(file));
                            b(obj, "nativeLibraryDirectories", file);
                        } else {
                            a(obj, "nativeLibraryDirectories", file);
                        }
                    }
                    s.d("NativeLibManager", "patch", "inject after classLoader", classLoader);
                    return true;
                } catch (Throwable th) {
                    throw new w(136, th);
                }
            }
        }
        throw new w(PatchStatus.CODE_LOAD_LIB_LOST, "lost some libs");
    }

    @TargetApi(18)
    public static void a() throws w {
        try {
            ClassLoader classLoader = u.class.getClassLoader();
            ClassLoader classLoader2 = j.f8458b.getClassLoader();
            if ((classLoader instanceof BaseDexClassLoader) && classLoader2.getClass().getName().startsWith("com.taobao.sophix")) {
                String str = (String) e0.a(BaseDexClassLoader.class, "getLdLibraryPath", new Class[0]).invoke(classLoader, null);
                int i10 = Build.VERSION.SDK_INT;
                if (i10 >= 31) {
                    return;
                }
                Class cls = Boolean.TYPE;
                Class cls2 = Integer.TYPE;
                if (i10 >= 29) {
                    e0.a(Class.forName("com.android.internal.os.ClassLoaderFactory"), "createClassloaderNamespace", ClassLoader.class, cls2, String.class, String.class, cls, String.class).invoke(null, classLoader2, 14, str, null, Boolean.FALSE, null);
                    return;
                }
                if (i10 >= 27) {
                    Method methodA = e0.a(Class.forName("com.android.internal.os.ClassLoaderFactory"), "createClassloaderNamespace", ClassLoader.class, cls2, String.class, String.class, cls, cls);
                    Boolean bool = Boolean.FALSE;
                    methodA.invoke(null, classLoader2, 14, str, null, bool, bool);
                    return;
                } else if (i10 >= 24) {
                    e0.a(Class.forName("com.android.internal.os.PathClassLoaderFactory"), "createClassloaderNamespace", ClassLoader.class, cls2, String.class, String.class, cls).invoke(null, classLoader2, 14, str, null, Boolean.FALSE);
                    return;
                } else {
                    s.d("NativeLibManager", "classloader has processed it", new Object[0]);
                    return;
                }
            }
            s.d("NativeLibManager", "no need to process ld path", new Object[0]);
        } catch (Throwable th) {
            throw new w(PatchStatus.CODE_LOAD_LIB_NS, th);
        }
    }

    private void a(Object obj, String str, Object obj2) throws Exception {
        Field fieldA = a(obj, str);
        Object[] objArr = (Object[]) fieldA.get(obj);
        Object[] objArr2 = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), objArr.length + 1);
        objArr2[0] = obj2;
        System.arraycopy(objArr, 0, objArr2, 1, objArr.length);
        fieldA.set(obj, objArr2);
    }

    private Object a(File file) throws Exception {
        Constructor constructorA = e0.a(Class.forName("dalvik.system.DexPathList$Element"), File.class, Boolean.TYPE, File.class, DexFile.class);
        if (constructorA != null) {
            return constructorA.newInstance(file, Boolean.TRUE, null, null);
        }
        throw new Exception("make nativeElement fail no such constructor");
    }

    private Field a(Object obj, String str) throws Exception {
        for (Class<?> superclass = obj.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
            try {
                return e0.a(superclass, str);
            } catch (NoSuchFieldException unused) {
            }
        }
        throw new Exception("Field " + str + " not found in " + obj.getClass());
    }
}
