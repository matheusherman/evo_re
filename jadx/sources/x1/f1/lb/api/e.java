package x1.f1.lb.api;

import gf.o;
import gf.q;
import kotlin.Metadata;
import okhttp3.c0;
import okhttp3.y;
import z1.b1.lb.m.feedback.FeedbackUploadResponse;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001JB\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u00022\b\b\u0001\u0010\b\u001a\u00020\u0007H§@¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lx1/f1/lb/api/e;", "", "Lokhttp3/c0;", "tenantId", "uid", "did", "requestTime", "Lokhttp3/y$c;", "file", "Lz1/b1/lb/m/feedback/FeedbackUploadResponse;", "a", "(Lokhttp3/c0;Lokhttp3/c0;Lokhttp3/c0;Lokhttp3/c0;Lokhttp3/y$c;Lv8/f;)Ljava/lang/Object;", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface e {
    @gf.l
    @o("/api/feedback/upload/v1")
    Object a(@q("tenantId") c0 c0Var, @q("uid") c0 c0Var2, @q("did") c0 c0Var3, @q("requestTime") c0 c0Var4, @q y.c cVar, v8.f<? super FeedbackUploadResponse> fVar);
}
