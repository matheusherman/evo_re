package com.google.android.gms.internal.measurement;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'b' uses external variables
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
public final class oa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final oa f2918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final oa f2919b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final oa f2920c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final oa f2921d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final oa f2922e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final oa f2923f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final oa f2924g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final oa f2925h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final oa f2926i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final oa f2927j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final /* synthetic */ oa[] f2928k;
    private final Class<?> zzl;

    static {
        oa oaVar = new oa("VOID", 0, Void.class, Void.class, null);
        f2918a = oaVar;
        Class cls = Integer.TYPE;
        oa oaVar2 = new oa("INT", 1, cls, Integer.class, 0);
        f2919b = oaVar2;
        oa oaVar3 = new oa("LONG", 2, Long.TYPE, Long.class, 0L);
        f2920c = oaVar3;
        oa oaVar4 = new oa("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        f2921d = oaVar4;
        oa oaVar5 = new oa("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(0.0d));
        f2922e = oaVar5;
        oa oaVar6 = new oa("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        f2923f = oaVar6;
        oa oaVar7 = new oa("STRING", 6, String.class, String.class, "");
        f2924g = oaVar7;
        oa oaVar8 = new oa("BYTE_STRING", 7, v8.class, v8.class, v8.f3170a);
        f2925h = oaVar8;
        oa oaVar9 = new oa("ENUM", 8, cls, Integer.class, null);
        f2926i = oaVar9;
        oa oaVar10 = new oa("MESSAGE", 9, Object.class, Object.class, null);
        f2927j = oaVar10;
        f2928k = new oa[]{oaVar, oaVar2, oaVar3, oaVar4, oaVar5, oaVar6, oaVar7, oaVar8, oaVar9, oaVar10};
    }

    public static oa[] values() {
        return (oa[]) f2928k.clone();
    }

    public final Class<?> a() {
        return this.zzl;
    }

    private oa(String str, int i10, Class cls, Class cls2, Object obj) {
        super(str, i10);
        this.zzl = cls2;
    }
}
