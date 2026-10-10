package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.n0;
import kotlin.collections.v0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ba.c f13139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ba.c f13140b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ba.c f13141c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ba.c f13142d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ba.c f13143e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ba.c f13144f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final List<ba.c> f13145g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final ba.c f13146h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final ba.c f13147i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final List<ba.c> f13148j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final ba.c f13149k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final ba.c f13150l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final ba.c f13151m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final ba.c f13152n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final Set<ba.c> f13153o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final Set<ba.c> f13154p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final Set<ba.c> f13155q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final Map<ba.c, ba.c> f13156r;

    static {
        ba.c cVar = new ba.c("org.jspecify.nullness.Nullable");
        f13139a = cVar;
        f13140b = new ba.c("org.jspecify.nullness.NullnessUnspecified");
        ba.c cVar2 = new ba.c("org.jspecify.nullness.NullMarked");
        f13141c = cVar2;
        ba.c cVar3 = new ba.c("org.jspecify.annotations.Nullable");
        f13142d = cVar3;
        f13143e = new ba.c("org.jspecify.annotations.NullnessUnspecified");
        ba.c cVar4 = new ba.c("org.jspecify.annotations.NullMarked");
        f13144f = cVar4;
        List<ba.c> listO = kotlin.collections.r.o(b0.f13120l, new ba.c("androidx.annotation.Nullable"), new ba.c("androidx.annotation.Nullable"), new ba.c("android.annotation.Nullable"), new ba.c("com.android.annotations.Nullable"), new ba.c("org.eclipse.jdt.annotation.Nullable"), new ba.c("org.checkerframework.checker.nullness.qual.Nullable"), new ba.c("javax.annotation.Nullable"), new ba.c("javax.annotation.CheckForNull"), new ba.c("edu.umd.cs.findbugs.annotations.CheckForNull"), new ba.c("edu.umd.cs.findbugs.annotations.Nullable"), new ba.c("edu.umd.cs.findbugs.annotations.PossiblyNull"), new ba.c("io.reactivex.annotations.Nullable"), new ba.c("io.reactivex.rxjava3.annotations.Nullable"));
        f13145g = listO;
        ba.c cVar5 = new ba.c("javax.annotation.Nonnull");
        f13146h = cVar5;
        f13147i = new ba.c("javax.annotation.CheckForNull");
        List<ba.c> listO2 = kotlin.collections.r.o(b0.f13119k, new ba.c("edu.umd.cs.findbugs.annotations.NonNull"), new ba.c("androidx.annotation.NonNull"), new ba.c("androidx.annotation.NonNull"), new ba.c("android.annotation.NonNull"), new ba.c("com.android.annotations.NonNull"), new ba.c("org.eclipse.jdt.annotation.NonNull"), new ba.c("org.checkerframework.checker.nullness.qual.NonNull"), new ba.c("lombok.NonNull"), new ba.c("io.reactivex.annotations.NonNull"), new ba.c("io.reactivex.rxjava3.annotations.NonNull"));
        f13148j = listO2;
        ba.c cVar6 = new ba.c("org.checkerframework.checker.nullness.compatqual.NullableDecl");
        f13149k = cVar6;
        ba.c cVar7 = new ba.c("org.checkerframework.checker.nullness.compatqual.NonNullDecl");
        f13150l = cVar7;
        ba.c cVar8 = new ba.c("androidx.annotation.RecentlyNullable");
        f13151m = cVar8;
        ba.c cVar9 = new ba.c("androidx.annotation.RecentlyNonNull");
        f13152n = cVar9;
        f13153o = v0.l(v0.l(v0.l(v0.l(v0.l(v0.l(v0.l(v0.l(v0.k(v0.l(v0.k(new LinkedHashSet(), listO), cVar5), listO2), cVar6), cVar7), cVar8), cVar9), cVar), cVar2), cVar3), cVar4);
        f13154p = v0.h(b0.f13122n, b0.f13123o);
        f13155q = v0.h(b0.f13121m, b0.f13124p);
        f13156r = n0.l(r8.v.a(b0.f13112d, kotlin.reflect.jvm.internal.impl.builtins.k.a.H), r8.v.a(b0.f13114f, kotlin.reflect.jvm.internal.impl.builtins.k.a.L), r8.v.a(b0.f13116h, kotlin.reflect.jvm.internal.impl.builtins.k.a.f12646y), r8.v.a(b0.f13117i, kotlin.reflect.jvm.internal.impl.builtins.k.a.P));
    }

    public static final ba.c a() {
        return f13152n;
    }

    public static final ba.c b() {
        return f13151m;
    }

    public static final ba.c c() {
        return f13150l;
    }

    public static final ba.c d() {
        return f13149k;
    }

    public static final ba.c e() {
        return f13147i;
    }

    public static final ba.c f() {
        return f13146h;
    }

    public static final ba.c g() {
        return f13142d;
    }

    public static final ba.c h() {
        return f13143e;
    }

    public static final ba.c i() {
        return f13144f;
    }

    public static final ba.c j() {
        return f13139a;
    }

    public static final ba.c k() {
        return f13140b;
    }

    public static final ba.c l() {
        return f13141c;
    }

    public static final Set<ba.c> m() {
        return f13155q;
    }

    public static final List<ba.c> n() {
        return f13148j;
    }

    public static final List<ba.c> o() {
        return f13145g;
    }

    public static final Set<ba.c> p() {
        return f13154p;
    }
}
