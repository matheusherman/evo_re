package gb;

import java.io.IOException;
import java.io.Writer;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
class f extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f10565a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f10566b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f10567c;

    public static f e(int i10, int i11) {
        return new f(i10, i11, true);
    }

    @Override // gb.c
    public boolean d(int i10, Writer writer) throws IOException {
        if (this.f10567c) {
            if (i10 < this.f10565a || i10 > this.f10566b) {
                return false;
            }
        } else if (i10 >= this.f10565a && i10 <= this.f10566b) {
            return false;
        }
        writer.write("&#");
        writer.write(Integer.toString(i10, 10));
        writer.write(59);
        return true;
    }

    private f(int i10, int i11, boolean z10) {
        this.f10565a = i10;
        this.f10566b = i11;
        this.f10567c = z10;
    }
}
