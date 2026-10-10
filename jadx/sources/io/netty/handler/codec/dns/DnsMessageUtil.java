package io.netty.handler.codec.dns;

import io.netty.channel.AddressedEnvelope;
import io.netty.util.internal.StringUtil;
import java.net.SocketAddress;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class DnsMessageUtil {
    private static StringBuilder appendAddresses(StringBuilder sb2, DnsMessage dnsMessage) {
        if (dnsMessage instanceof AddressedEnvelope) {
            AddressedEnvelope addressedEnvelope = (AddressedEnvelope) dnsMessage;
            SocketAddress socketAddressSender = addressedEnvelope.sender();
            if (socketAddressSender != null) {
                sb2.append("from: ");
                sb2.append(socketAddressSender);
                sb2.append(", ");
            }
            SocketAddress socketAddressRecipient = addressedEnvelope.recipient();
            if (socketAddressRecipient != null) {
                sb2.append("to: ");
                sb2.append(socketAddressRecipient);
                sb2.append(", ");
            }
        }
        return sb2;
    }

    private static void appendAllRecords(StringBuilder sb2, DnsMessage dnsMessage) {
        appendRecords(sb2, dnsMessage, DnsSection.QUESTION);
        appendRecords(sb2, dnsMessage, DnsSection.ANSWER);
        appendRecords(sb2, dnsMessage, DnsSection.AUTHORITY);
        appendRecords(sb2, dnsMessage, DnsSection.ADDITIONAL);
    }

    static StringBuilder appendQuery(StringBuilder sb2, DnsQuery dnsQuery) {
        appendQueryHeader(sb2, dnsQuery);
        appendAllRecords(sb2, dnsQuery);
        return sb2;
    }

    private static void appendQueryHeader(StringBuilder sb2, DnsQuery dnsQuery) {
        sb2.append(StringUtil.simpleClassName(dnsQuery));
        sb2.append('(');
        StringBuilder sbAppendAddresses = appendAddresses(sb2, dnsQuery);
        sbAppendAddresses.append(dnsQuery.id());
        sbAppendAddresses.append(", ");
        sbAppendAddresses.append(dnsQuery.opCode());
        if (dnsQuery.isRecursionDesired()) {
            sb2.append(", RD");
        }
        if (dnsQuery.z() != 0) {
            sb2.append(", Z: ");
            sb2.append(dnsQuery.z());
        }
        sb2.append(')');
    }

    static StringBuilder appendRecordClass(StringBuilder sb2, int i10) {
        String str;
        int i11 = i10 & 65535;
        if (i11 != 1) {
            if (i11 != 2) {
                if (i11 != 3) {
                    if (i11 != 4) {
                        if (i11 != 254) {
                            if (i11 != 255) {
                                str = null;
                            } else {
                                str = "ANY";
                            }
                        } else {
                            str = "NONE";
                        }
                    } else {
                        str = "HESIOD";
                    }
                } else {
                    str = "CHAOS";
                }
            } else {
                str = "CSNET";
            }
        } else {
            str = "IN";
        }
        if (str != null) {
            sb2.append(str);
            return sb2;
        }
        sb2.append("UNKNOWN(");
        sb2.append(i11);
        sb2.append(')');
        return sb2;
    }

    private static void appendRecords(StringBuilder sb2, DnsMessage dnsMessage, DnsSection dnsSection) {
        int iCount = dnsMessage.count(dnsSection);
        for (int i10 = 0; i10 < iCount; i10++) {
            sb2.append(StringUtil.NEWLINE);
            sb2.append('\t');
            sb2.append(dnsMessage.recordAt(dnsSection, i10));
        }
    }

    static StringBuilder appendResponse(StringBuilder sb2, DnsResponse dnsResponse) {
        appendResponseHeader(sb2, dnsResponse);
        appendAllRecords(sb2, dnsResponse);
        return sb2;
    }

    private static void appendResponseHeader(StringBuilder sb2, DnsResponse dnsResponse) {
        boolean z10;
        sb2.append(StringUtil.simpleClassName(dnsResponse));
        sb2.append('(');
        StringBuilder sbAppendAddresses = appendAddresses(sb2, dnsResponse);
        sbAppendAddresses.append(dnsResponse.id());
        sbAppendAddresses.append(", ");
        sbAppendAddresses.append(dnsResponse.opCode());
        sbAppendAddresses.append(", ");
        sbAppendAddresses.append(dnsResponse.code());
        sbAppendAddresses.append(',');
        boolean z11 = false;
        if (dnsResponse.isRecursionDesired()) {
            sb2.append(" RD");
            z10 = false;
        } else {
            z10 = true;
        }
        if (dnsResponse.isAuthoritativeAnswer()) {
            sb2.append(" AA");
            z10 = false;
        }
        if (dnsResponse.isTruncated()) {
            sb2.append(" TC");
            z10 = false;
        }
        if (dnsResponse.isRecursionAvailable()) {
            sb2.append(" RA");
        } else {
            z11 = z10;
        }
        if (dnsResponse.z() != 0) {
            if (!z11) {
                sb2.append(',');
            }
            sb2.append(" Z: ");
            sb2.append(dnsResponse.z());
        }
        if (z11) {
            sb2.setCharAt(sb2.length() - 1, ')');
        } else {
            sb2.append(')');
        }
    }
}
