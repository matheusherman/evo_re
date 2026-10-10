package com.tencent.bugly.crashreport.biz;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.proguard.ap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class UserInfoBean implements Parcelable {
    public static final Parcelable.Creator<UserInfoBean> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f8555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8556b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f8557c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f8558d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f8559e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f8560f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f8561g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f8562h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f8563i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f8564j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f8565k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f8566l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f8567m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f8568n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f8569o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f8570p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f8571q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Map<String, String> f8572r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Map<String, String> f8573s;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class a implements Parcelable.Creator<UserInfoBean> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ UserInfoBean createFromParcel(Parcel parcel) {
            return new UserInfoBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ UserInfoBean[] newArray(int i10) {
            return new UserInfoBean[i10];
        }

        a() {
        }
    }

    public UserInfoBean() {
        this.f8565k = 0L;
        this.f8566l = false;
        this.f8567m = "unknown";
        this.f8570p = -1;
        this.f8571q = -1;
        this.f8572r = null;
        this.f8573s = null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f8556b);
        parcel.writeString(this.f8557c);
        parcel.writeString(this.f8558d);
        parcel.writeLong(this.f8559e);
        parcel.writeLong(this.f8560f);
        parcel.writeLong(this.f8561g);
        parcel.writeLong(this.f8562h);
        parcel.writeLong(this.f8563i);
        parcel.writeString(this.f8564j);
        parcel.writeLong(this.f8565k);
        parcel.writeByte(this.f8566l ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f8567m);
        parcel.writeInt(this.f8570p);
        parcel.writeInt(this.f8571q);
        ap.b(parcel, this.f8572r);
        ap.b(parcel, this.f8573s);
        parcel.writeString(this.f8568n);
        parcel.writeInt(this.f8569o);
    }

    public UserInfoBean(Parcel parcel) {
        this.f8565k = 0L;
        this.f8566l = false;
        this.f8567m = "unknown";
        this.f8570p = -1;
        this.f8571q = -1;
        this.f8572r = null;
        this.f8573s = null;
        this.f8556b = parcel.readInt();
        this.f8557c = parcel.readString();
        this.f8558d = parcel.readString();
        this.f8559e = parcel.readLong();
        this.f8560f = parcel.readLong();
        this.f8561g = parcel.readLong();
        this.f8562h = parcel.readLong();
        this.f8563i = parcel.readLong();
        this.f8564j = parcel.readString();
        this.f8565k = parcel.readLong();
        this.f8566l = parcel.readByte() == 1;
        this.f8567m = parcel.readString();
        this.f8570p = parcel.readInt();
        this.f8571q = parcel.readInt();
        this.f8572r = ap.b(parcel);
        this.f8573s = ap.b(parcel);
        this.f8568n = parcel.readString();
        this.f8569o = parcel.readInt();
    }
}
