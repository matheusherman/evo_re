package z4;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.live.evo.R$id;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class r0 extends q0 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    private static final ViewDataBinding.IncludedLayouts f22949l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    private static final SparseIntArray f22950m;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f22951k;

    public r0(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 10, f22949l, f22950m));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.f22951k = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                return this.f22951k != 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f22951k = 1L;
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
        f22950m = sparseIntArray;
        sparseIntArray.put(R$id.login_type_back, 1);
        sparseIntArray.put(R$id.login_scan, 2);
        sparseIntArray.put(R$id.live_logo, 3);
        sparseIntArray.put(R$id.tv_login_remind, 4);
        sparseIntArray.put(R$id.tv_create_account, 5);
        sparseIntArray.put(R$id.rl_or, 6);
        sparseIntArray.put(R$id.tv_or, 7);
        sparseIntArray.put(R$id.rl_login_email, 8);
        sparseIntArray.put(R$id.rl_login_phone, 9);
    }

    private r0(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[3], (ImageView) objArr[2], (ImageView) objArr[1], (RelativeLayout) objArr[8], (RelativeLayout) objArr[9], (RelativeLayout) objArr[0], (RelativeLayout) objArr[6], (TextView) objArr[5], (TextView) objArr[4], (TextView) objArr[7]);
        this.f22951k = -1L;
        this.f22935f.setTag("layout/fragment_login_type_0");
        setRootTag(view);
        invalidateAll();
    }
}
