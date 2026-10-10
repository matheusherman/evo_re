package t.v.c.widget.videoview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.ISurfaceTextureHolder;
import x1.f1.lb.widget.videoview.c;
import x1.f1.lb.widget.videoview.d;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class SurfaceRenderView extends SurfaceView implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final q6.b f18834a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ag.a f18835b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private b f18836c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f18837d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AtomicInteger f18838e;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    final class a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final SurfaceRenderView f18839a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final SurfaceHolder f18840b;

        public a(SurfaceRenderView surfaceRenderView, SurfaceHolder surfaceHolder) {
            this.f18839a = surfaceRenderView;
            this.f18840b = surfaceHolder;
        }

        @Override // x1.f1.lb.widget.videoview.d
        @NonNull
        public c a() {
            return this.f18839a;
        }

        @Override // x1.f1.lb.widget.videoview.d
        public void b(IMediaPlayer iMediaPlayer) {
            if (iMediaPlayer == null || this.f18840b == null) {
                return;
            }
            if (iMediaPlayer instanceof ISurfaceTextureHolder) {
                ((ISurfaceTextureHolder) iMediaPlayer).setSurfaceTexture(null);
            }
            SurfaceRenderView.this.setZOrderOnTop(true);
            SurfaceRenderView.this.setZOrderMediaOverlay(true);
            iMediaPlayer.setDisplay(this.f18840b);
        }

        @Override // x1.f1.lb.widget.videoview.d
        public SurfaceHolder c() {
            return this.f18840b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    final class b implements SurfaceHolder.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private SurfaceHolder f18842a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f18843b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f18844c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f18845d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f18846e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final WeakReference<SurfaceRenderView> f18847f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final Map<x1.f1.lb.widget.videoview.b, x1.f1.lb.widget.videoview.b> f18848g = new ConcurrentHashMap();

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            this.f18842a = null;
            this.f18843b = false;
            this.f18844c = 0;
            this.f18845d = 0;
            this.f18846e = 0;
            a aVar = SurfaceRenderView.this.new a(this.f18847f.get(), this.f18842a);
            Iterator<x1.f1.lb.widget.videoview.b> it = this.f18848g.keySet().iterator();
            while (it.hasNext()) {
                it.next().c(aVar);
            }
        }

        public b(SurfaceRenderView surfaceRenderView) {
            this.f18847f = new WeakReference<>(surfaceRenderView);
        }

        public void a(@NonNull x1.f1.lb.widget.videoview.b bVar) {
            a aVar;
            this.f18848g.put(bVar, bVar);
            if (this.f18842a != null) {
                aVar = SurfaceRenderView.this.new a(this.f18847f.get(), this.f18842a);
                bVar.b(aVar, this.f18845d, this.f18846e);
            } else {
                aVar = null;
            }
            if (this.f18843b) {
                if (aVar == null) {
                    aVar = SurfaceRenderView.this.new a(this.f18847f.get(), this.f18842a);
                }
                bVar.a(aVar, this.f18844c, this.f18845d, this.f18846e);
            }
        }

        public void b(x1.f1.lb.widget.videoview.b bVar) {
            this.f18848g.remove(bVar);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i10, int i11, int i12) {
            this.f18842a = surfaceHolder;
            this.f18843b = true;
            this.f18844c = i10;
            this.f18845d = i11;
            this.f18846e = i12;
            a aVar = SurfaceRenderView.this.new a(this.f18847f.get(), this.f18842a);
            Iterator<x1.f1.lb.widget.videoview.b> it = this.f18848g.keySet().iterator();
            while (it.hasNext()) {
                it.next().a(aVar, i10, i11, i12);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            this.f18842a = surfaceHolder;
            this.f18843b = false;
            this.f18844c = 0;
            this.f18845d = 0;
            this.f18846e = 0;
            a aVar = SurfaceRenderView.this.new a(this.f18847f.get(), this.f18842a);
            Iterator<x1.f1.lb.widget.videoview.b> it = this.f18848g.keySet().iterator();
            while (it.hasNext()) {
                it.next().b(aVar, 0, 0);
            }
        }
    }

    public SurfaceRenderView(Context context) {
        super(context);
        this.f18834a = q6.c.d(SurfaceRenderView.class);
        this.f18838e = new AtomicInteger(0);
        e(context);
    }

    private void e(Context context) {
        this.f18835b = new ag.a(this);
        this.f18836c = new b(this);
        getHolder().addCallback(this.f18836c);
    }

    @Override // x1.f1.lb.widget.videoview.c
    public void a(int i10, int i11) {
        if (i10 <= 0 || i11 <= 0) {
            return;
        }
        this.f18835b.g(i10, i11);
        getHolder().setFixedSize(i10, i11);
        requestLayout();
        invalidate();
    }

    @Override // x1.f1.lb.widget.videoview.c
    public void b(int i10, int i11) {
        if (i10 <= 0 || i11 <= 0) {
            return;
        }
        this.f18835b.f(i10, i11);
        requestLayout();
    }

    @Override // x1.f1.lb.widget.videoview.c
    public void c(x1.f1.lb.widget.videoview.b bVar) {
        this.f18836c.b(bVar);
    }

    @Override // x1.f1.lb.widget.videoview.c
    public void d(x1.f1.lb.widget.videoview.b bVar) {
        this.f18836c.a(bVar);
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onMeasure(int i10, int i11) {
        this.f18835b.a(i10, i11);
        setMeasuredDimension(this.f18835b.c(), this.f18835b.b());
    }

    @Override // x1.f1.lb.widget.videoview.c
    public void setAspectRatio(int i10) {
        this.f18835b.d(i10);
        requestLayout();
        invalidate();
    }

    public void setVideoRotation(int i10) {
        this.f18835b.e(i10);
        requestLayout();
    }

    public void setVideoView(View view) {
        this.f18837d = view;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(SurfaceRenderView.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(SurfaceRenderView.class.getName());
    }

    public SurfaceRenderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18834a = q6.c.d(SurfaceRenderView.class);
        this.f18838e = new AtomicInteger(0);
        e(context);
    }

    public SurfaceRenderView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f18834a = q6.c.d(SurfaceRenderView.class);
        this.f18838e = new AtomicInteger(0);
        e(context);
    }

    @Override // x1.f1.lb.widget.videoview.c
    public View getView() {
        return this;
    }
}
