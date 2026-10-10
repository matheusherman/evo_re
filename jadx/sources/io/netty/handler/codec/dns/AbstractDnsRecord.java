package io.netty.handler.codec.dns;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.net.IDN;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class AbstractDnsRecord implements DnsRecord {
    private final short dnsClass;
    private int hashCode;
    private final String name;
    private final long timeToLive;
    private final DnsRecordType type;

    protected AbstractDnsRecord(String str, DnsRecordType dnsRecordType, long j10) {
        this(str, dnsRecordType, 1, j10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DnsRecord)) {
            return false;
        }
        DnsRecord dnsRecord = (DnsRecord) obj;
        int i10 = this.hashCode;
        return (i10 == 0 || i10 == dnsRecord.hashCode()) && type().intValue() == dnsRecord.type().intValue() && dnsClass() == dnsRecord.dnsClass() && name().equals(dnsRecord.name());
    }

    protected AbstractDnsRecord(String str, DnsRecordType dnsRecordType, int i10, long j10) {
        ObjectUtil.checkPositiveOrZero(j10, "timeToLive");
        this.name = appendTrailingDot(IDNtoASCII(str));
        this.type = (DnsRecordType) ObjectUtil.checkNotNull(dnsRecordType, IjkMediaMeta.IJKM_KEY_TYPE);
        this.dnsClass = (short) i10;
        this.timeToLive = j10;
    }

    private static String IDNtoASCII(String str) {
        ObjectUtil.checkNotNull(str, "name");
        return (PlatformDependent.isAndroid() && ".".equals(str)) ? str : IDN.toASCII(str);
    }

    @Override // io.netty.handler.codec.dns.DnsRecord
    public int dnsClass() {
        return this.dnsClass & 65535;
    }

    public int hashCode() {
        int i10 = this.hashCode;
        if (i10 != 0) {
            return i10;
        }
        int iHashCode = (this.name.hashCode() * 31) + (type().intValue() * 31) + dnsClass();
        this.hashCode = iHashCode;
        return iHashCode;
    }

    @Override // io.netty.handler.codec.dns.DnsRecord
    public String name() {
        return this.name;
    }

    @Override // io.netty.handler.codec.dns.DnsRecord
    public long timeToLive() {
        return this.timeToLive;
    }

    @Override // io.netty.handler.codec.dns.DnsRecord
    public DnsRecordType type() {
        return this.type;
    }

    private static String appendTrailingDot(String str) {
        if (str.length() > 0 && str.charAt(str.length() - 1) != '.') {
            return str + '.';
        }
        return str;
    }
}
