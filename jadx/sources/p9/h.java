package p9;

import ua.n;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class h {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String b(ba.b bVar) {
        String strB = bVar.i().b();
        kotlin.jvm.internal.m.e(strB, "relativeClassName.asString()");
        String strD = n.D(strB, '.', '$', false, 4, null);
        if (bVar.h().d()) {
            return strD;
        }
        return bVar.h() + '.' + strD;
    }
}
