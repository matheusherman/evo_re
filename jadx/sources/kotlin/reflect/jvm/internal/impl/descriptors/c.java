package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.types.w1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class c implements f1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f1 f12739a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final m f12740b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f12741c;

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.f1
    public boolean k0() {
        return true;
    }

    public c(f1 originalDescriptor, m declarationDescriptor, int i10) {
        kotlin.jvm.internal.m.f(originalDescriptor, "originalDescriptor");
        kotlin.jvm.internal.m.f(declarationDescriptor, "declarationDescriptor");
        this.f12739a = originalDescriptor;
        this.f12740b = declarationDescriptor;
        this.f12741c = i10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
    public <R, D> R H(o<R, D> oVar, D d10) {
        return (R) this.f12739a.H(oVar, d10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.n, kotlin.reflect.jvm.internal.impl.descriptors.m
    public m b() {
        return this.f12740b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.f1
    public ka.n d0() {
        return this.f12739a.d0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.a
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.g getAnnotations() {
        return this.f12739a.getAnnotations();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.f1
    public int getIndex() {
        return this.f12741c + this.f12739a.getIndex();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j0
    public ba.f getName() {
        return this.f12739a.getName();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.p
    public a1 getSource() {
        return this.f12739a.getSource();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.f1
    public List<kotlin.reflect.jvm.internal.impl.types.g0> getUpperBounds() {
        return this.f12739a.getUpperBounds();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.f1, kotlin.reflect.jvm.internal.impl.descriptors.h
    public kotlin.reflect.jvm.internal.impl.types.g1 h() {
        return this.f12739a.h();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.f1
    public w1 j() {
        return this.f12739a.j();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h
    public kotlin.reflect.jvm.internal.impl.types.o0 p() {
        return this.f12739a.p();
    }

    public String toString() {
        return this.f12739a + "[inner-copy]";
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.f1
    public boolean z() {
        return this.f12739a.z();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
    public f1 a() {
        f1 f1VarA = this.f12739a.a();
        kotlin.jvm.internal.m.e(f1VarA, "originalDescriptor.original");
        return f1VarA;
    }
}
