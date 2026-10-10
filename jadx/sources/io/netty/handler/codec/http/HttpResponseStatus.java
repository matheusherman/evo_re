package io.netty.handler.codec.http;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.FrameMetricsAggregator;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.util.AsciiString;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.ObjectUtil;
import org.apache.log4j.varia.ExternallyRolledFileAppender;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class HttpResponseStatus implements Comparable<HttpResponseStatus> {
    private final byte[] bytes;
    private final int code;
    private final AsciiString codeAsText;
    private HttpStatusClass codeClass;
    private final String reasonPhrase;
    public static final HttpResponseStatus CONTINUE = newStatus(100, "Continue");
    public static final HttpResponseStatus SWITCHING_PROTOCOLS = newStatus(101, "Switching Protocols");
    public static final HttpResponseStatus PROCESSING = newStatus(102, "Processing");
    public static final HttpResponseStatus OK = newStatus(200, ExternallyRolledFileAppender.OK);
    public static final HttpResponseStatus CREATED = newStatus(201, "Created");
    public static final HttpResponseStatus ACCEPTED = newStatus(202, "Accepted");
    public static final HttpResponseStatus NON_AUTHORITATIVE_INFORMATION = newStatus(203, "Non-Authoritative Information");
    public static final HttpResponseStatus NO_CONTENT = newStatus(204, "No Content");
    public static final HttpResponseStatus RESET_CONTENT = newStatus(205, "Reset Content");
    public static final HttpResponseStatus PARTIAL_CONTENT = newStatus(206, "Partial Content");
    public static final HttpResponseStatus MULTI_STATUS = newStatus(207, "Multi-Status");
    public static final HttpResponseStatus MULTIPLE_CHOICES = newStatus(300, "Multiple Choices");
    public static final HttpResponseStatus MOVED_PERMANENTLY = newStatus(301, "Moved Permanently");
    public static final HttpResponseStatus FOUND = newStatus(302, "Found");
    public static final HttpResponseStatus SEE_OTHER = newStatus(303, "See Other");
    public static final HttpResponseStatus NOT_MODIFIED = newStatus(304, "Not Modified");
    public static final HttpResponseStatus USE_PROXY = newStatus(305, "Use Proxy");
    public static final HttpResponseStatus TEMPORARY_REDIRECT = newStatus(307, "Temporary Redirect");
    public static final HttpResponseStatus PERMANENT_REDIRECT = newStatus(308, "Permanent Redirect");
    public static final HttpResponseStatus BAD_REQUEST = newStatus(400, "Bad Request");
    public static final HttpResponseStatus UNAUTHORIZED = newStatus(TypedValues.CycleType.TYPE_CURVE_FIT, "Unauthorized");
    public static final HttpResponseStatus PAYMENT_REQUIRED = newStatus(TypedValues.CycleType.TYPE_VISIBILITY, "Payment Required");
    public static final HttpResponseStatus FORBIDDEN = newStatus(TypedValues.CycleType.TYPE_ALPHA, "Forbidden");
    public static final HttpResponseStatus NOT_FOUND = newStatus(404, "Not Found");
    public static final HttpResponseStatus METHOD_NOT_ALLOWED = newStatus(405, "Method Not Allowed");
    public static final HttpResponseStatus NOT_ACCEPTABLE = newStatus(406, "Not Acceptable");
    public static final HttpResponseStatus PROXY_AUTHENTICATION_REQUIRED = newStatus(407, "Proxy Authentication Required");
    public static final HttpResponseStatus REQUEST_TIMEOUT = newStatus(408, "Request Timeout");
    public static final HttpResponseStatus CONFLICT = newStatus(409, "Conflict");
    public static final HttpResponseStatus GONE = newStatus(410, "Gone");
    public static final HttpResponseStatus LENGTH_REQUIRED = newStatus(411, "Length Required");
    public static final HttpResponseStatus PRECONDITION_FAILED = newStatus(412, "Precondition Failed");
    public static final HttpResponseStatus REQUEST_ENTITY_TOO_LARGE = newStatus(413, "Request Entity Too Large");
    public static final HttpResponseStatus REQUEST_URI_TOO_LONG = newStatus(414, "Request-URI Too Long");
    public static final HttpResponseStatus UNSUPPORTED_MEDIA_TYPE = newStatus(415, "Unsupported Media Type");
    public static final HttpResponseStatus REQUESTED_RANGE_NOT_SATISFIABLE = newStatus(TypedValues.CycleType.TYPE_PATH_ROTATE, "Requested Range Not Satisfiable");
    public static final HttpResponseStatus EXPECTATION_FAILED = newStatus(417, "Expectation Failed");
    public static final HttpResponseStatus MISDIRECTED_REQUEST = newStatus(TypedValues.CycleType.TYPE_WAVE_SHAPE, "Misdirected Request");
    public static final HttpResponseStatus UNPROCESSABLE_ENTITY = newStatus(TypedValues.CycleType.TYPE_CUSTOM_WAVE_SHAPE, "Unprocessable Entity");
    public static final HttpResponseStatus LOCKED = newStatus(TypedValues.CycleType.TYPE_WAVE_PERIOD, "Locked");
    public static final HttpResponseStatus FAILED_DEPENDENCY = newStatus(TypedValues.CycleType.TYPE_WAVE_OFFSET, "Failed Dependency");
    public static final HttpResponseStatus UNORDERED_COLLECTION = newStatus(TypedValues.CycleType.TYPE_WAVE_PHASE, "Unordered Collection");
    public static final HttpResponseStatus UPGRADE_REQUIRED = newStatus(426, "Upgrade Required");
    public static final HttpResponseStatus PRECONDITION_REQUIRED = newStatus(428, "Precondition Required");
    public static final HttpResponseStatus TOO_MANY_REQUESTS = newStatus(429, "Too Many Requests");
    public static final HttpResponseStatus REQUEST_HEADER_FIELDS_TOO_LARGE = newStatus(431, "Request Header Fields Too Large");
    public static final HttpResponseStatus INTERNAL_SERVER_ERROR = newStatus(500, "Internal Server Error");
    public static final HttpResponseStatus NOT_IMPLEMENTED = newStatus(TypedValues.PositionType.TYPE_TRANSITION_EASING, "Not Implemented");
    public static final HttpResponseStatus BAD_GATEWAY = newStatus(TypedValues.PositionType.TYPE_DRAWPATH, "Bad Gateway");
    public static final HttpResponseStatus SERVICE_UNAVAILABLE = newStatus(TypedValues.PositionType.TYPE_PERCENT_WIDTH, "Service Unavailable");
    public static final HttpResponseStatus GATEWAY_TIMEOUT = newStatus(TypedValues.PositionType.TYPE_PERCENT_HEIGHT, "Gateway Timeout");
    public static final HttpResponseStatus HTTP_VERSION_NOT_SUPPORTED = newStatus(TypedValues.PositionType.TYPE_SIZE_PERCENT, "HTTP Version Not Supported");
    public static final HttpResponseStatus VARIANT_ALSO_NEGOTIATES = newStatus(TypedValues.PositionType.TYPE_PERCENT_X, "Variant Also Negotiates");
    public static final HttpResponseStatus INSUFFICIENT_STORAGE = newStatus(TypedValues.PositionType.TYPE_PERCENT_Y, "Insufficient Storage");
    public static final HttpResponseStatus NOT_EXTENDED = newStatus(TypedValues.PositionType.TYPE_POSITION_TYPE, "Not Extended");
    public static final HttpResponseStatus NETWORK_AUTHENTICATION_REQUIRED = newStatus(FrameMetricsAggregator.EVERY_DURATION, "Network Authentication Required");

    private static HttpResponseStatus newStatus(int i10, String str) {
        return new HttpResponseStatus(i10, str, true);
    }

    public int code() {
        return this.code;
    }

    public HttpStatusClass codeClass() {
        HttpStatusClass httpStatusClass = this.codeClass;
        if (httpStatusClass != null) {
            return httpStatusClass;
        }
        HttpStatusClass httpStatusClassValueOf = HttpStatusClass.valueOf(this.code);
        this.codeClass = httpStatusClassValueOf;
        return httpStatusClassValueOf;
    }

    @Override // java.lang.Comparable
    public int compareTo(HttpResponseStatus httpResponseStatus) {
        return code() - httpResponseStatus.code();
    }

    void encode(ByteBuf byteBuf) {
        byte[] bArr = this.bytes;
        if (bArr != null) {
            byteBuf.writeBytes(bArr);
            return;
        }
        ByteBufUtil.copy(this.codeAsText, byteBuf);
        byteBuf.writeByte(32);
        byteBuf.writeCharSequence(this.reasonPhrase, CharsetUtil.US_ASCII);
    }

    public boolean equals(Object obj) {
        return (obj instanceof HttpResponseStatus) && code() == ((HttpResponseStatus) obj).code();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(this.reasonPhrase.length() + 4);
        sb2.append((CharSequence) this.codeAsText);
        sb2.append(' ');
        sb2.append(this.reasonPhrase);
        return sb2.toString();
    }

    private HttpResponseStatus(int i10, String str, boolean z10) {
        ObjectUtil.checkPositiveOrZero(i10, "code");
        ObjectUtil.checkNotNull(str, "reasonPhrase");
        for (int i11 = 0; i11 < str.length(); i11++) {
            char cCharAt = str.charAt(i11);
            if (cCharAt == '\n' || cCharAt == '\r') {
                throw new IllegalArgumentException("reasonPhrase contains one of the following prohibited characters: \\r\\n: " + str);
            }
        }
        this.code = i10;
        String string = Integer.toString(i10);
        this.codeAsText = new AsciiString(string);
        this.reasonPhrase = str;
        if (z10) {
            this.bytes = (string + ' ' + str).getBytes(CharsetUtil.US_ASCII);
            return;
        }
        this.bytes = null;
    }

    public int hashCode() {
        return code();
    }
}
