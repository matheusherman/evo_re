package kotlin.reflect.jvm.internal.impl.builtins;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'a' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:399)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:364)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:349)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:315)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:288)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f12656a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final n f12657b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final n f12658c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final n f12659d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ n[] f12660e;
    private final ba.b arrayClassId;
    private final ba.b classId;
    private final ba.f typeName;

    private static final /* synthetic */ n[] a() {
        return new n[]{f12656a, f12657b, f12658c, f12659d};
    }

    static {
        ba.b bVarE = ba.b.e("kotlin/UByte");
        kotlin.jvm.internal.m.e(bVarE, "fromString(\"kotlin/UByte\")");
        f12656a = new n("UBYTE", 0, bVarE);
        ba.b bVarE2 = ba.b.e("kotlin/UShort");
        kotlin.jvm.internal.m.e(bVarE2, "fromString(\"kotlin/UShort\")");
        f12657b = new n("USHORT", 1, bVarE2);
        ba.b bVarE3 = ba.b.e("kotlin/UInt");
        kotlin.jvm.internal.m.e(bVarE3, "fromString(\"kotlin/UInt\")");
        f12658c = new n("UINT", 2, bVarE3);
        ba.b bVarE4 = ba.b.e("kotlin/ULong");
        kotlin.jvm.internal.m.e(bVarE4, "fromString(\"kotlin/ULong\")");
        f12659d = new n("ULONG", 3, bVarE4);
        f12660e = a();
    }

    public static n valueOf(String str) {
        return (n) Enum.valueOf(n.class, str);
    }

    public static n[] values() {
        return (n[]) f12660e.clone();
    }

    public final ba.b f() {
        return this.arrayClassId;
    }

    public final ba.b i() {
        return this.classId;
    }

    public final ba.f j() {
        return this.typeName;
    }

    private n(String str, int i10, ba.b bVar) {
        super(str, i10);
        this.classId = bVar;
        ba.f fVarJ = bVar.j();
        kotlin.jvm.internal.m.e(fVarJ, "classId.shortClassName");
        this.typeName = fVarJ;
        this.arrayClassId = new ba.b(bVar.h(), ba.f.l(fVarJ.f() + "Array"));
    }
}
