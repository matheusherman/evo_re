package p3;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f17285a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f17286b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f17287c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<byte[]> f17288d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f17289e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Integer f17290f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Integer f17291g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Object f17292h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f17293i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f17294j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f17295k;

    public e(byte[] bArr, String str, List<byte[]> list, String str2) {
        this(bArr, str, list, str2, -1, -1, 0);
    }

    public e(byte[] bArr, String str, List<byte[]> list, String str2, int i10) {
        this(bArr, str, list, str2, -1, -1, i10);
    }

    public List<byte[]> a() {
        return this.f17288d;
    }

    public String b() {
        return this.f17289e;
    }

    public Integer c() {
        return this.f17291g;
    }

    public Integer d() {
        return this.f17290f;
    }

    public int e() {
        return this.f17286b;
    }

    public Object f() {
        return this.f17292h;
    }

    public byte[] g() {
        return this.f17285a;
    }

    public int h() {
        return this.f17293i;
    }

    public int i() {
        return this.f17294j;
    }

    public int j() {
        return this.f17295k;
    }

    public String k() {
        return this.f17287c;
    }

    public boolean l() {
        return this.f17293i >= 0 && this.f17294j >= 0;
    }

    public void m(Integer num) {
        this.f17291g = num;
    }

    public void n(Integer num) {
        this.f17290f = num;
    }

    public void o(int i10) {
        this.f17286b = i10;
    }

    public void p(Object obj) {
        this.f17292h = obj;
    }

    public e(byte[] bArr, String str, List<byte[]> list, String str2, int i10, int i11, int i12) {
        this.f17285a = bArr;
        this.f17286b = bArr == null ? 0 : bArr.length * 8;
        this.f17287c = str;
        this.f17288d = list;
        this.f17289e = str2;
        this.f17293i = i11;
        this.f17294j = i10;
        this.f17295k = i12;
    }
}
