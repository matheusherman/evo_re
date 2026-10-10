package u;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import l.r;
import l.v;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public abstract class i<T extends Drawable> implements v<T>, r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final T f19307a;

    @Override // l.v
    @NonNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final T get() {
        Drawable.ConstantState constantState = this.f19307a.getConstantState();
        return constantState == null ? this.f19307a : (T) constantState.newDrawable();
    }

    @Override // l.r
    public void initialize() {
        T t10 = this.f19307a;
        if (t10 instanceof BitmapDrawable) {
            ((BitmapDrawable) t10).getBitmap().prepareToDraw();
        } else if (t10 instanceof w.c) {
            ((w.c) t10).e().prepareToDraw();
        }
    }

    public i(T t10) {
        this.f19307a = (T) e0.k.d(t10);
    }
}
