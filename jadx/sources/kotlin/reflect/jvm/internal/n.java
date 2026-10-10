package kotlin.reflect.jvm.internal;

import androidx.exifinterface.media.ExifInterface;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0007\b \u0018\u0000 J2\u00020\u0001:\u0003JKLB\u0007¢\u0006\u0004\b\u0002\u0010\u0003JG\u0010\r\u001a\u0004\u0018\u00010\f*\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0006\u001a\u00020\u00052\u0010\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u00072\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ?\u0010\u000f\u001a\u0004\u0018\u00010\f*\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0006\u001a\u00020\u00052\u0010\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u00072\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J/\u0010\u0013\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0012*\u0006\u0012\u0002\b\u00030\u00042\u0010\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J1\u0010\u001a\u001a\u00020\u00192\u0010\u0010\u0016\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u00152\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ!\u0010\u001c\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u00112\u0006\u0010\u0017\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ+\u0010!\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001eH\u0002¢\u0006\u0004\b!\u0010\"J\u001b\u0010#\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0017\u001a\u00020\u0005H\u0002¢\u0006\u0004\b#\u0010$J\u001d\u0010(\u001a\b\u0012\u0004\u0012\u00020'0&2\u0006\u0010\u0006\u001a\u00020%H&¢\u0006\u0004\b(\u0010)J\u001d\u0010+\u001a\b\u0012\u0004\u0012\u00020*0&2\u0006\u0010\u0006\u001a\u00020%H&¢\u0006\u0004\b+\u0010)J\u0019\u0010-\u001a\u0004\u0018\u00010'2\u0006\u0010,\u001a\u00020\u001eH&¢\u0006\u0004\b-\u0010.J)\u00104\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u0003030&2\u0006\u00100\u001a\u00020/2\u0006\u00102\u001a\u000201H\u0004¢\u0006\u0004\b4\u00105J\u001d\u00107\u001a\u00020'2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u00106\u001a\u00020\u0005¢\u0006\u0004\b7\u00108J\u001d\u00109\u001a\u00020*2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u00106\u001a\u00020\u0005¢\u0006\u0004\b9\u0010:J\u001f\u0010;\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005¢\u0006\u0004\b;\u0010<J'\u0010>\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010=\u001a\u00020\n¢\u0006\u0004\b>\u0010?J\u001b\u0010@\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00122\u0006\u0010\u0017\u001a\u00020\u0005¢\u0006\u0004\b@\u0010AJ\u001b\u0010B\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00122\u0006\u0010\u0017\u001a\u00020\u0005¢\u0006\u0004\bB\u0010AR\u0018\u0010E\u001a\u0006\u0012\u0002\b\u00030\u00048TX\u0094\u0004¢\u0006\u0006\u001a\u0004\bC\u0010DR\u001a\u0010I\u001a\b\u0012\u0004\u0012\u00020F0&8&X¦\u0004¢\u0006\u0006\u001a\u0004\bG\u0010H¨\u0006M"}, d2 = {"Lkotlin/reflect/jvm/internal/n;", "Lkotlin/jvm/internal/d;", "<init>", "()V", "Ljava/lang/Class;", "", "name", "", "parameterTypes", "returnType", "", "isStaticDefault", "Ljava/lang/reflect/Method;", "C", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;Ljava/lang/Class;Z)Ljava/lang/reflect/Method;", "F", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;Ljava/lang/Class;)Ljava/lang/reflect/Method;", "", "Ljava/lang/reflect/Constructor;", ExifInterface.LONGITUDE_EAST, "(Ljava/lang/Class;Ljava/util/List;)Ljava/lang/reflect/Constructor;", "", "result", "desc", "isConstructor", "Lr8/z;", "m", "(Ljava/util/List;Ljava/lang/String;Z)V", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Ljava/lang/String;)Ljava/util/List;", "", "begin", "end", "D", "(Ljava/lang/String;II)Ljava/lang/Class;", "B", "(Ljava/lang/String;)Ljava/lang/Class;", "Lba/f;", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/u0;", "z", "(Lba/f;)Ljava/util/Collection;", "Lkotlin/reflect/jvm/internal/impl/descriptors/y;", "v", "index", "w", "(I)Lkotlin/reflect/jvm/internal/impl/descriptors/u0;", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/h;", "scope", "Lkotlin/reflect/jvm/internal/n$c;", "belonginess", "Lkotlin/reflect/jvm/internal/j;", "x", "(Lkotlin/reflect/jvm/internal/impl/resolve/scopes/h;Lkotlin/reflect/jvm/internal/n$c;)Ljava/util/Collection;", "signature", "s", "(Ljava/lang/String;Ljava/lang/String;)Lkotlin/reflect/jvm/internal/impl/descriptors/u0;", "q", "(Ljava/lang/String;Ljava/lang/String;)Lkotlin/reflect/jvm/internal/impl/descriptors/y;", "r", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/reflect/Method;", "isMember", "p", "(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/reflect/Method;", "n", "(Ljava/lang/String;)Ljava/lang/reflect/Constructor;", "o", "y", "()Ljava/lang/Class;", "methodOwner", "Lkotlin/reflect/jvm/internal/impl/descriptors/l;", "u", "()Ljava/util/Collection;", "constructorDescriptors", "a", "b", "c", "kotlin-reflection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class n implements kotlin.jvm.internal.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Class<?> f14520b = kotlin.jvm.internal.g.class;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ua.l f14521c = new ua.l("<v#(\\d+)>");

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.n$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR$\u0010\u000b\u001a\u0012\u0012\u0002\b\u0003 \n*\b\u0012\u0002\b\u0003\u0018\u00010\t0\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lkotlin/reflect/jvm/internal/n$a;", "", "<init>", "()V", "Lua/l;", "LOCAL_PROPERTY_SIGNATURE", "Lua/l;", "a", "()Lua/l;", "Ljava/lang/Class;", "kotlin.jvm.PlatformType", "DEFAULT_CONSTRUCTOR_MARKER", "Ljava/lang/Class;", "kotlin-reflection"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        private Companion() {
        }

        public final ua.l a() {
            return n.f14521c;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b¦\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\t\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lkotlin/reflect/jvm/internal/n$b;", "", "<init>", "(Lkotlin/reflect/jvm/internal/n;)V", "Lp9/k;", "a", "Lkotlin/reflect/jvm/internal/h0$a;", "getModuleData", "()Lorg/jetbrains/kotlin/descriptors/runtime/components/RuntimeModuleData;", "moduleData", "kotlin-reflection"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public abstract class b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final /* synthetic */ i9.k<Object>[] f14522c = {kotlin.jvm.internal.c0.g(new kotlin.jvm.internal.w(kotlin.jvm.internal.c0.b(b.class), "moduleData", "getModuleData()Lorg/jetbrains/kotlin/descriptors/runtime/components/RuntimeModuleData;"))};

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final h0.a moduleData;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lp9/k;", "kotlin.jvm.PlatformType", "a", "()Lp9/k;"}, k = 3, mv = {1, 8, 0})
        static final class a extends kotlin.jvm.internal.o implements c9.a<p9.k> {
            final /* synthetic */ n this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(n nVar) {
                super(0);
                this.this$0 = nVar;
            }

            @Override // c9.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final p9.k invoke() {
                return g0.a(this.this$0.d());
            }
        }

        public b() {
            this.moduleData = h0.c(new a(n.this));
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final p9.k a() {
            T tB = this.moduleData.b(this, f14522c[0]);
            kotlin.jvm.internal.m.e(tB, "<get-moduleData>(...)");
            return (p9.k) tB;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0084\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lkotlin/reflect/jvm/internal/n$c;", "", "<init>", "(Ljava/lang/String;I)V", "Lkotlin/reflect/jvm/internal/impl/descriptors/b;", "member", "", "f", "(Lkotlin/reflect/jvm/internal/impl/descriptors/b;)Z", "a", "b", "kotlin-reflection"}, k = 1, mv = {1, 8, 0}, xi = 48)
    protected enum c {
        DECLARED,
        INHERITED;

        public final boolean f(kotlin.reflect.jvm.internal.impl.descriptors.b member) {
            kotlin.jvm.internal.m.f(member, "member");
            return member.g().a() == (this == DECLARED);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlin/reflect/jvm/internal/impl/descriptors/y;", "descriptor", "", "a", "(Lkotlin/reflect/jvm/internal/impl/descriptors/y;)Ljava/lang/CharSequence;"}, k = 3, mv = {1, 8, 0})
    static final class d extends kotlin.jvm.internal.o implements c9.l<kotlin.reflect.jvm.internal.impl.descriptors.y, CharSequence> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f14528a = new d();

        d() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CharSequence invoke(kotlin.reflect.jvm.internal.impl.descriptors.y descriptor) {
            kotlin.jvm.internal.m.f(descriptor, "descriptor");
            return kotlin.reflect.jvm.internal.impl.renderer.c.f13793j.q(descriptor) + " | " + k0.f14515a.g(descriptor).get_signature();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlin/reflect/jvm/internal/impl/descriptors/u0;", "descriptor", "", "a", "(Lkotlin/reflect/jvm/internal/impl/descriptors/u0;)Ljava/lang/CharSequence;"}, k = 3, mv = {1, 8, 0})
    static final class e extends kotlin.jvm.internal.o implements c9.l<u0, CharSequence> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f14529a = new e();

        e() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CharSequence invoke(u0 descriptor) {
            kotlin.jvm.internal.m.f(descriptor, "descriptor");
            return kotlin.reflect.jvm.internal.impl.renderer.c.f13793j.q(descriptor) + " | " + k0.f14515a.f(descriptor).getString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"kotlin/reflect/jvm/internal/n$g", "Lkotlin/reflect/jvm/internal/e;", "Lkotlin/reflect/jvm/internal/impl/descriptors/l;", "descriptor", "Lr8/z;", "data", "Lkotlin/reflect/jvm/internal/j;", "visitConstructorDescriptor", "(Lorg/jetbrains/kotlin/descriptors/ConstructorDescriptor;Lr8/z;)Lkotlin/reflect/jvm/internal/j;", "kotlin-reflection"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class g extends kotlin.reflect.jvm.internal.e {
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.l, kotlin.reflect.jvm.internal.impl.descriptors.o
        /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
        public j<?> h(kotlin.reflect.jvm.internal.impl.descriptors.l descriptor, r8.z data) {
            kotlin.jvm.internal.m.f(descriptor, "descriptor");
            kotlin.jvm.internal.m.f(data, "data");
            throw new IllegalStateException("No constructors should appear here: " + descriptor);
        }

        g(n nVar) {
            super(nVar);
        }
    }

    private final Class<?> B(String desc) {
        return D(desc, ua.n.a0(desc, ')', 0, false, 6, null) + 1, desc.length());
    }

    private final Method C(Class<?> cls, String str, Class<?>[] clsArr, Class<?> cls2, boolean z10) {
        String str2;
        Class<?>[] clsArr2;
        Class<?> cls3;
        boolean z11;
        if (z10) {
            clsArr[0] = cls;
        }
        Method methodF = F(cls, str, clsArr, cls2);
        if (methodF != null) {
            return methodF;
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass != null) {
            Method methodC = C(superclass, str, clsArr, cls2, z10);
            str2 = str;
            clsArr2 = clsArr;
            cls3 = cls2;
            z11 = z10;
            if (methodC != null) {
                return methodC;
            }
        } else {
            str2 = str;
            clsArr2 = clsArr;
            cls3 = cls2;
            z11 = z10;
        }
        Class<?>[] interfaces = cls.getInterfaces();
        kotlin.jvm.internal.m.e(interfaces, "interfaces");
        for (Class<?> superInterface : interfaces) {
            kotlin.jvm.internal.m.e(superInterface, "superInterface");
            Method methodC2 = C(superInterface, str2, clsArr2, cls3, z11);
            if (methodC2 != null) {
                return methodC2;
            }
            if (z11) {
                Class<?> clsA = p9.e.a(kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.d.e(superInterface), superInterface.getName() + "$DefaultImpls");
                if (clsA != null) {
                    clsArr2[0] = superInterface;
                    Method methodF2 = F(clsA, str2, clsArr2, cls3);
                    if (methodF2 != null) {
                        return methodF2;
                    }
                } else {
                    continue;
                }
            }
        }
        return null;
    }

    private final Method F(Class<?> cls, String str, Class<?>[] clsArr, Class<?> cls2) {
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
            if (kotlin.jvm.internal.m.a(declaredMethod.getReturnType(), cls2)) {
                return declaredMethod;
            }
            Method[] declaredMethods = cls.getDeclaredMethods();
            kotlin.jvm.internal.m.e(declaredMethods, "declaredMethods");
            for (Method method : declaredMethods) {
                if (kotlin.jvm.internal.m.a(method.getName(), str) && kotlin.jvm.internal.m.a(method.getReturnType(), cls2) && Arrays.equals(method.getParameterTypes(), clsArr)) {
                    return method;
                }
            }
        } catch (NoSuchMethodException unused) {
        }
        return null;
    }

    public abstract Collection<kotlin.reflect.jvm.internal.impl.descriptors.l> u();

    public abstract Collection<kotlin.reflect.jvm.internal.impl.descriptors.y> v(ba.f name);

    public abstract u0 w(int index);

    public abstract Collection<u0> z(ba.f name);

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlin/reflect/jvm/internal/impl/descriptors/u;", "kotlin.jvm.PlatformType", "first", "second", "", "invoke", "(Lorg/jetbrains/kotlin/descriptors/DescriptorVisibility;Lorg/jetbrains/kotlin/descriptors/DescriptorVisibility;)Ljava/lang/Integer;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    static final class f extends kotlin.jvm.internal.o implements c9.p<kotlin.reflect.jvm.internal.impl.descriptors.u, kotlin.reflect.jvm.internal.impl.descriptors.u, Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f14530a = new f();

        f() {
            super(2);
        }

        @Override // c9.p
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Integer invoke(kotlin.reflect.jvm.internal.impl.descriptors.u uVar, kotlin.reflect.jvm.internal.impl.descriptors.u uVar2) {
            int iIntValue;
            Integer numD = kotlin.reflect.jvm.internal.impl.descriptors.t.d(uVar, uVar2);
            if (numD == null) {
                iIntValue = 0;
            } else {
                iIntValue = numD.intValue();
            }
            return Integer.valueOf(iIntValue);
        }
    }

    private final List<Class<?>> A(String desc) {
        String str;
        int iA0;
        ArrayList arrayList = new ArrayList();
        int i10 = 1;
        while (desc.charAt(i10) != ')') {
            int i11 = i10;
            while (desc.charAt(i11) == '[') {
                i11++;
            }
            char cCharAt = desc.charAt(i11);
            if (ua.n.N("VZCBSIFJD", cCharAt, false, 2, null)) {
                int i12 = i11 + 1;
                str = desc;
                iA0 = i12;
            } else {
                if (cCharAt != 'L') {
                    throw new f0("Unknown type prefix in the method signature: " + desc);
                }
                str = desc;
                iA0 = ua.n.a0(str, ';', i10, false, 4, null) + 1;
            }
            arrayList.add(D(str, i10, iA0));
            i10 = iA0;
            desc = str;
        }
        return arrayList;
    }

    private final Constructor<?> E(Class<?> cls, List<? extends Class<?>> list) {
        try {
            Class[] clsArr = (Class[]) list.toArray(new Class[0]);
            return cls.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr, clsArr.length));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int t(c9.p tmp0, Object obj, Object obj2) {
        kotlin.jvm.internal.m.f(tmp0, "$tmp0");
        return ((Number) tmp0.invoke(obj, obj2)).intValue();
    }

    public final Constructor<?> n(String desc) {
        kotlin.jvm.internal.m.f(desc, "desc");
        return E(d(), A(desc));
    }

    public final Constructor<?> o(String desc) {
        kotlin.jvm.internal.m.f(desc, "desc");
        Class<?> clsD = d();
        ArrayList arrayList = new ArrayList();
        m(arrayList, desc, true);
        r8.z zVar = r8.z.f17874a;
        return E(clsD, arrayList);
    }

    public final Method p(String name, String desc, boolean isMember) {
        kotlin.jvm.internal.m.f(name, "name");
        kotlin.jvm.internal.m.f(desc, "desc");
        if (kotlin.jvm.internal.m.a(name, "<init>")) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (isMember) {
            arrayList.add(d());
        }
        m(arrayList, desc, false);
        return C(y(), name + "$default", (Class[]) arrayList.toArray(new Class[0]), B(desc), isMember);
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.y q(String name, String signature) {
        List listV;
        kotlin.jvm.internal.m.f(name, "name");
        kotlin.jvm.internal.m.f(signature, "signature");
        if (kotlin.jvm.internal.m.a(name, "<init>")) {
            listV = kotlin.collections.r.O0(u());
        } else {
            ba.f fVarL = ba.f.l(name);
            kotlin.jvm.internal.m.e(fVarL, "identifier(name)");
            listV = v(fVarL);
        }
        Collection<kotlin.reflect.jvm.internal.impl.descriptors.y> collection = listV;
        ArrayList arrayList = new ArrayList();
        for (Object obj : collection) {
            if (kotlin.jvm.internal.m.a(k0.f14515a.g((kotlin.reflect.jvm.internal.impl.descriptors.y) obj).get_signature(), signature)) {
                arrayList.add(obj);
            }
        }
        if (arrayList.size() == 1) {
            return (kotlin.reflect.jvm.internal.impl.descriptors.y) kotlin.collections.r.F0(arrayList);
        }
        String strQ0 = kotlin.collections.r.q0(collection, "\n", null, null, 0, null, d.f14528a, 30, null);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Function '");
        sb2.append(name);
        sb2.append("' (JVM signature: ");
        sb2.append(signature);
        sb2.append(") not resolved in ");
        sb2.append(this);
        sb2.append(':');
        sb2.append(strQ0.length() == 0 ? " no members found" : '\n' + strQ0);
        throw new f0(sb2.toString());
    }

    public final Method r(String name, String desc) {
        Method methodC;
        kotlin.jvm.internal.m.f(name, "name");
        kotlin.jvm.internal.m.f(desc, "desc");
        if (kotlin.jvm.internal.m.a(name, "<init>")) {
            return null;
        }
        Class<?>[] clsArr = (Class[]) A(desc).toArray(new Class[0]);
        Class<?> clsB = B(desc);
        Method methodC2 = C(y(), name, clsArr, clsB, false);
        if (methodC2 != null) {
            return methodC2;
        }
        if (!y().isInterface() || (methodC = C(Object.class, name, clsArr, clsB, false)) == null) {
            return null;
        }
        return methodC;
    }

    public final u0 s(String name, String signature) {
        kotlin.jvm.internal.m.f(name, "name");
        kotlin.jvm.internal.m.f(signature, "signature");
        ua.i iVarC = f14521c.c(signature);
        if (iVarC != null) {
            String str = iVarC.a().getMatch().b().get(1);
            u0 u0VarW = w(Integer.parseInt(str));
            if (u0VarW != null) {
                return u0VarW;
            }
            throw new f0("Local property #" + str + " not found in " + d());
        }
        ba.f fVarL = ba.f.l(name);
        kotlin.jvm.internal.m.e(fVarL, "identifier(name)");
        Collection<u0> collectionZ = z(fVarL);
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionZ) {
            if (kotlin.jvm.internal.m.a(k0.f14515a.f((u0) obj).getString(), signature)) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            throw new f0("Property '" + name + "' (JVM signature: " + signature + ") not resolved in " + this);
        }
        if (arrayList.size() == 1) {
            return (u0) kotlin.collections.r.F0(arrayList);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj2 : arrayList) {
            kotlin.reflect.jvm.internal.impl.descriptors.u visibility = ((u0) obj2).getVisibility();
            Object arrayList2 = linkedHashMap.get(visibility);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                linkedHashMap.put(visibility, arrayList2);
            }
            ((List) arrayList2).add(obj2);
        }
        Collection collectionValues = kotlin.collections.n0.h(linkedHashMap, new m(f.f14530a)).values();
        kotlin.jvm.internal.m.e(collectionValues, "properties\n             …\n                }.values");
        List mostVisibleProperties = (List) kotlin.collections.r.r0(collectionValues);
        if (mostVisibleProperties.size() == 1) {
            kotlin.jvm.internal.m.e(mostVisibleProperties, "mostVisibleProperties");
            return (u0) kotlin.collections.r.g0(mostVisibleProperties);
        }
        ba.f fVarL2 = ba.f.l(name);
        kotlin.jvm.internal.m.e(fVarL2, "identifier(name)");
        String strQ0 = kotlin.collections.r.q0(z(fVarL2), "\n", null, null, 0, null, e.f14529a, 30, null);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Property '");
        sb2.append(name);
        sb2.append("' (JVM signature: ");
        sb2.append(signature);
        sb2.append(") not resolved in ");
        sb2.append(this);
        sb2.append(':');
        sb2.append(strQ0.length() == 0 ? " no members found" : '\n' + strQ0);
        throw new f0(sb2.toString());
    }

    /* JADX WARN: Code duplicated, block: B:12:0x004e  */
    protected final Collection<j<?>> x(kotlin.reflect.jvm.internal.impl.resolve.scopes.h scope, c belonginess) {
        j jVar;
        kotlin.jvm.internal.m.f(scope, "scope");
        kotlin.jvm.internal.m.f(belonginess, "belonginess");
        g gVar = new g(this);
        Collection<kotlin.reflect.jvm.internal.impl.descriptors.m> collectionA = kotlin.reflect.jvm.internal.impl.resolve.scopes.k.a.a(scope, null, null, 3, null);
        ArrayList arrayList = new ArrayList();
        for (kotlin.reflect.jvm.internal.impl.descriptors.m mVar : collectionA) {
            if (mVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.b) {
                kotlin.reflect.jvm.internal.impl.descriptors.b bVar = (kotlin.reflect.jvm.internal.impl.descriptors.b) mVar;
                if (kotlin.jvm.internal.m.a(bVar.getVisibility(), kotlin.reflect.jvm.internal.impl.descriptors.t.f13071h) || !belonginess.f(bVar)) {
                    jVar = null;
                } else {
                    jVar = (j) mVar.H(gVar, r8.z.f17874a);
                }
            } else {
                jVar = null;
            }
            if (jVar != null) {
                arrayList.add(jVar);
            }
        }
        return kotlin.collections.r.O0(arrayList);
    }

    private final Class<?> D(String desc, int begin, int end) throws ClassNotFoundException {
        char cCharAt = desc.charAt(begin);
        if (cCharAt == 'L') {
            ClassLoader classLoaderE = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.d.e(d());
            String strSubstring = desc.substring(begin + 1, end - 1);
            kotlin.jvm.internal.m.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            Class<?> clsLoadClass = classLoaderE.loadClass(ua.n.D(strSubstring, '/', '.', false, 4, null));
            kotlin.jvm.internal.m.e(clsLoadClass, "jClass.safeClassLoader.l…d - 1).replace('/', '.'))");
            return clsLoadClass;
        }
        if (cCharAt == '[') {
            return n0.f(D(desc, begin + 1, end));
        }
        if (cCharAt == 'V') {
            Class<?> TYPE = Void.TYPE;
            kotlin.jvm.internal.m.e(TYPE, "TYPE");
            return TYPE;
        }
        if (cCharAt == 'Z') {
            return Boolean.TYPE;
        }
        if (cCharAt == 'C') {
            return Character.TYPE;
        }
        if (cCharAt == 'B') {
            return Byte.TYPE;
        }
        if (cCharAt == 'S') {
            return Short.TYPE;
        }
        if (cCharAt == 'I') {
            return Integer.TYPE;
        }
        if (cCharAt == 'F') {
            return Float.TYPE;
        }
        if (cCharAt == 'J') {
            return Long.TYPE;
        }
        if (cCharAt == 'D') {
            return Double.TYPE;
        }
        throw new f0("Unknown type prefix in the method signature: " + desc);
    }

    private final void m(List<Class<?>> result, String desc, boolean isConstructor) {
        List<Class<?>> listA = A(desc);
        result.addAll(listA);
        int size = (listA.size() + 31) / 32;
        for (int i10 = 0; i10 < size; i10++) {
            Class<?> TYPE = Integer.TYPE;
            kotlin.jvm.internal.m.e(TYPE, "TYPE");
            result.add(TYPE);
        }
        if (isConstructor) {
            Class<?> DEFAULT_CONSTRUCTOR_MARKER = f14520b;
            result.remove(DEFAULT_CONSTRUCTOR_MARKER);
            kotlin.jvm.internal.m.e(DEFAULT_CONSTRUCTOR_MARKER, "DEFAULT_CONSTRUCTOR_MARKER");
            result.add(DEFAULT_CONSTRUCTOR_MARKER);
            return;
        }
        result.add(Object.class);
    }

    protected Class<?> y() {
        Class<?> clsF = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.d.f(d());
        if (clsF == null) {
            return d();
        }
        return clsF;
    }
}
