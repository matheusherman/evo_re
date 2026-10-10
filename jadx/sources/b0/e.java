package b0;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public abstract class e<Z> extends j<ImageView, Z> implements c0.b.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    private Animatable f613i;

    protected abstract void q(@Nullable Z z10);

    private void o(@Nullable Z z10) {
        if (!(z10 instanceof Animatable)) {
            this.f613i = null;
            return;
        }
        Animatable animatable = (Animatable) z10;
        this.f613i = animatable;
        animatable.start();
    }

    @Override // b0.i
    public void b(@NonNull Z z10, @Nullable c0.b<? super Z> bVar) {
        if (bVar == null || !bVar.a(z10, this)) {
            r(z10);
        } else {
            o(z10);
        }
    }

    @Override // b0.a, com.bumptech.glide.manager.m
    public void h() {
        Animatable animatable = this.f613i;
        if (animatable != null) {
            animatable.stop();
        }
    }

    @Override // b0.a, com.bumptech.glide.manager.m
    public void onStart() {
        Animatable animatable = this.f613i;
        if (animatable != null) {
            animatable.start();
        }
    }

    public void p(Drawable drawable) {
        ((ImageView) this.f618b).setImageDrawable(drawable);
    }

    public e(ImageView imageView) {
        super(imageView);
    }

    private void r(@Nullable Z z10) {
        q(z10);
        o(z10);
    }

    @Override // b0.a, b0.i
    public void g(@Nullable Drawable drawable) {
        super.g(drawable);
        r(null);
        p(drawable);
    }

    @Override // b0.j, b0.a, b0.i
    public void k(@Nullable Drawable drawable) {
        super.k(drawable);
        r(null);
        p(drawable);
    }

    @Override // b0.j, b0.a, b0.i
    public void n(@Nullable Drawable drawable) {
        super.n(drawable);
        Animatable animatable = this.f613i;
        if (animatable != null) {
            animatable.stop();
        }
        r(null);
        p(drawable);
    }
}
