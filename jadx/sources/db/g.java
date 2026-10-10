package db;

import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class g extends f {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f9686e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f9687f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private k[] f9688g;

    @Override // db.f
    public String i(i iVar, Locale locale) {
        k[] kVarArr = this.f9688g;
        if (kVarArr.length > 0) {
            return kVarArr[0].toString();
        }
        return null;
    }

    public long j() {
        return this.f9687f;
    }

    public void k(long j10) {
        this.f9687f = j10;
    }

    public void l(long j10) {
        this.f9686e = j10;
    }

    public void m(k[] kVarArr) {
        this.f9688g = kVarArr;
    }

    @Override // db.f
    public String toString() {
        return "ResourceMapEntry{parent=" + this.f9686e + ", count=" + this.f9687f + ", resourceTableMaps=" + Arrays.toString(this.f9688g) + '}';
    }

    public g(f fVar) {
        g(fVar.c());
        e(fVar.a());
        f(fVar.b());
    }
}
