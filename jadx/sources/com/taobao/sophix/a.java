package com.taobao.sophix;

import android.annotation.TargetApi;
import android.app.Application;
import android.os.Build;
import com.taobao.sophix.core.dex.ILibPathLoader;
import com.taobao.sophix.core.dex.SophixNative;
import dalvik.system.BaseDexClassLoader;
import dalvik.system.DexFile;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipFile;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@TargetApi(14)
class a extends PathClassLoader implements ILibPathLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f8391a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Method f8392b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Method f8393c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Method f8394d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Method f8395e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Method f8396f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Method f8397g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ClassLoader f8398h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ClassLoader f8399i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private List<DexFile> f8400j;

    private Object a(Application application) {
        return e0.a(Class.class.getClass(), "dexCache").get(application.getClass());
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public String findLibrary(String str) {
        try {
            return (String) this.f8393c.invoke(this.f8398h, str);
        } catch (Exception e10) {
            s.a("ColdClassLoader", "findLibrary", e10, new Object[0]);
            return null;
        }
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public Package getPackage(String str) {
        try {
            return (Package) this.f8397g.invoke(this.f8398h, str);
        } catch (Exception e10) {
            s.a("ColdClassLoader", "getPackage", e10, new Object[0]);
            return null;
        }
    }

    private void a() throws IllegalAccessException, NoSuchFieldException {
        Field fieldA = e0.a(Class.class.getClass(), "classLoader");
        Iterator<Class> it = b.f().iterator();
        while (it.hasNext()) {
            fieldA.set(it.next(), this);
        }
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public URL findResource(String str) {
        try {
            if (new ZipFile(j.f8459c.getPath()).getEntry(str) != null) {
                return new URL("jar:" + j.f8459c.toURI().toURL() + "!/" + str);
            }
            URL url = (URL) this.f8392b.invoke(this.f8398h, str);
            if (url != null) {
                return url;
            }
            s.e("ColdClassLoader", "findResource don't find " + str, new Object[0]);
            return null;
        } catch (Exception e10) {
            s.b("ColdClassLoader", "findResource", e10, new Object[0]);
        }
    }

    @Override // com.taobao.sophix.core.dex.ILibPathLoader
    public String getLdLibraryPath() {
        if (this.f8398h instanceof BaseDexClassLoader) {
            try {
                return (String) e0.a(BaseDexClassLoader.class, "getLdLibraryPath", new Class[0]).invoke(this.f8398h, null);
            } catch (Exception e10) {
                s.a("ColdClassLoader", "getLdLibraryPath", e10, new Object[0]);
            }
        }
        return null;
    }

    a(ClassLoader classLoader) throws w {
        boolean z10;
        boolean z11;
        ClassLoader classLoader2;
        super("", classLoader.getParent());
        this.f8400j = new ArrayList();
        try {
            synchronized (classLoader) {
                e0.a(ClassLoader.class, "parent").set(classLoader, this);
            }
            this.f8398h = classLoader;
            boolean z12 = true;
            this.f8393c = e0.a(ClassLoader.class, "findLibrary", String.class);
            this.f8394d = e0.a(ClassLoader.class, "findClass", String.class);
            this.f8392b = e0.a(ClassLoader.class, "findResource", String.class);
            this.f8395e = e0.a(ClassLoader.class, "findLoadedClass", String.class);
            this.f8397g = e0.a(ClassLoader.class, "getPackage", String.class);
            this.f8396f = e0.a(ClassLoader.class, "findResources", String.class);
            if (Build.BRAND.equals("zaszun#".replace("s", "m").replace("z", "s").replace("#", "g")) && Build.VERSION.SDK_INT == 21) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (Build.VERSION.SDK_INT >= 24) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (h.a() || (!z11 && !z10 && !j.f8462f)) {
                z12 = false;
            }
            this.f8391a = z12;
            if (z12) {
                classLoader2 = this;
            } else {
                classLoader2 = this.f8398h;
            }
            this.f8399i = classLoader2;
            if (z12) {
                Object obj = e0.a(e0.f8442a, "mPackageInfo").get(j.f8458b.getBaseContext());
                e0.a(obj.getClass(), "mClassLoader").set(obj, this);
                Thread.currentThread().setContextClassLoader(this);
                if (z11) {
                    if (b.d()) {
                        a(a(j.f8458b));
                        a();
                        return;
                    }
                    return;
                }
                if (z10) {
                    b(a(j.f8458b));
                    a();
                }
            }
        } catch (IllegalAccessException e10) {
            throw new w(86, e10);
        } catch (NoSuchFieldException e11) {
            throw new w(85, e11);
        } catch (NoSuchMethodException e12) {
            throw new w(84, e12);
        }
    }

    private void b(Object obj) throws w {
        try {
            Object[] objArr = (Object[]) e0.a(obj.getClass(), "resolvedTypes").get(obj);
            List<Class> listF = b.f();
            for (int i10 = 0; i10 < objArr.length; i10++) {
                if (a((Class) objArr[i10], listF)) {
                    objArr[i10] = null;
                }
            }
        } catch (IllegalAccessException e10) {
            throw new w(86, e10);
        } catch (NoSuchFieldException e11) {
            throw new w(85, e11);
        }
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public Class<?> findClass(String str) throws ClassNotFoundException {
        boolean zA = a(str);
        if (this.f8391a) {
            try {
                Class<?> cls = (Class) this.f8395e.invoke(this.f8398h, str);
                if (cls != null) {
                    if (!zA) {
                        Iterator<Class> it = b.f().iterator();
                        while (it.hasNext()) {
                            if (it.next().equals(cls)) {
                            }
                        }
                    }
                    return cls;
                }
            } catch (Exception e10) {
                if (((i0) SophixManager.getInstance()).b()) {
                    s.a("ColdClassLoader", "findClass fail to find loaded class: " + str, e10);
                }
            }
        }
        if (zA) {
            try {
                return (Class) this.f8394d.invoke(this.f8398h, str);
            } catch (Exception e11) {
                if (((i0) SophixManager.getInstance()).b()) {
                    s.b("ColdClassLoader", "findClass fail to find kept class: " + str, e11, new Object[0]);
                }
            }
        }
        Iterator<DexFile> it2 = this.f8400j.iterator();
        while (it2.hasNext()) {
            Class<?> clsLoadClass = it2.next().loadClass(str, this.f8399i);
            if (clsLoadClass != null) {
                return clsLoadClass;
            }
        }
        try {
            Class<?> cls2 = (Class) this.f8394d.invoke(this.f8398h, str);
            if (cls2 != null) {
                return cls2;
            }
        } catch (Exception e12) {
            if (((i0) SophixManager.getInstance()).b()) {
                s.b("ColdClassLoader", "findClass fail to find: " + str, e12, new Object[0]);
            }
        }
        try {
            Class<?> clsFindClass = super.findClass(str);
            if (clsFindClass != null) {
                return clsFindClass;
            }
        } catch (Exception e13) {
            if (((i0) SophixManager.getInstance()).b()) {
                s.b("ColdClassLoader", "super findClass fail to find: " + str, e13, new Object[0]);
            }
        }
        throw new ClassNotFoundException();
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    protected Enumeration<URL> findResources(String str) {
        Enumeration<URL> enumerationFindResources = super.findResources(str);
        if (enumerationFindResources != null && enumerationFindResources.hasMoreElements()) {
            return enumerationFindResources;
        }
        try {
            Enumeration<URL> enumeration = (Enumeration) this.f8396f.invoke(this.f8398h, str);
            if (enumeration != null && enumeration.hasMoreElements()) {
                return enumeration;
            }
            return enumerationFindResources;
        } catch (Exception e10) {
            s.a("ColdClassLoader", "getResources appClassLoader name:" + str, e10, new Object[0]);
            return enumerationFindResources;
        }
    }

    private void a(Object obj) throws w {
        if (!SophixNative.clearResolvedCache(new File(j.f8460d, "sophix.mkbm").getPath(), obj)) {
            throw new w(78, "fail to clear cache! abort cold fix");
        }
    }

    private boolean a(Class cls, List<Class> list) {
        return (cls == null || cls.getClassLoader() == null || !cls.getClassLoader().equals(getClass().getClassLoader()) || list.contains(cls) || a(cls.getName())) ? false : true;
    }

    private boolean a(String str) {
        return str.startsWith("com.taobao.sophix.") || str.startsWith("com.ali.fixHelper");
    }

    void a(File file) throws w {
        s.d("ColdClassLoader", "addDexFile", file.getName());
        try {
            file.setReadOnly();
            this.f8400j.add(DexFile.loadDex(file.getPath(), b.a(file.getPath()), 0));
        } catch (IOException e10) {
            throw new w(81, e10);
        }
    }
}
