package x9;

import java.io.IOException;
import java.io.InputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.g;
import r8.p;
import r8.v;
import w9.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class c {
    public static final p<m, a> a(InputStream inputStream) throws IOException {
        m mVarW;
        kotlin.jvm.internal.m.f(inputStream, "<this>");
        try {
            a aVarA = a.f22009g.a(inputStream);
            if (aVarA.h()) {
                g gVarD = g.d();
                b.a(gVarD);
                mVarW = m.W(inputStream, gVarD);
            } else {
                mVarW = null;
            }
            p<m, a> pVarA = v.a(mVarW, aVarA);
            a9.a.a(inputStream, null);
            return pVarA;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                a9.a.a(inputStream, th);
                throw th2;
            }
        }
    }
}
