package w;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import j.k;
import l.v;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class h implements k<h.a, Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final m.d f20043a;

    @Override // j.k
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull h.a aVar, @NonNull j.i iVar) {
        return true;
    }

    public h(m.d dVar) {
        this.f20043a = dVar;
    }

    @Override // j.k
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public v<Bitmap> b(@NonNull h.a aVar, int i10, int i11, @NonNull j.i iVar) {
        return s.f.c(aVar.a(), this.f20043a);
    }
}
