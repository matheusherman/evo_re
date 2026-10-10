package ye;

import xe.g;
import xe.h;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public abstract class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final a f22579c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f22580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f22581b;

    public static boolean a() {
        return f22579c != null;
    }

    public static a b() {
        return f22579c;
    }

    static {
        a aVarB;
        if (b.c()) {
            aVarB = b.b();
        } else {
            aVarB = null;
        }
        f22579c = aVarB;
    }

    public a(g gVar, h hVar) {
        this.f22580a = gVar;
        this.f22581b = hVar;
    }
}
