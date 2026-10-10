package retrofit2;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
class c0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final c0 f17945c = e();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f17946a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Constructor<MethodHandles.Lookup> f17947b;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class a extends c0 {

        /* JADX INFO: renamed from: retrofit2.c0$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        static final class ExecutorC0348a implements Executor {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Handler f17948a = new Handler(Looper.getMainLooper());

            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                this.f17948a.post(runnable);
            }

            ExecutorC0348a() {
            }
        }

        a() {
            super(Build.VERSION.SDK_INT >= 24);
        }

        @Override // retrofit2.c0
        public Executor b() {
            return new ExecutorC0348a();
        }

        @Override // retrofit2.c0
        Object g(Method method, Class<?> cls, Object obj, Object... objArr) {
            if (Build.VERSION.SDK_INT >= 26) {
                return super.g(method, cls, obj, objArr);
            }
            throw new UnsupportedOperationException("Calling default methods on API 24 and 25 is not supported");
        }
    }

    Executor b() {
        return null;
    }

    private static c0 e() {
        return "Dalvik".equals(System.getProperty("java.vm.name")) ? new a() : new c0(true);
    }

    static c0 f() {
        return f17945c;
    }

    List<? extends c.a> a(Executor executor) {
        j jVar = new j(executor);
        return this.f17946a ? Arrays.asList(h.f18021a, jVar) : Collections.singletonList(jVar);
    }

    List<? extends i.a> c() {
        return this.f17946a ? Collections.singletonList(t.f18082a) : Collections.EMPTY_LIST;
    }

    int d() {
        return this.f17946a ? 1 : 0;
    }

    @IgnoreJRERequirement
    Object g(Method method, Class<?> cls, Object obj, Object... objArr) {
        Constructor<MethodHandles.Lookup> constructor = this.f17947b;
        return (constructor != null ? w.a(constructor.newInstance(cls, -1)) : MethodHandles.lookup()).unreflectSpecial(method, cls).bindTo(obj).invokeWithArguments(objArr);
    }

    @IgnoreJRERequirement
    boolean h(Method method) {
        return this.f17946a && method.isDefault();
    }

    c0(boolean z10) {
        this.f17946a = z10;
        Constructor<MethodHandles.Lookup> declaredConstructor = null;
        if (z10) {
            try {
                declaredConstructor = v.a().getDeclaredConstructor(Class.class, Integer.TYPE);
                declaredConstructor.setAccessible(true);
            } catch (NoClassDefFoundError | NoSuchMethodException unused) {
            }
        }
        this.f17947b = declaredConstructor;
    }
}
