package x4;

import com.blankj.utilcode.util.u;
import com.live.evo.util.o1;
import com.live.evo.util.s0;
import i5.p;
import java.text.SimpleDateFormat;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\r\u001a\u001a\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u0011\u001a\u0004\u0018\u00010\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0014R\u001c\u0010\u0019\u001a\n \u0017*\u0004\u0018\u00010\u00160\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0018¨\u0006\u001a"}, d2 = {"Lx4/g;", "", "<init>", "()V", "", "timeMillis", "", "c", "(J)Ljava/lang/String;", "channelId", "Lcom/blankj/utilcode/util/u$c;", "Lkotlinx/coroutines/flow/f;", "Lx4/c;", "b", "(Ljava/lang/String;)Lcom/blankj/utilcode/util/u$c;", "Li5/p;", "epgBean", "a", "(Li5/p;Ljava/lang/String;)Lx4/c;", "Ljava/text/SimpleDateFormat;", "Ljava/text/SimpleDateFormat;", "sdf", "Lq6/b;", "kotlin.jvm.PlatformType", "Lq6/b;", "logger", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f21834a;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final SimpleDateFormat sdf;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final q6.b logger;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u001a\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001¨\u0006\u0004"}, d2 = {"x4/g$a", "Lcom/blankj/utilcode/util/u$c;", "Lkotlinx/coroutines/flow/f;", "Lx4/c;", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a implements u.c<kotlinx.coroutines.flow.f<? extends c>, c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f21837a;

        a(String str) {
            this.f21837a = str;
        }
    }

    static {
        g gVar = new g();
        f21834a = gVar;
        SimpleDateFormat simpleDateFormatA = o1.a("HH:mm");
        m.e(simpleDateFormatA, "getSimpleDateFormat(...)");
        sdf = simpleDateFormatA;
        logger = q6.c.d(gVar.getClass());
    }

    public final c a(p epgBean, String channelId) {
        if (epgBean == null) {
            return null;
        }
        c cVar = new c();
        cVar.k(epgBean.f().longValue());
        cVar.r(epgBean.g().longValue());
        cVar.q(epgBean.e());
        cVar.p(epgBean.a());
        i5.h hVarS = s0.f7342a.s(channelId);
        if (hVarS != null) {
            cVar.l(channelId);
            cVar.s(epgBean.b());
            cVar.n(hVarS.a());
            cVar.t(hVarS.g());
            cVar.n(hVarS.e());
            cVar.o(hVarS.i());
            cVar.m(channelId);
        }
        return cVar;
    }

    public final u.c<kotlinx.coroutines.flow.f<c>, c> b(String channelId) {
        return new a(channelId);
    }

    public final String c(long timeMillis) {
        String str = sdf.format(new Date(timeMillis));
        m.e(str, "format(...)");
        return str;
    }

    private g() {
    }
}
