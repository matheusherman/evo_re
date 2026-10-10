package o6;

import io.netty.handler.codec.dns.DatagramDnsQuery;
import io.netty.handler.codec.dns.DefaultDnsQuestion;
import io.netty.handler.codec.dns.DnsRecord;
import io.netty.handler.codec.dns.DnsRecordType;
import io.netty.handler.codec.dns.DnsSection;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class i {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static q6.b f16485g = q6.c.d(i.class);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final List<InetSocketAddress> f16486h = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private k f16490d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ArrayBlockingQueue<a> f16487a = new ArrayBlockingQueue<>(100);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<Integer, a> f16488b = new ConcurrentHashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<String, c> f16489c = new ConcurrentHashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private AtomicInteger f16491e = new AtomicInteger(ac.f.a(10000, 20000));

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private e f16492f = new e() { // from class: o6.f
        @Override // o6.e
        public final void a(int i10, c cVar) {
            i.b(this.f16482a, i10, cVar);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: Infinite loop detected, blocks: 26, insns: 0 */
    public void d() {
        while (true) {
            try {
                if (this.f16490d.c()) {
                    a aVarTake = this.f16487a.take();
                    c cVar = this.f16489c.get(aVarTake.c());
                    if (cVar != null) {
                        aVarTake.e().a(-1, cVar);
                        this.f16488b.remove(Integer.valueOf(aVarTake.d()));
                    } else {
                        Iterator<InetSocketAddress> it = f16486h.iterator();
                        while (it.hasNext()) {
                            DatagramDnsQuery record = new DatagramDnsQuery(null, it.next(), aVarTake.d()).setRecord(DnsSection.QUESTION, (DnsRecord) new DefaultDnsQuestion(aVarTake.c(), DnsRecordType.A));
                            record.setRecursionDesired(true);
                            this.f16490d.d(record);
                        }
                    }
                } else {
                    Thread.sleep(1000L);
                }
            } catch (Exception e10) {
                f16485g.error("[DNS]DNS Execute error", e10);
            }
        }
    }

    public static /* synthetic */ void b(i iVar, int i10, c cVar) {
        a aVarRemove = iVar.f16488b.remove(Integer.valueOf(i10));
        if (aVarRemove == null) {
            return;
        }
        if (cVar.d() == 0) {
            iVar.f16489c.put(cVar.c(), cVar);
        }
        aVarRemove.e().a(i10, cVar);
    }

    public void e(String str, long j10, long j11, e eVar) {
        c cVar = this.f16489c.get(str);
        if (cVar != null && System.currentTimeMillis() - cVar.b() < j11) {
            eVar.a(-1, cVar);
            return;
        }
        a aVar = new a();
        aVar.i(this.f16491e.incrementAndGet());
        aVar.h(str);
        aVar.j(eVar);
        aVar.k(j10);
        this.f16488b.put(Integer.valueOf(aVar.d()), aVar);
        this.f16487a.offer(aVar);
    }

    public i() {
        List<InetSocketAddress> list = f16486h;
        list.add(new InetSocketAddress("1.1.1.1", 53));
        list.add(new InetSocketAddress("1.0.0.1", 53));
        list.add(new InetSocketAddress("8.8.8.8", 53));
        list.add(new InetSocketAddress("8.8.4.4", 53));
        list.add(new InetSocketAddress("9.9.9.9", 53));
        list.add(new InetSocketAddress("9.9.9.10", 53));
        this.f16490d = new k(this.f16492f);
        new Thread(new Runnable() { // from class: o6.g
            @Override // java.lang.Runnable
            public final void run() {
                this.f16483a.d();
            }
        }, "dns-execute-thread").start();
        new Thread(new Runnable() { // from class: o6.h
            @Override // java.lang.Runnable
            public final void run() {
                this.f16484a.f();
            }
        }, "dns-task-thread").start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: Infinite loop detected, blocks: 27, insns: 0 */
    public void f() {
        while (true) {
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                Iterator<Map.Entry<Integer, a>> it = this.f16488b.entrySet().iterator();
                while (it.hasNext()) {
                    a value = it.next().getValue();
                    if (jCurrentTimeMillis - value.a() > value.f()) {
                        it.remove();
                        c cVar = new c();
                        cVar.g(-1);
                        cVar.e(value.c());
                        value.e().a(value.d(), cVar);
                    } else if (jCurrentTimeMillis - value.b() > 3000) {
                        this.f16488b.put(Integer.valueOf(value.d()), value);
                        value.g(jCurrentTimeMillis);
                    }
                }
                Thread.sleep(1000L);
            } catch (Exception e10) {
                f16485g.error("[DNS] task error.", e10);
            }
        }
    }
}
