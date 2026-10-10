package s;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class f implements l.v<Bitmap>, l.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Bitmap f18149a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final m.d f18150b;

    @Nullable
    public static f c(@Nullable Bitmap bitmap, @NonNull m.d dVar) {
        if (bitmap == null) {
            return null;
        }
        return new f(bitmap, dVar);
    }

    @Override // l.v
    @NonNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Bitmap get() {
        return this.f18149a;
    }

    @Override // l.v
    @NonNull
    public Class<Bitmap> b() {
        return Bitmap.class;
    }

    @Override // l.v
    public int getSize() {
        return e0.l.h(this.f18149a);
    }

    @Override // l.r
    public void initialize() {
        this.f18149a.prepareToDraw();
    }

    @Override // l.v
    public void recycle() {
        this.f18150b.c(this.f18149a);
    }

    public f(@NonNull Bitmap bitmap, @NonNull m.d dVar) {
        this.f18149a = (Bitmap) e0.k.e(bitmap, "Bitmap must not be null");
        this.f18150b = (m.d) e0.k.e(dVar, "BitmapPool must not be null");
    }
}
