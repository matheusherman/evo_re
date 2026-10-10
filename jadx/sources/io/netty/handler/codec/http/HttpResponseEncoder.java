package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class HttpResponseEncoder extends HttpObjectEncoder<HttpResponse> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.http.HttpObjectEncoder
    public void encodeInitialLine(ByteBuf byteBuf, HttpResponse httpResponse) {
        httpResponse.protocolVersion().encode(byteBuf);
        byteBuf.writeByte(32);
        httpResponse.status().encode(byteBuf);
        ByteBufUtil.writeShortBE(byteBuf, 3338);
    }

    protected void sanitizeHeadersBeforeEncode(HttpResponse httpResponse, boolean z10) {
        if (z10) {
            HttpResponseStatus httpResponseStatusStatus = httpResponse.status();
            if (httpResponseStatusStatus.codeClass() == HttpStatusClass.INFORMATIONAL || httpResponseStatusStatus.code() == HttpResponseStatus.NO_CONTENT.code()) {
                httpResponse.headers().remove(HttpHeaderNames.CONTENT_LENGTH);
                httpResponse.headers().remove(HttpHeaderNames.TRANSFER_ENCODING);
            } else if (httpResponseStatusStatus.code() == HttpResponseStatus.RESET_CONTENT.code()) {
                httpResponse.headers().remove(HttpHeaderNames.TRANSFER_ENCODING);
                httpResponse.headers().setInt(HttpHeaderNames.CONTENT_LENGTH, 0);
            }
        }
    }

    @Override // io.netty.handler.codec.http.HttpObjectEncoder, io.netty.handler.codec.MessageToMessageEncoder
    public boolean acceptOutboundMessage(Object obj) {
        if (super.acceptOutboundMessage(obj) && !(obj instanceof HttpRequest)) {
            return true;
        }
        return false;
    }

    protected boolean isContentAlwaysEmpty(HttpResponse httpResponse) {
        HttpResponseStatus httpResponseStatusStatus = httpResponse.status();
        if (httpResponseStatusStatus.codeClass() == HttpStatusClass.INFORMATIONAL) {
            if (httpResponseStatusStatus.code() != HttpResponseStatus.SWITCHING_PROTOCOLS.code()) {
                return true;
            }
            return httpResponse.headers().contains(HttpHeaderNames.SEC_WEBSOCKET_VERSION);
        }
        if (httpResponseStatusStatus.code() == HttpResponseStatus.NO_CONTENT.code() || httpResponseStatusStatus.code() == HttpResponseStatus.NOT_MODIFIED.code() || httpResponseStatusStatus.code() == HttpResponseStatus.RESET_CONTENT.code()) {
            return true;
        }
        return false;
    }
}
