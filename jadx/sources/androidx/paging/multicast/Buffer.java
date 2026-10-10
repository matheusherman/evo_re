package androidx.paging.multicast;

import androidx.exifinterface.media.ExifInterface;
import java.util.Collection;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0004\bb\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nR \u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u000b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Landroidx/paging/multicast/Buffer;", ExifInterface.GPS_DIRECTION_TRUE, "", "Landroidx/paging/multicast/ChannelManager$Message$Dispatch$Value;", "item", "Lr8/z;", "add", "(Landroidx/paging/multicast/ChannelManager$Message$Dispatch$Value;)V", "", "isEmpty", "()Z", "", "getItems", "()Ljava/util/Collection;", "items", "paging-common"}, k = 1, mv = {1, 4, 1})
interface Buffer<T> {
    void add(ChannelManager.Message.Dispatch.Value<T> item);

    Collection<ChannelManager.Message.Dispatch.Value<T>> getItems();

    boolean isEmpty();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    public static final class DefaultImpls {
        public static <T> boolean isEmpty(Buffer<T> buffer) {
            return buffer.getItems().isEmpty();
        }
    }
}
