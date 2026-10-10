package v7;

import android.content.DialogInterface;
import android.os.Build;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import c9.l;
import com.tvc.lib.R$layout;
import com.tvc.lib.mobile.ext.d;
import com.tvc.lib.mobile.ui.base.g;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0013\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00015B!\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\u000f\u0010\u000eJ\r\u0010\u0010\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u000bJ\u0015\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0003¢\u0006\u0004\b\u0012\u0010\u000eJ\r\u0010\u0013\u001a\u00020\u0006¢\u0006\u0004\b\u0013\u0010\u000bJ\u001f\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001a\u0010\u000bJ\u0017\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001f\u0010\u000bJ\u0015\u0010!\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b$\u0010%R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010(R\u0016\u0010)\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010'R\u0016\u0010+\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010'R\u0016\u0010-\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010'R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00102\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u00101R\u0016\u00104\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00101¨\u00066"}, d2 = {"Lv7/c;", "Lcom/tvc/lib/mobile/ui/base/g;", "Lp7/c;", "", "message", "Lkotlin/Function0;", "Lr8/z;", "onSure", "<init>", "(Ljava/lang/String;Lc9/a;)V", "f", "()V", "txt", "d0", "(Ljava/lang/String;)V", "e0", "b0", "text", "setTitle", "a0", "Lv7/c$a;", "onCancelListener", "", "cancelIfDismissWithoutConfirm", "g0", "(Lv7/c$a;Z)V", "l", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "(Landroid/content/DialogInterface;)V", "y", "isCancelableDefault", "f0", "(Z)V", "", "g", "()I", "e", "Ljava/lang/String;", "Lc9/a;", "titleText", "h", "confirmText", "i", "cancelText", "j", "Lv7/c$a;", "k", "Z", "isHideTitle", "m", "isHideCancelButton", "a", "tvclib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class c extends g<p7.c> {

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final String message;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final c9.a<z> onSure;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private String titleText;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private String confirmText;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private String cancelText;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private a onCancelListener;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    private boolean cancelIfDismissWithoutConfirm;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    private boolean isHideTitle;

    /* JADX INFO: renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isHideCancelButton;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lv7/c$a;", "", "Lr8/z;", "onCancel", "()V", "tvclib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface a {
        void onCancel();
    }

    public /* synthetic */ c(String str, c9.a aVar, int i10, kotlin.jvm.internal.g gVar) {
        this((i10 & 1) != 0 ? null : str, aVar);
    }

    public final void a0() {
        TextView textView;
        this.isHideCancelButton = true;
        p7.c cVarU = U();
        if (cVarU == null || (textView = cVarU.f17368a) == null) {
            return;
        }
        textView.setVisibility(8);
    }

    public final void b0() {
        TextView textView;
        this.isHideTitle = true;
        p7.c cVarU = U();
        if (cVarU == null || (textView = cVarU.f17371d) == null) {
            return;
        }
        textView.setVisibility(8);
    }

    public c(String str, c9.a<z> onSure) {
        m.f(onSure, "onSure");
        this.message = str;
        this.onSure = onSure;
        this.titleText = "";
        this.confirmText = "";
        this.cancelText = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final z c0(c cVar, View it) {
        m.f(it, "it");
        p7.c cVarU = cVar.U();
        if (m.a(it, cVarU != null ? cVarU.f17368a : null)) {
            a aVar = cVar.onCancelListener;
            if (aVar != null) {
                aVar.onCancel();
            }
        } else {
            p7.c cVarU2 = cVar.U();
            if (m.a(it, cVarU2 != null ? cVarU2.f17369b : null)) {
                cVar.onSure.invoke();
            }
        }
        cVar.dismiss();
        return z.f17874a;
    }

    public static /* synthetic */ void h0(c cVar, a aVar, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        cVar.g0(aVar, z10);
    }

    public final void d0(String txt) {
        TextView textView;
        m.f(txt, "txt");
        this.cancelText = txt;
        p7.c cVarU = U();
        if (cVarU == null || (textView = cVarU.f17368a) == null) {
            return;
        }
        textView.setText(txt);
    }

    public final void e0(String txt) {
        TextView textView;
        m.f(txt, "txt");
        this.confirmText = txt;
        p7.c cVarU = U();
        if (cVarU == null || (textView = cVarU.f17369b) == null) {
            return;
        }
        textView.setText(txt);
    }

    @Override // com.tvc.lib.mobile.ui.base.h
    public void f() {
        TextView textView;
        TextView textView2;
        p7.c cVarU;
        TextView textView3;
        p7.c cVarU2;
        TextView textView4;
        p7.c cVarU3;
        TextView textView5;
        TextView textView6;
        TextView textView7;
        TextView textView8;
        String str = this.message;
        if (str != null) {
            Spanned spannedFromHtml = Build.VERSION.SDK_INT >= 24 ? Html.fromHtml(str, 0) : Html.fromHtml(str);
            p7.c cVarU4 = U();
            if (cVarU4 != null && (textView8 = cVarU4.f17370c) != null) {
                textView8.setText(spannedFromHtml);
            }
        }
        if (this.isHideTitle) {
            p7.c cVarU5 = U();
            if (cVarU5 != null && (textView7 = cVarU5.f17371d) != null) {
                textView7.setVisibility(8);
            }
        } else {
            p7.c cVarU6 = U();
            if (cVarU6 != null && (textView = cVarU6.f17371d) != null) {
                textView.setVisibility(0);
            }
        }
        if (this.isHideCancelButton) {
            p7.c cVarU7 = U();
            if (cVarU7 != null && (textView6 = cVarU7.f17368a) != null) {
                textView6.setVisibility(8);
            }
        } else {
            p7.c cVarU8 = U();
            if (cVarU8 != null && (textView2 = cVarU8.f17368a) != null) {
                textView2.setVisibility(0);
            }
        }
        if (!TextUtils.isEmpty(this.titleText) && (cVarU3 = U()) != null && (textView5 = cVarU3.f17371d) != null) {
            textView5.setText(this.titleText);
        }
        if (!TextUtils.isEmpty(this.confirmText) && (cVarU2 = U()) != null && (textView4 = cVarU2.f17369b) != null) {
            textView4.setText(this.confirmText);
        }
        if (TextUtils.isEmpty(this.cancelText) || (cVarU = U()) == null || (textView3 = cVarU.f17368a) == null) {
            return;
        }
        textView3.setText(this.cancelText);
    }

    @Override // com.tvc.lib.mobile.ui.base.h
    public int g() {
        return R$layout.dialog_normal_notice;
    }

    public final void g0(a onCancelListener, boolean cancelIfDismissWithoutConfirm) {
        m.f(onCancelListener, "onCancelListener");
        this.onCancelListener = onCancelListener;
        this.cancelIfDismissWithoutConfirm = cancelIfDismissWithoutConfirm;
    }

    @Override // com.tvc.lib.mobile.ui.base.g, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        a aVar;
        m.f(dialog, "dialog");
        super.onDismiss(dialog);
        R();
        if (!this.cancelIfDismissWithoutConfirm || (aVar = this.onCancelListener) == null) {
            return;
        }
        aVar.onCancel();
    }

    public final void setTitle(String text) {
        TextView textView;
        m.f(text, "text");
        this.titleText = text;
        p7.c cVarU = U();
        if (cVarU == null || (textView = cVarU.f17371d) == null) {
            return;
        }
        textView.setText(text);
    }

    public final void f0(boolean isCancelableDefault) {
        W(isCancelableDefault);
    }

    @Override // com.tvc.lib.mobile.ui.base.h
    public void y() {
        TextView textView;
        p7.c cVarU = U();
        TextView textView2 = null;
        if (cVarU != null) {
            textView = cVarU.f17368a;
        } else {
            textView = null;
        }
        p7.c cVarU2 = U();
        if (cVarU2 != null) {
            textView2 = cVarU2.f17369b;
        }
        d.f(new View[]{textView, textView2}, 0L, new l() { // from class: v7.b
            @Override // c9.l
            public final Object invoke(Object obj) {
                return c.c0(this.f19708a, (View) obj);
            }
        }, 2, null);
    }

    @Override // com.tvc.lib.mobile.ui.base.h
    public void l() {
    }
}
