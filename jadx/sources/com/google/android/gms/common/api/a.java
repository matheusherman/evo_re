package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.a.d;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class a<O extends d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AbstractC0042a f2163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g f2164b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f2165c;

    /* JADX INFO: renamed from: com.google.android.gms.common.api.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static abstract class AbstractC0042a<T extends f, O> extends e<T, O> {
        @NonNull
        public T b(@NonNull Context context, @NonNull Looper looper, @NonNull m1.c cVar, @NonNull O o10, @NonNull k1.d dVar, @NonNull k1.k kVar) {
            throw new UnsupportedOperationException("buildClient must be implemented");
        }

        @NonNull
        @Deprecated
        public T a(@NonNull Context context, @NonNull Looper looper, @NonNull m1.c cVar, @NonNull O o10, @NonNull com.google.android.gms.common.api.g.a aVar, @NonNull com.google.android.gms.common.api.g.b bVar) {
            return (T) b(context, looper, cVar, o10, aVar, bVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface b {
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class c<C extends b> {
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface d {

        /* JADX INFO: renamed from: com.google.android.gms.common.api.a$d$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        public interface InterfaceC0043a extends d {
            @NonNull
            Account w();
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        public interface b extends d {
            @Nullable
            GoogleSignInAccount r();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @VisibleForTesting
    public static abstract class e<T extends b, O> {
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface f extends b {
        @NonNull
        Set<Scope> a();

        void b(@Nullable com.google.android.gms.common.internal.e eVar, @Nullable Set<Scope> set);

        void c(@NonNull String str);

        boolean d();

        void disconnect();

        @NonNull
        String e();

        void f(@NonNull com.google.android.gms.common.internal.b.c cVar);

        void g(@NonNull com.google.android.gms.common.internal.b.e eVar);

        boolean i();

        boolean isConnected();

        int j();

        @NonNull
        Feature[] k();

        @Nullable
        String l();

        boolean m();
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class g<C extends f> extends c<C> {
    }

    @NonNull
    public final AbstractC0042a a() {
        return this.f2163a;
    }

    @NonNull
    public final String b() {
        return this.f2165c;
    }

    public <C extends f> a(@NonNull String str, @NonNull AbstractC0042a<C, O> abstractC0042a, @NonNull g<C> gVar) {
        m1.g.l(abstractC0042a, "Cannot construct an Api with a null ClientBuilder");
        m1.g.l(gVar, "Cannot construct an Api with a null ClientKey");
        this.f2165c = str;
        this.f2163a = abstractC0042a;
        this.f2164b = gVar;
    }
}
