package com.skydoves.sandwich;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.FrameMetricsAggregator;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\bB\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u0007j\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b\u0006j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8j\u0002\b9j\u0002\b:j\u0002\b;j\u0002\b<j\u0002\b=j\u0002\b>j\u0002\b?j\u0002\b@j\u0002\bAj\u0002\bBj\u0002\bC¨\u0006D"}, d2 = {"Lcom/skydoves/sandwich/e;", "", "", "code", "<init>", "(Ljava/lang/String;II)V", "I", "f", "()I", "a", "b", "c", "d", "e", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "H", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, "X", "Y", "Z", "b1", "D1", "E1", "F1", "G1", "H1", "I1", "J1", "K1", "sandwich"}, k = 1, mv = {1, 8, 0}, xi = 48)
public enum e {
    Unknown(0),
    Continue(100),
    SwitchingProtocols(101),
    Processing(102),
    EarlyHints(103),
    OK(200),
    Created(201),
    Accepted(202),
    NonAuthoritative(203),
    NoContent(204),
    ResetContent(205),
    PartialContent(206),
    MultiStatus(207),
    AlreadyReported(208),
    IMUsed(209),
    MultipleChoices(300),
    MovePermanently(301),
    Found(302),
    SeeOther(303),
    NotModified(304),
    UseProxy(305),
    SwitchProxy(306),
    TemporaryRedirect(307),
    PermanentRedirect(308),
    BadRequest(400),
    Unauthorized(TypedValues.CycleType.TYPE_CURVE_FIT),
    PaymentRequired(TypedValues.CycleType.TYPE_VISIBILITY),
    Forbidden(TypedValues.CycleType.TYPE_ALPHA),
    NotFound(404),
    MethodNotAllowed(405),
    NotAcceptable(406),
    ProxyAuthenticationRequired(407),
    RequestTimeout(408),
    Conflict(409),
    Gone(410),
    LengthRequired(411),
    PreconditionFailed(412),
    PayloadTooLarge(413),
    URITooLong(414),
    UnsupportedMediaType(415),
    RangeNotSatisfiable(TypedValues.CycleType.TYPE_PATH_ROTATE),
    ExpectationFailed(417),
    IMATeapot(418),
    MisdirectedRequest(TypedValues.CycleType.TYPE_WAVE_SHAPE),
    UnProcessableEntity(TypedValues.CycleType.TYPE_CUSTOM_WAVE_SHAPE),
    Locked(TypedValues.CycleType.TYPE_WAVE_PERIOD),
    FailedDependency(TypedValues.CycleType.TYPE_WAVE_OFFSET),
    TooEarly(TypedValues.CycleType.TYPE_WAVE_PHASE),
    UpgradeRequired(426),
    PreconditionRequired(428),
    TooManyRequests(429),
    RequestHeaderFieldsTooLarge(431),
    UnavailableForLegalReasons(451),
    InternalServerError(500),
    NotImplemented(TypedValues.PositionType.TYPE_TRANSITION_EASING),
    BadGateway(TypedValues.PositionType.TYPE_DRAWPATH),
    ServiceUnavailable(TypedValues.PositionType.TYPE_PERCENT_WIDTH),
    GatewayTimeout(TypedValues.PositionType.TYPE_PERCENT_HEIGHT),
    HTTPVersionNotSupported(TypedValues.PositionType.TYPE_SIZE_PERCENT),
    NotExtended(TypedValues.PositionType.TYPE_POSITION_TYPE),
    NetworkAuthenticationRequired(FrameMetricsAggregator.EVERY_DURATION);

    private final int code;

    /* JADX INFO: renamed from: f, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    e(int i10) {
        this.code = i10;
    }
}
