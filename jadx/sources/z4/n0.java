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
public class n0 extends m0 {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    private static final ViewDataBinding.IncludedLayouts f22890k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    private static final SparseIntArray f22891l;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    private final RelativeLayout f22892i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f22893j;

    public n0(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 9, f22890k, f22891l));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.f22893j = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                return this.f22893j != 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f22893j = 1L;
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
        f22891l = sparseIntArray;
        sparseIntArray.put(R$id.layout_tab, 1);
        sparseIntArray.put(R$id.iv_login_email_back, 2);
        sparseIntArray.put(R$id.tv_login_email_forgot_pwd, 3);
        sparseIntArray.put(R$id.btn_login_email_commit, 4);
        sparseIntArray.put(R$id.tv_login_remind, 5);
        sparseIntArray.put(R$id.tv_login_email_sign_up, 6);
        sparseIntArray.put(R$id.rl_or, 7);
        sparseIntArray.put(R$id.tv_or, 8);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private n0(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        TextView textView = (TextView) objArr[4];
        ImageView imageView = (ImageView) objArr[2];
        Object obj = objArr[1];
        super(dataBindingComponent, view, 0, textView, imageView, obj != null ? c.a((View) obj) : null, (RelativeLayout) objArr[7], (TextView) objArr[3], (TextView) objArr[6], (TextView) objArr[5], (TextView) objArr[8]);
        this.f22893j = -1L;
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.f22892i = relativeLayout;
        relativeLayout.setTag("layout/fragment_login_email_0");
        setRootTag(view);
        invalidateAll();
    }
}
