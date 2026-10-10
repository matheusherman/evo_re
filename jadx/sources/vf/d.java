package vf;

import androidx.core.location.LocationRequestCompat;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class d extends n6.a {
    public long loginSession;
    public int mediaPlayMode;
    public String route;
    public long session;
    public String streamId;
    public String playType = "";
    public int maxBlockSize = 0;
    public int minBlockSize = Integer.MAX_VALUE;
    public double avgBlockSize = 0.0d;
    public int maxResendCnt = Integer.MIN_VALUE;
    public int minResendCnt = Integer.MAX_VALUE;
    public double avgResendCnt = 0.0d;
    public int minResendRate = 100;
    public int maxResendRate = 0;
    public double avgResendRate = 0.0d;
    public int minAvgLossRate = 100;
    public int maxAvgLossRate = 0;
    public double avgAvgLossRate = 0.0d;
    public int minRTT = Integer.MAX_VALUE;
    public int maxRTT = Integer.MIN_VALUE;
    public double avgRTT = 0.0d;
    public long minTime = LocationRequestCompat.PASSIVE_INTERVAL;
    public long maxTime = 0;
    public double avgTime = 0.0d;
    public int blockCnt = 0;
    public Map<Integer, AtomicInteger> sizeDistributionMap = new HashMap();
    public Map<Integer, AtomicInteger> resendCntDistributionMap = new HashMap();
    public Map<Integer, AtomicInteger> resendRateDistributionMap = new HashMap();
    public Map<Integer, AtomicInteger> avgLossRateDistributionMap = new HashMap();
    public Map<Long, AtomicInteger> timeDistribution = new HashMap();

    public d(String str, String str2, long j10, long j11) {
        this.route = "";
        this.streamId = "";
        this.loginSession = 0L;
        this.session = 0L;
        this.route = str;
        this.streamId = str2;
        this.loginSession = j10;
        this.session = j11;
    }
}
