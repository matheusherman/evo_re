package kotlin.reflect.jvm.internal;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\fJ\u0019\u0010\u0011\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lkotlin/reflect/jvm/internal/f;", "Lkotlin/reflect/jvm/internal/n;", "<init>", "()V", "", "G", "()Ljava/lang/Void;", "Lba/f;", "name", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/u0;", "z", "(Lba/f;)Ljava/util/Collection;", "Lkotlin/reflect/jvm/internal/impl/descriptors/y;", "v", "", "index", "w", "(I)Lkotlin/reflect/jvm/internal/impl/descriptors/u0;", "Ljava/lang/Class;", "d", "()Ljava/lang/Class;", "jClass", "Lkotlin/reflect/jvm/internal/impl/descriptors/l;", "u", "()Ljava/util/Collection;", "constructorDescriptors", "kotlin-reflection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class f extends n {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final f f12426d = new f();

    @Override // kotlin.reflect.jvm.internal.n
    public u0 w(int index) {
        return null;
    }

    private final Void G() {
        throw new f0("Introspecting local functions, lambdas, anonymous functions, local variables and typealiases is not yet fully supported in Kotlin reflection");
    }

    @Override // kotlin.reflect.jvm.internal.n
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.y> v(ba.f name) {
        kotlin.jvm.internal.m.f(name, "name");
        G();
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.n
    public Collection<u0> z(ba.f name) {
        kotlin.jvm.internal.m.f(name, "name");
        G();
        throw null;
    }

    private f() {
    }

    @Override // kotlin.jvm.internal.d
    public Class<?> d() {
        G();
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.n
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.l> u() {
        G();
        throw null;
    }
}
