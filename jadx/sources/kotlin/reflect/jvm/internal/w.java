package kotlin.reflect.jvm.internal;

import androidx.exifinterface.media.ExifInterface;
import java.lang.reflect.Member;
import kotlin.Metadata;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0006\b\u0001\u0010\u0002 \u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\b\u0012\u0004\u0012\u00028\u00010\u0004:\u0001!B\u0019\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nB+\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\t\u0010\u0010J\u0017\u0010\u0012\u001a\u00028\u00012\u0006\u0010\u0011\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0014\u0010\u0013J\u0018\u0010\u0015\u001a\u00028\u00012\u0006\u0010\u0011\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0015\u0010\u0013R&\u0010\u001a\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00170\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u0019R \u0010 \u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lkotlin/reflect/jvm/internal/w;", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Li9/m;", "Lkotlin/reflect/jvm/internal/a0;", "Lkotlin/reflect/jvm/internal/n;", "container", "Lkotlin/reflect/jvm/internal/impl/descriptors/u0;", "descriptor", "<init>", "(Lkotlin/reflect/jvm/internal/n;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "", "name", "signature", "", "boundReceiver", "(Lkotlin/reflect/jvm/internal/n;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "receiver", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "getDelegate", "invoke", "Lr8/i;", "Lkotlin/reflect/jvm/internal/w$a;", "n", "Lr8/i;", "_getter", "Ljava/lang/reflect/Member;", "o", "delegateSource", "D", "()Lkotlin/reflect/jvm/internal/w$a;", "getter", "a", "kotlin-reflection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class w<T, V> extends a0<V> implements i9.m<T, V> {

    /* JADX INFO: renamed from: n, reason: collision with root package name and from kotlin metadata */
    private final r8.i<a<T, V>> _getter;

    /* JADX INFO: renamed from: o, reason: collision with root package name and from kotlin metadata */
    private final r8.i<Member> delegateSource;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0006\b\u0003\u0010\u0002 \u00012\b\u0012\u0004\u0012\u00028\u00030\u00032\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0004B\u001b\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\n\u001a\u00028\u00032\u0006\u0010\t\u001a\u00028\u0002H\u0096\u0002¢\u0006\u0004\b\n\u0010\u000bR&\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lkotlin/reflect/jvm/internal/w$a;", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/reflect/jvm/internal/a0$c;", "Li9/m$a;", "Lkotlin/reflect/jvm/internal/w;", "property", "<init>", "(Lkotlin/reflect/jvm/internal/w;)V", "receiver", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;", "i", "Lkotlin/reflect/jvm/internal/w;", "z", "()Lkotlin/reflect/jvm/internal/w;", "kotlin-reflection"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class a<T, V> extends a0.c<V> implements i9.m.a<T, V> {

        /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
        private final w<T, V> property;

        /* JADX WARN: Multi-variable type inference failed */
        public a(w<T, ? extends V> property) {
            kotlin.jvm.internal.m.f(property, "property");
            this.property = property;
        }

        @Override // kotlin.reflect.jvm.internal.a0.a
        /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
        public w<T, V> x() {
            return this.property;
        }

        @Override // c9.l
        public V invoke(T receiver) {
            return x().get(receiver);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0006\b\u0001\u0010\u0001 \u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/reflect/jvm/internal/w$a;", "a", "()Lkotlin/reflect/jvm/internal/w$a;"}, k = 3, mv = {1, 8, 0})
    static final class b extends kotlin.jvm.internal.o implements c9.a<a<T, ? extends V>> {
        final /* synthetic */ w<T, V> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b(w<T, ? extends V> wVar) {
            super(0);
            this.this$0 = wVar;
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final a<T, V> invoke() {
            return new a<>(this.this$0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0006\b\u0001\u0010\u0001 \u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Ljava/lang/reflect/Member;", "a", "()Ljava/lang/reflect/Member;"}, k = 3, mv = {1, 8, 0})
    static final class c extends kotlin.jvm.internal.o implements c9.a<Member> {
        final /* synthetic */ w<T, V> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        c(w<T, ? extends V> wVar) {
            super(0);
            this.this$0 = wVar;
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Member invoke() {
            return this.this$0.w();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(n container, String name, String signature, Object obj) {
        super(container, name, signature, obj);
        kotlin.jvm.internal.m.f(container, "container");
        kotlin.jvm.internal.m.f(name, "name");
        kotlin.jvm.internal.m.f(signature, "signature");
        r8.m mVar = r8.m.PUBLICATION;
        this._getter = r8.j.b(mVar, new b(this));
        this.delegateSource = r8.j.b(mVar, new c(this));
    }

    @Override // i9.k
    /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
    public a<T, V> getGetter() {
        return this._getter.getValue();
    }

    @Override // i9.m
    public Object getDelegate(T receiver) {
        return y(this.delegateSource.getValue(), receiver, null);
    }

    @Override // i9.m
    public V get(T receiver) {
        return getGetter().call(receiver);
    }

    @Override // c9.l
    public V invoke(T receiver) {
        return get(receiver);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(n container, u0 descriptor) {
        super(container, descriptor);
        kotlin.jvm.internal.m.f(container, "container");
        kotlin.jvm.internal.m.f(descriptor, "descriptor");
        r8.m mVar = r8.m.PUBLICATION;
        this._getter = r8.j.b(mVar, new b(this));
        this.delegateSource = r8.j.b(mVar, new c(this));
    }
}
