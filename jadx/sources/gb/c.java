package gb;

import java.io.Writer;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
abstract class c extends b {
    public abstract boolean d(int i10, Writer writer);

    c() {
    }

    @Override // gb.b
    public final int a(CharSequence charSequence, int i10, Writer writer) {
        return d(Character.codePointAt(charSequence, i10), writer) ? 1 : 0;
    }
}
