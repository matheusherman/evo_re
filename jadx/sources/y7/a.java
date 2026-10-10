package y7;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tvc.lib.R$id;
import com.tvc.lib.R$layout;
import com.tvc.lib.R$style;
import com.tvc.lib.mobile.ui.widget.sloading.SLoadingView;
import com.tvc.lib.mobile.ui.widget.sloading.c;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WeakReference<Context> f22476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f22477b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private c f22478c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f22479d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f22480e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f22481f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f22482g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f22483h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f22484i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Dialog f22485j;

    public a(@NonNull Context context) {
        this(context, R$style.alert_dialog);
    }

    public a(@NonNull Context context, int i10) {
        this.f22481f = -1.0f;
        this.f22482g = -1;
        this.f22483h = true;
        this.f22484i = true;
        this.f22476a = new WeakReference<>(context);
        this.f22477b = i10;
    }

    private boolean e() {
        return this.f22476a.get() == null;
    }

    public void a() {
        Dialog dialog = this.f22485j;
        if (dialog != null) {
            dialog.cancel();
        }
        this.f22485j = null;
    }

    public void d() {
        Dialog dialog = this.f22485j;
        if (dialog != null) {
            dialog.dismiss();
        }
        this.f22485j = null;
    }

    public a f(@NonNull c cVar) {
        this.f22478c = cVar;
        return this;
    }

    public a g(int i10) {
        this.f22479d = i10;
        return this;
    }

    public void h() {
        Dialog dialog = this.f22485j;
        if (dialog != null) {
            dialog.show();
        } else {
            b().show();
        }
    }

    @NonNull
    private View c() {
        if (!e()) {
            return View.inflate(this.f22476a.get(), R$layout.s_loading_dialog_tvc_lib, null);
        }
        throw new RuntimeException("Context is null...");
    }

    public Dialog b() {
        if (!e()) {
            if (this.f22485j != null) {
                a();
            }
            this.f22485j = new Dialog(this.f22476a.get(), this.f22477b);
            View viewC = c();
            SLoadingView sLoadingView = (SLoadingView) viewC.findViewById(R$id.sloadingdlg_slv);
            TextView textView = (TextView) viewC.findViewById(R$id.sloadingdlg_tv_custom_text);
            if (this.f22481f > 0.0f && !TextUtils.isEmpty(this.f22480e)) {
                textView.setVisibility(0);
                textView.setText(this.f22480e);
                textView.setTextSize(this.f22481f);
                int i10 = this.f22482g;
                if (i10 == -1) {
                    i10 = this.f22479d;
                }
                textView.setTextColor(i10);
            } else {
                TextUtils.isEmpty(this.f22480e);
            }
            sLoadingView.setLoadingBuilder(this.f22478c);
            sLoadingView.setColorFilter(this.f22479d);
            this.f22485j.setContentView(viewC);
            this.f22485j.setCancelable(this.f22483h);
            this.f22485j.setCanceledOnTouchOutside(this.f22484i);
            return this.f22485j;
        }
        throw new RuntimeException("Context is null...");
    }
}
