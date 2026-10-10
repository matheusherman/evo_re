package z4;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.p000lifecycle.LifecycleOwner;
import com.live.evo.R$id;
import com.live.evo.R$layout;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class e extends d {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @Nullable
    private static final ViewDataBinding.IncludedLayouts f22751r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    private static final SparseIntArray f22752s;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f22753p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private long f22754q;

    public e(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 16, f22751r, f22752s));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.f22754q = 0L;
        }
        ViewDataBinding.executeBindingsOn(this.f22729a);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                if (this.f22754q != 0) {
                    return true;
                }
                return this.f22729a.hasPendingBindings();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f22754q = 2L;
        }
        this.f22729a.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i10, @Nullable Object obj) {
        return true;
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(16);
        f22751r = includedLayouts;
        includedLayouts.setIncludes(1, new String[]{"layout_header"}, new int[]{2}, new int[]{R$layout.layout_header});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f22752s = sparseIntArray;
        sparseIntArray.put(R$id.txt_contact_us, 3);
        sparseIntArray.put(R$id.info1, 4);
        sparseIntArray.put(R$id.info2, 5);
        sparseIntArray.put(R$id.ll_about_us_whatsapp, 6);
        sparseIntArray.put(R$id.txt_about_us_customer_whatsapp, 7);
        sparseIntArray.put(R$id.img_about_us_customer_whatsapp_qr_code, 8);
        sparseIntArray.put(R$id.ll_about_us_telegram, 9);
        sparseIntArray.put(R$id.txt_about_us_customer_telegram, 10);
        sparseIntArray.put(R$id.img_about_us_customer_telegram_qr_code, 11);
        sparseIntArray.put(R$id.ll_about_us_customer_service, 12);
        sparseIntArray.put(R$id.img_about_us_customer_service_qr_code, 13);
        sparseIntArray.put(R$id.txt_about_us_customer_service, 14);
        sparseIntArray.put(R$id.tv_mac, 15);
    }

    private e(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (k1) objArr[2], (AppCompatImageView) objArr[13], (AppCompatImageView) objArr[11], (ImageView) objArr[8], (TextView) objArr[4], (TextView) objArr[5], (LinearLayout) objArr[12], (LinearLayout) objArr[9], (LinearLayout) objArr[6], (LinearLayout) objArr[1], (TextView) objArr[15], (TextView) objArr[14], (t.v.c.widget.TextView) objArr[10], (TextView) objArr[7], (TextView) objArr[3]);
        this.f22754q = -1L;
        setContainedBinding(this.f22729a);
        this.f22738j.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f22753p = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(k1 k1Var, int i10) {
        if (i10 != 0) {
            return false;
        }
        synchronized (this) {
            this.f22754q |= 1;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i10, Object obj, int i11) {
        if (i10 != 0) {
            return false;
        }
        return a((k1) obj, i11);
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f22729a.setLifecycleOwner(lifecycleOwner);
    }
}
