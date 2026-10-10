package com.tvc.lib.mobile.ui.widget.sloading;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.view.animation.LinearInterpolator;
import androidx.annotation.FloatRange;
import com.google.android.material.color.utilities.Contrast;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class a implements ValueAnimator.AnimatorUpdateListener, Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f9512a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f9513b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f9514c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Drawable.Callback f9515d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ValueAnimator f9516e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f9517f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f9518g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f9519h;

    private void j() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f9516e = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setRepeatCount(-1);
        this.f9516e.setDuration(this.f9517f);
        this.f9516e.setStartDelay(333L);
        this.f9516e.setInterpolator(new LinearInterpolator());
    }

    protected abstract void a(ValueAnimator valueAnimator, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f10);

    protected abstract void k(Context context, int i10);

    protected abstract void n(Canvas canvas);

    protected abstract void o();

    protected abstract void p(ValueAnimator valueAnimator);

    protected abstract void q(int i10);

    protected abstract void t(ColorFilter colorFilter);

    private void l() {
        Drawable.Callback callback = this.f9515d;
        if (callback != null) {
            callback.invalidateDrawable(null);
        }
    }

    protected final float d() {
        return this.f9512a;
    }

    protected float e() {
        return this.f9514c;
    }

    protected float f() {
        return this.f9513b;
    }

    void i(Context context) {
        this.f9512a = b(context, 18.0f);
        this.f9513b = b(context, 56.0f);
        this.f9514c = b(context, 56.0f);
        this.f9517f = 1333L;
        j();
    }

    boolean m() {
        return this.f9516e.isRunning();
    }

    void r(Drawable.Callback callback) {
        this.f9515d = callback;
    }

    public void u(String str) {
        this.f9518g = str;
    }

    public void v(boolean z10) {
        this.f9519h = z10;
    }

    void w() {
        if (this.f9516e.isStarted()) {
            return;
        }
        this.f9516e.addUpdateListener(this);
        this.f9516e.addListener(this);
        this.f9516e.setRepeatCount(-1);
        this.f9516e.setDuration(this.f9517f);
        p(this.f9516e);
        this.f9516e.start();
    }

    void x() {
        this.f9516e.removeAllUpdateListeners();
        this.f9516e.removeAllListeners();
        this.f9516e.setRepeatCount(0);
        this.f9516e.setDuration(0L);
        o();
        this.f9516e.end();
    }

    protected static float b(Context context, float f10) {
        return f10 * context.getResources().getDisplayMetrics().density;
    }

    void c(Canvas canvas) {
        n(canvas);
    }

    protected final float g() {
        return f() * 0.5f;
    }

    protected final float h() {
        return e() * 0.5f;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        a(valueAnimator, ((Float) valueAnimator.getAnimatedValue()).floatValue());
        l();
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }

    protected void s(int i10) {
    }
}
