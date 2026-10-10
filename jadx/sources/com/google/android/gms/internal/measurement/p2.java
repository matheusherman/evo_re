package com.google.android.gms.internal.measurement;

import android.content.Intent;
import android.os.Bundle;
import android.os.IInterface;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public interface p2 extends IInterface {
    void beginAdUnitExposure(String str, long j10);

    void clearConditionalUserProperty(String str, String str2, Bundle bundle);

    void clearMeasurementEnabled(long j10);

    void endAdUnitExposure(String str, long j10);

    void generateEventId(u2 u2Var);

    void getAppInstanceId(u2 u2Var);

    void getCachedAppInstanceId(u2 u2Var);

    void getConditionalUserProperties(String str, String str2, u2 u2Var);

    void getCurrentScreenClass(u2 u2Var);

    void getCurrentScreenName(u2 u2Var);

    void getGmpAppId(u2 u2Var);

    void getMaxUserProperties(String str, u2 u2Var);

    void getSessionId(u2 u2Var);

    void getTestFlag(u2 u2Var, int i10);

    void getUserProperties(String str, String str2, boolean z10, u2 u2Var);

    void initForTests(Map map);

    void initialize(u1.a aVar, zzdz zzdzVar, long j10);

    void isDataCollectionEnabled(u2 u2Var);

    void logEvent(String str, String str2, Bundle bundle, boolean z10, boolean z11, long j10);

    void logEventAndBundle(String str, String str2, Bundle bundle, u2 u2Var, long j10);

    void logHealthData(int i10, String str, u1.a aVar, u1.a aVar2, u1.a aVar3);

    void onActivityCreated(u1.a aVar, Bundle bundle, long j10);

    void onActivityCreatedByScionActivityInfo(zzeb zzebVar, Bundle bundle, long j10);

    void onActivityDestroyed(u1.a aVar, long j10);

    void onActivityDestroyedByScionActivityInfo(zzeb zzebVar, long j10);

    void onActivityPaused(u1.a aVar, long j10);

    void onActivityPausedByScionActivityInfo(zzeb zzebVar, long j10);

    void onActivityResumed(u1.a aVar, long j10);

    void onActivityResumedByScionActivityInfo(zzeb zzebVar, long j10);

    void onActivitySaveInstanceState(u1.a aVar, u2 u2Var, long j10);

    void onActivitySaveInstanceStateByScionActivityInfo(zzeb zzebVar, u2 u2Var, long j10);

    void onActivityStarted(u1.a aVar, long j10);

    void onActivityStartedByScionActivityInfo(zzeb zzebVar, long j10);

    void onActivityStopped(u1.a aVar, long j10);

    void onActivityStoppedByScionActivityInfo(zzeb zzebVar, long j10);

    void performAction(Bundle bundle, u2 u2Var, long j10);

    void registerOnMeasurementEventListener(z2 z2Var);

    void resetAnalyticsData(long j10);

    void retrieveAndUploadBatches(v2 v2Var);

    void setConditionalUserProperty(Bundle bundle, long j10);

    void setConsent(Bundle bundle, long j10);

    void setConsentThirdParty(Bundle bundle, long j10);

    void setCurrentScreen(u1.a aVar, String str, String str2, long j10);

    void setCurrentScreenByScionActivityInfo(zzeb zzebVar, String str, String str2, long j10);

    void setDataCollectionEnabled(boolean z10);

    void setDefaultEventParameters(Bundle bundle);

    void setEventInterceptor(z2 z2Var);

    void setInstanceIdProvider(a3 a3Var);

    void setMeasurementEnabled(boolean z10, long j10);

    void setMinimumSessionDuration(long j10);

    void setSessionTimeoutDuration(long j10);

    void setSgtmDebugInfo(Intent intent);

    void setUserId(String str, long j10);

    void setUserProperty(String str, String str2, u1.a aVar, boolean z10, long j10);

    void unregisterOnMeasurementEventListener(z2 z2Var);
}
