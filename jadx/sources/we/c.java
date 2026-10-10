package we;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class c extends b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ResourceBundle f20513b = ResourceBundle.getBundle("org.eclipse.paho.client.mqttv3.internal.nls.messages");

    @Override // we.b
    protected String a(int i10) {
        try {
            return this.f20513b.getString(Integer.toString(i10));
        } catch (MissingResourceException unused) {
            return "MqttException";
        }
    }
}
