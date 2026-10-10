package com.live.evo.widget;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.DigitsKeyListener;
import android.util.AttributeSet;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class RechargeEditText extends RemoveKeyCodeEnterEditText {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f7528a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f7529b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f7530c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f7531d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f7532e;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String str = "";
            RechargeEditText.this.removeTextChangedListener(this);
            try {
                String strReplace = editable.toString().replace(" ", "");
                int i10 = 0;
                while (true) {
                    int i11 = i10 + 4;
                    if (i11 >= strReplace.length()) {
                        break;
                    }
                    str = str + strReplace.substring(i10, i11) + " ";
                    i10 = i11;
                }
                String str2 = str + strReplace.substring(i10, strReplace.length());
                int selectionStart = RechargeEditText.this.getSelectionStart();
                if (TextUtils.isEmpty(RechargeEditText.this.f7529b) || !str2.equals(RechargeEditText.this.f7529b)) {
                    RechargeEditText.this.f7529b = str2;
                    editable.replace(0, editable.length(), str2);
                    if (selectionStart % 5 == 0 && RechargeEditText.this.f7531d == 0) {
                        int i12 = selectionStart + 1;
                        if (i12 <= RechargeEditText.this.f7529b.length()) {
                            RechargeEditText.this.setSelection(i12);
                        } else {
                            RechargeEditText rechargeEditText = RechargeEditText.this;
                            rechargeEditText.setSelection(rechargeEditText.f7529b.length());
                        }
                    } else if (RechargeEditText.this.f7531d == 1 && selectionStart < RechargeEditText.this.f7529b.length()) {
                        RechargeEditText.this.setSelection(selectionStart);
                    } else if (RechargeEditText.this.f7531d != 0 || selectionStart >= RechargeEditText.this.f7529b.length()) {
                        RechargeEditText rechargeEditText2 = RechargeEditText.this;
                        rechargeEditText2.setSelection(rechargeEditText2.f7529b.length());
                    } else {
                        RechargeEditText.this.setSelection(selectionStart);
                    }
                }
            } catch (Exception unused) {
            } finally {
                RechargeEditText.this.addTextChangedListener(this);
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            RechargeEditText.this.f7530c = i10;
            RechargeEditText.this.f7531d = i11;
            RechargeEditText.this.f7532e = i12;
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    public RechargeEditText(Context context) {
        super(context);
        this.f7528a = false;
        this.f7529b = "";
        g();
    }

    private void g() {
        setInputType(2);
        if (getInputType() == 3 || getInputType() == 2) {
            setKeyListener(DigitsKeyListener.getInstance("0123456789* "));
        }
        addTextChangedListener(new a());
    }

    public RechargeEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7528a = false;
        this.f7529b = "";
        g();
    }

    public RechargeEditText(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f7528a = false;
        this.f7529b = "";
        g();
    }
}
