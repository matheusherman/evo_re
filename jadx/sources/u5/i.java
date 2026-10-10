package u5;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.Editable;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.exifinterface.media.ExifInterface;
import com.blankj.utilcode.util.ToastUtils;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.live.evo.R$string;
import kotlin.Metadata;
import r8.z;
import t.v.c.widget.MyButton;
import t.v.c.widget.MyEditText;
import t.v.c.widget.TextView;
import x1.f1.lb.util.m;
import x1.f1.lb.util.x0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 22\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\f\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0012\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u000e¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0017\u0010\u0003J!\u0010\u001c\u001a\u00020\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010'\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010 R\u001c\u0010,\u001a\n )*\u0004\u0018\u00010(0(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u001e\u0010/\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u0010\u0014\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101¨\u00063"}, d2 = {"Lu5/i;", "Lv7/a;", "<init>", "()V", "", "j0", "()Z", "", "password", "Lkotlin/Function0;", "Lr8/z;", "callback", "d0", "(Ljava/lang/String;Lc9/a;)V", "", "U", "()I", "Lx1/f1/lb/util/m;", "k0", "(Lx1/f1/lb/util/m;)V", "passwordType", "l0", "(I)V", "onStart", "Landroid/content/Context;", "context", "Landroid/view/View;", "view", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(Landroid/content/Context;Landroid/view/View;)V", "Lt/v/c/widget/TextView;", "a", "Lt/v/c/widget/TextView;", "tip", "Lt/v/c/widget/MyButton;", "b", "Lt/v/c/widget/MyButton;", "btnOk", "c", "btnReset", "Lq6/b;", "kotlin.jvm.PlatformType", "d", "Lq6/b;", "logger", "e", "Lx1/f1/lb/util/m;", "passwordListener", "f", "I", "g", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class i extends v7.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static boolean f19379h;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private TextView tip;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private MyButton btnOk;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private TextView btnReset;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private m<Integer> passwordListener;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final q6.b logger = q6.c.d(i.class);

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int passwordType = 2;

    /* JADX INFO: renamed from: u5.i$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\r¨\u0006\u0012"}, d2 = {"Lu5/i$a;", "", "<init>", "()V", "", "isAdultColumnOpen", "Z", "a", "()Z", "b", "(Z)V", "", "SHOW_INPUT_PASSWORD", "I", "SET_LOCK_SUCCES", "SET_LOCK_FAIL", "ADULT_PASSWORD", "PARENTAL_PASSWORD", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        private Companion() {
        }

        public final boolean a() {
            return i.f19379h;
        }

        public final void b(boolean z10) {
            i.f19379h = z10;
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0052  */
    /* JADX WARN: Code duplicated, block: B:18:0x0055  */
    /* JADX WARN: Code duplicated, block: B:21:0x005e  */
    /* JADX WARN: Code duplicated, block: B:22:0x0067  */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0049, code lost:
    
        if (t.v.c.i.a.f18646a.p0(r5) != false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x007d, code lost:
    
        if (j0() == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x007f, code lost:
    
        r5 = r4.btnReset;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0081, code lost:
    
        if (r5 == null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0083, code lost:
    
        r5.setVisibility(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0088, code lost:
    
        if (r4.passwordType != 1) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x008a, code lost:
    
        com.blankj.utilcode.util.ToastUtils.t(getString(com.live.evo.R$string.adult_key_not_map), new java.lang.Object[0]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0096, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0097, code lost:
    
        com.blankj.utilcode.util.ToastUtils.t(getString(2131952629), new java.lang.Object[0]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00a3, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00a6, code lost:
    
        if (r4.passwordType != 1) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00a8, code lost:
    
        com.blankj.utilcode.util.ToastUtils.t(getString(2131951735), new java.lang.Object[0]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00b4, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00b5, code lost:
    
        com.blankj.utilcode.util.ToastUtils.s(2131952623);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00bb, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x002e, code lost:
    
        if (kotlin.jvm.internal.m.a(x1.f1.lb.media.d.f20812a.n(), r5) != false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void d0(String password, c9.a<z> callback) {
        m<Integer> mVar;
        if (this.passwordType == 1) {
            if (!j0()) {
                x1.f1.lb.media.d.f20812a.w(password);
                ToastUtils.t(getString(R$string.adult_key_saved, ""), new Object[0]);
            }
            callback.invoke();
            if (this.passwordType == 1) {
                f19379h = true;
            } else {
                t.v.c.i.a.f18646a.H0();
            }
            mVar = this.passwordListener;
            if (mVar != null) {
                mVar.a(2);
            } else {
                xe.c.c().o(new nf.d(true, "", "enter adult"));
            }
            dismiss();
        }
        if (!j0()) {
            t.v.c.i.a.f18646a.G0(password);
            ToastUtils.s(2131952727);
        }
        callback.invoke();
        if (this.passwordType == 1) {
            f19379h = true;
        } else {
            t.v.c.i.a.f18646a.H0();
        }
        mVar = this.passwordListener;
        if (mVar != null) {
            mVar.a(2);
        } else {
            xe.c.c().o(new nf.d(true, "", "enter adult"));
        }
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i0(i iVar, DialogInterface dialogInterface) {
        m<Integer> mVar = iVar.passwordListener;
        if (mVar != null) {
            mVar.a(3);
        }
    }

    private final boolean j0() {
        if (this.passwordType == 2) {
            return t.v.c.i.a.f18646a.q0();
        }
        return x1.f1.lb.media.d.f20812a.n().length() > 0;
    }

    @Override // v7.a
    public void V(Context context, View view) {
        kotlin.jvm.internal.m.f(view, "view");
        if (context == null) {
            return;
        }
        final MyEditText myEditText = (MyEditText) view.findViewById(R$id.lock_password);
        this.btnOk = (MyButton) view.findViewById(R$id.btn_lock_password_ok);
        TextView textView = (TextView) view.findViewById(R$id.btn_lock_password_reset);
        this.btnReset = textView;
        if (textView != null) {
            textView.setText(Html.fromHtml("<u>" + getString(2131951820) + "</u>"));
        }
        this.tip = (TextView) view.findViewById(R$id.lock_dialog_input_tip);
        View viewFindViewById = view.findViewById(R$id.lock_dialog_desc);
        kotlin.jvm.internal.m.e(viewFindViewById, "findViewById(...)");
        TextView textView2 = (TextView) viewFindViewById;
        if (this.passwordType != 2) {
            ((TextView) view.findViewById(R$id.lock_dialog_title)).setText(getString(R$string.adult_key_title));
            if (j0()) {
                textView2.setText(getString(R$string.adult_key_input_remind));
            } else {
                textView2.setText(getString(R$string.adult_key_first_hint));
            }
        } else if (j0()) {
            textView2.setText(context.getString(2131952722));
        } else {
            textView2.setText(context.getString(2131952723));
        }
        ((MyButton) view.findViewById(R$id.btn_lock_password_cancel)).setOnClickListener(new View.OnClickListener() { // from class: u5.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                i.e0(this.f19372a, view2);
            }
        });
        myEditText.requestFocus();
        MyButton myButton = this.btnOk;
        if (myButton != null) {
            myButton.setOnClickListener(new View.OnClickListener() { // from class: u5.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    i.f0(myEditText, this, view2);
                }
            });
        }
        TextView textView3 = this.btnReset;
        if (textView3 != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: u5.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    i.h0(this.f19375a, view2);
                }
            });
        }
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: u5.g
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    i.i0(this.f19376a, dialogInterface);
                }
            });
        }
    }

    public final void k0(m<Integer> callback) {
        kotlin.jvm.internal.m.f(callback, "callback");
        this.passwordListener = callback;
    }

    public final void l0(int passwordType) {
        this.passwordType = passwordType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(i iVar, View view) {
        Dialog dialog = iVar.getDialog();
        if (dialog != null) {
            dialog.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(final MyEditText myEditText, i iVar, View view) {
        String string;
        Editable text = myEditText.getText();
        if (text == null || (string = text.toString()) == null) {
            string = "";
        }
        if (string.length() < 4) {
            ToastUtils.s(2131952725);
        } else {
            iVar.d0(string, new c9.a() { // from class: u5.h
                @Override // c9.a
                public final Object invoke() {
                    return i.g0(myEditText);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final z g0(MyEditText myEditText) {
        Editable text = myEditText.getText();
        if (text != null) {
            text.clear();
        }
        return z.f17874a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h0(i iVar, View view) {
        iVar.dismiss();
        m<Integer> mVar = iVar.passwordListener;
        if (mVar != null) {
            mVar.a(1);
        }
    }

    @Override // v7.a
    public int U() {
        return R$layout.dialog_input_lock_passowrd;
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
