package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class r extends t implements u9.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Field f13052a;

    @Override // u9.n
    public boolean M() {
        return false;
    }

    public r(Field member) {
        kotlin.jvm.internal.m.f(member, "member");
        this.f13052a = member;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.t
    /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
    public Field Q() {
        return this.f13052a;
    }

    @Override // u9.n
    /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] */
    public z getType() {
        z.a aVar = z.f13060a;
        Type genericType = Q().getGenericType();
        kotlin.jvm.internal.m.e(genericType, "member.genericType");
        return aVar.a(genericType);
    }

    @Override // u9.n
    public boolean D() {
        return Q().isEnumConstant();
    }
}
