package z4;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.live.evo.R$id;
import com.live.evo_mobile.ui.login.NoScrollViewPager;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class b extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private static final ViewDataBinding.IncludedLayouts f22685d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private static final SparseIntArray f22686e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    private final RelativeLayout f22687b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f22688c;

    public b(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 2, f22685d, f22686e));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.f22688c = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                return this.f22688c != 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f22688c = 1L;
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
        f22686e = sparseIntArray;
        sparseIntArray.put(R$id.login_type_viewpager, 1);
    }

    private b(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (NoScrollViewPager) objArr[1]);
        this.f22688c = -1L;
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.f22687b = relativeLayout;
        relativeLayout.setTag("layout/account_activity_login_type_0");
        setRootTag(view);
        invalidateAll();
    }
}
