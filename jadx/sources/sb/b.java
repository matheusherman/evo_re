package sb;

import h9.f;
import java.io.EOFException;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import tb.d;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ltb/d;", "", "a", "(Ltb/d;)Z", "okhttp-logging-interceptor"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class b {
    public static final boolean a(d dVar) {
        m.f(dVar, "<this>");
        try {
            d dVar2 = new d();
            dVar.j(dVar2, 0L, f.f(dVar.getSize(), 64L));
            for (int i10 = 0; i10 < 16 && !dVar2.L(); i10++) {
                int iY = dVar2.y();
                if (Character.isISOControl(iY) && !Character.isWhitespace(iY)) {
                    return false;
                }
            }
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }
}
