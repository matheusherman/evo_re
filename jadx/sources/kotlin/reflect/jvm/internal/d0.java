package kotlin.reflect.jvm.internal;

import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.reflect.jvm.internal.impl.descriptors.f1;
import kotlin.reflect.jvm.internal.impl.types.w1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\n*\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u000e*\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0096\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR!\u0010%\u001a\b\u0012\u0004\u0012\u00020 0\u001f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010)\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u001bR\u0014\u0010-\u001a\u00020*8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,¨\u0006."}, d2 = {"Lkotlin/reflect/jvm/internal/d0;", "Li9/o;", "Lkotlin/reflect/jvm/internal/l;", "Lkotlin/reflect/jvm/internal/e0;", "container", "Lkotlin/reflect/jvm/internal/impl/descriptors/f1;", "descriptor", "<init>", "(Lkotlin/reflect/jvm/internal/e0;Lorg/jetbrains/kotlin/descriptors/TypeParameterDescriptor;)V", "Lkotlin/reflect/jvm/internal/impl/descriptors/e;", "Lkotlin/reflect/jvm/internal/k;", "d", "(Lkotlin/reflect/jvm/internal/impl/descriptors/e;)Lkotlin/reflect/jvm/internal/k;", "Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/descriptors/g;", "Ljava/lang/Class;", "a", "(Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/descriptors/g;)Ljava/lang/Class;", "", TransactionPartnerType.OTHER, "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lkotlin/reflect/jvm/internal/impl/descriptors/f1;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/TypeParameterDescriptor;", "", "Li9/n;", "b", "Lkotlin/reflect/jvm/internal/h0$a;", "getUpperBounds", "()Ljava/util/List;", "upperBounds", "c", "Lkotlin/reflect/jvm/internal/e0;", "getName", "name", "Li9/q;", "j", "()Li9/q;", "variance", "kotlin-reflection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class d0 implements i9.o, l {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final /* synthetic */ i9.k<Object>[] f12420d = {kotlin.jvm.internal.c0.g(new kotlin.jvm.internal.w(kotlin.jvm.internal.c0.b(d0.class), "upperBounds", "getUpperBounds()Ljava/util/List;"))};

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final f1 descriptor;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final h0.a upperBounds;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final e0 container;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "Lkotlin/reflect/jvm/internal/c0;", "kotlin.jvm.PlatformType", "invoke", "()Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    static final class b extends kotlin.jvm.internal.o implements c9.a<List<? extends c0>> {
        b() {
            super(0);
        }

        @Override // c9.a
        public final List<? extends c0> invoke() {
            List<kotlin.reflect.jvm.internal.impl.types.g0> upperBounds = d0.this.i().getUpperBounds();
            kotlin.jvm.internal.m.e(upperBounds, "descriptor.upperBounds");
            List<kotlin.reflect.jvm.internal.impl.types.g0> list = upperBounds;
            ArrayList arrayList = new ArrayList(kotlin.collections.r.w(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new c0((kotlin.reflect.jvm.internal.impl.types.g0) it.next(), null, 2, null));
            }
            return arrayList;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12424a;

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
            f12424a = iArr;
        }
    }

    public d0(e0 e0Var, f1 descriptor) {
        k<?> kVarD;
        Object objH;
        kotlin.jvm.internal.m.f(descriptor, "descriptor");
        this.descriptor = descriptor;
        this.upperBounds = h0.c(new b());
        if (e0Var == null) {
            kotlin.reflect.jvm.internal.impl.descriptors.m mVarB = i().b();
            kotlin.jvm.internal.m.e(mVarB, "descriptor.containingDeclaration");
            if (mVarB instanceof kotlin.reflect.jvm.internal.impl.descriptors.e) {
                objH = d((kotlin.reflect.jvm.internal.impl.descriptors.e) mVarB);
            } else {
                if (!(mVarB instanceof kotlin.reflect.jvm.internal.impl.descriptors.b)) {
                    throw new f0("Unknown type parameter container: " + mVarB);
                }
                kotlin.reflect.jvm.internal.impl.descriptors.m mVarB2 = ((kotlin.reflect.jvm.internal.impl.descriptors.b) mVarB).b();
                kotlin.jvm.internal.m.e(mVarB2, "declaration.containingDeclaration");
                if (mVarB2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.e) {
                    kVarD = d((kotlin.reflect.jvm.internal.impl.descriptors.e) mVarB2);
                } else {
                    kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.g gVar = mVarB instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.g ? (kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.g) mVarB : null;
                    if (gVar == null) {
                        throw new f0("Non-class callable descriptor must be deserialized: " + mVarB);
                    }
                    i9.d dVarE = b9.a.e(a(gVar));
                    kotlin.jvm.internal.m.d(dVarE, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
                    kVarD = (k) dVarE;
                }
                objH = mVarB.H(new e(kVarD), r8.z.f17874a);
            }
            kotlin.jvm.internal.m.e(objH, "when (val declaration = … $declaration\")\n        }");
            e0Var = (e0) objH;
        }
        this.container = e0Var;
    }

    @Override // kotlin.reflect.jvm.internal.l
    /* JADX INFO: renamed from: c, reason: from getter and merged with bridge method [inline-methods] */
    public f1 i() {
        return this.descriptor;
    }

    public boolean equals(Object other) {
        if (!(other instanceof d0)) {
            return false;
        }
        d0 d0Var = (d0) other;
        return kotlin.jvm.internal.m.a(this.container, d0Var.container) && kotlin.jvm.internal.m.a(getName(), d0Var.getName());
    }

    @Override // i9.o
    public List<i9.n> getUpperBounds() {
        T tB = this.upperBounds.b(this, f12420d[0]);
        kotlin.jvm.internal.m.e(tB, "<get-upperBounds>(...)");
        return (List) tB;
    }

    public int hashCode() {
        return (this.container.hashCode() * 31) + getName().hashCode();
    }

    public String toString() {
        return kotlin.jvm.internal.i0.INSTANCE.a(this);
    }

    private final Class<?> a(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.g gVar) {
        kotlin.reflect.jvm.internal.impl.load.kotlin.m mVar;
        kotlin.reflect.jvm.internal.impl.load.kotlin.s sVarG;
        Class<?> clsA;
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.f fVarY = gVar.Y();
        p9.f fVar = null;
        if (fVarY instanceof kotlin.reflect.jvm.internal.impl.load.kotlin.m) {
            mVar = (kotlin.reflect.jvm.internal.impl.load.kotlin.m) fVarY;
        } else {
            mVar = null;
        }
        if (mVar != null) {
            sVarG = mVar.g();
        } else {
            sVarG = null;
        }
        if (sVarG instanceof p9.f) {
            fVar = (p9.f) sVarG;
        }
        if (fVar != null && (clsA = fVar.a()) != null) {
            return clsA;
        }
        throw new f0("Container of deserialized member is not resolved: " + gVar);
    }

    private final k<?> d(kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
        i9.d dVarE;
        Class<?> clsP = n0.p(eVar);
        if (clsP != null) {
            dVarE = b9.a.e(clsP);
        } else {
            dVarE = null;
        }
        k<?> kVar = (k) dVarE;
        if (kVar != null) {
            return kVar;
        }
        throw new f0("Type parameter container is not resolved: " + eVar.b());
    }

    @Override // i9.o
    public String getName() {
        String strF = i().getName().f();
        kotlin.jvm.internal.m.e(strF, "descriptor.name.asString()");
        return strF;
    }

    @Override // i9.o
    public i9.q j() {
        int i10 = a.f12424a[i().j().ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 == 3) {
                    return i9.q.OUT;
                }
                throw new r8.n();
            }
            return i9.q.IN;
        }
        return i9.q.INVARIANT;
    }
}
