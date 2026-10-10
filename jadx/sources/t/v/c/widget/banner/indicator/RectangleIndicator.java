package t.v.c.widget.banner.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H\u0014¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lt/v/c/widget/banner/indicator/RectangleIndicator;", "Lt/v/c/widget/banner/indicator/BaseIndicator;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "widthMeasureSpec", "heightMeasureSpec", "Lr8/z;", "onMeasure", "(II)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "Landroid/graphics/RectF;", "d", "Landroid/graphics/RectF;", "rectF", "tvcbaselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RectangleIndicator extends BaseIndicator {

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private RectF rectF;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RectangleIndicator(Context context) {
        super(context);
        m.f(context, "context");
        this.rectF = new RectF();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        m.f(canvas, "canvas");
        super.onDraw(canvas);
        int iD = getConfig().d();
        if (iD <= 1) {
            return;
        }
        int i10 = 0;
        float fE = 0.0f;
        while (i10 < iD) {
            getMPaint().setColor(getConfig().a() == i10 ? getConfig().j() : getConfig().g());
            int iK = getConfig().a() == i10 ? getConfig().k() : getConfig().h();
            this.rectF.set(fE, 0.0f, iK + fE, getConfig().c());
            fE += iK + getConfig().e();
            canvas.drawRoundRect(this.rectF, getConfig().i(), getConfig().i(), getMPaint());
            i10++;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RectangleIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);
        m.f(context, "context");
        m.f(attrs, "attrs");
        this.rectF = new RectF();
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int iD = getConfig().d();
        if (iD <= 1) {
            return;
        }
        int i10 = iD - 1;
        setMeasuredDimension((getConfig().e() * i10) + (getConfig().h() * i10) + getConfig().k(), getConfig().c());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RectangleIndicator(Context context, AttributeSet attrs, int i10) {
        super(context, attrs, i10);
        m.f(context, "context");
        m.f(attrs, "attrs");
        this.rectF = new RectF();
    }
}
