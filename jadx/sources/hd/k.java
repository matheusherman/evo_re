package hd;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
abstract class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final int f10993a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final int f10994b;

    short a(short s10, short s11) {
        return (short) (s10 ^ s11);
    }

    protected abstract short b(short s10);

    protected abstract short c(short s10, short s11);

    public k(int i10) {
        this.f10993a = i10;
        this.f10994b = (1 << i10) - 1;
    }
}
