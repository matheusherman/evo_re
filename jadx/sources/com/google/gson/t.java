package com.google.gson;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public abstract class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t f4925a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final t f4926b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ t[] f4927c;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    final enum a extends t {
        a(String str, int i10) {
            super(str, i10, null);
        }
    }

    private t(String str, int i10) {
        super(str, i10);
    }

    static {
        a aVar = new a("DEFAULT", 0);
        f4925a = aVar;
        t tVar = new t("STRING", 1) { // from class: com.google.gson.t.b
            {
                a aVar2 = null;
            }
        };
        f4926b = tVar;
        f4927c = new t[]{aVar, tVar};
    }

    /* synthetic */ t(String str, int i10, a aVar) {
        this(str, i10);
    }

    public static t valueOf(String str) {
        return (t) Enum.valueOf(t.class, str);
    }

    public static t[] values() {
        return (t[]) f4927c.clone();
    }
}
