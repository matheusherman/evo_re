package jf;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class a extends Drawable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ColorFilter f11723b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ColorStateList f11724c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private PorterDuffColorFilter f11726e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f11722a = 255;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private PorterDuff.Mode f11725d = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private C0200a f11727f = new C0200a(this, null);

    /* JADX INFO: renamed from: jf.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private class C0200a extends Drawable.ConstantState {
        /* synthetic */ C0200a(a aVar, b bVar) {
            this();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        private C0200a() {
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            return a.this;
        }
    }

    protected abstract void b(Canvas canvas, int i10, int i11);

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    private boolean c() {
        ColorStateList colorStateList = this.f11724c;
        if (colorStateList != null && this.f11725d != null) {
            this.f11726e = new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), this.f11725d);
            return true;
        }
        boolean z10 = this.f11726e != null;
        this.f11726e = null;
        return z10;
    }

    protected ColorFilter a() {
        ColorFilter colorFilter = this.f11723b;
        return colorFilter != null ? colorFilter : this.f11726e;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f11722a;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.f11723b;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f11727f;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList = this.f11724c;
        return colorStateList != null && colorStateList.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        if (this.f11722a != i10) {
            this.f11722a = i10;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.f11723b = colorFilter;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(@Nullable ColorStateList colorStateList) {
        this.f11724c = colorStateList;
        if (c()) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(@NonNull PorterDuff.Mode mode) {
        this.f11725d = mode;
        if (c()) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        if (bounds.width() != 0 && bounds.height() != 0) {
            int iSave = canvas.save();
            canvas.translate(bounds.left, bounds.top);
            b(canvas, bounds.width(), bounds.height());
            canvas.restoreToCount(iSave);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        return c();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(@ColorInt int i10) {
        setTintList(ColorStateList.valueOf(i10));
    }
}
