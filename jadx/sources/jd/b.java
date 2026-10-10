package jd;

import com.pengrad.telegrambot.passport.decrypt.RsaOaep;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f11695e = new b("kyber512", 2, 128, false);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f11696f = new b("kyber768", 3, RsaOaep.DerParser.PRIVATE, false);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b f11697g = new b("kyber1024", 4, 256, false);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final b f11698h = new b("kyber512-aes", 2, 128, true);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final b f11699i = new b("kyber768-aes", 3, RsaOaep.DerParser.PRIVATE, true);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final b f11700j = new b("kyber1024-aes", 4, 256, true);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f11701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f11702b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f11703c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f11704d;

    private b(String str, int i10, int i11, boolean z10) {
        this.f11701a = str;
        this.f11702b = i10;
        this.f11703c = i11;
        this.f11704d = z10;
    }
}
