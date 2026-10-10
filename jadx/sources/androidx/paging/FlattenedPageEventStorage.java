package androidx.paging;

import androidx.annotation.VisibleForTesting;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import h9.f;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.k0;
import kotlin.collections.r;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u000b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u000e\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0011\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00100\u0013¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u0018R \u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001b0\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Landroidx/paging/FlattenedPageEventStorage;", "", ExifInterface.GPS_DIRECTION_TRUE, "<init>", "()V", "Landroidx/paging/PageEvent$Drop;", NotificationCompat.CATEGORY_EVENT, "Lr8/z;", "handlePageDrop", "(Landroidx/paging/PageEvent$Drop;)V", "Landroidx/paging/PageEvent$Insert;", "handleInsert", "(Landroidx/paging/PageEvent$Insert;)V", "Landroidx/paging/PageEvent$LoadStateUpdate;", "handleLoadStateUpdate", "(Landroidx/paging/PageEvent$LoadStateUpdate;)V", "Landroidx/paging/PageEvent;", "add", "(Landroidx/paging/PageEvent;)V", "", "getAsEvents", "()Ljava/util/List;", "", "placeholdersBefore", "I", "placeholdersAfter", "Ljava/util/ArrayDeque;", "Landroidx/paging/TransformablePage;", "pages", "Ljava/util/ArrayDeque;", "Landroidx/paging/MutableLoadStateCollection;", "loadStates", "Landroidx/paging/MutableLoadStateCollection;", "paging-common"}, k = 1, mv = {1, 4, 1})
@VisibleForTesting(otherwise = 2)
public final class FlattenedPageEventStorage<T> {
    private int placeholdersAfter;
    private int placeholdersBefore;
    private final ArrayDeque<TransformablePage<T>> pages = new ArrayDeque<>();
    private final MutableLoadStateCollection loadStates = new MutableLoadStateCollection();

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[LoadType.values().length];
            $EnumSwitchMapping$0 = iArr;
            LoadType loadType = LoadType.PREPEND;
            iArr[loadType.ordinal()] = 1;
            LoadType loadType2 = LoadType.APPEND;
            iArr[loadType2.ordinal()] = 2;
            int[] iArr2 = new int[LoadType.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[LoadType.REFRESH.ordinal()] = 1;
            iArr2[loadType.ordinal()] = 2;
            iArr2[loadType2.ordinal()] = 3;
        }
    }

    private final void handleInsert(PageEvent.Insert<T> event) {
        this.loadStates.set(event.getCombinedLoadStates());
        int i10 = WhenMappings.$EnumSwitchMapping$1[event.getLoadType().ordinal()];
        if (i10 == 1) {
            this.pages.clear();
            this.placeholdersAfter = event.getPlaceholdersAfter();
            this.placeholdersBefore = event.getPlaceholdersBefore();
            this.pages.addAll(event.getPages());
            return;
        }
        if (i10 != 2) {
            if (i10 != 3) {
                return;
            }
            this.placeholdersAfter = event.getPlaceholdersAfter();
            this.pages.addAll(event.getPages());
            return;
        }
        this.placeholdersBefore = event.getPlaceholdersBefore();
        Iterator<Integer> it = f.k(event.getPages().size() - 1, 0).iterator();
        while (it.hasNext()) {
            this.pages.addFirst(event.getPages().get(((k0) it).nextInt()));
        }
    }

    private final void handleLoadStateUpdate(PageEvent.LoadStateUpdate<T> event) {
        this.loadStates.set(event.getLoadType(), event.getFromMediator(), event.getLoadState());
    }

    private final void handlePageDrop(PageEvent.Drop<T> event) {
        int i10 = 0;
        this.loadStates.set(event.getLoadType(), false, LoadState.NotLoading.INSTANCE.getIncomplete$paging_common());
        int i11 = WhenMappings.$EnumSwitchMapping$0[event.getLoadType().ordinal()];
        if (i11 == 1) {
            this.placeholdersBefore = event.getPlaceholdersRemaining();
            int pageCount = event.getPageCount();
            while (i10 < pageCount) {
                this.pages.removeFirst();
                i10++;
            }
            return;
        }
        if (i11 != 2) {
            throw new IllegalArgumentException("Page drop type must be prepend or append");
        }
        this.placeholdersAfter = event.getPlaceholdersRemaining();
        int pageCount2 = event.getPageCount();
        while (i10 < pageCount2) {
            this.pages.removeLast();
            i10++;
        }
    }

    public final void add(PageEvent<T> event) {
        m.f(event, "event");
        if (event instanceof PageEvent.Insert) {
            handleInsert((PageEvent.Insert) event);
        } else if (event instanceof PageEvent.Drop) {
            handlePageDrop((PageEvent.Drop) event);
        } else if (event instanceof PageEvent.LoadStateUpdate) {
            handleLoadStateUpdate((PageEvent.LoadStateUpdate) event);
        }
    }

    public final List<PageEvent<T>> getAsEvents() {
        ArrayList arrayList = new ArrayList();
        if (!this.pages.isEmpty()) {
            arrayList.add(PageEvent.Insert.INSTANCE.Refresh(r.O0(this.pages), this.placeholdersBefore, this.placeholdersAfter, this.loadStates.snapshot()));
            return arrayList;
        }
        MutableLoadStateCollection mutableLoadStateCollection = this.loadStates;
        LoadStates loadStates = mutableLoadStateCollection.source;
        LoadType loadType = LoadType.REFRESH;
        LoadState refresh = loadStates.getRefresh();
        PageEvent.LoadStateUpdate.Companion companion = PageEvent.LoadStateUpdate.INSTANCE;
        if (companion.canDispatchWithoutInsert$paging_common(refresh, false)) {
            arrayList.add(new PageEvent.LoadStateUpdate(loadType, false, refresh));
        }
        LoadType loadType2 = LoadType.PREPEND;
        LoadState prepend = loadStates.getPrepend();
        if (companion.canDispatchWithoutInsert$paging_common(prepend, false)) {
            arrayList.add(new PageEvent.LoadStateUpdate(loadType2, false, prepend));
        }
        LoadType loadType3 = LoadType.APPEND;
        LoadState append = loadStates.getAppend();
        if (companion.canDispatchWithoutInsert$paging_common(append, false)) {
            arrayList.add(new PageEvent.LoadStateUpdate(loadType3, false, append));
        }
        LoadStates loadStates2 = mutableLoadStateCollection.mediator;
        if (loadStates2 != null) {
            LoadState refresh2 = loadStates2.getRefresh();
            if (companion.canDispatchWithoutInsert$paging_common(refresh2, true)) {
                arrayList.add(new PageEvent.LoadStateUpdate(loadType, true, refresh2));
            }
            LoadState prepend2 = loadStates2.getPrepend();
            if (companion.canDispatchWithoutInsert$paging_common(prepend2, true)) {
                arrayList.add(new PageEvent.LoadStateUpdate(loadType2, true, prepend2));
            }
            LoadState append2 = loadStates2.getAppend();
            if (companion.canDispatchWithoutInsert$paging_common(append2, true)) {
                arrayList.add(new PageEvent.LoadStateUpdate(loadType3, true, append2));
            }
        }
        return arrayList;
    }
}
