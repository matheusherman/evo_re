package com.live.evo.catchup;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;
import androidx.core.content.ContextCompat;
import com.live.evo.R$array;
import com.live.evo.R$color;
import com.live.evo.R$dimen;
import com.live.evo.R$drawable;
import com.live.evo.R$string;
import com.live.evo.util.l;
import com.live.evo.util.q1;
import com.live.evo.util.r1;
import com.live.evo.util.s;
import com.live.evo.util.s0;
import com.live.evo.util.u1;
import com.live.evo.util.x1;
import i5.h;
import i5.p;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import q6.c;
import x4.e;
import x4.f;
import x4.g;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class EPG extends ViewGroup implements View.OnKeyListener {
    private final SparseArray<Bitmap> A;
    private final int B;
    private final int C;
    private final int D;
    private Bitmap D1;
    private final int E;
    private Bitmap E1;
    private final int F;
    private Bitmap F1;
    private final int G;
    private TimerTask G1;
    private final int H;
    private long H1;
    private int I;
    private boolean I1;
    private int J;
    private long J1;
    private long K;
    private List<Integer> K1;
    private long L;
    private int L1;
    private long M;
    private boolean M1;
    private long N;
    private boolean N1;
    private int O;
    private boolean O1;
    private int P;
    private int P1;
    private int Q;
    private String Q1;
    private boolean R;
    private boolean R1;
    private x4.b S;
    Timer S1;
    private p T;
    private String U;
    private int V;
    private boolean W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final q6.b f5545a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5546b;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    private Bitmap f5547b1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f5548c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f5549d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f5550e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f5551f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Rect f5552g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Rect f5553h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Rect f5554i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Paint f5555j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Scroller f5556k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final GestureDetector f5557l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final int f5558m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final int f5559n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final int f5560o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final int f5561p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final int f5562q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final int f5563r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final int f5564s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final int f5565t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final int f5566u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final int f5567v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final int f5568w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final int f5569x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final int f5570y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final int f5571z;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f5572a;

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Integer num;
            while (EPG.this.K1.size() > EPG.this.L1 && (num = (Integer) EPG.this.K1.remove(0)) != null) {
                try {
                    if (num.intValue() < EPG.this.S.b()) {
                        EPG.this.S.i(num.intValue());
                    }
                } catch (Exception e10) {
                    EPG.this.f5545a.error("EPG onKeyDown TimerTask Error", e10);
                    return;
                }
            }
            int firstVisibleChannelPosition = EPG.this.getFirstVisibleChannelPosition();
            int lastVisibleChannelPosition = EPG.this.getLastVisibleChannelPosition();
            int i10 = lastVisibleChannelPosition - 3;
            if (lastVisibleChannelPosition <= this.f5572a - 3) {
                lastVisibleChannelPosition = i10;
            }
            EPG.this.V(firstVisibleChannelPosition, lastVisibleChannelPosition);
        }

        a(int i10) {
            this.f5572a = i10;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private class b extends GestureDetector.SimpleOnGestureListener {
        /* synthetic */ b(EPG epg, e eVar) {
            this();
        }

        private b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            if (!EPG.this.f5556k.isFinished()) {
                EPG.this.f5556k.forceFinished(true);
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
            EPG.this.f5556k.fling(EPG.this.getScrollX(), EPG.this.getScrollY(), -((int) f10), -((int) f11), 0, EPG.this.I, 0, EPG.this.J);
            EPG.this.X();
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
            EPG.this.Z((int) f10, (int) f11);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            motionEvent.getX();
            if (EPG.this.L(EPG.this.getScrollY() + ((int) motionEvent.getY())) != -1) {
                EPG.d(EPG.this);
                return true;
            }
            return true;
        }
    }

    public EPG(Context context) {
        this(context, null);
    }

    private long M(int i10) {
        return (((long) i10) * this.K) + this.L;
    }

    private void a0(int i10) {
        if (i10 == 0) {
            if ((N(this.P + 1) - getScrollY()) - this.f5569x < this.f5560o) {
                scrollTo(getScrollX(), N(this.P) - this.f5569x);
                return;
            }
            return;
        }
        if (i10 == 1) {
            int scrollY = getScrollY();
            int height = getHeight() - (N(this.P) - scrollY);
            int i11 = this.f5560o;
            if (height < i11) {
                Z(0, (i11 + this.f5558m) - height);
            }
        }
    }

    private void v(Canvas canvas, Rect rect, int i10, Calendar calendar, int i11) {
        long jLongValue;
        p pVarD = this.S.d(this.P, this.Q);
        if (this.O1) {
            jLongValue = this.J1;
        } else if (!this.N1) {
            jLongValue = this.M;
        } else if (pVarD != null) {
            jLongValue = pVarD.f().longValue();
            this.J1 = jLongValue;
        } else {
            jLongValue = this.J1;
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.date_move_right);
        rect.left = getScrollX() + ((this.V * 2) / 3) + this.G + ((i11 + 2) * i10) + dimensionPixelSize;
        int scrollY = getScrollY();
        rect.top = scrollY;
        rect.right = rect.left + i10;
        rect.bottom = scrollY + this.B;
        Calendar calendar2 = Calendar.getInstance();
        calendar.setTimeZone(l.d().c());
        calendar2.setTimeInMillis(jLongValue);
        int color = getResources().getColor(R$color.date_normal);
        int i12 = calendar.get(5);
        Date date = new Date();
        Calendar calendarE = q1.e(q1.h(), -7);
        Calendar calendarE2 = q1.e(q1.h(), 6);
        int i13 = this.F;
        if (calendar2.get(5) == i12 || (calendar2.getTimeInMillis() < calendarE.getTimeInMillis() && calendar.get(5) == calendarE.get(5))) {
            color = getResources().getColor(R$color.epg_date_bg);
            this.f5555j.setShadowLayer(3.0f, 5.0f, 5.0f, getResources().getColor(2131099811));
            i13 = this.f5565t;
        } else if (calendar.get(5) == date.getDate()) {
            color = getResources().getColor(R$color.current_today);
        }
        this.f5555j.setColor(color);
        canvas.drawCircle(rect.centerX(), rect.centerY(), i10 / 3, this.f5555j);
        this.f5555j.clearShadowLayer();
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(this.C);
        String str = i12 + "";
        float fMeasureText = textPaint.measureText(str);
        float dimensionPixelSize2 = (this.B / 2) + getResources().getDimensionPixelSize(R$dimen.catchup_date_padding);
        float f10 = i10 / 2;
        this.f5555j.setColor(i13);
        this.f5555j.setTextSize(this.C);
        this.f5555j.setTypeface(Typeface.DEFAULT);
        canvas.drawText(str, rect.left + (f10 - (fMeasureText / 2.0f)), rect.top + dimensionPixelSize2, this.f5555j);
        this.f5555j.setTypeface(s.b());
        this.f5555j.setTextSize(this.D);
        TextPaint textPaint2 = new TextPaint();
        textPaint2.setTextSize(this.D);
        String strL = q1.l(calendar.getTimeInMillis());
        canvas.drawText(strL, rect.left + (f10 - (textPaint2.measureText(strL) / 2.0f)), rect.top + dimensionPixelSize2 + (this.C / 2), this.f5555j);
        if (i11 == 0) {
            int dimensionPixelSize3 = getResources().getDimensionPixelSize(R$dimen.catchup_triangle);
            rect.left = getScrollX() + ((this.V * 5) / 9) + this.G + (i10 * 2) + dimensionPixelSize + getResources().getDimensionPixelSize(R$dimen.catchup_left_triangle);
            rect.top = getScrollY() + ((this.B - dimensionPixelSize3) / 2);
            Path path = new Path();
            path.moveTo(rect.left, getScrollY() + (this.B / 2));
            float f11 = (dimensionPixelSize3 * 1.71f) / 2.0f;
            int i14 = dimensionPixelSize3 / 2;
            path.lineTo(rect.left + f11, (getScrollY() + (this.B / 2)) - i14);
            path.lineTo(rect.left + f11, getScrollY() + (this.B / 2) + i14);
            path.lineTo(rect.left, getScrollY() + (this.B / 2));
            int color2 = getResources().getColor(R$color.unfocus_tri);
            if (calendar2.get(5) == calendarE.get(5)) {
                this.f5555j.setColor(color2);
            } else {
                this.f5555j.setColor(this.f5565t);
            }
            canvas.drawPath(path, this.f5555j);
            Path path2 = new Path();
            rect.left = ((int) (getScrollX() + ((this.V * 9) / 7) + this.G + (i10 * 8.2f))) + dimensionPixelSize + getResources().getDimensionPixelSize(R$dimen.catchup_right_triangle);
            rect.top = getScrollY();
            path2.moveTo(rect.left, (getScrollY() + (this.B / 2)) - i14);
            path2.lineTo(rect.left, getScrollY() + (this.B / 2) + i14);
            path2.lineTo(rect.left + f11, getScrollY() + (this.B / 2));
            if (calendar2.get(5) == calendarE2.get(5)) {
                this.f5555j.setColor(color2);
            } else {
                this.f5555j.setColor(this.f5565t);
            }
            canvas.drawPath(path2, this.f5555j);
        }
    }

    private void y(Canvas canvas, int i10, p pVar, Rect rect, int i11) {
        if (pVar.f().longValue() > this.H1) {
            B(canvas, i10, pVar, rect);
        }
        this.H1 = pVar.g().longValue();
        long j10 = ((this.M + this.N) - (((long) this.f5561p) * this.K)) / 2;
        if (this.W && this.P == i10 && j10 >= pVar.f().longValue() && j10 < pVar.g().longValue()) {
            this.Q = i11;
            this.W = false;
        }
        if (this.W && this.P == i10 && j10 < pVar.f().longValue()) {
            this.Q = i11;
            this.W = false;
        }
        b0(i10, pVar.f().longValue(), pVar.g().longValue(), rect, canvas);
        boolean z10 = this.O == i10 && R(pVar).booleanValue();
        int color = this.f5563r;
        if (z10) {
            if (this.R) {
                this.Q = i11;
                this.R = false;
                this.W = false;
            }
            color = getResources().getColor(R$color.current_play);
        } else if (R(pVar).booleanValue()) {
            color = this.f5564s;
            if (this.T == null) {
                this.T = pVar;
            }
        }
        if (i11 == 0) {
            rect.left -= this.f5558m;
        }
        this.f5555j.setColor(color);
        canvas.drawRect(rect, this.f5555j);
        boolean zS = S(i10);
        if (zS) {
            this.f5555j.setColor(this.P1);
            canvas.drawRect(rect, this.f5555j);
        }
        int i12 = rect.left;
        int i13 = this.f5559n;
        rect.left = i12 + i13;
        rect.right -= i13;
        if (zS || ((this.O == i10 && R(pVar).booleanValue()) || (this.P == i10 && this.Q == i11))) {
            this.f5555j.setColor(this.f5565t);
        } else {
            this.f5555j.setColor(this.F);
        }
        this.f5555j.setTextSize(this.f5566u);
        String strE = pVar.e();
        this.f5555j.getTextBounds(strE, 0, strE.length(), this.f5554i);
        int i14 = rect.top;
        rect.top = i14 + ((rect.bottom - i14) / 2) + (this.f5554i.height() / 2);
        this.f5555j.setTypeface(s.c());
        int iO = O(this.M);
        if (rect.left < iO) {
            rect.left = iO + this.f5559n;
        }
        canvas.drawText(strE.substring(0, this.f5555j.breakText(strE, true, rect.right - rect.left, null)), rect.left, rect.top, this.f5555j);
        if (this.M1) {
            h hVarA = this.S.a(i10);
            if (s0.f7342a.O(pVar, hVarA != null ? hVarA.b() : null)) {
                rect.top = N(i10) + 5;
                rect.right = (rect.left + getResources().getDimensionPixelSize(R$dimen.catchup_icon_width2)) - this.f5558m;
                rect.bottom = rect.top + getResources().getDimensionPixelSize(R$dimen.catchup_icon_width2);
                canvas.drawBitmap(this.F1, (Rect) null, rect, this.f5555j);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:155:0x04ad  */
    /* JADX WARN: Code duplicated, block: B:157:0x04b5  */
    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i10, KeyEvent keyEvent) {
        int i11;
        boolean z10;
        int i12;
        x4.b bVar = this.S;
        if (bVar == null || bVar.b() < this.P) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        int i13 = this.P;
        int i14 = this.Q;
        int iB = this.S.b();
        List<p> list = this.S.e(this.P).first;
        Boolean bool = this.S.e(this.P).second;
        this.M = M(getScrollX());
        this.N = M(getScrollX() + getWidth());
        if (keyCode != 23 && keyCode != 66 && keyCode != 4 && (keyCode != 22 || keyEvent.getAction() != 1)) {
            this.O1 = false;
        }
        if (keyEvent.getAction() != 0) {
            i11 = 1;
        } else if (keyCode != 11) {
            if (keyCode == 13) {
                long jG = q1.g(this.M);
                TimeUnit timeUnit = TimeUnit.DAYS;
                long millis = jG + timeUnit.toMillis(6L);
                long millis2 = (((this.M + this.N) + (((long) this.f5561p) * this.K)) / 2) + timeUnit.toMillis(1L);
                if (this.N > millis - timeUnit.toMillis(1L)) {
                    scrollTo((O(millis) - this.f5558m) - this.f5561p, getScrollY());
                } else {
                    Z((int) (timeUnit.toMillis(1L) / this.K), 0);
                }
                this.J1 = millis2;
                p pVarD = this.S.d(this.P, this.Q);
                if (pVarD != null && T(pVarD.f().longValue(), pVarD.g().longValue())) {
                    this.N1 = true;
                    return false;
                }
                boolean zJ = J(list, millis2);
                this.N1 = zJ;
                if (zJ) {
                    return false;
                }
            } else if (keyCode == 66) {
                if (!x1.m(1000L)) {
                    if (!bool.booleanValue() && list.isEmpty()) {
                        this.S.a(this.P);
                        throw null;
                    }
                    this.S.d(this.P, this.Q);
                    this.S.a(this.P);
                    throw null;
                }
            } else if (keyCode != 67) {
                switch (keyCode) {
                    case 19:
                        i11 = 1;
                        if (i13 > 0) {
                            this.P--;
                            U(0);
                        }
                        break;
                    case 20:
                        i11 = 1;
                        if (i13 < iB - 1) {
                            this.P++;
                            U(1);
                        }
                        break;
                    case 21:
                        if (bool.booleanValue()) {
                            if (list.isEmpty()) {
                                r1.d(getContext(), getContext().getString(R$string.current_channel_no_epg), 0);
                            } else {
                                if (this.Q == 0) {
                                    r1.d(getContext(), getContext().getString(R$string.no_more_epg), 0);
                                }
                                if (this.Q >= list.size() || list.get(0).f().longValue() > this.N || list.get(list.size() - 1).g().longValue() < this.M) {
                                    for (int i15 = 0; i15 < list.size(); i15++) {
                                        p pVar = list.get(i15);
                                        long j10 = ((this.M + this.N) + (this.K * ((long) this.f5561p))) / 2;
                                        if (T(pVar.f().longValue(), pVar.g().longValue()) && j10 >= pVar.f().longValue() && j10 <= pVar.g().longValue()) {
                                            this.Q = i15;
                                        } else if (T(pVar.f().longValue(), pVar.g().longValue()) && j10 <= pVar.f().longValue()) {
                                            this.Q = i15;
                                        }
                                    }
                                } else if (i14 > 0) {
                                    this.Q--;
                                }
                                if (this.Q >= list.size() || list.get(0).f().longValue() > this.N || list.get(list.size() - 1).g().longValue() < this.M) {
                                    if (list.get(0).f().longValue() > this.N) {
                                        this.Q = 0;
                                    } else if (list.get(list.size() - 1).g().longValue() < this.M) {
                                        this.Q = list.size() - 1;
                                    } else {
                                        this.Q = list.size() - 1;
                                    }
                                    scrollTo((O(list.get(this.Q).f().longValue()) - this.f5558m) - this.f5561p, getScrollY());
                                } else {
                                    p pVar2 = list.get(this.Q);
                                    long jLongValue = pVar2.f().longValue();
                                    long jLongValue2 = pVar2.g().longValue();
                                    long j11 = this.M;
                                    if (jLongValue < j11) {
                                        Z(((int) ((jLongValue - j11) / this.K)) + this.f5558m, 0);
                                    } else {
                                        int scrollX = getScrollX() + getWidth();
                                        int i16 = this.f5558m;
                                        int i17 = this.f5561p;
                                        long j12 = this.K;
                                        if (jLongValue2 > (((long) (scrollX - ((i16 * 2) + i17))) * j12) + this.L) {
                                            Z(((int) ((jLongValue2 - this.N) / j12)) + (i16 * 2) + i17, 0);
                                        }
                                    }
                                }
                                i11 = 1;
                                this.N1 = true;
                            }
                        }
                        break;
                    case 22:
                        if (bool.booleanValue()) {
                            if (list.isEmpty()) {
                                r1.d(getContext(), getContext().getString(R$string.current_channel_no_epg), 0);
                            } else {
                                if (this.Q == list.size() - 1) {
                                    r1.d(getContext(), getContext().getString(R$string.no_more_epg), 0);
                                }
                                if (this.Q >= list.size() || list.get(0).f().longValue() > this.N || list.get(list.size() - 1).g().longValue() < this.M) {
                                    for (int i18 = 0; i18 < list.size(); i18++) {
                                        p pVar3 = list.get(i18);
                                        long j13 = ((this.M + this.N) + (((long) this.f5561p) * this.K)) / 2;
                                        if (T(pVar3.f().longValue(), pVar3.g().longValue()) && j13 >= pVar3.f().longValue() && j13 <= pVar3.g().longValue()) {
                                            this.Q = i18;
                                        } else if (T(pVar3.f().longValue(), pVar3.g().longValue()) && j13 <= pVar3.f().longValue()) {
                                            this.Q = i18;
                                        }
                                    }
                                } else if (this.Q < list.size() && list.get(this.Q).g().longValue() < q1.f(q1.h(), 7) && this.Q < list.size() - 1) {
                                    this.Q++;
                                }
                                if (this.Q < list.size() && list.get(0).f().longValue() <= this.N) {
                                    if (list.get(list.size() - 1).g().longValue() < this.M) {
                                        i12 = 0;
                                        z10 = true;
                                    } else {
                                        p pVar4 = list.get(this.Q);
                                        long jLongValue3 = pVar4.g().longValue();
                                        long jLongValue4 = pVar4.f().longValue();
                                        int scrollX2 = getScrollX() + getWidth();
                                        int i19 = this.f5558m;
                                        int i20 = this.f5561p;
                                        z10 = true;
                                        z10 = true;
                                        z10 = true;
                                        long j14 = this.K;
                                        if (jLongValue3 > (((long) (scrollX2 - ((i19 * 2) + i20))) * j14) + this.L) {
                                            Z(((int) ((jLongValue3 - this.N) / j14)) + i19 + i20, 0);
                                        } else if (jLongValue4 < this.M) {
                                            scrollTo((O(jLongValue4) - this.f5561p) + this.f5558m, getScrollY());
                                        }
                                    }
                                    this.N1 = z10;
                                } else {
                                    z10 = true;
                                    i12 = 0;
                                }
                                if (list.get(i12).f().longValue() > this.N) {
                                    this.Q = i12;
                                } else if (list.get(list.size() - (z10 ? 1 : 0)).g().longValue() < this.M) {
                                    this.Q = list.size() - (z10 ? 1 : 0);
                                } else {
                                    this.Q = list.size() - (z10 ? 1 : 0);
                                }
                                scrollTo((O(list.get(this.Q).f().longValue()) - this.f5558m) - this.f5561p, getScrollY());
                                this.N1 = z10;
                            }
                        }
                        break;
                    case 23:
                        if (!x1.m(1000L)) {
                            if (!bool.booleanValue()) {
                                break;
                            }
                            this.S.d(this.P, this.Q);
                            this.S.a(this.P);
                            throw null;
                        }
                        break;
                }
            } else {
                this.P = this.O;
                this.W = true;
                W(false);
            }
            i11 = 1;
        } else {
            long jG2 = q1.g(u1.b().a());
            TimeUnit timeUnit2 = TimeUnit.DAYS;
            long millis3 = jG2 - timeUnit2.toMillis(7L);
            long millis4 = (((this.M + this.N) + (((long) this.f5561p) * this.K)) / 2) - timeUnit2.toMillis(1L);
            long j15 = this.M;
            if (j15 >= millis3) {
                Z(-((int) (timeUnit2.toMillis(1L) / this.K)), 0);
            } else if (j15 < millis3) {
                scrollTo(O(millis3) - (this.f5558m + this.f5561p), getScrollY());
                millis4 = ((((long) getWidth()) * this.K) / 2) + (((long) getScrollX()) * this.K);
            }
            this.J1 = millis4;
            p pVarD2 = this.S.d(this.P, this.Q);
            if (pVarD2 != null && T(pVarD2.f().longValue(), pVarD2.g().longValue())) {
                this.N1 = true;
                return false;
            }
            i11 = 1;
            boolean zJ2 = J(list, millis4);
            this.N1 = zJ2;
            if (zJ2) {
                return false;
            }
        }
        if (keyEvent.getAction() == i11 && ((keyCode == 19 || keyCode == 20) && !this.I1)) {
            TimerTask timerTask = this.G1;
            if (timerTask != null) {
                timerTask.cancel();
            }
            a aVar = new a(iB);
            this.G1 = aVar;
            this.S1.schedule(aVar, 500L);
        }
        invalidate();
        return false;
    }

    public EPG(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void A(Canvas canvas, Rect rect) {
        this.f5552g.left = getScrollX() + this.f5561p + this.f5558m;
        this.f5552g.top = getScrollY() + this.f5569x;
        Rect rect2 = this.f5552g;
        rect2.right = rect2.left + getWidth();
        Rect rect3 = this.f5552g;
        rect3.bottom = rect3.top + getHeight();
        canvas.save();
        canvas.clipRect(this.f5552g);
        rect.left = getScrollX() + this.f5561p + this.f5558m;
        rect.top = getScrollY() + this.f5569x;
        rect.right = this.f5552g.left + getWidth();
        rect.bottom = this.f5552g.top + getHeight();
        this.f5555j.setColor(this.f5562q);
        canvas.drawRect(rect, this.f5555j);
        this.f5555j.setColor(this.F);
        this.f5555j.setTextSize(this.f5566u);
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(this.f5566u);
        int iMeasureText = (int) textPaint.measureText(getResources().getString(R$string.catchup_init_remind));
        rect.top = getScrollY() + this.f5569x + (((getHeight() - this.f5569x) - this.f5566u) / 2);
        rect.left = getScrollX() + this.f5561p + (((getWidth() - this.f5561p) - iMeasureText) / 2);
        this.f5555j.setTypeface(s.c());
        canvas.drawText(getResources().getString(R$string.catchup_init_remind), rect.left, rect.top, this.f5555j);
        canvas.restore();
    }

    private void B(Canvas canvas, int i10, p pVar, Rect rect) {
        long j10 = this.H1;
        long j11 = this.M;
        if (j10 < j11) {
            this.H1 = j11 - (((long) this.f5558m) * this.K);
        }
        b0(i10, this.H1, pVar.f().longValue() - ((long) this.f5558m), rect, canvas);
        this.f5555j.setColor(this.f5563r);
        if (Q(this.H1, pVar.f().longValue()).booleanValue()) {
            this.f5555j.setColor(this.f5564s);
        }
        canvas.drawRect(rect, this.f5555j);
        if (S(i10)) {
            this.f5555j.setColor(this.P1);
            canvas.drawRect(rect, this.f5555j);
        }
        rect.left += this.f5559n;
        this.f5555j.setColor(this.F);
        this.f5555j.setTextSize(this.f5566u);
        Paint paint = this.f5555j;
        String str = this.Q1;
        paint.getTextBounds(str, 0, str.length(), this.f5554i);
        int i11 = rect.top;
        rect.top = i11 + ((rect.bottom - i11) / 2) + (this.f5554i.height() / 2);
        this.f5555j.setTypeface(s.c());
        int iO = O(this.M);
        if (rect.left < iO) {
            rect.left = iO;
        }
        String str2 = this.Q1;
        canvas.drawText(str2.substring(0, this.f5555j.breakText(str2, true, rect.right - rect.left, null)), rect.left, rect.top, this.f5555j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int L(int i10) {
        int i11 = i10 - this.f5569x;
        int i12 = this.f5558m;
        int i13 = (i11 + i12) / (this.f5560o + i12);
        if (this.S.b() == 0) {
            return -1;
        }
        return i13;
    }

    private int N(int i10) {
        int i11 = this.f5560o;
        int i12 = this.f5558m;
        return (i10 * (i11 + i12)) + i12 + this.f5569x;
    }

    private int O(long j10) {
        return ((int) ((j10 - this.L) / this.K)) + this.f5561p + (this.f5558m * 2);
    }

    private boolean S(int i10) {
        return i10 == this.P;
    }

    private void U(int i10) {
        List<p> list = this.S.e(this.P).first;
        a0(i10);
        if (list.isEmpty()) {
            return;
        }
        p pVar = this.T;
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            p pVar2 = list.get(i11);
            long jLongValue = pVar != null ? pVar.f().longValue() : M(getScrollX() + this.f5561p + (((getWidth() - this.f5561p) - this.f5558m) / 2));
            long j10 = this.M;
            if (jLongValue < j10) {
                jLongValue = j10;
            }
            if (pVar2.f().longValue() > this.N) {
                this.Q = i11;
                this.N1 = true;
                return;
            }
            if (jLongValue >= pVar2.f().longValue() && jLongValue < pVar2.g().longValue() && T(pVar2.f().longValue(), pVar2.g().longValue())) {
                this.Q = i11;
                if (pVar != null && i11 < size - 1 && pVar.f().longValue() > pVar2.f().longValue()) {
                    int i12 = i11 + 1;
                    p pVar3 = list.get(i12);
                    if (pVar3.f().longValue() >= pVar.f().longValue() && pVar3.g().longValue() <= pVar.g().longValue() && T(pVar3.f().longValue(), pVar3.g().longValue())) {
                        this.Q = i12;
                    }
                    this.N1 = true;
                    return;
                }
            }
        }
        this.N1 = J(list, ((this.M + this.N) - (((long) this.f5561p) * this.K)) / 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(int i10, int i11) {
        if (i10 < i11) {
            getFirstVisibleChannelPosition();
            getLastVisibleChannelPosition();
            SparseArray sparseArray = new SparseArray();
            while (i10 <= i11) {
                if (!this.S.e(i10).second.booleanValue()) {
                    sparseArray.put(i10, this.S.a(i10).f());
                }
                i10++;
            }
        }
    }

    private boolean c0(long j10) {
        return j10 >= this.M && j10 < this.N;
    }

    private void o() {
        int iN = N(this.S.b() - 2) + this.f5560o;
        this.J = iN < getHeight() ? 0 : (iN - getHeight()) + this.f5560o + (this.f5558m * 2);
    }

    private void u(Canvas canvas, Rect rect) {
        p pVarD = this.S.d(this.P, this.Q);
        if (pVarD != null) {
            this.N1 = T(pVarD.f().longValue(), pVarD.g().longValue());
        }
        if (!this.N1) {
            C(canvas, rect);
            return;
        }
        p pVarD2 = this.S.d(this.P, this.Q);
        this.f5555j.setMaskFilter(new BlurMaskFilter(10.0f, BlurMaskFilter.Blur.SOLID));
        if (pVarD2 == null) {
            C(canvas, rect);
        } else if (T(pVarD2.f().longValue(), pVarD2.g().longValue())) {
            rect.left = Math.max(O(pVarD2.f().longValue()), getScrollX() + this.f5561p);
            rect.top = N(this.P);
            rect.right = Math.min(O(pVarD2.g().longValue()) - this.f5558m, (getScrollX() + getWidth()) - this.f5558m);
            rect.bottom = rect.top + this.f5560o;
            this.f5555j.setColor(getResources().getColor(R$color.event_select_color));
            this.f5555j.setStyle(Paint.Style.STROKE);
            this.f5555j.setStrokeWidth(getResources().getDimensionPixelSize(R$dimen.select_stroke_width));
            canvas.drawRect(rect, this.f5555j);
            this.f5555j.setStyle(Paint.Style.FILL);
            this.T = pVarD2;
        } else {
            List<p> list = this.S.e(this.P).first;
            if (list != null && !list.isEmpty()) {
                int size = list.size();
                for (int i10 = 0; i10 < size; i10++) {
                    p pVar = list.get(i10);
                    long j10 = ((this.M + this.N) - (((long) this.f5561p) * this.K)) / 2;
                    if (j10 < pVar.f().longValue() || j10 >= pVar.g().longValue()) {
                        if (pVar.f().longValue() > this.N) {
                            break;
                        }
                    } else if (T(pVar.f().longValue(), pVar.g().longValue())) {
                        this.Q = i10;
                        u(canvas, rect);
                        return;
                    }
                }
            }
        }
        this.f5555j.setMaskFilter(null);
    }

    private void w(Canvas canvas, Rect rect) {
        long jLongValue;
        Canvas canvas2;
        Rect rect2;
        p pVarD = this.S.d(this.P, this.Q);
        if (this.O1 || pVarD == null || !T(pVarD.f().longValue(), pVarD.g().longValue())) {
            jLongValue = this.J1;
        } else {
            jLongValue = pVarD.f().longValue();
            this.J1 = jLongValue;
        }
        rect.left = getScrollX() + (this.f5561p * 2);
        rect.top = getScrollY();
        rect.right = rect.left + getWidth();
        rect.bottom = rect.top + this.B;
        this.f5552g.left = getScrollX() + this.f5561p;
        this.f5552g.top = getScrollY();
        this.f5552g.right = getScrollX() + getWidth();
        Rect rect3 = this.f5552g;
        rect3.bottom = rect3.top + this.B;
        canvas.save();
        canvas.clipRect(this.f5552g);
        this.f5555j.setColor(this.f5571z);
        canvas.drawRect(rect, this.f5555j);
        long jH = q1.h();
        int dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.date_wide);
        if (jH > jLongValue) {
            for (int i10 = 0; i10 < 7; i10++) {
                v(canvas, rect, dimensionPixelSize, q1.e(jH, i10 - 7), i10);
            }
            canvas2 = canvas;
            rect2 = rect;
        } else {
            canvas2 = canvas;
            rect2 = rect;
            for (int i11 = 0; i11 < 7; i11++) {
                v(canvas2, rect2, dimensionPixelSize, q1.e(jH, i11), i11);
            }
        }
        this.f5555j.setTextSize(this.E);
        this.f5555j.setTypeface(s.d());
        CharSequence charSequence = getResources().getTextArray(R$array.month)[new Date().getMonth()];
        rect2.left = getScrollX() + (this.V / 2) + this.G + dimensionPixelSize + getResources().getDimensionPixelSize(R$dimen.date_move_right);
        int scrollY = getScrollY();
        rect2.top = scrollY;
        rect2.right = rect2.left + dimensionPixelSize;
        rect2.bottom = scrollY + this.B;
        canvas2.drawText(charSequence.toString(), rect2.left + (dimensionPixelSize / 4), rect2.centerY() + (this.E / 2), this.f5555j);
        x(canvas2, rect2);
        canvas2.restore();
    }

    private void z(Canvas canvas, Rect rect) {
        p pVarD;
        int lastVisibleChannelPosition = getLastVisibleChannelPosition();
        for (int firstVisibleChannelPosition = getFirstVisibleChannelPosition(); firstVisibleChannelPosition <= lastVisibleChannelPosition; firstVisibleChannelPosition++) {
            this.H1 = 0L;
            this.f5552g.left = getScrollX() + this.f5561p + this.f5558m;
            int iN = N(firstVisibleChannelPosition);
            Rect rect2 = this.f5552g;
            rect2.top = this.f5558m + iN;
            rect2.right = getScrollX() + getWidth();
            Rect rect3 = this.f5552g;
            rect3.bottom = rect3.top + this.f5560o;
            canvas.save();
            canvas.clipRect(this.f5552g);
            x4.b bVar = this.S;
            if (bVar != null && bVar.e(firstVisibleChannelPosition) != null) {
                List<p> list = this.S.e(firstVisibleChannelPosition).first;
                boolean zS = S(firstVisibleChannelPosition);
                if (list.isEmpty()) {
                    rect.left = getScrollX() + this.f5561p + this.f5558m;
                    rect.top = iN;
                    rect.right = getScrollX() + getWidth();
                    rect.bottom = rect.top + this.f5560o + this.f5558m;
                    this.f5555j.setColor(this.f5563r);
                    canvas.drawRect(rect, this.f5555j);
                    if (zS) {
                        this.f5555j.setColor(this.P1);
                        rect.left = getScrollX() + this.f5561p;
                        rect.top = iN;
                        rect.right = getScrollX() + getWidth();
                        rect.bottom = rect.top + this.f5560o + this.f5558m;
                        canvas.drawRect(rect, this.f5555j);
                    }
                    this.f5555j.setColor(this.F);
                    if (zS) {
                        this.f5555j.setColor(this.f5565t);
                    }
                    String string = this.Q1;
                    if (!this.S.e(firstVisibleChannelPosition).second.booleanValue()) {
                        string = getResources().getString(2131952317);
                    }
                    this.f5555j.setTextSize(this.f5566u);
                    TextPaint textPaint = new TextPaint();
                    textPaint.setTextSize(this.f5570y);
                    float fMeasureText = textPaint.measureText(string);
                    rect.top += (this.f5560o / 2) + (this.f5570y / 2);
                    canvas.drawText(string, rect.left + ((((getWidth() - this.f5561p) - this.f5558m) - fMeasureText) / 2.0f), rect.top, this.f5555j);
                } else {
                    for (int i10 = 0; i10 < list.size(); i10++) {
                        p pVar = list.get(i10);
                        if (pVar.f().longValue() > this.N) {
                            if (pVar.f().longValue() <= this.H1) {
                                break;
                            }
                            B(canvas, firstVisibleChannelPosition, pVar, rect);
                            this.H1 = pVar.g().longValue();
                            break;
                        }
                        int i11 = this.P;
                        if (i10 == i11 && !this.W && (pVarD = this.S.d(i11, this.Q)) != null && !T(pVarD.f().longValue(), pVarD.g().longValue())) {
                            this.W = true;
                        }
                        if (T(pVar.f().longValue(), pVar.g().longValue())) {
                            this.K1.remove(Integer.valueOf(firstVisibleChannelPosition));
                            this.K1.add(Integer.valueOf(firstVisibleChannelPosition));
                            y(canvas, firstVisibleChannelPosition, pVar, rect, i10);
                        }
                        if (i10 == list.size() - 1) {
                            Long lG = pVar.g();
                            if (lG.longValue() < this.N) {
                                long jLongValue = lG.longValue();
                                long j10 = this.M;
                                if (jLongValue < j10) {
                                    rect.left = O(j10) - this.f5558m;
                                } else {
                                    rect.left = O(lG.longValue());
                                }
                                rect.top = this.f5558m + iN;
                                rect.right = O(this.N);
                                rect.bottom = rect.top + this.f5560o;
                                this.f5555j.setColor(this.f5563r);
                                if (zS) {
                                    this.f5555j.setColor(this.P1);
                                }
                                canvas.drawRect(rect, this.f5555j);
                                this.f5555j.setColor(this.F);
                                this.f5555j.setTextSize(this.f5566u);
                                int i12 = rect.left;
                                int i13 = this.f5559n;
                                rect.left = i12 + i13;
                                rect.right -= i13;
                                int i14 = rect.top;
                                int iHeight = i14 + ((rect.bottom - i14) / 2) + (this.f5554i.height() / 2);
                                rect.top = iHeight;
                                canvas.drawText(this.Q1, rect.left, iHeight, this.f5555j);
                            }
                        }
                    }
                }
                int scrollX = getScrollX();
                rect.left = scrollX;
                rect.top = iN;
                rect.right = scrollX + getWidth();
                rect.bottom = rect.top + this.f5558m;
                this.f5555j.setColor(this.H);
                canvas.drawRect(rect, this.f5555j);
                canvas.restore();
            }
        }
    }

    public Bitmap K(Context context, int i10) {
        Bitmap bitmap = this.A.get(i10);
        if (bitmap != null) {
            return bitmap;
        }
        Drawable drawable = ContextCompat.getDrawable(context, i10);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        this.A.put(i10, bitmapCreateBitmap);
        return bitmapCreateBitmap;
    }

    public void P(boolean z10, int i10) {
        this.R = z10;
        if (z10) {
            this.O = i10;
            this.P = i10;
        }
    }

    public void W(boolean z10) {
        x4.b bVar = this.S;
        if (bVar == null || !bVar.h()) {
            return;
        }
        Y();
        o();
        n();
        int i10 = this.O;
        if (this.O > this.S.b() - ((getHeight() - this.f5569x) / (this.f5560o + this.f5558m))) {
            this.f5556k.startScroll(getScrollX(), getScrollY(), (getXPositionStart() - getScrollX()) - this.f5561p, this.J - getScrollY(), z10 ? 600 : 0);
        } else {
            this.f5556k.startScroll(getScrollX(), getScrollY(), (getXPositionStart() - getScrollX()) - this.f5561p, (N(i10) - this.f5569x) - getScrollY(), z10 ? 600 : 0);
        }
        X();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        x4.b bVar = this.S;
        if (bVar == null || !bVar.h()) {
            return;
        }
        this.M = M(getScrollX());
        this.N = M(getScrollX() + getWidth());
        Rect rect = this.f5553h;
        rect.left = getScrollX();
        rect.top = getScrollY();
        rect.right = rect.left + getWidth();
        rect.bottom = rect.top + getHeight();
        this.f5555j.setColor(getResources().getColor(R$color.catchup_bg_3));
        canvas.drawRect(rect, this.f5555j);
        if (this.I1) {
            A(canvas, rect);
        }
        rect.left = getScrollX() + this.f5561p;
        int scrollY = getScrollY();
        rect.top = scrollY;
        rect.right = rect.left + this.f5558m;
        rect.bottom = scrollY + getHeight();
        this.f5555j.setColor(this.H);
        canvas.drawRect(rect, this.f5555j);
        t(canvas, rect);
        if (!this.I1) {
            z(canvas, rect);
        }
        G(canvas, rect);
        r(canvas, rect);
        if (!this.I1) {
            u(canvas, rect);
            H(canvas, rect);
        }
        if (this.M1) {
            E(canvas, rect);
            F(canvas, rect);
        } else {
            D(canvas, rect);
        }
        w(canvas, rect);
        if (this.f5556k.computeScrollOffset()) {
            scrollTo(this.f5556k.getCurrX(), this.f5556k.getCurrY());
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.f5557l.onTouchEvent(motionEvent);
    }

    public void setInitData(boolean z10) {
        this.I1 = z10;
    }

    public EPG(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f5545a = c.d(EPG.class);
        this.f5546b = getClass().getSimpleName();
        this.f5548c = 604800000;
        this.f5549d = 604800000;
        this.f5550e = 18000000;
        this.f5551f = 1800000;
        this.O = 10;
        this.P = 0;
        this.Q = 0;
        this.R = true;
        this.W = false;
        this.I1 = true;
        this.J1 = u1.b().a();
        this.K1 = new ArrayList();
        this.M1 = false;
        this.N1 = true;
        this.O1 = true;
        this.S1 = new Timer();
        setFocusable(true);
        requestFocus();
        setOnKeyListener(this);
        setWillNotDraw(false);
        this.L1 = com.live.evo.l.n().g("epg_cache_size", 20);
        Y();
        P(true, this.P);
        this.f5553h = new Rect();
        this.f5552g = new Rect();
        this.f5554i = new Rect();
        this.f5555j = new Paint(1);
        this.f5557l = new GestureDetector(context, new b(this, null));
        this.A = new SparseArray<>();
        Scroller scroller = new Scroller(context);
        this.f5556k = scroller;
        scroller.setFriction(0.2f);
        this.f5571z = getResources().getColor(R$color.epg_background);
        this.f5558m = getResources().getDimensionPixelSize(R$dimen.epg_channel_layout_margin);
        this.f5559n = getResources().getDimensionPixelSize(R$dimen.epg_channel_layout_padding);
        this.f5560o = getResources().getDimensionPixelSize(R$dimen.epg_channel_layout_height);
        this.f5561p = getResources().getDimensionPixelSize(R$dimen.epg_channel_layout_width);
        this.G = getResources().getDimensionPixelSize(R$dimen.epg_date_margin);
        this.V = getResources().getDimensionPixelSize(R$dimen.date_space);
        this.B = getResources().getDimensionPixelSize(R$dimen.date_layout_height);
        this.f5562q = getResources().getColor(R$color.epg_channel_layout_background);
        this.f5563r = getResources().getColor(R$color.epg_event_layout_background);
        this.f5564s = getResources().getColor(R$color.epg_event_layout_background_current);
        this.f5565t = getResources().getColor(R$color.epg_event_select_text);
        this.F = getResources().getColor(R$color.epg_event_default_text);
        this.P1 = getResources().getColor(R$color.current_channel);
        this.H = getResources().getColor(R$color.epg_spacing);
        this.f5566u = getResources().getDimensionPixelSize(R$dimen.epg_event_layout_text);
        this.f5569x = getResources().getDimensionPixelSize(R$dimen.epg_time_bar_height);
        this.f5570y = getResources().getDimensionPixelSize(R$dimen.epg_time_bar_text);
        this.C = getResources().getDimensionPixelSize(R$dimen.epg_time_bar_Date_text);
        this.E = getResources().getDimensionPixelSize(R$dimen.epg_time_bar_Month_text);
        this.D = getResources().getDimensionPixelSize(R$dimen.epg_time_bar_week_text);
        this.f5567v = getResources().getDimensionPixelSize(R$dimen.epg_time_bar_line_width);
        this.Q1 = getResources().getString(R$string.not_data);
        this.f5568w = getResources().getColor(R$color.epg_time_line);
        this.D1 = K(getContext(), R$drawable.catchup_4_icon);
        this.f5547b1 = K(getContext(), R$drawable.catchup_6_icon);
        this.E1 = K(getContext(), R$drawable.catchup_subscribe_icon);
        this.F1 = K(getContext(), R$drawable.catchup_subscribe_icon_small);
        this.R1 = com.live.evo.l.n().j("epg_show_num_tip", true);
    }

    private void C(Canvas canvas, Rect rect) {
        rect.left = getScrollX() + this.f5561p;
        rect.top = N(this.P);
        rect.right = (getScrollX() + getWidth()) - (this.f5558m * 2);
        rect.bottom = rect.top + this.f5560o;
        this.f5555j.setColor(getResources().getColor(R$color.event_select_color));
        this.f5555j.setStyle(Paint.Style.STROKE);
        this.f5555j.setStrokeWidth(getResources().getDimensionPixelSize(R$dimen.select_stroke_width));
        canvas.drawRect(rect, this.f5555j);
        this.f5555j.setStyle(Paint.Style.FILL);
    }

    private void D(Canvas canvas, Rect rect) {
        rect.left = getScrollX();
        rect.top = getScrollY();
        rect.right = rect.left + (this.f5561p * 2);
        rect.bottom = getScrollY() + this.B;
        this.f5555j.setColor(this.f5571z);
        canvas.drawRect(rect, this.f5555j);
        if (!this.R1) {
            return;
        }
        rect.left = getScrollX() + this.f5559n;
        this.f5555j.setTypeface(s.d());
        this.f5555j.setColor(this.F);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.catchup_remind_text_size);
        float f10 = dimensionPixelSize;
        this.f5555j.setTextSize(f10);
        rect.top = getScrollY();
        rect.bottom = getScrollY() + this.B;
        String string = getResources().getString(R$string.catchup_press);
        int i10 = dimensionPixelSize / 2;
        canvas.drawText(string, rect.left, rect.centerY() + i10, this.f5555j);
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(f10);
        float fMeasureText = textPaint.measureText(string);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R$dimen.remind_num_height);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(R$dimen.remind_num_height);
        rect.left = getScrollX() + ((int) fMeasureText) + ((this.f5559n * 6) / 4);
        int scrollY = getScrollY() + ((this.B - dimensionPixelSize3) / 2);
        rect.top = scrollY;
        int i11 = rect.left;
        rect.right = i11 + dimensionPixelSize2;
        rect.bottom = dimensionPixelSize3 + scrollY;
        rect.left = i11 + (this.f5558m * 2);
        rect.top = scrollY + getResources().getDimensionPixelSize(R$dimen.line_radius);
        rect.bottom += getResources().getDimensionPixelSize(R$dimen.line_radius2);
        canvas.drawBitmap(this.D1, (Rect) null, rect, this.f5555j);
        int i12 = rect.right;
        rect.left = (this.f5558m * 2) + i12;
        rect.right = i12 + dimensionPixelSize2;
        canvas.drawBitmap(this.f5547b1, (Rect) null, rect, this.f5555j);
        rect.left = rect.right + (this.f5558m * 2);
        rect.bottom = getScrollY() + this.B;
        rect.top = getScrollY();
        rect.left += this.f5558m * 2;
        canvas.drawText(getResources().getString(R$string.catchup_remind2), rect.left, rect.centerY() + i10, this.f5555j);
    }

    private void E(Canvas canvas, Rect rect) {
        rect.left = getScrollX();
        rect.top = getScrollY();
        rect.right = rect.left + (this.f5561p * 2);
        rect.bottom = getScrollY() + (this.B / 2);
        this.f5555j.setColor(this.f5571z);
        canvas.drawRect(rect, this.f5555j);
        if (!this.R1) {
            return;
        }
        rect.left = getScrollX() + this.f5559n;
        this.f5555j.setTypeface(s.d());
        this.f5555j.setColor(this.F);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.catchup_remind_text_size);
        float f10 = dimensionPixelSize;
        this.f5555j.setTextSize(f10);
        rect.top = getScrollY();
        rect.bottom = getScrollY() + (this.B / 2);
        String string = getResources().getString(R$string.catchup_press);
        int i10 = dimensionPixelSize / 2;
        canvas.drawText(string, rect.left, rect.centerY() + i10, this.f5555j);
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(f10);
        float fMeasureText = textPaint.measureText(string);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R$dimen.remind_num_height);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(R$dimen.remind_num_height);
        rect.left = getScrollX() + ((int) fMeasureText) + ((this.f5559n * 6) / 4);
        int scrollY = getScrollY() + (((rect.bottom - rect.top) - dimensionPixelSize3) / 2);
        rect.top = scrollY;
        int i11 = rect.left;
        rect.right = i11 + dimensionPixelSize2;
        rect.bottom = dimensionPixelSize3 + scrollY;
        rect.left = i11 + (this.f5558m * 2);
        rect.top = scrollY + getResources().getDimensionPixelSize(R$dimen.line_radius);
        rect.bottom += getResources().getDimensionPixelSize(R$dimen.line_radius2);
        canvas.drawBitmap(this.D1, (Rect) null, rect, this.f5555j);
        int i12 = rect.right;
        rect.left = (this.f5558m * 2) + i12;
        rect.right = i12 + dimensionPixelSize2;
        canvas.drawBitmap(this.f5547b1, (Rect) null, rect, this.f5555j);
        rect.left = rect.right + (this.f5558m * 2);
        rect.bottom = getScrollY() + (this.B / 2);
        rect.top = getScrollY();
        rect.left += this.f5558m * 2;
        canvas.drawText(getResources().getString(R$string.catchup_remind2), rect.left, rect.centerY() + i10, this.f5555j);
    }

    private void F(Canvas canvas, Rect rect) {
        rect.left = getScrollX();
        rect.top = getScrollY() + (this.B / 2);
        rect.right = rect.left + (this.f5561p * 2);
        rect.bottom = getScrollY() + this.B;
        this.f5555j.setColor(this.f5571z);
        canvas.drawRect(rect, this.f5555j);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.remind_num_height);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R$dimen.remind_num_height);
        int scrollX = getScrollX() + ((this.f5559n * 6) / 4);
        rect.right = dimensionPixelSize + scrollX;
        int i10 = rect.top;
        rect.bottom = dimensionPixelSize2 + i10;
        rect.left = scrollX + (this.f5558m * 2);
        rect.top = i10 + getResources().getDimensionPixelSize(R$dimen.line_radius2);
        rect.bottom += getResources().getDimensionPixelSize(R$dimen.line_radius4);
        canvas.drawBitmap(this.E1, (Rect) null, rect, this.f5555j);
        rect.left = rect.right + this.f5559n;
        this.f5555j.setTypeface(s.d());
        this.f5555j.setColor(this.F);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(R$dimen.catchup_remind_text_size);
        this.f5555j.setTextSize(dimensionPixelSize3);
        rect.top = getScrollY() + (this.B / 2);
        rect.bottom = (getScrollY() + this.B) - this.f5559n;
        canvas.drawText(getResources().getString(R$string.subscribe_epg_tip), rect.left, rect.centerY() + (dimensionPixelSize3 / 2), this.f5555j);
    }

    private void G(Canvas canvas, Rect rect) {
        rect.left = getScrollX() + this.f5561p + this.f5558m;
        rect.top = getScrollY() + this.B;
        rect.right = rect.left + getWidth();
        rect.bottom = getScrollY() + this.f5569x;
        this.f5552g.left = getScrollX() + this.f5561p + this.f5558m;
        this.f5552g.top = getScrollY() + this.B;
        this.f5552g.right = getScrollX() + getWidth();
        this.f5552g.bottom = getScrollY() + this.f5569x;
        canvas.save();
        canvas.clipRect(this.f5552g);
        this.f5555j.setColor(getResources().getColor(R$color.epg_time_bar_bg));
        canvas.drawRect(rect, this.f5555j);
        this.f5555j.setColor(getResources().getColor(R$color.epg_time_bar_text_color));
        this.f5555j.setTextSize(this.f5570y);
        for (int i10 = 0; i10 < 10; i10++) {
            long j10 = (((this.M + ((long) (1800000 * i10))) + 900000) / 1800000) * 1800000;
            String strC = g.f21834a.c(j10);
            if (strC.endsWith("00")) {
                float fO = O(j10);
                int i11 = rect.top;
                canvas.drawText(strC, fO, i11 + ((rect.bottom - i11) / 2) + (this.f5570y / 2), this.f5555j);
            }
        }
        canvas.restore();
        I(canvas, rect);
    }

    private void H(Canvas canvas, Rect rect) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (c0(jCurrentTimeMillis)) {
            rect.left = O(jCurrentTimeMillis);
            int scrollY = getScrollY() + this.f5569x;
            rect.top = scrollY;
            rect.right = rect.left + this.f5567v;
            rect.bottom = scrollY + getHeight();
            this.f5555j.setColor(this.f5568w);
            this.f5555j.setMaskFilter(new BlurMaskFilter(5.0f, BlurMaskFilter.Blur.SOLID));
            int dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.line_radius);
            canvas.drawCircle(rect.centerX(), rect.top, dimensionPixelSize, this.f5555j);
            rect.top = getScrollY() + this.f5569x + dimensionPixelSize;
            rect.bottom = getScrollY() + getHeight();
            canvas.drawRect(rect, this.f5555j);
            this.f5555j.setMaskFilter(null);
        }
    }

    private void I(Canvas canvas, Rect rect) {
        rect.left = getScrollX();
        rect.top = (getScrollY() + this.f5569x) - (this.f5558m / 2);
        rect.right = rect.left + getWidth();
        rect.bottom = rect.top + this.f5558m;
        this.f5555j.setColor(this.H);
        canvas.drawRect(rect, this.f5555j);
        rect.left = getScrollX();
        rect.top = getScrollY() + this.B;
        rect.right = rect.left + getWidth();
        rect.bottom = rect.top + this.f5558m;
        canvas.drawRect(rect, this.f5555j);
    }

    private boolean J(List<p> list, long j10) {
        if (list.isEmpty()) {
            return false;
        }
        for (int i10 = 0; i10 < list.size(); i10++) {
            p pVar = list.get(i10);
            if (j10 >= pVar.f().longValue() && j10 <= pVar.g().longValue()) {
                this.Q = i10;
                return true;
            }
        }
        int i11 = this.Q;
        int i12 = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            p pVar2 = list.get(i13);
            if (T(pVar2.f().longValue(), pVar2.g().longValue())) {
                i12++;
                i11 = i13;
            }
            if (pVar2.f().longValue() > this.N) {
                break;
            }
        }
        if (i12 == 0) {
            return false;
        }
        if (i12 <= 2) {
            this.Q = i11;
            return true;
        }
        this.Q = (((i11 * 2) - i12) + 1) / 2;
        return true;
    }

    private Boolean Q(long j10, long j11) {
        boolean z10;
        long jA = u1.b().a();
        if (jA >= j10 && jA <= j11) {
            z10 = true;
        } else {
            z10 = false;
        }
        return Boolean.valueOf(z10);
    }

    private Boolean R(p pVar) {
        boolean z10;
        long jA = u1.b().a();
        if (jA >= pVar.f().longValue() && jA <= pVar.g().longValue()) {
            z10 = true;
        } else {
            z10 = false;
        }
        return Boolean.valueOf(z10);
    }

    private boolean T(long j10, long j11) {
        if (O(j10) < getScrollX() + this.f5561p || j10 > this.N) {
            if (O(j11) < getScrollX() + this.f5561p || j11 > this.N) {
                if (O(j10) <= getScrollX() + this.f5561p && j11 >= this.N) {
                    return true;
                }
                return false;
            }
            return true;
        }
        return true;
    }

    private void Y() {
        this.K = p();
        this.L = q();
        this.M = M(0);
        this.N = M(getWidth());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(int i10, int i11) {
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        if (scrollX + i10 < 0) {
            i10 = 0 - scrollX;
        }
        if (scrollY + i11 < 0) {
            i11 = 0 - scrollY;
        }
        int i12 = scrollX + i10;
        int i13 = this.I;
        int i14 = this.f5561p;
        if (i12 > i13 + i14) {
            i10 = (i13 - scrollX) + i14;
        }
        int i15 = scrollY + i11;
        int i16 = this.J;
        if (i15 > i16) {
            i11 = i16 - scrollY;
        }
        scrollBy(i10, i11);
    }

    private void b0(int i10, long j10, long j11, Rect rect, Canvas canvas) {
        rect.left = O(j11) - this.f5558m;
        int iN = N(i10);
        int i11 = this.f5558m;
        int i12 = iN + i11;
        rect.top = i12;
        rect.right = rect.left + i11;
        rect.bottom = i12 + this.f5560o;
        this.f5555j.setColor(this.H);
        canvas.drawRect(rect, this.f5555j);
        rect.left = O(j10);
        rect.top = N(i10) + this.f5558m;
        rect.right = O(j11) - this.f5558m;
        rect.bottom = rect.top + this.f5560o;
    }

    static /* bridge */ /* synthetic */ f d(EPG epg) {
        epg.getClass();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getFirstVisibleChannelPosition() {
        int scrollY = getScrollY();
        int i10 = this.f5558m;
        int i11 = ((scrollY - i10) - this.f5569x) / (this.f5560o + i10);
        if (i11 < 0) {
            return 0;
        }
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getLastVisibleChannelPosition() {
        int scrollY = getScrollY();
        int iB = this.S.b();
        int height = scrollY + getHeight();
        int i10 = this.f5569x + height;
        int i11 = this.f5558m;
        int i12 = this.f5560o;
        int i13 = (i10 - i11) / (i11 + i12);
        int i14 = iB - 1;
        if (i13 > i14) {
            i13 = i14;
        }
        if (height > i12 * i13 && i13 < i14) {
            return i13 + 1;
        }
        return i13;
    }

    private int getXPositionStart() {
        return O(u1.b().a()) - (((getWidth() - this.f5561p) - this.f5558m) / 2);
    }

    private void n() {
        this.I = (int) (1191600000 / this.K);
    }

    private long p() {
        return 18000000 / ((getResources().getDisplayMetrics().widthPixels - this.f5561p) - this.f5558m);
    }

    private long q() {
        return q1.f(q1.h(), -7);
    }

    private void r(Canvas canvas, Rect rect) {
        rect.left = getScrollX();
        rect.top = getScrollY() + this.B;
        rect.right = rect.left + this.f5561p;
        rect.bottom = getScrollY() + this.f5569x;
        this.f5555j.setColor(this.f5562q);
        canvas.drawRect(rect, this.f5555j);
        this.f5555j.setColor(this.F);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.catchup_channel_text_size);
        float f10 = dimensionPixelSize;
        this.f5555j.setTextSize(f10);
        this.f5555j.setTypeface(s.d());
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(f10);
        String str = String.format("%s(%d/%d)", this.U, Integer.valueOf(this.P + 1), Integer.valueOf(this.S.b()));
        float fMeasureText = rect.left + ((this.f5561p - textPaint.measureText(str)) / 2.0f);
        int i10 = rect.top;
        canvas.drawText(str, fMeasureText, i10 + ((rect.bottom - i10) / 2) + (dimensionPixelSize / 2), this.f5555j);
        rect.bottom = rect.top + this.f5558m;
        this.f5555j.setColor(this.H);
        canvas.drawRect(rect, this.f5555j);
    }

    private void s(Canvas canvas, int i10, Rect rect) {
        rect.left = getScrollX();
        int iN = N(i10);
        rect.top = iN;
        rect.right = rect.left + this.f5561p;
        rect.bottom = this.f5560o + iN;
        this.f5555j.setColor(this.f5562q);
        canvas.drawRect(rect, this.f5555j);
        if (S(i10)) {
            this.f5555j.setColor(this.P1);
            rect.bottom += this.f5558m;
            canvas.drawRect(rect, this.f5555j);
        }
        int scrollX = getScrollX();
        rect.left = scrollX;
        rect.top = iN;
        rect.right = scrollX + getWidth();
        rect.bottom = rect.top + this.f5558m;
        this.f5555j.setColor(this.H);
        canvas.drawRect(rect, this.f5555j);
        h hVarA = this.S.a(i10);
        int i11 = hVarA.i() + 1;
        String str = i11 + "";
        if (i11 < 10) {
            str = "00" + str;
        } else if (i11 < 100) {
            str = "0" + str;
        }
        String str2 = str + " " + hVarA.e();
        this.f5555j.setColor(this.F);
        if (i10 == this.P) {
            this.f5555j.setColor(this.f5565t);
        }
        this.f5555j.setTextSize(getResources().getDimensionPixelSize(R$dimen.catchup_channel_text_size));
        int i12 = rect.left;
        int i13 = this.f5559n;
        rect.left = i12 + i13;
        rect.top += (this.f5560o / 2) + i13;
        rect.right -= i13;
        rect.bottom -= i13;
        this.f5555j.setTypeface(s.d());
        canvas.drawText(str2, rect.left, rect.top, this.f5555j);
        if (s0.f7342a.M(hVarA.f(), hVarA.b(), null)) {
            int scrollX2 = getScrollX() + ((this.f5561p * 8) / 9);
            rect.left = scrollX2;
            rect.right = scrollX2 + getResources().getDimensionPixelSize(R$dimen.catchup_icon_width);
            int dimensionPixelSize = iN + ((this.f5560o - getResources().getDimensionPixelSize(R$dimen.catchup_icon_width)) / 2);
            rect.top = dimensionPixelSize;
            rect.bottom = dimensionPixelSize + getResources().getDimensionPixelSize(R$dimen.catchup_icon_width);
            canvas.drawBitmap(K(getContext(), R$drawable.play_back), (Rect) null, rect, this.f5555j);
        }
    }

    private void t(Canvas canvas, Rect rect) {
        int lastVisibleChannelPosition = getLastVisibleChannelPosition();
        for (int firstVisibleChannelPosition = getFirstVisibleChannelPosition(); firstVisibleChannelPosition <= lastVisibleChannelPosition; firstVisibleChannelPosition++) {
            s(canvas, firstVisibleChannelPosition, rect);
            if (firstVisibleChannelPosition == lastVisibleChannelPosition) {
                rect.left = getScrollX();
                rect.top = N(firstVisibleChannelPosition + 1);
                rect.right = rect.left + getWidth();
                rect.bottom = rect.top + this.f5558m;
                this.f5555j.setColor(this.H);
                canvas.drawRect(rect, this.f5555j);
            }
        }
    }

    private void x(Canvas canvas, Rect rect) {
        rect.left = getScrollX();
        rect.top = getScrollY() + this.B;
        rect.right = rect.left + getWidth();
        rect.bottom = rect.top + this.f5558m;
        this.f5555j.setColor(this.f5571z);
        canvas.drawRect(rect, this.f5555j);
    }

    public void X() {
        invalidate();
        requestLayout();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        W(false);
    }

    public void setEPGClickListener(f fVar) {
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
    }
}
