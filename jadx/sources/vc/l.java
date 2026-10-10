package vc;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
class l {

    private static class a implements tc.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f19830a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f19831b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final tc.d f19832c;

        @Override // tc.c
        public String a() {
            return this.f19831b;
        }

        public a(int i10, String str, tc.d dVar) {
            this.f19830a = i10;
            this.f19831b = str;
            this.f19832c = dVar;
        }
    }

    private static class b implements tc.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f19833a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f19834b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f19835c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final tc.d f19836d;

        @Override // tc.c
        public String a() {
            return this.f19835c;
        }

        public b(int i10, int i11, String str, tc.d dVar) {
            this.f19833a = i10;
            this.f19834b = i11;
            this.f19835c = str;
            this.f19836d = dVar;
        }
    }

    static tc.c a(tc.i iVar, int i10, tc.d dVar) {
        return new b(iVar.e() * 4, i10, iVar.a(), dVar);
    }

    static tc.c b(tc.i iVar, tc.d dVar) {
        return new a(iVar.e() * 4, iVar.a(), dVar);
    }
}
