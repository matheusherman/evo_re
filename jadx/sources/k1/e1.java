package k1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class e1 extends Fragment implements h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final WeakHashMap f12024b = new WeakHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d1 f12025a = new d1();

    public static e1 R(FragmentActivity fragmentActivity) {
        e1 e1Var;
        WeakHashMap weakHashMap = f12024b;
        WeakReference weakReference = (WeakReference) weakHashMap.get(fragmentActivity);
        if (weakReference != null && (e1Var = (e1) weakReference.get()) != null) {
            return e1Var;
        }
        try {
            e1 e1Var2 = (e1) fragmentActivity.getSupportFragmentManager().findFragmentByTag("SLifecycleFragmentImpl");
            if (e1Var2 == null || e1Var2.isRemoving()) {
                e1Var2 = new e1();
                fragmentActivity.getSupportFragmentManager().beginTransaction().add(e1Var2, "SLifecycleFragmentImpl").commitAllowingStateLoss();
            }
            weakHashMap.put(fragmentActivity, new WeakReference(e1Var2));
            return e1Var2;
        } catch (ClassCastException e10) {
            throw new IllegalStateException("Fragment with tag SLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", e10);
        }
    }

    @Override // k1.h
    public final void B(String str, @NonNull g gVar) {
        this.f12025a.d(str, gVar);
    }

    @Override // k1.h
    @Nullable
    public final <T extends g> T w(String str, Class<T> cls) {
        return (T) this.f12025a.c(str, cls);
    }

    @Override // androidx.fragment.app.Fragment
    public final void dump(String str, @Nullable FileDescriptor fileDescriptor, PrintWriter printWriter, @Nullable String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        this.f12025a.e(str, fileDescriptor, printWriter, strArr);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int i10, int i11, @Nullable Intent intent) {
        super.onActivityResult(i10, i11, intent);
        this.f12025a.f(i10, i11, intent);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.f12025a.g(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f12025a.h();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        this.f12025a.i();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f12025a.j(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        this.f12025a.k();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        this.f12025a.l();
    }

    @Override // k1.h
    @Nullable
    public final Activity x() {
        return getActivity();
    }
}
