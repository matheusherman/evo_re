package androidx.paging;

import androidx.annotation.VisibleForTesting;
import androidx.arch.core.util.Function;
import c9.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.r;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.h;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.n;
import kotlinx.coroutines.o;
import r8.q;
import v8.f;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000g\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\t\b'\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004:\u00044567B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J+\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\b0\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\fH\u0080@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0014\u001a\u0004\u0018\u00018\u0000*\b\u0012\u0004\u0012\u00028\u00010\u0011H\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0016\u001a\u0004\u0018\u00018\u0000*\b\u0012\u0004\u0012\u00028\u00010\u0011H\u0000¢\u0006\u0004\b\u0015\u0010\u0013J'\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00010\b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017H\u0081@ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J'\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00010\b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u001bH\u0081@ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ'\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00010\b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u001bH\u0081@ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u001dJ+\u0010\u001a\u001a\u00020#2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u00172\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00010!H&¢\u0006\u0004\b\u001a\u0010$J+\u0010 \u001a\u00020#2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00010%H&¢\u0006\u0004\b \u0010&J+\u0010\u001e\u001a\u00020#2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00010%H&¢\u0006\u0004\b\u001e\u0010&J\u0017\u0010(\u001a\u00028\u00002\u0006\u0010'\u001a\u00028\u0001H&¢\u0006\u0004\b(\u0010)J\u0017\u0010+\u001a\u00028\u00002\u0006\u0010'\u001a\u00028\u0001H\u0010¢\u0006\u0004\b*\u0010)JC\u0010/\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u0000\"\b\b\u0002\u0010,*\u00020\u00012\u001e\u0010.\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u00110-¢\u0006\u0004\b/\u00100JC\u0010/\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u0000\"\b\b\u0002\u0010,*\u00020\u00012\u001e\u0010.\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u001101¢\u0006\u0004\b/\u00102J7\u00103\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u0000\"\b\b\u0002\u0010,*\u00020\u00012\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020-¢\u0006\u0004\b3\u00100J7\u00103\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u0000\"\b\b\u0002\u0010,*\u00020\u00012\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u000201¢\u0006\u0004\b3\u00102\u0082\u0002\u0004\n\u0002\b\u0019¨\u00068"}, d2 = {"Landroidx/paging/ItemKeyedDataSource;", "", "Key", "Value", "Landroidx/paging/DataSource;", "<init>", "()V", "Lkotlinx/coroutines/n;", "Landroidx/paging/DataSource$BaseResult;", "androidx/paging/ItemKeyedDataSource$asCallback$1", "asCallback", "(Lkotlinx/coroutines/n;)Landroidx/paging/ItemKeyedDataSource$asCallback$1;", "Landroidx/paging/DataSource$Params;", "params", "load$paging_common", "(Landroidx/paging/DataSource$Params;Lv8/f;)Ljava/lang/Object;", "load", "", "getPrevKey$paging_common", "(Ljava/util/List;)Ljava/lang/Object;", "getPrevKey", "getNextKey$paging_common", "getNextKey", "Landroidx/paging/ItemKeyedDataSource$LoadInitialParams;", "loadInitial$paging_common", "(Landroidx/paging/ItemKeyedDataSource$LoadInitialParams;Lv8/f;)Ljava/lang/Object;", "loadInitial", "Landroidx/paging/ItemKeyedDataSource$LoadParams;", "loadBefore$paging_common", "(Landroidx/paging/ItemKeyedDataSource$LoadParams;Lv8/f;)Ljava/lang/Object;", "loadBefore", "loadAfter$paging_common", "loadAfter", "Landroidx/paging/ItemKeyedDataSource$LoadInitialCallback;", "callback", "Lr8/z;", "(Landroidx/paging/ItemKeyedDataSource$LoadInitialParams;Landroidx/paging/ItemKeyedDataSource$LoadInitialCallback;)V", "Landroidx/paging/ItemKeyedDataSource$LoadCallback;", "(Landroidx/paging/ItemKeyedDataSource$LoadParams;Landroidx/paging/ItemKeyedDataSource$LoadCallback;)V", "item", "getKey", "(Ljava/lang/Object;)Ljava/lang/Object;", "getKeyInternal$paging_common", "getKeyInternal", "ToValue", "Landroidx/arch/core/util/Function;", "function", "mapByPage", "(Landroidx/arch/core/util/Function;)Landroidx/paging/ItemKeyedDataSource;", "Lkotlin/Function1;", "(Lc9/l;)Landroidx/paging/ItemKeyedDataSource;", "map", "LoadCallback", "LoadInitialCallback", "LoadInitialParams", "LoadParams", "paging-common"}, k = 1, mv = {1, 4, 1})
public abstract class ItemKeyedDataSource<Key, Value> extends DataSource<Key, Value> {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0002\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00020\u0005H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroidx/paging/ItemKeyedDataSource$LoadCallback;", "Value", "", "<init>", "()V", "", "data", "Lr8/z;", "onResult", "(Ljava/util/List;)V", "paging-common"}, k = 1, mv = {1, 4, 1})
    public static abstract class LoadCallback<Value> {
        public abstract void onResult(List<? extends Value> data);
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u00028\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J-\u0010\u000b\u001a\u00020\n2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Landroidx/paging/ItemKeyedDataSource$LoadInitialCallback;", "Value", "Landroidx/paging/ItemKeyedDataSource$LoadCallback;", "<init>", "()V", "", "data", "", "position", "totalCount", "Lr8/z;", "onResult", "(Ljava/util/List;II)V", "paging-common"}, k = 1, mv = {1, 4, 1})
    public static abstract class LoadInitialCallback<Value> extends LoadCallback<Value> {
        public abstract void onResult(List<? extends Value> data, int position, int totalCount);
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0016\u0018\u0000*\b\b\u0002\u0010\u0001*\u00020\u00022\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00028\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0012\u0010\u0003\u001a\u00028\u00028\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Landroidx/paging/ItemKeyedDataSource$LoadParams;", "Key", "", "key", "requestedLoadSize", "", "(Ljava/lang/Object;I)V", "Ljava/lang/Object;", "paging-common"}, k = 1, mv = {1, 4, 1})
    public static class LoadParams<Key> {
        public final Key key;
        public final int requestedLoadSize;

