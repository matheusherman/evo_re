package androidx.leanback.widget;

import android.util.Log;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
public class ArrayObjectAdapter extends ObjectAdapter {
    private static final Boolean DEBUG = Boolean.FALSE;
    private static final String TAG = "ArrayObjectAdapter";
    private final List<Object> mItems;
    ListUpdateCallback mListUpdateCallback;
    final List<Object> mOldItems;
    private List<?> mUnmodifiableItems;

    public ArrayObjectAdapter(PresenterSelector presenterSelector) {
        super(presenterSelector);
        this.mItems = new ArrayList();
        this.mOldItems = new ArrayList();
    }

    public void add(Object obj) {
        add(this.mItems.size(), obj);
    }

    @Override // androidx.leanback.widget.ObjectAdapter
    public boolean isImmediateNotifySupported() {
        return true;
    }

    public void add(int i10, Object obj) {
        this.mItems.add(i10, obj);
        notifyItemRangeInserted(i10, 1);
    }

    public void clear() {
        int size = this.mItems.size();
        if (size == 0) {
            return;
        }
        this.mItems.clear();
        notifyItemRangeRemoved(0, size);
    }

    @Override // androidx.leanback.widget.ObjectAdapter
    public Object get(int i10) {
        return this.mItems.get(i10);
    }

    public int indexOf(Object obj) {
        return this.mItems.indexOf(obj);
    }

    public void move(int i10, int i11) {
        if (i10 == i11) {
            return;
        }
        this.mItems.add(i11, this.mItems.remove(i10));
        notifyItemMoved(i10, i11);
    }

    public boolean remove(Object obj) {
        int iIndexOf = this.mItems.indexOf(obj);
        if (iIndexOf >= 0) {
            this.mItems.remove(iIndexOf);
            notifyItemRangeRemoved(iIndexOf, 1);
        }
        return iIndexOf >= 0;
    }

    public int removeItems(int i10, int i11) {
        int iMin = Math.min(i11, this.mItems.size() - i10);
        if (iMin <= 0) {
            return 0;
        }
        for (int i12 = 0; i12 < iMin; i12++) {
            this.mItems.remove(i10);
        }
        notifyItemRangeRemoved(i10, iMin);
        return iMin;
    }

    public void replace(int i10, Object obj) {
        this.mItems.set(i10, obj);
        notifyItemRangeChanged(i10, 1);
    }

    public void setItems(final List list, final DiffCallback diffCallback) {
        if (diffCallback == null) {
            this.mItems.clear();
            this.mItems.addAll(list);
            notifyChanged();
            return;
        }
        this.mOldItems.clear();
        this.mOldItems.addAll(this.mItems);
        DiffUtil.DiffResult diffResultCalculateDiff = DiffUtil.calculateDiff(new DiffUtil.Callback() { // from class: androidx.leanback.widget.ArrayObjectAdapter.1
            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public boolean areContentsTheSame(int i10, int i11) {
                return diffCallback.areContentsTheSame(ArrayObjectAdapter.this.mOldItems.get(i10), list.get(i11));
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public boolean areItemsTheSame(int i10, int i11) {
                return diffCallback.areItemsTheSame(ArrayObjectAdapter.this.mOldItems.get(i10), list.get(i11));
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public Object getChangePayload(int i10, int i11) {
                return diffCallback.getChangePayload(ArrayObjectAdapter.this.mOldItems.get(i10), list.get(i11));
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public int getNewListSize() {
                return list.size();
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public int getOldListSize() {
                return ArrayObjectAdapter.this.mOldItems.size();
            }
        });
        this.mItems.clear();
        this.mItems.addAll(list);
        if (this.mListUpdateCallback == null) {
            this.mListUpdateCallback = new ListUpdateCallback() { // from class: androidx.leanback.widget.ArrayObjectAdapter.2
                @Override // androidx.recyclerview.widget.ListUpdateCallback
                public void onChanged(int i10, int i11, Object obj) {
                    if (ArrayObjectAdapter.DEBUG.booleanValue()) {
                        Log.d(ArrayObjectAdapter.TAG, "onChanged");
                    }
                    ArrayObjectAdapter.this.notifyItemRangeChanged(i10, i11, obj);
                }

                @Override // androidx.recyclerview.widget.ListUpdateCallback
                public void onInserted(int i10, int i11) {
                    if (ArrayObjectAdapter.DEBUG.booleanValue()) {
                        Log.d(ArrayObjectAdapter.TAG, "onInserted");
                    }
                    ArrayObjectAdapter.this.notifyItemRangeInserted(i10, i11);
                }

                @Override // androidx.recyclerview.widget.ListUpdateCallback
                public void onMoved(int i10, int i11) {
                    if (ArrayObjectAdapter.DEBUG.booleanValue()) {
                        Log.d(ArrayObjectAdapter.TAG, "onMoved");
                    }
                    ArrayObjectAdapter.this.notifyItemMoved(i10, i11);
                }

                @Override // androidx.recyclerview.widget.ListUpdateCallback
                public void onRemoved(int i10, int i11) {
                    if (ArrayObjectAdapter.DEBUG.booleanValue()) {
                        Log.d(ArrayObjectAdapter.TAG, "onRemoved");
                    }
                    ArrayObjectAdapter.this.notifyItemRangeRemoved(i10, i11);
                }
            };
        }
        diffResultCalculateDiff.dispatchUpdatesTo(this.mListUpdateCallback);
        this.mOldItems.clear();
    }

    @Override // androidx.leanback.widget.ObjectAdapter
    public int size() {
        return this.mItems.size();
    }

    public <E> List<E> unmodifiableList() {
        if (this.mUnmodifiableItems == null) {
            this.mUnmodifiableItems = Collections.unmodifiableList(this.mItems);
        }
        return (List<E>) this.mUnmodifiableItems;
    }

    public void addAll(int i10, Collection<?> collection) {
        int size = collection.size();
        if (size == 0) {
            return;
        }
        this.mItems.addAll(i10, collection);
        notifyItemRangeInserted(i10, size);
    }

    public void notifyArrayItemRangeChanged(int i10, int i11) {
        notifyItemRangeChanged(i10, i11);
    }

    public ArrayObjectAdapter(Presenter presenter) {
        super(presenter);
        this.mItems = new ArrayList();
        this.mOldItems = new ArrayList();
    }

    public ArrayObjectAdapter() {
        this.mItems = new ArrayList();
        this.mOldItems = new ArrayList();
    }
}
