package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.Set;
import kotlin.collections.v0;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.f1;
import kotlin.reflect.jvm.internal.impl.types.o0;
import kotlin.reflect.jvm.internal.impl.types.r1;
import kotlin.reflect.jvm.internal.impl.types.y;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class a extends y {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final r1 f13388d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final c f13389e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f13390f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f13391g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Set<f1> f13392h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final o0 f13393i;

    public /* synthetic */ a(r1 r1Var, c cVar, boolean z10, boolean z11, Set set, o0 o0Var, int i10, kotlin.jvm.internal.g gVar) {
        this(r1Var, (i10 & 2) != 0 ? c.INFLEXIBLE : cVar, (i10 & 4) != 0 ? false : z10, (i10 & 8) != 0 ? false : z11, (i10 & 16) != 0 ? null : set, (i10 & 32) != 0 ? null : o0Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ a f(a aVar, r1 r1Var, c cVar, boolean z10, boolean z11, Set set, o0 o0Var, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            r1Var = aVar.f13388d;
        }
        if ((i10 & 2) != 0) {
            cVar = aVar.f13389e;
        }
        if ((i10 & 4) != 0) {
            z10 = aVar.f13390f;
        }
        if ((i10 & 8) != 0) {
            z11 = aVar.f13391g;
        }
        if ((i10 & 16) != 0) {
            set = aVar.f13392h;
        }
        if ((i10 & 32) != 0) {
            o0Var = aVar.f13393i;
        }
        Set set2 = set;
        o0 o0Var2 = o0Var;
        return aVar.e(r1Var, cVar, z10, z11, set2, o0Var2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.y
    public o0 a() {
        return this.f13393i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.y
    public r1 b() {
        return this.f13388d;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.y
    public Set<f1> c() {
        return this.f13392h;
    }

    public final a e(r1 howThisTypeIsUsed, c flexibility, boolean z10, boolean z11, Set<? extends f1> set, o0 o0Var) {
        m.f(howThisTypeIsUsed, "howThisTypeIsUsed");
        m.f(flexibility, "flexibility");
        return new a(howThisTypeIsUsed, flexibility, z10, z11, set, o0Var);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return m.a(aVar.a(), a()) && aVar.b() == b() && aVar.f13389e == this.f13389e && aVar.f13390f == this.f13390f && aVar.f13391g == this.f13391g;
    }

    public final c g() {
        return this.f13389e;
    }

    public final boolean h() {
        return this.f13391g;
    }

    public final boolean i() {
        return this.f13390f;
    }

    public final a j(boolean z10) {
        return f(this, null, null, z10, false, null, null, 59, null);
    }

    public a k(o0 o0Var) {
        return f(this, null, null, false, false, null, o0Var, 31, null);
    }

    public final a l(c flexibility) {
        m.f(flexibility, "flexibility");
        return f(this, null, flexibility, false, false, null, null, 61, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.y
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public a d(f1 typeParameter) {
        m.f(typeParameter, "typeParameter");
        return f(this, null, null, false, false, c() != null ? v0.l(c(), typeParameter) : v0.d(typeParameter), null, 47, null);
    }

    public String toString() {
        return "JavaTypeAttributes(howThisTypeIsUsed=" + this.f13388d + ", flexibility=" + this.f13389e + ", isRaw=" + this.f13390f + ", isForAnnotationParameter=" + this.f13391g + ", visitedTypeParameters=" + this.f13392h + ", defaultType=" + this.f13393i + ')';
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public a(r1 howThisTypeIsUsed, c flexibility, boolean z10, boolean z11, Set<? extends f1> set, o0 o0Var) {
        super(howThisTypeIsUsed, set, o0Var);
        m.f(howThisTypeIsUsed, "howThisTypeIsUsed");
        m.f(flexibility, "flexibility");
        this.f13388d = howThisTypeIsUsed;
        this.f13389e = flexibility;
        this.f13390f = z10;
        this.f13391g = z11;
        this.f13392h = set;
        this.f13393i = o0Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.y
    public int hashCode() {
        int iHashCode;
        o0 o0VarA = a();
        if (o0VarA != null) {
            iHashCode = o0VarA.hashCode();
        } else {
            iHashCode = 0;
        }
        int iHashCode2 = iHashCode + (iHashCode * 31) + b().hashCode();
        int iHashCode3 = iHashCode2 + (iHashCode2 * 31) + this.f13389e.hashCode();
        int i10 = iHashCode3 + (iHashCode3 * 31) + (this.f13390f ? 1 : 0);
        return i10 + (i10 * 31) + (this.f13391g ? 1 : 0);
    }
}