        public LoadParams(Key key, int i10) {
            m.f(key, "key");
            this.key = key;
            this.requestedLoadSize = i10;
        }
    }

    public abstract Key getKey(Value item);

    public abstract void loadAfter(LoadParams<Key> params, LoadCallback<Value> callback);

    public abstract void loadBefore(LoadParams<Key> params, LoadCallback<Value> callback);

    public abstract void loadInitial(LoadInitialParams<Key> params, LoadInitialCallback<Value> callback);

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0016\u0018\u0000*\b\b\u0002\u0010\u0001*\u00020\u00022\u00020\u0002B\u001f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00018\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u0004\u0018\u00018\u00028\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Landroidx/paging/ItemKeyedDataSource$LoadInitialParams;", "Key", "", "requestedInitialKey", "requestedLoadSize", "", "placeholdersEnabled", "", "(Ljava/lang/Object;IZ)V", "Ljava/lang/Object;", "paging-common"}, k = 1, mv = {1, 4, 1})
    public static class LoadInitialParams<Key> {
        public final boolean placeholdersEnabled;
        public final Key requestedInitialKey;
        public final int requestedLoadSize;

        public LoadInitialParams(Key key, int i10, boolean z10) {
            this.requestedInitialKey = key;
            this.requestedLoadSize = i10;
            this.placeholdersEnabled = z10;
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LoadType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[LoadType.REFRESH.ordinal()] = 1;
            iArr[LoadType.PREPEND.ordinal()] = 2;
            iArr[LoadType.APPEND.ordinal()] = 3;
        }
    }

