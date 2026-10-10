package z1.b1.lb.m.sports;

import androidx.annotation.Keep;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001Bk\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\u0012R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0019\u001a\u0004\b\u001b\u0010\u0012R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001c\u0010\u0012R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001d\u0010\u0012R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0019\u001a\u0004\b\u001e\u0010\u0012R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u001f\u001a\u0004\b \u0010!R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\"\u0010\u0012R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b#\u0010\u0012R\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b$\u0010\u0012R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010%\u001a\u0004\b&\u0010'¨\u0006("}, d2 = {"Lz1/b1/lb/m/sports/Channel;", "", "", "channelId", "name", "channelType", "platform", "geoScope", "", "priority", "effectiveStart", "effectiveEnd", "epgId", "Lz1/b1/lb/m/sports/Program;", "epgProgram", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lz1/b1/lb/m/sports/Program;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", TransactionPartnerType.OTHER, "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "a", "getName", "getChannelType", "getPlatform", "getGeoScope", "Ljava/lang/Integer;", "getPriority", "()Ljava/lang/Integer;", "getEffectiveStart", "getEffectiveEnd", "b", "Lz1/b1/lb/m/sports/Program;", "c", "()Lz1/b1/lb/m/sports/Program;", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class Channel {

    @Keep
    private final String channelId;

    @Keep
    private final String channelType;

    @Keep
    private final String effectiveEnd;

    @Keep
    private final String effectiveStart;

    @Keep
    private final String epgId;

    @Keep
    private final Program epgProgram;

    @Keep
    private final String geoScope;

    @Keep
    private final String name;

    @Keep
    private final String platform;

    @Keep
    private final Integer priority;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Channel)) {
            return false;
        }
        Channel channel = (Channel) other;
        return m.a(this.channelId, channel.channelId) && m.a(this.name, channel.name) && m.a(this.channelType, channel.channelType) && m.a(this.platform, channel.platform) && m.a(this.geoScope, channel.geoScope) && m.a(this.priority, channel.priority) && m.a(this.effectiveStart, channel.effectiveStart) && m.a(this.effectiveEnd, channel.effectiveEnd) && m.a(this.epgId, channel.epgId) && m.a(this.epgProgram, channel.epgProgram);
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getChannelId() {
        return this.channelId;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getEpgId() {
        return this.epgId;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final Program getEpgProgram() {
        return this.epgProgram;
    }

    public int hashCode() {
        String str = this.channelId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.name;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.channelType;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.platform;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.geoScope;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Integer num = this.priority;
        int iHashCode6 = (iHashCode5 + (num == null ? 0 : num.hashCode())) * 31;
        String str6 = this.effectiveStart;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.effectiveEnd;
        int iHashCode8 = (iHashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.epgId;
        int iHashCode9 = (iHashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31;
        Program program = this.epgProgram;
        return iHashCode9 + (program != null ? program.hashCode() : 0);
    }

    public String toString() {
        return "Channel(channelId=" + this.channelId + ", name=" + this.name + ", channelType=" + this.channelType + ", platform=" + this.platform + ", geoScope=" + this.geoScope + ", priority=" + this.priority + ", effectiveStart=" + this.effectiveStart + ", effectiveEnd=" + this.effectiveEnd + ", epgId=" + this.epgId + ", epgProgram=" + this.epgProgram + ")";
    }

    public Channel(String str, String str2, String str3, String str4, String str5, Integer num, String str6, String str7, String str8, Program program) {
        this.channelId = str;
        this.name = str2;
        this.channelType = str3;
        this.platform = str4;
        this.geoScope = str5;
        this.priority = num;
        this.effectiveStart = str6;
        this.effectiveEnd = str7;
        this.epgId = str8;
        this.epgProgram = program;
    }
}
