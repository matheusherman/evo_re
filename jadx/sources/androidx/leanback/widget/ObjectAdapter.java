package androidx.leanback.widget;

import android.annotation.SuppressLint;
import android.database.Observable;
import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
public abstract class ObjectAdapter {
    public static final int NO_ID = -1;
    private boolean mHasStableIds;
    private final DataObservable mObservable = new DataObservable();
    private PresenterSelector mPresenterSelector;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class DataObservable extends Observable<DataObserver> {
        public void notifyItemRangeChanged(int i10, int i11) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((DataObserver) ((Observable) this).mObservers.get(size)).onItemRangeChanged(i10, i11);
            }
        }

        boolean hasObserver() {
            return ((Observable) this).mObservers.size() > 0;
        }

        public void notifyChanged() {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((DataObserver) ((Observable) this).mObservers.get(size)).onChanged();
            }
        }

        public void notifyItemMoved(int i10, int i11) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((DataObserver) ((Observable) this).mObservers.get(size)).onItemMoved(i10, i11);
            }
        }

        public void notifyItemRangeInserted(int i10, int i11) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((DataObserver) ((Observable) this).mObservers.get(size)).onItemRangeInserted(i10, i11);
            }
        }

        public void notifyItemRangeRemoved(int i10, int i11) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((DataObserver) ((Observable) this).mObservers.get(size)).onItemRangeRemoved(i10, i11);
            }
        }

        DataObservable() {
        }

        public void notifyItemRangeChanged(int i10, int i11, Object obj) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((DataObserver) ((Observable) this).mObservers.get(size)).onItemRangeChanged(i10, i11, obj);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static abstract class DataObserver {
        public void onItemRangeChanged(int i10, int i11) {
            onChanged();
        }

        public void onItemRangeChanged(int i10, int i11, Object obj) {
            onChanged();
        }

        public void onItemMoved(int i10, int i11) {
            onChanged();
        }

        public void onItemRangeInserted(int i10, int i11) {
            onChanged();
        }

        public void onItemRangeRemoved(int i10, int i11) {
            onChanged();
        }

        public void onChanged() {
        }
    }

    public ObjectAdapter(PresenterSelector presenterSelector) {
        setPresenterSelector(presenterSelector);
    }

    public abstract Object get(int i10);

    public boolean isImmediateNotifySupported() {
        return false;
    }

    public final void notifyItemRangeChanged(int i10, int i11) {
        this.mObservable.notifyItemRangeChanged(i10, i11);
    }

    public abstract int size();

    public long getId(int i10) {
        return -1L;
    }

    public final Presenter getPresenter(Object obj) {
        PresenterSelector presenterSelector = this.mPresenterSelector;
        if (presenterSelector != null) {
            return presenterSelector.getPresenter(obj);
        }
        throw new IllegalStateException("Presenter selector must not be null");
    }

    public final PresenterSelector getPresenterSelector() {
        return this.mPresenterSelector;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public final boolean hasObserver() {
        return this.mObservable.hasObserver();
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public final boolean hasStableIds() {
        return this.mHasStableIds;
    }

    protected final void notifyChanged() {
        this.mObservable.notifyChanged();
    }

    protected final void notifyItemMoved(int i10, int i11) {
        this.mObservable.notifyItemMoved(i10, i11);
    }

    public final void notifyItemRangeChanged(int i10, int i11, Object obj) {
        this.mObservable.notifyItemRangeChanged(i10, i11, obj);
    }

    protected final void notifyItemRangeInserted(int i10, int i11) {
        this.mObservable.notifyItemRangeInserted(i10, i11);
    }

    protected final void notifyItemRangeRemoved(int i10, int i11) {
        this.mObservable.notifyItemRangeRemoved(i10, i11);
    }

    public final void registerObserver(DataObserver dataObserver) {
        this.mObservable.registerObserver(dataObserver);
    }

    public final void setHasStableIds(boolean z10) {
        boolean z11 = this.mHasStableIds != z10;
        this.mHasStableIds = z10;
        if (z11) {
            onHasStableIdsChanged();
        }
    }

    public final void setPresenterSelector(PresenterSelector presenterSelector) {
        if (presenterSelector == null) {
            throw new IllegalArgumentException("Presenter selector must not be null");
        }
        PresenterSelector presenterSelector2 = this.mPresenterSelector;
        boolean z10 = false;
        boolean z11 = presenterSelector2 != null;
        if (z11 && presenterSelector2 != presenterSelector) {
            z10 = true;
        }
        this.mPresenterSelector = presenterSelector;
        if (z10) {
            onPresenterSelectorChanged();
        }
        if (z11) {
            notifyChanged();
        }
    }

    public final void unregisterAllObservers() {
        this.mObservable.unregisterAll();
    }

    public final void unregisterObserver(DataObserver dataObserver) {
        this.mObservable.unregisterObserver(dataObserver);
    }

    public ObjectAdapter(Presenter presenter) {
        setPresenterSelector(new SinglePresenterSelector(presenter));
    }

    public ObjectAdapter() {
    }

    protected void onHasStableIdsChanged() {
    }

    protected void onPresenterSelectorChanged() {
    }
}
