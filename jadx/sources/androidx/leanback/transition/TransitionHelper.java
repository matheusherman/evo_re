package androidx.leanback.transition;

import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.graphics.Rect;
import android.transition.AutoTransition;
import android.transition.ChangeTransform;
import android.transition.Fade;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AnimationUtils;
import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class TransitionHelper {
    public static final int FADE_IN = 1;
    public static final int FADE_OUT = 2;

    public static Object createFadeAndShortSlide(int i10) {
        return new FadeAndShortSlide(i10);
    }

    public static void exclude(Object obj, int i10, boolean z10) {
        ((Transition) obj).excludeTarget(i10, z10);
    }

    public static void excludeChildren(Object obj, int i10, boolean z10) {
        ((Transition) obj).excludeChildren(i10, z10);
    }

    public static void include(Object obj, int i10) {
        ((Transition) obj).addTarget(i10);
    }

    public static void setChangeBoundsStartDelay(Object obj, View view, int i10) {
        ((CustomChangeBounds) obj).setStartDelay(view, i10);
    }

    public static void setEnterTransition(Window window, Object obj) {
        window.setEnterTransition((Transition) obj);
    }

    public static void setSharedElementEnterTransition(Window window, Object obj) {
        window.setSharedElementEnterTransition((Transition) obj);
    }

    public static boolean systemSupportsEntranceTransitions() {
        return true;
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class TransitionStub {
        TransitionStub() {
        }
    }

    public static void addTarget(Object obj, View view) {
        ((Transition) obj).addTarget(view);
    }

    public static void addTransition(Object obj, Object obj2) {
        ((TransitionSet) obj).addTransition((Transition) obj2);
    }

    public static void addTransitionListener(Object obj, final TransitionListener transitionListener) {
        if (transitionListener == null) {
            return;
        }
        Transition.TransitionListener transitionListener2 = new Transition.TransitionListener() { // from class: androidx.leanback.transition.TransitionHelper.1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(Transition transition) {
                transitionListener.onTransitionCancel(transition);
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(Transition transition) {
                transitionListener.onTransitionEnd(transition);
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(Transition transition) {
                transitionListener.onTransitionPause(transition);
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(Transition transition) {
                transitionListener.onTransitionResume(transition);
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(Transition transition) {
                transitionListener.onTransitionStart(transition);
            }
        };
        transitionListener.mImpl = transitionListener2;
        ((Transition) obj).addListener(transitionListener2);
    }

    public static void beginDelayedTransition(ViewGroup viewGroup, Object obj) {
        TransitionManager.beginDelayedTransition(viewGroup, (Transition) obj);
    }

    public static Object createAutoTransition() {
        return new AutoTransition();
    }

    public static Object createChangeBounds(boolean z10) {
        CustomChangeBounds customChangeBounds = new CustomChangeBounds();
        customChangeBounds.setReparent(z10);
        return customChangeBounds;
    }

    public static Object createChangeTransform() {
        return new ChangeTransform();
    }

    public static Object createFadeAndShortSlide(int i10, float f10) {
        FadeAndShortSlide fadeAndShortSlide = new FadeAndShortSlide(i10);
        fadeAndShortSlide.setDistance(f10);
        return fadeAndShortSlide;
    }

    public static Object createFadeTransition(int i10) {
        return new Fade(i10);
    }

    public static Object createScale() {
        return new ChangeTransform();
    }

    public static Object createScene(ViewGroup viewGroup, Runnable runnable) {
        Scene scene = new Scene(viewGroup);
        scene.setEnterAction(runnable);
        return scene;
    }

    public static Object createSlide(int i10) {
        SlideKitkat slideKitkat = new SlideKitkat();
        slideKitkat.setSlideEdge(i10);
        return slideKitkat;
    }

    public static Object createTransitionSet(boolean z10) {
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.setOrdering(z10 ? 1 : 0);
        return transitionSet;
    }

    public static void exclude(Object obj, View view, boolean z10) {
        ((Transition) obj).excludeTarget(view, z10);
    }

    public static void excludeChildren(Object obj, View view, boolean z10) {
        ((Transition) obj).excludeChildren(view, z10);
    }

    public static void include(Object obj, View view) {
        ((Transition) obj).addTarget(view);
    }

    public static void removeTransitionListener(Object obj, TransitionListener transitionListener) {
        Object obj2;
        if (transitionListener == null || (obj2 = transitionListener.mImpl) == null) {
            return;
        }
        ((Transition) obj).removeListener((Transition.TransitionListener) obj2);
        transitionListener.mImpl = null;
    }

    public static void runTransition(Object obj, Object obj2) {
        TransitionManager.go((Scene) obj, (Transition) obj2);
    }

    public static void setChangeBoundsDefaultStartDelay(Object obj, int i10) {
        ((CustomChangeBounds) obj).setDefaultStartDelay(i10);
    }

    public static void setChangeBoundsStartDelay(Object obj, int i10, int i11) {
        ((CustomChangeBounds) obj).setStartDelay(i10, i11);
    }

    public static void setDuration(Object obj, long j10) {
        ((Transition) obj).setDuration(j10);
    }

    @SuppressLint({"ReferencesDeprecated"})
    public static void setEnterTransition(Fragment fragment, Object obj) {
        fragment.setEnterTransition((Transition) obj);
    }

    public static void setEpicenterCallback(Object obj, final TransitionEpicenterCallback transitionEpicenterCallback) {
        if (transitionEpicenterCallback == null) {
            ((Transition) obj).setEpicenterCallback(null);
        } else {
            ((Transition) obj).setEpicenterCallback(new Transition.EpicenterCallback() { // from class: androidx.leanback.transition.TransitionHelper.2
                @Override // android.transition.Transition.EpicenterCallback
                public Rect onGetEpicenter(Transition transition) {
                    return transitionEpicenterCallback.onGetEpicenter(transition);
                }
            });
        }
    }

    @SuppressLint({"ReferencesDeprecated"})
    public static void setExitTransition(Fragment fragment, Object obj) {
        fragment.setExitTransition((Transition) obj);
    }

    public static void setInterpolator(Object obj, Object obj2) {
        ((Transition) obj).setInterpolator((TimeInterpolator) obj2);
    }

    public static void setReturnTransition(Window window, Object obj) {
        window.setReturnTransition((Transition) obj);
    }

    @SuppressLint({"ReferencesDeprecated"})
    public static void setSharedElementEnterTransition(Fragment fragment, Object obj) {
        fragment.setSharedElementEnterTransition((Transition) obj);
    }

    public static void setSharedElementReturnTransition(Window window, Object obj) {
        window.setSharedElementReturnTransition((Transition) obj);
    }

    public static void setStartDelay(Object obj, long j10) {
        ((Transition) obj).setStartDelay(j10);
    }

    private TransitionHelper() {
    }

    @SuppressLint({"ReferencesDeprecated"})
    public static void addSharedElement(FragmentTransaction fragmentTransaction, View view, String str) {
        fragmentTransaction.addSharedElement(view, str);
    }

    public static Object createDefaultInterpolator(Context context) {
        return AnimationUtils.loadInterpolator(context, 17563663);
    }

    public static Object getEnterTransition(Window window) {
        return window.getEnterTransition();
    }

    public static Object getExitTransition(Window window) {
        return window.getExitTransition();
    }

    public static Object getReenterTransition(Window window) {
        return window.getReenterTransition();
    }

    public static Object getReturnTransition(Window window) {
        return window.getReturnTransition();
    }

    public static Object getSharedElementEnterTransition(Window window) {
        return window.getSharedElementEnterTransition();
    }

    public static Object getSharedElementExitTransition(Window window) {
        return window.getSharedElementExitTransition();
    }

    public static Object getSharedElementReenterTransition(Window window) {
        return window.getSharedElementReenterTransition();
    }

    public static Object getSharedElementReturnTransition(Window window) {
        return window.getSharedElementReturnTransition();
    }

    public static Object loadTransition(Context context, int i10) {
        return TransitionInflater.from(context).inflateTransition(i10);
    }

    public static void setChangeBoundsStartDelay(Object obj, String str, int i10) {
        ((CustomChangeBounds) obj).setStartDelay(str, i10);
    }

    public static void setTransitionGroup(ViewGroup viewGroup, boolean z10) {
        viewGroup.setTransitionGroup(z10);
    }
}
