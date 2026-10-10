package androidx.paging;

import androidx.arch.core.util.Function;
import c9.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.h;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.n;
import kotlinx.coroutines.o;
import r8.q;
import r8.r;
import v8.f;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b'\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004:\u00042345B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J7\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f2\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\b0\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0080@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00010\b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00010\b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J'\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00010\b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0019J1\u0010\u0015\u001a\u00020\u001d2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001bH&¢\u0006\u0004\b\u0015\u0010\u001eJ1\u0010\u0018\u001a\u00020\u001d2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u00172\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\fH&¢\u0006\u0004\b\u0018\u0010\u001fJ1\u0010\u001a\u001a\u00020\u001d2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u00172\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\fH&¢\u0006\u0004\b\u001a\u0010\u001fJ\u0017\u0010#\u001a\u00028\u00002\u0006\u0010 \u001a\u00028\u0001H\u0010¢\u0006\u0004\b!\u0010\"JC\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u0000\"\b\b\u0002\u0010$*\u00020\u00012\u001e\u0010'\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010&\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020&0%¢\u0006\u0004\b(\u0010)JC\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u0000\"\b\b\u0002\u0010$*\u00020\u00012\u001e\u0010'\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010&\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020&0*¢\u0006\u0004\b(\u0010+J7\u0010,\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u0000\"\b\b\u0002\u0010$*\u00020\u00012\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020%¢\u0006\u0004\b,\u0010)J7\u0010,\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u0000\"\b\b\u0002\u0010$*\u00020\u00012\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020*¢\u0006\u0004\b,\u0010+R \u0010-\u001a\u00020\n8\u0010X\u0090D¢\u0006\u0012\n\u0004\b-\u0010.\u0012\u0004\b1\u0010\u0006\u001a\u0004\b/\u00100\u0082\u0002\u0004\n\u0002\b\u0019¨\u00066"}, d2 = {"Landroidx/paging/PageKeyedDataSource;", "", "Key", "Value", "Landroidx/paging/DataSource;", "<init>", "()V", "Lkotlinx/coroutines/n;", "Landroidx/paging/DataSource$BaseResult;", "continuation", "", "isAppend", "Landroidx/paging/PageKeyedDataSource$LoadCallback;", "continuationAsCallback", "(Lkotlinx/coroutines/n;Z)Landroidx/paging/PageKeyedDataSource$LoadCallback;", "Landroidx/paging/DataSource$Params;", "params", "load$paging_common", "(Landroidx/paging/DataSource$Params;Lv8/f;)Ljava/lang/Object;", "load", "Landroidx/paging/PageKeyedDataSource$LoadInitialParams;", "loadInitial", "(Landroidx/paging/PageKeyedDataSource$LoadInitialParams;Lv8/f;)Ljava/lang/Object;", "Landroidx/paging/PageKeyedDataSource$LoadParams;", "loadBefore", "(Landroidx/paging/PageKeyedDataSource$LoadParams;Lv8/f;)Ljava/lang/Object;", "loadAfter", "Landroidx/paging/PageKeyedDataSource$LoadInitialCallback;", "callback", "Lr8/z;", "(Landroidx/paging/PageKeyedDataSource$LoadInitialParams;Landroidx/paging/PageKeyedDataSource$LoadInitialCallback;)V", "(Landroidx/paging/PageKeyedDataSource$LoadParams;Landroidx/paging/PageKeyedDataSource$LoadCallback;)V", "item", "getKeyInternal$paging_common", "(Ljava/lang/Object;)Ljava/lang/Object;", "getKeyInternal", "ToValue", "Landroidx/arch/core/util/Function;", "", "function", "mapByPage", "(Landroidx/arch/core/util/Function;)Landroidx/paging/PageKeyedDataSource;", "Lkotlin/Function1;", "(Lc9/l;)Landroidx/paging/PageKeyedDataSource;", "map", "supportsPageDropping", "Z", "getSupportsPageDropping$paging_common", "()Z", "getSupportsPageDropping$paging_common$annotations", "LoadCallback", "LoadInitialCallback", "LoadInitialParams", "LoadParams", "paging-common"}, k = 1, mv = {1, 4, 1})
public abstract class PageKeyedDataSource<Key, Value> extends DataSource<Key, Value> {
    private final boolean supportsPageDropping;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J'\u0010\n\u001a\u00020\t2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00030\u00062\b\u0010\b\u001a\u0004\u0018\u00018\u0002H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/paging/PageKeyedDataSource$LoadCallback;", "Key", "Value", "", "<init>", "()V", "", "data", "adjacentPageKey", "Lr8/z;", "onResult", "(Ljava/util/List;Ljava/lang/Object;)V", "paging-common"}, k = 1, mv = {1, 4, 1})
    public static abstract class LoadCallback<Key, Value> {
        public abstract void onResult(List<? extends Value> data, Key adjacentPageKey);
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005JA\u0010\u000e\u001a\u00020\r2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00030\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00018\u00022\b\u0010\f\u001a\u0004\u0018\u00018\u0002H&¢\u0006\u0004\b\u000e\u0010\u000fJ1\u0010\u000e\u001a\u00020\r2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00030\u00062\b\u0010\u000b\u001a\u0004\u0018\u00018\u00022\b\u0010\f\u001a\u0004\u0018\u00018\u0002H&¢\u0006\u0004\b\u000e\u0010\u0010¨\u0006\u0011"}, d2 = {"Landroidx/paging/PageKeyedDataSource$LoadInitialCallback;", "Key", "Value", "", "<init>", "()V", "", "data", "", "position", "totalCount", "previousPageKey", "nextPageKey", "Lr8/z;", "onResult", "(Ljava/util/List;IILjava/lang/Object;Ljava/lang/Object;)V", "(Ljava/util/List;Ljava/lang/Object;Ljava/lang/Object;)V", "paging-common"}, k = 1, mv = {1, 4, 1})
    public static abstract class LoadInitialCallback<Key, Value> {
        public abstract void onResult(List<? extends Value> data, int position, int totalCount, Key previousPageKey, Key nextPageKey);

