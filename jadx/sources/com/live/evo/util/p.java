package com.live.evo.util;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import z1.b1.lb.m.meta.EPGProgramme;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/live/evo/util/p;", "", "<init>", "()V", "", "epgId", "Lkotlinx/coroutines/flow/f;", "", "Li5/p;", "a", "(Ljava/lang/String;)Lkotlinx/coroutines/flow/f;", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f7317a = new p();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.util.EpgBeanDaoUtils$getTwoEpg$1", f = "EpgBeanDaoUtils.kt", l = {358, 370}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/flow/g;", "", "Li5/p;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;)V"}, k = 3, mv = {2, 1, 0})
    static final class a extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.flow.g<? super List<? extends i5.p>>, v8.f<? super r8.z>, Object> {
        final /* synthetic */ String $epgId;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, v8.f<? super a> fVar) {
            super(2, fVar);
            this.$epgId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            a aVar = new a(this.$epgId, fVar);
            aVar.L$0 = obj;
            return aVar;
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.flow.g<? super List<? extends i5.p>> gVar, v8.f<? super r8.z> fVar) {
            return ((a) create(gVar, fVar)).invokeSuspend(r8.z.f17874a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x007d, code lost:
        
            if (r3.emit(r1, r9) == r0) goto L22;
         */
        @Override // kotlin.coroutines.jvm.internal.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            ArrayList arrayList;
            kotlinx.coroutines.flow.g gVar;
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 == 2) {
                        r8.r.b(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    arrayList = (ArrayList) this.L$1;
                    gVar = (kotlinx.coroutines.flow.g) this.L$0;
                    r8.r.b(obj);
                }
                return r8.z.f17874a;
            }
            r8.r.b(obj);
            kotlinx.coroutines.flow.g gVar2 = (kotlinx.coroutines.flow.g) this.L$0;
            arrayList = new ArrayList();
            long jA = u1.b().a();
            t.v.c.i.a aVar = t.v.c.i.a.f18646a;
            String str = this.$epgId;
            this.L$0 = gVar2;
            this.L$1 = arrayList;
            this.label = 1;
            Object objX = aVar.X(str, jA, this);
            if (objX != objC) {
                gVar = gVar2;
                obj = objX;
            }
            return objC;
            r8.p pVar = (r8.p) obj;
            EPGProgramme ePGProgramme = (EPGProgramme) pVar.c();
            if (ePGProgramme != null) {
                arrayList.add(s0.f7342a.l(ePGProgramme));
            }
            EPGProgramme ePGProgramme2 = (EPGProgramme) pVar.d();
            if (ePGProgramme2 != null) {
                arrayList.add(s0.f7342a.l(ePGProgramme2));
            }
            this.L$0 = null;
            this.L$1 = null;
            this.label = 2;
        }
    }

    public final kotlinx.coroutines.flow.f<List<i5.p>> a(String epgId) {
        kotlin.jvm.internal.m.f(epgId, "epgId");
        return kotlinx.coroutines.flow.h.v(new a(epgId, null));
    }

    private p() {
    }
}
