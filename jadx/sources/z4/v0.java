package z4;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.live.evo.R$id;
import com.tvc.lib.mobile.ui.widget.MyVideoView;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class v0 extends u0 {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Nullable
    private static final ViewDataBinding.IncludedLayouts f23008o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    private static final SparseIntArray f23009p;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f23010n;

    public v0(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 13, f23008o, f23009p));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.f23010n = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                return this.f23010n != 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f23010n = 1L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i10, Object obj, int i11) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i10, @Nullable Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f23009p = sparseIntArray;
        sparseIntArray.put(R$id.ll_header, 1);
        sparseIntArray.put(R$id.tv_search, 2);
        sparseIntArray.put(R$id.my_video_view, 3);
        sparseIntArray.put(R$id.main_rg, 4);
        sparseIntArray.put(R$id.rb_channel, 5);
        sparseIntArray.put(R$id.rb_favorite, 6);
        sparseIntArray.put(R$id.main_rl, 7);
        sparseIntArray.put(R$id.main_iv, 8);
        sparseIntArray.put(R$id.main_iv_bg, 9);
        sparseIntArray.put(R$id.main_rl_channeltext, 10);
        sparseIntArray.put(R$id.v_h_line, 11);
        sparseIntArray.put(2131427772, 12);
    }

    private v0(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ConstraintLayout) objArr[0], (FrameLayout) objArr[12], (LinearLayout) objArr[1], (ImageView) objArr[8], (ImageView) objArr[9], (RadioGroup) objArr[4], (RelativeLayout) objArr[7], (TextView) objArr[10], (MyVideoView) objArr[3], (RadioButton) objArr[5], (RadioButton) objArr[6], (TextView) objArr[2], (View) objArr[11]);
        this.f23010n = -1L;
        this.f22988a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
