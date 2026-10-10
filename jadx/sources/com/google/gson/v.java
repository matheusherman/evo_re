package com.google.gson;

import java.io.IOException;
import java.math.BigDecimal;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public abstract class v implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v f4933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final v f4934b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final v f4935c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final v f4936d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ v[] f4937e;

    private v(String str, int i10) {
        super(str, i10);
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    final enum a extends v {
        a(String str, int i10) {
            super(str, i10, null);
        }

        @Override // com.google.gson.w
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Double a(g3.a aVar) {
            return Double.valueOf(aVar.s());
        }
    }

    static {
        a aVar = new a("DOUBLE", 0);
        f4933a = aVar;
        v vVar = new v("LAZILY_PARSED_NUMBER", 1) { // from class: com.google.gson.v.b
            {
                a aVar2 = null;
            }

            @Override // com.google.gson.w
            public Number a(g3.a aVar2) {
                return new com.google.gson.internal.g(aVar2.z());
            }
        };
        f4934b = vVar;
        v vVar2 = new v("LONG_OR_DOUBLE", 2) { // from class: com.google.gson.v.c
            {
                a aVar2 = null;
            }

            @Override // com.google.gson.w
            public Number a(g3.a aVar2) throws IOException {
                String strZ = aVar2.z();
                try {
                    try {
                        return Long.valueOf(Long.parseLong(strZ));
                    } catch (NumberFormatException unused) {
                        Double dValueOf = Double.valueOf(strZ);
                        if (dValueOf.isInfinite() || dValueOf.isNaN()) {
                            if (!aVar2.o()) {
                                throw new g3.d("JSON forbids NaN and infinities: " + dValueOf + "; at path " + aVar2.m());
                            }
                        }
                        return dValueOf;
                    }
                } catch (NumberFormatException e10) {
                    throw new o("Cannot parse " + strZ + "; at path " + aVar2.m(), e10);
                }
            }
        };
        f4935c = vVar2;
        v vVar3 = new v("BIG_DECIMAL", 3) { // from class: com.google.gson.v.d
            {
                a aVar2 = null;
            }

            @Override // com.google.gson.w
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public BigDecimal a(g3.a aVar2) throws IOException {
                String strZ = aVar2.z();
                try {
                    return new BigDecimal(strZ);
                } catch (NumberFormatException e10) {
                    throw new o("Cannot parse " + strZ + "; at path " + aVar2.m(), e10);
                }
            }
        };
        f4936d = vVar3;
        f4937e = new v[]{aVar, vVar, vVar2, vVar3};
    }

    /* synthetic */ v(String str, int i10, a aVar) {
        this(str, i10);
    }

    public static v valueOf(String str) {
        return (v) Enum.valueOf(v.class, str);
    }

    public static v[] values() {
        return (v[]) f4937e.clone();
    }
}
