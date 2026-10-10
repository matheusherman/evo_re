package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class b0 extends p implements u9.b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final z f13013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Annotation[] f13014b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f13015c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f13016d;

    @Override // u9.d
    public boolean l() {
        return false;
    }

    public b0(z type, Annotation[] reflectAnnotations, String str, boolean z10) {
        kotlin.jvm.internal.m.f(type, "type");
        kotlin.jvm.internal.m.f(reflectAnnotations, "reflectAnnotations");
        this.f13013a = type;
        this.f13014b = reflectAnnotations;
        this.f13015c = str;
        this.f13016d = z10;
    }

    @Override // u9.b0
    /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
    public z getType() {
        return this.f13013a;
    }

    @Override // u9.b0
    public boolean a() {
        return this.f13016d;
    }

    @Override // u9.d
    public List<e> getAnnotations() {
        return i.b(this.f13014b);
    }

    @Override // u9.b0
    public ba.f getName() {
        String str = this.f13015c;
        if (str != null) {
            return ba.f.k(str);
        }
        return null;
    }

    @Override // u9.d
    public e j(ba.c fqName) {
        kotlin.jvm.internal.m.f(fqName, "fqName");
        return i.a(this.f13014b, fqName);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(b0.class.getName());
        sb2.append(": ");
        sb2.append(a() ? "vararg " : "");
        sb2.append(getName());
        sb2.append(": ");
        sb2.append(getType());
        return sb2.toString();
    }
}
