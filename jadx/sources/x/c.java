package x;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import j.i;
import l.v;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class c implements e<Drawable, byte[]> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final m.d f20524a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e<Bitmap, byte[]> f20525b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e<w.c, byte[]> f20526c;

    public c(@NonNull m.d dVar, @NonNull e<Bitmap, byte[]> eVar, @NonNull e<w.c, byte[]> eVar2) {
        this.f20524a = dVar;
        this.f20525b = eVar;
        this.f20526c = eVar2;
    }

    @Override // x.e
    @Nullable
    public v<byte[]> a(@NonNull v<Drawable> vVar, @NonNull i iVar) {
        Drawable drawable = vVar.get();
        if (drawable instanceof BitmapDrawable) {
            return this.f20525b.a(s.f.c(((BitmapDrawable) drawable).getBitmap(), this.f20524a), iVar);
        }
        if (drawable instanceof w.c) {
            return this.f20526c.a(b(vVar), iVar);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    private static v<w.c> b(@NonNull v<Drawable> vVar) {
        return vVar;
    }
}
