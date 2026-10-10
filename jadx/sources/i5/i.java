package i5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f11130a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f11131b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f11132c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f11133d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f11134e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f11135f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f11136g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f11137h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f11138i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private List<String> f11139j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private List<j> f11140k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f11141l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f11142m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f11143n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private Map<String, String> f11144o;

    public i(int i10, String str, String str2, String str3, int i11, List<j> list, Map<String, String> map, int i12) {
        this.f11139j = new ArrayList();
        this.f11140k = new ArrayList();
        this.f11143n = 0;
        this.f11144o = new HashMap();
        this.f11130a = i10;
        this.f11131b = str;
        this.f11132c = str2;
        this.f11135f = i11;
        this.f11140k = list;
        this.f11143n = i12;
    }

    public k j() {
        return null;
    }

    public List<String> a() {
        return this.f11139j;
    }

    public String b() {
        return this.f11133d;
    }

    public String c() {
        return this.f11131b;
    }

    public String d() {
        return this.f11134e;
    }

    public String e() {
        return this.f11138i;
    }

    public String f() {
        return this.f11137h;
    }

    public int g() {
        return this.f11143n;
    }

    public String h() {
        return this.f11132c;
    }

    public int i() {
        return this.f11130a;
    }

    public String toString() {
        return "ApiChannelGroup{channelGroupSeq=" + this.f11130a + ", channelGroupId='" + this.f11131b + "', channelGroupName='" + this.f11132c + "', channelGroupIconUrl='" + this.f11133d + "', channelGroupStatus=" + this.f11135f + ", updateTime=" + this.f11136g + ", frontPictureUrl='" + this.f11137h + "', frontPictureDesc='" + this.f11138i + "', rotationPictureUrlList=" + this.f11139j + ", channelGroupMappings=" + this.f11140k + ", logo='" + this.f11141l + "', desc='" + this.f11142m + "', isPrivate=" + this.f11143n + ", channelGroupLogoMap=" + this.f11144o + '}';
    }

    public i() {
        this.f11139j = new ArrayList();
        this.f11140k = new ArrayList();
        this.f11143n = 0;
        this.f11144o = new HashMap();
    }
}
