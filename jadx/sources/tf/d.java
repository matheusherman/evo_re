package tf;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class d extends n6.a {
    private int errorCode;
    private int errorType;
    private int firstM3U8RequestCnt;
    private long firstM3U8ResponseToPlayer;
    private long firstM3u8RequestFromPlayer;
    private int firstTSBytes;
    private double firstTSDuration;
    private int firstTSIndex;
    private int firstTSRequestCnt;
    private long firstTSRequestFromPlayer;
    private long firstTSResponseToPlayer;
    private long lastTSRequestFromPlayer;
    private long lastTSResponseToPlayer;
    private long loginSession;
    private int mediaPlayMode;
    private long playUrlInjectIntoPlayer;
    private long playUrlReadyFromEngine;
    private int requestTSCntDuringPreparing;
    private int retryCnt;
    private int seq;
    private long session;
    private long start;
    private long stopEnginePlay;
    private long stopPlayer;
    public c monitorStat = null;
    private String player = "";
    private v6.c playType = v6.c.LIVE;
    private String channel = "";
    private String streamId = "";
    private String route = "";
    private String sessionFromPlayerRequest = "";
    private String error = "";
    private boolean isFirstTSFromLocalCache = false;
    private long playerPrepared = 0;
    private int minRTT = 0;
    private int avgRTT = 0;
    private int maxRTT = 0;
    private int lossRate = 0;
    private Map<String, Integer> streamMap = new HashMap();

    public long A() {
        return this.stopEnginePlay;
    }

    public long B() {
        return this.stopPlayer;
    }

    public Map<String, Integer> C() {
        return this.streamMap;
    }

    public boolean D() {
        return this.isFirstTSFromLocalCache;
    }

    public void E(String str) {
        this.error = str;
    }

    public void F(int i10) {
        this.errorCode = i10;
    }

    public void G(int i10) {
        this.errorType = i10;
    }

    public void H(int i10) {
        this.firstM3U8RequestCnt = i10;
    }

    public void I(long j10) {
        this.firstM3U8ResponseToPlayer = j10;
    }

    public void J(long j10) {
        this.firstM3u8RequestFromPlayer = j10;
    }

    public void K(int i10) {
        this.firstTSBytes = i10;
    }

    public void L(double d10) {
        this.firstTSDuration = d10;
    }

    public void M(boolean z10) {
        this.isFirstTSFromLocalCache = z10;
    }

    public void N(int i10) {
        this.firstTSIndex = i10;
    }

    public void O(int i10) {
        this.firstTSRequestCnt = i10;
    }

    public void P(long j10) {
        this.firstTSRequestFromPlayer = j10;
    }

    public void Q(long j10) {
        this.firstTSResponseToPlayer = j10;
    }

    public void R(long j10) {
        this.lastTSRequestFromPlayer = j10;
    }

    public void S(long j10) {
        this.lastTSResponseToPlayer = j10;
    }

    public void T(long j10) {
        this.loginSession = j10;
    }

    public void U(int i10) {
        this.mediaPlayMode = i10;
    }

    public void V(v6.c cVar) {
        this.playType = cVar;
    }

    public void W(long j10) {
        this.playUrlInjectIntoPlayer = j10;
    }

    public void X(long j10) {
        this.playUrlReadyFromEngine = j10;
    }

    public void Y(String str) {
        this.player = str;
    }

    public void Z(long j10) {
        this.playerPrepared = j10;
    }

    public void a0(int i10) {
        this.requestTSCntDuringPreparing = i10;
    }

    public void b0(int i10) {
        this.retryCnt = i10;
    }

    public String c() {
        return this.error;
    }

    public void c0(long j10) {
        this.session = j10;
    }

    public int d() {
        return this.errorCode;
    }

    public void d0(String str) {
        this.sessionFromPlayerRequest = str;
    }

    public int e() {
        return this.errorType;
    }

    public void e0(long j10) {
        this.stopEnginePlay = j10;
    }

    public int f() {
        return this.firstM3U8RequestCnt;
    }

    public void f0(long j10) {
        this.stopPlayer = j10;
    }

    public long g() {
        return this.firstM3U8ResponseToPlayer;
    }

    public String getChannel() {
        return this.channel;
    }

    public String getRoute() {
        return this.route;
    }

    public int getSeq() {
        return this.seq;
    }

    public long getStart() {
        return this.start;
    }

    public String getStreamId() {
        return this.streamId;
    }

    public long h() {
        return this.firstM3u8RequestFromPlayer;
    }

    public int i() {
        return this.firstTSBytes;
    }

    public double j() {
        return this.firstTSDuration;
    }

    public int k() {
        return this.firstTSIndex;
    }

    public int l() {
        return this.firstTSRequestCnt;
    }

    public long m() {
        return this.firstTSRequestFromPlayer;
    }

    public long n() {
        return this.firstTSResponseToPlayer;
    }

    public long o() {
        return this.lastTSRequestFromPlayer;
    }

    public long p() {
        return this.lastTSResponseToPlayer;
    }

    public long q() {
        return this.loginSession;
    }

    public int r() {
        return this.mediaPlayMode;
    }

    public v6.c s() {
        return this.playType;
    }

    public void setChannel(String str) {
        this.channel = str;
    }

    public void setRoute(String str) {
        this.route = str;
    }

    public void setSeq(int i10) {
        this.seq = i10;
    }

    public void setStart(long j10) {
        this.start = j10;
    }

    public void setStreamId(String str) {
        this.streamId = str;
    }

    public long t() {
        return this.playUrlInjectIntoPlayer;
    }

    public long u() {
        return this.playUrlReadyFromEngine;
    }

    public long v() {
        return this.playerPrepared;
    }

    public int w() {
        return this.requestTSCntDuringPreparing;
    }

    public int x() {
        return this.retryCnt;
    }

    public long y() {
        return this.session;
    }

    public String z() {
        return this.sessionFromPlayerRequest;
    }
}
