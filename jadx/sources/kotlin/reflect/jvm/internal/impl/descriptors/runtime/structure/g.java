package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class g extends f implements u9.c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Annotation f13033c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(ba.f fVar, Annotation annotation) {
        super(fVar, null);
        kotlin.jvm.internal.m.f(annotation, "annotation");
        this.f13033c = annotation;
    }

    @Override // u9.c
    public u9.a a() {
        return new e(this.f13033c);
    }
}
