package z4;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.live.evo.R$id;
import t.v.c.widget.MyRoundImageView;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class t0 extends s0 {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Nullable
    private static final ViewDataBinding.IncludedLayouts f22980o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    private static final SparseIntArray f22981p;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f22982m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f22983n;

    public t0(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 13, f22980o, f22981p));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.f22983n = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                return this.f22983n != 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f22983n = 1L;
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
        f22981p = sparseIntArray;
        sparseIntArray.put(R$id.iv_scan, 1);
        sparseIntArray.put(R$id.iv_message, 2);
        sparseIntArray.put(R$id.iv_user, 3);
        sparseIntArray.put(R$id.tv_name, 4);
        sparseIntArray.put(R$id.tv_uid, 5);
        sparseIntArray.put(R$id.tv_vip, 6);
        sparseIntArray.put(R$id.ll_invite, 7);
        sparseIntArray.put(R$id.iv_renew, 8);
        sparseIntArray.put(R$id.tv_favorite, 9);
        sparseIntArray.put(R$id.tv_history, 10);
        sparseIntArray.put(R$id.rv_setting1, 11);
        sparseIntArray.put(R$id.rv_setting2, 12);
    }

    private t0(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (AppCompatImageView) objArr[2], (MyRoundImageView) objArr[8], (AppCompatImageView) objArr[1], (AppCompatImageView) objArr[3], (LinearLayout) objArr[7], (RecyclerView) objArr[11], (RecyclerView) objArr[12], (TextView) objArr[9], (TextView) objArr[10], (TextView) objArr[4], (TextView) objArr[5], (TextView) objArr[6]);
        this.f22983n = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f22982m = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
