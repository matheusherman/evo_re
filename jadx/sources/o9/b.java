package o9;

import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.m1;
import kotlin.reflect.jvm.internal.impl.descriptors.n1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class b extends n1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f16512c = new b();

    private b() {
        super("protected_and_package", true);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.n1
    public Integer a(n1 visibility) {
        m.f(visibility, "visibility");
        if (m.a(this, visibility)) {
            return 0;
        }
        if (visibility == m1.b.f12989c) {
            return null;
        }
        return m1.f12985a.b(visibility) ? 1 : -1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.n1
    public String b() {
        return "protected/*protected and package*/";
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.n1
    public n1 d() {
        return m1.g.f12994c;
    }
}
