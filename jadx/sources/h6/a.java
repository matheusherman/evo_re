package h6;

import android.graphics.PointF;
import android.view.View;
import g6.f;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class a implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PointF f10848a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f f10849b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f10850c = true;

    @Override // g6.f
    public boolean a(View view) {
        f fVar = this.f10849b;
        return fVar != null ? fVar.a(view) : i6.b.b(view, this.f10848a);
    }

    @Override // g6.f
    public boolean b(View view) {
        f fVar = this.f10849b;
        return fVar != null ? fVar.b(view) : i6.b.a(view, this.f10848a, this.f10850c);
    }
}
