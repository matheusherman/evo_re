package w;

import androidx.annotation.NonNull;
import l.r;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class e extends u.i<c> implements r {
    @Override // l.v
    @NonNull
    public Class<c> b() {
        return c.class;
    }

    @Override // l.v
    public int getSize() {
        return ((c) this.f19307a).i();
    }

    @Override // u.i, l.r
    public void initialize() {
        ((c) this.f19307a).e().prepareToDraw();
    }

    @Override // l.v
    public void recycle() {
        ((c) this.f19307a).stop();
        ((c) this.f19307a).k();
    }

    public e(c cVar) {
        super(cVar);
    }
}
