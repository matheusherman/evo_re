package x1.f1.lb.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.RouteInfo;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.StringReader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import tf.SystemInfo;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0003J\u0017\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J'\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001a\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u001d\u001a\u00020\b¢\u0006\u0004\b\u001d\u0010\u0019J\u0015\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\b¢\u0006\u0004\b\u001f\u0010 J\r\u0010!\u001a\u00020\b¢\u0006\u0004\b!\u0010\u0019J\r\u0010#\u001a\u00020\"¢\u0006\u0004\b#\u0010$J\r\u0010%\u001a\u00020\u0006¢\u0006\u0004\b%\u0010&J\r\u0010'\u001a\u00020\u0006¢\u0006\u0004\b'\u0010&J\r\u0010(\u001a\u00020\u0006¢\u0006\u0004\b(\u0010&J\r\u0010*\u001a\u00020)¢\u0006\u0004\b*\u0010+J\r\u0010,\u001a\u00020\u0006¢\u0006\u0004\b,\u0010&J\r\u0010-\u001a\u00020\b¢\u0006\u0004\b-\u0010\u0019J\r\u0010.\u001a\u00020\b¢\u0006\u0004\b.\u0010\u0019J\r\u0010/\u001a\u00020\b¢\u0006\u0004\b/\u0010\u0019J\u0013\u00101\u001a\b\u0012\u0004\u0012\u00020\b00¢\u0006\u0004\b1\u00102J!\u00103\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b3\u0010\nJ\u0015\u00104\u001a\b\u0012\u0004\u0012\u00020\b00H\u0007¢\u0006\u0004\b4\u00102J\r\u00106\u001a\u000205¢\u0006\u0004\b6\u00107R\u001c\u0010;\u001a\n 9*\u0004\u0018\u000108088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010:R\u0016\u0010=\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010<R\u0014\u0010>\u001a\u00020\b8\u0002X\u0082D¢\u0006\u0006\n\u0004\b*\u0010<R\u0016\u0010@\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010<R\u0016\u0010A\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010<R\u0016\u0010B\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010<R\u0016\u0010C\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010<R0\u0010H\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0Dj\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b`E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010I\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010<R$\u0010O\u001a\u0004\u0018\u00010)8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR$\u0010Q\u001a\u0004\u0018\u00010)8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u0010J\u001a\u0004\b?\u0010L\"\u0004\bP\u0010NR$\u0010T\u001a\u0004\u0018\u00010)8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u0010J\u001a\u0004\bR\u0010L\"\u0004\bS\u0010NR-\u0010V\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0Dj\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b`E8F¢\u0006\u0006\u001a\u0004\bF\u0010U¨\u0006W"}, d2 = {"Lx1/f1/lb/util/z;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "printLog", "", "k", "(Landroid/content/Context;Z)Ljava/lang/String;", "", "length", "a", "(S)Ljava/lang/String;", "Lr8/z;", "g", "node", "C", "(Ljava/lang/String;)Ljava/lang/String;", "cpu", "hardware", "h", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "j", "()Ljava/lang/String;", "t", "b", "(Landroid/content/Context;)Ljava/lang/String;", "c", "did", "B", "(Ljava/lang/String;)V", "o", "Ltf/f;", "u", "()Ltf/f;", "z", "()Z", "y", "x", "", "d", "()I", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "s", "f", "q", "", "m", "()Ljava/util/List;", "v", "n", "", "l", "()J", "Lq6/b;", "kotlin.jvm.PlatformType", "Lq6/b;", "logger", "Ljava/lang/String;", "ETHERNET_INTERFACE", "WIFI_INTERFACE", "e", "ethernetMac", "wifiMac", "cpuSerial", "cpuHardware", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "i", "Ljava/util/HashMap;", "_devProp", "_devInfoJson", "Ljava/lang/Integer;", "r", "()Ljava/lang/Integer;", "setSimFlag", "(Ljava/lang/Integer;)V", "simFlag", "setBatteryFlag", "batteryFlag", "p", "setMobileFlag", "mobileFlag", "()Ljava/util/HashMap;", "devProp", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z f21470a = new z();

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final q6.b logger = q6.c.d(z.class);

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static String ETHERNET_INTERFACE = "eth0";

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final String WIFI_INTERFACE = "wlan0";

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static String ethernetMac = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static String wifiMac = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static String cpuSerial = "";

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static String cpuHardware = "";

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static final HashMap<String, String> _devProp = new HashMap<>();

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private static String _devInfoJson = "";

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    private static Integer simFlag;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    private static Integer batteryFlag;

    /* JADX INFO: renamed from: m, reason: collision with root package name and from kotlin metadata */
    private static Integer mobileFlag;

    public final int d() {
        BatteryManager batteryManager;
        try {
            Context contextA = x1.f1.lb.config.b.f20643a.a();
            if (contextA == null || (batteryManager = (BatteryManager) contextA.getSystemService("batterymanager")) == null) {
                return -1;
            }
            int intProperty = batteryManager.getIntProperty(4);
            logger.a("mobile_batteryCapacity[" + intProperty + " %]", new Object[0]);
            return intProperty;
        } catch (Throwable th) {
            logger.error("get battery capacity failure", th);
            return -1;
        }
    }

    private final String C(String node) {
        try {
            String strN = yb.e.n(new FileInputStream(new File(node)), StandardCharsets.UTF_8);
            kotlin.jvm.internal.m.e(strN, "toString(...)");
            return strN;
        } catch (Throwable th) {
            logger.debug("read from node error", th);
            return "";
        }
    }

    private final String a(short length) {
        int i10 = (-1) << (32 - length);
        int[] iArr = new int[4];
        for (int i11 = 0; i11 < 4; i11++) {
            iArr[3 - i11] = (i10 >> (i11 * 8)) & 255;
        }
        int i12 = iArr[0];
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i12);
        String string = sb2.toString();
        for (int i13 = 1; i13 < 4; i13++) {
            string = string + "." + iArr[i13];
        }
        return string;
    }

    private final void g() {
        h("/proc/cpuinfo", "Serial", "Hardware");
        if (cpuSerial.length() == 0) {
            h("/sys/class/sunxi_info/sys_info", "sunxi_serial", "Hardware");
        }
        if (cpuSerial.length() == 0) {
            h("/proc/cpu_chipid", "Serial", "Hardware");
        }
    }

    private final void h(String node, String cpu, String hardware) {
        List listL;
        if (!new File(node).exists()) {
            return;
        }
        try {
            LineNumberReader lineNumberReader = new LineNumberReader(new StringReader(C(node)));
            while (true) {
                String line = lineNumberReader.readLine();
                if (line == null) {
                    return;
                }
                kotlin.jvm.internal.m.c(line);
                List<String> listG = new ua.l(":").g(line, 0);
                if (!listG.isEmpty()) {
                    ListIterator<String> listIterator = listG.listIterator(listG.size());
                    while (true) {
                        if (!listIterator.hasPrevious()) {
                            listL = kotlin.collections.r.l();
                            break;
                        } else if (listIterator.previous().length() != 0) {
                            listL = kotlin.collections.r.K0(listG, listIterator.nextIndex() + 1);
                            break;
                        }
                    }
                } else {
                    listL = kotlin.collections.r.l();
                    break;
                }
                String[] strArr = (String[]) listL.toArray(new String[0]);
                if (strArr.length == 2) {
                    String string = ua.n.Q0(strArr[0]).toString();
                    String string2 = ua.n.Q0(strArr[1]).toString();
                    if (ua.n.w(cpu, string, true)) {
                        cpuSerial = string2;
                    } else if (ua.n.w(hardware, string, true)) {
                        cpuHardware = string2;
                    }
                }
            }
        } catch (Throwable th) {
            logger.debug("getCpuInfo error", th);
        }
    }

    private final String j() {
        return ua.n.Q0(C("/sys/block/mmcblk0/device/cid")).toString();
    }

    private final String k(Context context, boolean printLog) {
        if (TextUtils.isEmpty(ethernetMac)) {
            synchronized (this) {
                try {
                    if (TextUtils.isEmpty(ethernetMac)) {
                        try {
                            ethernetMac = zf.f.f(context).d();
                        } catch (Throwable th) {
                            if (printLog) {
                                logger.warn("getEthernetMac error", th);
                            }
                        }
                    }
                    r8.z zVar = r8.z.f17874a;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        if (printLog) {
            logger.a("ethernetMac:" + ethernetMac, new Object[0]);
        }
        return ethernetMac;
    }

    private final String t() {
        File file = new File("/sys/class/unifykeys/name");
        if (!file.exists()) {
            return "";
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bytes = "usid".getBytes(ua.d.UTF_8);
            kotlin.jvm.internal.m.e(bytes, "getBytes(...)");
            fileOutputStream.write(bytes);
            fileOutputStream.close();
            return C("/sys/class/unifykeys/read");
        } catch (Throwable th) {
            logger.debug("read st error", th);
            return "";
        }
    }

    public static /* synthetic */ String w(z zVar, Context context, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return zVar.v(context, z10);
    }

    public final boolean A() {
        Context contextA = x1.f1.lb.config.b.f20643a.a();
        if (contextA == null) {
            return false;
        }
        Object systemService = contextA.getSystemService("phone");
        kotlin.jvm.internal.m.d(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
        try {
            boolean z10 = ((TelephonyManager) systemService).getPhoneType() != 0;
            logger.a("mobile_phoneType[" + z10 + "]", new Object[0]);
            return z10;
        } catch (Throwable th) {
            logger.error("get phone type failure", th);
            return false;
        }
    }

    public final void B(String did) {
        kotlin.jvm.internal.m.f(did, "did");
        i().put("did", did);
    }

    @SuppressLint({"HardwareIds"})
    public final String b(Context context) {
        kotlin.jvm.internal.m.f(context, "context");
        try {
            String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
            kotlin.jvm.internal.m.c(string);
            return string;
        } catch (Throwable unused) {
            return "";
        }
    }

    public final Integer e() {
        return batteryFlag;
    }

    public final HashMap<String, String> i() {
        Context contextA = x1.f1.lb.config.b.f20643a.a();
        if (contextA == null) {
            return _devProp;
        }
        HashMap<String, String> map = _devProp;
        if (!map.isEmpty()) {
            if (TextUtils.isEmpty(map.get("wifi_mac"))) {
                map.put("wifi_mac", w(this, contextA, false, 2, null));
            }
            if (TextUtils.isEmpty(map.get("has_sim"))) {
                map.put("has_sim", String.valueOf(A()));
                y();
            }
            if (TextUtils.isEmpty(map.get("has_battery_capacity"))) {
                map.put("has_battery_capacity", String.valueOf(d() > 0));
                x();
            }
            return map;
        }
        map.put("brand", Build.BRAND);
        map.put("model", Build.MODEL);
        map.put("device", Build.DEVICE);
        map.put("product", Build.PRODUCT);
        map.put("build_id", Build.ID);
        map.put("display", Build.DISPLAY);
        map.put("board", Build.BOARD);
        map.put("manufacturer", Build.MANUFACTURER);
        map.put("bootloader", Build.BOOTLOADER);
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 31) {
            map.put("soc_manufacturer", Build.SOC_MANUFACTURER);
            map.put("soc_model", Build.SOC_MODEL);
            map.put("sku", Build.SKU);
            map.put("odm_sku", Build.ODM_SKU);
            map.put("media_performance_class", String.valueOf(Build.VERSION.MEDIA_PERFORMANCE_CLASS));
        }
        map.put("hardware", Build.HARDWARE);
        map.put("supported_abis", Arrays.deepToString(Build.SUPPORTED_ABIS));
        map.put("incremental", Build.VERSION.INCREMENTAL);
        if (i10 >= 23) {
            map.put("base_os", Build.VERSION.BASE_OS);
            map.put("security_patch", Build.VERSION.SECURITY_PATCH);
            map.put("preview_sdk_int", String.valueOf(Build.VERSION.PREVIEW_SDK_INT));
        }
        map.put("sdk_int", String.valueOf(i10));
        map.put("codename", Build.VERSION.CODENAME.toString());
        String str = Build.USER;
        map.put("build_serial", str);
        map.put("build_host", Build.HOST);
        map.put("build_user", str);
        map.put("fingerprint", Build.FINGERPRINT);
        z zVar = f21470a;
        map.put("eth_mac", zVar.k(contextA, true));
        map.put("wifi_mac", zVar.v(contextA, true));
        map.put("android_id", zVar.b(contextA));
        k kVar = k.f21398a;
        map.put("package_name", kVar.x());
        map.put("app_id", String.valueOf(kVar.q()));
        map.put("app_ver_code", String.valueOf(kVar.s()));
        map.put("app_ver_name", kVar.t());
        map.put("system_app_flag", String.valueOf(m0.f21410a.a(contextA)));
        map.put("emmc_id", zVar.j());
        map.put("system_sign", y0.f21468a.c(contextA, "com.android.providers.settings"));
        zVar.g();
        map.put("cpu_hadrware", cpuHardware);
        map.put("cpu_serial", cpuSerial);
        map.put("st", zVar.t());
        return map;
    }

    public final long l() {
        try {
            if (new File(Environment.getExternalStorageDirectory().getPath()).exists()) {
                return new StatFs(Environment.getExternalStorageDirectory().getPath()).getAvailableBytes() / ((long) 1024);
            }
            return 0L;
        } catch (Exception e10) {
            Log.e("[DeviceMonitor]", "getRomRate failed " + e10);
            return 0L;
        }
    }

    public final List<String> m() {
        String hostAddress;
        ArrayList arrayList = new ArrayList();
        Context contextA = x1.f1.lb.config.b.f20643a.a();
        if (contextA != null) {
            try {
                Process processExec = Runtime.getRuntime().exec("ip route list table 0");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(processExec.getInputStream()));
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    List<String> listG = new ua.l("\\s+").g(line, 0);
                    if (listG.size() >= 3) {
                        String str = listG.get(2);
                        if (f2.a.f(str)) {
                            arrayList.add(str);
                            break;
                        }
                    }
                }
                bufferedReader.close();
                processExec.waitFor();
            } catch (Throwable th) {
                logger.debug("getGateway error", th);
            }
            if (arrayList.isEmpty() && Build.VERSION.SDK_INT >= 23) {
                try {
                    Object systemService = contextA.getSystemService("connectivity");
                    kotlin.jvm.internal.m.d(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
                    ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
                    LinkProperties linkProperties = connectivityManager.getLinkProperties(connectivityManager.getActiveNetwork());
                    List<RouteInfo> routes = linkProperties != null ? linkProperties.getRoutes() : null;
                    List<RouteInfo> list = routes;
                    if (list != null && !list.isEmpty()) {
                        Iterator<RouteInfo> it = routes.iterator();
                        while (it.hasNext()) {
                            InetAddress gateway = it.next().getGateway();
                            if (gateway != null && (hostAddress = gateway.getHostAddress()) != null && !kotlin.jvm.internal.m.a("::", hostAddress) && !kotlin.jvm.internal.m.a("0.0.0.0", hostAddress)) {
                                arrayList.add(hostAddress);
                            }
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }
        return arrayList;
    }

    @SuppressLint({"WifiManagerPotentialLeak", "HardwareIds"})
    public final List<String> n() {
        ArrayList arrayList = new ArrayList();
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
                if (networkInterfaceNextElement.isUp()) {
                    for (InterfaceAddress interfaceAddress : networkInterfaceNextElement.getInterfaceAddresses()) {
                        if (interfaceAddress.getAddress() instanceof Inet4Address) {
                            String hostAddress = interfaceAddress.getAddress().getHostAddress();
                            kotlin.jvm.internal.m.d(hostAddress, "null cannot be cast to non-null type kotlin.String");
                            if (!kotlin.jvm.internal.m.a("127.0.0.1", hostAddress)) {
                                arrayList.add(hostAddress + "/" + a(interfaceAddress.getNetworkPrefixLength()));
                            }
                        }
                    }
                }
            }
            return arrayList;
        } catch (Throwable th) {
            logger.debug("getIP and Mask error", th);
            return arrayList;
        }
    }

    public final Integer p() {
        return mobileFlag;
    }

    public final Integer r() {
        return simFlag;
    }

    public final SystemInfo u() {
        String str = i().get("did");
        if (str == null) {
            str = "";
        }
        String str2 = i().get("cpu_serial");
        if (str2 == null) {
            str2 = "";
        }
        String str3 = i().get("eth_mac");
        if (str3 == null) {
            str3 = "";
        }
        String str4 = i().get("wifi_mac");
        if (str4 == null) {
            str4 = "";
        }
        String str5 = i().get("android_id");
        if (str5 == null) {
            str5 = "";
        }
        String str6 = i().get("manufacturer");
        if (str6 == null) {
            str6 = "";
        }
        String str7 = i().get("hardware");
        if (str7 == null) {
            str7 = "";
        }
        String str8 = i().get("display");
        if (str8 == null) {
            str8 = "";
        }
        String str9 = i().get("brand");
        if (str9 == null) {
            str9 = "";
        }
        String str10 = i().get("model");
        if (str10 == null) {
            str10 = "";
        }
        String str11 = i().get("supported_abis");
        if (str11 == null) {
            str11 = "";
        }
        String str12 = i().get("build_user");
        if (str12 == null) {
            str12 = "";
        }
        String str13 = i().get("build_host");
        if (str13 == null) {
            str13 = "";
        }
        String str14 = i().get("fingerprint");
        return new SystemInfo(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14 != null ? str14 : "", 0, 16384, null);
    }

    @SuppressLint({"WifiManagerPotentialLeak", "HardwareIds"})
    public final String v(Context context, boolean printLog) {
        kotlin.jvm.internal.m.f(context, "context");
        if (TextUtils.isEmpty(wifiMac)) {
            synchronized (this) {
                try {
                    if (TextUtils.isEmpty(wifiMac)) {
                        try {
                            wifiMac = zf.f.f(context).j();
                        } catch (Throwable th) {
                            if (printLog) {
                                logger.error("getWifiMac error", th);
                            }
                        }
                    }
                    r8.z zVar = r8.z.f17874a;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        if (printLog) {
            logger.a("wifiMac:" + wifiMac, new Object[0]);
        }
        return wifiMac;
    }

    private z() {
    }

    public final String c() {
        String str = i().get("android_id");
        if (str == null) {
            return "";
        }
        return str;
    }

    public final String f() {
        String str = i().get("brand");
        if (str == null) {
            return "Unknown";
        }
        return str;
    }

    public final String o() {
        String str = i().get("eth_mac");
        if (str == null || str.length() == 0) {
            str = i().get("wifi_mac");
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public final String q() {
        String str = i().get("model");
        if (str == null) {
            return "Unknown";
        }
        return str;
    }

    public final String s() {
        String str = i().get("cpu_serial");
        if (str == null) {
            str = "";
        }
        if (str.length() == 0) {
            return o();
        }
        return str;
    }

    public final boolean x() {
        int i10;
        boolean z10 = Boolean.parseBoolean(i().get("has_battery_capacity"));
        if (batteryFlag == null) {
            if (z10) {
                i10 = 1;
            } else {
                i10 = 0;
            }
            batteryFlag = Integer.valueOf(i10);
        }
        return z10;
    }

    public final boolean y() {
        int i10;
        boolean z10 = Boolean.parseBoolean(i().get("has_sim"));
        if (simFlag == null) {
            if (z10) {
                i10 = 1;
            } else {
                i10 = 0;
            }
            simFlag = Integer.valueOf(i10);
        }
        return z10;
    }

    public final boolean z() {
        boolean z10;
        int i10;
        String str = i().get("eth_mac");
        if ((str != null && str.length() > 0) || !y() || !x()) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (mobileFlag == null) {
            if (z10) {
                i10 = 1;
            } else {
                i10 = 0;
            }
            mobileFlag = i10;
        }
        return z10;
    }
}
