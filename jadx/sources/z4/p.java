package z4;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.p000lifecycle.LifecycleOwner;
import com.live.evo.R$layout;
import t.v.c.widget.MyRelativelayout;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class p extends o {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private static final ViewDataBinding.IncludedLayouts f22914f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private static final SparseIntArray f22915g;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    private final MyRelativelayout f22916d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f22917e;

    public p(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f22914f, f22915g));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.f22917e = 0L;
        }
        ViewDataBinding.executeBindingsOn(this.f22899b);
        ViewDataBinding.executeBindingsOn(this.f22900c);
        ViewDataBinding.executeBindingsOn(this.f22898a);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                if (this.f22917e != 0) {
                    return true;
                }
                return this.f22899b.hasPendingBindings() || this.f22900c.hasPendingBindings() || this.f22898a.hasPendingBindings();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f22917e = 8L;
        }
        this.f22899b.invalidateAll();
        this.f22900c.invalidateAll();
        this.f22898a.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i10, @Nullable Object obj) {
        return true;
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(4);
        f22914f = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_header", "layout_settings_item", "settings_detail_bottom"}, new int[]{1, 2, 3}, new int[]{R$layout.layout_header, R$layout.layout_settings_item, R$layout.settings_detail_bottom});
        f22915g = null;
    }

    private p(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (r1) objArr[3], (k1) objArr[1], (m1) objArr[2]);
        this.f22917e = -1L;
        MyRelativelayout myRelativelayout = (MyRelativelayout) objArr[0];
        this.f22916d = myRelativelayout;
        myRelativelayout.setTag(null);
        setContainedBinding(this.f22898a);
        setContainedBinding(this.f22899b);
        setContainedBinding(this.f22900c);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(r1 r1Var, int i10) {
        if (i10 != 0) {
            return false;
        }
        synchronized (this) {
            this.f22917e |= 1;
        }
        return true;
    }

    private boolean b(k1 k1Var, int i10) {
        if (i10 != 0) {
            return false;
        }
        synchronized (this) {
            this.f22917e |= 2;
        }
        return true;
    }

    private boolean c(m1 m1Var, int i10) {
        if (i10 != 0) {
            return false;
        }
        synchronized (this) {
            this.f22917e |= 4;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i10, Object obj, int i11) {
        if (i10 == 0) {
            return a((r1) obj, i11);
        }
        if (i10 == 1) {
            return b((k1) obj, i11);
        }
        if (i10 != 2) {
            return false;
        }
        return c((m1) obj, i11);
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f22899b.setLifecycleOwner(lifecycleOwner);
        this.f22900c.setLifecycleOwner(lifecycleOwner);
        this.f22898a.setLifecycleOwner(lifecycleOwner);
    }
}
