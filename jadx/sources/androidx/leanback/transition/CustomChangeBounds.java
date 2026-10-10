package androidx.leanback.transition;

import android.animation.Animator;
import android.transition.ChangeBounds;
import android.transition.TransitionValues;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
class CustomChangeBounds extends ChangeBounds {
    int mDefaultStartDelay;
    final HashMap<View, Integer> mViewStartDelays = new HashMap<>();
    final SparseIntArray mIdStartDelays = new SparseIntArray();
    final HashMap<String, Integer> mClassStartDelays = new HashMap<>();

    public void setStartDelay(View view, int i10) {
        this.mViewStartDelays.put(view, Integer.valueOf(i10));
    }

    private int getDelay(View view) {
        Integer num = this.mViewStartDelays.get(view);
        if (num != null) {
            return num.intValue();
        }
        int i10 = this.mIdStartDelays.get(view.getId(), -1);
        if (i10 != -1) {
            return i10;
        }
        Integer num2 = this.mClassStartDelays.get(view.getClass().getName());
        return num2 != null ? num2.intValue() : this.mDefaultStartDelay;
    }

    public void setDefaultStartDelay(int i10) {
        this.mDefaultStartDelay = i10;
    }

    public void setStartDelay(int i10, int i11) {
        this.mIdStartDelays.put(i10, i11);
    }

    CustomChangeBounds() {
    }

    @Override // android.transition.ChangeBounds, android.transition.Transition
    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        View view;
        Animator animatorCreateAnimator = super.createAnimator(viewGroup, transitionValues, transitionValues2);
        if (animatorCreateAnimator != null && transitionValues2 != null && (view = transitionValues2.view) != null) {
            animatorCreateAnimator.setStartDelay(getDelay(view));
        }
        return animatorCreateAnimator;
    }

    public void setStartDelay(String str, int i10) {
        this.mClassStartDelays.put(str, Integer.valueOf(i10));
    }
}
