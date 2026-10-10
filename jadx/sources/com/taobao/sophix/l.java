package com.taobao.sophix;

import dalvik.system.DexFile;
import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
class l extends ClassLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Method f8473a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Method f8474b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ClassLoader f8475c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private DexFile f8476d;

    @Override // java.lang.ClassLoader
    protected String findLibrary(String str) {
        try {
            File file = new File(j.f8461e, "lib" + str + ".so");
            if (!file.exists()) {
                i.a(new File((String) this.f8474b.invoke(getParent(), str)), file);
            }
            return file.getAbsolutePath();
        } catch (Throwable th) {
            s.a("HotClassLoader", "findLibrary", th, new Object[0]);
            return null;
        }
    }

    @Override // java.lang.ClassLoader
    public URL findResource(String str) {
        try {
            return (URL) this.f8473a.invoke(this.f8475c, str);
        } catch (Exception e10) {
            s.a("HotClassLoader", "findResource", e10, new Object[0]);
            return null;
        }
    }

    public l(ClassLoader classLoader) throws w {
        super(classLoader);
        this.f8475c = classLoader;
        try {
            this.f8474b = e0.a(ClassLoader.class, "findLibrary", String.class);
            this.f8473a = e0.a(ClassLoader.class, "findResource", String.class);
        } catch (NoSuchMethodException e10) {
            throw new w(84, e10);
        }
    }

    public void a(DexFile dexFile) {
        this.f8476d = dexFile;
    }

    @Override // java.lang.ClassLoader
    public Package getPackage(String str) throws Throwable {
        if (str == null || str.isEmpty()) {
            return null;
        }
        synchronized (this) {
            try {
                try {
                    Package packageDefinePackage = super.getPackage(str);
                    if (packageDefinePackage == null) {
                        packageDefinePackage = definePackage(str, "Unknown", "0.0", "Unknown", "Unknown", "0.0", "Unknown", null);
                    }
                    return packageDefinePackage;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        }
    }

    @Override // java.lang.ClassLoader
    public Class<?> loadClass(String str) {
        Class<?> clsFindLoadedClass = findLoadedClass(str);
        if (clsFindLoadedClass != null && clsFindLoadedClass.getClassLoader() == this) {
            return clsFindLoadedClass;
        }
        Class<?> clsLoadClass = this.f8476d.loadClass(str, this);
        if (clsLoadClass != null) {
            s.a("HotClassLoader", "loadClass", "clazzPatch", str);
            return clsLoadClass;
        }
        return getParent().loadClass(str);
    }
}
