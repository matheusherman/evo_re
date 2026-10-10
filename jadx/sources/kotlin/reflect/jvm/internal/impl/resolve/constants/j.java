package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.reflect.jvm.internal.impl.descriptors.h0;
import kotlin.reflect.jvm.internal.impl.types.g0;
import kotlin.reflect.jvm.internal.impl.types.o0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class j extends g<r8.p<? extends ba.b, ? extends ba.f>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ba.b f13900b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ba.f f13901c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(ba.b enumClassId, ba.f enumEntryName) {
        super(r8.v.a(enumClassId, enumEntryName));
        kotlin.jvm.internal.m.f(enumClassId, "enumClassId");
        kotlin.jvm.internal.m.f(enumEntryName, "enumEntryName");
        this.f13900b = enumClassId;
        this.f13901c = enumEntryName;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.g
    public g0 a(h0 module) {
        kotlin.jvm.internal.m.f(module, "module");
        kotlin.reflect.jvm.internal.impl.descriptors.e eVarA = kotlin.reflect.jvm.internal.impl.descriptors.x.a(module, this.f13900b);
        o0 o0VarP = null;
        if (eVarA != null) {
            if (!kotlin.reflect.jvm.internal.impl.resolve.e.A(eVarA)) {
                eVarA = null;
            }
            if (eVarA != null) {
                o0VarP = eVarA.p();
            }
        }
        if (o0VarP != null) {
            return o0VarP;
        }
        la.j jVar = la.j.Y1;
        String string = this.f13900b.toString();
        kotlin.jvm.internal.m.e(string, "enumClassId.toString()");
        String string2 = this.f13901c.toString();
        kotlin.jvm.internal.m.e(string2, "enumEntryName.toString()");
        return la.k.d(jVar, string, string2);
    }

    public final ba.f c() {
        return this.f13901c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.g
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f13900b.j());
        sb2.append('.');
        sb2.append(this.f13901c);
        return sb2.toString();
    }
}
