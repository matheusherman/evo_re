package org.eclipse.paho.android.service;

import android.os.Bundle;
import android.os.PowerManager;
import android.util.Log;
import java.util.Map;
import ve.g;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
class c implements ve.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f17096a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f17097b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f17098c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private MqttService f17099d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile boolean f17100e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f17101f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Map<ve.b, String> f17102g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Map<ve.b, g> f17103h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Map<ve.b, String> f17104i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Map<ve.b, String> f17105j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private PowerManager.WakeLock f17106k;

    synchronized void j() {
        this.f17099d.a("MqttConnection", "Reconnect myClient = null. Will not do reconnect");
    }

    private Bundle h(String str, String str2, g gVar) {
        Bundle bundle = new Bundle();
        bundle.putString("MqttService.messageId", str);
        bundle.putString("MqttService.destinationName", str2);
        bundle.putParcelable("MqttService.PARCEL", new ParcelableMqttMessage(gVar));
        return bundle;
    }

    private void k() {
        PowerManager.WakeLock wakeLock = this.f17106k;
        if (wakeLock == null || !wakeLock.isHeld()) {
            return;
        }
        this.f17106k.release();
    }

    @Override // ve.d
    public void a(Throwable th) {
        this.f17099d.b("MqttConnection", "connectionLost(" + th.getMessage() + ")");
        this.f17100e = true;
        try {
            throw null;
        } catch (Exception unused) {
            Bundle bundle = new Bundle();
            bundle.putString("MqttService.callbackAction", "onConnectionLost");
            bundle.putString("MqttService.errorMessage", th.getMessage());
            if (th instanceof ve.f) {
                bundle.putSerializable("MqttService.exception", th);
            }
            bundle.putString("MqttService.exceptionStack", Log.getStackTraceString(th));
            this.f17099d.f(this.f17098c, f.OK, bundle);
            k();
        }
    }

    @Override // ve.e
    public void b(boolean z10, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("MqttService.callbackAction", "connectExtended");
        bundle.putBoolean("MqttService.reconnect", z10);
        bundle.putString("MqttService.serverURI", str);
        this.f17099d.f(this.f17098c, f.OK, bundle);
    }

    @Override // ve.d
    public void c(ve.b bVar) {
        this.f17099d.b("MqttConnection", "deliveryComplete(" + bVar + ")");
        g gVarRemove = this.f17103h.remove(bVar);
        if (gVarRemove != null) {
            String strRemove = this.f17102g.remove(bVar);
            String strRemove2 = this.f17104i.remove(bVar);
            String strRemove3 = this.f17105j.remove(bVar);
            Bundle bundleH = h(null, strRemove, gVarRemove);
            if (strRemove2 != null) {
                bundleH.putString("MqttService.callbackAction", "send");
                bundleH.putString("MqttService.activityToken", strRemove2);
                bundleH.putString("MqttService.invocationContext", strRemove3);
                this.f17099d.f(this.f17098c, f.OK, bundleH);
            }
            bundleH.putString("MqttService.callbackAction", "messageDelivered");
            this.f17099d.f(this.f17098c, f.OK, bundleH);
        }
    }

    @Override // ve.d
    public void d(String str, g gVar) {
        this.f17099d.b("MqttConnection", "messageArrived(" + str + ",{" + gVar.toString() + "})");
        String strA = this.f17099d.f17085c.a(this.f17098c, str, gVar);
        Bundle bundleH = h(strA, str, gVar);
        bundleH.putString("MqttService.callbackAction", "messageArrived");
        bundleH.putString("MqttService.messageId", strA);
        this.f17099d.f(this.f17098c, f.OK, bundleH);
    }

    void e(String str, String str2) {
        this.f17099d.b("MqttConnection", "disconnect()");
        this.f17100e = true;
        Bundle bundle = new Bundle();
        bundle.putString("MqttService.activityToken", str2);
        bundle.putString("MqttService.invocationContext", str);
        bundle.putString("MqttService.callbackAction", "disconnect");
        bundle.putString("MqttService.errorMessage", "not connected");
        this.f17099d.a("disconnect", "not connected");
        this.f17099d.f(this.f17098c, f.ERROR, bundle);
        k();
    }

    public String f() {
        return this.f17097b;
    }

    public String g() {
        return this.f17096a;
    }

    void i() {
        if (this.f17100e || this.f17101f) {
            return;
        }
        a(new Exception("Android offline"));
    }
}
