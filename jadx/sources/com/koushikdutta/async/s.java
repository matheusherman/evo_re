package com.koushikdutta.async;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class s implements o4.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Charset f5131a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    l f5132b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    a f5133c;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface a {
        void a(String str);
    }

    public s() {
        this(null);
    }

    public s(Charset charset) {
        this.f5132b = new l();
        this.f5131a = charset;
    }

    public void a(a aVar) {
        this.f5133c = aVar;
    }

    @Override // o4.b
    public void i(n nVar, l lVar) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(lVar.A());
        while (lVar.A() > 0) {
            byte bE = lVar.e();
            if (bE == 10) {
                byteBufferAllocate.flip();
                this.f5132b.a(byteBufferAllocate);
                this.f5133c.a(this.f5132b.x(this.f5131a));
                this.f5132b = new l();
                return;
            }
            byteBufferAllocate.put(bE);
        }
        byteBufferAllocate.flip();
        this.f5132b.a(byteBufferAllocate);
    }
}
