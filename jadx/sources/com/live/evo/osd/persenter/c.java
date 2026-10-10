package com.live.evo.osd.persenter;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentManager;
import c9.q;
import com.live.evo.util.j1;
import com.live.evo.util.s0;
import i5.h;
import i5.p;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.flow.g;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import r8.r;
import r8.z;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001)B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\nJ+\u0010\u0012\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0016\u0010\nJ1\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\bH\u0016¢\u0006\u0004\b \u0010\nJ-\u0010%\u001a\u00020\b2\b\u0010!\u001a\u0004\u0018\u00010\r2\b\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010$\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b%\u0010&J\u001f\u0010)\u001a\u00020\b2\u0006\u0010'\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u000fH\u0016¢\u0006\u0004\b)\u0010*J!\u0010,\u001a\u00020\b2\b\u0010+\u001a\u0004\u0018\u00010\r2\u0006\u0010(\u001a\u00020\u000fH\u0016¢\u0006\u0004\b,\u0010-J#\u00100\u001a\u00020\b2\b\u0010+\u001a\u0004\u0018\u00010\r2\b\u0010/\u001a\u0004\u0018\u00010.H\u0016¢\u0006\u0004\b0\u00101J\u0019\u00102\u001a\u00020\b2\b\u0010+\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020\bH\u0016¢\u0006\u0004\b4\u0010\nJ\u000f\u00105\u001a\u00020\bH\u0016¢\u0006\u0004\b5\u0010\nJ\u0011\u00107\u001a\u0004\u0018\u000106H\u0016¢\u0006\u0004\b7\u00108J#\u0010<\u001a\u00020\b2\b\u0010:\u001a\u0004\u0018\u0001092\b\u0010;\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b<\u0010=J\u000f\u0010>\u001a\u00020\bH\u0016¢\u0006\u0004\b>\u0010\nJ\u000f\u0010?\u001a\u00020\u000fH\u0016¢\u0006\u0004\b?\u0010\u0015J\u0017\u0010A\u001a\u00020\b2\u0006\u0010@\u001a\u00020\u000fH\u0016¢\u0006\u0004\bA\u0010\u001fJ\u0017\u0010B\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u000fH\u0016¢\u0006\u0004\bB\u0010\u001fJ\u0017\u0010D\u001a\u00020\b2\u0006\u0010C\u001a\u00020\u000fH\u0016¢\u0006\u0004\bD\u0010\u001fJ\u000f\u0010E\u001a\u00020\bH\u0016¢\u0006\u0004\bE\u0010\nJ\u000f\u0010F\u001a\u00020\bH\u0016¢\u0006\u0004\bF\u0010\nJ\u000f\u0010G\u001a\u00020\bH\u0016¢\u0006\u0004\bG\u0010\nJ\u000f\u0010I\u001a\u00020HH\u0016¢\u0006\u0004\bI\u0010JJ\u0019\u0010L\u001a\u00020\b2\b\u0010K\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\bL\u00103R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b%\u0010R\u001a\u0004\bS\u0010TR\u0014\u0010W\u001a\u00020U8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010VR\u0016\u0010X\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u0010AR\u0016\u0010Y\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u0010AR\u0016\u0010Z\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u0010AR\u0018\u0010]\u001a\u0004\u0018\u00010[8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\\R\u0018\u0010^\u001a\u0004\u0018\u00010[8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010\\R\u0016\u0010_\u001a\u0004\u0018\u00010[8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u0010\\¨\u0006`"}, d2 = {"Lcom/live/evo/osd/persenter/c;", "Lcom/live/evo/osd/persenter/a;", "Lcom/live/evo/osd/persenter/b;", "mView", "Lcom/live/evo/osd/persenter/c$a;", "mCallback", "<init>", "(Lcom/live/evo/osd/persenter/b;Lcom/live/evo/osd/persenter/c$a;)V", "Lr8/z;", "u", "()V", "G", "v", "", "epgId", "", "pastDays", "currentChannelId", "q", "(Ljava/lang/String;ILjava/lang/String;)V", "g", "()I", "m", "categorySelect", "programSelect", "inAllProgramPos", "playType", "o", "(IIILjava/lang/String;)V", "selectedItemPosition", "k", "(I)V", "w", "catchupType", "Li5/p;", "bean", "channelId", "b", "(Ljava/lang/String;Li5/p;Ljava/lang/String;)V", IjkMediaMeta.IJKM_KEY_TYPE, "index", "a", "(II)V", "tag", "c", "(Ljava/lang/String;I)V", "Landroid/view/View;", "container", "h", "(Ljava/lang/String;Landroid/view/View;)V", "e", "(Ljava/lang/String;)V", "d", "f", "Li5/h;", "i", "()Li5/h;", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "menuTag", "M", "(Landroidx/fragment/app/FragmentManager;Ljava/lang/String;)V", "hide", "C", "position", "I", "L", "inListSelectPos", "J", "F", "H", ExifInterface.LONGITUDE_EAST, "", "D", "()Z", IjkMediaMeta.IJKM_KEY_TRACK_ID, "K", "Lcom/live/evo/osd/persenter/b;", "B", "()Lcom/live/evo/osd/persenter/b;", "setMView", "(Lcom/live/evo/osd/persenter/b;)V", "Lcom/live/evo/osd/persenter/c$a;", "getMCallback", "()Lcom/live/evo/osd/persenter/c$a;", "Lq6/b;", "Lq6/b;", "logger", "playCategory", "playChannel", "playAllPos", "Lh8/c;", "Lh8/c;", "mEpgAllSubscription", "mSaveHistorySubscription", "getEpgSubscribe", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class c implements com.live.evo.osd.persenter.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private com.live.evo.osd.persenter.b mView;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final a mCallback;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final q6.b logger;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int playCategory;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int playChannel;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int playAllPos;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private h8.c mEpgAllSubscription;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private h8.c mSaveHistorySubscription;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final h8.c getEpgSubscribe;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J1\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0005H&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0002H&¢\u0006\u0004\b\u0010\u0010\u0004J-\u0010\u0015\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0005H&¢\u0006\u0004\b\u0019\u0010\u001aJ!\u0010\u001c\u001a\u00020\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0018\u001a\u00020\u0005H&¢\u0006\u0004\b\u001c\u0010\u001dJ#\u0010 \u001a\u00020\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\t2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH&¢\u0006\u0004\b \u0010!J\u0019\u0010\"\u001a\u00020\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0002H&¢\u0006\u0004\b$\u0010\u0004J\u000f\u0010%\u001a\u00020\u0002H&¢\u0006\u0004\b%\u0010\u0004R\u0014\u0010(\u001a\u00020\u00058&X¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0016\u0010,\u001a\u0004\u0018\u00010)8&X¦\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+¨\u0006-"}, d2 = {"Lcom/live/evo/osd/persenter/c$a;", "", "Lr8/z;", "l", "()V", "", "categorySelect", "programSelect", "inAllProgramPos", "", "playType", "j", "(IIILjava/lang/String;)V", "selectedItemPosition", "m", "(I)V", "k", "catchupType", "Li5/p;", "bean", "channelId", "b", "(Ljava/lang/String;Li5/p;Ljava/lang/String;)V", IjkMediaMeta.IJKM_KEY_TYPE, "index", "a", "(II)V", "tag", "c", "(Ljava/lang/String;I)V", "Landroid/view/View;", "container", "h", "(Ljava/lang/String;Landroid/view/View;)V", "e", "(Ljava/lang/String;)V", "d", "f", "g", "()I", "programId", "Li5/h;", "i", "()Li5/h;", "currentPlayProgram", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface a {
        void a(int type, int index);

        void b(String catchupType, p bean, String channelId);

        void c(String tag, int index);

        void d();

        void e(String tag);

        void f();

        int g();

        void h(String tag, View container);

        h i();

        void j(int categorySelect, int programSelect, int inAllProgramPos, String playType);

        void k();

        void l();

        void m(int selectedItemPosition);
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @f(c = "com.live.evo.osd.persenter.OSDListProgramPresenter$getEpgList$1", f = "OSDListProgramPresenter.kt", l = {78}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class b extends l implements c9.p<l0, v8.f<? super z>, Object> {
        final /* synthetic */ String $currentChannelId;
        final /* synthetic */ String $epgId;
        int label;
        final /* synthetic */ c this$0;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @f(c = "com.live.evo.osd.persenter.OSDListProgramPresenter$getEpgList$1$1", f = "OSDListProgramPresenter.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u0005*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lkotlinx/coroutines/flow/g;", "", "Li5/p;", "", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends l implements q<g<? super List<? extends p>>, Throwable, v8.f<? super z>, Object> {
            final /* synthetic */ String $currentChannelId;
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ c this$0;

            /* JADX INFO: renamed from: com.live.evo.osd.persenter.c$b$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @f(c = "com.live.evo.osd.persenter.OSDListProgramPresenter$getEpgList$1$1$1", f = "OSDListProgramPresenter.kt", l = {}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
            static final class C0108a extends l implements c9.p<l0, v8.f<? super z>, Object> {
                final /* synthetic */ String $currentChannelId;
                final /* synthetic */ Throwable $it;
                int label;
                final /* synthetic */ c this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0108a(c cVar, Throwable th, String str, v8.f<? super C0108a> fVar) {
                    super(2, fVar);
                    this.this$0 = cVar;
                    this.$it = th;
                    this.$currentChannelId = str;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final v8.f<z> create(Object obj, v8.f<?> fVar) {
                    return new C0108a(this.this$0, this.$it, this.$currentChannelId, fVar);
                }

                @Override // c9.p
                public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
                    return ((C0108a) create(l0Var, fVar)).invokeSuspend(z.f17874a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    com.live.evo.osd.persenter.b mView;
                    kotlin.coroutines.intrinsics.b.c();
                    if (this.label == 0) {
                        r.b(obj);
                        if (this.this$0.getMView() != null && (mView = this.this$0.getMView()) != null) {
                            mView.q(this.$it, this.$currentChannelId);
                        }
                        return z.f17874a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(c cVar, String str, v8.f<? super a> fVar) {
                super(3, fVar);
                this.this$0 = cVar;
                this.$currentChannelId = str;
            }

            @Override // c9.q
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object invoke(g<? super List<? extends p>> gVar, Throwable th, v8.f<? super z> fVar) {
                a aVar = new a(this.this$0, this.$currentChannelId, fVar);
                aVar.L$0 = th;
                return aVar.invokeSuspend(z.f17874a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.b.c();
                if (this.label == 0) {
                    r.b(obj);
                    j.d(m0.b(), null, null, new C0108a(this.this$0, (Throwable) this.L$0, this.$currentChannelId, null), 3, null);
                    return z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.live.evo.osd.persenter.c$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class C0109b<T> implements g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ c f7142a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f7143b;

            /* JADX INFO: renamed from: com.live.evo.osd.persenter.c$b$b$a */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @f(c = "com.live.evo.osd.persenter.OSDListProgramPresenter$getEpgList$1$2$1", f = "OSDListProgramPresenter.kt", l = {}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
            static final class a extends l implements c9.p<l0, v8.f<? super z>, Object> {
                final /* synthetic */ String $currentChannelId;
                final /* synthetic */ List<p> $it;
                int label;
                final /* synthetic */ c this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                a(c cVar, List<? extends p> list, String str, v8.f<? super a> fVar) {
                    super(2, fVar);
                    this.this$0 = cVar;
                    this.$it = list;
                    this.$currentChannelId = str;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final v8.f<z> create(Object obj, v8.f<?> fVar) {
                    return new a(this.this$0, this.$it, this.$currentChannelId, fVar);
                }

                @Override // c9.p
                public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
                    return ((a) create(l0Var, fVar)).invokeSuspend(z.f17874a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    com.live.evo.osd.persenter.b mView;
                    kotlin.coroutines.intrinsics.b.c();
                    if (this.label == 0) {
                        r.b(obj);
                        if (this.this$0.getMView() != null && (mView = this.this$0.getMView()) != null) {
                            mView.L(this.$it, this.$currentChannelId);
                        }
                        return z.f17874a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            C0109b(c cVar, String str) {
                this.f7142a = cVar;
                this.f7143b = str;
            }

            @Override // kotlinx.coroutines.flow.g
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(List<? extends p> list, v8.f<? super z> fVar) {
                j.d(m0.b(), null, null, new a(this.f7142a, list, this.f7143b, null), 3, null);
                return z.f17874a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, String str2, c cVar, v8.f<? super b> fVar) {
            super(2, fVar);
            this.$currentChannelId = str;
            this.$epgId = str2;
            this.this$0 = cVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            return new b(this.$currentChannelId, this.$epgId, this.this$0, fVar);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
            return ((b) create(l0Var, fVar)).invokeSuspend(z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
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
                kotlinx.coroutines.flow.f fVarF = kotlinx.coroutines.flow.h.f(s0.f7342a.A(this.$currentChannelId, this.$epgId), new a(this.this$0, this.$currentChannelId, null));
                C0109b c0109b = new C0109b(this.this$0, this.$currentChannelId);
                this.label = 1;
                if (fVarF.collect(c0109b, this) == objC) {
                    return objC;
                }
            }
            return z.f17874a;
        }
    }

    /* JADX INFO: renamed from: com.live.evo.osd.persenter.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class C0110c<T> implements j8.c {
        C0110c() {
        }

        @Override // j8.c
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void accept(b5.h savePlayHistoryEvent) {
            com.live.evo.osd.persenter.b mView;
            m.f(savePlayHistoryEvent, "savePlayHistoryEvent");
            c.this.playCategory = savePlayHistoryEvent.f912a;
            c.this.playChannel = savePlayHistoryEvent.f913b;
            c.this.playAllPos = savePlayHistoryEvent.f914c;
            if (c.this.getMView() == null || (mView = c.this.getMView()) == null) {
                return;
            }
            mView.F(savePlayHistoryEvent);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class d<T> implements j8.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d<T> f7145a = new d<>();

        d() {
        }

        @Override // j8.c
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void accept(Throwable th) {
        }
    }

    /* JADX INFO: renamed from: B, reason: from getter */
    public final com.live.evo.osd.persenter.b getMView() {
        return this.mView;
    }

    public int C() {
        com.live.evo.osd.persenter.b bVar = this.mView;
        if (bVar != null) {
            return bVar.getMProgramSelect();
        }
        return 0;
    }

    public boolean D() {
        com.live.evo.osd.persenter.b bVar = this.mView;
        if (bVar != null) {
            return bVar.getIsShow();
        }
        return false;
    }

    public void E() {
        com.live.evo.osd.persenter.b bVar = this.mView;
        if (bVar != null) {
            bVar.s();
        }
    }

    public void F() {
        com.live.evo.osd.persenter.b bVar = this.mView;
        if (bVar != null) {
            bVar.m();
        }
    }

    public void H() {
        com.live.evo.osd.persenter.b bVar = this.mView;
        if (bVar != null) {
            bVar.t();
        }
    }

    public void I(int position) {
        com.live.evo.osd.persenter.b bVar = this.mView;
        if (bVar != null) {
            bVar.u(position);
        }
    }

    public void J(int inListSelectPos) {
        com.live.evo.osd.persenter.b bVar = this.mView;
        if (bVar != null) {
            bVar.r(inListSelectPos);
        }
    }

    public void K(String id2) {
        com.live.evo.osd.persenter.b bVar = this.mView;
        if (bVar != null) {
            bVar.M(id2);
        }
    }

    public void L(int inAllProgramPos) {
        com.live.evo.osd.persenter.b bVar = this.mView;
        if (bVar != null) {
            bVar.p(inAllProgramPos);
        }
    }

    @Override // com.live.evo.osd.persenter.a
    public void a(int type, int index) {
        a aVar = this.mCallback;
        if (aVar != null) {
            aVar.a(type, index);
        }
    }

    @Override // com.live.evo.osd.persenter.a
    public void b(String catchupType, p bean, String channelId) {
        a aVar = this.mCallback;
        if (aVar != null) {
            aVar.b(catchupType, bean, channelId);
        }
    }

    @Override // com.live.evo.osd.persenter.a
    public void c(String tag, int index) {
        a aVar = this.mCallback;
        if (aVar != null) {
            aVar.c(tag, index);
        }
    }

    @Override // com.live.evo.osd.persenter.a
    public void d() {
        a aVar = this.mCallback;
        if (aVar != null) {
            aVar.d();
        }
    }

    @Override // com.live.evo.osd.persenter.a
    public void e(String tag) {
        a aVar = this.mCallback;
        if (aVar != null) {
            aVar.e(tag);
        }
    }

    @Override // com.live.evo.osd.persenter.a
    public void f() {
        a aVar = this.mCallback;
        if (aVar != null) {
            aVar.f();
        }
    }

    @Override // com.live.evo.osd.persenter.a
    public int g() {
        a aVar = this.mCallback;
        if (aVar != null) {
            return aVar.g();
        }
        return 0;
    }

    @Override // com.live.evo.osd.persenter.a
    public void h(String tag, View container) {
        a aVar = this.mCallback;
        if (aVar != null) {
            aVar.h(tag, container);
        }
    }

    @Override // com.live.evo.osd.persenter.a
    public void hide() {
        com.live.evo.osd.persenter.b bVar = this.mView;
        if (bVar != null) {
            bVar.I();
        }
    }

    @Override // com.live.evo.osd.persenter.a
    public h i() {
        a aVar = this.mCallback;
        if (aVar != null) {
            return aVar.i();
        }
        return null;
    }

    @Override // com.live.evo.osd.persenter.a
    public void k(int selectedItemPosition) {
        a aVar = this.mCallback;
        if (aVar != null) {
            aVar.m(selectedItemPosition);
        }
    }

    @Override // com.live.evo.osd.persenter.a
    public void m() {
        a aVar = this.mCallback;
        if (aVar != null) {
            aVar.l();
        }
    }

    @Override // com.live.evo.osd.persenter.a
    public void o(int categorySelect, int programSelect, int inAllProgramPos, String playType) {
        a aVar = this.mCallback;
        if (aVar != null) {
            aVar.j(categorySelect, programSelect, inAllProgramPos, playType);
        }
    }

    @Override // k5.a
    public void u() {
        h8.c cVar;
        h8.c cVar2;
        h8.c cVar3;
        com.live.evo.osd.persenter.b bVar = this.mView;
        if (bVar != null) {
            bVar.E();
        }
        this.mView = null;
        h8.c cVar4 = this.mSaveHistorySubscription;
        if (cVar4 != null && !cVar4.f() && (cVar3 = this.mSaveHistorySubscription) != null) {
            cVar3.dispose();
        }
        h8.c cVar5 = this.mEpgAllSubscription;
        if (cVar5 != null && !cVar5.f() && (cVar2 = this.mEpgAllSubscription) != null) {
            cVar2.dispose();
        }
        h8.c cVar6 = this.getEpgSubscribe;
        if (cVar6 == null || cVar6.f() || (cVar = this.getEpgSubscribe) == null) {
            return;
        }
        cVar.dispose();
    }

    @Override // com.live.evo.osd.persenter.a
    public void w() {
        a aVar = this.mCallback;
        if (aVar != null) {
            aVar.k();
        }
    }

    public c(com.live.evo.osd.persenter.b bVar, a aVar) {
        this.mView = bVar;
        this.mCallback = aVar;
        q6.b bVarD = q6.c.d(c.class);
        m.e(bVarD, "getLogger(...)");
        this.logger = bVarD;
        com.live.evo.osd.persenter.b bVar2 = this.mView;
        if (bVar2 != null) {
            bVar2.K(this);
        }
        G();
    }

    public void M(FragmentManager fragmentManager, String menuTag) {
        com.live.evo.osd.persenter.b bVar;
        if (!D() && (bVar = this.mView) != null) {
            bVar.N(fragmentManager, menuTag);
        }
    }

    @Override // com.live.evo.osd.persenter.a
    public void q(String epgId, int pastDays, String currentChannelId) {
        j.d(m0.a(a1.b()), null, null, new b(currentChannelId, epgId, this, null), 3, null);
    }

    @Override // com.live.evo.osd.persenter.a
    public void v() {
        this.mSaveHistorySubscription = j1.a().c(b5.h.class).s(new C0110c(), d.f7145a);
    }

    public void G() {
    }
}
