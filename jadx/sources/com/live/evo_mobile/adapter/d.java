package com.live.evo_mobile.adapter;

import android.view.View;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import kotlin.Metadata;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.g2;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import r8.r;
import r8.z;
import t.v.c.widget.MyRelativelayout;
import t.v.c.widget.TextView;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import u7.EpgData;
import x1.f1.lb.util.d1;
import z1.b1.lb.m.meta.ChannelStreamResponse;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0017\u0010\u0016R$\u0010\u001d\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u0014R\u0016\u0010 \u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006$"}, d2 = {"Lcom/live/evo_mobile/adapter/d;", "Lr7/e;", "Lu7/c;", "<init>", "()V", "Lj0/b;", "holder", "", "position", "item", "Lr8/z;", "X", "(Lj0/b;ILu7/c;)V", "Lz1/b1/lb/m/meta/ChannelStreamResponse;", "response", "a0", "(Lz1/b1/lb/m/meta/ChannelStreamResponse;)V", "Lcom/live/evo_mobile/adapter/d$a;", "listener", "b0", "(Lcom/live/evo_mobile/adapter/d$a;)V", "Z", "()I", "G", "r", "Lcom/live/evo_mobile/adapter/d$a;", "getPlaybackClickListener", "()Lcom/live/evo_mobile/adapter/d$a;", "setPlaybackClickListener", "playbackClickListener", "s", "I", "playingPos", "t", "Lz1/b1/lb/m/meta/ChannelStreamResponse;", "a", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class d extends r7.e<EpgData> {

    /* JADX INFO: renamed from: r, reason: collision with root package name and from kotlin metadata */
    private a playbackClickListener;

    /* JADX INFO: renamed from: s, reason: collision with root package name and from kotlin metadata */
    private int playingPos = -1;

    /* JADX INFO: renamed from: t, reason: collision with root package name and from kotlin metadata */
    private ChannelStreamResponse response;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/live/evo_mobile/adapter/d$a;", "", "Lu7/c;", "item", "", IjkMediaMeta.IJKM_KEY_TYPE, "position", "Lr8/z;", "a", "(Lu7/c;II)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface a {
        void a(EpgData item, int type, int position);
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.adapter.EpgListAdapter$bindViewHolder$1$1$1", f = "EpgListAdapter.kt", l = {75, 85}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class b extends kotlin.coroutines.jvm.internal.l implements c9.p<l0, v8.f<? super z>, Object> {
        final /* synthetic */ EpgData $item;
        final /* synthetic */ TextView $playbackText;
        int label;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.adapter.EpgListAdapter$bindViewHolder$1$1$1$1", f = "EpgListAdapter.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends kotlin.coroutines.jvm.internal.l implements c9.p<l0, v8.f<? super z>, Object> {
            final /* synthetic */ boolean $isRetSub;
            final /* synthetic */ TextView $playbackText;
            int label;
            final /* synthetic */ d this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(boolean z10, TextView textView, d dVar, v8.f<? super a> fVar) {
                super(2, fVar);
                this.$isRetSub = z10;
                this.$playbackText = textView;
                this.this$0 = dVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final v8.f<z> create(Object obj, v8.f<?> fVar) {
                return new a(this.$isRetSub, this.$playbackText, this.this$0, fVar);
            }

            @Override // c9.p
            public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
                return ((a) create(l0Var, fVar)).invokeSuspend(z.f17874a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.b.c();
                if (this.label == 0) {
                    r.b(obj);
                    if (this.$isRetSub) {
                        this.$playbackText.setText(this.this$0.j().getString(2131953077));
                    } else {
                        this.$playbackText.setText(this.this$0.j().getString(2131953074));
                    }
                    return z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(EpgData epgData, TextView textView, v8.f<? super b> fVar) {
            super(2, fVar);
            this.$item = epgData;
            this.$playbackText = textView;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            return d.this.new b(this.$item, this.$playbackText, fVar);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
            return ((b) create(l0Var, fVar)).invokeSuspend(z.f17874a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0097, code lost:
        
            if (kotlinx.coroutines.h.g(r1, r2, r13) == r0) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            b bVar;
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 == 2) {
                        r.b(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    r.b(obj);
                    bVar = this;
                }
                return z.f17874a;
            }
            r.b(obj);
            t.v.c.i.a aVar = t.v.c.i.a.f18646a;
            ChannelStreamResponse channelStreamResponse = d.this.response;
            kotlin.jvm.internal.m.c(channelStreamResponse);
            int key = channelStreamResponse.getKey();
            long start = this.$item.getStart();
            ChannelStreamResponse channelStreamResponse2 = d.this.response;
            kotlin.jvm.internal.m.c(channelStreamResponse2);
            String epgId = channelStreamResponse2.getEpgId();
            kotlin.jvm.internal.m.e(epgId, "getEpgId(...)");
            this.label = 1;
            bVar = this;
            if (t.v.c.i.a.K0(aVar, key, start, epgId, null, bVar, 8, null) != objC) {
            }
            return objC;
            t.v.c.i.a aVar2 = t.v.c.i.a.f18646a;
            ChannelStreamResponse channelStreamResponse3 = d.this.response;
            kotlin.jvm.internal.m.c(channelStreamResponse3);
            int key2 = channelStreamResponse3.getKey();
            long start2 = bVar.$item.getStart();
            ChannelStreamResponse channelStreamResponse4 = d.this.response;
            kotlin.jvm.internal.m.c(channelStreamResponse4);
            String epgId2 = channelStreamResponse4.getEpgId();
            kotlin.jvm.internal.m.e(epgId2, "getEpgId(...)");
            boolean zH0 = aVar2.h0(key2, start2, epgId2);
            g2 g2VarC = a1.c();
            a aVar3 = new a(zH0, bVar.$playbackText, d.this, null);
            bVar.label = 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(d dVar, kotlin.jvm.internal.z zVar, String str, EpgData epgData, int i10, TextView textView, View view) {
        a aVar = dVar.playbackClickListener;
        if (aVar != null) {
            if (zVar.element == 3 && dVar.response != null && str != null) {
                kotlinx.coroutines.j.d(m0.a(a1.b()), null, null, dVar.new b(epgData, textView, null), 3, null);
            } else {
                kotlin.jvm.internal.m.c(aVar);
                aVar.a(epgData, zVar.element, i10);
            }
        }
    }

    @Override // r7.a
    /* JADX INFO: renamed from: X, reason: merged with bridge method [inline-methods] */
    public void E(j0.b holder, final int position, final EpgData item) {
        kotlin.jvm.internal.m.f(holder, "holder");
        kotlin.jvm.internal.m.f(item, "item");
        final String strH = x1.f1.lb.util.n.n().h(1, item.getStart());
        String strH2 = x1.f1.lb.util.n.n().h(1, item.getStop());
        long jD = d1.d();
        holder.e(R$id.tv_epg_title, strH + "-" + strH2).d(R$id.cl_epg_root, item.getSelected()).e(R$id.tv_epg_content, item.getTitle());
        final TextView textView = (TextView) holder.a(R$id.tv_playback);
        final kotlin.jvm.internal.z zVar = new kotlin.jvm.internal.z();
        int i10 = 0;
        if (item.getStart() > jD) {
            ChannelStreamResponse channelStreamResponse = this.response;
            if (channelStreamResponse != null) {
                t.v.c.i.a aVar = t.v.c.i.a.f18646a;
                kotlin.jvm.internal.m.c(channelStreamResponse);
                int key = channelStreamResponse.getKey();
                long start = item.getStart();
                String channel = item.getChannel();
                kotlin.jvm.internal.m.e(channel, "getChannel(...)");
                if (aVar.h0(key, start, channel)) {
                    textView.setText(j().getString(2131953077));
                } else {
                    textView.setText(j().getString(2131953074));
                }
            } else {
                textView.setText(j().getString(2131953074));
            }
            zVar.element = 3;
        } else if (item.getStart() > jD || item.getStop() < jD) {
            textView.setText(j().getString(2131953069));
            zVar.element = 1;
            if (!item.getHasCatchup()) {
                i10 = 8;
            }
        } else {
            textView.setText(j().getString(2131953072));
            zVar.element = 2;
            this.playingPos = position;
        }
        MyRelativelayout myRelativelayout = (MyRelativelayout) holder.a(R$id.rl_playback_btn);
        myRelativelayout.setVisibility(i10);
        if (i10 != 0) {
            return;
        }
        myRelativelayout.setOnClickListener(new View.OnClickListener() { // from class: com.live.evo_mobile.adapter.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.Y(this.f7752a, zVar, strH, item, position, textView, view);
            }
        });
    }

    /* JADX INFO: renamed from: Z, reason: from getter */
    public final int getPlayingPos() {
        return this.playingPos;
    }

    public final void a0(ChannelStreamResponse response) {
        kotlin.jvm.internal.m.f(response, "response");
        this.response = response;
    }

    public final void b0(a listener) {
        kotlin.jvm.internal.m.f(listener, "listener");
        this.playbackClickListener = listener;
    }

    @Override // r7.a
    public int G() {
        return R$layout.item_epg_list;
    }
}
