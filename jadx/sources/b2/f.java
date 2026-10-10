package b2;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.measurement.internal.zzag;
import com.google.android.gms.measurement.internal.zzai;
import com.google.android.gms.measurement.internal.zzan;
import com.google.android.gms.measurement.internal.zzbj;
import com.google.android.gms.measurement.internal.zzow;
import com.google.android.gms.measurement.internal.zzpb;
import com.google.android.gms.measurement.internal.zzpy;
import com.google.android.gms.measurement.internal.zzq;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public abstract class f extends com.google.android.gms.internal.measurement.a1 implements g {
    @Override // com.google.android.gms.internal.measurement.a1
    protected final boolean a(int i10, Parcel parcel, Parcel parcel2, int i11) {
        l mVar = null;
        h iVar = null;
        switch (i10) {
            case 1:
                zzbj zzbjVar = (zzbj) com.google.android.gms.internal.measurement.z0.a(parcel, zzbj.CREATOR);
                zzq zzqVar = (zzq) com.google.android.gms.internal.measurement.z0.a(parcel, zzq.CREATOR);
                com.google.android.gms.internal.measurement.z0.f(parcel);
                N(zzbjVar, zzqVar);
                parcel2.writeNoException();
                return true;
            case 2:
                zzpy zzpyVar = (zzpy) com.google.android.gms.internal.measurement.z0.a(parcel, zzpy.CREATOR);
                zzq zzqVar2 = (zzq) com.google.android.gms.internal.measurement.z0.a(parcel, zzq.CREATOR);
                com.google.android.gms.internal.measurement.z0.f(parcel);
                q(zzpyVar, zzqVar2);
                parcel2.writeNoException();
                return true;
            case 3:
            case 8:
            case 22:
            case 23:
            case 28:
            default:
                return false;
            case 4:
                zzq zzqVar3 = (zzq) com.google.android.gms.internal.measurement.z0.a(parcel, zzq.CREATOR);
                com.google.android.gms.internal.measurement.z0.f(parcel);
                u(zzqVar3);
                parcel2.writeNoException();
                return true;
            case 5:
                zzbj zzbjVar2 = (zzbj) com.google.android.gms.internal.measurement.z0.a(parcel, zzbj.CREATOR);
                String string = parcel.readString();
                String string2 = parcel.readString();
                com.google.android.gms.internal.measurement.z0.f(parcel);
                T(zzbjVar2, string, string2);
                parcel2.writeNoException();
                return true;
            case 6:
                zzq zzqVar4 = (zzq) com.google.android.gms.internal.measurement.z0.a(parcel, zzq.CREATOR);
                com.google.android.gms.internal.measurement.z0.f(parcel);
                P(zzqVar4);
                parcel2.writeNoException();
                return true;
            case 7:
                zzq zzqVar5 = (zzq) com.google.android.gms.internal.measurement.z0.a(parcel, zzq.CREATOR);
                boolean zH = com.google.android.gms.internal.measurement.z0.h(parcel);
                com.google.android.gms.internal.measurement.z0.f(parcel);
                List<zzpy> listM = M(zzqVar5, zH);
                parcel2.writeNoException();
                parcel2.writeTypedList(listM);
                return true;
            case 9:
                zzbj zzbjVar3 = (zzbj) com.google.android.gms.internal.measurement.z0.a(parcel, zzbj.CREATOR);
                String string3 = parcel.readString();
                com.google.android.gms.internal.measurement.z0.f(parcel);
                byte[] bArrW = w(zzbjVar3, string3);
                parcel2.writeNoException();
                parcel2.writeByteArray(bArrW);
                return true;
            case 10:
                long j10 = parcel.readLong();
                String string4 = parcel.readString();
                String string5 = parcel.readString();
                String string6 = parcel.readString();
                com.google.android.gms.internal.measurement.z0.f(parcel);
                B(j10, string4, string5, string6);
                parcel2.writeNoException();
                return true;
            case 11:
                zzq zzqVar6 = (zzq) com.google.android.gms.internal.measurement.z0.a(parcel, zzq.CREATOR);
                com.google.android.gms.internal.measurement.z0.f(parcel);
                String strI = i(zzqVar6);
                parcel2.writeNoException();
                parcel2.writeString(strI);
                break;
            case 12:
                zzai zzaiVar = (zzai) com.google.android.gms.internal.measurement.z0.a(parcel, zzai.CREATOR);
                zzq zzqVar7 = (zzq) com.google.android.gms.internal.measurement.z0.a(parcel, zzq.CREATOR);
                com.google.android.gms.internal.measurement.z0.f(parcel);
                n(zzaiVar, zzqVar7);
                parcel2.writeNoException();
                break;
            case 13:
                zzai zzaiVar2 = (zzai) com.google.android.gms.internal.measurement.z0.a(parcel, zzai.CREATOR);
                com.google.android.gms.internal.measurement.z0.f(parcel);
                k(zzaiVar2);
                parcel2.writeNoException();
                break;
            case 14:
                String string7 = parcel.readString();
                String string8 = parcel.readString();
                boolean zH2 = com.google.android.gms.internal.measurement.z0.h(parcel);
                zzq zzqVar8 = (zzq) com.google.android.gms.internal.measurement.z0.a(parcel, zzq.CREATOR);
                com.google.android.gms.internal.measurement.z0.f(parcel);
                List<zzpy> listV = V(string7, string8, zH2, zzqVar8);
                parcel2.writeNoException();
                parcel2.writeTypedList(listV);
                break;
            case 15:
                String string9 = parcel.readString();
                String string10 = parcel.readString();
                String string11 = parcel.readString();
                boolean zH3 = com.google.android.gms.internal.measurement.z0.h(parcel);
                com.google.android.gms.internal.measurement.z0.f(parcel);
                List<zzpy> listR = r(string9, string10, string11, zH3);
                parcel2.writeNoException();
                parcel2.writeTypedList(listR);
                break;
            case 16:
                String string12 = parcel.readString();
                String string13 = parcel.readString();
                zzq zzqVar9 = (zzq) com.google.android.gms.internal.measurement.z0.a(parcel, zzq.CREATOR);
                com.google.android.gms.internal.measurement.z0.f(parcel);
                List<zzai> listQ = Q(string12, string13, zzqVar9);
                parcel2.writeNoException();
                parcel2.writeTypedList(listQ);
                break;
            case 17:
                String string14 = parcel.readString();
                String string15 = parcel.readString();
                String string16 = parcel.readString();
                com.google.android.gms.internal.measurement.z0.f(parcel);
                List<zzai> listE = E(string14, string15, string16);
                parcel2.writeNoException();
                parcel2.writeTypedList(listE);
                break;
            case 18:
                zzq zzqVar10 = (zzq) com.google.android.gms.internal.measurement.z0.a(parcel, zzq.CREATOR);
                com.google.android.gms.internal.measurement.z0.f(parcel);
                R(zzqVar10);
                parcel2.writeNoException();
                break;
            case 19:
                Bundle bundle = (Bundle) com.google.android.gms.internal.measurement.z0.a(parcel, Bundle.CREATOR);
                zzq zzqVar11 = (zzq) com.google.android.gms.internal.measurement.z0.a(parcel, zzq.CREATOR);
                com.google.android.gms.internal.measurement.z0.f(parcel);
                F(bundle, zzqVar11);
                parcel2.writeNoException();
                break;
            case 20:
                zzq zzqVar12 = (zzq) com.google.android.gms.internal.measurement.z0.a(parcel, zzq.CREATOR);
                com.google.android.gms.internal.measurement.z0.f(parcel);
                U(zzqVar12);
                parcel2.writeNoException();
                break;
            case 21:
                zzq zzqVar13 = (zzq) com.google.android.gms.internal.measurement.z0.a(parcel, zzq.CREATOR);
                com.google.android.gms.internal.measurement.z0.f(parcel);
                zzan zzanVarD = D(zzqVar13);
                parcel2.writeNoException();
                com.google.android.gms.internal.measurement.z0.g(parcel2, zzanVarD);
                break;
            case 24:
                zzq zzqVar14 = (zzq) com.google.android.gms.internal.measurement.z0.a(parcel, zzq.CREATOR);
                Bundle bundle2 = (Bundle) com.google.android.gms.internal.measurement.z0.a(parcel, Bundle.CREATOR);
                com.google.android.gms.internal.measurement.z0.f(parcel);
                List<zzow> listL = l(zzqVar14, bundle2);
                parcel2.writeNoException();
                parcel2.writeTypedList(listL);
                break;
            case 25:
                zzq zzqVar15 = (zzq) com.google.android.gms.internal.measurement.z0.a(parcel, zzq.CREATOR);
                com.google.android.gms.internal.measurement.z0.f(parcel);
                y(zzqVar15);
                parcel2.writeNoException();
                break;
            case 26:
                zzq zzqVar16 = (zzq) com.google.android.gms.internal.measurement.z0.a(parcel, zzq.CREATOR);
                com.google.android.gms.internal.measurement.z0.f(parcel);
                K(zzqVar16);
                parcel2.writeNoException();
                break;
            case 27:
                zzq zzqVar17 = (zzq) com.google.android.gms.internal.measurement.z0.a(parcel, zzq.CREATOR);
                com.google.android.gms.internal.measurement.z0.f(parcel);
                t(zzqVar17);
                parcel2.writeNoException();
                break;
            case 29:
                zzq zzqVar18 = (zzq) com.google.android.gms.internal.measurement.z0.a(parcel, zzq.CREATOR);
                zzpb zzpbVar = (zzpb) com.google.android.gms.internal.measurement.z0.a(parcel, zzpb.CREATOR);
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IUploadBatchesCallback");
                    mVar = iInterfaceQueryLocalInterface instanceof l ? (l) iInterfaceQueryLocalInterface : new m(strongBinder);
                }
                com.google.android.gms.internal.measurement.z0.f(parcel);
                p(zzqVar18, zzpbVar, mVar);
                parcel2.writeNoException();
                break;
            case 30:
                zzq zzqVar19 = (zzq) com.google.android.gms.internal.measurement.z0.a(parcel, zzq.CREATOR);
                zzag zzagVar = (zzag) com.google.android.gms.internal.measurement.z0.a(parcel, zzag.CREATOR);
                com.google.android.gms.internal.measurement.z0.f(parcel);
                H(zzqVar19, zzagVar);
                parcel2.writeNoException();
                break;
            case 31:
                zzq zzqVar20 = (zzq) com.google.android.gms.internal.measurement.z0.a(parcel, zzq.CREATOR);
                Bundle bundle3 = (Bundle) com.google.android.gms.internal.measurement.z0.a(parcel, Bundle.CREATOR);
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.measurement.internal.ITriggerUrisCallback");
                    iVar = iInterfaceQueryLocalInterface2 instanceof h ? (h) iInterfaceQueryLocalInterface2 : new i(strongBinder2);
                }
                com.google.android.gms.internal.measurement.z0.f(parcel);
                A(zzqVar20, bundle3, iVar);
                parcel2.writeNoException();
                break;
        }
        return true;
    }

    public f() {
        super("com.google.android.gms.measurement.internal.IMeasurementService");
    }
}
