package k1;

import com.google.android.gms.common.Feature;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class p0 extends n {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ n.a f12065d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    p0(n.a aVar, Feature[] featureArr, boolean z10, int i10) {
        super(featureArr, z10, i10);
        this.f12065d = aVar;
    }

    @Override // k1.n
    protected final void b(com.google.android.gms.common.api.a.b bVar, e2.h hVar) {
        this.f12065d.f12049a.accept(bVar, hVar);
    }
}
