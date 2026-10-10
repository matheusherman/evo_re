package r4;

import com.koushikdutta.async.l;
import com.koushikdutta.async.n;
import com.koushikdutta.async.q;
import com.koushikdutta.async.y;
import java.nio.ByteBuffer;
import java.util.zip.Inflater;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class g extends q {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Inflater f17840g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    l f17841h;

    public g() {
        this(new Inflater());
    }

    public g(Inflater inflater) {
        this.f17841h = new l();
        this.f17840g = inflater;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.koushikdutta.async.o
    public void w(Exception exc) {
        this.f17840g.end();
        if (exc != null && this.f17840g.getRemaining() > 0) {
            exc = new e("data still remaining in inflater", exc);
        }
        super.w(exc);
    }

    @Override // com.koushikdutta.async.q, o4.b
    public void i(n nVar, l lVar) {
        try {
            ByteBuffer byteBufferR = l.r(lVar.A() * 2);
            while (lVar.C() > 0) {
                ByteBuffer byteBufferB = lVar.B();
                if (byteBufferB.hasRemaining()) {
                    byteBufferB.remaining();
                    this.f17840g.setInput(byteBufferB.array(), byteBufferB.arrayOffset() + byteBufferB.position(), byteBufferB.remaining());
                    do {
                        byteBufferR.position(byteBufferR.position() + this.f17840g.inflate(byteBufferR.array(), byteBufferR.arrayOffset() + byteBufferR.position(), byteBufferR.remaining()));
                        if (!byteBufferR.hasRemaining()) {
                            byteBufferR.flip();
                            this.f17841h.a(byteBufferR);
                            byteBufferR = l.r(byteBufferR.capacity() * 2);
                        }
                        if (this.f17840g.needsInput()) {
                            break;
                        }
                    } while (!this.f17840g.finished());
                }
                l.y(byteBufferB);
            }
            byteBufferR.flip();
            this.f17841h.a(byteBufferR);
            y.a(this, this.f17841h);
        } catch (Exception e10) {
            w(e10);
        }
    }
}
