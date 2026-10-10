package r4;

import com.koushikdutta.async.l;
import com.koushikdutta.async.p;
import com.koushikdutta.async.r;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class c extends r {
    @Override // com.koushikdutta.async.r
    public l m(l lVar) {
        lVar.c(ByteBuffer.wrap((Integer.toString(lVar.A(), 16) + "\r\n").getBytes()));
        lVar.a(ByteBuffer.wrap("\r\n".getBytes()));
        return lVar;
    }

    public c(p pVar) {
        super(pVar);
    }

    @Override // com.koushikdutta.async.p
    public void end() {
        h(Integer.MAX_VALUE);
        n(new l());
        h(0);
    }
}
