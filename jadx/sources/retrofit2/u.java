package retrofit2;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
abstract class u<T> {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a extends u<Iterable<T>> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.u
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(d0 d0Var, Iterable<T> iterable) {
            if (iterable == null) {
                return;
            }
            Iterator<T> it = iterable.iterator();
            while (it.hasNext()) {
                u.this.a(d0Var, it.next());
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b extends u<Object> {
        b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // retrofit2.u
        void a(d0 d0Var, Object obj) {
            if (obj == null) {
                return;
            }
            int length = Array.getLength(obj);
            for (int i10 = 0; i10 < length; i10++) {
                u.this.a(d0Var, Array.get(obj, i10));
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class d<T> extends u<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f18089a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final retrofit2.i<T, String> f18090b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f18091c;

        @Override // retrofit2.u
        void a(d0 d0Var, T t10) {
            String strA;
            if (t10 == null || (strA = this.f18090b.a(t10)) == null) {
                return;
            }
            d0Var.a(this.f18089a, strA, this.f18091c);
        }

        d(String str, retrofit2.i<T, String> iVar, boolean z10) {
            Objects.requireNonNull(str, "name == null");
            this.f18089a = str;
            this.f18090b = iVar;
            this.f18091c = z10;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class f<T> extends u<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f18096a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final retrofit2.i<T, String> f18097b;

        @Override // retrofit2.u
        void a(d0 d0Var, T t10) {
            String strA;
            if (t10 == null || (strA = this.f18097b.a(t10)) == null) {
                return;
            }
            d0Var.b(this.f18096a, strA);
        }

        f(String str, retrofit2.i<T, String> iVar) {
            Objects.requireNonNull(str, "name == null");
            this.f18096a = str;
            this.f18097b = iVar;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class h extends u<okhttp3.u> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Method f18101a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f18102b;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.u
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(d0 d0Var, okhttp3.u uVar) {
            if (uVar == null) {
                throw k0.o(this.f18101a, this.f18102b, "Headers parameter must not be null.", new Object[0]);
            }
            d0Var.c(uVar);
        }

        h(Method method, int i10) {
            this.f18101a = method;
            this.f18102b = i10;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class i<T> extends u<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Method f18103a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f18104b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final okhttp3.u f18105c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final retrofit2.i<T, okhttp3.c0> f18106d;

        @Override // retrofit2.u
        void a(d0 d0Var, T t10) {
            if (t10 == null) {
                return;
            }
            try {
                d0Var.d(this.f18105c, this.f18106d.a(t10));
            } catch (IOException e10) {
                throw k0.o(this.f18103a, this.f18104b, "Unable to convert " + t10 + " to RequestBody", e10);
            }
        }

        i(Method method, int i10, okhttp3.u uVar, retrofit2.i<T, okhttp3.c0> iVar) {
            this.f18103a = method;
            this.f18104b = i10;
            this.f18105c = uVar;
            this.f18106d = iVar;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class k<T> extends u<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Method f18111a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f18112b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f18113c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final retrofit2.i<T, String> f18114d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final boolean f18115e;

        @Override // retrofit2.u
        void a(d0 d0Var, T t10) {
            if (t10 != null) {
                d0Var.f(this.f18113c, this.f18114d.a(t10), this.f18115e);
                return;
            }
            throw k0.o(this.f18111a, this.f18112b, "Path parameter \"" + this.f18113c + "\" value must not be null.", new Object[0]);
        }

        k(Method method, int i10, String str, retrofit2.i<T, String> iVar, boolean z10) {
            this.f18111a = method;
            this.f18112b = i10;
            Objects.requireNonNull(str, "name == null");
            this.f18113c = str;
            this.f18114d = iVar;
            this.f18115e = z10;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class l<T> extends u<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f18116a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final retrofit2.i<T, String> f18117b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f18118c;

        @Override // retrofit2.u
        void a(d0 d0Var, T t10) {
            String strA;
            if (t10 == null || (strA = this.f18117b.a(t10)) == null) {
                return;
            }
            d0Var.g(this.f18116a, strA, this.f18118c);
        }

        l(String str, retrofit2.i<T, String> iVar, boolean z10) {
            Objects.requireNonNull(str, "name == null");
            this.f18116a = str;
            this.f18117b = iVar;
            this.f18118c = z10;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class n<T> extends u<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final retrofit2.i<T, String> f18123a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f18124b;

        @Override // retrofit2.u
        void a(d0 d0Var, T t10) {
            if (t10 == null) {
                return;
            }
            d0Var.g(this.f18123a.a(t10), null, this.f18124b);
        }

        n(retrofit2.i<T, String> iVar, boolean z10) {
            this.f18123a = iVar;
            this.f18124b = z10;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class o extends u<okhttp3.y.c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final o f18125a = new o();

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.u
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(d0 d0Var, okhttp3.y.c cVar) {
            if (cVar != null) {
                d0Var.e(cVar);
            }
        }

        private o() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class p extends u<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Method f18126a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f18127b;

        @Override // retrofit2.u
        void a(d0 d0Var, Object obj) {
            if (obj == null) {
                throw k0.o(this.f18126a, this.f18127b, "@Url parameter is null.", new Object[0]);
            }
            d0Var.m(obj);
        }

        p(Method method, int i10) {
            this.f18126a = method;
            this.f18127b = i10;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class q<T> extends u<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Class<T> f18128a;

        @Override // retrofit2.u
        void a(d0 d0Var, T t10) {
            d0Var.h(this.f18128a, t10);
        }

        q(Class<T> cls) {
            this.f18128a = cls;
        }
    }

    abstract void a(d0 d0Var, T t10);

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class c<T> extends u<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Method f18086a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f18087b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final retrofit2.i<T, okhttp3.c0> f18088c;

        @Override // retrofit2.u
        void a(d0 d0Var, T t10) {
            if (t10 == null) {
                throw k0.o(this.f18086a, this.f18087b, "Body parameter value must not be null.", new Object[0]);
            }
            try {
                d0Var.l(this.f18088c.a(t10));
            } catch (IOException e10) {
                throw k0.p(this.f18086a, e10, this.f18087b, "Unable to convert " + t10 + " to RequestBody", new Object[0]);
            }
        }

        c(Method method, int i10, retrofit2.i<T, okhttp3.c0> iVar) {
            this.f18086a = method;
            this.f18087b = i10;
            this.f18088c = iVar;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class e<T> extends u<Map<String, T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Method f18092a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f18093b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final retrofit2.i<T, String> f18094c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f18095d;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.u
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(d0 d0Var, Map<String, T> map) {
            if (map == null) {
                throw k0.o(this.f18092a, this.f18093b, "Field map was null.", new Object[0]);
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw k0.o(this.f18092a, this.f18093b, "Field map contained null key.", new Object[0]);
                }
                T value = entry.getValue();
                if (value == null) {
                    throw k0.o(this.f18092a, this.f18093b, "Field map contained null value for key '" + key + "'.", new Object[0]);
                }
                String strA = this.f18094c.a(value);
                if (strA == null) {
                    throw k0.o(this.f18092a, this.f18093b, "Field map value '" + value + "' converted to null by " + this.f18094c.getClass().getName() + " for key '" + key + "'.", new Object[0]);
                }
                d0Var.a(key, strA, this.f18095d);
            }
        }

        e(Method method, int i10, retrofit2.i<T, String> iVar, boolean z10) {
            this.f18092a = method;
            this.f18093b = i10;
            this.f18094c = iVar;
            this.f18095d = z10;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class g<T> extends u<Map<String, T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Method f18098a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f18099b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final retrofit2.i<T, String> f18100c;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.u
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(d0 d0Var, Map<String, T> map) {
            if (map == null) {
                throw k0.o(this.f18098a, this.f18099b, "Header map was null.", new Object[0]);
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw k0.o(this.f18098a, this.f18099b, "Header map contained null key.", new Object[0]);
                }
                T value = entry.getValue();
                if (value == null) {
                    throw k0.o(this.f18098a, this.f18099b, "Header map contained null value for key '" + key + "'.", new Object[0]);
                }
                d0Var.b(key, this.f18100c.a(value));
            }
        }

        g(Method method, int i10, retrofit2.i<T, String> iVar) {
            this.f18098a = method;
            this.f18099b = i10;
            this.f18100c = iVar;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class j<T> extends u<Map<String, T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Method f18107a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f18108b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final retrofit2.i<T, okhttp3.c0> f18109c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f18110d;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.u
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(d0 d0Var, Map<String, T> map) {
            if (map == null) {
                throw k0.o(this.f18107a, this.f18108b, "Part map was null.", new Object[0]);
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw k0.o(this.f18107a, this.f18108b, "Part map contained null key.", new Object[0]);
                }
                T value = entry.getValue();
                if (value == null) {
                    throw k0.o(this.f18107a, this.f18108b, "Part map contained null value for key '" + key + "'.", new Object[0]);
                }
                d0Var.d(okhttp3.u.i("Content-Disposition", "form-data; name=\"" + key + "\"", "Content-Transfer-Encoding", this.f18110d), this.f18109c.a(value));
            }
        }

        j(Method method, int i10, retrofit2.i<T, okhttp3.c0> iVar, String str) {
            this.f18107a = method;
            this.f18108b = i10;
            this.f18109c = iVar;
            this.f18110d = str;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class m<T> extends u<Map<String, T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Method f18119a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f18120b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final retrofit2.i<T, String> f18121c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f18122d;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.u
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(d0 d0Var, Map<String, T> map) {
            if (map == null) {
                throw k0.o(this.f18119a, this.f18120b, "Query map was null", new Object[0]);
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw k0.o(this.f18119a, this.f18120b, "Query map contained null key.", new Object[0]);
                }
                T value = entry.getValue();
                if (value == null) {
                    throw k0.o(this.f18119a, this.f18120b, "Query map contained null value for key '" + key + "'.", new Object[0]);
                }
                String strA = this.f18121c.a(value);
                if (strA == null) {
                    throw k0.o(this.f18119a, this.f18120b, "Query map value '" + value + "' converted to null by " + this.f18121c.getClass().getName() + " for key '" + key + "'.", new Object[0]);
                }
                d0Var.g(key, strA, this.f18122d);
            }
        }

        m(Method method, int i10, retrofit2.i<T, String> iVar, boolean z10) {
            this.f18119a = method;
            this.f18120b = i10;
            this.f18121c = iVar;
            this.f18122d = z10;
        }
    }

    final u<Object> b() {
        return new b();
    }

    final u<Iterable<T>> c() {
        return new a();
    }

    u() {
    }
}
