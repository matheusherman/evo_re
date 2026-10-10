package p7;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.tabs.TabLayout;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class a extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TabLayout f17362a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final View f17363b;

    protected a(Object obj, View view, int i10, TabLayout tabLayout, View view2) {
        super(obj, view, i10);
        this.f17362a = tabLayout;
        this.f17363b = view2;
    }
}
