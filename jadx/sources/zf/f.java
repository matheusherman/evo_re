package zf;

import ac.g;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.io.FileInputStream;
import java.lang.ref.SoftReference;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import x1.f1.lb.util.d1;
import x1.f1.lb.util.w0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class f {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final q6.b f23253v = q6.c.d(f.class);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static f f23254w;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SharedPreferences f23255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SoftReference<Context> f23256b;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f23262h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f23263i;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final ConnectivityManager f23267m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final WifiManager f23268n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final TelephonyManager f23269o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private BluetoothAdapter f23270p;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f23257c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f23258d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Integer f23259e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f23260f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f23261g = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f23264j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f23265k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f23266l = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f23271q = true;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f23272r = true;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f23273s = true;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final String f23274t = "";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private long f23275u = 0;

    public int i() {
        try {
            NetworkInfo activeNetworkInfo = this.f23267m.getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return 0;
            }
            if (activeNetworkInfo.getType() == 1) {
                return 1;
            }
            if (activeNetworkInfo.getType() == 0) {
                return 2;
            }
            return activeNetworkInfo.getType() == 9 ? 3 : 4;
        } catch (Throwable th) {
            f23253v.debug("get network type exception " + th.getMessage(), new Object[0]);
            return 4;
        }
    }

    public static f e() {
        return f23254w;
    }

    private String g() {
        if (!this.f23271q) {
            return "";
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream("/sys/class/net/eth0/address");
            try {
                byte[] bArr = new byte[17];
                fileInputStream2.read(bArr, 0, 17);
                String str = new String(bArr);
                if (str.contains("-")) {
                    str = str.replace("-", ":").trim();
                }
                try {
                    fileInputStream2.close();
                } catch (Throwable unused) {
                }
                if (!TextUtils.isEmpty(str)) {
                    return str.toLowerCase();
                }
                f23253v.debug("getMac by file return empty!", new Object[0]);
                return "";
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                try {
                    f23253v.debug("getMac by file error: [{}->{}]", th.getClass().getName(), th.getMessage());
                    this.f23271q = false;
                    return "";
                } finally {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable unused2) {
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private String h(NetworkInterface networkInterface) {
        if (networkInterface == null) {
            return "";
        }
        try {
            Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
            while (inetAddresses.hasMoreElements()) {
                InetAddress inetAddressNextElement = inetAddresses.nextElement();
                if (!inetAddressNextElement.isLoopbackAddress() && (inetAddressNextElement instanceof Inet4Address)) {
                    return inetAddressNextElement.getHostAddress();
                }
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static void m(Context context) {
        SoftReference<Context> softReference;
        try {
            f fVar = f23254w;
            if (fVar == null || (softReference = fVar.f23256b) == null || softReference.get() == null) {
                f23254w = new f(context);
            }
            f23254w.u();
        } catch (Throwable th) {
            f23253v.debug("init network manager failure", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(String str) {
        this.f23264j = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(String str) {
        this.f23265k = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r(String str) {
        this.f23266l = str;
    }

    private String s(byte b10) {
        String str = "00" + Integer.toHexString(b10) + ":";
        return str.substring(str.length() - 3);
    }

    private String t(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder();
        if (bArr == null) {
            return null;
        }
        sb2.delete(0, sb2.length());
        for (byte b10 : bArr) {
            sb2.append(s(b10));
        }
        return sb2.substring(0, sb2.length() - 1);
    }

    private void v(ConnectivityManager connectivityManager) {
        WifiInfo connectionInfo;
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
                connectionInfo = networkCapabilities != null ? (WifiInfo) networkCapabilities.getTransportInfo() : null;
            } else {
                connectionInfo = this.f23268n.getConnectionInfo();
            }
            if (connectionInfo == null) {
                return;
            }
            this.f23258d = connectionInfo.getSSID();
            this.f23259e = Integer.valueOf(connectionInfo.getRssi());
        } catch (Throwable th) {
            f23253v.debug("get Wifi signal failure: [{}->{}]", th.getClass().getName(), th.getMessage());
        }
    }

    public String d() {
        String str = this.f23260f;
        return str == null ? "" : g.j(str, ":", "").toLowerCase();
    }

    public String j() {
        String str = this.f23257c;
        return str == null ? "" : g.j(str, ":", "").toLowerCase();
    }

    public Integer k() {
        return this.f23259e;
    }

    public String l() {
        return this.f23258d;
    }

    public boolean n() {
        NetworkInfo activeNetworkInfo = this.f23267m.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public boolean o() {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        if (this.f23256b.get() == null || (activeNetworkInfo = (connectivityManager = this.f23267m).getActiveNetworkInfo()) == null || activeNetworkInfo.getType() != 1) {
            return false;
        }
        v(connectivityManager);
        return true;
    }

    private f(Context context) {
        this.f23256b = new SoftReference<>(context);
        this.f23268n = (WifiManager) context.getSystemService("wifi");
        this.f23267m = (ConnectivityManager) context.getSystemService("connectivity");
        this.f23269o = (TelephonyManager) context.getSystemService("phone");
        try {
            this.f23270p = BluetoothAdapter.getDefaultAdapter();
        } catch (Exception e10) {
            f23253v.debug("get bluetooth failure", e10);
        }
        this.f23255a = context.getSharedPreferences("network", 0);
        w0 w0Var = w0.f21452a;
        w0Var.n("ethernet_mac", new w0.a() { // from class: zf.c
            @Override // x1.f1.lb.util.w0.a
            public final void a(Object obj) {
                this.f23250a.p((String) obj);
            }
        }, "");
        w0Var.n("wifi_mac", new w0.a() { // from class: zf.d
            @Override // x1.f1.lb.util.w0.a
            public final void a(Object obj) {
                this.f23251a.q((String) obj);
            }
        }, "");
        w0Var.n("bluetooth_mac", new w0.a() { // from class: zf.e
            @Override // x1.f1.lb.util.w0.a
            public final void a(Object obj) {
                this.f23252a.r((String) obj);
            }
        }, "");
        u();
    }

    public static f f(Context context) {
        m(context);
        return f23254w;
    }

    public void u() {
        long jD = d1.d();
        if (jD - this.f23275u >= 10000) {
            this.f23275u = jD;
            if (this.f23272r && (this.f23265k == null || this.f23264j == null || TextUtils.isEmpty(this.f23257c) || TextUtils.isEmpty(this.f23260f))) {
                try {
                    Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                    while (networkInterfaces.hasMoreElements()) {
                        NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
                        if ("wlan0".equals(networkInterfaceNextElement.getDisplayName())) {
                            this.f23257c = t(networkInterfaceNextElement.getHardwareAddress());
                            this.f23262h = h(networkInterfaceNextElement);
                        } else if ("eth0".equals(networkInterfaceNextElement.getDisplayName())) {
                            this.f23260f = t(networkInterfaceNextElement.getHardwareAddress());
                            this.f23263i = h(networkInterfaceNextElement);
                        }
                    }
                    if (TextUtils.isEmpty(this.f23257c)) {
                        String macAddress = this.f23268n.getConnectionInfo().getMacAddress();
                        if (!TextUtils.isEmpty(macAddress) && !TextUtils.equals("020000000000", macAddress) && !TextUtils.equals("02:00:00:00:00:00", macAddress)) {
                            this.f23257c = macAddress;
                        }
                    }
                    if (TextUtils.isEmpty(this.f23260f)) {
                        this.f23260f = g();
                    }
                    if (!TextUtils.isEmpty(this.f23257c)) {
                        if (!TextUtils.equals(this.f23257c, this.f23265k)) {
                            String str = this.f23257c;
                            this.f23265k = str;
                            w0.f21452a.t("wifi_mac", str);
                        }
                    } else {
                        this.f23257c = (String) b.a(this.f23265k, "");
                    }
                    if (!TextUtils.isEmpty(this.f23260f)) {
                        if (!TextUtils.equals(this.f23260f, this.f23264j)) {
                            String str2 = this.f23260f;
                            this.f23264j = str2;
                            w0.f21452a.t("ethernet_mac", str2);
                        }
                    } else {
                        this.f23260f = (String) b.a(this.f23264j, "");
                    }
                } catch (Throwable th) {
                    this.f23272r = false;
                    f23253v.debug("refreshNetworkInfo ethernet/wifi failed: [{}->{}]", th.getClass().getName(), th.getMessage());
                }
            }
            if (this.f23273s && (this.f23266l == null || TextUtils.isEmpty(this.f23261g))) {
                try {
                    BluetoothAdapter bluetoothAdapter = this.f23270p;
                    if (bluetoothAdapter != null) {
                        String address = bluetoothAdapter.getAddress();
                        if (!TextUtils.isEmpty(address) && !TextUtils.equals("020000000000", address) && !TextUtils.equals("02:00:00:00:00:00", address)) {
                            this.f23261g = address;
                        }
                    }
                    if (!TextUtils.isEmpty(this.f23261g)) {
                        if (!TextUtils.equals(this.f23261g, this.f23266l)) {
                            String str3 = this.f23261g;
                            this.f23266l = str3;
                            w0.f21452a.t("bluetooth_mac", str3);
                        }
                    } else {
                        this.f23261g = (String) b.a(this.f23266l, "");
                    }
                } catch (Throwable th2) {
                    this.f23273s = false;
                    f23253v.debug("refreshNetworkInfo bluetooth failed: [{}->{}]", th2.getClass().getName(), th2.getMessage());
                }
            }
            if (this.f23272r || this.f23273s) {
                f23253v.debug("ethernetMac[{}], wifiMac[{}], bluetoothMac[{}]", this.f23260f, this.f23257c, this.f23261g);
            }
        }
    }
}
