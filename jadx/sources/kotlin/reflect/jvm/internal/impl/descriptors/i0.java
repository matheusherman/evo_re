package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import java.util.Map;
import na.k;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class i0<Type extends na.k> extends h1<Type> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<r8.p<ba.f, Type>> f12760a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<ba.f, Type> f12761b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public i0(List<? extends r8.p<ba.f, ? extends Type>> underlyingPropertyNamesToTypes) {
        super(null);
        kotlin.jvm.internal.m.f(underlyingPropertyNamesToTypes, "underlyingPropertyNamesToTypes");
        this.f12760a = underlyingPropertyNamesToTypes;
        Map<ba.f, Type> mapQ = kotlin.collections.n0.q(a());
        if (mapQ.size() != a().size()) {
            throw new IllegalArgumentException("Some properties have the same names");
        }
        this.f12761b = mapQ;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h1
    public List<r8.p<ba.f, Type>> a() {
        return this.f12760a;
    }

    public String toString() {
        return "MultiFieldValueClassRepresentation(underlyingPropertyNamesToTypes=" + a() + ')';
    }
}
