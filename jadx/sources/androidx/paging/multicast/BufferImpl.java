package androidx.paging.multicast;

import androidx.exifinterface.media.ExifInterface;
import h9.f;
import java.util.ArrayDeque;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bR&\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0011¨\u0006\u0012"}, d2 = {"Landroidx/paging/multicast/BufferImpl;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/paging/multicast/Buffer;", "", "limit", "<init>", "(I)V", "Landroidx/paging/multicast/ChannelManager$Message$Dispatch$Value;", "item", "Lr8/z;", "add", "(Landroidx/paging/multicast/ChannelManager$Message$Dispatch$Value;)V", "Ljava/util/ArrayDeque;", "items", "Ljava/util/ArrayDeque;", "getItems", "()Ljava/util/ArrayDeque;", "I", "paging-common"}, k = 1, mv = {1, 4, 1})
final class BufferImpl<T> implements Buffer<T> {
    private final ArrayDeque<ChannelManager.Message.Dispatch.Value<T>> items;
    private final int limit;

    @Override // androidx.paging.multicast.Buffer
    public void add(ChannelManager.Message.Dispatch.Value<T> item) {
        m.f(item, "item");
        while (getItems().size() >= this.limit) {
            getItems().pollFirst();
        }
        getItems().offerLast(item);
    }

    @Override // androidx.paging.multicast.Buffer
    public ArrayDeque<ChannelManager.Message.Dispatch.Value<T>> getItems() {
        return this.items;
    }

    public BufferImpl(int i10) {
        this.limit = i10;
        this.items = new ArrayDeque<>(f.e(i10, 10));
    }

    @Override // androidx.paging.multicast.Buffer
    public boolean isEmpty() {
        return Buffer.DefaultImpls.isEmpty(this);
    }
}
