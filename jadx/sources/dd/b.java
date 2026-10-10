package dd;

import java.security.Permission;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import zc.c;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
class b implements zc.b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Permission f9760e = new c("BC", "threadLocalEcImplicitlyCa");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Permission f9761f = new c("BC", "ecImplicitlyCa");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static Permission f9762g = new c("BC", "threadLocalDhDefaultParams");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static Permission f9763h = new c("BC", "DhDefaultParams");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static Permission f9764i = new c("BC", "acceptableEcCurves");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static Permission f9765j = new c("BC", "additionalEcParameters");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ThreadLocal f9766a = new ThreadLocal();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ThreadLocal f9767b = new ThreadLocal();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile Set f9768c = new HashSet();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile Map f9769d = new HashMap();

    b() {
    }
}
