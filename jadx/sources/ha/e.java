package ha;

import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.types.o0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class e implements g, i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.e f10907a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e f10908b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.e f10909c;

    public e(kotlin.reflect.jvm.internal.impl.descriptors.e classDescriptor, e eVar) {
        m.f(classDescriptor, "classDescriptor");
        this.f10907a = classDescriptor;
        this.f10908b = eVar == null ? this : eVar;
        this.f10909c = classDescriptor;
    }

    @Override // ha.g
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public o0 getType() {
        o0 o0VarP = this.f10907a.p();
        m.e(o0VarP, "classDescriptor.defaultType");
        return o0VarP;
    }

    public boolean equals(Object obj) {
        kotlin.reflect.jvm.internal.impl.descriptors.e eVar = this.f10907a;
        e eVar2 = obj instanceof e ? (e) obj : null;
        return m.a(eVar, eVar2 != null ? eVar2.f10907a : null);
    }

    public int hashCode() {
        return this.f10907a.hashCode();
    }

    @Override // ha.i
    public final kotlin.reflect.jvm.internal.impl.descriptors.e o() {
        return this.f10907a;
    }

    public String toString() {
        return "Class{" + getType() + '}';
    }
}