        public abstract void onResult(List<? extends Value> data, Key previousPageKey, Key nextPageKey);
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0016\u0018\u0000*\b\b\u0002\u0010\u0001*\u00020\u00022\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00028\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0012\u0010\u0003\u001a\u00028\u00028\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Landroidx/paging/PageKeyedDataSource$LoadParams;", "Key", "", "key", "requestedLoadSize", "", "(Ljava/lang/Object;I)V", "Ljava/lang/Object;", "paging-common"}, k = 1, mv = {1, 4, 1})
    public static class LoadParams<Key> {
        public final Key key;
        public final int requestedLoadSize;

        public LoadParams(Key key, int i10) {
            m.f(key, "key");
            this.key = key;
            this.requestedLoadSize = i10;
        }
    }

    final /* synthetic */ Object loadAfter(LoadParams<Key> loadParams, f<? super DataSource.BaseResult<Value>> fVar) {
        o oVar = new o(b.b(fVar), 1);
        oVar.D();
        loadAfter(loadParams, continuationAsCallback(oVar, true));
        Object objZ = oVar.z();
        if (objZ == b.c()) {
            h.c(fVar);
        }
        return objZ;
    }

    public abstract void loadAfter(LoadParams<Key> params, LoadCallback<Key, Value> callback);

    final /* synthetic */ Object loadBefore(LoadParams<Key> loadParams, f<? super DataSource.BaseResult<Value>> fVar) {
        o oVar = new o(b.b(fVar), 1);
        oVar.D();
        loadBefore(loadParams, continuationAsCallback(oVar, false));
        Object objZ = oVar.z();
        if (objZ == b.c()) {
            h.c(fVar);
        }
        return objZ;
    }

    public abstract void loadBefore(LoadParams<Key> params, LoadCallback<Key, Value> callback);

