package androidx.leanback.app;

import androidx.leanback.widget.ObjectAdapter;
import androidx.leanback.widget.Row;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
class ListRowDataAdapter extends ObjectAdapter {
    public static final int ON_CHANGED = 16;
    public static final int ON_ITEM_RANGE_CHANGED = 2;
    public static final int ON_ITEM_RANGE_INSERTED = 4;
    public static final int ON_ITEM_RANGE_REMOVED = 8;
    private final ObjectAdapter mAdapter;
    final ObjectAdapter.DataObserver mDataObserver;
    int mLastVisibleRowIndex;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private class QueueBasedDataObserver extends ObjectAdapter.DataObserver {
        QueueBasedDataObserver() {
        }

        @Override // androidx.leanback.widget.ObjectAdapter.DataObserver
        public void onChanged() {
            ListRowDataAdapter.this.initialize();
            ListRowDataAdapter.this.notifyChanged();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private class SimpleDataObserver extends ObjectAdapter.DataObserver {
        SimpleDataObserver() {
        }

        @Override // androidx.leanback.widget.ObjectAdapter.DataObserver
        public void onChanged() {
            ListRowDataAdapter.this.initialize();
            onEventFired(16, -1, -1);
        }

        protected void onEventFired(int i10, int i11, int i12) {
            ListRowDataAdapter.this.doNotify(i10, i11, i12);
        }

        @Override // androidx.leanback.widget.ObjectAdapter.DataObserver
        public void onItemRangeChanged(int i10, int i11) {
            int i12 = ListRowDataAdapter.this.mLastVisibleRowIndex;
            if (i10 <= i12) {
                onEventFired(2, i10, Math.min(i11, (i12 - i10) + 1));
            }
        }

        @Override // androidx.leanback.widget.ObjectAdapter.DataObserver
        public void onItemRangeInserted(int i10, int i11) {
            ListRowDataAdapter listRowDataAdapter = ListRowDataAdapter.this;
            int i12 = listRowDataAdapter.mLastVisibleRowIndex;
            if (i10 <= i12) {
                listRowDataAdapter.mLastVisibleRowIndex = i12 + i11;
                onEventFired(4, i10, i11);
                return;
            }
            listRowDataAdapter.initialize();
            int i13 = ListRowDataAdapter.this.mLastVisibleRowIndex;
            if (i13 > i12) {
                onEventFired(4, i12 + 1, i13 - i12);
            }
        }

        @Override // androidx.leanback.widget.ObjectAdapter.DataObserver
        public void onItemRangeRemoved(int i10, int i11) {
            int i12 = (i10 + i11) - 1;
            ListRowDataAdapter listRowDataAdapter = ListRowDataAdapter.this;
            int i13 = listRowDataAdapter.mLastVisibleRowIndex;
            if (i12 < i13) {
                listRowDataAdapter.mLastVisibleRowIndex = i13 - i11;
                onEventFired(8, i10, i11);
                return;
            }
            listRowDataAdapter.initialize();
            int i14 = ListRowDataAdapter.this.mLastVisibleRowIndex;
            int i15 = i13 - i14;
            if (i15 > 0) {
                onEventFired(8, Math.min(i14 + 1, i10), i15);
            }
        }
    }

    void doNotify(int i10, int i11, int i12) {
        if (i10 == 2) {
            notifyItemRangeChanged(i11, i12);
            return;
        }
        if (i10 == 4) {
            notifyItemRangeInserted(i11, i12);
            return;
        }
        if (i10 == 8) {
            notifyItemRangeRemoved(i11, i12);
        } else {
            if (i10 == 16) {
                notifyChanged();
                return;
            }
            throw new IllegalArgumentException("Invalid event type " + i10);
        }
    }

    void initialize() {
        this.mLastVisibleRowIndex = -1;
        for (int size = this.mAdapter.size() - 1; size >= 0; size--) {
            if (((Row) this.mAdapter.get(size)).isRenderedAsRowView()) {
                this.mLastVisibleRowIndex = size;
                return;
            }
        }
    }

    void detach() {
        this.mAdapter.unregisterObserver(this.mDataObserver);
    }

    @Override // androidx.leanback.widget.ObjectAdapter
    public Object get(int i10) {
        return this.mAdapter.get(i10);
    }

    @Override // androidx.leanback.widget.ObjectAdapter
    public int size() {
        return this.mLastVisibleRowIndex + 1;
    }

    public ListRowDataAdapter(ObjectAdapter objectAdapter) {
        super(objectAdapter.getPresenterSelector());
        this.mAdapter = objectAdapter;
        initialize();
        if (objectAdapter.isImmediateNotifySupported()) {
            this.mDataObserver = new SimpleDataObserver();
        } else {
            this.mDataObserver = new QueueBasedDataObserver();
        }
        attach();
    }

    void attach() {
        initialize();
        this.mAdapter.registerObserver(this.mDataObserver);
    }
}
