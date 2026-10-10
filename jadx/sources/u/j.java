package u;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import l.v;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class j extends i<Drawable> {
    @Nullable
    static v<Drawable> c(@Nullable Drawable drawable) {
        if (drawable != null) {
            return new j(drawable);
        }
        return null;
    }

    @Override // l.v
    @NonNull
    public Class<Drawable> b() {
        return this.f19307a.getClass();
    }

    @Override // l.v
    public int getSize() {
        return Math.max(1, this.f19307a.getIntrinsicWidth() * this.f19307a.getIntrinsicHeight() * 4);
    }

    private j(Drawable drawable) {
        super(drawable);
    }

    @Override // l.v
    public void recycle() {
    }
}
