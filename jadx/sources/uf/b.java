package uf;

import com.google.gson.e;
import hb.d;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import okhttp3.b0;
import okhttp3.c0;
import okhttp3.d0;
import okhttp3.s;
import okhttp3.z;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import x1.f1.lb.util.d1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u000f\u001a\u00020\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J+\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00032\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001c\u001a\u00020\t¢\u0006\u0004\b\u001c\u0010\u000bR\u001c\u0010!\u001a\n \u001e*\u0004\u0018\u00010\u001d0\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010$\u001a\u00020\u00038\u0002X\u0082D¢\u0006\u0006\n\u0004\b\"\u0010#R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010%R\u0016\u0010(\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010'R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010'R\u0016\u0010,\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010+R\u001c\u0010/\u001a\b\u0012\u0004\u0012\u00020\r0-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010.R\u0014\u00101\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u0010+R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00106\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0014\u0010:\u001a\u0002078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109¨\u0006;"}, d2 = {"Luf/b;", "", "", "", "urls", "Lokhttp3/z;", "okHttpClient", "<init>", "([Ljava/lang/String;Lokhttp3/z;)V", "Lr8/z;", "c", "()V", "", "Lp6/c;", "list", "f", "(Ljava/util/List;)V", "eventName", "", "values", "d", "(Ljava/lang/String;Ljava/util/Map;)V", "Lokhttp3/c0;", "requestBody", IjkMediaPlayer.OnNativeInvokeListener.ARG_URL, "", "e", "(Lokhttp3/c0;Ljava/lang/String;)Z", "g", "Lq6/b;", "kotlin.jvm.PlatformType", "a", "Lq6/b;", "logger", "b", "Ljava/lang/String;", "METRIC_URI", "[Ljava/lang/String;", "", "I", "index", "batchSize", "", "J", "batchInterval", "Ljava/util/concurrent/LinkedBlockingQueue;", "Ljava/util/concurrent/LinkedBlockingQueue;", "queue", "h", "lastSendTime", "i", "Lokhttp3/z;", "j", "Z", "stopped", "Lcom/google/gson/e;", "k", "Lcom/google/gson/e;", "gson", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final q6.b logger;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final String METRIC_URI;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private String[] urls;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int index;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int batchSize;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long batchInterval;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private LinkedBlockingQueue<p6.c> queue;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final long lastSendTime;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private z okHttpClient;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private boolean stopped;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final e gson;

    public final void g() {
        this.stopped = true;
    }

    public b(String[] urls, z okHttpClient) {
        m.f(urls, "urls");
        m.f(okHttpClient, "okHttpClient");
        this.logger = q6.c.d(b.class);
        this.METRIC_URI = "/api/metric/batch/v1";
        this.batchSize = 100;
        this.batchInterval = 10000L;
        this.queue = new LinkedBlockingQueue<>(10000);
        this.lastSendTime = d1.c();
        this.stopped = true;
        this.gson = new e();
        this.urls = urls;
        this.stopped = false;
        this.okHttpClient = okHttpClient;
        new Thread(new Runnable() { // from class: uf.a
            @Override // java.lang.Runnable
            public final void run() {
                b.b(this.f19474a);
            }
        }, "metric-agent-thread").start();
    }

    private final void c() {
        ArrayList arrayList = new ArrayList();
        while (!this.stopped) {
            try {
                p6.c cVarTake = this.queue.take();
                if (cVarTake != null) {
                    arrayList.add(cVarTake);
                    if (arrayList.size() >= this.batchSize || d1.c() - this.lastSendTime > this.batchInterval) {
                        if (!arrayList.isEmpty()) {
                            f(arrayList);
                        }
                    }
                }
            } catch (Exception e10) {
                this.logger.error("send metric loop failure", e10);
            }
        }
    }

    public final void d(String eventName, Map<String, ? extends Object> values) {
        m.f(eventName, "eventName");
        m.f(values, "values");
        if (x1.f1.lb.config.b.f20643a.v() && !this.stopped) {
            p6.c cVar = new p6.c();
            cVar.setName(eventName);
            cVar.setValues(values);
            this.queue.offer(cVar);
        }
    }

    public final boolean e(c0 requestBody, String url) {
        m.f(requestBody, "requestBody");
        m.f(url, "url");
        d0 d0VarExecute = null;
        try {
            try {
                d0VarExecute = this.okHttpClient.a(new b0.a().k(url).h(requestBody).b()).execute();
                if (d0VarExecute.n()) {
                    d.m(d0VarExecute);
                    return true;
                }
            } catch (Exception e10) {
                this.logger.error("send metric failure", e10);
                if (d0VarExecute != null) {
                }
                return false;
            }
            d.m(d0VarExecute);
            return false;
        } catch (Throwable th) {
            if (d0VarExecute != null) {
                d.m(d0VarExecute);
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(b bVar) {
        bVar.c();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void f(List<p6.c> list) {
        String strC = p6.a.a().c(p6.b.a(this.gson.w(list)));
        try {
            s.a aVar = new s.a(null, 1, 0 == true ? 1 : 0);
            m.c(strC);
            s sVarC = aVar.a("data", strC).c();
            for (int i10 = 0; i10 < 4; i10++) {
                if (e(sVarC, this.urls[this.index] + this.METRIC_URI)) {
                    break;
                }
                int i11 = this.index + 1;
                this.index = i11;
                if (i11 >= this.urls.length) {
                    this.index = 0;
                }
            }
        } catch (Exception e10) {
            this.logger.error("send metric failure", e10);
        }
        list.clear();
    }
}
