package androidx.leanback.tab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
public class LeanbackViewPager extends ViewPager {
    private boolean mEnableKeyEvent;
    private boolean mTouchEnabled;

    public LeanbackViewPager(@NonNull Context context) {
        super(context);
        this.mTouchEnabled = false;
        this.mEnableKeyEvent = false;
    }

    @Override // androidx.viewpager.widget.ViewPager
    public boolean executeKeyEvent(@NonNull KeyEvent keyEvent) {
        return this.mEnableKeyEvent && super.executeKeyEvent(keyEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(@NonNull MotionEvent motionEvent) {
        return this.mTouchEnabled && super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        return this.mTouchEnabled && super.onTouchEvent(motionEvent);
    }

    public void setKeyEventsEnabled(boolean z10) {
        this.mEnableKeyEvent = z10;
    }

    public void setTouchEnabled(boolean z10) {
        this.mTouchEnabled = z10;
    }

    public LeanbackViewPager(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTouchEnabled = false;
        this.mEnableKeyEvent = false;
    }
}
