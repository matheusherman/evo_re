package z4;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.p000lifecycle.LifecycleOwner;
import com.live.evo.R$id;
import com.live.evo.R$layout;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class t extends s {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private static final ViewDataBinding.IncludedLayouts f22976h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    private static final SparseIntArray f22977i;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    private final LinearLayout f22978f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f22979g;

    public t(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 6, f22976h, f22977i));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.f22979g = 0L;
        }
        ViewDataBinding.executeBindingsOn(this.f22959e);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                if (this.f22979g != 0) {
                    return true;
                }
                return this.f22959e.hasPendingBindings();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f22979g = 2L;
        }
        this.f22959e.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i10, @Nullable Object obj) {
        return true;
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(6);
        f22976h = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_header"}, new int[]{1}, new int[]{R$layout.layout_header});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f22977i = sparseIntArray;
        sparseIntArray.put(R$id.ivPreview, 2);
        sparseIntArray.put(R$id.btnWhatsApp, 3);
        sparseIntArray.put(R$id.btnTelegram, 4);
        sparseIntArray.put(R$id.btnMore, 5);
    }

    private t(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (ImageButton) objArr[5], (ImageButton) objArr[4], (ImageButton) objArr[3], (ImageView) objArr[2], (k1) objArr[1]);
        this.f22979g = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f22978f = linearLayout;
        linearLayout.setTag(null);
        setContainedBinding(this.f22959e);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(k1 k1Var, int i10) {
        if (i10 != 0) {
            return false;
        }
        synchronized (this) {
            this.f22979g |= 1;
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
        this.f22959e.setLifecycleOwner(lifecycleOwner);
    }
}
