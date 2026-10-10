package t.v.c.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import q6.b;
import q6.c;
import x1.f1.lb.util.x0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class MyRecyclerView extends RecyclerView {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final b f18727e = c.d(MyRecyclerView.class);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f18728a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f18729b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f18730c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f18731d;

    public MyRecyclerView(Context context) {
        super(context);
        this.f18728a = 0;
        this.f18729b = 0;
        this.f18730c = null;
        this.f18731d = 0;
    }

    public void a() {
        setItemAnimator(null);
        setDescendantFocusability(262144);
        setChildrenDrawingOrderEnabled(true);
        setFocusable(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (view != null) {
            super.requestChildFocus(view, view2);
            this.f18730c = view2;
            this.f18731d = getChildViewHolder(view).getAbsoluteAdapterPosition();
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (this.f18729b != 0) {
            super.setLayoutParams(layoutParams);
        } else {
            super.setLayoutParams(x0.f21457a.l(this, layoutParams));
            this.f18729b++;
        }
    }

    @Override // android.view.View
    public void setMinimumHeight(int i10) {
        super.setMinimumHeight(x0.f21457a.d(this, i10));
    }

    @Override // android.view.View
    public void setMinimumWidth(int i10) {
        super.setMinimumWidth(x0.f21457a.h(this, i10));
    }

    @Override // android.view.View
    public void setPadding(int i10, int i11, int i12, int i13) {
        if (this.f18728a != 0) {
            super.setPadding(i10, i11, i12, i13);
            return;
        }
        x0 x0Var = x0.f21457a;
        super.setPadding(x0Var.h(this, i10), x0Var.d(this, i11), x0Var.h(this, i12), x0Var.d(this, i13));
        this.f18728a++;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i10, int i11) {
        if (!hasFocus() && this.f18730c != null) {
            arrayList.add(getLayoutManager().findViewByPosition(this.f18731d));
        } else {
            super.addFocusables(arrayList, i10, i11);
        }
    }

    public MyRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MyRecyclerView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f18728a = 0;
        this.f18729b = 0;
        this.f18730c = null;
        this.f18731d = 0;
        a();
    }
}
