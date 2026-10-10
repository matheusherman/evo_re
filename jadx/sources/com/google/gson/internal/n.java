package com.google.gson.internal;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public abstract class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f4916a = c();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a extends n {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Method f4917b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Object f4918c;

        a(Method method, Object obj) {
            this.f4917b = method;
            this.f4918c = obj;
        }

        @Override // com.google.gson.internal.n
        public <T> T d(Class<T> cls) {
            n.b(cls);
            return (T) this.f4917b.invoke(this.f4918c, cls);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b extends n {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Method f4919b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f4920c;

        b(Method method, int i10) {
            this.f4919b = method;
            this.f4920c = i10;
        }

        @Override // com.google.gson.internal.n
        public <T> T d(Class<T> cls) {
            n.b(cls);
            return (T) this.f4919b.invoke(null, cls, Integer.valueOf(this.f4920c));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class c extends n {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Method f4921b;

        c(Method method) {
            this.f4921b = method;
        }

        @Override // com.google.gson.internal.n
        public <T> T d(Class<T> cls) {
            n.b(cls);
            return (T) this.f4921b.invoke(null, cls, Object.class);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class d extends n {
        @Override // com.google.gson.internal.n
        public <T> T d(Class<T> cls) {
            throw new UnsupportedOperationException("Cannot allocate " + cls + ". Usage of JDK sun.misc.Unsafe is enabled, but it could not be used. Make sure your runtime is configured correctly.");
        }

        d() {
        }
    }

    public abstract <T> T d(Class<T> cls);

    private static n c() {
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return new a(cls.getMethod("allocateInstance", Class.class), declaredField.get(null));
        } catch (Exception unused) {
            try {
                try {
                    Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
                    declaredMethod.setAccessible(true);
                    int iIntValue = ((Integer) declaredMethod.invoke(null, Object.class)).intValue();
                    Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
                    declaredMethod2.setAccessible(true);
                    return new b(declaredMethod2, iIntValue);
                } catch (Exception unused2) {
                    Method declaredMethod3 = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                    declaredMethod3.setAccessible(true);
                    return new c(declaredMethod3);
                }
            } catch (Exception unused3) {
                return new d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Class<?> cls) {
        String strA = com.google.gson.internal.c.a(cls);
        if (strA == null) {
            return;
        }
        throw new AssertionError("UnsafeAllocator is used for non-instantiable type: " + strA);
    }
}
