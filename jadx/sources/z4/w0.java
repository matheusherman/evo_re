package z4;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import t.v.c.widget.ImageView;
import t.v.c.widget.MyRelativelayout;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class w0 extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f23016a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinearLayout f23017b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f23018c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final ViewPager2 f23019d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    public final TextView f23020e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final TabLayout f23021f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final TabLayout f23022g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final MyRelativelayout f23023h;

    protected w0(Object obj, View view, int i10, ConstraintLayout constraintLayout, LinearLayout linearLayout, ImageView imageView, ViewPager2 viewPager2, TextView textView, TabLayout tabLayout, TabLayout tabLayout2, MyRelativelayout myRelativelayout) {
        super(obj, view, i10);
        this.f23016a = constraintLayout;
        this.f23017b = linearLayout;
        this.f23018c = imageView;
        this.f23019d = viewPager2;
        this.f23020e = textView;
        this.f23021f = tabLayout;
        this.f23022g = tabLayout2;
        this.f23023h = myRelativelayout;
    }
}
