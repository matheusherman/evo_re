package kotlin.reflect.jvm.internal;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.reflect.jvm.internal.impl.descriptors.f1;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.descriptors.r0;
import kotlin.reflect.jvm.internal.impl.descriptors.x0;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b \u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ%\u0010\r\u001a\u00028\u00002\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00070\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0011\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010\u0016\u001a\u00028\u00002\u0016\u0010\f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00070\u0006\"\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J%\u0010\u0018\u001a\u00028\u00002\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00070\nH\u0016¢\u0006\u0004\b\u0018\u0010\u000eJ3\u0010\u001b\u001a\u00028\u00002\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00070\n2\f\u0010\u001a\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0019H\u0000¢\u0006\u0004\b\u001b\u0010\u001cR.\u0010#\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u001f  *\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001e0\u001e0\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R.\u0010&\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u000b  *\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010$0$0\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010\"R\"\u0010)\u001a\u0010\u0012\f\u0012\n  *\u0004\u0018\u00010'0'0\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010\"R.\u0010,\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020*  *\n\u0012\u0004\u0012\u00020*\u0018\u00010\u001e0\u001e0\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010\"R2\u0010.\u001a \u0012\u001c\u0012\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0007  *\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00060\u00060\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010\"R\u0018\u00102\u001a\u0006\u0012\u0002\b\u00030/8&X¦\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u001a\u00104\u001a\b\u0012\u0002\b\u0003\u0018\u00010/8&X¦\u0004¢\u0006\u0006\u001a\u0004\b3\u00101R\u0014\u00108\u001a\u0002058&X¦\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R\u0014\u0010<\u001a\u0002098&X¦\u0004¢\u0006\u0006\u001a\u0004\b:\u0010;R\u001a\u0010?\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>R\u001a\u0010A\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b@\u0010>R\u0014\u0010D\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bB\u0010CR\u001a\u0010G\u001a\b\u0012\u0004\u0012\u00020E0\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bF\u0010>R\u0016\u0010K\u001a\u0004\u0018\u00010H8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bI\u0010JR\u0014\u0010L\u001a\u0002098VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bL\u0010;R\u0014\u0010M\u001a\u0002098VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bM\u0010;R\u0014\u0010N\u001a\u0002098VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bN\u0010;R\u0014\u0010P\u001a\u0002098DX\u0084\u0004¢\u0006\u0006\u001a\u0004\bO\u0010;R\u0014\u0010T\u001a\u00020Q8&X¦\u0004¢\u0006\u0006\u001a\u0004\bR\u0010S¨\u0006U"}, d2 = {"Lkotlin/reflect/jvm/internal/j;", "R", "Li9/c;", "Lkotlin/reflect/jvm/internal/e0;", "<init>", "()V", "", "", "p", "()[Ljava/lang/Object;", "", "Li9/j;", "args", "l", "(Ljava/util/Map;)Ljava/lang/Object;", "Li9/n;", IjkMediaMeta.IJKM_KEY_TYPE, "n", "(Li9/n;)Ljava/lang/Object;", "Ljava/lang/reflect/Type;", "o", "()Ljava/lang/reflect/Type;", NotificationCompat.CATEGORY_CALL, "([Ljava/lang/Object;)Ljava/lang/Object;", "callBy", "Lv8/f;", "continuationArgument", "m", "(Ljava/util/Map;Lv8/f;)Ljava/lang/Object;", "Lkotlin/reflect/jvm/internal/h0$a;", "", "", "kotlin.jvm.PlatformType", "a", "Lkotlin/reflect/jvm/internal/h0$a;", "_annotations", "Ljava/util/ArrayList;", "b", "_parameters", "Lkotlin/reflect/jvm/internal/c0;", "c", "_returnType", "Lkotlin/reflect/jvm/internal/d0;", "d", "_typeParameters", "e", "_absentArguments", "Lkotlin/reflect/jvm/internal/calls/e;", "q", "()Lkotlin/reflect/jvm/internal/calls/e;", "caller", "s", "defaultCaller", "Lkotlin/reflect/jvm/internal/n;", "r", "()Lkotlin/reflect/jvm/internal/n;", "container", "", "v", "()Z", "isBound", "getAnnotations", "()Ljava/util/List;", "annotations", "getParameters", "parameters", "getReturnType", "()Li9/n;", "returnType", "Li9/o;", "getTypeParameters", "typeParameters", "Li9/r;", "getVisibility", "()Li9/r;", "visibility", "isFinal", "isOpen", "isAbstract", "u", "isAnnotationConstructor", "Lkotlin/reflect/jvm/internal/impl/descriptors/b;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;", "descriptor", "kotlin-reflection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class j<R> implements i9.c<R>, e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final h0.a<List<Annotation>> _annotations;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final h0.a<ArrayList<i9.j>> _parameters;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final h0.a<c0> _returnType;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final h0.a<List<d0>> _typeParameters;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final h0.a<Object[]> _absentArguments;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0004\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0002 \u0003*\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00010\u0001\"\u0006\b\u0000\u0010\u0000 \u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"R", "", "", "kotlin.jvm.PlatformType", "a", "()[Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0})
    static final class a extends kotlin.jvm.internal.o implements c9.a<Object[]> {
        final /* synthetic */ j<R> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(j<? extends R> jVar) {
            super(0);
            this.this$0 = jVar;
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object[] invoke() {
            int size = this.this$0.getParameters().size() + (this.this$0.isSuspend() ? 1 : 0);
            int size2 = (this.this$0.getParameters().size() + 31) / 32;
            Object[] objArr = new Object[size + size2 + 1];
            List<i9.j> parameters = this.this$0.getParameters();
            j<R> jVar = this.this$0;
            for (i9.j jVar2 : parameters) {
                if (jVar2.h() && !n0.k(jVar2.getType())) {
                    objArr[jVar2.getIndex()] = n0.g(k9.c.f(jVar2.getType()));
                } else if (jVar2.a()) {
                    objArr[jVar2.getIndex()] = jVar.n(jVar2.getType());
                }
            }
            for (int i10 = 0; i10 < size2; i10++) {
                objArr[size + i10] = 0;
            }
            return objArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001\"\u0006\b\u0000\u0010\u0004 \u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "", "kotlin.jvm.PlatformType", "R", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class b extends kotlin.jvm.internal.o implements c9.a<List<? extends Annotation>> {
        final /* synthetic */ j<R> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b(j<? extends R> jVar) {
            super(0);
            this.this$0 = jVar;
        }

        @Override // c9.a
        public final List<? extends Annotation> invoke() {
            return n0.e(this.this$0.w());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001\"\u0006\b\u0000\u0010\u0000 \u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"R", "Ljava/util/ArrayList;", "Li9/j;", "kotlin.jvm.PlatformType", "a", "()Ljava/util/ArrayList;"}, k = 3, mv = {1, 8, 0})
    static final class c extends kotlin.jvm.internal.o implements c9.a<ArrayList<i9.j>> {
        final /* synthetic */ j<R> this$0;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0000 \u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"R", "Lkotlin/reflect/jvm/internal/impl/descriptors/r0;", "a", "()Lkotlin/reflect/jvm/internal/impl/descriptors/r0;"}, k = 3, mv = {1, 8, 0})
        static final class a extends kotlin.jvm.internal.o implements c9.a<r0> {
            final /* synthetic */ x0 $instanceReceiver;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(x0 x0Var) {
                super(0);
                this.$instanceReceiver = x0Var;
            }

            @Override // c9.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final r0 invoke() {
                return this.$instanceReceiver;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0000 \u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"R", "Lkotlin/reflect/jvm/internal/impl/descriptors/r0;", "a", "()Lkotlin/reflect/jvm/internal/impl/descriptors/r0;"}, k = 3, mv = {1, 8, 0})
        static final class b extends kotlin.jvm.internal.o implements c9.a<r0> {
            final /* synthetic */ x0 $extensionReceiver;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(x0 x0Var) {
                super(0);
                this.$extensionReceiver = x0Var;
            }

            @Override // c9.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final r0 invoke() {
                return this.$extensionReceiver;
            }
        }

        /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.j$c$c, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0000 \u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"R", "Lkotlin/reflect/jvm/internal/impl/descriptors/r0;", "a", "()Lkotlin/reflect/jvm/internal/impl/descriptors/r0;"}, k = 3, mv = {1, 8, 0})
        static final class C0274c extends kotlin.jvm.internal.o implements c9.a<r0> {
            final /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.b $descriptor;
            final /* synthetic */ int $i;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0274c(kotlin.reflect.jvm.internal.impl.descriptors.b bVar, int i10) {
                super(0);
                this.$descriptor = bVar;
                this.$i = i10;
            }

            @Override // c9.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final r0 invoke() {
                j1 j1Var = this.$descriptor.f().get(this.$i);
                kotlin.jvm.internal.m.e(j1Var, "descriptor.valueParameters[i]");
                return j1Var;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\f\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "kotlin.jvm.PlatformType", "a", "b", "", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "<anonymous>"}, k = 3, mv = {1, 8, 0})
        public static final class d<T> implements Comparator {
            @Override // java.util.Comparator
            public final int compare(T t10, T t11) {
                return t8.a.a(((i9.j) t10).getName(), ((i9.j) t11).getName());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        c(j<? extends R> jVar) {
            super(0);
            this.this$0 = jVar;
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ArrayList<i9.j> invoke() {
            int i10;
            kotlin.reflect.jvm.internal.impl.descriptors.b bVarW = this.this$0.w();
            ArrayList<i9.j> arrayList = new ArrayList<>();
            int i11 = 0;
            if (this.this$0.v()) {
                i10 = 0;
            } else {
                x0 x0VarI = n0.i(bVarW);
                if (x0VarI != null) {
                    arrayList.add(new u(this.this$0, 0, i9.j.a.INSTANCE, new a(x0VarI)));
                    i10 = 1;
                } else {
                    i10 = 0;
                }
                x0 x0VarI0 = bVarW.i0();
                if (x0VarI0 != null) {
                    arrayList.add(new u(this.this$0, i10, i9.j.a.EXTENSION_RECEIVER, new b(x0VarI0)));
                    i10++;
                }
            }
            int size = bVarW.f().size();
            while (i11 < size) {
                arrayList.add(new u(this.this$0, i10, i9.j.a.VALUE, new C0274c(bVarW, i11)));
                i11++;
                i10++;
            }
            if (this.this$0.u() && (bVarW instanceof s9.a) && arrayList.size() > 1) {
                kotlin.collections.r.B(arrayList, new d());
            }
            arrayList.trimToSize();
            return arrayList;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001\"\u0006\b\u0000\u0010\u0000 \u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"R", "Lkotlin/reflect/jvm/internal/c0;", "kotlin.jvm.PlatformType", "a", "()Lkotlin/reflect/jvm/internal/c0;"}, k = 3, mv = {1, 8, 0})
    static final class d extends kotlin.jvm.internal.o implements c9.a<c0> {
        final /* synthetic */ j<R> this$0;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0000 \u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"R", "Ljava/lang/reflect/Type;", "a", "()Ljava/lang/reflect/Type;"}, k = 3, mv = {1, 8, 0})
        static final class a extends kotlin.jvm.internal.o implements c9.a<Type> {
            final /* synthetic */ j<R> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            a(j<? extends R> jVar) {
                super(0);
                this.this$0 = jVar;
            }

            @Override // c9.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Type invoke() {
                Type typeO = this.this$0.o();
                return typeO == null ? this.this$0.q().getReturnType() : typeO;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        d(j<? extends R> jVar) {
            super(0);
            this.this$0 = jVar;
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final c0 invoke() {
            kotlin.reflect.jvm.internal.impl.types.g0 returnType = this.this$0.w().getReturnType();
            kotlin.jvm.internal.m.c(returnType);
            return new c0(returnType, new a(this.this$0));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001\"\u0006\b\u0000\u0010\u0000 \u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"R", "", "Lkotlin/reflect/jvm/internal/d0;", "kotlin.jvm.PlatformType", "invoke", "()Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    static final class e extends kotlin.jvm.internal.o implements c9.a<List<? extends d0>> {
        final /* synthetic */ j<R> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        e(j<? extends R> jVar) {
            super(0);
            this.this$0 = jVar;
        }

        @Override // c9.a
        public final List<? extends d0> invoke() {
            List<f1> typeParameters = this.this$0.w().getTypeParameters();
            kotlin.jvm.internal.m.e(typeParameters, "descriptor.typeParameters");
            List<f1> list = typeParameters;
            j<R> jVar = this.this$0;
            ArrayList arrayList = new ArrayList(kotlin.collections.r.w(list, 10));
            for (f1 descriptor : list) {
                kotlin.jvm.internal.m.e(descriptor, "descriptor");
                arrayList.add(new d0(jVar, descriptor));
            }
            return arrayList;
        }
    }

    public abstract kotlin.reflect.jvm.internal.calls.e<?> q();

    /* JADX INFO: renamed from: r */
    public abstract n getContainer();

    public abstract kotlin.reflect.jvm.internal.calls.e<?> s();

    /* JADX INFO: renamed from: t */
    public abstract kotlin.reflect.jvm.internal.impl.descriptors.b w();

    public abstract boolean v();

    private final Object[] p() {
        return (Object[]) this._absentArguments.invoke().clone();
    }

    @Override // i9.c
    public R call(Object... args) throws j9.a {
        kotlin.jvm.internal.m.f(args, "args");
        try {
            return (R) q().call(args);
        } catch (IllegalAccessException e10) {
            throw new j9.a(e10);
        }
    }

    @Override // i9.c
    public R callBy(Map<i9.j, ? extends Object> args) {
        kotlin.jvm.internal.m.f(args, "args");
        return u() ? l(args) : m(args, null);
    }

    @Override // i9.b
    public List<Annotation> getAnnotations() {
        List<Annotation> listInvoke = this._annotations.invoke();
        kotlin.jvm.internal.m.e(listInvoke, "_annotations()");
        return listInvoke;
    }

    @Override // i9.c
    public List<i9.j> getParameters() {
        ArrayList<i9.j> arrayListInvoke = this._parameters.invoke();
        kotlin.jvm.internal.m.e(arrayListInvoke, "_parameters()");
        return arrayListInvoke;
    }

    @Override // i9.c
    public i9.n getReturnType() {
        c0 c0VarInvoke = this._returnType.invoke();
        kotlin.jvm.internal.m.e(c0VarInvoke, "_returnType()");
        return c0VarInvoke;
    }

    @Override // i9.c
    public List<i9.o> getTypeParameters() {
        List<d0> listInvoke = this._typeParameters.invoke();
        kotlin.jvm.internal.m.e(listInvoke, "_typeParameters()");
        return listInvoke;
    }

    public final R m(Map<i9.j, ? extends Object> args, v8.f<?> continuationArgument) throws j9.a {
        kotlin.jvm.internal.m.f(args, "args");
        List<i9.j> parameters = getParameters();
        boolean z10 = false;
        if (parameters.isEmpty()) {
            try {
                return (R) q().call(isSuspend() ? new v8.f[]{continuationArgument} : new v8.f[0]);
            } catch (IllegalAccessException e10) {
                throw new j9.a(e10);
            }
        }
        int size = parameters.size() + (isSuspend() ? 1 : 0);
        Object[] objArrP = p();
        if (isSuspend()) {
            objArrP[parameters.size()] = continuationArgument;
        }
        int i10 = 0;
        for (i9.j jVar : parameters) {
            if (args.containsKey(jVar)) {
                objArrP[jVar.getIndex()] = args.get(jVar);
            } else if (jVar.h()) {
                int i11 = (i10 / 32) + size;
                Object obj = objArrP[i11];
                kotlin.jvm.internal.m.d(obj, "null cannot be cast to non-null type kotlin.Int");
                objArrP[i11] = Integer.valueOf(((Integer) obj).intValue() | (1 << (i10 % 32)));
                z10 = true;
            } else if (!jVar.a()) {
                throw new IllegalArgumentException("No argument provided for a required parameter: " + jVar);
            }
            if (jVar.getKind() == i9.j.a.VALUE) {
                i10++;
            }
        }
        if (!z10) {
            try {
                kotlin.reflect.jvm.internal.calls.e<?> eVarQ = q();
                Object[] objArrCopyOf = Arrays.copyOf(objArrP, size);
                kotlin.jvm.internal.m.e(objArrCopyOf, "copyOf(this, newSize)");
                return (R) eVarQ.call(objArrCopyOf);
            } catch (IllegalAccessException e11) {
                throw new j9.a(e11);
            }
        }
        kotlin.reflect.jvm.internal.calls.e<?> eVarS = s();
        if (eVarS != null) {
            try {
                return (R) eVarS.call(objArrP);
            } catch (IllegalAccessException e12) {
                throw new j9.a(e12);
            }
        }
        throw new f0("This callable does not support a default call: " + w());
    }

    public j() {
        h0.a<List<Annotation>> aVarC = h0.c(new b(this));
        kotlin.jvm.internal.m.e(aVarC, "lazySoft { descriptor.computeAnnotations() }");
        this._annotations = aVarC;
        h0.a<ArrayList<i9.j>> aVarC2 = h0.c(new c(this));
        kotlin.jvm.internal.m.e(aVarC2, "lazySoft {\n        val d…ze()\n        result\n    }");
        this._parameters = aVarC2;
        h0.a<c0> aVarC3 = h0.c(new d(this));
        kotlin.jvm.internal.m.e(aVarC3, "lazySoft {\n        KType…eturnType\n        }\n    }");
        this._returnType = aVarC3;
        h0.a<List<d0>> aVarC4 = h0.c(new e(this));
        kotlin.jvm.internal.m.e(aVarC4, "lazySoft {\n        descr…this, descriptor) }\n    }");
        this._typeParameters = aVarC4;
        h0.a<Object[]> aVarC5 = h0.c(new a(this));
        kotlin.jvm.internal.m.e(aVarC5, "lazySoft {\n        val p…\n\n        arguments\n    }");
        this._absentArguments = aVarC5;
    }

    private final R l(Map<i9.j, ? extends Object> args) throws j9.a {
        Object objN;
        List<i9.j> parameters = getParameters();
        ArrayList arrayList = new ArrayList(kotlin.collections.r.w(parameters, 10));
        for (i9.j jVar : parameters) {
            if (args.containsKey(jVar)) {
                objN = args.get(jVar);
                if (objN == null) {
                    throw new IllegalArgumentException("Annotation argument value cannot be null (" + jVar + ')');
                }
            } else if (jVar.h()) {
                objN = null;
            } else if (jVar.a()) {
                objN = n(jVar.getType());
            } else {
                throw new IllegalArgumentException("No argument provided for a required parameter: " + jVar);
            }
            arrayList.add(objN);
        }
        kotlin.reflect.jvm.internal.calls.e<?> eVarS = s();
        if (eVarS != null) {
            try {
                return (R) eVarS.call(arrayList.toArray(new Object[0]));
            } catch (IllegalAccessException e10) {
                throw new j9.a(e10);
            }
        }
        throw new f0("This callable does not support a default call: " + w());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object n(i9.n type) {
        Class clsB = b9.a.b(k9.b.b(type));
        if (clsB.isArray()) {
            Object objNewInstance = Array.newInstance(clsB.getComponentType(), 0);
            kotlin.jvm.internal.m.e(objNewInstance, "type.jvmErasure.java.run…\"\n            )\n        }");
            return objNewInstance;
        }
        throw new f0("Cannot instantiate the default empty array of type " + clsB.getSimpleName() + ", because it is not an array type");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Type o() {
        ParameterizedType parameterizedType;
        Type rawType;
        WildcardType wildcardType;
        Type[] lowerBounds;
        if (isSuspend()) {
            Object objU0 = kotlin.collections.r.u0(q().a());
            if (objU0 instanceof ParameterizedType) {
                parameterizedType = (ParameterizedType) objU0;
            } else {
                parameterizedType = null;
            }
            if (parameterizedType != null) {
                rawType = parameterizedType.getRawType();
            } else {
                rawType = null;
            }
            if (kotlin.jvm.internal.m.a(rawType, v8.f.class)) {
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                kotlin.jvm.internal.m.e(actualTypeArguments, "continuationType.actualTypeArguments");
                Object objN0 = kotlin.collections.j.n0(actualTypeArguments);
                if (objN0 instanceof WildcardType) {
                    wildcardType = (WildcardType) objN0;
                } else {
                    wildcardType = null;
                }
                if (wildcardType != null && (lowerBounds = wildcardType.getLowerBounds()) != null) {
                    return (Type) kotlin.collections.j.O(lowerBounds);
                }
            }
        }
        return null;
    }

    @Override // i9.c
    public i9.r getVisibility() {
        kotlin.reflect.jvm.internal.impl.descriptors.u visibility = w().getVisibility();
        kotlin.jvm.internal.m.e(visibility, "descriptor.visibility");
        return n0.q(visibility);
    }

    @Override // i9.c
    public boolean isAbstract() {
        if (w().i() == kotlin.reflect.jvm.internal.impl.descriptors.e0.ABSTRACT) {
            return true;
        }
        return false;
    }

    @Override // i9.c
    public boolean isFinal() {
        if (w().i() == kotlin.reflect.jvm.internal.impl.descriptors.e0.FINAL) {
            return true;
        }
        return false;
    }

    @Override // i9.c
    public boolean isOpen() {
        if (w().i() == kotlin.reflect.jvm.internal.impl.descriptors.e0.OPEN) {
            return true;
        }
        return false;
    }

    protected final boolean u() {
        if (kotlin.jvm.internal.m.a(getName(), "<init>") && getContainer().d().isAnnotation()) {
            return true;
        }
        return false;
    }
}
