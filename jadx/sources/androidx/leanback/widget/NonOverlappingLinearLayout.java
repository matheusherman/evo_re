package androidx.leanback.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class NonOverlappingLinearLayout extends LinearLayout {
    boolean mDeferFocusableViewAvailableInLayout;
    boolean mFocusableViewAvailableFixEnabled;
    final ArrayList<ArrayList<View>> mSortedAvailableViews;

    public NonOverlappingLinearLayout(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0019  */
    /* JADX WARN: Code duplicated, block: B:16:0x001e A[Catch: all -> 0x0014, LOOP:0: B:16:0x001e->B:18:0x002a, LOOP_START, TRY_ENTER, TryCatch #0 {all -> 0x0014, blocks: (B:6:0x0006, B:8:0x000c, B:16:0x001e, B:18:0x002a, B:19:0x0035, B:21:0x0041), top: B:53:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:18:0x002a A[Catch: all -> 0x0014, LOOP:0: B:16:0x001e->B:18:0x002a, LOOP_END, TryCatch #0 {all -> 0x0014, blocks: (B:6:0x0006, B:8:0x000c, B:16:0x001e, B:18:0x002a, B:19:0x0035, B:21:0x0041), top: B:53:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:21:0x0041 A[Catch: all -> 0x0014, LOOP:1: B:19:0x0035->B:21:0x0041, LOOP_END, TRY_LEAVE, TryCatch #0 {all -> 0x0014, blocks: (B:6:0x0006, B:8:0x000c, B:16:0x001e, B:18:0x002a, B:19:0x0035, B:21:0x0041), top: B:53:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:26:0x0059  */
    /* JADX WARN: Code duplicated, block: B:29:0x0062  */
    /* JADX WARN: Code duplicated, block: B:32:0x0071 A[Catch: all -> 0x0085, TRY_LEAVE, TryCatch #1 {all -> 0x0085, blocks: (B:24:0x0052, B:27:0x005a, B:30:0x0063, B:32:0x0071), top: B:55:0x0052 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x008f  */
    /* JADX WARN: Code duplicated, block: B:42:0x0099 A[LOOP:5: B:40:0x0091->B:42:0x0099, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:43:0x00a7 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:48:0x00af  */
    /* JADX WARN: Code duplicated, block: B:51:0x00b9 A[LOOP:2: B:49:0x00b1->B:51:0x00b9, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:52:0x00c7  */
    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) throws Throwable {
        NonOverlappingLinearLayout nonOverlappingLinearLayout;
        Throwable th;
        boolean z11;
        int i14;
        int i15;
        int i16 = 0;
        try {
            if (!this.mFocusableViewAvailableFixEnabled) {
                z11 = false;
                this.mDeferFocusableViewAvailableInLayout = z11;
                if (z11) {
                    while (this.mSortedAvailableViews.size() > getChildCount()) {
                        ArrayList<ArrayList<View>> arrayList = this.mSortedAvailableViews;
                        arrayList.remove(arrayList.size() - 1);
                    }
                    while (this.mSortedAvailableViews.size() < getChildCount()) {
                        this.mSortedAvailableViews.add(new ArrayList<>());
                    }
                }
                nonOverlappingLinearLayout = this;
                super.onLayout(z10, i10, i11, i12, i13);
                if (nonOverlappingLinearLayout.mDeferFocusableViewAvailableInLayout) {
                    for (i14 = 0; i14 < nonOverlappingLinearLayout.mSortedAvailableViews.size(); i14++) {
                        for (i15 = 0; i15 < nonOverlappingLinearLayout.mSortedAvailableViews.get(i14).size(); i15++) {
                            super.focusableViewAvailable(nonOverlappingLinearLayout.mSortedAvailableViews.get(i14).get(i15));
                        }
                    }
                }
                if (nonOverlappingLinearLayout.mDeferFocusableViewAvailableInLayout) {
                    nonOverlappingLinearLayout.mDeferFocusableViewAvailableInLayout = false;
                    while (i16 < nonOverlappingLinearLayout.mSortedAvailableViews.size()) {
                        nonOverlappingLinearLayout.mSortedAvailableViews.get(i16).clear();
                        i16++;
                    }
                    return;
                }
                return;
            }
            try {
                if (getOrientation() == 0 && getLayoutDirection() == 1) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                this.mDeferFocusableViewAvailableInLayout = z11;
                if (z11) {
                    while (this.mSortedAvailableViews.size() > getChildCount()) {
                        ArrayList<ArrayList<View>> arrayList2 = this.mSortedAvailableViews;
                        arrayList2.remove(arrayList2.size() - 1);
                    }
                    while (this.mSortedAvailableViews.size() < getChildCount()) {
                        this.mSortedAvailableViews.add(new ArrayList<>());
                    }
                }
                nonOverlappingLinearLayout = this;
                try {
                    super.onLayout(z10, i10, i11, i12, i13);
                    if (nonOverlappingLinearLayout.mDeferFocusableViewAvailableInLayout) {
                        while (i14 < nonOverlappingLinearLayout.mSortedAvailableViews.size()) {
                            while (i15 < nonOverlappingLinearLayout.mSortedAvailableViews.get(i14).size()) {
                                super.focusableViewAvailable(nonOverlappingLinearLayout.mSortedAvailableViews.get(i14).get(i15));
                            }
                        }
                    }
                    if (nonOverlappingLinearLayout.mDeferFocusableViewAvailableInLayout) {
                        nonOverlappingLinearLayout.mDeferFocusableViewAvailableInLayout = false;
                        while (i16 < nonOverlappingLinearLayout.mSortedAvailableViews.size()) {
                            nonOverlappingLinearLayout.mSortedAvailableViews.get(i16).clear();
                            i16++;
                        }
                        return;
                    }
                    return;
                } catch (Throwable th2) {
                    th = th2;
                    th = th;
                    if (nonOverlappingLinearLayout.mDeferFocusableViewAvailableInLayout) {
                        throw th;
                    }
                    nonOverlappingLinearLayout.mDeferFocusableViewAvailableInLayout = false;
                    while (i16 < nonOverlappingLinearLayout.mSortedAvailableViews.size()) {
                        nonOverlappingLinearLayout.mSortedAvailableViews.get(i16).clear();
                        i16++;
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                nonOverlappingLinearLayout = this;
            }
        } catch (Throwable th4) {
            th = th4;
            nonOverlappingLinearLayout = this;
        }
        if (nonOverlappingLinearLayout.mDeferFocusableViewAvailableInLayout) {
            throw th;
        }
        nonOverlappingLinearLayout.mDeferFocusableViewAvailableInLayout = false;
        while (i16 < nonOverlappingLinearLayout.mSortedAvailableViews.size()) {
            nonOverlappingLinearLayout.mSortedAvailableViews.get(i16).clear();
            i16++;
        }
        throw th;
    }

    public NonOverlappingLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void focusableViewAvailable(View view) {
        int iIndexOfChild;
        if (!this.mDeferFocusableViewAvailableInLayout) {
            super.focusableViewAvailable(view);
            return;
        }
        View view2 = view;
        while (true) {
            if (view2 == this || view2 == null) {
                iIndexOfChild = -1;
                break;
            } else {
                if (view2.getParent() == this) {
                    iIndexOfChild = indexOfChild(view2);
                    break;
                }
                view2 = (View) view2.getParent();
            }
        }
        if (iIndexOfChild != -1) {
            this.mSortedAvailableViews.get(iIndexOfChild).add(view);
        }
    }

    public void setFocusableViewAvailableFixEnabled(boolean z10) {
        this.mFocusableViewAvailableFixEnabled = z10;
    }

    public NonOverlappingLinearLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mFocusableViewAvailableFixEnabled = false;
        this.mSortedAvailableViews = new ArrayList<>();
    }
}
