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
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f12651a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m f12652b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final m f12653c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final m f12654d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ m[] f12655e;
    private final ba.b classId;
    private final ba.f typeName;

    private static final /* synthetic */ m[] a() {
        return new m[]{f12651a, f12652b, f12653c, f12654d};
    }

    static {
        ba.b bVarE = ba.b.e("kotlin/UByteArray");
        kotlin.jvm.internal.m.e(bVarE, "fromString(\"kotlin/UByteArray\")");
        f12651a = new m("UBYTEARRAY", 0, bVarE);
        ba.b bVarE2 = ba.b.e("kotlin/UShortArray");
        kotlin.jvm.internal.m.e(bVarE2, "fromString(\"kotlin/UShortArray\")");
        f12652b = new m("USHORTARRAY", 1, bVarE2);
        ba.b bVarE3 = ba.b.e("kotlin/UIntArray");
        kotlin.jvm.internal.m.e(bVarE3, "fromString(\"kotlin/UIntArray\")");
        f12653c = new m("UINTARRAY", 2, bVarE3);
        ba.b bVarE4 = ba.b.e("kotlin/ULongArray");
        kotlin.jvm.internal.m.e(bVarE4, "fromString(\"kotlin/ULongArray\")");
        f12654d = new m("ULONGARRAY", 3, bVarE4);
        f12655e = a();
    }

    public static m valueOf(String str) {
        return (m) Enum.valueOf(m.class, str);
    }

    public static m[] values() {
        return (m[]) f12655e.clone();
    }

    public final ba.f f() {
        return this.typeName;
    }

    private m(String str, int i10, ba.b bVar) {
        super(str, i10);
        this.classId = bVar;
        ba.f fVarJ = bVar.j();
        kotlin.jvm.internal.m.e(fVarJ, "classId.shortClassName");
        this.typeName = fVarJ;
    }
}
