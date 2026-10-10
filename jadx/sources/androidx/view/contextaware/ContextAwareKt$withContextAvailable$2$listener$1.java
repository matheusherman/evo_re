package androidx.view.contextaware;

import android.content.Context;
import c9.l;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.n;
import org.apache.log4j.net.SyslogAppender;
import r8.q;
import r8.r;
import v8.f;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"androidx/activity/contextaware/ContextAwareKt$withContextAvailable$2$listener$1", "Landroidx/activity/contextaware/OnContextAvailableListener;", "Landroid/content/Context;", "context", "Lr8/z;", "onContextAvailable", "(Landroid/content/Context;)V", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = SyslogAppender.LOG_LOCAL6)
public final class ContextAwareKt$withContextAvailable$2$listener$1 implements OnContextAvailableListener {
    final /* synthetic */ n<R> $co;
    final /* synthetic */ l<Context, R> $onContextAvailable;

    public ContextAwareKt$withContextAvailable$2$listener$1(n<R> nVar, l<Context, R> lVar) {
        this.$co = nVar;
        this.$onContextAvailable = lVar;
    }

    @Override // androidx.view.contextaware.OnContextAvailableListener
    public void onContextAvailable(Context context) {
        Object objA;
        m.f(context, "context");
        f fVar = this.$co;
        l<Context, R> lVar = this.$onContextAvailable;
        try {
            q.Companion companion = q.INSTANCE;
            objA = q.a(lVar.invoke(context));
        } catch (Throwable th) {
            q.Companion companion2 = q.INSTANCE;
            objA = q.a(r.a(th));
        }
        fVar.resumeWith(objA);
    }
}
