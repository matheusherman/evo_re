package androidx.paging;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.IndexedValue;
import kotlin.collections.r;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;
import kotlinx.coroutines.sync.c;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J'\u0010\t\u001a\u00020\b2\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00060\u0005H\u0086@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0086@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b0\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Landroidx/paging/FlattenedPageController;", "", ExifInterface.GPS_DIRECTION_TRUE, "<init>", "()V", "Lkotlin/collections/h0;", "Landroidx/paging/PageEvent;", NotificationCompat.CATEGORY_EVENT, "Lr8/z;", "record", "(Lkotlin/collections/h0;Lv8/f;)Ljava/lang/Object;", "Landroidx/paging/TemporaryDownstream;", "createTemporaryDownstream", "(Lv8/f;)Ljava/lang/Object;", "Landroidx/paging/FlattenedPageEventStorage;", "list", "Landroidx/paging/FlattenedPageEventStorage;", "", "snapshots", "Ljava/util/List;", "Lkotlinx/coroutines/sync/a;", "lock", "Lkotlinx/coroutines/sync/a;", "paging-common"}, k = 1, mv = {1, 4, 1})
final class FlattenedPageController<T> {
    private final FlattenedPageEventStorage<T> list = new FlattenedPageEventStorage<>();
    private List<TemporaryDownstream<T>> snapshots = r.l();
    private final kotlinx.coroutines.sync.a lock = c.b(false, 1, null);

