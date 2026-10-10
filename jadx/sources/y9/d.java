package y9;

import java.util.LinkedList;
import java.util.List;
import kotlin.collections.r;
import kotlin.jvm.internal.m;
import r8.u;
import w9.o;
import w9.p;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class d implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final p f22523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final o f22524b;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f22525a;

        static {
            int[] iArr = new int[o.c.EnumC0389c.values().length];
            try {
                iArr[o.c.EnumC0389c.CLASS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[o.c.EnumC0389c.PACKAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[o.c.EnumC0389c.LOCAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f22525a = iArr;
        }
    }

    public d(p strings, o qualifiedNames) {
        m.f(strings, "strings");
        m.f(qualifiedNames, "qualifiedNames");
        this.f22523a = strings;
        this.f22524b = qualifiedNames;
    }

    private final u<List<String>, List<String>, Boolean> c(int i10) {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        boolean z10 = false;
        while (i10 != -1) {
            o.c cVarU = this.f22524b.u(i10);
            String strU = this.f22523a.u(cVarU.y());
            o.c.EnumC0389c enumC0389cW = cVarU.w();
            m.c(enumC0389cW);
            int i11 = a.f22525a[enumC0389cW.ordinal()];
            if (i11 == 1) {
                linkedList2.addFirst(strU);
            } else if (i11 == 2) {
                linkedList.addFirst(strU);
            } else if (i11 == 3) {
                linkedList2.addFirst(strU);
                z10 = true;
            }
            i10 = cVarU.x();
        }
        return new u<>(linkedList, linkedList2, Boolean.valueOf(z10));
    }

    @Override // y9.c
    public String getString(int i10) {
        String strU = this.f22523a.u(i10);
        m.e(strU, "strings.getString(index)");
        return strU;
    }

    @Override // y9.c
    public String a(int i10) {
        u<List<String>, List<String>, Boolean> uVarC = c(i10);
        List<String> listA = uVarC.a();
        String strQ0 = r.q0(uVarC.b(), ".", null, null, 0, null, null, 62, null);
        if (listA.isEmpty()) {
            return strQ0;
        }
        return r.q0(listA, "/", null, null, 0, null, null, 62, null) + '/' + strQ0;
    }

    @Override // y9.c
    public boolean b(int i10) {
        return c(i10).f().booleanValue();
    }
}
