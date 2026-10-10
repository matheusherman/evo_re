package t.v.c.s.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import t.v.c.widget.TextView;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB%\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\fH\u0014¢\u0006\u0004\b\u0012\u0010\u000eR\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0082D¢\u0006\u0006\n\u0004\b\r\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u000f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Lt/v/c/s/widget/SimpleSubtitleView;", "Lt/v/c/widget/TextView;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lr8/z;", "c", "()V", "Lyf/a;", "getSubtitleHandler", "()Lyf/a;", "onDetachedFromWindow", "", "Ljava/lang/String;", "EMPTY_TEXT", "", "d", "F", "mStrokeWidth", "e", "I", "mStrokeColor", "f", "Lyf/a;", "subtitleViewHandler", "tvcbaselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SimpleSubtitleView extends TextView {

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final String EMPTY_TEXT;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private float mStrokeWidth;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int mStrokeColor;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private yf.a subtitleViewHandler;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"t/v/c/s/widget/SimpleSubtitleView$a", "Lyf/a;", "", "text", "Lr8/z;", "c", "(Ljava/lang/CharSequence;)V", "tvcbaselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a extends yf.a {
        a() {
        }

        @Override // yf.a
        public void c(CharSequence text) {
            m.f(text, "text");
            SimpleSubtitleView.this.setText(text);
        }
    }

    public SimpleSubtitleView(Context context) {
        super(context);
        this.EMPTY_TEXT = "";
        this.mStrokeWidth = 3.0f;
        this.mStrokeColor = Color.parseColor("#000000");
        c();
    }

    private final void c() {
        this.subtitleViewHandler = new a();
    }

    public final yf.a getSubtitleHandler() {
        yf.a aVar = this.subtitleViewHandler;
        if (aVar != null) {
            return aVar;
        }
        m.v("subtitleViewHandler");
        return null;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.view.View
    protected void onDetachedFromWindow() {
        yf.a aVar = this.subtitleViewHandler;
        if (aVar == null) {
            m.v("subtitleViewHandler");
            aVar = null;
        }
        aVar.destroy();
        super.onDetachedFromWindow();
    }

    public SimpleSubtitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.EMPTY_TEXT = "";
        this.mStrokeWidth = 3.0f;
        this.mStrokeColor = Color.parseColor("#000000");
        c();
    }

    public SimpleSubtitleView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.EMPTY_TEXT = "";
        this.mStrokeWidth = 3.0f;
        this.mStrokeColor = Color.parseColor("#000000");
        c();
    }
}
