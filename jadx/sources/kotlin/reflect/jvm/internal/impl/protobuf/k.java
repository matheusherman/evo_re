package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class k extends IOException {
    private q unfinishedMessage;

    static k b() {
        return new k("Protocol message end-group tag did not match expected tag.");
    }

    static k c() {
        return new k("Protocol message contained an invalid tag (zero).");
    }

    static k d() {
        return new k("Protocol message had invalid UTF-8.");
    }

    static k e() {
        return new k("Protocol message tag had invalid wire type.");
    }

    static k f() {
        return new k("CodedInputStream encountered a malformed varint.");
    }

    static k g() {
        return new k("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static k h() {
        return new k("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    static k j() {
        return new k("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    static k k() {
        return new k("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }

    public q a() {
        return this.unfinishedMessage;
    }

    public k i(q qVar) {
        this.unfinishedMessage = qVar;
        return this;
    }

    public k(String str) {
        super(str);
        this.unfinishedMessage = null;
    }
}
