package z4;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.live.evo.R$id;
import t.v.c.widget.ImageView;
import t.v.c.widget.MyRelativelayout;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class x0 extends w0 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    private static final ViewDataBinding.IncludedLayouts f23032j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    private static final SparseIntArray f23033k;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f23034i;

    public x0(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 8, f23032j, f23033k));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.f23034i = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                return this.f23034i != 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f23034i = 1L;
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
        f23033k = sparseIntArray;
        sparseIntArray.put(R$id.ll_vod_header, 1);
        sparseIntArray.put(R$id.vod_search, 2);
        sparseIntArray.put(R$id.vod_tabs_rl, 3);
        sparseIntArray.put(R$id.vod_tabs1, 4);
        sparseIntArray.put(R$id.vod_tabs2, 5);
        sparseIntArray.put(R$id.right_arrow, 6);
        sparseIntArray.put(R$id.vod_container, 7);
    }

    private x0(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ConstraintLayout) objArr[0], (LinearLayout) objArr[1], (ImageView) objArr[6], (ViewPager2) objArr[7], (TextView) objArr[2], (TabLayout) objArr[4], (TabLayout) objArr[5], (MyRelativelayout) objArr[3]);
        this.f23034i = -1L;
        this.f23016a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
