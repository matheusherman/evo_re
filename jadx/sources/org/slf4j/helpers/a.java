package org.slf4j.helpers;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static a f17119d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f17120a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Throwable f17121b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Object[] f17122c;

    public a(String str) {
        this(str, null, null);
    }

    public a(String str, Object[] objArr, Throwable th) {
        this.f17120a = str;
        this.f17121b = th;
        this.f17122c = objArr;
    }

    public Object[] a() {
        return this.f17122c;
    }

    public String b() {
        return this.f17120a;
    }

    public Throwable c() {
        return this.f17121b;
    }
}
