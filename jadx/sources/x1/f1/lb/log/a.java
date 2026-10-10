package x1.f1.lb.log;

import androidx.core.app.NotificationCompat;
import d7.c;
import java.net.InetAddress;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import org.apache.log4j.spi.LocationInfo;
import r8.p;
import r8.r;
import r8.z;
import x1.f1.lb.media.d;
import x1.f1.lb.util.d0;
import x1.f1.lb.util.k;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ=\u0010\u0013\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0015\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\f¢\u0006\u0004\b\u0015\u0010\u0016J%\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0006¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0006¢\u0006\u0004\b\u001c\u0010\u001dJ1\u0010\u001e\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0007\u001a\n  *\u0004\u0018\u00010\u00060\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u001e\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010+R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00101\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\"R\u0016\u0010\u0018\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\"RJ\u00107\u001a6\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060302j\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000603`48\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106¨\u00068"}, d2 = {"Lx1/f1/lb/log/a;", "", "<init>", "()V", "", "seq", "", "tag", "logTxt", "Lr8/z;", "k", "(JLjava/lang/String;Ljava/lang/String;)V", "", "servers", "j", "([Ljava/lang/String;)[Ljava/lang/String;", "logLevel", NotificationCompat.CATEGORY_MESSAGE, "stackTrace", "e", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "m", "([Ljava/lang/String;)V", "channelId", "uid", "did", "l", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "g", "(Ljava/lang/String;)V", "h", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "kotlin.jvm.PlatformType", "b", "Ljava/lang/String;", "Ld7/c;", "c", "Ld7/c;", "udpLogger", "Lmf/b;", "d", "Lmf/b;", "dns", "[Ljava/lang/String;", "originalServers", "Ljava/util/concurrent/atomic/AtomicLong;", "f", "Ljava/util/concurrent/atomic/AtomicLong;", "logSeq", "lastSentLogTxt", "Ljava/util/LinkedHashMap;", "Lr8/p;", "Lkotlin/collections/LinkedHashMap;", "i", "Ljava/util/LinkedHashMap;", "toSendLog", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f20729a;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final String tag;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static c udpLogger;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final mf.b dns;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static String[] originalServers;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static final AtomicLong logSeq;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static String lastSentLogTxt;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static String uid;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static LinkedHashMap<String, p<Long, String>> toSendLog;

    /* JADX INFO: renamed from: x1.f1.lb.log.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @f(c = "x1.f1.lb.log.RemoteLogger$sendLog$1", f = "RemoteLogger.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class C0416a extends l implements c9.p<l0, v8.f<? super z>, Object> {
        final /* synthetic */ String $logTxt;
        final /* synthetic */ c $logger;
        final /* synthetic */ long $seq;
        final /* synthetic */ String $tag;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0416a(long j10, String str, c cVar, String str2, v8.f<? super C0416a> fVar) {
            super(2, fVar);
            this.$seq = j10;
            this.$tag = str;
            this.$logger = cVar;
            this.$logTxt = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            return new C0416a(this.$seq, this.$tag, this.$logger, this.$logTxt, fVar);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
            return ((C0416a) create(l0Var, fVar)).invokeSuspend(z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.b.c();
            if (this.label == 0) {
                r.b(obj);
                if (this.$seq == 1) {
                    try {
                        a aVar = a.f20729a;
                        String str = this.$tag;
                        x1.f1.lb.util.z zVar = x1.f1.lb.util.z.f21470a;
                        this.$logger.b(a.f(aVar, 0L, str, "I", "app_start brand[" + zVar.f() + "] model[" + zVar.q() + "] mac[" + zVar.o() + "]", null, 16, null));
                    } catch (Throwable unused) {
                    }
                }
                try {
                    this.$logger.b(this.$logTxt);
                } catch (Throwable unused2) {
                }
                return z.f17874a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @f(c = "x1.f1.lb.log.RemoteLogger$setUdpLoggerServer$1", f = "RemoteLogger.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class b extends l implements c9.p<l0, v8.f<? super z>, Object> {
        final /* synthetic */ String[] $servers;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String[] strArr, v8.f<? super b> fVar) {
            super(2, fVar);
            this.$servers = strArr;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            return new b(this.$servers, fVar);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
            return ((b) create(l0Var, fVar)).invokeSuspend(z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.b.c();
            if (this.label == 0) {
                r.b(obj);
                try {
                    String[] strArrJ = a.f20729a.j(this.$servers);
                    a.originalServers = this.$servers;
                    c cVar = a.udpLogger;
                    if (cVar == null) {
                        of.a aVar = of.a.f16585a;
                        a.udpLogger = new c(strArrJ, aVar.f(), aVar.b(), aVar.k());
                    } else {
                        cVar.d(strArrJ);
                    }
                } catch (Throwable unused) {
                }
                return z.f17874a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        a aVar = new a();
        f20729a = aVar;
        tag = aVar.getClass().getSimpleName();
        dns = new mf.b();
        logSeq = new AtomicLong(1L);
        uid = "";
        toSendLog = new LinkedHashMap<>();
    }

    private final String e(long seq, String tag2, String logLevel, String msg, String stackTrace) {
        String str;
        try {
            k kVar = k.f21398a;
            int iY = kVar.y();
            int iU = kVar.u();
            String str2 = m.a(kVar.r(), "stb") ? "s" : "m";
            long jI = of.a.f16585a.i();
            String strT = kVar.t();
            x1.f1.lb.util.z zVar = x1.f1.lb.util.z.f21470a;
            Object objP = zVar.p();
            d0 d0Var = d0.f21360a;
            boolean zK = d0Var.k();
            boolean zL = d0Var.l();
            Object objR = zVar.r();
            Object objE = zVar.e();
            boolean zV = d.f20812a.v();
            if (objP == null) {
                objP = LocationInfo.NA;
            }
            if (objR == null) {
                objR = LocationInfo.NA;
            }
            if (objE == null) {
                objE = LocationInfo.NA;
            }
            if (stackTrace != null) {
                str = "\n" + stackTrace;
            } else {
                str = "";
            }
            return " [" + iY + "." + iU + "." + str2 + "." + jI + "][" + strT + "] msbkta[" + objP + objR + objE + (zK ? 1 : 0) + (zL ? 1 : 0) + (zV ? 1 : 0) + "] [" + seq + "] [" + logLevel + "] " + tag2 + ": " + msg + str;
        } catch (Throwable unused) {
            return null;
        }
    }

    static /* synthetic */ String f(a aVar, long j10, String str, String str2, String str3, String str4, int i10, Object obj) {
        if ((i10 & 16) != 0) {
            str4 = null;
        }
        return aVar.e(j10, str, str2, str3, str4);
    }

    public static /* synthetic */ void i(a aVar, String str, String str2, String str3, String str4, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            str4 = null;
        }
        aVar.h(str, str2, str3, str4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String[] j(String[] servers) {
        List listL;
        HashSet hashSet = new HashSet();
        for (String str : servers) {
            List<String> listG = new ua.l(":").g(str, 0);
            if (listG.isEmpty()) {
                listL = kotlin.collections.r.l();
                break;
            }
            ListIterator<String> listIterator = listG.listIterator(listG.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    listL = kotlin.collections.r.l();
                    break;
                }
                if (listIterator.previous().length() != 0) {
                    listL = kotlin.collections.r.K0(listG, listIterator.nextIndex() + 1);
                    break;
                }
            }
            String[] strArr = (String[]) listL.toArray(new String[0]);
            if (strArr.length == 2) {
                try {
                    Iterator<InetAddress> it = dns.a(strArr[0]).iterator();
                    while (it.hasNext()) {
                        String hostAddress = it.next().getHostAddress();
                        if (hostAddress != null) {
                            hashSet.add(hostAddress + ":" + strArr[1]);
                        }
                    }
                } catch (Throwable unused) {
                    hashSet.add(str);
                }
            }
        }
        return (String[]) hashSet.toArray(new String[0]);
    }

    private final void k(long seq, String tag2, String logTxt) {
        c cVar = udpLogger;
        if (cVar == null) {
            return;
        }
        j.d(m0.a(a1.b()), null, null, new C0416a(seq, tag2, cVar, logTxt, null), 3, null);
    }

    public final void g(String msg) {
        m.f(msg, "msg");
    }

    public final void h(String logLevel, String tag2, String msg, String stackTrace) {
        m.f(logLevel, "logLevel");
        m.f(tag2, "tag");
        m.f(msg, "msg");
        long andIncrement = logSeq.getAndIncrement();
        String strE = e(andIncrement, tag2, logLevel, msg, stackTrace);
        if (strE == null || m.a(strE, lastSentLogTxt)) {
            return;
        }
        lastSentLogTxt = strE;
        if (udpLogger == null) {
            synchronized (toSendLog) {
                toSendLog.put(strE, new p<>(Long.valueOf(andIncrement), tag2));
                z zVar = z.f17874a;
            }
            return;
        }
        if (uid.length() != 0) {
            k(andIncrement, tag2, strE);
            return;
        }
        synchronized (toSendLog) {
            toSendLog.put(strE, new p<>(Long.valueOf(andIncrement), tag2));
            z zVar2 = z.f17874a;
        }
    }

    public final void l(String channelId, String uid2, String did) {
        m.f(channelId, "channelId");
        m.f(uid2, "uid");
        m.f(did, "did");
        c cVar = udpLogger;
        if (cVar != null) {
            cVar.e(channelId, uid2, did);
        }
        uid = uid2;
        if (toSendLog.isEmpty()) {
            return;
        }
        synchronized (toSendLog) {
            try {
                for (Map.Entry<String, p<Long, String>> entry : toSendLog.entrySet()) {
                    m.e(entry, "next(...)");
                    Map.Entry<String, p<Long, String>> entry2 = entry;
                    a aVar = f20729a;
                    long jLongValue = entry2.getValue().c().longValue();
                    String strD = entry2.getValue().d();
                    String key = entry2.getKey();
                    m.e(key, "<get-key>(...)");
                    aVar.k(jLongValue, strD, key);
                }
                toSendLog.clear();
                z zVar = z.f17874a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void m(String[] servers) {
        m.f(servers, "servers");
        j.d(m0.a(a1.b()), null, null, new b(servers, null), 3, null);
    }

    private a() {
    }
}
