package x1.f1.lb.api;

import c9.q;
import kotlin.Metadata;
import r8.r;
import r8.z;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import z1.b1.lb.m.meta.CatchupPlayRequest;
import z1.b1.lb.m.meta.CatchupPlayResponse;
import z1.b1.lb.m.meta.ChannelListResponse;
import z1.b1.lb.m.meta.MetaDetailResponse;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jd\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0087@¢\u0006\u0004\b\u0013\u0010\u0014Jt\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u00102\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\u0017\u0010\u0018J|\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u00110\u00102\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0086@¢\u0006\u0004\b\u001c\u0010\u001dJt\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u00110\u00102\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b \u0010\u0018R\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020&0%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010'R\u0014\u0010+\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010*¨\u0006,"}, d2 = {"Lx1/f1/lb/api/b;", "", "<init>", "()V", "", "did", "uid", "appId", "", "appVer", "requestTime", "token", "checksum", "", "pageId", "pageSize", "Lcom/skydoves/sandwich/a;", "Ln6/b;", "Lz1/b1/lb/m/meta/ChannelListResponse;", "d", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;IILv8/f;)Ljava/lang/Object;", "tenantId", IjkMediaMeta.IJKM_KEY_LANGUAGE, "c", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;IIJLjava/lang/String;Ljava/lang/String;Lv8/f;)Ljava/lang/Object;", "Lz1/b1/lb/m/meta/CatchupPlayRequest;", "request", "Lz1/b1/lb/m/meta/CatchupPlayResponse;", "e", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;IIJLjava/lang/String;Ljava/lang/String;Lz1/b1/lb/m/meta/CatchupPlayRequest;Lv8/f;)Ljava/lang/Object;", "metaId", "Lz1/b1/lb/m/meta/MetaDetailResponse;", "f", "Lq6/b;", "b", "Lq6/b;", "logger", "Lx1/f1/lb/host/a;", "Lx1/f1/lb/api/l;", "Lx1/f1/lb/host/a;", "streamMetaApiServerProvider", "Lcom/skydoves/sandwich/retry/b;", "Lcom/skydoves/sandwich/retry/b;", "retryPolicy", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f20552a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static q6.b logger;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final x1.f1.lb.host.a<l> streamMetaApiServerProvider;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final com.skydoves.sandwich.retry.b retryPolicy;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J!\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"x1/f1/lb/api/b$a", "Lcom/skydoves/sandwich/retry/b;", "", "attempt", "", "message", "b", "(ILjava/lang/String;)I", "", "a", "(ILjava/lang/String;)Z", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a implements com.skydoves.sandwich.retry.b {
        @Override // com.skydoves.sandwich.retry.b
        public boolean a(int attempt, String message) {
            return attempt <= 3;
        }

        @Override // com.skydoves.sandwich.retry.b
        public int b(int attempt, String message) {
            return 3000;
        }

        a() {
        }
    }

    /* JADX INFO: renamed from: x1.f1.lb.api.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.api.ApiStreamMetaClient$getChannelList$2", f = "ApiStreamMetaClient.kt", l = {47}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "attempt", "", "reason", "Lcom/skydoves/sandwich/a;", "Ln6/b;", "Lz1/b1/lb/m/meta/ChannelListResponse;", "<anonymous>", "(ILjava/lang/String;)Lcom/skydoves/sandwich/a;"}, k = 3, mv = {2, 1, 0})
    static final class C0403b extends kotlin.coroutines.jvm.internal.l implements q<Integer, String, v8.f<? super com.skydoves.sandwich.a<? extends n6.b<ChannelListResponse>>>, Object> {
        final /* synthetic */ String $appId;
        final /* synthetic */ long $appVer;
        final /* synthetic */ String $checksum;
        final /* synthetic */ String $did;
        final /* synthetic */ int $pageId;
        final /* synthetic */ int $pageSize;
        final /* synthetic */ long $requestTime;
        final /* synthetic */ String $token;
        final /* synthetic */ String $uid;
        /* synthetic */ int I$0;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0403b(String str, String str2, String str3, long j10, long j11, String str4, int i10, int i11, String str5, v8.f<? super C0403b> fVar) {
            super(3, fVar);
            this.$did = str;
            this.$uid = str2;
            this.$appId = str3;
            this.$appVer = j10;
            this.$requestTime = j11;
            this.$token = str4;
            this.$pageId = i10;
            this.$pageSize = i11;
            this.$checksum = str5;
        }

        public final Object b(int i10, String str, v8.f<? super com.skydoves.sandwich.a<? extends n6.b<ChannelListResponse>>> fVar) {
            C0403b c0403b = new C0403b(this.$did, this.$uid, this.$appId, this.$appVer, this.$requestTime, this.$token, this.$pageId, this.$pageSize, this.$checksum, fVar);
            c0403b.I$0 = i10;
            c0403b.L$0 = str;
            return c0403b.invokeSuspend(z.f17874a);
        }

        @Override // c9.q
        public /* bridge */ /* synthetic */ Object invoke(Integer num, String str, v8.f<? super com.skydoves.sandwich.a<? extends n6.b<ChannelListResponse>>> fVar) {
            return b(num.intValue(), str, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            Object objA;
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 == 1) {
                    r.b(obj);
                    objA = obj;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                r.b(obj);
                int i11 = this.I$0;
                String str = (String) this.L$0;
                if (x1.f1.lb.config.b.f20643a.t()) {
                    b.logger.debug("get channel list request[{},{}]", kotlin.coroutines.jvm.internal.b.b(i11), str);
                }
                l lVar = (l) b.streamMetaApiServerProvider.a(i11);
                if (lVar != null) {
                    String str2 = this.$did;
                    String str3 = this.$uid;
                    String str4 = this.$appId;
                    long j10 = this.$appVer;
                    long j11 = this.$requestTime;
                    String str5 = this.$token;
                    int i12 = this.$pageId;
                    int i13 = this.$pageSize;
                    String str6 = this.$checksum;
                    this.label = 1;
                    objA = lVar.a(str2, str3, str4, j10, j11, str5, i12, i13, str6, this);
                    if (objA == objC) {
                        return objC;
                    }
                }
                throw new NullPointerException("channel api service is null");
            }
            com.skydoves.sandwich.a aVar = (com.skydoves.sandwich.a) objA;
            if (aVar != null) {
                return aVar;
            }
            throw new NullPointerException("channel api service is null");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.api.ApiStreamMetaClient$getChannelList$4", f = "ApiStreamMetaClient.kt", l = {76}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "attempt", "", "reason", "Lcom/skydoves/sandwich/a;", "Ln6/b;", "Lz1/b1/lb/m/meta/ChannelListResponse;", "<anonymous>", "(ILjava/lang/String;)Lcom/skydoves/sandwich/a;"}, k = 3, mv = {2, 1, 0})
    static final class c extends kotlin.coroutines.jvm.internal.l implements q<Integer, String, v8.f<? super com.skydoves.sandwich.a<? extends n6.b<ChannelListResponse>>>, Object> {
        final /* synthetic */ String $appId;
        final /* synthetic */ long $appVer;
        final /* synthetic */ String $checksum;
        final /* synthetic */ String $did;
        final /* synthetic */ String $language;
        final /* synthetic */ int $pageId;
        final /* synthetic */ int $pageSize;
        final /* synthetic */ long $requestTime;
        final /* synthetic */ String $tenantId;
        final /* synthetic */ String $token;
        final /* synthetic */ String $uid;
        /* synthetic */ int I$0;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str, String str2, long j10, String str3, String str4, String str5, int i10, int i11, long j11, String str6, String str7, v8.f<? super c> fVar) {
            super(3, fVar);
            this.$tenantId = str;
            this.$appId = str2;
            this.$appVer = j10;
            this.$checksum = str3;
            this.$did = str4;
            this.$language = str5;
            this.$pageId = i10;
            this.$pageSize = i11;
            this.$requestTime = j11;
            this.$token = str6;
            this.$uid = str7;
        }

        public final Object b(int i10, String str, v8.f<? super com.skydoves.sandwich.a<? extends n6.b<ChannelListResponse>>> fVar) {
            c cVar = new c(this.$tenantId, this.$appId, this.$appVer, this.$checksum, this.$did, this.$language, this.$pageId, this.$pageSize, this.$requestTime, this.$token, this.$uid, fVar);
            cVar.I$0 = i10;
            cVar.L$0 = str;
            return cVar.invokeSuspend(z.f17874a);
        }

        @Override // c9.q
        public /* bridge */ /* synthetic */ Object invoke(Integer num, String str, v8.f<? super com.skydoves.sandwich.a<? extends n6.b<ChannelListResponse>>> fVar) {
            return b(num.intValue(), str, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            Object objC;
            Object objC2 = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            if (i10 == 0) {
                r.b(obj);
                int i11 = this.I$0;
                String str = (String) this.L$0;
                if (x1.f1.lb.config.b.f20643a.t()) {
                    b.logger.debug("get channel list request[{},{}]", kotlin.coroutines.jvm.internal.b.b(i11), str);
                }
                l lVar = (l) b.streamMetaApiServerProvider.a(i11);
                if (lVar != null) {
                    String str2 = this.$tenantId;
                    String str3 = this.$appId;
                    long j10 = this.$appVer;
                    String str4 = this.$checksum;
                    String str5 = this.$did;
                    String str6 = this.$language;
                    int i12 = this.$pageId;
                    int i13 = this.$pageSize;
                    long j11 = this.$requestTime;
                    String str7 = this.$token;
                    String str8 = this.$uid;
                    this.label = 1;
                    objC = lVar.c(str2, str3, j10, str4, str5, str6, i12, i13, j11, str7, str8, this);
                    if (objC == objC2) {
                        return objC2;
                    }
                }
                throw new NullPointerException("channel api service is null");
            }
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            r.b(obj);
            objC = obj;
            com.skydoves.sandwich.a aVar = (com.skydoves.sandwich.a) objC;
            if (aVar != null) {
                return aVar;
            }
            throw new NullPointerException("channel api service is null");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.api.ApiStreamMetaClient$getPlayUrl$2", f = "ApiStreamMetaClient.kt", l = {108}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "attempt", "", "reason", "Lcom/skydoves/sandwich/a;", "Ln6/b;", "Lz1/b1/lb/m/meta/CatchupPlayResponse;", "<anonymous>", "(ILjava/lang/String;)Lcom/skydoves/sandwich/a;"}, k = 3, mv = {2, 1, 0})
    static final class d extends kotlin.coroutines.jvm.internal.l implements q<Integer, String, v8.f<? super com.skydoves.sandwich.a<? extends n6.b<CatchupPlayResponse>>>, Object> {
        final /* synthetic */ String $appId;
        final /* synthetic */ long $appVer;
        final /* synthetic */ String $checksum;
        final /* synthetic */ String $did;
        final /* synthetic */ String $language;
        final /* synthetic */ int $pageId;
        final /* synthetic */ int $pageSize;
        final /* synthetic */ CatchupPlayRequest $request;
        final /* synthetic */ long $requestTime;
        final /* synthetic */ String $tenantId;
        final /* synthetic */ String $token;
        final /* synthetic */ String $uid;
        /* synthetic */ int I$0;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(String str, String str2, long j10, String str3, String str4, String str5, int i10, int i11, long j11, String str6, String str7, CatchupPlayRequest catchupPlayRequest, v8.f<? super d> fVar) {
            super(3, fVar);
            this.$tenantId = str;
            this.$appId = str2;
            this.$appVer = j10;
            this.$checksum = str3;
            this.$did = str4;
            this.$language = str5;
            this.$pageId = i10;
            this.$pageSize = i11;
            this.$requestTime = j11;
            this.$token = str6;
            this.$uid = str7;
            this.$request = catchupPlayRequest;
        }

        public final Object b(int i10, String str, v8.f<? super com.skydoves.sandwich.a<? extends n6.b<CatchupPlayResponse>>> fVar) {
            d dVar = new d(this.$tenantId, this.$appId, this.$appVer, this.$checksum, this.$did, this.$language, this.$pageId, this.$pageSize, this.$requestTime, this.$token, this.$uid, this.$request, fVar);
            dVar.I$0 = i10;
            dVar.L$0 = str;
            return dVar.invokeSuspend(z.f17874a);
        }

        @Override // c9.q
        public /* bridge */ /* synthetic */ Object invoke(Integer num, String str, v8.f<? super com.skydoves.sandwich.a<? extends n6.b<CatchupPlayResponse>>> fVar) {
            return b(num.intValue(), str, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            Object objD;
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            if (i10 == 0) {
                r.b(obj);
                int i11 = this.I$0;
                String str = (String) this.L$0;
                if (x1.f1.lb.config.b.f20643a.t()) {
                    b.logger.debug("get play url request[{},{}]", kotlin.coroutines.jvm.internal.b.b(i11), str);
                }
                l lVar = (l) b.streamMetaApiServerProvider.a(i11);
                if (lVar != null) {
                    String str2 = this.$tenantId;
                    String str3 = this.$appId;
                    long j10 = this.$appVer;
                    String str4 = this.$checksum;
                    String str5 = this.$did;
                    String str6 = this.$language;
                    int i12 = this.$pageId;
                    int i13 = this.$pageSize;
                    long j11 = this.$requestTime;
                    String str7 = this.$token;
                    String str8 = this.$uid;
                    String streamId = this.$request.getStreamId();
                    kotlin.jvm.internal.m.e(streamId, "getStreamId(...)");
                    String catchupRoute = this.$request.getCatchupRoute();
                    kotlin.jvm.internal.m.e(catchupRoute, "getCatchupRoute(...)");
                    String catchupStreamId = this.$request.getCatchupStreamId();
                    kotlin.jvm.internal.m.e(catchupStreamId, "getCatchupStreamId(...)");
                    long startTimestamp = this.$request.getStartTimestamp();
                    long endTimestamp = this.$request.getEndTimestamp();
                    this.label = 1;
                    objD = lVar.d(str2, str3, j10, str4, str5, str6, i12, i13, j11, str7, str8, streamId, catchupRoute, catchupStreamId, startTimestamp, endTimestamp, this);
                    if (objD == objC) {
                        return objC;
                    }
                }
                throw new NullPointerException("channel api service is null");
            }
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            r.b(obj);
            objD = obj;
            com.skydoves.sandwich.a aVar = (com.skydoves.sandwich.a) objD;
            if (aVar != null) {
                return aVar;
            }
            throw new NullPointerException("channel api service is null");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.api.ApiStreamMetaClient$getVideoDetail$2", f = "ApiStreamMetaClient.kt", l = {207}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "attempt", "", "reason", "Lcom/skydoves/sandwich/a;", "Ln6/b;", "Lz1/b1/lb/m/meta/MetaDetailResponse;", "<anonymous>", "(ILjava/lang/String;)Lcom/skydoves/sandwich/a;"}, k = 3, mv = {2, 1, 0})
    static final class e extends kotlin.coroutines.jvm.internal.l implements q<Integer, String, v8.f<? super com.skydoves.sandwich.a<? extends n6.b<MetaDetailResponse>>>, Object> {
        final /* synthetic */ String $appId;
        final /* synthetic */ long $appVer;
        final /* synthetic */ String $did;
        final /* synthetic */ String $language;
        final /* synthetic */ String $metaId;
        final /* synthetic */ int $pageId;
        final /* synthetic */ int $pageSize;
        final /* synthetic */ long $requestTime;
        final /* synthetic */ String $tenantId;
        final /* synthetic */ String $token;
        final /* synthetic */ String $uid;
        /* synthetic */ int I$0;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(String str, String str2, long j10, String str3, String str4, String str5, int i10, int i11, long j11, String str6, String str7, v8.f<? super e> fVar) {
            super(3, fVar);
            this.$tenantId = str;
            this.$appId = str2;
            this.$appVer = j10;
            this.$did = str3;
            this.$language = str4;
            this.$metaId = str5;
            this.$pageId = i10;
            this.$pageSize = i11;
            this.$requestTime = j11;
            this.$token = str6;
            this.$uid = str7;
        }

        public final Object b(int i10, String str, v8.f<? super com.skydoves.sandwich.a<? extends n6.b<MetaDetailResponse>>> fVar) {
            e eVar = new e(this.$tenantId, this.$appId, this.$appVer, this.$did, this.$language, this.$metaId, this.$pageId, this.$pageSize, this.$requestTime, this.$token, this.$uid, fVar);
            eVar.I$0 = i10;
            eVar.L$0 = str;
            return eVar.invokeSuspend(z.f17874a);
        }

        @Override // c9.q
        public /* bridge */ /* synthetic */ Object invoke(Integer num, String str, v8.f<? super com.skydoves.sandwich.a<? extends n6.b<MetaDetailResponse>>> fVar) {
            return b(num.intValue(), str, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            Object objB;
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            if (i10 == 0) {
                r.b(obj);
                int i11 = this.I$0;
                String str = (String) this.L$0;
                if (x1.f1.lb.config.b.f20643a.t()) {
                    b.logger.debug("vod_api get vod detail request[" + i11 + "," + str + "]", new Object[0]);
                }
                l lVar = (l) b.streamMetaApiServerProvider.a(i11);
                if (lVar != null) {
                    String str2 = this.$tenantId;
                    String str3 = this.$appId;
                    long j10 = this.$appVer;
                    String str4 = this.$did;
                    String str5 = this.$language;
                    String str6 = this.$metaId;
                    int i12 = this.$pageId;
                    int i13 = this.$pageSize;
                    long j11 = this.$requestTime;
                    String str7 = this.$token;
                    String str8 = this.$uid;
                    this.label = 1;
                    objB = lVar.b(str2, str3, j10, str4, str5, str6, i12, i13, j11, str7, str8, this);
                    if (objB == objC) {
                        return objC;
                    }
                }
                throw new NullPointerException("vod detail api service is null");
            }
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            r.b(obj);
            objB = obj;
            com.skydoves.sandwich.a aVar = (com.skydoves.sandwich.a) objB;
            if (aVar != null) {
                return aVar;
            }
            throw new NullPointerException("vod detail api service is null");
        }
    }

    static {
        q6.b bVarD = q6.c.d(b.class);
        kotlin.jvm.internal.m.e(bVarD, "getLogger(...)");
        logger = bVarD;
        streamMetaApiServerProvider = x1.f1.lb.host.b.f20720a.m();
        retryPolicy = new a();
    }

    public final Object c(String str, String str2, long j10, String str3, String str4, String str5, int i10, int i11, long j11, String str6, String str7, v8.f<? super com.skydoves.sandwich.a<? extends n6.b<ChannelListResponse>>> fVar) {
        return com.skydoves.sandwich.retry.a.a(retryPolicy, new c(str, str2, j10, str3, str4, str5, i10, i11, j11, str6, str7, null), fVar);
    }

    public final Object d(String str, String str2, String str3, long j10, long j11, String str4, String str5, int i10, int i11, v8.f<? super com.skydoves.sandwich.a<? extends n6.b<ChannelListResponse>>> fVar) {
        return com.skydoves.sandwich.retry.a.a(retryPolicy, new C0403b(str, str2, str3, j10, j11, str4, i10, i11, str5, null), fVar);
    }

    public final Object e(String str, String str2, long j10, String str3, String str4, String str5, int i10, int i11, long j11, String str6, String str7, CatchupPlayRequest catchupPlayRequest, v8.f<? super com.skydoves.sandwich.a<? extends n6.b<CatchupPlayResponse>>> fVar) {
        return com.skydoves.sandwich.retry.a.a(retryPolicy, new d(str, str2, j10, str3, str4, str5, i10, i11, j11, str6, str7, catchupPlayRequest, null), fVar);
    }

    public final Object f(String str, String str2, long j10, String str3, String str4, String str5, int i10, int i11, long j11, String str6, String str7, v8.f<? super com.skydoves.sandwich.a<? extends n6.b<MetaDetailResponse>>> fVar) {
        return com.skydoves.sandwich.retry.a.a(retryPolicy, new e(str, str2, j10, str3, str4, str5, i10, i11, j11, str6, str7, null), fVar);
    }

    private b() {
    }
}
