package com.live.evo.fragment.login.presenter;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.live.evo.R$string;
import com.live.evo.util.s0;
import com.live.evo.util.x1;
import kotlin.Metadata;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import org.apache.log4j.net.SyslogAppender;
import r8.u;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J;\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u0003J!\u0010\u0012\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0016\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0018\u0010\u0003R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Lcom/live/evo/fragment/login/presenter/e;", "Lcom/live/evo/fragment/login/presenter/c;", "<init>", "()V", "", "userID", "password", "", "accountLoginType", "phonePreCode", "countryCode", "Lr8/z;", "l", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "p", "Landroid/content/Context;", "context", "code", "s", "(Landroid/content/Context;Ljava/lang/String;)V", "Lcom/live/evo/fragment/login/presenter/d;", "view", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lcom/live/evo/fragment/login/presenter/d;)V", "u", "Lq6/b;", "a", "Lq6/b;", "logger", "b", "Lcom/live/evo/fragment/login/presenter/d;", "mView", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class e implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final q6.b logger;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private d mView;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.fragment.login.presenter.LoginPresenter$login$1", f = "LoginPresenter.kt", l = {44}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class a extends kotlin.coroutines.jvm.internal.l implements c9.p<l0, v8.f<? super z>, Object> {
        final /* synthetic */ String $password;
        final /* synthetic */ String $userID;
        final /* synthetic */ d $view;
        int label;
        final /* synthetic */ e this$0;

        /* JADX INFO: renamed from: com.live.evo.fragment.login.presenter.e$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.fragment.login.presenter.LoginPresenter$login$1$1", f = "LoginPresenter.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\b\u001a\u00020\u0007*\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00010\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lkotlinx/coroutines/flow/g;", "Lr8/u;", "", "", "", "", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
        static final class C0080a extends kotlin.coroutines.jvm.internal.l implements c9.q<kotlinx.coroutines.flow.g<? super u<? extends Boolean, ? extends Integer, ? extends String>>, Throwable, v8.f<? super z>, Object> {
            final /* synthetic */ d $view;
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ e this$0;

            /* JADX INFO: renamed from: com.live.evo.fragment.login.presenter.e$a$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.fragment.login.presenter.LoginPresenter$login$1$1$1", f = "LoginPresenter.kt", l = {}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
            static final class C0081a extends kotlin.coroutines.jvm.internal.l implements c9.p<l0, v8.f<? super z>, Object> {
                final /* synthetic */ String $msg;
                int label;
                final /* synthetic */ e this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0081a(e eVar, String str, v8.f<? super C0081a> fVar) {
                    super(2, fVar);
                    this.this$0 = eVar;
                    this.$msg = str;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final v8.f<z> create(Object obj, v8.f<?> fVar) {
                    return new C0081a(this.this$0, this.$msg, fVar);
                }

                @Override // c9.p
                public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
                    return ((C0081a) create(l0Var, fVar)).invokeSuspend(z.f17874a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    kotlin.coroutines.intrinsics.b.c();
                    if (this.label == 0) {
                        r8.r.b(obj);
                        d dVar = this.this$0.mView;
                        if (dVar != null) {
                            dVar.J(this.$msg);
                        }
                        return z.f17874a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0080a(d dVar, e eVar, v8.f<? super C0080a> fVar) {
                super(3, fVar);
                this.$view = dVar;
                this.this$0 = eVar;
            }

            @Override // c9.q
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object invoke(kotlinx.coroutines.flow.g<? super u<Boolean, Integer, String>> gVar, Throwable th, v8.f<? super z> fVar) {
                C0080a c0080a = new C0080a(this.$view, this.this$0, fVar);
                c0080a.L$0 = th;
                return c0080a.invokeSuspend(z.f17874a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.b.c();
                if (this.label == 0) {
                    r8.r.b(obj);
                    Throwable th = (Throwable) this.L$0;
                    this.$view.a();
                    this.this$0.logger.error("Auth error", th);
                    kotlinx.coroutines.j.d(m0.b(), null, null, new C0081a(this.this$0, x1.j(R$string.auth_fail_title) + "[" + th.getMessage() + "]", null), 3, null);
                    return z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class b<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ e f6326a;

            /* JADX INFO: renamed from: com.live.evo.fragment.login.presenter.e$a$b$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.fragment.login.presenter.LoginPresenter$login$1$2$1", f = "LoginPresenter.kt", l = {}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
            static final class C0082a extends kotlin.coroutines.jvm.internal.l implements c9.p<l0, v8.f<? super z>, Object> {
                final /* synthetic */ u<Boolean, Integer, String> $it;
                int label;
                final /* synthetic */ e this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0082a(e eVar, u<Boolean, Integer, String> uVar, v8.f<? super C0082a> fVar) {
                    super(2, fVar);
                    this.this$0 = eVar;
                    this.$it = uVar;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final v8.f<z> create(Object obj, v8.f<?> fVar) {
                    return new C0082a(this.this$0, this.$it, fVar);
                }

                @Override // c9.p
                public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
                    return ((C0082a) create(l0Var, fVar)).invokeSuspend(z.f17874a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    kotlin.coroutines.intrinsics.b.c();
                    if (this.label == 0) {
                        r8.r.b(obj);
                        d dVar = this.this$0.mView;
                        if (dVar != null) {
                            dVar.a();
                        }
                        if (this.$it.d().booleanValue()) {
                            d dVar2 = this.this$0.mView;
                            if (dVar2 != null) {
                                dVar2.c();
                            }
                        } else {
                            Integer numE = this.$it.e();
                            if (numE != null && numE.intValue() == -3) {
                                d dVar3 = this.this$0.mView;
                                if (dVar3 != null) {
                                    dVar3.d();
                                }
                            } else {
                                d dVar4 = this.this$0.mView;
                                if (dVar4 != null) {
                                    String strF = this.$it.f();
                                    dVar4.J(((Object) strF) + "(" + this.$it.e() + ")");
                                }
                            }
                        }
                        return z.f17874a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            b(e eVar) {
                this.f6326a = eVar;
            }

            @Override // kotlinx.coroutines.flow.g
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(u<Boolean, Integer, String> uVar, v8.f<? super z> fVar) {
                kotlinx.coroutines.j.d(m0.b(), null, null, new C0082a(this.f6326a, uVar, null), 3, null);
                return z.f17874a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, String str2, d dVar, e eVar, v8.f<? super a> fVar) {
            super(2, fVar);
            this.$userID = str;
            this.$password = str2;
            this.$view = dVar;
            this.this$0 = eVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            return new a(this.$userID, this.$password, this.$view, this.this$0, fVar);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
            return ((a) create(l0Var, fVar)).invokeSuspend(z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 == 1) {
                    r8.r.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                r8.r.b(obj);
                kotlinx.coroutines.flow.f fVarF = kotlinx.coroutines.flow.h.f(t.v.c.i.a.f18646a.y0(this.$userID, this.$password), new C0080a(this.$view, this.this$0, null));
                b bVar = new b(this.this$0);
                this.label = 1;
                if (fVarF.collect(bVar, this) == objC) {
                    return objC;
                }
            }
            return z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.fragment.login.presenter.LoginPresenter$loginByRenewalCode$1", f = "LoginPresenter.kt", l = {SyslogAppender.LOG_LOCAL3, 159}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class b extends kotlin.coroutines.jvm.internal.l implements c9.p<l0, v8.f<? super z>, Object> {
        final /* synthetic */ String $code;
        final /* synthetic */ d $view;
        int label;
        final /* synthetic */ e this$0;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.fragment.login.presenter.LoginPresenter$loginByRenewalCode$1$1", f = "LoginPresenter.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\b\u001a\u00020\u0007*\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00010\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lkotlinx/coroutines/flow/g;", "Lr8/u;", "", "", "", "", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends kotlin.coroutines.jvm.internal.l implements c9.q<kotlinx.coroutines.flow.g<? super u<? extends Boolean, ? extends Integer, ? extends String>>, Throwable, v8.f<? super z>, Object> {
            final /* synthetic */ d $view;
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ e this$0;

            /* JADX INFO: renamed from: com.live.evo.fragment.login.presenter.e$b$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.fragment.login.presenter.LoginPresenter$loginByRenewalCode$1$1$1", f = "LoginPresenter.kt", l = {}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
            static final class C0083a extends kotlin.coroutines.jvm.internal.l implements c9.p<l0, v8.f<? super z>, Object> {
                final /* synthetic */ String $msg;
                int label;
                final /* synthetic */ e this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0083a(e eVar, String str, v8.f<? super C0083a> fVar) {
                    super(2, fVar);
                    this.this$0 = eVar;
                    this.$msg = str;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final v8.f<z> create(Object obj, v8.f<?> fVar) {
                    return new C0083a(this.this$0, this.$msg, fVar);
                }

                @Override // c9.p
                public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
                    return ((C0083a) create(l0Var, fVar)).invokeSuspend(z.f17874a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    kotlin.coroutines.intrinsics.b.c();
                    if (this.label == 0) {
                        r8.r.b(obj);
                        d dVar = this.this$0.mView;
                        if (dVar != null) {
                            dVar.J(this.$msg);
                        }
                        return z.f17874a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(d dVar, e eVar, v8.f<? super a> fVar) {
                super(3, fVar);
                this.$view = dVar;
                this.this$0 = eVar;
            }

            @Override // c9.q
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object invoke(kotlinx.coroutines.flow.g<? super u<Boolean, Integer, String>> gVar, Throwable th, v8.f<? super z> fVar) {
                a aVar = new a(this.$view, this.this$0, fVar);
                aVar.L$0 = th;
                return aVar.invokeSuspend(z.f17874a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.b.c();
                if (this.label == 0) {
                    r8.r.b(obj);
                    Throwable th = (Throwable) this.L$0;
                    this.$view.a();
                    this.this$0.logger.error("Auth error", th);
                    kotlinx.coroutines.j.d(m0.b(), null, null, new C0083a(this.this$0, x1.j(R$string.auth_fail_title) + "[" + th.getMessage() + "]", null), 3, null);
                    return z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.live.evo.fragment.login.presenter.e$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class C0084b<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ d f6327a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f6328b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ e f6329c;

            /* JADX INFO: renamed from: com.live.evo.fragment.login.presenter.e$b$b$a */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.fragment.login.presenter.LoginPresenter$loginByRenewalCode$1$2$1", f = "LoginPresenter.kt", l = {}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
            static final class a extends kotlin.coroutines.jvm.internal.l implements c9.p<l0, v8.f<? super z>, Object> {
                final /* synthetic */ String $code;
                final /* synthetic */ u<Boolean, Integer, String> $it;
                final /* synthetic */ d $view;
                int label;
                final /* synthetic */ e this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                a(d dVar, u<Boolean, Integer, String> uVar, String str, e eVar, v8.f<? super a> fVar) {
                    super(2, fVar);
                    this.$view = dVar;
                    this.$it = uVar;
                    this.$code = str;
                    this.this$0 = eVar;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final v8.f<z> create(Object obj, v8.f<?> fVar) {
                    return new a(this.$view, this.$it, this.$code, this.this$0, fVar);
                }

                @Override // c9.p
                public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
                    return ((a) create(l0Var, fVar)).invokeSuspend(z.f17874a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    kotlin.coroutines.intrinsics.b.c();
                    if (this.label == 0) {
                        r8.r.b(obj);
                        this.$view.a();
                        if (this.$it.d().booleanValue()) {
                            if (t.v.c.i.a.f18646a.r0(this.$code)) {
                                this.$view.P();
                            } else {
                                this.$view.c();
                            }
                        } else {
                            Integer numE = this.$it.e();
                            if (numE != null && numE.intValue() == -3) {
                                d dVar = this.this$0.mView;
                                if (dVar != null) {
                                    dVar.d();
                                }
                            } else {
                                d dVar2 = this.this$0.mView;
                                if (dVar2 != null) {
                                    String strF = this.$it.f();
                                    dVar2.J(((Object) strF) + "(" + this.$it.e() + ")");
                                }
                            }
                        }
                        return z.f17874a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            C0084b(d dVar, String str, e eVar) {
                this.f6327a = dVar;
                this.f6328b = str;
                this.f6329c = eVar;
            }

            @Override // kotlinx.coroutines.flow.g
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(u<Boolean, Integer, String> uVar, v8.f<? super z> fVar) {
                kotlinx.coroutines.j.d(m0.b(), null, null, new a(this.f6327a, uVar, this.f6328b, this.f6329c, null), 3, null);
                return z.f17874a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, d dVar, e eVar, v8.f<? super b> fVar) {
            super(2, fVar);
            this.$code = str;
            this.$view = dVar;
            this.this$0 = eVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            return new b(this.$code, this.$view, this.this$0, fVar);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
            return ((b) create(l0Var, fVar)).invokeSuspend(z.f17874a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x004f, code lost:
        
            if (r7.collect(r1, r6) == r0) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
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
                    r8.r.b(obj);
                }
                return z.f17874a;
            }
            r8.r.b(obj);
            t.v.c.i.a aVar = t.v.c.i.a.f18646a;
            String str = this.$code;
            this.label = 1;
            obj = aVar.w0(str, this);
            if (obj != objC) {
            }
            return objC;
            kotlinx.coroutines.flow.f fVarF = kotlinx.coroutines.flow.h.f((kotlinx.coroutines.flow.f) obj, new a(this.$view, this.this$0, null));
            C0084b c0084b = new C0084b(this.$view, this.$code, this.this$0);
            this.label = 2;
        }
    }

    @Override // k5.a
    public void u() {
        this.mView = null;
    }

    @Override // k5.a
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public void r(d view) {
        this.mView = view;
    }

    @Override // com.live.evo.fragment.login.presenter.c
    public void l(String userID, String password, int accountLoginType, String phonePreCode, String countryCode) {
        kotlin.jvm.internal.m.f(userID, "userID");
        kotlin.jvm.internal.m.f(password, "password");
        d dVar = this.mView;
        if (dVar == null) {
            return;
        }
        dVar.b();
        kotlinx.coroutines.j.d(m0.a(a1.b()), null, null, new a(userID, password, dVar, this, null), 3, null);
    }

    @Override // com.live.evo.fragment.login.presenter.c
    public void p() {
        d dVar = this.mView;
        if (dVar != null) {
            dVar.k(s0.f7342a.p());
        }
    }

    @Override // com.live.evo.fragment.login.presenter.c
    public void s(Context context, String code) {
        kotlin.jvm.internal.m.f(code, "code");
        d dVar = this.mView;
        if (dVar == null) {
            return;
        }
        dVar.b();
        kotlinx.coroutines.j.d(m0.a(a1.b()), null, null, new b(code, dVar, this, null), 3, null);
    }

    public e() {
        q6.b bVarD = q6.c.d(e.class);
        kotlin.jvm.internal.m.e(bVarD, "getLogger(...)");
        this.logger = bVarD;
    }
}
