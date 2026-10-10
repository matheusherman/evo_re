package i5;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class a implements Serializable {

    @a3.c("e")
    private String accountName;

    @a3.c("c")
    private String countryCode;

    @a3.c("d")
    private String password;

    @a3.c("b")
    private String phonePreCode;

    @a3.c("a")
    private int type;

    public a() {
        this.type = -1;
        this.phonePreCode = "";
        this.countryCode = "";
        this.password = "";
        this.accountName = "";
    }

    public String a() {
        return this.accountName;
    }

    public String b() {
        return this.countryCode;
    }

    public String c() {
        return this.password;
    }

    public String d() {
        return this.phonePreCode;
    }

    public int e() {
        return this.type;
    }

    public void f(String str) {
        this.accountName = str;
    }

    public void g(String str) {
        this.countryCode = str;
    }

    public void h(String str) {
        this.password = str;
    }

    public void i(String str) {
        this.phonePreCode = str;
    }

    public void j(int i10) {
        this.type = i10;
    }

    public a(int i10, String str, String str2, String str3, String str4) {
        this.type = i10;
        this.phonePreCode = str;
        this.countryCode = str2;
        this.password = str3;
        this.accountName = str4;
    }
}
