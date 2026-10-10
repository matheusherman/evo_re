package androidx.paging;

import androidx.arch.core.util.Function;
import androidx.exifinterface.media.ExifInterface;
import java.util.IdentityHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u0001*\b\b\u0002\u0010\u0004*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u0005B;\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u001e\u0010\t\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\b0\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00020\b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\b¢\u0006\u0004\b\u0014\u0010\u0015J+\u0010\u001a\u001a\u00020\u000e2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00162\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ+\u0010\u001e\u001a\u00020\u000e2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u001c2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ+\u0010 \u001a\u00020\u000e2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u001c2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00020\u001dH\u0016¢\u0006\u0004\b \u0010\u001fJ\u0017\u0010\"\u001a\u00028\u00002\u0006\u0010!\u001a\u00028\u0002H\u0016¢\u0006\u0004\b\"\u0010#R \u0010%\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00000$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010'R,\u0010\t\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\b0\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010(R\u0014\u0010*\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+¨\u0006,"}, d2 = {"Landroidx/paging/WrapperItemKeyedDataSource;", "", "K", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "Landroidx/paging/ItemKeyedDataSource;", "source", "Landroidx/arch/core/util/Function;", "", "listFunction", "<init>", "(Landroidx/paging/ItemKeyedDataSource;Landroidx/arch/core/util/Function;)V", "Landroidx/paging/DataSource$InvalidatedCallback;", "onInvalidatedCallback", "Lr8/z;", "addInvalidatedCallback", "(Landroidx/paging/DataSource$InvalidatedCallback;)V", "removeInvalidatedCallback", "invalidate", "()V", "convertWithStashedKeys", "(Ljava/util/List;)Ljava/util/List;", "Landroidx/paging/ItemKeyedDataSource$LoadInitialParams;", "params", "Landroidx/paging/ItemKeyedDataSource$LoadInitialCallback;", "callback", "loadInitial", "(Landroidx/paging/ItemKeyedDataSource$LoadInitialParams;Landroidx/paging/ItemKeyedDataSource$LoadInitialCallback;)V", "Landroidx/paging/ItemKeyedDataSource$LoadParams;", "Landroidx/paging/ItemKeyedDataSource$LoadCallback;", "loadAfter", "(Landroidx/paging/ItemKeyedDataSource$LoadParams;Landroidx/paging/ItemKeyedDataSource$LoadCallback;)V", "loadBefore", "item", "getKey", "(Ljava/lang/Object;)Ljava/lang/Object;", "Ljava/util/IdentityHashMap;", "keyMap", "Ljava/util/IdentityHashMap;", "Landroidx/paging/ItemKeyedDataSource;", "Landroidx/arch/core/util/Function;", "", "isInvalid", "()Z", "paging-common"}, k = 1, mv = {1, 4, 1})
public final class WrapperItemKeyedDataSource<K, A, B> extends ItemKeyedDataSource<K, B> {
    private final IdentityHashMap<B, K> keyMap;
    private final Function<List<A>, List<B>> listFunction;
    private final ItemKeyedDataSource<K, A> source;

    public WrapperItemKeyedDataSource(ItemKeyedDataSource<K, A> source, Function<List<A>, List<B>> listFunction) {
        m.f(source, "source");
        m.f(listFunction, "listFunction");
        this.source = source;
        this.listFunction = listFunction;
        this.keyMap = new IdentityHashMap<>();
    }

    @Override // androidx.paging.DataSource
    public void addInvalidatedCallback(DataSource.InvalidatedCallback onInvalidatedCallback) {
        m.f(onInvalidatedCallback, "onInvalidatedCallback");
        this.source.addInvalidatedCallback(onInvalidatedCallback);
    }

    public final List<B> convertWithStashedKeys(List<? extends A> source) {
        m.f(source, "source");
        List<B> listConvert$paging_common = DataSource.INSTANCE.convert$paging_common(this.listFunction, source);
        synchronized (this.keyMap) {
            try {
                int size = listConvert$paging_common.size();
                for (int i10 = 0; i10 < size; i10++) {
                    this.keyMap.put(listConvert$paging_common.get(i10), this.source.getKey(source.get(i10)));
                }
                z zVar = z.f17874a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return listConvert$paging_common;
    }

    @Override // androidx.paging.ItemKeyedDataSource
    public K getKey(B item) {
        K k10;
        m.f(item, "item");
        synchronized (this.keyMap) {
            k10 = this.keyMap.get(item);
            m.c(k10);
        }
        return k10;
    }

    @Override // androidx.paging.DataSource
    public void invalidate() {
        this.source.invalidate();
    }

    @Override // androidx.paging.DataSource
    public boolean isInvalid() {
        return this.source.isInvalid();
    }

    @Override // androidx.paging.ItemKeyedDataSource
    public void loadAfter(ItemKeyedDataSource.LoadParams<K> params, final ItemKeyedDataSource.LoadCallback<B> callback) {
        m.f(params, "params");
        m.f(callback, "callback");
        this.source.loadAfter(params, new ItemKeyedDataSource.LoadCallback<A>() { // from class: androidx.paging.WrapperItemKeyedDataSource.loadAfter.1
            @Override // androidx.paging.ItemKeyedDataSource.LoadCallback
            public void onResult(List<? extends A> data) {
                m.f(data, "data");
                callback.onResult(WrapperItemKeyedDataSource.this.convertWithStashedKeys(data));
            }
        });
    }

    @Override // androidx.paging.ItemKeyedDataSource
    public void loadBefore(ItemKeyedDataSource.LoadParams<K> params, final ItemKeyedDataSource.LoadCallback<B> callback) {
        m.f(params, "params");
        m.f(callback, "callback");
        this.source.loadBefore(params, new ItemKeyedDataSource.LoadCallback<A>() { // from class: androidx.paging.WrapperItemKeyedDataSource.loadBefore.1
            @Override // androidx.paging.ItemKeyedDataSource.LoadCallback
            public void onResult(List<? extends A> data) {
                m.f(data, "data");
                callback.onResult(WrapperItemKeyedDataSource.this.convertWithStashedKeys(data));
            }
        });
    }

    @Override // androidx.paging.ItemKeyedDataSource
    public void loadInitial(ItemKeyedDataSource.LoadInitialParams<K> params, final ItemKeyedDataSource.LoadInitialCallback<B> callback) {
        m.f(params, "params");
        m.f(callback, "callback");
        this.source.loadInitial(params, new ItemKeyedDataSource.LoadInitialCallback<A>() { // from class: androidx.paging.WrapperItemKeyedDataSource.loadInitial.1
            @Override // androidx.paging.ItemKeyedDataSource.LoadInitialCallback
            public void onResult(List<? extends A> data, int position, int totalCount) {
                m.f(data, "data");
                callback.onResult(WrapperItemKeyedDataSource.this.convertWithStashedKeys(data), position, totalCount);
            }

            @Override // androidx.paging.ItemKeyedDataSource.LoadCallback
            public void onResult(List<? extends A> data) {
                m.f(data, "data");
                callback.onResult(WrapperItemKeyedDataSource.this.convertWithStashedKeys(data));
            }
        });
    }

    @Override // androidx.paging.DataSource
    public void removeInvalidatedCallback(DataSource.InvalidatedCallback onInvalidatedCallback) {
        m.f(onInvalidatedCallback, "onInvalidatedCallback");
        this.source.removeInvalidatedCallback(onInvalidatedCallback);
    }
}
