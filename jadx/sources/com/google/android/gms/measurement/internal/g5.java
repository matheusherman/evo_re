package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class g5 extends com.google.android.gms.internal.measurement.x0 implements b2.g {
    g5(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IMeasurementService");
    }

    @Override // b2.g
    public final void A(zzq zzqVar, Bundle bundle, b2.h hVar) {
        Parcel parcelA = a();
        com.google.android.gms.internal.measurement.z0.d(parcelA, zzqVar);
        com.google.android.gms.internal.measurement.z0.d(parcelA, bundle);
        com.google.android.gms.internal.measurement.z0.c(parcelA, hVar);
        g(31, parcelA);
    }

    @Override // b2.g
    public final void B(long j10, String str, String str2, String str3) {
        Parcel parcelA = a();
        parcelA.writeLong(j10);
        parcelA.writeString(str);
        parcelA.writeString(str2);
        parcelA.writeString(str3);
        g(10, parcelA);
    }

    @Override // b2.g
    public final zzan D(zzq zzqVar) {
        Parcel parcelA = a();
        com.google.android.gms.internal.measurement.z0.d(parcelA, zzqVar);
        Parcel parcelF = f(21, parcelA);
        zzan zzanVar = (zzan) com.google.android.gms.internal.measurement.z0.a(parcelF, zzan.CREATOR);
        parcelF.recycle();
        return zzanVar;
    }

    @Override // b2.g
    public final List<zzai> E(String str, String str2, String str3) {
        Parcel parcelA = a();
        parcelA.writeString(str);
        parcelA.writeString(str2);
        parcelA.writeString(str3);
        Parcel parcelF = f(17, parcelA);
        ArrayList arrayListCreateTypedArrayList = parcelF.createTypedArrayList(zzai.CREATOR);
        parcelF.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // b2.g
    public final void F(Bundle bundle, zzq zzqVar) {
        Parcel parcelA = a();
        com.google.android.gms.internal.measurement.z0.d(parcelA, bundle);
        com.google.android.gms.internal.measurement.z0.d(parcelA, zzqVar);
        g(19, parcelA);
    }

    @Override // b2.g
    public final void H(zzq zzqVar, zzag zzagVar) {
        Parcel parcelA = a();
        com.google.android.gms.internal.measurement.z0.d(parcelA, zzqVar);
        com.google.android.gms.internal.measurement.z0.d(parcelA, zzagVar);
        g(30, parcelA);
    }

    @Override // b2.g
    public final void K(zzq zzqVar) {
        Parcel parcelA = a();
        com.google.android.gms.internal.measurement.z0.d(parcelA, zzqVar);
        g(26, parcelA);
    }

    @Override // b2.g
    public final void N(zzbj zzbjVar, zzq zzqVar) {
        Parcel parcelA = a();
        com.google.android.gms.internal.measurement.z0.d(parcelA, zzbjVar);
        com.google.android.gms.internal.measurement.z0.d(parcelA, zzqVar);
        g(1, parcelA);
    }

    @Override // b2.g
    public final void P(zzq zzqVar) {
        Parcel parcelA = a();
        com.google.android.gms.internal.measurement.z0.d(parcelA, zzqVar);
        g(6, parcelA);
    }

    @Override // b2.g
    public final List<zzai> Q(String str, String str2, zzq zzqVar) {
        Parcel parcelA = a();
        parcelA.writeString(str);
        parcelA.writeString(str2);
        com.google.android.gms.internal.measurement.z0.d(parcelA, zzqVar);
        Parcel parcelF = f(16, parcelA);
        ArrayList arrayListCreateTypedArrayList = parcelF.createTypedArrayList(zzai.CREATOR);
        parcelF.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // b2.g
    public final void R(zzq zzqVar) {
        Parcel parcelA = a();
        com.google.android.gms.internal.measurement.z0.d(parcelA, zzqVar);
        g(18, parcelA);
    }

    @Override // b2.g
    public final void T(zzbj zzbjVar, String str, String str2) {
        Parcel parcelA = a();
        com.google.android.gms.internal.measurement.z0.d(parcelA, zzbjVar);
        parcelA.writeString(str);
        parcelA.writeString(str2);
        g(5, parcelA);
    }

    @Override // b2.g
    public final void U(zzq zzqVar) {
        Parcel parcelA = a();
        com.google.android.gms.internal.measurement.z0.d(parcelA, zzqVar);
        g(20, parcelA);
    }

    @Override // b2.g
    public final List<zzpy> V(String str, String str2, boolean z10, zzq zzqVar) {
        Parcel parcelA = a();
        parcelA.writeString(str);
        parcelA.writeString(str2);
        com.google.android.gms.internal.measurement.z0.e(parcelA, z10);
        com.google.android.gms.internal.measurement.z0.d(parcelA, zzqVar);
        Parcel parcelF = f(14, parcelA);
        ArrayList arrayListCreateTypedArrayList = parcelF.createTypedArrayList(zzpy.CREATOR);
        parcelF.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // b2.g
    public final String i(zzq zzqVar) {
        Parcel parcelA = a();
        com.google.android.gms.internal.measurement.z0.d(parcelA, zzqVar);
        Parcel parcelF = f(11, parcelA);
        String string = parcelF.readString();
        parcelF.recycle();
        return string;
    }

    @Override // b2.g
    public final void k(zzai zzaiVar) {
        Parcel parcelA = a();
        com.google.android.gms.internal.measurement.z0.d(parcelA, zzaiVar);
        g(13, parcelA);
    }

    @Override // b2.g
    public final List<zzow> l(zzq zzqVar, Bundle bundle) {
        Parcel parcelA = a();
        com.google.android.gms.internal.measurement.z0.d(parcelA, zzqVar);
        com.google.android.gms.internal.measurement.z0.d(parcelA, bundle);
        Parcel parcelF = f(24, parcelA);
        ArrayList arrayListCreateTypedArrayList = parcelF.createTypedArrayList(zzow.CREATOR);
        parcelF.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // b2.g
    public final void n(zzai zzaiVar, zzq zzqVar) {
        Parcel parcelA = a();
        com.google.android.gms.internal.measurement.z0.d(parcelA, zzaiVar);
        com.google.android.gms.internal.measurement.z0.d(parcelA, zzqVar);
        g(12, parcelA);
    }

    @Override // b2.g
    public final void p(zzq zzqVar, zzpb zzpbVar, b2.l lVar) {
        Parcel parcelA = a();
        com.google.android.gms.internal.measurement.z0.d(parcelA, zzqVar);
        com.google.android.gms.internal.measurement.z0.d(parcelA, zzpbVar);
        com.google.android.gms.internal.measurement.z0.c(parcelA, lVar);
        g(29, parcelA);
    }

    @Override // b2.g
    public final void q(zzpy zzpyVar, zzq zzqVar) {
        Parcel parcelA = a();
        com.google.android.gms.internal.measurement.z0.d(parcelA, zzpyVar);
        com.google.android.gms.internal.measurement.z0.d(parcelA, zzqVar);
        g(2, parcelA);
    }

    @Override // b2.g
    public final List<zzpy> r(String str, String str2, String str3, boolean z10) {
        Parcel parcelA = a();
        parcelA.writeString(str);
        parcelA.writeString(str2);
        parcelA.writeString(str3);
        com.google.android.gms.internal.measurement.z0.e(parcelA, z10);
        Parcel parcelF = f(15, parcelA);
        ArrayList arrayListCreateTypedArrayList = parcelF.createTypedArrayList(zzpy.CREATOR);
        parcelF.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // b2.g
    public final void t(zzq zzqVar) {
        Parcel parcelA = a();
        com.google.android.gms.internal.measurement.z0.d(parcelA, zzqVar);
        g(27, parcelA);
    }

    @Override // b2.g
    public final void u(zzq zzqVar) {
        Parcel parcelA = a();
        com.google.android.gms.internal.measurement.z0.d(parcelA, zzqVar);
        g(4, parcelA);
    }

    @Override // b2.g
    public final byte[] w(zzbj zzbjVar, String str) {
        Parcel parcelA = a();
        com.google.android.gms.internal.measurement.z0.d(parcelA, zzbjVar);
        parcelA.writeString(str);
        Parcel parcelF = f(9, parcelA);
        byte[] bArrCreateByteArray = parcelF.createByteArray();
        parcelF.recycle();
        return bArrCreateByteArray;
    }

    @Override // b2.g
    public final void y(zzq zzqVar) {
        Parcel parcelA = a();
        com.google.android.gms.internal.measurement.z0.d(parcelA, zzqVar);
        g(25, parcelA);
    }
}
