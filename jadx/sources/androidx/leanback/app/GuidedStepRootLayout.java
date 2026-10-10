package androidx.leanback.app;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.leanback.widget.Util;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
class GuidedStepRootLayout extends LinearLayout {
    private boolean mFocusOutEnd;
    private boolean mFocusOutStart;

    public GuidedStepRootLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mFocusOutStart = false;
        this.mFocusOutEnd = false;
    }

    public void setFocusOutEnd(boolean z10) {
        this.mFocusOutEnd = z10;
    }

    public void setFocusOutStart(boolean z10) {
        this.mFocusOutStart = z10;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0027 A[RETURN] */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0020, code lost:
    
        if (r4.mFocusOutStart != false) goto L19;
     */
    @Override // android.view.ViewGroup, android.view.ViewParent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View focusSearch(View view, int i10) {
        View viewFocusSearch = super.focusSearch(view, i10);
        if ((i10 == 17 || i10 == 66) && !Util.isDescendant(this, viewFocusSearch)) {
            if (getLayoutDirection() == 0) {
                if (!this.mFocusOutEnd) {
                    return view;
                }
            } else if (!this.mFocusOutEnd) {
                return view;
            }
        }
        return viewFocusSearch;
    }

    public GuidedStepRootLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mFocusOutStart = false;
        this.mFocusOutEnd = false;
    }
}
