package h3;

import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10817a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte[] f10818b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f10819c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private s[] f10820d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final a f10821e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Map<r, Object> f10822f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final long f10823g;

    public q(String str, byte[] bArr, s[] sVarArr, a aVar) {
        this(str, bArr, sVarArr, aVar, System.currentTimeMillis());
    }

    public q(String str, byte[] bArr, s[] sVarArr, a aVar, long j10) {
        this(str, bArr, bArr == null ? 0 : bArr.length * 8, sVarArr, aVar, j10);
    }

    public void a(s[] sVarArr) {
        s[] sVarArr2 = this.f10820d;
        if (sVarArr2 == null) {
            this.f10820d = sVarArr;
            return;
        }
        if (sVarArr == null || sVarArr.length <= 0) {
            return;
        }
        s[] sVarArr3 = new s[sVarArr2.length + sVarArr.length];
        System.arraycopy(sVarArr2, 0, sVarArr3, 0, sVarArr2.length);
        System.arraycopy(sVarArr, 0, sVarArr3, sVarArr2.length, sVarArr.length);
        this.f10820d = sVarArr3;
    }

    public a b() {
        return this.f10821e;
    }

    public byte[] c() {
        return this.f10818b;
    }

    public Map<r, Object> d() {
        return this.f10822f;
    }

    public s[] e() {
        return this.f10820d;
    }

    public String f() {
        return this.f10817a;
    }

    public void g(Map<r, Object> map) {
        if (map != null) {
            Map<r, Object> map2 = this.f10822f;
            if (map2 == null) {
                this.f10822f = map;
            } else {
                map2.putAll(map);
            }
        }
    }

    public void h(r rVar, Object obj) {
        if (this.f10822f == null) {
            this.f10822f = new EnumMap(r.class);
        }
        this.f10822f.put(rVar, obj);
    }

    public String toString() {
        return this.f10817a;
    }

    public q(String str, byte[] bArr, int i10, s[] sVarArr, a aVar, long j10) {
        this.f10817a = str;
        this.f10818b = bArr;
        this.f10819c = i10;
        this.f10820d = sVarArr;
        this.f10821e = aVar;
        this.f10822f = null;
        this.f10823g = j10;
    }
}
