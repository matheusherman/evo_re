package androidx.paging.multicast;

import androidx.exifinterface.media.ExifInterface;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR \u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Landroidx/paging/multicast/NoBuffer;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/paging/multicast/Buffer;", "<init>", "()V", "Landroidx/paging/multicast/ChannelManager$Message$Dispatch$Value;", "item", "Lr8/z;", "add", "(Landroidx/paging/multicast/ChannelManager$Message$Dispatch$Value;)V", "", "getItems", "()Ljava/util/Collection;", "items", "paging-common"}, k = 1, mv = {1, 4, 1})
final class NoBuffer<T> implements Buffer<T> {
    @Override // androidx.paging.multicast.Buffer
    public void add(ChannelManager.Message.Dispatch.Value<T> item) {
        m.f(item, "item");
    }

    @Override // androidx.paging.multicast.Buffer
    public Collection<ChannelManager.Message.Dispatch.Value<T>> getItems() {
        List list = Collections.EMPTY_LIST;
        m.e(list, "Collections.emptyList()");
        return list;
    }

    @Override // androidx.paging.multicast.Buffer
    public boolean isEmpty() {
        return Buffer.DefaultImpls.isEmpty(this);
    }
}
