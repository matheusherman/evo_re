package l5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import androidx.annotation.Nullable;
import com.live.evo.R$anim;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class b extends com.live.evo.fragment.c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private View f15202f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f15203g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f15204h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f15205i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected String f15206j = "";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f15207k = 0;

    private void e0() {
        this.f15205i = true;
        this.f15203g = false;
        this.f15202f = null;
        this.f15204h = true;
    }

    protected abstract int b0();

    protected abstract void c0(Bundle bundle);

    protected abstract void f0(View view);

    @Override // com.live.evo.fragment.c
    protected boolean T() {
        return this.f15203g;
    }

    public long a0() {
        long j10 = this.f15207k;
        return j10 > 0 ? j10 : b0();
    }

    protected void i0(View view) {
        if (view == null) {
            return;
        }
        view.startAnimation(AnimationUtils.loadAnimation(getContext(), R$anim.arrow_shake));
    }

    @Override // com.live.evo.fragment.c, androidx.fragment.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        View view2 = this.f15202f;
        if (view2 == null) {
            this.f15202f = view;
            if (getUserVisibleHint()) {
                if (this.f15205i) {
                    g0();
                    this.f15205i = false;
                }
                h0(true);
                this.f15203g = true;
            }
        } else {
            view2.setVisibility(0);
        }
        if (this.f15204h) {
            view = this.f15202f;
        }
        super.onViewCreated(view, bundle);
        f0(this.f15202f);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        c0(bundle);
        d0();
    }

    @Override // com.live.evo.fragment.c, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        e0();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return layoutInflater.inflate(b0(), viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        e0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // com.live.evo.fragment.c, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z10) {
        super.setUserVisibleHint(z10);
        if (this.f15202f != null) {
            if (this.f15205i && z10) {
                g0();
                this.f15205i = false;
            }
            if (z10) {
                h0(true);
                this.f15203g = true;
            } else if (this.f15203g) {
                this.f15203g = false;
                h0(false);
            }
        }
    }

    protected void d0() {
    }

    protected void g0() {
    }

    public void h0(boolean z10) {
    }
}
