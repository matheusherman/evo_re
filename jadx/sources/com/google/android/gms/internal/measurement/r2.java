package com.google.android.gms.internal.measurement;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class r2 extends x0 implements p2 {
    r2(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public final void beginAdUnitExposure(String str, long j10) {
        Parcel parcelA = a();
        parcelA.writeString(str);
        parcelA.writeLong(j10);
        g(23, parcelA);
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        Parcel parcelA = a();
        parcelA.writeString(str);
        parcelA.writeString(str2);
        z0.d(parcelA, bundle);
        g(9, parcelA);
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public final void endAdUnitExposure(String str, long j10) {
        Parcel parcelA = a();
        parcelA.writeString(str);
        parcelA.writeLong(j10);
        g(24, parcelA);
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public final void generateEventId(u2 u2Var) {
        Parcel parcelA = a();
        z0.c(parcelA, u2Var);
        g(22, parcelA);
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public final void getCachedAppInstanceId(u2 u2Var) {
        Parcel parcelA = a();
        z0.c(parcelA, u2Var);
        g(19, parcelA);
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public final void getConditionalUserProperties(String str, String str2, u2 u2Var) {
        Parcel parcelA = a();
        parcelA.writeString(str);
        parcelA.writeString(str2);
        z0.c(parcelA, u2Var);
        g(10, parcelA);
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public final void getCurrentScreenClass(u2 u2Var) {
        Parcel parcelA = a();
        z0.c(parcelA, u2Var);
        g(17, parcelA);
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public final void getCurrentScreenName(u2 u2Var) {
        Parcel parcelA = a();
        z0.c(parcelA, u2Var);
        g(16, parcelA);
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public final void getGmpAppId(u2 u2Var) {
        Parcel parcelA = a();
        z0.c(parcelA, u2Var);
        g(21, parcelA);
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public final void getMaxUserProperties(String str, u2 u2Var) {
        Parcel parcelA = a();
        parcelA.writeString(str);
        z0.c(parcelA, u2Var);
        g(6, parcelA);
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public final void getUserProperties(String str, String str2, boolean z10, u2 u2Var) {
        Parcel parcelA = a();
        parcelA.writeString(str);
        parcelA.writeString(str2);
        z0.e(parcelA, z10);
        z0.c(parcelA, u2Var);
        g(5, parcelA);
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public final void initialize(u1.a aVar, zzdz zzdzVar, long j10) {
        Parcel parcelA = a();
        z0.c(parcelA, aVar);
        z0.d(parcelA, zzdzVar);
        parcelA.writeLong(j10);
        g(1, parcelA);
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public final void logEvent(String str, String str2, Bundle bundle, boolean z10, boolean z11, long j10) {
        Parcel parcelA = a();
        parcelA.writeString(str);
        parcelA.writeString(str2);
        z0.d(parcelA, bundle);
        z0.e(parcelA, z10);
        z0.e(parcelA, z11);
        parcelA.writeLong(j10);
        g(2, parcelA);
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public final void logHealthData(int i10, String str, u1.a aVar, u1.a aVar2, u1.a aVar3) {
        Parcel parcelA = a();
        parcelA.writeInt(i10);
        parcelA.writeString(str);
        z0.c(parcelA, aVar);
        z0.c(parcelA, aVar2);
        z0.c(parcelA, aVar3);
        g(33, parcelA);
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public final void onActivityCreatedByScionActivityInfo(zzeb zzebVar, Bundle bundle, long j10) {
        Parcel parcelA = a();
        z0.d(parcelA, zzebVar);
        z0.d(parcelA, bundle);
        parcelA.writeLong(j10);
        g(53, parcelA);
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public final void onActivityDestroyedByScionActivityInfo(zzeb zzebVar, long j10) {
        Parcel parcelA = a();
        z0.d(parcelA, zzebVar);
        parcelA.writeLong(j10);
        g(54, parcelA);
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public final void onActivityPausedByScionActivityInfo(zzeb zzebVar, long j10) {
        Parcel parcelA = a();
        z0.d(parcelA, zzebVar);
        parcelA.writeLong(j10);
        g(55, parcelA);
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public final void onActivityResumedByScionActivityInfo(zzeb zzebVar, long j10) {
        Parcel parcelA = a();
        z0.d(parcelA, zzebVar);
        parcelA.writeLong(j10);
        g(56, parcelA);
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public final void onActivitySaveInstanceStateByScionActivityInfo(zzeb zzebVar, u2 u2Var, long j10) {
        Parcel parcelA = a();
        z0.d(parcelA, zzebVar);
        z0.c(parcelA, u2Var);
        parcelA.writeLong(j10);
        g(57, parcelA);
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public final void onActivityStartedByScionActivityInfo(zzeb zzebVar, long j10) {
        Parcel parcelA = a();
        z0.d(parcelA, zzebVar);
        parcelA.writeLong(j10);
        g(51, parcelA);
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public final void onActivityStoppedByScionActivityInfo(zzeb zzebVar, long j10) {
        Parcel parcelA = a();
        z0.d(parcelA, zzebVar);
        parcelA.writeLong(j10);
        g(52, parcelA);
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public final void retrieveAndUploadBatches(v2 v2Var) {
        Parcel parcelA = a();
        z0.c(parcelA, v2Var);
        g(58, parcelA);
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public final void setConditionalUserProperty(Bundle bundle, long j10) {
        Parcel parcelA = a();
        z0.d(parcelA, bundle);
        parcelA.writeLong(j10);
        g(8, parcelA);
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public final void setCurrentScreenByScionActivityInfo(zzeb zzebVar, String str, String str2, long j10) {
        Parcel parcelA = a();
        z0.d(parcelA, zzebVar);
        parcelA.writeString(str);
        parcelA.writeString(str2);
        parcelA.writeLong(j10);
        g(50, parcelA);
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public final void setDataCollectionEnabled(boolean z10) {
        Parcel parcelA = a();
        z0.e(parcelA, z10);
        g(39, parcelA);
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public final void setSgtmDebugInfo(Intent intent) {
        Parcel parcelA = a();
        z0.d(parcelA, intent);
        g(48, parcelA);
    }
}
