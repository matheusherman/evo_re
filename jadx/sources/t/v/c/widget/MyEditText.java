package t.v.c.widget;

import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatEditText;
import x1.f1.lb.util.x0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class MyEditText extends AppCompatEditText {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f18711a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f18712b;

    public MyEditText(Context context) {
        super(context);
        this.f18711a = 0;
        this.f18712b = 0;
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
        if (this.f18712b != 0) {
            super.setLayoutParams(layoutParams);
        } else {
            super.setLayoutParams(x0.f21457a.l(this, layoutParams));
            this.f18712b++;
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
        if (this.f18711a != 0) {
            super.setPadding(i10, i11, i12, i13);
            return;
        }
        x0 x0Var = x0.f21457a;
        super.setPadding(x0Var.h(this, i10), x0Var.d(this, i11), x0Var.h(this, i12), x0Var.d(this, i13));
        this.f18711a++;
    }

    @Override // android.widget.TextView
    public void setTextSize(int i10, float f10) {
        super.setTextSize(0, f10);
    }

    public void setTextViewGradientStyle(Pair<Integer, Float>[] pairArr) {
        if (pairArr == null || pairArr.length == 0) {
            return;
        }
        if (pairArr.length == 1) {
            setTextColor(((Integer) pairArr[0].first).intValue());
            return;
        }
        int[] iArr = new int[pairArr.length];
        float[] fArr = new float[pairArr.length];
        for (int i10 = 0; i10 < pairArr.length; i10++) {
            iArr[i10] = ((Integer) pairArr[i10].first).intValue();
            fArr[i10] = ((Float) pairArr[i10].second).floatValue();
        }
        getPaint().setShader(new LinearGradient(0.0f, 0.0f, getPaint().getTextSize() * getText().length(), 0.0f, iArr, fArr, Shader.TileMode.CLAMP));
        invalidate();
    }

    private void a(Context context, AttributeSet attributeSet) {
        setTextSize(getTextSize());
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    public MyEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18711a = 0;
        this.f18712b = 0;
        a(context, attributeSet);
    }

    public MyEditText(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f18711a = 0;
        this.f18712b = 0;
        a(context, attributeSet);
    }
}
