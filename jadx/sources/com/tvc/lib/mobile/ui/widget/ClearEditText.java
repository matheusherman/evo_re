package com.tvc.lib.mobile.ui.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.tvc.lib.R$mipmap;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B'\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0015\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0018\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010!\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"J1\u0010(\u001a\u00020\r2\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020\t2\u0006\u0010'\u001a\u00020\tH\u0016¢\u0006\u0004\b(\u0010)J1\u0010+\u001a\u00020\r2\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010%\u001a\u00020\t2\u0006\u0010'\u001a\u00020\t2\u0006\u0010*\u001a\u00020\tH\u0016¢\u0006\u0004\b+\u0010)J\u0019\u0010-\u001a\u00020\r2\b\u0010$\u001a\u0004\u0018\u00010,H\u0016¢\u0006\u0004\b-\u0010.R\u0018\u00101\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u00100R\u0018\u00104\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0018\u00107\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106¨\u00068"}, d2 = {"Lcom/tvc/lib/mobile/ui/widget/ClearEditText;", "Landroidx/appcompat/widget/AppCompatEditText;", "Landroid/view/View$OnTouchListener;", "Landroid/view/View$OnFocusChangeListener;", "Landroid/text/TextWatcher;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lr8/z;", "a", "(Landroid/content/Context;)V", "", "visible", "setClearIconVisible", "(Z)V", "onFocusChangeListener", "setOnFocusChangeListener", "(Landroid/view/View$OnFocusChangeListener;)V", "onTouchListener", "setOnTouchListener", "(Landroid/view/View$OnTouchListener;)V", "Landroid/view/View;", "view", "hasFocus", "onFocusChange", "(Landroid/view/View;Z)V", "Landroid/view/MotionEvent;", "motionEvent", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "", "s", "start", "before", "count", "onTextChanged", "(Ljava/lang/CharSequence;III)V", "after", "beforeTextChanged", "Landroid/text/Editable;", "afterTextChanged", "(Landroid/text/Editable;)V", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Drawable;", "mClearIcon", "b", "Landroid/view/View$OnTouchListener;", "mOnTouchListener", "c", "Landroid/view/View$OnFocusChangeListener;", "mOnFocusChangeListener", "tvclib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ClearEditText extends AppCompatEditText implements View.OnTouchListener, View.OnFocusChangeListener, TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private Drawable mClearIcon;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private View.OnTouchListener mOnTouchListener;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private View.OnFocusChangeListener mOnFocusChangeListener;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ClearEditText(Context context) {
        this(context, null, 0, 6, null);
        kotlin.jvm.internal.m.f(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ClearEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        kotlin.jvm.internal.m.f(context, "context");
    }

    private final void a(Context context) {
        Drawable drawable = ContextCompat.getDrawable(context, R$mipmap.delete_input);
        kotlin.jvm.internal.m.c(drawable);
        Drawable drawableWrap = DrawableCompat.wrap(drawable);
        kotlin.jvm.internal.m.e(drawableWrap, "wrap(...)");
        this.mClearIcon = drawableWrap;
        if (drawableWrap != null) {
            kotlin.jvm.internal.m.c(drawableWrap);
            int intrinsicWidth = drawableWrap.getIntrinsicWidth() - 20;
            Drawable drawable2 = this.mClearIcon;
            kotlin.jvm.internal.m.c(drawable2);
            drawableWrap.setBounds(-20, 0, intrinsicWidth, drawable2.getIntrinsicHeight());
        }
        setClearIconVisible(false);
        super.setOnTouchListener(this);
        super.setOnFocusChangeListener(this);
        super.addTextChangedListener(this);
    }

    private final void setClearIconVisible(boolean visible) {
        Drawable drawable = this.mClearIcon;
        if (drawable == null || drawable.isVisible() != visible) {
            Drawable drawable2 = this.mClearIcon;
            if (drawable2 != null) {
                drawable2.setVisible(visible, false);
            }
            Drawable[] compoundDrawables = getCompoundDrawables();
            kotlin.jvm.internal.m.e(compoundDrawables, "getCompoundDrawables(...)");
            setCompoundDrawables(compoundDrawables[0], compoundDrawables[1], visible ? this.mClearIcon : null, compoundDrawables[3]);
        }
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean hasFocus) {
        kotlin.jvm.internal.m.f(view, "view");
        if (!hasFocus || getText() == null) {
            setClearIconVisible(false);
        } else {
            Editable text = getText();
            kotlin.jvm.internal.m.c(text);
            setClearIconVisible(text.length() > 0);
        }
        View.OnFocusChangeListener onFocusChangeListener = this.mOnFocusChangeListener;
        if (onFocusChangeListener != null) {
            onFocusChangeListener.onFocusChange(view, hasFocus);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        kotlin.jvm.internal.m.f(view, "view");
        kotlin.jvm.internal.m.f(motionEvent, "motionEvent");
        int x10 = (int) motionEvent.getX();
        Drawable drawable = this.mClearIcon;
        if (drawable != null && drawable.isVisible()) {
            int width = getWidth() - getPaddingRight();
            Drawable drawable2 = this.mClearIcon;
            kotlin.jvm.internal.m.c(drawable2);
            if (x10 > width - drawable2.getIntrinsicWidth()) {
                if (motionEvent.getAction() == 1) {
                    setText("");
                }
                return true;
            }
        }
        View.OnTouchListener onTouchListener = this.mOnTouchListener;
        if (onTouchListener != null) {
            return onTouchListener.onTouch(view, motionEvent);
        }
        return false;
    }

    @Override // android.view.View
    public void setOnFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.mOnFocusChangeListener = onFocusChangeListener;
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.mOnTouchListener = onTouchListener;
    }

    public /* synthetic */ ClearEditText(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.g gVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    @Override // android.widget.TextView, android.text.TextWatcher
    public void onTextChanged(CharSequence s10, int start, int before, int count) {
        int length;
        if (isFocused()) {
            boolean z10 = false;
            if (s10 != null) {
                length = s10.length();
            } else {
                length = 0;
            }
            if (length > 0) {
                z10 = true;
            }
            setClearIconVisible(z10);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClearEditText(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.m.f(context, "context");
        a(context);
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable s10) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence s10, int start, int count, int after) {
    }
}
