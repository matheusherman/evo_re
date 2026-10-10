package fc;

import java.io.InputStream;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
abstract class t2 extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final InputStream f10227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f10228b;

    int a() {
        return this.f10228b;
    }

    protected void b(boolean z10) {
        InputStream inputStream = this.f10227a;
        if (inputStream instanceof q2) {
            ((q2) inputStream).d(z10);
        }
    }

    t2(InputStream inputStream, int i10) {
        this.f10227a = inputStream;
        this.f10228b = i10;
    }
}
