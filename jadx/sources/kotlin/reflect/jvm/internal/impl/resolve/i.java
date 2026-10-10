package kotlin.reflect.jvm.internal.impl.resolve;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class i extends j {
    protected abstract void e(kotlin.reflect.jvm.internal.impl.descriptors.b bVar, kotlin.reflect.jvm.internal.impl.descriptors.b bVar2);

    @Override // kotlin.reflect.jvm.internal.impl.resolve.j
    public void b(kotlin.reflect.jvm.internal.impl.descriptors.b first, kotlin.reflect.jvm.internal.impl.descriptors.b second) {
        kotlin.jvm.internal.m.f(first, "first");
        kotlin.jvm.internal.m.f(second, "second");
        e(first, second);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.j
    public void c(kotlin.reflect.jvm.internal.impl.descriptors.b fromSuper, kotlin.reflect.jvm.internal.impl.descriptors.b fromCurrent) {
        kotlin.jvm.internal.m.f(fromSuper, "fromSuper");
        kotlin.jvm.internal.m.f(fromCurrent, "fromCurrent");
        e(fromSuper, fromCurrent);
    }
}
