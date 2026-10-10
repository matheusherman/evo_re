package p7;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tvc.lib.R$id;
import t.v.c.widget.ImageView;
import t.v.c.widget.LinearLayout;
import t.v.c.widget.TextView;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class i implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    private final FrameLayout f17408a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f17409b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final LinearLayout f17410c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final ImageView f17411d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    public final FrameLayout f17412e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f17413f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final TextView f17414g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final LinearLayout f17415h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final TextView f17416i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final TextView f17417j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final LinearLayout f17418k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    public final ImageView f17419l;

    @NonNull
    public static i a(@NonNull View view) {
        int i10 = R$id.app_video_brightness;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
        if (textView != null) {
            i10 = R$id.app_video_brightness_box;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
            if (linearLayout != null) {
                i10 = R$id.app_video_brightness_icon;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
                if (imageView != null) {
                    FrameLayout frameLayout = (FrameLayout) view;
                    i10 = R$id.app_video_fastForward;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i10);
                    if (textView2 != null) {
                        i10 = R$id.app_video_fastForward_all;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i10);
                        if (textView3 != null) {
                            i10 = R$id.app_video_fastForward_box;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                            if (linearLayout2 != null) {
                                i10 = R$id.app_video_fastForward_target;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i10);
                                if (textView4 != null) {
                                    i10 = R$id.app_video_volume;
                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i10);
                                    if (textView5 != null) {
                                        i10 = R$id.app_video_volume_box;
                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                                        if (linearLayout3 != null) {
                                            i10 = R$id.app_video_volume_icon;
                                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i10);
                                            if (imageView2 != null) {
                                                return new i(frameLayout, textView, linearLayout, imageView, frameLayout, textView2, textView3, linearLayout2, textView4, textView5, linearLayout3, imageView2);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f17408a;
    }

    private i(@NonNull FrameLayout frameLayout, @NonNull TextView textView, @NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull FrameLayout frameLayout2, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull LinearLayout linearLayout2, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull LinearLayout linearLayout3, @NonNull ImageView imageView2) {
        this.f17408a = frameLayout;
        this.f17409b = textView;
        this.f17410c = linearLayout;
        this.f17411d = imageView;
        this.f17412e = frameLayout2;
        this.f17413f = textView2;
        this.f17414g = textView3;
        this.f17415h = linearLayout2;
        this.f17416i = textView4;
        this.f17417j = textView5;
        this.f17418k = linearLayout3;
        this.f17419l = imageView2;
    }
}
