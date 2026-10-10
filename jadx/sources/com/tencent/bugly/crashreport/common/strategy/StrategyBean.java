package com.tencent.bugly.crashreport.common.strategy;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.proguard.ap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class StrategyBean implements Parcelable {
    public static final Parcelable.Creator<StrategyBean> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f8577a = "https://android.bugly.qq.com/rqd/async";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f8578b = "https://android.bugly.qq.com/rqd/async";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f8579c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f8580d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f8581e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f8582f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f8583g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f8584h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f8585i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f8586j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f8587k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f8588l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f8589m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f8590n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f8591o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f8592p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f8593q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f8594r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f8595s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Map<String, String> f8596t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f8597u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f8598v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f8599w;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class a implements Parcelable.Creator<StrategyBean> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ StrategyBean createFromParcel(Parcel parcel) {
            return new StrategyBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ StrategyBean[] newArray(int i10) {
            return new StrategyBean[i10];
        }

        a() {
        }
    }

    public StrategyBean() {
        this.f8580d = -1L;
        this.f8581e = -1L;
        this.f8582f = true;
        this.f8583g = true;
        this.f8584h = true;
        this.f8585i = true;
        this.f8586j = false;
        this.f8587k = true;
        this.f8588l = true;
        this.f8589m = true;
        this.f8590n = true;
        this.f8592p = 30000L;
        this.f8593q = f8577a;
        this.f8594r = f8578b;
        this.f8597u = 10;
        this.f8598v = 300000L;
        this.f8599w = -1L;
        this.f8581e = System.currentTimeMillis();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("S(@L@L@)");
        f8579c = sb2.toString();
        sb2.setLength(0);
        sb2.append("*^@K#K@!");
        this.f8595s = sb2.toString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeLong(this.f8581e);
        parcel.writeByte(this.f8582f ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f8583g ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f8584h ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f8593q);
        parcel.writeString(this.f8594r);
        parcel.writeString(this.f8595s);
        ap.b(parcel, this.f8596t);
        parcel.writeByte(this.f8585i ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f8586j ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f8589m ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f8590n ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f8592p);
        parcel.writeByte(this.f8587k ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f8588l ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f8591o);
        parcel.writeInt(this.f8597u);
        parcel.writeLong(this.f8598v);
        parcel.writeLong(this.f8599w);
    }

    public StrategyBean(Parcel parcel) {
        this.f8580d = -1L;
        this.f8581e = -1L;
        boolean z10 = true;
        this.f8582f = true;
        this.f8583g = true;
        this.f8584h = true;
        this.f8585i = true;
        this.f8586j = false;
        this.f8587k = true;
        this.f8588l = true;
        this.f8589m = true;
        this.f8590n = true;
        this.f8592p = 30000L;
        this.f8593q = f8577a;
        this.f8594r = f8578b;
        this.f8597u = 10;
        this.f8598v = 300000L;
        this.f8599w = -1L;
        try {
            f8579c = "S(@L@L@)";
            this.f8581e = parcel.readLong();
            this.f8582f = parcel.readByte() == 1;
            this.f8583g = parcel.readByte() == 1;
            this.f8584h = parcel.readByte() == 1;
            this.f8593q = parcel.readString();
            this.f8594r = parcel.readString();
            this.f8595s = parcel.readString();
            this.f8596t = ap.b(parcel);
            this.f8585i = parcel.readByte() == 1;
            this.f8586j = parcel.readByte() == 1;
            this.f8589m = parcel.readByte() == 1;
            this.f8590n = parcel.readByte() == 1;
            this.f8592p = parcel.readLong();
            this.f8587k = parcel.readByte() == 1;
            if (parcel.readByte() != 1) {
                z10 = false;
            }
            this.f8588l = z10;
            this.f8591o = parcel.readLong();
            this.f8597u = parcel.readInt();
            this.f8598v = parcel.readLong();
            this.f8599w = parcel.readLong();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }
}
