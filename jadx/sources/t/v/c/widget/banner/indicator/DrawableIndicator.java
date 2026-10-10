package t.v.c.widget.banner.indicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import x.l1.b2.R$styleable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0006\u0010\nJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\u0007J\u001f\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0014¢\u0006\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017¨\u0006\u001b"}, d2 = {"Lt/v/c/widget/banner/indicator/DrawableIndicator;", "Lt/v/c/widget/banner/indicator/BaseIndicator;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lr8/z;", "a", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "Landroid/graphics/Bitmap;", "d", "Landroid/graphics/Bitmap;", "normalBitmap", "e", "selectedBitmap", "tvcbaselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DrawableIndicator extends BaseIndicator {

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Bitmap normalBitmap;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Bitmap selectedBitmap;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DrawableIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);
        m.f(context, "context");
        m.f(attrs, "attrs");
        a(context, attrs);
    }

    private final void a(Context context, AttributeSet attrs) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, R$styleable.DrawableIndicator);
        m.e(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        BitmapDrawable bitmapDrawable = (BitmapDrawable) typedArrayObtainStyledAttributes.getDrawable(R$styleable.DrawableIndicator_normal_drawable);
        BitmapDrawable bitmapDrawable2 = (BitmapDrawable) typedArrayObtainStyledAttributes.getDrawable(R$styleable.DrawableIndicator_selected_drawable);
        this.normalBitmap = bitmapDrawable != null ? bitmapDrawable.getBitmap() : null;
        this.selectedBitmap = bitmapDrawable2 != null ? bitmapDrawable2.getBitmap() : null;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        m.f(canvas, "canvas");
        super.onDraw(canvas);
        int iD = getConfig().d();
        if (iD <= 1 || this.normalBitmap == null || this.selectedBitmap == null) {
            return;
        }
        int i10 = 0;
        float width = 0.0f;
        while (i10 < iD) {
            Bitmap bitmap = getConfig().a() == i10 ? this.selectedBitmap : this.normalBitmap;
            m.c(bitmap);
            canvas.drawBitmap(bitmap, width, 0.0f, getMPaint());
            Bitmap bitmap2 = this.normalBitmap;
            m.c(bitmap2);
            width += bitmap2.getWidth() + getConfig().e();
            i10++;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DrawableIndicator(Context context, AttributeSet attrs, int i10) {
        super(context, attrs, i10);
        m.f(context, "context");
        m.f(attrs, "attrs");
        a(context, attrs);
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int iD = getConfig().d();
        if (iD <= 1) {
            return;
        }
        Bitmap bitmap = this.selectedBitmap;
        m.c(bitmap);
        int i10 = iD - 1;
        int width = bitmap.getWidth() * i10;
        Bitmap bitmap2 = this.selectedBitmap;
        m.c(bitmap2);
        int width2 = width + bitmap2.getWidth() + (getConfig().e() * i10);
        Bitmap bitmap3 = this.normalBitmap;
        m.c(bitmap3);
        int height = bitmap3.getHeight();
        Bitmap bitmap4 = this.selectedBitmap;
        m.c(bitmap4);
        setMeasuredDimension(width2, Math.max(height, bitmap4.getHeight()));
    }
}