    final /* synthetic */ Object loadInitial(LoadInitialParams<Key> loadInitialParams, f<? super DataSource.BaseResult<Value>> fVar) {
        final o oVar = new o(b.b(fVar), 1);
        oVar.D();
        loadInitial(loadInitialParams, new LoadInitialCallback<Key, Value>() { // from class: androidx.paging.PageKeyedDataSource$loadInitial$2$1
            @Override // androidx.paging.PageKeyedDataSource.LoadInitialCallback
            public void onResult(List<? extends Value> data, int position, int totalCount, Key previousPageKey, Key nextPageKey) {
                m.f(data, "data");
                oVar.resumeWith(q.a(new DataSource.BaseResult(data, previousPageKey, nextPageKey, position, (totalCount - data.size()) - position)));
            }

            @Override // androidx.paging.PageKeyedDataSource.LoadInitialCallback
            public void onResult(List<? extends Value> data, Key previousPageKey, Key nextPageKey) {
                m.f(data, "data");
                oVar.resumeWith(q.a(new DataSource.BaseResult(data, previousPageKey, nextPageKey, 0, 0, 24, null)));
            }
        });
        Object objZ = oVar.z();
        if (objZ == b.c()) {
            h.c(fVar);
        }
        return objZ;
    }

    public abstract void loadInitial(LoadInitialParams<Key> params, LoadInitialCallback<Key, Value> callback);

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0016\u0018\u0000*\b\b\u0002\u0010\u0001*\u00020\u00022\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Landroidx/paging/PageKeyedDataSource$LoadInitialParams;", "Key", "", "requestedLoadSize", "", "placeholdersEnabled", "", "(IZ)V", "paging-common"}, k = 1, mv = {1, 4, 1})
    public static class LoadInitialParams<Key> {
        public final boolean placeholdersEnabled;
        public final int requestedLoadSize;

        public LoadInitialParams(int i10, boolean z10) {
            this.requestedLoadSize = i10;
            this.placeholdersEnabled = z10;
        }
    }

