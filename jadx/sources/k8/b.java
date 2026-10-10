package k8;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public enum b implements o8.a<Object> {
    INSTANCE,
    NEVER;

    @Override // o8.c
    public boolean isEmpty() {
        return true;
    }

    @Override // o8.c
    public Object poll() {
        return null;
    }

    @Override // h8.c
    public boolean f() {
        return this == INSTANCE;
    }

    @Override // o8.b
    public int j(int i10) {
        return i10 & 2;
    }

    @Override // o8.c
    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // o8.c
    public void clear() {
    }

    @Override // h8.c
    public void dispose() {
    }
}
