package z4;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.p000lifecycle.LifecycleOwner;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import t.v.c.widget.ImageView;
import t.v.c.widget.MyRelativelayout;
import t.v.c.widget.TextView;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class n extends m {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @Nullable
    private static final ViewDataBinding.IncludedLayouts f22886t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @Nullable
    private static final SparseIntArray f22887u;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f22888r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private long f22889s;

    public n(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 18, f22886t, f22887u));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.f22889s = 0L;
        }
        ViewDataBinding.executeBindingsOn(this.f22859k);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                if (this.f22889s != 0) {
                    return true;
                }
                return this.f22859k.hasPendingBindings();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f22889s = 2L;
        }
        this.f22859k.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i10, @Nullable Object obj) {
        return true;
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(18);
        f22886t = includedLayouts;
        includedLayouts.setIncludes(1, new String[]{"layout_header"}, new int[]{2}, new int[]{R$layout.layout_header});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f22887u = sparseIntArray;
        sparseIntArray.put(R$id.settings_menu_check_update, 3);
        sparseIntArray.put(R$id.check_update_iv, 4);
        sparseIntArray.put(R$id.check_update_tv, 5);
        sparseIntArray.put(R$id.check_update_arrow, 6);
        sparseIntArray.put(R$id.check_update_version, 7);
        sparseIntArray.put(R$id.check_update_progress, 8);
        sparseIntArray.put(R$id.settings_menu_about_us, 9);
        sparseIntArray.put(R$id.about_us_iv, 10);
        sparseIntArray.put(R$id.about_us_tv, 11);
        sparseIntArray.put(R$id.about_us_arrow, 12);
        sparseIntArray.put(R$id.settings_menu_switch_language, 13);
        sparseIntArray.put(R$id.switch_language_iv, 14);
        sparseIntArray.put(R$id.switch_language_tv, 15);
        sparseIntArray.put(R$id.current_language_tv, 16);
        sparseIntArray.put(R$id.switch_language_arrow, 17);
    }

    private n(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (ImageView) objArr[12], (ImageView) objArr[10], (TextView) objArr[11], (ImageView) objArr[6], (ImageView) objArr[4], (TextView) objArr[8], (TextView) objArr[5], (TextView) objArr[7], (TextView) objArr[16], (MyRelativelayout) objArr[1], (k1) objArr[2], (MyRelativelayout) objArr[9], (MyRelativelayout) objArr[3], (MyRelativelayout) objArr[13], (ImageView) objArr[17], (ImageView) objArr[14], (TextView) objArr[15]);
        this.f22889s = -1L;
        this.f22858j.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f22888r = constraintLayout;
        constraintLayout.setTag(null);
        setContainedBinding(this.f22859k);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(k1 k1Var, int i10) {
        if (i10 != 0) {
            return false;
        }
        synchronized (this) {
            this.f22889s |= 1;
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
        this.f22859k.setLifecycleOwner(lifecycleOwner);
    }
}
