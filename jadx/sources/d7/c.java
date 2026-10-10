package d7;

import ac.g;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class c {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static q6.b f9650i = q6.c.d(c.class);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private InetSocketAddress f9652b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String[] f9654d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f9655e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f9656f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f9657g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f9658h;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private LinkedBlockingQueue<a> f9653c = new LinkedBlockingQueue<>(10000);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d7.a f9651a = new d7.a();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f9659a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f9660b;

        a(int i10, String str) {
            this.f9659a = i10;
            this.f9660b = str;
        }
    }

    private void c(int i10, String str) {
        if (this.f9652b == null || g.f(str)) {
            return;
        }
        this.f9653c.offer(new a(i10, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(1400).order(ByteOrder.BIG_ENDIAN);
        r6.b bVar = new r6.b();
        r6.a aVar = new r6.a();
        while (true) {
            try {
                a aVarTake = this.f9653c.take();
                if (aVarTake != null) {
                    String str = aVarTake.f9660b;
                    if (!g.f(str)) {
                        bVar.d(aVarTake.f9659a);
                        aVar.c(bVar);
                        String strSubstring = this.f9655e + str;
                        if (strSubstring.length() > 1300) {
                            strSubstring = strSubstring.substring(0, 1300);
                        }
                        bVar.e(strSubstring.length());
                        aVar.d(strSubstring.getBytes(StandardCharsets.UTF_8));
                        r6.c.a(aVar, byteBufferOrder);
                        d7.a aVar2 = this.f9651a;
                        if (aVar2 != null) {
                            aVar2.a(byteBufferOrder, this.f9652b);
                        }
                    }
                }
            } catch (Exception unused) {
                System.out.println("send log error.");
            }
        }
    }

    public void b(String str) {
        c(10003, str);
    }

    public void d(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return;
        }
        String[] strArrSplit = strArr[this.f9657g.hashCode() % strArr.length].split(":");
        if (strArrSplit.length != 2) {
            return;
        }
        this.f9652b = new InetSocketAddress(strArrSplit[0], Integer.parseInt(strArrSplit[1]));
    }

    public void e(String str, String str2, String str3) {
        this.f9656f = str;
        this.f9657g = str2;
        this.f9658h = str3;
        this.f9655e = String.format("[%s][%s][%s]", str, str2, str3);
    }

    public c(String[] strArr, String str, String str2, String str3) {
        this.f9654d = strArr;
        e(str, str2, str3);
        d(strArr);
        new Thread(new Runnable() { // from class: d7.b
            @Override // java.lang.Runnable
            public final void run() {
                this.f9649a.f();
            }
        }, "log-thread").start();
    }
}
