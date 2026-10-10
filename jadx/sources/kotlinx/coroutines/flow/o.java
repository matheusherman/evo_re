package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlinx.coroutines.u1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u001aV\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012.\u0010\b\u001a*\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0002ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a3\u0010\f\u001a\u0004\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0080@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u001b\u0010\u0011\u001a\u00020\u0010*\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u001d\u0010\u0014\u001a\u00020\u0010*\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\u0015\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/f;", "Lkotlin/Function3;", "Lkotlinx/coroutines/flow/g;", "", "Lv8/f;", "Lr8/z;", "", "action", "a", "(Lkotlinx/coroutines/flow/f;Lc9/q;)Lkotlinx/coroutines/flow/f;", "collector", "b", "(Lkotlinx/coroutines/flow/f;Lkotlinx/coroutines/flow/g;Lv8/f;)Ljava/lang/Object;", "Lv8/j;", "coroutineContext", "", "c", "(Ljava/lang/Throwable;Lv8/j;)Z", TransactionPartnerType.OTHER, "d", "(Ljava/lang/Throwable;Ljava/lang/Throwable;)Z", "kotlinx-coroutines-core"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
final /* synthetic */ class o {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/o$a", "Lkotlinx/coroutines/flow/f;", "Lkotlinx/coroutines/flow/g;", "collector", "Lr8/z;", "collect", "(Lkotlinx/coroutines/flow/g;Lv8/f;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class a<T> implements f<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f14761a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ c9.q f14762b;

        /* JADX INFO: renamed from: kotlinx.coroutines.flow.o$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1", f = "Errors.kt", l = {114, 115}, m = "collect")
        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public static final class C0285a extends kotlin.coroutines.jvm.internal.d {
            Object L$0;
            Object L$1;
            int label;
            /* synthetic */ Object result;

            public C0285a(v8.f fVar) {
                super(fVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return a.this.collect(null, this);
            }
        }

        public a(f fVar, c9.q qVar) {
            this.f14761a = fVar;
            this.f14762b = qVar;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x006c, code lost:
        
            if (r6 == r1) goto L24;
         */
        @Override // kotlinx.coroutines.flow.f
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Object collect(g<? super T> gVar, v8.f<? super r8.z> fVar) {
            C0285a c0285a;
            a<T> aVar;
            if (fVar instanceof C0285a) {
                c0285a = (C0285a) fVar;
                int i10 = c0285a.label;
                if ((i10 & Integer.MIN_VALUE) != 0) {
                    c0285a.label = i10 - Integer.MIN_VALUE;
                } else {
                    c0285a = new C0285a(fVar);
                }
            } else {
                c0285a = new C0285a(fVar);
            }
            Object objG = c0285a.result;
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i11 = c0285a.label;
            if (i11 != 0) {
                if (i11 == 1) {
                    gVar = (g) c0285a.L$1;
                    aVar = (a) c0285a.L$0;
                    r8.r.b(objG);
                } else {
                    if (i11 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    r8.r.b(objG);
                }
                return r8.z.f17874a;
            }
            r8.r.b(objG);
            f fVar2 = this.f14761a;
            c0285a.L$0 = this;
            c0285a.L$1 = gVar;
            c0285a.label = 1;
            objG = h.g(fVar2, gVar, c0285a);
            if (objG != objC) {
                aVar = this;
            }
            return objC;
            Throwable th = (Throwable) objG;
            if (th != null) {
                c9.q qVar = aVar.f14762b;
                c0285a.L$0 = null;
                c0285a.L$1 = null;
                c0285a.label = 2;
                kotlin.jvm.internal.l.c(6);
                Object objInvoke = qVar.invoke(gVar, th, c0285a);
                kotlin.jvm.internal.l.c(7);
            }
            return r8.z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt", f = "Errors.kt", l = {156}, m = "catchImpl")
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    static final class b<T> extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return h.g(null, null, this);
        }

        b(v8.f<? super b> fVar) {
            super(fVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "it", "Lr8/z;", "emit", "(Ljava/lang/Object;Lv8/f;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    static final class c<T> implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ g<T> f14763a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ kotlin.jvm.internal.b0<Throwable> f14764b;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$2", f = "Errors.kt", l = {158}, m = "emit")
        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        static final class a extends kotlin.coroutines.jvm.internal.d {
            Object L$0;
            int label;
            /* synthetic */ Object result;
            final /* synthetic */ c<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            a(c<? super T> cVar, v8.f<? super a> fVar) {
                super(fVar);
                this.this$0 = cVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return this.this$0.emit(null, this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        c(g<? super T> gVar, kotlin.jvm.internal.b0<Throwable> b0Var) {
            this.f14763a = gVar;
            this.f14764b = b0Var;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.g
        public final Object emit(T t10, v8.f<? super r8.z> fVar) throws Throwable {
            a aVar;
            c<T> cVar;
            if (fVar instanceof a) {
                aVar = (a) fVar;
                int i10 = aVar.label;
                if ((i10 & Integer.MIN_VALUE) != 0) {
                    aVar.label = i10 - Integer.MIN_VALUE;
                } else {
                    aVar = new a(this, fVar);
                }
            } else {
                aVar = new a(this, fVar);
            }
            Object obj = aVar.result;
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i11 = aVar.label;
            if (i11 != 0) {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                cVar = (c) aVar.L$0;
                try {
                    r8.r.b(obj);
                    return r8.z.f17874a;
                } catch (Throwable 
                /*  JADX ERROR: Method code generation error
                    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getCodeVar()" because "ssaVar" is null
                    	at jadx.core.codegen.RegionGen.makeCatchBlock(RegionGen.java:372)
                    	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:335)
                    	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:291)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:270)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                    	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                    	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                    	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                    	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                    	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
                    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                    	at jadx.core.ProcessClass.process(ProcessClass.java:89)
                    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
                    	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
                    	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
                    */
                /*
                    this = this;
                    boolean r0 = r6 instanceof kotlinx.coroutines.flow.o.c.a
                    if (r0 == 0) goto L13
                    r0 = r6
                    kotlinx.coroutines.flow.o$c$a r0 = (kotlinx.coroutines.flow.o.c.a) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.label = r1
                    goto L18
                L13:
                    kotlinx.coroutines.flow.o$c$a r0 = new kotlinx.coroutines.flow.o$c$a
                    r0.<init>(r4, r6)
                L18:
                    java.lang.Object r6 = r0.result
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.b.c()
                    int r2 = r0.label
                    r3 = 1
                    if (r2 == 0) goto L37
                    if (r2 != r3) goto L2f
                    java.lang.Object r5 = r0.L$0
                    kotlinx.coroutines.flow.o$c r5 = (kotlinx.coroutines.flow.o.c) r5
                    r8.r.b(r6)     // Catch: java.lang.Throwable -> L2d
                    goto L47
                L2d:
                    r6 = move-exception
                    goto L4c
                L2f:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L37:
                    r8.r.b(r6)
                    kotlinx.coroutines.flow.g<T> r6 = r4.f14763a     // Catch: java.lang.Throwable -> L4a
                    r0.L$0 = r4     // Catch: java.lang.Throwable -> L4a
                    r0.label = r3     // Catch: java.lang.Throwable -> L4a
                    java.lang.Object r5 = r6.emit(r5, r0)     // Catch: java.lang.Throwable -> L4a
                    if (r5 != r1) goto L47
                    return r1
                L47:
                    r8.z r5 = r8.z.f17874a
                    return r5
                L4a:
                    r6 = move-exception
                    r5 = r4
                L4c:
                    kotlin.jvm.internal.b0<java.lang.Throwable> r5 = r5.f14764b
                    r5.element = r6
                    throw r6
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.o.c.emit(java.lang.Object, v8.f):java.lang.Object");
            }
        }

        public static final <T> f<T> a(f<? extends T> fVar, c9.q<? super g<? super T>, ? super Throwable, ? super v8.f<? super r8.z>, ? extends Object> qVar) {
            return new a(fVar, qVar);
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        public static final <T> Object b(f<? extends T> fVar, g<? super T> gVar, v8.f<? super Throwable> fVar2) throws Throwable {
            b bVar;
            kotlin.jvm.internal.b0 b0Var;
            if (fVar2 instanceof b) {
                bVar = (b) fVar2;
                int i10 = bVar.label;
                if ((i10 & Integer.MIN_VALUE) != 0) {
                    bVar.label = i10 - Integer.MIN_VALUE;
                } else {
                    bVar = new b(fVar2);
                }
            } else {
                bVar = new b(fVar2);
            }
            Object obj = bVar.result;
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i11 = bVar.label;
            if (i11 == 0) {
                r8.r.b(obj);
                kotlin.jvm.internal.b0 b0Var2 = new kotlin.jvm.internal.b0();
                try {
                    g<? super Object> cVar = new c<>(gVar, b0Var2);
                    bVar.L$0 = b0Var2;
                    bVar.label = 1;
                    if (fVar.collect(cVar, bVar) == objC) {
                        return objC;
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    b0Var = b0Var2;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b0Var = (kotlin.jvm.internal.b0) bVar.L$0;
                try {
                    r8.r.b(obj);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            Throwable th3 = (Throwable) b0Var.element;
            if (d(th, th3) || c(th, bVar.getContext())) {
                throw th;
            }
            if (th3 == null) {
                return th;
            }
            if (th instanceof CancellationException) {
                r8.a.a(th3, th);
                throw th3;
            }
            r8.a.a(th, th3);
            throw th;
        }

        private static final boolean c(Throwable th, v8.j jVar) {
            u1 u1Var = (u1) jVar.get(u1.INSTANCE);
            if (u1Var == null || !u1Var.isCancelled()) {
                return false;
            }
            return d(th, u1Var.j());
        }

        private static final boolean d(Throwable th, Throwable th2) {
            return th2 != null && kotlin.jvm.internal.m.a(th2, th);
        }
    }
