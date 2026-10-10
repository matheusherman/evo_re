package com.bumptech.glide.integration.okhttp3;

import androidx.annotation.NonNull;
import j.i;
import java.io.InputStream;
import okhttp3.e;
import okhttp3.z;
import p.h;
import p.o;
import p.p;
import p.s;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class a implements o<h, InputStream> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e.a f1335a;

    /* JADX INFO: renamed from: com.bumptech.glide.integration.okhttp3.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class C0036a implements p<h, InputStream> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static volatile e.a f1336b;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final e.a f1337a;

        public C0036a() {
            this(a());
        }

        public C0036a(@NonNull e.a aVar) {
            this.f1337a = aVar;
        }

        private static e.a a() {
            if (f1336b == null) {
                synchronized (C0036a.class) {
                    try {
                        if (f1336b == null) {
                            f1336b = new z();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return f1336b;
        }

        @Override // p.p
        @NonNull
        public o<h, InputStream> c(s sVar) {
            return new a(this.f1337a);
        }

        @Override // p.p
        public void d() {
        }
    }

    @Override // p.o
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull h hVar) {
        return true;
    }

    @Override // p.o
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public o.a<InputStream> b(@NonNull h hVar, int i10, int i11, @NonNull i iVar) {
        return new o.a<>(hVar, new i.a(this.f1335a, hVar));
    }

    public a(@NonNull e.a aVar) {
        this.f1335a = aVar;
    }
}
