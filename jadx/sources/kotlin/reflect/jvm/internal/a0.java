package kotlin.reflect.jvm.internal;

import androidx.exifinterface.media.ExifInterface;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.reflect.jvm.internal.impl.descriptors.t0;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.v0;
import kotlin.reflect.jvm.internal.impl.descriptors.w0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\b \u0018\u0000 P*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0004QRSTB\u0019\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB5\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\b\u0010\u0010B+\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\b\u0010\u0012J\u0011\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0004¢\u0006\u0004\b\u0014\u0010\u0015J/\u0010\u0019\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0018\u001a\u0004\u0018\u00010\u000eH\u0004¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000eH\u0096\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\nH\u0016¢\u0006\u0004\b\"\u0010#R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001a\u0010\u000b\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010#R\u0017\u0010\f\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b+\u0010)\u001a\u0004\b,\u0010#R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u001c\u00103\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001000/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\"\u00108\u001a\u0010\u0012\f\u0012\n 5*\u0004\u0018\u00010\u00060\u0006048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u000e8F¢\u0006\u0006\u001a\u0004\b9\u0010:R\u0014\u0010=\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<R\u0013\u0010@\u001a\u0004\u0018\u0001008F¢\u0006\u0006\u001a\u0004\b>\u0010?R\u001a\u0010D\u001a\b\u0012\u0004\u0012\u00028\u00000A8&X¦\u0004¢\u0006\u0006\u001a\u0004\bB\u0010CR\u0018\u0010H\u001a\u0006\u0012\u0002\b\u00030E8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bF\u0010GR\u001a\u0010J\u001a\b\u0012\u0002\b\u0003\u0018\u00010E8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bI\u0010GR\u0014\u0010K\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bK\u0010<R\u0014\u0010L\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bL\u0010<R\u0014\u0010M\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bM\u0010<R\u0014\u0010\u0007\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bN\u0010O¨\u0006U"}, d2 = {"Lkotlin/reflect/jvm/internal/a0;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/reflect/jvm/internal/j;", "Li9/k;", "Lkotlin/reflect/jvm/internal/n;", "container", "Lkotlin/reflect/jvm/internal/impl/descriptors/u0;", "descriptor", "<init>", "(Lkotlin/reflect/jvm/internal/n;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "", "name", "signature", "descriptorInitialValue", "", "rawBoundReceiver", "(Lkotlin/reflect/jvm/internal/n;Ljava/lang/String;Ljava/lang/String;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;Ljava/lang/Object;)V", "boundReceiver", "(Lkotlin/reflect/jvm/internal/n;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "Ljava/lang/reflect/Member;", "w", "()Ljava/lang/reflect/Member;", "fieldOrMethod", "receiver1", "receiver2", "y", "(Ljava/lang/reflect/Member;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", TransactionPartnerType.OTHER, "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "()Ljava/lang/String;", "f", "Lkotlin/reflect/jvm/internal/n;", "r", "()Lkotlin/reflect/jvm/internal/n;", "g", "Ljava/lang/String;", "getName", "h", "C", "i", "Ljava/lang/Object;", "Lr8/i;", "Ljava/lang/reflect/Field;", "j", "Lr8/i;", "_javaField", "Lkotlin/reflect/jvm/internal/h0$a;", "kotlin.jvm.PlatformType", "k", "Lkotlin/reflect/jvm/internal/h0$a;", "_descriptor", "x", "()Ljava/lang/Object;", "v", "()Z", "isBound", "B", "()Ljava/lang/reflect/Field;", "javaField", "Lkotlin/reflect/jvm/internal/a0$c;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Lkotlin/reflect/jvm/internal/a0$c;", "getter", "Lkotlin/reflect/jvm/internal/calls/e;", "q", "()Lkotlin/reflect/jvm/internal/calls/e;", "caller", "s", "defaultCaller", "isLateinit", "isConst", "isSuspend", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", "l", "a", "b", "c", "d", "kotlin-reflection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class a0<V> extends j<V> implements i9.k<V> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final Object f12346m = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final n container;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final String name;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final String signature;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Object rawBoundReceiver;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final r8.i<Field> _javaField;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final h0.a<u0> _descriptor;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00010\u00022\b\u0012\u0004\u0012\u00028\u00010\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0096\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0016\u001a\u00020\u00118VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001f\u0010\u001c\u001a\u0006\u0012\u0002\b\u00030\u00178VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\b¨\u0006\u001f"}, d2 = {"Lkotlin/reflect/jvm/internal/a0$c;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/reflect/jvm/internal/a0$a;", "Li9/k$b;", "<init>", "()V", "", "toString", "()Ljava/lang/String;", "", TransactionPartnerType.OTHER, "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Lkotlin/reflect/jvm/internal/impl/descriptors/v0;", "f", "Lkotlin/reflect/jvm/internal/h0$a;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyGetterDescriptor;", "descriptor", "Lkotlin/reflect/jvm/internal/calls/e;", "g", "Lr8/i;", "q", "()Lkotlin/reflect/jvm/internal/calls/e;", "caller", "getName", "name", "kotlin-reflection"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static abstract class c<V> extends a<V, V> implements i9.k.b<V> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        static final /* synthetic */ i9.k<Object>[] f12353h = {kotlin.jvm.internal.c0.g(new kotlin.jvm.internal.w(kotlin.jvm.internal.c0.b(c.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PropertyGetterDescriptor;"))};

        /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final h0.a descriptor = h0.c(new b(this));

        /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
        private final r8.i caller = r8.j.b(r8.m.PUBLICATION, new a(this));

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0001\"\u0006\b\u0000\u0010\u0000 \u0001\"\u0006\b\u0001\u0010\u0000 \u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/reflect/jvm/internal/calls/e;", "a", "()Lkotlin/reflect/jvm/internal/calls/e;"}, k = 3, mv = {1, 8, 0})
        static final class a extends kotlin.jvm.internal.o implements c9.a<kotlin.reflect.jvm.internal.calls.e<?>> {
            final /* synthetic */ c<V> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            a(c<? extends V> cVar) {
                super(0);
                this.this$0 = cVar;
            }

            @Override // c9.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final kotlin.reflect.jvm.internal.calls.e<?> invoke() {
                return b0.b(this.this$0, true);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001\"\u0006\b\u0000\u0010\u0000 \u0001\"\u0006\b\u0001\u0010\u0000 \u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/reflect/jvm/internal/impl/descriptors/v0;", "kotlin.jvm.PlatformType", "a", "()Lkotlin/reflect/jvm/internal/impl/descriptors/v0;"}, k = 3, mv = {1, 8, 0})
        static final class b extends kotlin.jvm.internal.o implements c9.a<v0> {
            final /* synthetic */ c<V> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            b(c<? extends V> cVar) {
                super(0);
                this.this$0 = cVar;
            }

            @Override // c9.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final v0 invoke() {
                v0 getter = this.this$0.x().w().getGetter();
                return getter == null ? kotlin.reflect.jvm.internal.impl.resolve.d.d(this.this$0.x().w(), kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f12688i0.b()) : getter;
            }
        }

        public boolean equals(Object other) {
            return (other instanceof c) && kotlin.jvm.internal.m.a(x(), ((c) other).x());
        }

        @Override // i9.c
        public String getName() {
            return "<get-" + x().getName() + '>';
        }

        @Override // kotlin.reflect.jvm.internal.j
        public kotlin.reflect.jvm.internal.calls.e<?> q() {
            return (kotlin.reflect.jvm.internal.calls.e) this.caller.getValue();
        }

        public String toString() {
            return "getter of " + x();
        }

        @Override // kotlin.reflect.jvm.internal.a0.a
        /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public v0 w() {
            T tB = this.descriptor.b(this, f12353h[0]);
            kotlin.jvm.internal.m.e(tB, "<get-descriptor>(...)");
            return (v0) tB;
        }

        public int hashCode() {
            return x().hashCode();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000*\u0004\b\u0001\u0010\u00012\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00028\u00010\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0096\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0017\u001a\u00020\u00128VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001f\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\u00188VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001f\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\t¨\u0006 "}, d2 = {"Lkotlin/reflect/jvm/internal/a0$d;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/reflect/jvm/internal/a0$a;", "Lr8/z;", "Li9/h$a;", "<init>", "()V", "", "toString", "()Ljava/lang/String;", "", TransactionPartnerType.OTHER, "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Lkotlin/reflect/jvm/internal/impl/descriptors/w0;", "f", "Lkotlin/reflect/jvm/internal/h0$a;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertySetterDescriptor;", "descriptor", "Lkotlin/reflect/jvm/internal/calls/e;", "g", "Lr8/i;", "q", "()Lkotlin/reflect/jvm/internal/calls/e;", "caller", "getName", "name", "kotlin-reflection"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static abstract class d<V> extends a<V, r8.z> implements i9.h.a<V> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        static final /* synthetic */ i9.k<Object>[] f12356h = {kotlin.jvm.internal.c0.g(new kotlin.jvm.internal.w(kotlin.jvm.internal.c0.b(d.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PropertySetterDescriptor;"))};

        /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final h0.a descriptor = h0.c(new b(this));

        /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
        private final r8.i caller = r8.j.b(r8.m.PUBLICATION, new a(this));

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0001\"\u0004\b\u0000\u0010\u0000\"\u0006\b\u0001\u0010\u0000 \u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/reflect/jvm/internal/calls/e;", "a", "()Lkotlin/reflect/jvm/internal/calls/e;"}, k = 3, mv = {1, 8, 0})
        static final class a extends kotlin.jvm.internal.o implements c9.a<kotlin.reflect.jvm.internal.calls.e<?>> {
            final /* synthetic */ d<V> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(d<V> dVar) {
                super(0);
                this.this$0 = dVar;
            }

            @Override // c9.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final kotlin.reflect.jvm.internal.calls.e<?> invoke() {
                return b0.b(this.this$0, false);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001\"\u0004\b\u0000\u0010\u0000\"\u0006\b\u0001\u0010\u0000 \u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/reflect/jvm/internal/impl/descriptors/w0;", "kotlin.jvm.PlatformType", "a", "()Lkotlin/reflect/jvm/internal/impl/descriptors/w0;"}, k = 3, mv = {1, 8, 0})
        static final class b extends kotlin.jvm.internal.o implements c9.a<w0> {
            final /* synthetic */ d<V> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(d<V> dVar) {
                super(0);
                this.this$0 = dVar;
            }

            @Override // c9.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final w0 invoke() {
                w0 setter = this.this$0.x().w().getSetter();
                if (setter != null) {
                    return setter;
                }
                u0 u0VarW = this.this$0.x().w();
                kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.a aVar = kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f12688i0;
                return kotlin.reflect.jvm.internal.impl.resolve.d.e(u0VarW, aVar.b(), aVar.b());
            }
        }

        public boolean equals(Object other) {
            return (other instanceof d) && kotlin.jvm.internal.m.a(x(), ((d) other).x());
        }

        @Override // i9.c
        public String getName() {
            return "<set-" + x().getName() + '>';
        }

        @Override // kotlin.reflect.jvm.internal.j
        public kotlin.reflect.jvm.internal.calls.e<?> q() {
            return (kotlin.reflect.jvm.internal.calls.e) this.caller.getValue();
        }

        public String toString() {
            return "setter of " + x();
        }

        @Override // kotlin.reflect.jvm.internal.a0.a
        /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
        public w0 w() {
            T tB = this.descriptor.b(this, f12356h[0]);
            kotlin.jvm.internal.m.e(tB, "<get-descriptor>(...)");
            return (w0) tB;
        }

        public int hashCode() {
            return x().hashCode();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001\"\u0006\b\u0000\u0010\u0000 \u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/reflect/jvm/internal/impl/descriptors/u0;", "kotlin.jvm.PlatformType", "a", "()Lkotlin/reflect/jvm/internal/impl/descriptors/u0;"}, k = 3, mv = {1, 8, 0})
    static final class e extends kotlin.jvm.internal.o implements c9.a<u0> {
        final /* synthetic */ a0<V> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        e(a0<? extends V> a0Var) {
            super(0);
            this.this$0 = a0Var;
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final u0 invoke() {
            return this.this$0.getContainer().s(this.this$0.getName(), this.this$0.getSignature());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001\"\u0006\b\u0000\u0010\u0000 \u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Ljava/lang/reflect/Field;", "a", "()Ljava/lang/reflect/Field;"}, k = 3, mv = {1, 8, 0})
    static final class f extends kotlin.jvm.internal.o implements c9.a<Field> {
        final /* synthetic */ a0<V> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        f(a0<? extends V> a0Var) {
            super(0);
            this.this$0 = a0Var;
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Field invoke() {
            Class<?> enclosingClass;
            i iVarF = k0.f14515a.f(this.this$0.w());
            if (!(iVarF instanceof i.c)) {
                if (iVarF instanceof i.a) {
                    return ((i.a) iVarF).getField();
                }
                if ((iVarF instanceof i.b) || (iVarF instanceof i.d)) {
                    return null;
                }
                throw new r8.n();
            }
            i.c cVar = (i.c) iVarF;
            u0 u0VarB = cVar.getDescriptor();
            aa.d.a aVarD = aa.i.d(aa.i.f190a, cVar.getProto(), cVar.getNameResolver(), cVar.getTypeTable(), false, 8, null);
            if (aVarD == null) {
                return null;
            }
            a0<V> a0Var = this.this$0;
            if (kotlin.reflect.jvm.internal.impl.load.java.k.e(u0VarB) || aa.i.f(cVar.getProto())) {
                enclosingClass = a0Var.getContainer().d().getEnclosingClass();
            } else {
                kotlin.reflect.jvm.internal.impl.descriptors.m mVarB = u0VarB.b();
                enclosingClass = mVarB instanceof kotlin.reflect.jvm.internal.impl.descriptors.e ? n0.p((kotlin.reflect.jvm.internal.impl.descriptors.e) mVarB) : a0Var.getContainer().d();
            }
            if (enclosingClass == null) {
                return null;
            }
            try {
                return enclosingClass.getDeclaredField(aVarD.c());
            } catch (NoSuchFieldException unused) {
                return null;
            }
        }
    }

    private a0(n nVar, String str, String str2, u0 u0Var, Object obj) {
        this.container = nVar;
        this.name = str;
        this.signature = str2;
        this.rawBoundReceiver = obj;
        this._javaField = r8.j.b(r8.m.PUBLICATION, new f(this));
        h0.a<u0> aVarD = h0.d(u0Var, new e(this));
        kotlin.jvm.internal.m.e(aVarD, "lazySoft(descriptorIniti…or(name, signature)\n    }");
        this._descriptor = aVarD;
    }

    /* JADX INFO: renamed from: A */
    public abstract c<V> getGetter();

    @Override // i9.c
    public boolean isSuspend() {
        return false;
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u0001*\u0006\b\u0002\u0010\u0002 \u00012\b\u0012\u0004\u0012\u00028\u00020\u00032\b\u0012\u0004\u0012\u00028\u00010\u00042\b\u0012\u0004\u0012\u00028\u00020\u0005B\u0007¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0013\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0016R\u0014\u0010\u001c\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0016R\u0014\u0010 \u001a\u00020\u001d8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006!"}, d2 = {"Lkotlin/reflect/jvm/internal/a0$a;", "PropertyType", "ReturnType", "Lkotlin/reflect/jvm/internal/j;", "Li9/k$a;", "Li9/g;", "<init>", "()V", "Lkotlin/reflect/jvm/internal/a0;", "x", "()Lkotlin/reflect/jvm/internal/a0;", "property", "Lkotlin/reflect/jvm/internal/n;", "r", "()Lkotlin/reflect/jvm/internal/n;", "container", "Lkotlin/reflect/jvm/internal/calls/e;", "s", "()Lkotlin/reflect/jvm/internal/calls/e;", "defaultCaller", "", "v", "()Z", "isBound", "isInline", "isExternal", "isOperator", "isInfix", "isSuspend", "Lkotlin/reflect/jvm/internal/impl/descriptors/t0;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyAccessorDescriptor;", "descriptor", "kotlin-reflection"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static abstract class a<PropertyType, ReturnType> extends j<ReturnType> implements i9.g<ReturnType>, i9.k.a<PropertyType> {
        @Override // kotlin.reflect.jvm.internal.j
        public kotlin.reflect.jvm.internal.calls.e<?> s() {
            return null;
        }

        public abstract t0 w();

        public abstract a0<PropertyType> x();

        @Override // i9.g
        public boolean isExternal() {
            return w().isExternal();
        }

        @Override // i9.g
        public boolean isInfix() {
            return w().isInfix();
        }

        @Override // i9.g
        public boolean isInline() {
            return w().isInline();
        }

        @Override // i9.g
        public boolean isOperator() {
            return w().isOperator();
        }

        @Override // i9.c
        public boolean isSuspend() {
            return w().isSuspend();
        }

        @Override // kotlin.reflect.jvm.internal.j
        /* JADX INFO: renamed from: r */
        public n getContainer() {
            return x().getContainer();
        }

        @Override // kotlin.reflect.jvm.internal.j
        public boolean v() {
            return x().v();
        }
    }

    public final Field B() {
        return this._javaField.getValue();
    }

    /* JADX INFO: renamed from: C, reason: from getter */
    public final String getSignature() {
        return this.signature;
    }

    @Override // i9.c
    public String getName() {
        return this.name;
    }

    @Override // kotlin.reflect.jvm.internal.j
    /* JADX INFO: renamed from: r, reason: from getter */
    public n getContainer() {
        return this.container;
    }

    public String toString() {
        return j0.f14485a.g(w());
    }

    @Override // kotlin.reflect.jvm.internal.j
    public boolean v() {
        return !kotlin.jvm.internal.m.a(this.rawBoundReceiver, kotlin.jvm.internal.c.NO_RECEIVER);
    }

    public final Object x() {
        return kotlin.reflect.jvm.internal.calls.i.a(this.rawBoundReceiver, w());
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected final Object y(Member fieldOrMethod, Object receiver1, Object receiver2) throws j9.b {
        try {
            Object obj = f12346m;
            if ((receiver1 == obj || receiver2 == obj) && w().i0() == null) {
                throw new RuntimeException('\'' + this + "' is not an extension property and thus getExtensionDelegate() is not going to work, use getDelegate() instead");
            }
            Object objX = v() ? x() : receiver1;
            if (objX == obj) {
                objX = null;
            }
            if (!v()) {
                receiver1 = receiver2;
            }
            if (receiver1 == obj) {
                receiver1 = null;
            }
            AccessibleObject accessibleObject = fieldOrMethod instanceof AccessibleObject ? (AccessibleObject) fieldOrMethod : null;
            if (accessibleObject != null) {
                accessibleObject.setAccessible(k9.a.a(this));
            }
            if (fieldOrMethod == 0) {
                return null;
            }
            if (fieldOrMethod instanceof Field) {
                return ((Field) fieldOrMethod).get(objX);
            }
            if (!(fieldOrMethod instanceof Method)) {
                throw new AssertionError("delegate field/method " + fieldOrMethod + " neither field nor method");
            }
            int length = ((Method) fieldOrMethod).getParameterTypes().length;
            if (length == 0) {
                return ((Method) fieldOrMethod).invoke(null, null);
            }
            if (length == 1) {
                Method method = (Method) fieldOrMethod;
                if (objX == null) {
                    Class<?> cls = ((Method) fieldOrMethod).getParameterTypes()[0];
                    kotlin.jvm.internal.m.e(cls, "fieldOrMethod.parameterTypes[0]");
                    objX = n0.g(cls);
                }
                return method.invoke(null, objX);
            }
            if (length != 2) {
                throw new AssertionError("delegate method " + fieldOrMethod + " should take 0, 1, or 2 parameters");
            }
            Method method2 = (Method) fieldOrMethod;
            if (receiver1 == null) {
                Class<?> cls2 = ((Method) fieldOrMethod).getParameterTypes()[1];
                kotlin.jvm.internal.m.e(cls2, "fieldOrMethod.parameterTypes[1]");
                receiver1 = n0.g(cls2);
            }
            return method2.invoke(null, objX, receiver1);
        } catch (IllegalAccessException e10) {
            throw new j9.b(e10);
        }
    }

    @Override // kotlin.reflect.jvm.internal.j
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public u0 w() {
        u0 u0VarInvoke = this._descriptor.invoke();
        kotlin.jvm.internal.m.e(u0VarInvoke, "_descriptor()");
        return u0VarInvoke;
    }

    public boolean equals(Object other) {
        a0<?> a0VarD = n0.d(other);
        if (a0VarD == null || !kotlin.jvm.internal.m.a(getContainer(), a0VarD.getContainer()) || !kotlin.jvm.internal.m.a(getName(), a0VarD.getName()) || !kotlin.jvm.internal.m.a(this.signature, a0VarD.signature) || !kotlin.jvm.internal.m.a(this.rawBoundReceiver, a0VarD.rawBoundReceiver)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((getContainer().hashCode() * 31) + getName().hashCode()) * 31) + this.signature.hashCode();
    }

    @Override // i9.k
    public boolean isConst() {
        return w().isConst();
    }

    @Override // i9.k
    public boolean isLateinit() {
        return w().o0();
    }

    @Override // kotlin.reflect.jvm.internal.j
    public kotlin.reflect.jvm.internal.calls.e<?> q() {
        return getGetter().q();
    }

    @Override // kotlin.reflect.jvm.internal.j
    public kotlin.reflect.jvm.internal.calls.e<?> s() {
        return getGetter().s();
    }

    protected final Member w() {
        if (!w().K()) {
            return null;
        }
        i iVarF = k0.f14515a.f(w());
        if (iVarF instanceof i.c) {
            i.c cVar = (i.c) iVarF;
            if (cVar.getSignature().D()) {
                z9.a.c cVarY = cVar.getSignature().y();
                if (!cVarY.y() || !cVarY.x()) {
                    return null;
                }
                return getContainer().r(cVar.getNameResolver().getString(cVarY.w()), cVar.getNameResolver().getString(cVarY.v()));
            }
        }
        return B();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a0(n container, String name, String signature, Object obj) {
        this(container, name, signature, null, obj);
        kotlin.jvm.internal.m.f(container, "container");
        kotlin.jvm.internal.m.f(name, "name");
        kotlin.jvm.internal.m.f(signature, "signature");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public a0(n container, u0 descriptor) {
        kotlin.jvm.internal.m.f(container, "container");
        kotlin.jvm.internal.m.f(descriptor, "descriptor");
        String strF = descriptor.getName().f();
        kotlin.jvm.internal.m.e(strF, "descriptor.name.asString()");
        this(container, strF, k0.f14515a.f(descriptor).getString(), descriptor, kotlin.jvm.internal.c.NO_RECEIVER);
    }
}
