package t5;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.live.evo.R$style;
import com.live.evo.widget.o;
import com.live.evo.widget.sloading.SLoadingView;
import com.live.evo.widget.sloading.anim.SLoadingTextView;
import com.live.evo.widget.sloading.c;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WeakReference<Context> f18909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f18910b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private c f18911c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f18912d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f18913e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f18914f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f18915g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f18916h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f18917i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Dialog f18918j;

    public a(@NonNull Context context) {
        this(context, R$style.alert_dialog);
    }

    public a(@NonNull Context context, int i10) {
        this.f18914f = -1.0f;
        this.f18915g = -1;
        this.f18916h = true;
        this.f18917i = true;
        this.f18909a = new WeakReference<>(context);
        this.f18910b = i10;
    }

    private boolean e() {
        return this.f18909a.get() == null;
    }

    public void a() {
        Dialog dialog = this.f18918j;
        if (dialog != null) {
            dialog.cancel();
        }
        this.f18918j = null;
    }

    public void d() {
        Dialog dialog = this.f18918j;
        if (dialog != null) {
            dialog.dismiss();
        }
        this.f18918j = null;
    }

    public a f(@NonNull c cVar) {
        this.f18911c = cVar;
        return this;
    }

    public a g(int i10) {
        this.f18912d = i10;
        return this;
    }

    public void h() {
        Dialog dialog = this.f18918j;
        if (dialog != null) {
            dialog.show();
        } else {
            b().show();
        }
    }

    @NonNull
    private View c() {
        if (!e()) {
            return View.inflate(this.f18909a.get(), R$layout.s_loading_dialog, null);
        }
        throw new RuntimeException("Context is null...");
    }

    public Dialog b() {
        if (!e()) {
            if (this.f18918j != null) {
                a();
            }
            this.f18918j = new o(this.f18909a.get(), this.f18910b);
            View viewC = c();
            SLoadingView sLoadingView = (SLoadingView) viewC.findViewById(R$id.sloadingdlg_slv);
            SLoadingTextView sLoadingTextView = (SLoadingTextView) viewC.findViewById(R$id.sloadingdlg_tv_text);
            TextView textView = (TextView) viewC.findViewById(R$id.sloadingdlg_tv_custom_text);
            if (this.f18914f > 0.0f && !TextUtils.isEmpty(this.f18913e)) {
                textView.setVisibility(0);
                textView.setText(this.f18913e);
                textView.setTextSize(this.f18914f);
                int i10 = this.f18915g;
                if (i10 == -1) {
                    i10 = this.f18912d;
                }
                textView.setTextColor(i10);
            } else if (!TextUtils.isEmpty(this.f18913e)) {
                sLoadingTextView.setVisibility(0);
                sLoadingTextView.setText(this.f18913e);
                int i11 = this.f18915g;
                if (i11 == -1) {
                    i11 = this.f18912d;
                }
                sLoadingTextView.setColorFilter(i11);
            }
            sLoadingView.setLoadingBuilder(this.f18911c);
            sLoadingView.setColorFilter(this.f18912d);
            this.f18918j.setContentView(viewC);
            this.f18918j.setCancelable(this.f18916h);
            this.f18918j.setCanceledOnTouchOutside(this.f18917i);
            return this.f18918j;
        }
        throw new RuntimeException("Context is null...");
    }
}
