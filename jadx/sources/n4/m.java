package n4;

import android.graphics.Rect;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private m4.p f15941a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f15942b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f15943c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private q f15944d = new n();

    public m4.p b(boolean z10) {
        m4.p pVar = this.f15941a;
        if (pVar == null) {
            return null;
        }
        return z10 ? pVar.f() : pVar;
    }

    public int c() {
        return this.f15942b;
    }

    public Rect d(m4.p pVar) {
        return this.f15944d.d(pVar, this.f15941a);
    }

    public void e(q qVar) {
        this.f15944d = qVar;
    }

    public m(int i10, m4.p pVar) {
        this.f15942b = i10;
        this.f15941a = pVar;
    }

    public m4.p a(List<m4.p> list, boolean z10) {
        return this.f15944d.b(list, b(z10));
    }
}
