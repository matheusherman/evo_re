package z4;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.live.evo.R$id;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class b0 extends a0 {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    private static final ViewDataBinding.IncludedLayouts f22689n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Nullable
    private static final SparseIntArray f22690o;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    private final RelativeLayout f22691l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f22692m;

    public b0(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 12, f22689n, f22690o));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.f22692m = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                return this.f22692m != 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f22692m = 1L;
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
        f22690o = sparseIntArray;
        sparseIntArray.put(R$id.layout_tab, 1);
        sparseIntArray.put(R$id.rl_login_email_actionbar, 2);
        sparseIntArray.put(R$id.iv_create_back, 3);
        sparseIntArray.put(R$id.rl_verify_code, 4);
        sparseIntArray.put(R$id.et_verify_code, 5);
        sparseIntArray.put(R$id.tv_send_code, 6);
        sparseIntArray.put(R$id.rl_create_commit, 7);
        sparseIntArray.put(R$id.tv_create_terms, 8);
        sparseIntArray.put(R$id.ll_create_tologin, 9);
        sparseIntArray.put(R$id.tv_already_member, 10);
        sparseIntArray.put(R$id.toLogin, 11);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private b0(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        EditText editText = (EditText) objArr[5];
        ImageView imageView = (ImageView) objArr[3];
        Object obj = objArr[1];
        super(dataBindingComponent, view, 0, editText, imageView, obj != null ? c.a((View) obj) : null, (LinearLayout) objArr[9], (TextView) objArr[7], (RelativeLayout) objArr[2], (RelativeLayout) objArr[4], (TextView) objArr[11], (TextView) objArr[10], (TextView) objArr[8], (TextView) objArr[6]);
        this.f22692m = -1L;
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.f22691l = relativeLayout;
        relativeLayout.setTag("layout/fragment_create_account_0");
        setRootTag(view);
        invalidateAll();
    }
}
