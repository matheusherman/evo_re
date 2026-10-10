package ec;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class b<L, R> extends c<L, R> {
    private static final long serialVersionUID = 4954918890077093841L;
    public L left;
    public R right;

    @Override // ec.c
    public L f() {
        return this.left;
    }

    @Override // ec.c
    public R i() {
        return this.right;
    }

    public void j(R r10) {
        this.right = r10;
    }

    @Override // java.util.Map.Entry
    public R setValue(R r10) {
        R rI = i();
        j(r10);
        return rI;
    }
}
