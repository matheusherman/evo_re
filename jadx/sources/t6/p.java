package t6;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f18956b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f18957c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f18958d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f18960f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f18961g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte f18955a = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Long f18959e = -1L;

    public void a(ByteBuffer byteBuffer) {
        byteBuffer.put(this.f18955a);
        byteBuffer.putInt(this.f18956b);
        byteBuffer.putInt(this.f18957c);
        if (this.f18957c > 0) {
            byteBuffer.put(this.f18958d.getBytes(StandardCharsets.UTF_8));
        }
        byteBuffer.putLong(this.f18959e.longValue());
        byteBuffer.putInt(this.f18960f);
        if (this.f18960f > 0) {
            byteBuffer.put(this.f18961g.getBytes(StandardCharsets.UTF_8));
        }
    }

    public int b() {
        return this.f18957c + 9 + (this.f18959e == null ? 0 : 8) + 4 + this.f18960f;
    }

    public void c(Long l10) {
        this.f18959e = l10;
    }

    public void d(String str) {
        this.f18958d = str;
        this.f18957c = ac.g.f(str) ? 0 : str.length();
    }

    public void e(int i10) {
        this.f18956b = i10;
    }

    public void f(String str) {
        this.f18961g = str;
        this.f18960f = ac.g.f(str) ? 0 : str.length();
    }

    public void g(byte b10) {
        this.f18955a = b10;
    }
}
