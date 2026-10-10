package androidx.paging;

import androidx.annotation.VisibleForTesting;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.r;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0007\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050\u0004B!\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001c\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005H\u0086\u0002¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rR2\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050\u000e8\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u0012\u0004\b\u0013\u0010\r\u001a\u0004\b\u0011\u0010\u0012R&\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0014¨\u0006\u0015"}, d2 = {"Landroidx/paging/InvalidatingPagingSourceFactory;", "", "Key", "Value", "Lkotlin/Function0;", "Landroidx/paging/PagingSource;", "pagingSourceFactory", "<init>", "(Lc9/a;)V", "invoke", "()Landroidx/paging/PagingSource;", "Lr8/z;", "invalidate", "()V", "", "pagingSources", "Ljava/util/List;", "getPagingSources$paging_common", "()Ljava/util/List;", "getPagingSources$paging_common$annotations", "Lc9/a;", "paging-common"}, k = 1, mv = {1, 4, 1})
public class InvalidatingPagingSourceFactory<Key, Value> implements c9.a<PagingSource<Key, Value>> {
    private final c9.a<PagingSource<Key, Value>> pagingSourceFactory;
    private final List<PagingSource<Key, Value>> pagingSources;

    /* JADX WARN: Multi-variable type inference failed */
    public InvalidatingPagingSourceFactory(c9.a<? extends PagingSource<Key, Value>> pagingSourceFactory) {
        m.f(pagingSourceFactory, "pagingSourceFactory");
        this.pagingSourceFactory = pagingSourceFactory;
        this.pagingSources = new ArrayList();
    }

    public final List<PagingSource<Key, Value>> getPagingSources$paging_common() {
        return this.pagingSources;
    }

    public final void invalidate() {
        while (!this.pagingSources.isEmpty()) {
            PagingSource pagingSource = (PagingSource) r.J(this.pagingSources);
            if (!pagingSource.getInvalid()) {
                pagingSource.invalidate();
            }
        }
    }

    @Override // c9.a
    public final PagingSource<Key, Value> invoke() {
        PagingSource<Key, Value> pagingSourceInvoke = this.pagingSourceFactory.invoke();
        this.pagingSources.add(pagingSourceInvoke);
        return pagingSourceInvoke;
    }

    @VisibleForTesting
    public static /* synthetic */ void getPagingSources$paging_common$annotations() {
    }
}
