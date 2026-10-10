package t6;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte f18941a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f18942b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f18943c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f18944d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f18945e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f18946f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f18947g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private List<c> f18948h = new ArrayList();

    public void a(ByteBuffer byteBuffer) {
        byteBuffer.put(this.f18941a);
        byteBuffer.putInt(this.f18942b);
        if (this.f18942b > 0) {
            byteBuffer.put(this.f18943c.getBytes(StandardCharsets.UTF_8));
        }
        byteBuffer.putInt(this.f18944d);
        if (this.f18944d > 0) {
            byteBuffer.put(this.f18945e.getBytes(StandardCharsets.UTF_8));
        }
        byteBuffer.putInt(this.f18946f);
        byteBuffer.putLong(this.f18947g);
        Iterator<c> it = this.f18948h.iterator();
        while (it.hasNext()) {
            it.next().a(byteBuffer);
        }
    }

    public int b() {
        int i10 = this.f18942b + 9 + this.f18944d + 12;
        int size = 0;
        if (this.f18948h.size() != 0) {
            size = this.f18948h.size() * this.f18948h.get(0).b();
        }
        return i10 + size;
    }

    public void c(int i10) {
        this.f18946f = i10;
    }

    public void d(String str) {
        this.f18943c = str;
        this.f18942b = ac.g.f(str) ? 0 : str.length();
    }

    public void e(byte b10) {
        this.f18941a = b10;
    }

    public void f(String str) {
        this.f18945e = str;
        this.f18944d = ac.g.f(str) ? 0 : str.length();
    }
}
