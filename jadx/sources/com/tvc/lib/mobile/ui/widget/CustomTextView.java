package com.tvc.lib.mobile.ui.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import t.v.c.widget.TextView;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class CustomTextView extends TextView {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f9244c;

    public CustomTextView(Context context) {
        super(context);
        this.f9244c = 13;
        c();
    }

    private void c() {
        setEllipsize(TextUtils.TruncateAt.END);
    }

    public void setMaxCharacters(int i10) {
        this.f9244c = i10;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        super.onTextChanged(charSequence, i10, i11, i12);
        if (this.f9244c == 0) {
            this.f9244c = 13;
        }
        if (charSequence.length() > this.f9244c) {
            setText(((Object) charSequence.subSequence(0, this.f9244c - 3)) + "...");
        }
    }

    public CustomTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9244c = 13;
        c();
    }

    public CustomTextView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f9244c = 13;
        c();
    }
}
