package mf;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.r;
import kotlin.jvm.internal.m;
import o6.e;
import okhttp3.q;
import q6.c;
import x.l1.b2.R$string;
import x1.f1.lb.util.d1;
import x1.f1.lb.util.u0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u0000 \u00192\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\n2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0014\u001a\n \u0012*\u0004\u0018\u00010\u00110\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lmf/b;", "Lokhttp3/q;", "<init>", "()V", "Lo6/c;", "response", "Ljava/util/ArrayList;", "Ljava/net/InetAddress;", "Lkotlin/collections/ArrayList;", "list", "", "c", "(Lo6/c;Ljava/util/ArrayList;)Ljava/util/List;", "", "hostname", "a", "(Ljava/lang/String;)Ljava/util/List;", "Lq6/b;", "kotlin.jvm.PlatformType", "Lq6/b;", "logger", "", "d", "J", "timeoutSeconds", "e", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class b implements q {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String f15806f = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static long f15807g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static long f15808h;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final q6.b logger = c.d(b.class);

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final long timeoutSeconds = 30;

    private final List<InetAddress> c(o6.c response, ArrayList<InetAddress> list) {
        if (response == null) {
            return new ArrayList();
        }
        if (response.a() == null || response.a().isEmpty()) {
            return new ArrayList();
        }
        Iterator<String> it = response.a().iterator();
        while (it.hasNext()) {
            list.add(f2.a.c(it.next()));
        }
        return list;
    }

    @Override // okhttp3.q
    public List<InetAddress> a(String hostname) {
        boolean z10;
        List<InetAddress> list;
        Object obj;
        m.f(hostname, "hostname");
        try {
            try {
                f15807g = d1.c();
                f15808h = 0L;
                if (f2.a.f(hostname)) {
                    List<InetAddress> listA = q.f16943b.a(hostname);
                    if (listA.isEmpty()) {
                        obj = listA;
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(f2.a.c(hostname));
                        obj = arrayList;
                    }
                    obj = listA;
                    return (List) obj;
                }
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                final ArrayList arrayList2 = new ArrayList();
                o6.b.c(hostname, new e() { // from class: mf.a
                    @Override // o6.e
                    public final void a(int i10, o6.c cVar) {
                        b.d(this.f15802a, arrayList2, countDownLatch, i10, cVar);
                    }
                });
                if (!countDownLatch.await(this.timeoutSeconds, TimeUnit.SECONDS) || arrayList2.isEmpty()) {
                    try {
                        u0 u0Var = u0.f21448a;
                        f15806f = u0.b(u0Var, R$string.resolving, null, 2, null);
                        List<InetAddress> listA2 = q.f16943b.a(hostname);
                        f15806f = u0.b(u0Var, R$string.pass, null, 2, null) + " (sys)";
                        list = listA2;
                    } catch (Exception e10) {
                        e = e10;
                        z10 = true;
                        this.logger.error("DNS resolver failure, will try system dns", e);
                        f15806f = u0.b(u0.f21448a, R$string.fail, null, 2, null) + " (" + e.getClass().getSimpleName() + ")";
                        return z10 ? r.l() : q.f16943b.a(hostname);
                    }
                } else {
                    f15806f = u0.b(u0.f21448a, R$string.pass, null, 2, null) + " (app)";
                    list = arrayList2;
                }
                return list;
            } finally {
                f15808h = d1.c();
            }
        } catch (Exception e11) {
            e = e11;
            z10 = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(b bVar, ArrayList arrayList, CountDownLatch countDownLatch, int i10, o6.c cVar) {
        bVar.c(cVar, arrayList);
        countDownLatch.countDown();
    }
}
