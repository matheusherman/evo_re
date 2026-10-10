package h0;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00142\u00020\u0001:\u0001\u000bB\u001d\b\u0007\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\rR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lh0/a;", "Lh0/b;", "", TypedValues.TransitionType.S_DURATION, "", "mFrom", "<init>", "(JF)V", "Landroid/view/View;", "view", "Landroid/animation/Animator;", "a", "(Landroid/view/View;)Landroid/animation/Animator;", "J", "b", "F", "Landroid/view/animation/LinearInterpolator;", "c", "Landroid/view/animation/LinearInterpolator;", "interpolator", "d", "com.github.CymChad.brvah"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long duration;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final float mFrom;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final LinearInterpolator interpolator;

    public a(long j10, float f10) {
        this.duration = j10;
        this.mFrom = f10;
        this.interpolator = new LinearInterpolator();
    }

    @Override // h0.b
    public Animator a(View view) {
        m.f(view, "view");
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "alpha", this.mFrom, 1.0f);
        animator.setDuration(this.duration);
        animator.setInterpolator(this.interpolator);
        m.e(animator, "animator");
        return animator;
    }

    public /* synthetic */ a(long j10, float f10, int i10, g gVar) {
        this((i10 & 1) != 0 ? 300L : j10, (i10 & 2) != 0 ? 0.0f : f10);
    }
}
