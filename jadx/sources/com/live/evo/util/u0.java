package com.live.evo.util;

import com.franmontiel.persistentcookiejar.PersistentCookieJar;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;
import com.live.evo.MyApplication;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class u0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static u0 f7365b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private okhttp3.z f7366a;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements okhttp3.w {
        a() {
        }

        @Override // okhttp3.w
        public okhttp3.d0 a(okhttp3.w.a aVar) {
            okhttp3.b0.a aVarA = aVar.getRequest().h().a("GetServerTime", "true").a("ClientTimeMS", Long.toString(x1.f1.lb.util.d1.d()));
            of.a aVar2 = of.a.f16585a;
            return aVar.a(aVarA.a("VnoId", Long.toString(aVar2.h())).a("BrandId", Long.toString(aVar2.d())).a("AppId", Long.toString(aVar2.a())).a("VersionCode", Long.toString(aVar2.i())).a("MAC", aVar2.e()).a("CPUSerial", aVar2.j()).a("UserId", u0.this.d()).b());
        }
    }

    public static u0 b() {
        if (f7365b == null) {
            synchronized (u0.class) {
                try {
                    if (f7365b == null) {
                        f7365b = new u0();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f7365b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String d() {
        return t.v.c.i.a.f18646a.Y();
    }

    public okhttp3.z c() {
        return this.f7366a;
    }

    private u0() {
        new sb.a().e(sb.a.EnumC0360a.BODY);
        okhttp3.z.a aVarH = new okhttp3.z.a().a(new a()).h(h5.a.f10843f);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        this.f7366a = aVarH.P(15000L, timeUnit).d(15000L, timeUnit).b(new f5.a()).g(new mf.b()).f(new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(MyApplication.a()))).c();
    }
}
