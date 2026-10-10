package ec;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class a<L, R> extends c<L, R> {
    private static final long serialVersionUID = 4954918890077093841L;
    public final L left;
    public final R right;

    @Override // ec.c
    public L f() {
        return this.left;
    }

    @Override // ec.c
    public R i() {
        return this.right;
    }

    @Override // java.util.Map.Entry
    public R setValue(R r10) {
        throw new UnsupportedOperationException();
    }

    public a(L l10, R r10) {
        this.left = l10;
        this.right = r10;
    }
}
