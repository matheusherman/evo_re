package com.koushikdutta.async.http;

import java.util.Hashtable;
import java.util.Locale;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f5098a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m f5099b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final m f5100c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final m f5101d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Hashtable<String, m> f5102e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final /* synthetic */ m[] f5103f;
    private final String protocol;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static enum a extends m {
        a(String str, int i10, String str2) {
            super(str, i10, str2, null);
        }
    }

    /* synthetic */ m(String str, int i10, String str2, a aVar) {
        this(str, i10, str2);
    }

    static {
        m mVar = new m("HTTP_1_0", 0, "http/1.0");
        f5098a = mVar;
        m mVar2 = new m("HTTP_1_1", 1, "http/1.1");
        f5099b = mVar2;
        a aVar = new a("SPDY_3", 2, "spdy/3.1");
        f5100c = aVar;
        m mVar3 = new m("HTTP_2", 3, "h2-13") { // from class: com.koushikdutta.async.http.m.b
            {
                a aVar2 = null;
            }
        };
        f5101d = mVar3;
        f5103f = new m[]{mVar, mVar2, aVar, mVar3};
        Hashtable<String, m> hashtable = new Hashtable<>();
        f5102e = hashtable;
        hashtable.put(mVar.toString(), mVar);
        hashtable.put(mVar2.toString(), mVar2);
        hashtable.put(aVar.toString(), aVar);
        hashtable.put(mVar3.toString(), mVar3);
    }

    private m(String str, int i10, String str2) {
        super(str, i10);
        this.protocol = str2;
    }

    public static m a(String str) {
        if (str == null) {
            return null;
        }
        return f5102e.get(str.toLowerCase(Locale.US));
    }

    public static m valueOf(String str) {
        return (m) Enum.valueOf(m.class, str);
    }

    public static m[] values() {
        return (m[]) f5103f.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.protocol;
    }
}
