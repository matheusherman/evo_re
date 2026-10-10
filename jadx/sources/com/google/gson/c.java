package com.google.gson;

import java.lang.reflect.Field;
import java.util.Locale;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public abstract class c implements com.google.gson.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f4794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f4795b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f4796c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f4797d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f4798e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final c f4799f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final c f4800g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final /* synthetic */ c[] f4801h;

    private c(String str, int i10) {
        super(str, i10);
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    final enum a extends c {
        a(String str, int i10) {
            super(str, i10, null);
        }

        @Override // com.google.gson.d
        public String a(Field field) {
            return field.getName();
        }
    }

    static {
        a aVar = new a("IDENTITY", 0);
        f4794a = aVar;
        c cVar = new c("UPPER_CAMEL_CASE", 1) { // from class: com.google.gson.c.b
            {
                a aVar2 = null;
            }

            @Override // com.google.gson.d
            public String a(Field field) {
                return c.i(field.getName());
            }
        };
        f4795b = cVar;
        c cVar2 = new c("UPPER_CAMEL_CASE_WITH_SPACES", 2) { // from class: com.google.gson.c.c
            {
                a aVar2 = null;
            }

            @Override // com.google.gson.d
            public String a(Field field) {
                return c.i(c.f(field.getName(), ' '));
            }
        };
        f4796c = cVar2;
        c cVar3 = new c("UPPER_CASE_WITH_UNDERSCORES", 3) { // from class: com.google.gson.c.d
            {
                a aVar2 = null;
            }

            @Override // com.google.gson.d
            public String a(Field field) {
                return c.f(field.getName(), '_').toUpperCase(Locale.ENGLISH);
            }
        };
        f4797d = cVar3;
        c cVar4 = new c("LOWER_CASE_WITH_UNDERSCORES", 4) { // from class: com.google.gson.c.e
            {
                a aVar2 = null;
            }

            @Override // com.google.gson.d
            public String a(Field field) {
                return c.f(field.getName(), '_').toLowerCase(Locale.ENGLISH);
            }
        };
        f4798e = cVar4;
        c cVar5 = new c("LOWER_CASE_WITH_DASHES", 5) { // from class: com.google.gson.c.f
            {
                a aVar2 = null;
            }

            @Override // com.google.gson.d
            public String a(Field field) {
                return c.f(field.getName(), '-').toLowerCase(Locale.ENGLISH);
            }
        };
        f4799f = cVar5;
        c cVar6 = new c("LOWER_CASE_WITH_DOTS", 6) { // from class: com.google.gson.c.g
            {
                a aVar2 = null;
            }

            @Override // com.google.gson.d
            public String a(Field field) {
                return c.f(field.getName(), '.').toLowerCase(Locale.ENGLISH);
            }
        };
        f4800g = cVar6;
        f4801h = new c[]{aVar, cVar, cVar2, cVar3, cVar4, cVar5, cVar6};
    }

    /* synthetic */ c(String str, int i10, a aVar) {
        this(str, i10);
    }

    static String f(String str, char c10) {
        StringBuilder sb2 = new StringBuilder();
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = str.charAt(i10);
            if (Character.isUpperCase(cCharAt) && sb2.length() != 0) {
                sb2.append(c10);
            }
            sb2.append(cCharAt);
        }
        return sb2.toString();
    }

    public static c valueOf(String str) {
        return (c) Enum.valueOf(c.class, str);
    }

    public static c[] values() {
        return (c[]) f4801h.clone();
    }

    static String i(String str) {
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = str.charAt(i10);
            if (Character.isLetter(cCharAt)) {
                if (Character.isUpperCase(cCharAt)) {
                    break;
                }
                char upperCase = Character.toUpperCase(cCharAt);
                if (i10 == 0) {
                    return upperCase + str.substring(1);
                }
                return str.substring(0, i10) + upperCase + str.substring(i10 + 1);
            }
        }
        return str;
    }
}
