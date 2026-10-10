package kotlin.reflect.jvm.internal;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004:\u0001\u001eB\u0019\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nB+\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\t\u0010\u0010J\u001f\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R&\u0010\u001a\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00170\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R \u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lkotlin/reflect/jvm/internal/q;", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/reflect/jvm/internal/w;", "Li9/i;", "Lkotlin/reflect/jvm/internal/n;", "container", "Lkotlin/reflect/jvm/internal/impl/descriptors/u0;", "descriptor", "<init>", "(Lkotlin/reflect/jvm/internal/n;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "", "name", "signature", "", "boundReceiver", "(Lkotlin/reflect/jvm/internal/n;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "receiver", "value", "Lr8/z;", "F", "(Ljava/lang/Object;Ljava/lang/Object;)V", "Lr8/i;", "Lkotlin/reflect/jvm/internal/q$a;", "p", "Lr8/i;", "_setter", ExifInterface.LONGITUDE_EAST, "()Lkotlin/reflect/jvm/internal/q$a;", "setter", "a", "kotlin-reflection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class q<T, V> extends w<T, V> implements i9.i<T, V> {

    /* JADX INFO: renamed from: p, reason: collision with root package name and from kotlin metadata */
    private final r8.i<a<T, V>> _setter;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\b\u0012\u0004\u0012\u00028\u00030\u00032\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0004B\u001b\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005¢\u0006\u0004\b\u0007\u0010\bJ \u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00028\u00022\u0006\u0010\n\u001a\u00028\u0003H\u0096\u0002¢\u0006\u0004\b\f\u0010\rR&\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lkotlin/reflect/jvm/internal/q$a;", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/reflect/jvm/internal/a0$d;", "Li9/i$a;", "Lkotlin/reflect/jvm/internal/q;", "property", "<init>", "(Lkotlin/reflect/jvm/internal/q;)V", "receiver", "value", "Lr8/z;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Ljava/lang/Object;Ljava/lang/Object;)V", "i", "Lkotlin/reflect/jvm/internal/q;", "z", "()Lkotlin/reflect/jvm/internal/q;", "kotlin-reflection"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class a<T, V> extends a0.d<V> implements i9.i.a<T, V> {

        /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
        private final q<T, V> property;

        public a(q<T, V> property) {
            kotlin.jvm.internal.m.f(property, "property");
            this.property = property;
        }

        @Override // kotlin.reflect.jvm.internal.a0.a
        /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
        public q<T, V> x() {
            return this.property;
        }

        public void A(T receiver, V value) throws j9.a {
            x().F(receiver, value);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // c9.p
        public /* bridge */ /* synthetic */ r8.z invoke(Object obj, Object obj2) throws j9.a {
            A(obj, obj2);
            return r8.z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/reflect/jvm/internal/q$a;", "a", "()Lkotlin/reflect/jvm/internal/q$a;"}, k = 3, mv = {1, 8, 0})
    static final class b extends kotlin.jvm.internal.o implements c9.a<a<T, V>> {
        final /* synthetic */ q<T, V> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(q<T, V> qVar) {
            super(0);
            this.this$0 = qVar;
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final a<T, V> invoke() {
            return new a<>(this.this$0);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(n container, String name, String signature, Object obj) {
        super(container, name, signature, obj);
        kotlin.jvm.internal.m.f(container, "container");
        kotlin.jvm.internal.m.f(name, "name");
        kotlin.jvm.internal.m.f(signature, "signature");
        this._setter = r8.j.b(r8.m.PUBLICATION, new b(this));
    }

    @Override // i9.i, i9.h
    /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
    public a<T, V> getSetter() {
        return this._setter.getValue();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(n container, u0 descriptor) {
        super(container, descriptor);
        kotlin.jvm.internal.m.f(container, "container");
        kotlin.jvm.internal.m.f(descriptor, "descriptor");
        this._setter = r8.j.b(r8.m.PUBLICATION, new b(this));
    }

    public void F(T receiver, V value) throws j9.a {
        getSetter().call(receiver, value);
    }
}
