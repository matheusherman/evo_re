package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class ma extends IOException {
    static pa a() {
        return new pa("Protocol message tag had invalid wire type.");
    }

    static ma b() {
        return new ma("Protocol message contained an invalid tag (zero).");
    }

    static ma c() {
        return new ma("Protocol message had invalid UTF-8.");
    }

    static ma d() {
        return new ma("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static ma e() {
        return new ma("Failed to parse the message.");
    }

    static ma f() {
        return new ma("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
    }

    static ma g() {
        return new ma("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public ma(String str) {
        super(str);
    }
}
