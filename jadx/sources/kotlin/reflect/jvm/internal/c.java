package kotlin.reflect.jvm.internal;

import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a-\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\b\b\u0000\u0010\u0001*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a'\u0010\b\u001a\u00020\u0007\"\b\b\u0000\u0010\u0001*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0000¢\u0006\u0004\b\b\u0010\t\"*\u0010\r\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u000e\b\u0001\u0012\n \u000b*\u0004\u0018\u00010\u00000\u00000\u00040\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\f\"\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\f\"\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\f\"\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\f\"<\u0010\u001c\u001a*\u0012&\u0012$\u0012\u001a\u0012\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u0017\u0012\u0004\u0012\u00020\u00190\u0016j\u0002`\u001a\u0012\u0004\u0012\u00020\u00100\u00150\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\f*0\b\u0002\u0010\u001d\"\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u0017\u0012\u0004\u0012\u00020\u00190\u00162\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u0017\u0012\u0004\u0012\u00020\u00190\u0016¨\u0006\u001e"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Class;", "jClass", "Lkotlin/reflect/jvm/internal/k;", "a", "(Ljava/lang/Class;)Lkotlin/reflect/jvm/internal/k;", "Li9/f;", "b", "(Ljava/lang/Class;)Li9/f;", "Lkotlin/reflect/jvm/internal/a;", "kotlin.jvm.PlatformType", "Lkotlin/reflect/jvm/internal/a;", "K_CLASS_CACHE", "Lkotlin/reflect/jvm/internal/t;", "K_PACKAGE_CACHE", "Li9/n;", "c", "CACHE_FOR_BASE_CLASSIFIERS", "d", "CACHE_FOR_NULLABLE_BASE_CLASSIFIERS", "Ljava/util/concurrent/ConcurrentHashMap;", "Lr8/p;", "", "Li9/p;", "", "Lkotlin/reflect/jvm/internal/Key;", "e", "CACHE_FOR_GENERIC_CLASSIFIERS", "Key", "kotlin-reflection"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final kotlin.reflect.jvm.internal.a<k<? extends Object>> f12359a = kotlin.reflect.jvm.internal.b.a(d.f12367a);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final kotlin.reflect.jvm.internal.a<t> f12360b = kotlin.reflect.jvm.internal.b.a(e.f12368a);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final kotlin.reflect.jvm.internal.a<i9.n> f12361c = kotlin.reflect.jvm.internal.b.a(a.f12364a);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final kotlin.reflect.jvm.internal.a<i9.n> f12362d = kotlin.reflect.jvm.internal.b.a(C0207c.f12366a);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final kotlin.reflect.jvm.internal.a<ConcurrentHashMap<r8.p<List<i9.p>, Boolean>, i9.n>> f12363e = kotlin.reflect.jvm.internal.b.a(b.f12365a);

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\n\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Class;", "it", "Li9/n;", "a", "(Ljava/lang/Class;)Li9/n;"}, k = 3, mv = {1, 8, 0})
    static final class a extends kotlin.jvm.internal.o implements c9.l<Class<?>, i9.n> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f12364a = new a();

        a() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final i9.n invoke(Class<?> it) {
            kotlin.jvm.internal.m.f(it, "it");
            return j9.c.b(c.a(it), kotlin.collections.r.l(), false, kotlin.collections.r.l());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\t\u001a$\u0012\u001a\u0012\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00060\u0003j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u00022\n\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000H\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Ljava/lang/Class;", "it", "Ljava/util/concurrent/ConcurrentHashMap;", "Lr8/p;", "", "Li9/p;", "", "Lkotlin/reflect/jvm/internal/Key;", "Li9/n;", "a", "(Ljava/lang/Class;)Ljava/util/concurrent/ConcurrentHashMap;"}, k = 3, mv = {1, 8, 0})
    static final class b extends kotlin.jvm.internal.o implements c9.l<Class<?>, ConcurrentHashMap<r8.p<? extends List<? extends i9.p>, ? extends Boolean>, i9.n>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f12365a = new b();

        b() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ConcurrentHashMap<r8.p<List<i9.p>, Boolean>, i9.n> invoke(Class<?> it) {
            kotlin.jvm.internal.m.f(it, "it");
            return new ConcurrentHashMap<>();
        }
    }

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\n\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Class;", "it", "Li9/n;", "a", "(Ljava/lang/Class;)Li9/n;"}, k = 3, mv = {1, 8, 0})
    static final class C0207c extends kotlin.jvm.internal.o implements c9.l<Class<?>, i9.n> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0207c f12366a = new C0207c();

        C0207c() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final i9.n invoke(Class<?> it) {
            kotlin.jvm.internal.m.f(it, "it");
            return j9.c.b(c.a(it), kotlin.collections.r.l(), true, kotlin.collections.r.l());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0005\u001a\u0012\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00010\u00030\u00030\u00022\n\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Ljava/lang/Class;", "it", "Lkotlin/reflect/jvm/internal/k;", "", "kotlin.jvm.PlatformType", "a", "(Ljava/lang/Class;)Lkotlin/reflect/jvm/internal/k;"}, k = 3, mv = {1, 8, 0})
    static final class d extends kotlin.jvm.internal.o implements c9.l<Class<?>, k<? extends Object>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f12367a = new d();

        d() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final k<? extends Object> invoke(Class<?> it) {
            kotlin.jvm.internal.m.f(it, "it");
            return new k<>(it);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\n\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Class;", "it", "Lkotlin/reflect/jvm/internal/t;", "a", "(Ljava/lang/Class;)Lkotlin/reflect/jvm/internal/t;"}, k = 3, mv = {1, 8, 0})
    static final class e extends kotlin.jvm.internal.o implements c9.l<Class<?>, t> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f12368a = new e();

        e() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final t invoke(Class<?> it) {
            kotlin.jvm.internal.m.f(it, "it");
            return new t(it);
        }
    }

    public static final <T> k<T> a(Class<T> jClass) {
        kotlin.jvm.internal.m.f(jClass, "jClass");
        kotlin.jvm.internal.d dVarA = f12359a.a(jClass);
        kotlin.jvm.internal.m.d(dVarA, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<T of kotlin.reflect.jvm.internal.CachesKt.getOrCreateKotlinClass>");
        return (k) dVarA;
    }

    public static final <T> i9.f b(Class<T> jClass) {
        kotlin.jvm.internal.m.f(jClass, "jClass");
        return f12360b.a(jClass);
    }
}
