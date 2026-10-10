package io.netty.handler.codec.dns;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public interface DnsResponse extends DnsMessage {
    DnsResponse addRecord(DnsSection dnsSection, DnsRecord dnsRecord);

    DnsResponseCode code();

    boolean isAuthoritativeAnswer();

    boolean isRecursionAvailable();

    boolean isTruncated();

    DnsResponse setAuthoritativeAnswer(boolean z10);

    DnsResponse setRecursionAvailable(boolean z10);

    DnsResponse setRecursionDesired(boolean z10);

    DnsResponse setTruncated(boolean z10);

    DnsResponse setZ(int i10);
}
