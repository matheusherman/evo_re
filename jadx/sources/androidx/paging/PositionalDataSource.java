package androidx.paging;

import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.arch.core.util.Function;
import androidx.exifinterface.media.ExifInterface;
import c9.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.r;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.h;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.o;
import r8.q;
import v8.f;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\b'\u0018\u0000 -*\b\b\u0000\u0010\u0002*\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0003:\u0005-./01B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007H\u0080@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\u0006\u0010\b\u001a\u00020\rH\u0081@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\u0006\u0010\b\u001a\u00020\u0011H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0010\u001a\u00020\u00162\u0006\u0010\b\u001a\u00020\r2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H'¢\u0006\u0004\b\u0010\u0010\u0017J%\u0010\u0012\u001a\u00020\u00162\u0006\u0010\b\u001a\u00020\u00112\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H'¢\u0006\u0004\b\u0012\u0010\u0019J\u0017\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00028\u0000H\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ=\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000\"\b\b\u0001\u0010\u001e*\u00020\u00012\u001e\u0010!\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000 \u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010 0\u001f¢\u0006\u0004\b\"\u0010#J=\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000\"\b\b\u0001\u0010\u001e*\u00020\u00012\u001e\u0010!\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000 \u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010 0$¢\u0006\u0004\b\"\u0010%J1\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000\"\b\b\u0001\u0010\u001e*\u00020\u00012\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001f¢\u0006\u0004\b&\u0010#J1\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000\"\b\b\u0001\u0010\u001e*\u00020\u00012\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010$¢\u0006\u0004\b&\u0010%R \u0010(\u001a\u00020'8\u0010X\u0090D¢\u0006\u0012\n\u0004\b(\u0010)\u0012\u0004\b,\u0010\u0006\u001a\u0004\b*\u0010+\u0082\u0002\u0004\n\u0002\b\u0019¨\u00062"}, d2 = {"Landroidx/paging/PositionalDataSource;", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/paging/DataSource;", "", "<init>", "()V", "Landroidx/paging/DataSource$Params;", "params", "Landroidx/paging/DataSource$BaseResult;", "load$paging_common", "(Landroidx/paging/DataSource$Params;Lv8/f;)Ljava/lang/Object;", "load", "Landroidx/paging/PositionalDataSource$LoadInitialParams;", "loadInitial$paging_common", "(Landroidx/paging/PositionalDataSource$LoadInitialParams;Lv8/f;)Ljava/lang/Object;", "loadInitial", "Landroidx/paging/PositionalDataSource$LoadRangeParams;", "loadRange", "(Landroidx/paging/PositionalDataSource$LoadRangeParams;Lv8/f;)Ljava/lang/Object;", "Landroidx/paging/PositionalDataSource$LoadInitialCallback;", "callback", "Lr8/z;", "(Landroidx/paging/PositionalDataSource$LoadInitialParams;Landroidx/paging/PositionalDataSource$LoadInitialCallback;)V", "Landroidx/paging/PositionalDataSource$LoadRangeCallback;", "(Landroidx/paging/PositionalDataSource$LoadRangeParams;Landroidx/paging/PositionalDataSource$LoadRangeCallback;)V", "item", "getKeyInternal$paging_common", "(Ljava/lang/Object;)Ljava/lang/Integer;", "getKeyInternal", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Landroidx/arch/core/util/Function;", "", "function", "mapByPage", "(Landroidx/arch/core/util/Function;)Landroidx/paging/PositionalDataSource;", "Lkotlin/Function1;", "(Lc9/l;)Landroidx/paging/PositionalDataSource;", "map", "", "isContiguous", "Z", "isContiguous$paging_common", "()Z", "isContiguous$paging_common$annotations", "Companion", "LoadInitialCallback", "LoadInitialParams", "LoadRangeCallback", "LoadRangeParams", "paging-common"}, k = 1, mv = {1, 4, 1})
public abstract class PositionalDataSource<T> extends DataSource<Integer, T> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final boolean isContiguous;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0007J \u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0007¨\u0006\n"}, d2 = {"Landroidx/paging/PositionalDataSource$Companion;", "", "()V", "computeInitialLoadPosition", "", "params", "Landroidx/paging/PositionalDataSource$LoadInitialParams;", "totalCount", "computeInitialLoadSize", "initialLoadPosition", "paging-common"}, k = 1, mv = {1, 4, 1})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final int computeInitialLoadPosition(LoadInitialParams params, int totalCount) {
            m.f(params, "params");
            int i10 = params.requestedStartPosition;
            int i11 = params.requestedLoadSize;
            int i12 = params.pageSize;
            return Math.max(0, Math.min(((((totalCount - i11) + i12) - 1) / i12) * i12, (i10 / i12) * i12));
        }

        public final int computeInitialLoadSize(LoadInitialParams params, int initialLoadPosition, int totalCount) {
            m.f(params, "params");
            return Math.min(totalCount - initialLoadPosition, params.requestedLoadSize);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J-\u0010\u000b\u001a\u00020\n2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H&¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\u000b\u001a\u00020\n2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u000b\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/paging/PositionalDataSource$LoadInitialCallback;", ExifInterface.GPS_DIRECTION_TRUE, "", "<init>", "()V", "", "data", "", "position", "totalCount", "Lr8/z;", "onResult", "(Ljava/util/List;II)V", "(Ljava/util/List;I)V", "paging-common"}, k = 1, mv = {1, 4, 1})
    public static abstract class LoadInitialCallback<T> {
        public abstract void onResult(List<? extends T> data, int position);

        public abstract void onResult(List<? extends T> data, int position, int totalCount);
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroidx/paging/PositionalDataSource$LoadRangeCallback;", ExifInterface.GPS_DIRECTION_TRUE, "", "<init>", "()V", "", "data", "Lr8/z;", "onResult", "(Ljava/util/List;)V", "paging-common"}, k = 1, mv = {1, 4, 1})
    public static abstract class LoadRangeCallback<T> {
        public abstract void onResult(List<? extends T> data);
    }

    @WorkerThread
    public abstract void loadInitial(LoadInitialParams params, LoadInitialCallback<T> callback);

    final /* synthetic */ Object loadRange(final LoadRangeParams loadRangeParams, f<? super DataSource.BaseResult<T>> fVar) {
        final o oVar = new o(b.b(fVar), 1);
        oVar.D();
        loadRange(loadRangeParams, new LoadRangeCallback<T>() { // from class: androidx.paging.PositionalDataSource$loadRange$$inlined$suspendCancellableCoroutine$lambda$1
            @Override // androidx.paging.PositionalDataSource.LoadRangeCallback
            public void onResult(List<? extends T> data) {
                m.f(data, "data");
                int i10 = loadRangeParams.startPosition;
                Integer numValueOf = i10 == 0 ? null : Integer.valueOf(i10);
                if (this.isInvalid()) {
                    oVar.resumeWith(q.a(DataSource.BaseResult.INSTANCE.empty$paging_common()));
                } else {
                    oVar.resumeWith(q.a(new DataSource.BaseResult(data, numValueOf, Integer.valueOf(loadRangeParams.startPosition + data.size()), 0, 0, 24, null)));
                }
            }
        });
        Object objZ = oVar.z();
        if (objZ == b.c()) {
            h.c(fVar);
        }
        return objZ;
    }

    @WorkerThread
    public abstract void loadRange(LoadRangeParams params, LoadRangeCallback<T> callback);

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0010\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Landroidx/paging/PositionalDataSource$LoadInitialParams;", "", "requestedStartPosition", "", "requestedLoadSize", "pageSize", "placeholdersEnabled", "", "(IIIZ)V", "paging-common"}, k = 1, mv = {1, 4, 1})
    public static class LoadInitialParams {
        public final int pageSize;
        public final boolean placeholdersEnabled;
        public final int requestedLoadSize;
        public final int requestedStartPosition;

        public LoadInitialParams(int i10, int i11, int i12, boolean z10) {
            this.requestedStartPosition = i10;
            this.requestedLoadSize = i11;
            this.pageSize = i12;
            this.placeholdersEnabled = z10;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0010\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Landroidx/paging/PositionalDataSource$LoadRangeParams;", "", "startPosition", "", "loadSize", "(II)V", "paging-common"}, k = 1, mv = {1, 4, 1})
    public static class LoadRangeParams {
        public final int loadSize;
        public final int startPosition;

        public LoadRangeParams(int i10, int i11) {
            this.startPosition = i10;
            this.loadSize = i11;
        }
    }

    public PositionalDataSource() {
        super(DataSource.KeyType.POSITIONAL);
    }

    public static final int computeInitialLoadPosition(LoadInitialParams loadInitialParams, int i10) {
        return INSTANCE.computeInitialLoadPosition(loadInitialParams, i10);
    }

    public static final int computeInitialLoadSize(LoadInitialParams loadInitialParams, int i10, int i11) {
        return INSTANCE.computeInitialLoadSize(loadInitialParams, i10, i11);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.paging.DataSource
    public final Integer getKeyInternal$paging_common(T item) {
        m.f(item, "item");
        throw new IllegalStateException("Cannot get key by item in positionalDataSource");
    }

    @Override // androidx.paging.DataSource
    /* JADX INFO: renamed from: isContiguous$paging_common, reason: from getter */
    public boolean getIsContiguous() {
        return this.isContiguous;
    }

    @VisibleForTesting
    public final Object loadInitial$paging_common(final LoadInitialParams loadInitialParams, f<? super DataSource.BaseResult<T>> fVar) {
        final o oVar = new o(b.b(fVar), 1);
        oVar.D();
        loadInitial(loadInitialParams, new LoadInitialCallback<T>() { // from class: androidx.paging.PositionalDataSource$loadInitial$$inlined$suspendCancellableCoroutine$lambda$1
            @Override // androidx.paging.PositionalDataSource.LoadInitialCallback
            public void onResult(List<? extends T> data, int position, int totalCount) {
                m.f(data, "data");
                if (this.isInvalid()) {
                    oVar.resumeWith(q.a(DataSource.BaseResult.INSTANCE.empty$paging_common()));
                } else {
                    int size = data.size() + position;
                    resume(loadInitialParams, new DataSource.BaseResult<>(data, position == 0 ? null : Integer.valueOf(position), size != totalCount ? Integer.valueOf(size) : null, position, (totalCount - data.size()) - position));
                }
            }

            private final void resume(PositionalDataSource.LoadInitialParams params, DataSource.BaseResult<T> result) {
                if (params.placeholdersEnabled) {
                    result.validateForInitialTiling$paging_common(params.pageSize);
                }
                oVar.resumeWith(q.a(result));
            }

            @Override // androidx.paging.PositionalDataSource.LoadInitialCallback
            public void onResult(List<? extends T> data, int position) {
                m.f(data, "data");
                if (this.isInvalid()) {
                    oVar.resumeWith(q.a(DataSource.BaseResult.INSTANCE.empty$paging_common()));
                } else {
                    resume(loadInitialParams, new DataSource.BaseResult<>(data, position == 0 ? null : Integer.valueOf(position), Integer.valueOf(data.size() + position), position, Integer.MIN_VALUE));
                }
            }
        });
        Object objZ = oVar.z();
        if (objZ == b.c()) {
            h.c(fVar);
        }
        return objZ;
    }

    @Override // androidx.paging.DataSource
    public final Object load$paging_common(DataSource.Params<Integer> params, f<? super DataSource.BaseResult<T>> fVar) {
        if (params.getType() == LoadType.REFRESH) {
            int initialLoadSize = params.getInitialLoadSize();
            int iMax = 0;
            if (params.getKey() != null) {
                int iIntValue = params.getKey().intValue();
                if (params.getPlaceholdersEnabled()) {
                    initialLoadSize = Math.max(initialLoadSize / params.getPageSize(), 2) * params.getPageSize();
                    iMax = Math.max(0, ((iIntValue - (initialLoadSize / 2)) / params.getPageSize()) * params.getPageSize());
                } else {
                    iMax = iIntValue - (initialLoadSize / 2);
                }
            }
            return loadInitial$paging_common(new LoadInitialParams(iMax, initialLoadSize, params.getPageSize(), params.getPlaceholdersEnabled()), fVar);
        }
        Integer key = params.getKey();
        m.c(key);
        int iIntValue2 = key.intValue();
        int pageSize = params.getPageSize();
        if (params.getType() == LoadType.PREPEND) {
            pageSize = Math.min(pageSize, iIntValue2);
            iIntValue2 -= pageSize;
        }
        return loadRange(new LoadRangeParams(iIntValue2, pageSize), fVar);
    }

    @Override // androidx.paging.DataSource
    public final <V> PositionalDataSource<V> map(final Function<T, V> function) {
        m.f(function, "function");
        return mapByPage((Function) new Function<List<? extends T>, List<? extends V>>() { // from class: androidx.paging.PositionalDataSource.map.1
            @Override // androidx.arch.core.util.Function
            public final List<V> apply(List<? extends T> list) {
                m.e(list, "list");
                List<? extends T> list2 = list;
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
    public final <V> PositionalDataSource<V> mapByPage(Function<List<T>, List<V>> function) {
        m.f(function, "function");
        return new WrapperPositionalDataSource(this, function);
    }

    @Override // androidx.paging.DataSource
    public final <V> PositionalDataSource<V> map(final l<? super T, ? extends V> function) {
        m.f(function, "function");
        return mapByPage((Function) new Function<List<? extends T>, List<? extends V>>() { // from class: androidx.paging.PositionalDataSource.map.2
            @Override // androidx.arch.core.util.Function
            public final List<V> apply(List<? extends T> list) {
                m.e(list, "list");
                List<? extends T> list2 = list;
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
    public final <V> PositionalDataSource<V> mapByPage(final l<? super List<? extends T>, ? extends List<? extends V>> function) {
        m.f(function, "function");
        return mapByPage((Function) new Function<List<? extends T>, List<? extends V>>() { // from class: androidx.paging.PositionalDataSource.mapByPage.1
            @Override // androidx.arch.core.util.Function
            public final List<V> apply(List<? extends T> it) {
                l lVar = function;
                m.e(it, "it");
                return (List) lVar.invoke(it);
            }
        });
    }

    public static /* synthetic */ void isContiguous$paging_common$annotations() {
    }
}
