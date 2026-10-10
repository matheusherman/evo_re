package org.eclipse.paho.android.service;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PowerManager;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@SuppressLint({"Registered"})
public class MqttService extends Service implements ue.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f17083a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    org.eclipse.paho.android.service.b f17085c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private b f17086d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private d f17088f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f17084b = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile boolean f17087e = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Map<String, c> f17089g = new ConcurrentHashMap();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static /* synthetic */ class a {
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private class b extends BroadcastReceiver {
        private b() {
        }

        /* synthetic */ b(MqttService mqttService, a aVar) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        @SuppressLint({"Wakelock"})
        public void onReceive(Context context, Intent intent) {
            MqttService.this.b("MqttService", "Internal network status receive.");
            PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) MqttService.this.getSystemService("power")).newWakeLock(1, "MQTT");
            wakeLockNewWakeLock.acquire();
            MqttService.this.b("MqttService", "Reconnect for Network recovery.");
            if (MqttService.this.g()) {
                MqttService.this.b("MqttService", "Online,reconnect.");
                MqttService.this.i();
            } else {
                MqttService.this.h();
            }
            wakeLockNewWakeLock.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        Iterator<c> it = this.f17089g.values().iterator();
        while (it.hasNext()) {
            it.next().i();
        }
    }

    private void j() {
        if (this.f17086d == null) {
            b bVar = new b(this, null);
            this.f17086d = bVar;
            registerReceiver(bVar, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
    }

    private void k(String str, String str2, String str3) {
        if (this.f17083a == null || !this.f17084b) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("MqttService.callbackAction", "trace");
        bundle.putString("MqttService.traceSeverity", str);
        bundle.putString("MqttService.traceTag", str2);
        bundle.putString("MqttService.errorMessage", str3);
        f(this.f17083a, f.ERROR, bundle);
    }

    private void l() {
        b bVar = this.f17086d;
        if (bVar != null) {
            unregisterReceiver(bVar);
            this.f17086d = null;
        }
    }

    @Override // ue.a
    public void a(String str, String str2) {
        k(IjkMediaPlayer.OnNativeInvokeListener.ARG_ERROR, str, str2);
    }

    @Override // ue.a
    public void b(String str, String str2) {
        k("debug", str, str2);
    }

    @Override // ue.a
    public void c(String str, String str2, Exception exc) {
        if (this.f17083a != null) {
            Bundle bundle = new Bundle();
            bundle.putString("MqttService.callbackAction", "trace");
            bundle.putString("MqttService.traceSeverity", "exception");
            bundle.putString("MqttService.errorMessage", str2);
            bundle.putSerializable("MqttService.exception", exc);
            bundle.putString("MqttService.traceTag", str);
            f(this.f17083a, f.ERROR, bundle);
        }
    }

    public f e(String str, String str2) {
        return this.f17085c.b(str, str2) ? f.OK : f.ERROR;
    }

    void f(String str, f fVar, Bundle bundle) {
        Intent intent = new Intent("MqttService.callbackToActivity.v0");
        if (str != null) {
            intent.putExtra("MqttService.clientHandle", str);
        }
        intent.putExtra("MqttService.callbackStatus", fVar);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }

    public boolean g() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected() && this.f17087e;
    }

    void i() {
        b("MqttService", "Reconnect to server, client size=" + this.f17089g.size());
        for (c cVar : this.f17089g.values()) {
            b("Reconnect Client:", cVar.f() + '/' + cVar.g());
            if (g()) {
                cVar.j();
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        this.f17088f.a(intent.getStringExtra("MqttService.activityToken"));
        return this.f17088f;
    }

    @Override // android.app.Service
    public void onDestroy() {
        Iterator<c> it = this.f17089g.values().iterator();
        while (it.hasNext()) {
            it.next().e(null, null);
        }
        if (this.f17088f != null) {
            this.f17088f = null;
        }
        l();
        org.eclipse.paho.android.service.b bVar = this.f17085c;
        if (bVar != null) {
            bVar.close();
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f17088f = new d(this);
        this.f17085c = new org.eclipse.paho.android.service.a(this, this);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        j();
        return 1;
    }
}
