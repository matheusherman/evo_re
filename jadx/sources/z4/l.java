package z4;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.p000lifecycle.LifecycleOwner;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import t.v.c.widget.MyRelativelayout;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class l extends k {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    private static final ViewDataBinding.IncludedLayouts f22837j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    private static final SparseIntArray f22838k;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    private final MyRelativelayout f22839h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f22840i;

    public l(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 8, f22837j, f22838k));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.f22840i = 0L;
        }
        ViewDataBinding.executeBindingsOn(this.f22819a);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                if (this.f22840i != 0) {
                    return true;
                }
                return this.f22819a.hasPendingBindings();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f22840i = 2L;
        }
        this.f22819a.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i10, @Nullable Object obj) {
        return true;
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(8);
        f22837j = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_header"}, new int[]{2}, new int[]{R$layout.layout_header});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f22838k = sparseIntArray;
        sparseIntArray.put(R$id.loading_layout, 1);
        sparseIntArray.put(R$id.txt_renew_online, 3);
        sparseIntArray.put(R$id.btn_refresh, 4);
        sparseIntArray.put(R$id.recharge_code_title, 5);
        sparseIntArray.put(R$id.etRecharge, 6);
        sparseIntArray.put(R$id.btn_recharge, 7);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private l(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        k1 k1Var = (k1) objArr[2];
        TextView textView = (TextView) objArr[7];
        TextView textView2 = (TextView) objArr[4];
        AppCompatEditText appCompatEditText = (AppCompatEditText) objArr[6];
        Object obj = objArr[1];
        super(dataBindingComponent, view, 1, k1Var, textView, textView2, appCompatEditText, obj != null ? p7.j.a((View) obj) : null, (TextView) objArr[5], (TextView) objArr[3]);
        this.f22840i = -1L;
        setContainedBinding(this.f22819a);
        MyRelativelayout myRelativelayout = (MyRelativelayout) objArr[0];
        this.f22839h = myRelativelayout;
        myRelativelayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(k1 k1Var, int i10) {
        if (i10 != 0) {
            return false;
        }
        synchronized (this) {
            this.f22840i |= 1;
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
        this.f22819a.setLifecycleOwner(lifecycleOwner);
    }
}
