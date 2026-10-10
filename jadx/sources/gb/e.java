package gb;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
class e extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HashMap<String, CharSequence> f10562a = new HashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f10563b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f10564c;

    @Override // gb.b
    public int a(CharSequence charSequence, int i10, Writer writer) throws IOException {
        int length = this.f10564c;
        if (i10 + length > charSequence.length()) {
            length = charSequence.length() - i10;
        }
        while (length >= this.f10563b) {
            CharSequence charSequence2 = this.f10562a.get(charSequence.subSequence(i10, i10 + length).toString());
            if (charSequence2 != null) {
                writer.write(charSequence2.toString());
                return length;
            }
            length--;
        }
        return 0;
    }

    public e(CharSequence[]... charSequenceArr) {
        int i10 = Integer.MAX_VALUE;
        int i11 = 0;
        if (charSequenceArr != null) {
            int i12 = 0;
            for (CharSequence[] charSequenceArr2 : charSequenceArr) {
                this.f10562a.put(charSequenceArr2[0].toString(), charSequenceArr2[1]);
                int length = charSequenceArr2[0].length();
                i10 = length < i10 ? length : i10;
                if (length > i12) {
                    i12 = length;
                }
            }
            i11 = i12;
        }
        this.f10563b = i10;
        this.f10564c = i11;
    }
}
