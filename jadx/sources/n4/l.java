package n4;

import android.graphics.Rect;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class l extends q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f15940b = "l";

    @Override // n4.q
    protected float c(m4.p pVar, m4.p pVar2) {
        if (pVar.f15654a <= 0 || pVar.f15655b <= 0) {
            return 0.0f;
        }
        m4.p pVarI = pVar.i(pVar2);
        float fPow = (pVarI.f15654a * 1.0f) / pVar.f15654a;
        if (fPow > 1.0f) {
            fPow = (float) Math.pow(1.0f / fPow, 1.1d);
        }
        float f10 = ((pVarI.f15654a * 1.0f) / pVar2.f15654a) + ((pVarI.f15655b * 1.0f) / pVar2.f15655b);
        return fPow * ((1.0f / f10) / f10);
    }

    @Override // n4.q
    public Rect d(m4.p pVar, m4.p pVar2) {
        m4.p pVarI = pVar.i(pVar2);
        Log.i(f15940b, "Preview: " + pVar + "; Scaled: " + pVarI + "; Want: " + pVar2);
        int i10 = (pVarI.f15654a - pVar2.f15654a) / 2;
        int i11 = (pVarI.f15655b - pVar2.f15655b) / 2;
        return new Rect(-i10, -i11, pVarI.f15654a - i10, pVarI.f15655b - i11);
    }
}
