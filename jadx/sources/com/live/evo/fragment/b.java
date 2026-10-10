package com.live.evo.fragment;

import android.content.DialogInterface;
import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class b extends DialogFragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f5863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<z1> f5864b = new ArrayList();

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NonNull DialogInterface dialogInterface) {
        U(false);
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        U(true);
        super.onStart();
    }

    public void R(z1 z1Var) {
        this.f5864b.add(z1Var);
    }

    public boolean S() {
        return this.f5863a;
    }

    public void T(z1 z1Var) {
        this.f5864b.remove(z1Var);
    }

    protected void U(boolean z10) {
        this.f5863a = z10;
        Iterator<z1> it = this.f5864b.iterator();
        while (it.hasNext()) {
            it.next().O(z10);
        }
    }
}
