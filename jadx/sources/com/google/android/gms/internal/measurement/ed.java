package com.google.android.gms.internal.measurement;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'c' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class ed {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ed f2643a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ed f2644b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ed f2645c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ed f2646d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ed f2647e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ed f2648f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ed f2649g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ed f2650h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ed f2651i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ed f2652j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ed f2653k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final ed f2654l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final ed f2655m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final ed f2656n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final ed f2657o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final ed f2658p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final ed f2659q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final ed f2660r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final /* synthetic */ ed[] f2661s;
    private final ld zzt;
    private final int zzu;

    /* synthetic */ ed(String str, int i10, ld ldVar, int i11, kd kdVar) {
        this(str, i10, ldVar, i11);
    }

    static {
        ed edVar = new ed("DOUBLE", 0, ld.DOUBLE, 1);
        f2643a = edVar;
        ed edVar2 = new ed("FLOAT", 1, ld.FLOAT, 5);
        f2644b = edVar2;
        ld ldVar = ld.LONG;
        ed edVar3 = new ed("INT64", 2, ldVar, 0);
        f2645c = edVar3;
        ed edVar4 = new ed("UINT64", 3, ldVar, 0);
        f2646d = edVar4;
        ld ldVar2 = ld.INT;
        ed edVar5 = new ed("INT32", 4, ldVar2, 0);
        f2647e = edVar5;
        ed edVar6 = new ed("FIXED64", 5, ldVar, 1);
        f2648f = edVar6;
        ed edVar7 = new ed("FIXED32", 6, ldVar2, 5);
        f2649g = edVar7;
        ed edVar8 = new ed("BOOL", 7, ld.BOOLEAN, 0);
        f2650h = edVar8;
        hd hdVar = new hd("STRING", 8, ld.STRING, 2, null);
        f2651i = hdVar;
        ld ldVar3 = ld.MESSAGE;
        gd gdVar = new gd("GROUP", 9, ldVar3, 3, null);
        f2652j = gdVar;
        jd jdVar = new jd("MESSAGE", 10, ldVar3, 2, null);
        f2653k = jdVar;
        id idVar = new id("BYTES", 11, ld.BYTE_STRING, 2, null);
        f2654l = idVar;
        ed edVar9 = new ed("UINT32", 12, ldVar2, 0);
        f2655m = edVar9;
        ed edVar10 = new ed("ENUM", 13, ld.ENUM, 0);
        f2656n = edVar10;
        ed edVar11 = new ed("SFIXED32", 14, ldVar2, 5);
        f2657o = edVar11;
        ed edVar12 = new ed("SFIXED64", 15, ldVar, 1);
        f2658p = edVar12;
        ed edVar13 = new ed("SINT32", 16, ldVar2, 0);
        f2659q = edVar13;
        ed edVar14 = new ed("SINT64", 17, ldVar, 0);
        f2660r = edVar14;
        f2661s = new ed[]{edVar, edVar2, edVar3, edVar4, edVar5, edVar6, edVar7, edVar8, hdVar, gdVar, jdVar, idVar, edVar9, edVar10, edVar11, edVar12, edVar13, edVar14};
    }

    private ed(String str, int i10, ld ldVar, int i11) {
        super(str, i10);
        this.zzt = ldVar;
        this.zzu = i11;
    }

    public static ed[] values() {
        return (ed[]) f2661s.clone();
    }

    public final ld a() {
        return this.zzt;
    }
}
