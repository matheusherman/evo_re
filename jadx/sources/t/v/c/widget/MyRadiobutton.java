package t.v.c.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatRadioButton;
import x1.f1.lb.util.x0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class MyRadiobutton extends AppCompatRadioButton {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f18723a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f18724b;

    public MyRadiobutton(Context context) {
        super(context);
        this.f18723a = 0;
        this.f18724b = 0;
    }

    @Override // android.widget.TextView
    public void setMaxWidth(int i10) {
        if (i10 != -1 && i10 != Integer.MAX_VALUE) {
            i10 = x0.f21457a.g(getContext(), i10);
        }
        super.setMaxWidth(i10);
    }

    @Override // android.widget.TextView
    public void setTextSize(float f10) {
        setTextSize(0, x0.f21457a.f(this, (int) f10));
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablePadding(int i10) {
        super.setCompoundDrawablePadding(x0.f21457a.f(this, i10));
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (this.f18724b != 0) {
            super.setLayoutParams(layoutParams);
        } else {
            super.setLayoutParams(x0.f21457a.l(this, layoutParams));
            this.f18724b++;
        }
    }

    @Override // android.widget.TextView
    public void setLineSpacing(float f10, float f11) {
        super.setLineSpacing(x0.f21457a.c(getContext(), (int) f10), f11);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i10) {
        super.setMinimumHeight(x0.f21457a.d(this, i10));
    }

    @Override // android.view.View
    public void setMinimumWidth(int i10) {
        super.setMinimumWidth(x0.f21457a.h(this, i10));
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i10, int i11, int i12, int i13) {
        if (this.f18723a != 0) {
            super.setPadding(i10, i11, i12, i13);
            return;
        }
        x0 x0Var = x0.f21457a;
        super.setPadding(x0Var.h(this, i10), x0Var.d(this, i11), x0Var.h(this, i12), x0Var.d(this, i13));
        this.f18723a++;
    }

    @Override // android.widget.TextView
    public void setTextSize(int i10, float f10) {
        super.setTextSize(0, f10);
    }

    private void a(Context context, AttributeSet attributeSet) {
        setTextSize(getTextSize());
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    public MyRadiobutton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18723a = 0;
        this.f18724b = 0;
        a(context, attributeSet);
    }

    public MyRadiobutton(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f18723a = 0;
        this.f18724b = 0;
        a(context, attributeSet);
    }
}
