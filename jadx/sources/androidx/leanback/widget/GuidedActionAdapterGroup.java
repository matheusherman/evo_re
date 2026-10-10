package androidx.leanback.widget;

import android.util.Pair;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class GuidedActionAdapterGroup {
    private static final boolean DEBUG_EDIT = false;
    private static final String TAG_EDIT = "EditableAction";
    ArrayList<Pair<GuidedActionAdapter, GuidedActionAdapter>> mAdapters = new ArrayList<>();
    private GuidedActionAdapter.EditListener mEditListener;
    private boolean mImeOpened;

    public GuidedActionAdapter getNextAdapter(GuidedActionAdapter guidedActionAdapter) {
        for (int i10 = 0; i10 < this.mAdapters.size(); i10++) {
            Pair<GuidedActionAdapter, GuidedActionAdapter> pair = this.mAdapters.get(i10);
            if (pair.first == guidedActionAdapter) {
                return (GuidedActionAdapter) pair.second;
            }
        }
        return null;
    }

    public void addAdpter(GuidedActionAdapter guidedActionAdapter, GuidedActionAdapter guidedActionAdapter2) {
        this.mAdapters.add(new Pair<>(guidedActionAdapter, guidedActionAdapter2));
        if (guidedActionAdapter != null) {
            guidedActionAdapter.mGroup = this;
        }
        if (guidedActionAdapter2 != null) {
            guidedActionAdapter2.mGroup = this;
        }
    }

    public void closeIme(View view) {
        if (this.mImeOpened) {
            this.mImeOpened = false;
            ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
            this.mEditListener.onImeClose();
        }
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0011 A[LOOP:0: B:9:0x0012->B:8:0x0011, LOOP_END] */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0012, code lost:
    
        r9 = 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    boolean focusToNextAction(GuidedActionAdapter guidedActionAdapter, GuidedAction guidedAction, long j10) {
        int i10;
        if (j10 != -2) {
            i10 = 0;
        } else {
            int iIndexOf = guidedActionAdapter.indexOf(guidedAction);
            if (iIndexOf < 0) {
                return false;
            }
            i10 = iIndexOf + 1;
        }
        while (true) {
            int count = guidedActionAdapter.getCount();
            if (j10 == -2) {
                while (i10 < count && !guidedActionAdapter.getItem(i10).isFocusable()) {
                    i10++;
                }
            } else {
                while (i10 < count && guidedActionAdapter.getItem(i10).getId() != j10) {
                    i10++;
                }
            }
            if (i10 < count) {
                GuidedActionsStylist.ViewHolder viewHolder = (GuidedActionsStylist.ViewHolder) guidedActionAdapter.getGuidedActionsStylist().getActionsGridView().findViewHolderForPosition(i10);
                if (viewHolder == null) {
                    return false;
                }
                if (viewHolder.getAction().hasTextEditable()) {
                    openIme(guidedActionAdapter, viewHolder);
                } else {
                    closeIme(viewHolder.itemView);
                    viewHolder.itemView.requestFocus();
                }
                return true;
            }
            guidedActionAdapter = getNextAdapter(guidedActionAdapter);
            if (guidedActionAdapter == null) {
                return false;
            }
            i10 = 0;
        }
    }

    public void setEditListener(GuidedActionAdapter.EditListener editListener) {
        this.mEditListener = editListener;
    }

    private void updateTextIntoAction(GuidedActionsStylist.ViewHolder viewHolder, TextView textView) {
        GuidedAction action = viewHolder.getAction();
        if (textView == viewHolder.getDescriptionView()) {
            if (action.getEditDescription() != null) {
                action.setEditDescription(textView.getText());
                return;
            } else {
                action.setDescription(textView.getText());
                return;
            }
        }
        if (textView == viewHolder.getTitleView()) {
            if (action.getEditTitle() != null) {
                action.setEditTitle(textView.getText());
            } else {
                action.setTitle(textView.getText());
            }
        }
    }

    public void fillAndGoNext(GuidedActionAdapter guidedActionAdapter, TextView textView) {
        GuidedActionsStylist.ViewHolder viewHolderFindSubChildViewHolder = guidedActionAdapter.findSubChildViewHolder(textView);
        updateTextIntoAction(viewHolderFindSubChildViewHolder, textView);
        guidedActionAdapter.performOnActionClick(viewHolderFindSubChildViewHolder);
        long jOnGuidedActionEditedAndProceed = this.mEditListener.onGuidedActionEditedAndProceed(viewHolderFindSubChildViewHolder.getAction());
        boolean zFocusToNextAction = false;
        guidedActionAdapter.getGuidedActionsStylist().setEditingMode(viewHolderFindSubChildViewHolder, false);
        if (jOnGuidedActionEditedAndProceed != -3 && jOnGuidedActionEditedAndProceed != viewHolderFindSubChildViewHolder.getAction().getId()) {
            zFocusToNextAction = focusToNextAction(guidedActionAdapter, viewHolderFindSubChildViewHolder.getAction(), jOnGuidedActionEditedAndProceed);
        }
        if (!zFocusToNextAction) {
            closeIme(textView);
            viewHolderFindSubChildViewHolder.itemView.requestFocus();
        }
    }

    public void fillAndStay(GuidedActionAdapter guidedActionAdapter, TextView textView) {
        GuidedActionsStylist.ViewHolder viewHolderFindSubChildViewHolder = guidedActionAdapter.findSubChildViewHolder(textView);
        updateTextIntoAction(viewHolderFindSubChildViewHolder, textView);
        this.mEditListener.onGuidedActionEditCanceled(viewHolderFindSubChildViewHolder.getAction());
        guidedActionAdapter.getGuidedActionsStylist().setEditingMode(viewHolderFindSubChildViewHolder, false);
        closeIme(textView);
        viewHolderFindSubChildViewHolder.itemView.requestFocus();
    }

    public void openIme(GuidedActionAdapter guidedActionAdapter, GuidedActionsStylist.ViewHolder viewHolder) {
        guidedActionAdapter.getGuidedActionsStylist().setEditingMode(viewHolder, true);
        View editingView = viewHolder.getEditingView();
        if (editingView != null && viewHolder.isInEditingText()) {
            InputMethodManager inputMethodManager = (InputMethodManager) editingView.getContext().getSystemService("input_method");
            editingView.setFocusable(true);
            editingView.requestFocus();
            inputMethodManager.showSoftInput(editingView, 0);
            if (!this.mImeOpened) {
                this.mImeOpened = true;
                this.mEditListener.onImeOpen();
            }
        }
    }
}
