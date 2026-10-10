package r4;

import com.koushikdutta.async.l;
import com.koushikdutta.async.n;
import com.koushikdutta.async.q;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class d extends q {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    long f17826g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    long f17827h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    l f17828i = new l();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.koushikdutta.async.o
    public void w(Exception exc) {
        if (exc == null && this.f17827h != this.f17826g) {
            exc = new h("End of data reached before content length was read: " + this.f17827h + "/" + this.f17826g + " Paused: " + t());
        }
        super.w(exc);
    }

    public d(long j10) {
        this.f17826g = j10;
    }

    @Override // com.koushikdutta.async.q, o4.b
    public void i(n nVar, l lVar) {
        lVar.g(this.f17828i, (int) Math.min(this.f17826g - this.f17827h, lVar.A()));
        int iA = this.f17828i.A();
        super.i(nVar, this.f17828i);
        this.f17827h += (long) (iA - this.f17828i.A());
        this.f17828i.f(lVar);
        if (this.f17827h == this.f17826g) {
            w(null);
        }
    }
}
