package androidx.databinding;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.p000lifecycle.LifecycleOwner;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
class WeakListener<T> extends WeakReference<ViewDataBinding> {
    protected final int mLocalFieldId;
    private final ObservableReference<T> mObservable;
    private T mTarget;

    public T getTarget() {
        return this.mTarget;
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        this.mObservable.setLifecycleOwner(lifecycleOwner);
    }

    public boolean unregister() {
        boolean z10;
        T t10 = this.mTarget;
        if (t10 != null) {
            this.mObservable.removeListener(t10);
            z10 = true;
        } else {
            z10 = false;
        }
        this.mTarget = null;
        return z10;
    }

    public WeakListener(ViewDataBinding viewDataBinding, int i10, ObservableReference<T> observableReference, ReferenceQueue<ViewDataBinding> referenceQueue) {
        super(viewDataBinding, referenceQueue);
        this.mLocalFieldId = i10;
        this.mObservable = observableReference;
    }

    @Nullable
    protected ViewDataBinding getBinder() {
        ViewDataBinding viewDataBinding = (ViewDataBinding) get();
        if (viewDataBinding == null) {
            unregister();
        }
        return viewDataBinding;
    }

    public void setTarget(T t10) {
        unregister();
        this.mTarget = t10;
        if (t10 != null) {
            this.mObservable.addListener(t10);
        }
    }
}
