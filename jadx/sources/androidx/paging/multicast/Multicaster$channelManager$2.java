package androidx.paging.multicast;

import androidx.exifinterface.media.ExifInterface;
import c9.a;
import kotlin.Metadata;
import kotlin.jvm.internal.o;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/paging/multicast/ChannelManager;", ExifInterface.GPS_DIRECTION_TRUE, "invoke"}, k = 3, mv = {1, 4, 1})
final class Multicaster$channelManager$2<T> extends o implements a<ChannelManager<T>> {
    final /* synthetic */ int $bufferSize;
    final /* synthetic */ Multicaster this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Multicaster$channelManager$2(Multicaster multicaster, int i10) {
        super(0);
        this.this$0 = multicaster;
        this.$bufferSize = i10;
    }

    @Override // c9.a
    public final ChannelManager<T> invoke() {
        return new ChannelManager<>(this.this$0.scope, this.$bufferSize, this.this$0.piggybackingDownstream, this.this$0.onEach, this.this$0.keepUpstreamAlive, this.this$0.source);
    }
}
