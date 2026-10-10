package t.v.c.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u0011\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0017\u001a\u00020\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\f2\b\b\u0002\u0010\u0019\u001a\u00020\t¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\f2\b\b\u0002\u0010\u0019\u001a\u00020\t¢\u0006\u0004\b\u001c\u0010\u001bJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\tH\u0016¢\u0006\u0004\b \u0010\u0014J\r\u0010!\u001a\u00020\t¢\u0006\u0004\b!\u0010\u0014J\r\u0010\"\u001a\u00020\t¢\u0006\u0004\b\"\u0010\u0014J\u0015\u0010$\u001a\u00020\f2\u0006\u0010#\u001a\u00020\t¢\u0006\u0004\b$\u0010\u001bJ\u000f\u0010%\u001a\u00020\fH\u0014¢\u0006\u0004\b%\u0010\u000eJ!\u0010)\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\t2\b\u0010(\u001a\u0004\u0018\u00010'H\u0016¢\u0006\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u001c\u00102\u001a\b\u0012\u0004\u0012\u00020/0.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105¨\u00067"}, d2 = {"Lt/v/c/widget/TVRecyclerView;", "Lt/v/c/widget/MyRecyclerView;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attr", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lr8/z;", "b", "()V", "leftRight", "topBottom", "c", "(II)V", "getFocusedItemPosition", "()I", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "layout", "setLayoutManager", "(Landroidx/recyclerview/widget/RecyclerView$LayoutManager;)V", "position", "setRequestFocusByPosition", "(I)V", "setClearFocusByPosition", "", "isInTouchMode", "()Z", "getBaseline", "getFirstVisiblePosition", "getLastVisiblePosition", "pos", "setSelectedPosition", "onDetachedFromWindow", "keyCode", "Landroid/view/KeyEvent;", NotificationCompat.CATEGORY_EVENT, "onKeyDown", "(ILandroid/view/KeyEvent;)Z", "f", "I", "focusedItemPosition", "", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "g", "Ljava/util/List;", "decors", "", "h", "J", "mLastKeyDownTime", "tvcbaselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class TVRecyclerView extends MyRecyclerView {

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int focusedItemPosition;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private List<RecyclerView.ItemDecoration> decors;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long mLastKeyDownTime;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TVRecyclerView(Context context) {
        this(context, null);
        m.f(context, "context");
    }

    private final void b() {
        setWillNotDraw(true);
        setOverScrollMode(2);
        setChildrenDrawingOrderEnabled(true);
        setClipChildren(false);
        setClipToPadding(false);
        setClickable(false);
        setFocusable(true);
        setFocusableInTouchMode(true);
        setItemAnimator(null);
        if (getLayoutManager() instanceof LinearLayoutManager) {
            d(this, 0, 0, 3, null);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public int getBaseline() {
        return -1;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TVRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        m.f(context, "context");
    }

    private final void c(int leftRight, int topBottom) {
        a aVar = new a(leftRight, topBottom);
        this.decors.add(aVar);
        addItemDecoration(aVar);
    }

    static /* synthetic */ void d(TVRecyclerView tVRecyclerView, int i10, int i11, int i12, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: registerItemDecoration");
        }
        if ((i12 & 1) != 0) {
            i10 = 20;
        }
        if ((i12 & 2) != 0) {
            i11 = 20;
        }
        tVRecyclerView.c(i10, i11);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TVRecyclerView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        m.f(context, "context");
        this.focusedItemPosition = -1;
        this.decors = new ArrayList();
        b();
    }

    private final int getFocusedItemPosition() {
        View focusedChild = getFocusedChild();
        if (focusedChild != null) {
            return getChildAdapterPosition(focusedChild);
        }
        return -1;
    }

    public final int getFirstVisiblePosition() {
        if (getChildCount() == 0) {
            return 0;
        }
        return getChildAdapterPosition(getChildAt(0));
    }

    public final int getLastVisiblePosition() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return 0;
        }
        return getChildAdapterPosition(getChildAt(childCount - 1));
    }

    @Override // android.view.View
    public boolean isInTouchMode() {
        return super.isInTouchMode();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (getLayoutManager() != null) {
            super.onDetachedFromWindow();
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.mLastKeyDownTime < 150) {
            return true;
        }
        boolean zOnKeyDown = super.onKeyDown(keyCode, event);
        this.mLastKeyDownTime = jCurrentTimeMillis;
        return zOnKeyDown;
    }

    public final void setClearFocusByPosition(int position) {
        View view;
        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = findViewHolderForAdapterPosition(position);
        if (viewHolderFindViewHolderForAdapterPosition != null) {
            view = viewHolderFindViewHolderForAdapterPosition.itemView;
        } else {
            view = null;
        }
        if (view != null) {
            view.clearFocus();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setLayoutManager(RecyclerView.LayoutManager layout) {
        super.setLayoutManager(layout);
        setHasFixedSize(true);
    }

    public final void setRequestFocusByPosition(int position) {
        View view;
        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = findViewHolderForAdapterPosition(position);
        if (viewHolderFindViewHolderForAdapterPosition != null) {
            view = viewHolderFindViewHolderForAdapterPosition.itemView;
        } else {
            view = null;
        }
        if (view != null) {
            view.requestFocus();
        }
    }

    public final void setSelectedPosition(int pos) {
        smoothScrollToPosition(pos);
    }
}
