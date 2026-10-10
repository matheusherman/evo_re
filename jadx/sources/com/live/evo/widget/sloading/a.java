package com.live.evo.widget.sloading;

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
    private float f7717a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f7718b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f7719c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Drawable.Callback f7720d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ValueAnimator f7721e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f7722f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f7723g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f7724h;

    private void j() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f7721e = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setRepeatCount(-1);
        this.f7721e.setDuration(this.f7722f);
        this.f7721e.setStartDelay(333L);
        this.f7721e.setInterpolator(new LinearInterpolator());
    }

    protected abstract void a(ValueAnimator valueAnimator, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f10);

    protected abstract void k(Context context, int i10);

    protected abstract void n(Canvas canvas);

    protected abstract void o();

    protected abstract void p(ValueAnimator valueAnimator);

    protected abstract void q(int i10);

    protected abstract void t(ColorFilter colorFilter);

    private void l() {
        Drawable.Callback callback = this.f7720d;
        if (callback != null) {
            callback.invalidateDrawable(null);
        }
    }

    protected final float d() {
        return this.f7717a;
    }

    protected float e() {
        return this.f7719c;
    }

    protected float f() {
        return this.f7718b;
    }

    void i(Context context) {
        this.f7717a = b(context, 18.0f);
        this.f7718b = b(context, 56.0f);
        this.f7719c = b(context, 56.0f);
        this.f7722f = 1333L;
        j();
    }

    boolean m() {
        return this.f7721e.isRunning();
    }

    void r(Drawable.Callback callback) {
        this.f7720d = callback;
    }

    public void u(String str) {
        this.f7723g = str;
    }

    public void v(boolean z10) {
        this.f7724h = z10;
    }

    void w() {
        if (this.f7721e.isStarted()) {
            return;
        }
        this.f7721e.addUpdateListener(this);
        this.f7721e.addListener(this);
        this.f7721e.setRepeatCount(-1);
        this.f7721e.setDuration(this.f7722f);
        p(this.f7721e);
        this.f7721e.start();
    }

    void x() {
        this.f7721e.removeAllUpdateListeners();
        this.f7721e.removeAllListeners();
        this.f7721e.setRepeatCount(0);
        this.f7721e.setDuration(0L);
        o();
        this.f7721e.end();
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
