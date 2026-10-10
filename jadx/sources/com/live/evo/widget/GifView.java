package com.live.evo.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import com.live.evo.R$style;
import com.live.evo.R$styleable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class GifView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f7450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Movie f7451b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f7452c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f7453d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f7454e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f7455f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f7456g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f7457h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f7458i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private volatile boolean f7459j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f7460k;

    public GifView(Context context) {
        this(context, null);
    }

    @SuppressLint({"NewApi"})
    private void c(Context context, AttributeSet attributeSet, int i10) {
        setLayerType(1, null);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.GifMoviewView, i10, R$style.Widget_GifMoviewView);
        this.f7450a = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        this.f7459j = typedArrayObtainStyledAttributes.getBoolean(1, false);
        typedArrayObtainStyledAttributes.recycle();
        if (this.f7450a != -1) {
            this.f7451b = Movie.decodeStream(getResources().openRawResource(this.f7450a));
        }
    }

    public GifView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(Canvas canvas) {
        this.f7451b.setTime(this.f7453d);
        canvas.save();
        float f10 = this.f7456g;
        canvas.scale(f10, f10);
        Movie movie = this.f7451b;
        float f11 = this.f7454e;
        float f12 = this.f7456g;
        movie.draw(canvas, f11 / f12, this.f7455f / f12);
        canvas.restore();
    }

    @SuppressLint({"NewApi"})
    private void b() {
        if (this.f7460k) {
            postInvalidateOnAnimation();
        }
    }

    public Movie getMovie() {
        return this.f7451b;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f7451b != null) {
            if (this.f7459j) {
                a(canvas);
                return;
            }
            d();
            a(canvas);
            b();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        int size;
        int size2;
        Movie movie = this.f7451b;
        if (movie == null) {
            setMeasuredDimension(getSuggestedMinimumWidth(), getSuggestedMinimumHeight());
            return;
        }
        int iWidth = movie.width();
        int iHeight = this.f7451b.height();
        float fMax = 1.0f / Math.max((View.MeasureSpec.getMode(i10) == 0 || iWidth <= (size2 = View.MeasureSpec.getSize(i10))) ? 1.0f : iWidth / size2, (View.MeasureSpec.getMode(i11) == 0 || iHeight <= (size = View.MeasureSpec.getSize(i11))) ? 1.0f : iHeight / size);
        this.f7456g = fMax;
        int i12 = (int) (iWidth * fMax);
        this.f7457h = i12;
        int i13 = (int) (iHeight * fMax);
        this.f7458i = i13;
        setMeasuredDimension(i12, i13);
    }

    public void setMovie(Movie movie) {
        this.f7451b = movie;
        requestLayout();
    }

    public void setMovieResource(int i10) {
        this.f7450a = i10;
        this.f7451b = Movie.decodeStream(getResources().openRawResource(this.f7450a));
        requestLayout();
    }

    public void setMovieTime(int i10) {
        this.f7453d = i10;
        invalidate();
    }

    public void setPaused(boolean z10) {
        this.f7459j = z10;
        if (!z10) {
            this.f7452c = SystemClock.uptimeMillis() - ((long) this.f7453d);
        }
        invalidate();
    }

    public GifView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f7453d = 0;
        this.f7459j = false;
        this.f7460k = true;
        c(context, attributeSet, i10);
    }

    private void d() {
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (this.f7452c == 0) {
            this.f7452c = jUptimeMillis;
        }
        int iDuration = this.f7451b.duration();
        if (iDuration == 0) {
            iDuration = 1000;
        }
        this.f7453d = (int) ((jUptimeMillis - this.f7452c) % ((long) iDuration));
    }

    @Override // android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        boolean z11;
        super.onLayout(z10, i10, i11, i12, i13);
        this.f7454e = (getWidth() - this.f7457h) / 2.0f;
        this.f7455f = (getHeight() - this.f7458i) / 2.0f;
        if (getVisibility() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        this.f7460k = z11;
    }

    @Override // android.view.View
    @SuppressLint({"NewApi"})
    public void onScreenStateChanged(int i10) {
        super.onScreenStateChanged(i10);
        boolean z10 = true;
        if (i10 != 1) {
            z10 = false;
        }
        this.f7460k = z10;
        b();
    }

    @Override // android.view.View
    @SuppressLint({"NewApi"})
    protected void onVisibilityChanged(View view, int i10) {
        boolean z10;
        super.onVisibilityChanged(view, i10);
        if (i10 == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f7460k = z10;
        b();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i10) {
        boolean z10;
        super.onWindowVisibilityChanged(i10);
        if (i10 == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f7460k = z10;
        b();
    }
}
