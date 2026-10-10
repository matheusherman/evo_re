package y3;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class u implements h3.u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f22380a = new j();

    @Override // h3.u
    public p3.b a(String str, h3.a aVar, int i10, int i11, Map<h3.g, ?> map) {
        if (aVar != h3.a.UPC_A) {
            throw new IllegalArgumentException("Can only encode UPC-A, but got " + aVar);
        }
        return this.f22380a.a('0' + str, h3.a.EAN_13, i10, i11, map);
    }
}
