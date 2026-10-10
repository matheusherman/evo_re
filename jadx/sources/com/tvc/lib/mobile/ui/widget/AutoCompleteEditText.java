package com.tvc.lib.mobile.ui.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.tvc.lib.R$mipmap;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class AutoCompleteEditText extends AppCompatAutoCompleteTextView implements View.OnTouchListener, View.OnFocusChangeListener, TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Drawable f9235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View.OnTouchListener f9236b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View.OnFocusChangeListener f9237c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private r f9238d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<String> f9239e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f9240f;

    public AutoCompleteEditText(Context context) {
        super(context);
        a(context);
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z10) {
        if (!z10 || getText() == null) {
            setClearIconVisible(false);
        } else {
            setClearIconVisible(getText().length() > 0);
        }
        View.OnFocusChangeListener onFocusChangeListener = this.f9237c;
        if (onFocusChangeListener != null) {
            onFocusChangeListener.onFocusChange(view, z10);
        }
    }

    private void a(Context context) {
        Drawable drawableWrap = DrawableCompat.wrap(ContextCompat.getDrawable(context, R$mipmap.delete_input));
        this.f9235a = drawableWrap;
        drawableWrap.setBounds(0, 0, drawableWrap.getIntrinsicWidth(), this.f9235a.getIntrinsicHeight());
        setClearIconVisible(false);
        super.setOnTouchListener(this);
        super.setOnFocusChangeListener(this);
        super.addTextChangedListener(this);
        this.f9239e = Arrays.asList("gmail.com", "hotmail.com", "outlook.com", "yahoo.com.br", "yahoo.com");
        r rVar = new r(context);
        this.f9238d = rVar;
        setAdapter(rVar);
        setThreshold(1);
    }

    private void setClearIconVisible(boolean z10) {
        if (this.f9235a.isVisible() == z10) {
            return;
        }
        this.f9235a.setVisible(z10, false);
        Drawable[] compoundDrawables = getCompoundDrawables();
        setCompoundDrawables(compoundDrawables[0], compoundDrawables[1], z10 ? this.f9235a : null, compoundDrawables[3]);
    }

    @Override // android.widget.AutoCompleteTextView
    public boolean enoughToFilter() {
        String str = this.f9240f;
        return (str == null || !str.endsWith("@") || this.f9240f.endsWith("@@")) ? false : true;
    }

    @Override // android.view.View
    public void setOnFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.f9237c = onFocusChangeListener;
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.f9236b = onTouchListener;
    }

    public AutoCompleteEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    @Override // android.widget.TextView, android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        boolean z10;
        if (isFocused()) {
            if (charSequence.length() > 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            setClearIconVisible(z10);
            this.f9240f = charSequence.toString();
            this.f9238d.c(charSequence.toString(), this.f9239e);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int x10 = (int) motionEvent.getX();
        if (this.f9235a.isVisible() && x10 > (getWidth() - getPaddingRight()) - this.f9235a.getIntrinsicWidth()) {
            if (motionEvent.getAction() == 1) {
                setText("");
            }
            return true;
        }
        View.OnTouchListener onTouchListener = this.f9236b;
        if (onTouchListener != null && onTouchListener.onTouch(view, motionEvent)) {
            return true;
        }
        return false;
    }

    public AutoCompleteEditText(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        a(context);
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
    }
}
