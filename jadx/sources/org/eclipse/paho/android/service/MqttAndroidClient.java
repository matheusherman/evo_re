package org.eclipse.paho.android.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class MqttAndroidClient extends BroadcastReceiver {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final ExecutorService f17072h = Executors.newCachedThreadPool();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private MqttService f17073a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f17074b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SparseArray<ve.c> f17075c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ve.c f17076d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ve.d f17077e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ue.a f17078f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final a f17079g;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public enum a {
        AUTO_ACK,
        MANUAL_ACK
    }

    private void d(Bundle bundle) {
        this.f17074b = null;
        ve.c cVarH = h(bundle);
        if (cVarH != null) {
            ((e) cVarH).a();
        }
        ve.d dVar = this.f17077e;
        if (dVar != null) {
            dVar.a(null);
        }
    }

    private synchronized ve.c e(Bundle bundle) {
        return this.f17075c.get(Integer.parseInt(bundle.getString("MqttService.activityToken")));
    }

    private synchronized ve.c h(Bundle bundle) {
        String string = bundle.getString("MqttService.activityToken");
        if (string == null) {
            return null;
        }
        int i10 = Integer.parseInt(string);
        ve.c cVar = this.f17075c.get(i10);
        this.f17075c.delete(i10);
        return cVar;
    }

    private void a(Bundle bundle) {
        ve.c cVar = this.f17076d;
        h(bundle);
        j(cVar, bundle);
    }

    private void b(Bundle bundle) {
        if (this.f17077e instanceof ve.e) {
            ((ve.e) this.f17077e).b(bundle.getBoolean("MqttService.reconnect", false), bundle.getString("MqttService.serverURI"));
        }
    }

    private void c(Bundle bundle) {
        if (this.f17077e != null) {
            this.f17077e.a((Exception) bundle.getSerializable("MqttService.exception"));
        }
    }

    private void f(Bundle bundle) {
        if (this.f17077e != null) {
            String string = bundle.getString("MqttService.messageId");
            String string2 = bundle.getString("MqttService.destinationName");
            ParcelableMqttMessage parcelableMqttMessage = (ParcelableMqttMessage) bundle.getParcelable("MqttService.PARCEL");
            try {
                if (this.f17079g == a.AUTO_ACK) {
                    this.f17077e.d(string2, parcelableMqttMessage);
                    this.f17073a.e(this.f17074b, string);
                } else {
                    parcelableMqttMessage.f17091f = string;
                    this.f17077e.d(string2, parcelableMqttMessage);
                }
            } catch (Exception unused) {
            }
        }
    }

    private void j(ve.c cVar, Bundle bundle) {
        if (cVar == null) {
            this.f17073a.a("MqttService", "simpleAction : token is null");
        } else if (((f) bundle.getSerializable("MqttService.callbackStatus")) == f.OK) {
            ((e) cVar).a();
        } else {
            ((e) cVar).b((Exception) bundle.getSerializable("MqttService.exception"));
        }
    }

    private void l(Bundle bundle) {
        if (this.f17078f != null) {
            String string = bundle.getString("MqttService.traceSeverity");
            String string2 = bundle.getString("MqttService.errorMessage");
            String string3 = bundle.getString("MqttService.traceTag");
            if ("debug".equals(string)) {
                this.f17078f.b(string3, string2);
            } else if (IjkMediaPlayer.OnNativeInvokeListener.ARG_ERROR.equals(string)) {
                this.f17078f.a(string3, string2);
            } else {
                this.f17078f.c(string3, string2, (Exception) bundle.getSerializable("MqttService.exception"));
            }
        }
    }

    private void g(Bundle bundle) {
        ve.c cVarH = h(bundle);
        if (cVarH != null && this.f17077e != null && ((f) bundle.getSerializable("MqttService.callbackStatus")) == f.OK && (cVarH instanceof ve.b)) {
            this.f17077e.c((ve.b) cVarH);
        }
    }

    private void i(Bundle bundle) {
        j(e(bundle), bundle);
    }

    private void k(Bundle bundle) {
        j(h(bundle), bundle);
    }

    private void m(Bundle bundle) {
        j(h(bundle), bundle);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        String string = extras.getString("MqttService.clientHandle");
        if (string != null && string.equals(this.f17074b)) {
            String string2 = extras.getString("MqttService.callbackAction");
            if ("connect".equals(string2)) {
                a(extras);
                return;
            }
            if ("connectExtended".equals(string2)) {
                b(extras);
                return;
            }
            if ("messageArrived".equals(string2)) {
                f(extras);
                return;
            }
            if ("subscribe".equals(string2)) {
                k(extras);
                return;
            }
            if ("unsubscribe".equals(string2)) {
                m(extras);
                return;
            }
            if ("send".equals(string2)) {
                i(extras);
                return;
            }
            if ("messageDelivered".equals(string2)) {
                g(extras);
                return;
            }
            if ("onConnectionLost".equals(string2)) {
                c(extras);
                return;
            }
            if ("disconnect".equals(string2)) {
                d(extras);
            } else if ("trace".equals(string2)) {
                l(extras);
            } else {
                this.f17073a.a("MqttService", "Callback action doesn't exist.");
            }
        }
    }
}
