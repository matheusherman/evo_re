package gd;

import com.pengrad.telegrambot.passport.decrypt.RsaOaep;
import com.taobao.sophix.PatchStatus;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final c f10670j = new c("bike128", 12323, 142, PatchStatus.CODE_LOAD_LIB_LOST, 256, 5, 3, 128);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final c f10671k = new c("bike192", 24659, 206, 199, 256, 5, 3, RsaOaep.DerParser.PRIVATE);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final c f10672l = new c("bike256", 40973, 274, 264, 256, 5, 3, 256);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f10673a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f10674b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f10675c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f10676d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f10677e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f10678f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f10679g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f10680h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private a f10681i;

    public int a() {
        return (this.f10674b + 7) / 8;
    }

    private c(String str, int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        this.f10673a = str;
        this.f10674b = i10;
        this.f10675c = i11;
        this.f10676d = i12;
        this.f10677e = i13;
        this.f10678f = i14;
        this.f10679g = i15;
        this.f10680h = i16;
        this.f10681i = new a(i10, i11, i12, i13, i14, i15);
    }
}
