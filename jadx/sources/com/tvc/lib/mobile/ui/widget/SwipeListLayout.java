package com.tvc.lib.mobile.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u000263B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0013\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0015\u0010\u0010J\u000f\u0010\u0016\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u001c\u0010\u0010J\u000f\u0010\u001d\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u0017\u0010$\u001a\u00020\f2\u0006\u0010#\u001a\u00020\u001fH\u0016¢\u0006\u0004\b$\u0010\"J\u000f\u0010%\u001a\u00020\u000eH\u0014¢\u0006\u0004\b%\u0010\u001eJ/\u0010)\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020\tH\u0014¢\u0006\u0004\b)\u0010*J7\u00100\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020\f2\u0006\u0010,\u001a\u00020\t2\u0006\u0010-\u001a\u00020\t2\u0006\u0010.\u001a\u00020\t2\u0006\u0010/\u001a\u00020\tH\u0014¢\u0006\u0004\b0\u00101R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u00107\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00104R\u0016\u0010:\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010@\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u00109R\u0016\u0010B\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u00109R\u0016\u0010C\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u00109R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010DR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010ER\"\u0010M\u001a\u00020F8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u0018\u0010O\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010D¨\u0006P"}, d2 = {"Lcom/tvc/lib/mobile/ui/widget/SwipeListLayout;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attr", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "smooth", "Lr8/z;", "g", "(Z)V", "Lcom/tvc/lib/mobile/ui/widget/SwipeListLayout$b;", NotificationCompat.CATEGORY_STATUS, "h", "(Lcom/tvc/lib/mobile/ui/widget/SwipeListLayout$b;)V", "i", "getSwipWidth", "()I", "Lcom/tvc/lib/mobile/ui/widget/SwipeListLayout$a;", "listener", "setOnSwipeStatusListener", "(Lcom/tvc/lib/mobile/ui/widget/SwipeListLayout$a;)V", "setSmooth", "computeScroll", "()V", "Landroid/view/MotionEvent;", "ev", "onInterceptTouchEvent", "(Landroid/view/MotionEvent;)Z", NotificationCompat.CATEGORY_EVENT, "onTouchEvent", "onFinishInflate", "w", "oldw", "oldh", "onSizeChanged", "(IIII)V", "changed", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "Landroid/view/View;", "a", "Landroid/view/View;", "hiddenView", "b", "itemView", "c", "I", "hiddenViewWidth", "Landroidx/customview/widget/ViewDragHelper;", "d", "Landroidx/customview/widget/ViewDragHelper;", "mDragHelper", "e", "hiddenViewHeight", "f", "itemWidth", "itemHeight", "Lcom/tvc/lib/mobile/ui/widget/SwipeListLayout$b;", "Z", "Landroidx/customview/widget/ViewDragHelper$Callback;", "j", "Landroidx/customview/widget/ViewDragHelper$Callback;", "getCallback", "()Landroidx/customview/widget/ViewDragHelper$Callback;", "setCallback", "(Landroidx/customview/widget/ViewDragHelper$Callback;)V", "callback", "k", "preStatus", "tvclib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SwipeListLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private View hiddenView;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private View itemView;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int hiddenViewWidth;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ViewDragHelper mDragHelper;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int hiddenViewHeight;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int itemWidth;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int itemHeight;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private b status;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean smooth;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private ViewDragHelper.Callback callback;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    private b preStatus;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/tvc/lib/mobile/ui/widget/SwipeListLayout$a;", "", "tvclib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface a {
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/tvc/lib/mobile/ui/widget/SwipeListLayout$b;", "", "<init>", "(Ljava/lang/String;I)V", "a", "b", "tvclib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public enum b {
        Open,
        Close;


        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ w8.a f9295d = w8.b.a(a());
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ7\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"com/tvc/lib/mobile/ui/widget/SwipeListLayout$c", "Landroidx/customview/widget/ViewDragHelper$Callback;", "Landroid/view/View;", "child", "", "left", "dx", "clampViewPositionHorizontal", "(Landroid/view/View;II)I", "getViewHorizontalDragRange", "(Landroid/view/View;)I", "changedView", "top", "dy", "Lr8/z;", "onViewPositionChanged", "(Landroid/view/View;IIII)V", "releasedChild", "", "xvel", "yvel", "onViewReleased", "(Landroid/view/View;FF)V", "pointerId", "", "tryCaptureView", "(Landroid/view/View;I)Z", "tvclib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class c extends ViewDragHelper.Callback {
        c() {
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(View child, int left, int dx) {
            kotlin.jvm.internal.m.f(child, "child");
            if (child != SwipeListLayout.this.itemView || left > 0) {
                return 0;
            }
            return Math.max(left, -SwipeListLayout.this.getSwipWidth());
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewHorizontalDragRange(View child) {
            kotlin.jvm.internal.m.f(child, "child");
            return SwipeListLayout.this.getSwipWidth();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(View changedView, int left, int top, int dx, int dy) {
            View view;
            kotlin.jvm.internal.m.f(changedView, "changedView");
            if (SwipeListLayout.this.itemView == changedView && (view = SwipeListLayout.this.hiddenView) != null) {
                view.offsetLeftAndRight(dx);
            }
            SwipeListLayout.this.invalidate();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(View releasedChild, float xvel, float yvel) {
            kotlin.jvm.internal.m.f(releasedChild, "releasedChild");
            if (releasedChild == SwipeListLayout.this.itemView) {
                if (xvel == 0.0f) {
                    View view = SwipeListLayout.this.itemView;
                    if (Math.abs(view != null ? view.getLeft() : 0) > SwipeListLayout.this.getSwipWidth() / 2.0f) {
                        SwipeListLayout swipeListLayout = SwipeListLayout.this;
                        swipeListLayout.i(swipeListLayout.smooth);
                        return;
                    }
                }
                if (xvel < 0.0f) {
                    SwipeListLayout swipeListLayout2 = SwipeListLayout.this;
                    swipeListLayout2.i(swipeListLayout2.smooth);
                } else {
                    SwipeListLayout swipeListLayout3 = SwipeListLayout.this;
                    swipeListLayout3.g(swipeListLayout3.smooth);
                }
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(View child, int pointerId) {
            kotlin.jvm.internal.m.f(child, "child");
            return child == SwipeListLayout.this.itemView;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SwipeListLayout(Context context) {
        this(context, null);
        kotlin.jvm.internal.m.f(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SwipeListLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        kotlin.jvm.internal.m.f(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(boolean smooth) {
        this.preStatus = this.status;
        b bVar = b.Close;
        this.status = bVar;
        if (!smooth) {
            h(bVar);
            return;
        }
        ViewDragHelper viewDragHelper = this.mDragHelper;
        kotlin.jvm.internal.m.c(viewDragHelper);
        View view = this.itemView;
        kotlin.jvm.internal.m.c(view);
        if (viewDragHelper.smoothSlideViewTo(view, 0, 0)) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getSwipWidth() {
        View view = this.hiddenView;
        int measuredWidth = 0;
        if (view != null && view.getVisibility() == 0) {
            int i10 = this.hiddenViewWidth;
            if (i10 > 0) {
                return i10;
            }
            View view2 = this.hiddenView;
            measuredWidth = view2 != null ? view2.getMeasuredWidth() : 0;
            this.hiddenViewWidth = measuredWidth;
        }
        return measuredWidth;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(boolean smooth) {
        this.preStatus = this.status;
        b bVar = b.Open;
        this.status = bVar;
        if (!smooth) {
            h(bVar);
            return;
        }
        ViewDragHelper viewDragHelper = this.mDragHelper;
        kotlin.jvm.internal.m.c(viewDragHelper);
        View view = this.itemView;
        kotlin.jvm.internal.m.c(view);
        if (viewDragHelper.smoothSlideViewTo(view, -getSwipWidth(), 0)) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public final ViewDragHelper.Callback getCallback() {
        return this.callback;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        kotlin.jvm.internal.m.f(ev, "ev");
        if (ev.getAction() != 3) {
            ViewDragHelper viewDragHelper = this.mDragHelper;
            kotlin.jvm.internal.m.c(viewDragHelper);
            return viewDragHelper.shouldInterceptTouchEvent(ev);
        }
        ViewDragHelper viewDragHelper2 = this.mDragHelper;
        kotlin.jvm.internal.m.c(viewDragHelper2);
        viewDragHelper2.cancel();
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        h(b.Close);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        kotlin.jvm.internal.m.f(event, "event");
        ViewDragHelper viewDragHelper = this.mDragHelper;
        kotlin.jvm.internal.m.c(viewDragHelper);
        viewDragHelper.processTouchEvent(event);
        return true;
    }

    public final void setCallback(ViewDragHelper.Callback callback) {
        kotlin.jvm.internal.m.f(callback, "<set-?>");
        this.callback = callback;
    }

    public final void setSmooth(boolean smooth) {
        this.smooth = smooth;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwipeListLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.m.f(context, "context");
        b bVar = b.Close;
        this.status = bVar;
        this.smooth = true;
        c cVar = new c();
        this.callback = cVar;
        this.preStatus = bVar;
        this.mDragHelper = ViewDragHelper.create(this, cVar);
    }

    private final void h(b status) {
        int swipWidth = getSwipWidth();
        if (status == b.Close) {
            View view = this.hiddenView;
            kotlin.jvm.internal.m.c(view);
            int i10 = this.itemWidth;
            view.layout(i10, 0, swipWidth + i10, this.itemHeight);
            View view2 = this.itemView;
            kotlin.jvm.internal.m.c(view2);
            view2.layout(0, 0, this.itemWidth, this.itemHeight);
            return;
        }
        View view3 = this.hiddenView;
        kotlin.jvm.internal.m.c(view3);
        int i11 = this.itemWidth;
        view3.layout(i11 - swipWidth, 0, i11, this.itemHeight);
        View view4 = this.itemView;
        kotlin.jvm.internal.m.c(view4);
        view4.layout(-swipWidth, 0, this.itemWidth - swipWidth, this.itemHeight);
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        ViewDragHelper viewDragHelper = this.mDragHelper;
        kotlin.jvm.internal.m.c(viewDragHelper);
        if (viewDragHelper.continueSettling(true)) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.hiddenView = getChildAt(0);
        this.itemView = getChildAt(1);
    }

    @Override // android.view.View
    protected void onSizeChanged(int w10, int h10, int oldw, int oldh) {
        int measuredWidth;
        int measuredHeight;
        int measuredWidth2;
        super.onSizeChanged(w10, h10, oldw, oldh);
        View view = this.itemView;
        int measuredHeight2 = 0;
        if (view != null) {
            measuredWidth = view.getMeasuredWidth();
        } else {
            measuredWidth = 0;
        }
        this.itemWidth = measuredWidth;
        View view2 = this.itemView;
        if (view2 != null) {
            measuredHeight = view2.getMeasuredHeight();
        } else {
            measuredHeight = 0;
        }
        this.itemHeight = measuredHeight;
        View view3 = this.hiddenView;
        if (view3 != null) {
            measuredWidth2 = view3.getMeasuredWidth();
        } else {
            measuredWidth2 = 0;
        }
        this.hiddenViewWidth = measuredWidth2;
        View view4 = this.hiddenView;
        if (view4 != null) {
            measuredHeight2 = view4.getMeasuredHeight();
        }
        this.hiddenViewHeight = measuredHeight2;
    }

    public final void setOnSwipeStatusListener(a listener) {
    }
}
