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
public class p0 extends o0 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    private static final ViewDataBinding.IncludedLayouts f22918l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    private static final SparseIntArray f22919m;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    private final RelativeLayout f22920j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f22921k;

    public p0(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 10, f22918l, f22919m));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.f22921k = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                return this.f22921k != 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f22921k = 1L;
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
        f22919m = sparseIntArray;
        sparseIntArray.put(R$id.layout_tab, 1);
        sparseIntArray.put(R$id.rl_login_phone_actionbar, 2);
        sparseIntArray.put(R$id.iv_login_phone_back, 3);
        sparseIntArray.put(R$id.tv_login_phone_forgot_pwd, 4);
        sparseIntArray.put(R$id.rl_login_phone_commit, 5);
        sparseIntArray.put(R$id.tv_login_remind, 6);
        sparseIntArray.put(R$id.tv_login_phone_sign_up, 7);
        sparseIntArray.put(R$id.rl_or, 8);
        sparseIntArray.put(R$id.tv_or, 9);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private p0(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        ImageView imageView = (ImageView) objArr[3];
        Object obj = objArr[1];
        super(dataBindingComponent, view, 0, imageView, obj != null ? c.a((View) obj) : null, (RelativeLayout) objArr[2], (TextView) objArr[5], (RelativeLayout) objArr[8], (TextView) objArr[4], (TextView) objArr[7], (TextView) objArr[6], (TextView) objArr[9]);
        this.f22921k = -1L;
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.f22920j = relativeLayout;
        relativeLayout.setTag("fragment_login_phone_0");
        setRootTag(view);
        invalidateAll();
    }
}
