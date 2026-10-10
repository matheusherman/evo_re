package com.google.firebase.concurrent;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.StrictMode;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.concurrent.ExecutorsRegistrar;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import m2.e0;
import m2.x;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@SuppressLint({"ThreadPoolCreation"})
public class ExecutorsRegistrar implements ComponentRegistrar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final x<ScheduledExecutorService> f4706a = new x<>(new r2.b() { // from class: n2.c
        @Override // r2.b
        public final Object get() {
            return ExecutorsRegistrar.m(Executors.newFixedThreadPool(4, ExecutorsRegistrar.k("Firebase Background", 10, ExecutorsRegistrar.i())));
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final x<ScheduledExecutorService> f4707b = new x<>(new r2.b() { // from class: n2.d
        @Override // r2.b
        public final Object get() {
            return ExecutorsRegistrar.m(Executors.newFixedThreadPool(Math.max(2, Runtime.getRuntime().availableProcessors()), ExecutorsRegistrar.k("Firebase Lite", 0, ExecutorsRegistrar.l())));
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final x<ScheduledExecutorService> f4708c = new x<>(new r2.b() { // from class: n2.e
        @Override // r2.b
        public final Object get() {
            return ExecutorsRegistrar.m(Executors.newCachedThreadPool(ExecutorsRegistrar.j("Firebase Blocking", 11)));
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final x<ScheduledExecutorService> f4709d = new x<>(new r2.b() { // from class: n2.f
        @Override // r2.b
        public final Object get() {
            return Executors.newSingleThreadScheduledExecutor(ExecutorsRegistrar.j("Firebase Scheduler", 0));
        }
    });

    private static StrictMode.ThreadPolicy i() {
        StrictMode.ThreadPolicy.Builder builderDetectNetwork = new StrictMode.ThreadPolicy.Builder().detectNetwork();
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 23) {
            builderDetectNetwork.detectResourceMismatches();
            if (i10 >= 26) {
                builderDetectNetwork.detectUnbufferedIo();
            }
        }
        return builderDetectNetwork.penaltyLog().build();
    }

    private static ThreadFactory j(String str, int i10) {
        return new b(str, i10, null);
    }

    private static ThreadFactory k(String str, int i10, StrictMode.ThreadPolicy threadPolicy) {
        return new b(str, i10, threadPolicy);
    }

    private static StrictMode.ThreadPolicy l() {
        return new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ScheduledExecutorService m(ExecutorService executorService) {
        return new o(executorService, f4709d.get());
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<m2.c<?>> getComponents() {
        return Arrays.asList(m2.c.f(e0.a(l2.a.class, ScheduledExecutorService.class), e0.a(l2.a.class, ExecutorService.class), e0.a(l2.a.class, Executor.class)).e(new m2.h() { // from class: n2.g
            @Override // m2.h
            public final Object a(m2.e eVar) {
                return ExecutorsRegistrar.f4706a.get();
            }
        }).c(), m2.c.f(e0.a(l2.b.class, ScheduledExecutorService.class), e0.a(l2.b.class, ExecutorService.class), e0.a(l2.b.class, Executor.class)).e(new m2.h() { // from class: n2.h
            @Override // m2.h
            public final Object a(m2.e eVar) {
                return ExecutorsRegistrar.f4708c.get();
            }
        }).c(), m2.c.f(e0.a(l2.c.class, ScheduledExecutorService.class), e0.a(l2.c.class, ExecutorService.class), e0.a(l2.c.class, Executor.class)).e(new m2.h() { // from class: n2.i
            @Override // m2.h
            public final Object a(m2.e eVar) {
                return ExecutorsRegistrar.f4707b.get();
            }
        }).c(), m2.c.e(e0.a(l2.d.class, Executor.class)).e(new m2.h() { // from class: n2.j
            @Override // m2.h
            public final Object a(m2.e eVar) {
                return m.INSTANCE;
            }
        }).c());
    }
}
