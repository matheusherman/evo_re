package ba;

import kotlin.jvm.internal.m;
import ua.l;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f940a = new g();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final l f941b = new l("[^\\p{L}\\p{Digit}]");

    public static final f a(int i10) {
        f fVarL = f.l("_context_receiver_" + i10);
        m.e(fVarL, "identifier(\"_context_receiver_$index\")");
        return fVarL;
    }

    public static final String b(String name) {
        m.f(name, "name");
        return f941b.f(name, "_");
    }

    private g() {
    }
}
