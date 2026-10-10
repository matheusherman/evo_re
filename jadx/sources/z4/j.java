package z4;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.live.evo.R$id;
import com.tvc.lib.mobile.ui.widget.ClearEditText;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class j extends i {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    private static final ViewDataBinding.IncludedLayouts f22807m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    private static final SparseIntArray f22808n;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    private final LinearLayout f22809j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    private final RelativeLayout f22810k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f22811l;

    public j(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 11, f22807m, f22808n));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.f22811l = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                return this.f22811l != 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f22811l = 1L;
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
        f22808n = sparseIntArray;
        sparseIntArray.put(R$id.loading_layout, 2);
        sparseIntArray.put(R$id.iv_back, 3);
        sparseIntArray.put(R$id.edt_search, 4);
        sparseIntArray.put(R$id.tv_search, 5);
        sparseIntArray.put(R$id.search_record_ll, 6);
        sparseIntArray.put(R$id.search_record_delete, 7);
        sparseIntArray.put(R$id.search_record_rv, 8);
        sparseIntArray.put(R$id.search_result_ll, 9);
        sparseIntArray.put(R$id.search_result_rv, 10);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private j(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        ClearEditText clearEditText = (ClearEditText) objArr[4];
        AppCompatImageView appCompatImageView = (AppCompatImageView) objArr[3];
        Object obj = objArr[2];
        super(dataBindingComponent, view, 0, clearEditText, appCompatImageView, obj != null ? p7.j.a((View) obj) : null, (AppCompatImageView) objArr[7], (LinearLayout) objArr[6], (RecyclerView) objArr[8], (LinearLayout) objArr[9], (RecyclerView) objArr[10], (TextView) objArr[5]);
        this.f22811l = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f22809j = linearLayout;
        linearLayout.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) objArr[1];
        this.f22810k = relativeLayout;
        relativeLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
