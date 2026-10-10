package androidx.paging;

import androidx.annotation.AnyThread;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.arch.core.util.Function;
import androidx.exifinterface.media.ExifInterface;
import c9.l;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.collections.r;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.i0;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import v8.f;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\b&\u0018\u0000 7*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0001:\u0006879:;<B\u0011\b\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007JE\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u0000\"\b\b\u0002\u0010\b*\u00020\u00012\u001e\u0010\u000b\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\n\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\n0\tH\u0016¢\u0006\u0004\b\f\u0010\rJE\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u0000\"\b\b\u0002\u0010\b*\u00020\u00012\u001e\u0010\u000b\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\n\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\n0\u000eH\u0016¢\u0006\u0004\b\f\u0010\u000fJ9\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u0000\"\b\b\u0002\u0010\b*\u00020\u00012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\tH\u0016¢\u0006\u0004\b\u0010\u0010\rJ9\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u0000\"\b\b\u0002\u0010\b*\u00020\u00012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0017¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0017¢\u0006\u0004\b\u0016\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0013H\u0017¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00010\u001b2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H @ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\"\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00028\u0001H ¢\u0006\u0004\b \u0010!R&\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00110#8\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b$\u0010%\u0012\u0004\b(\u0010\u0018\u001a\u0004\b&\u0010'R\u0014\u0010*\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u001a\u0010-\u001a\u00020,8\u0010X\u0090D¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u001a\u00101\u001a\u00020,8\u0010X\u0090D¢\u0006\f\n\u0004\b1\u0010.\u001a\u0004\b2\u00100R\u001a\u0010\u0005\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u00103\u001a\u0004\b4\u00105R\u0014\u00106\u001a\u00020,8WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b6\u00100\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006="}, d2 = {"Landroidx/paging/DataSource;", "", "Key", "Value", "Landroidx/paging/DataSource$KeyType;", IjkMediaMeta.IJKM_KEY_TYPE, "<init>", "(Landroidx/paging/DataSource$KeyType;)V", "ToValue", "Landroidx/arch/core/util/Function;", "", "function", "mapByPage", "(Landroidx/arch/core/util/Function;)Landroidx/paging/DataSource;", "Lkotlin/Function1;", "(Lc9/l;)Landroidx/paging/DataSource;", "map", "Landroidx/paging/DataSource$InvalidatedCallback;", "onInvalidatedCallback", "Lr8/z;", "addInvalidatedCallback", "(Landroidx/paging/DataSource$InvalidatedCallback;)V", "removeInvalidatedCallback", "invalidate", "()V", "Landroidx/paging/DataSource$Params;", "params", "Landroidx/paging/DataSource$BaseResult;", "load$paging_common", "(Landroidx/paging/DataSource$Params;Lv8/f;)Ljava/lang/Object;", "load", "item", "getKeyInternal$paging_common", "(Ljava/lang/Object;)Ljava/lang/Object;", "getKeyInternal", "Ljava/util/concurrent/CopyOnWriteArrayList;", "onInvalidatedCallbacks", "Ljava/util/concurrent/CopyOnWriteArrayList;", "getOnInvalidatedCallbacks$paging_common", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "getOnInvalidatedCallbacks$paging_common$annotations", "Ljava/util/concurrent/atomic/AtomicBoolean;", "_invalid", "Ljava/util/concurrent/atomic/AtomicBoolean;", "", "isContiguous", "Z", "isContiguous$paging_common", "()Z", "supportsPageDropping", "getSupportsPageDropping$paging_common", "Landroidx/paging/DataSource$KeyType;", "getType$paging_common", "()Landroidx/paging/DataSource$KeyType;", "isInvalid", "Companion", "BaseResult", "Factory", "InvalidatedCallback", "KeyType", "Params", "paging-common"}, k = 1, mv = {1, 4, 1})
public abstract class DataSource<Key, Value> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final AtomicBoolean _invalid;
    private final boolean isContiguous;
    private final CopyOnWriteArrayList<InvalidatedCallback> onInvalidatedCallbacks;
    private final boolean supportsPageDropping;
    private final KeyType type;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\r\b\u0000\u0018\u0000 \u001e*\b\b\u0002\u0010\u0002*\u00020\u00012\u00020\u0001:\u0001\u001eB?\b\u0000\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0010\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0015R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00018\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00018\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u0019\u0010\u0018R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\t\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010\u001a\u001a\u0004\b\u001d\u0010\u001c¨\u0006\u001f"}, d2 = {"Landroidx/paging/DataSource$BaseResult;", "", "Value", "", "data", "prevKey", "nextKey", "", "itemsBefore", "itemsAfter", "<init>", "(Ljava/util/List;Ljava/lang/Object;Ljava/lang/Object;II)V", "pageSize", "Lr8/z;", "validateForInitialTiling$paging_common", "(I)V", "validateForInitialTiling", TransactionPartnerType.OTHER, "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "Ljava/lang/Object;", "getPrevKey", "()Ljava/lang/Object;", "getNextKey", "I", "getItemsBefore", "()I", "getItemsAfter", "Companion", "paging-common"}, k = 1, mv = {1, 4, 1})
    public static final class BaseResult<Value> {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public final List<Value> data;
        private final int itemsAfter;
        private final int itemsBefore;
        private final Object nextKey;
        private final Object prevKey;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0005\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JU\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\b\b\u0003\u0010\u0006*\u00020\u0001\"\b\b\u0004\u0010\u0005*\u00020\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\u001e\u0010\b\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\n\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\n0\tH\u0000¢\u0006\u0002\b\u000bJ\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\r0\u0004\"\b\b\u0003\u0010\r*\u00020\u0001H\u0000¢\u0006\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Landroidx/paging/DataSource$BaseResult$Companion;", "", "()V", "convert", "Landroidx/paging/DataSource$BaseResult;", "Value", "ToValue", "result", "function", "Landroidx/arch/core/util/Function;", "", "convert$paging_common", "empty", ExifInterface.GPS_DIRECTION_TRUE, "empty$paging_common", "paging-common"}, k = 1, mv = {1, 4, 1})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(g gVar) {
                this();
            }

            public final <ToValue, Value> BaseResult<Value> convert$paging_common(BaseResult<ToValue> result, Function<List<ToValue>, List<Value>> function) {
                m.f(result, "result");
                m.f(function, "function");
                return new BaseResult<>(DataSource.INSTANCE.convert$paging_common(function, result.data), result.getPrevKey(), result.getNextKey(), result.getItemsBefore(), result.getItemsAfter());
            }

            public final <T> BaseResult<T> empty$paging_common() {
                return new BaseResult<>(r.l(), null, null, 0, 0);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public BaseResult(List<? extends Value> data, Object obj, Object obj2, int i10, int i11) {
            m.f(data, "data");
            this.data = data;
            this.prevKey = obj;
            this.nextKey = obj2;
            this.itemsBefore = i10;
            this.itemsAfter = i11;
            if (i10 < 0 && i10 != Integer.MIN_VALUE) {
                throw new IllegalArgumentException("Position must be non-negative");
            }
            if (data.isEmpty() && (i10 > 0 || i11 > 0)) {
                throw new IllegalArgumentException("Initial result cannot be empty if items are present in data set.");
            }
            if (i11 < 0 && i11 != Integer.MIN_VALUE) {
                throw new IllegalArgumentException("List size + position too large, last item in list beyond totalCount.");
            }
        }

        public boolean equals(Object other) {
            if (other instanceof BaseResult) {
                BaseResult baseResult = (BaseResult) other;
                if (m.a(this.data, baseResult.data) && m.a(this.prevKey, baseResult.prevKey) && m.a(this.nextKey, baseResult.nextKey) && this.itemsBefore == baseResult.itemsBefore && this.itemsAfter == baseResult.itemsAfter) {
                    return true;
                }
            }
            return false;
        }

        public final int getItemsAfter() {
            return this.itemsAfter;
        }

        public final int getItemsBefore() {
            return this.itemsBefore;
        }

        public final Object getNextKey() {
            return this.nextKey;
        }

        public final Object getPrevKey() {
            return this.prevKey;
        }

        public final void validateForInitialTiling$paging_common(int pageSize) {
            int i10;
            if (this.itemsBefore == Integer.MIN_VALUE || (i10 = this.itemsAfter) == Integer.MIN_VALUE) {
                throw new IllegalStateException("Placeholders requested, but totalCount not provided. Please call the three-parameter onResult method, or disable placeholders in the PagedList.Config");
            }
            if (i10 <= 0 || this.data.size() % pageSize == 0) {
                if (this.itemsBefore % pageSize == 0) {
                    return;
                }
                throw new IllegalArgumentException("Initial load must be pageSize aligned.Position = " + this.itemsBefore + ", pageSize = " + pageSize);
            }
            throw new IllegalArgumentException("PositionalDataSource requires initial load size to be a multiple of page size to support internal tiling. loadSize " + this.data.size() + ", position " + this.itemsBefore + ", totalCount " + (this.itemsBefore + this.data.size() + this.itemsAfter) + ", pageSize " + pageSize);
        }

        public /* synthetic */ BaseResult(List list, Object obj, Object obj2, int i10, int i11, int i12, g gVar) {
            this(list, obj, obj2, (i12 & 8) != 0 ? Integer.MIN_VALUE : i10, (i12 & 16) != 0 ? Integer.MIN_VALUE : i11);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JM\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0002\u0010\u0006\"\u0004\b\u0003\u0010\u00052\u001e\u0010\u0007\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u00040\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0004H\u0000¢\u0006\u0002\b\n¨\u0006\u000b"}, d2 = {"Landroidx/paging/DataSource$Companion;", "", "()V", "convert", "", "B", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "function", "Landroidx/arch/core/util/Function;", "source", "convert$paging_common", "paging-common"}, k = 1, mv = {1, 4, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final <A, B> List<B> convert$paging_common(Function<List<A>, List<B>> function, List<? extends A> source) {
            m.f(function, "function");
            m.f(source, "source");
            List<B> dest = function.apply(source);
            if (dest.size() == source.size()) {
                m.e(dest, "dest");
                return dest;
            }
            throw new IllegalStateException("Invalid Function " + function + " changed return size. This is not supported.");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0002\u0010\u0002*\u00020\u0001*\b\b\u0003\u0010\u0003*\u00020\u00012\u00020\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006H&¢\u0006\u0004\b\u0007\u0010\bJ9\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00040\u0000\"\b\b\u0004\u0010\t*\u00020\u00012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00040\nH\u0016¢\u0006\u0004\b\f\u0010\rJ9\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00040\u0000\"\b\b\u0004\u0010\t*\u00020\u00012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00040\u000eH\u0016¢\u0006\u0004\b\f\u0010\u000fJE\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00040\u0000\"\b\b\u0004\u0010\t*\u00020\u00012\u001e\u0010\u000b\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00030\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00040\u00100\nH\u0016¢\u0006\u0004\b\u0011\u0010\rJE\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00040\u0000\"\b\b\u0004\u0010\t*\u00020\u00012\u001e\u0010\u000b\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00030\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00040\u00100\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u000fJ+\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00150\u00142\b\b\u0002\u0010\u0013\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Landroidx/paging/DataSource$Factory;", "", "Key", "Value", "<init>", "()V", "Landroidx/paging/DataSource;", "create", "()Landroidx/paging/DataSource;", "ToValue", "Landroidx/arch/core/util/Function;", "function", "map", "(Landroidx/arch/core/util/Function;)Landroidx/paging/DataSource$Factory;", "Lkotlin/Function1;", "(Lc9/l;)Landroidx/paging/DataSource$Factory;", "", "mapByPage", "Lkotlinx/coroutines/i0;", "fetchDispatcher", "Lkotlin/Function0;", "Landroidx/paging/PagingSource;", "asPagingSourceFactory", "(Lkotlinx/coroutines/i0;)Lc9/a;", "paging-common"}, k = 1, mv = {1, 4, 1})
    public static abstract class Factory<Key, Value> {
        public final c9.a<PagingSource<Key, Value>> asPagingSourceFactory() {
            return asPagingSourceFactory$default(this, null, 1, null);
        }

        public abstract DataSource<Key, Value> create();

        public <ToValue> Factory<Key, ToValue> map(final Function<Value, ToValue> function) {
            m.f(function, "function");
            return mapByPage(new Function<List<? extends Value>, List<? extends ToValue>>() { // from class: androidx.paging.DataSource$Factory$map$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // androidx.arch.core.util.Function
                public final List<ToValue> apply(List<? extends Value> list) {
                    m.e(list, "list");
                    List<? extends Value> list2 = list;
                    ArrayList arrayList = new ArrayList(r.w(list2, 10));
                    Iterator<T> it = list2.iterator();
                    while (it.hasNext()) {
                        arrayList.add(function.apply(it.next()));
                    }
                    return arrayList;
                }
            });
        }

        public <ToValue> Factory<Key, ToValue> mapByPage(final Function<List<Value>, List<ToValue>> function) {
            m.f(function, "function");
            return new Factory<Key, ToValue>() { // from class: androidx.paging.DataSource$Factory$mapByPage$1
                @Override // androidx.paging.DataSource.Factory
                public DataSource<Key, ToValue> create() {
                    return this.this$0.create().mapByPage(function);
                }
            };
        }

        public static /* synthetic */ c9.a asPagingSourceFactory$default(Factory factory, i0 i0Var, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: asPagingSourceFactory");
            }
            if ((i10 & 1) != 0) {
                i0Var = a1.b();
            }
            return factory.asPagingSourceFactory(i0Var);
        }

        public final c9.a<PagingSource<Key, Value>> asPagingSourceFactory(i0 fetchDispatcher) {
            m.f(fetchDispatcher, "fetchDispatcher");
            return new SuspendingPagingSourceFactory(fetchDispatcher, new DataSource$Factory$asPagingSourceFactory$1(this, fetchDispatcher));
        }

        public /* synthetic */ <ToValue> Factory<Key, ToValue> map(final l<? super Value, ? extends ToValue> function) {
            m.f(function, "function");
            return mapByPage(new Function<List<? extends Value>, List<? extends ToValue>>() { // from class: androidx.paging.DataSource$Factory$map$2
                @Override // androidx.arch.core.util.Function
                public final List<ToValue> apply(List<? extends Value> list) {
                    m.e(list, "list");
                    List<? extends Value> list2 = list;
                    l lVar = function;
                    ArrayList arrayList = new ArrayList(r.w(list2, 10));
                    Iterator<T> it = list2.iterator();
                    while (it.hasNext()) {
                        arrayList.add(lVar.invoke(it.next()));
                    }
                    return arrayList;
                }
            });
        }

        public /* synthetic */ <ToValue> Factory<Key, ToValue> mapByPage(final l<? super List<? extends Value>, ? extends List<? extends ToValue>> function) {
            m.f(function, "function");
            return mapByPage(new Function<List<? extends Value>, List<? extends ToValue>>() { // from class: androidx.paging.DataSource$Factory$mapByPage$2
                @Override // androidx.arch.core.util.Function
                public final List<ToValue> apply(List<? extends Value> it) {
                    l lVar = function;
                    m.e(it, "it");
                    return (List) lVar.invoke(it);
                }
            });
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroidx/paging/DataSource$InvalidatedCallback;", "", "Lr8/z;", "onInvalidated", "()V", "paging-common"}, k = 1, mv = {1, 4, 1})
    public interface InvalidatedCallback {
        @AnyThread
        void onInvalidated();
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/paging/DataSource$KeyType;", "", "(Ljava/lang/String;I)V", "POSITIONAL", "PAGE_KEYED", "ITEM_KEYED", "paging-common"}, k = 1, mv = {1, 4, 1})
    public enum KeyType {
        POSITIONAL,
        PAGE_KEYED,
        ITEM_KEYED
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0000\u0018\u0000*\b\b\u0002\u0010\u0001*\u00020\u00022\u00020\u0002B1\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00018\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0005\u001a\u0004\u0018\u00018\u0002¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Landroidx/paging/DataSource$Params;", "K", "", IjkMediaMeta.IJKM_KEY_TYPE, "Landroidx/paging/LoadType;", "key", "initialLoadSize", "", "placeholdersEnabled", "", "pageSize", "(Landroidx/paging/LoadType;Ljava/lang/Object;IZI)V", "getInitialLoadSize", "()I", "getKey", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getPageSize", "getPlaceholdersEnabled", "()Z", "getType$paging_common", "()Landroidx/paging/LoadType;", "paging-common"}, k = 1, mv = {1, 4, 1})
    public static final class Params<K> {
        private final int initialLoadSize;
        private final K key;
        private final int pageSize;
        private final boolean placeholdersEnabled;
        private final LoadType type;

        public Params(LoadType type, K k10, int i10, boolean z10, int i11) {
            m.f(type, "type");
            this.type = type;
            this.key = k10;
            this.initialLoadSize = i10;
            this.placeholdersEnabled = z10;
            this.pageSize = i11;
            if (type != LoadType.REFRESH && k10 == null) {
                throw new IllegalArgumentException("Key must be non-null for prepend/append");
            }
        }

        public final int getInitialLoadSize() {
            return this.initialLoadSize;
        }

        public final K getKey() {
            return this.key;
        }

        public final int getPageSize() {
            return this.pageSize;
        }

        public final boolean getPlaceholdersEnabled() {
            return this.placeholdersEnabled;
        }

        /* JADX INFO: renamed from: getType$paging_common, reason: from getter */
        public final LoadType getType() {
            return this.type;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [ToValue] */
    /* JADX INFO: renamed from: androidx.paging.DataSource$map$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003\"\b\b\u0002\u0010\u0005*\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "ToValue", "", "Key", "Value", "list", "invoke"}, k = 3, mv = {1, 4, 1})
    static final class AnonymousClass1<ToValue> extends o implements l<List<? extends Value>, List<? extends ToValue>> {
        final /* synthetic */ Function $function;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Function function) {
            super(1);
            this.$function = function;
        }

        @Override // c9.l
        public final List<ToValue> invoke(List<? extends Value> list) {
            m.f(list, "list");
            List<? extends Value> list2 = list;
            ArrayList arrayList = new ArrayList(r.w(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(this.$function.apply(it.next()));
            }
            return arrayList;
        }
    }

    public abstract Key getKeyInternal$paging_common(Value item);

    public abstract Object load$paging_common(Params<Key> params, f<? super BaseResult<Value>> fVar);

    public <ToValue> DataSource<Key, ToValue> map(Function<Value, ToValue> function) {
        m.f(function, "function");
        return mapByPage(new AnonymousClass1(function));
    }

    public <ToValue> DataSource<Key, ToValue> mapByPage(Function<List<Value>, List<ToValue>> function) {
        m.f(function, "function");
        return new WrapperDataSource(this, function);
    }

    public DataSource(KeyType type) {
        m.f(type, "type");
        this.type = type;
        this.onInvalidatedCallbacks = new CopyOnWriteArrayList<>();
        this._invalid = new AtomicBoolean(false);
        this.isContiguous = true;
        this.supportsPageDropping = true;
    }

    @AnyThread
    public void addInvalidatedCallback(InvalidatedCallback onInvalidatedCallback) {
        m.f(onInvalidatedCallback, "onInvalidatedCallback");
        this.onInvalidatedCallbacks.add(onInvalidatedCallback);
    }

    public final CopyOnWriteArrayList<InvalidatedCallback> getOnInvalidatedCallbacks$paging_common() {
        return this.onInvalidatedCallbacks;
    }

    /* JADX INFO: renamed from: getSupportsPageDropping$paging_common, reason: from getter */
    public boolean getSupportsPageDropping() {
        return this.supportsPageDropping;
    }

    /* JADX INFO: renamed from: getType$paging_common, reason: from getter */
    public final KeyType getType() {
        return this.type;
    }

    @AnyThread
    public void invalidate() {
        if (this._invalid.compareAndSet(false, true)) {
            Iterator<T> it = this.onInvalidatedCallbacks.iterator();
            while (it.hasNext()) {
                ((InvalidatedCallback) it.next()).onInvalidated();
            }
        }
    }

    /* JADX INFO: renamed from: isContiguous$paging_common, reason: from getter */
    public boolean getIsContiguous() {
        return this.isContiguous;
    }

    @WorkerThread
    public boolean isInvalid() {
        return this._invalid.get();
    }

    public /* synthetic */ <ToValue> DataSource<Key, ToValue> map(final l<? super Value, ? extends ToValue> function) {
        m.f(function, "function");
        return map(new Function<Value, ToValue>() { // from class: androidx.paging.DataSource.map.2
            @Override // androidx.arch.core.util.Function
            public final ToValue apply(Value it) {
                l lVar = function;
                m.e(it, "it");
                return (ToValue) lVar.invoke(it);
            }
        });
    }

    public /* synthetic */ <ToValue> DataSource<Key, ToValue> mapByPage(final l<? super List<? extends Value>, ? extends List<? extends ToValue>> function) {
        m.f(function, "function");
        return mapByPage(new Function<List<? extends Value>, List<? extends ToValue>>() { // from class: androidx.paging.DataSource.mapByPage.1
            @Override // androidx.arch.core.util.Function
            public final List<ToValue> apply(List<? extends Value> it) {
                l lVar = function;
                m.e(it, "it");
                return (List) lVar.invoke(it);
            }
        });
    }

    @AnyThread
    public void removeInvalidatedCallback(InvalidatedCallback onInvalidatedCallback) {
        m.f(onInvalidatedCallback, "onInvalidatedCallback");
        this.onInvalidatedCallbacks.remove(onInvalidatedCallback);
    }

    @VisibleForTesting
    public static /* synthetic */ void getOnInvalidatedCallbacks$paging_common$annotations() {
    }
}
