package z4;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.live.evo.R$id;
import t.v.c.widget.LinearLayout;
import t.v.c.widget.MyRelativelayout;
import t.v.c.widget.TextView;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class n1 extends m1 {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Nullable
    private static final ViewDataBinding.IncludedLayouts f22894o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    private static final SparseIntArray f22895p;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NonNull
    private final LinearLayout f22896m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f22897n;

    public n1(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 13, f22894o, f22895p));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.f22897n = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                return this.f22897n != 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f22897n = 1L;
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
        f22895p = sparseIntArray;
        sparseIntArray.put(R$id.settings_item1, 1);
        sparseIntArray.put(R$id.settings_item_title, 2);
        sparseIntArray.put(R$id.settings_item_icon1, 3);
        sparseIntArray.put(R$id.settings_item_content1, 4);
        sparseIntArray.put(R$id.settings_item_2, 5);
        sparseIntArray.put(R$id.settings_item_title2, 6);
        sparseIntArray.put(R$id.settings_item_icon2, 7);
        sparseIntArray.put(R$id.settings_item_content2, 8);
        sparseIntArray.put(R$id.settings_item_3, 9);
        sparseIntArray.put(R$id.settings_item_title3, 10);
        sparseIntArray.put(R$id.settings_item_icon3, 11);
        sparseIntArray.put(R$id.settings_item_content3, 12);
    }

    private n1(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (MyRelativelayout) objArr[1], (MyRelativelayout) objArr[5], (MyRelativelayout) objArr[9], (TextView) objArr[4], (TextView) objArr[8], (TextView) objArr[12], (AppCompatImageView) objArr[3], (AppCompatImageView) objArr[7], (AppCompatImageView) objArr[11], (TextView) objArr[2], (TextView) objArr[6], (TextView) objArr[10]);
        this.f22897n = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f22896m = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
