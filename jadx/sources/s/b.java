package s;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class b implements j.l<BitmapDrawable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final m.d f18132a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final j.l<Bitmap> f18133b;

    @Override // j.l
    @NonNull
    public j.c b(@NonNull j.i iVar) {
        return this.f18133b.b(iVar);
    }

    @Override // j.d
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull l.v<BitmapDrawable> vVar, @NonNull File file, @NonNull j.i iVar) {
        return this.f18133b.a((Bitmap) new f(vVar.get().getBitmap(), this.f18132a), file, iVar);
    }

    public b(m.d dVar, j.l<Bitmap> lVar) {
        this.f18132a = dVar;
        this.f18133b = lVar;
    }
}
