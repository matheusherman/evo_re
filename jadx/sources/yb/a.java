package yb;

import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Deprecated
    public static final Charset f22544a = Charset.forName("ISO-8859-1");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Deprecated
    public static final Charset f22545b = Charset.forName("US-ASCII");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Deprecated
    public static final Charset f22546c = Charset.forName("UTF-16");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Deprecated
    public static final Charset f22547d = Charset.forName("UTF-16BE");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Deprecated
    public static final Charset f22548e = Charset.forName("UTF-16LE");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Deprecated
    public static final Charset f22549f = Charset.forName("UTF-8");

    public static Charset a(Charset charset) {
        return charset == null ? Charset.defaultCharset() : charset;
    }
}
