package x6;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class e {
    public static s6.a a(ByteBuffer byteBuffer) {
        s6.a aVar = new s6.a();
        if (byteBuffer.remaining() < 64) {
            return null;
        }
        aVar.v(byteBuffer.getInt());
        int i10 = byteBuffer.getInt();
        if (i10 != -182581298) {
            return null;
        }
        aVar.z(i10);
        aVar.s(byteBuffer.getShort());
        aVar.E(byteBuffer.getLong());
        aVar.y(byteBuffer.getInt());
        aVar.r(byteBuffer.getLong());
        aVar.B(byteBuffer.getLong());
        aVar.A(byteBuffer.getInt());
        aVar.w(byteBuffer.getInt());
        aVar.x(byteBuffer.getShort());
        aVar.q(byteBuffer.getInt());
        aVar.C(byteBuffer.getInt());
        aVar.D(byteBuffer.getInt());
        int i11 = byteBuffer.getInt();
        if (i11 > 1500) {
            return null;
        }
        aVar.u(i11);
        if (i11 > 0) {
            byte[] bArr = new byte[i11];
            byteBuffer.get(bArr);
            aVar.t(bArr);
        }
        return aVar;
    }

    public static ByteBuffer b(s6.a aVar, int i10) {
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(aVar.f() + i10).order(ByteOrder.BIG_ENDIAN);
        byteBufferOrder.putInt(aVar.g());
        byteBufferOrder.putInt(aVar.k());
        byteBufferOrder.putShort(aVar.c());
        byteBufferOrder.putLong(aVar.p());
        byteBufferOrder.putInt(aVar.j());
        byteBufferOrder.putLong(aVar.b());
        byteBufferOrder.putLong(aVar.m());
        byteBufferOrder.putInt(aVar.l());
        byteBufferOrder.putInt(aVar.h());
        byteBufferOrder.putShort(aVar.i());
        byteBufferOrder.putInt(aVar.a());
        byteBufferOrder.putInt(aVar.n());
        byteBufferOrder.putInt(aVar.o());
        byteBufferOrder.putInt(aVar.e());
        if (aVar.e() > 0) {
            byteBufferOrder.put(aVar.d());
        }
        return byteBufferOrder;
    }
}
