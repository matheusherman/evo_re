package je;

import java.security.spec.KeySpec;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class b implements KeySpec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private short[][] f11718a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private short[][] f11719b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private short[] f11720c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f11721d;

    public short[][] a() {
        return this.f11718a;
    }

    public short[] b() {
        return this.f11720c;
    }

    public short[][] c() {
        return this.f11719b;
    }

    public int d() {
        return this.f11721d;
    }

    public b(int i10, short[][] sArr, short[][] sArr2, short[] sArr3) {
        this.f11721d = i10;
        this.f11718a = sArr;
        this.f11719b = sArr2;
        this.f11720c = sArr3;
    }
}
