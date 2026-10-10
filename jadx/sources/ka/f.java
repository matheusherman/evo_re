package ka;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class f implements ka.n {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f12181d = ua.n.P0(f.class.getCanonicalName(), ".", "");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ka.n f12182e = new a("NO_LOCKS", InterfaceC0204f.f12191a, ka.e.f12180b);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final ka.k f12183a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final InterfaceC0204f f12184b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f12185c;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class a extends f {
        a(String str, InterfaceC0204f interfaceC0204f, ka.k kVar) {
            super(str, interfaceC0204f, kVar, null);
        }

        private static /* synthetic */ void j(int i10) {
            String str = i10 != 1 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i10 != 1 ? 3 : 2];
            if (i10 != 1) {
                objArr[0] = "source";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$1";
            }
            if (i10 != 1) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$1";
            } else {
                objArr[1] = "recursionDetectedDefault";
            }
            if (i10 != 1) {
                objArr[2] = "recursionDetectedDefault";
            }
            String str2 = String.format(str, objArr);
            if (i10 == 1) {
                throw new IllegalStateException(str2);
            }
        }

        @Override // ka.f
        protected <K, V> o<V> p(String str, K k10) {
            if (str == null) {
                j(0);
            }
            o<V> oVarA = o.a();
            if (oVarA == null) {
                j(1);
            }
            return oVarA;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b<T> extends j<T> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Object f12186d;

        private static /* synthetic */ void a(int i10) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$4", "recursionDetected"));
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(f fVar, c9.a aVar, Object obj) {
            super(fVar, aVar);
            this.f12186d = obj;
        }

        @Override // ka.f.h
        protected o<T> c(boolean z10) {
            o<T> oVarD = o.d(this.f12186d);
            if (oVarD == null) {
                a(0);
            }
            return oVarD;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class c<T> extends k<T> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ c9.l f12188e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ c9.l f12189f;

        private static /* synthetic */ void a(int i10) {
            String str = i10 != 2 ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[i10 != 2 ? 2 : 3];
            if (i10 != 2) {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$5";
            } else {
                objArr[0] = "value";
            }
            if (i10 != 2) {
                objArr[1] = "recursionDetected";
            } else {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$5";
            }
            if (i10 == 2) {
                objArr[2] = "doPostCompute";
            }
            String str2 = String.format(str, objArr);
            if (i10 == 2) {
                throw new IllegalArgumentException(str2);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(f fVar, c9.a aVar, c9.l lVar, c9.l lVar2) {
            super(fVar, aVar);
            this.f12188e = lVar;
            this.f12189f = lVar2;
        }

        @Override // ka.f.h
        protected o<T> c(boolean z10) {
            c9.l lVar = this.f12188e;
            if (lVar == null) {
                o<T> oVarC = super.c(z10);
                if (oVarC == null) {
                    a(0);
                }
                return oVarC;
            }
            o<T> oVarD = o.d(lVar.invoke(Boolean.valueOf(z10)));
            if (oVarD == null) {
                a(1);
            }
            return oVarD;
        }

        @Override // ka.f.i
        protected void e(T t10) {
            if (t10 == null) {
                a(2);
            }
            this.f12189f.invoke(t10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class d<K, V> extends e<K, V> implements ka.a<K, V> {
        /* synthetic */ d(f fVar, ConcurrentMap concurrentMap, a aVar) {
            this(fVar, concurrentMap);
        }

        private static /* synthetic */ void b(int i10) {
            String str = i10 != 3 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i10 != 3 ? 3 : 2];
            if (i10 == 1) {
                objArr[0] = "map";
            } else if (i10 == 2) {
                objArr[0] = "computation";
            } else if (i10 != 3) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNotNullValuesBasedOnMemoizedFunction";
            }
            if (i10 != 3) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNotNullValuesBasedOnMemoizedFunction";
            } else {
                objArr[1] = "computeIfAbsent";
            }
            if (i10 == 2) {
                objArr[2] = "computeIfAbsent";
            } else if (i10 != 3) {
                objArr[2] = "<init>";
            }
            String str2 = String.format(str, objArr);
            if (i10 == 3) {
                throw new IllegalStateException(str2);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private d(f fVar, ConcurrentMap<g<K, V>, Object> concurrentMap) {
            super(fVar, concurrentMap, null);
            if (fVar == null) {
                b(0);
            }
            if (concurrentMap == null) {
                b(1);
            }
        }

        @Override // ka.f.e, ka.a
        public V a(K k10, c9.a<? extends V> aVar) {
            if (aVar == null) {
                b(2);
            }
            V v10 = (V) super.a(k10, aVar);
            if (v10 == null) {
                b(3);
            }
            return v10;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class e<K, V> extends l<g<K, V>, V> implements ka.b<K, V> {
        /* synthetic */ e(f fVar, ConcurrentMap concurrentMap, a aVar) {
            this(fVar, concurrentMap);
        }

        private static /* synthetic */ void b(int i10) {
            Object[] objArr = new Object[3];
            if (i10 == 1) {
                objArr[0] = "map";
            } else if (i10 != 2) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "computation";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNullableValuesBasedOnMemoizedFunction";
            if (i10 != 2) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "computeIfAbsent";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        class a implements c9.l<g<K, V>, V> {
            a() {
            }

            @Override // c9.l
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public V invoke(g<K, V> gVar) {
                return (V) ((g) gVar).f12193b.invoke();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private e(f fVar, ConcurrentMap<g<K, V>, Object> concurrentMap) {
            super(fVar, concurrentMap, new a());
            if (fVar == null) {
                b(0);
            }
            if (concurrentMap == null) {
                b(1);
            }
        }

        public V a(K k10, c9.a<? extends V> aVar) {
            if (aVar == null) {
                b(2);
            }
            return invoke(new g(k10, aVar));
        }
    }

    /* JADX INFO: renamed from: ka.f$f, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface InterfaceC0204f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final InterfaceC0204f f12191a = new a();

        /* JADX INFO: renamed from: ka.f$f$a */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        static class a implements InterfaceC0204f {
            private static /* synthetic */ void b(int i10) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "throwable", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$ExceptionHandlingStrategy$1", "handleException"));
            }

            @Override // ka.f.InterfaceC0204f
            public RuntimeException a(Throwable th) {
                if (th == null) {
                    b(0);
                }
                throw sa.d.b(th);
            }

            a() {
            }
        }

        RuntimeException a(Throwable th);
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class g<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final K f12192a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final c9.a<? extends V> f12193b;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.f12192a.equals(((g) obj).f12192a);
        }

        public int hashCode() {
            return this.f12192a.hashCode();
        }

        public g(K k10, c9.a<? extends V> aVar) {
            this.f12192a = k10;
            this.f12193b = aVar;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class h<T> implements ka.j<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final f f12194a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final c9.a<? extends T> f12195b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private volatile Object f12196c;

        private static /* synthetic */ void a(int i10) {
            String str = (i10 == 2 || i10 == 3) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i10 == 2 || i10 == 3) ? 2 : 3];
            if (i10 == 1) {
                objArr[0] = "computable";
            } else if (i10 == 2 || i10 == 3) {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValue";
            } else {
                objArr[0] = "storageManager";
            }
            if (i10 == 2) {
                objArr[1] = "recursionDetected";
            } else if (i10 != 3) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValue";
            } else {
                objArr[1] = "renderDebugInformation";
            }
            if (i10 != 2 && i10 != 3) {
                objArr[2] = "<init>";
            }
            String str2 = String.format(str, objArr);
            if (i10 != 2 && i10 != 3) {
                throw new IllegalArgumentException(str2);
            }
            throw new IllegalStateException(str2);
        }

        public h(f fVar, c9.a<? extends T> aVar) {
            if (fVar == null) {
                a(0);
            }
            if (aVar == null) {
                a(1);
            }
            this.f12196c = n.NOT_COMPUTED;
            this.f12194a = fVar;
            this.f12195b = aVar;
        }

        protected o<T> c(boolean z10) {
            o<T> oVarP = this.f12194a.p("in a lazy value", null);
            if (oVarP == null) {
                a(2);
            }
            return oVarP;
        }

        public boolean d() {
            return (this.f12196c == n.NOT_COMPUTED || this.f12196c == n.COMPUTING) ? false : true;
        }

        /* JADX WARN: Code duplicated, block: B:19:0x003e A[Catch: all -> 0x0024, TryCatch #1 {all -> 0x0024, blocks: (B:7:0x0012, B:9:0x0018, B:14:0x0026, B:16:0x002a, B:18:0x0039, B:19:0x003e, B:21:0x0042, B:23:0x004d, B:24:0x0052, B:28:0x0061, B:30:0x0067, B:32:0x006d, B:33:0x0073, B:34:0x007d, B:35:0x007e, B:36:0x0084, B:25:0x0054), top: B:41:0x0012, inners: #0 }] */
        /* JADX WARN: Code duplicated, block: B:21:0x0042 A[Catch: all -> 0x0024, TryCatch #1 {all -> 0x0024, blocks: (B:7:0x0012, B:9:0x0018, B:14:0x0026, B:16:0x002a, B:18:0x0039, B:19:0x003e, B:21:0x0042, B:23:0x004d, B:24:0x0052, B:28:0x0061, B:30:0x0067, B:32:0x006d, B:33:0x0073, B:34:0x007d, B:35:0x007e, B:36:0x0084, B:25:0x0054), top: B:41:0x0012, inners: #0 }] */
        /* JADX WARN: Code duplicated, block: B:23:0x004d A[Catch: all -> 0x0024, TryCatch #1 {all -> 0x0024, blocks: (B:7:0x0012, B:9:0x0018, B:14:0x0026, B:16:0x002a, B:18:0x0039, B:19:0x003e, B:21:0x0042, B:23:0x004d, B:24:0x0052, B:28:0x0061, B:30:0x0067, B:32:0x006d, B:33:0x0073, B:34:0x007d, B:35:0x007e, B:36:0x0084, B:25:0x0054), top: B:41:0x0012, inners: #0 }] */
        /* JADX WARN: Code duplicated, block: B:24:0x0052 A[Catch: all -> 0x0024, TRY_LEAVE, TryCatch #1 {all -> 0x0024, blocks: (B:7:0x0012, B:9:0x0018, B:14:0x0026, B:16:0x002a, B:18:0x0039, B:19:0x003e, B:21:0x0042, B:23:0x004d, B:24:0x0052, B:28:0x0061, B:30:0x0067, B:32:0x006d, B:33:0x0073, B:34:0x007d, B:35:0x007e, B:36:0x0084, B:25:0x0054), top: B:41:0x0012, inners: #0 }] */
        @Override // c9.a
        public T invoke() {
            T tInvoke;
            o<T> oVarC;
            Object obj = this.f12196c;
            if (!(obj instanceof n)) {
                return (T) sa.h.f(obj);
            }
            this.f12194a.f12183a.lock();
            try {
                Object obj2 = this.f12196c;
                if (obj2 instanceof n) {
                    n nVar = n.COMPUTING;
                    if (obj2 == nVar) {
                        this.f12196c = n.RECURSION_WAS_DETECTED;
                        o<T> oVarC2 = c(true);
                        if (!oVarC2.c()) {
                            tInvoke = oVarC2.b();
                        } else if (obj2 == n.RECURSION_WAS_DETECTED) {
                            oVarC = c(false);
                            if (oVarC.c()) {
                                this.f12196c = nVar;
                                try {
                                    tInvoke = this.f12195b.invoke();
                                    b(tInvoke);
                                    this.f12196c = tInvoke;
                                } catch (Throwable th) {
                                    if (sa.d.a(th)) {
                                        this.f12196c = n.NOT_COMPUTED;
                                        throw th;
                                    }
                                    if (this.f12196c == n.COMPUTING) {
                                        this.f12196c = sa.h.c(th);
                                    }
                                    throw this.f12194a.f12184b.a(th);
                                }
                            } else {
                                tInvoke = oVarC.b();
                            }
                        } else {
                            this.f12196c = nVar;
                            tInvoke = this.f12195b.invoke();
                            b(tInvoke);
                            this.f12196c = tInvoke;
                        }
                    } else if (obj2 == n.RECURSION_WAS_DETECTED) {
                        oVarC = c(false);
                        if (oVarC.c()) {
                            tInvoke = oVarC.b();
                        } else {
                            this.f12196c = nVar;
                            tInvoke = this.f12195b.invoke();
                            b(tInvoke);
                            this.f12196c = tInvoke;
                        }
                    } else {
                        this.f12196c = nVar;
                        tInvoke = this.f12195b.invoke();
                        b(tInvoke);
                        this.f12196c = tInvoke;
                    }
                } else {
                    tInvoke = (T) sa.h.f(obj2);
                }
                this.f12194a.f12183a.unlock();
                return tInvoke;
            } catch (Throwable th2) {
                this.f12194a.f12183a.unlock();
                throw th2;
            }
        }

        protected void b(T t10) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static abstract class i<T> extends h<T> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private volatile ka.l<T> f12197d;

        private static /* synthetic */ void a(int i10) {
            Object[] objArr = new Object[3];
            if (i10 != 1) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "computable";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValueWithPostCompute";
            objArr[2] = "<init>";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        protected abstract void e(T t10);

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(f fVar, c9.a<? extends T> aVar) {
            super(fVar, aVar);
            if (fVar == null) {
                a(0);
            }
            if (aVar == null) {
                a(1);
            }
            this.f12197d = null;
        }

        @Override // ka.f.h
        protected final void b(T t10) {
            this.f12197d = new ka.l<>(t10);
            try {
                e(t10);
            } finally {
                this.f12197d = null;
            }
        }

        @Override // ka.f.h, c9.a
        public T invoke() {
            ka.l<T> lVar = this.f12197d;
            return (lVar == null || !lVar.b()) ? (T) super.invoke() : lVar.a();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class j<T> extends h<T> implements ka.i<T> {
        private static /* synthetic */ void a(int i10) {
            String str = i10 != 2 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i10 != 2 ? 3 : 2];
            if (i10 == 1) {
                objArr[0] = "computable";
            } else if (i10 != 2) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValue";
            }
            if (i10 != 2) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValue";
            } else {
                objArr[1] = "invoke";
            }
            if (i10 != 2) {
                objArr[2] = "<init>";
            }
            String str2 = String.format(str, objArr);
            if (i10 == 2) {
                throw new IllegalStateException(str2);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(f fVar, c9.a<? extends T> aVar) {
            super(fVar, aVar);
            if (fVar == null) {
                a(0);
            }
            if (aVar == null) {
                a(1);
            }
        }

        @Override // ka.f.h, c9.a
        public T invoke() {
            T t10 = (T) super.invoke();
            if (t10 == null) {
                a(2);
            }
            return t10;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static abstract class k<T> extends i<T> implements ka.i<T> {
        private static /* synthetic */ void a(int i10) {
            String str = i10 != 2 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i10 != 2 ? 3 : 2];
            if (i10 == 1) {
                objArr[0] = "computable";
            } else if (i10 != 2) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValueWithPostCompute";
            }
            if (i10 != 2) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValueWithPostCompute";
            } else {
                objArr[1] = "invoke";
            }
            if (i10 != 2) {
                objArr[2] = "<init>";
            }
            String str2 = String.format(str, objArr);
            if (i10 == 2) {
                throw new IllegalStateException(str2);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(f fVar, c9.a<? extends T> aVar) {
            super(fVar, aVar);
            if (fVar == null) {
                a(0);
            }
            if (aVar == null) {
                a(1);
            }
        }

        @Override // ka.f.i, ka.f.h, c9.a
        public T invoke() {
            T t10 = (T) super.invoke();
            if (t10 == null) {
                a(2);
            }
            return t10;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class l<K, V> implements ka.h<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final f f12198a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ConcurrentMap<K, Object> f12199b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final c9.l<? super K, ? extends V> f12200c;

        private static /* synthetic */ void b(int i10) {
            String str = (i10 == 3 || i10 == 4) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i10 == 3 || i10 == 4) ? 2 : 3];
            if (i10 == 1) {
                objArr[0] = "map";
            } else if (i10 == 2) {
                objArr[0] = "compute";
            } else if (i10 == 3 || i10 == 4) {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction";
            } else {
                objArr[0] = "storageManager";
            }
            if (i10 == 3) {
                objArr[1] = "recursionDetected";
            } else if (i10 != 4) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction";
            } else {
                objArr[1] = "raceCondition";
            }
            if (i10 != 3 && i10 != 4) {
                objArr[2] = "<init>";
            }
            String str2 = String.format(str, objArr);
            if (i10 != 3 && i10 != 4) {
                throw new IllegalArgumentException(str2);
            }
            throw new IllegalStateException(str2);
        }

        public l(f fVar, ConcurrentMap<K, Object> concurrentMap, c9.l<? super K, ? extends V> lVar) {
            if (fVar == null) {
                b(0);
            }
            if (concurrentMap == null) {
                b(1);
            }
            if (lVar == null) {
                b(2);
            }
            this.f12198a = fVar;
            this.f12199b = concurrentMap;
            this.f12200c = lVar;
        }

        private AssertionError c(K k10, Object obj) {
            AssertionError assertionError = (AssertionError) f.q(new AssertionError("Race condition detected on input " + k10 + ". Old value is " + obj + " under " + this.f12198a));
            if (assertionError == null) {
                b(4);
            }
            return assertionError;
        }

        protected o<V> e(K k10, boolean z10) {
            o<V> oVarP = this.f12198a.p("", k10);
            if (oVarP == null) {
                b(3);
            }
            return oVarP;
        }

        @Override // ka.h
        public boolean i(K k10) {
            Object obj = this.f12199b.get(k10);
            return (obj == null || obj == n.COMPUTING) ? false : true;
        }

        /* JADX WARN: Code duplicated, block: B:18:0x003e A[Catch: all -> 0x003b, PHI: r0
          0x003e: PHI (r0v8 java.lang.Object) = (r0v7 java.lang.Object), (r0v17 java.lang.Object) binds: [B:10:0x0020, B:12:0x002d] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TryCatch #0 {all -> 0x003b, blocks: (B:9:0x0018, B:11:0x0022, B:13:0x002f, B:18:0x003e, B:20:0x0042, B:22:0x004d, B:24:0x0054, B:34:0x007f, B:37:0x0087, B:39:0x0095, B:40:0x0099, B:41:0x009a, B:42:0x00a4, B:43:0x00a5, B:44:0x00af, B:45:0x00b0, B:46:0x00b7, B:27:0x005a, B:31:0x0079, B:32:0x007d), top: B:49:0x0018, inners: #1 }] */
        /* JADX WARN: Code duplicated, block: B:20:0x0042 A[Catch: all -> 0x003b, TryCatch #0 {all -> 0x003b, blocks: (B:9:0x0018, B:11:0x0022, B:13:0x002f, B:18:0x003e, B:20:0x0042, B:22:0x004d, B:24:0x0054, B:34:0x007f, B:37:0x0087, B:39:0x0095, B:40:0x0099, B:41:0x009a, B:42:0x00a4, B:43:0x00a5, B:44:0x00af, B:45:0x00b0, B:46:0x00b7, B:27:0x005a, B:31:0x0079, B:32:0x007d), top: B:49:0x0018, inners: #1 }] */
        /* JADX WARN: Code duplicated, block: B:22:0x004d A[Catch: all -> 0x003b, TryCatch #0 {all -> 0x003b, blocks: (B:9:0x0018, B:11:0x0022, B:13:0x002f, B:18:0x003e, B:20:0x0042, B:22:0x004d, B:24:0x0054, B:34:0x007f, B:37:0x0087, B:39:0x0095, B:40:0x0099, B:41:0x009a, B:42:0x00a4, B:43:0x00a5, B:44:0x00af, B:45:0x00b0, B:46:0x00b7, B:27:0x005a, B:31:0x0079, B:32:0x007d), top: B:49:0x0018, inners: #1 }] */
        /* JADX WARN: Code duplicated, block: B:23:0x0052 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:24:0x0054 A[Catch: all -> 0x003b, TRY_LEAVE, TryCatch #0 {all -> 0x003b, blocks: (B:9:0x0018, B:11:0x0022, B:13:0x002f, B:18:0x003e, B:20:0x0042, B:22:0x004d, B:24:0x0054, B:34:0x007f, B:37:0x0087, B:39:0x0095, B:40:0x0099, B:41:0x009a, B:42:0x00a4, B:43:0x00a5, B:44:0x00af, B:45:0x00b0, B:46:0x00b7, B:27:0x005a, B:31:0x0079, B:32:0x007d), top: B:49:0x0018, inners: #1 }] */
        /* JADX WARN: Code duplicated, block: B:26:0x0059  */
        /* JADX WARN: Code duplicated, block: B:29:0x0071  */
        /* JADX WARN: Code duplicated, block: B:31:0x0079 A[Catch: all -> 0x007e, TRY_ENTER, TryCatch #1 {all -> 0x007e, blocks: (B:27:0x005a, B:31:0x0079, B:32:0x007d), top: B:50:0x005a, outer: #0 }] */
        @Override // c9.l
        public V invoke(K k10) {
            AssertionError assertionErrorC;
            V vInvoke;
            Object objPut;
            V vB;
            o<V> oVarE;
            Object obj = this.f12199b.get(k10);
            if (obj != null && obj != n.COMPUTING) {
                return (V) sa.h.d(obj);
            }
            this.f12198a.f12183a.lock();
            try {
                Object obj2 = this.f12199b.get(k10);
                n nVar = n.COMPUTING;
                if (obj2 == nVar) {
                    obj2 = n.RECURSION_WAS_DETECTED;
                    o<V> oVarE2 = e(k10, true);
                    if (!oVarE2.c()) {
                        vB = oVarE2.b();
                    } else if (obj2 == n.RECURSION_WAS_DETECTED) {
                        oVarE = e(k10, false);
                        if (!oVarE.c()) {
                            vB = oVarE.b();
                        } else {
                            if (obj2 != null) {
                                assertionErrorC = null;
                                try {
                                    this.f12199b.put(k10, nVar);
                                    vInvoke = this.f12200c.invoke(k10);
                                    objPut = this.f12199b.put(k10, sa.h.b(vInvoke));
                                    if (objPut == nVar) {
                                        this.f12198a.f12183a.unlock();
                                        return vInvoke;
                                    }
                                    assertionErrorC = c(k10, objPut);
                                    throw assertionErrorC;
                                } catch (Throwable th) {
                                    if (sa.d.a(th)) {
                                        this.f12199b.remove(k10);
                                        throw th;
                                    }
                                    if (th == assertionErrorC) {
                                        throw this.f12198a.f12184b.a(th);
                                    }
                                    Object objPut2 = this.f12199b.put(k10, sa.h.c(th));
                                    if (objPut2 != n.COMPUTING) {
                                        throw c(k10, objPut2);
                                    }
                                    throw this.f12198a.f12184b.a(th);
                                }
                            }
                            vB = (V) sa.h.d(obj2);
                        }
                    } else {
                        if (obj2 != null) {
                            assertionErrorC = null;
                            this.f12199b.put(k10, nVar);
                            vInvoke = this.f12200c.invoke(k10);
                            objPut = this.f12199b.put(k10, sa.h.b(vInvoke));
                            if (objPut == nVar) {
                                this.f12198a.f12183a.unlock();
                                return vInvoke;
                            }
                            assertionErrorC = c(k10, objPut);
                            throw assertionErrorC;
                        }
                        vB = (V) sa.h.d(obj2);
                    }
                } else if (obj2 == n.RECURSION_WAS_DETECTED) {
                    oVarE = e(k10, false);
                    if (!oVarE.c()) {
                        vB = oVarE.b();
                    } else {
                        if (obj2 != null) {
                            assertionErrorC = null;
                            this.f12199b.put(k10, nVar);
                            vInvoke = this.f12200c.invoke(k10);
                            objPut = this.f12199b.put(k10, sa.h.b(vInvoke));
                            if (objPut == nVar) {
                                this.f12198a.f12183a.unlock();
                                return vInvoke;
                            }
                            assertionErrorC = c(k10, objPut);
                            throw assertionErrorC;
                        }
                        vB = (V) sa.h.d(obj2);
                    }
                } else {
                    if (obj2 != null) {
                        assertionErrorC = null;
                        this.f12199b.put(k10, nVar);
                        vInvoke = this.f12200c.invoke(k10);
                        objPut = this.f12199b.put(k10, sa.h.b(vInvoke));
                        if (objPut == nVar) {
                            this.f12198a.f12183a.unlock();
                            return vInvoke;
                        }
                        assertionErrorC = c(k10, objPut);
                        throw assertionErrorC;
                    }
                    vB = (V) sa.h.d(obj2);
                }
                this.f12198a.f12183a.unlock();
                return vB;
            } catch (Throwable th2) {
                this.f12198a.f12183a.unlock();
                throw th2;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class m<K, V> extends l<K, V> implements ka.g<K, V> {
        private static /* synthetic */ void b(int i10) {
            String str = i10 != 3 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i10 != 3 ? 3 : 2];
            if (i10 == 1) {
                objArr[0] = "map";
            } else if (i10 == 2) {
                objArr[0] = "compute";
            } else if (i10 != 3) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull";
            }
            if (i10 != 3) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull";
            } else {
                objArr[1] = "invoke";
            }
            if (i10 != 3) {
                objArr[2] = "<init>";
            }
            String str2 = String.format(str, objArr);
            if (i10 == 3) {
                throw new IllegalStateException(str2);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(f fVar, ConcurrentMap<K, Object> concurrentMap, c9.l<? super K, ? extends V> lVar) {
            super(fVar, concurrentMap, lVar);
            if (fVar == null) {
                b(0);
            }
            if (concurrentMap == null) {
                b(1);
            }
            if (lVar == null) {
                b(2);
            }
        }

        @Override // ka.f.l, c9.l
        public V invoke(K k10) {
            V v10 = (V) super.invoke(k10);
            if (v10 == null) {
                b(3);
            }
            return v10;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private enum n {
        NOT_COMPUTED,
        COMPUTING,
        RECURSION_WAS_DETECTED
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class o<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final T f12205a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f12206b;

        public static <T> o<T> a() {
            return new o<>(null, true);
        }

        public static <T> o<T> d(T t10) {
            return new o<>(t10, false);
        }

        public T b() {
            return this.f12205a;
        }

        public boolean c() {
            return this.f12206b;
        }

        private o(T t10, boolean z10) {
            this.f12205a = t10;
            this.f12206b = z10;
        }

        public String toString() {
            if (c()) {
                return "FALL_THROUGH";
            }
            return String.valueOf(this.f12205a);
        }
    }

    /* synthetic */ f(String str, InterfaceC0204f interfaceC0204f, ka.k kVar, a aVar) {
        this(str, interfaceC0204f, kVar);
    }

    private f(String str, InterfaceC0204f interfaceC0204f, ka.k kVar) {
        if (str == null) {
            j(4);
        }
        if (interfaceC0204f == null) {
            j(5);
        }
        if (kVar == null) {
            j(6);
        }
        this.f12183a = kVar;
        this.f12184b = interfaceC0204f;
        this.f12185c = str;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0065  */
    private static /* synthetic */ void j(int i10) {
        String str = (i10 == 10 || i10 == 13 || i10 == 20 || i10 == 37) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 10 || i10 == 13 || i10 == 20 || i10 == 37) ? 2 : 3];
        if (i10 == 1 || i10 == 3 || i10 == 5) {
            objArr[0] = "exceptionHandlingStrategy";
        } else if (i10 != 6) {
            switch (i10) {
                case 8:
                    objArr[0] = "exceptionHandlingStrategy";
                    break;
                case 9:
                case 11:
                case 14:
                case 16:
                case 19:
                case 21:
                    objArr[0] = "compute";
                    break;
                case 10:
                case 13:
                case 20:
                case 37:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager";
                    break;
                case 12:
                case 17:
                case 25:
                case 27:
                    objArr[0] = "onRecursiveCall";
                    break;
                case 15:
                case 18:
                case 22:
                    objArr[0] = "map";
                    break;
                case 23:
                case 24:
                case 26:
                case 28:
                case 30:
                case 31:
                case 32:
                case 34:
                    objArr[0] = "computable";
                    break;
                case 29:
                case 33:
                    objArr[0] = "postCompute";
                    break;
                case 35:
                    objArr[0] = "source";
                    break;
                case 36:
                    objArr[0] = "throwable";
                    break;
                default:
                    objArr[0] = "debugText";
                    break;
            }
        } else {
            objArr[0] = "lock";
        }
        if (i10 == 10 || i10 == 13) {
            objArr[1] = "createMemoizedFunction";
        } else if (i10 == 20) {
            objArr[1] = "createMemoizedFunctionWithNullableValues";
        } else if (i10 != 37) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager";
        } else {
            objArr[1] = "sanitizeStackTrace";
        }
        switch (i10) {
            case 4:
            case 5:
            case 6:
                objArr[2] = "<init>";
                break;
            case 7:
            case 8:
                objArr[2] = "replaceExceptionHandling";
                break;
            case 9:
            case 11:
            case 12:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                objArr[2] = "createMemoizedFunction";
                break;
            case 10:
            case 13:
            case 20:
            case 37:
                break;
            case 19:
            case 21:
            case 22:
                objArr[2] = "createMemoizedFunctionWithNullableValues";
                break;
            case 23:
            case 24:
            case 25:
                objArr[2] = "createLazyValue";
                break;
            case 26:
            case 27:
                objArr[2] = "createRecursionTolerantLazyValue";
                break;
            case 28:
            case 29:
                objArr[2] = "createLazyValueWithPostCompute";
                break;
            case 30:
                objArr[2] = "createNullableLazyValue";
                break;
            case 31:
                objArr[2] = "createRecursionTolerantNullableLazyValue";
                break;
            case 32:
            case 33:
                objArr[2] = "createNullableLazyValueWithPostCompute";
                break;
            case 34:
                objArr[2] = "compute";
                break;
            case 35:
                objArr[2] = "recursionDetectedDefault";
                break;
            case 36:
                objArr[2] = "sanitizeStackTrace";
                break;
            default:
                objArr[2] = "createWithExceptionHandling";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i10 != 10 && i10 != 13 && i10 != 20 && i10 != 37) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    private static <K> ConcurrentMap<K, Object> m() {
        return new ConcurrentHashMap(3, 1.0f, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T extends Throwable> T q(T t10) {
        if (t10 == null) {
            j(36);
        }
        StackTraceElement[] stackTrace = t10.getStackTrace();
        int length = stackTrace.length;
        int i10 = 0;
        while (i10 < length) {
            if (!stackTrace[i10].getClassName().startsWith(f12181d)) {
                List listSubList = Arrays.asList(stackTrace).subList(i10, length);
                t10.setStackTrace((StackTraceElement[]) listSubList.toArray(new StackTraceElement[listSubList.size()]));
                return t10;
            }
            i10++;
        }
        i10 = -1;
        List listSubList2 = Arrays.asList(stackTrace).subList(i10, length);
        t10.setStackTrace((StackTraceElement[]) listSubList2.toArray(new StackTraceElement[listSubList2.size()]));
        return t10;
    }

    @Override // ka.n
    public <T> T a(c9.a<? extends T> aVar) {
        if (aVar == null) {
            j(34);
        }
        this.f12183a.lock();
        try {
            T tInvoke = aVar.invoke();
            this.f12183a.unlock();
            return tInvoke;
        } catch (Throwable th) {
            try {
                throw this.f12184b.a(th);
            } catch (Throwable th2) {
                this.f12183a.unlock();
                throw th2;
            }
        }
    }

    @Override // ka.n
    public <K, V> ka.b<K, V> b() {
        return new e(this, m(), null);
    }

    @Override // ka.n
    public <T> ka.i<T> c(c9.a<? extends T> aVar) {
        if (aVar == null) {
            j(23);
        }
        return new j(this, aVar);
    }

    @Override // ka.n
    public <K, V> ka.a<K, V> d() {
        return new d(this, m(), null);
    }

    @Override // ka.n
    public <T> ka.i<T> e(c9.a<? extends T> aVar, T t10) {
        if (aVar == null) {
            j(26);
        }
        if (t10 == null) {
            j(27);
        }
        return new b(this, aVar, t10);
    }

    @Override // ka.n
    public <K, V> ka.g<K, V> f(c9.l<? super K, ? extends V> lVar) {
        if (lVar == null) {
            j(9);
        }
        ka.g<K, V> gVarN = n(lVar, m());
        if (gVarN == null) {
            j(10);
        }
        return gVarN;
    }

    @Override // ka.n
    public <T> ka.j<T> g(c9.a<? extends T> aVar) {
        if (aVar == null) {
            j(30);
        }
        return new h(this, aVar);
    }

    @Override // ka.n
    public <T> ka.i<T> h(c9.a<? extends T> aVar, c9.l<? super Boolean, ? extends T> lVar, c9.l<? super T, z> lVar2) {
        if (aVar == null) {
            j(28);
        }
        if (lVar2 == null) {
            j(29);
        }
        return new c(this, aVar, lVar, lVar2);
    }

    @Override // ka.n
    public <K, V> ka.h<K, V> i(c9.l<? super K, ? extends V> lVar) {
        if (lVar == null) {
            j(19);
        }
        ka.h<K, V> hVarO = o(lVar, m());
        if (hVarO == null) {
            j(20);
        }
        return hVarO;
    }

    public <K, V> ka.g<K, V> n(c9.l<? super K, ? extends V> lVar, ConcurrentMap<K, Object> concurrentMap) {
        if (lVar == null) {
            j(14);
        }
        if (concurrentMap == null) {
            j(15);
        }
        return new m(this, concurrentMap, lVar);
    }

    public <K, V> ka.h<K, V> o(c9.l<? super K, ? extends V> lVar, ConcurrentMap<K, Object> concurrentMap) {
        if (lVar == null) {
            j(21);
        }
        if (concurrentMap == null) {
            j(22);
        }
        return new l(this, concurrentMap, lVar);
    }

    protected <K, V> o<V> p(String str, K k10) {
        String str2;
        if (str == null) {
            j(35);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Recursion detected ");
        sb2.append(str);
        if (k10 == null) {
            str2 = "";
        } else {
            str2 = "on input: " + k10;
        }
        sb2.append(str2);
        sb2.append(" under ");
        sb2.append(this);
        throw ((AssertionError) q(new AssertionError(sb2.toString())));
    }

    public String toString() {
        return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + " (" + this.f12185c + ")";
    }

    public f(String str) {
        this(str, (Runnable) null, (c9.l<InterruptedException, z>) null);
    }

    public f(String str, Runnable runnable, c9.l<InterruptedException, z> lVar) {
        this(str, InterfaceC0204f.f12191a, ka.k.f12207a.a(runnable, lVar));
    }
}
