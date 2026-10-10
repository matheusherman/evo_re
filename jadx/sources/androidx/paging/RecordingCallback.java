package androidx.paging;

import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import h9.c;
import h9.f;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\n\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\tJ\u001f\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\tJ\u0015\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0001¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Landroidx/paging/RecordingCallback;", "Landroidx/paging/PagedList$Callback;", "<init>", "()V", "", "position", "count", "Lr8/z;", "onChanged", "(II)V", "onInserted", "onRemoved", TransactionPartnerType.OTHER, "dispatchRecordingTo", "(Landroidx/paging/PagedList$Callback;)V", "", "list", "Ljava/util/List;", "Companion", "paging-runtime_release"}, k = 1, mv = {1, 4, 1})
public final class RecordingCallback extends PagedList.Callback {
    private static final int Changed = 0;
    private static final int Inserted = 1;
    private static final int Removed = 2;
    private final List<Integer> list = new ArrayList();

    public final void dispatchRecordingTo(PagedList.Callback other) {
        m.f(other, "other");
        c cVarL = f.l(f.m(0, this.list.size()), 3);
        int first = cVarL.getFirst();
        int last = cVarL.getLast();
        int step = cVarL.getStep();
        if (step < 0 ? first >= last : first <= last) {
            while (true) {
                int iIntValue = this.list.get(first).intValue();
                if (iIntValue == 0) {
                    other.onChanged(this.list.get(first + 1).intValue(), this.list.get(first + 2).intValue());
                } else if (iIntValue == 1) {
                    other.onInserted(this.list.get(first + 1).intValue(), this.list.get(first + 2).intValue());
                } else {
                    if (iIntValue != 2) {
                        throw new IllegalStateException("Unexpected recording value");
                    }
                    other.onRemoved(this.list.get(first + 1).intValue(), this.list.get(first + 2).intValue());
                }
                if (first == last) {
                    break;
                } else {
                    first += step;
                }
            }
        }
        this.list.clear();
    }

    @Override // androidx.paging.PagedList.Callback
    public void onChanged(int position, int count) {
        this.list.add(0);
        this.list.add(Integer.valueOf(position));
        this.list.add(Integer.valueOf(count));
    }

    @Override // androidx.paging.PagedList.Callback
    public void onInserted(int position, int count) {
        this.list.add(1);
        this.list.add(Integer.valueOf(position));
        this.list.add(Integer.valueOf(count));
    }

    @Override // androidx.paging.PagedList.Callback
    public void onRemoved(int position, int count) {
        this.list.add(2);
        this.list.add(Integer.valueOf(position));
        this.list.add(Integer.valueOf(count));
    }
}
