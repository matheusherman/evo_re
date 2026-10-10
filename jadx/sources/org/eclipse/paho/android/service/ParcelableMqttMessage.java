package org.eclipse.paho.android.service;

import android.os.Parcel;
import android.os.Parcelable;
import ve.g;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class ParcelableMqttMessage extends g implements Parcelable {
    public static final Parcelable.Creator<ParcelableMqttMessage> CREATOR = new a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    String f17091f;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class a implements Parcelable.Creator<ParcelableMqttMessage> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ParcelableMqttMessage createFromParcel(Parcel parcel) {
            return new ParcelableMqttMessage(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ParcelableMqttMessage[] newArray(int i10) {
            return new ParcelableMqttMessage[i10];
        }

        a() {
        }
    }

    ParcelableMqttMessage(g gVar) {
        super(gVar.b());
        this.f17091f = null;
        h(gVar.c());
        j(gVar.e());
        f(gVar.d());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeByteArray(b());
        parcel.writeInt(c());
        parcel.writeBooleanArray(new boolean[]{e(), d()});
        parcel.writeString(this.f17091f);
    }

    ParcelableMqttMessage(Parcel parcel) {
        super(parcel.createByteArray());
        this.f17091f = null;
        h(parcel.readInt());
        boolean[] zArrCreateBooleanArray = parcel.createBooleanArray();
        j(zArrCreateBooleanArray[0]);
        f(zArrCreateBooleanArray[1]);
        this.f17091f = parcel.readString();
    }
}
