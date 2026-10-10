package io.netty.handler.codec.http;

import io.netty.util.AsciiString;
import io.netty.util.internal.ObjectUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class HttpUtil {
    private static final AsciiString CHARSET_EQUALS = AsciiString.of(((Object) HttpHeaderValues.CHARSET) + "=");
    private static final AsciiString SEMICOLON = AsciiString.cached(";");
    private static final String COMMA_STRING = String.valueOf(',');

    public static void setTransferEncodingChunked(HttpMessage httpMessage, boolean z10) {
        if (z10) {
            httpMessage.headers().set(HttpHeaderNames.TRANSFER_ENCODING, HttpHeaderValues.CHUNKED);
            httpMessage.headers().remove(HttpHeaderNames.CONTENT_LENGTH);
            return;
        }
        List<String> all = httpMessage.headers().getAll(HttpHeaderNames.TRANSFER_ENCODING);
        if (all.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(all);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (HttpHeaderValues.CHUNKED.contentEqualsIgnoreCase((CharSequence) it.next())) {
                it.remove();
            }
        }
        if (arrayList.isEmpty()) {
            httpMessage.headers().remove(HttpHeaderNames.TRANSFER_ENCODING);
        } else {
            httpMessage.headers().set((CharSequence) HttpHeaderNames.TRANSFER_ENCODING, (Iterable<?>) arrayList);
        }
    }

    public static long getContentLength(HttpMessage httpMessage, long j10) {
        String str = httpMessage.headers().get(HttpHeaderNames.CONTENT_LENGTH);
        if (str != null) {
            return Long.parseLong(str);
        }
        long webSocketContentLength = getWebSocketContentLength(httpMessage);
        if (webSocketContentLength >= 0) {
            return webSocketContentLength;
        }
        return j10;
    }

    private static int getWebSocketContentLength(HttpMessage httpMessage) {
        HttpHeaders httpHeadersHeaders = httpMessage.headers();
        if (httpMessage instanceof HttpRequest) {
            if (HttpMethod.GET.equals(((HttpRequest) httpMessage).method()) && httpHeadersHeaders.contains(HttpHeaderNames.SEC_WEBSOCKET_KEY1) && httpHeadersHeaders.contains(HttpHeaderNames.SEC_WEBSOCKET_KEY2)) {
                return 8;
            }
            return -1;
        }
        if ((httpMessage instanceof HttpResponse) && ((HttpResponse) httpMessage).status().code() == 101 && httpHeadersHeaders.contains(HttpHeaderNames.SEC_WEBSOCKET_ORIGIN) && httpHeadersHeaders.contains(HttpHeaderNames.SEC_WEBSOCKET_LOCATION)) {
            return 16;
        }
        return -1;
    }

    public static boolean isContentLengthSet(HttpMessage httpMessage) {
        return httpMessage.headers().contains(HttpHeaderNames.CONTENT_LENGTH);
    }

    public static boolean isTransferEncodingChunked(HttpMessage httpMessage) {
        return httpMessage.headers().containsValue(HttpHeaderNames.TRANSFER_ENCODING, HttpHeaderValues.CHUNKED, true);
    }

    public static long normalizeAndGetContentLength(List<? extends CharSequence> list, boolean z10, boolean z11) {
        if (list.isEmpty()) {
            return -1L;
        }
        String string = list.get(0).toString();
        if ((list.size() > 1 || string.indexOf(44) >= 0) && !z10) {
            if (z11) {
                Iterator<? extends CharSequence> it = list.iterator();
                string = null;
                while (it.hasNext()) {
                    for (String str : it.next().toString().split(COMMA_STRING, -1)) {
                        String strTrim = str.trim();
                        if (string == null) {
                            string = strTrim;
                        } else if (!strTrim.equals(string)) {
                            throw new IllegalArgumentException("Multiple Content-Length values found: " + list);
                        }
                    }
                }
            } else {
                throw new IllegalArgumentException("Multiple Content-Length values found: " + list);
            }
        }
        if (!string.isEmpty() && Character.isDigit(string.charAt(0))) {
            try {
                return ObjectUtil.checkPositiveOrZero(Long.parseLong(string), "Content-Length value");
            } catch (NumberFormatException e10) {
                throw new IllegalArgumentException("Content-Length value is not a number: " + string, e10);
            }
        }
        throw new IllegalArgumentException("Content-Length value is not a number: " + string);
    }

    public static void setContentLength(HttpMessage httpMessage, long j10) {
        httpMessage.headers().set(HttpHeaderNames.CONTENT_LENGTH, Long.valueOf(j10));
    }
}
