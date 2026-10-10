package la;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.collections.r;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.f1;
import kotlin.reflect.jvm.internal.impl.types.g0;
import kotlin.reflect.jvm.internal.impl.types.g1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class i implements g1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f15287a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String[] f15288b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f15289c;

    @Override // kotlin.reflect.jvm.internal.impl.types.g1
    public boolean e() {
        return false;
    }

    public i(j kind, String... formatParams) {
        m.f(kind, "kind");
        m.f(formatParams, "formatParams");
        this.f15287a = kind;
        this.f15288b = formatParams;
        String strF = b.ERROR_TYPE.f();
        String strF2 = kind.f();
        Object[] objArrCopyOf = Arrays.copyOf(formatParams, formatParams.length);
        String str = String.format(strF2, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
        m.e(str, "format(this, *args)");
        String str2 = String.format(strF, Arrays.copyOf(new Object[]{str}, 1));
        m.e(str2, "format(this, *args)");
        this.f15289c = str2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g1
    public g1 c(kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
        m.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g1
    public kotlin.reflect.jvm.internal.impl.descriptors.h d() {
        return k.f15326a.h();
    }

    public final j g() {
        return this.f15287a;
    }

    public final String h(int i10) {
        return this.f15288b[i10];
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g1
    public kotlin.reflect.jvm.internal.impl.builtins.h l() {
        return kotlin.reflect.jvm.internal.impl.builtins.e.f12460h.a();
    }

    public String toString() {
        return this.f15289c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g1
    public Collection<g0> b() {
        return r.l();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g1
    public List<f1> getParameters() {
        return r.l();
    }
}
