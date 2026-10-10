package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class e0 extends n1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.f1[] f14274c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final k1[] f14275d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f14276e;

    public /* synthetic */ e0(kotlin.reflect.jvm.internal.impl.descriptors.f1[] f1VarArr, k1[] k1VarArr, boolean z10, int i10, kotlin.jvm.internal.g gVar) {
        this(f1VarArr, k1VarArr, (i10 & 4) != 0 ? false : z10);
    }

    public e0(kotlin.reflect.jvm.internal.impl.descriptors.f1[] parameters, k1[] arguments, boolean z10) {
        kotlin.jvm.internal.m.f(parameters, "parameters");
        kotlin.jvm.internal.m.f(arguments, "arguments");
        this.f14274c = parameters;
        this.f14275d = arguments;
        this.f14276e = z10;
        int length = parameters.length;
        int length2 = arguments.length;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.n1
    public boolean b() {
        return this.f14276e;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.n1
    public k1 e(g0 key) {
        kotlin.jvm.internal.m.f(key, "key");
        kotlin.reflect.jvm.internal.impl.descriptors.h hVarD = key.J0().d();
        kotlin.reflect.jvm.internal.impl.descriptors.f1 f1Var = hVarD instanceof kotlin.reflect.jvm.internal.impl.descriptors.f1 ? (kotlin.reflect.jvm.internal.impl.descriptors.f1) hVarD : null;
        if (f1Var == null) {
            return null;
        }
        int index = f1Var.getIndex();
        kotlin.reflect.jvm.internal.impl.descriptors.f1[] f1VarArr = this.f14274c;
        if (index >= f1VarArr.length || !kotlin.jvm.internal.m.a(f1VarArr[index].h(), f1Var.h())) {
            return null;
        }
        return this.f14275d[index];
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.n1
    public boolean f() {
        return this.f14275d.length == 0;
    }

    public final k1[] i() {
        return this.f14275d;
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.f1[] j() {
        return this.f14274c;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public e0(List<? extends kotlin.reflect.jvm.internal.impl.descriptors.f1> parameters, List<? extends k1> argumentsList) {
        this((kotlin.reflect.jvm.internal.impl.descriptors.f1[]) parameters.toArray(new kotlin.reflect.jvm.internal.impl.descriptors.f1[0]), (k1[]) argumentsList.toArray(new k1[0]), false, 4, null);
        kotlin.jvm.internal.m.f(parameters, "parameters");
        kotlin.jvm.internal.m.f(argumentsList, "argumentsList");
    }
}
