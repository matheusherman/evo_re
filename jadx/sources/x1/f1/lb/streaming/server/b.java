package x1.f1.lb.streaming.server;

import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.PointerIconCompat;
import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import nf.t;
import nf.v;
import org.apache.log4j.helpers.FileWatchdog;
import x1.f1.lb.util.d1;
import x1.f1.lb.util.w0;
import x1.f1.lb.util.z0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class b {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final q6.b f21020x = q6.c.d(b.class);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private x6.c f21021a;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final c f21033m;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f21022b = Long.toString(of.a.f16585a.i());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private vf.d f21023c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f21024d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f21025e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f21026f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f21027g = "";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f21028h = "";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f21029i = "";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private v6.c f21030j = v6.c.LIVE;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f21031k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final long f21032l = x1.f1.lb.user.f.f21202a.q0();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f21034n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f21035o = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f21036p = true;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final AtomicBoolean f21037q = new AtomicBoolean(false);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private Map<Integer, Long> f21038r = new HashMap();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private AtomicLong f21039s = new AtomicLong(0);

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f21040t = false;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private wf.a f21041u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private a7.a f21042v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final x6.d f21043w = new C0445b();

    /* JADX INFO: renamed from: x1.f1.lb.streaming.server.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class C0445b implements x6.d {
        /* JADX WARN: Code duplicated, block: B:44:0x0111 A[Catch: all -> 0x0045, TryCatch #0 {all -> 0x0045, blocks: (B:4:0x0003, B:41:0x00f8, B:46:0x0136, B:48:0x013c, B:52:0x0144, B:54:0x014a, B:56:0x0155, B:55:0x0150, B:43:0x00fe, B:44:0x0111, B:45:0x0124, B:29:0x0048, B:30:0x0064, B:31:0x007f, B:32:0x0092, B:33:0x00a5, B:34:0x00b8, B:35:0x00cb, B:36:0x00de), top: B:64:0x0003 }] */
        /* JADX WARN: Code duplicated, block: B:45:0x0124 A[Catch: all -> 0x0045, TryCatch #0 {all -> 0x0045, blocks: (B:4:0x0003, B:41:0x00f8, B:46:0x0136, B:48:0x013c, B:52:0x0144, B:54:0x014a, B:56:0x0155, B:55:0x0150, B:43:0x00fe, B:44:0x0111, B:45:0x0124, B:29:0x0048, B:30:0x0064, B:31:0x007f, B:32:0x0092, B:33:0x00a5, B:34:0x00b8, B:35:0x00cb, B:36:0x00de), top: B:64:0x0003 }] */
        private synchronized void k(String str, int i10) {
            String str2;
            String str3;
            try {
                Long l10 = (Long) b.this.f21038r.get(Integer.valueOf(i10));
                long jD = d1.d();
                if (l10 != null && i10 != -1000 && i10 != -4000) {
                    return;
                }
                if (i10 == -4000) {
                    str2 = String.format(Locale.ENGLISH, "[streaming][%d]\nconnect prt timeout\nmediaId:%s", Integer.valueOf(i10), str);
                } else if (i10 == -1000) {
                    str2 = String.format(Locale.ENGLISH, "[streaming][%d]\nconnect trk timeout\nmediaId:%s", Integer.valueOf(i10), str);
                } else if (i10 == 4008) {
                    str2 = String.format(Locale.ENGLISH, "[streaming][%d]\nfree media invalid\nmediaId:%s", Integer.valueOf(i10), str);
                } else if (i10 == 4101) {
                    str2 = String.format(Locale.ENGLISH, "[streaming][%d]\nstart play failure tr stopped\nmediaId:%s", Integer.valueOf(i10), str);
                } else if (i10 == 1000) {
                    str2 = String.format(Locale.ENGLISH, "[streaming][%d]\nallocate free media invalid\nmediaId:%s", Integer.valueOf(i10), str);
                } else if (i10 == 1001) {
                    str2 = String.format(Locale.ENGLISH, "[streaming][%d]\nallocate server invalid\nmediaId:%s", Integer.valueOf(i10), str);
                } else if (i10 != 4003) {
                    str2 = i10 != 4004 ? "" : String.format(Locale.ENGLISH, "[streaming][source][%d]\ninvalid stream id\n[%s] mediaId:%s", Integer.valueOf(i10), b.this.f21030j, str);
                } else {
                    str2 = String.format(Locale.ENGLISH, "[streaming][source][%d]\ninvalid stream\n[%s] mediaId:%s", Integer.valueOf(i10), b.this.f21030j, str);
                }
                if (i10 == 4006) {
                    str3 = String.format(Locale.ENGLISH, "[streaming][%d]\nexpired token\nmediaId:%s", Integer.valueOf(i10), str);
                } else if (i10 != 4007) {
                    switch (i10) {
                        case PointerIconCompat.TYPE_HAND /* 1002 */:
                            str3 = String.format(Locale.ENGLISH, "[streaming][%d]\nclient session out\nmediaId:%s", Integer.valueOf(i10), str);
                            break;
                        case PointerIconCompat.TYPE_HELP /* 1003 */:
                            str3 = String.format(Locale.ENGLISH, "[streaming][%d]\napp version not support\nmediaId:%s", Integer.valueOf(i10), str);
                            break;
                        case 1004:
                            str3 = String.format(Locale.ENGLISH, "[streaming][%d]\nexpired token\nmediaId:%s", Integer.valueOf(i10), str);
                            break;
                        default:
                            str3 = "";
                            break;
                    }
                } else {
                    str3 = String.format(Locale.ENGLISH, "[streaming][%d]\napp version not support\nmediaId:%s", Integer.valueOf(i10), str);
                }
                if (str3.isEmpty() && str2.isEmpty()) {
                    return;
                }
                if (str3.isEmpty()) {
                    x1.f1.lb.bot.a.f20583a.l(str2);
                } else {
                    x1.f1.lb.bot.a.f20583a.n(str3);
                }
                b.this.f21039s.set(jD);
                b.this.f21038r.put(Integer.valueOf(i10), Long.valueOf(jD));
                w0 w0Var = w0.f21452a;
                w0Var.t("sp_streaming_event_bot_time_in_ces", new com.google.gson.e().w(b.this.f21038r));
                w0Var.s("sp_streaming_last_bot_time_in_ces", jD);
            } catch (Throwable th) {
                b.f21020x.error("bot streaming event failure", th);
            }
        }

        C0445b() {
        }

        @Override // x6.d
        public void c(long j10, long j11, long j12) {
            d1.f("trk", j12, j10, j11);
        }

        @Override // x6.d
        public void d(String str, String str2, String str3) {
            q.f21130a.e(str, str2, str3);
        }

        @Override // x6.d
        public void e(String str, int i10, String str2) {
            String str3;
            int i11;
            String str4;
            if (i10 == 4101) {
                b.this.f21040t = false;
            }
            if (b.this.f21037q.compareAndSet(false, true)) {
                str3 = str;
                i11 = i10;
                str4 = str2;
                xe.c.c().l(new v(str3, b.this.f21024d, b.this.f21025e, i11, str4));
            } else {
                str3 = str;
                i11 = i10;
                str4 = str2;
            }
            if (x1.f1.lb.config.b.f20643a.t()) {
                b.f21020x.a("[Listener]On peer server event [{}][{}][{}]", b.this.f21022b, Integer.valueOf(i11), str4);
            }
            k(str3, i11);
        }

        @Override // x6.d
        public void f(String str, int i10, String str2) {
            if (x1.f1.lb.config.b.f20643a.t()) {
                b.f21020x.warn("[Listener]On tracker logout[{}, {}, {}, {}, {}, {}]", Long.valueOf(b.this.f21024d), str, b.this.f21030j, Integer.valueOf(b.this.f21031k), Integer.valueOf(i10), str2);
            }
            if (b.this.f21037q.compareAndSet(false, true)) {
                if (i10 == 1003) {
                    x1.f1.lb.user.f.f21202a.Z0("streaming", 2);
                } else if (i10 == 1002) {
                    x1.f1.lb.user.f.f21202a.Z0("streaming", 1);
                } else if (i10 == 1004) {
                    x1.f1.lb.user.f.f21202a.Z0("streaming", 3);
                } else {
                    x1.f1.lb.user.f.f21202a.Z0("streaming", 5);
                }
                k(str, i10);
            }
            xe.c.c().l(new v(str, b.this.f21024d, b.this.f21025e, i10, str2));
        }

        @Override // x6.d
        public void i(String str, int i10, String str2) {
            if (x1.f1.lb.config.b.f20643a.t()) {
                b.f21020x.warn("[Listener]On prt logout[{}, {}, {}, {}, {}, {}]", Long.valueOf(b.this.f21024d), str, b.this.f21030j, Integer.valueOf(b.this.f21031k), Integer.valueOf(i10), str2);
            }
            xe.c.c().o(new v(str, b.this.f21024d, b.this.f21025e, i10, str2));
            k(str, i10);
        }

        @Override // x6.d
        public void j(String str, int i10, int i11, int i12, int i13, long j10, int i14, long j11) {
            long j12;
            long j13 = b.this.f21039s.get();
            long jD = d1.d();
            if (j13 > 0 && j13 + FileWatchdog.DEFAULT_DELAY < jD && b.this.f21039s.compareAndSet(j13, 0L)) {
                Map map = b.this.f21038r;
                b.this.f21038r = new HashMap();
                w0 w0Var = w0.f21452a;
                w0Var.t("sp_streaming_event_bot_time_in_ces", "");
                w0Var.s("sp_streaming_last_bot_time_in_ces", 0L);
                String strB = d1.b(jD - j13, null);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("[streaming]");
                if (map.containsKey(4004) || map.containsKey(4003)) {
                    sb2.append("[source]");
                }
                sb2.append("\nrecovered\nmediaId:");
                sb2.append(str);
                sb2.append(", and ");
                sb2.append(strB);
                sb2.append(" back to normal\n");
                for (Map.Entry entry : map.entrySet()) {
                    String strB2 = d1.b(jD - ((Long) entry.getValue()).longValue(), null);
                    sb2.append(entry.getKey());
                    sb2.append(": ");
                    sb2.append(strB2);
                    sb2.append(" back to normal");
                    sb2.append("\n");
                }
                x1.f1.lb.bot.a.f20583a.m(sb2.toString());
            }
            vf.d dVar = b.this.f21023c;
            if (dVar == null) {
                j12 = 0;
                dVar = new vf.d(b.this.f21028h, str, b.this.f21032l, b.this.f21024d);
                dVar.playType = b.this.f21030j.name();
                dVar.mediaPlayMode = b.this.f21031k;
                b.this.f21035o = 0L;
                b.this.f21034n = 0L;
                b.this.f21023c = dVar;
            } else {
                j12 = 0;
            }
            long j14 = i11;
            b.this.f21035o += j14;
            b.this.f21034n += j10;
            int i15 = dVar.blockCnt + 1;
            dVar.blockCnt = i15;
            if (dVar.minBlockSize > i11) {
                dVar.minBlockSize = i11;
            } else if (dVar.maxBlockSize < i11) {
                dVar.maxBlockSize = i11;
            }
            double d10 = dVar.avgBlockSize;
            long j15 = j12;
            double d11 = i11;
            double d12 = i15;
            dVar.avgBlockSize = d10 + ((d11 - d10) / d12);
            int iPow = (int) Math.pow(10.0d, (int) Math.log10(d11));
            b.y(dVar.sizeDistributionMap, Integer.valueOf(iPow <= 0 ? 0 : (i11 / iPow) * iPow));
            if (dVar.minTime > j10) {
                dVar.minTime = j10;
            } else if (dVar.maxTime < j10) {
                dVar.maxTime = j10;
            }
            double d13 = dVar.avgTime;
            double d14 = j10;
            dVar.avgTime = d13 + ((d14 - d13) / d12);
            long jPow = (long) Math.pow(10.0d, (int) Math.log10(d14));
            b.y(dVar.timeDistribution, Long.valueOf(jPow <= j15 ? j15 : jPow * (j10 / jPow)));
            if (dVar.minResendCnt > i12) {
                dVar.minResendCnt = i12;
            } else if (dVar.maxResendCnt < i12) {
                dVar.maxResendCnt = i12;
            }
            double d15 = dVar.avgResendCnt;
            dVar.avgResendCnt = d15 + ((((double) i12) - d15) / d12);
            b.y(dVar.resendCntDistributionMap, Integer.valueOf(i12));
            if (dVar.minResendRate > i13) {
                dVar.minResendRate = i13;
            } else if (dVar.maxResendRate < i13) {
                dVar.maxResendRate = i13;
            }
            double d16 = dVar.avgResendRate;
            dVar.avgResendRate = d16 + ((((double) i13) - d16) / d12);
            b.y(dVar.resendRateDistributionMap, Integer.valueOf(i13 < 10 ? i13 : (i13 / 10) * 10));
            if (dVar.minAvgLossRate > i14) {
                dVar.minAvgLossRate = i14;
            } else if (dVar.maxAvgLossRate < i14) {
                dVar.maxAvgLossRate = i14;
            }
            double d17 = dVar.avgAvgLossRate;
            dVar.avgAvgLossRate = d17 + ((((double) i14) - d17) / d12);
            b.y(dVar.avgLossRateDistributionMap, Integer.valueOf(i14 < 10 ? i14 : (i14 / 10) * 10));
            long j16 = b.this.f21034n > j15 ? (b.this.f21035o * 8000) / b.this.f21034n : j15;
            int i16 = (int) j11;
            if (dVar.minRTT > j11) {
                dVar.minRTT = i16;
            } else if (dVar.maxRTT < j11) {
                dVar.maxRTT = i16;
            }
            double d18 = dVar.avgRTT;
            dVar.avgRTT = d18 + ((j11 - d18) / d12);
            b.this.f21033m.n(j14, i12, i13, j10, i14, j16, i16, dVar.minRTT, dVar.maxRTT, (int) dVar.avgRTT);
            long j17 = j16;
            if (x1.f1.lb.config.b.f20643a.t()) {
                b.f21020x.debug("onBlockMetric mediaId[{}], blockId[{}], blockSize[{}], resendCount[{}], resendRate[{}], avgLossRate[{}], avgSpeed[{}]", str, Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14), z0.f21483a.a(j17));
            }
        }

        @Override // x6.d
        public void a(int i10, String str) {
            xe.c.c().o(new t(b.this.f21024d, b.this.f21025e, i10, str));
            if (x1.f1.lb.config.b.f20643a.t()) {
                b.f21020x.a("[Listener]On notice [{}][{}]", Integer.valueOf(i10), str);
            }
        }

        @Override // x6.d
        public void b() {
            xe.c.c().l(new v(b.this.f21029i, b.this.f21024d, b.this.f21025e, NotificationManagerCompat.IMPORTANCE_UNSPECIFIED, ""));
            if (x1.f1.lb.config.b.f20643a.t()) {
                b.f21020x.a("[Listener]On tracker event [{}][{}][{}]", b.this.f21022b, Integer.valueOf(NotificationManagerCompat.IMPORTANCE_UNSPECIFIED), "");
            }
            k(b.this.f21029i, NotificationManagerCompat.IMPORTANCE_UNSPECIFIED);
        }

        @Override // x6.d
        public void g(String str) {
            xe.c.c().l(new v(str, b.this.f21024d, b.this.f21025e, -4000, ""));
            if (x1.f1.lb.config.b.f20643a.t()) {
                b.f21020x.a("[Listener]On prt event [{}][{}][{}]", b.this.f21022b, -4000, "");
            }
            k(str, -4000);
        }

        @Override // x6.d
        public void h(String str, int i10, String str2) {
            xe.c.c().l(new v(str, b.this.f21024d, b.this.f21025e, i10, str2));
            if (x1.f1.lb.config.b.f20643a.t()) {
                b.f21020x.a("[Listener]On tracker event [{}][{}][{}]", b.this.f21022b, Integer.valueOf(i10), str2);
            }
            k(str, i10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface c {
        void n(long j10, long j11, int i10, long j12, int i11, long j13, int i12, int i13, int i14, int i15);
    }

    /* JADX WARN: Code duplicated, block: B:101:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:69:0x0135 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:70:0x0136  */
    /* JADX WARN: Code duplicated, block: B:72:0x013c  */
    /* JADX WARN: Code duplicated, block: B:73:0x013e  */
    /* JADX WARN: Code duplicated, block: B:76:0x0147  */
    /* JADX WARN: Code duplicated, block: B:78:0x0152  */
    /* JADX WARN: Code duplicated, block: B:79:0x0154  */
    /* JADX WARN: Code duplicated, block: B:82:0x017d  */
    /* JADX WARN: Code duplicated, block: B:84:0x0186  */
    /* JADX WARN: Code duplicated, block: B:86:0x018f  */
    /* JADX WARN: Code duplicated, block: B:88:0x0197  */
    /* JADX WARN: Code duplicated, block: B:91:0x019f  */
    /* JADX WARN: Code duplicated, block: B:93:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:96:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:99:0x01bd  */
    public byte[] A(long j10, String str, String str2, int i10) {
        int i11;
        char c10;
        char c11;
        char c12;
        char c13;
        char c14;
        boolean z10;
        String str3;
        char c15;
        String localizedMessage;
        b7.a aVar;
        Object obj;
        x6.c cVar = this.f21021a;
        if (cVar == null) {
            if (!this.f21037q.get()) {
                throw new RuntimeException("engine is not init");
            }
            f21020x.warn("get data [{}] [{}], but kicked out", str, str2);
            return null;
        }
        if (j10 != this.f21024d || !Objects.equals(this.f21029i, str)) {
            f21020x.warn("get data mismatch, request play_session[{}] mediaId[{}], but now session[{}] mediaId[{}]", Long.valueOf(j10), str, Long.valueOf(this.f21024d), this.f21029i);
            return null;
        }
        try {
            long jC = d1.c();
            v6.b bVarJ = v6.b.j(yb.d.c(str2));
            try {
                if (bVarJ == null) {
                    throw new RuntimeException("Unknown extension");
                }
                byte[] bArrQ = cVar.q(bVarJ, str, str2);
                c10 = 2;
                try {
                    int i12 = i10 / 10;
                    if (i12 < 1) {
                        i12 = 1;
                    }
                    int i13 = 0;
                    c11 = 3;
                    while (bArrQ == null && i13 < i12) {
                        try {
                            bArrQ = cVar.q(bVarJ, str, str2);
                            if (bArrQ == null) {
                                try {
                                    Thread.sleep(10L);
                                    i13++;
                                } catch (InterruptedException e10) {
                                    throw new RuntimeException(e10);
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            i11 = 1;
                        }
                    }
                    if (x1.f1.lb.config.b.f20643a.t()) {
                        int length = bArrQ != null ? bArrQ.length : 0;
                        String strB = d1.b(d1.c() - jC, null);
                        try {
                            if (str2.contains(".ts")) {
                                try {
                                    c13 = 4;
                                    c12 = 5;
                                    f21020x.debug("zapping_time_opt client_service_get_data_ts [{}/{}], size[{}] [{}] play_session request[{}] server[{}]", str, str2, Integer.valueOf(length), strB, Long.valueOf(j10), Long.valueOf(this.f21024d));
                                } catch (Throwable th2) {
                                    th = th2;
                                    c13 = 4;
                                    c12 = 5;
                                    i11 = 1;
                                    c14 = 0;
                                    if (!cVar.r()) {
                                        return null;
                                    }
                                    if (this.f21026f >= j10) {
                                        z10 = true;
                                    } else {
                                        z10 = false;
                                    }
                                    if (th instanceof b7.a) {
                                        aVar = th;
                                        Locale locale = Locale.ENGLISH;
                                        Long lValueOf = Long.valueOf(j10);
                                        if (z10) {
                                            obj = "closed";
                                        } else {
                                            obj = "active";
                                        }
                                        Integer numValueOf = Integer.valueOf(aVar.a());
                                        String strB2 = aVar.b();
                                        Object[] objArr = new Object[6];
                                        objArr[c14] = lValueOf;
                                        objArr[i11] = obj;
                                        objArr[c10] = str;
                                        objArr[c11] = str2;
                                        objArr[c13] = numValueOf;
                                        objArr[c12] = strB2;
                                        str3 = String.format(locale, "get data failure, [%d/%s] [%s/%s], %d:%s", objArr);
                                        if (aVar.a() == 2001) {
                                            f21020x.warn(str3, new Object[0]);
                                            return null;
                                        }
                                        if (aVar.a() == 1001) {
                                            f21020x.warn(str3, new Object[0]);
                                            return null;
                                        }
                                    } else {
                                        str3 = "";
                                    }
                                    if (ac.g.f(str3)) {
                                        localizedMessage = th.getLocalizedMessage();
                                        if (ac.g.f(localizedMessage)) {
                                            localizedMessage = th.getMessage();
                                        }
                                        if (ac.g.f(localizedMessage)) {
                                            localizedMessage = "get data failure,";
                                        }
                                        Locale locale2 = Locale.ENGLISH;
                                        Long lValueOf2 = Long.valueOf(j10);
                                        String str4 = z10 ? "closed" : "active";
                                        Object[] objArr2 = new Object[5];
                                        c15 = 0;
                                        objArr2[0] = localizedMessage;
                                        objArr2[i11] = lValueOf2;
                                        objArr2[c10] = str4;
                                        objArr2[c11] = str;
                                        objArr2[c13] = str2;
                                        str3 = String.format(locale2, "%s [%d/%s] [%s/%s]", objArr2);
                                    } else {
                                        c15 = 0;
                                    }
                                    q6.b bVar = f21020x;
                                    Object[] objArr3 = new Object[i11];
                                    objArr3[c15] = th;
                                    bVar.error("get data failure", objArr3);
                                    throw new RuntimeException(str3, th);
                                }
                            } else {
                                c13 = 4;
                                c12 = 5;
                                f21020x.debug("client_service_get_data [{}/{}], size[{}] [{}] play_session request[{}] server[{}]", str, str2, Integer.valueOf(length), strB, Long.valueOf(j10), Long.valueOf(this.f21024d));
                            }
                            if (length > 0) {
                                this.f21041u.e(new ByteArrayInputStream(bArrQ));
                                return bArrQ;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    }
                    return bArrQ;
                } catch (Throwable th4) {
                    th = th4;
                    i11 = 1;
                    c11 = 3;
                }
            } catch (Throwable th5) {
                th = th5;
            }
        } catch (Throwable th6) {
            th = th6;
            i11 = 1;
            c10 = 2;
        }
        c11 = 3;
        c14 = 0;
        c13 = 4;
        c12 = 5;
        if (!cVar.r()) {
            return null;
        }
        if (this.f21026f >= j10) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (th instanceof b7.a) {
            aVar = th;
            Locale locale3 = Locale.ENGLISH;
            Long lValueOf3 = Long.valueOf(j10);
            if (z10) {
                obj = "closed";
            } else {
                obj = "active";
            }
            Integer numValueOf2 = Integer.valueOf(aVar.a());
            String strB3 = aVar.b();
            Object[] objArr4 = new Object[6];
            objArr4[c14] = lValueOf3;
            objArr4[i11] = obj;
            objArr4[c10] = str;
            objArr4[c11] = str2;
            objArr4[c13] = numValueOf2;
            objArr4[c12] = strB3;
            str3 = String.format(locale3, "get data failure, [%d/%s] [%s/%s], %d:%s", objArr4);
            if (aVar.a() == 2001) {
                f21020x.warn(str3, new Object[0]);
                return null;
            }
            if (aVar.a() == 1001) {
                f21020x.warn(str3, new Object[0]);
                return null;
            }
        } else {
            str3 = "";
        }
        if (ac.g.f(str3)) {
            localizedMessage = th.getLocalizedMessage();
            if (ac.g.f(localizedMessage)) {
                localizedMessage = th.getMessage();
            }
            if (ac.g.f(localizedMessage)) {
                localizedMessage = "get data failure,";
            }
            Locale locale4 = Locale.ENGLISH;
            Long lValueOf4 = Long.valueOf(j10);
            if (z10) {
            }
            Object[] objArr5 = new Object[5];
            c15 = 0;
            objArr5[0] = localizedMessage;
            objArr5[i11] = lValueOf4;
            objArr5[c10] = str4;
            objArr5[c11] = str;
            objArr5[c13] = str2;
            str3 = String.format(locale4, "%s [%d/%s] [%s/%s]", objArr5);
        } else {
            c15 = 0;
        }
        q6.b bVar2 = f21020x;
        Object[] objArr6 = new Object[i11];
        objArr6[c15] = th;
        bVar2.error("get data failure", objArr6);
        throw new RuntimeException(str3, th);
    }

    public Boolean M() {
        synchronized (this) {
            try {
                x6.c cVar = this.f21021a;
                if (cVar == null) {
                    f21020x.error("stop Engine, but it is null", new Object[0]);
                    return Boolean.FALSE;
                }
                if (x1.f1.lb.config.b.f20643a.t()) {
                    f21020x.debug("stopEngine@[{}], session[{}], playType[{}], mediaId[{}], playMode[{}]", Integer.valueOf(hashCode()), Long.valueOf(this.f21024d), this.f21030j, this.f21029i, Integer.valueOf(this.f21031k));
                }
                this.f21021a = null;
                cVar.x();
                f21020x.a("stop engine [{}] completed", Long.valueOf(this.f21024d));
                this.f21024d = 0L;
                return Boolean.TRUE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public synchronized Boolean N(Long l10) {
        if (this.f21021a == null) {
            f21020x.error("stop Play, but engine is null", new Object[0]);
            return Boolean.FALSE;
        }
        if (x1.f1.lb.config.b.f20643a.t()) {
            f21020x.debug("stopPlay@[{}], requestSession[{}], play_session[{}], playType[{}], mediaId[{}], playMode[{}]", Integer.valueOf(hashCode()), l10, Long.valueOf(this.f21024d), this.f21030j, this.f21029i, Integer.valueOf(this.f21031k));
        }
        H();
        this.f21021a.y();
        this.f21026f = l10.longValue();
        this.f21024d = 0L;
        return Boolean.TRUE;
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a extends f3.a<HashMap<Integer, Long>> {
        a(b bVar) {
        }
    }

    private void H() {
        vf.d dVar = this.f21023c;
        if (dVar != null) {
            this.f21023c = null;
            uf.c.f19486a.q(dVar);
        }
    }

    private void I() {
        int iA;
        v6.d dVarB;
        a7.a aVar = this.f21042v;
        if (aVar == null) {
            return;
        }
        x1.f1.lb.config.b bVar = x1.f1.lb.config.b.f20643a;
        v6.d dVarQ = bVar.q();
        if (dVarQ != null && dVarQ != (dVarB = aVar.b())) {
            f21020x.a("set push mode [{} -> {}]", dVarB, dVarQ);
            aVar.d(dVarQ);
        }
        Integer numK = bVar.k();
        if (numK == null || numK.intValue() == (iA = aVar.a())) {
            return;
        }
        f21020x.a("set max downloading block cnt [{} -> {}]", Integer.valueOf(iA), numK);
        aVar.c(numK.intValue());
    }

    public x6.c B() {
        return this.f21021a;
    }

    public boolean C(String str) {
        v6.c cVar;
        if (this.f21021a == null || !this.f21040t || (cVar = this.f21030j) == null || !cVar.name().equals(str)) {
            return false;
        }
        if (this.f21036p) {
            return true;
        }
        return D().booleanValue();
    }

    public Boolean D() {
        return Boolean.valueOf(this.f21021a != null);
    }

    public void F(String str) {
        x6.c cVar = this.f21021a;
        if (cVar != null) {
            cVar.s(str);
        } else {
            if (!this.f21037q.get()) {
                throw new RuntimeException("engine is not init");
            }
            f21020x.error("refresh token [{}], but kicked out", str);
        }
    }

    public void G(long j10) {
        if (this.f21024d == j10) {
            this.f21025e = 0;
        }
    }

    public void J(long j10, int i10) {
        if (this.f21024d == j10) {
            this.f21025e = i10;
        }
    }

    public Boolean K(String str, String str2, String str3, String str4, int i10, List<e7.b> list, v6.c cVar) {
        synchronized (this) {
            try {
                this.f21036p = true;
                if (this.f21021a != null) {
                    v6.c cVar2 = this.f21030j;
                    if (cVar2 == cVar) {
                        f21020x.warn("start Engine[{}], but engine is already started.", cVar);
                        return Boolean.TRUE;
                    }
                    f21020x.error("restart Engine[{}->{}], but engine is already started.", cVar2, cVar);
                    M();
                }
                if (this.f21042v == null) {
                    s sVar = s.f21156a;
                    a7.a aVar = new a7.a();
                    this.f21042v = aVar;
                    aVar.f144a = sVar;
                    I();
                }
                this.f21027g = str;
                x6.c cVar3 = new x6.c(str, str2, str3, str4, this.f21022b, v6.a.i(i10), cVar, this.f21042v, this.f21043w);
                cVar3.w(list);
                this.f21030j = cVar;
                if (x1.f1.lb.config.b.f20643a.t()) {
                    f21020x.debug("start_engin_with [{}, {}, {}, {}, {}, {}, {}]", str, str2, Long.valueOf(this.f21024d), Integer.valueOf(i10), cVar, this.f21029i, str3);
                }
                this.f21037q.set(false);
                this.f21021a = cVar3;
                this.f21040t = true;
                f21020x.a("engine is started", new Object[0]);
                return Boolean.TRUE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public synchronized Boolean L(String str, String str2, int i10, long j10) {
        char c10;
        try {
            x6.c cVar = this.f21021a;
            if (cVar == null) {
                if (this.f21037q.get()) {
                    f21020x.warn("start play, [{}] [{}] [{}], but kicked out", str, str2, Integer.valueOf(i10));
                } else {
                    f21020x.error("start play, but engine is not start", new Object[0]);
                }
                return Boolean.FALSE;
            }
            H();
            x1.f1.lb.config.b bVar = x1.f1.lb.config.b.f20643a;
            if (bVar.t()) {
                c10 = 2;
                f21020x.debug("startPlay@[{}], play_session[{}], playType[{}], requestSession[{}], mediaId[{}], playMode[{}]", Integer.valueOf(hashCode()), Long.valueOf(this.f21024d), this.f21030j, Long.valueOf(j10), str, Integer.valueOf(i10));
            } else {
                c10 = 2;
            }
            this.f21024d = j10;
            this.f21028h = str2;
            this.f21029i = str;
            this.f21031k = i10;
            I();
            this.f21041u = new wf.a();
            String strB = q.f21130a.b(this.f21027g, str);
            String str3 = ac.g.f(strB) ? "" : strB;
            if (bVar.t()) {
                q6.b bVar2 = f21020x;
                Object[] objArr = new Object[3];
                objArr[0] = this.f21027g;
                objArr[1] = str;
                objArr[c10] = str3;
                bVar2.debug("get_signature uid[{}], mediaId[{}], signature[{}]", objArr);
            }
            cVar.v(str, str2, i10, str3);
            if (this.f21036p) {
                this.f21036p = false;
            }
            return Boolean.TRUE;
        } catch (Throwable th) {
            throw th;
        }
    }

    public void x() {
        x6.c cVar = this.f21021a;
        if (cVar == null) {
            return;
        }
        cVar.t();
    }

    b(c cVar) {
        this.f21033m = cVar;
        final com.google.gson.e eVar = new com.google.gson.e();
        w0.f21452a.n("sp_streaming_event_bot_time_in_ces", new w0.a() { // from class: x1.f1.lb.streaming.server.a
            @Override // x1.f1.lb.util.w0.a
            public final void a(Object obj) {
                this.f21018a.E(eVar, (String) obj);
            }
        }, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E(com.google.gson.e eVar, String str) {
        if (!ac.g.f(str)) {
            try {
                this.f21038r = (Map) eVar.o(str, new a(this).d());
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <K> void y(Map<K, AtomicInteger> map, K k10) {
        AtomicInteger atomicInteger = map.get(k10);
        if (atomicInteger == null) {
            map.put(k10, new AtomicInteger(1));
        } else {
            atomicInteger.incrementAndGet();
        }
    }

    public byte[] z(long j10, String str, String str2) {
        return A(j10, str, str2, 60000);
    }
}
