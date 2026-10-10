package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0010\u0018\u00002\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\t\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lkotlin/reflect/jvm/internal/e;", "Lkotlin/reflect/jvm/internal/impl/descriptors/impl/l;", "Lkotlin/reflect/jvm/internal/j;", "Lr8/z;", "Lkotlin/reflect/jvm/internal/n;", "container", "<init>", "(Lkotlin/reflect/jvm/internal/n;)V", "Lkotlin/reflect/jvm/internal/impl/descriptors/y;", "descriptor", "data", "visitFunctionDescriptor", "(Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;Lr8/z;)Lkotlin/reflect/jvm/internal/j;", "Lkotlin/reflect/jvm/internal/impl/descriptors/u0;", "visitPropertyDescriptor", "(Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;Lr8/z;)Lkotlin/reflect/jvm/internal/j;", "a", "Lkotlin/reflect/jvm/internal/n;", "kotlin-reflection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class e extends kotlin.reflect.jvm.internal.impl.descriptors.impl.l<j<?>, r8.z> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final n container;

    public e(n container) {
        kotlin.jvm.internal.m.f(container, "container");
        this.container = container;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.l, kotlin.reflect.jvm.internal.impl.descriptors.o
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public j<?> g(kotlin.reflect.jvm.internal.impl.descriptors.y descriptor, r8.z data) {
        kotlin.jvm.internal.m.f(descriptor, "descriptor");
        kotlin.jvm.internal.m.f(data, "data");
        return new o(this.container, descriptor);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.o
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public j<?> d(u0 descriptor, r8.z data) {
        kotlin.jvm.internal.m.f(descriptor, "descriptor");
        kotlin.jvm.internal.m.f(data, "data");
        int i10 = (descriptor.b0() != null ? 1 : 0) + (descriptor.i0() != null ? 1 : 0);
        if (descriptor.f0()) {
            if (i10 == 0) {
                return new p(this.container, descriptor);
            }
            if (i10 == 1) {
                return new q(this.container, descriptor);
            }
            if (i10 == 2) {
                return new r(this.container, descriptor);
            }
        } else {
            if (i10 == 0) {
                return new v(this.container, descriptor);
            }
            if (i10 == 1) {
                return new w(this.container, descriptor);
            }
            if (i10 == 2) {
                return new x(this.container, descriptor);
            }
        }
        throw new f0("Unsupported property: " + descriptor);
    }
}
