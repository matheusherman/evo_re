package com.live.evo.widget;

import android.content.Context;
import android.graphics.Rect;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.annotation.Nullable;
import com.live.evo.R$color;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.live.evo.R$style;
import com.live.evo.util.x1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class LabelRemoveKeyCodeEnterEditText extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private RemoveKeyCodeEnterEditText f7461a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TextView f7462b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f7463c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f7464d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f7465e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f7466f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f7467g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f7468h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f7469i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f7470j;

    public LabelRemoveKeyCodeEnterEditText(Context context) {
        this(context, null);
    }

    public LabelRemoveKeyCodeEnterEditText(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RemoveKeyCodeEnterEditText getRemoveKeyCodeEnterEditText() {
        return this.f7461a;
    }

    public void setEditId(@IdRes int i10) {
        RemoveKeyCodeEnterEditText removeKeyCodeEnterEditText = this.f7461a;
        if (removeKeyCodeEnterEditText != null) {
            removeKeyCodeEnterEditText.setId(i10);
        }
    }

    public LabelRemoveKeyCodeEnterEditText(Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        int attributeResourceValue = attributeSet.getAttributeResourceValue(null, "labelPosition", 0);
        if (attributeResourceValue != 0) {
            this.f7464d = getResources().getString(attributeResourceValue);
        } else {
            this.f7464d = attributeSet.getAttributeValue(null, "labelPosition");
        }
        int attributeResourceValue2 = attributeSet.getAttributeResourceValue(null, "labelText", 0);
        if (attributeResourceValue2 != 0) {
            this.f7463c = getResources().getString(attributeResourceValue2);
        } else {
            this.f7463c = attributeSet.getAttributeValue(null, "labelText");
        }
        int attributeResourceValue3 = attributeSet.getAttributeResourceValue(null, "labelFontSize", 0);
        if (attributeResourceValue3 != 0) {
            this.f7465e = getResources().getInteger(attributeResourceValue3);
        } else {
            this.f7465e = attributeSet.getAttributeIntValue(null, "labelFontSize", 18);
        }
        int attributeResourceValue4 = attributeSet.getAttributeResourceValue(null, "labelColor", 0);
        if (attributeResourceValue4 != 0) {
            this.f7466f = getResources().getInteger(attributeResourceValue4);
        } else {
            this.f7466f = attributeSet.getAttributeIntValue(null, "labelColor", R$color.text_hint_color_normal);
        }
        int attributeResourceValue5 = attributeSet.getAttributeResourceValue(null, "editLenght", 0);
        if (attributeResourceValue5 != 0) {
            this.f7467g = getResources().getInteger(attributeResourceValue5);
        } else {
            this.f7467g = attributeSet.getAttributeIntValue(null, "editLenght", 50);
        }
        int attributeResourceValue6 = attributeSet.getAttributeResourceValue(null, "editInputType", 0);
        if (attributeResourceValue6 != 0) {
            this.f7468h = getResources().getInteger(attributeResourceValue6);
        } else {
            this.f7468h = attributeSet.getAttributeIntValue(null, "editInputType", 1);
        }
        int attributeResourceValue7 = attributeSet.getAttributeResourceValue(null, "editStyle", 0);
        if (attributeResourceValue7 != 0) {
            this.f7469i = getResources().getInteger(attributeResourceValue7);
        } else {
            this.f7469i = attributeSet.getAttributeIntValue(null, "editStyle", R$style.LabelEditTextStyle);
        }
        int attributeResourceValue8 = attributeSet.getAttributeResourceValue(null, "editHintText", 0);
        if (attributeResourceValue8 != 0) {
            this.f7470j = getResources().getString(attributeResourceValue8);
        } else {
            this.f7470j = attributeSet.getAttributeValue(null, "editHintText");
        }
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R$layout.label_removekeycode_edittext, this);
        TextView textView = (TextView) findViewById(R$id.tv_label);
        this.f7462b = textView;
        com.live.evo.util.t.c(textView);
        if (TextUtils.isEmpty(this.f7463c)) {
            this.f7462b.setVisibility(8);
        } else {
            this.f7462b.setText(this.f7463c);
            this.f7462b.setTextSize(this.f7465e);
            this.f7462b.setTextColor(x1.e(this.f7466f));
        }
        RemoveKeyCodeEnterEditText removeKeyCodeEnterEditText = (RemoveKeyCodeEnterEditText) findViewById(R$id.et_codetext);
        this.f7461a = removeKeyCodeEnterEditText;
        com.live.evo.util.t.c(removeKeyCodeEnterEditText);
        this.f7461a.setInputType(this.f7468h);
        this.f7461a.setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.f7467g)});
        this.f7461a.setTextAppearance(context, this.f7469i);
        this.f7461a.setHint(this.f7470j);
    }

    @Override // android.view.View
    protected void onFocusChanged(boolean z10, int i10, Rect rect) {
        super.onFocusChanged(z10, i10, rect);
    }
}
