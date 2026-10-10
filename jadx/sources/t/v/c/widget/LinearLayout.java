package t.v.c.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import q6.b;
import q6.c;
import x1.f1.lb.util.x0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class LinearLayout extends android.widget.LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f18682a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f18683b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f18684c;

    public LinearLayout(Context context) {
        super(context);
        this.f18682a = c.d(FrameLayout.class);
        this.f18683b = 0;
        this.f18684c = 0;
    }

    public void setAutoLayoutParams(ViewGroup.LayoutParams layoutParams) {
        this.f18684c = 1;
        super.setLayoutParams(x0.f21457a.l(this, layoutParams));
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (this.f18684c != 0) {
            super.setLayoutParams(layoutParams);
        } else {
            super.setLayoutParams(x0.f21457a.l(this, layoutParams));
            this.f18684c++;
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
        if (this.f18683b != 0) {
            super.setPadding(i10, i11, i12, i13);
            return;
        }
        x0 x0Var = x0.f21457a;
        super.setPadding(x0Var.h(this, i10), x0Var.d(this, i11), x0Var.h(this, i12), x0Var.d(this, i13));
        this.f18683b++;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i10, int i11) {
        try {
            super.onMeasure(i10, i11);
        } catch (Exception e10) {
            this.f18682a.error("onMeasure failure", e10);
        }
    }

    public LinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18682a = c.d(FrameLayout.class);
        this.f18683b = 0;
        this.f18684c = 0;
    }

    public LinearLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f18682a = c.d(FrameLayout.class);
        this.f18683b = 0;
        this.f18684c = 0;
    }
}
