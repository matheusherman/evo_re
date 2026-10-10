package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import d1.k;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class ApicFrame extends Id3Frame {
    public static final Parcelable.Creator<ApicFrame> CREATOR = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1525b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final String f1526c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f1527d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final byte[] f1528e;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements Parcelable.Creator<ApicFrame> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ApicFrame createFromParcel(Parcel parcel) {
            return new ApicFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ApicFrame[] newArray(int i10) {
            return new ApicFrame[i10];
        }

        a() {
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ApicFrame.class == obj.getClass()) {
            ApicFrame apicFrame = (ApicFrame) obj;
            if (this.f1527d == apicFrame.f1527d && k.a(this.f1525b, apicFrame.f1525b) && k.a(this.f1526c, apicFrame.f1526c) && Arrays.equals(this.f1528e, apicFrame.f1528e)) {
                return true;
            }
        }
        return false;
    }

    ApicFrame(Parcel parcel) {
        super("APIC");
        this.f1525b = (String) k.b(parcel.readString());
        this.f1526c = parcel.readString();
        this.f1527d = parcel.readInt();
        this.f1528e = (byte[]) k.b(parcel.createByteArray());
    }

    public int hashCode() {
        int i10 = (527 + this.f1527d) * 31;
        String str = this.f1525b;
        int iHashCode = (i10 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f1526c;
        return ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + Arrays.hashCode(this.f1528e);
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame
    public String toString() {
        String str = this.f1548a;
        String str2 = this.f1525b;
        String str3 = this.f1526c;
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 25 + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb2.append(str);
        sb2.append(": mimeType=");
        sb2.append(str2);
        sb2.append(", description=");
        sb2.append(str3);
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f1525b);
        parcel.writeString(this.f1526c);
        parcel.writeInt(this.f1527d);
        parcel.writeByteArray(this.f1528e);
    }
}
