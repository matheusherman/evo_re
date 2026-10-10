package com.tvc.lib.mobile.ext;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import u7.MessageEventData;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0004\u001a\u00020\u0001*\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0004\u0010\u0003\u001a-\u0010\n\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"", "Lr8/z;", "c", "(Ljava/lang/Object;)V", "d", "", "code", "", NotificationCompat.CATEGORY_MESSAGE, "data", "a", "(ILjava/lang/String;Ljava/lang/Object;)V", "tvclib_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class f {
    public static /* synthetic */ void b(int i10, String str, Object obj, int i11, Object obj2) {
        if ((i11 & 2) != 0) {
            str = null;
        }
        if ((i11 & 4) != 0) {
            obj = null;
        }
        a(i10, str, obj);
    }

    public static final void a(int i10, String str, Object obj) {
        xe.c.c().l(new MessageEventData(i10, str, obj));
    }

    public static final void c(Object obj) {
        if (!xe.c.c().j(obj)) {
            xe.c.c().q(obj);
        }
    }

    public static final void d(Object obj) {
        if (xe.c.c().j(obj)) {
            xe.c.c().u(obj);
        }
    }
}