    public ItemKeyedDataSource() {
        super(DataSource.KeyType.ITEM_KEYED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AnonymousClass1 asCallback(final n<? super DataSource.BaseResult<Value>> nVar) {
        return new LoadCallback<Value>() { // from class: androidx.paging.ItemKeyedDataSource.asCallback.1
            @Override // androidx.paging.ItemKeyedDataSource.LoadCallback
            public void onResult(List<? extends Value> data) {
                m.f(data, "data");
                nVar.resumeWith(q.a(new DataSource.BaseResult(data, ItemKeyedDataSource.this.getPrevKey$paging_common(data), ItemKeyedDataSource.this.getNextKey$paging_common(data), 0, 0, 24, null)));
            }
        };
    }

    @Override // androidx.paging.DataSource
    public Key getKeyInternal$paging_common(Value item) {
        m.f(item, "item");
        return getKey(item);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Key getNextKey$paging_common(List<? extends Value> getNextKey) {
        m.f(getNextKey, "$this$getNextKey");
        Object objU0 = r.u0(getNextKey);
        if (objU0 != null) {
            return (Key) getKey(objU0);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Key getPrevKey$paging_common(List<? extends Value> getPrevKey) {
        m.f(getPrevKey, "$this$getPrevKey");
        Object objI0 = r.i0(getPrevKey);
        if (objI0 != null) {
            return (Key) getKey(objI0);
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006a, code lost:
    
        if (r8 == r1) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x008c, code lost:
    
        if (r8 == r1) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00a9, code lost:
    
        if (r8 == r1) goto L36;
     */
    @Override // androidx.paging.DataSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object load$paging_common(DataSource.Params<Key> params, f<? super DataSource.BaseResult<Value>> fVar) {
        ItemKeyedDataSource$load$1 itemKeyedDataSource$load$1;
        if (fVar instanceof ItemKeyedDataSource$load$1) {
            itemKeyedDataSource$load$1 = (ItemKeyedDataSource$load$1) fVar;
            int i10 = itemKeyedDataSource$load$1.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                itemKeyedDataSource$load$1.label = i10 - Integer.MIN_VALUE;
            } else {
                itemKeyedDataSource$load$1 = new ItemKeyedDataSource$load$1(this, fVar);
            }
        } else {
            itemKeyedDataSource$load$1 = new ItemKeyedDataSource$load$1(this, fVar);
        }
        Object objLoadInitial$paging_common = itemKeyedDataSource$load$1.result;
        Object objC = b.c();
        int i11 = itemKeyedDataSource$load$1.label;
        if (i11 != 0) {
            if (i11 == 1) {
                r8.r.b(objLoadInitial$paging_common);
                return (DataSource.BaseResult) objLoadInitial$paging_common;
            }
            if (i11 == 2) {
                r8.r.b(objLoadInitial$paging_common);
                return (DataSource.BaseResult) objLoadInitial$paging_common;
            }
            if (i11 != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            r8.r.b(objLoadInitial$paging_common);
            return (DataSource.BaseResult) objLoadInitial$paging_common;
        }
        r8.r.b(objLoadInitial$paging_common);
        int i12 = WhenMappings.$EnumSwitchMapping$0[params.getType().ordinal()];
        if (i12 == 1) {
            LoadInitialParams<Key> loadInitialParams = new LoadInitialParams<>(params.getKey(), params.getInitialLoadSize(), params.getPlaceholdersEnabled());
            itemKeyedDataSource$load$1.label = 1;
            objLoadInitial$paging_common = loadInitial$paging_common(loadInitialParams, itemKeyedDataSource$load$1);
        } else if (i12 == 2) {
            Key key = params.getKey();
            m.c(key);
            LoadParams<Key> loadParams = new LoadParams<>(key, params.getPageSize());
            itemKeyedDataSource$load$1.label = 2;
            objLoadInitial$paging_common = loadBefore$paging_common(loadParams, itemKeyedDataSource$load$1);
        } else {
            if (i12 != 3) {
                throw new r8.n();
            }
            Key key2 = params.getKey();
            m.c(key2);
            LoadParams<Key> loadParams2 = new LoadParams<>(key2, params.getPageSize());
            itemKeyedDataSource$load$1.label = 3;
            objLoadInitial$paging_common = loadAfter$paging_common(loadParams2, itemKeyedDataSource$load$1);
        }
        return objC;
    }

    @VisibleForTesting
    public final Object loadAfter$paging_common(LoadParams<Key> loadParams, f<? super DataSource.BaseResult<Value>> fVar) {
        o oVar = new o(b.b(fVar), 1);
        oVar.D();
        loadAfter(loadParams, asCallback(oVar));
        Object objZ = oVar.z();
        if (objZ == b.c()) {
            h.c(fVar);
        }
        return objZ;
    }

    @VisibleForTesting
    public final Object loadBefore$paging_common(LoadParams<Key> loadParams, f<? super DataSource.BaseResult<Value>> fVar) {
        o oVar = new o(b.b(fVar), 1);
        oVar.D();
        loadBefore(loadParams, asCallback(oVar));
        Object objZ = oVar.z();
        if (objZ == b.c()) {
            h.c(fVar);
        }
        return objZ;
    }

    @VisibleForTesting
    public final Object loadInitial$paging_common(final LoadInitialParams<Key> loadInitialParams, f<? super DataSource.BaseResult<Value>> fVar) {
        final o oVar = new o(b.b(fVar), 1);
        oVar.D();
        loadInitial(loadInitialParams, new LoadInitialCallback<Value>() { // from class: androidx.paging.ItemKeyedDataSource$loadInitial$$inlined$suspendCancellableCoroutine$lambda$1
            @Override // androidx.paging.ItemKeyedDataSource.LoadInitialCallback
            public void onResult(List<? extends Value> data, int position, int totalCount) {
                m.f(data, "data");
                oVar.resumeWith(q.a(new DataSource.BaseResult(data, this.getPrevKey$paging_common(data), this.getNextKey$paging_common(data), position, (totalCount - data.size()) - position)));
            }

            @Override // androidx.paging.ItemKeyedDataSource.LoadCallback
            public void onResult(List<? extends Value> data) {
                m.f(data, "data");
                oVar.resumeWith(q.a(new DataSource.BaseResult(data, this.getPrevKey$paging_common(data), this.getNextKey$paging_common(data), 0, 0, 24, null)));
            }
        });
        Object objZ = oVar.z();
        if (objZ == b.c()) {
            h.c(fVar);
        }
        return objZ;
    }

    @Override // androidx.paging.DataSource
    public final <ToValue> ItemKeyedDataSource<Key, ToValue> map(final Function<Value, ToValue> function) {
        m.f(function, "function");
        return mapByPage((Function) new Function<List<? extends Value>, List<? extends ToValue>>() { // from class: androidx.paging.ItemKeyedDataSource.map.1
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

    @Override // androidx.paging.DataSource
    public final <ToValue> ItemKeyedDataSource<Key, ToValue> mapByPage(Function<List<Value>, List<ToValue>> function) {
        m.f(function, "function");
        return new WrapperItemKeyedDataSource(this, function);
    }

    @Override // androidx.paging.DataSource
    public final <ToValue> ItemKeyedDataSource<Key, ToValue> map(final l<? super Value, ? extends ToValue> function) {
        m.f(function, "function");
        return mapByPage((Function) new Function<List<? extends Value>, List<? extends ToValue>>() { // from class: androidx.paging.ItemKeyedDataSource.map.2
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

    @Override // androidx.paging.DataSource
    public final <ToValue> ItemKeyedDataSource<Key, ToValue> mapByPage(final l<? super List<? extends Value>, ? extends List<? extends ToValue>> function) {
        m.f(function, "function");
        return mapByPage((Function) new Function<List<? extends Value>, List<? extends ToValue>>() { // from class: androidx.paging.ItemKeyedDataSource.mapByPage.1
            @Override // androidx.arch.core.util.Function
            public final List<ToValue> apply(List<? extends Value> it) {
                l lVar = function;
                m.e(it, "it");
                return (List) lVar.invoke(it);
            }
        });
    }
}
