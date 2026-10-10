package nf;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class r extends n6.a {
    private final String mediaId;
    private final int mediaMode;
    private String playPositionPersistenceKey;
    private final v6.c playType;
    private final String routeId;
    private final long session;
    private final String url;
    private String videoName;

    public String c() {
        return this.mediaId;
    }

    public int d() {
        return this.mediaMode;
    }

    public String e() {
        return this.playPositionPersistenceKey;
    }

    public v6.c f() {
        return this.playType;
    }

    public long g() {
        return this.session;
    }

    public String getRouteId() {
        return this.routeId;
    }

    public String getUrl() {
        return this.url;
    }

    public String h() {
        return this.videoName;
    }

    public void i(String str) {
        this.playPositionPersistenceKey = str;
    }

    public void j(String str) {
        this.videoName = str;
    }

    public r(String str, String str2, int i10, v6.c cVar, String str3, long j10) {
        this.mediaId = str;
        this.routeId = str2;
        this.mediaMode = i10;
        this.playType = cVar;
        this.url = str3;
        this.session = j10;
    }
}
