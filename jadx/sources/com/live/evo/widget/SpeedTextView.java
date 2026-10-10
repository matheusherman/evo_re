package com.live.evo.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.appcompat.widget.AppCompatTextView;
import com.live.evo.MyApplication;
import com.live.evo.util.k1;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class SpeedTextView extends AppCompatTextView implements View.OnClickListener {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static int f7549q = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final q6.b f7550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f7551b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f7552c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f7553d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f7554e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f7555f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f7556g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f7557h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Paint f7558i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f7559j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f7560k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f7561l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f7562m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f7563n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private Timer f7564o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private TimerTask f7565p;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a extends TimerTask {

        /* JADX INFO: renamed from: com.live.evo.widget.SpeedTextView$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        class RunnableC0115a implements Runnable {
            RunnableC0115a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SpeedTextView.this.invalidate();
            }
        }

        a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            k1.f7250a.c(new RunnableC0115a());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface b {
    }

    public void d() {
        this.f7557h = false;
        TimerTask timerTask = this.f7565p;
        if (timerTask != null) {
            timerTask.cancel();
        }
        invalidate();
    }

    @Override // android.view.View
    public boolean isFocused() {
        return true;
    }

    public static int getSpeed() {
        return f7549q;
    }

    public void b() {
        setGravity(16);
        TextPaint paint = getPaint();
        this.f7558i = paint;
        paint.setColor(this.f7560k);
        this.f7559j = getText().toString();
        this.f7558i.setTextSize(this.f7561l);
        this.f7551b = this.f7558i.measureText(this.f7559j);
        float width = getWidth();
        this.f7552c = width;
        this.f7553d = this.f7551b;
        if (width == 0.0f) {
            this.f7552c = MyApplication.a().getResources().getDisplayMetrics().widthPixels;
        }
        float f10 = this.f7552c;
        float f11 = this.f7551b;
        this.f7555f = f10 + f11;
        this.f7556g = f10 + (f11 * 2.0f);
        this.f7554e = getTextSize() + getPaddingTop();
    }

    public void c() {
        if (this.f7557h) {
            return;
        }
        b();
        this.f7557h = true;
        invalidate();
        setHeight((int) (((double) this.f7561l) * 1.5d));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f7557h) {
            d();
        } else {
            c();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        Paint paint = this.f7558i;
        if (paint == null) {
            return;
        }
        canvas.drawText(this.f7559j, this.f7555f - this.f7553d, this.f7554e, paint);
        float speed = this.f7553d + getSpeed();
        this.f7553d = speed;
        int i10 = this.f7562m;
        if (i10 <= 0) {
            return;
        }
        if (speed > this.f7556g) {
            this.f7553d = this.f7551b;
            this.f7562m = i10 - 1;
            if (!this.f7557h) {
                return;
            }
            if (this.f7563n > 0) {
                a aVar = new a();
                this.f7565p = aVar;
                this.f7564o.schedule(aVar, this.f7563n);
                return;
            }
        }
        invalidate();
    }

    public void setDisplayTimes(int i10) {
        this.f7562m = i10;
    }

    public void setInterval(int i10) {
        this.f7563n = i10;
    }

    public void setSpeed(int i10) {
        f7549q = i10;
    }

    @Override // android.widget.TextView
    public void setTextColor(@ColorInt int i10) {
        this.f7560k = i10;
        super.setTextColor(i10);
    }

    @Override // android.widget.TextView
    public void setTextSize(float f10) {
        this.f7561l = f10;
        super.setTextSize(f10);
    }

    public SpeedTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7550a = q6.c.d(SpeedTextView.class);
        this.f7551b = 0.0f;
        this.f7552c = 0.0f;
        this.f7553d = 0.0f;
        this.f7554e = 0.0f;
        this.f7555f = 0.0f;
        this.f7556g = 0.0f;
        this.f7557h = false;
        this.f7558i = null;
        this.f7559j = "";
        this.f7560k = Color.parseColor("#eeeeee");
        this.f7561l = 30.0f;
        this.f7562m = 1000;
        this.f7563n = 0;
        this.f7564o = new Timer();
        b();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onFocusChanged(boolean z10, int i10, Rect rect) {
        super.onFocusChanged(z10, i10, rect);
    }

    public void setOnScrollListener(b bVar) {
    }
}
