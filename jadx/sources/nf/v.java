package nf;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class v extends n6.a {
    private final int code;
    private final String event;
    private final String mediaId;
    private final long playSession;
    private final int playerId;

    public int c() {
        return this.code;
    }

    public long d() {
        return this.playSession;
    }

    public int e() {
        return this.playerId;
    }

    public v(String str, long j10, int i10, int i11, String str2) {
        this.mediaId = str;
        this.playSession = j10;
        this.playerId = i10;
        this.code = i11;
        this.event = str2;
    }
}
