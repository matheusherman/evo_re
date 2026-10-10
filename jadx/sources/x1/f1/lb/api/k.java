package x1.f1.lb.api;

import c9.q;
import kotlin.Metadata;
import r8.r;
import r8.z;
import x1.f1.lb.util.d1;
import z1.b1.lb.m.sports.DataVersion;
import z1.b1.lb.m.sports.Matches;
import z1.b1.lb.m.sports.Sports;
import z1.b1.lb.m.sports.Tournaments;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000Q\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004*\u0001\u001d\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0006H\u0086@¢\u0006\u0004\b\u000b\u0010\fJ\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00062\u0006\u0010\r\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\u000f\u0010\tJ&\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00062\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u001e¨\u0006 "}, d2 = {"Lx1/f1/lb/api/k;", "", "<init>", "()V", "", "lastVersion", "Lcom/skydoves/sandwich/a;", "Lz1/b1/lb/m/sports/DataVersion;", "c", "(Ljava/lang/String;Lv8/f;)Ljava/lang/Object;", "Lz1/b1/lb/m/sports/Sports;", "e", "(Lv8/f;)Ljava/lang/Object;", "sportId", "Lz1/b1/lb/m/sports/Tournaments;", "f", "tournamentId", "date", "Lz1/b1/lb/m/sports/Matches;", "d", "(Ljava/lang/String;Ljava/lang/String;Lv8/f;)Ljava/lang/Object;", "Lq6/b;", "b", "Lq6/b;", "logger", "Lx1/f1/lb/host/a;", "Lx1/f1/lb/api/j;", "Lx1/f1/lb/host/a;", "sportsServerProvider", "x1/f1/lb/api/k$i", "Lx1/f1/lb/api/k$i;", "retryPolicy", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f20579a = new k();

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static q6.b logger;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final x1.f1.lb.host.a<j> sportsServerProvider;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final i retryPolicy;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.api.SportsApiClient", f = "SportsApiClient.kt", l = {33}, m = "queryDataVersion")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class a extends kotlin.coroutines.jvm.internal.d {
        long J$0;
        int label;
        /* synthetic */ Object result;

        a(v8.f<? super a> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return k.this.c(null, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.api.SportsApiClient$queryDataVersion$response$1", f = "SportsApiClient.kt", l = {35}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "attempt", "", "reason", "Lcom/skydoves/sandwich/a;", "Lz1/b1/lb/m/sports/DataVersion;", "<anonymous>", "(ILjava/lang/String;)Lcom/skydoves/sandwich/a;"}, k = 3, mv = {2, 1, 0})
    static final class b extends kotlin.coroutines.jvm.internal.l implements q<Integer, String, v8.f<? super com.skydoves.sandwich.a<? extends DataVersion>>, Object> {
        final /* synthetic */ String $lastVersion;
        /* synthetic */ int I$0;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, v8.f<? super b> fVar) {
            super(3, fVar);
            this.$lastVersion = str;
        }

        public final Object b(int i10, String str, v8.f<? super com.skydoves.sandwich.a<DataVersion>> fVar) {
            b bVar = new b(this.$lastVersion, fVar);
            bVar.I$0 = i10;
            bVar.L$0 = str;
            return bVar.invokeSuspend(z.f17874a);
        }

        @Override // c9.q
        public /* bridge */ /* synthetic */ Object invoke(Integer num, String str, v8.f<? super com.skydoves.sandwich.a<? extends DataVersion>> fVar) {
            return b(num.intValue(), str, fVar);
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
                int i11 = this.I$0;
                String str = (String) this.L$0;
                if (x1.f1.lb.config.b.f20643a.t()) {
                    k.logger.debug("query data version, request[ {}, {} ]", kotlin.coroutines.jvm.internal.b.b(i11), str);
                }
                j jVar = (j) k.sportsServerProvider.a(i11);
                if (jVar != null) {
                    String str2 = this.$lastVersion;
                    this.label = 1;
                    obj = jVar.c(str2, this);
                    if (obj == objC) {
                        return objC;
                    }
                }
                throw new NullPointerException("sports api service is null");
            }
            com.skydoves.sandwich.a aVar = (com.skydoves.sandwich.a) obj;
            if (aVar != null) {
                return aVar;
            }
            throw new NullPointerException("sports api service is null");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.api.SportsApiClient", f = "SportsApiClient.kt", l = {106}, m = "queryMatches")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class c extends kotlin.coroutines.jvm.internal.d {
        long J$0;
        int label;
        /* synthetic */ Object result;

        c(v8.f<? super c> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return k.this.d(null, null, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.api.SportsApiClient$queryMatches$response$1", f = "SportsApiClient.kt", l = {108}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "attempt", "", "reason", "Lcom/skydoves/sandwich/a;", "Lz1/b1/lb/m/sports/Matches;", "<anonymous>", "(ILjava/lang/String;)Lcom/skydoves/sandwich/a;"}, k = 3, mv = {2, 1, 0})
    static final class d extends kotlin.coroutines.jvm.internal.l implements q<Integer, String, v8.f<? super com.skydoves.sandwich.a<? extends Matches>>, Object> {
        final /* synthetic */ String $date;
        final /* synthetic */ String $tournamentId;
        /* synthetic */ int I$0;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(String str, String str2, v8.f<? super d> fVar) {
            super(3, fVar);
            this.$tournamentId = str;
            this.$date = str2;
        }

        public final Object b(int i10, String str, v8.f<? super com.skydoves.sandwich.a<Matches>> fVar) {
            d dVar = new d(this.$tournamentId, this.$date, fVar);
            dVar.I$0 = i10;
            dVar.L$0 = str;
            return dVar.invokeSuspend(z.f17874a);
        }

        @Override // c9.q
        public /* bridge */ /* synthetic */ Object invoke(Integer num, String str, v8.f<? super com.skydoves.sandwich.a<? extends Matches>> fVar) {
            return b(num.intValue(), str, fVar);
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
                int i11 = this.I$0;
                String str = (String) this.L$0;
                if (x1.f1.lb.config.b.f20643a.t()) {
                    k.logger.debug("query matches, request[ {}, {} ]", kotlin.coroutines.jvm.internal.b.b(i11), str);
                }
                j jVar = (j) k.sportsServerProvider.a(i11);
                if (jVar != null) {
                    String str2 = this.$tournamentId;
                    String str3 = this.$date;
                    this.label = 1;
                    obj = jVar.b(str2, str3, this);
                    if (obj == objC) {
                        return objC;
                    }
                }
                throw new NullPointerException("sports api service is null");
            }
            com.skydoves.sandwich.a aVar = (com.skydoves.sandwich.a) obj;
            if (aVar != null) {
                return aVar;
            }
            throw new NullPointerException("sports api service is null");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.api.SportsApiClient", f = "SportsApiClient.kt", l = {58}, m = "querySports")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class e extends kotlin.coroutines.jvm.internal.d {
        long J$0;
        int label;
        /* synthetic */ Object result;

        e(v8.f<? super e> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return k.this.e(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.api.SportsApiClient$querySports$response$1", f = "SportsApiClient.kt", l = {60}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "attempt", "", "reason", "Lcom/skydoves/sandwich/a;", "Lz1/b1/lb/m/sports/Sports;", "<anonymous>", "(ILjava/lang/String;)Lcom/skydoves/sandwich/a;"}, k = 3, mv = {2, 1, 0})
    static final class f extends kotlin.coroutines.jvm.internal.l implements q<Integer, String, v8.f<? super com.skydoves.sandwich.a<? extends Sports>>, Object> {
        /* synthetic */ int I$0;
        /* synthetic */ Object L$0;
        int label;

        f(v8.f<? super f> fVar) {
            super(3, fVar);
        }

        public final Object b(int i10, String str, v8.f<? super com.skydoves.sandwich.a<Sports>> fVar) {
            f fVar2 = new f(fVar);
            fVar2.I$0 = i10;
            fVar2.L$0 = str;
            return fVar2.invokeSuspend(z.f17874a);
        }

        @Override // c9.q
        public /* bridge */ /* synthetic */ Object invoke(Integer num, String str, v8.f<? super com.skydoves.sandwich.a<? extends Sports>> fVar) {
            return b(num.intValue(), str, fVar);
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
                int i11 = this.I$0;
                String str = (String) this.L$0;
                if (x1.f1.lb.config.b.f20643a.t()) {
                    k.logger.debug("query sports, request[ {}, {} ]", kotlin.coroutines.jvm.internal.b.b(i11), str);
                }
                j jVar = (j) k.sportsServerProvider.a(i11);
                if (jVar != null) {
                    this.label = 1;
                    obj = jVar.a(this);
                    if (obj == objC) {
                        return objC;
                    }
                }
                throw new NullPointerException("sports api service is null");
            }
            com.skydoves.sandwich.a aVar = (com.skydoves.sandwich.a) obj;
            if (aVar != null) {
                return aVar;
            }
            throw new NullPointerException("sports api service is null");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.api.SportsApiClient", f = "SportsApiClient.kt", l = {82}, m = "queryTournaments")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class g extends kotlin.coroutines.jvm.internal.d {
        long J$0;
        int label;
        /* synthetic */ Object result;

        g(v8.f<? super g> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return k.this.f(null, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.api.SportsApiClient$queryTournaments$response$1", f = "SportsApiClient.kt", l = {84}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "attempt", "", "reason", "Lcom/skydoves/sandwich/a;", "Lz1/b1/lb/m/sports/Tournaments;", "<anonymous>", "(ILjava/lang/String;)Lcom/skydoves/sandwich/a;"}, k = 3, mv = {2, 1, 0})
    static final class h extends kotlin.coroutines.jvm.internal.l implements q<Integer, String, v8.f<? super com.skydoves.sandwich.a<? extends Tournaments>>, Object> {
        final /* synthetic */ String $sportId;
        /* synthetic */ int I$0;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(String str, v8.f<? super h> fVar) {
            super(3, fVar);
            this.$sportId = str;
        }

        public final Object b(int i10, String str, v8.f<? super com.skydoves.sandwich.a<Tournaments>> fVar) {
            h hVar = new h(this.$sportId, fVar);
            hVar.I$0 = i10;
            hVar.L$0 = str;
            return hVar.invokeSuspend(z.f17874a);
        }

        @Override // c9.q
        public /* bridge */ /* synthetic */ Object invoke(Integer num, String str, v8.f<? super com.skydoves.sandwich.a<? extends Tournaments>> fVar) {
            return b(num.intValue(), str, fVar);
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
                int i11 = this.I$0;
                String str = (String) this.L$0;
                if (x1.f1.lb.config.b.f20643a.t()) {
                    k.logger.debug("query tournament, request[ {}, {}, {} ]", kotlin.coroutines.jvm.internal.b.b(i11), str, this.$sportId);
                }
                j jVar = (j) k.sportsServerProvider.a(i11);
                if (jVar != null) {
                    String str2 = this.$sportId;
                    this.label = 1;
                    obj = jVar.d(str2, this);
                    if (obj == objC) {
                        return objC;
                    }
                }
                throw new NullPointerException("sports api service is null");
            }
            com.skydoves.sandwich.a aVar = (com.skydoves.sandwich.a) obj;
            if (aVar != null) {
                return aVar;
            }
            throw new NullPointerException("sports api service is null");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J!\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"x1/f1/lb/api/k$i", "Lcom/skydoves/sandwich/retry/b;", "", "attempt", "", "message", "b", "(ILjava/lang/String;)I", "", "a", "(ILjava/lang/String;)Z", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class i implements com.skydoves.sandwich.retry.b {
        @Override // com.skydoves.sandwich.retry.b
        public boolean a(int attempt, String message) {
            return attempt <= 3;
        }

        @Override // com.skydoves.sandwich.retry.b
        public int b(int attempt, String message) {
            return 3000;
        }

        i() {
        }
    }

    static {
        q6.b bVarD = q6.c.d(k.class);
        kotlin.jvm.internal.m.e(bVarD, "getLogger(...)");
        logger = bVarD;
        sportsServerProvider = x1.f1.lb.host.b.f20720a.l();
        retryPolicy = new i();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object c(String str, v8.f<? super com.skydoves.sandwich.a<DataVersion>> fVar) {
        a aVar;
        long j10;
        if (fVar instanceof a) {
            aVar = (a) fVar;
            int i10 = aVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                aVar.label = i10 - Integer.MIN_VALUE;
            } else {
                aVar = new a(fVar);
            }
        } else {
            aVar = new a(fVar);
        }
        Object objA = aVar.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = aVar.label;
        try {
            if (i11 == 0) {
                r.b(objA);
                long jC = d1.c();
                i iVar = retryPolicy;
                b bVar = new b(str, null);
                aVar.J$0 = jC;
                aVar.label = 1;
                objA = com.skydoves.sandwich.retry.a.a(iVar, bVar, aVar);
                if (objA == objC) {
                    return objC;
                }
                j10 = jC;
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j10 = aVar.J$0;
                r.b(objA);
            }
            com.skydoves.sandwich.a aVar2 = (com.skydoves.sandwich.a) objA;
            if (x1.f1.lb.config.b.f20643a.t()) {
                logger.debug("api:query data version [{}ms]", kotlin.coroutines.jvm.internal.b.c(d1.c() - j10));
            }
            return aVar2;
        } catch (Throwable th) {
            return com.skydoves.sandwich.a.INSTANCE.a(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object d(String str, String str2, v8.f<? super com.skydoves.sandwich.a<Matches>> fVar) {
        c cVar;
        long j10;
        if (fVar instanceof c) {
            cVar = (c) fVar;
            int i10 = cVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                cVar.label = i10 - Integer.MIN_VALUE;
            } else {
                cVar = new c(fVar);
            }
        } else {
            cVar = new c(fVar);
        }
        Object objA = cVar.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = cVar.label;
        try {
            if (i11 == 0) {
                r.b(objA);
                long jC = d1.c();
                i iVar = retryPolicy;
                d dVar = new d(str, str2, null);
                cVar.J$0 = jC;
                cVar.label = 1;
                objA = com.skydoves.sandwich.retry.a.a(iVar, dVar, cVar);
                if (objA == objC) {
                    return objC;
                }
                j10 = jC;
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j10 = cVar.J$0;
                r.b(objA);
            }
            com.skydoves.sandwich.a aVar = (com.skydoves.sandwich.a) objA;
            logger.a("api:query matches [{}ms]", kotlin.coroutines.jvm.internal.b.c(d1.c() - j10));
            return aVar;
        } catch (Throwable th) {
            return com.skydoves.sandwich.a.INSTANCE.a(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object e(v8.f<? super com.skydoves.sandwich.a<Sports>> fVar) {
        e eVar;
        long j10;
        if (fVar instanceof e) {
            eVar = (e) fVar;
            int i10 = eVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                eVar.label = i10 - Integer.MIN_VALUE;
            } else {
                eVar = new e(fVar);
            }
        } else {
            eVar = new e(fVar);
        }
        Object objA = eVar.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = eVar.label;
        try {
            if (i11 == 0) {
                r.b(objA);
                long jC = d1.c();
                i iVar = retryPolicy;
                f fVar2 = new f(null);
                eVar.J$0 = jC;
                eVar.label = 1;
                objA = com.skydoves.sandwich.retry.a.a(iVar, fVar2, eVar);
                if (objA == objC) {
                    return objC;
                }
                j10 = jC;
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j10 = eVar.J$0;
                r.b(objA);
            }
            com.skydoves.sandwich.a aVar = (com.skydoves.sandwich.a) objA;
            logger.a("api:query sports [{}ms]", kotlin.coroutines.jvm.internal.b.c(d1.c() - j10));
            return aVar;
        } catch (Throwable th) {
            return com.skydoves.sandwich.a.INSTANCE.a(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object f(String str, v8.f<? super com.skydoves.sandwich.a<Tournaments>> fVar) {
        g gVar;
        long j10;
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
        Object objA = gVar.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = gVar.label;
        try {
            if (i11 == 0) {
                r.b(objA);
                long jC = d1.c();
                i iVar = retryPolicy;
                h hVar = new h(str, null);
                gVar.J$0 = jC;
                gVar.label = 1;
                objA = com.skydoves.sandwich.retry.a.a(iVar, hVar, gVar);
                if (objA == objC) {
                    return objC;
                }
                j10 = jC;
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j10 = gVar.J$0;
                r.b(objA);
            }
            com.skydoves.sandwich.a aVar = (com.skydoves.sandwich.a) objA;
            logger.a("api:query tournament [{}ms]", kotlin.coroutines.jvm.internal.b.c(d1.c() - j10));
            return aVar;
        } catch (Throwable th) {
            return com.skydoves.sandwich.a.INSTANCE.a(th);
        }
    }

    private k() {
    }
}
