package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.List;
import ka.n;
import kotlin.collections.r;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.e0;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.t;
import kotlin.reflect.jvm.internal.impl.descriptors.y;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class a extends kotlin.reflect.jvm.internal.impl.resolve.scopes.e {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final C0215a f12501e = new C0215a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ba.f f12502f;

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.builtins.jvm.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class C0215a {
        public /* synthetic */ C0215a(kotlin.jvm.internal.g gVar) {
            this();
        }

        private C0215a() {
        }

        public final ba.f a() {
            return a.f12502f;
        }
    }

    static {
        ba.f fVarL = ba.f.l("clone");
        m.e(fVarL, "identifier(\"clone\")");
        f12502f = fVarL;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(n storageManager, kotlin.reflect.jvm.internal.impl.descriptors.e containingClass) {
        super(storageManager, containingClass);
        m.f(storageManager, "storageManager");
        m.f(containingClass, "containingClass");
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.e
    protected List<y> i() {
        g0 g0VarH1 = g0.h1(l(), kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f12688i0.b(), f12502f, kotlin.reflect.jvm.internal.impl.descriptors.b.a.DECLARATION, a1.f12668a);
        g0VarH1.N0(null, l().F0(), r.l(), r.l(), r.l(), ea.c.j(l()).i(), e0.OPEN, t.f13066c);
        return r.e(g0VarH1);
    }
}
