package w;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import e0.k;
import j.m;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class c extends Drawable implements g.b, Animatable, Animatable2Compat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f20007a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f20008b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f20009c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f20010d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f20011e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f20012f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f20013g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f20014h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Paint f20015i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Rect f20016j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private List<Animatable2Compat.AnimationCallback> f20017k;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class a extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @VisibleForTesting
        final g f20018a;

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable(Resources resources) {
            return newDrawable();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            return new c(this);
        }

        a(g gVar) {
            this.f20018a = gVar;
        }
    }

    public c(Context context, h.a aVar, m<Bitmap> mVar, int i10, int i11, Bitmap bitmap) {
        this(new a(new g(com.bumptech.glide.c.c(context), aVar, i10, i11, mVar, bitmap)));
    }

    private void l() {
        this.f20012f = 0;
    }

    private void o() {
        this.f20008b = false;
        this.f20007a.f20018a.s(this);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    public void k() {
        this.f20010d = true;
        this.f20007a.f20018a.a();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.f20009c = true;
        l();
        if (this.f20011e) {
            n();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f20009c = false;
        o();
    }

    private Rect d() {
        if (this.f20016j == null) {
            this.f20016j = new Rect();
        }
        return this.f20016j;
    }

    private Paint h() {
        if (this.f20015i == null) {
            this.f20015i = new Paint(2);
        }
        return this.f20015i;
    }

    private void j() {
        List<Animatable2Compat.AnimationCallback> list = this.f20017k;
        if (list != null) {
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.f20017k.get(i10).onAnimationEnd(this);
            }
        }
    }

    private void n() {
        k.a(!this.f20010d, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.f20007a.f20018a.f() == 1) {
            invalidateSelf();
        } else {
            if (this.f20008b) {
                return;
            }
            this.f20008b = true;
            this.f20007a.f20018a.r(this);
            invalidateSelf();
        }
    }

    public ByteBuffer c() {
        return this.f20007a.f20018a.b();
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void clearAnimationCallbacks() {
        List<Animatable2Compat.AnimationCallback> list = this.f20017k;
        if (list != null) {
            list.clear();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.f20010d) {
            return;
        }
        if (this.f20014h) {
            Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), d());
            this.f20014h = false;
        }
        canvas.drawBitmap(this.f20007a.f20018a.c(), (Rect) null, d(), h());
    }

    public Bitmap e() {
        return this.f20007a.f20018a.e();
    }

    public int f() {
        return this.f20007a.f20018a.f();
    }

    public int g() {
        return this.f20007a.f20018a.d();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f20007a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f20007a.f20018a.h();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f20007a.f20018a.k();
    }

    public int i() {
        return this.f20007a.f20018a.j();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f20008b;
    }

    public void m(m<Bitmap> mVar, Bitmap bitmap) {
        this.f20007a.f20018a.o(mVar, bitmap);
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void registerAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        if (animationCallback == null) {
            return;
        }
        if (this.f20017k == null) {
            this.f20017k = new ArrayList();
        }
        this.f20017k.add(animationCallback);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z10, boolean z11) {
        k.a(!this.f20010d, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.f20011e = z10;
        if (!z10) {
            o();
        } else if (this.f20009c) {
            n();
        }
        return super.setVisible(z10, z11);
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public boolean unregisterAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        List<Animatable2Compat.AnimationCallback> list = this.f20017k;
        if (list == null || animationCallback == null) {
            return false;
        }
        return list.remove(animationCallback);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Drawable.Callback b() {
        Drawable.Callback callback = getCallback();
        while (callback instanceof Drawable) {
            callback = ((Drawable) callback).getCallback();
        }
        return callback;
    }

    @Override // w.g.b
    public void a() {
        if (b() == null) {
            stop();
            invalidateSelf();
            return;
        }
        invalidateSelf();
        if (g() == f() - 1) {
            this.f20012f++;
        }
        int i10 = this.f20013g;
        if (i10 != -1 && this.f20012f >= i10) {
            j();
            stop();
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f20014h = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        h().setAlpha(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        h().setColorFilter(colorFilter);
    }

    c(a aVar) {
        this.f20011e = true;
        this.f20013g = -1;
        this.f20007a = (a) k.d(aVar);
    }
}
