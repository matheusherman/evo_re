package androidx.paging.multicast;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001a\u0018\u0010\u0005\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0007H\u0000¨\u0006\b"}, d2 = {"Buffer", "Landroidx/paging/multicast/Buffer;", ExifInterface.GPS_DIRECTION_TRUE, "limit", "", "markDelivered", "", "Landroidx/paging/multicast/ChannelManager$Message$Dispatch$Value;", "paging-common"}, k = 2, mv = {1, 4, 1})
public final class ChannelManagerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> Buffer<T> Buffer(int i10) {
        return i10 > 0 ? new BufferImpl(i10) : new NoBuffer();
    }

    public static final <T> boolean markDelivered(ChannelManager.Message.Dispatch.Value<T> markDelivered) {
        m.f(markDelivered, "$this$markDelivered");
        return markDelivered.getDelivered().r(z.f17874a);
    }
}
