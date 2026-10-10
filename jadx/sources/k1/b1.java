package k1;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class b1 extends Fragment implements h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final WeakHashMap f11983b = new WeakHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d1 f11984a = new d1();

    public static b1 a(Activity activity) {
        b1 b1Var;
        WeakHashMap weakHashMap = f11983b;
        WeakReference weakReference = (WeakReference) weakHashMap.get(activity);
        if (weakReference != null && (b1Var = (b1) weakReference.get()) != null) {
            return b1Var;
        }
        try {
            b1 b1Var2 = (b1) activity.getFragmentManager().findFragmentByTag("LifecycleFragmentImpl");
            if (b1Var2 == null || b1Var2.isRemoving()) {
                b1Var2 = new b1();
                activity.getFragmentManager().beginTransaction().add(b1Var2, "LifecycleFragmentImpl").commitAllowingStateLoss();
            }
            weakHashMap.put(activity, new WeakReference(b1Var2));
            return b1Var2;
        } catch (ClassCastException e10) {
            throw new IllegalStateException("Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl", e10);
        }
    }

    @Override // k1.h
    public final void B(String str, @NonNull g gVar) {
        this.f11984a.d(str, gVar);
    }

    @Override // k1.h
    @Nullable
    public final <T extends g> T w(String str, Class<T> cls) {
        return (T) this.f11984a.c(str, cls);
    }

    @Override // android.app.Fragment
    public final void dump(String str, @Nullable FileDescriptor fileDescriptor, PrintWriter printWriter, @Nullable String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        this.f11984a.e(str, fileDescriptor, printWriter, strArr);
    }

    @Override // android.app.Fragment
    public final void onActivityResult(int i10, int i11, @Nullable Intent intent) {
        super.onActivityResult(i10, i11, intent);
        this.f11984a.f(i10, i11, intent);
    }

    @Override // android.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.f11984a.g(bundle);
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f11984a.h();
    }

    @Override // android.app.Fragment
    public final void onResume() {
        super.onResume();
        this.f11984a.i();
    }

    @Override // android.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f11984a.j(bundle);
    }

    @Override // android.app.Fragment
    public final void onStart() {
        super.onStart();
        this.f11984a.k();
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
        this.f11984a.l();
    }

    @Override // k1.h
    @Nullable
    public final Activity x() {
        return getActivity();
    }
}
