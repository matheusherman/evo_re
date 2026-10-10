package z4;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.tvc.lib.mobile.ui.widget.ClearEditText;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class i extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ClearEditText f22793a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f22794b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final p7.j f22795c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f22796d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    public final LinearLayout f22797e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final RecyclerView f22798f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final LinearLayout f22799g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final RecyclerView f22800h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final TextView f22801i;

    protected i(Object obj, View view, int i10, ClearEditText clearEditText, AppCompatImageView appCompatImageView, p7.j jVar, AppCompatImageView appCompatImageView2, LinearLayout linearLayout, RecyclerView recyclerView, LinearLayout linearLayout2, RecyclerView recyclerView2, TextView textView) {
        super(obj, view, i10);
        this.f22793a = clearEditText;
        this.f22794b = appCompatImageView;
        this.f22795c = jVar;
        this.f22796d = appCompatImageView2;
        this.f22797e = linearLayout;
        this.f22798f = recyclerView;
        this.f22799g = linearLayout2;
        this.f22800h = recyclerView2;
        this.f22801i = textView;
    }
}
