package s;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class b0 implements l.v<BitmapDrawable>, l.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Resources f18134a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final l.v<Bitmap> f18135b;

    @Nullable
    public static l.v<BitmapDrawable> c(@NonNull Resources resources, @Nullable l.v<Bitmap> vVar) {
        if (vVar == null) {
            return null;
        }
        return new b0(resources, vVar);
    }

    @Override // l.v
    @NonNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public BitmapDrawable get() {
        return new BitmapDrawable(this.f18134a, this.f18135b.get());
    }

    @Override // l.v
    @NonNull
    public Class<BitmapDrawable> b() {
        return BitmapDrawable.class;
    }

    @Override // l.v
    public int getSize() {
        return this.f18135b.getSize();
    }

    @Override // l.r
    public void initialize() {
        l.v<Bitmap> vVar = this.f18135b;
        if (vVar instanceof l.r) {
            ((l.r) vVar).initialize();
        }
    }

    @Override // l.v
    public void recycle() {
        this.f18135b.recycle();
    }

    private b0(@NonNull Resources resources, @NonNull l.v<Bitmap> vVar) {
        this.f18134a = (Resources) e0.k.d(resources);
        this.f18135b = (l.v) e0.k.d(vVar);
    }
}
