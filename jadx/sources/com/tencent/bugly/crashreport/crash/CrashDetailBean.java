package com.tencent.bugly.crashreport.crash;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.tencent.bugly.proguard.ap;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class CrashDetailBean implements Parcelable, Comparable<CrashDetailBean> {
    public static final Parcelable.Creator<CrashDetailBean> CREATOR = new a();
    public String A;
    public String B;
    public long C;
    public long D;
    public long E;
    public long F;
    public long G;
    public long H;
    public long I;
    public long J;
    public long K;
    public String L;
    public String M;
    public String N;
    public String O;
    public String P;
    public long Q;
    public boolean R;
    public Map<String, String> S;
    public Map<String, String> T;
    public int U;
    public int V;
    public Map<String, String> W;
    public Map<String, String> X;
    public byte[] Y;
    public String Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f8600a;

    /* JADX INFO: renamed from: aa, reason: collision with root package name */
    public String f8601aa;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8602b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f8603c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f8604d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f8605e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f8606f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f8607g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Map<String, PlugInBean> f8608h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Map<String, PlugInBean> f8609i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f8610j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f8611k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f8612l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f8613m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f8614n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f8615o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f8616p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f8617q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f8618r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f8619s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f8620t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f8621u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f8622v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f8623w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f8624x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public byte[] f8625y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Map<String, String> f8626z;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class a implements Parcelable.Creator<CrashDetailBean> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ CrashDetailBean createFromParcel(Parcel parcel) {
            return new CrashDetailBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ CrashDetailBean[] newArray(int i10) {
            return new CrashDetailBean[i10];
        }

        a() {
        }
    }

    public CrashDetailBean() {
        this.f8600a = -1L;
        this.f8602b = 0;
        this.f8603c = UUID.randomUUID().toString();
        this.f8604d = false;
        this.f8605e = "";
        this.f8606f = "";
        this.f8607g = "";
        this.f8608h = null;
        this.f8609i = null;
        this.f8610j = false;
        this.f8611k = false;
        this.f8612l = 0;
        this.f8613m = "";
        this.f8614n = "";
        this.f8615o = "";
        this.f8616p = "";
        this.f8617q = "";
        this.f8618r = -1L;
        this.f8619s = null;
        this.f8620t = 0;
        this.f8621u = "";
        this.f8622v = "";
        this.f8623w = null;
        this.f8624x = null;
        this.f8625y = null;
        this.f8626z = null;
        this.A = "";
        this.B = "";
        this.C = -1L;
        this.D = -1L;
        this.E = -1L;
        this.F = -1L;
        this.G = -1L;
        this.H = -1L;
        this.I = -1L;
        this.J = -1L;
        this.K = -1L;
        this.L = "";
        this.M = "";
        this.N = "";
        this.O = "";
        this.P = "";
        this.Q = -1L;
        this.R = false;
        this.S = null;
        this.T = null;
        this.U = -1;
        this.V = -1;
        this.W = null;
        this.X = null;
        this.Y = null;
        this.Z = null;
        this.f8601aa = null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(CrashDetailBean crashDetailBean) {
        CrashDetailBean crashDetailBean2 = crashDetailBean;
        if (crashDetailBean2 == null) {
            return 1;
        }
        long j10 = this.f8618r - crashDetailBean2.f8618r;
        if (j10 <= 0) {
            return j10 < 0 ? -1 : 0;
        }
        return 1;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f8602b);
        parcel.writeString(this.f8603c);
        parcel.writeByte(this.f8604d ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f8605e);
        parcel.writeString(this.f8606f);
        parcel.writeString(this.f8607g);
        parcel.writeByte(this.f8610j ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f8611k ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f8612l);
        parcel.writeString(this.f8613m);
        parcel.writeString(this.f8614n);
        parcel.writeString(this.f8615o);
        parcel.writeString(this.f8616p);
        parcel.writeString(this.f8617q);
        parcel.writeLong(this.f8618r);
        parcel.writeString(this.f8619s);
        parcel.writeInt(this.f8620t);
        parcel.writeString(this.f8621u);
        parcel.writeString(this.f8622v);
        parcel.writeString(this.f8623w);
        ap.b(parcel, this.f8626z);
        parcel.writeString(this.A);
        parcel.writeString(this.B);
        parcel.writeLong(this.C);
        parcel.writeLong(this.D);
        parcel.writeLong(this.E);
        parcel.writeLong(this.F);
        parcel.writeLong(this.G);
        parcel.writeLong(this.H);
        parcel.writeString(this.L);
        parcel.writeString(this.M);
        parcel.writeString(this.N);
        parcel.writeString(this.O);
        parcel.writeString(this.P);
        parcel.writeLong(this.Q);
        parcel.writeByte(this.R ? (byte) 1 : (byte) 0);
        ap.b(parcel, this.S);
        ap.a(parcel, this.f8608h);
        ap.a(parcel, this.f8609i);
        parcel.writeInt(this.U);
        parcel.writeInt(this.V);
        ap.b(parcel, this.W);
        ap.b(parcel, this.X);
        parcel.writeByteArray(this.Y);
        parcel.writeByteArray(this.f8625y);
        parcel.writeString(this.Z);
        parcel.writeString(this.f8601aa);
        parcel.writeString(this.f8624x);
        parcel.writeLong(this.I);
        parcel.writeLong(this.J);
        parcel.writeLong(this.K);
    }

    public CrashDetailBean(Parcel parcel) {
        this.f8600a = -1L;
        this.f8602b = 0;
        this.f8603c = UUID.randomUUID().toString();
        this.f8604d = false;
        this.f8605e = "";
        this.f8606f = "";
        this.f8607g = "";
        this.f8608h = null;
        this.f8609i = null;
        this.f8610j = false;
        this.f8611k = false;
        this.f8612l = 0;
        this.f8613m = "";
        this.f8614n = "";
        this.f8615o = "";
        this.f8616p = "";
        this.f8617q = "";
        this.f8618r = -1L;
        this.f8619s = null;
        this.f8620t = 0;
        this.f8621u = "";
        this.f8622v = "";
        this.f8623w = null;
        this.f8624x = null;
        this.f8625y = null;
        this.f8626z = null;
        this.A = "";
        this.B = "";
        this.C = -1L;
        this.D = -1L;
        this.E = -1L;
        this.F = -1L;
        this.G = -1L;
        this.H = -1L;
        this.I = -1L;
        this.J = -1L;
        this.K = -1L;
        this.L = "";
        this.M = "";
        this.N = "";
        this.O = "";
        this.P = "";
        this.Q = -1L;
        this.R = false;
        this.S = null;
        this.T = null;
        this.U = -1;
        this.V = -1;
        this.W = null;
        this.X = null;
        this.Y = null;
        this.Z = null;
        this.f8601aa = null;
        this.f8602b = parcel.readInt();
        this.f8603c = parcel.readString();
        this.f8604d = parcel.readByte() == 1;
        this.f8605e = parcel.readString();
        this.f8606f = parcel.readString();
        this.f8607g = parcel.readString();
        this.f8610j = parcel.readByte() == 1;
        this.f8611k = parcel.readByte() == 1;
        this.f8612l = parcel.readInt();
        this.f8613m = parcel.readString();
        this.f8614n = parcel.readString();
        this.f8615o = parcel.readString();
        this.f8616p = parcel.readString();
        this.f8617q = parcel.readString();
        this.f8618r = parcel.readLong();
        this.f8619s = parcel.readString();
        this.f8620t = parcel.readInt();
        this.f8621u = parcel.readString();
        this.f8622v = parcel.readString();
        this.f8623w = parcel.readString();
        this.f8626z = ap.b(parcel);
        this.A = parcel.readString();
        this.B = parcel.readString();
        this.C = parcel.readLong();
        this.D = parcel.readLong();
        this.E = parcel.readLong();
        this.F = parcel.readLong();
        this.G = parcel.readLong();
        this.H = parcel.readLong();
        this.L = parcel.readString();
        this.M = parcel.readString();
        this.N = parcel.readString();
        this.O = parcel.readString();
        this.P = parcel.readString();
        this.Q = parcel.readLong();
        this.R = parcel.readByte() == 1;
        this.S = ap.b(parcel);
        this.f8608h = ap.a(parcel);
        this.f8609i = ap.a(parcel);
        this.U = parcel.readInt();
        this.V = parcel.readInt();
        this.W = ap.b(parcel);
        this.X = ap.b(parcel);
        this.Y = parcel.createByteArray();
        this.f8625y = parcel.createByteArray();
        this.Z = parcel.readString();
        this.f8601aa = parcel.readString();
        this.f8624x = parcel.readString();
        this.I = parcel.readLong();
        this.J = parcel.readLong();
        this.K = parcel.readLong();
    }
}
