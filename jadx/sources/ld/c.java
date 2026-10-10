package ld;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f15391a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f15392b;

    static class a extends c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        tc.b f15393c;

        public a(int i10, int i11) {
            super(i10, i11);
            this.f15393c = new tc.b(new wc.a());
        }
    }

    static class b extends c {
        public b(int i10, int i11) {
            super(i10, i11);
        }
    }

    public c(int i10, int i11) {
        this.f15391a = i10;
        this.f15392b = i11;
    }
}
