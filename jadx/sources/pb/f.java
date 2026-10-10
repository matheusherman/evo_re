package pb;

import java.util.logging.Handler;
import java.util.logging.LogRecord;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\u0003¨\u0006\u000b"}, d2 = {"Lpb/f;", "Ljava/util/logging/Handler;", "<init>", "()V", "Ljava/util/logging/LogRecord;", "record", "Lr8/z;", "publish", "(Ljava/util/logging/LogRecord;)V", "flush", "close", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class f extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f17467a = new f();

    @Override // java.util.logging.Handler
    public void publish(LogRecord record) {
        kotlin.jvm.internal.m.f(record, "record");
        e eVar = e.f17464a;
        String loggerName = record.getLoggerName();
        kotlin.jvm.internal.m.e(loggerName, "record.loggerName");
        int iB = g.b(record);
        String message = record.getMessage();
        kotlin.jvm.internal.m.e(message, "record.message");
        eVar.a(loggerName, iB, message, record.getThrown());
    }

    private f() {
    }

    @Override // java.util.logging.Handler
    public void close() {
    }

    @Override // java.util.logging.Handler
    public void flush() {
    }
}
