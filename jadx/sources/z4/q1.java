package z4;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.live.evo.R$id;
import com.tvc.lib.mobile.ui.widget.sloading.SLoadingView;
import com.tvc.lib.mobile.ui.widget.sloading.anim.SLoadingTextView;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class q1 implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f22940a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinearLayout f22941b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final SLoadingView f22942c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f22943d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    public final SLoadingTextView f22944e;

    @NonNull
    public static q1 a(@NonNull View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i10 = R$id.sloadingdlg_slv;
        SLoadingView sLoadingView = (SLoadingView) ViewBindings.findChildViewById(view, R$id.sloadingdlg_slv);
        if (sLoadingView != null) {
            i10 = R$id.sloadingdlg_tv_custom_text;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R$id.sloadingdlg_tv_custom_text);
            if (textView != null) {
                i10 = R$id.sloadingdlg_tv_text;
                SLoadingTextView sLoadingTextView = (SLoadingTextView) ViewBindings.findChildViewById(view, R$id.sloadingdlg_tv_text);
                if (sLoadingTextView != null) {
                    return new q1(linearLayout, linearLayout, sLoadingView, textView, sLoadingTextView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f22940a;
    }

    private q1(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull SLoadingView sLoadingView, @NonNull TextView textView, @NonNull SLoadingTextView sLoadingTextView) {
        this.f22940a = linearLayout;
        this.f22941b = linearLayout2;
        this.f22942c = sLoadingView;
        this.f22943d = textView;
        this.f22944e = sLoadingTextView;
    }
}
