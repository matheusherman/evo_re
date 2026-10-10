package com.skydoves.sandwich;

import androidx.exifinterface.media.ExifInterface;
import c9.p;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.internal.m;
import r8.n;
import r8.r;
import retrofit2.f0;
import tv.danmaku.ijk.media.player.IMediaPlayer;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001f\u0010\u0002\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001d\u0010\u0004\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0004\u0010\u0003\u001aS\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0005*\b\u0012\u0004\u0012\u00028\u00000\u00012\"\u0010\t\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006H\u0087@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a\u001d\u0010\u000e\u001a\u00020\r\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\f¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u001d\u0010\u0011\u001a\u00020\r\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0010¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u001d\u0010\u0014\u001a\u00020\r\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0013¢\u0006\u0004\b\u0014\u0010\u0015\u001a;\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000\"\u000e\b\u0001\u0010\u0005*\b\u0012\u0004\u0012\u00028\u00000\u0016*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0017\u001a\u00028\u0001¢\u0006\u0004\b\u0018\u0010\u0019\u001aA\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000\"\u000e\b\u0001\u0010\u0005*\b\u0012\u0004\u0012\u00028\u00000\u001a*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0017\u001a\u00028\u0001H\u0087@ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lcom/skydoves/sandwich/a;", "a", "(Lcom/skydoves/sandwich/a;)Ljava/lang/Object;", "b", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/Function2;", "Lv8/f;", "", "transformer", "g", "(Lcom/skydoves/sandwich/a;Lc9/p;Lv8/f;)Ljava/lang/Object;", "Lcom/skydoves/sandwich/a$b;", "", "e", "(Lcom/skydoves/sandwich/a$b;)Ljava/lang/String;", "Lcom/skydoves/sandwich/a$b$a;", "c", "(Lcom/skydoves/sandwich/a$b$a;)Ljava/lang/String;", "Lcom/skydoves/sandwich/a$b$b;", "d", "(Lcom/skydoves/sandwich/a$b$b;)Ljava/lang/String;", "Lm6/a;", "apiResponseOperator", "f", "(Lcom/skydoves/sandwich/a;Lm6/a;)Lcom/skydoves/sandwich/a;", "Lm6/b;", "h", "(Lcom/skydoves/sandwich/a;Lm6/b;Lv8/f;)Ljava/lang/Object;", "sandwich"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "com/skydoves/sandwich/ResponseTransformer")
final /* synthetic */ class c {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @f(c = "com.skydoves.sandwich.ResponseTransformer__ResponseTransformerKt", f = "ResponseTransformer.kt", l = {536}, m = "suspendMapSuccess")
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    static final class a<T, V> extends kotlin.coroutines.jvm.internal.d {
        int label;
        /* synthetic */ Object result;

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return c.g(null, null, this);
        }

        a(v8.f<? super a> fVar) {
            super(fVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @f(c = "com.skydoves.sandwich.ResponseTransformer__ResponseTransformerKt", f = "ResponseTransformer.kt", l = {799, 800, IMediaPlayer.MEDIA_INFO_NOT_SEEKABLE}, m = "suspendOperator")
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    static final class b<T, V extends m6.b<T>> extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return c.h(null, null, this);
        }

        b(v8.f<? super b> fVar) {
            super(fVar);
        }
    }

    public static final <T> T a(com.skydoves.sandwich.a<? extends T> aVar) {
        m.f(aVar, "<this>");
        if (aVar instanceof com.skydoves.sandwich.a.c) {
            return (T) ((com.skydoves.sandwich.a.c) aVar).a();
        }
        if ((aVar instanceof com.skydoves.sandwich.a.b.C0151a) || (aVar instanceof com.skydoves.sandwich.a.b.C0152b)) {
            return null;
        }
        throw new n();
    }

    public static final <T> T b(com.skydoves.sandwich.a<? extends T> aVar) throws Throwable {
        m.f(aVar, "<this>");
        if (aVar instanceof com.skydoves.sandwich.a.c) {
            return (T) ((com.skydoves.sandwich.a.c) aVar).a();
        }
        if (aVar instanceof com.skydoves.sandwich.a.b.C0151a) {
            throw new RuntimeException(com.skydoves.sandwich.b.c((com.skydoves.sandwich.a.b.C0151a) aVar));
        }
        if (aVar instanceof com.skydoves.sandwich.a.b.C0152b) {
            throw ((com.skydoves.sandwich.a.b.C0152b) aVar).getException();
        }
        throw new n();
    }

    public static final <T> String c(com.skydoves.sandwich.a.b.C0151a<T> c0151a) {
        m.f(c0151a, "<this>");
        return c0151a.toString();
    }

    public static final <T> String d(com.skydoves.sandwich.a.b.C0152b<T> c0152b) {
        m.f(c0152b, "<this>");
        return c0152b.toString();
    }

    public static final <T> String e(com.skydoves.sandwich.a.b<T> bVar) {
        m.f(bVar, "<this>");
        if (bVar instanceof com.skydoves.sandwich.a.b.C0151a) {
            return com.skydoves.sandwich.b.c((com.skydoves.sandwich.a.b.C0151a) bVar);
        }
        if (bVar instanceof com.skydoves.sandwich.a.b.C0152b) {
            return com.skydoves.sandwich.b.d((com.skydoves.sandwich.a.b.C0152b) bVar);
        }
        throw new n();
    }

    public static final /* synthetic */ com.skydoves.sandwich.a f(com.skydoves.sandwich.a aVar, m6.a apiResponseOperator) {
        m.f(aVar, "<this>");
        m.f(apiResponseOperator, "apiResponseOperator");
        if (aVar instanceof com.skydoves.sandwich.a.c) {
            apiResponseOperator.c((com.skydoves.sandwich.a.c) aVar);
            return aVar;
        }
        if (aVar instanceof com.skydoves.sandwich.a.b.C0151a) {
            apiResponseOperator.a((com.skydoves.sandwich.a.b.C0151a) aVar);
            return aVar;
        }
        if (aVar instanceof com.skydoves.sandwich.a.b.C0152b) {
            apiResponseOperator.b((com.skydoves.sandwich.a.b.C0152b) aVar);
        }
        return aVar;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final /* synthetic */ Object g(com.skydoves.sandwich.a aVar, p pVar, v8.f fVar) {
        a aVar2;
        Object c0152b;
        if (fVar instanceof a) {
            aVar2 = (a) fVar;
            int i10 = aVar2.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                aVar2.label = i10 - Integer.MIN_VALUE;
            } else {
                aVar2 = new a(fVar);
            }
        } else {
            aVar2 = new a(fVar);
        }
        Object objInvoke = aVar2.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = aVar2.label;
        if (i11 == 0) {
            r.b(objInvoke);
            if (!(aVar instanceof com.skydoves.sandwich.a.c)) {
                m.d(aVar, "null cannot be cast to non-null type com.skydoves.sandwich.ApiResponse<V of com.skydoves.sandwich.ResponseTransformer__ResponseTransformerKt.suspendMapSuccess>");
                return aVar;
            }
            Object objA = ((com.skydoves.sandwich.a.c) aVar).a();
            aVar2.label = 1;
            objInvoke = pVar.invoke(objA, aVar2);
            if (objInvoke == objC) {
                return objC;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            r.b(objInvoke);
        }
        com.skydoves.sandwich.a.Companion c0149a = com.skydoves.sandwich.a.INSTANCE;
        h9.e eVarC = d.c();
        try {
            f0 f0VarI = f0.i(objInvoke);
            m.e(f0VarI, "success(invoke)");
            int first = eVarC.getFirst();
            int last = eVarC.getLast();
            int code = f0VarI.h().getCode();
            c0152b = (first > code || code > last) ? new com.skydoves.sandwich.a.b.C0151a(f0VarI) : new com.skydoves.sandwich.a.c(f0VarI);
        } catch (Exception e10) {
            c0152b = new com.skydoves.sandwich.a.b.C0152b(e10);
        }
        return c0149a.c(c0152b);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final /* synthetic */ Object h(com.skydoves.sandwich.a aVar, m6.b bVar, v8.f fVar) {
        b bVar2;
        if (fVar instanceof b) {
            bVar2 = (b) fVar;
            int i10 = bVar2.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                bVar2.label = i10 - Integer.MIN_VALUE;
            } else {
                bVar2 = new b(fVar);
            }
        } else {
            bVar2 = new b(fVar);
        }
        Object obj = bVar2.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = bVar2.label;
        if (i11 != 0) {
            if (i11 != 1 && i11 != 2 && i11 != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            com.skydoves.sandwich.a aVar2 = (com.skydoves.sandwich.a) bVar2.L$0;
            r.b(obj);
            return aVar2;
        }
        r.b(obj);
        if (aVar instanceof com.skydoves.sandwich.a.c) {
            bVar2.L$0 = aVar;
            bVar2.label = 1;
            if (bVar.c((com.skydoves.sandwich.a.c) aVar, bVar2) != objC) {
                return aVar;
            }
        } else {
            if (!(aVar instanceof com.skydoves.sandwich.a.b.C0151a)) {
                if (aVar instanceof com.skydoves.sandwich.a.b.C0152b) {
                    bVar2.L$0 = aVar;
                    bVar2.label = 3;
                    if (bVar.b((com.skydoves.sandwich.a.b.C0152b) aVar, bVar2) == objC) {
                    }
                }
                return aVar;
            }
            bVar2.L$0 = aVar;
            bVar2.label = 2;
            if (bVar.a((com.skydoves.sandwich.a.b.C0151a) aVar, bVar2) != objC) {
                return aVar;
            }
        }
        return objC;
    }
}
