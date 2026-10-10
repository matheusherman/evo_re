package t.v.c.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import q6.b;
import q6.c;
import x1.f1.lb.util.x0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class MyListView extends ListView {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final b f18713f = c.d(MyListView.class);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f18714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f18715b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f18716c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f18717d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f18718e;

    public MyListView(Context context) {
        super(context);
        this.f18714a = 0;
        this.f18715b = 0;
        this.f18716c = 0;
        this.f18717d = true;
        this.f18718e = 0;
    }

    @Override // android.widget.ListView, android.widget.AdapterView
    public void setSelection(int i10) {
        int i11;
        View childAt = null;
        try {
            int height = getHeight();
            childAt = getChildAt(i10);
            int lastVisiblePosition = (getLastVisiblePosition() - getFirstVisiblePosition()) + 1;
            if (lastVisiblePosition <= 0) {
                lastVisiblePosition = getCount();
            }
            int height2 = this.f18718e;
            if (height2 == 0) {
                if (childAt != null) {
                    height2 = childAt.getHeight();
                    this.f18718e = height2;
                } else {
                    height2 = lastVisiblePosition > 0 ? height / lastVisiblePosition : 0;
                }
            }
            if (this.f18717d) {
                i11 = height >> 1;
                if (height2 > 0) {
                    i11 = (int) (((double) i11) - (((double) height2) * 0.67d));
                }
            } else {
                i11 = this.f18716c != 20 ? 0 : height - height2;
            }
            try {
                if (x1.f1.lb.config.b.f20643a.t()) {
                    f18713f.debug("my_list_view[{}][{}][{}][{}][{}]", Integer.valueOf(height), Integer.valueOf(lastVisiblePosition), Integer.valueOf(childAt == null ? 0 : childAt.getHeight()), Integer.valueOf(lastVisiblePosition > 0 ? height / lastVisiblePosition : 0), Integer.valueOf(i11));
                }
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            i11 = 0;
        }
        if (x1.f1.lb.config.b.f20643a.t()) {
            f18713f.debug("setSelection position[{}] y[{}] view is null[{}]", Integer.valueOf(i10), Integer.valueOf(i11), Boolean.valueOf(childAt == null));
        }
        setSelectionFromTop(i10, i11);
    }

    @Override // android.widget.ListView
    public void setDividerHeight(int i10) {
        super.setDividerHeight(x0.f21457a.d(this, i10));
    }

    public void setIsKeepCenterPosition(boolean z10) {
        this.f18717d = z10;
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (this.f18715b != 0) {
            super.setLayoutParams(layoutParams);
        } else {
            super.setLayoutParams(x0.f21457a.l(this, layoutParams));
            this.f18715b++;
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
        if (this.f18714a != 0) {
            super.setPadding(i10, i11, i12, i13);
            return;
        }
        x0 x0Var = x0.f21457a;
        super.setPadding(x0Var.h(this, i10), x0Var.d(this, i11), x0Var.h(this, i12), x0Var.d(this, i13));
        this.f18714a++;
    }

    public void setSelectionDirection(int i10) {
        this.f18716c = i10;
    }

    public MyListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18714a = 0;
        this.f18715b = 0;
        this.f18716c = 0;
        this.f18717d = true;
        this.f18718e = 0;
    }

    public MyListView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f18714a = 0;
        this.f18715b = 0;
        this.f18716c = 0;
        this.f18717d = true;
        this.f18718e = 0;
    }
}
