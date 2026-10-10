package t.v.c.widget.banner.indicator;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import bg.b;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0005\u0010\tB!\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0005\u0010\fJ\u000f\u0010\r\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0011\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\nH\u0016¢\u0006\u0004\b \u0010\u001eR\u001a\u0010$\u001a\u00020\u000f8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\u0011R\u001a\u0010*\u001a\u00020%8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0016\u0010-\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,¨\u0006."}, d2 = {"Lt/v/c/widget/banner/indicator/BaseIndicator;", "Landroid/view/View;", "Lt/v/c/widget/banner/indicator/a;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "getIndicatorView", "()Landroid/view/View;", "Lbg/b;", "getIndicatorConfig", "()Lbg/b;", "count", "currentPosition", "Lr8/z;", "onPageChanged", "(II)V", "position", "", "positionOffset", "positionOffsetPixels", "onPageScrolled", "(IFI)V", "onPageSelected", "(I)V", "state", "onPageScrollStateChanged", "a", "Lbg/b;", "getConfig", "config", "Landroid/graphics/Paint;", "b", "Landroid/graphics/Paint;", "getMPaint", "()Landroid/graphics/Paint;", "mPaint", "c", "F", "offset", "tvcbaselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class BaseIndicator extends View implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final b config;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Paint mPaint;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private float offset;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseIndicator(Context context) {
        super(context);
        m.f(context, "context");
        b bVar = new b();
        this.config = bVar;
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        paint.setColor(0);
        paint.setColor(bVar.g());
    }

    protected final b getConfig() {
        return this.config;
    }

    @Override // t.v.c.widget.banner.indicator.a
    public b getIndicatorConfig() {
        return this.config;
    }

    public View getIndicatorView() {
        if (this.config.l()) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            int iB = this.config.b();
            if (iB == 0) {
                layoutParams.gravity = 8388691;
            } else if (iB == 1) {
                layoutParams.gravity = 81;
            } else if (iB == 2) {
                layoutParams.gravity = 8388693;
            }
            layoutParams.leftMargin = this.config.f().f1092a;
            layoutParams.rightMargin = this.config.f().f1094c;
            layoutParams.topMargin = this.config.f().f1093b;
            layoutParams.bottomMargin = this.config.f().f1095d;
            setLayoutParams(layoutParams);
        }
        return this;
    }

    protected final Paint getMPaint() {
        return this.mPaint;
    }

    @Override // t.v.c.widget.banner.indicator.a
    public void onPageChanged(int count, int currentPosition) {
        this.config.n(count);
        this.config.m(currentPosition);
        requestLayout();
    }

    @Override // cg.a
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        this.offset = positionOffset;
        invalidate();
    }

    @Override // cg.a
    public void onPageSelected(int position) {
        this.config.m(position);
        invalidate();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);
        m.f(context, "context");
        m.f(attrs, "attrs");
        b bVar = new b();
        this.config = bVar;
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        paint.setColor(0);
        paint.setColor(bVar.g());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseIndicator(Context context, AttributeSet attrs, int i10) {
        super(context, attrs, i10);
        m.f(context, "context");
        m.f(attrs, "attrs");
        b bVar = new b();
        this.config = bVar;
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        paint.setColor(0);
        paint.setColor(bVar.g());
    }

    @Override // cg.a
    public void onPageScrollStateChanged(int state) {
    }
}
