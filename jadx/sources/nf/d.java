package nf;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class d extends n6.a {
    private String code;
    private boolean isOK;
    private String msg;

    public d() {
        this.isOK = true;
    }

    public String c() {
        return this.msg;
    }

    public boolean d() {
        return this.isOK;
    }

    public String getCode() {
        return this.code;
    }

    public d(boolean z10, String str, String str2) {
        this.isOK = z10;
        this.code = str;
        this.msg = str2;
    }
}
