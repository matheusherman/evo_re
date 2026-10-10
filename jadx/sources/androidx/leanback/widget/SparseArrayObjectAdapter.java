package androidx.leanback.widget;

import android.util.SparseArray;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
public class SparseArrayObjectAdapter extends ObjectAdapter {
    private SparseArray<Object> mItems;

    public SparseArrayObjectAdapter(PresenterSelector presenterSelector) {
        super(presenterSelector);
        this.mItems = new SparseArray<>();
    }

    public void clear(int i10) {
        int iIndexOfKey = this.mItems.indexOfKey(i10);
        if (iIndexOfKey >= 0) {
            this.mItems.removeAt(iIndexOfKey);
            notifyItemRangeRemoved(iIndexOfKey, 1);
        }
    }

    public int indexOf(Object obj) {
        return this.mItems.indexOfValue(obj);
    }

    @Override // androidx.leanback.widget.ObjectAdapter
    public boolean isImmediateNotifySupported() {
        return true;
    }

    @Override // androidx.leanback.widget.ObjectAdapter
    public Object get(int i10) {
        return this.mItems.valueAt(i10);
    }

    public int indexOf(int i10) {
        return this.mItems.indexOfKey(i10);
    }

    public Object lookup(int i10) {
        return this.mItems.get(i10);
    }

    public void set(int i10, Object obj) {
        int iIndexOfKey = this.mItems.indexOfKey(i10);
        if (iIndexOfKey < 0) {
            this.mItems.append(i10, obj);
            notifyItemRangeInserted(this.mItems.indexOfKey(i10), 1);
        } else if (this.mItems.valueAt(iIndexOfKey) != obj) {
            this.mItems.setValueAt(iIndexOfKey, obj);
            notifyItemRangeChanged(iIndexOfKey, 1);
        }
    }

    @Override // androidx.leanback.widget.ObjectAdapter
    public int size() {
        return this.mItems.size();
    }

    public SparseArrayObjectAdapter(Presenter presenter) {
        super(presenter);
        this.mItems = new SparseArray<>();
    }

    public void notifyArrayItemRangeChanged(int i10, int i11) {
        notifyItemRangeChanged(i10, i11);
    }

    public void clear() {
        int size = this.mItems.size();
        if (size == 0) {
            return;
        }
        this.mItems.clear();
        notifyItemRangeRemoved(0, size);
    }

    public SparseArrayObjectAdapter() {
        this.mItems = new SparseArray<>();
    }
}
