package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<Method, h0<?>> f18003a = new ConcurrentHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final okhttp3.e.a f18004b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final okhttp3.v f18005c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final List<i.a> f18006d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final List<c.a> f18007e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final Executor f18008f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final boolean f18009g;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final c0 f18010a = c0.f();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Object[] f18011b = new Object[0];

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Class f18012c;

        a(Class cls) {
            this.f18012c = cls;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            if (method.getDeclaringClass() == Object.class) {
                return method.invoke(this, objArr);
            }
            if (objArr == null) {
                objArr = this.f18011b;
            }
            if (this.f18010a.h(method)) {
                return this.f18010a.g(method, this.f18012c, obj, objArr);
            }
            return g0.this.c(method).a(objArr);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final c0 f18014a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private okhttp3.e.a f18015b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private okhttp3.v f18016c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final List<i.a> f18017d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final List<c.a> f18018e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Executor f18019f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f18020g;

        b(c0 c0Var) {
            this.f18017d = new ArrayList();
            this.f18018e = new ArrayList();
            this.f18014a = c0Var;
        }

        public b a(c.a aVar) {
            List<c.a> list = this.f18018e;
            Objects.requireNonNull(aVar, "factory == null");
            list.add(aVar);
            return this;
        }

        public b b(i.a aVar) {
            List<i.a> list = this.f18017d;
            Objects.requireNonNull(aVar, "factory == null");
            list.add(aVar);
            return this;
        }

        public b c(String str) {
            Objects.requireNonNull(str, "baseUrl == null");
            return d(okhttp3.v.h(str));
        }

        public b d(okhttp3.v vVar) {
            Objects.requireNonNull(vVar, "baseUrl == null");
            List<String> listM = vVar.m();
            if ("".equals(listM.get(listM.size() - 1))) {
                this.f18016c = vVar;
                return this;
            }
            throw new IllegalArgumentException("baseUrl must end in /: " + vVar);
        }

        public g0 e() {
            if (this.f18016c == null) {
                throw new IllegalStateException("Base URL required.");
            }
            okhttp3.e.a zVar = this.f18015b;
            if (zVar == null) {
                zVar = new okhttp3.z();
            }
            okhttp3.e.a aVar = zVar;
            Executor executorB = this.f18019f;
            if (executorB == null) {
                executorB = this.f18014a.b();
            }
            Executor executor = executorB;
            ArrayList arrayList = new ArrayList(this.f18018e);
            arrayList.addAll(this.f18014a.a(executor));
            ArrayList arrayList2 = new ArrayList(this.f18017d.size() + 1 + this.f18014a.d());
            arrayList2.add(new retrofit2.a());
            arrayList2.addAll(this.f18017d);
            arrayList2.addAll(this.f18014a.c());
            return new g0(aVar, this.f18016c, Collections.unmodifiableList(arrayList2), Collections.unmodifiableList(arrayList), executor, this.f18020g);
        }

        public b f(okhttp3.e.a aVar) {
            Objects.requireNonNull(aVar, "factory == null");
            this.f18015b = aVar;
            return this;
        }

        public b g(okhttp3.z zVar) {
            Objects.requireNonNull(zVar, "client == null");
            return f(zVar);
        }

        public b() {
            this(c0.f());
        }
    }

    public c<?, ?> a(Type type, Annotation[] annotationArr) {
        return d(null, type, annotationArr);
    }

    public <T> i<T, okhttp3.c0> g(Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        return e(null, type, annotationArr, annotationArr2);
    }

    public <T> i<okhttp3.e0, T> h(Type type, Annotation[] annotationArr) {
        return f(null, type, annotationArr);
    }

    h0<?> c(Method method) {
        h0<?> h0VarB;
        h0<?> h0Var = this.f18003a.get(method);
        if (h0Var != null) {
            return h0Var;
        }
        synchronized (this.f18003a) {
            try {
                h0VarB = this.f18003a.get(method);
                if (h0VarB == null) {
                    h0VarB = h0.b(this, method);
                    this.f18003a.put(method, h0VarB);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return h0VarB;
    }

    public c<?, ?> d(c.a aVar, Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "returnType == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        int iIndexOf = this.f18007e.indexOf(aVar) + 1;
        int size = this.f18007e.size();
        for (int i10 = iIndexOf; i10 < size; i10++) {
            c<?, ?> cVarA = this.f18007e.get(i10).a(type, annotationArr, this);
            if (cVarA != null) {
                return cVarA;
            }
        }
        StringBuilder sb2 = new StringBuilder("Could not locate call adapter for ");
        sb2.append(type);
        sb2.append(".\n");
        if (aVar != null) {
            sb2.append("  Skipped:");
            for (int i11 = 0; i11 < iIndexOf; i11++) {
                sb2.append("\n   * ");
                sb2.append(this.f18007e.get(i11).getClass().getName());
            }
            sb2.append('\n');
        }
        sb2.append("  Tried:");
        int size2 = this.f18007e.size();
        while (iIndexOf < size2) {
            sb2.append("\n   * ");
            sb2.append(this.f18007e.get(iIndexOf).getClass().getName());
            iIndexOf++;
        }
        throw new IllegalArgumentException(sb2.toString());
    }

    public <T> i<T, okhttp3.c0> e(i.a aVar, Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "parameterAnnotations == null");
        Objects.requireNonNull(annotationArr2, "methodAnnotations == null");
        int iIndexOf = this.f18006d.indexOf(aVar) + 1;
        int size = this.f18006d.size();
        for (int i10 = iIndexOf; i10 < size; i10++) {
            i<T, okhttp3.c0> iVar = (i<T, okhttp3.c0>) this.f18006d.get(i10).c(type, annotationArr, annotationArr2, this);
            if (iVar != null) {
                return iVar;
            }
        }
        StringBuilder sb2 = new StringBuilder("Could not locate RequestBody converter for ");
        sb2.append(type);
        sb2.append(".\n");
        if (aVar != null) {
            sb2.append("  Skipped:");
            for (int i11 = 0; i11 < iIndexOf; i11++) {
                sb2.append("\n   * ");
                sb2.append(this.f18006d.get(i11).getClass().getName());
            }
            sb2.append('\n');
        }
        sb2.append("  Tried:");
        int size2 = this.f18006d.size();
        while (iIndexOf < size2) {
            sb2.append("\n   * ");
            sb2.append(this.f18006d.get(iIndexOf).getClass().getName());
            iIndexOf++;
        }
        throw new IllegalArgumentException(sb2.toString());
    }

    public <T> i<okhttp3.e0, T> f(i.a aVar, Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        int iIndexOf = this.f18006d.indexOf(aVar) + 1;
        int size = this.f18006d.size();
        for (int i10 = iIndexOf; i10 < size; i10++) {
            i<okhttp3.e0, T> iVar = (i<okhttp3.e0, T>) this.f18006d.get(i10).d(type, annotationArr, this);
            if (iVar != null) {
                return iVar;
            }
        }
        StringBuilder sb2 = new StringBuilder("Could not locate ResponseBody converter for ");
        sb2.append(type);
        sb2.append(".\n");
        if (aVar != null) {
            sb2.append("  Skipped:");
            for (int i11 = 0; i11 < iIndexOf; i11++) {
                sb2.append("\n   * ");
                sb2.append(this.f18006d.get(i11).getClass().getName());
            }
            sb2.append('\n');
        }
        sb2.append("  Tried:");
        int size2 = this.f18006d.size();
        while (iIndexOf < size2) {
            sb2.append("\n   * ");
            sb2.append(this.f18006d.get(iIndexOf).getClass().getName());
            iIndexOf++;
        }
        throw new IllegalArgumentException(sb2.toString());
    }

    public <T> i<T, String> i(Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        int size = this.f18006d.size();
        for (int i10 = 0; i10 < size; i10++) {
            i<T, String> iVar = (i<T, String>) this.f18006d.get(i10).e(type, annotationArr, this);
            if (iVar != null) {
                return iVar;
            }
        }
        return retrofit2.a.d.f17942a;
    }

    g0(okhttp3.e.a aVar, okhttp3.v vVar, List<i.a> list, List<c.a> list2, Executor executor, boolean z10) {
        this.f18004b = aVar;
        this.f18005c = vVar;
        this.f18006d = list;
        this.f18007e = list2;
        this.f18008f = executor;
        this.f18009g = z10;
    }

    private void j(Class<?> cls) {
        if (cls.isInterface()) {
            ArrayDeque arrayDeque = new ArrayDeque(1);
            arrayDeque.add(cls);
            while (!arrayDeque.isEmpty()) {
                Class<?> cls2 = (Class) arrayDeque.removeFirst();
                if (cls2.getTypeParameters().length != 0) {
                    StringBuilder sb2 = new StringBuilder("Type parameters are unsupported on ");
                    sb2.append(cls2.getName());
                    if (cls2 != cls) {
                        sb2.append(" which is an interface of ");
                        sb2.append(cls.getName());
                    }
                    throw new IllegalArgumentException(sb2.toString());
                }
                Collections.addAll(arrayDeque, cls2.getInterfaces());
            }
            if (this.f18009g) {
                c0 c0VarF = c0.f();
                for (Method method : cls.getDeclaredMethods()) {
                    if (!c0VarF.h(method) && !Modifier.isStatic(method.getModifiers())) {
                        c(method);
                    }
                }
                return;
            }
            return;
        }
        throw new IllegalArgumentException("API declarations must be interfaces.");
    }

    public <T> T b(Class<T> cls) {
        j(cls);
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new a(cls));
    }
}
