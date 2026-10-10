package s5;

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
    private float f18353l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Path f18354m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private float f18356o;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final LinkedList<a.C0354a> f18352k = new LinkedList<>();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f18355n = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f18357p = false;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f18358q = 0;

    @Override // com.live.evo.widget.sloading.a
    protected void a(ValueAnimator valueAnimator, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f10) {
        float f11 = this.f18356o;
        int i10 = this.f18357p ? this.f18355n + 3 : this.f18355n;
        if (i10 == 0) {
            valueAnimator.setDuration(120L);
            valueAnimator.setInterpolator(new AccelerateInterpolator());
            float f12 = f11 * f10;
            this.f18330i.get(5).e(f12);
            this.f18330i.get(6).e(f12);
            this.f18330i.get(7).e(f12);
            return;
        }
        if (i10 == 1) {
            valueAnimator.setDuration(160L);
            valueAnimator.setInterpolator(new DecelerateInterpolator());
            float f13 = f11 * f10;
            this.f18330i.get(2).e(f13);
            this.f18330i.get(3).e(f13);
            this.f18330i.get(4).e(f13);
            this.f18330i.get(8).e(f13);
            this.f18330i.get(9).e(f13);
            this.f18330i.get(10).e(f13);
            return;
        }
        if (i10 == 2) {
            valueAnimator.setDuration(240L);
            valueAnimator.setInterpolator(new BounceInterpolator());
            float f14 = f11 * f10;
            this.f18330i.get(0).e(f14);
            this.f18330i.get(1).e(f14);
            this.f18330i.get(11).e(f14);
            return;
        }
        if (i10 == 3) {
            valueAnimator.setDuration(120L);
            valueAnimator.setInterpolator(new AccelerateInterpolator());
            float f15 = f11 * (1.0f - f10);
            this.f18330i.get(0).e(f15);
            this.f18330i.get(1).e(f15);
            this.f18330i.get(11).e(f15);
            return;
        }
        if (i10 != 4) {
            if (i10 != 5) {
                return;
            }
            valueAnimator.setDuration(240L);
            valueAnimator.setInterpolator(new BounceInterpolator());
            float f16 = f11 * (1.0f - f10);
            this.f18330i.get(5).e(f16);
            this.f18330i.get(6).e(f16);
            this.f18330i.get(7).e(f16);
            return;
        }
        valueAnimator.setDuration(160L);
        valueAnimator.setInterpolator(new DecelerateInterpolator());
        float f17 = f11 * (1.0f - f10);
        this.f18330i.get(2).e(f17);
        this.f18330i.get(3).e(f17);
        this.f18330i.get(4).e(f17);
        this.f18330i.get(8).e(f17);
        this.f18330i.get(9).e(f17);
        this.f18330i.get(10).e(f17);
    }

    @Override // com.live.evo.widget.sloading.a, android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        int i10 = this.f18355n + 1;
        this.f18355n = i10;
        if (i10 > 2) {
            this.f18355n = 0;
            if (this.f18357p) {
                this.f18358q--;
            } else {
                this.f18358q++;
            }
            int i11 = this.f18358q;
            if (i11 >= 4) {
                this.f18357p = true;
                this.f18358q = 3;
                for (int i12 = 0; i12 < this.f18352k.size(); i12++) {
                    a.C0354a c0354a = this.f18352k.get(i12);
                    if (i12 == this.f18352k.size() - 1) {
                        c0354a.d(true);
                    } else {
                        c0354a.d(false);
                    }
                }
            } else if (i11 < 0) {
                this.f18357p = false;
                this.f18358q = 0;
                for (int i13 = 0; i13 < this.f18352k.size(); i13++) {
                    a.C0354a c0354a2 = this.f18352k.get(i13);
                    if (i13 == 0) {
                        c0354a2.d(false);
                    } else {
                        c0354a2.d(true);
                    }
                }
            }
            if (this.f18357p) {
                Iterator<a.C0354a> it = this.f18330i.iterator();
                while (it.hasNext()) {
                    it.next().e(this.f18356o);
                }
                this.f18352k.get(this.f18358q + 1).d(true);
                return;
            }
            Iterator<a.C0354a> it2 = this.f18330i.iterator();
            while (it2.hasNext()) {
                it2.next().e(0.0f);
            }
            this.f18352k.get(this.f18358q).d(false);
        }
    }

    @Override // com.live.evo.widget.sloading.a
    protected void p(ValueAnimator valueAnimator) {
        valueAnimator.setDuration(120L);
    }

    private void B(Canvas canvas) {
        canvas.save();
        this.f18331j.setStyle(Paint.Style.STROKE);
        Iterator<a.C0354a> it = this.f18352k.iterator();
        while (it.hasNext()) {
            it.next().a(canvas, this.f18353l, this.f18331j);
        }
        canvas.restore();
    }

    private void C(Canvas canvas) {
        canvas.save();
        this.f18331j.setStyle(Paint.Style.FILL_AND_STROKE);
        float size = this.f18352k.size() / 2;
        float f10 = this.f18356o;
        canvas.translate((-(size * f10)) + (f10 * this.f18358q), 0.0f);
        super.y(canvas, this.f18354m, this.f18331j);
        canvas.restore();
    }

    private void D() {
        float fG = g();
        float fH = h();
        a.C0354a c0354a = new a.C0354a(fG - (this.f18356o * 2.0f), fH);
        a.C0354a c0354a2 = new a.C0354a(fG - this.f18356o, fH);
        a.C0354a c0354a3 = new a.C0354a(fG, fH);
        a.C0354a c0354a4 = new a.C0354a(this.f18356o + fG, fH);
        a.C0354a c0354a5 = new a.C0354a(fG + (this.f18356o * 2.0f), fH);
        c0354a.d(false);
        this.f18352k.add(c0354a);
        this.f18352k.add(c0354a2);
        this.f18352k.add(c0354a3);
        this.f18352k.add(c0354a4);
        this.f18352k.add(c0354a5);
    }

    @Override // com.live.evo.widget.sloading.a
    protected void k(Context context, int i10) {
        this.f18353l = d() / 5.0f;
        this.f18356o = f() / 5.0f;
        this.f18354m = new Path();
        z(5.0f);
        A(this.f18353l);
        D();
    }

    @Override // com.live.evo.widget.sloading.a
    protected void n(Canvas canvas) {
        B(canvas);
        C(canvas);
    }

    @Override // com.live.evo.widget.sloading.a
    protected void o() {
    }
}
