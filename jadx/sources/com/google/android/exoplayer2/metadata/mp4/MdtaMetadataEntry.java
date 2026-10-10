package com.google.android.exoplayer2.metadata.mp4;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import d1.k;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class MdtaMetadataEntry implements Metadata.Entry {
    public static final Parcelable.Creator<MdtaMetadataEntry> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f1564b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f1565c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f1566d;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements Parcelable.Creator<MdtaMetadataEntry> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MdtaMetadataEntry createFromParcel(Parcel parcel) {
            return new MdtaMetadataEntry(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public MdtaMetadataEntry[] newArray(int i10) {
            return new MdtaMetadataEntry[i10];
        }

        a() {
        }
    }

    /* synthetic */ MdtaMetadataEntry(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && MdtaMetadataEntry.class == obj.getClass()) {
            MdtaMetadataEntry mdtaMetadataEntry = (MdtaMetadataEntry) obj;
            if (this.f1563a.equals(mdtaMetadataEntry.f1563a) && Arrays.equals(this.f1564b, mdtaMetadataEntry.f1564b) && this.f1565c == mdtaMetadataEntry.f1565c && this.f1566d == mdtaMetadataEntry.f1566d) {
                return true;
            }
        }
        return false;
    }

    private MdtaMetadataEntry(Parcel parcel) {
        this.f1563a = (String) k.b(parcel.readString());
        this.f1564b = (byte[]) k.b(parcel.createByteArray());
        this.f1565c = parcel.readInt();
        this.f1566d = parcel.readInt();
    }

    public int hashCode() {
        return ((((((527 + this.f1563a.hashCode()) * 31) + Arrays.hashCode(this.f1564b)) * 31) + this.f1565c) * 31) + this.f1566d;
    }

    public String toString() {
        String strValueOf = String.valueOf(this.f1563a);
        return strValueOf.length() != 0 ? "mdta: key=".concat(strValueOf) : new String("mdta: key=");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f1563a);
        parcel.writeByteArray(this.f1564b);
        parcel.writeInt(this.f1565c);
        parcel.writeInt(this.f1566d);
    }
}
