package com.journeyapps.barcodescanner;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.core.view.ViewCompat;
import com.google.zxing.client.android.R$id;
import com.google.zxing.client.android.R$styleable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import m4.n;
import m4.o;
import m4.p;
import m4.r;
import n4.g;
import n4.i;
import n4.j;
import n4.l;
import n4.m;
import n4.q;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class CameraPreview extends ViewGroup {
    private static final String A = "CameraPreview";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private g f4945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private WindowManager f4946b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Handler f4947c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f4948d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private SurfaceView f4949e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private TextureView f4950f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f4951g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private o f4952h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f4953i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private List<f> f4954j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private m f4955k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private i f4956l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private p f4957m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private p f4958n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private Rect f4959o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private p f4960p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Rect f4961q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private Rect f4962r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private p f4963s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private double f4964t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private q f4965u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f4966v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final SurfaceHolder.Callback f4967w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final Handler.Callback f4968x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private n f4969y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final f f4970z;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements TextureView.SurfaceTextureListener {
        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return false;
        }

        a() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i10, int i11) {
            CameraPreview.this.f4960p = new p(i10, i11);
            CameraPreview.this.C();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i10, int i11) {
            onSurfaceTextureSizeChanged(surfaceTexture, i10, i11);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b implements SurfaceHolder.Callback {
        b() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i10, int i11, int i12) {
            if (surfaceHolder == null) {
                Log.e(CameraPreview.A, "*** WARNING *** surfaceChanged() gave us a null surface!");
                return;
            }
            CameraPreview.this.f4960p = new p(i11, i12);
            CameraPreview.this.C();
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            CameraPreview.this.f4960p = null;
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class c implements Handler.Callback {
        c() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == R$id.zxing_prewiew_size_ready) {
                CameraPreview.this.w((p) message.obj);
                return true;
            }
            if (i10 != R$id.zxing_camera_error) {
                if (i10 != R$id.zxing_camera_closed) {
                    return false;
                }
                CameraPreview.this.f4970z.d();
                return false;
            }
            Exception exc = (Exception) message.obj;
            if (!CameraPreview.this.r()) {
                return false;
            }
            CameraPreview.this.u();
            CameraPreview.this.f4970z.b(exc);
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class d implements n {
        d() {
        }

        @Override // m4.n
        public void a(int i10) {
            CameraPreview.this.f4947c.postDelayed(new Runnable() { // from class: com.journeyapps.barcodescanner.a
                @Override // java.lang.Runnable
                public final void run() {
                    CameraPreview.this.z();
                }
            }, 250L);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class e implements f {
        e() {
        }

        @Override // com.journeyapps.barcodescanner.CameraPreview.f
        public void a() {
            Iterator it = CameraPreview.this.f4954j.iterator();
            while (it.hasNext()) {
                ((f) it.next()).a();
            }
        }

        @Override // com.journeyapps.barcodescanner.CameraPreview.f
        public void b(Exception exc) {
            Iterator it = CameraPreview.this.f4954j.iterator();
            while (it.hasNext()) {
                ((f) it.next()).b(exc);
            }
        }

        @Override // com.journeyapps.barcodescanner.CameraPreview.f
        public void c() {
            Iterator it = CameraPreview.this.f4954j.iterator();
            while (it.hasNext()) {
                ((f) it.next()).c();
            }
        }

        @Override // com.journeyapps.barcodescanner.CameraPreview.f
        public void d() {
            Iterator it = CameraPreview.this.f4954j.iterator();
            while (it.hasNext()) {
                ((f) it.next()).d();
            }
        }

        @Override // com.journeyapps.barcodescanner.CameraPreview.f
        public void e() {
            Iterator it = CameraPreview.this.f4954j.iterator();
            while (it.hasNext()) {
                ((f) it.next()).e();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface f {
        void a();

        void b(Exception exc);

        void c();

        void d();

        void e();
    }

    public CameraPreview(Context context) {
        super(context);
        this.f4948d = false;
        this.f4951g = false;
        this.f4953i = -1;
        this.f4954j = new ArrayList();
        this.f4956l = new i();
        this.f4961q = null;
        this.f4962r = null;
        this.f4963s = null;
        this.f4964t = 0.1d;
        this.f4965u = null;
        this.f4966v = false;
        this.f4967w = new b();
        this.f4968x = new c();
        this.f4969y = new d();
        this.f4970z = new e();
        p(context, null, 0, 0);
    }

    private void A() {
        if (this.f4948d) {
            TextureView textureView = new TextureView(getContext());
            this.f4950f = textureView;
            textureView.setSurfaceTextureListener(D());
            addView(this.f4950f);
            return;
        }
        SurfaceView surfaceView = new SurfaceView(getContext());
        this.f4949e = surfaceView;
        surfaceView.getHolder().addCallback(this.f4967w);
        addView(this.f4949e);
    }

    private void B(j jVar) {
        if (this.f4951g || this.f4945a == null) {
            return;
        }
        Log.i(A, "Starting preview");
        this.f4945a.w(jVar);
        this.f4945a.y();
        this.f4951g = true;
        x();
        this.f4970z.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        Rect rect;
        p pVar = this.f4960p;
        if (pVar == null || this.f4958n == null || (rect = this.f4959o) == null) {
            return;
        }
        if (this.f4949e != null && pVar.equals(new p(rect.width(), this.f4959o.height()))) {
            B(new j(this.f4949e.getHolder()));
            return;
        }
        TextureView textureView = this.f4950f;
        if (textureView == null || textureView.getSurfaceTexture() == null) {
            return;
        }
        if (this.f4958n != null) {
            this.f4950f.setTransform(l(new p(this.f4950f.getWidth(), this.f4950f.getHeight()), this.f4958n));
        }
        B(new j(this.f4950f.getSurfaceTexture()));
    }

    @TargetApi(14)
    private TextureView.SurfaceTextureListener D() {
        return new a();
    }

    private int getDisplayRotation() {
        return this.f4946b.getDefaultDisplay().getRotation();
    }

    private void j() {
        p pVar;
        m mVar;
        p pVar2 = this.f4957m;
        if (pVar2 == null || (pVar = this.f4958n) == null || (mVar = this.f4955k) == null) {
            this.f4962r = null;
            this.f4961q = null;
            this.f4959o = null;
            throw new IllegalStateException("containerSize or previewSize is not set yet");
        }
        int i10 = pVar.f15654a;
        int i11 = pVar.f15655b;
        int i12 = pVar2.f15654a;
        int i13 = pVar2.f15655b;
        Rect rectD = mVar.d(pVar);
        if (rectD.width() <= 0 || rectD.height() <= 0) {
            return;
        }
        this.f4959o = rectD;
        this.f4961q = k(new Rect(0, 0, i12, i13), this.f4959o);
        Rect rect = new Rect(this.f4961q);
        Rect rect2 = this.f4959o;
        rect.offset(-rect2.left, -rect2.top);
        Rect rect3 = new Rect((rect.left * i10) / this.f4959o.width(), (rect.top * i11) / this.f4959o.height(), (rect.right * i10) / this.f4959o.width(), (rect.bottom * i11) / this.f4959o.height());
        this.f4962r = rect3;
        if (rect3.width() > 0 && this.f4962r.height() > 0) {
            this.f4970z.a();
            return;
        }
        this.f4962r = null;
        this.f4961q = null;
        Log.w(A, "Preview frame is too small");
    }

    private void m(p pVar) {
        this.f4957m = pVar;
        g gVar = this.f4945a;
        if (gVar == null || gVar.n() != null) {
            return;
        }
        m mVar = new m(getDisplayRotation(), pVar);
        this.f4955k = mVar;
        mVar.e(getPreviewScalingStrategy());
        this.f4945a.u(this.f4955k);
        this.f4945a.m();
        boolean z10 = this.f4966v;
        if (z10) {
            this.f4945a.x(z10);
        }
    }

    private void o() {
        if (this.f4945a != null) {
            Log.w(A, "initCamera called twice");
            return;
        }
        g gVarN = n();
        this.f4945a = gVarN;
        gVarN.v(this.f4947c);
        this.f4945a.r();
        this.f4953i = getDisplayRotation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(p pVar) {
        this.f4958n = pVar;
        if (this.f4957m != null) {
            j();
            requestLayout();
            C();
        }
    }

    public g getCameraInstance() {
        return this.f4945a;
    }

    public i getCameraSettings() {
        return this.f4956l;
    }

    public Rect getFramingRect() {
        return this.f4961q;
    }

    public p getFramingRectSize() {
        return this.f4963s;
    }

    public double getMarginFraction() {
        return this.f4964t;
    }

    public Rect getPreviewFramingRect() {
        return this.f4962r;
    }

    public q getPreviewScalingStrategy() {
        q qVar = this.f4965u;
        if (qVar != null) {
            return qVar;
        }
        return this.f4950f != null ? new l() : new n4.n();
    }

    public p getPreviewSize() {
        return this.f4958n;
    }

    public void i(f fVar) {
        this.f4954j.add(fVar);
    }

    protected Rect k(Rect rect, Rect rect2) {
        Rect rect3 = new Rect(rect);
        rect3.intersect(rect2);
        if (this.f4963s != null) {
            rect3.inset(Math.max(0, (rect3.width() - this.f4963s.f15654a) / 2), Math.max(0, (rect3.height() - this.f4963s.f15655b) / 2));
            return rect3;
        }
        int iMin = (int) Math.min(((double) rect3.width()) * this.f4964t, ((double) rect3.height()) * this.f4964t);
        rect3.inset(iMin, iMin);
        if (rect3.height() > rect3.width()) {
            rect3.inset(0, (rect3.height() - rect3.width()) / 2);
        }
        return rect3;
    }

    protected Matrix l(p pVar, p pVar2) {
        float f10;
        float f11 = pVar.f15654a / pVar.f15655b;
        float f12 = pVar2.f15654a / pVar2.f15655b;
        float f13 = 1.0f;
        if (f11 < f12) {
            f13 = f12 / f11;
            f10 = 1.0f;
        } else {
            f10 = f11 / f12;
        }
        Matrix matrix = new Matrix();
        matrix.setScale(f13, f10);
        int i10 = pVar.f15654a;
        int i11 = pVar.f15655b;
        matrix.postTranslate((i10 - (i10 * f13)) / 2.0f, (i11 - (i11 * f10)) / 2.0f);
        return matrix;
    }

    protected g n() {
        g gVar = new g(getContext());
        gVar.t(this.f4956l);
        return gVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        m(new p(i12 - i10, i13 - i11));
        SurfaceView surfaceView = this.f4949e;
        if (surfaceView == null) {
            TextureView textureView = this.f4950f;
            if (textureView != null) {
                textureView.layout(0, 0, getWidth(), getHeight());
                return;
            }
            return;
        }
        Rect rect = this.f4959o;
        if (rect == null) {
            surfaceView.layout(0, 0, getWidth(), getHeight());
        } else {
            surfaceView.layout(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        super.onRestoreInstanceState(bundle.getParcelable("super"));
        setTorch(bundle.getBoolean("torch"));
    }

    protected boolean r() {
        return this.f4945a != null;
    }

    public boolean s() {
        g gVar = this.f4945a;
        return gVar == null || gVar.p();
    }

    public void setCameraSettings(i iVar) {
        this.f4956l = iVar;
    }

    public void setFramingRectSize(p pVar) {
        this.f4963s = pVar;
    }

    public void setMarginFraction(double d10) {
        if (d10 >= 0.5d) {
            throw new IllegalArgumentException("The margin fraction must be less than 0.5");
        }
        this.f4964t = d10;
    }

    public void setPreviewScalingStrategy(q qVar) {
        this.f4965u = qVar;
    }

    public void setTorch(boolean z10) {
        this.f4966v = z10;
        g gVar = this.f4945a;
        if (gVar != null) {
            gVar.x(z10);
        }
    }

    public void setUseTextureView(boolean z10) {
        this.f4948d = z10;
    }

    public boolean t() {
        return this.f4951g;
    }

    private void p(Context context, AttributeSet attributeSet, int i10, int i11) {
        if (getBackground() == null) {
            setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        q(attributeSet);
        this.f4946b = (WindowManager) context.getSystemService("window");
        this.f4947c = new Handler(this.f4968x);
        this.f4952h = new o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        if (r() && getDisplayRotation() != this.f4953i) {
            u();
            y();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        A();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        Bundle bundle = new Bundle();
        bundle.putParcelable("super", parcelableOnSaveInstanceState);
        bundle.putBoolean("torch", this.f4966v);
        return bundle;
    }

    protected void q(AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.zxing_camera_preview);
        int dimension = (int) typedArrayObtainStyledAttributes.getDimension(R$styleable.zxing_camera_preview_zxing_framing_rect_width, -1.0f);
        int dimension2 = (int) typedArrayObtainStyledAttributes.getDimension(R$styleable.zxing_camera_preview_zxing_framing_rect_height, -1.0f);
        if (dimension > 0 && dimension2 > 0) {
            this.f4963s = new p(dimension, dimension2);
        }
        this.f4948d = typedArrayObtainStyledAttributes.getBoolean(R$styleable.zxing_camera_preview_zxing_use_texture_view, true);
        int integer = typedArrayObtainStyledAttributes.getInteger(R$styleable.zxing_camera_preview_zxing_preview_scaling_strategy, -1);
        if (integer == 1) {
            this.f4965u = new l();
        } else if (integer == 2) {
            this.f4965u = new n4.n();
        } else if (integer == 3) {
            this.f4965u = new n4.o();
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public void u() {
        TextureView textureView;
        SurfaceView surfaceView;
        r.a();
        Log.d(A, "pause()");
        this.f4953i = -1;
        g gVar = this.f4945a;
        if (gVar != null) {
            gVar.l();
            this.f4945a = null;
            this.f4951g = false;
        } else {
            this.f4947c.sendEmptyMessage(R$id.zxing_camera_closed);
        }
        if (this.f4960p == null && (surfaceView = this.f4949e) != null) {
            surfaceView.getHolder().removeCallback(this.f4967w);
        }
        if (this.f4960p == null && (textureView = this.f4950f) != null) {
            textureView.setSurfaceTextureListener(null);
        }
        this.f4957m = null;
        this.f4958n = null;
        this.f4962r = null;
        this.f4952h.f();
        this.f4970z.c();
    }

    public void v() {
        g cameraInstance = getCameraInstance();
        u();
        long jNanoTime = System.nanoTime();
        while (cameraInstance != null && !cameraInstance.p() && System.nanoTime() - jNanoTime <= 2000000000) {
            try {
                Thread.sleep(1L);
            } catch (InterruptedException unused) {
                return;
            }
        }
    }

    public void y() {
        r.a();
        Log.d(A, "resume()");
        o();
        if (this.f4960p != null) {
            C();
        } else {
            SurfaceView surfaceView = this.f4949e;
            if (surfaceView != null) {
                surfaceView.getHolder().addCallback(this.f4967w);
            } else {
                TextureView textureView = this.f4950f;
                if (textureView != null) {
                    if (textureView.isAvailable()) {
                        D().onSurfaceTextureAvailable(this.f4950f.getSurfaceTexture(), this.f4950f.getWidth(), this.f4950f.getHeight());
                    } else {
                        this.f4950f.setSurfaceTextureListener(D());
                    }
                }
            }
        }
        requestLayout();
        this.f4952h.e(getContext(), this.f4969y);
    }

    public CameraPreview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4948d = false;
        this.f4951g = false;
        this.f4953i = -1;
        this.f4954j = new ArrayList();
        this.f4956l = new i();
        this.f4961q = null;
        this.f4962r = null;
        this.f4963s = null;
        this.f4964t = 0.1d;
        this.f4965u = null;
        this.f4966v = false;
        this.f4967w = new b();
        this.f4968x = new c();
        this.f4969y = new d();
        this.f4970z = new e();
        p(context, attributeSet, 0, 0);
    }

    protected void x() {
    }

    public CameraPreview(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f4948d = false;
        this.f4951g = false;
        this.f4953i = -1;
        this.f4954j = new ArrayList();
        this.f4956l = new i();
        this.f4961q = null;
        this.f4962r = null;
        this.f4963s = null;
        this.f4964t = 0.1d;
        this.f4965u = null;
        this.f4966v = false;
        this.f4967w = new b();
        this.f4968x = new c();
        this.f4969y = new d();
        this.f4970z = new e();
        p(context, attributeSet, i10, 0);
    }
}
