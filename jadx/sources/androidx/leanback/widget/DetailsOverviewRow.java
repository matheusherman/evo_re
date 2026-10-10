package androidx.leanback.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
public class DetailsOverviewRow extends Row {
    private ObjectAdapter mActionsAdapter;
    private PresenterSelector mDefaultActionPresenter;
    private Drawable mImageDrawable;
    private boolean mImageScaleUpAllowed;
    private Object mItem;
    private ArrayList<WeakReference<Listener>> mListeners;

    public DetailsOverviewRow(Object obj) {
        super(null);
        this.mImageScaleUpAllowed = true;
        this.mDefaultActionPresenter = new ActionPresenterSelector();
        this.mActionsAdapter = new ArrayObjectAdapter(this.mDefaultActionPresenter);
        this.mItem = obj;
        verify();
    }

    @Deprecated
    public final void addAction(Action action) {
        getArrayObjectAdapter().add(action);
    }

    private ArrayObjectAdapter getArrayObjectAdapter() {
        return (ArrayObjectAdapter) this.mActionsAdapter;
    }

    private void verify() {
        if (this.mItem == null) {
            throw new IllegalArgumentException("Object cannot be null");
        }
    }

    @Deprecated
    public final void addAction(int i10, Action action) {
        getArrayObjectAdapter().add(i10, action);
    }

    final void addListener(Listener listener) {
        if (this.mListeners == null) {
            this.mListeners = new ArrayList<>();
        } else {
            int i10 = 0;
            while (i10 < this.mListeners.size()) {
                Listener listener2 = this.mListeners.get(i10).get();
                if (listener2 == null) {
                    this.mListeners.remove(i10);
                } else if (listener2 == listener) {
                    return;
                } else {
                    i10++;
                }
            }
        }
        this.mListeners.add(new WeakReference<>(listener));
    }

    public final ObjectAdapter getActionsAdapter() {
        return this.mActionsAdapter;
    }

    public final Drawable getImageDrawable() {
        return this.mImageDrawable;
    }

    public final Object getItem() {
        return this.mItem;
    }

    public boolean isImageScaleUpAllowed() {
        return this.mImageScaleUpAllowed;
    }

    final void notifyActionsAdapterChanged() {
        if (this.mListeners != null) {
            int i10 = 0;
            while (i10 < this.mListeners.size()) {
                Listener listener = this.mListeners.get(i10).get();
                if (listener == null) {
                    this.mListeners.remove(i10);
                } else {
                    listener.onActionsAdapterChanged(this);
                    i10++;
                }
            }
        }
    }

    final void notifyImageDrawableChanged() {
        if (this.mListeners != null) {
            int i10 = 0;
            while (i10 < this.mListeners.size()) {
                Listener listener = this.mListeners.get(i10).get();
                if (listener == null) {
                    this.mListeners.remove(i10);
                } else {
                    listener.onImageDrawableChanged(this);
                    i10++;
                }
            }
        }
    }

    final void notifyItemChanged() {
        if (this.mListeners != null) {
            int i10 = 0;
            while (i10 < this.mListeners.size()) {
                Listener listener = this.mListeners.get(i10).get();
                if (listener == null) {
                    this.mListeners.remove(i10);
                } else {
                    listener.onItemChanged(this);
                    i10++;
                }
            }
        }
    }

    final void removeListener(Listener listener) {
        if (this.mListeners != null) {
            int i10 = 0;
            while (i10 < this.mListeners.size()) {
                Listener listener2 = this.mListeners.get(i10).get();
                if (listener2 == null) {
                    this.mListeners.remove(i10);
                } else {
                    if (listener2 == listener) {
                        this.mListeners.remove(i10);
                        return;
                    }
                    i10++;
                }
            }
        }
    }

    public final void setActionsAdapter(ObjectAdapter objectAdapter) {
        if (objectAdapter != this.mActionsAdapter) {
            this.mActionsAdapter = objectAdapter;
            if (objectAdapter.getPresenterSelector() == null) {
                this.mActionsAdapter.setPresenterSelector(this.mDefaultActionPresenter);
            }
            notifyActionsAdapterChanged();
        }
    }

    public final void setImageBitmap(Context context, Bitmap bitmap) {
        this.mImageDrawable = new BitmapDrawable(context.getResources(), bitmap);
        notifyImageDrawableChanged();
    }

    public final void setImageDrawable(Drawable drawable) {
        if (this.mImageDrawable != drawable) {
            this.mImageDrawable = drawable;
            notifyImageDrawableChanged();
        }
    }

    public void setImageScaleUpAllowed(boolean z10) {
        if (z10 != this.mImageScaleUpAllowed) {
            this.mImageScaleUpAllowed = z10;
            notifyImageDrawableChanged();
        }
    }

    public final void setItem(Object obj) {
        if (obj != this.mItem) {
            this.mItem = obj;
            notifyItemChanged();
        }
    }

    public Action getActionForKeyCode(int i10) {
        ObjectAdapter actionsAdapter = getActionsAdapter();
        if (actionsAdapter != null) {
            for (int i11 = 0; i11 < actionsAdapter.size(); i11++) {
                Action action = (Action) actionsAdapter.get(i11);
                if (action.respondsToKeyCode(i10)) {
                    return action;
                }
            }
            return null;
        }
        return null;
    }

    @Deprecated
    public final List<Action> getActions() {
        return getArrayObjectAdapter().unmodifiableList();
    }

    @Deprecated
    public final boolean removeAction(Action action) {
        return getArrayObjectAdapter().remove(action);
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class Listener {
        public void onActionsAdapterChanged(DetailsOverviewRow detailsOverviewRow) {
        }

        public void onImageDrawableChanged(DetailsOverviewRow detailsOverviewRow) {
        }

        public void onItemChanged(DetailsOverviewRow detailsOverviewRow) {
        }
    }
}
