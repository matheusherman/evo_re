package t.v.c.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import x.l1.b2.R$styleable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 S2\u00020\u0001:\u0001\u0016B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000e\u0010\fJ\u000f\u0010\u000f\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000f\u0010\fJ\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ/\u0010 \u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006H\u0014¢\u0006\u0004\b \u0010!J\u0017\u0010$\u001a\u00020\n2\u0006\u0010#\u001a\u00020\"H\u0014¢\u0006\u0004\b$\u0010%R\u0016\u0010'\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010&R\u0016\u0010(\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010&R\u0016\u0010+\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010*R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010*R\u0016\u0010-\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010*R\u0016\u0010.\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010*R\u0016\u00100\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u0010*R\u0016\u00101\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010*R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00107\u001a\u0002028\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b6\u00104R\u0016\u00109\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u0010*R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010A\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010C\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010&R\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bI\u0010JR\"\u0010O\u001a\u00020L8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bM\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010R¨\u0006T"}, d2 = {"Lt/v/c/widget/RoundImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lr8/z;", "c", "()V", "f", "d", "e", "Landroid/graphics/drawable/Drawable;", "drawable", "Landroid/graphics/Bitmap;", "b", "(Landroid/graphics/drawable/Drawable;)Landroid/graphics/Bitmap;", "dpVal", "a", "(I)I", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "w", "h", "oldw", "oldh", "onSizeChanged", "(IIII)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "I", IjkMediaMeta.IJKM_KEY_TYPE, "mBorderColor", "", "F", "mBorderWidth", "mCornerRadius", "mLeftTopCornerRadius", "mRightTopCornerRadius", "g", "mLeftBottomCornerRadius", "mRightBottomCornerRadius", "Landroid/graphics/Paint;", "i", "Landroid/graphics/Paint;", "mBitmapPaint", "j", "mBorderPaint", "k", "mRadius", "Landroid/graphics/Matrix;", "l", "Landroid/graphics/Matrix;", "mMatrix", "Landroid/graphics/BitmapShader;", "m", "Landroid/graphics/BitmapShader;", "mBitmapShader", "n", "mWidth", "Landroid/graphics/RectF;", "o", "Landroid/graphics/RectF;", "mRoundRect", "Landroid/graphics/Path;", "p", "Landroid/graphics/Path;", "mRoundPath", "", "q", "Z", "isUseUnitDip", "()Z", "setUseUnitDip", "(Z)V", "r", "tvcbaselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RoundImageView extends AppCompatImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int type;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int mBorderColor;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private float mBorderWidth;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private float mCornerRadius;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private float mLeftTopCornerRadius;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float mRightTopCornerRadius;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private float mLeftBottomCornerRadius;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private float mRightBottomCornerRadius;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private Paint mBitmapPaint;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private Paint mBorderPaint;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    private float mRadius;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    private Matrix mMatrix;

    /* JADX INFO: renamed from: m, reason: collision with root package name and from kotlin metadata */
    private BitmapShader mBitmapShader;

    /* JADX INFO: renamed from: n, reason: collision with root package name and from kotlin metadata */
    private int mWidth;

    /* JADX INFO: renamed from: o, reason: collision with root package name and from kotlin metadata */
    private RectF mRoundRect;

    /* JADX INFO: renamed from: p, reason: collision with root package name and from kotlin metadata */
    private Path mRoundPath;

    /* JADX INFO: renamed from: q, reason: collision with root package name and from kotlin metadata */
    private boolean isUseUnitDip;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RoundImageView(Context context) {
        this(context, null, 0, 6, null);
        m.f(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RoundImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        m.f(context, "context");
    }

    private final int a(int dpVal) {
        return !this.isUseUnitDip ? dpVal : (int) TypedValue.applyDimension(1, dpVal, getResources().getDisplayMetrics());
    }

    private final Bitmap b(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
            m.e(bitmapCreateBitmap, "createBitmap(...)");
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            drawable.draw(canvas);
            return bitmapCreateBitmap;
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }

    private final void c() {
        this.mRoundPath = new Path();
        this.mRoundRect = new RectF();
        this.mMatrix = new Matrix();
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        this.mBitmapPaint = paint;
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setStyle(Paint.Style.STROKE);
        this.mBorderPaint = paint2;
        f();
    }

    private final void d() {
        Path path = this.mRoundPath;
        RectF rectF = null;
        if (path == null) {
            m.v("mRoundPath");
            path = null;
        }
        path.reset();
        if (this.mLeftTopCornerRadius == 0.0f && this.mLeftBottomCornerRadius == 0.0f && this.mRightTopCornerRadius == 0.0f && this.mRightBottomCornerRadius == 0.0f) {
            Path path2 = this.mRoundPath;
            if (path2 == null) {
                m.v("mRoundPath");
                path2 = null;
            }
            RectF rectF2 = this.mRoundRect;
            if (rectF2 == null) {
                m.v("mRoundRect");
            } else {
                rectF = rectF2;
            }
            float f10 = this.mCornerRadius;
            path2.addRoundRect(rectF, new float[]{f10, f10, f10, f10, f10, f10, f10, f10}, Path.Direction.CW);
            return;
        }
        Path path3 = this.mRoundPath;
        if (path3 == null) {
            m.v("mRoundPath");
            path3 = null;
        }
        RectF rectF3 = this.mRoundRect;
        if (rectF3 == null) {
            m.v("mRoundRect");
        } else {
            rectF = rectF3;
        }
        float f11 = this.mLeftTopCornerRadius;
        float f12 = this.mRightTopCornerRadius;
        float f13 = this.mRightBottomCornerRadius;
        float f14 = this.mLeftBottomCornerRadius;
        path3.addRoundRect(rectF, new float[]{f11, f11, f12, f12, f13, f13, f14, f14}, Path.Direction.CW);
    }

    private final void f() {
        Paint paint = this.mBorderPaint;
        Paint paint2 = null;
        if (paint == null) {
            m.v("mBorderPaint");
            paint = null;
        }
        paint.setColor(this.mBorderColor);
        Paint paint3 = this.mBorderPaint;
        if (paint3 == null) {
            m.v("mBorderPaint");
        } else {
            paint2 = paint3;
        }
        paint2.setStrokeWidth(this.mBorderWidth);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        m.f(canvas, "canvas");
        if (getDrawable() == null) {
            return;
        }
        e();
        int i10 = this.type;
        Paint paint = null;
        if (i10 == 0) {
            float f10 = this.mRadius;
            float f11 = this.mBorderWidth;
            float f12 = 2;
            float f13 = (f11 / f12) + f10;
            float f14 = (f11 / f12) + f10;
            Paint paint2 = this.mBitmapPaint;
            if (paint2 == null) {
                m.v("mBitmapPaint");
                paint2 = null;
            }
            canvas.drawCircle(f13, f14, f10, paint2);
            float f15 = this.mBorderWidth;
            if (f15 > 0.0f) {
                float f16 = this.mRadius;
                float f17 = (f15 / f12) + f16;
                float f18 = (f15 / f12) + f16;
                Paint paint3 = this.mBorderPaint;
                if (paint3 == null) {
                    m.v("mBorderPaint");
                } else {
                    paint = paint3;
                }
                canvas.drawCircle(f17, f18, f16, paint);
                return;
            }
            return;
        }
        if (i10 != 1) {
            RectF rectF = this.mRoundRect;
            if (rectF == null) {
                m.v("mRoundRect");
                rectF = null;
            }
            Paint paint4 = this.mBitmapPaint;
            if (paint4 == null) {
                m.v("mBitmapPaint");
                paint4 = null;
            }
            canvas.drawOval(rectF, paint4);
            if (this.mBorderWidth > 0.0f) {
                RectF rectF2 = this.mRoundRect;
                if (rectF2 == null) {
                    m.v("mRoundRect");
                    rectF2 = null;
                }
                Paint paint5 = this.mBorderPaint;
                if (paint5 == null) {
                    m.v("mBorderPaint");
                } else {
                    paint = paint5;
                }
                canvas.drawOval(rectF2, paint);
                return;
            }
            return;
        }
        d();
        Path path = this.mRoundPath;
        if (path == null) {
            m.v("mRoundPath");
            path = null;
        }
        Paint paint6 = this.mBitmapPaint;
        if (paint6 == null) {
            m.v("mBitmapPaint");
            paint6 = null;
        }
        canvas.drawPath(path, paint6);
        if (this.mBorderWidth > 0.0f) {
            Path path2 = this.mRoundPath;
            if (path2 == null) {
                m.v("mRoundPath");
                path2 = null;
            }
            Paint paint7 = this.mBorderPaint;
            if (paint7 == null) {
                m.v("mBorderPaint");
            } else {
                paint = paint7;
            }
            canvas.drawPath(path2, paint);
        }
    }

    public final void setUseUnitDip(boolean z10) {
        this.isUseUnitDip = z10;
    }

    public /* synthetic */ RoundImageView(Context context, AttributeSet attributeSet, int i10, int i11, g gVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    private final void e() {
        Bitmap bitmapB;
        Drawable drawable = getDrawable();
        if (drawable == null || (bitmapB = b(drawable)) == null) {
            return;
        }
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.mBitmapShader = new BitmapShader(bitmapB, tileMode, tileMode);
        Matrix matrix = this.mMatrix;
        Paint paint = null;
        if (matrix == null) {
            m.v("mMatrix");
            matrix = null;
        }
        matrix.setTranslate(0.0f, 0.0f);
        int i10 = this.type;
        float fMin = 1.0f;
        if (i10 != 0) {
            if ((i10 == 1 || i10 == 2) && (bitmapB.getWidth() != getWidth() || bitmapB.getHeight() != getHeight())) {
                fMin = Math.max((getWidth() * 1.0f) / bitmapB.getWidth(), (getHeight() * 1.0f) / bitmapB.getHeight());
                float f10 = 2;
                float width = ((bitmapB.getWidth() * fMin) - getWidth()) / f10;
                float height = ((bitmapB.getHeight() * fMin) - getHeight()) / f10;
                Matrix matrix2 = this.mMatrix;
                if (matrix2 == null) {
                    m.v("mMatrix");
                    matrix2 = null;
                }
                matrix2.setTranslate(-width, -height);
            }
        } else if (bitmapB.getWidth() != getWidth() || bitmapB.getHeight() != getHeight()) {
            fMin = (this.mWidth * 1.0f) / Math.min(bitmapB.getWidth(), bitmapB.getHeight());
            float f11 = 2;
            float width2 = ((bitmapB.getWidth() * fMin) - this.mWidth) / f11;
            float height2 = ((bitmapB.getHeight() * fMin) - this.mWidth) / f11;
            Matrix matrix3 = this.mMatrix;
            if (matrix3 == null) {
                m.v("mMatrix");
                matrix3 = null;
            }
            matrix3.setTranslate(-width2, -height2);
        }
        Matrix matrix4 = this.mMatrix;
        if (matrix4 == null) {
            m.v("mMatrix");
            matrix4 = null;
        }
        matrix4.preScale(fMin, fMin);
        BitmapShader bitmapShader = this.mBitmapShader;
        if (bitmapShader != null) {
            Matrix matrix5 = this.mMatrix;
            if (matrix5 == null) {
                m.v("mMatrix");
                matrix5 = null;
            }
            bitmapShader.setLocalMatrix(matrix5);
        }
        Paint paint2 = this.mBitmapPaint;
        if (paint2 == null) {
            m.v("mBitmapPaint");
        } else {
            paint = paint2;
        }
        paint.setShader(this.mBitmapShader);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (this.type == 0) {
            int iMin = Math.min(View.MeasureSpec.getSize(widthMeasureSpec), View.MeasureSpec.getSize(heightMeasureSpec));
            this.mWidth = iMin;
            this.mRadius = (iMin / 2) - (this.mBorderWidth / 2);
            setMeasuredDimension(iMin, iMin);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int w10, int h10, int oldw, int oldh) {
        super.onSizeChanged(w10, h10, oldw, oldh);
        int i10 = this.type;
        if (i10 != 1 && i10 != 2) {
            return;
        }
        RectF rectF = this.mRoundRect;
        if (rectF == null) {
            m.v("mRoundRect");
            rectF = null;
        }
        float f10 = this.mBorderWidth;
        float f11 = 2;
        rectF.set(f10 / f11, f10 / f11, w10 - (f10 / f11), h10 - (f10 / f11));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoundImageView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        m.f(context, "context");
        this.isUseUnitDip = true;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RoundImageView, i10, 0);
        m.e(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        this.type = typedArrayObtainStyledAttributes.getInt(R$styleable.RoundImageView_type, 1);
        this.mBorderColor = typedArrayObtainStyledAttributes.getColor(R$styleable.RoundImageView_border_color, -1);
        this.mBorderWidth = typedArrayObtainStyledAttributes.getDimension(R$styleable.RoundImageView_border_width, 0.0f);
        this.mCornerRadius = typedArrayObtainStyledAttributes.getDimension(R$styleable.RoundImageView_corner_radius, a(10));
        this.mLeftTopCornerRadius = typedArrayObtainStyledAttributes.getDimension(R$styleable.RoundImageView_leftTop_corner_radius, 0.0f);
        this.mLeftBottomCornerRadius = typedArrayObtainStyledAttributes.getDimension(R$styleable.RoundImageView_leftBottom_corner_radius, 0.0f);
        this.mRightTopCornerRadius = typedArrayObtainStyledAttributes.getDimension(R$styleable.RoundImageView_rightTop_corner_radius, 0.0f);
        this.mRightBottomCornerRadius = typedArrayObtainStyledAttributes.getDimension(R$styleable.RoundImageView_rightBottom_corner_radius, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
        c();
    }
}
