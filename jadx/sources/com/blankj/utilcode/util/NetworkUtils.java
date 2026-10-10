package com.blankj.utilcode.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.annotation.RequiresPermission;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class NetworkUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Set<u.b<Object>> f1193a = new CopyOnWriteArraySet();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class NetworkChangedReceiver extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private a f1194a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Set<b> f1195b = new HashSet();

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
            public void run() {
                a aVarB = NetworkUtils.b();
                if (NetworkChangedReceiver.this.f1194a != aVarB) {
                    NetworkChangedReceiver.this.f1194a = aVarB;
                    if (aVarB == a.NETWORK_NO) {
                        Iterator it = NetworkChangedReceiver.this.f1195b.iterator();
                        while (it.hasNext()) {
                            ((b) it.next()).b();
                        }
                    } else {
                        Iterator it2 = NetworkChangedReceiver.this.f1195b.iterator();
                        while (it2.hasNext()) {
                            ((b) it2.next()).a(aVarB);
                        }
                    }
                }
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                x.x(new a(), 1000L);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public enum a {
        NETWORK_ETHERNET,
        NETWORK_WIFI,
        NETWORK_5G,
        NETWORK_4G,
        NETWORK_3G,
        NETWORK_2G,
        NETWORK_UNKNOWN,
        NETWORK_NO
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface b {
        void a(a aVar);

        void b();
    }

    @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
    private static NetworkInfo a() {
        ConnectivityManager connectivityManager = (ConnectivityManager) u.a().getSystemService("connectivity");
        if (connectivityManager == null) {
            return null;
        }
        return connectivityManager.getActiveNetworkInfo();
    }

    @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
    public static a b() {
        if (c()) {
            return a.NETWORK_ETHERNET;
        }
        NetworkInfo networkInfoA = a();
        if (networkInfoA != null && networkInfoA.isAvailable()) {
            if (networkInfoA.getType() == 1) {
                return a.NETWORK_WIFI;
            }
            if (networkInfoA.getType() == 0) {
                switch (networkInfoA.getSubtype()) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                    case 16:
                        return a.NETWORK_2G;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                    case 17:
                        return a.NETWORK_3G;
                    case 13:
                    case 18:
                        return a.NETWORK_4G;
                    case 19:
                    default:
                        String subtypeName = networkInfoA.getSubtypeName();
                        if (!subtypeName.equalsIgnoreCase("TD-SCDMA") && !subtypeName.equalsIgnoreCase("WCDMA") && !subtypeName.equalsIgnoreCase("CDMA2000")) {
                            return a.NETWORK_UNKNOWN;
                        }
                        return a.NETWORK_3G;
                    case 20:
                        return a.NETWORK_5G;
                }
            }
            return a.NETWORK_UNKNOWN;
        }
        return a.NETWORK_NO;
    }

    @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
    private static boolean c() {
        NetworkInfo networkInfo;
        NetworkInfo.State state;
        ConnectivityManager connectivityManager = (ConnectivityManager) u.a().getSystemService("connectivity");
        if (connectivityManager == null || (networkInfo = connectivityManager.getNetworkInfo(9)) == null || (state = networkInfo.getState()) == null) {
            return false;
        }
        if (state != NetworkInfo.State.CONNECTED && state != NetworkInfo.State.CONNECTING) {
            return false;
        }
        return true;
    }
}
