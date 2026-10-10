package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.Set;
import kotlin.collections.v0;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 kotlin.reflect.jvm.internal.impl.builtins.i, still in use, count: 1, list:
  (r0v1 kotlin.reflect.jvm.internal.impl.builtins.i) from 0x0070: FILLED_NEW_ARRAY 
  (r0v1 kotlin.reflect.jvm.internal.impl.builtins.i)
  (r1v2 kotlin.reflect.jvm.internal.impl.builtins.i)
  (r2v3 kotlin.reflect.jvm.internal.impl.builtins.i)
  (r5v2 kotlin.reflect.jvm.internal.impl.builtins.i)
  (r7v2 kotlin.reflect.jvm.internal.impl.builtins.i)
  (r9v2 kotlin.reflect.jvm.internal.impl.builtins.i)
  (r11v2 kotlin.reflect.jvm.internal.impl.builtins.i)
 A[WRAPPED] (LINE:114) elemType: kotlin.reflect.jvm.internal.impl.builtins.i
	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:257)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:187)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class i {
    BOOLEAN("Boolean"),
    CHAR("Char"),
    BYTE("Byte"),
    SHORT("Short"),
    INT("Int"),
    FLOAT("Float"),
    LONG("Long"),
    DOUBLE("Double");


    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<i> f12478b = v0.h(new i("Char"), new i("Byte"), new i("Short"), new i("Int"), new i("Float"), new i("Long"), new i("Double"));
    private final r8.i arrayTypeFqName$delegate;
    private final ba.f arrayTypeName;
    private final r8.i typeFqName$delegate;
    private final ba.f typeName;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12477a = new a(null);

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class b extends kotlin.jvm.internal.o implements c9.a<ba.c> {
        b() {
            super(0);
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ba.c invoke() {
            ba.c cVarC = k.f12593v.c(i.this.i());
            kotlin.jvm.internal.m.e(cVarC, "BUILT_INS_PACKAGE_FQ_NAME.child(arrayTypeName)");
            return cVarC;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class c extends kotlin.jvm.internal.o implements c9.a<ba.c> {
        c() {
            super(0);
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ba.c invoke() {
            ba.c cVarC = k.f12593v.c(i.this.k());
            kotlin.jvm.internal.m.e(cVarC, "BUILT_INS_PACKAGE_FQ_NAME.child(this.typeName)");
            return cVarC;
        }
    }

    static {
    }

    public static i valueOf(String str) {
        return (i) Enum.valueOf(i.class, str);
    }

    public static i[] values() {
        return (i[]) f12487k.clone();
    }

    public final ba.c f() {
        return (ba.c) this.arrayTypeFqName$delegate.getValue();
    }

    public final ba.f i() {
        return this.arrayTypeName;
    }

    public final ba.c j() {
        return (ba.c) this.typeFqName$delegate.getValue();
    }

    public final ba.f k() {
        return this.typeName;
    }

    private i(String str) {
        super(str, i);
        ba.f fVarL = ba.f.l(str);
        kotlin.jvm.internal.m.e(fVarL, "identifier(typeName)");
        this.typeName = fVarL;
        ba.f fVarL2 = ba.f.l(str + "Array");
        kotlin.jvm.internal.m.e(fVarL2, "identifier(\"${typeName}Array\")");
        this.arrayTypeName = fVarL2;
        r8.m mVar = r8.m.PUBLICATION;
        this.typeFqName$delegate = r8.j.b(mVar, new c());
        this.arrayTypeFqName$delegate = r8.j.b(mVar, new b());
    }
}
