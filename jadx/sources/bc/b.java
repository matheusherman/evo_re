package bc;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class b extends c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f1049e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f1050f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected String[] f1051g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Class<?> f1052h;

    public static String q(Object obj, d dVar) {
        return r(obj, dVar, false, false, null);
    }

    public static <T> String r(T t10, d dVar, boolean z10, boolean z11, Class<? super T> cls) {
        return new b(t10, dVar, null, cls, z10, z11).toString();
    }

    public Class<?> i() {
        return this.f1052h;
    }

    public boolean k() {
        return this.f1049e;
    }

    public boolean l() {
        return this.f1050f;
    }

    public void n(boolean z10) {
        this.f1049e = z10;
    }

    public void o(boolean z10) {
        this.f1050f = z10;
    }

    public void p(Class<?> cls) {
        Object objC;
        if (cls != null && (objC = c()) != null && !cls.isInstance(objC)) {
            throw new IllegalArgumentException("Specified class is not a superclass of the object");
        }
        this.f1052h = cls;
    }

    public <T> b(T t10, d dVar, StringBuffer stringBuffer, Class<? super T> cls, boolean z10, boolean z11) {
        super(t10, dVar, stringBuffer);
        this.f1049e = false;
        this.f1050f = false;
        this.f1052h = null;
        p(cls);
        o(z10);
        n(z11);
    }

    protected boolean g(Field field) {
        if (field.getName().indexOf(36) != -1) {
            return false;
        }
        if (Modifier.isTransient(field.getModifiers()) && !l()) {
            return false;
        }
        if (Modifier.isStatic(field.getModifiers()) && !k()) {
            return false;
        }
        String[] strArr = this.f1051g;
        if (strArr != null && Arrays.binarySearch(strArr, field.getName()) >= 0) {
            return false;
        }
        return true;
    }

    protected void h(Class<?> cls) {
        if (cls.isArray()) {
            m(c());
            return;
        }
        Field[] declaredFields = cls.getDeclaredFields();
        AccessibleObject.setAccessible(declaredFields, true);
        for (Field field : declaredFields) {
            String name = field.getName();
            if (g(field)) {
                try {
                    a(name, j(field));
                } catch (IllegalAccessException e10) {
                    throw new InternalError("Unexpected IllegalAccessException: " + e10.getMessage());
                }
            }
        }
    }

    protected Object j(Field field) {
        return field.get(c());
    }

    public b m(Object obj) {
        e().Y(d(), null, obj);
        return this;
    }

    @Override // bc.c
    public String toString() {
        if (c() == null) {
            return e().S();
        }
        Class<?> superclass = c().getClass();
        h(superclass);
        while (superclass.getSuperclass() != null && superclass != i()) {
            superclass = superclass.getSuperclass();
            h(superclass);
        }
        return super.toString();
    }
}
