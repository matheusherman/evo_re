package we;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static b f20512a;

    protected abstract String a(int i10);

    public static final String b(int i10) {
        if (f20512a == null) {
            if (a.a("java.util.ResourceBundle")) {
                try {
                    f20512a = (b) c.class.newInstance();
                } catch (Exception unused) {
                    return "";
                }
            } else if (a.a("org.eclipse.paho.client.mqttv3.internal.MIDPCatalog")) {
                try {
                    f20512a = (b) Class.forName("org.eclipse.paho.client.mqttv3.internal.MIDPCatalog").newInstance();
                } catch (Exception unused2) {
                    return "";
                }
            }
        }
        return f20512a.a(i10);
    }
}
