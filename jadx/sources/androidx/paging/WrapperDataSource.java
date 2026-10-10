package androidx.paging;

import androidx.arch.core.util.Function;
import java.util.IdentityHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.b;
import kotlin.jvm.internal.m;
import r8.r;
import r8.z;
import v8.f;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0010\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u0001*\b\b\u0002\u0010\u0004*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u0005B;\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u001e\u0010\t\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\b0\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0017\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00028\u0002H\u0010¢\u0006\u0004\b\u0015\u0010\u0016J)\u0010\u0019\u001a\u00020\u000e2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\b2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00020\b¢\u0006\u0004\b\u0019\u0010\u001aJ'\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00020\u001d2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001bH\u0090@ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fR\"\u0010\"\u001a\u0010\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0000\u0018\u00010!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010$R,\u0010\t\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\b0\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010%R\u0014\u0010'\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006)"}, d2 = {"Landroidx/paging/WrapperDataSource;", "", "Key", "ValueFrom", "ValueTo", "Landroidx/paging/DataSource;", "source", "Landroidx/arch/core/util/Function;", "", "listFunction", "<init>", "(Landroidx/paging/DataSource;Landroidx/arch/core/util/Function;)V", "Landroidx/paging/DataSource$InvalidatedCallback;", "onInvalidatedCallback", "Lr8/z;", "addInvalidatedCallback", "(Landroidx/paging/DataSource$InvalidatedCallback;)V", "removeInvalidatedCallback", "invalidate", "()V", "item", "getKeyInternal$paging_common", "(Ljava/lang/Object;)Ljava/lang/Object;", "getKeyInternal", "dest", "stashKeysIfNeeded", "(Ljava/util/List;Ljava/util/List;)V", "Landroidx/paging/DataSource$Params;", "params", "Landroidx/paging/DataSource$BaseResult;", "load$paging_common", "(Landroidx/paging/DataSource$Params;Lv8/f;)Ljava/lang/Object;", "load", "Ljava/util/IdentityHashMap;", "keyMap", "Ljava/util/IdentityHashMap;", "Landroidx/paging/DataSource;", "Landroidx/arch/core/util/Function;", "", "isInvalid", "()Z", "paging-common"}, k = 1, mv = {1, 4, 1})
public class WrapperDataSource<Key, ValueFrom, ValueTo> extends DataSource<Key, ValueTo> {
    private final IdentityHashMap<ValueTo, Key> keyMap;
    private final Function<List<ValueFrom>, List<ValueTo>> listFunction;
    private final DataSource<Key, ValueFrom> source;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DataSource.KeyType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[DataSource.KeyType.ITEM_KEYED.ordinal()] = 1;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WrapperDataSource(DataSource<Key, ValueFrom> source, Function<List<ValueFrom>, List<ValueTo>> listFunction) {
        super(source.getType());
        m.f(source, "source");
        m.f(listFunction, "listFunction");
        this.source = source;
        this.listFunction = listFunction;
        this.keyMap = WhenMappings.$EnumSwitchMapping$0[source.getType().ordinal()] != 1 ? null : new IdentityHashMap<>();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Object load$paging_common$suspendImpl(WrapperDataSource wrapperDataSource, DataSource.Params params, f fVar) {
        WrapperDataSource$load$1 wrapperDataSource$load$1;
        WrapperDataSource wrapperDataSource2;
        if (fVar instanceof WrapperDataSource$load$1) {
            wrapperDataSource$load$1 = (WrapperDataSource$load$1) fVar;
            int i10 = wrapperDataSource$load$1.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                wrapperDataSource$load$1.label = i10 - Integer.MIN_VALUE;
            } else {
                wrapperDataSource$load$1 = new WrapperDataSource$load$1(wrapperDataSource, fVar);
            }
        } else {
            wrapperDataSource$load$1 = new WrapperDataSource$load$1(wrapperDataSource, fVar);
        }
        Object objLoad$paging_common = wrapperDataSource$load$1.result;
        Object objC = b.c();
        int i11 = wrapperDataSource$load$1.label;
        if (i11 == 0) {
            r.b(objLoad$paging_common);
            DataSource<Key, ValueFrom> dataSource = wrapperDataSource.source;
            wrapperDataSource$load$1.L$0 = wrapperDataSource;
            wrapperDataSource$load$1.label = 1;
            objLoad$paging_common = dataSource.load$paging_common(params, wrapperDataSource$load$1);
            if (objLoad$paging_common == objC) {
                wrapperDataSource2 = wrapperDataSource;
                return objC;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            WrapperDataSource wrapperDataSource3 = (WrapperDataSource) wrapperDataSource$load$1.L$0;
            r.b(objLoad$paging_common);
            wrapperDataSource2 = wrapperDataSource3;
        }
        wrapperDataSource2 = wrapperDataSource;
        DataSource.BaseResult baseResult = (DataSource.BaseResult) objLoad$paging_common;
        DataSource.BaseResult baseResultConvert$paging_common = DataSource.BaseResult.INSTANCE.convert$paging_common(baseResult, wrapperDataSource2.listFunction);
        wrapperDataSource2.stashKeysIfNeeded(baseResult.data, baseResultConvert$paging_common.data);
        return baseResultConvert$paging_common;
    }

    @Override // androidx.paging.DataSource
    public void addInvalidatedCallback(DataSource.InvalidatedCallback onInvalidatedCallback) {
        m.f(onInvalidatedCallback, "onInvalidatedCallback");
        this.source.addInvalidatedCallback(onInvalidatedCallback);
    }

    @Override // androidx.paging.DataSource
    public Key getKeyInternal$paging_common(ValueTo item) {
        Key key;
        m.f(item, "item");
        IdentityHashMap<ValueTo, Key> identityHashMap = this.keyMap;
        if (identityHashMap == null) {
            throw new IllegalStateException("Cannot get key by item in non-item keyed DataSource");
        }
        synchronized (identityHashMap) {
            key = this.keyMap.get(item);
            m.c(key);
        }
        return key;
    }

    @Override // androidx.paging.DataSource
    public void invalidate() {
        this.source.invalidate();
    }

    @Override // androidx.paging.DataSource
    public boolean isInvalid() {
        return this.source.isInvalid();
    }

    @Override // androidx.paging.DataSource
    public void removeInvalidatedCallback(DataSource.InvalidatedCallback onInvalidatedCallback) {
        m.f(onInvalidatedCallback, "onInvalidatedCallback");
        this.source.removeInvalidatedCallback(onInvalidatedCallback);
    }

    public final void stashKeysIfNeeded(List<? extends ValueFrom> source, List<? extends ValueTo> dest) {
        m.f(source, "source");
        m.f(dest, "dest");
        IdentityHashMap<ValueTo, Key> identityHashMap = this.keyMap;
        if (identityHashMap != null) {
            synchronized (identityHashMap) {
                try {
                    int size = dest.size();
                    for (int i10 = 0; i10 < size; i10++) {
                        IdentityHashMap<ValueTo, Key> identityHashMap2 = this.keyMap;
                        ValueTo valueto = dest.get(i10);
                        DataSource<Key, ValueFrom> dataSource = this.source;
                        if (dataSource == null) {
                            throw new NullPointerException("null cannot be cast to non-null type androidx.paging.ItemKeyedDataSource<Key, ValueFrom>");
                        }
                        identityHashMap2.put(valueto, (Key) ((ItemKeyedDataSource) dataSource).getKey(source.get(i10)));
                    }
                    z zVar = z.f17874a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // androidx.paging.DataSource
    public Object load$paging_common(DataSource.Params<Key> params, f<? super DataSource.BaseResult<ValueTo>> fVar) {
        return load$paging_common$suspendImpl(this, params, fVar);
    }
}
