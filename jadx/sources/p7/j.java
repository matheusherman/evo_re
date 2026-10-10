package p7;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tvc.lib.R$id;
import com.tvc.lib.mobile.ui.widget.sloading.SLoadingView;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class j implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f17420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinearLayout f17421b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final SLoadingView f17422c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f17423d;

    @NonNull
    public static j a(@NonNull View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i10 = R$id.sloadingdlg_slv;
        SLoadingView sLoadingView = (SLoadingView) ViewBindings.findChildViewById(view, i10);
        if (sLoadingView != null) {
            i10 = R$id.sloadingdlg_tv_custom_text;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
            if (textView != null) {
                return new j(linearLayout, linearLayout, sLoadingView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f17420a;
    }

    private j(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull SLoadingView sLoadingView, @NonNull TextView textView) {
        this.f17420a = linearLayout;
        this.f17421b = linearLayout2;
        this.f17422c = sLoadingView;
        this.f17423d = textView;
    }
}
