package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\b\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002B\u001b\u0012\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001c\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0005H\u0096\u0002¢\u0006\u0004\b\t\u0010\nR \u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lkotlin/collections/i0;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlin/collections/h0;", "Lkotlin/Function0;", "", "iteratorFactory", "<init>", "(Lc9/a;)V", "iterator", "()Ljava/util/Iterator;", "a", "Lc9/a;", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class i0<T> implements Iterable<IndexedValue<? extends T>>, d9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final c9.a<Iterator<T>> iteratorFactory;

    /* JADX WARN: Multi-variable type inference failed */
    public i0(c9.a<? extends Iterator<? extends T>> iteratorFactory) {
        kotlin.jvm.internal.m.f(iteratorFactory, "iteratorFactory");
        this.iteratorFactory = iteratorFactory;
    }

    @Override // java.lang.Iterable
    public Iterator<IndexedValue<T>> iterator() {
        return new j0(this.iteratorFactory.invoke());
    }
}
