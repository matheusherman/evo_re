package t.v.c.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import x.l1.b2.R$styleable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class MyRoundImageView extends AppCompatImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f18734a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f18735b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f18736c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f18737d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f18738e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f18739f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f18740g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f18741h;

    public MyRoundImageView(Context context) {
        this(context, null);
        init(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.MyRoundCornerImageView);
        this.f18737d = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.MyRoundCornerImageView_radius, this.f18736c);
        this.f18738e = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.MyRoundCornerImageView_left_top_radius, this.f18736c);
        this.f18739f = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.MyRoundCornerImageView_right_top_radius, this.f18736c);
        this.f18740g = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.MyRoundCornerImageView_right_bottom_radius, this.f18736c);
        int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.MyRoundCornerImageView_left_bottom_radius, this.f18736c);
        this.f18741h = dimensionPixelOffset;
        int i10 = this.f18736c;
        if (i10 == this.f18738e) {
            this.f18738e = this.f18737d;
        }
        if (i10 == this.f18739f) {
            this.f18739f = this.f18737d;
        }
        if (i10 == this.f18740g) {
            this.f18740g = this.f18737d;
        }
        if (i10 == dimensionPixelOffset) {
            this.f18741h = this.f18737d;
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        int iMax = Math.max(this.f18738e, this.f18741h) + Math.max(this.f18739f, this.f18740g);
        int iMax2 = Math.max(this.f18738e, this.f18739f) + Math.max(this.f18741h, this.f18740g);
        if (this.f18734a >= iMax && this.f18735b > iMax2) {
            Path path = new Path();
            path.moveTo(this.f18738e, 0.0f);
            path.lineTo(this.f18734a - this.f18739f, 0.0f);
            float f10 = this.f18734a;
            path.quadTo(f10, 0.0f, f10, this.f18739f);
            path.lineTo(this.f18734a, this.f18735b - this.f18740g);
            float f11 = this.f18734a;
            float f12 = this.f18735b;
            path.quadTo(f11, f12, f11 - this.f18740g, f12);
            path.lineTo(this.f18741h, this.f18735b);
            float f13 = this.f18735b;
            path.quadTo(0.0f, f13, 0.0f, f13 - this.f18741h);
            path.lineTo(0.0f, this.f18738e);
            path.quadTo(0.0f, 0.0f, this.f18738e, 0.0f);
            canvas.clipPath(path);
        }
        super.onDraw(canvas);
    }

    public MyRoundImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        init(context, attributeSet);
    }

    @Override // android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        this.f18734a = getWidth();
        this.f18735b = getHeight();
    }

    public MyRoundImageView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f18736c = 0;
        init(context, attributeSet);
    }
}
