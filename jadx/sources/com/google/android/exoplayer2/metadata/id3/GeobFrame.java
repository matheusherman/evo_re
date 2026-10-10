package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import d1.k;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class GeobFrame extends Id3Frame {
    public static final Parcelable.Creator<GeobFrame> CREATOR = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1544b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f1545c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f1546d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final byte[] f1547e;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements Parcelable.Creator<GeobFrame> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public GeobFrame createFromParcel(Parcel parcel) {
            return new GeobFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public GeobFrame[] newArray(int i10) {
            return new GeobFrame[i10];
        }

        a() {
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && GeobFrame.class == obj.getClass()) {
            GeobFrame geobFrame = (GeobFrame) obj;
            if (k.a(this.f1544b, geobFrame.f1544b) && k.a(this.f1545c, geobFrame.f1545c) && k.a(this.f1546d, geobFrame.f1546d) && Arrays.equals(this.f1547e, geobFrame.f1547e)) {
                return true;
            }
        }
        return false;
    }

    GeobFrame(Parcel parcel) {
        super("GEOB");
        this.f1544b = (String) k.b(parcel.readString());
        this.f1545c = (String) k.b(parcel.readString());
        this.f1546d = (String) k.b(parcel.readString());
        this.f1547e = (byte[]) k.b(parcel.createByteArray());
    }

    public int hashCode() {
        String str = this.f1544b;
        int iHashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f1545c;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f1546d;
        return ((iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + Arrays.hashCode(this.f1547e);
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame
    public String toString() {
        String str = this.f1548a;
        String str2 = this.f1544b;
        String str3 = this.f1545c;
        String str4 = this.f1546d;
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 36 + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length());
        sb2.append(str);
        sb2.append(": mimeType=");
        sb2.append(str2);
        sb2.append(", filename=");
        sb2.append(str3);
        sb2.append(", description=");
        sb2.append(str4);
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f1544b);
        parcel.writeString(this.f1545c);
        parcel.writeString(this.f1546d);
        parcel.writeByteArray(this.f1547e);
    }
}
