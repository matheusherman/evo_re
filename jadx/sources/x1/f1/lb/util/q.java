package x1.f1.lb.util;

import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u0014\u001a\u00020\u00132\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\n\u0010\u0012\u001a\u00060\u0010j\u0002`\u0011¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lx1/f1/lb/util/q;", "", "<init>", "()V", "", "idx", "", "b", "(I)Ljava/lang/String;", "", "t", "d", "(Ljava/lang/Throwable;)Ljava/lang/String;", "", "Ljava/lang/StackTraceElement;", "stackTraceElements", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "builder", "Lr8/z;", "a", "([Ljava/lang/StackTraceElement;Ljava/lang/StringBuilder;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f21441a = new q();

    public static /* synthetic */ String c(q qVar, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 2;
        }
        return qVar.b(i10);
    }

    public final void a(StackTraceElement[] stackTraceElements, StringBuilder builder) {
        kotlin.jvm.internal.m.f(stackTraceElements, "stackTraceElements");
        kotlin.jvm.internal.m.f(builder, "builder");
        for (StackTraceElement stackTraceElement : stackTraceElements) {
            builder.append(stackTraceElement.getClassName());
            builder.append(".");
            builder.append(stackTraceElement.getMethodName());
            builder.append("(");
            builder.append(stackTraceElement.getFileName());
            builder.append(":");
            builder.append(stackTraceElement.getLineNumber());
            builder.append(")\n");
        }
    }

    public final String b(int idx) {
        StackTraceElement[] stackTrace = new Exception().getStackTrace();
        if (stackTrace.length <= idx + 1) {
            return "";
        }
        StackTraceElement stackTraceElement = stackTrace[idx];
        return stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + "()@" + stackTraceElement.getLineNumber() + ":" + stackTraceElement.getFileName();
    }

    public final String d(Throwable t10) {
        kotlin.jvm.internal.m.f(t10, "t");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(t10.getClass().getCanonicalName());
        sb2.append(":");
        sb2.append(t10.getMessage());
        sb2.append("\n");
        StackTraceElement[] stackTrace = t10.getStackTrace();
        kotlin.jvm.internal.m.e(stackTrace, "getStackTrace(...)");
        a(stackTrace, sb2);
        String string = sb2.toString();
        kotlin.jvm.internal.m.e(string, "toString(...)");
        return string;
    }

    private q() {
    }
}
