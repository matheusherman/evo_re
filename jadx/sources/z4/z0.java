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
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.live.evo.R$id;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class z0 extends y0 {

    @Nullable
    private static final ViewDataBinding.IncludedLayouts C = null;

    @Nullable
    private static final SparseIntArray D;

    @NonNull
    private final RelativeLayout A;
    private long B;

    public z0(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 27, C, D));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.B = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                return this.B != 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.B = 1L;
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
        D = sparseIntArray;
        sparseIntArray.put(R$id.rl_reset_actionbar, 1);
        sparseIntArray.put(R$id.iv_reset_back, 2);
        sparseIntArray.put(R$id.layout_reset_tab_container, 3);
        sparseIntArray.put(R$id.rl_reset_account_email, 4);
        sparseIntArray.put(R$id.tv_reset_account_email, 5);
        sparseIntArray.put(R$id.line_reset_account_email, 6);
        sparseIntArray.put(R$id.rl_reset_account_phone, 7);
        sparseIntArray.put(R$id.tv_reset_account_phone, 8);
        sparseIntArray.put(R$id.line_reset_account_phone, 9);
        sparseIntArray.put(R$id.rl_reset_account, 10);
        sparseIntArray.put(R$id.ll_phone_area_code, 11);
        sparseIntArray.put(R$id.spinner_area, 12);
        sparseIntArray.put(R$id.et_account, 13);
        sparseIntArray.put(R$id.iv_account_delete, 14);
        sparseIntArray.put(R$id.rl_reset_password, 15);
        sparseIntArray.put(R$id.et_reset_password, 16);
        sparseIntArray.put(R$id.iv_password_delete, 17);
        sparseIntArray.put(R$id.iv_password_show, 18);
        sparseIntArray.put(R$id.rl_reset_password_confirm, 19);
        sparseIntArray.put(R$id.et_reset_password_confirm, 20);
        sparseIntArray.put(R$id.iv_password_delete_confirm, 21);
        sparseIntArray.put(R$id.rl_verify_code, 22);
        sparseIntArray.put(R$id.et_verify_code, 23);
        sparseIntArray.put(R$id.tv_send_code, 24);
        sparseIntArray.put(R$id.rl_reset_commit, 25);
        sparseIntArray.put(R$id.tv_reset_terms, 26);
    }

    private z0(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (EditText) objArr[13], (EditText) objArr[16], (EditText) objArr[20], (EditText) objArr[23], (ImageView) objArr[14], (ImageView) objArr[17], (ImageView) objArr[21], (ImageView) objArr[18], (ImageView) objArr[2], (LinearLayout) objArr[3], (View) objArr[6], (View) objArr[9], (LinearLayout) objArr[11], (RelativeLayout) objArr[10], (RelativeLayout) objArr[4], (RelativeLayout) objArr[7], (RelativeLayout) objArr[1], (RelativeLayout) objArr[25], (RelativeLayout) objArr[15], (RelativeLayout) objArr[19], (RelativeLayout) objArr[22], (AppCompatSpinner) objArr[12], (TextView) objArr[5], (TextView) objArr[8], (TextView) objArr[26], (TextView) objArr[24]);
        this.B = -1L;
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.A = relativeLayout;
        relativeLayout.setTag("layout/fragment_reset_password_0");
        setRootTag(view);
        invalidateAll();
    }
}
