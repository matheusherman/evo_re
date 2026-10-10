package t.v.c.widget.ratingbar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;
import jf.c;
import jf.e;
import t.v.c.R$drawable;
import t.v.c.R$styleable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@SuppressLint({"AppCompatCustomView"})
public class MyRatingBar extends RatingBar implements RatingBar.OnRatingBarChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ColorStateList f18812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ColorStateList f18813b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ColorStateList f18814c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f18815d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f18816e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f18817f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f18818g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f18819h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f18820i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private e f18821j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f18822k;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface a {
    }

    public MyRatingBar(Context context) {
        this(context, null);
    }

    @Override // android.widget.RatingBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        int measuredHeight = getMeasuredHeight();
        setMeasuredDimension(View.resolveSizeAndState(Math.round(measuredHeight * this.f18821j.b() * getNumStars() * this.f18818g) + ((int) ((getNumStars() - 1) * this.f18819h)), i10, 0), measuredHeight);
    }

    public MyRatingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet, 0);
    }

    private void a(Context context, AttributeSet attributeSet, int i10) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.MyRatingBar, i10, 0);
        this.f18820i = typedArrayObtainStyledAttributes.getBoolean(R$styleable.MyRatingBar_right2Left, false);
        int i11 = R$styleable.MyRatingBar_starColor;
        if (typedArrayObtainStyledAttributes.hasValue(i11)) {
            if (this.f18820i) {
                this.f18814c = typedArrayObtainStyledAttributes.getColorStateList(i11);
            } else {
                this.f18812a = typedArrayObtainStyledAttributes.getColorStateList(i11);
            }
        }
        int i12 = R$styleable.MyRatingBar_subStarColor;
        if (typedArrayObtainStyledAttributes.hasValue(i12) && !this.f18820i) {
            this.f18813b = typedArrayObtainStyledAttributes.getColorStateList(i12);
        }
        int i13 = R$styleable.MyRatingBar_bgColor;
        if (typedArrayObtainStyledAttributes.hasValue(i13)) {
            if (this.f18820i) {
                this.f18812a = typedArrayObtainStyledAttributes.getColorStateList(i13);
            } else {
                this.f18814c = typedArrayObtainStyledAttributes.getColorStateList(i13);
            }
        }
        this.f18817f = typedArrayObtainStyledAttributes.getBoolean(R$styleable.MyRatingBar_keepOriginColor, false);
        this.f18818g = typedArrayObtainStyledAttributes.getFloat(R$styleable.MyRatingBar_scaleFactor, 1.0f);
        this.f18819h = typedArrayObtainStyledAttributes.getDimension(R$styleable.MyRatingBar_starSpacing, 0.0f);
        int i14 = R$styleable.MyRatingBar_starDrawable;
        int i15 = R$drawable.ic_rating_star_solid;
        this.f18815d = typedArrayObtainStyledAttributes.getResourceId(i14, i15);
        int i16 = R$styleable.MyRatingBar_bgDrawable;
        if (typedArrayObtainStyledAttributes.hasValue(i16)) {
            this.f18816e = typedArrayObtainStyledAttributes.getResourceId(i16, i15);
        } else {
            this.f18816e = this.f18815d;
        }
        typedArrayObtainStyledAttributes.recycle();
        e eVar = new e(new c(context, getNumStars(), this.f18816e, this.f18815d, this.f18814c, this.f18813b, this.f18812a, this.f18817f));
        this.f18821j = eVar;
        setProgressDrawable(eVar);
    }

    @Override // android.widget.RatingBar.OnRatingBarChangeListener
    public void onRatingChanged(RatingBar ratingBar, float f10, boolean z10) {
        this.f18822k = f10;
    }

    public void setScaleFactor(float f10) {
        this.f18818g = f10;
        requestLayout();
    }

    public void setStarSpacing(float f10) {
        this.f18819h = f10;
        requestLayout();
    }

    @Override // android.widget.RatingBar
    public void setNumStars(int i10) {
        super.setNumStars(i10);
        e eVar = this.f18821j;
        if (eVar != null) {
            eVar.d(i10);
        }
    }

    public void setOnRatingChangeListener(a aVar) {
        setOnRatingBarChangeListener(this);
    }

    @Override // android.widget.RatingBar
    public void setRating(float f10) {
        super.setRating(f10);
        if (this.f18820i) {
            super.setRating(getNumStars() - getRating());
        }
    }

    public MyRatingBar(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        a(context, attributeSet, i10);
    }
}
