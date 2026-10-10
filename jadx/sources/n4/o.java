package n4;

import android.graphics.Rect;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class o extends q {
    private static float e(float f10) {
        return f10 < 1.0f ? 1.0f / f10 : f10;
    }

    @Override // n4.q
    protected float c(m4.p pVar, m4.p pVar2) {
        int i10 = pVar.f15654a;
        if (i10 <= 0 || pVar.f15655b <= 0) {
            return 0.0f;
        }
        float fE = (1.0f / e((i10 * 1.0f) / pVar2.f15654a)) / e((pVar.f15655b * 1.0f) / pVar2.f15655b);
        float fE2 = e(((pVar.f15654a * 1.0f) / pVar.f15655b) / ((pVar2.f15654a * 1.0f) / pVar2.f15655b));
        return fE * (((1.0f / fE2) / fE2) / fE2);
    }

    @Override // n4.q
    public Rect d(m4.p pVar, m4.p pVar2) {
        return new Rect(0, 0, pVar2.f15654a, pVar2.f15655b);
    }
}
