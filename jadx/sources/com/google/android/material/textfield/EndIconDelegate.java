package com.google.android.material.textfield;

import android.content.Context;
import android.text.Editable;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.EditText;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.internal.CheckableImageButton;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
abstract class EndIconDelegate {
    final Context context;
    final CheckableImageButton endIconView;
    final EndCompoundLayout endLayout;
    final TextInputLayout textInputLayout;

    @StringRes
    int getIconContentDescriptionResId() {
        return 0;
    }

    @DrawableRes
    int getIconDrawableResId() {
        return 0;
    }

    View.OnFocusChangeListener getOnEditTextFocusChangeListener() {
        return null;
    }

    View.OnClickListener getOnIconClickListener() {
        return null;
    }

    View.OnFocusChangeListener getOnIconViewFocusChangeListener() {
        return null;
    }

    AccessibilityManager.TouchExplorationStateChangeListener getTouchExplorationStateChangeListener() {
        return null;
    }

    boolean isBoxBackgroundModeSupported(int i10) {
        return true;
    }

    boolean isIconActivable() {
        return false;
    }

    boolean isIconActivated() {
        return false;
    }

    boolean isIconCheckable() {
        return false;
    }

    boolean isIconChecked() {
        return false;
    }

    boolean shouldTintIconOnError() {
        return false;
    }

    final void refreshIconState() {
        this.endLayout.refreshIconState(false);
    }

    EndIconDelegate(@NonNull EndCompoundLayout endCompoundLayout) {
        this.textInputLayout = endCompoundLayout.textInputLayout;
        this.endLayout = endCompoundLayout;
        this.context = endCompoundLayout.getContext();
        this.endIconView = endCompoundLayout.getEndIconView();
    }

    void setUp() {
    }

    void tearDown() {
    }

    void afterEditTextChanged(Editable editable) {
    }

    void onEditTextAttached(@Nullable EditText editText) {
    }

    void onSuffixVisibilityChanged(boolean z10) {
    }

    void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
    }

    void onPopulateAccessibilityEvent(View view, @NonNull AccessibilityEvent accessibilityEvent) {
    }

    void beforeEditTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
    }
}
