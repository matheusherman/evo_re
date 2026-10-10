package t4;

import com.koushikdutta.async.l;
import com.koushikdutta.async.n;
import java.nio.charset.Charset;
import p4.k;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Charset f18908a;

    public static /* synthetic */ String a(e eVar, String str, l lVar) {
        Charset charsetForName = eVar.f18908a;
        if (charsetForName == null && str != null) {
            charsetForName = Charset.forName(str);
        }
        return lVar.x(charsetForName);
    }

    public p4.b<String> b(n nVar) {
        final String strH = nVar.h();
        return new a().a(nVar).f(new k() { // from class: t4.d
            @Override // p4.k
            public final Object a(Object obj) {
                return e.a(this.f18906a, strH, (l) obj);
            }
        });
    }
}
