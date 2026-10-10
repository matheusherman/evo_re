package r6;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class c {
    public static ByteBuffer a(a aVar, ByteBuffer byteBuffer) {
        byteBuffer.putInt(aVar.a().c());
        byteBuffer.putInt(aVar.a().a());
        byteBuffer.putInt(aVar.a().b());
        if (aVar.a().b() > 0) {
            byteBuffer.put(w6.c.a(aVar.b(), w6.c.f20090a));
        }
        return byteBuffer;
    }
}
