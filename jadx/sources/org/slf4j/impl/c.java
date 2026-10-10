package org.slf4j.impl;

import org.apache.log4j.Level;
import org.slf4j.helpers.i;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final c f17137b = new c();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f17138c = "1.6.99";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f17139d = b.class.getName();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final bf.a f17140a = new b();

    public static final c c() {
        return f17137b;
    }

    public bf.a a() {
        return this.f17140a;
    }

    public String b() {
        return f17139d;
    }

    private c() {
        try {
            int i10 = Level.TRACE_INT;
        } catch (NoSuchFieldError unused) {
            i.a("This version of SLF4J requires log4j version 1.2.12 or later. See also http://www.slf4j.org/codes.html#log4j_version");
        }
    }
}
