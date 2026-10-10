package androidx.leanback.widget;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import androidx.collection.LruCache;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
final class ViewsStateBundle {
    private static final int LIMIT_DEFAULT = 100;
    private static final int UNLIMITED = Integer.MAX_VALUE;
    private LruCache<String, SparseArray<Parcelable>> mChildStates;
    private int mSavePolicy = 0;
    private int mLimitNumber = 100;

    private void applyPolicyChanges() {
        int i10 = this.mSavePolicy;
        if (i10 == 2) {
            if (this.mLimitNumber <= 0) {
                throw new IllegalArgumentException();
            }
            LruCache<String, SparseArray<Parcelable>> lruCache = this.mChildStates;
            if (lruCache == null || lruCache.maxSize() != this.mLimitNumber) {
                this.mChildStates = new LruCache<>(this.mLimitNumber);
                return;
            }
            return;
        }
        if (i10 != 3 && i10 != 1) {
            this.mChildStates = null;
            return;
        }
        LruCache<String, SparseArray<Parcelable>> lruCache2 = this.mChildStates;
        if (lruCache2 == null || lruCache2.maxSize() != Integer.MAX_VALUE) {
            this.mChildStates = new LruCache<>(Integer.MAX_VALUE);
        }
    }

    private void saveViewUnchecked(View view, int i10) {
        if (this.mChildStates != null) {
            String saveStatesKey = getSaveStatesKey(i10);
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            view.saveHierarchyState(sparseArray);
            this.mChildStates.put(saveStatesKey, sparseArray);
        }
    }

    void clear() {
        LruCache<String, SparseArray<Parcelable>> lruCache = this.mChildStates;
        if (lruCache != null) {
            lruCache.evictAll();
        }
    }

    int getLimitNumber() {
        return this.mLimitNumber;
    }

    int getSavePolicy() {
        return this.mSavePolicy;
    }

    void loadFromBundle(Bundle bundle) {
        LruCache<String, SparseArray<Parcelable>> lruCache = this.mChildStates;
        if (lruCache == null || bundle == null) {
            return;
        }
        lruCache.evictAll();
        for (String str : bundle.keySet()) {
            this.mChildStates.put(str, bundle.getSparseParcelableArray(str));
        }
    }

    void loadView(View view, int i10) {
        if (this.mChildStates != null) {
            SparseArray<Parcelable> sparseArrayRemove = this.mChildStates.remove(getSaveStatesKey(i10));
            if (sparseArrayRemove != null) {
                view.restoreHierarchyState(sparseArrayRemove);
            }
        }
    }

    void remove(int i10) {
        LruCache<String, SparseArray<Parcelable>> lruCache = this.mChildStates;
        if (lruCache == null || lruCache.size() == 0) {
            return;
        }
        this.mChildStates.remove(getSaveStatesKey(i10));
    }

    Bundle saveAsBundle() {
        LruCache<String, SparseArray<Parcelable>> lruCache = this.mChildStates;
        if (lruCache == null || lruCache.size() == 0) {
            return null;
        }
        Map<String, SparseArray<Parcelable>> mapSnapshot = this.mChildStates.snapshot();
        Bundle bundle = new Bundle();
        for (Map.Entry<String, SparseArray<Parcelable>> entry : mapSnapshot.entrySet()) {
            bundle.putSparseParcelableArray(entry.getKey(), entry.getValue());
        }
        return bundle;
    }

    void saveOffscreenView(View view, int i10) {
        int i11 = this.mSavePolicy;
        if (i11 == 1) {
            remove(i10);
        } else if (i11 == 2 || i11 == 3) {
            saveViewUnchecked(view, i10);
        }
    }

    Bundle saveOnScreenView(Bundle bundle, View view, int i10) {
        if (this.mSavePolicy != 0) {
            String saveStatesKey = getSaveStatesKey(i10);
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            view.saveHierarchyState(sparseArray);
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray(saveStatesKey, sparseArray);
        }
        return bundle;
    }

    void setLimitNumber(int i10) {
        this.mLimitNumber = i10;
        applyPolicyChanges();
    }

    void setSavePolicy(int i10) {
        this.mSavePolicy = i10;
        applyPolicyChanges();
    }

    ViewsStateBundle() {
    }

    static String getSaveStatesKey(int i10) {
        return Integer.toString(i10);
    }
}
