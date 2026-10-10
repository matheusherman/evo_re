package o6;

import io.netty.handler.codec.dns.DnsRecordType;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f16476b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private DnsRecordType f16477c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f16475a = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<String> f16478d = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f16479e = System.currentTimeMillis();

    public List<String> a() {
        return this.f16478d;
    }

    public long b() {
        return this.f16479e;
    }

    public String c() {
        return this.f16476b;
    }

    public int d() {
        return this.f16475a;
    }

    public void e(String str) {
        this.f16476b = str;
    }

    public void f(DnsRecordType dnsRecordType) {
        this.f16477c = dnsRecordType;
    }

    public void g(int i10) {
        this.f16475a = i10;
    }
}
