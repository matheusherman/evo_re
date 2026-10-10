package gb;

import java.io.Writer;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
class a extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b[] f10559a;

    @Override // gb.b
    public int a(CharSequence charSequence, int i10, Writer writer) {
        for (b bVar : this.f10559a) {
            int iA = bVar.a(charSequence, i10, writer);
            if (iA != 0) {
                return iA;
            }
        }
        return 0;
    }

    public a(b... bVarArr) {
        this.f10559a = bVarArr;
    }
}
