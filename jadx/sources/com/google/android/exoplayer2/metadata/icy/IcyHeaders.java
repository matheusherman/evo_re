package com.google.android.exoplayer2.metadata.icy;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import d1.k;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class IcyHeaders implements Metadata.Entry {
    public static final Parcelable.Creator<IcyHeaders> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1516a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final String f1517b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final String f1518c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final String f1519d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f1520e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f1521f;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements Parcelable.Creator<IcyHeaders> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public IcyHeaders createFromParcel(Parcel parcel) {
            return new IcyHeaders(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public IcyHeaders[] newArray(int i10) {
            return new IcyHeaders[i10];
        }

        a() {
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && IcyHeaders.class == obj.getClass()) {
            IcyHeaders icyHeaders = (IcyHeaders) obj;
            if (this.f1516a == icyHeaders.f1516a && k.a(this.f1517b, icyHeaders.f1517b) && k.a(this.f1518c, icyHeaders.f1518c) && k.a(this.f1519d, icyHeaders.f1519d) && this.f1520e == icyHeaders.f1520e && this.f1521f == icyHeaders.f1521f) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i10 = (527 + this.f1516a) * 31;
        String str = this.f1517b;
        int iHashCode = (i10 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f1518c;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f1519d;
        return ((((iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + (this.f1520e ? 1 : 0)) * 31) + this.f1521f;
    }

    public String toString() {
        String str = this.f1518c;
        String str2 = this.f1517b;
        int i10 = this.f1516a;
        int i11 = this.f1521f;
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 80 + String.valueOf(str2).length());
        sb2.append("IcyHeaders: name=\"");
        sb2.append(str);
        sb2.append("\", genre=\"");
        sb2.append(str2);
        sb2.append("\", bitrate=");
        sb2.append(i10);
        sb2.append(", metadataInterval=");
        sb2.append(i11);
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f1516a);
        parcel.writeString(this.f1517b);
        parcel.writeString(this.f1518c);
        parcel.writeString(this.f1519d);
        k.m(parcel, this.f1520e);
        parcel.writeInt(this.f1521f);
    }

    IcyHeaders(Parcel parcel) {
        this.f1516a = parcel.readInt();
        this.f1517b = parcel.readString();
        this.f1518c = parcel.readString();
        this.f1519d = parcel.readString();
        this.f1520e = k.j(parcel);
        this.f1521f = parcel.readInt();
    }
}
