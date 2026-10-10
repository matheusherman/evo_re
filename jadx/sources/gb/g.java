package gb;

import java.io.Writer;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
class g extends c {
    g() {
    }

    @Override // gb.c
    public boolean d(int i10, Writer writer) {
        if (i10 >= 55296 && i10 <= 57343) {
            return true;
        }
        return false;
    }
}
