package io.netty.handler.codec.http;

import io.netty.handler.codec.DecoderResult;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class HttpMessageDecoderResult extends DecoderResult {
    private final int headerSize;
    private final int initialLineLength;

    HttpMessageDecoderResult(int i10, int i11) {
        super(DecoderResult.SIGNAL_SUCCESS);
        this.initialLineLength = i10;
        this.headerSize = i11;
    }
}
