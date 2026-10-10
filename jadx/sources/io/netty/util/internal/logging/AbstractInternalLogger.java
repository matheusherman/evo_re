package io.netty.util.internal.logging;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class AbstractInternalLogger implements InternalLogger, Serializable {
    private static final long serialVersionUID = -6382972526573193470L;
    private final String name;

    public String name() {
        return this.name;
    }

    public String toString() {
        return StringUtil.simpleClassName(this) + '(' + name() + ')';
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void warn(Throwable th) {
        warn("Unexpected exception:", th);
    }

    protected AbstractInternalLogger(String str) {
        this.name = (String) ObjectUtil.checkNotNull(str, "name");
    }

    protected Object readResolve() {
        return InternalLoggerFactory.getInstance(name());
    }
}
