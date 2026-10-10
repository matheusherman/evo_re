package com.tvc.lib.mobile.ui.base;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.FloatRange;
import androidx.annotation.GravityInt;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.color.utilities.Contrast;
import com.tvc.lib.R$style;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\u00020\u0004:\u0001\u001fB\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ+\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0013\u0010\u0006J\u000f\u0010\u0015\u001a\u00020\u0014H\u0017¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eR$\u0010%\u001a\u0004\u0018\u00018\u00008\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010-\u001a\u0004\u0018\u00010&8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u00105\u001a\u0004\u0018\u00010.8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u00109\u001a\u0002068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R$\u0010>\u001a\u0004\u0018\u00010=8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010C¨\u0006D"}, d2 = {"Lcom/tvc/lib/mobile/ui/base/g;", "Landroidx/databinding/ViewDataBinding;", "VB", "Landroidx/fragment/app/DialogFragment;", "Lcom/tvc/lib/mobile/ui/base/h;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "Lr8/z;", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "onStart", "", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "()F", "Landroidx/fragment/app/FragmentManager;", "manager", "X", "(Landroidx/fragment/app/FragmentManager;)V", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "(Landroid/content/DialogInterface;)V", "a", "Landroidx/databinding/ViewDataBinding;", "U", "()Landroidx/databinding/ViewDataBinding;", "setMDataBinding", "(Landroidx/databinding/ViewDataBinding;)V", "mDataBinding", "Landroid/content/Context;", "b", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "mContext", "Landroidx/appcompat/app/AppCompatActivity;", "c", "Landroidx/appcompat/app/AppCompatActivity;", "getMActivity", "()Landroidx/appcompat/app/AppCompatActivity;", "setMActivity", "(Landroidx/appcompat/app/AppCompatActivity;)V", "mActivity", "", "d", "Z", "isCancelableDefault", "()Z", ExifInterface.LONGITUDE_WEST, "(Z)V", "Lcom/tvc/lib/mobile/ui/base/g$a;", "dialogDismissListener", "Lcom/tvc/lib/mobile/ui/base/g$a;", "R", "()Lcom/tvc/lib/mobile/ui/base/g$a;", "setDialogDismissListener", "(Lcom/tvc/lib/mobile/ui/base/g$a;)V", "tvclib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class g<VB extends ViewDataBinding> extends DialogFragment implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private VB mDataBinding;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private Context mContext;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private AppCompatActivity mActivity;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isCancelableDefault = true;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/tvc/lib/mobile/ui/base/g$a;", "", "tvclib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface a {
    }

    protected final a R() {
        return null;
    }

    protected final VB U() {
        return this.mDataBinding;
    }

    @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN)
    public float V() {
        return 0.5f;
    }

    public final void W(boolean z10) {
        this.isCancelableDefault = z10;
    }

    public final void X(FragmentManager manager) {
        m.f(manager, "manager");
        super.show(manager, getClass().getSimpleName());
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        m.f(inflater, "inflater");
        this.mContext = getActivity();
        FragmentActivity activity = getActivity();
        m.d(activity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        this.mActivity = (AppCompatActivity) activity;
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCanceledOnTouchOutside(this.isCancelableDefault);
        }
        Dialog dialog2 = getDialog();
        if (dialog2 != null) {
            dialog2.setCancelable(this.isCancelableDefault);
        }
        VB vb2 = (VB) DataBindingUtil.inflate(inflater, g(), container, false);
        this.mDataBinding = vb2;
        m.c(vb2);
        vb2.setLifecycleOwner(this);
        f();
        l();
        y();
        VB vb3 = this.mDataBinding;
        m.c(vb3);
        View root = vb3.getRoot();
        m.e(root, "getRoot(...)");
        return root;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        m.f(dialog, "dialog");
        super.onDismiss(dialog);
    }

    public int S() {
        return h.a.a(this);
    }

    public int T() {
        return h.a.b(this);
    }

    @GravityInt
    public int Y() {
        return h.a.c(this);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(0, R$style.common_dialog_style);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        WindowManager.LayoutParams attributes = null;
        if (dialog != null) {
            window = dialog.getWindow();
        } else {
            window = null;
        }
        if (window != null) {
            attributes = window.getAttributes();
        }
        if (attributes != null) {
            attributes.width = T();
        }
        if (attributes != null) {
            attributes.height = S();
        }
        if (attributes != null) {
            attributes.gravity = Y();
        }
        if (window != null) {
            window.setAttributes(attributes);
        }
        if (window != null) {
            window.setDimAmount(V());
        }
    }
}