    public PageKeyedDataSource() {
        super(DataSource.KeyType.PAGE_KEYED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LoadCallback<Key, Value> continuationAsCallback(final n<? super DataSource.BaseResult<Value>> continuation, final boolean isAppend) {
        return new LoadCallback<Key, Value>() { // from class: androidx.paging.PageKeyedDataSource.continuationAsCallback.1
            @Override // androidx.paging.PageKeyedDataSource.LoadCallback
            public void onResult(List<? extends Value> data, Key adjacentPageKey) {
                m.f(data, "data");
                n nVar = continuation;
                boolean z10 = isAppend;
                Key key = null;
                Key key2 = z10 ? null : adjacentPageKey;
                if (z10) {
                    key = adjacentPageKey;
                }
                nVar.resumeWith(q.a(new DataSource.BaseResult(data, key2, key, 0, 0, 24, null)));
            }
        };
    }

    @Override // androidx.paging.DataSource
    public Key getKeyInternal$paging_common(Value item) {
        m.f(item, "item");
        throw new IllegalStateException("Cannot get key by item in pageKeyedDataSource");
    }

    @Override // androidx.paging.DataSource
    /* JADX INFO: renamed from: getSupportsPageDropping$paging_common, reason: from getter */
    public boolean getSupportsPageDropping() {
        return this.supportsPageDropping;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005e, code lost:
    
        if (r8 == r1) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x008c, code lost:
    
        if (r8 == r1) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00ad, code lost:
    
        if (r8 == r1) goto L40;
     */
    @Override // androidx.paging.DataSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object load$paging_common(DataSource.Params<Key> params, f<? super DataSource.BaseResult<Value>> fVar) {
        PageKeyedDataSource$load$1 pageKeyedDataSource$load$1;
        if (fVar instanceof PageKeyedDataSource$load$1) {
            pageKeyedDataSource$load$1 = (PageKeyedDataSource$load$1) fVar;
            int i10 = pageKeyedDataSource$load$1.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                pageKeyedDataSource$load$1.label = i10 - Integer.MIN_VALUE;
            } else {
                pageKeyedDataSource$load$1 = new PageKeyedDataSource$load$1(this, fVar);
            }
        } else {
            pageKeyedDataSource$load$1 = new PageKeyedDataSource$load$1(this, fVar);
        }
        Object objLoadAfter = pageKeyedDataSource$load$1.result;
        Object objC = b.c();
        int i11 = pageKeyedDataSource$load$1.label;
        if (i11 != 0) {
            if (i11 == 1) {
                r.b(objLoadAfter);
                return (DataSource.BaseResult) objLoadAfter;
            }
            if (i11 == 2) {
                r.b(objLoadAfter);
                return (DataSource.BaseResult) objLoadAfter;
            }
            if (i11 != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            r.b(objLoadAfter);
            return (DataSource.BaseResult) objLoadAfter;
        }
        r.b(objLoadAfter);
        if (params.getType() == LoadType.REFRESH) {
            LoadInitialParams<Key> loadInitialParams = new LoadInitialParams<>(params.getInitialLoadSize(), params.getPlaceholdersEnabled());
            pageKeyedDataSource$load$1.label = 1;
            objLoadAfter = loadInitial(loadInitialParams, pageKeyedDataSource$load$1);
        } else {
            if (params.getKey() == null) {
                return DataSource.BaseResult.INSTANCE.empty$paging_common();
            }
            if (params.getType() == LoadType.PREPEND) {
                LoadParams<Key> loadParams = new LoadParams<>(params.getKey(), params.getPageSize());
                pageKeyedDataSource$load$1.label = 2;
                objLoadAfter = loadBefore(loadParams, pageKeyedDataSource$load$1);
            } else {
                if (params.getType() != LoadType.APPEND) {
                    throw new IllegalArgumentException("Unsupported type " + params.getType().toString());
                }
                LoadParams<Key> loadParams2 = new LoadParams<>(params.getKey(), params.getPageSize());
                pageKeyedDataSource$load$1.label = 3;
                objLoadAfter = loadAfter(loadParams2, pageKeyedDataSource$load$1);
            }
        }
        return objC;
    }

    @Override // androidx.paging.DataSource
    public final <ToValue> PageKeyedDataSource<Key, ToValue> map(final Function<Value, ToValue> function) {
        m.f(function, "function");
        return mapByPage((Function) new Function<List<? extends Value>, List<? extends ToValue>>() { // from class: androidx.paging.PageKeyedDataSource.map.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.arch.core.util.Function
            public final List<ToValue> apply(List<? extends Value> list) {
                m.e(list, "list");
                List<? extends Value> list2 = list;
                ArrayList arrayList = new ArrayList(kotlin.collections.r.w(list2, 10));
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    arrayList.add(function.apply(it.next()));
                }
                return arrayList;
            }
        });
    }

    @Override // androidx.paging.DataSource
    public final <ToValue> PageKeyedDataSource<Key, ToValue> mapByPage(Function<List<Value>, List<ToValue>> function) {
        m.f(function, "function");
        return new WrapperPageKeyedDataSource(this, function);
    }

    @Override // androidx.paging.DataSource
    public final <ToValue> PageKeyedDataSource<Key, ToValue> map(final l<? super Value, ? extends ToValue> function) {
        m.f(function, "function");
        return mapByPage((Function) new Function<List<? extends Value>, List<? extends ToValue>>() { // from class: androidx.paging.PageKeyedDataSource.map.2
            @Override // androidx.arch.core.util.Function
            public final List<ToValue> apply(List<? extends Value> list) {
                m.e(list, "list");
                List<? extends Value> list2 = list;
                l lVar = function;
                ArrayList arrayList = new ArrayList(kotlin.collections.r.w(list2, 10));
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    arrayList.add(lVar.invoke(it.next()));
                }
                return arrayList;
            }
        });
    }

    @Override // androidx.paging.DataSource
    public final <ToValue> PageKeyedDataSource<Key, ToValue> mapByPage(final l<? super List<? extends Value>, ? extends List<? extends ToValue>> function) {
        m.f(function, "function");
        return mapByPage((Function) new Function<List<? extends Value>, List<? extends ToValue>>() { // from class: androidx.paging.PageKeyedDataSource.mapByPage.1
            @Override // androidx.arch.core.util.Function
            public final List<ToValue> apply(List<? extends Value> it) {
                l lVar = function;
                m.e(it, "it");
                return (List) lVar.invoke(it);
            }
        });
    }

    public static /* synthetic */ void getSupportsPageDropping$paging_common$annotations() {
    }
}
