package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c2.f;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.internal.zat;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class a extends com.google.android.gms.common.internal.c<c> implements f {
    public static final /* synthetic */ int M = 0;
    private final boolean I;
    private final m1.c J;
    private final Bundle K;

    @Nullable
    private final Integer L;

    public a(@NonNull Context context, @NonNull Looper looper, boolean z10, @NonNull m1.c cVar, @NonNull Bundle bundle, @NonNull g.a aVar, @NonNull g.b bVar) {
        super(context, looper, 44, cVar, aVar, bVar);
        this.I = true;
        this.J = cVar;
        this.K = bundle;
        this.L = cVar.g();
    }

    @Override // com.google.android.gms.common.internal.b
    @NonNull
    protected final String C() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    @Override // com.google.android.gms.common.internal.b
    @NonNull
    protected final String D() {
        return "com.google.android.gms.signin.service.START";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // c2.f
    public final void h(d2.c cVar) {
        m1.g.l(cVar, "Expecting a valid ISignInCallbacks");
        try {
            Account accountB = this.J.b();
            ((c) B()).X(new zai(1, new zat(accountB, ((Integer) m1.g.k(this.L)).intValue(), "<<default account>>".equals(accountB.name) ? i1.b.a(w()).b() : null)), cVar);
        } catch (RemoteException e10) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                cVar.v(new zak(1, new ConnectionResult(8, null), null));
            } catch (RemoteException unused) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e10);
            }
        }
    }

    @Override // com.google.android.gms.common.internal.b, com.google.android.gms.common.api.a.f
    public final boolean m() {
        return this.I;
    }

    @Override // c2.f
    public final void n() {
        f(new com.google.android.gms.common.internal.b.d());
    }

    @Override // com.google.android.gms.common.internal.b
    @NonNull
    protected final /* synthetic */ IInterface q(@NonNull IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        return iInterfaceQueryLocalInterface instanceof c ? (c) iInterfaceQueryLocalInterface : new c(iBinder);
    }

    @Override // com.google.android.gms.common.internal.b
    @NonNull
    protected final Bundle y() {
        if (!w().getPackageName().equals(this.J.d())) {
            this.K.putString("com.google.android.gms.signin.internal.realClientPackageName", this.J.d());
        }
        return this.K;
    }

    @NonNull
    public static Bundle j0(@NonNull m1.c cVar) {
        cVar.f();
        Integer numG = cVar.g();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", cVar.a());
        if (numG != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", numG.intValue());
        }
        bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", false);
        bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", false);
        bundle.putString("com.google.android.gms.signin.internal.serverClientId", null);
        bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
        bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", false);
        bundle.putString("com.google.android.gms.signin.internal.hostedDomain", null);
        bundle.putString("com.google.android.gms.signin.internal.logSessionId", null);
        bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", false);
        return bundle;
    }

    @Override // com.google.android.gms.common.internal.b
    public final int j() {
        return 12451000;
    }
}
