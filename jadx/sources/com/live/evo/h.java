package com.live.evo;

import androidx.exifinterface.media.ExifInterface;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class h {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static h f6969p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, Boolean> f6970a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f6971b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f6972c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f6973d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f6974e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f6975f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f6976g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f6977h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f6978i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f6979j = true;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f6980k = true;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f6981l = false;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f6982m = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f6983n = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f6984o = true;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public enum a {
        PRODUCT_FEATURE_SEARCH("1"),
        PRODUCT_FEATURE_FAV(ExifInterface.GPS_MEASUREMENT_2D),
        PRODUCT_FEATURE_SUBSCRIBE(ExifInterface.GPS_MEASUREMENT_3D),
        PRODUCT_FEATURE_INFO("4"),
        PRODUCT_FEATURE_FEEDBACK("5"),
        PRODUCT_FEATURE_CHANNEL_LOCK("6"),
        PRODUCT_FEATURE_EPG_FEATURE("7"),
        PRODUCT_FEATURE_PIP("8"),
        PRODUCT_FEATURE_HISTORY("9"),
        PRODUCT_FEATURE_NOTIFICATION("10"),
        PRODUCT_FEATURE_SUBJECT("11"),
        PRODUCT_FEATURE_KIDSMODE("12"),
        PRODUCT_FEATURE_VOD("13"),
        PRODUCT_FEATURE_TOPX("15");

        private String name;

        public String f() {
            return this.name;
        }

        a(String str) {
            this.name = str;
        }
    }

    private boolean a(String str, boolean z10) {
        Boolean bool;
        Map<String, Boolean> map = this.f6970a;
        return (map == null || map.isEmpty() || (bool = this.f6970a.get(str)) == null) ? z10 : bool.booleanValue();
    }

    public static h b() {
        if (f6969p == null) {
            synchronized (h.class) {
                try {
                    if (f6969p == null) {
                        f6969p = new h();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f6969p;
    }

    private void c() {
        this.f6971b = a(a.PRODUCT_FEATURE_PIP.f(), false);
        this.f6972c = a(a.PRODUCT_FEATURE_FAV.f(), true);
        this.f6973d = a(a.PRODUCT_FEATURE_CHANNEL_LOCK.f(), false);
        this.f6974e = a(a.PRODUCT_FEATURE_SUBSCRIBE.f(), true);
        this.f6975f = a(a.PRODUCT_FEATURE_SEARCH.f(), true);
        this.f6978i = a(a.PRODUCT_FEATURE_EPG_FEATURE.f(), true);
        this.f6977h = a(a.PRODUCT_FEATURE_FEEDBACK.f(), true);
        this.f6976g = a(a.PRODUCT_FEATURE_INFO.f(), true);
        this.f6979j = a(a.PRODUCT_FEATURE_HISTORY.f(), true);
        this.f6980k = a(a.PRODUCT_FEATURE_NOTIFICATION.f(), true);
        this.f6981l = a(a.PRODUCT_FEATURE_SUBJECT.f(), false);
        this.f6982m = a(a.PRODUCT_FEATURE_KIDSMODE.f(), true);
        this.f6983n = a(a.PRODUCT_FEATURE_TOPX.f(), true);
        this.f6984o = a(a.PRODUCT_FEATURE_VOD.f(), false);
    }

    public boolean d() {
        return this.f6978i;
    }

    private h() {
        c();
    }
}
