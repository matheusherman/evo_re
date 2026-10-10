package io.netty.handler.codec.http;

import io.netty.util.internal.StringUtil;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class HttpMessageUtil {
    private static void appendInitialLine(StringBuilder sb2, HttpRequest httpRequest) {
        sb2.append(httpRequest.method());
        sb2.append(' ');
        sb2.append(httpRequest.uri());
        sb2.append(' ');
        sb2.append(httpRequest.protocolVersion());
        sb2.append(StringUtil.NEWLINE);
    }

    private static void appendCommon(StringBuilder sb2, HttpMessage httpMessage) {
        sb2.append(StringUtil.simpleClassName(httpMessage));
        sb2.append("(decodeResult: ");
        sb2.append(httpMessage.decoderResult());
        sb2.append(", version: ");
        sb2.append(httpMessage.protocolVersion());
        sb2.append(')');
        sb2.append(StringUtil.NEWLINE);
    }

    private static void appendFullCommon(StringBuilder sb2, FullHttpMessage fullHttpMessage) {
        sb2.append(StringUtil.simpleClassName(fullHttpMessage));
        sb2.append("(decodeResult: ");
        sb2.append(fullHttpMessage.decoderResult());
        sb2.append(", version: ");
        sb2.append(fullHttpMessage.protocolVersion());
        sb2.append(", content: ");
        sb2.append(fullHttpMessage.content());
        sb2.append(')');
        sb2.append(StringUtil.NEWLINE);
    }

    static StringBuilder appendFullRequest(StringBuilder sb2, FullHttpRequest fullHttpRequest) {
        appendFullCommon(sb2, fullHttpRequest);
        appendInitialLine(sb2, fullHttpRequest);
        appendHeaders(sb2, fullHttpRequest.headers());
        appendHeaders(sb2, fullHttpRequest.trailingHeaders());
        removeLastNewLine(sb2);
        return sb2;
    }

    private static void appendHeaders(StringBuilder sb2, HttpHeaders httpHeaders) {
        for (Map.Entry<String, String> entry : httpHeaders) {
            sb2.append(entry.getKey());
            sb2.append(": ");
            sb2.append(entry.getValue());
            sb2.append(StringUtil.NEWLINE);
        }
    }

    static StringBuilder appendRequest(StringBuilder sb2, HttpRequest httpRequest) {
        appendCommon(sb2, httpRequest);
        appendInitialLine(sb2, httpRequest);
        appendHeaders(sb2, httpRequest.headers());
        removeLastNewLine(sb2);
        return sb2;
    }

    static StringBuilder appendResponse(StringBuilder sb2, HttpResponse httpResponse) {
        appendCommon(sb2, httpResponse);
        appendInitialLine(sb2, httpResponse);
        appendHeaders(sb2, httpResponse.headers());
        removeLastNewLine(sb2);
        return sb2;
    }

    private static void removeLastNewLine(StringBuilder sb2) {
        sb2.setLength(sb2.length() - StringUtil.NEWLINE.length());
    }

    private static void appendInitialLine(StringBuilder sb2, HttpResponse httpResponse) {
        sb2.append(httpResponse.protocolVersion());
        sb2.append(' ');
        sb2.append(httpResponse.status());
        sb2.append(StringUtil.NEWLINE);
    }
}
