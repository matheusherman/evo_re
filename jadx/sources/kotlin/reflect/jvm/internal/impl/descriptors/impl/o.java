package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.reflect.jvm.internal.impl.descriptors.u0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class o extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.b implements kotlin.reflect.jvm.internal.impl.descriptors.w {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final u0 f12884b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(kotlin.reflect.jvm.internal.impl.descriptors.annotations.g annotations, u0 correspondingProperty) {
        super(annotations);
        kotlin.jvm.internal.m.f(annotations, "annotations");
        kotlin.jvm.internal.m.f(correspondingProperty, "correspondingProperty");
        this.f12884b = correspondingProperty;
    }
}
