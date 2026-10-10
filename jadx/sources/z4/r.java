package z4;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.p000lifecycle.LifecycleOwner;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import t.v.c.widget.MyRelativelayout;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class r extends q {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private static final ViewDataBinding.IncludedLayouts f22945g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private static final SparseIntArray f22946h;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    private final MyRelativelayout f22947e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f22948f;

    public r(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f22945g, f22946h));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.f22948f = 0L;
        }
        ViewDataBinding.executeBindingsOn(this.f22929d);
        ViewDataBinding.executeBindingsOn(this.f22927b);
        ViewDataBinding.executeBindingsOn(this.f22928c);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                if (this.f22948f != 0) {
                    return true;
                }
                return this.f22929d.hasPendingBindings() || this.f22927b.hasPendingBindings() || this.f22928c.hasPendingBindings();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f22948f = 8L;
        }
        this.f22929d.invalidateAll();
        this.f22927b.invalidateAll();
        this.f22928c.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i10, @Nullable Object obj) {
        return true;
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(5);
        f22945g = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_header", "layout_settings_link", "settings_detail_bottom"}, new int[]{2, 3, 4}, new int[]{R$layout.layout_header, R$layout.layout_settings_link, R$layout.settings_detail_bottom});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f22946h = sparseIntArray;
        sparseIntArray.put(R$id.loading_layout, 1);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private r(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        Object obj = objArr[1];
        super(dataBindingComponent, view, 3, obj != null ? p7.j.a((View) obj) : null, (o1) objArr[3], (r1) objArr[4], (k1) objArr[2]);
        this.f22948f = -1L;
        MyRelativelayout myRelativelayout = (MyRelativelayout) objArr[0];
        this.f22947e = myRelativelayout;
        myRelativelayout.setTag(null);
        setContainedBinding(this.f22927b);
        setContainedBinding(this.f22928c);
        setContainedBinding(this.f22929d);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(o1 o1Var, int i10) {
        if (i10 != 0) {
            return false;
        }
        synchronized (this) {
            this.f22948f |= 2;
        }
        return true;
    }

    private boolean b(r1 r1Var, int i10) {
        if (i10 != 0) {
            return false;
        }
        synchronized (this) {
            this.f22948f |= 4;
        }
        return true;
    }

    private boolean c(k1 k1Var, int i10) {
        if (i10 != 0) {
            return false;
        }
        synchronized (this) {
            this.f22948f |= 1;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i10, Object obj, int i11) {
        if (i10 == 0) {
            return c((k1) obj, i11);
        }
        if (i10 == 1) {
            return a((o1) obj, i11);
        }
        if (i10 != 2) {
            return false;
        }
        return b((r1) obj, i11);
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f22929d.setLifecycleOwner(lifecycleOwner);
        this.f22927b.setLifecycleOwner(lifecycleOwner);
        this.f22928c.setLifecycleOwner(lifecycleOwner);
    }
}
