package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.ObjectUtil;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class HttpVersion implements Comparable<HttpVersion> {
    private final byte[] bytes;
    private final boolean keepAliveDefault;
    private final int majorVersion;
    private final int minorVersion;
    private final String protocolName;
    private final String text;
    private static final Pattern VERSION_PATTERN = Pattern.compile("(\\S+)/(\\d+)\\.(\\d+)");
    public static final HttpVersion HTTP_1_0 = new HttpVersion("HTTP", 1, 0, false, true);
    public static final HttpVersion HTTP_1_1 = new HttpVersion("HTTP", 1, 1, true, true);

    public HttpVersion(String str, boolean z10) {
        String upperCase = ObjectUtil.checkNonEmptyAfterTrim(str, "text").toUpperCase();
        Matcher matcher = VERSION_PATTERN.matcher(upperCase);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("invalid version format: " + upperCase);
        }
        String strGroup = matcher.group(1);
        this.protocolName = strGroup;
        int i10 = Integer.parseInt(matcher.group(2));
        this.majorVersion = i10;
        int i11 = Integer.parseInt(matcher.group(3));
        this.minorVersion = i11;
        this.text = strGroup + '/' + i10 + '.' + i11;
        this.keepAliveDefault = z10;
        this.bytes = null;
    }

    public static HttpVersion valueOf(String str) {
        ObjectUtil.checkNotNull(str, "text");
        String strTrim = str.trim();
        if (strTrim.isEmpty()) {
            throw new IllegalArgumentException("text is empty (possibly HTTP/0.9)");
        }
        HttpVersion httpVersionVersion0 = version0(strTrim);
        return httpVersionVersion0 == null ? new HttpVersion(strTrim, true) : httpVersionVersion0;
    }

    private static HttpVersion version0(String str) {
        if ("HTTP/1.1".equals(str)) {
            return HTTP_1_1;
        }
        if ("HTTP/1.0".equals(str)) {
            return HTTP_1_0;
        }
        return null;
    }

    @Override // java.lang.Comparable
    public int compareTo(HttpVersion httpVersion) {
        int iCompareTo = protocolName().compareTo(httpVersion.protocolName());
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        int iMajorVersion = majorVersion() - httpVersion.majorVersion();
        return iMajorVersion != 0 ? iMajorVersion : minorVersion() - httpVersion.minorVersion();
    }

    void encode(ByteBuf byteBuf) {
        byte[] bArr = this.bytes;
        if (bArr == null) {
            byteBuf.writeCharSequence(this.text, CharsetUtil.US_ASCII);
        } else {
            byteBuf.writeBytes(bArr);
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof HttpVersion)) {
            return false;
        }
        HttpVersion httpVersion = (HttpVersion) obj;
        return minorVersion() == httpVersion.minorVersion() && majorVersion() == httpVersion.majorVersion() && protocolName().equals(httpVersion.protocolName());
    }

    public int majorVersion() {
        return this.majorVersion;
    }

    public int minorVersion() {
        return this.minorVersion;
    }

    public String protocolName() {
        return this.protocolName;
    }

    public String text() {
        return this.text;
    }

    public int hashCode() {
        return (((protocolName().hashCode() * 31) + majorVersion()) * 31) + minorVersion();
    }

    public String toString() {
        return text();
    }

    private HttpVersion(String str, int i10, int i11, boolean z10, boolean z11) {
        String upperCase = ObjectUtil.checkNonEmptyAfterTrim(str, "protocolName").toUpperCase();
        for (int i12 = 0; i12 < upperCase.length(); i12++) {
            if (Character.isISOControl(upperCase.charAt(i12)) || Character.isWhitespace(upperCase.charAt(i12))) {
                throw new IllegalArgumentException("invalid character in protocolName");
            }
        }
        ObjectUtil.checkPositiveOrZero(i10, "majorVersion");
        ObjectUtil.checkPositiveOrZero(i11, "minorVersion");
        this.protocolName = upperCase;
        this.majorVersion = i10;
        this.minorVersion = i11;
        String str2 = upperCase + '/' + i10 + '.' + i11;
        this.text = str2;
        this.keepAliveDefault = z10;
        if (z11) {
            this.bytes = str2.getBytes(CharsetUtil.US_ASCII);
        } else {
            this.bytes = null;
        }
    }
}
