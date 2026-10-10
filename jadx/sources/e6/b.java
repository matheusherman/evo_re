package e6;

import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public interface b {
    boolean a();

    void b(MotionEvent motionEvent);

    void c(int i10, int i11, int i12);

    void d(g6.f fVar);

    void e(boolean z10);

    ValueAnimator.AnimatorUpdateListener f(int i10);

    void g(e eVar, View view, View view2);

    @NonNull
    View getView();

    boolean h();

    @NonNull
    View j();
}
