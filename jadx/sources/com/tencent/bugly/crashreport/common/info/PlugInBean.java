package com.tencent.bugly.crashreport.common.info;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class PlugInBean implements Parcelable {
    public static final Parcelable.Creator<PlugInBean> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f8575b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f8576c;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class a implements Parcelable.Creator<PlugInBean> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ PlugInBean createFromParcel(Parcel parcel) {
            return new PlugInBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ PlugInBean[] newArray(int i10) {
            return new PlugInBean[i10];
        }

        a() {
        }
    }

    public PlugInBean(String str, String str2, String str3) {
        this.f8574a = str;
        this.f8575b = str2;
        this.f8576c = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "plid:" + this.f8574a + " plV:" + this.f8575b + " plUUID:" + this.f8576c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f8574a);
        parcel.writeString(this.f8575b);
        parcel.writeString(this.f8576c);
    }

    public PlugInBean(Parcel parcel) {
        this.f8574a = parcel.readString();
        this.f8575b = parcel.readString();
        this.f8576c = parcel.readString();
    }
}
