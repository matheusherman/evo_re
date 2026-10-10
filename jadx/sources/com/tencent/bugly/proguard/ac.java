package com.tencent.bugly.proguard;

import android.content.Context;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class ac {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f8693a = 1000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f8694b = 259200000;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static ac f8695d;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static String f8696i;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ak f8697c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<o> f8698e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final StrategyBean f8699f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private StrategyBean f8700g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Context f8701h;

    public final synchronized boolean b() {
        return this.f8700g != null;
    }

    public final StrategyBean c() {
        StrategyBean strategyBean = this.f8700g;
        if (strategyBean != null) {
            if (!ap.d(strategyBean.f8593q)) {
                this.f8700g.f8593q = StrategyBean.f8577a;
            }
            if (!ap.d(this.f8700g.f8594r)) {
                this.f8700g.f8594r = StrategyBean.f8578b;
            }
            return this.f8700g;
        }
        if (!ap.b(f8696i) && ap.d(f8696i)) {
            StrategyBean strategyBean2 = this.f8699f;
            String str = f8696i;
            strategyBean2.f8593q = str;
            strategyBean2.f8594r = str;
        }
        return this.f8699f;
    }

    private ac(Context context, List<o> list) {
        this.f8701h = context;
        if (aa.a(context) != null) {
            String str = aa.a(context).H;
            if ("oversea".equals(str)) {
                StrategyBean.f8577a = "https://astat.bugly.qcloud.com/rqd/async";
                StrategyBean.f8578b = "https://astat.bugly.qcloud.com/rqd/async";
            } else if ("na_https".equals(str)) {
                StrategyBean.f8577a = "https://astat.bugly.cros.wr.pvp.net/:8180/rqd/async";
                StrategyBean.f8578b = "https://astat.bugly.cros.wr.pvp.net/:8180/rqd/async";
            }
        }
        this.f8699f = new StrategyBean();
        this.f8698e = list;
        this.f8697c = ak.a();
    }

    public static synchronized ac a(Context context, List<o> list) {
        try {
            if (f8695d == null) {
                f8695d = new ac(context, list);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f8695d;
    }

    public static StrategyBean d() {
        byte[] bArr;
        List<y> listA = w.a().a(2);
        if (listA != null && listA.size() > 0 && (bArr = listA.get(0).f9183g) != null) {
            return (StrategyBean) ap.a(bArr, StrategyBean.CREATOR);
        }
        return null;
    }

    public static synchronized ac a() {
        return f8695d;
    }

    protected final void a(StrategyBean strategyBean, boolean z10) {
        al.c("[Strategy] Notify %s", s.class.getName());
        s.a(strategyBean, z10);
        for (o oVar : this.f8698e) {
            try {
                al.c("[Strategy] Notify %s", oVar.getClass().getName());
                oVar.onServerStrategyChanged(strategyBean);
            } catch (Throwable th) {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
            }
        }
    }

    public static void a(String str) {
        if (!ap.b(str) && ap.d(str)) {
            f8696i = str;
        } else {
            al.d("URL user set is invalid.", new Object[0]);
        }
    }

    public final void a(bt btVar) {
        if (btVar == null) {
            return;
        }
        StrategyBean strategyBean = this.f8700g;
        if (strategyBean == null || btVar.f9040h != strategyBean.f8591o) {
            StrategyBean strategyBean2 = new StrategyBean();
            strategyBean2.f8582f = btVar.f9033a;
            strategyBean2.f8584h = btVar.f9035c;
            strategyBean2.f8583g = btVar.f9034b;
            if (ap.b(f8696i) || !ap.d(f8696i)) {
                if (ap.d(btVar.f9036d)) {
                    al.c("[Strategy] Upload url changes to %s", btVar.f9036d);
                    strategyBean2.f8593q = btVar.f9036d;
                }
                if (ap.d(btVar.f9037e)) {
                    al.c("[Strategy] Exception upload url changes to %s", btVar.f9037e);
                    strategyBean2.f8594r = btVar.f9037e;
                }
            }
            bs bsVar = btVar.f9038f;
            if (bsVar != null && !ap.b(bsVar.f9028a)) {
                strategyBean2.f8595s = btVar.f9038f.f9028a;
            }
            long j10 = btVar.f9040h;
            if (j10 != 0) {
                strategyBean2.f8591o = j10;
            }
            Map<String, String> map = btVar.f9039g;
            if (map != null && map.size() > 0) {
                Map<String, String> map2 = btVar.f9039g;
                strategyBean2.f8596t = map2;
                String str = map2.get("B11");
                strategyBean2.f8585i = str != null && str.equals("1");
                String str2 = btVar.f9039g.get("B3");
                if (str2 != null) {
                    strategyBean2.f8599w = Long.parseLong(str2);
                }
                int i10 = btVar.f9044l;
                strategyBean2.f8592p = i10;
                strategyBean2.f8598v = i10;
                String str3 = btVar.f9039g.get("B27");
                if (str3 != null && str3.length() > 0) {
                    try {
                        int i11 = Integer.parseInt(str3);
                        if (i11 > 0) {
                            strategyBean2.f8597u = i11;
                        }
                    } catch (Exception e10) {
                        if (!al.a(e10)) {
                            e10.printStackTrace();
                        }
                    }
                }
                String str4 = btVar.f9039g.get("B25");
                strategyBean2.f8587k = str4 != null && str4.equals("1");
            }
            al.a("[Strategy] enableCrashReport:%b, enableQuery:%b, enableUserInfo:%b, enableAnr:%b, enableBlock:%b, enableSession:%b, enableSessionTimer:%b, sessionOverTime:%d, enableCocos:%b, strategyLastUpdateTime:%d", Boolean.valueOf(strategyBean2.f8582f), Boolean.valueOf(strategyBean2.f8584h), Boolean.valueOf(strategyBean2.f8583g), Boolean.valueOf(strategyBean2.f8585i), Boolean.valueOf(strategyBean2.f8586j), Boolean.valueOf(strategyBean2.f8589m), Boolean.valueOf(strategyBean2.f8590n), Long.valueOf(strategyBean2.f8592p), Boolean.valueOf(strategyBean2.f8587k), Long.valueOf(strategyBean2.f8591o));
            this.f8700g = strategyBean2;
            if (!ap.d(btVar.f9036d)) {
                al.c("[Strategy] download url is null", new Object[0]);
                this.f8700g.f8593q = "";
            }
            if (!ap.d(btVar.f9037e)) {
                al.c("[Strategy] download crashurl is null", new Object[0]);
                this.f8700g.f8594r = "";
            }
            w.a().b(2);
            y yVar = new y();
            yVar.f9178b = 2;
            yVar.f9177a = strategyBean2.f8580d;
            yVar.f9181e = strategyBean2.f8581e;
            yVar.f9183g = ap.a(strategyBean2);
            w.a().a(yVar);
            a(strategyBean2, true);
        }
    }
}
