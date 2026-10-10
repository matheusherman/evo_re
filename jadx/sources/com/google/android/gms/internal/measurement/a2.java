package com.google.android.gms.internal.measurement;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.Context;
import android.os.Build;
import android.os.UserHandle;
import android.util.Log;
import androidx.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@TargetApi(24)
public final class a2 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private static final Method f2524b = e();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private static final Method f2525c = d();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final JobScheduler f2526a;

    private static int a() {
        Method method = f2525c;
        if (method != null) {
            try {
                Integer num = (Integer) method.invoke(UserHandle.class, null);
                if (num != null) {
                    return num.intValue();
                }
                return 0;
            } catch (IllegalAccessException | InvocationTargetException e10) {
                if (Log.isLoggable("JobSchedulerCompat", 6)) {
                    Log.e("JobSchedulerCompat", "myUserId invocation illegal", e10);
                }
            }
        }
        return 0;
    }

    private final int b(JobInfo jobInfo, String str, int i10, String str2) {
        Method method = f2524b;
        if (method != null) {
            try {
                Integer num = (Integer) method.invoke(this.f2526a, jobInfo, str, Integer.valueOf(i10), str2);
                if (num != null) {
                    return num.intValue();
                }
                return 0;
            } catch (IllegalAccessException | InvocationTargetException e10) {
                Log.e(str2, "error calling scheduleAsPackage", e10);
            }
        }
        return this.f2526a.schedule(jobInfo);
    }

    public static int c(Context context, JobInfo jobInfo, String str, String str2) {
        JobScheduler jobScheduler = (JobScheduler) com.google.common.base.m.i((JobScheduler) context.getSystemService("jobscheduler"));
        return (f2524b == null || context.checkSelfPermission("android.permission.UPDATE_DEVICE_STATS") != 0) ? jobScheduler.schedule(jobInfo) : new a2(jobScheduler).b(jobInfo, str, a(), str2);
    }

    @Nullable
    private static Method d() {
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                return UserHandle.class.getDeclaredMethod("myUserId", null);
            } catch (NoSuchMethodException unused) {
                if (Log.isLoggable("JobSchedulerCompat", 6)) {
                    Log.e("JobSchedulerCompat", "No myUserId method available");
                }
            }
        }
        return null;
    }

    @Nullable
    private static Method e() {
        if (Build.VERSION.SDK_INT < 24) {
            return null;
        }
        try {
            return JobScheduler.class.getDeclaredMethod("scheduleAsPackage", JobInfo.class, String.class, Integer.TYPE, String.class);
        } catch (NoSuchMethodException unused) {
            if (!Log.isLoggable("JobSchedulerCompat", 6)) {
                return null;
            }
            Log.e("JobSchedulerCompat", "No scheduleAsPackage method available, falling back to schedule");
            return null;
        }
    }

    private a2(JobScheduler jobScheduler) {
        this.f2526a = jobScheduler;
    }
}
