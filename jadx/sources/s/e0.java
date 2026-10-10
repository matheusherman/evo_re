package s;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class e0 implements j.k<Uri, Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final u.k f18147a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final m.d f18148b;

    @Override // j.k
    @Nullable
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public l.v<Bitmap> b(@NonNull Uri uri, int i10, int i11, @NonNull j.i iVar) {
        l.v<Drawable> vVarB = this.f18147a.b(uri, i10, i11, iVar);
        if (vVarB == null) {
            return null;
        }
        return u.a(this.f18148b, vVarB.get(), i10, i11);
    }

    @Override // j.k
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull Uri uri, @NonNull j.i iVar) {
        return "android.resource".equals(uri.getScheme());
    }

    public e0(u.k kVar, m.d dVar) {
        this.f18147a = kVar;
        this.f18148b = dVar;
    }
}
