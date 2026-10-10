package x4;

import android.content.Context;
import com.live.evo.R$string;
import com.live.evo.activity.CatchUpPlayerActivity;
import com.live.evo.util.r1;
import com.live.evo.util.s0;
import com.live.evo.util.u1;
import i5.p;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J=\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u00062\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lx4/d;", "Lx4/a;", "Landroid/content/Context;", "mContext", "<init>", "(Landroid/content/Context;)V", "", "catchupType", "Li5/p;", "epgBean", "channelId", "Lx1/f1/lb/util/m;", "", "callback", "Lr8/z;", "a", "(Ljava/lang/String;Li5/p;Ljava/lang/String;Lx1/f1/lb/util/m;)V", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class d implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Context mContext;

    public d(Context mContext) {
        m.f(mContext, "mContext");
        this.mContext = mContext;
    }

    @Override // x4.a
    public void a(String catchupType, p epgBean, String channelId, x1.f1.lb.util.m<Boolean> callback) {
        m.f(callback, "callback");
        if (epgBean == null || epgBean.g().longValue() <= epgBean.f().longValue() || epgBean.g().longValue() > u1.b().a()) {
            callback.a(Boolean.FALSE);
            return;
        }
        if (!s0.f7342a.M(epgBean.b(), channelId, epgBean.f())) {
            r1.a(this.mContext, R$string.playback_not_supported);
            callback.a(Boolean.FALSE);
            return;
        }
        CatchUpPlayerActivity.Companion companion = CatchUpPlayerActivity.INSTANCE;
        Context context = this.mContext;
        g gVar = g.f21834a;
        companion.a(context, channelId, catchupType, gVar.a(epgBean, channelId), gVar.b(channelId));
        callback.a(Boolean.TRUE);
    }
}
