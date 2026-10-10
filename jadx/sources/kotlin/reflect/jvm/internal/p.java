package kotlin.reflect.jvm.internal;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\u0016B\u0019\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\f\u0010\rR \u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f0\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lkotlin/reflect/jvm/internal/p;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/reflect/jvm/internal/v;", "", "Lkotlin/reflect/jvm/internal/n;", "container", "Lkotlin/reflect/jvm/internal/impl/descriptors/u0;", "descriptor", "<init>", "(Lkotlin/reflect/jvm/internal/n;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "value", "Lr8/z;", "F", "(Ljava/lang/Object;)V", "Lr8/i;", "Lkotlin/reflect/jvm/internal/p$a;", "p", "Lr8/i;", "_setter", ExifInterface.LONGITUDE_EAST, "()Lkotlin/reflect/jvm/internal/p$a;", "setter", "a", "kotlin-reflection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class p<V> extends v<V> implements i9.l, i9.h {

    /* JADX INFO: renamed from: p, reason: collision with root package name and from kotlin metadata */
    private final r8.i<a<V>> _setter;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u00022\b\u0012\u0004\u0012\u00028\u00010\u0003B\u0015\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0004\b\n\u0010\u000bR \u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lkotlin/reflect/jvm/internal/p$a;", "R", "Lkotlin/reflect/jvm/internal/a0$d;", "", "Lkotlin/reflect/jvm/internal/p;", "property", "<init>", "(Lkotlin/reflect/jvm/internal/p;)V", "value", "Lr8/z;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Ljava/lang/Object;)V", "i", "Lkotlin/reflect/jvm/internal/p;", "z", "()Lkotlin/reflect/jvm/internal/p;", "kotlin-reflection"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class a<R> extends a0.d<R> implements i9.h.a, c9.l {

        /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
        private final p<R> property;

        public a(p<R> property) {
            kotlin.jvm.internal.m.f(property, "property");
            this.property = property;
        }

        @Override // kotlin.reflect.jvm.internal.a0.a
        /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
        public p<R> x() {
            return this.property;
        }

        public void A(R value) throws j9.a {
            x().F(value);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // c9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) throws j9.a {
            A(obj);
            return r8.z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/reflect/jvm/internal/p$a;", "a", "()Lkotlin/reflect/jvm/internal/p$a;"}, k = 3, mv = {1, 8, 0})
    static final class b extends kotlin.jvm.internal.o implements c9.a<a<V>> {
        final /* synthetic */ p<V> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(p<V> pVar) {
            super(0);
            this.this$0 = pVar;
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final a<V> invoke() {
            return new a<>(this.this$0);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(n container, u0 descriptor) {
        super(container, descriptor);
        kotlin.jvm.internal.m.f(container, "container");
        kotlin.jvm.internal.m.f(descriptor, "descriptor");
        this._setter = r8.j.b(r8.m.PUBLICATION, new b(this));
    }

    @Override // i9.h
    /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
    public a<V> getSetter() {
        return this._setter.getValue();
    }

    public void F(V value) throws j9.a {
        getSetter().call(value);
    }
}
