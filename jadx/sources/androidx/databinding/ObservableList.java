package androidx.databinding;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
public interface ObservableList<T> extends List<T> {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static abstract class OnListChangedCallback<T extends ObservableList> {
        public abstract void onChanged(T t10);

        public abstract void onItemRangeChanged(T t10, int i10, int i11);

        public abstract void onItemRangeInserted(T t10, int i10, int i11);

        public abstract void onItemRangeMoved(T t10, int i10, int i11, int i12);

        public abstract void onItemRangeRemoved(T t10, int i10, int i11);
    }

    void addOnListChangedCallback(OnListChangedCallback<? extends ObservableList<T>> onListChangedCallback);

    void removeOnListChangedCallback(OnListChangedCallback<? extends ObservableList<T>> onListChangedCallback);
}
