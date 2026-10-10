package kotlin.reflect.jvm.internal;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0010\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\u001dB\u0019\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB+\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000fJ\u000f\u0010\u0010\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0012\u0010\u0011R \u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00140\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lkotlin/reflect/jvm/internal/v;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Li9/l;", "Lkotlin/reflect/jvm/internal/a0;", "Lkotlin/reflect/jvm/internal/n;", "container", "Lkotlin/reflect/jvm/internal/impl/descriptors/u0;", "descriptor", "<init>", "(Lkotlin/reflect/jvm/internal/n;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "", "name", "signature", "", "boundReceiver", "(Lkotlin/reflect/jvm/internal/n;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "get", "()Ljava/lang/Object;", "invoke", "Lr8/i;", "Lkotlin/reflect/jvm/internal/v$a;", "n", "Lr8/i;", "_getter", "o", "delegateValue", "D", "()Lkotlin/reflect/jvm/internal/v$a;", "getter", "a", "kotlin-reflection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class v<V> extends a0<V> implements i9.l<V> {

    /* JADX INFO: renamed from: n, reason: collision with root package name and from kotlin metadata */
    private final r8.i<a<V>> _getter;

    /* JADX INFO: renamed from: o, reason: collision with root package name and from kotlin metadata */
    private final r8.i<Object> delegateValue;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00010\u00022\b\u0012\u0004\u0012\u00028\u00010\u0003B\u0015\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0004\b\b\u0010\tR \u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lkotlin/reflect/jvm/internal/v$a;", "R", "Lkotlin/reflect/jvm/internal/a0$c;", "Li9/l$a;", "Lkotlin/reflect/jvm/internal/v;", "property", "<init>", "(Lkotlin/reflect/jvm/internal/v;)V", "invoke", "()Ljava/lang/Object;", "i", "Lkotlin/reflect/jvm/internal/v;", "z", "()Lkotlin/reflect/jvm/internal/v;", "kotlin-reflection"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class a<R> extends a0.c<R> implements i9.l.a<R> {

        /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
        private final v<R> property;

        /* JADX WARN: Multi-variable type inference failed */
        public a(v<? extends R> property) {
            kotlin.jvm.internal.m.f(property, "property");
            this.property = property;
        }

        @Override // kotlin.reflect.jvm.internal.a0.a
        /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
        public v<R> x() {
            return this.property;
        }

        @Override // c9.a
        public R invoke() {
            return x().get();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0006\b\u0000\u0010\u0000 \u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/reflect/jvm/internal/v$a;", "a", "()Lkotlin/reflect/jvm/internal/v$a;"}, k = 3, mv = {1, 8, 0})
    static final class b extends kotlin.jvm.internal.o implements c9.a<a<? extends V>> {
        final /* synthetic */ v<V> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b(v<? extends V> vVar) {
            super(0);
            this.this$0 = vVar;
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final a<V> invoke() {
            return new a<>(this.this$0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0006\b\u0000\u0010\u0002 \u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class c extends kotlin.jvm.internal.o implements c9.a<Object> {
        final /* synthetic */ v<V> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        c(v<? extends V> vVar) {
            super(0);
            this.this$0 = vVar;
        }

        @Override // c9.a
        public final Object invoke() {
            v<V> vVar = this.this$0;
            return vVar.y(vVar.w(), null, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(n container, u0 descriptor) {
        super(container, descriptor);
        kotlin.jvm.internal.m.f(container, "container");
        kotlin.jvm.internal.m.f(descriptor, "descriptor");
        r8.m mVar = r8.m.PUBLICATION;
        this._getter = r8.j.b(mVar, new b(this));
        this.delegateValue = r8.j.b(mVar, new c(this));
    }

    @Override // i9.k
    /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
    public a<V> getGetter() {
        return this._getter.getValue();
    }

    @Override // i9.l
    public V get() {
        return getGetter().call(new Object[0]);
    }

    @Override // c9.a
    public V invoke() {
        return get();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(n container, String name, String signature, Object obj) {
        super(container, name, signature, obj);
        kotlin.jvm.internal.m.f(container, "container");
        kotlin.jvm.internal.m.f(name, "name");
        kotlin.jvm.internal.m.f(signature, "signature");
        r8.m mVar = r8.m.PUBLICATION;
        this._getter = r8.j.b(mVar, new b(this));
        this.delegateValue = r8.j.b(mVar, new c(this));
    }
}
