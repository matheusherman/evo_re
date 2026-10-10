package com.tencent.bugly.proguard;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class aq extends BroadcastReceiver {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static aq f8796d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f8798b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f8799c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f8800e = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IntentFilter f8797a = new IntentFilter();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ aq f8801a;

        a(aq aqVar) {
            this.f8801a = aqVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                al.a(aq.f8796d.getClass(), "Register broadcast receiver of Bugly.", new Object[0]);
                synchronized (this.f8801a) {
                    aq.this.f8798b.registerReceiver(aq.f8796d, aq.this.f8797a, "com.tencent.bugly.BuglyBroadcastReceiver.permission", null);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static synchronized aq a() {
        try {
            if (f8796d == null) {
                f8796d = new aq();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f8796d;
    }

    public final synchronized void b(Context context) {
        try {
            al.a(aq.class, "Unregister broadcast receiver of Bugly.", new Object[0]);
            context.unregisterReceiver(this);
            this.f8798b = context;
        } catch (Throwable th) {
            if (al.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        try {
            a(context, intent);
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
        }
    }

    public final synchronized void a(String str) {
        try {
            if (!this.f8797a.hasAction(str)) {
                this.f8797a.addAction(str);
            }
            al.c("add action %s", str);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void a(Context context) {
        this.f8798b = context;
        ap.a(new a(this));
    }

    private synchronized boolean a(Context context, Intent intent) {
        if (context != null && intent != null) {
            if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                if (this.f8800e) {
                    this.f8800e = false;
                    return true;
                }
                String strC = ab.c(this.f8798b);
                al.c("is Connect BC ".concat(String.valueOf(strC)), new Object[0]);
                al.a("network %s changed to %s", this.f8799c, String.valueOf(strC));
                if (strC == null) {
                    this.f8799c = null;
                    return true;
                }
                String str = this.f8799c;
                this.f8799c = strC;
                long jCurrentTimeMillis = System.currentTimeMillis();
                ac acVarA = ac.a();
                ai aiVarA = ai.a();
                aa aaVarA = aa.a(context);
                if (acVarA != null && aiVarA != null && aaVarA != null) {
                    if (!strC.equals(str) && jCurrentTimeMillis - aiVarA.a(at.f8826a) > 30000) {
                        al.a("try to upload crash on network changed.", new Object[0]);
                        at atVarA = at.a();
                        if (atVarA != null) {
                            atVarA.a(0L);
                        }
                        al.a("try to upload userinfo on network changed.", new Object[0]);
                        s.f9120b.b();
                    }
                    return true;
                }
                al.d("not inited BC not work", new Object[0]);
                return true;
            }
        }
        return false;
    }
}
