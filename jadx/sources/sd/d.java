package sd;

import com.pengrad.telegrambot.passport.decrypt.RsaOaep;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d f18617e = new d("lightsaberkem128r3", 2, 128);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final d f18618f = new d("saberkem128r3", 3, 128);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final d f18619g = new d("firesaberkem128r3", 4, 128);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final d f18620h = new d("lightsaberkem192r3", 2, RsaOaep.DerParser.PRIVATE);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final d f18621i = new d("saberkem192r3", 3, RsaOaep.DerParser.PRIVATE);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final d f18622j = new d("firesaberkem192r3", 4, RsaOaep.DerParser.PRIVATE);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final d f18623k = new d("lightsaberkem256r3", 2, 256);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final d f18624l = new d("saberkem256r3", 3, 256);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final d f18625m = new d("firesaberkem256r3", 4, 256);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f18626a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f18627b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f18628c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final b f18629d;

    public d(String str, int i10, int i11) {
        this.f18626a = str;
        this.f18627b = i10;
        this.f18628c = i11;
        this.f18629d = new b(i10, i11);
    }
}
