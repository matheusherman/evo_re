package k8;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class d extends AtomicReference<h8.c> implements h8.c {
    private static final long serialVersionUID = -754898800686245608L;

    public d() {
    }

    public d(h8.c cVar) {
        lazySet(cVar);
    }

    public boolean a(h8.c cVar) {
        return a.j(this, cVar);
    }

    @Override // h8.c
    public void dispose() {
        a.a(this);
    }

    @Override // h8.c
    public boolean f() {
        return a.i(get());
    }
}
