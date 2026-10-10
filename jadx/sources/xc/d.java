package xc;

import java.math.BigInteger;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private BigInteger f22058a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private BigInteger f22059b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private BigInteger f22060c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private e f22061d;

    public BigInteger a() {
        return this.f22058a;
    }

    public BigInteger b() {
        return this.f22060c;
    }

    public BigInteger c() {
        return this.f22059b;
    }

    public e d() {
        return this.f22061d;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return dVar.b().equals(this.f22060c) && dVar.c().equals(this.f22059b) && dVar.a().equals(this.f22058a);
    }

    public d(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, e eVar) {
        this.f22058a = bigInteger3;
        this.f22060c = bigInteger;
        this.f22059b = bigInteger2;
        this.f22061d = eVar;
    }

    public int hashCode() {
        return (b().hashCode() ^ c().hashCode()) ^ a().hashCode();
    }
}
