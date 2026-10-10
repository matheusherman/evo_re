package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import com.google.android.material.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class SlideDistanceProvider implements VisibilityAnimatorProvider {
    private static final int DEFAULT_DISTANCE = -1;

    @Px
    private int slideDistance = -1;
    private int slideEdge;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface GravityFlag {
    }

    private static Animator createTranslationXAnimator(final View view, float f10, float f11, final float f12) {
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_X, f10, f11));
        objectAnimatorOfPropertyValuesHolder.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.transition.SlideDistanceProvider.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                view.setTranslationX(f12);
            }
        });
        return objectAnimatorOfPropertyValuesHolder;
    }

    private static Animator createTranslationYAnimator(final View view, float f10, float f11, final float f12) {
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_Y, f10, f11));
        objectAnimatorOfPropertyValuesHolder.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.transition.SlideDistanceProvider.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                view.setTranslationY(f12);
            }
        });
        return objectAnimatorOfPropertyValuesHolder;
    }

    private int getSlideDistanceOrDefault(Context context) {
        int i10 = this.slideDistance;
        return i10 != -1 ? i10 : context.getResources().getDimensionPixelSize(R.dimen.mtrl_transition_shared_axis_slide_distance);
    }

    @Override // com.google.android.material.transition.VisibilityAnimatorProvider
    @Nullable
    public Animator createAppear(@NonNull ViewGroup viewGroup, @NonNull View view) {
        return createTranslationAppearAnimator(viewGroup, view, this.slideEdge, getSlideDistanceOrDefault(view.getContext()));
    }

    @Override // com.google.android.material.transition.VisibilityAnimatorProvider
    @Nullable
    public Animator createDisappear(@NonNull ViewGroup viewGroup, @NonNull View view) {
        return createTranslationDisappearAnimator(viewGroup, view, this.slideEdge, getSlideDistanceOrDefault(view.getContext()));
    }

    @Px
    public int getSlideDistance() {
        return this.slideDistance;
    }

    public int getSlideEdge() {
        return this.slideEdge;
    }

    public void setSlideDistance(@Px int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("Slide distance must be positive. If attempting to reverse the direction of the slide, use setSlideEdge(int) instead.");
        }
        this.slideDistance = i10;
    }

    public void setSlideEdge(int i10) {
        this.slideEdge = i10;
    }

    public SlideDistanceProvider(int i10) {
        this.slideEdge = i10;
    }

    private static Animator createTranslationAppearAnimator(View view, View view2, int i10, @Px int i11) {
        float f10;
        float f11;
        float translationX = view2.getTranslationX();
        float translationY = view2.getTranslationY();
        if (i10 != 3) {
            if (i10 != 5) {
                if (i10 != 48) {
                    if (i10 != 80) {
                        if (i10 != 8388611) {
                            if (i10 == 8388613) {
                                if (isRtl(view)) {
                                    f11 = translationX - i11;
                                } else {
                                    f11 = i11 + translationX;
                                }
                                return createTranslationXAnimator(view2, f11, translationX, translationX);
                            }
                            throw new IllegalArgumentException("Invalid slide direction: " + i10);
                        }
                        if (isRtl(view)) {
                            f10 = i11 + translationX;
                        } else {
                            f10 = translationX - i11;
                        }
                        return createTranslationXAnimator(view2, f10, translationX, translationX);
                    }
                    return createTranslationYAnimator(view2, i11 + translationY, translationY, translationY);
                }
                return createTranslationYAnimator(view2, translationY - i11, translationY, translationY);
            }
            return createTranslationXAnimator(view2, translationX - i11, translationX, translationX);
        }
        return createTranslationXAnimator(view2, i11 + translationX, translationX, translationX);
    }

    private static Animator createTranslationDisappearAnimator(View view, View view2, int i10, @Px int i11) {
        float f10;
        float f11;
        float translationX = view2.getTranslationX();
        float translationY = view2.getTranslationY();
        if (i10 != 3) {
            if (i10 != 5) {
                if (i10 != 48) {
                    if (i10 != 80) {
                        if (i10 != 8388611) {
                            if (i10 == 8388613) {
                                if (isRtl(view)) {
                                    f11 = i11 + translationX;
                                } else {
                                    f11 = translationX - i11;
                                }
                                return createTranslationXAnimator(view2, translationX, f11, translationX);
                            }
                            throw new IllegalArgumentException("Invalid slide direction: " + i10);
                        }
                        if (isRtl(view)) {
                            f10 = translationX - i11;
                        } else {
                            f10 = i11 + translationX;
                        }
                        return createTranslationXAnimator(view2, translationX, f10, translationX);
                    }
                    return createTranslationYAnimator(view2, translationY, translationY - i11, translationY);
                }
                return createTranslationYAnimator(view2, translationY, i11 + translationY, translationY);
            }
            return createTranslationXAnimator(view2, translationX, i11 + translationX, translationX);
        }
        return createTranslationXAnimator(view2, translationX, translationX - i11, translationX);
    }

    private static boolean isRtl(View view) {
        if (view.getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }
}
