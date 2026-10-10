package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collection;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class j {
    public abstract void a(kotlin.reflect.jvm.internal.impl.descriptors.b bVar);

    public abstract void b(kotlin.reflect.jvm.internal.impl.descriptors.b bVar, kotlin.reflect.jvm.internal.impl.descriptors.b bVar2);

    public abstract void c(kotlin.reflect.jvm.internal.impl.descriptors.b bVar, kotlin.reflect.jvm.internal.impl.descriptors.b bVar2);

    public void d(kotlin.reflect.jvm.internal.impl.descriptors.b member, Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.b> overridden) {
        kotlin.jvm.internal.m.f(member, "member");
        kotlin.jvm.internal.m.f(overridden, "overridden");
        member.t0(overridden);
    }
}
