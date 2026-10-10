package com.google.android.gms.internal.measurement;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public abstract class s2 extends a1 implements p2 {
    public s2() {
        super("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    public static p2 asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
        return iInterfaceQueryLocalInterface instanceof p2 ? (p2) iInterfaceQueryLocalInterface : new r2(iBinder);
    }

    @Override // com.google.android.gms.internal.measurement.a1
    protected final boolean a(int i10, Parcel parcel, Parcel parcel2, int i11) {
        u2 w2Var = null;
        v2 x2Var = null;
        u2 w2Var2 = null;
        u2 w2Var3 = null;
        u2 w2Var4 = null;
        u2 w2Var5 = null;
        z2 b3Var = null;
        z2 b3Var2 = null;
        z2 b3Var3 = null;
        u2 w2Var6 = null;
        u2 w2Var7 = null;
        u2 w2Var8 = null;
        u2 w2Var9 = null;
        u2 w2Var10 = null;
        u2 w2Var11 = null;
        a3 d3Var = null;
        u2 w2Var12 = null;
        u2 w2Var13 = null;
        u2 w2Var14 = null;
        u2 w2Var15 = null;
        u2 w2Var16 = null;
        switch (i10) {
            case 1:
                u1.a aVarF = u1.a.AbstractBinderC0368a.f(parcel.readStrongBinder());
                zzdz zzdzVar = (zzdz) z0.a(parcel, zzdz.CREATOR);
                long j10 = parcel.readLong();
                z0.f(parcel);
                initialize(aVarF, zzdzVar, j10);
                break;
            case 2:
                String string = parcel.readString();
                String string2 = parcel.readString();
                Bundle bundle = (Bundle) z0.a(parcel, Bundle.CREATOR);
                boolean zH = z0.h(parcel);
                boolean zH2 = z0.h(parcel);
                long j11 = parcel.readLong();
                z0.f(parcel);
                logEvent(string, string2, bundle, zH, zH2, j11);
                break;
            case 3:
                String string3 = parcel.readString();
                String string4 = parcel.readString();
                Bundle bundle2 = (Bundle) z0.a(parcel, Bundle.CREATOR);
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    w2Var = iInterfaceQueryLocalInterface instanceof u2 ? (u2) iInterfaceQueryLocalInterface : new w2(strongBinder);
                }
                long j12 = parcel.readLong();
                z0.f(parcel);
                logEventAndBundle(string3, string4, bundle2, w2Var, j12);
                break;
            case 4:
                String string5 = parcel.readString();
                String string6 = parcel.readString();
                u1.a aVarF2 = u1.a.AbstractBinderC0368a.f(parcel.readStrongBinder());
                boolean zH3 = z0.h(parcel);
                long j13 = parcel.readLong();
                z0.f(parcel);
                setUserProperty(string5, string6, aVarF2, zH3, j13);
                break;
            case 5:
                String string7 = parcel.readString();
                String string8 = parcel.readString();
                boolean zH4 = z0.h(parcel);
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    w2Var16 = iInterfaceQueryLocalInterface2 instanceof u2 ? (u2) iInterfaceQueryLocalInterface2 : new w2(strongBinder2);
                }
                z0.f(parcel);
                getUserProperties(string7, string8, zH4, w2Var16);
                break;
            case 6:
                String string9 = parcel.readString();
                IBinder strongBinder3 = parcel.readStrongBinder();
                if (strongBinder3 != null) {
                    IInterface iInterfaceQueryLocalInterface3 = strongBinder3.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    w2Var15 = iInterfaceQueryLocalInterface3 instanceof u2 ? (u2) iInterfaceQueryLocalInterface3 : new w2(strongBinder3);
                }
                z0.f(parcel);
                getMaxUserProperties(string9, w2Var15);
                break;
            case 7:
                String string10 = parcel.readString();
                long j14 = parcel.readLong();
                z0.f(parcel);
                setUserId(string10, j14);
                break;
            case 8:
                Bundle bundle3 = (Bundle) z0.a(parcel, Bundle.CREATOR);
                long j15 = parcel.readLong();
                z0.f(parcel);
                setConditionalUserProperty(bundle3, j15);
                break;
            case 9:
                String string11 = parcel.readString();
                String string12 = parcel.readString();
                Bundle bundle4 = (Bundle) z0.a(parcel, Bundle.CREATOR);
                z0.f(parcel);
                clearConditionalUserProperty(string11, string12, bundle4);
                break;
            case 10:
                String string13 = parcel.readString();
                String string14 = parcel.readString();
                IBinder strongBinder4 = parcel.readStrongBinder();
                if (strongBinder4 != null) {
                    IInterface iInterfaceQueryLocalInterface4 = strongBinder4.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    w2Var14 = iInterfaceQueryLocalInterface4 instanceof u2 ? (u2) iInterfaceQueryLocalInterface4 : new w2(strongBinder4);
                }
                z0.f(parcel);
                getConditionalUserProperties(string13, string14, w2Var14);
                break;
            case 11:
                boolean zH5 = z0.h(parcel);
                long j16 = parcel.readLong();
                z0.f(parcel);
                setMeasurementEnabled(zH5, j16);
                break;
            case 12:
                long j17 = parcel.readLong();
                z0.f(parcel);
                resetAnalyticsData(j17);
                break;
            case 13:
                long j18 = parcel.readLong();
                z0.f(parcel);
                setMinimumSessionDuration(j18);
                break;
            case 14:
                long j19 = parcel.readLong();
                z0.f(parcel);
                setSessionTimeoutDuration(j19);
                break;
            case 15:
                u1.a aVarF3 = u1.a.AbstractBinderC0368a.f(parcel.readStrongBinder());
                String string15 = parcel.readString();
                String string16 = parcel.readString();
                long j20 = parcel.readLong();
                z0.f(parcel);
                setCurrentScreen(aVarF3, string15, string16, j20);
                break;
            case 16:
                IBinder strongBinder5 = parcel.readStrongBinder();
                if (strongBinder5 != null) {
                    IInterface iInterfaceQueryLocalInterface5 = strongBinder5.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    w2Var13 = iInterfaceQueryLocalInterface5 instanceof u2 ? (u2) iInterfaceQueryLocalInterface5 : new w2(strongBinder5);
                }
                z0.f(parcel);
                getCurrentScreenName(w2Var13);
                break;
            case 17:
                IBinder strongBinder6 = parcel.readStrongBinder();
                if (strongBinder6 != null) {
                    IInterface iInterfaceQueryLocalInterface6 = strongBinder6.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    w2Var12 = iInterfaceQueryLocalInterface6 instanceof u2 ? (u2) iInterfaceQueryLocalInterface6 : new w2(strongBinder6);
                }
                z0.f(parcel);
                getCurrentScreenClass(w2Var12);
                break;
            case 18:
                IBinder strongBinder7 = parcel.readStrongBinder();
                if (strongBinder7 != null) {
                    IInterface iInterfaceQueryLocalInterface7 = strongBinder7.queryLocalInterface("com.google.android.gms.measurement.api.internal.IStringProvider");
                    d3Var = iInterfaceQueryLocalInterface7 instanceof a3 ? (a3) iInterfaceQueryLocalInterface7 : new d3(strongBinder7);
                }
                z0.f(parcel);
                setInstanceIdProvider(d3Var);
                break;
            case 19:
                IBinder strongBinder8 = parcel.readStrongBinder();
                if (strongBinder8 != null) {
                    IInterface iInterfaceQueryLocalInterface8 = strongBinder8.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    w2Var11 = iInterfaceQueryLocalInterface8 instanceof u2 ? (u2) iInterfaceQueryLocalInterface8 : new w2(strongBinder8);
                }
                z0.f(parcel);
                getCachedAppInstanceId(w2Var11);
                break;
            case 20:
                IBinder strongBinder9 = parcel.readStrongBinder();
                if (strongBinder9 != null) {
                    IInterface iInterfaceQueryLocalInterface9 = strongBinder9.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    w2Var10 = iInterfaceQueryLocalInterface9 instanceof u2 ? (u2) iInterfaceQueryLocalInterface9 : new w2(strongBinder9);
                }
                z0.f(parcel);
                getAppInstanceId(w2Var10);
                break;
            case 21:
                IBinder strongBinder10 = parcel.readStrongBinder();
                if (strongBinder10 != null) {
                    IInterface iInterfaceQueryLocalInterface10 = strongBinder10.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    w2Var9 = iInterfaceQueryLocalInterface10 instanceof u2 ? (u2) iInterfaceQueryLocalInterface10 : new w2(strongBinder10);
                }
                z0.f(parcel);
                getGmpAppId(w2Var9);
                break;
            case 22:
                IBinder strongBinder11 = parcel.readStrongBinder();
                if (strongBinder11 != null) {
                    IInterface iInterfaceQueryLocalInterface11 = strongBinder11.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    w2Var8 = iInterfaceQueryLocalInterface11 instanceof u2 ? (u2) iInterfaceQueryLocalInterface11 : new w2(strongBinder11);
                }
                z0.f(parcel);
                generateEventId(w2Var8);
                break;
            case 23:
                String string17 = parcel.readString();
                long j21 = parcel.readLong();
                z0.f(parcel);
                beginAdUnitExposure(string17, j21);
                break;
            case 24:
                String string18 = parcel.readString();
                long j22 = parcel.readLong();
                z0.f(parcel);
                endAdUnitExposure(string18, j22);
                break;
            case 25:
                u1.a aVarF4 = u1.a.AbstractBinderC0368a.f(parcel.readStrongBinder());
                long j23 = parcel.readLong();
                z0.f(parcel);
                onActivityStarted(aVarF4, j23);
                break;
            case 26:
                u1.a aVarF5 = u1.a.AbstractBinderC0368a.f(parcel.readStrongBinder());
                long j24 = parcel.readLong();
                z0.f(parcel);
                onActivityStopped(aVarF5, j24);
                break;
            case 27:
                u1.a aVarF6 = u1.a.AbstractBinderC0368a.f(parcel.readStrongBinder());
                Bundle bundle5 = (Bundle) z0.a(parcel, Bundle.CREATOR);
                long j25 = parcel.readLong();
                z0.f(parcel);
                onActivityCreated(aVarF6, bundle5, j25);
                break;
            case 28:
                u1.a aVarF7 = u1.a.AbstractBinderC0368a.f(parcel.readStrongBinder());
                long j26 = parcel.readLong();
                z0.f(parcel);
                onActivityDestroyed(aVarF7, j26);
                break;
            case 29:
                u1.a aVarF8 = u1.a.AbstractBinderC0368a.f(parcel.readStrongBinder());
                long j27 = parcel.readLong();
                z0.f(parcel);
                onActivityPaused(aVarF8, j27);
                break;
            case 30:
                u1.a aVarF9 = u1.a.AbstractBinderC0368a.f(parcel.readStrongBinder());
                long j28 = parcel.readLong();
                z0.f(parcel);
                onActivityResumed(aVarF9, j28);
                break;
            case 31:
                u1.a aVarF10 = u1.a.AbstractBinderC0368a.f(parcel.readStrongBinder());
                IBinder strongBinder12 = parcel.readStrongBinder();
                if (strongBinder12 != null) {
                    IInterface iInterfaceQueryLocalInterface12 = strongBinder12.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    w2Var7 = iInterfaceQueryLocalInterface12 instanceof u2 ? (u2) iInterfaceQueryLocalInterface12 : new w2(strongBinder12);
                }
                long j29 = parcel.readLong();
                z0.f(parcel);
                onActivitySaveInstanceState(aVarF10, w2Var7, j29);
                break;
            case 32:
                Bundle bundle6 = (Bundle) z0.a(parcel, Bundle.CREATOR);
                IBinder strongBinder13 = parcel.readStrongBinder();
                if (strongBinder13 != null) {
                    IInterface iInterfaceQueryLocalInterface13 = strongBinder13.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    w2Var6 = iInterfaceQueryLocalInterface13 instanceof u2 ? (u2) iInterfaceQueryLocalInterface13 : new w2(strongBinder13);
                }
                long j30 = parcel.readLong();
                z0.f(parcel);
                performAction(bundle6, w2Var6, j30);
                break;
            case 33:
                int i12 = parcel.readInt();
                String string19 = parcel.readString();
                u1.a aVarF11 = u1.a.AbstractBinderC0368a.f(parcel.readStrongBinder());
                u1.a aVarF12 = u1.a.AbstractBinderC0368a.f(parcel.readStrongBinder());
                u1.a aVarF13 = u1.a.AbstractBinderC0368a.f(parcel.readStrongBinder());
                z0.f(parcel);
                logHealthData(i12, string19, aVarF11, aVarF12, aVarF13);
                break;
            case 34:
                IBinder strongBinder14 = parcel.readStrongBinder();
                if (strongBinder14 != null) {
                    IInterface iInterfaceQueryLocalInterface14 = strongBinder14.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    b3Var3 = iInterfaceQueryLocalInterface14 instanceof z2 ? (z2) iInterfaceQueryLocalInterface14 : new b3(strongBinder14);
                }
                z0.f(parcel);
                setEventInterceptor(b3Var3);
                break;
            case 35:
                IBinder strongBinder15 = parcel.readStrongBinder();
                if (strongBinder15 != null) {
                    IInterface iInterfaceQueryLocalInterface15 = strongBinder15.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    b3Var2 = iInterfaceQueryLocalInterface15 instanceof z2 ? (z2) iInterfaceQueryLocalInterface15 : new b3(strongBinder15);
                }
                z0.f(parcel);
                registerOnMeasurementEventListener(b3Var2);
                break;
            case 36:
                IBinder strongBinder16 = parcel.readStrongBinder();
                if (strongBinder16 != null) {
                    IInterface iInterfaceQueryLocalInterface16 = strongBinder16.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    b3Var = iInterfaceQueryLocalInterface16 instanceof z2 ? (z2) iInterfaceQueryLocalInterface16 : new b3(strongBinder16);
                }
                z0.f(parcel);
                unregisterOnMeasurementEventListener(b3Var);
                break;
            case 37:
                HashMap mapB = z0.b(parcel);
                z0.f(parcel);
                initForTests(mapB);
                break;
            case 38:
                IBinder strongBinder17 = parcel.readStrongBinder();
                if (strongBinder17 != null) {
                    IInterface iInterfaceQueryLocalInterface17 = strongBinder17.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    w2Var5 = iInterfaceQueryLocalInterface17 instanceof u2 ? (u2) iInterfaceQueryLocalInterface17 : new w2(strongBinder17);
                }
                int i13 = parcel.readInt();
                z0.f(parcel);
                getTestFlag(w2Var5, i13);
                break;
            case 39:
                boolean zH6 = z0.h(parcel);
                z0.f(parcel);
                setDataCollectionEnabled(zH6);
                break;
            case 40:
                IBinder strongBinder18 = parcel.readStrongBinder();
                if (strongBinder18 != null) {
                    IInterface iInterfaceQueryLocalInterface18 = strongBinder18.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    w2Var4 = iInterfaceQueryLocalInterface18 instanceof u2 ? (u2) iInterfaceQueryLocalInterface18 : new w2(strongBinder18);
                }
                z0.f(parcel);
                isDataCollectionEnabled(w2Var4);
                break;
            case 41:
            case 47:
            case 49:
            default:
                return false;
            case 42:
                Bundle bundle7 = (Bundle) z0.a(parcel, Bundle.CREATOR);
                z0.f(parcel);
                setDefaultEventParameters(bundle7);
                break;
            case 43:
                long j31 = parcel.readLong();
                z0.f(parcel);
                clearMeasurementEnabled(j31);
                break;
            case 44:
                Bundle bundle8 = (Bundle) z0.a(parcel, Bundle.CREATOR);
                long j32 = parcel.readLong();
                z0.f(parcel);
                setConsent(bundle8, j32);
                break;
            case 45:
                Bundle bundle9 = (Bundle) z0.a(parcel, Bundle.CREATOR);
                long j33 = parcel.readLong();
                z0.f(parcel);
                setConsentThirdParty(bundle9, j33);
                break;
            case 46:
                IBinder strongBinder19 = parcel.readStrongBinder();
                if (strongBinder19 != null) {
                    IInterface iInterfaceQueryLocalInterface19 = strongBinder19.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    w2Var3 = iInterfaceQueryLocalInterface19 instanceof u2 ? (u2) iInterfaceQueryLocalInterface19 : new w2(strongBinder19);
                }
                z0.f(parcel);
                getSessionId(w2Var3);
                break;
            case 48:
                Intent intent = (Intent) z0.a(parcel, Intent.CREATOR);
                z0.f(parcel);
                setSgtmDebugInfo(intent);
                break;
            case 50:
                zzeb zzebVar = (zzeb) z0.a(parcel, zzeb.CREATOR);
                String string20 = parcel.readString();
                String string21 = parcel.readString();
                long j34 = parcel.readLong();
                z0.f(parcel);
                setCurrentScreenByScionActivityInfo(zzebVar, string20, string21, j34);
                break;
            case 51:
                zzeb zzebVar2 = (zzeb) z0.a(parcel, zzeb.CREATOR);
                long j35 = parcel.readLong();
                z0.f(parcel);
                onActivityStartedByScionActivityInfo(zzebVar2, j35);
                break;
            case 52:
                zzeb zzebVar3 = (zzeb) z0.a(parcel, zzeb.CREATOR);
                long j36 = parcel.readLong();
                z0.f(parcel);
                onActivityStoppedByScionActivityInfo(zzebVar3, j36);
                break;
            case 53:
                zzeb zzebVar4 = (zzeb) z0.a(parcel, zzeb.CREATOR);
                Bundle bundle10 = (Bundle) z0.a(parcel, Bundle.CREATOR);
                long j37 = parcel.readLong();
                z0.f(parcel);
                onActivityCreatedByScionActivityInfo(zzebVar4, bundle10, j37);
                break;
            case 54:
                zzeb zzebVar5 = (zzeb) z0.a(parcel, zzeb.CREATOR);
                long j38 = parcel.readLong();
                z0.f(parcel);
                onActivityDestroyedByScionActivityInfo(zzebVar5, j38);
                break;
            case 55:
                zzeb zzebVar6 = (zzeb) z0.a(parcel, zzeb.CREATOR);
                long j39 = parcel.readLong();
                z0.f(parcel);
                onActivityPausedByScionActivityInfo(zzebVar6, j39);
                break;
            case 56:
                zzeb zzebVar7 = (zzeb) z0.a(parcel, zzeb.CREATOR);
                long j40 = parcel.readLong();
                z0.f(parcel);
                onActivityResumedByScionActivityInfo(zzebVar7, j40);
                break;
            case 57:
                zzeb zzebVar8 = (zzeb) z0.a(parcel, zzeb.CREATOR);
                IBinder strongBinder20 = parcel.readStrongBinder();
                if (strongBinder20 != null) {
                    IInterface iInterfaceQueryLocalInterface20 = strongBinder20.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    w2Var2 = iInterfaceQueryLocalInterface20 instanceof u2 ? (u2) iInterfaceQueryLocalInterface20 : new w2(strongBinder20);
                }
                long j41 = parcel.readLong();
                z0.f(parcel);
                onActivitySaveInstanceStateByScionActivityInfo(zzebVar8, w2Var2, j41);
                break;
            case 58:
                IBinder strongBinder21 = parcel.readStrongBinder();
                if (strongBinder21 != null) {
                    IInterface iInterfaceQueryLocalInterface21 = strongBinder21.queryLocalInterface("com.google.android.gms.measurement.api.internal.IDynamiteUploadBatchesCallback");
                    x2Var = iInterfaceQueryLocalInterface21 instanceof v2 ? (v2) iInterfaceQueryLocalInterface21 : new x2(strongBinder21);
                }
                z0.f(parcel);
                retrieveAndUploadBatches(x2Var);
                break;
        }
        parcel2.writeNoException();
        return true;
    }
}
