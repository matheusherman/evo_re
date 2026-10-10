package com.tvc.lib.mobile.ui.base;

import android.content.Context;
import androidx.databinding.ViewDataBinding;
import c9.p;
import com.tvc.lib.R$string;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import r8.r;
import r8.z;
import u7.StoryListData;
import z1.b1.lb.m.meta.ChannelStreamResponse;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 \u0015*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\u0016B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJE\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b2 \u0010\u0012\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\u00110\r¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/tvc/lib/mobile/ui/base/a;", "Landroidx/databinding/ViewDataBinding;", "DB", "Lcom/tvc/lib/mobile/ui/base/d;", "<init>", "()V", "", "column", "", "Lz1/b1/lb/m/meta/ChannelStreamResponse;", "d0", "(Ljava/lang/String;)Ljava/util/List;", "channelList", "Lkotlin/Function2;", "", "Lu7/i;", "", "Lr8/z;", "result", "c0", "(Ljava/lang/String;Ljava/util/List;Lc9/p;)V", "e", "a", "tvclib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class a<DB extends ViewDataBinding> extends d<DB> {

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String f9215f = "";

    /* JADX INFO: renamed from: com.tvc.lib.mobile.ui.base.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/tvc/lib/mobile/ui/base/a$a;", "", "<init>", "()V", "", "currentStreamId", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "b", "(Ljava/lang/String;)V", "tvclib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        private Companion() {
        }

        public final void b(String str) {
            m.f(str, "<set-?>");
            a.f9215f = str;
        }

        public final String a() {
            return a.f9215f;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "com.tvc.lib.mobile.ui.base.BaseChannelListFragment$coverStoryList$1", f = "BaseChannelListFragment.kt", l = {33, 34, 47, 60, 97}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class b extends l implements p<l0, v8.f<? super z>, Object> {
        final /* synthetic */ List<ChannelStreamResponse> $channelList;
        final /* synthetic */ String $column;
        final /* synthetic */ p<List<StoryListData>, Integer, z> $result;
        int I$0;
        int I$1;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        final /* synthetic */ a<DB> this$0;

        /* JADX INFO: renamed from: com.tvc.lib.mobile.ui.base.a$b$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "com.tvc.lib.mobile.ui.base.BaseChannelListFragment$coverStoryList$1$1", f = "BaseChannelListFragment.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
        static final class C0164a extends l implements p<l0, v8.f<? super z>, Object> {
            final /* synthetic */ List<StoryListData> $mStoryList;
            final /* synthetic */ b0<Integer> $playingPosition;
            final /* synthetic */ p<List<StoryListData>, Integer, z> $result;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C0164a(p<? super List<StoryListData>, ? super Integer, z> pVar, List<StoryListData> list, b0<Integer> b0Var, v8.f<? super C0164a> fVar) {
                super(2, fVar);
                this.$result = pVar;
                this.$mStoryList = list;
                this.$playingPosition = b0Var;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final v8.f<z> create(Object obj, v8.f<?> fVar) {
                return new C0164a(this.$result, this.$mStoryList, this.$playingPosition, fVar);
            }

            @Override // c9.p
            public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
                return ((C0164a) create(l0Var, fVar)).invokeSuspend(z.f17874a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.b.c();
                if (this.label == 0) {
                    r.b(obj);
                    this.$result.invoke(this.$mStoryList, this.$playingPosition.element);
                    return z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.tvc.lib.mobile.ui.base.a$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "com.tvc.lib.mobile.ui.base.BaseChannelListFragment$coverStoryList$1$noEPG$1", f = "BaseChannelListFragment.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "", "<anonymous>", "(Lkotlinx/coroutines/l0;)Ljava/lang/String;"}, k = 3, mv = {2, 1, 0})
        static final class C0165b extends l implements p<l0, v8.f<? super String>, Object> {
            int label;
            final /* synthetic */ a<DB> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0165b(a<DB> aVar, v8.f<? super C0165b> fVar) {
                super(2, fVar);
                this.this$0 = aVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final v8.f<z> create(Object obj, v8.f<?> fVar) {
                return new C0165b(this.this$0, fVar);
            }

            @Override // c9.p
            public final Object invoke(l0 l0Var, v8.f<? super String> fVar) {
                return ((C0165b) create(l0Var, fVar)).invokeSuspend(z.f17874a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                String string;
                kotlin.coroutines.intrinsics.b.c();
                if (this.label == 0) {
                    r.b(obj);
                    Context context = this.this$0.getContext();
                    if (context != null && (string = context.getString(R$string.no_epg)) != null) {
                        return string;
                    }
                    return "";
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "com.tvc.lib.mobile.ui.base.BaseChannelListFragment$coverStoryList$1$noProgramme$1", f = "BaseChannelListFragment.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "", "<anonymous>", "(Lkotlinx/coroutines/l0;)Ljava/lang/String;"}, k = 3, mv = {2, 1, 0})
        static final class c extends l implements p<l0, v8.f<? super String>, Object> {
            int label;
            final /* synthetic */ a<DB> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(a<DB> aVar, v8.f<? super c> fVar) {
                super(2, fVar);
                this.this$0 = aVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final v8.f<z> create(Object obj, v8.f<?> fVar) {
                return new c(this.this$0, fVar);
            }

            @Override // c9.p
            public final Object invoke(l0 l0Var, v8.f<? super String> fVar) {
                return ((c) create(l0Var, fVar)).invokeSuspend(z.f17874a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                String string;
                kotlin.coroutines.intrinsics.b.c();
                if (this.label == 0) {
                    r.b(obj);
                    Context context = this.this$0.getContext();
                    if (context != null && (string = context.getString(R$string.no_epg_program)) != null) {
                        return string;
                    }
                    return "";
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b(List<? extends ChannelStreamResponse> list, String str, a<DB> aVar, p<? super List<StoryListData>, ? super Integer, z> pVar, v8.f<? super b> fVar) {
            super(2, fVar);
            this.$channelList = list;
            this.$column = str;
            this.this$0 = aVar;
            this.$result = pVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            return new b(this.$channelList, this.$column, this.this$0, this.$result, fVar);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
            return ((b) create(l0Var, fVar)).invokeSuspend(z.f17874a);
        }

        /* JADX WARN: Code duplicated, block: B:24:0x00db  */
        /* JADX WARN: Code duplicated, block: B:26:0x00f3  */
        /* JADX WARN: Code duplicated, block: B:30:0x013b  */
        /* JADX WARN: Code duplicated, block: B:33:0x0153  */
        /* JADX WARN: Code duplicated, block: B:54:0x01c0 A[ADDED_TO_REGION, REMOVE] */
        /* JADX WARN: Code duplicated, block: B:57:0x01d4  */
        /* JADX WARN: Code duplicated, block: B:58:0x01d6  */
        /* JADX WARN: Type inference failed for: r14v6, types: [T, java.lang.Integer] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x0182 -> B:40:0x0186). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.a
        public final java.lang.Object invokeSuspend(java.lang.Object r26) {
            /*
                Method dump skipped, instruction units count: 531
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tvc.lib.mobile.ui.base.a.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final void c0(String column, List<? extends ChannelStreamResponse> channelList, p<? super List<StoryListData>, ? super Integer, z> result) {
        m.f(column, "column");
        m.f(channelList, "channelList");
        m.f(result, "result");
        j.d(m0.a(a1.b()), null, null, new b(channelList, column, this, result, null), 3, null);
    }

    public final List<ChannelStreamResponse> d0(String column) {
        m.f(column, "column");
        t.v.c.i.a aVar = t.v.c.i.a.f18646a;
        return aVar.n(column, Boolean.valueOf(aVar.d0(column)));
    }
}
