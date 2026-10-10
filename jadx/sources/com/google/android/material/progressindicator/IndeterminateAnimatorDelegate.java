package com.google.android.material.progressindicator;

import android.animation.Animator;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.core.math.MathUtils;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
abstract class IndeterminateAnimatorDelegate<T extends Animator> {
    protected final List<DrawingDelegate.ActiveIndicator> activeIndicators = new ArrayList();
    protected IndeterminateDrawable drawable;

    abstract void cancelAnimatorImmediately();

    protected float getFractionInRange(int i10, int i11, int i12) {
        return MathUtils.clamp((i10 - i11) / i12, 0.0f, 1.0f);
    }

    public abstract void invalidateSpecValues();

    public abstract void registerAnimatorsCompleteCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback);

    abstract void requestCancelAnimatorAfterCurrentCycle();

    @VisibleForTesting
    abstract void resetPropertiesForNewStart();

    @VisibleForTesting
    abstract void setAnimationFraction(float f10);

    abstract void startAnimator();

    public abstract void unregisterAnimatorsCompleteCallback();

    protected void registerDrawable(@NonNull IndeterminateDrawable indeterminateDrawable) {
        this.drawable = indeterminateDrawable;
    }

    protected IndeterminateAnimatorDelegate(int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            this.activeIndicators.add(new DrawingDelegate.ActiveIndicator());
        }
    }
}
