package ld;

import tc.l;
import vc.k;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final short[] f15394g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final short[] f15395h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final short[] f15396i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final d f15397j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final d f15398k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final d f15399l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final d f15400m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final d f15401n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final d f15402o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f15403a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f15404b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f15405c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f15406d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f15407e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final a f15408f;

    static {
        short[] sArr = {4643, 13363, 20579, 25843, 29227, 31145, 32103, 32525, 32689, 32745, 32762, 32766, Short.MAX_VALUE};
        f15394g = sArr;
        short[] sArr2 = {5638, 15915, 23689, 28571, 31116, 32217, 32613, 32731, 32760, 32766, Short.MAX_VALUE};
        f15395h = sArr2;
        short[] sArr3 = {9142, 23462, 30338, 32361, 32725, 32765, Short.MAX_VALUE};
        f15396i = sArr3;
        f15397j = new d("frodokem640aes", 640, 15, 2, sArr, new k(128), new c.a(640, 32768));
        f15398k = new d("frodokem640shake", 640, 15, 2, sArr, new k(128), new c.b(640, 32768));
        f15399l = new d("frodokem976aes", 976, 16, 3, sArr2, new k(256), new c.a(976, 65536));
        f15400m = new d("frodokem976shake", 976, 16, 3, sArr2, new k(256), new c.b(976, 65536));
        f15401n = new d("frodokem1344aes", 1344, 16, 4, sArr3, new k(256), new c.a(1344, 65536));
        f15402o = new d("frodokem1344shake", 1344, 16, 4, sArr3, new k(256), new c.b(1344, 65536));
    }

    private d(String str, int i10, int i11, int i12, short[] sArr, l lVar, c cVar) {
        this.f15403a = str;
        this.f15404b = i10;
        this.f15405c = i11;
        this.f15406d = i12;
        this.f15407e = i12 * 64;
        this.f15408f = new a(i10, i11, i12, sArr, lVar, cVar);
    }
}
