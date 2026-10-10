package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class l extends u1.c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final l f2340c = new l();

    private l() {
        super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
    }

    public static View c(Context context, int i10, int i11) throws u1.c.a {
        l lVar = f2340c;
        try {
            return (View) u1.b.g(((h) lVar.b(context)).X(u1.b.W(context), new zax(1, i10, i11, null)));
        } catch (Exception e10) {
            throw new u1.c.a("Could not get button with size " + i10 + " and color " + i11, e10);
        }
    }

    @Override // u1.c
    public final /* synthetic */ Object a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
        return iInterfaceQueryLocalInterface instanceof h ? (h) iInterfaceQueryLocalInterface : new h(iBinder);
    }
}
