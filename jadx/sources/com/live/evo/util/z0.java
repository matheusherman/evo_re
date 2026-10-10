package com.live.evo.util;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static AlphaAnimation f7391a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static AlphaAnimation f7392b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static View f7393c;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements Animation.AnimationListener {
        a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (z0.f7393c != null) {
                z0.f7393c.startAnimation(z0.f7392b);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b implements Animation.AnimationListener {
        b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (z0.f7393c != null) {
                z0.f7393c.startAnimation(z0.f7391a);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public static void d(View view) {
        if (view != null) {
            view.animate().scaleX(1.1f).scaleY(1.1f).setInterpolator(new AccelerateInterpolator()).setDuration(200L);
        }
    }

    private static void e(View view, float f10, int i10) {
        if (f7391a == null) {
            f7391a = new AlphaAnimation(f10, 1.0f);
        }
        long j10 = i10;
        f7391a.setDuration(j10);
        if (f7392b == null) {
            f7392b = new AlphaAnimation(1.0f, f10);
        }
        f7392b.setDuration(j10);
        f7391a.setAnimationListener(new a());
        f7392b.setAnimationListener(new b());
        f7393c.startAnimation(f7392b);
    }

    public static void f(View view) {
        View view2 = f7393c;
        if (view2 != null) {
            if (view2.equals(view)) {
                return;
            } else {
                f7393c.clearAnimation();
            }
        }
        f7393c = view;
        if (view == null) {
            return;
        }
        e(view, 0.5f, 1500);
    }

    public static void g(View view) {
        if (view != null) {
            view.animate().scaleX(1.0f).scaleY(1.0f).setInterpolator(new AccelerateInterpolator()).setDuration(200L);
        }
    }

    public static void h(View view) {
        if (view == null) {
            return;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "translationY", 0.0f, 500.0f);
        objectAnimatorOfFloat.setDuration(300L);
        objectAnimatorOfFloat.setInterpolator(new AccelerateInterpolator());
        objectAnimatorOfFloat.start();
    }

    public static void i(View view) {
        if (view == null) {
            return;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "translationY", 500.0f, 0.0f);
        objectAnimatorOfFloat.setDuration(300L);
        objectAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
        objectAnimatorOfFloat.start();
    }
}
