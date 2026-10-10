package x1.f1.lb.util;

import android.annotation.SuppressLint;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.taobao.sophix.PatchStatus;
import java.util.HashMap;
import kotlin.Metadata;
import kotlinx.coroutines.a2;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002-:B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\r\u001a\u00020\f\"\u0004\b\u0000\u0010\b2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\u0019\u0010\u001aJ\"\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u001b\u001a\u00020\u0013H\u0086@¢\u0006\u0004\b\u001c\u0010\u001dJ-\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00130\t2\b\b\u0002\u0010\u001b\u001a\u00020\u0013¢\u0006\u0004\b\u001e\u0010\u001fJ\"\u0010 \u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u001b\u001a\u00020\u0016H\u0086@¢\u0006\u0004\b \u0010!J-\u0010\"\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00160\t2\b\b\u0002\u0010\u001b\u001a\u00020\u0016¢\u0006\u0004\b\"\u0010#J\"\u0010$\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u001b\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b$\u0010%J-\u0010&\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\t2\b\b\u0002\u0010\u001b\u001a\u00020\u0004¢\u0006\u0004\b&\u0010'J)\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000(\"\u0004\b\u0000\u0010\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00028\u0000¢\u0006\u0004\b)\u0010*R\u001c\u0010/\u001a\n ,*\u0004\u0018\u00010+0+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00103\u001a\u0002008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R0\u00108\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000404j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`58\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u00109¨\u0006;"}, d2 = {"Lx1/f1/lb/util/w0;", "", "<init>", "()V", "", "key", "f", "(Ljava/lang/String;)Ljava/lang/String;", ExifInterface.GPS_DIRECTION_TRUE, "Lx1/f1/lb/util/w0$a;", "callback", "value", "Lr8/z;", "e", "(Lx1/f1/lb/util/w0$a;Ljava/lang/Object;)V", "Lx1/f1/lb/util/w0$b;", "editor", "q", "(Lx1/f1/lb/util/w0$b;)V", "", "r", "(Ljava/lang/String;I)V", "", "s", "(Ljava/lang/String;J)V", "t", "(Ljava/lang/String;Ljava/lang/String;)V", "dft", "h", "(Ljava/lang/String;ILv8/f;)Ljava/lang/Object;", "i", "(Ljava/lang/String;Lx1/f1/lb/util/w0$a;I)V", "j", "(Ljava/lang/String;JLv8/f;)Ljava/lang/Object;", "k", "(Ljava/lang/String;Lx1/f1/lb/util/w0$a;J)V", "m", "(Ljava/lang/String;Ljava/lang/String;Lv8/f;)Ljava/lang/Object;", "n", "(Ljava/lang/String;Lx1/f1/lb/util/w0$a;Ljava/lang/String;)V", "Lkotlinx/coroutines/flow/f;", "g", "(Ljava/lang/String;Ljava/lang/Object;)Lkotlinx/coroutines/flow/f;", "Lq6/b;", "kotlin.jvm.PlatformType", "b", "Lq6/b;", "logger", "Lkotlinx/coroutines/l0;", "c", "Lkotlinx/coroutines/l0;", "puckScope", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "d", "Ljava/util/HashMap;", "keyMap", "Lx1/f1/lb/util/w0$b;", "a", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w0 f21452a;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final q6.b logger;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final kotlinx.coroutines.l0 puckScope;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    @SuppressLint({"StaticFieldLeak"})
    private static final HashMap<String, String> keyMap;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static b editor;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lx1/f1/lb/util/w0$a;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "value", "Lr8/z;", "a", "(Ljava/lang/Object;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface a<V> {
        void a(V value);
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H¦@¢\u0006\u0004\b\u0007\u0010\bJ \u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0004H¦@¢\u0006\u0004\b\n\u0010\bJ \u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH¦@¢\u0006\u0004\b\r\u0010\u000eJ \u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u000bH¦@¢\u0006\u0004\b\u000f\u0010\u000eJ \u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002H¦@¢\u0006\u0004\b\u0011\u0010\u0012J \u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H¦@¢\u0006\u0004\b\u0013\u0010\u0012¨\u0006\u0014"}, d2 = {"Lx1/f1/lb/util/w0$b;", "", "", "key", "", "int", "Lr8/z;", "a", "(Ljava/lang/String;ILv8/f;)Ljava/lang/Object;", "dft", "e", "", "long", "c", "(Ljava/lang/String;JLv8/f;)Ljava/lang/Object;", "b", TypedValues.Custom.S_STRING, "d", "(Ljava/lang/String;Ljava/lang/String;Lv8/f;)Ljava/lang/Object;", "f", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface b {
        Object a(String str, int i10, v8.f<? super r8.z> fVar);

        Object b(String str, long j10, v8.f<? super Long> fVar);

        Object c(String str, long j10, v8.f<? super r8.z> fVar);

        Object d(String str, String str2, v8.f<? super r8.z> fVar);

        Object e(String str, int i10, v8.f<? super Integer> fVar);

        Object f(String str, String str2, v8.f<? super String> fVar);
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.util.SPUtils$callCallback$1", f = "SPUtils.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class c extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        final /* synthetic */ a<T> $callback;
        final /* synthetic */ T $value;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(a<T> aVar, T t10, v8.f<? super c> fVar) {
            super(2, fVar);
            this.$callback = aVar;
            this.$value = t10;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return new c(this.$callback, this.$value, fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((c) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.b.c();
            if (this.label == 0) {
                r8.r.b(obj);
                this.$callback.a(this.$value);
                return r8.z.f17874a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.util.SPUtils$get$1", f = "SPUtils.kt", l = {172, 173, 174, 178}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/g;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;)V"}, k = 3, mv = {2, 1, 0})
    static final class d<T> extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.flow.g<? super T>, v8.f<? super r8.z>, Object> {
        final /* synthetic */ T $dft;
        final /* synthetic */ String $key;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(T t10, String str, v8.f<? super d> fVar) {
            super(2, fVar);
            this.$dft = t10;
            this.$key = str;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            d dVar = new d(this.$dft, this.$key, fVar);
            dVar.L$0 = obj;
            return dVar;
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.flow.g<? super T> gVar, v8.f<? super r8.z> fVar) {
            return ((d) create(gVar, fVar)).invokeSuspend(r8.z.f17874a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:28:0x0082, code lost:
        
            if (r1.emit(r9, r8) == r0) goto L29;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v10 */
        /* JADX WARN: Type inference failed for: r1v3, types: [kotlinx.coroutines.flow.g] */
        /* JADX WARN: Type inference failed for: r1v6 */
        /* JADX WARN: Type inference failed for: r1v7 */
        /* JADX WARN: Type inference failed for: r1v8 */
        /* JADX WARN: Type inference failed for: r1v9 */
        @Override // kotlin.coroutines.jvm.internal.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            kotlinx.coroutines.flow.g gVar;
            ?? r10;
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1 && i10 != 2 && i10 != 3) {
                    if (i10 == 4) {
                        r8.r.b(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    kotlinx.coroutines.flow.g gVar2 = (kotlinx.coroutines.flow.g) this.L$0;
                    r8.r.b(obj);
                    r10 = gVar2;
                }
                return r8.z.f17874a;
            }
            r8.r.b(obj);
            gVar = (kotlinx.coroutines.flow.g) this.L$0;
            obj = this.$dft;
            if (obj instanceof String) {
                this.L$0 = gVar;
                this.label = 1;
                obj = w0.f21452a.m(this.$key, (String) obj, this);
                if (obj != objC) {
                }
            } else if (obj instanceof Integer) {
                w0 w0Var = w0.f21452a;
                String str = this.$key;
                int iIntValue = ((Number) obj).intValue();
                this.L$0 = gVar;
                this.label = 2;
                obj = w0Var.h(str, iIntValue, this);
                if (obj != objC) {
                }
            } else if (obj instanceof Long) {
                w0 w0Var2 = w0.f21452a;
                String str2 = this.$key;
                long jLongValue = ((Number) obj).longValue();
                this.L$0 = gVar;
                this.label = 3;
                obj = w0Var2.j(str2, jLongValue, this);
                if (obj != objC) {
                }
            }
            r10 = gVar;
            r10 = gVar;
            r10 = gVar;
            r10 = gVar;
            return objC;
            r10 = gVar;
            r10 = gVar;
            r10 = gVar;
            r10 = gVar;
            r10 = gVar;
            this.L$0 = null;
            this.label = 4;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.util.SPUtils", f = "SPUtils.kt", l = {90, 92}, m = "getInt")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class e extends kotlin.coroutines.jvm.internal.d {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        e(v8.f<? super e> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return w0.this.h(null, 0, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.util.SPUtils$getInt$2", f = "SPUtils.kt", l = {106}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class f extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        final /* synthetic */ a<Integer> $callback;
        final /* synthetic */ int $dft;
        final /* synthetic */ String $key;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(a<Integer> aVar, String str, int i10, v8.f<? super f> fVar) {
            super(2, fVar);
            this.$callback = aVar;
            this.$key = str;
            this.$dft = i10;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return new f(this.$callback, this.$key, this.$dft, fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((f) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            a<Integer> aVar;
            Exception e10;
            a<Integer> aVar2;
            int iIntValue;
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 == 1) {
                    aVar2 = (a) this.L$1;
                    aVar = (a) this.L$0;
                    try {
                        r8.r.b(obj);
                    } catch (Exception e11) {
                        e10 = e11;
                        w0.logger.error("get [{}] from sp failure", this.$key, e10);
                        iIntValue = this.$dft;
                        aVar2 = aVar;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                r8.r.b(obj);
                a<Integer> aVar3 = this.$callback;
                try {
                    w0 w0Var = w0.f21452a;
                    String str = this.$key;
                    int i11 = this.$dft;
                    this.L$0 = aVar3;
                    this.L$1 = aVar3;
                    this.label = 1;
                    Object objH = w0Var.h(str, i11, this);
                    if (objH == objC) {
                        return objC;
                    }
                    aVar2 = aVar3;
                    obj = objH;
                    aVar = aVar2;
                } catch (Exception e12) {
                    aVar = aVar3;
                    e10 = e12;
                    w0.logger.error("get [{}] from sp failure", this.$key, e10);
                    iIntValue = this.$dft;
                    aVar2 = aVar;
                }
            }
            iIntValue = ((Number) obj).intValue();
            aVar2.a(kotlin.coroutines.jvm.internal.b.b(iIntValue));
            return r8.z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.util.SPUtils", f = "SPUtils.kt", l = {116, 118}, m = "getLong")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class g extends kotlin.coroutines.jvm.internal.d {
        long J$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        g(v8.f<? super g> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return w0.this.j(null, 0L, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.util.SPUtils$getLong$2", f = "SPUtils.kt", l = {PatchStatus.CODE_LOAD_LIB_CPUABIS}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class h extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        final /* synthetic */ a<Long> $callback;
        final /* synthetic */ long $dft;
        final /* synthetic */ String $key;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(a<Long> aVar, String str, long j10, v8.f<? super h> fVar) {
            super(2, fVar);
            this.$callback = aVar;
            this.$key = str;
            this.$dft = j10;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return new h(this.$callback, this.$key, this.$dft, fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((h) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            w0 w0Var;
            a<Long> aVar;
            Exception e10;
            w0 w0Var2;
            a<Long> aVar2;
            long jLongValue;
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 == 1) {
                    aVar2 = (a) this.L$3;
                    w0Var = (w0) this.L$2;
                    aVar = (a) this.L$1;
                    w0Var2 = (w0) this.L$0;
                    try {
                        r8.r.b(obj);
                    } catch (Exception e11) {
                        e10 = e11;
                        w0.logger.error("get [{}] from sp failure", this.$key, e10);
                        aVar2 = aVar;
                        jLongValue = this.$dft;
                        w0Var = w0Var2;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                r8.r.b(obj);
                w0Var = w0.f21452a;
                a<Long> aVar3 = this.$callback;
                try {
                    String str = this.$key;
                    long j10 = this.$dft;
                    this.L$0 = w0Var;
                    this.L$1 = aVar3;
                    this.L$2 = w0Var;
                    this.L$3 = aVar3;
                    this.label = 1;
                    Object objJ = w0Var.j(str, j10, this);
                    if (objJ == objC) {
                        return objC;
                    }
                    aVar2 = aVar3;
                    w0Var2 = w0Var;
                    obj = objJ;
                    aVar = aVar2;
                } catch (Exception e12) {
                    aVar = aVar3;
                    e10 = e12;
                    w0Var2 = w0Var;
                    w0.logger.error("get [{}] from sp failure", this.$key, e10);
                    aVar2 = aVar;
                    jLongValue = this.$dft;
                    w0Var = w0Var2;
                }
            }
            jLongValue = ((Number) obj).longValue();
            w0Var.e(aVar2, kotlin.coroutines.jvm.internal.b.c(jLongValue));
            return r8.z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.util.SPUtils", f = "SPUtils.kt", l = {141, 141}, m = "getString")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class i extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        i(v8.f<? super i> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return w0.this.m(null, null, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.util.SPUtils$getString$2", f = "SPUtils.kt", l = {161}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class j extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        final /* synthetic */ a<String> $callback;
        final /* synthetic */ String $dft;
        final /* synthetic */ String $key;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(a<String> aVar, String str, String str2, v8.f<? super j> fVar) {
            super(2, fVar);
            this.$callback = aVar;
            this.$key = str;
            this.$dft = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return new j(this.$callback, this.$key, this.$dft, fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((j) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            w0 w0Var;
            a<String> aVar;
            Exception e10;
            w0 w0Var2;
            a<String> aVar2;
            String str;
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 == 1) {
                    aVar2 = (a) this.L$3;
                    w0Var = (w0) this.L$2;
                    aVar = (a) this.L$1;
                    w0Var2 = (w0) this.L$0;
                    try {
                        r8.r.b(obj);
                    } catch (Exception e11) {
                        e10 = e11;
                        w0.logger.error("get [{}] from sp failure", this.$key, e10);
                        str = this.$dft;
                        aVar2 = aVar;
                        w0Var = w0Var2;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                r8.r.b(obj);
                w0Var = w0.f21452a;
                a<String> aVar3 = this.$callback;
                try {
                    String str2 = this.$key;
                    String str3 = this.$dft;
                    this.L$0 = w0Var;
                    this.L$1 = aVar3;
                    this.L$2 = w0Var;
                    this.L$3 = aVar3;
                    this.label = 1;
                    Object objM = w0Var.m(str2, str3, this);
                    if (objM == objC) {
                        return objC;
                    }
                    aVar2 = aVar3;
                    w0Var2 = w0Var;
                    obj = objM;
                    aVar = aVar2;
                } catch (Exception e12) {
                    aVar = aVar3;
                    e10 = e12;
                    w0Var2 = w0Var;
                    w0.logger.error("get [{}] from sp failure", this.$key, e10);
                    str = this.$dft;
                    aVar2 = aVar;
                    w0Var = w0Var2;
                }
            }
            str = (String) obj;
            w0Var.e(aVar2, str);
            return r8.z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.util.SPUtils$putInt$1", f = "SPUtils.kt", l = {56}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class k extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        final /* synthetic */ String $key;
        final /* synthetic */ int $value;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k(String str, int i10, v8.f<? super k> fVar) {
            super(2, fVar);
            this.$key = str;
            this.$value = i10;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return new k(this.$key, this.$value, fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((k) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            try {
                if (i10 != 0) {
                    if (i10 == 1) {
                        r8.r.b(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    r8.r.b(obj);
                    b bVar = w0.editor;
                    if (bVar != null) {
                        String strF = w0.f21452a.f(this.$key);
                        int i11 = this.$value;
                        this.label = 1;
                        if (bVar.a(strF, i11, this) == objC) {
                            return objC;
                        }
                    }
                }
            } catch (Exception e10) {
                w0.logger.error("put [{}] into sp failure", this.$key, e10);
            }
            return r8.z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.util.SPUtils$putLong$1", f = "SPUtils.kt", l = {66}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class l extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        final /* synthetic */ String $key;
        final /* synthetic */ long $value;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l(String str, long j10, v8.f<? super l> fVar) {
            super(2, fVar);
            this.$key = str;
            this.$value = j10;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return new l(this.$key, this.$value, fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((l) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            try {
                if (i10 != 0) {
                    if (i10 == 1) {
                        r8.r.b(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    r8.r.b(obj);
                    b bVar = w0.editor;
                    if (bVar != null) {
                        String strF = w0.f21452a.f(this.$key);
                        long j10 = this.$value;
                        this.label = 1;
                        if (bVar.c(strF, j10, this) == objC) {
                            return objC;
                        }
                    }
                }
            } catch (Exception e10) {
                w0.logger.error("put [{}] into sp failure", this.$key, e10);
            }
            return r8.z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.util.SPUtils$putString$1", f = "SPUtils.kt", l = {81}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class m extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        final /* synthetic */ String $key;
        final /* synthetic */ String $value;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        m(String str, String str2, v8.f<? super m> fVar) {
            super(2, fVar);
            this.$value = str;
            this.$key = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return new m(this.$value, this.$key, fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((m) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            try {
                if (i10 != 0) {
                    if (i10 == 1) {
                        r8.r.b(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    r8.r.b(obj);
                    String strC = x1.f1.lb.util.a.f21291a.c(this.$value, false);
                    if (x1.f1.lb.config.b.f20643a.t()) {
                        w0.logger.debug("sp_string_put[{}], size[{}]", this.$key, kotlin.coroutines.jvm.internal.b.b(strC.length()));
                    }
                    b bVar = w0.editor;
                    if (bVar != null) {
                        String strF = w0.f21452a.f(this.$key);
                        this.label = 1;
                        if (bVar.d(strF, strC, this) == objC) {
                            return objC;
                        }
                    }
                }
            } catch (Exception e10) {
                w0.logger.error("put [{}] into sp failure", this.$key, e10);
            }
            return r8.z.f17874a;
        }
    }

    static {
        w0 w0Var = new w0();
        f21452a = w0Var;
        logger = q6.c.d(w0Var.getClass());
        puckScope = kotlinx.coroutines.m0.a(a2.b(null, 1, null).plus(kotlinx.coroutines.a1.b()));
        keyMap = new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T> void e(a<T> callback, T value) {
        if (callback == null) {
            return;
        }
        kotlinx.coroutines.j.d(kotlinx.coroutines.m0.a(kotlinx.coroutines.a1.c()), null, null, new c(callback, value, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String f(String key) {
        String strO;
        HashMap<String, String> map = keyMap;
        String str = map.get(key);
        if (str == null) {
            str = "";
        }
        if (str.length() != 0) {
            return str;
        }
        synchronized (this) {
            try {
                strO = map.get(key);
                if (strO == null) {
                    strO = "";
                }
                if (strO.length() == 0) {
                    strO = n.n().o(key);
                    if (strO == null) {
                        strO = key;
                    }
                    map.put(key, strO);
                }
                r8.z zVar = r8.z.f17874a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return strO;
    }

    public static /* synthetic */ Object l(w0 w0Var, String str, long j10, v8.f fVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = 0;
        }
        return w0Var.j(str, j10, fVar);
    }

    public static /* synthetic */ Object o(w0 w0Var, String str, String str2, v8.f fVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = "";
        }
        return w0Var.m(str, str2, fVar);
    }

    public static /* synthetic */ void p(w0 w0Var, String str, a aVar, String str2, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str2 = "";
        }
        w0Var.n(str, aVar, str2);
    }

    public final <T> kotlinx.coroutines.flow.f<T> g(String key, T dft) {
        kotlin.jvm.internal.m.f(key, "key");
        return kotlinx.coroutines.flow.h.v(new d(dft, key, null));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0074, code lost:
    
        if (r9 == r1) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object h(String str, int i10, v8.f<? super Integer> fVar) {
        e eVar;
        int iIntValue;
        int i11;
        if (fVar instanceof e) {
            eVar = (e) fVar;
            int i12 = eVar.label;
            if ((i12 & Integer.MIN_VALUE) != 0) {
                eVar.label = i12 - Integer.MIN_VALUE;
            } else {
                eVar = new e(fVar);
            }
        } else {
            eVar = new e(fVar);
        }
        Object objE = eVar.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i13 = eVar.label;
        try {
            try {
                if (i13 == 0) {
                    r8.r.b(objE);
                    b bVar = editor;
                    if (bVar == null) {
                        return kotlin.coroutines.jvm.internal.b.b(i10);
                    }
                    String strF = f(str);
                    eVar.L$0 = str;
                    eVar.I$0 = i10;
                    eVar.label = 1;
                    objE = bVar.e(strF, i10, eVar);
                    if (objE == objC) {
                    }
                    return objC;
                }
                if (i13 == 1) {
                    i10 = eVar.I$0;
                    str = (String) eVar.L$0;
                    r8.r.b(objE);
                } else {
                    if (i13 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i10 = eVar.I$0;
                    str = (String) eVar.L$0;
                    r8.r.b(objE);
                }
                iIntValue = ((Number) objE).intValue();
                int i14 = iIntValue;
                i11 = i10;
                i10 = i14;
                return kotlin.coroutines.jvm.internal.b.b(i10);
                return kotlin.coroutines.jvm.internal.b.b(i10);
            } catch (Exception e10) {
                int i15 = i11;
                e = e10;
                i10 = i15;
                logger.error("get [{}] from sp failure", str, e);
                return kotlin.coroutines.jvm.internal.b.b(i10);
            }
            iIntValue = ((Number) objE).intValue();
            if (iIntValue != i10) {
                int i16 = iIntValue;
                i11 = i10;
                i10 = i16;
            } else {
                b bVar2 = editor;
                if (bVar2 != null) {
                    eVar.L$0 = str;
                    eVar.I$0 = i10;
                    eVar.label = 2;
                    objE = bVar2.e(str, i10, eVar);
                } else {
                    i11 = i10;
                }
            }
        } catch (Exception e11) {
            e = e11;
        }
    }

    public final void i(String key, a<Integer> callback, int dft) {
        kotlin.jvm.internal.m.f(key, "key");
        kotlin.jvm.internal.m.f(callback, "callback");
        kotlinx.coroutines.j.d(puckScope, null, null, new f(callback, key, dft, null), 3, null);
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0072 A[Catch: Exception -> 0x0089, TRY_LEAVE, TryCatch #0 {Exception -> 0x0089, blocks: (B:44:0x008d, B:33:0x006e, B:35:0x0072), top: B:48:0x006e }] */
    /* JADX WARN: Code duplicated, block: B:38:0x007f  */
    /* JADX WARN: Code duplicated, block: B:43:0x008c  */
    /* JADX WARN: Code duplicated, block: B:48:0x006e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object j(String str, long j10, v8.f<? super Long> fVar) {
        g gVar;
        long j11;
        b bVar;
        if (fVar instanceof g) {
            gVar = (g) fVar;
            int i10 = gVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                gVar.label = i10 - Integer.MIN_VALUE;
            } else {
                gVar = new g(fVar);
            }
        } else {
            gVar = new g(fVar);
        }
        Object objB = gVar.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = gVar.label;
        try {
            if (i11 != 0) {
                if (i11 == 1) {
                    j10 = gVar.J$0;
                    str = (String) gVar.L$0;
                    r8.r.b(objB);
                } else {
                    if (i11 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    j10 = gVar.J$0;
                    str = (String) gVar.L$0;
                    r8.r.b(objB);
                }
                j11 = j10;
                j10 = ((Number) objB).longValue();
                return kotlin.coroutines.jvm.internal.b.c(j10);
            }
            r8.r.b(objB);
            b bVar2 = editor;
            if (bVar2 == null) {
                j11 = j10;
                if (j10 == j11) {
                    try {
                        bVar = editor;
                        if (bVar != null) {
                            gVar.L$0 = str;
                            gVar.J$0 = j11;
                            gVar.label = 2;
                            objB = bVar.b(str, j11, gVar);
                            if (objB != objC) {
                                j10 = j11;
                                j11 = j10;
                                j10 = ((Number) objB).longValue();
                            }
                        } else {
                            j10 = j11;
                        }
                    } catch (Exception e10) {
                        e = e10;
                        j10 = j11;
                        logger.error("get [{}] from sp failure", str, e);
                        return kotlin.coroutines.jvm.internal.b.c(j10);
                    }
                }
                return kotlin.coroutines.jvm.internal.b.c(j10);
            }
            String strF = f(str);
            gVar.L$0 = str;
            gVar.J$0 = j10;
            gVar.label = 1;
            objB = bVar2.b(strF, j10, gVar);
            if (objB == objC) {
            }
            return objC;
            j11 = j10;
            j10 = ((Number) objB).longValue();
            if (j10 == j11) {
                bVar = editor;
                if (bVar != null) {
                    gVar.L$0 = str;
                    gVar.J$0 = j11;
                    gVar.label = 2;
                    objB = bVar.b(str, j11, gVar);
                    if (objB != objC) {
                        j10 = j11;
                        j11 = j10;
                        j10 = ((Number) objB).longValue();
                    }
                    return objC;
                }
                j10 = j11;
            }
            return kotlin.coroutines.jvm.internal.b.c(j10);
        } catch (Exception e11) {
            e = e11;
        }
    }

    public final void k(String key, a<Long> callback, long dft) {
        kotlin.jvm.internal.m.f(key, "key");
        kotlin.jvm.internal.m.f(callback, "callback");
        kotlinx.coroutines.j.d(puckScope, null, null, new h(callback, key, dft, null), 3, null);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0065 A[PHI: r9 r10
      0x0065: PHI (r9v1 java.lang.String) = (r9v0 java.lang.String), (r9v3 java.lang.String) binds: [B:17:0x004e, B:22:0x0063] A[DONT_GENERATE, DONT_INLINE]
      0x0065: PHI (r10v1 java.lang.String) = (r10v0 java.lang.String), (r10v3 java.lang.String) binds: [B:17:0x004e, B:22:0x0063] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:25:0x0069  */
    /* JADX WARN: Code duplicated, block: B:28:0x0076  */
    /* JADX WARN: Code duplicated, block: B:33:0x0087 A[Catch: all -> 0x009d, TryCatch #0 {all -> 0x009d, blocks: (B:31:0x007f, B:33:0x0087, B:36:0x009f, B:38:0x00a5, B:40:0x00ab), top: B:45:0x007f }] */
    /* JADX WARN: Code duplicated, block: B:38:0x00a5 A[Catch: all -> 0x009d, TryCatch #0 {all -> 0x009d, blocks: (B:31:0x007f, B:33:0x0087, B:36:0x009f, B:38:0x00a5, B:40:0x00ab), top: B:45:0x007f }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x005e, code lost:
    
        if (r11 == r1) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m(String str, String str2, v8.f<? super String> fVar) {
        i iVar;
        b bVar;
        String str3;
        String str4;
        String str5;
        if (fVar instanceof i) {
            iVar = (i) fVar;
            int i10 = iVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                iVar.label = i10 - Integer.MIN_VALUE;
            } else {
                iVar = new i(fVar);
            }
        } else {
            iVar = new i(fVar);
        }
        Object objF = iVar.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = iVar.label;
        if (i11 == 0) {
            r8.r.b(objF);
            b bVar2 = editor;
            if (bVar2 == null) {
                bVar = editor;
                if (bVar != null) {
                    iVar.L$0 = str;
                    iVar.L$1 = str2;
                    iVar.label = 2;
                    objF = bVar.f(str, str2, iVar);
                    if (objF != objC) {
                        String str6 = str2;
                        str3 = str;
                        str4 = str6;
                        str5 = (String) objF;
                        String str7 = str3;
                        str2 = str4;
                        str = str7;
                        if (x1.f1.lb.config.b.f20643a.t()) {
                            logger.debug("sp_string_get[{}], size[{}]", str, kotlin.coroutines.jvm.internal.b.b(str5.length()));
                        }
                        if (str5.length() > 0) {
                        }
                    }
                }
                return str2;
            }
            String strF = f(str);
            iVar.L$0 = str;
            iVar.L$1 = str2;
            iVar.label = 1;
            objF = bVar2.f(strF, str2, iVar);
            return objC;
        }
        if (i11 == 1) {
            str2 = (String) iVar.L$1;
            str = (String) iVar.L$0;
            r8.r.b(objF);
        } else {
            if (i11 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str4 = (String) iVar.L$1;
            str3 = (String) iVar.L$0;
            r8.r.b(objF);
        }
        str5 = (String) objF;
        String str8 = str3;
        str2 = str4;
        str = str8;
        try {
            if (x1.f1.lb.config.b.f20643a.t()) {
                logger.debug("sp_string_get[{}], size[{}]", str, kotlin.coroutines.jvm.internal.b.b(str5.length()));
            }
            return (str5.length() > 0 || kotlin.jvm.internal.m.a(str5, str2)) ? str2 : x1.f1.lb.util.a.f21291a.a(str5, false);
        } catch (Throwable th) {
            logger.error("get [{}] from sp failure", str, th);
        }
        str5 = (String) objF;
        if (str5 != null) {
            if (x1.f1.lb.config.b.f20643a.t()) {
                logger.debug("sp_string_get[{}], size[{}]", str, kotlin.coroutines.jvm.internal.b.b(str5.length()));
            }
            if (str5.length() > 0) {
            }
        }
        bVar = editor;
        if (bVar != null) {
            iVar.L$0 = str;
            iVar.L$1 = str2;
            iVar.label = 2;
            objF = bVar.f(str, str2, iVar);
            if (objF != objC) {
                String str9 = str2;
                str3 = str;
                str4 = str9;
                str5 = (String) objF;
                String str10 = str3;
                str2 = str4;
                str = str10;
                if (x1.f1.lb.config.b.f20643a.t()) {
                    logger.debug("sp_string_get[{}], size[{}]", str, kotlin.coroutines.jvm.internal.b.b(str5.length()));
                }
                if (str5.length() > 0) {
                }
            }
            return objC;
        }
        return str2;
    }

    public final void n(String key, a<String> callback, String dft) {
        kotlin.jvm.internal.m.f(key, "key");
        kotlin.jvm.internal.m.f(callback, "callback");
        kotlin.jvm.internal.m.f(dft, "dft");
        kotlinx.coroutines.j.d(puckScope, null, null, new j(callback, key, dft, null), 3, null);
    }

    public final void q(b editor2) {
        kotlin.jvm.internal.m.f(editor2, "editor");
        editor = editor2;
    }

    public final void r(String key, int value) {
        kotlin.jvm.internal.m.f(key, "key");
        kotlinx.coroutines.j.d(puckScope, null, null, new k(key, value, null), 3, null);
    }

    public final void s(String key, long value) {
        kotlin.jvm.internal.m.f(key, "key");
        kotlinx.coroutines.j.d(puckScope, null, null, new l(key, value, null), 3, null);
    }

    public final void t(String key, String value) {
        kotlin.jvm.internal.m.f(key, "key");
        kotlin.jvm.internal.m.f(value, "value");
        kotlinx.coroutines.j.d(puckScope, null, null, new m(value, key, null), 3, null);
    }

    private w0() {
    }
}
