package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final q f13456a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<q> f13457b;

    /* JADX WARN: Multi-variable type inference failed */
    public k() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public k(q qVar, List<q> parametersInfo) {
        kotlin.jvm.internal.m.f(parametersInfo, "parametersInfo");
        this.f13456a = qVar;
        this.f13457b = parametersInfo;
    }

    public final List<q> a() {
        return this.f13457b;
    }

    public final q b() {
        return this.f13456a;
    }

    public /* synthetic */ k(q qVar, List list, int i10, kotlin.jvm.internal.g gVar) {
        this((i10 & 1) != 0 ? null : qVar, (i10 & 2) != 0 ? kotlin.collections.r.l() : list);
    }
}
