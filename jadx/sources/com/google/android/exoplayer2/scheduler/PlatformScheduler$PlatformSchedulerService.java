package com.google.android.exoplayer2.scheduler;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.PersistableBundle;
import d1.a;
import d1.d;
import d1.k;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class PlatformScheduler$PlatformSchedulerService extends JobService {
    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        PersistableBundle extras = jobParameters.getExtras();
        int iB = new Requirements(extras.getInt("requirements")).b(this);
        if (iB == 0) {
            String str = (String) a.b(extras.getString("service_action"));
            k.l(this, new Intent(str).setPackage((String) a.b(extras.getString("service_package"))));
            return false;
        }
        StringBuilder sb2 = new StringBuilder(33);
        sb2.append("Requirements not met: ");
        sb2.append(iB);
        d.f("PlatformScheduler", sb2.toString());
        jobFinished(jobParameters, true);
        return false;
    }
}
