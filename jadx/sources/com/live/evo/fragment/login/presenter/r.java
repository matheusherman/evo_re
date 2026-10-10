package com.live.evo.fragment.login.presenter;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import r8.u;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\u0003JI\u0010\u0012\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J+\u0010\u0016\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lcom/live/evo/fragment/login/presenter/r;", "Lcom/live/evo/fragment/login/presenter/p;", "<init>", "()V", "Lcom/live/evo/fragment/login/presenter/q;", "view", "Lr8/z;", "z", "(Lcom/live/evo/fragment/login/presenter/q;)V", "u", "", "verifyCode", NotificationCompat.CATEGORY_EMAIL, "password", "", "accountLoginType", "phonePreCode", "countryCode", "x", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "Li5/a;", "accountBean", "j", "(Ljava/lang/String;ILi5/a;)V", "a", "Lcom/live/evo/fragment/login/presenter/q;", "mView", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class r implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private q mView;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.fragment.login.presenter.ResetPasswordPresenter$reset$1", f = "ResetPasswordPresenter.kt", l = {41}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class a extends kotlin.coroutines.jvm.internal.l implements c9.p<l0, v8.f<? super z>, Object> {
        final /* synthetic */ String $email;
        final /* synthetic */ String $password;
        final /* synthetic */ String $verifyCode;
        int label;
        final /* synthetic */ r this$0;

        /* JADX INFO: renamed from: com.live.evo.fragment.login.presenter.r$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.fragment.login.presenter.ResetPasswordPresenter$reset$1$1", f = "ResetPasswordPresenter.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\b\u001a\u00020\u0007*\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00010\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lkotlinx/coroutines/flow/g;", "Lr8/u;", "", "", "", "", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
        static final class C0090a extends kotlin.coroutines.jvm.internal.l implements c9.q<kotlinx.coroutines.flow.g<? super u<? extends Boolean, ? extends Integer, ? extends String>>, Throwable, v8.f<? super z>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ r this$0;

            /* JADX INFO: renamed from: com.live.evo.fragment.login.presenter.r$a$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.fragment.login.presenter.ResetPasswordPresenter$reset$1$1$1", f = "ResetPasswordPresenter.kt", l = {}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
            static final class C0091a extends kotlin.coroutines.jvm.internal.l implements c9.p<l0, v8.f<? super z>, Object> {
                final /* synthetic */ Throwable $it;
                int label;
                final /* synthetic */ r this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0091a(r rVar, Throwable th, v8.f<? super C0091a> fVar) {
                    super(2, fVar);
                    this.this$0 = rVar;
                    this.$it = th;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final v8.f<z> create(Object obj, v8.f<?> fVar) {
                    return new C0091a(this.this$0, this.$it, fVar);
                }

                @Override // c9.p
                public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
                    return ((C0091a) create(l0Var, fVar)).invokeSuspend(z.f17874a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    kotlin.coroutines.intrinsics.b.c();
                    if (this.label == 0) {
                        r8.r.b(obj);
                        if (this.this$0.mView != null) {
                            q qVar = this.this$0.mView;
                            if (qVar != null) {
                                qVar.a();
                            }
                            q qVar2 = this.this$0.mView;
                            if (qVar2 != null) {
                                qVar2.j(this.$it.getMessage(), "");
                            }
                            return z.f17874a;
                        }
                        return z.f17874a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0090a(r rVar, v8.f<? super C0090a> fVar) {
                super(3, fVar);
                this.this$0 = rVar;
            }

            @Override // c9.q
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object invoke(kotlinx.coroutines.flow.g<? super u<Boolean, Integer, String>> gVar, Throwable th, v8.f<? super z> fVar) {
                C0090a c0090a = new C0090a(this.this$0, fVar);
                c0090a.L$0 = th;
                return c0090a.invokeSuspend(z.f17874a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.b.c();
                if (this.label == 0) {
                    r8.r.b(obj);
                    kotlinx.coroutines.j.d(m0.b(), null, null, new C0091a(this.this$0, (Throwable) this.L$0, null), 3, null);
                    return z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class b<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ r f6341a;

            /* JADX INFO: renamed from: com.live.evo.fragment.login.presenter.r$a$b$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.fragment.login.presenter.ResetPasswordPresenter$reset$1$2$1", f = "ResetPasswordPresenter.kt", l = {}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
            static final class C0092a extends kotlin.coroutines.jvm.internal.l implements c9.p<l0, v8.f<? super z>, Object> {
                final /* synthetic */ u<Boolean, Integer, String> $it;
                int label;
                final /* synthetic */ r this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0092a(r rVar, u<Boolean, Integer, String> uVar, v8.f<? super C0092a> fVar) {
                    super(2, fVar);
                    this.this$0 = rVar;
                    this.$it = uVar;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final v8.f<z> create(Object obj, v8.f<?> fVar) {
                    return new C0092a(this.this$0, this.$it, fVar);
                }

                @Override // c9.p
                public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
                    return ((C0092a) create(l0Var, fVar)).invokeSuspend(z.f17874a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    String string;
                    kotlin.coroutines.intrinsics.b.c();
                    if (this.label == 0) {
                        r8.r.b(obj);
                        if (this.this$0.mView != null) {
                            q qVar = this.this$0.mView;
                            if (qVar != null) {
                                qVar.a();
                            }
                            if (this.$it.d().booleanValue()) {
                                q qVar2 = this.this$0.mView;
                                if (qVar2 != null) {
                                    qVar2.G();
                                }
                            } else {
                                Integer numE = this.$it.e();
                                if (numE != null && numE.intValue() == -3) {
                                    q qVar3 = this.this$0.mView;
                                    if (qVar3 != null) {
                                        qVar3.d();
                                    }
                                } else {
                                    q qVar4 = this.this$0.mView;
                                    if (qVar4 != null) {
                                        String strF = this.$it.f();
                                        Integer numE2 = this.$it.e();
                                        if (numE2 != null) {
                                            string = numE2.toString();
                                        } else {
                                            string = null;
                                        }
                                        qVar4.j(strF, string);
                                    }
                                }
                            }
                            return z.f17874a;
                        }
                        return z.f17874a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            b(r rVar) {
                this.f6341a = rVar;
            }

            @Override // kotlinx.coroutines.flow.g
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(u<Boolean, Integer, String> uVar, v8.f<? super z> fVar) {
                kotlinx.coroutines.j.d(m0.b(), null, null, new C0092a(this.f6341a, uVar, null), 3, null);
                return z.f17874a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, String str2, String str3, r rVar, v8.f<? super a> fVar) {
            super(2, fVar);
            this.$email = str;
            this.$password = str2;
            this.$verifyCode = str3;
            this.this$0 = rVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            return new a(this.$email, this.$password, this.$verifyCode, this.this$0, fVar);
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
                t.v.c.i.a aVar = t.v.c.i.a.f18646a;
                String str = this.$email;
                if (str == null) {
                    str = "";
                }
                String str2 = this.$password;
                if (str2 == null) {
                    str2 = "";
                }
                String str3 = this.$verifyCode;
                if (str3 == null) {
                    str3 = "";
                }
                kotlinx.coroutines.flow.f fVarF = kotlinx.coroutines.flow.h.f(aVar.F0(str, "", str2, str3), new C0090a(this.this$0, null));
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
    @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.fragment.login.presenter.ResetPasswordPresenter$verify$1", f = "ResetPasswordPresenter.kt", l = {145, 147, 153}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class b extends kotlin.coroutines.jvm.internal.l implements c9.p<l0, v8.f<? super z>, Object> {
        final /* synthetic */ i5.a $accountBean;
        final /* synthetic */ int $accountLoginType;
        final /* synthetic */ String $email;
        int label;
        final /* synthetic */ r this$0;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.fragment.login.presenter.ResetPasswordPresenter$verify$1$1", f = "ResetPasswordPresenter.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\b\u001a\u00020\u0007*\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00010\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lkotlinx/coroutines/flow/g;", "Lr8/u;", "", "", "", "", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends kotlin.coroutines.jvm.internal.l implements c9.q<kotlinx.coroutines.flow.g<? super u<? extends Boolean, ? extends Integer, ? extends String>>, Throwable, v8.f<? super z>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ r this$0;

            /* JADX INFO: renamed from: com.live.evo.fragment.login.presenter.r$b$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.fragment.login.presenter.ResetPasswordPresenter$verify$1$1$1", f = "ResetPasswordPresenter.kt", l = {}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
            static final class C0093a extends kotlin.coroutines.jvm.internal.l implements c9.p<l0, v8.f<? super z>, Object> {
                final /* synthetic */ Throwable $it;
                int label;
                final /* synthetic */ r this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0093a(r rVar, Throwable th, v8.f<? super C0093a> fVar) {
                    super(2, fVar);
                    this.this$0 = rVar;
                    this.$it = th;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final v8.f<z> create(Object obj, v8.f<?> fVar) {
                    return new C0093a(this.this$0, this.$it, fVar);
                }

                @Override // c9.p
                public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
                    return ((C0093a) create(l0Var, fVar)).invokeSuspend(z.f17874a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    kotlin.coroutines.intrinsics.b.c();
                    if (this.label == 0) {
                        r8.r.b(obj);
                        q qVar = this.this$0.mView;
                        if (qVar != null) {
                            qVar.a();
                        }
                        q qVar2 = this.this$0.mView;
                        if (qVar2 != null) {
                            qVar2.j(this.$it.getMessage(), "");
                        }
                        return z.f17874a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(r rVar, v8.f<? super a> fVar) {
                super(3, fVar);
                this.this$0 = rVar;
            }

            @Override // c9.q
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object invoke(kotlinx.coroutines.flow.g<? super u<Boolean, Integer, String>> gVar, Throwable th, v8.f<? super z> fVar) {
                a aVar = new a(this.this$0, fVar);
                aVar.L$0 = th;
                return aVar.invokeSuspend(z.f17874a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.b.c();
                if (this.label == 0) {
                    r8.r.b(obj);
                    kotlinx.coroutines.j.d(m0.b(), null, null, new C0093a(this.this$0, (Throwable) this.L$0, null), 3, null);
                    return z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.live.evo.fragment.login.presenter.r$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class C0094b<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ r f6342a;

            /* JADX INFO: renamed from: com.live.evo.fragment.login.presenter.r$b$b$a */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.fragment.login.presenter.ResetPasswordPresenter$verify$1$2$1", f = "ResetPasswordPresenter.kt", l = {}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
            static final class a extends kotlin.coroutines.jvm.internal.l implements c9.p<l0, v8.f<? super z>, Object> {
                final /* synthetic */ u<Boolean, Integer, String> $it;
                int label;
                final /* synthetic */ r this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                a(r rVar, u<Boolean, Integer, String> uVar, v8.f<? super a> fVar) {
                    super(2, fVar);
                    this.this$0 = rVar;
                    this.$it = uVar;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final v8.f<z> create(Object obj, v8.f<?> fVar) {
                    return new a(this.this$0, this.$it, fVar);
                }

                @Override // c9.p
                public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
                    return ((a) create(l0Var, fVar)).invokeSuspend(z.f17874a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    String string;
                    kotlin.coroutines.intrinsics.b.c();
                    if (this.label == 0) {
                        r8.r.b(obj);
                        q qVar = this.this$0.mView;
                        if (qVar != null) {
                            qVar.a();
                        }
                        if (this.$it.d().booleanValue()) {
                            q qVar2 = this.this$0.mView;
                            if (qVar2 != null) {
                                qVar2.h();
                            }
                        } else {
                            Integer numE = this.$it.e();
                            if (numE != null && numE.intValue() == -3) {
                                q qVar3 = this.this$0.mView;
                                if (qVar3 != null) {
                                    qVar3.d();
                                }
                            } else {
                                q qVar4 = this.this$0.mView;
                                if (qVar4 != null) {
                                    String strF = this.$it.f();
                                    Integer numE2 = this.$it.e();
                                    if (numE2 != null) {
                                        string = numE2.toString();
                                    } else {
                                        string = null;
                                    }
                                    qVar4.j(strF, string);
                                }
                            }
                        }
                        return z.f17874a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            C0094b(r rVar) {
                this.f6342a = rVar;
            }

            @Override // kotlinx.coroutines.flow.g
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(u<Boolean, Integer, String> uVar, v8.f<? super z> fVar) {
                kotlinx.coroutines.j.d(m0.b(), null, null, new a(this.f6342a, uVar, null), 3, null);
                return z.f17874a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(int i10, i5.a aVar, String str, r rVar, v8.f<? super b> fVar) {
            super(2, fVar);
            this.$accountLoginType = i10;
            this.$accountBean = aVar;
            this.$email = str;
            this.this$0 = rVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            return new b(this.$accountLoginType, this.$accountBean, this.$email, this.this$0, fVar);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
            return ((b) create(l0Var, fVar)).invokeSuspend(z.f17874a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:24:0x004a, code lost:
        
            if (r8 == r0) goto L37;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x005e, code lost:
        
            if (r8 == r0) goto L37;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x007c, code lost:
        
            if (r8.collect(r1, r7) == r0) goto L37;
         */
        @Override // kotlin.coroutines.jvm.internal.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            String strD;
            kotlinx.coroutines.flow.f fVar;
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 != 2) {
                        if (i10 == 3) {
                            r8.r.b(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        r8.r.b(obj);
                        fVar = (kotlinx.coroutines.flow.f) obj;
                    }
                } else {
                    r8.r.b(obj);
                    fVar = (kotlinx.coroutines.flow.f) obj;
                }
                return z.f17874a;
            }
            r8.r.b(obj);
            String str = "";
            if (this.$accountLoginType == 1) {
                t.v.c.i.a aVar = t.v.c.i.a.f18646a;
                i5.a aVar2 = this.$accountBean;
                if (aVar2 == null || (strD = aVar2.d()) == null) {
                    strD = "";
                }
                String str2 = this.$email;
                if (str2 != null) {
                    str = str2;
                }
                this.label = 1;
                obj = aVar.t(strD, str, "FORGET", this);
            } else {
                t.v.c.i.a aVar3 = t.v.c.i.a.f18646a;
                String str3 = this.$email;
                if (str3 != null) {
                    str = str3;
                }
                this.label = 2;
                obj = aVar3.s(str, "FORGET", this);
            }
            return objC;
            kotlinx.coroutines.flow.f fVarF = kotlinx.coroutines.flow.h.f(fVar, new a(this.this$0, null));
            C0094b c0094b = new C0094b(this.this$0);
            this.label = 3;
        }
    }

    @Override // k5.a
    public void u() {
        this.mView = null;
    }

    @Override // k5.a
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public void r(q view) {
        this.mView = view;
    }

    @Override // com.live.evo.fragment.login.presenter.p
    public void j(String email, int accountLoginType, i5.a accountBean) {
        kotlinx.coroutines.j.d(m0.a(a1.b()), null, null, new b(accountLoginType, accountBean, email, this, null), 3, null);
    }

    @Override // com.live.evo.fragment.login.presenter.p
    public void x(String verifyCode, String email, String password, int accountLoginType, String phonePreCode, String countryCode) {
        kotlinx.coroutines.j.d(m0.a(a1.b()), null, null, new a(email, password, verifyCode, this, null), 3, null);
    }
}
