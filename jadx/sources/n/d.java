package n;

import java.io.File;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class d implements n.a.InterfaceC0306a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f15816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f15817b;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface a {
        File a();
    }

    @Override // n.a.InterfaceC0306a
    public n.a build() {
        File fileA = this.f15817b.a();
        if (fileA == null) {
            return null;
        }
        if (fileA.isDirectory() || fileA.mkdirs()) {
            return e.c(fileA, this.f15816a);
        }
        return null;
    }

    public d(a aVar, long j10) {
        this.f15816a = j10;
        this.f15817b = aVar;
    }
}
