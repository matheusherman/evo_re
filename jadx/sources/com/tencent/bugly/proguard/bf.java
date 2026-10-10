package com.tencent.bugly.proguard;

import android.os.Handler;
import android.os.SystemClock;
import androidx.p000lifecycle.CoroutineLiveDataKt;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class bf implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Handler f8936a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    long f8939d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f8940e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List<ba> f8941f = new LinkedList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    long f8937b = CoroutineLiveDataKt.DEFAULT_TIMEOUT;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final long f8942g = CoroutineLiveDataKt.DEFAULT_TIMEOUT;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f8938c = true;

    @Override // java.lang.Runnable
    public final void run() {
        this.f8938c = true;
        this.f8937b = this.f8942g;
    }

    private Thread e() {
        return this.f8936a.getLooper().getThread();
    }

    public final boolean a() {
        return !this.f8938c && SystemClock.uptimeMillis() >= this.f8939d + this.f8937b;
    }

    public final void d() {
        StringBuilder sb2 = new StringBuilder(1024);
        long jNanoTime = System.nanoTime();
        try {
            StackTraceElement[] stackTrace = e().getStackTrace();
            if (stackTrace.length == 0) {
                sb2.append("Thread does not have stack trace.\n");
            } else {
                for (StackTraceElement stackTraceElement : stackTrace) {
                    sb2.append(stackTraceElement);
                    sb2.append("\n");
                }
            }
        } catch (SecurityException e10) {
            sb2.append("getStackTrace() encountered:\n");
            sb2.append(e10.getMessage());
            sb2.append("\n");
            al.a(e10);
        }
        long jNanoTime2 = System.nanoTime();
        ba baVar = new ba(sb2.toString(), System.currentTimeMillis());
        baVar.f8916d = jNanoTime2 - jNanoTime;
        String name = e().getName();
        if (name == null) {
            name = "";
        }
        baVar.f8913a = name;
        synchronized (this.f8941f) {
            while (this.f8941f.size() >= 32) {
                try {
                    this.f8941f.remove(0);
                } catch (Throwable th) {
                    throw th;
                }
            }
            this.f8941f.add(baVar);
        }
    }

    bf(Handler handler, String str) {
        this.f8936a = handler;
        this.f8940e = str;
    }

    public final long b() {
        return SystemClock.uptimeMillis() - this.f8939d;
    }

    public final List<ba> c() {
        ArrayList arrayList;
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (this.f8941f) {
            try {
                arrayList = new ArrayList(this.f8941f.size());
                for (int i10 = 0; i10 < this.f8941f.size(); i10++) {
                    ba baVar = this.f8941f.get(i10);
                    if (!baVar.f8917e && jCurrentTimeMillis - baVar.f8914b < 200000) {
                        arrayList.add(baVar);
                        baVar.f8917e = true;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return arrayList;
    }
}
