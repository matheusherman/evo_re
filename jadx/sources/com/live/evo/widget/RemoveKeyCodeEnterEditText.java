package com.live.evo.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatEditText;
import com.live.evo.util.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class RemoveKeyCodeEnterEditText extends AppCompatEditText {
    public RemoveKeyCodeEnterEditText(Context context) {
        super(context);
    }

    public RemoveKeyCodeEnterEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.TextView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (i10 == 20) {
            return false;
        }
        int length = getText() == null ? 0 : getText().length();
        int selectionStart = getSelectionStart();
        if ((length == 0 || selectionStart == 0) && i10 == 19) {
            return false;
        }
        if (i10 == 21 && selectionStart <= 0) {
            return false;
        }
        if (i10 == 22 && selectionStart >= length) {
            return false;
        }
        if (i10 == 66) {
            i10 = 23;
        }
        return super.onKeyDown(i10, keyEvent);
    }

    @Override // android.widget.TextView, android.view.View, android.view.KeyEvent.Callback
    @RequiresApi(api = 21)
    public boolean onKeyUp(int i10, KeyEvent keyEvent) {
        if (i10 == 66) {
            i10 = 23;
        }
        return super.onKeyUp(i10, keyEvent);
    }

    public RemoveKeyCodeEnterEditText(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }

    @Override // android.widget.TextView
    public void onEditorAction(int i10) {
        InputMethodManager inputMethodManagerA = z.a();
        if (i10 == 5) {
            View viewFocusSearch = focusSearch(2);
            if (viewFocusSearch != null && !viewFocusSearch.requestFocus(2)) {
                throw new IllegalStateException("focus search returned a view that wasn't able to take focus!");
            }
            return;
        }
        if (i10 == 7) {
            View viewFocusSearch2 = focusSearch(1);
            if (viewFocusSearch2 != null && !viewFocusSearch2.requestFocus(1)) {
                throw new IllegalStateException("focus search returned a view that wasn't able to take focus!");
            }
            return;
        }
        if (i10 == 6 && inputMethodManagerA != null && inputMethodManagerA.isActive(this)) {
            inputMethodManagerA.hideSoftInputFromWindow(getWindowToken(), 0);
        }
    }
}
