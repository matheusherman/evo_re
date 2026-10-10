package com.google.android.exoplayer2.offline;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import d1.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class DownloadRequest implements Parcelable {
    public static final Parcelable.Creator<DownloadRequest> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1614a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Uri f1615b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final String f1616c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<StreamKey> f1617d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public final byte[] f1618e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public final String f1619f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final byte[] f1620g;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements Parcelable.Creator<DownloadRequest> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public DownloadRequest createFromParcel(Parcel parcel) {
            return new DownloadRequest(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public DownloadRequest[] newArray(int i10) {
            return new DownloadRequest[i10];
        }

        a() {
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof DownloadRequest)) {
            return false;
        }
        DownloadRequest downloadRequest = (DownloadRequest) obj;
        return this.f1614a.equals(downloadRequest.f1614a) && this.f1615b.equals(downloadRequest.f1615b) && k.a(this.f1616c, downloadRequest.f1616c) && this.f1617d.equals(downloadRequest.f1617d) && Arrays.equals(this.f1618e, downloadRequest.f1618e) && k.a(this.f1619f, downloadRequest.f1619f) && Arrays.equals(this.f1620g, downloadRequest.f1620g);
    }

    public final int hashCode() {
        int iHashCode = ((this.f1614a.hashCode() * 961) + this.f1615b.hashCode()) * 31;
        String str = this.f1616c;
        int iHashCode2 = (((((iHashCode + (str != null ? str.hashCode() : 0)) * 31) + this.f1617d.hashCode()) * 31) + Arrays.hashCode(this.f1618e)) * 31;
        String str2 = this.f1619f;
        return ((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + Arrays.hashCode(this.f1620g);
    }

    public String toString() {
        String str = this.f1616c;
        String str2 = this.f1614a;
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(str2).length());
        sb2.append(str);
        sb2.append(":");
        sb2.append(str2);
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f1614a);
        parcel.writeString(this.f1615b.toString());
        parcel.writeString(this.f1616c);
        parcel.writeInt(this.f1617d.size());
        for (int i11 = 0; i11 < this.f1617d.size(); i11++) {
            parcel.writeParcelable(this.f1617d.get(i11), 0);
        }
        parcel.writeByteArray(this.f1618e);
        parcel.writeString(this.f1619f);
        parcel.writeByteArray(this.f1620g);
    }

    DownloadRequest(Parcel parcel) {
        this.f1614a = (String) k.b(parcel.readString());
        this.f1615b = Uri.parse((String) k.b(parcel.readString()));
        this.f1616c = parcel.readString();
        int i10 = parcel.readInt();
        ArrayList arrayList = new ArrayList(i10);
        for (int i11 = 0; i11 < i10; i11++) {
            arrayList.add((StreamKey) parcel.readParcelable(StreamKey.class.getClassLoader()));
        }
        this.f1617d = Collections.unmodifiableList(arrayList);
        this.f1618e = parcel.createByteArray();
        this.f1619f = parcel.readString();
        this.f1620g = (byte[]) k.b(parcel.createByteArray());
    }
}