    /* JADX INFO: renamed from: androidx.paging.FlattenedPageController$createTemporaryDownstream$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @f(c = "androidx.paging.FlattenedPageController", f = "CachedPageEventFlow.kt", l = {313, 191}, m = "createTemporaryDownstream")
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002H\u0086@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Lv8/f;", "Landroidx/paging/TemporaryDownstream;", "continuation", "createTemporaryDownstream", "(Lv8/f;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
    static final class AnonymousClass1 extends d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(v8.f fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlattenedPageController.this.createTemporaryDownstream(this);
        }
    }

    /* JADX INFO: renamed from: androidx.paging.FlattenedPageController$record$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @f(c = "androidx.paging.FlattenedPageController", f = "CachedPageEventFlow.kt", l = {300, 177}, m = "record")
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0086@¢\u0006\u0004\b\b\u0010\t"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/collections/h0;", "Landroidx/paging/PageEvent;", NotificationCompat.CATEGORY_EVENT, "Lv8/f;", "Lr8/z;", "continuation", "record", "(Lkotlin/collections/h0;Lv8/f;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
    static final class C05371 extends d {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C05371(v8.f fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlattenedPageController.this.record(null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0088 A[Catch: all -> 0x0040, TryCatch #0 {all -> 0x0040, blocks: (B:13:0x003b, B:25:0x0082, B:27:0x0088, B:29:0x0090, B:30:0x0093, B:24:0x006c), top: B:38:0x0023 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x0090 A[Catch: all -> 0x0040, TryCatch #0 {all -> 0x0040, blocks: (B:13:0x003b, B:25:0x0082, B:27:0x0088, B:29:0x0090, B:30:0x0093, B:24:0x006c), top: B:38:0x0023 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x00b6 A[LOOP:0: B:25:0x0082->B:33:0x00b6, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:41:0x00b5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object createTemporaryDownstream(v8.f<? super TemporaryDownstream<T>> fVar) {
        AnonymousClass1 anonymousClass1;
        FlattenedPageController<T> flattenedPageController;
        kotlinx.coroutines.sync.a aVar;
        TemporaryDownstream temporaryDownstream;
        TemporaryDownstream temporaryDownstream2;
        Iterator<T> it;
        int i10;
        int i11;
        IndexedValue<? extends PageEvent<T>> indexedValue;
        if (fVar instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) fVar;
            int i12 = anonymousClass1.label;
            if ((i12 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i12 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(fVar);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(fVar);
        }
        Object obj = anonymousClass1.result;
        Object objC = b.c();
        int i13 = anonymousClass1.label;
        try {
            if (i13 == 0) {
                r8.r.b(obj);
                kotlinx.coroutines.sync.a aVar2 = this.lock;
                anonymousClass1.L$0 = this;
                anonymousClass1.L$1 = aVar2;
                anonymousClass1.label = 1;
                if (aVar2.a(null, anonymousClass1) != objC) {
                    flattenedPageController = this;
                    aVar = aVar2;
                }
                return objC;
            }
            if (i13 == 1) {
                kotlinx.coroutines.sync.a aVar3 = (kotlinx.coroutines.sync.a) anonymousClass1.L$1;
                flattenedPageController = (FlattenedPageController) anonymousClass1.L$0;
                r8.r.b(obj);
                aVar = aVar3;
            } else {
                if (i13 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i14 = anonymousClass1.I$0;
                it = (Iterator) anonymousClass1.L$3;
                temporaryDownstream = (TemporaryDownstream) anonymousClass1.L$2;
                temporaryDownstream2 = (TemporaryDownstream) anonymousClass1.L$1;
                aVar = (kotlinx.coroutines.sync.a) anonymousClass1.L$0;
                r8.r.b(obj);
                i10 = i14;
            }
            while (it.hasNext()) {
                T next = it.next();
                i11 = i10 + 1;
                if (i10 < 0) {
                    r.v();
                }
                indexedValue = new IndexedValue<>(kotlin.coroutines.jvm.internal.b.b(i10).intValue() - Integer.MIN_VALUE, (PageEvent) next);
                anonymousClass1.L$0 = aVar;
                anonymousClass1.L$1 = temporaryDownstream2;
                anonymousClass1.L$2 = temporaryDownstream;
                anonymousClass1.L$3 = it;
                anonymousClass1.I$0 = i11;
                anonymousClass1.label = 2;
                if (temporaryDownstream.send(indexedValue, anonymousClass1) == objC) {
                    return objC;
                }
                i10 = i11;
            }
            aVar.b(null);
            return temporaryDownstream2;
            temporaryDownstream = new TemporaryDownstream();
            temporaryDownstream2 = temporaryDownstream;
            it = flattenedPageController.list.getAsEvents().iterator();
            i10 = 0;
            while (it.hasNext()) {
                T next2 = it.next();
                i11 = i10 + 1;
                if (i10 < 0) {
                    r.v();
                }
                indexedValue = new IndexedValue<>(kotlin.coroutines.jvm.internal.b.b(i10).intValue() - Integer.MIN_VALUE, (PageEvent) next2);
                anonymousClass1.L$0 = aVar;
                anonymousClass1.L$1 = temporaryDownstream2;
                anonymousClass1.L$2 = temporaryDownstream;
                anonymousClass1.L$3 = it;
                anonymousClass1.I$0 = i11;
                anonymousClass1.label = 2;
                if (temporaryDownstream.send(indexedValue, anonymousClass1) == objC) {
                    return objC;
                }
                i10 = i11;
            }
            aVar.b(null);
            return temporaryDownstream2;
        } catch (Throwable th) {
            aVar.b(null);
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0099 A[Catch: all -> 0x0044, TryCatch #0 {all -> 0x0044, blocks: (B:13:0x003f, B:30:0x00b5, B:25:0x0093, B:27:0x0099, B:33:0x00c9, B:32:0x00c5, B:24:0x0077), top: B:38:0x0023 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x00c9 A[Catch: all -> 0x0044, TRY_LEAVE, TryCatch #0 {all -> 0x0044, blocks: (B:13:0x003f, B:30:0x00b5, B:25:0x0093, B:27:0x0099, B:33:0x00c9, B:32:0x00c5, B:24:0x0077), top: B:38:0x0023 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00b2, code lost:
    
        if (r11 == r1) goto L29;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00b2 -> B:30:0x00b5). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object record(IndexedValue<? extends PageEvent<T>> indexedValue, v8.f<? super z> fVar) {
        C05371 c05371;
        FlattenedPageController<T> flattenedPageController;
        kotlinx.coroutines.sync.a aVar;
        IndexedValue<? extends PageEvent<T>> indexedValue2;
        FlattenedPageController<T> flattenedPageController2;
        Collection arrayList;
        Iterator<T> it;
        T next;
        if (fVar instanceof C05371) {
            c05371 = (C05371) fVar;
            int i10 = c05371.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c05371.label = i10 - Integer.MIN_VALUE;
            } else {
                c05371 = new C05371(fVar);
            }
        } else {
            c05371 = new C05371(fVar);
        }
        Object objSend = c05371.result;
        Object objC = b.c();
        int i11 = c05371.label;
        try {
            if (i11 == 0) {
                r8.r.b(objSend);
                kotlinx.coroutines.sync.a aVar2 = this.lock;
                c05371.L$0 = this;
                c05371.L$1 = indexedValue;
                c05371.L$2 = aVar2;
                c05371.label = 1;
                if (aVar2.a(null, c05371) != objC) {
                    flattenedPageController = this;
                    aVar = aVar2;
                }
                return objC;
            }
            if (i11 == 1) {
                kotlinx.coroutines.sync.a aVar3 = (kotlinx.coroutines.sync.a) c05371.L$2;
                IndexedValue<? extends PageEvent<T>> indexedValue3 = (IndexedValue) c05371.L$1;
                flattenedPageController = (FlattenedPageController) c05371.L$0;
                r8.r.b(objSend);
                aVar = aVar3;
                indexedValue = indexedValue3;
            } else {
                if (i11 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                next = (T) c05371.L$5;
                it = (Iterator) c05371.L$4;
                arrayList = (Collection) c05371.L$3;
                flattenedPageController2 = (FlattenedPageController) c05371.L$2;
                aVar = (kotlinx.coroutines.sync.a) c05371.L$1;
                indexedValue2 = (IndexedValue) c05371.L$0;
                r8.r.b(objSend);
            }
            if (kotlin.coroutines.jvm.internal.b.a(((Boolean) objSend).booleanValue()).booleanValue()) {
                arrayList.add(next);
            }
            if (it.hasNext()) {
                flattenedPageController2.snapshots = (List) arrayList;
                z zVar = z.f17874a;
                aVar.b(null);
                return z.f17874a;
            }
            next = it.next();
            c05371.L$0 = indexedValue2;
            c05371.L$1 = aVar;
            c05371.L$2 = flattenedPageController2;
            c05371.L$3 = arrayList;
            c05371.L$4 = it;
            c05371.L$5 = next;
            c05371.label = 2;
            objSend = ((TemporaryDownstream) next).send(indexedValue2, c05371);
            flattenedPageController.list.add(indexedValue.d());
            List<TemporaryDownstream<T>> list = flattenedPageController.snapshots;
            indexedValue2 = indexedValue;
            flattenedPageController2 = flattenedPageController;
            arrayList = new ArrayList();
            it = list.iterator();
            if (it.hasNext()) {
                flattenedPageController2.snapshots = (List) arrayList;
                z zVar2 = z.f17874a;
                aVar.b(null);
                return z.f17874a;
            }
            next = it.next();
            c05371.L$0 = indexedValue2;
            c05371.L$1 = aVar;
            c05371.L$2 = flattenedPageController2;
            c05371.L$3 = arrayList;
            c05371.L$4 = it;
            c05371.L$5 = next;
            c05371.label = 2;
            objSend = ((TemporaryDownstream) next).send(indexedValue2, c05371);
        } catch (Throwable th) {
            aVar.b(null);
            throw th;
        }
    }
}
