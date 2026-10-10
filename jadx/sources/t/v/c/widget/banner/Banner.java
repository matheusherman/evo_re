package t.v.c.widget.banner;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.p000lifecycle.DefaultLifecycleObserver;
import androidx.p000lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.ViewPager2;
import bg.b;
import com.youth.banner.config.BannerConfig;
import hf.a;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import t.v.c.R$styleable;
import t.v.c.widget.FrameLayout;
import t.v.c.widget.banner.util.ScrollSpeedManger;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000  \u0001*\u0004\b\u0000\u0010\u0001*\u0016\b\u0001\u0010\u0004*\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\b\u0001\u0012\u00020\u00030\u00022\u00020\u00052\u00020\u0006:\u0004¡\u0001¢\u0001B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nB\u0019\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\t\u0010\rB!\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\t\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0012\u0010\nJ\u001f\u0010\u0013\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0013\u0010\rJ\u0017\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0018\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0019\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u001a\u0010\u0017J\u000f\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010!\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u000eH\u0002¢\u0006\u0004\b!\u0010\"J\u001f\u0010%\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u000eH\u0002¢\u0006\u0004\b%\u0010&J\u0017\u0010*\u001a\u00020)2\u0006\u0010(\u001a\u00020'H\u0016¢\u0006\u0004\b*\u0010+J\u0017\u0010-\u001a\u00020)2\u0006\u0010,\u001a\u00020'H\u0016¢\u0006\u0004\b-\u0010+J\u0017\u0010.\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0014H\u0014¢\u0006\u0004\b.\u0010\u0017J\u000f\u0010/\u001a\u00020\u0011H\u0014¢\u0006\u0004\b/\u0010\u001fJ\u000f\u00100\u001a\u00020\u0011H\u0014¢\u0006\u0004\b0\u0010\u001fJ\u000f\u00101\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b1\u00102J\r\u00103\u001a\u00020\u000e¢\u0006\u0004\b3\u00104J\r\u00105\u001a\u00020\u000e¢\u0006\u0004\b5\u00104J\r\u00106\u001a\u00020)¢\u0006\u0004\b6\u00107J\u001d\u00108\u001a\u0012\u0012\u0004\u0012\u00028\u0000\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0004\b8\u00109J\u000f\u0010;\u001a\u0004\u0018\u00010:¢\u0006\u0004\b;\u0010<J\u000f\u0010>\u001a\u0004\u0018\u00010=¢\u0006\u0004\b>\u0010?J\u000f\u0010A\u001a\u0004\u0018\u00010@¢\u0006\u0004\bA\u0010BJ\r\u0010C\u001a\u00020\u000e¢\u0006\u0004\bC\u00104J!\u0010E\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010D\u001a\u00020\u000e¢\u0006\u0004\bE\u0010FJ)\u0010H\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010D\u001a\u00020\u000e2\u0006\u0010G\u001a\u00020)¢\u0006\u0004\bH\u0010IJ\u0019\u0010J\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000¢\u0006\u0004\bJ\u0010KJ!\u0010M\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010L\u001a\u00020\u000e¢\u0006\u0004\bM\u0010FJ\r\u0010N\u001a\u00020\u000e¢\u0006\u0004\bN\u00104J!\u0010P\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010O\u001a\u00020)¢\u0006\u0004\bP\u0010QJ\u0019\u0010R\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000¢\u0006\u0004\bR\u0010KJ\u0019\u0010S\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000¢\u0006\u0004\bS\u0010KJ\r\u0010T\u001a\u00020\u0011¢\u0006\u0004\bT\u0010\u001fJ!\u0010V\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010U\u001a\u00020\u000e¢\u0006\u0004\bV\u0010FR\u0018\u0010Y\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010XR\u0018\u0010]\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010\\R\u0018\u0010a\u001a\u0004\u0018\u00010^8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010`R\u0018\u0010d\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010cR\u0018\u0010h\u001a\u0004\u0018\u00010e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010gR\u0018\u0010k\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010jR\u0016\u0010n\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bl\u0010mR\u0016\u0010p\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bo\u0010mR\u0016\u0010s\u001a\u00020q8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\br\u0010RR\u0016\u0010u\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bt\u0010MR\u0016\u0010L\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bv\u0010MR\u0016\u0010y\u001a\u00020w8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bx\u0010\u001eR\u0016\u0010{\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bz\u0010mR\u0016\u0010}\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b|\u0010mR\u0016\u0010\u007f\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b~\u0010mR\u0018\u0010\u0081\u0001\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0080\u0001\u0010mR\u0017\u0010\u0082\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010MR\u0017\u0010\u0083\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010MR\u0017\u0010\u0084\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010MR\u0017\u0010\u0085\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010MR\u0017\u0010\u0086\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010MR\u0017\u0010\u0087\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010MR\u0017\u0010\u0088\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010MR\u0017\u0010\u0089\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010MR\u0017\u0010\u008a\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u0010MR\u0017\u0010\u008b\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010MR\u0017\u0010\u008c\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010MR\u0017\u0010\u008d\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010MR\u0017\u0010\u008e\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010MR\u0017\u0010\u008f\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010MR\u0017\u0010\u0090\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010MR\u0017\u0010\u0091\u0001\u001a\u00020w8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010\u001eR\u0017\u0010\u0092\u0001\u001a\u00020w8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010\u001eR\u0017\u0010\u0093\u0001\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010mR\u0018\u0010\u0095\u0001\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0094\u0001\u0010mR\u001c\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u0096\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0097\u0001\u0010\u0098\u0001R\u001c\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u0096\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009a\u0001\u0010\u0098\u0001R\u0018\u0010\u009f\u0001\u001a\u00030\u009c\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009d\u0001\u0010\u009e\u0001¨\u0006£\u0001"}, d2 = {"Lt/v/c/widget/banner/Banner;", ExifInterface.GPS_DIRECTION_TRUE, "Lhf/a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "BA", "Lt/v/c/widget/FrameLayout;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lr8/z;", "y", "z", "Landroid/graphics/Canvas;", "canvas", "w", "(Landroid/graphics/Canvas;)V", "x", "u", "v", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "getBannerOnPageChangeCallback", "()Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "F", "()V", "itemPadding", "setRecyclerViewPadding", "(I)V", "leftItemPadding", "rightItemPadding", "H", "(II)V", "Landroid/view/MotionEvent;", "ev", "", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", NotificationCompat.CATEGORY_EVENT, "onInterceptTouchEvent", "dispatchDraw", "onAttachedToWindow", "onDetachedFromWindow", "getCurrentItem", "()Ljava/lang/Integer;", "getItemCount", "()I", "getScrollTime", "B", "()Z", "getAdapter", "()Lhf/a;", "Landroidx/viewpager2/widget/ViewPager2;", "getViewPager2", "()Landroidx/viewpager2/widget/ViewPager2;", "Lt/v/c/widget/banner/indicator/a;", "getIndicator", "()Lt/v/c/widget/banner/indicator/a;", "Lbg/b;", "getIndicatorConfig", "()Lbg/b;", "getRealCount", "position", "C", "(I)Lt/v/c/widget/banner/Banner;", "smoothScroll", "D", "(IZ)Lt/v/c/widget/banner/Banner;", ExifInterface.LONGITUDE_EAST, "()Lt/v/c/widget/banner/Banner;", "mStartPosition", "I", "getStartPosition", "isAutoLoop", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Z)Lt/v/c/widget/banner/Banner;", "J", "K", "t", "orientation", "G", "d", "Landroidx/viewpager2/widget/ViewPager2;", "mViewPager2", "Lt/v/c/widget/banner/Banner$a;", "e", "Lt/v/c/widget/banner/Banner$a;", "mLoopTask", "Lcg/a;", "f", "Lcg/a;", "mOnPageChangeListener", "g", "Lt/v/c/widget/banner/indicator/a;", "mIndicator", "Landroidx/viewpager2/widget/CompositePageTransformer;", "h", "Landroidx/viewpager2/widget/CompositePageTransformer;", "mCompositePageTransformer", "i", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "mPageChangeCallback", "j", "Z", "mIsInfiniteLoop", "k", "mIsAutoLoop", "", "l", "mLoopTime", "m", "mScrollTime", "n", "", "o", "mBannerRadius", "p", "mRoundTopLeft", "q", "mRoundTopRight", "r", "mRoundBottomLeft", "s", "mRoundBottomRight", "normalWidth", "selectedWidth", "normalColor", "selectedColor", "indicatorGravity", "indicatorSpace", "indicatorMargin", "indicatorMarginLeft", "indicatorMarginTop", "indicatorMarginRight", "indicatorMarginBottom", "indicatorHeight", "indicatorRadius", "mOrientation", "mTouchSlop", "mStartX", "mStartY", "mIsViewPager2Drag", "L", "isIntercept", "Landroid/graphics/Paint;", "M", "Landroid/graphics/Paint;", "mRoundPaint", "N", "mImagePaint", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "O", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "mAdapterDataObserver", "P", "b", "a", "tvcbaselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Banner<T, BA extends hf.a<T, ? extends RecyclerView.ViewHolder>> extends FrameLayout implements DefaultLifecycleObserver {

    /* JADX INFO: renamed from: A, reason: from kotlin metadata */
    private int indicatorMarginLeft;

    /* JADX INFO: renamed from: B, reason: from kotlin metadata */
    private int indicatorMarginTop;

    /* JADX INFO: renamed from: C, reason: from kotlin metadata */
    private int indicatorMarginRight;

    /* JADX INFO: renamed from: D, reason: from kotlin metadata */
    private int indicatorMarginBottom;

    /* JADX INFO: renamed from: E, reason: from kotlin metadata */
    private int indicatorHeight;

    /* JADX INFO: renamed from: F, reason: from kotlin metadata */
    private int indicatorRadius;

    /* JADX INFO: renamed from: G, reason: from kotlin metadata */
    private int mOrientation;

    /* JADX INFO: renamed from: H, reason: from kotlin metadata */
    private int mTouchSlop;

    /* JADX INFO: renamed from: I, reason: from kotlin metadata */
    private float mStartX;

    /* JADX INFO: renamed from: J, reason: from kotlin metadata */
    private float mStartY;

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    private boolean mIsViewPager2Drag;

    /* JADX INFO: renamed from: L, reason: from kotlin metadata */
    private boolean isIntercept;

    /* JADX INFO: renamed from: M, reason: from kotlin metadata */
    private Paint mRoundPaint;

    /* JADX INFO: renamed from: N, reason: from kotlin metadata */
    private Paint mImagePaint;

    /* JADX INFO: renamed from: O, reason: from kotlin metadata */
    private final RecyclerView.AdapterDataObserver mAdapterDataObserver;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ViewPager2 mViewPager2;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private a mLoopTask;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private cg.a mOnPageChangeListener;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private t.v.c.widget.banner.indicator.a mIndicator;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private CompositePageTransformer mCompositePageTransformer;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ViewPager2.OnPageChangeCallback mPageChangeCallback;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private boolean mIsInfiniteLoop;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    private boolean mIsAutoLoop;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    private long mLoopTime;

    /* JADX INFO: renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mScrollTime;

    /* JADX INFO: renamed from: n, reason: collision with root package name and from kotlin metadata */
    private int mStartPosition;

    /* JADX INFO: renamed from: o, reason: collision with root package name and from kotlin metadata */
    private float mBannerRadius;

    /* JADX INFO: renamed from: p, reason: collision with root package name and from kotlin metadata */
    private boolean mRoundTopLeft;

    /* JADX INFO: renamed from: q, reason: collision with root package name and from kotlin metadata */
    private boolean mRoundTopRight;

    /* JADX INFO: renamed from: r, reason: collision with root package name and from kotlin metadata */
    private boolean mRoundBottomLeft;

    /* JADX INFO: renamed from: s, reason: collision with root package name and from kotlin metadata */
    private boolean mRoundBottomRight;

    /* JADX INFO: renamed from: t, reason: collision with root package name and from kotlin metadata */
    private int normalWidth;

    /* JADX INFO: renamed from: u, reason: collision with root package name and from kotlin metadata */
    private int selectedWidth;

    /* JADX INFO: renamed from: v, reason: collision with root package name and from kotlin metadata */
    private int normalColor;

    /* JADX INFO: renamed from: w, reason: collision with root package name and from kotlin metadata */
    private int selectedColor;

    /* JADX INFO: renamed from: x, reason: collision with root package name and from kotlin metadata */
    private int indicatorGravity;

    /* JADX INFO: renamed from: y, reason: collision with root package name and from kotlin metadata */
    private int indicatorSpace;

    /* JADX INFO: renamed from: z, reason: collision with root package name and from kotlin metadata */
    private int indicatorMargin;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0003\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\f\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lt/v/c/widget/banner/Banner$a;", "Ljava/lang/Runnable;", "Lt/v/c/widget/banner/Banner;", "banner", "<init>", "(Lt/v/c/widget/banner/Banner;)V", "Lr8/z;", "run", "()V", "Ljava/lang/ref/WeakReference;", "a", "Ljava/lang/ref/WeakReference;", TypedValues.Custom.S_REFERENCE, "tvcbaselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<Banner<?, ?>> reference;

        public a(Banner<?, ?> banner) {
            m.f(banner, "banner");
            this.reference = new WeakReference<>(banner);
        }

        @Override // java.lang.Runnable
        public void run() {
            int itemCount;
            Integer currentItem;
            Banner<?, ?> banner = this.reference.get();
            if (banner == null || !((Banner) banner).mIsAutoLoop || (itemCount = banner.getItemCount()) == 0 || (currentItem = banner.getCurrentItem()) == null) {
                return;
            }
            banner.C((currentItem.intValue() + 1) % itemCount);
            banner.postDelayed(((Banner) banner).mLoopTask, ((Banner) banner).mLoopTime);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"t/v/c/widget/banner/Banner$c", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "", "position", "", "positionOffset", "positionOffsetPixels", "Lr8/z;", "onPageScrolled", "(IFI)V", "onPageSelected", "(I)V", "state", "onPageScrollStateChanged", "a", "I", "mTempPosition", "", "b", "Z", "isScrolled", "tvcbaselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class c extends ViewPager2.OnPageChangeCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int mTempPosition = -1;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private boolean isScrolled;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Banner<T, BA> f18797c;

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int state) {
            if (state == 0) {
                this.isScrolled = false;
                if (this.mTempPosition != -1 && ((Banner) this.f18797c).mIsInfiniteLoop) {
                    int i10 = this.mTempPosition;
                    if (i10 == 0) {
                        Banner<T, BA> banner = this.f18797c;
                        banner.D(banner.getRealCount(), false);
                    } else if (i10 == this.f18797c.getItemCount() - 1) {
                        this.f18797c.D(1, false);
                    }
                }
            } else if (state == 1 || state == 2) {
                this.isScrolled = true;
            }
            cg.a aVar = ((Banner) this.f18797c).mOnPageChangeListener;
            if (aVar != null) {
                aVar.onPageScrollStateChanged(state);
            }
            t.v.c.widget.banner.indicator.a mIndicator = this.f18797c.getMIndicator();
            if (mIndicator != null) {
                mIndicator.onPageScrollStateChanged(state);
            }
        }

        c(Banner<T, BA> banner) {
            this.f18797c = banner;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            int iB = dg.a.b(this.f18797c.getMIsInfiniteLoop(), position, this.f18797c.getRealCount());
            Integer currentItem = this.f18797c.getCurrentItem();
            if (currentItem != null) {
                Banner<T, BA> banner = this.f18797c;
                if (iB == currentItem.intValue() - 1) {
                    cg.a aVar = ((Banner) banner).mOnPageChangeListener;
                    if (aVar != null) {
                        aVar.onPageScrolled(iB, positionOffset, positionOffsetPixels);
                    }
                    t.v.c.widget.banner.indicator.a mIndicator = banner.getMIndicator();
                    if (mIndicator != null) {
                        mIndicator.onPageScrolled(iB, positionOffset, positionOffsetPixels);
                    }
                }
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int position) {
            cg.a aVar;
            if (this.isScrolled) {
                this.mTempPosition = position;
                int iB = dg.a.b(this.f18797c.getMIsInfiniteLoop(), position, this.f18797c.getRealCount());
                if (((Banner) this.f18797c).mOnPageChangeListener != null && (aVar = ((Banner) this.f18797c).mOnPageChangeListener) != null) {
                    aVar.onPageSelected(iB);
                }
                t.v.c.widget.banner.indicator.a mIndicator = this.f18797c.getMIndicator();
                if (mIndicator != null) {
                    mIndicator.onPageSelected(iB);
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"t/v/c/widget/banner/Banner$d", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "Lr8/z;", "onChanged", "()V", "tvcbaselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class d extends RecyclerView.AdapterDataObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Banner<T, BA> f18798a;

        d(Banner<T, BA> banner) {
            this.f18798a = banner;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            if (this.f18798a.getItemCount() <= 1) {
                this.f18798a.K();
            } else {
                this.f18798a.J();
            }
            this.f18798a.E();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Banner(Context context) {
        super(context);
        m.f(context, "context");
        this.mIsInfiniteLoop = true;
        this.mIsAutoLoop = true;
        this.mLoopTime = 3000L;
        this.mScrollTime = 600;
        this.mStartPosition = 1;
        this.normalWidth = bg.a.f1074a;
        this.selectedWidth = bg.a.f1075b;
        this.normalColor = BannerConfig.INDICATOR_NORMAL_COLOR;
        this.selectedColor = BannerConfig.INDICATOR_SELECTED_COLOR;
        this.indicatorGravity = 1;
        this.indicatorHeight = bg.a.f1078e;
        this.indicatorRadius = bg.a.f1079f;
        this.isIntercept = true;
        this.mAdapterDataObserver = new d(this);
        y(context);
    }

    public final Banner<T, BA> C(int position) {
        return D(position, true);
    }

    public final hf.a<T, ? extends RecyclerView.ViewHolder> getAdapter() {
        return null;
    }

    private final ViewPager2.OnPageChangeCallback getBannerOnPageChangeCallback() {
        return new c(this);
    }

    private final void w(Canvas canvas) {
        Path path = new Path();
        path.moveTo(0.0f, this.mBannerRadius);
        path.lineTo(0.0f, 0.0f);
        path.lineTo(this.mBannerRadius, 0.0f);
        float f10 = this.mBannerRadius;
        float f11 = 2;
        path.arcTo(new RectF(0.0f, 0.0f, f10 * f11, f10 * f11), -90.0f, -90.0f);
        path.close();
        Paint paint = this.mRoundPaint;
        m.c(paint);
        canvas.drawPath(path, paint);
    }

    private final void z(Context context, AttributeSet attrs) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, R$styleable.Banner);
        m.e(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        this.mBannerRadius = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.Banner_banner_radius, 0);
        this.mLoopTime = typedArrayObtainStyledAttributes.getInt(R$styleable.Banner_banner_loop_time, 3000);
        this.mIsAutoLoop = typedArrayObtainStyledAttributes.getBoolean(R$styleable.Banner_banner_auto_loop, true);
        this.mIsInfiniteLoop = typedArrayObtainStyledAttributes.getBoolean(R$styleable.Banner_banner_infinite_loop, true);
        this.normalWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.Banner_banner_indicator_normal_width, bg.a.f1074a);
        this.selectedWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.Banner_banner_indicator_selected_width, bg.a.f1075b);
        this.normalColor = typedArrayObtainStyledAttributes.getColor(R$styleable.Banner_banner_indicator_normal_color, BannerConfig.INDICATOR_NORMAL_COLOR);
        this.selectedColor = typedArrayObtainStyledAttributes.getColor(R$styleable.Banner_banner_indicator_selected_color, BannerConfig.INDICATOR_SELECTED_COLOR);
        this.indicatorGravity = typedArrayObtainStyledAttributes.getInt(R$styleable.Banner_banner_indicator_gravity, 1);
        this.indicatorSpace = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.Banner_banner_indicator_space, 0);
        this.indicatorMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.Banner_banner_indicator_margin, 0);
        this.indicatorMarginLeft = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.Banner_banner_indicator_marginLeft, 0);
        this.indicatorMarginTop = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.Banner_banner_indicator_marginTop, 0);
        this.indicatorMarginRight = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.Banner_banner_indicator_marginRight, 0);
        this.indicatorMarginBottom = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.Banner_banner_indicator_marginBottom, 0);
        this.indicatorHeight = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.Banner_banner_indicator_height, bg.a.f1078e);
        this.indicatorRadius = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.Banner_banner_indicator_radius, bg.a.f1079f);
        this.mOrientation = typedArrayObtainStyledAttributes.getInt(R$styleable.Banner_banner_orientation, 0);
        this.mRoundTopLeft = typedArrayObtainStyledAttributes.getBoolean(R$styleable.Banner_banner_round_top_left, false);
        this.mRoundTopRight = typedArrayObtainStyledAttributes.getBoolean(R$styleable.Banner_banner_round_top_right, false);
        this.mRoundBottomLeft = typedArrayObtainStyledAttributes.getBoolean(R$styleable.Banner_banner_round_bottom_left, false);
        this.mRoundBottomRight = typedArrayObtainStyledAttributes.getBoolean(R$styleable.Banner_banner_round_bottom_right, false);
        typedArrayObtainStyledAttributes.recycle();
        G(this.mOrientation);
        F();
    }

    public final Banner<T, BA> A(boolean isAutoLoop) {
        this.mIsAutoLoop = isAutoLoop;
        return this;
    }

    /* JADX INFO: renamed from: B, reason: from getter */
    public final boolean getMIsInfiniteLoop() {
        return this.mIsInfiniteLoop;
    }

    public final Banner<T, BA> I(int mStartPosition) {
        this.mStartPosition = mStartPosition;
        return this;
    }

    public final Banner<T, BA> J() {
        if (this.mIsAutoLoop) {
            K();
            postDelayed(this.mLoopTask, this.mLoopTime);
        }
        return this;
    }

    public final Banner<T, BA> K() {
        if (this.mIsAutoLoop) {
            removeCallbacks(this.mLoopTask);
        }
        return this;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        m.f(canvas, "canvas");
        if (this.mBannerRadius <= 0.0f) {
            super.dispatchDraw(canvas);
            return;
        }
        canvas.saveLayer(new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight()), this.mImagePaint, 31);
        super.dispatchDraw(canvas);
        if (!this.mRoundTopRight && !this.mRoundTopLeft && !this.mRoundBottomRight && !this.mRoundBottomLeft) {
            w(canvas);
            x(canvas);
            u(canvas);
            v(canvas);
            canvas.restore();
            return;
        }
        if (this.mRoundTopLeft) {
            w(canvas);
        }
        if (this.mRoundTopRight) {
            x(canvas);
        }
        if (this.mRoundBottomLeft) {
            u(canvas);
        }
        if (this.mRoundBottomRight) {
            v(canvas);
        }
        canvas.restore();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent ev) {
        m.f(ev, "ev");
        ViewPager2 mViewPager2 = getMViewPager2();
        m.c(mViewPager2);
        if (!mViewPager2.isUserInputEnabled()) {
            return super.dispatchTouchEvent(ev);
        }
        int actionMasked = ev.getActionMasked();
        if (actionMasked == 0) {
            K();
        } else if (actionMasked == 1 || actionMasked == 3 || actionMasked == 4) {
            J();
        }
        return super.dispatchTouchEvent(ev);
    }

    /* JADX INFO: renamed from: getIndicator, reason: from getter */
    public final t.v.c.widget.banner.indicator.a getMIndicator() {
        return this.mIndicator;
    }

    /* JADX INFO: renamed from: getScrollTime, reason: from getter */
    public final int getMScrollTime() {
        return this.mScrollTime;
    }

    /* JADX INFO: renamed from: getStartPosition, reason: from getter */
    public final int getMStartPosition() {
        return this.mStartPosition;
    }

    /* JADX INFO: renamed from: getViewPager2, reason: from getter */
    public final ViewPager2 getMViewPager2() {
        return this.mViewPager2;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0071  */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent event) {
        m.f(event, "event");
        ViewPager2 mViewPager2 = getMViewPager2();
        m.c(mViewPager2);
        if (!mViewPager2.isUserInputEnabled() || !this.isIntercept) {
            return super.onInterceptTouchEvent(event);
        }
        int action = event.getAction();
        boolean z10 = true;
        if (action == 0) {
            this.mStartX = event.getX();
            this.mStartY = event.getY();
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action == 1) {
            getParent().requestDisallowInterceptTouchEvent(false);
        } else if (action == 2) {
            float x10 = event.getX();
            float y10 = event.getY();
            float fAbs = Math.abs(x10 - this.mStartX);
            float fAbs2 = Math.abs(y10 - this.mStartY);
            ViewPager2 mViewPager3 = getMViewPager2();
            m.c(mViewPager3);
            if (mViewPager3.getOrientation() != 0 ? fAbs2 <= this.mTouchSlop || fAbs2 <= fAbs : fAbs <= this.mTouchSlop || fAbs <= fAbs2) {
                z10 = false;
            }
            this.mIsViewPager2Drag = z10;
            getParent().requestDisallowInterceptTouchEvent(this.mIsViewPager2Drag);
        } else if (action == 3) {
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        return super.onInterceptTouchEvent(event);
    }

    private final void F() {
        int i10 = 0;
        if (!getMIsInfiniteLoop()) {
            A(false);
        }
        if (getMIsInfiniteLoop()) {
            i10 = this.mStartPosition;
        }
        I(i10);
    }

    private final void H(int leftItemPadding, int rightItemPadding) {
        View childAt;
        ViewPager2 mViewPager2 = getMViewPager2();
        if (mViewPager2 != null) {
            childAt = mViewPager2.getChildAt(0);
        } else {
            childAt = null;
        }
        m.d(childAt, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) childAt;
        ViewPager2 mViewPager3 = getMViewPager2();
        if (mViewPager3 != null && mViewPager3.getOrientation() == 1) {
            ViewPager2 viewPager2 = this.mViewPager2;
            m.c(viewPager2);
            int paddingLeft = viewPager2.getPaddingLeft();
            ViewPager2 viewPager3 = this.mViewPager2;
            m.c(viewPager3);
            recyclerView.setPadding(paddingLeft, leftItemPadding, viewPager3.getPaddingRight(), rightItemPadding);
        } else {
            ViewPager2 viewPager4 = this.mViewPager2;
            m.c(viewPager4);
            int paddingTop = viewPager4.getPaddingTop();
            ViewPager2 viewPager5 = this.mViewPager2;
            m.c(viewPager5);
            recyclerView.setPadding(leftItemPadding, paddingTop, rightItemPadding, viewPager5.getPaddingBottom());
        }
        recyclerView.setClipToPadding(false);
    }

    private final void setRecyclerViewPadding(int itemPadding) {
        H(itemPadding, itemPadding);
    }

    private final void u(Canvas canvas) {
        float height = getHeight();
        Path path = new Path();
        path.moveTo(0.0f, height - this.mBannerRadius);
        path.lineTo(0.0f, height);
        path.lineTo(this.mBannerRadius, height);
        float f10 = 2;
        float f11 = this.mBannerRadius;
        path.arcTo(new RectF(0.0f, height - (f10 * f11), f11 * f10, height), 90.0f, 90.0f);
        path.close();
        Paint paint = this.mRoundPaint;
        m.c(paint);
        canvas.drawPath(path, paint);
    }

    private final void v(Canvas canvas) {
        float height = getHeight();
        float width = getWidth();
        Path path = new Path();
        path.moveTo(width - this.mBannerRadius, height);
        path.lineTo(width, height);
        path.lineTo(width, height - this.mBannerRadius);
        float f10 = 2;
        float f11 = this.mBannerRadius;
        path.arcTo(new RectF(width - (f10 * f11), height - (f10 * f11), width, height), 0.0f, 90.0f);
        path.close();
        Paint paint = this.mRoundPaint;
        m.c(paint);
        canvas.drawPath(path, paint);
    }

    private final void x(Canvas canvas) {
        float width = getWidth();
        Path path = new Path();
        path.moveTo(width - this.mBannerRadius, 0.0f);
        path.lineTo(width, 0.0f);
        path.lineTo(width, this.mBannerRadius);
        float f10 = 2;
        float f11 = this.mBannerRadius;
        path.arcTo(new RectF(width - (f10 * f11), 0.0f, width, f11 * f10), 0.0f, -90.0f);
        path.close();
        Paint paint = this.mRoundPaint;
        m.c(paint);
        canvas.drawPath(path, paint);
    }

    private final void y(Context context) {
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop() / 2;
        this.mCompositePageTransformer = new CompositePageTransformer();
        this.mPageChangeCallback = getBannerOnPageChangeCallback();
        this.mLoopTask = new a(this);
        ViewPager2 viewPager2 = new ViewPager2(context);
        this.mViewPager2 = viewPager2;
        m.c(viewPager2);
        viewPager2.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -1));
        ViewPager2 viewPager3 = this.mViewPager2;
        m.c(viewPager3);
        viewPager3.setOffscreenPageLimit(2);
        ViewPager2 viewPager4 = this.mViewPager2;
        m.c(viewPager4);
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.mPageChangeCallback;
        m.c(onPageChangeCallback);
        viewPager4.registerOnPageChangeCallback(onPageChangeCallback);
        ViewPager2 viewPager5 = this.mViewPager2;
        m.c(viewPager5);
        viewPager5.setPageTransformer(this.mCompositePageTransformer);
        ScrollSpeedManger.n(this);
        addView(this.mViewPager2);
        Paint paint = new Paint();
        this.mRoundPaint = paint;
        m.c(paint);
        paint.setColor(-1);
        Paint paint2 = this.mRoundPaint;
        m.c(paint2);
        paint2.setAntiAlias(true);
        Paint paint3 = this.mRoundPaint;
        m.c(paint3);
        paint3.setStyle(Paint.Style.FILL);
        Paint paint4 = this.mRoundPaint;
        m.c(paint4);
        paint4.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        Paint paint5 = new Paint();
        this.mImagePaint = paint5;
        m.c(paint5);
        paint5.setXfermode(null);
    }

    public final Banner<T, BA> D(int position, boolean smoothScroll) {
        ViewPager2 mViewPager2 = getMViewPager2();
        if (mViewPager2 != null) {
            mViewPager2.setCurrentItem(position, smoothScroll);
        }
        return this;
    }

    public final Banner<T, BA> E() {
        Integer currentItem;
        t.v.c.widget.banner.indicator.a mIndicator = getMIndicator();
        if (mIndicator != null && (currentItem = getCurrentItem()) != null) {
            mIndicator.onPageChanged(getRealCount(), dg.a.b(getMIsInfiniteLoop(), currentItem.intValue(), getRealCount()));
        }
        return this;
    }

    public final Banner<T, BA> G(int orientation) {
        ViewPager2 mViewPager2 = getMViewPager2();
        if (mViewPager2 != null) {
            mViewPager2.setOrientation(orientation);
        }
        return this;
    }

    public final Integer getCurrentItem() {
        ViewPager2 mViewPager2 = getMViewPager2();
        if (mViewPager2 != null) {
            return Integer.valueOf(mViewPager2.getCurrentItem());
        }
        return null;
    }

    public final b getIndicatorConfig() {
        t.v.c.widget.banner.indicator.a mIndicator = getMIndicator();
        if (mIndicator != null) {
            return mIndicator.getIndicatorConfig();
        }
        return null;
    }

    public final int getItemCount() {
        getAdapter();
        return 0;
    }

    public final int getRealCount() {
        getAdapter();
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        J();
    }

    @Override // androidx.p000lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
        androidx.p000lifecycle.c.a(this, lifecycleOwner);
    }

    @Override // androidx.p000lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onDestroy(LifecycleOwner lifecycleOwner) {
        androidx.p000lifecycle.c.b(this, lifecycleOwner);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        K();
    }

    @Override // androidx.p000lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
        androidx.p000lifecycle.c.c(this, lifecycleOwner);
    }

    @Override // androidx.p000lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onResume(LifecycleOwner lifecycleOwner) {
        androidx.p000lifecycle.c.d(this, lifecycleOwner);
    }

    @Override // androidx.p000lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
        androidx.p000lifecycle.c.e(this, lifecycleOwner);
    }

    @Override // androidx.p000lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
        androidx.p000lifecycle.c.f(this, lifecycleOwner);
    }

    public final void t() {
        ViewPager2.OnPageChangeCallback onPageChangeCallback;
        ViewPager2 mViewPager2 = getMViewPager2();
        if (mViewPager2 != null && (onPageChangeCallback = this.mPageChangeCallback) != null) {
            mViewPager2.unregisterOnPageChangeCallback(onPageChangeCallback);
            this.mPageChangeCallback = null;
        }
        K();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Banner(Context context, AttributeSet attrs) {
        super(context, attrs);
        m.f(context, "context");
        m.f(attrs, "attrs");
        this.mIsInfiniteLoop = true;
        this.mIsAutoLoop = true;
        this.mLoopTime = 3000L;
        this.mScrollTime = 600;
        this.mStartPosition = 1;
        this.normalWidth = bg.a.f1074a;
        this.selectedWidth = bg.a.f1075b;
        this.normalColor = BannerConfig.INDICATOR_NORMAL_COLOR;
        this.selectedColor = BannerConfig.INDICATOR_SELECTED_COLOR;
        this.indicatorGravity = 1;
        this.indicatorHeight = bg.a.f1078e;
        this.indicatorRadius = bg.a.f1079f;
        this.isIntercept = true;
        this.mAdapterDataObserver = new d(this);
        y(context);
        z(context, attrs);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Banner(Context context, AttributeSet attrs, int i10) {
        super(context, attrs, i10);
        m.f(context, "context");
        m.f(attrs, "attrs");
        this.mIsInfiniteLoop = true;
        this.mIsAutoLoop = true;
        this.mLoopTime = 3000L;
        this.mScrollTime = 600;
        this.mStartPosition = 1;
        this.normalWidth = bg.a.f1074a;
        this.selectedWidth = bg.a.f1075b;
        this.normalColor = BannerConfig.INDICATOR_NORMAL_COLOR;
        this.selectedColor = BannerConfig.INDICATOR_SELECTED_COLOR;
        this.indicatorGravity = 1;
        this.indicatorHeight = bg.a.f1078e;
        this.indicatorRadius = bg.a.f1079f;
        this.isIntercept = true;
        this.mAdapterDataObserver = new d(this);
        y(context);
        z(context, attrs);
    }
}
