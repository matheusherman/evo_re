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
import androidx.core.util.Pair;
import com.live.evo.R$array;
import com.live.evo.R$color;
import com.live.evo.R$dimen;
import com.live.evo.R$drawable;
import com.live.evo.R$string;
import com.live.evo.activity.LiveNewActivity;
import com.live.evo.util.l;
import com.live.evo.util.q1;
import com.live.evo.util.s;
import com.live.evo.util.s0;
import com.live.evo.util.u1;
import com.live.evo.util.x1;
import com.live.evo.util.y;
import i5.h;
import i5.i;
import i5.p;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import r8.z;
import x1.f1.lb.util.g1;
import x4.f;
import x4.g;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class EPG_Dstyle extends ViewGroup implements View.OnKeyListener {
    private final SparseArray<Bitmap> A;
    private final int B;
    private final int C;
    private final int D;
    private TimerTask D1;
    private final int E;
    private long E1;
    private final int F;
    private long F1;
    private final int G;
    private Calendar G1;
    private final int H;
    private List<Integer> H1;
    private int I;
    private int I1;
    private int J;
    private boolean J1;
    private long K;
    private boolean K1;
    private long L;
    private int L1;
    private long M;
    private String M1;
    private long N;
    private boolean N1;
    private int O;
    private List<String> O1;
    private int P;
    private Map<String, i> P1;
    private int Q;
    private boolean Q1;
    private int R;
    private boolean R1;
    private boolean S;
    private String S1;
    private x4.b T;
    private volatile Map<String, x4.b> T1;
    private p U;
    private Map<String, Boolean> U1;
    private int V;
    private y V1;
    private boolean W;
    private final int W1;
    private boolean X1;
    private boolean Y1;
    private boolean Z1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final q6.b f5575a;

    /* JADX INFO: renamed from: a2, reason: collision with root package name */
    Timer f5576a2;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5577b;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    private Bitmap f5578b1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f5579c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f5580d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f5581e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f5582f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Rect f5583g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Rect f5584h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Rect f5585i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Paint f5586j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Scroller f5587k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final GestureDetector f5588l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final int f5589m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final int f5590n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final int f5591o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final int f5592p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final int f5593q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final int f5594r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final int f5595s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final int f5596t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final int f5597u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final int f5598v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final int f5599w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final int f5600x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final int f5601y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final int f5602z;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f5603a;

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Integer num;
            while (EPG_Dstyle.this.H1.size() > EPG_Dstyle.this.I1 && (num = (Integer) EPG_Dstyle.this.H1.remove(0)) != null) {
                try {
                    if (num.intValue() < EPG_Dstyle.this.T.b()) {
                        EPG_Dstyle.this.T.i(num.intValue());
                    }
                } catch (Exception e10) {
                    EPG_Dstyle.this.f5575a.error("EPG onKeyDown TimerTask Error", e10);
                    return;
                }
            }
            int firstVisibleChannelPosition = EPG_Dstyle.this.getFirstVisibleChannelPosition();
            int lastVisibleChannelPosition = EPG_Dstyle.this.getLastVisibleChannelPosition();
            int i10 = lastVisibleChannelPosition - 3;
            if (lastVisibleChannelPosition <= this.f5603a - 3) {
                lastVisibleChannelPosition = i10;
            }
            EPG_Dstyle.this.g0(firstVisibleChannelPosition, lastVisibleChannelPosition);
        }

        a(int i10) {
            this.f5603a = i10;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f5605a;

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Integer num;
            while (EPG_Dstyle.this.H1.size() > EPG_Dstyle.this.I1 && (num = (Integer) EPG_Dstyle.this.H1.remove(0)) != null) {
                try {
                    if (num.intValue() < EPG_Dstyle.this.T.b()) {
                        EPG_Dstyle.this.T.i(num.intValue());
                    }
                } catch (Exception e10) {
                    EPG_Dstyle.this.f5575a.error("EPG onKeyDown TimerTask Error", e10);
                    return;
                }
            }
            int firstVisibleChannelPosition = EPG_Dstyle.this.getFirstVisibleChannelPosition();
            int lastVisibleChannelPosition = EPG_Dstyle.this.getLastVisibleChannelPosition();
            int i10 = lastVisibleChannelPosition - 3;
            if (lastVisibleChannelPosition <= this.f5605a - 3) {
                lastVisibleChannelPosition = i10;
            }
            EPG_Dstyle.this.g0(firstVisibleChannelPosition, lastVisibleChannelPosition);
        }

        b(int i10) {
            this.f5605a = i10;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private class c extends GestureDetector.SimpleOnGestureListener {
        /* synthetic */ c(EPG_Dstyle ePG_Dstyle, x4.i iVar) {
            this();
        }

        private c() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            if (!EPG_Dstyle.this.f5587k.isFinished()) {
                EPG_Dstyle.this.f5587k.forceFinished(true);
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
            EPG_Dstyle.this.f5587k.fling(EPG_Dstyle.this.getScrollX(), EPG_Dstyle.this.getScrollY(), -((int) f10), -((int) f11), 0, EPG_Dstyle.this.I, 0, EPG_Dstyle.this.J);
            EPG_Dstyle.this.i0();
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
            EPG_Dstyle.this.k0((int) f10, (int) f11);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            motionEvent.getX();
            if (EPG_Dstyle.this.R(EPG_Dstyle.this.getScrollY() + ((int) motionEvent.getY())) != -1) {
                EPG_Dstyle.e(EPG_Dstyle.this);
                return true;
            }
            return true;
        }
    }

    public EPG_Dstyle(Context context) {
        this(context, null);
    }

    private long U(int i10) {
        return (((long) i10) * this.K) + this.L;
    }

    private void l0(int i10) {
        if (i10 == 0) {
            if ((V(this.P + 1) - getScrollY()) - this.f5600x < this.f5591o) {
                scrollTo(getScrollX(), V(this.P) - this.f5600x);
                return;
            }
            return;
        }
        if (i10 == 1) {
            int scrollY = getScrollY();
            int height = getHeight() - (V(this.P) - scrollY);
            int i11 = this.f5591o;
            if (height < i11) {
                k0(0, (i11 + this.f5589m) - height);
            }
        }
    }

    private synchronized void o0() {
        try {
            new HashMap();
            this.T = this.T1.get(this.S1);
            this.H1.clear();
            this.Q = 0;
            this.P = 0;
            this.O = 0;
            if (this.T != null) {
                getChannelIconBitmap();
                int i10 = this.P;
                int i11 = i10 - 4;
                int i12 = i10 + 8;
                if (i11 < 0) {
                    i11 = 0;
                }
                List<h> listC = this.T.c();
                List<Pair<List<p>, Boolean>> listF = this.T.f();
                ArrayList arrayList = new ArrayList();
                if (listC != null && listF != null) {
                    int size = listC.size() - 1;
                    if (i12 >= size) {
                        i12 = size;
                    }
                    while (i11 <= i12) {
                        if (listF.size() > i11) {
                            listF.set(i11, new Pair<>(listF.get(i11).first, Boolean.TRUE));
                        }
                        arrayList.add(Integer.valueOf(i11));
                        i11++;
                    }
                }
                p0(arrayList);
            }
            h0(false);
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:298:0x07f8  */
    /* JADX WARN: Code duplicated, block: B:306:0x0807  */
    /* JADX WARN: Code duplicated, block: B:38:0x00b8  */
    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i10, KeyEvent keyEvent) {
        x4.b bVar = this.T;
        if (bVar != null && bVar.b() >= this.P) {
            int keyCode = keyEvent.getKeyCode();
            int i11 = this.P;
            int i12 = this.Q;
            int iB = this.T.b();
            int size = this.O1.size();
            List<p> list = this.T.e(this.P).first;
            Boolean bool = this.T.e(this.P).second;
            this.M = U(getScrollX());
            this.N = U(getScrollX() + getWidth());
            if (keyCode != 23 && keyCode != 66 && keyCode != 4 && (keyCode != 22 || keyEvent.getAction() != 1)) {
                this.Y1 = false;
            }
            if (keyEvent.getAction() == 0) {
                keyEvent.startTracking();
                if (keyCode != 19) {
                    if (keyCode != 82) {
                        if (keyCode == 66) {
                            if (!this.Q1 && !this.R1 && !x1.m(1000L)) {
                                if (!bool.booleanValue() && list.isEmpty()) {
                                    this.T.a(this.P);
                                    throw null;
                                }
                                this.T.d(this.P, this.Q);
                                this.T.a(this.P);
                                throw null;
                            }
                        } else if (keyCode != 67) {
                            switch (keyCode) {
                                case 21:
                                    if (keyEvent.getRepeatCount() < 1) {
                                        this.X1 = false;
                                    } else if (keyEvent.getRepeatCount() >= 1) {
                                        this.X1 = true;
                                        if (!this.Q1 && !this.R1) {
                                            this.Q1 = true;
                                            invalidate();
                                        }
                                    }
                                    break;
                                case 22:
                                    this.Z1 = true;
                                    break;
                                case 23:
                                    if (!this.Q1) {
                                        if (!bool.booleanValue()) {
                                            break;
                                        }
                                        this.T.d(this.P, this.Q);
                                        this.T.a(this.P);
                                        throw null;
                                    }
                                    break;
                            }
                        } else {
                            this.P = this.O;
                            this.W = true;
                            h0(false);
                        }
                    }
                } else if (keyEvent.getRepeatCount() < 1) {
                    this.X1 = false;
                } else if (keyEvent.getRepeatCount() >= 1) {
                    this.X1 = true;
                    if (!this.R1 && !this.Q1) {
                        this.R1 = true;
                        invalidate();
                    }
                }
            }
            if (keyEvent.getAction() == 1) {
                switch (keyCode) {
                    case 19:
                        if (!this.X1 && !this.R1) {
                            if (this.Q1) {
                                int i13 = this.R;
                                if (i13 > 0) {
                                    int i14 = i13 - 1;
                                    this.R = i14;
                                    this.S1 = this.P1.get(this.O1.get(i14)).h();
                                    o0();
                                }
                            } else {
                                int i15 = this.P;
                                if (i15 > 0) {
                                    this.P = i15 - 1;
                                    e0(0);
                                }
                            }
                        }
                        Map<String, Boolean> map = this.U1;
                        if (map != null && map.get(this.S1) != null && !this.U1.get(this.S1).booleanValue()) {
                            TimerTask timerTask = this.D1;
                            if (timerTask != null) {
                                timerTask.cancel();
                            }
                            a aVar = new a(iB);
                            this.D1 = aVar;
                            this.f5576a2.schedule(aVar, 500L);
                        }
                        if (keyCode != 20 || keyCode == 19 || keyCode == 21 || keyCode == 22) {
                            invalidate();
                        }
                        break;
                    case 20:
                        if (this.R1) {
                            this.R1 = false;
                            this.Q1 = false;
                            p pVarD = this.T.d(this.P, 0);
                            if (pVarD != null && pVarD.f().longValue() > this.N) {
                                this.Q = 0;
                                P(this.T.e(this.P).first, 0);
                                this.F1 = pVarD.f().longValue();
                                this.K1 = true;
                                invalidate();
                                return true;
                            }
                            x4.b bVar2 = this.T;
                            int i16 = this.P;
                            p pVarD2 = bVar2.d(i16, bVar2.g(i16) - 1);
                            if (pVarD2 != null && ((this.M + this.N) - (((long) this.f5592p) * this.K)) / 2 > pVarD2.f().longValue() && this.T.e(this.P) != null) {
                                this.Q = this.T.g(this.P) - 1;
                                P(this.T.e(this.P).first, 0);
                                this.F1 = pVarD2.f().longValue();
                                this.K1 = true;
                            }
                        } else if (this.Q1) {
                            int i17 = this.R;
                            if (i17 < size - 1) {
                                int i18 = i17 + 1;
                                this.R = i18;
                                this.S1 = this.P1.get(this.O1.get(i18)).h();
                                o0();
                            }
                        } else if (i11 < iB - 1) {
                            this.P++;
                            e0(1);
                        }
                        Map<String, Boolean> map2 = this.U1;
                        if (map2 != null && map2.get(this.S1) != null && !this.U1.get(this.S1).booleanValue()) {
                            TimerTask timerTask2 = this.D1;
                            if (timerTask2 != null) {
                                timerTask2.cancel();
                            }
                            b bVar3 = new b(iB);
                            this.D1 = bVar3;
                            this.f5576a2.schedule(bVar3, 500L);
                        }
                        if (keyCode != 20) {
                            invalidate();
                        } else {
                            invalidate();
                        }
                        break;
                    case 21:
                        if (this.R1) {
                            long jG = q1.g(u1.b().a());
                            TimeUnit timeUnit = TimeUnit.DAYS;
                            long millis = jG - timeUnit.toMillis(7L);
                            long millis2 = (((this.M + this.N) - (((long) this.f5592p) * this.K)) / 2) - timeUnit.toMillis(1L);
                            if (millis2 >= millis) {
                                k0(-((int) (timeUnit.toMillis(1L) / this.K)), 0);
                                millis = millis2;
                            } else {
                                scrollTo(W(millis) - (this.f5589m + this.f5592p), getScrollY());
                            }
                            this.F1 = millis;
                            p pVarD3 = this.T.d(this.P, this.Q);
                            if (pVarD3 != null && d0(pVarD3.f().longValue(), pVarD3.g().longValue())) {
                                this.K1 = true;
                                invalidate();
                                return false;
                            }
                            boolean zN = N(list, millis);
                            this.K1 = zN;
                            if (zN) {
                                invalidate();
                                return false;
                            }
                        } else {
                            boolean z10 = this.X1;
                            if (z10 || this.Q1) {
                                if (z10 && !this.Q1) {
                                    this.Q1 = true;
                                }
                            } else if (bool.booleanValue()) {
                                if (list.isEmpty()) {
                                    g1.f21390a.e(getContext().getString(R$string.current_channel_no_epg));
                                } else {
                                    if (this.Q == 0) {
                                        g1.f21390a.e(getContext().getString(R$string.no_more_epg));
                                    }
                                    if (this.Q >= list.size() || list.get(0).f().longValue() > this.N || list.get(list.size() - 1).g().longValue() < this.M) {
                                        for (int i19 = 0; i19 < list.size(); i19++) {
                                            p pVar = list.get(i19);
                                            long j10 = ((this.M + this.N) - (this.K * ((long) this.f5592p))) / 2;
                                            if (d0(pVar.f().longValue(), pVar.g().longValue()) && j10 >= pVar.f().longValue() && j10 <= pVar.g().longValue()) {
                                                this.Q = i19;
                                            } else if (d0(pVar.f().longValue(), pVar.g().longValue()) && j10 <= pVar.f().longValue()) {
                                                this.Q = i19;
                                            }
                                        }
                                    } else if (i12 > 0) {
                                        this.Q--;
                                        O(list, 2);
                                    }
                                    if (this.Q >= list.size() || list.get(0).f().longValue() > this.N || list.get(list.size() - 1).g().longValue() < this.M) {
                                        if (list.get(0).f().longValue() > this.N) {
                                            this.Q = 0;
                                        } else if (list.get(list.size() - 1).g().longValue() < this.M) {
                                            this.Q = list.size() - 1;
                                        } else {
                                            this.Q = list.size() - 1;
                                        }
                                        scrollTo((W(list.get(this.Q).f().longValue()) - this.f5589m) - this.f5592p, getScrollY());
                                    } else {
                                        p pVar2 = list.get(this.Q);
                                        long jLongValue = pVar2.f().longValue();
                                        long jLongValue2 = pVar2.g().longValue();
                                        if (jLongValue >= this.M || !c0(list.get(0).f().longValue(), list.get(0).g().longValue())) {
                                            int scrollX = getScrollX() + getWidth();
                                            int i20 = this.f5589m;
                                            int i21 = this.f5592p;
                                            long j11 = this.K;
                                            if (jLongValue2 > (((long) (scrollX - ((i20 * 2) + i21))) * j11) + this.L) {
                                                k0(((int) ((jLongValue2 - this.N) / j11)) + (i20 * 2) + i21, 0);
                                            }
                                        } else {
                                            k0(((int) ((jLongValue - this.M) / this.K)) + this.f5589m, 0);
                                        }
                                    }
                                    this.K1 = true;
                                }
                            }
                        }
                        if (keyCode != 20) {
                            invalidate();
                        } else {
                            invalidate();
                        }
                        break;
                    case 22:
                        if (this.Z1) {
                            this.Z1 = false;
                            if (this.R1) {
                                long timeInMillis = q1.e(q1.h(), 6).getTimeInMillis();
                                long j12 = ((this.M + this.N) - (this.K * ((long) this.f5592p))) / 2;
                                TimeUnit timeUnit2 = TimeUnit.DAYS;
                                long millis3 = j12 + timeUnit2.toMillis(1L);
                                if (millis3 <= timeInMillis) {
                                    k0((int) (timeUnit2.toMillis(1L) / this.K), 0);
                                    timeInMillis = millis3;
                                } else {
                                    scrollTo(W(timeInMillis) - (this.f5589m + this.f5592p), getScrollY());
                                }
                                this.F1 = timeInMillis;
                                p pVarD4 = this.T.d(this.P, this.Q);
                                if (pVarD4 != null && d0(pVarD4.f().longValue(), pVarD4.g().longValue())) {
                                    this.K1 = true;
                                    invalidate();
                                    return false;
                                }
                                boolean zN2 = N(list, timeInMillis);
                                this.K1 = zN2;
                                if (zN2) {
                                    invalidate();
                                    return false;
                                }
                            } else {
                                boolean z11 = this.Q1;
                                if (z11) {
                                    if (z11 && !this.U1.get(this.S1).booleanValue()) {
                                        this.Q1 = false;
                                        invalidate();
                                        return true;
                                    }
                                } else if (bool.booleanValue()) {
                                    if (list.isEmpty()) {
                                        g1.f21390a.e(getContext().getString(R$string.current_channel_no_epg));
                                    } else {
                                        if (this.Q == list.size() - 1) {
                                            g1.f21390a.e(getContext().getString(R$string.no_more_epg));
                                        }
                                        if (this.Q >= list.size() || list.get(0).f().longValue() > this.N || list.get(list.size() - 1).g().longValue() < this.M) {
                                            for (int i22 = 0; i22 < list.size(); i22++) {
                                                p pVar3 = list.get(i22);
                                                long j13 = ((this.M + this.N) - (((long) this.f5592p) * this.K)) / 2;
                                                if (d0(pVar3.f().longValue(), pVar3.g().longValue()) && j13 >= pVar3.f().longValue() && j13 <= pVar3.g().longValue()) {
                                                    this.Q = i22;
                                                    this.K1 = true;
                                                } else if (d0(pVar3.f().longValue(), pVar3.g().longValue()) && j13 <= pVar3.f().longValue()) {
                                                    this.Q = i22;
                                                    this.K1 = true;
                                                }
                                            }
                                        } else if (this.Q < list.size() && list.get(this.Q).g().longValue() < q1.f(q1.h(), 7) && this.Q < list.size() - 1) {
                                            this.Q++;
                                            O(list, 1);
                                        }
                                        if (this.Q >= list.size() || list.get(0).f().longValue() > this.N || list.get(list.size() - 1).g().longValue() < this.M) {
                                            if (list.get(0).f().longValue() > this.N) {
                                                this.Q = 0;
                                            } else if (list.get(list.size() - 1).g().longValue() < this.M) {
                                                this.Q = list.size() - 1;
                                            } else {
                                                this.Q = list.size() - 1;
                                            }
                                            scrollTo((W(list.get(this.Q).f().longValue()) - this.f5589m) - this.f5592p, getScrollY());
                                        } else {
                                            p pVar4 = list.get(this.Q);
                                            long jLongValue3 = pVar4.g().longValue();
                                            long jLongValue4 = pVar4.f().longValue();
                                            int scrollX2 = getScrollX() + getWidth();
                                            int i23 = this.f5589m;
                                            int i24 = this.f5592p;
                                            long j14 = this.K;
                                            if (jLongValue3 > (((long) (scrollX2 - ((i23 * 2) + i24))) * j14) + this.L) {
                                                k0(((int) ((jLongValue3 - this.N) / j14)) + i23 + i24, 0);
                                            } else if (jLongValue4 < this.M) {
                                                scrollTo((W(jLongValue4) - this.f5592p) + this.f5589m, getScrollY());
                                            }
                                        }
                                        this.K1 = true;
                                    }
                                }
                            }
                        }
                        if (keyCode != 20) {
                            invalidate();
                        } else {
                            invalidate();
                        }
                        break;
                    default:
                        if (keyCode != 20) {
                            invalidate();
                        } else {
                            invalidate();
                        }
                        break;
                }
            }
            if (keyCode != 4 && keyCode == 111) {
                invalidate();
            }
        }
        return false;
    }

    public EPG_Dstyle(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:22:0x00c8 A[LOOP:0: B:21:0x00c6->B:22:0x00c8, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:25:0x00db  */
    /* JADX WARN: Code duplicated, block: B:27:0x00e0 A[LOOP:1: B:26:0x00de->B:27:0x00e0, LOOP_END] */
    private void A(Canvas canvas, Rect rect) {
        long j10;
        long jLongValue;
        long jH;
        int dimensionPixelSize;
        Canvas canvas2;
        Rect rect2;
        int i10;
        int i11;
        p pVarD = this.T.d(this.P, this.Q);
        if (this.R1) {
            long j11 = this.F1;
            if (j11 != 0 || pVarD == null) {
                j10 = j11;
            } else {
                jLongValue = pVarD.f().longValue();
                this.F1 = jLongValue;
            }
            rect.left = getScrollX() + (this.f5592p * 2);
            rect.top = getScrollY();
            rect.right = rect.left + getWidth();
            rect.bottom = rect.top + this.B;
            this.f5583g.left = getScrollX() + this.f5592p;
            this.f5583g.top = getScrollY();
            this.f5583g.right = getScrollX() + getWidth();
            Rect rect3 = this.f5583g;
            rect3.bottom = rect3.top + this.B;
            canvas.save();
            canvas.clipRect(this.f5583g);
            this.f5586j.setColor(this.f5602z);
            canvas.drawRect(rect, this.f5586j);
            jH = q1.h();
            dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.date_wide);
            if (jH > j10) {
                for (i11 = 0; i11 < 7; i11++) {
                    z(canvas, rect, dimensionPixelSize, q1.e(jH, i11 - 7), i11, j10);
                }
                canvas2 = canvas;
                rect2 = rect;
            } else {
                canvas2 = canvas;
                rect2 = rect;
                for (i10 = 0; i10 < 7; i10++) {
                    z(canvas2, rect2, dimensionPixelSize, q1.e(jH, i10), i10, j10);
                }
            }
            this.f5586j.setTextSize(this.E);
            this.f5586j.setTypeface(s.d());
            CharSequence charSequence = getResources().getTextArray(R$array.month)[new Date().getMonth()];
            rect2.left = getScrollX() + (this.V / 2) + this.G + dimensionPixelSize + getResources().getDimensionPixelSize(R$dimen.date_move_right);
            int scrollY = getScrollY();
            rect2.top = scrollY;
            rect2.right = rect2.left + dimensionPixelSize;
            rect2.bottom = scrollY + this.B;
            canvas2.drawText(charSequence.toString(), rect2.left + (dimensionPixelSize / 4), rect2.centerY() + (this.E / 2), this.f5586j);
            B(canvas2, rect2);
            canvas2.restore();
        }
        if (this.Y1 || pVarD == null || !d0(pVarD.f().longValue(), pVarD.g().longValue())) {
            jLongValue = this.F1;
        } else {
            jLongValue = pVarD.f().longValue();
            this.F1 = jLongValue;
        }
        j10 = jLongValue;
        rect.left = getScrollX() + (this.f5592p * 2);
        rect.top = getScrollY();
        rect.right = rect.left + getWidth();
        rect.bottom = rect.top + this.B;
        this.f5583g.left = getScrollX() + this.f5592p;
        this.f5583g.top = getScrollY();
        this.f5583g.right = getScrollX() + getWidth();
        Rect rect4 = this.f5583g;
        rect4.bottom = rect4.top + this.B;
        canvas.save();
        canvas.clipRect(this.f5583g);
        this.f5586j.setColor(this.f5602z);
        canvas.drawRect(rect, this.f5586j);
        jH = q1.h();
        dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.date_wide);
        if (jH > j10) {
            while (i11 < 7) {
                z(canvas, rect, dimensionPixelSize, q1.e(jH, i11 - 7), i11, j10);
            }
            canvas2 = canvas;
            rect2 = rect;
        } else {
            canvas2 = canvas;
            rect2 = rect;
            while (i10 < 7) {
                z(canvas2, rect2, dimensionPixelSize, q1.e(jH, i10), i10, j10);
            }
        }
        this.f5586j.setTextSize(this.E);
        this.f5586j.setTypeface(s.d());
        CharSequence charSequence2 = getResources().getTextArray(R$array.month)[new Date().getMonth()];
        rect2.left = getScrollX() + (this.V / 2) + this.G + dimensionPixelSize + getResources().getDimensionPixelSize(R$dimen.date_move_right);
        int scrollY2 = getScrollY();
        rect2.top = scrollY2;
        rect2.right = rect2.left + dimensionPixelSize;
        rect2.bottom = scrollY2 + this.B;
        canvas2.drawText(charSequence2.toString(), rect2.left + (dimensionPixelSize / 4), rect2.centerY() + (this.E / 2), this.f5586j);
        B(canvas2, rect2);
        canvas2.restore();
    }

    private void C(Canvas canvas, int i10, p pVar, Rect rect, int i11) {
        if (pVar.f().longValue() > this.E1) {
            F(canvas, i10, pVar, rect);
        }
        this.E1 = pVar.g().longValue();
        long j10 = ((this.M + this.N) - (((long) this.f5592p) * this.K)) / 2;
        if (this.W && this.P == i10 && j10 >= pVar.f().longValue() && j10 < pVar.g().longValue()) {
            this.Q = i11;
            this.W = false;
        }
        if (this.W && this.P == i10 && j10 < pVar.f().longValue()) {
            this.Q = i11;
            this.W = false;
        }
        m0(i10, pVar.f().longValue(), pVar.g().longValue(), rect, canvas);
        boolean z10 = this.O == i10 && a0(pVar).booleanValue();
        int color = this.f5594r;
        if (z10) {
            if (this.S) {
                this.Q = i11;
                this.S = false;
                this.W = false;
            }
            color = getResources().getColor(R$color.current_play);
        } else if (a0(pVar).booleanValue()) {
            color = this.f5595s;
            if (this.U == null) {
                this.U = pVar;
            }
        }
        if (i11 == 0) {
            rect.left -= this.f5589m;
        }
        this.f5586j.setColor(color);
        canvas.drawRect(rect, this.f5586j);
        boolean zB0 = b0(i10);
        if (zB0) {
            if (this.Q1 || this.R1 || i11 != this.Q || !d0(pVar.f().longValue(), pVar.g().longValue())) {
                this.f5586j.setColor(this.L1);
            } else {
                this.f5586j.setColor(getResources().getColor(R$color.select_color));
            }
            canvas.drawRect(rect, this.f5586j);
        }
        int i12 = rect.left;
        int i13 = this.f5590n;
        rect.left = i12 + i13;
        rect.right -= i13;
        if (zB0 && !z10 && i11 == this.Q && (this.Q1 || this.R1)) {
            this.f5586j.setColor(getResources().getColor(R$color.select_color));
        } else {
            this.f5586j.setColor(this.F);
        }
        this.f5586j.setTextSize(this.f5597u);
        String strE = pVar.e();
        this.f5586j.getTextBounds(strE, 0, strE.length(), this.f5585i);
        int i14 = rect.top;
        rect.top = i14 + ((rect.bottom - i14) / 2) + (this.f5585i.height() / 2);
        this.f5586j.setTypeface(s.c());
        int iW = W(this.M);
        if (rect.left < iW) {
            rect.left = iW + this.f5590n;
        }
        canvas.drawText(strE.substring(0, this.f5586j.breakText(strE, true, rect.right - rect.left, null)), rect.left, rect.top, this.f5586j);
        if (this.J1) {
            h hVarA = this.T.a(i10);
            if (s0.f7342a.O(pVar, hVarA != null ? hVarA.b() : null)) {
                rect.top = V(i10) + 5;
                rect.right = (rect.left + getResources().getDimensionPixelSize(R$dimen.catchup_icon_width2)) - this.f5589m;
                rect.bottom = rect.top + getResources().getDimensionPixelSize(R$dimen.catchup_icon_width2);
                canvas.drawBitmap(this.f5578b1, (Rect) null, rect, this.f5586j);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:82:0x02cb  */
    private void D(Canvas canvas, Rect rect) {
        p pVarD;
        int lastVisibleChannelPosition = getLastVisibleChannelPosition();
        for (int firstVisibleChannelPosition = getFirstVisibleChannelPosition(); firstVisibleChannelPosition <= lastVisibleChannelPosition; firstVisibleChannelPosition++) {
            this.E1 = 0L;
            this.f5583g.left = getScrollX() + this.f5592p + this.f5589m;
            int iV = V(firstVisibleChannelPosition);
            Rect rect2 = this.f5583g;
            rect2.top = this.f5589m + iV;
            rect2.right = getScrollX() + getWidth();
            Rect rect3 = this.f5583g;
            rect3.bottom = rect3.top + this.f5591o;
            canvas.save();
            canvas.clipRect(this.f5583g);
            x4.b bVar = this.T;
            if (bVar != null && bVar.e(firstVisibleChannelPosition) != null) {
                List<p> list = this.T.e(firstVisibleChannelPosition).first;
                boolean zB0 = b0(firstVisibleChannelPosition);
                if (list.isEmpty()) {
                    rect.left = getScrollX() + this.f5592p + this.f5589m;
                    rect.top = iV;
                    rect.right = getScrollX() + getWidth();
                    rect.bottom = rect.top + this.f5591o + this.f5589m;
                    this.f5586j.setColor(this.f5594r);
                    canvas.drawRect(rect, this.f5586j);
                    if (zB0) {
                        if (this.Q1 || this.R1) {
                            this.f5586j.setColor(this.L1);
                        } else {
                            this.f5586j.setColor(getResources().getColor(R$color.select_color));
                        }
                        rect.left = getScrollX() + this.f5592p;
                        rect.top = iV;
                        rect.right = getScrollX() + getWidth();
                        rect.bottom = rect.top + this.f5591o + this.f5589m;
                        canvas.drawRect(rect, this.f5586j);
                    }
                    this.f5586j.setColor(this.F);
                    if (zB0 && (this.Q1 || this.R1)) {
                        this.f5586j.setColor(getResources().getColor(R$color.select_color));
                    }
                    String string = this.M1;
                    if (!this.T.e(firstVisibleChannelPosition).second.booleanValue()) {
                        string = getResources().getString(2131952317);
                    }
                    this.f5586j.setTextSize(this.f5597u);
                    TextPaint textPaint = new TextPaint();
                    textPaint.setTextSize(this.f5601y);
                    float fMeasureText = textPaint.measureText(string);
                    rect.top += (this.f5591o / 2) + (this.f5601y / 2);
                    canvas.drawText(string, rect.left + ((((getWidth() - this.f5592p) - this.f5589m) - fMeasureText) / 2.0f), rect.top, this.f5586j);
                } else {
                    for (int i10 = 0; i10 < list.size(); i10++) {
                        p pVar = list.get(i10);
                        if (pVar.f().longValue() > this.N) {
                            if (pVar.f().longValue() <= this.E1) {
                                break;
                            }
                            F(canvas, firstVisibleChannelPosition, pVar, rect);
                            this.E1 = pVar.g().longValue();
                            break;
                        }
                        int i11 = this.P;
                        if (i10 == i11 && !this.W && (pVarD = this.T.d(i11, this.Q)) != null && !d0(pVarD.f().longValue(), pVarD.g().longValue())) {
                            this.W = true;
                        }
                        if (d0(pVar.f().longValue(), pVar.g().longValue())) {
                            this.H1.remove(Integer.valueOf(firstVisibleChannelPosition));
                            this.H1.add(Integer.valueOf(firstVisibleChannelPosition));
                            C(canvas, firstVisibleChannelPosition, pVar, rect, i10);
                        }
                        if (i10 == list.size() - 1) {
                            Long lG = pVar.g();
                            Boolean bool = Boolean.TRUE;
                            if (lG.longValue() < this.N) {
                                long jLongValue = lG.longValue();
                                long j10 = this.M;
                                if (jLongValue < j10) {
                                    rect.left = W(j10) - this.f5589m;
                                    bool = Boolean.FALSE;
                                } else {
                                    rect.left = W(lG.longValue());
                                }
                                rect.top = this.f5589m + iV;
                                rect.right = W(this.N);
                                rect.bottom = rect.top + this.f5591o;
                                this.f5586j.setColor(this.f5594r);
                                if (zB0) {
                                    if (this.Q1 || this.R1 || bool.booleanValue()) {
                                        this.f5586j.setColor(this.L1);
                                    } else {
                                        this.f5586j.setColor(getResources().getColor(R$color.select_color));
                                    }
                                }
                                canvas.drawRect(rect, this.f5586j);
                                if (!zB0 || (!(this.Q1 || this.R1) || bool.booleanValue())) {
                                    this.f5586j.setColor(this.F);
                                } else {
                                    this.f5586j.setColor(getResources().getColor(R$color.select_color));
                                }
                                this.f5586j.setTextSize(this.f5597u);
                                int i12 = rect.left;
                                int i13 = this.f5590n;
                                rect.left = i12 + i13;
                                rect.right -= i13;
                                int i14 = rect.top;
                                int iHeight = i14 + ((rect.bottom - i14) / 2) + (this.f5585i.height() / 2);
                                rect.top = iHeight;
                                canvas.drawText(this.M1, rect.left, iHeight, this.f5586j);
                            }
                        }
                    }
                }
                int scrollX = getScrollX();
                rect.left = scrollX;
                rect.top = iV;
                rect.right = scrollX + getWidth();
                rect.bottom = rect.top + this.f5589m;
                this.f5586j.setColor(this.H);
                canvas.drawRect(rect, this.f5586j);
                canvas.restore();
            }
        }
    }

    private void E(Canvas canvas, Rect rect) {
        this.f5583g.left = getScrollX() + this.f5592p + this.f5589m;
        this.f5583g.top = getScrollY() + this.f5600x;
        Rect rect2 = this.f5583g;
        rect2.right = rect2.left + getWidth();
        Rect rect3 = this.f5583g;
        rect3.bottom = rect3.top + getHeight();
        canvas.save();
        canvas.clipRect(this.f5583g);
        rect.left = getScrollX() + this.f5592p + this.f5589m;
        rect.top = getScrollY() + this.f5600x;
        rect.right = this.f5583g.left + getWidth();
        rect.bottom = this.f5583g.top + getHeight();
        this.f5586j.setColor(this.f5593q);
        canvas.drawRect(rect, this.f5586j);
        this.f5586j.setColor(this.F);
        this.f5586j.setTextSize(this.f5597u);
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(this.f5597u);
        int iMeasureText = (int) textPaint.measureText(getResources().getString(R$string.catchup_init_remind));
        rect.top = getScrollY() + this.f5600x + (((getHeight() - this.f5600x) - this.f5597u) / 2);
        rect.left = getScrollX() + this.f5592p + (((getWidth() - this.f5592p) - iMeasureText) / 2);
        this.f5586j.setTypeface(s.c());
        canvas.drawText(getResources().getString(R$string.catchup_init_remind), rect.left, rect.top, this.f5586j);
        canvas.restore();
    }

    private void F(Canvas canvas, int i10, p pVar, Rect rect) {
        long j10 = this.E1;
        long j11 = this.M;
        if (j10 < j11) {
            this.E1 = j11 - (((long) this.f5589m) * this.K);
        }
        m0(i10, this.E1, pVar.f().longValue() - ((long) this.f5589m), rect, canvas);
        this.f5586j.setColor(this.f5594r);
        if (Z(this.E1, pVar.f().longValue()).booleanValue()) {
            this.f5586j.setColor(this.f5595s);
        }
        canvas.drawRect(rect, this.f5586j);
        if (b0(i10)) {
            this.f5586j.setColor(this.L1);
            canvas.drawRect(rect, this.f5586j);
        }
        rect.left += this.f5590n;
        this.f5586j.setColor(this.F);
        this.f5586j.setTextSize(this.f5597u);
        Paint paint = this.f5586j;
        String str = this.M1;
        paint.getTextBounds(str, 0, str.length(), this.f5585i);
        int i11 = rect.top;
        rect.top = i11 + ((rect.bottom - i11) / 2) + (this.f5585i.height() / 2);
        this.f5586j.setTypeface(s.c());
        int iW = W(this.M);
        if (rect.left < iW) {
            rect.left = iW;
        }
        String str2 = this.M1;
        canvas.drawText(str2.substring(0, this.f5586j.breakText(str2, true, rect.right - rect.left, null)), rect.left, rect.top, this.f5586j);
    }

    private void G(Canvas canvas, Rect rect) {
        this.f5586j.setStyle(Paint.Style.FILL);
    }

    private void O(List<p> list, int i10) {
        int i11;
        p pVar;
        if (list == null || (i11 = this.Q) < 0 || i11 >= list.size() || (pVar = list.get(this.Q)) == null) {
            return;
        }
        int iW = ((W(pVar.f().longValue()) + W(pVar.g().longValue())) / 2) - W(((this.M + this.N) - (((long) this.f5592p) * this.K)) / 2);
        if (i10 == 0) {
            k0(iW, 0);
            return;
        }
        if (i10 != 1) {
            if (i10 != 2) {
                return;
            }
        } else if (iW > 0) {
            k0(iW, 0);
        }
        if (iW >= 0 || c0(list.get(0).f().longValue(), list.get(0).g().longValue())) {
            return;
        }
        k0(iW, 0);
    }

    private void P(List<p> list, int i10) {
        int i11;
        p pVar;
        if (list == null || (i11 = this.Q) < 0 || i11 >= list.size() || (pVar = list.get(this.Q)) == null) {
            return;
        }
        int iW = ((W(pVar.f().longValue()) + W(pVar.f().longValue())) / 2) - W(((this.M + this.N) - (((long) this.f5592p) * this.K)) / 2);
        if (i10 == 0) {
            k0(iW, 0);
            return;
        }
        if (i10 != 1) {
            if (i10 != 2) {
                return;
            }
        } else if (iW > 0) {
            k0(iW, 0);
        }
        if (iW >= 0 || c0(list.get(0).f().longValue(), list.get(0).g().longValue())) {
            return;
        }
        k0(iW, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int R(int i10) {
        int i11 = i10 - this.f5600x;
        int i12 = this.f5589m;
        int i13 = (i11 + i12) / (this.f5591o + i12);
        if (this.T.b() == 0) {
            return -1;
        }
        return i13;
    }

    private int V(int i10) {
        int i11 = this.f5591o;
        int i12 = this.f5589m;
        return (i10 * (i11 + i12)) + i12 + this.f5600x;
    }

    private int W(long j10) {
        return ((int) ((j10 - this.L) / this.K)) + this.f5592p + (this.f5589m * 2);
    }

    private void Y() {
        this.O1 = new ArrayList();
        this.P1 = new HashMap();
        this.T1 = new HashMap();
        this.U1 = new HashMap();
        s0 s0Var = s0.f7342a;
        Map<String, i> mapT = s0Var.t();
        HashMap<String, List<h>> mapC = s0Var.C();
        List<String> listU = t.v.c.i.a.f18646a.u(Boolean.TRUE);
        for (int i10 = 0; i10 < listU.size(); i10++) {
            String str = listU.get(i10);
            if (str != null && !str.equals("favorite") && mapC.get(str) != null && mapC.get(str).size() != 0 && !s(str)) {
                this.O1.add(str);
                this.P1.put(str, mapT.get(str));
            }
        }
    }

    private boolean b0(int i10) {
        return i10 == this.P;
    }

    private void e0(int i10) {
        List<p> list = this.T.e(this.P).first;
        l0(i10);
        if (list.isEmpty()) {
            return;
        }
        p pVar = this.U;
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            p pVar2 = list.get(i11);
            long j10 = ((this.M + this.N) - (((long) this.f5592p) * this.K)) / 2;
            if (pVar2.f().longValue() > j10) {
                this.Q = i11;
                O(list, 0);
                this.K1 = true;
                return;
            }
            if (j10 >= pVar2.f().longValue() && j10 < pVar2.g().longValue() && d0(pVar2.f().longValue(), pVar2.g().longValue())) {
                this.Q = i11;
                if (pVar != null && i11 < size - 1 && pVar.f().longValue() > pVar2.f().longValue()) {
                    int i12 = i11 + 1;
                    p pVar3 = list.get(i12);
                    if (pVar3.f().longValue() >= pVar.f().longValue() && pVar3.g().longValue() <= pVar.g().longValue() && d0(pVar3.f().longValue(), pVar3.g().longValue())) {
                        this.Q = i12;
                    }
                }
                this.K1 = true;
                return;
            }
        }
        this.K1 = N(list, ((this.M + this.N) - (((long) this.f5592p) * this.K)) / 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g0(int i10, int i11) {
        if (i10 < i11) {
            getFirstVisibleChannelPosition();
            getLastVisibleChannelPosition();
            SparseArray sparseArray = new SparseArray();
            while (i10 <= i11) {
                if (!this.T.e(i10).second.booleanValue()) {
                    sparseArray.put(i10, this.T.a(i10).f());
                }
                i10++;
            }
        }
    }

    private boolean n0(long j10) {
        return j10 >= this.M && j10 < this.N;
    }

    private void p() {
        int iV = V(this.T.b() - 2) + this.f5591o;
        this.J = iV < getHeight() ? 0 : (iV - getHeight()) + this.f5591o + (this.f5589m * 2);
    }

    private boolean s(String str) {
        i iVar = s0.f7342a.t().get(str);
        return iVar != null && iVar.g() == 1;
    }

    private void y(Canvas canvas, Rect rect) {
        p pVarD = this.T.d(this.P, this.Q);
        if (pVarD != null) {
            this.K1 = d0(pVarD.f().longValue(), pVarD.g().longValue());
        }
        if (!this.K1) {
            G(canvas, rect);
            return;
        }
        p pVarD2 = this.T.d(this.P, this.Q);
        this.f5586j.setMaskFilter(new BlurMaskFilter(10.0f, BlurMaskFilter.Blur.SOLID));
        if (pVarD2 == null) {
            G(canvas, rect);
        } else if (d0(pVarD2.f().longValue(), pVarD2.g().longValue())) {
            this.U = pVarD2;
        } else {
            List<p> list = this.T.e(this.P).first;
            if (list != null && !list.isEmpty()) {
                int size = list.size();
                for (int i10 = 0; i10 < size; i10++) {
                    p pVar = list.get(i10);
                    long j10 = ((this.M + this.N) - (((long) this.f5592p) * this.K)) / 2;
                    if (j10 < pVar.f().longValue() || j10 >= pVar.g().longValue()) {
                        if (pVar.f().longValue() > this.N) {
                            break;
                        }
                    } else if (d0(pVar.f().longValue(), pVar.g().longValue())) {
                        this.Q = i10;
                        y(canvas, rect);
                        return;
                    }
                }
            }
        }
        this.f5586j.setMaskFilter(null);
    }

    private void z(Canvas canvas, Rect rect, int i10, Calendar calendar, int i11, long j10) {
        int color;
        int dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.date_move_right);
        rect.left = getScrollX() + ((this.V * 2) / 3) + this.G + ((i11 + 2) * i10) + dimensionPixelSize;
        int scrollY = getScrollY();
        rect.top = scrollY;
        rect.right = rect.left + i10;
        rect.bottom = scrollY + this.B;
        Calendar calendar2 = Calendar.getInstance();
        calendar.setTimeZone(l.d().c());
        calendar2.setTimeZone(l.d().c());
        calendar2.setTimeInMillis(j10);
        int color2 = getResources().getColor(R$color.date_normal);
        int i12 = calendar.get(5);
        Date date = new Date();
        Calendar calendarE = q1.e(q1.h(), -7);
        Calendar calendarE2 = q1.e(q1.h(), 6);
        int i13 = this.F;
        if (calendar2.get(5) == i12 || (calendar2.getTimeInMillis() < calendarE.getTimeInMillis() && calendar.get(5) == calendarE.get(5))) {
            if (this.R1) {
                color2 = getResources().getColor(R$color.select_color);
                color = this.f5596t;
            } else {
                color = getResources().getColor(R$color.select_color);
            }
            i13 = color;
            this.f5586j.setShadowLayer(3.0f, 5.0f, 5.0f, getResources().getColor(2131099811));
            this.G1 = calendar2;
        } else if (calendar.get(5) == date.getDate()) {
            color2 = getResources().getColor(R$color.current_today);
        }
        this.f5586j.setColor(color2);
        canvas.drawCircle(rect.centerX(), rect.centerY(), i10 / 3, this.f5586j);
        this.f5586j.clearShadowLayer();
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(this.C);
        String str = i12 + "";
        float fMeasureText = textPaint.measureText(str);
        float dimensionPixelSize2 = (this.B / 2) + getResources().getDimensionPixelSize(R$dimen.catchup_date_padding);
        float f10 = i10 / 2;
        this.f5586j.setColor(i13);
        this.f5586j.setTextSize(this.C);
        this.f5586j.setTypeface(Typeface.DEFAULT);
        canvas.drawText(str, rect.left + (f10 - (fMeasureText / 2.0f)), rect.top + dimensionPixelSize2, this.f5586j);
        this.f5586j.setTypeface(s.b());
        this.f5586j.setTextSize(this.D);
        TextPaint textPaint2 = new TextPaint();
        textPaint2.setTextSize(this.D);
        String strL = q1.l(calendar.getTimeInMillis());
        canvas.drawText(strL, rect.left + (f10 - (textPaint2.measureText(strL) / 2.0f)), rect.top + dimensionPixelSize2 + (this.C / 2), this.f5586j);
        this.f5586j.setColor(this.F);
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
            int color3 = getResources().getColor(R$color.unfocus_tri);
            if (calendar2.get(5) == calendarE.get(5)) {
                this.f5586j.setColor(color3);
            } else {
                this.f5586j.setColor(this.f5596t);
            }
            canvas.drawPath(path, this.f5586j);
            Path path2 = new Path();
            rect.left = ((int) (getScrollX() + ((this.V * 9) / 7) + this.G + (i10 * 8.2f))) + dimensionPixelSize + getResources().getDimensionPixelSize(R$dimen.catchup_right_triangle);
            rect.top = getScrollY();
            path2.moveTo(rect.left, (getScrollY() + (this.B / 2)) - i14);
            path2.lineTo(rect.left, getScrollY() + (this.B / 2) + i14);
            path2.lineTo(rect.left + f11, getScrollY() + (this.B / 2));
            if (calendar2.get(5) == calendarE2.get(5)) {
                this.f5586j.setColor(color3);
            } else {
                this.f5586j.setColor(this.f5596t);
            }
            canvas.drawPath(path2, this.f5586j);
        }
    }

    public Bitmap Q(Context context, int i10) {
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

    public void S(List<h> list) {
        s0.f7342a.y(list, this.V1, getResources(), new c9.a() { // from class: x4.h
            @Override // c9.a
            public final Object invoke() {
                return this.f21838a.f0();
            }
        });
    }

    public void X(boolean z10, int i10) {
        this.S = z10;
        if (z10) {
            this.O = i10;
            this.P = i10;
        }
    }

    public x4.b getCatchUpdata() {
        return this.T;
    }

    public List<h> getChannels() {
        return this.T.c();
    }

    public String getCurFocusCategoryId() {
        int size = this.O1.size();
        int i10 = this.R;
        if (size > i10) {
            return this.O1.get(i10);
        }
        return null;
    }

    public void h0(boolean z10) {
        x4.b bVar = this.T;
        if (bVar == null || !bVar.h()) {
            return;
        }
        j0();
        p();
        o();
        int i10 = this.O;
        if (this.O > this.T.b() - ((getHeight() - this.f5600x) / (this.f5591o + this.f5589m))) {
            this.f5587k.startScroll(getScrollX(), getScrollY(), (getXPositionStart() - getScrollX()) - this.f5592p, this.J - getScrollY(), z10 ? 600 : 0);
        } else {
            this.f5587k.startScroll(getScrollX(), getScrollY(), (getXPositionStart() - getScrollX()) - this.f5592p, (V(i10) - this.f5600x) - getScrollY(), z10 ? 600 : 0);
        }
        i0();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        x4.b bVar = this.T;
        if (bVar == null || !bVar.h()) {
            return;
        }
        this.M = U(getScrollX());
        this.N = U(getScrollX() + getWidth());
        Rect rect = this.f5584h;
        rect.left = getScrollX();
        rect.top = getScrollY();
        rect.right = rect.left + getWidth();
        rect.bottom = rect.top + getHeight();
        this.f5586j.setColor(getResources().getColor(R$color.catchup_bg_3));
        canvas.drawRect(rect, this.f5586j);
        if (this.U1.get(this.S1).booleanValue()) {
            E(canvas, rect);
        }
        x(canvas, rect);
        rect.left = getScrollX() + (this.f5592p / 2);
        int scrollY = getScrollY();
        rect.top = scrollY;
        rect.right = rect.left + this.f5589m;
        rect.bottom = scrollY + getHeight();
        this.f5586j.setColor(this.H);
        canvas.drawRect(rect, this.f5586j);
        rect.left = getScrollX() + this.f5592p;
        int scrollY2 = getScrollY();
        rect.top = scrollY2;
        rect.right = rect.left + this.f5589m;
        rect.bottom = scrollY2 + getHeight();
        this.f5586j.setColor(this.H);
        canvas.drawRect(rect, this.f5586j);
        u(canvas, rect);
        if (!this.U1.get(this.S1).booleanValue()) {
            D(canvas, rect);
        }
        K(canvas, rect);
        v(canvas, rect);
        if (!this.U1.get(this.S1).booleanValue()) {
            if (!this.Q1 && !this.R1) {
                y(canvas, rect);
            }
            L(canvas, rect);
        }
        if (this.J1) {
            I(canvas, rect);
            J(canvas, rect);
        } else {
            H(canvas, rect);
        }
        A(canvas, rect);
        if (this.f5587k.computeScrollOffset()) {
            scrollTo(this.f5587k.getCurrX(), this.f5587k.getCurrY());
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.f5588l.onTouchEvent(motionEvent);
    }

    public void p0(List<Integer> list) {
        if (list != null) {
            this.H1.addAll(list);
        }
    }

    public EPG_Dstyle(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f5575a = q6.c.d(EPG_Dstyle.class);
        this.f5577b = getClass().getSimpleName();
        this.f5579c = 604800000;
        this.f5580d = 604800000;
        this.f5581e = 18000000;
        this.f5582f = 1800000;
        this.O = 10;
        this.P = 0;
        this.Q = 0;
        this.R = 0;
        this.S = true;
        this.W = false;
        this.F1 = u1.b().a();
        this.H1 = new ArrayList();
        this.J1 = false;
        this.K1 = true;
        this.W1 = 4;
        this.Y1 = true;
        this.f5576a2 = new Timer();
        setFocusable(true);
        requestFocus();
        setOnKeyListener(this);
        setWillNotDraw(false);
        this.I1 = 20;
        this.V1 = y.l(((LiveNewActivity) context).getSupportFragmentManager(), new y.b());
        j0();
        X(true, this.P);
        this.f5584h = new Rect();
        this.f5583g = new Rect();
        this.f5585i = new Rect();
        this.f5586j = new Paint(1);
        this.f5588l = new GestureDetector(context, new c(this, null));
        this.A = new SparseArray<>();
        Scroller scroller = new Scroller(context);
        this.f5587k = scroller;
        scroller.setFriction(0.2f);
        this.f5602z = getResources().getColor(R$color.epg_background);
        this.f5589m = getResources().getDimensionPixelSize(R$dimen.epg_channel_layout_margin);
        this.f5590n = getResources().getDimensionPixelSize(R$dimen.epg_channel_layout_padding);
        this.f5591o = getResources().getDimensionPixelSize(R$dimen.epg_channel_layout_height);
        this.f5592p = getResources().getDimensionPixelSize(R$dimen.epg_channel_layout_width_d);
        this.G = getResources().getDimensionPixelSize(R$dimen.epg_date_margin);
        this.V = getResources().getDimensionPixelSize(R$dimen.date_space);
        this.B = getResources().getDimensionPixelSize(R$dimen.date_layout_height);
        this.f5593q = getResources().getColor(R$color.epg_channel_layout_background);
        this.f5594r = getResources().getColor(R$color.epg_event_layout_background);
        this.f5595s = getResources().getColor(R$color.epg_event_layout_background_current);
        this.f5596t = getResources().getColor(R$color.epg_event_select_text);
        this.F = getResources().getColor(R$color.epg_event_default_text);
        this.L1 = getResources().getColor(R$color.current_channel);
        this.H = getResources().getColor(R$color.epg_spacing);
        this.f5597u = getResources().getDimensionPixelSize(R$dimen.epg_event_layout_text);
        this.f5600x = getResources().getDimensionPixelSize(R$dimen.epg_time_bar_height);
        this.f5601y = getResources().getDimensionPixelSize(R$dimen.epg_time_bar_text);
        this.C = getResources().getDimensionPixelSize(R$dimen.epg_time_bar_Date_text);
        this.E = getResources().getDimensionPixelSize(R$dimen.epg_time_bar_Month_text);
        this.D = getResources().getDimensionPixelSize(R$dimen.epg_time_bar_week_text);
        this.f5598v = getResources().getDimensionPixelSize(R$dimen.epg_time_bar_line_width);
        this.M1 = getResources().getString(R$string.not_data);
        this.f5599w = getResources().getColor(R$color.epg_time_line);
        this.f5578b1 = Q(getContext(), R$drawable.catchup_subscribe_icon_small);
        this.N1 = true;
        Y();
    }

    private void B(Canvas canvas, Rect rect) {
        rect.left = getScrollX();
        rect.top = getScrollY() + this.B;
        rect.right = rect.left + getWidth();
        rect.bottom = rect.top + this.f5589m;
        this.f5586j.setColor(this.f5602z);
        canvas.drawRect(rect, this.f5586j);
    }

    private void H(Canvas canvas, Rect rect) {
        rect.left = getScrollX();
        rect.top = getScrollY();
        rect.right = rect.left + (this.f5592p * 3);
        rect.bottom = getScrollY() + this.B;
        this.f5586j.setColor(this.f5602z);
        canvas.drawRect(rect, this.f5586j);
        if (!this.N1) {
            return;
        }
        rect.left = getScrollX() + this.f5590n;
        this.f5586j.setTypeface(s.d());
        this.f5586j.setColor(this.F);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.catchup_remind_text_size);
        float f10 = dimensionPixelSize;
        this.f5586j.setTextSize(f10);
        rect.top = getScrollY();
        rect.bottom = getScrollY() + this.B;
        String string = getResources().getString(R$string.catchup_press_d);
        int i10 = dimensionPixelSize / 2;
        canvas.drawText(string, rect.left, rect.centerY() + i10, this.f5586j);
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(f10);
        float fMeasureText = textPaint.measureText(string);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R$dimen.remind_num_height_d);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(R$dimen.remind_num_height_d);
        rect.left = getScrollX() + ((int) fMeasureText) + ((this.f5590n * 6) / 4);
        int scrollY = getScrollY() + ((this.B - dimensionPixelSize3) / 2);
        rect.top = scrollY;
        int i11 = rect.left;
        rect.right = i11 + dimensionPixelSize2;
        rect.bottom = scrollY + dimensionPixelSize3;
        rect.left = i11 + (this.f5589m * 2);
        rect.top = scrollY + getResources().getDimensionPixelSize(R$dimen.line_radius);
        rect.bottom += getResources().getDimensionPixelSize(R$dimen.line_radius2);
        Path path = new Path();
        path.moveTo((rect.left + rect.right) / 2, rect.top);
        int i12 = dimensionPixelSize2 / 2;
        float f11 = (dimensionPixelSize3 * 1.71f) / 2.0f;
        path.lineTo(((rect.left + rect.right) / 2) - i12, rect.top + f11);
        path.lineTo(((rect.left + rect.right) / 2) + i12, rect.top + f11);
        path.lineTo((rect.left + rect.right) / 2, rect.top);
        this.f5586j.setColor(this.f5596t);
        canvas.drawPath(path, this.f5586j);
        rect.left = rect.right + (this.f5589m * 3);
        rect.bottom = getScrollY() + this.B;
        rect.top = getScrollY();
        rect.left += this.f5589m * 2;
        canvas.drawText(getResources().getString(R$string.catchup_remind2_d), rect.left, rect.centerY() + i10, this.f5586j);
    }

    private void I(Canvas canvas, Rect rect) {
        rect.left = getScrollX();
        rect.top = getScrollY();
        rect.right = rect.left + (this.f5592p * 3);
        rect.bottom = getScrollY() + (this.B / 2);
        this.f5586j.setColor(this.f5602z);
        canvas.drawRect(rect, this.f5586j);
        if (!this.N1) {
            return;
        }
        rect.left = getScrollX() + this.f5590n;
        this.f5586j.setTypeface(s.d());
        this.f5586j.setColor(this.F);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.catchup_remind_text_size);
        float f10 = dimensionPixelSize;
        this.f5586j.setTextSize(f10);
        rect.top = getScrollY();
        rect.bottom = getScrollY() + (this.B / 2);
        String string = getResources().getString(R$string.catchup_press_d);
        int i10 = dimensionPixelSize / 2;
        canvas.drawText(string, rect.left, rect.centerY() + i10, this.f5586j);
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(f10);
        float fMeasureText = textPaint.measureText(string);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R$dimen.remind_num_height_d);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(R$dimen.remind_num_height_d);
        rect.left = getScrollX() + ((int) fMeasureText) + ((this.f5590n * 6) / 4);
        int scrollY = getScrollY() + (((rect.bottom - rect.top) - dimensionPixelSize3) / 2);
        rect.top = scrollY;
        int i11 = rect.left;
        rect.right = i11 + dimensionPixelSize2;
        rect.bottom = scrollY + dimensionPixelSize3;
        rect.left = i11 + (this.f5589m * 2);
        rect.top = scrollY + getResources().getDimensionPixelSize(R$dimen.line_radius);
        rect.bottom += getResources().getDimensionPixelSize(R$dimen.line_radius2);
        Path path = new Path();
        path.moveTo((rect.left + rect.right) / 2, rect.top);
        int i12 = dimensionPixelSize2 / 2;
        float f11 = (dimensionPixelSize3 * 1.71f) / 2.0f;
        path.lineTo(((rect.left + rect.right) / 2) - i12, rect.top + f11);
        path.lineTo(((rect.left + rect.right) / 2) + i12, rect.top + f11);
        path.lineTo((rect.left + rect.right) / 2, rect.top);
        this.f5586j.setColor(this.f5596t);
        canvas.drawPath(path, this.f5586j);
        rect.left = rect.right + (this.f5589m * 3);
        rect.bottom = getScrollY() + (this.B / 2);
        rect.top = getScrollY();
        rect.left += this.f5589m * 2;
        canvas.drawText(getResources().getString(R$string.catchup_remind2_d), rect.left, rect.centerY() + i10, this.f5586j);
    }

    private void J(Canvas canvas, Rect rect) {
        rect.left = getScrollX();
        rect.top = getScrollY() + (this.B / 2);
        rect.right = rect.left + (this.f5592p * 2);
        rect.bottom = getScrollY() + this.B;
        this.f5586j.setColor(this.f5602z);
        canvas.drawRect(rect, this.f5586j);
        if (!this.N1) {
            return;
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.catchup_remind_text_size);
        this.f5586j.setColor(this.F);
        this.f5586j.setTypeface(s.d());
        int scrollY = getScrollY() + this.B;
        int i10 = this.f5590n;
        rect.bottom = scrollY - i10;
        int i11 = rect.left + i10;
        rect.left = i11;
        rect.right = i11 + (i10 * 5);
        String string = getResources().getString(R$string.catchup_press_d);
        int i12 = dimensionPixelSize / 2;
        canvas.drawText(string, rect.left, rect.centerY() + i12, this.f5586j);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R$dimen.remind_num_height_d);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(R$dimen.remind_num_height_d);
        TextPaint textPaint = new TextPaint();
        float f10 = dimensionPixelSize;
        textPaint.setTextSize(f10);
        int scrollX = getScrollX() + ((int) textPaint.measureText(string)) + ((this.f5590n * 6) / 4);
        rect.right = dimensionPixelSize2 + scrollX;
        int i13 = rect.top;
        rect.bottom = i13 + dimensionPixelSize3;
        rect.left = scrollX + (this.f5589m * 2);
        rect.top = i13 + getResources().getDimensionPixelSize(R$dimen.line_radius2);
        rect.bottom += getResources().getDimensionPixelSize(R$dimen.line_radius4);
        Path path = new Path();
        path.moveTo(rect.left, rect.bottom);
        float f11 = (dimensionPixelSize3 * 1.71f) / 2.0f;
        int i14 = dimensionPixelSize3 / 2;
        path.lineTo(rect.left + f11, rect.bottom - i14);
        path.lineTo(rect.left + f11, rect.bottom + i14);
        path.lineTo(rect.left, rect.bottom);
        this.f5586j.setColor(this.f5596t);
        canvas.drawPath(path, this.f5586j);
        rect.left = rect.right + this.f5590n;
        this.f5586j.setTextSize(f10);
        rect.top = getScrollY() + (this.B / 2);
        rect.bottom = (getScrollY() + this.B) - this.f5590n;
        canvas.drawText(getResources().getString(R$string.subscribe_epg_tip_d), rect.left, rect.centerY() + i12, this.f5586j);
    }

    private void K(Canvas canvas, Rect rect) {
        rect.left = getScrollX() + this.f5592p + this.f5589m;
        rect.top = getScrollY() + this.B;
        rect.right = rect.left + getWidth();
        rect.bottom = getScrollY() + this.f5600x;
        this.f5583g.left = getScrollX() + this.f5592p + this.f5589m;
        this.f5583g.top = getScrollY() + this.B;
        this.f5583g.right = getScrollX() + getWidth();
        this.f5583g.bottom = getScrollY() + this.f5600x;
        canvas.save();
        canvas.clipRect(this.f5583g);
        this.f5586j.setColor(getResources().getColor(R$color.epg_time_bar_bg));
        canvas.drawRect(rect, this.f5586j);
        this.f5586j.setColor(getResources().getColor(R$color.epg_time_bar_text_color));
        this.f5586j.setTextSize(this.f5601y);
        for (int i10 = 0; i10 < 10; i10++) {
            long j10 = (((this.M + ((long) (1800000 * i10))) + 900000) / 1800000) * 1800000;
            String strC = g.f21834a.c(j10);
            if (strC.endsWith("00")) {
                float fW = W(j10);
                int i11 = rect.top;
                canvas.drawText(strC, fW, i11 + ((rect.bottom - i11) / 2) + (this.f5601y / 2), this.f5586j);
            }
        }
        canvas.restore();
        M(canvas, rect);
    }

    private void L(Canvas canvas, Rect rect) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (n0(jCurrentTimeMillis)) {
            rect.left = W(jCurrentTimeMillis);
            int scrollY = getScrollY() + this.f5600x;
            rect.top = scrollY;
            rect.right = rect.left + this.f5598v;
            rect.bottom = scrollY + getHeight();
            this.f5586j.setColor(this.f5599w);
            this.f5586j.setMaskFilter(new BlurMaskFilter(5.0f, BlurMaskFilter.Blur.SOLID));
            int dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.line_radius);
            canvas.drawCircle(rect.centerX(), rect.top, dimensionPixelSize, this.f5586j);
            rect.top = getScrollY() + this.f5600x + dimensionPixelSize;
            rect.bottom = getScrollY() + getHeight();
            canvas.drawRect(rect, this.f5586j);
            this.f5586j.setMaskFilter(null);
        }
    }

    private void M(Canvas canvas, Rect rect) {
        rect.left = getScrollX();
        rect.top = (getScrollY() + this.f5600x) - (this.f5589m / 2);
        rect.right = rect.left + getWidth();
        rect.bottom = rect.top + this.f5589m;
        this.f5586j.setColor(this.H);
        canvas.drawRect(rect, this.f5586j);
        rect.left = getScrollX();
        rect.top = getScrollY() + this.B;
        rect.right = rect.left + getWidth();
        rect.bottom = rect.top + this.f5589m;
        canvas.drawRect(rect, this.f5586j);
    }

    private boolean N(List<p> list, long j10) {
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
            if (d0(pVar2.f().longValue(), pVar2.g().longValue())) {
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

    private int T(int i10) {
        int height = (i10 + ((getHeight() / this.f5591o) - 1)) - 1;
        int size = this.O1.size() - 1;
        if (height > size) {
            return size;
        }
        return height;
    }

    private Boolean Z(long j10, long j11) {
        boolean z10;
        long jA = u1.b().a();
        if (jA >= j10 && jA <= j11) {
            z10 = true;
        } else {
            z10 = false;
        }
        return Boolean.valueOf(z10);
    }

    private Boolean a0(p pVar) {
        boolean z10;
        long jA = u1.b().a();
        if (jA >= pVar.f().longValue() && jA <= pVar.g().longValue()) {
            z10 = true;
        } else {
            z10 = false;
        }
        return Boolean.valueOf(z10);
    }

    private boolean c0(long j10, long j11) {
        if (W(j10) >= getScrollX() + this.f5592p && j10 <= this.N) {
            return true;
        }
        return false;
    }

    private boolean d0(long j10, long j11) {
        if (W(j10) < getScrollX() + this.f5592p || j10 > this.N) {
            if (W(j11) < getScrollX() + this.f5592p || j11 > this.N) {
                if (W(j10) <= getScrollX() + this.f5592p && j11 >= this.N) {
                    return true;
                }
                return false;
            }
            return true;
        }
        return true;
    }

    static /* bridge */ /* synthetic */ f e(EPG_Dstyle ePG_Dstyle) {
        ePG_Dstyle.getClass();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ z f0() {
        invalidate();
        return null;
    }

    private int getFirstVisibleCategoryPosition() {
        int height = (getHeight() / this.f5591o) - 1;
        int i10 = height / 2;
        if (this.O1.size() <= height) {
            return 0;
        }
        int size = this.O1.size();
        int i11 = this.R;
        if (size - i11 > i10) {
            if (i11 <= i10) {
                return 0;
            }
            return i11 - i10;
        }
        return this.O1.size() - height;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getFirstVisibleChannelPosition() {
        int scrollY = getScrollY();
        int i10 = this.f5589m;
        int i11 = ((scrollY - i10) - this.f5600x) / (this.f5591o + i10);
        if (i11 < 0) {
            return 0;
        }
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getLastVisibleChannelPosition() {
        int scrollY = getScrollY();
        int iB = this.T.b();
        int height = scrollY + getHeight();
        int i10 = this.f5600x + height;
        int i11 = this.f5589m;
        int i12 = this.f5591o;
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
        return W(u1.b().a()) - (((getWidth() - this.f5592p) - this.f5589m) / 2);
    }

    private void j0() {
        this.K = q();
        this.L = r();
        this.M = U(0);
        this.N = U(getWidth());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k0(int i10, int i11) {
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
        int i14 = this.f5592p;
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

    private void m0(int i10, long j10, long j11, Rect rect, Canvas canvas) {
        rect.left = W(j11) - this.f5589m;
        int iV = V(i10);
        int i11 = this.f5589m;
        int i12 = iV + i11;
        rect.top = i12;
        rect.right = rect.left + i11;
        rect.bottom = i12 + this.f5591o;
        this.f5586j.setColor(this.H);
        canvas.drawRect(rect, this.f5586j);
        rect.left = W(j10);
        rect.top = V(i10) + this.f5589m;
        rect.right = W(j11) - this.f5589m;
        rect.bottom = rect.top + this.f5591o;
    }

    private void o() {
        this.I = (int) (1191600000 / this.K);
    }

    private long q() {
        return 18000000 / ((getResources().getDisplayMetrics().widthPixels - this.f5592p) - this.f5589m);
    }

    private long r() {
        return q1.f(q1.h(), -7);
    }

    private void t(Canvas canvas, int i10, Rect rect, int i11, int i12) {
        int color;
        rect.left = getScrollX();
        int scrollY = getScrollY() + this.f5600x;
        int i13 = this.f5591o;
        int i14 = scrollY + ((this.f5589m + i13) * (i10 - i11));
        rect.top = i14;
        rect.right = rect.left + (this.f5592p / 2);
        rect.bottom = i13 + i14;
        this.f5586j.setColor(this.f5593q);
        canvas.drawRect(rect, this.f5586j);
        int scrollX = getScrollX();
        rect.left = scrollX;
        rect.top = i14;
        rect.right = scrollX + (this.f5592p / 2);
        getResources().getColor(R$color.current_category);
        if (i10 == this.R && this.Q1) {
            rect.bottom = rect.top + this.f5591o + this.f5589m;
            color = getResources().getColor(R$color.select_color);
        } else {
            rect.bottom = rect.top + this.f5589m;
            color = getResources().getColor(R$color.epg_spacing);
        }
        this.f5586j.setColor(color);
        canvas.drawRect(rect, this.f5586j);
        String strH = this.P1.get(this.O1.get(i10)).h();
        this.f5586j.setColor(this.F);
        int i15 = rect.left;
        int i16 = this.f5590n;
        rect.left = i15 + (i16 * 2);
        rect.top += (this.f5591o / 2) + i16;
        rect.right -= i16;
        rect.bottom -= i16;
        this.f5586j.setTypeface(s.d());
        int dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.catchup_category_text_size_d);
        int i17 = (rect.right - rect.left) + 10;
        this.f5586j.setTextSize(dimensionPixelSize);
        if (this.f5586j.measureText(strH) > i17) {
            dimensionPixelSize = (int) ((dimensionPixelSize * i17) / this.f5586j.measureText(strH));
        }
        this.f5586j.setTextSize(dimensionPixelSize);
        if (i10 == this.R && !this.Q1) {
            this.f5586j.setColor(getResources().getColor(R$color.select_color));
        }
        canvas.drawText(strH, rect.left, rect.top, this.f5586j);
    }

    private void u(Canvas canvas, Rect rect) {
        int firstVisibleCategoryPosition = getFirstVisibleCategoryPosition();
        int iT = T(firstVisibleCategoryPosition);
        int i10 = firstVisibleCategoryPosition;
        while (i10 <= iT) {
            Canvas canvas2 = canvas;
            Rect rect2 = rect;
            t(canvas2, i10, rect2, firstVisibleCategoryPosition, iT);
            if (i10 == iT) {
                rect2.left = getScrollX();
                int iV = V(i10 + 1);
                rect2.top = iV;
                rect2.right = rect2.left + (this.f5592p / 2);
                rect2.bottom = iV + this.f5589m;
                this.f5586j.setColor(this.H);
                canvas2.drawRect(rect2, this.f5586j);
            }
            i10++;
            canvas = canvas2;
            rect = rect2;
        }
    }

    private void v(Canvas canvas, Rect rect) {
        rect.left = getScrollX();
        rect.top = getScrollY() + this.B;
        rect.right = rect.left + this.f5592p;
        rect.bottom = getScrollY() + this.f5600x;
        this.f5586j.setColor(this.f5593q);
        canvas.drawRect(rect, this.f5586j);
        this.f5586j.setColor(this.F);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.catchup_category_text_size_d);
        float f10 = dimensionPixelSize;
        this.f5586j.setTextSize(f10);
        this.f5586j.setTypeface(s.d());
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(f10);
        String str = String.format("%s(%d/%d)", this.S1, Integer.valueOf(this.P + 1), Integer.valueOf(this.T.b()));
        float fMeasureText = rect.left + ((this.f5592p - textPaint.measureText(str)) / 2.0f);
        int i10 = rect.top;
        canvas.drawText(str, fMeasureText, i10 + ((rect.bottom - i10) / 2) + (dimensionPixelSize / 2), this.f5586j);
        rect.bottom = rect.top + this.f5589m;
        this.f5586j.setColor(this.H);
        canvas.drawRect(rect, this.f5586j);
    }

    private void w(Canvas canvas, int i10, Rect rect) {
        rect.left = getScrollX() + (this.f5592p / 2);
        int iV = V(i10);
        rect.top = iV;
        rect.right = rect.left + (this.f5592p / 2);
        rect.bottom = this.f5591o + iV;
        this.f5586j.setColor(this.f5593q);
        canvas.drawRect(rect, this.f5586j);
        boolean zB0 = b0(i10);
        if (zB0) {
            this.f5586j.setColor(getResources().getColor(R$color.current_channel));
            rect.bottom += this.f5589m;
            canvas.drawRect(rect, this.f5586j);
        }
        int scrollX = getScrollX() + (this.f5592p / 2);
        rect.left = scrollX;
        rect.top = iV;
        rect.right = scrollX + getWidth();
        rect.bottom = rect.top + this.f5589m;
        this.f5586j.setColor(this.H);
        canvas.drawRect(rect, this.f5586j);
        h hVarA = this.T.a(i10);
        int i11 = hVarA.i() + 1;
        String str = i11 + "";
        if (i11 < 10) {
            str = "00" + str;
        } else if (i11 < 100) {
            str = "0" + str;
        }
        String strTrim = hVarA.e().trim();
        this.f5586j.setColor(this.F);
        if (i10 == this.P) {
            this.f5586j.setColor(this.f5596t);
        }
        this.f5586j.setTextSize(getResources().getDimensionPixelSize(R$dimen.catchup_channel_index_size_d));
        this.f5586j.setTypeface(s.d());
        int i12 = rect.left;
        int i13 = this.f5590n;
        rect.left = i12 + (i13 * 3);
        rect.top += (this.f5591o / 2) + i13;
        rect.right = getScrollX() + ((this.f5592p * 2) / 3);
        rect.bottom -= this.f5590n;
        if (zB0) {
            this.f5586j.setColor(getResources().getColor(R$color.select_color));
        }
        canvas.drawText(str, rect.left, rect.top, this.f5586j);
        this.f5586j.setTextSize(getResources().getDimensionPixelSize(R$dimen.catchup_channel_text_size_d));
        rect.left = getScrollX() + ((this.f5592p * 5) / 6);
        rect.top += this.f5590n * 2;
        rect.right = getScrollX() + this.f5592p;
        rect.bottom -= this.f5590n;
        this.f5586j.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(strTrim.trim(), rect.left, rect.top, this.f5586j);
        this.f5586j.setTextAlign(Paint.Align.LEFT);
        int scrollX2 = getScrollX() + ((this.f5592p * 2) / 3) + (this.f5590n * 4);
        rect.left = scrollX2;
        rect.right = scrollX2 + getResources().getDimensionPixelSize(R$dimen.catchup_channel_icon_width_d);
        int dimensionPixelSize = (((this.f5591o - getResources().getDimensionPixelSize(R$dimen.catchup_channel_icon_height_d)) / 2) + iV) - (this.f5589m * 5);
        rect.top = dimensionPixelSize;
        rect.bottom = dimensionPixelSize + getResources().getDimensionPixelSize(R$dimen.catchup_channel_icon_height_d);
        if (this.V1.h(hVarA.g()) != null) {
            this.f5586j.setFlags(3);
            canvas.drawBitmap(this.V1.h(hVarA.g()).getBitmap(), (Rect) null, rect, this.f5586j);
        }
        if (s0.f7342a.M(hVarA.f(), hVarA.b(), null)) {
            int i14 = rect.right + this.f5590n;
            rect.left = i14;
            rect.right = i14 + getResources().getDimensionPixelSize(R$dimen.catchup_icon_width);
            int dimensionPixelSize2 = iV + ((this.f5591o - getResources().getDimensionPixelSize(R$dimen.catchup_icon_width)) / 2);
            rect.top = dimensionPixelSize2;
            rect.bottom = dimensionPixelSize2 + getResources().getDimensionPixelSize(R$dimen.catchup_icon_width);
            canvas.drawBitmap(Q(getContext(), R$drawable.play_back), (Rect) null, rect, this.f5586j);
        }
    }

    private void x(Canvas canvas, Rect rect) {
        int lastVisibleChannelPosition = getLastVisibleChannelPosition();
        for (int firstVisibleChannelPosition = getFirstVisibleChannelPosition(); firstVisibleChannelPosition <= lastVisibleChannelPosition; firstVisibleChannelPosition++) {
            w(canvas, firstVisibleChannelPosition, rect);
            if (firstVisibleChannelPosition == lastVisibleChannelPosition) {
                rect.left = getScrollX() + (this.f5592p / 2);
                rect.top = V(firstVisibleChannelPosition + 1);
                rect.right = rect.left + getWidth();
                rect.bottom = rect.top + this.f5589m;
                this.f5586j.setColor(this.H);
                canvas.drawRect(rect, this.f5586j);
            }
        }
    }

    public void getChannelIconBitmap() {
        int firstVisibleChannelPosition = getFirstVisibleChannelPosition();
        int height = (getHeight() / this.f5591o) - 1;
        if (height < 0) {
            height = 6;
        }
        int size = firstVisibleChannelPosition + height;
        List<h> listC = this.T.c();
        if (listC != null && listC.size() >= 0) {
            if (firstVisibleChannelPosition > listC.size()) {
                if (listC.size() - height >= 0) {
                    firstVisibleChannelPosition = listC.size() - height;
                } else {
                    firstVisibleChannelPosition = 0;
                }
                size = listC.size();
            }
            if (size >= listC.size()) {
                S(listC.subList(firstVisibleChannelPosition, listC.size()));
            } else {
                S(listC.subList(firstVisibleChannelPosition, size));
                S(listC.subList(size, listC.size()));
            }
        }
    }

    public void i0() {
        invalidate();
        requestLayout();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        h0(false);
    }

    public void setEPGClickListener(f fVar) {
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
    }
}
