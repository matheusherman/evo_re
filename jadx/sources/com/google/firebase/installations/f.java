package com.google.firebase.installations;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f4783b = TimeUnit.HOURS.toSeconds(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Pattern f4784c = Pattern.compile("\\AA[\\w-]{38}\\z");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static f f4785d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final w2.a f4786a;

    public static f d(w2.a aVar) {
        if (f4785d == null) {
            f4785d = new f(aVar);
        }
        return f4785d;
    }

    static boolean g(@Nullable String str) {
        return f4784c.matcher(str).matches();
    }

    static boolean h(@Nullable String str) {
        return str.contains(":");
    }

    public long a() {
        return this.f4786a.a();
    }

    public long b() {
        return TimeUnit.MILLISECONDS.toSeconds(a());
    }

    private f(w2.a aVar) {
        this.f4786a = aVar;
    }

    public static f c() {
        return d(w2.b.b());
    }

    public long e() {
        return (long) (Math.random() * 1000.0d);
    }

    public boolean f(@NonNull u2.d dVar) {
        if (TextUtils.isEmpty(dVar.b()) || dVar.h() + dVar.c() < b() + f4783b) {
            return true;
        }
        return false;
    }
}
