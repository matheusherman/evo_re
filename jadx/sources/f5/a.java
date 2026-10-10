package f5;

import okhttp3.b0;
import okhttp3.d0;
import okhttp3.w;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class a implements w {
    @Override // okhttp3.w
    public d0 a(w.a aVar) {
        b0 b0VarF = aVar.f();
        if (b0VarF.getBody() != null && b0VarF.d("Content-Encoding") == null) {
            return aVar.a(b0VarF.h().e("Accept-Encoding", "gzip").b());
        }
        return aVar.a(b0VarF);
    }
}
