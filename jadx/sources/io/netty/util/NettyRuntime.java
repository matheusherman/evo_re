package io.netty.util;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.SystemPropertyUtil;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class NettyRuntime {
    private static final AvailableProcessorsHolder holder = new AvailableProcessorsHolder();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class AvailableProcessorsHolder {
        private int availableProcessors;

        synchronized int availableProcessors() {
            try {
                if (this.availableProcessors == 0) {
                    setAvailableProcessors(SystemPropertyUtil.getInt("io.netty.availableProcessors", Runtime.getRuntime().availableProcessors()));
                }
            } catch (Throwable th) {
                throw th;
            }
            return this.availableProcessors;
        }

        synchronized void setAvailableProcessors(int i10) {
            ObjectUtil.checkPositive(i10, "availableProcessors");
            int i11 = this.availableProcessors;
            if (i11 != 0) {
                throw new IllegalStateException(String.format(Locale.ROOT, "availableProcessors is already set to [%d], rejecting [%d]", Integer.valueOf(i11), Integer.valueOf(i10)));
            }
            this.availableProcessors = i10;
        }

        AvailableProcessorsHolder() {
        }
    }

    public static int availableProcessors() {
        return holder.availableProcessors();
    }
}
