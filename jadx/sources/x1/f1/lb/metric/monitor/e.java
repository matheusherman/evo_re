package x1.f1.lb.metric.monitor;

import java.util.Arrays;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.Metadata;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.m;
import r8.z;
import x.l1.b2.R$string;
import x1.f1.lb.util.u0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0010\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\u0004¢\u0006\u0004\b\u0014\u0010\u0013J\r\u0010\u0015\u001a\u00020\u0006¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\b¢\u0006\u0004\b\u0017\u0010\u0003R\u001c\u0010\u001b\u001a\n \u0019*\u0004\u0018\u00010\u00180\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u001aR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u001cR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u001eR\u0018\u0010 \u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u001eR\u0018\u0010!\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\"R\u0018\u0010%\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010\"R\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020\u000e0&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(¨\u0006*"}, d2 = {"Lx1/f1/lb/metric/monitor/e;", "", "<init>", "()V", "", "ssid", "", "rssi", "Lr8/z;", "c", "(Ljava/lang/String;I)V", "e", "(I)V", "", "", "array", "d", "([Ljava/lang/Double;)V", "a", "()Ljava/lang/String;", "g", "f", "()I", "b", "Lq6/b;", "kotlin.jvm.PlatformType", "Lq6/b;", "logger", "Ljava/lang/String;", "wifiSSID", "Ljava/lang/Integer;", "wifiRssi", "minWifiRssi", "maxWifiRssi", "Ljava/lang/Double;", "wifiRssiStdDev", "h", "wifiRssiMean", "Ljava/util/concurrent/LinkedBlockingQueue;", "i", "Ljava/util/concurrent/LinkedBlockingQueue;", "wifiRssiSample", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f20898a;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final q6.b logger;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static String wifiSSID;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static Integer wifiRssi;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static Integer minWifiRssi;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static Integer maxWifiRssi;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static Double wifiRssiStdDev;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static Double wifiRssiMean;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static LinkedBlockingQueue<Double> wifiRssiSample;

    private final void d(Double[] array) {
        if (array.length == 0) {
            return;
        }
        double dPow = 0.0d;
        double dDoubleValue = 0.0d;
        for (Double d10 : array) {
            dDoubleValue += d10.doubleValue();
        }
        double length = dDoubleValue / ((double) array.length);
        wifiRssiMean = Double.valueOf(length);
        for (Double d11 : array) {
            dPow += Math.pow(d11.doubleValue() - length, 2.0d);
        }
        wifiRssiStdDev = Double.valueOf(Math.sqrt(dPow / ((double) array.length)));
    }

    public final void b() {
        try {
            zf.f fVarE = zf.f.e();
            if (fVarE == null || !fVarE.o()) {
                return;
            }
            zf.f fVarE2 = zf.f.e();
            String strL = fVarE2 != null ? fVarE2.l() : null;
            zf.f fVarE3 = zf.f.e();
            Integer numK = fVarE3 != null ? fVarE3.k() : null;
            if (!m.a(strL, wifiSSID) && strL != null && numK != null) {
                c(strL, numK.intValue());
            }
            if (numK != null) {
                e(numK.intValue());
            }
        } catch (Throwable th) {
            logger.error("wifi refresh failure", th);
        }
    }

    static {
        e eVar = new e();
        f20898a = eVar;
        logger = q6.c.d(eVar.getClass());
        wifiRssiSample = new LinkedBlockingQueue<>(60);
    }

    private final void c(String ssid, int rssi) {
        wifiSSID = ssid;
        wifiRssi = Integer.valueOf(rssi);
        minWifiRssi = Integer.valueOf(rssi);
        maxWifiRssi = Integer.valueOf(rssi);
        wifiRssiStdDev = Double.valueOf(0.0d);
        wifiRssiSample.clear();
        wifiRssiSample.add(Double.valueOf(rssi));
    }

    public final int f() {
        Integer num = wifiRssi;
        int iIntValue = num != null ? num.intValue() : -1;
        if (iIntValue < -100) {
            return 0;
        }
        if (iIntValue < -87) {
            return 1;
        }
        if (iIntValue < -76) {
            return 2;
        }
        return iIntValue < -54 ? 3 : 4;
    }

    private e() {
    }

    private final void e(int rssi) {
        wifiRssi = Integer.valueOf(rssi);
        Integer num = minWifiRssi;
        if (num != null && num.intValue() > rssi) {
            minWifiRssi = Integer.valueOf(rssi);
        }
        Integer num2 = maxWifiRssi;
        if (num2 != null && num2.intValue() < rssi) {
            maxWifiRssi = Integer.valueOf(rssi);
        }
        double d10 = rssi;
        try {
            try {
                if (wifiRssiSample.remainingCapacity() == 0) {
                    wifiRssiSample.remove();
                }
                wifiRssiSample.add(Double.valueOf(d10));
            } catch (Throwable th) {
                logger.error("network monitor add rssi failure", th);
                z zVar = z.f17874a;
            }
        } catch (Throwable unused) {
            wifiRssiSample.remove();
            wifiRssiSample.add(Double.valueOf(d10));
        }
        d((Double[]) wifiRssiSample.toArray(new Double[0]));
    }

    public final String a() {
        Integer numValueOf;
        String str;
        zf.f fVarE = zf.f.e();
        String str2 = null;
        if (fVarE != null) {
            numValueOf = Integer.valueOf(fVarE.i());
        } else {
            numValueOf = null;
        }
        if (numValueOf == null) {
            return "Network[ Unknown ]";
        }
        if (numValueOf.intValue() == 1) {
            Integer num = wifiRssi;
            Integer num2 = minWifiRssi;
            if (num2 == null) {
                num2 = num;
            }
            Integer num3 = maxWifiRssi;
            if (num3 == null) {
                num3 = num;
            }
            Double d10 = wifiRssiStdDev;
            if (d10 == null) {
                str = null;
            } else {
                g0 g0Var = g0.f12340a;
                str = String.format("%.2f", Arrays.copyOf(new Object[]{d10}, 1));
                m.e(str, "format(...)");
            }
            Double d11 = wifiRssiMean;
            if (d11 != null) {
                g0 g0Var2 = g0.f12340a;
                str2 = String.format("%.2f", Arrays.copyOf(new Object[]{d11}, 1));
                m.e(str2, "format(...)");
            }
            return "Network[ WiFi(" + wifiSSID + ") ][ " + g() + " ][ stdDev=" + str + ", rssi=" + num + ", min=" + num2 + ", mean=" + str2 + ", max=" + num3 + " ]";
        }
        if (numValueOf.intValue() == 3) {
            return "Network[ Ethernet ]";
        }
        if (numValueOf.intValue() == 2) {
            return "Network[ Mobile ]";
        }
        if (numValueOf.intValue() != 0) {
            return "Network[ Unknown ]";
        }
        return "Network[ No ]";
    }

    public final String g() {
        int iF = f();
        if (iF != 0) {
            if (iF != 1) {
                if (iF != 2) {
                    if (iF != 3) {
                        if (iF != 4) {
                            return u0.f21448a.a(R$string.wifi_signal_unknown, "unknown");
                        }
                        return u0.f21448a.a(R$string.wifi_signal_4, "strongest");
                    }
                    return u0.f21448a.a(R$string.wifi_signal_3, "stronger");
                }
                return u0.f21448a.a(R$string.wifi_signal_2, "median");
            }
            return u0.f21448a.a(R$string.wifi_signal_1, "weaker");
        }
        return u0.f21448a.a(R$string.wifi_signal_0, "weakest");
    }
}
