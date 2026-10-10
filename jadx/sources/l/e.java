package l;

import androidx.annotation.NonNull;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
class e<DataType> implements n.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j.d<DataType> f14974a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DataType f14975b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final j.i f14976c;

    @Override // n.a.b
    public boolean a(@NonNull File file) {
        return this.f14974a.a(this.f14975b, file, this.f14976c);
    }

    e(j.d<DataType> dVar, DataType datatype, j.i iVar) {
        this.f14974a = dVar;
        this.f14975b = datatype;
        this.f14976c = iVar;
    }
}
