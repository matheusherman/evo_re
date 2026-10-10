package z4;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import t.v.c.widget.MyRelativelayout;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class c1 extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final MyRelativelayout f22725a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final RecyclerView f22726b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f22727c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final SmartRefreshLayout f22728d;

    protected c1(Object obj, View view, int i10, MyRelativelayout myRelativelayout, RecyclerView recyclerView, RelativeLayout relativeLayout, SmartRefreshLayout smartRefreshLayout) {
        super(obj, view, i10);
        this.f22725a = myRelativelayout;
        this.f22726b = recyclerView;
        this.f22727c = relativeLayout;
        this.f22728d = smartRefreshLayout;
    }
}
