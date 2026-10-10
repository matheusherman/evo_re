package z4;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.tvc.lib.mobile.ui.widget.MyVideoView;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class u0 extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f22988a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final FrameLayout f22989b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final LinearLayout f22990c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final ImageView f22991d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    public final ImageView f22992e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final RadioGroup f22993f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f22994g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final TextView f22995h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final MyVideoView f22996i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final RadioButton f22997j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final RadioButton f22998k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    public final TextView f22999l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NonNull
    public final View f23000m;

    protected u0(Object obj, View view, int i10, ConstraintLayout constraintLayout, FrameLayout frameLayout, LinearLayout linearLayout, ImageView imageView, ImageView imageView2, RadioGroup radioGroup, RelativeLayout relativeLayout, TextView textView, MyVideoView myVideoView, RadioButton radioButton, RadioButton radioButton2, TextView textView2, View view2) {
        super(obj, view, i10);
        this.f22988a = constraintLayout;
        this.f22989b = frameLayout;
        this.f22990c = linearLayout;
        this.f22991d = imageView;
        this.f22992e = imageView2;
        this.f22993f = radioGroup;
        this.f22994g = relativeLayout;
        this.f22995h = textView;
        this.f22996i = myVideoView;
        this.f22997j = radioButton;
        this.f22998k = radioButton2;
        this.f22999l = textView2;
        this.f23000m = view2;
    }
}
