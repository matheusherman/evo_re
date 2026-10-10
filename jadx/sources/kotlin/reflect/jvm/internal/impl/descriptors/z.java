package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import na.k;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class z<Type extends na.k> extends h1<Type> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ba.f f13090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Type f13091b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(ba.f underlyingPropertyName, Type underlyingType) {
        super(null);
        kotlin.jvm.internal.m.f(underlyingPropertyName, "underlyingPropertyName");
        kotlin.jvm.internal.m.f(underlyingType, "underlyingType");
        this.f13090a = underlyingPropertyName;
        this.f13091b = underlyingType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h1
    public List<r8.p<ba.f, Type>> a() {
        return kotlin.collections.r.e(r8.v.a(this.f13090a, this.f13091b));
    }

    public final ba.f c() {
        return this.f13090a;
    }

    public final Type d() {
        return this.f13091b;
    }

    public String toString() {
        return "InlineClassRepresentation(underlyingPropertyName=" + this.f13090a + ", underlyingType=" + this.f13091b + ')';
    }
}
