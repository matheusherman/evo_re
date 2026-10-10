package com.google.android.exoplayer2.source.hls;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class HlsTrackMetadataEntry implements Metadata.Entry {
    public static final Parcelable.Creator<HlsTrackMetadataEntry> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final String f1652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final String f1653b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<VariantInfo> f1654c;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class VariantInfo implements Parcelable {
        public static final Parcelable.Creator<VariantInfo> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f1655a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f1656b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public final String f1657c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public final String f1658d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Nullable
        public final String f1659e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Nullable
        public final String f1660f;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        class a implements Parcelable.Creator<VariantInfo> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public VariantInfo createFromParcel(Parcel parcel) {
                return new VariantInfo(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public VariantInfo[] newArray(int i10) {
                return new VariantInfo[i10];
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
            if (obj != null && VariantInfo.class == obj.getClass()) {
                VariantInfo variantInfo = (VariantInfo) obj;
                if (this.f1655a == variantInfo.f1655a && this.f1656b == variantInfo.f1656b && TextUtils.equals(this.f1657c, variantInfo.f1657c) && TextUtils.equals(this.f1658d, variantInfo.f1658d) && TextUtils.equals(this.f1659e, variantInfo.f1659e) && TextUtils.equals(this.f1660f, variantInfo.f1660f)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            int i10 = ((this.f1655a * 31) + this.f1656b) * 31;
            String str = this.f1657c;
            int iHashCode = (i10 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.f1658d;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.f1659e;
            int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.f1660f;
            return iHashCode3 + (str4 != null ? str4.hashCode() : 0);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.f1655a);
            parcel.writeInt(this.f1656b);
            parcel.writeString(this.f1657c);
            parcel.writeString(this.f1658d);
            parcel.writeString(this.f1659e);
            parcel.writeString(this.f1660f);
        }

        VariantInfo(Parcel parcel) {
            this.f1655a = parcel.readInt();
            this.f1656b = parcel.readInt();
            this.f1657c = parcel.readString();
            this.f1658d = parcel.readString();
            this.f1659e = parcel.readString();
            this.f1660f = parcel.readString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements Parcelable.Creator<HlsTrackMetadataEntry> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public HlsTrackMetadataEntry createFromParcel(Parcel parcel) {
            return new HlsTrackMetadataEntry(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public HlsTrackMetadataEntry[] newArray(int i10) {
            return new HlsTrackMetadataEntry[i10];
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
        if (obj != null && HlsTrackMetadataEntry.class == obj.getClass()) {
            HlsTrackMetadataEntry hlsTrackMetadataEntry = (HlsTrackMetadataEntry) obj;
            if (TextUtils.equals(this.f1652a, hlsTrackMetadataEntry.f1652a) && TextUtils.equals(this.f1653b, hlsTrackMetadataEntry.f1653b) && this.f1654c.equals(hlsTrackMetadataEntry.f1654c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.f1652a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f1653b;
        return ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.f1654c.hashCode();
    }

    public String toString() {
        String string;
        String str = this.f1652a;
        if (str != null) {
            String str2 = this.f1653b;
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 5 + String.valueOf(str2).length());
            sb2.append(" [");
            sb2.append(str);
            sb2.append(", ");
            sb2.append(str2);
            sb2.append("]");
            string = sb2.toString();
        } else {
            string = "";
        }
        String strValueOf = String.valueOf(string);
        return strValueOf.length() != 0 ? "HlsTrackMetadataEntry".concat(strValueOf) : new String("HlsTrackMetadataEntry");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f1652a);
        parcel.writeString(this.f1653b);
        int size = this.f1654c.size();
        parcel.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            parcel.writeParcelable(this.f1654c.get(i11), 0);
        }
    }

    HlsTrackMetadataEntry(Parcel parcel) {
        this.f1652a = parcel.readString();
        this.f1653b = parcel.readString();
        int i10 = parcel.readInt();
        ArrayList arrayList = new ArrayList(i10);
        for (int i11 = 0; i11 < i10; i11++) {
            arrayList.add((VariantInfo) parcel.readParcelable(VariantInfo.class.getClassLoader()));
        }
        this.f1654c = Collections.unmodifiableList(arrayList);
    }
}
