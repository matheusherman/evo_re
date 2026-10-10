package kotlin.reflect.jvm.internal;

import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.descriptors.f1;
import kotlin.reflect.jvm.internal.impl.types.k1;
import kotlin.reflect.jvm.internal.impl.types.s1;
import kotlin.reflect.jvm.internal.impl.types.w1;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001d\u0010 \u001a\u0004\u0018\u00010\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR!\u0010&\u001a\b\u0012\u0004\u0012\u00020\"0!8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u001d\u001a\u0004\b$\u0010%R\u0016\u0010)\u001a\u0004\u0018\u00010\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(¨\u0006+²\u0006\u0012\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00050!8\nX\u008a\u0084\u0002"}, d2 = {"Lkotlin/reflect/jvm/internal/c0;", "Lkotlin/jvm/internal/n;", "Lkotlin/reflect/jvm/internal/impl/types/g0;", IjkMediaMeta.IJKM_KEY_TYPE, "Lkotlin/Function0;", "Ljava/lang/reflect/Type;", "computeJavaType", "<init>", "(Lorg/jetbrains/kotlin/types/KotlinType;Lc9/a;)V", "Li9/e;", "i", "(Lkotlin/reflect/jvm/internal/impl/types/g0;)Li9/e;", "", TransactionPartnerType.OTHER, "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "a", "Lkotlin/reflect/jvm/internal/impl/types/g0;", "getType", "()Lorg/jetbrains/kotlin/types/KotlinType;", "Lkotlin/reflect/jvm/internal/h0$a;", "b", "Lkotlin/reflect/jvm/internal/h0$a;", "c", "()Li9/e;", "classifier", "", "Li9/p;", "d", "getArguments", "()Ljava/util/List;", "arguments", "f", "()Ljava/lang/reflect/Type;", "javaType", "parameterizedTypeArguments", "kotlin-reflection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class c0 implements kotlin.jvm.internal.n {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final /* synthetic */ i9.k<Object>[] f12369e = {kotlin.jvm.internal.c0.g(new kotlin.jvm.internal.w(kotlin.jvm.internal.c0.b(c0.class), "classifier", "getClassifier()Lkotlin/reflect/KClassifier;")), kotlin.jvm.internal.c0.g(new kotlin.jvm.internal.w(kotlin.jvm.internal.c0.b(c0.class), "arguments", "getArguments()Ljava/util/List;"))};

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final kotlin.reflect.jvm.internal.impl.types.g0 type;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final h0.a<Type> computeJavaType;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final h0.a classifier;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final h0.a arguments;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "Li9/p;", "kotlin.jvm.PlatformType", "invoke", "()Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    static final class a extends kotlin.jvm.internal.o implements c9.a<List<? extends i9.p>> {
        final /* synthetic */ c9.a<Type> $computeJavaType;

        /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.c0$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ljava/lang/reflect/Type;", "a", "()Ljava/lang/reflect/Type;"}, k = 3, mv = {1, 8, 0})
        static final class C0208a extends kotlin.jvm.internal.o implements c9.a<Type> {
            final /* synthetic */ int $i;
            final /* synthetic */ r8.i<List<Type>> $parameterizedTypeArguments$delegate;
            final /* synthetic */ c0 this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C0208a(c0 c0Var, int i10, r8.i<? extends List<? extends Type>> iVar) {
                super(0);
                this.this$0 = c0Var;
                this.$i = i10;
                this.$parameterizedTypeArguments$delegate = iVar;
            }

            @Override // c9.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Type invoke() {
                Type typeF = this.this$0.f();
                if (typeF instanceof Class) {
                    Class cls = (Class) typeF;
                    Class<?> componentType = cls.isArray() ? cls.getComponentType() : Object.class;
                    kotlin.jvm.internal.m.e(componentType, "{\n                      …                        }");
                    return componentType;
                }
                if (typeF instanceof GenericArrayType) {
                    if (this.$i == 0) {
                        Type genericComponentType = ((GenericArrayType) typeF).getGenericComponentType();
                        kotlin.jvm.internal.m.e(genericComponentType, "{\n                      …                        }");
                        return genericComponentType;
                    }
                    throw new f0("Array type has been queried for a non-0th argument: " + this.this$0);
                }
                if (!(typeF instanceof ParameterizedType)) {
                    throw new f0("Non-generic type has been queried for arguments: " + this.this$0);
                }
                Type type = (Type) a.b(this.$parameterizedTypeArguments$delegate).get(this.$i);
                if (type instanceof WildcardType) {
                    WildcardType wildcardType = (WildcardType) type;
                    Type[] lowerBounds = wildcardType.getLowerBounds();
                    kotlin.jvm.internal.m.e(lowerBounds, "argument.lowerBounds");
                    Type type2 = (Type) kotlin.collections.j.P(lowerBounds);
                    if (type2 == null) {
                        Type[] upperBounds = wildcardType.getUpperBounds();
                        kotlin.jvm.internal.m.e(upperBounds, "argument.upperBounds");
                        type = (Type) kotlin.collections.j.O(upperBounds);
                    } else {
                        type = type2;
                    }
                }
                kotlin.jvm.internal.m.e(type, "{\n                      …                        }");
                return type;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Ljava/lang/reflect/Type;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
        static final class c extends kotlin.jvm.internal.o implements c9.a<List<? extends Type>> {
            final /* synthetic */ c0 this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(c0 c0Var) {
                super(0);
                this.this$0 = c0Var;
            }

            @Override // c9.a
            public final List<? extends Type> invoke() {
                Type typeF = this.this$0.f();
                kotlin.jvm.internal.m.c(typeF);
                return kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.d.c(typeF);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public /* synthetic */ class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f12374a;

            static {
                int[] iArr = new int[w1.values().length];
                try {
                    iArr[w1.INVARIANT.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[w1.IN_VARIANCE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[w1.OUT_VARIANCE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                f12374a = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(c9.a<? extends Type> aVar) {
            super(0);
            this.$computeJavaType = aVar;
        }

        @Override // c9.a
        public final List<? extends i9.p> invoke() {
            i9.p pVarD;
            List<k1> listH0 = c0.this.getType().H0();
            if (listH0.isEmpty()) {
                return kotlin.collections.r.l();
            }
            r8.i iVarB = r8.j.b(r8.m.PUBLICATION, new c(c0.this));
            List<k1> list = listH0;
            c9.a<Type> aVar = this.$computeJavaType;
            c0 c0Var = c0.this;
            ArrayList arrayList = new ArrayList(kotlin.collections.r.w(list, 10));
            int i10 = 0;
            for (Object obj : list) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    kotlin.collections.r.v();
                }
                k1 k1Var = (k1) obj;
                if (k1Var.b()) {
                    pVarD = i9.p.INSTANCE.c();
                } else {
                    kotlin.reflect.jvm.internal.impl.types.g0 type = k1Var.getType();
                    kotlin.jvm.internal.m.e(type, "typeProjection.type");
                    c0 c0Var2 = new c0(type, aVar == null ? null : new C0208a(c0Var, i10, iVarB));
                    int i12 = b.f12374a[k1Var.a().ordinal()];
                    if (i12 == 1) {
                        pVarD = i9.p.INSTANCE.d(c0Var2);
                    } else if (i12 == 2) {
                        pVarD = i9.p.INSTANCE.a(c0Var2);
                    } else {
                        if (i12 != 3) {
                            throw new r8.n();
                        }
                        pVarD = i9.p.INSTANCE.b(c0Var2);
                    }
                }
                arrayList.add(pVarD);
                i10 = i11;
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List<Type> b(r8.i<? extends List<? extends Type>> iVar) {
            return (List) iVar.getValue();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Li9/e;", "a", "()Li9/e;"}, k = 3, mv = {1, 8, 0})
    static final class b extends kotlin.jvm.internal.o implements c9.a<i9.e> {
        b() {
            super(0);
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final i9.e invoke() {
            c0 c0Var = c0.this;
            return c0Var.i(c0Var.getType());
        }
    }

    public c0(kotlin.reflect.jvm.internal.impl.types.g0 type, c9.a<? extends Type> aVar) {
        kotlin.jvm.internal.m.f(type, "type");
        this.type = type;
        h0.a<Type> aVarC = null;
        h0.a<Type> aVar2 = aVar instanceof h0.a ? (h0.a) aVar : null;
        if (aVar2 != null) {
            aVarC = aVar2;
        } else if (aVar != null) {
            aVarC = h0.c(aVar);
        }
        this.computeJavaType = aVarC;
        this.classifier = h0.c(new b());
        this.arguments = h0.c(new a(aVar));
    }

    @Override // i9.n
    public i9.e c() {
        return (i9.e) this.classifier.b(this, f12369e[0]);
    }

    public boolean equals(Object other) {
        if (!(other instanceof c0)) {
            return false;
        }
        c0 c0Var = (c0) other;
        return kotlin.jvm.internal.m.a(this.type, c0Var.type) && kotlin.jvm.internal.m.a(c(), c0Var.c()) && kotlin.jvm.internal.m.a(getArguments(), c0Var.getArguments());
    }

    @Override // kotlin.jvm.internal.n
    public Type f() {
        h0.a<Type> aVar = this.computeJavaType;
        if (aVar != null) {
            return aVar.invoke();
        }
        return null;
    }

    @Override // i9.n
    public List<i9.p> getArguments() {
        T tB = this.arguments.b(this, f12369e[1]);
        kotlin.jvm.internal.m.e(tB, "<get-arguments>(...)");
        return (List) tB;
    }

    public int hashCode() {
        int iHashCode = this.type.hashCode() * 31;
        i9.e eVarC = c();
        return ((iHashCode + (eVarC != null ? eVarC.hashCode() : 0)) * 31) + getArguments().hashCode();
    }

    /* JADX INFO: renamed from: j, reason: from getter */
    public final kotlin.reflect.jvm.internal.impl.types.g0 getType() {
        return this.type;
    }

    public String toString() {
        return j0.f14485a.h(this.type);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final i9.e i(kotlin.reflect.jvm.internal.impl.types.g0 type) {
        kotlin.reflect.jvm.internal.impl.types.g0 type2;
        kotlin.reflect.jvm.internal.impl.descriptors.h hVarD = type.J0().d();
        if (hVarD instanceof kotlin.reflect.jvm.internal.impl.descriptors.e) {
            Class<?> clsP = n0.p((kotlin.reflect.jvm.internal.impl.descriptors.e) hVarD);
            if (clsP == null) {
                return null;
            }
            if (clsP.isArray()) {
                k1 k1Var = (k1) kotlin.collections.r.H0(type.H0());
                if (k1Var != null && (type2 = k1Var.getType()) != null) {
                    i9.e eVarI = i(type2);
                    if (eVarI != null) {
                        return new k(n0.f(b9.a.b(k9.b.a(eVarI))));
                    }
                    throw new f0("Cannot determine classifier for array element type: " + this);
                }
                return new k(clsP);
            }
            if (!s1.l(type)) {
                Class<?> clsD = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.d.d(clsP);
                if (clsD != null) {
                    clsP = clsD;
                }
                return new k(clsP);
            }
            return new k(clsP);
        }
        if (hVarD instanceof f1) {
            return new d0(null, (f1) hVarD);
        }
        if (!(hVarD instanceof e1)) {
            return null;
        }
        throw new r8.o("An operation is not implemented: Type alias classifiers are not yet supported");
    }

    public /* synthetic */ c0(kotlin.reflect.jvm.internal.impl.types.g0 g0Var, c9.a aVar, int i10, kotlin.jvm.internal.g gVar) {
        this(g0Var, (i10 & 2) != 0 ? null : aVar);
    }
}
