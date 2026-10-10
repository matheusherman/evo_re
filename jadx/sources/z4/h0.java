package z4;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.p000lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.live.evo.R$id;
import com.live.evo.R$layout;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class h0 extends g0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private static final ViewDataBinding.IncludedLayouts f22786e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private static final SparseIntArray f22787f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f22788c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f22789d;

    public h0(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f22786e, f22787f));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.f22789d = 0L;
        }
        ViewDataBinding.executeBindingsOn(this.f22778a);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                if (this.f22789d != 0) {
                    return true;
                }
                return this.f22778a.hasPendingBindings();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f22789d = 2L;
        }
        this.f22778a.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i10, @Nullable Object obj) {
        return true;
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(3);
        f22786e = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"include_history_del_view"}, new int[]{1}, new int[]{R$layout.include_history_del_view});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f22787f = sparseIntArray;
        sparseIntArray.put(R$id.re_list, 2);
    }

    private h0(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (e1) objArr[1], (RecyclerView) objArr[2]);
        this.f22789d = -1L;
        setContainedBinding(this.f22778a);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f22788c = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(e1 e1Var, int i10) {
        if (i10 != 0) {
            return false;
        }
        synchronized (this) {
            this.f22789d |= 1;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i10, Object obj, int i11) {
        if (i10 != 0) {
            return false;
        }
        return a((e1) obj, i11);
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f22778a.setLifecycleOwner(lifecycleOwner);
    }
}
