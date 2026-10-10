package xe;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
class p {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Map<Class<?>, List<o>> f22255d = new ConcurrentHashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final a[] f22256e = new a[4];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<ze.b> f22257a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f22258b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f22259c;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final List<o> f22260a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Map<Class, Object> f22261b = new HashMap();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Map<String, Class> f22262c = new HashMap();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final StringBuilder f22263d = new StringBuilder(128);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Class<?> f22264e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Class<?> f22265f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        boolean f22266g;

        private boolean b(Method method, Class<?> cls) {
            this.f22263d.setLength(0);
            this.f22263d.append(method.getName());
            StringBuilder sb2 = this.f22263d;
            sb2.append('>');
            sb2.append(cls.getName());
            String string = this.f22263d.toString();
            Class<?> declaringClass = method.getDeclaringClass();
            Class clsPut = this.f22262c.put(string, declaringClass);
            if (clsPut == null || clsPut.isAssignableFrom(declaringClass)) {
                return true;
            }
            this.f22262c.put(string, clsPut);
            return false;
        }

        boolean a(Method method, Class<?> cls) {
            Object objPut = this.f22261b.put(cls, method);
            if (objPut == null) {
                return true;
            }
            if (objPut instanceof Method) {
                if (!b((Method) objPut, cls)) {
                    throw new IllegalStateException();
                }
                this.f22261b.put(cls, this);
            }
            return b(method, cls);
        }

        void c(Class<?> cls) {
            this.f22265f = cls;
            this.f22264e = cls;
            this.f22266g = false;
        }

        void d() {
            if (this.f22266g) {
                this.f22265f = null;
                return;
            }
            Class<? super Object> superclass = this.f22265f.getSuperclass();
            this.f22265f = superclass;
            String name = superclass.getName();
            if (name.startsWith("java.") || name.startsWith("javax.") || name.startsWith("android.") || name.startsWith("androidx.")) {
                this.f22265f = null;
            }
        }

        void e() {
            this.f22260a.clear();
            this.f22261b.clear();
            this.f22262c.clear();
            this.f22263d.setLength(0);
            this.f22264e = null;
            this.f22265f = null;
            this.f22266g = false;
        }

        a() {
        }
    }

    private void d(a aVar) {
        Method[] methods;
        try {
            try {
                methods = aVar.f22265f.getDeclaredMethods();
            } catch (Throwable unused) {
                methods = aVar.f22265f.getMethods();
                aVar.f22266g = true;
            }
            for (Method method : methods) {
                int modifiers = method.getModifiers();
                if ((modifiers & 1) != 0 && (modifiers & 5192) == 0) {
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    if (parameterTypes.length == 1) {
                        m mVar = (m) method.getAnnotation(m.class);
                        if (mVar != null) {
                            Class<?> cls = parameterTypes[0];
                            if (aVar.a(method, cls)) {
                                aVar.f22260a.add(new o(method, cls, mVar.threadMode(), mVar.priority(), mVar.sticky()));
                            }
                        }
                    } else if (this.f22258b && method.isAnnotationPresent(m.class)) {
                        throw new e("@Subscribe method " + (method.getDeclaringClass().getName() + "." + method.getName()) + "must have exactly 1 parameter but has " + parameterTypes.length);
                    }
                } else if (this.f22258b && method.isAnnotationPresent(m.class)) {
                    throw new e((method.getDeclaringClass().getName() + "." + method.getName()) + " is a illegal @Subscribe method: must be public, non-static, and non-abstract");
                }
            }
        } catch (LinkageError e10) {
            String str = "Could not inspect methods of " + aVar.f22265f.getName();
            throw new e(this.f22259c ? str + ". Please consider using EventBus annotation processor to avoid reflection." : str + ". Please make this class visible to EventBus annotation processor to avoid reflection.", e10);
        }
    }

    private List<o> e(a aVar) {
        ArrayList arrayList = new ArrayList(aVar.f22260a);
        aVar.e();
        synchronized (f22256e) {
            for (int i10 = 0; i10 < 4; i10++) {
                try {
                    a[] aVarArr = f22256e;
                    if (aVarArr[i10] == null) {
                        aVarArr[i10] = aVar;
                        break;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return arrayList;
    }

    private a g() {
        synchronized (f22256e) {
            for (int i10 = 0; i10 < 4; i10++) {
                try {
                    a[] aVarArr = f22256e;
                    a aVar = aVarArr[i10];
                    if (aVar != null) {
                        aVarArr[i10] = null;
                        return aVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return new a();
        }
    }

    List<o> a(Class<?> cls) {
        Map<Class<?>, List<o>> map = f22255d;
        List<o> list = map.get(cls);
        if (list != null) {
            return list;
        }
        List<o> listC = this.f22259c ? c(cls) : b(cls);
        if (!listC.isEmpty()) {
            map.put(cls, listC);
            return listC;
        }
        throw new e("Subscriber " + cls + " and its super classes have no public methods with the @Subscribe annotation");
    }

    p(List<ze.b> list, boolean z10, boolean z11) {
        this.f22257a = list;
        this.f22258b = z10;
        this.f22259c = z11;
    }

    private List<o> b(Class<?> cls) {
        a aVarG = g();
        aVarG.c(cls);
        while (aVarG.f22265f != null) {
            f(aVarG);
            d(aVarG);
            aVarG.d();
        }
        return e(aVarG);
    }

    private List<o> c(Class<?> cls) {
        a aVarG = g();
        aVarG.c(cls);
        while (aVarG.f22265f != null) {
            d(aVarG);
            aVarG.d();
        }
        return e(aVarG);
    }

    private ze.a f(a aVar) {
        aVar.getClass();
        List<ze.b> list = this.f22257a;
        if (list != null) {
            Iterator<ze.b> it = list.iterator();
            while (it.hasNext()) {
                it.next().a(aVar.f22265f);
            }
            return null;
        }
        return null;
    }
}
