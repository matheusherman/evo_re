package com.google.common.base;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class r {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class a<T> implements q<T>, Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        volatile transient boolean f4577a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        transient T f4578b;
        final q<T> delegate;

        @Override // com.google.common.base.q
        public T get() {
            if (!this.f4577a) {
                synchronized (this) {
                    try {
                        if (!this.f4577a) {
                            T t10 = this.delegate.get();
                            this.f4578b = t10;
                            this.f4577a = true;
                            return t10;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return (T) j.a(this.f4578b);
        }

        public String toString() {
            Object obj;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Suppliers.memoize(");
            if (this.f4577a) {
                obj = "<supplier that returned " + this.f4578b + ">";
            } else {
                obj = this.delegate;
            }
            sb2.append(obj);
            sb2.append(")");
            return sb2.toString();
        }

        a(q<T> qVar) {
            this.delegate = (q) m.i(qVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class b<T> implements q<T> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final q<Void> f4579c = new q() { // from class: com.google.common.base.s
            @Override // com.google.common.base.q
            public final Object get() {
                return r.b.a();
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private volatile q<T> f4580a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private T f4581b;

        public static /* synthetic */ Void a() {
            throw new IllegalStateException();
        }

        @Override // com.google.common.base.q
        public T get() {
            q<T> qVar = this.f4580a;
            q<T> qVar2 = (q<T>) f4579c;
            if (qVar != qVar2) {
                synchronized (this) {
                    try {
                        if (this.f4580a != qVar2) {
                            T t10 = this.f4580a.get();
                            this.f4581b = t10;
                            this.f4580a = qVar2;
                            return t10;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return (T) j.a(this.f4581b);
        }

        public String toString() {
            Object obj = this.f4580a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Suppliers.memoize(");
            if (obj == f4579c) {
                obj = "<supplier that returned " + this.f4581b + ">";
            }
            sb2.append(obj);
            sb2.append(")");
            return sb2.toString();
        }

        b(q<T> qVar) {
            this.f4580a = (q) m.i(qVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class c<T> implements q<T>, Serializable {
        private static final long serialVersionUID = 0;
        final T instance;

        public boolean equals(Object obj) {
            if (obj instanceof c) {
                return k.a(this.instance, ((c) obj).instance);
            }
            return false;
        }

        @Override // com.google.common.base.q
        public T get() {
            return this.instance;
        }

        public int hashCode() {
            return k.b(this.instance);
        }

        public String toString() {
            return "Suppliers.ofInstance(" + this.instance + ")";
        }

        c(T t10) {
            this.instance = t10;
        }
    }

    public static <T> q<T> a(q<T> qVar) {
        if ((qVar instanceof b) || (qVar instanceof a)) {
            return qVar;
        }
        return qVar instanceof Serializable ? new a(qVar) : new b(qVar);
    }

    public static <T> q<T> b(T t10) {
        return new c(t10);
    }
}
