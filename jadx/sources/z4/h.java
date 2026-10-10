package z4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import t.v.c.widget.FrameLayout;
import t.v.c.widget.ImageView;
import t.v.c.widget.TextView;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class h implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    private final FrameLayout f22781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f22782b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final q1 f22783c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final ViewStub f22784d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    public final TextView f22785e;

    @NonNull
    public static h c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f22781a;
    }

    private h(@NonNull FrameLayout frameLayout, @NonNull ImageView imageView, @NonNull q1 q1Var, @NonNull ViewStub viewStub, @NonNull TextView textView) {
        this.f22781a = frameLayout;
        this.f22782b = imageView;
        this.f22783c = q1Var;
        this.f22784d = viewStub;
        this.f22785e = textView;
    }

    @NonNull
    public static h a(@NonNull View view) {
        int i10 = R$id.appLogoImageView;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R$id.appLogoImageView);
        if (imageView != null) {
            i10 = R$id.loading_layout;
            View viewFindChildViewById = ViewBindings.findChildViewById(view, R$id.loading_layout);
            if (viewFindChildViewById != null) {
                q1 q1VarA = q1.a(viewFindChildViewById);
                i10 = R$id.splash_view_stub;
                ViewStub viewStub = (ViewStub) ViewBindings.findChildViewById(view, R$id.splash_view_stub);
                if (viewStub != null) {
                    i10 = R$id.versionTextView;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R$id.versionTextView);
                    if (textView != null) {
                        return new h((FrameLayout) view, imageView, q1VarA, viewStub, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static h d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.activity_init, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }
}
