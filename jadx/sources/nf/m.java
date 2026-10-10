package nf;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class m extends n6.a {
    private final String channelName;
    private final String desc;
    private final String epgId;
    private final int key;
    private final String programmeTitle;
    private final long startTime;
    private final long stopTime;

    public String c() {
        return this.channelName;
    }

    public String d() {
        return this.programmeTitle;
    }

    public long e() {
        return this.startTime;
    }

    public Long f() {
        return Long.valueOf(this.stopTime);
    }

    public String getDesc() {
        return this.desc;
    }

    public String getEpgId() {
        return this.epgId;
    }

    public int getKey() {
        return this.key;
    }

    public m(int i10, String str, long j10, long j11, String str2, String str3, String str4) {
        this.key = i10;
        this.epgId = str;
        this.startTime = j10;
        this.stopTime = j11;
        this.programmeTitle = str3;
        this.channelName = str2;
        this.desc = str4;
    }
}
