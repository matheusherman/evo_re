package u5;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.Editable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.exifinterface.media.ExifInterface;
import com.blankj.utilcode.util.ToastUtils;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import kotlin.Metadata;
import t.v.c.widget.MyButton;
import t.v.c.widget.MyEditText;
import t.v.c.widget.TextView;
import x1.f1.lb.util.m;
import x1.f1.lb.util.x0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\u000b\u001a\u00020\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u0003J!\u0010\u0012\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001f\u001a\n \u001c*\u0004\u0018\u00010\u001b0\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u0004\u0018\u00010\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u001e\u0010%\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\"\u0010+\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010*¨\u0006,"}, d2 = {"Lu5/c;", "Lv7/a;", "<init>", "()V", "", "U", "()I", "Lx1/f1/lb/util/m;", "", "callback", "Lr8/z;", "b0", "(Lx1/f1/lb/util/m;)V", "onStart", "Landroid/content/Context;", "context", "Landroid/view/View;", "view", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(Landroid/content/Context;Landroid/view/View;)V", "Landroid/content/DialogInterface$OnCancelListener;", "listener", "a0", "(Landroid/content/DialogInterface$OnCancelListener;)V", "a", "Landroid/content/DialogInterface$OnCancelListener;", "cancelListener", "Lq6/b;", "kotlin.jvm.PlatformType", "b", "Lq6/b;", "logger", "c", "Landroid/content/Context;", "mContext", "d", "Lx1/f1/lb/util/m;", "passwordListener", "e", "I", "getPasswordType", "c0", "(I)V", "passwordType", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class c extends v7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private DialogInterface.OnCancelListener cancelListener;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private m<String> passwordListener;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final q6.b logger = q6.c.d(c.class);

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Context mContext = getContext();

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int passwordType = 2;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(c cVar, MyEditText myEditText, View view) {
        String string;
        m<String> mVar = cVar.passwordListener;
        if (mVar != null) {
            Editable text = myEditText.getText();
            if (text == null || (string = text.toString()) == null) {
                string = "";
            }
            if (!t.v.c.i.a.f18646a.i0(string)) {
                ToastUtils.s(2131952629);
            } else {
                mVar.a(string);
                cVar.dismiss();
            }
        }
    }

    @Override // v7.a
    public void V(Context context, View view) {
        Dialog dialog;
        kotlin.jvm.internal.m.f(view, "view");
        if (context == null) {
            return;
        }
        final MyEditText myEditText = (MyEditText) view.findViewById(R$id.password);
        MyButton myButton = (MyButton) view.findViewById(R$id.btn_password_ok);
        MyButton myButton2 = (MyButton) view.findViewById(R$id.btn_password_cancel);
        if (this.passwordType == 1) {
            ((TextView) view.findViewById(R$id.txt_tip)).setText(getString(2131952139));
        }
        myButton.setOnClickListener(new View.OnClickListener() { // from class: u5.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                c.Y(this.f19364a, myEditText, view2);
            }
        });
        myButton2.setOnClickListener(new View.OnClickListener() { // from class: u5.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                c.Z(this.f19366a, view2);
            }
        });
        myEditText.requestFocus();
        if (this.cancelListener == null || (dialog = getDialog()) == null) {
            return;
        }
        dialog.setOnCancelListener(this.cancelListener);
    }

    public final void a0(DialogInterface.OnCancelListener listener) {
        kotlin.jvm.internal.m.f(listener, "listener");
        if (getDialog() == null) {
            this.cancelListener = listener;
            return;
        }
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setOnCancelListener(listener);
        }
    }

    public final void b0(m<String> callback) {
        kotlin.jvm.internal.m.f(callback, "callback");
        this.passwordListener = callback;
    }

    public final void c0(int i10) {
        this.passwordType = i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(c cVar, View view) {
        Dialog dialog = cVar.getDialog();
        if (dialog != null) {
            dialog.cancel();
        }
    }

    @Override // v7.a
    public int U() {
        return R$layout.dialog_input_passowrd;
    }

    @Override // v7.a, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            window = dialog.getWindow();
        } else {
            window = null;
        }
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            Context context = getContext();
            if (context != null) {
                attributes.width = (int) (((double) x0.f21457a.n(context)) * 0.8d);
            }
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }
}
