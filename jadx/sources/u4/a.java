package u4;

import com.koushikdutta.async.l;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f19344b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f19345c = 4096;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f19343a = l.f5115f;

    public void c(long j10) {
        this.f19344b = ((int) j10) * 2;
    }

    public ByteBuffer a() {
        return b(this.f19344b);
    }

    public ByteBuffer b(int i10) {
        return l.r(Math.min(Math.max(i10, this.f19345c), this.f19343a));
    }
}
