package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.ArrayList;
import java.util.Set;
import kotlin.collections.r;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public enum e {
    VISIBILITY(true),
    MODALITY(true),
    OVERRIDE(true),
    ANNOTATIONS(false),
    INNER(true),
    MEMBER_KIND(true),
    DATA(true),
    INLINE(true),
    EXPECT(true),
    ACTUAL(true),
    CONST(true),
    LATEINIT(true),
    FUN(true),
    VALUE(true);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f13816a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<e> f13817b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set<e> f13818c;
    private final boolean includeByDefault;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        private a() {
        }
    }

    static {
        e[] eVarArrValues = values();
        ArrayList arrayList = new ArrayList();
        for (e eVar : eVarArrValues) {
            if (eVar.includeByDefault) {
                arrayList.add(eVar);
            }
        }
        f13817b = r.S0(arrayList);
        f13818c = kotlin.collections.j.R0(values());
    }

    e(boolean z10) {
        this.includeByDefault = z10;
    }
}
