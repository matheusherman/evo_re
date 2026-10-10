package m9;

import java.util.List;
import ka.n;
import kotlin.collections.r;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.y;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class d extends kotlin.reflect.jvm.internal.impl.resolve.scopes.e {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f15693a;

        static {
            int[] iArr = new int[c.values().length];
            try {
                iArr[c.f15686b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[c.f15687c.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f15693a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(n storageManager, b containingClass) {
        super(storageManager, containingClass);
        m.f(storageManager, "storageManager");
        m.f(containingClass, "containingClass");
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.e
    protected List<y> i() {
        kotlin.reflect.jvm.internal.impl.descriptors.e eVarL = l();
        m.d(eVarL, "null cannot be cast to non-null type org.jetbrains.kotlin.builtins.functions.FunctionClassDescriptor");
        int i10 = a.f15693a[((b) eVarL).Q0().ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                return r.l();
            }
            return r.e(e.E.a((b) l(), true));
        }
        return r.e(e.E.a((b) l(), false));
    }
}
