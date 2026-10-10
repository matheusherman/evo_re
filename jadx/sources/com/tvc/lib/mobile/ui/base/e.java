package com.tvc.lib.mobile.ui.base;

import androidx.databinding.ViewDataBinding;
import c9.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.g2;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import r8.r;
import r8.z;
import u7.EpgData;
import x1.f1.lb.util.n;
import z1.b1.lb.m.meta.ChannelStreamResponse;
import z1.b1.lb.m.meta.EPGProgramme;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005JG\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0018\u0010\u0011\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0004\u0012\u00020\u00100\r¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/tvc/lib/mobile/ui/base/e;", "Landroidx/databinding/ViewDataBinding;", "DB", "Lcom/tvc/lib/mobile/ui/base/d;", "<init>", "()V", "", "yyyyMMdd", "Lz1/b1/lb/m/meta/ChannelStreamResponse;", "response", "", "Lz1/b1/lb/m/meta/EPGProgramme;", "epgList", "Lkotlin/Function1;", "", "Lu7/c;", "Lr8/z;", "result", "a0", "(Ljava/lang/String;Lz1/b1/lb/m/meta/ChannelStreamResponse;Ljava/util/List;Lc9/l;)V", "tvclib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class e<DB extends ViewDataBinding> extends d<DB> {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "com.tvc.lib.mobile.ui.base.BaseEpgListFragment$coverEpgList$1", f = "BaseEpgListFragment.kt", l = {73}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class a extends l implements p<l0, v8.f<? super z>, Object> {
        final /* synthetic */ List<EPGProgramme> $epgList;
        final /* synthetic */ ChannelStreamResponse $response;
        final /* synthetic */ c9.l<List<EpgData>, z> $result;
        final /* synthetic */ String $yyyyMMdd;
        int label;

        /* JADX INFO: renamed from: com.tvc.lib.mobile.ui.base.e$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "com.tvc.lib.mobile.ui.base.BaseEpgListFragment$coverEpgList$1$1", f = "BaseEpgListFragment.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
        static final class C0166a extends l implements p<l0, v8.f<? super z>, Object> {
            final /* synthetic */ List<EpgData> $mEpgDataList;
            final /* synthetic */ c9.l<List<EpgData>, z> $result;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C0166a(c9.l<? super List<EpgData>, z> lVar, List<EpgData> list, v8.f<? super C0166a> fVar) {
                super(2, fVar);
                this.$result = lVar;
                this.$mEpgDataList = list;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final v8.f<z> create(Object obj, v8.f<?> fVar) {
                return new C0166a(this.$result, this.$mEpgDataList, fVar);
            }

            @Override // c9.p
            public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
                return ((C0166a) create(l0Var, fVar)).invokeSuspend(z.f17874a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.b.c();
                if (this.label == 0) {
                    r.b(obj);
                    this.$result.invoke(this.$mEpgDataList);
                    return z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(List<? extends EPGProgramme> list, ChannelStreamResponse channelStreamResponse, String str, c9.l<? super List<EpgData>, z> lVar, v8.f<? super a> fVar) {
            super(2, fVar);
            this.$epgList = list;
            this.$response = channelStreamResponse;
            this.$yyyyMMdd = str;
            this.$result = lVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            return new a(this.$epgList, this.$response, this.$yyyyMMdd, this.$result, fVar);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
            return ((a) create(l0Var, fVar)).invokeSuspend(z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            boolean zIsCatchup;
            String epgId;
            boolean zIsCatchup2;
            String epgId2;
            boolean zIsCatchup3;
            String epgId3;
            ChannelStreamResponse channelStreamResponse;
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 == 1) {
                    r.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                r.b(obj);
                ArrayList arrayList = new ArrayList();
                Iterator<EPGProgramme> it = this.$epgList.iterator();
                while (true) {
                    zIsCatchup = false;
                    if (!it.hasNext()) {
                        break;
                    }
                    EPGProgramme next = it.next();
                    EpgData epgData = new EpgData(false, false, 3, null);
                    epgData.setTitle(next.getTitle());
                    epgData.setStop(next.getStop());
                    epgData.setCategory(next.getCategory());
                    epgData.setChannel(next.getChannel());
                    epgData.setDesc(next.getDesc());
                    epgData.setStart(next.getStart());
                    epgData.setIconSrc(next.getIconSrc());
                    if (x1.f1.lb.config.b.f20643a.h() && (channelStreamResponse = this.$response) != null) {
                        zIsCatchup = channelStreamResponse.isCatchup();
                    }
                    epgData.d(zIsCatchup);
                    arrayList.add(epgData);
                }
                if (x1.f1.lb.config.b.f20643a.u() && arrayList.isEmpty()) {
                    long jD = n.n().d(this.$yyyyMMdd, "yyyyMMdd");
                    EpgData epgData2 = new EpgData(false, false, 3, null);
                    epgData2.setTitle("test programme1");
                    epgData2.setStop(25200000 + jD);
                    epgData2.setCategory("");
                    ChannelStreamResponse channelStreamResponse2 = this.$response;
                    if (channelStreamResponse2 == null || (epgId = channelStreamResponse2.getEpgId()) == null) {
                        epgId = "";
                    }
                    epgData2.setChannel(epgId);
                    epgData2.setDesc("auto generated test programme");
                    epgData2.setStart(21600000 + jD);
                    epgData2.setIconSrc("");
                    ChannelStreamResponse channelStreamResponse3 = this.$response;
                    if (channelStreamResponse3 != null) {
                        zIsCatchup2 = channelStreamResponse3.isCatchup();
                    } else {
                        zIsCatchup2 = false;
                    }
                    epgData2.d(zIsCatchup2);
                    arrayList.add(epgData2);
                    EpgData epgData3 = new EpgData(false, false, 3, null);
                    epgData3.setTitle("test programme2");
                    epgData3.setStop(46800000 + jD);
                    epgData3.setCategory("");
                    ChannelStreamResponse channelStreamResponse4 = this.$response;
                    if (channelStreamResponse4 == null || (epgId2 = channelStreamResponse4.getEpgId()) == null) {
                        epgId2 = "";
                    }
                    epgData3.setChannel(epgId2);
                    epgData3.setDesc("auto generated test programme");
                    epgData3.setStart(39600000 + jD);
                    epgData3.setIconSrc("");
                    ChannelStreamResponse channelStreamResponse5 = this.$response;
                    if (channelStreamResponse5 != null) {
                        zIsCatchup3 = channelStreamResponse5.isCatchup();
                    } else {
                        zIsCatchup3 = false;
                    }
                    epgData3.d(zIsCatchup3);
                    arrayList.add(epgData3);
                    EpgData epgData4 = new EpgData(false, false, 3, null);
                    epgData4.setTitle("test programme3");
                    epgData4.setStop(64800000 + jD);
                    epgData4.setCategory("");
                    ChannelStreamResponse channelStreamResponse6 = this.$response;
                    if (channelStreamResponse6 == null || (epgId3 = channelStreamResponse6.getEpgId()) == null) {
                        epgId3 = "";
                    }
                    epgData4.setChannel(epgId3);
                    epgData4.setDesc("auto generated test programme");
                    epgData4.setStart(jD + 61200000);
                    epgData4.setIconSrc("");
                    ChannelStreamResponse channelStreamResponse7 = this.$response;
                    if (channelStreamResponse7 != null) {
                        zIsCatchup = channelStreamResponse7.isCatchup();
                    }
                    epgData4.d(zIsCatchup);
                    arrayList.add(epgData4);
                }
                g2 g2VarC = a1.c();
                C0166a c0166a = new C0166a(this.$result, arrayList, null);
                this.label = 1;
                if (kotlinx.coroutines.h.g(g2VarC, c0166a, this) == objC) {
                    return objC;
                }
            }
            return z.f17874a;
        }
    }

    public final void a0(String yyyyMMdd, ChannelStreamResponse response, List<? extends EPGProgramme> epgList, c9.l<? super List<EpgData>, z> result) {
        m.f(yyyyMMdd, "yyyyMMdd");
        m.f(epgList, "epgList");
        m.f(result, "result");
        j.d(m0.a(a1.b()), null, null, new a(epgList, response, yyyyMMdd, result, null), 3, null);
    }
}
