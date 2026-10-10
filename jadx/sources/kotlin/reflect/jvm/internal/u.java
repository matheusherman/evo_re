package kotlin.reflect.jvm.internal;

import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.descriptors.r0;
import kotlin.reflect.jvm.internal.impl.descriptors.x0;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B1\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0096\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0013R\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001b\u0010&\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R!\u0010,\u001a\b\u0012\u0004\u0012\u00020(0'8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b)\u0010#\u001a\u0004\b*\u0010+R\u0016\u0010.\u001a\u0004\u0018\u00010\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010\u0016R\u0014\u00102\u001a\u00020/8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u0014\u00105\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R\u0014\u00106\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u00104¨\u00067"}, d2 = {"Lkotlin/reflect/jvm/internal/u;", "Li9/j;", "Lkotlin/reflect/jvm/internal/j;", "callable", "", "index", "Li9/j$a;", "kind", "Lkotlin/Function0;", "Lkotlin/reflect/jvm/internal/impl/descriptors/r0;", "computeDescriptor", "<init>", "(Lkotlin/reflect/jvm/internal/j;ILi9/j$a;Lc9/a;)V", "", TransactionPartnerType.OTHER, "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "a", "Lkotlin/reflect/jvm/internal/j;", "i", "()Lkotlin/reflect/jvm/internal/j;", "b", "I", "getIndex", "c", "Li9/j$a;", "g", "()Li9/j$a;", "d", "Lkotlin/reflect/jvm/internal/h0$a;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ParameterDescriptor;", "descriptor", "", "", "e", "getAnnotations", "()Ljava/util/List;", "annotations", "getName", "name", "Li9/n;", "getType", "()Li9/n;", IjkMediaMeta.IJKM_KEY_TYPE, "h", "()Z", "isOptional", "isVararg", "kotlin-reflection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class u implements i9.j {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final /* synthetic */ i9.k<Object>[] f14559f = {kotlin.jvm.internal.c0.g(new kotlin.jvm.internal.w(kotlin.jvm.internal.c0.b(u.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ParameterDescriptor;")), kotlin.jvm.internal.c0.g(new kotlin.jvm.internal.w(kotlin.jvm.internal.c0.b(u.class), "annotations", "getAnnotations()Ljava/util/List;"))};

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final j<?> callable;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int index;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final i9.j.a kind;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final h0.a descriptor;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final h0.a annotations;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0002\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class a extends kotlin.jvm.internal.o implements c9.a<List<? extends Annotation>> {
        a() {
            super(0);
        }

        @Override // c9.a
        public final List<? extends Annotation> invoke() {
            return n0.e(u.this.j());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ljava/lang/reflect/Type;", "a", "()Ljava/lang/reflect/Type;"}, k = 3, mv = {1, 8, 0})
    static final class b extends kotlin.jvm.internal.o implements c9.a<Type> {
        b() {
            super(0);
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Type invoke() {
            r0 r0VarJ = u.this.j();
            if (!(r0VarJ instanceof x0) || !kotlin.jvm.internal.m.a(n0.i(u.this.i().w()), r0VarJ) || u.this.i().w().g() != kotlin.reflect.jvm.internal.impl.descriptors.b.a.FAKE_OVERRIDE) {
                return u.this.i().q().a().get(u.this.getIndex());
            }
            kotlin.reflect.jvm.internal.impl.descriptors.m mVarB = u.this.i().w().b();
            kotlin.jvm.internal.m.d(mVarB, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            Class<?> clsP = n0.p((kotlin.reflect.jvm.internal.impl.descriptors.e) mVarB);
            if (clsP != null) {
                return clsP;
            }
            throw new f0("Cannot determine receiver Java type of inherited declaration: " + r0VarJ);
        }
    }

    public u(j<?> callable, int i10, i9.j.a kind, c9.a<? extends r0> computeDescriptor) {
        kotlin.jvm.internal.m.f(callable, "callable");
        kotlin.jvm.internal.m.f(kind, "kind");
        kotlin.jvm.internal.m.f(computeDescriptor, "computeDescriptor");
        this.callable = callable;
        this.index = i10;
        this.kind = kind;
        this.descriptor = h0.c(computeDescriptor);
        this.annotations = h0.c(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final r0 j() {
        T tB = this.descriptor.b(this, f14559f[0]);
        kotlin.jvm.internal.m.e(tB, "<get-descriptor>(...)");
        return (r0) tB;
    }

    public boolean equals(Object other) {
        if (!(other instanceof u)) {
            return false;
        }
        u uVar = (u) other;
        return kotlin.jvm.internal.m.a(this.callable, uVar.callable) && getIndex() == uVar.getIndex();
    }

    @Override // i9.j
    /* JADX INFO: renamed from: g, reason: from getter */
    public i9.j.a getKind() {
        return this.kind;
    }

    @Override // i9.j
    public int getIndex() {
        return this.index;
    }

    @Override // i9.j
    public i9.n getType() {
        kotlin.reflect.jvm.internal.impl.types.g0 type = j().getType();
        kotlin.jvm.internal.m.e(type, "descriptor.type");
        return new c0(type, new b());
    }

    public int hashCode() {
        return (this.callable.hashCode() * 31) + getIndex();
    }

    public final j<?> i() {
        return this.callable;
    }

    public String toString() {
        return j0.f14485a.f(this);
    }

    @Override // i9.j
    public boolean a() {
        r0 r0VarJ = j();
        if ((r0VarJ instanceof j1) && ((j1) r0VarJ).h0() != null) {
            return true;
        }
        return false;
    }

    @Override // i9.j
    public String getName() {
        j1 j1Var;
        r0 r0VarJ = j();
        if (r0VarJ instanceof j1) {
            j1Var = (j1) r0VarJ;
        } else {
            j1Var = null;
        }
        if (j1Var == null || j1Var.b().A()) {
            return null;
        }
        ba.f name = j1Var.getName();
        kotlin.jvm.internal.m.e(name, "valueParameter.name");
        if (name.m()) {
            return null;
        }
        return name.f();
    }

    @Override // i9.j
    public boolean h() {
        j1 j1Var;
        r0 r0VarJ = j();
        if (r0VarJ instanceof j1) {
            j1Var = (j1) r0VarJ;
        } else {
            j1Var = null;
        }
        if (j1Var != null) {
            return ea.c.c(j1Var);
        }
        return false;
    }
}
