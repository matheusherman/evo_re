package z4;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import com.tvc.lib.mobile.ui.widget.TabBarView;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class u extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f22985a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinearLayout f22986b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final TabBarView f22987c;

    protected u(Object obj, View view, int i10, FrameLayout frameLayout, LinearLayout linearLayout, TabBarView tabBarView) {
        super(obj, view, i10);
        this.f22985a = frameLayout;
        this.f22986b = linearLayout;
        this.f22987c = tabBarView;
    }
}
