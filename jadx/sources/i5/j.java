package i5;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f11145a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f11146b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f11147c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f11148d;

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("ApiChannelGroupMapping{");
        stringBuffer.append("channelGroupId='");
        stringBuffer.append(this.f11145a);
        stringBuffer.append('\'');
        stringBuffer.append(", channelId='");
        stringBuffer.append(this.f11146b);
        stringBuffer.append('\'');
        stringBuffer.append(", channelGroupMappingSeq=");
        stringBuffer.append(this.f11147c);
        stringBuffer.append(", channelGroupMappingStatus=");
        stringBuffer.append(this.f11148d);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    public j(String str, String str2, int i10, int i11) {
        this.f11145a = str;
        this.f11146b = str2;
        this.f11147c = i10;
        this.f11148d = i11;
    }
}
