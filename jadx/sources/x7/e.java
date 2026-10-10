package x7;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.FloatRange;
import com.google.android.material.color.utilities.Contrast;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class e extends a {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f21910l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Path f21911m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private float f21913o;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final LinkedList<a.C0472a> f21909k = new LinkedList<>();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f21912n = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f21914p = false;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f21915q = 0;

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a
    protected void a(ValueAnimator valueAnimator, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f10) {
        float f11 = this.f21913o;
        int i10 = this.f21914p ? this.f21912n + 3 : this.f21912n;
        if (i10 == 0) {
            valueAnimator.setDuration(120L);
            valueAnimator.setInterpolator(new AccelerateInterpolator());
            float f12 = f11 * f10;
            this.f21887i.get(5).e(f12);
            this.f21887i.get(6).e(f12);
            this.f21887i.get(7).e(f12);
            return;
        }
        if (i10 == 1) {
            valueAnimator.setDuration(160L);
            valueAnimator.setInterpolator(new DecelerateInterpolator());
            float f13 = f11 * f10;
            this.f21887i.get(2).e(f13);
            this.f21887i.get(3).e(f13);
            this.f21887i.get(4).e(f13);
            this.f21887i.get(8).e(f13);
            this.f21887i.get(9).e(f13);
            this.f21887i.get(10).e(f13);
            return;
        }
        if (i10 == 2) {
            valueAnimator.setDuration(240L);
            valueAnimator.setInterpolator(new BounceInterpolator());
            float f14 = f11 * f10;
            this.f21887i.get(0).e(f14);
            this.f21887i.get(1).e(f14);
            this.f21887i.get(11).e(f14);
            return;
        }
        if (i10 == 3) {
            valueAnimator.setDuration(120L);
            valueAnimator.setInterpolator(new AccelerateInterpolator());
            float f15 = f11 * (1.0f - f10);
            this.f21887i.get(0).e(f15);
            this.f21887i.get(1).e(f15);
            this.f21887i.get(11).e(f15);
            return;
        }
        if (i10 != 4) {
            if (i10 != 5) {
                return;
            }
            valueAnimator.setDuration(240L);
            valueAnimator.setInterpolator(new BounceInterpolator());
            float f16 = f11 * (1.0f - f10);
            this.f21887i.get(5).e(f16);
            this.f21887i.get(6).e(f16);
            this.f21887i.get(7).e(f16);
            return;
        }
        valueAnimator.setDuration(160L);
        valueAnimator.setInterpolator(new DecelerateInterpolator());
        float f17 = f11 * (1.0f - f10);
        this.f21887i.get(2).e(f17);
        this.f21887i.get(3).e(f17);
        this.f21887i.get(4).e(f17);
        this.f21887i.get(8).e(f17);
        this.f21887i.get(9).e(f17);
        this.f21887i.get(10).e(f17);
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a, android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        int i10 = this.f21912n + 1;
        this.f21912n = i10;
        if (i10 > 2) {
            this.f21912n = 0;
            if (this.f21914p) {
                this.f21915q--;
            } else {
                this.f21915q++;
            }
            int i11 = this.f21915q;
            if (i11 >= 4) {
                this.f21914p = true;
                this.f21915q = 3;
                for (int i12 = 0; i12 < this.f21909k.size(); i12++) {
                    a.C0472a c0472a = this.f21909k.get(i12);
                    if (i12 == this.f21909k.size() - 1) {
                        c0472a.d(true);
                    } else {
                        c0472a.d(false);
                    }
                }
            } else if (i11 < 0) {
                this.f21914p = false;
                this.f21915q = 0;
                for (int i13 = 0; i13 < this.f21909k.size(); i13++) {
                    a.C0472a c0472a2 = this.f21909k.get(i13);
                    if (i13 == 0) {
                        c0472a2.d(false);
                    } else {
                        c0472a2.d(true);
                    }
                }
            }
            if (this.f21914p) {
                Iterator<a.C0472a> it = this.f21887i.iterator();
                while (it.hasNext()) {
                    it.next().e(this.f21913o);
                }
                this.f21909k.get(this.f21915q + 1).d(true);
                return;
            }
            Iterator<a.C0472a> it2 = this.f21887i.iterator();
            while (it2.hasNext()) {
                it2.next().e(0.0f);
            }
            this.f21909k.get(this.f21915q).d(false);
        }
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a
    protected void p(ValueAnimator valueAnimator) {
        valueAnimator.setDuration(120L);
    }

    private void B(Canvas canvas) {
        canvas.save();
        this.f21888j.setStyle(Paint.Style.STROKE);
        Iterator<a.C0472a> it = this.f21909k.iterator();
        while (it.hasNext()) {
            it.next().a(canvas, this.f21910l, this.f21888j);
        }
        canvas.restore();
    }

    private void C(Canvas canvas) {
        canvas.save();
        this.f21888j.setStyle(Paint.Style.FILL_AND_STROKE);
        float size = this.f21909k.size() / 2;
        float f10 = this.f21913o;
        canvas.translate((-(size * f10)) + (f10 * this.f21915q), 0.0f);
        super.y(canvas, this.f21911m, this.f21888j);
        canvas.restore();
    }

    private void D() {
        float fG = g();
        float fH = h();
        a.C0472a c0472a = new a.C0472a(fG - (this.f21913o * 2.0f), fH);
        a.C0472a c0472a2 = new a.C0472a(fG - this.f21913o, fH);
        a.C0472a c0472a3 = new a.C0472a(fG, fH);
        a.C0472a c0472a4 = new a.C0472a(this.f21913o + fG, fH);
        a.C0472a c0472a5 = new a.C0472a(fG + (this.f21913o * 2.0f), fH);
        c0472a.d(false);
        this.f21909k.add(c0472a);
        this.f21909k.add(c0472a2);
        this.f21909k.add(c0472a3);
        this.f21909k.add(c0472a4);
        this.f21909k.add(c0472a5);
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a
    protected void k(Context context, int i10) {
        this.f21910l = d() / 5.0f;
        this.f21913o = f() / 5.0f;
        this.f21911m = new Path();
        z(5.0f);
        A(this.f21910l);
        D();
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a
    protected void n(Canvas canvas) {
        B(canvas);
        C(canvas);
    }

    @Override // com.tvc.lib.mobile.ui.widget.sloading.a
    protected void o() {
    }
}
