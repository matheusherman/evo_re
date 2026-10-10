package x1.f1.lb.util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.KeyGenerator;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\f\u0010\u000bR\u001c\u0010\u0011\u001a\n \u000e*\u0004\u0018\u00010\r0\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012¨\u0006\u0016"}, d2 = {"Lx1/f1/lb/util/a;", "", "<init>", "()V", "", "e", "()Ljava/lang/String;", "text", "", "isRandomKey", "c", "(Ljava/lang/String;Z)Ljava/lang/String;", "a", "Lq6/b;", "kotlin.jvm.PlatformType", "b", "Lq6/b;", "logger", "Ljava/lang/String;", "randomKey", "d", "fixedKey", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f21291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final q6.b logger;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static String randomKey;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static String fixedKey;

    static {
        a aVar = new a();
        f21291a = aVar;
        logger = q6.c.d(w6.a.class);
        randomKey = aVar.e();
        fixedKey = "PrI8TBSHDuybYmKSdaBBYg";
    }

    public static /* synthetic */ String b(a aVar, String str, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = true;
        }
        return aVar.a(str, z10);
    }

    public static /* synthetic */ String d(a aVar, String str, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = true;
        }
        return aVar.c(str, z10);
    }

    private final String e() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(256, new SecureRandom());
        return o0.f21433a.e(keyGenerator.generateKey().toString());
    }

    public final String a(String text, boolean isRandomKey) {
        kotlin.jvm.internal.m.f(text, "text");
        String strA = o0.f21433a.a(text, isRandomKey ? randomKey : fixedKey);
        return strA == null ? "" : strA;
    }

    public final String c(String text, boolean isRandomKey) {
        kotlin.jvm.internal.m.f(text, "text");
        String strC = o0.f21433a.c(text, isRandomKey ? randomKey : fixedKey);
        return strC == null ? "" : strC;
    }

    private a() {
    }
}
