package z1.b1.lb.m.extra.marquee;

import androidx.annotation.Keep;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import n6.a;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class MarqueeInfo extends a {
    private String content;
    private int displayInterval;
    private int displayTimes;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private long f22611id;
    private String lang;
    private Map<String, String> properties = new HashMap();
    private int seq;
    private long updateTime;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MarqueeInfo) {
            MarqueeInfo marqueeInfo = (MarqueeInfo) obj;
            if (getId() == marqueeInfo.getId() && getSeq() == marqueeInfo.getSeq() && getUpdateTime() == marqueeInfo.getUpdateTime() && getDisplayInterval() == marqueeInfo.getDisplayInterval() && getDisplayTimes() == marqueeInfo.getDisplayTimes() && Objects.equals(getLang(), marqueeInfo.getLang()) && Objects.equals(getContent(), marqueeInfo.getContent()) && Objects.equals(getProperties(), marqueeInfo.getProperties())) {
                return true;
            }
        }
        return false;
    }

    @Keep
    public String getContent() {
        return this.content;
    }

    @Keep
    public int getDisplayInterval() {
        return this.displayInterval;
    }

    @Keep
    public int getDisplayTimes() {
        return this.displayTimes;
    }

    @Keep
    public long getId() {
        return this.f22611id;
    }

    @Keep
    public String getLang() {
        return this.lang;
    }

    @Keep
    public Map<String, String> getProperties() {
        return this.properties;
    }

    @Keep
    public int getSeq() {
        return this.seq;
    }

    @Keep
    public long getUpdateTime() {
        return this.updateTime;
    }

    @Keep
    public void setContent(String str) {
        this.content = str;
    }

    @Keep
    public void setDisplayInterval(int i10) {
        this.displayInterval = i10;
    }

    @Keep
    public void setDisplayTimes(int i10) {
        this.displayTimes = i10;
    }

    @Keep
    public void setId(long j10) {
        this.f22611id = j10;
    }

    @Keep
    public void setLang(String str) {
        this.lang = str;
    }

    @Keep
    public void setProperties(Map<String, String> map) {
        this.properties = map;
    }

    @Keep
    public void setSeq(int i10) {
        this.seq = i10;
    }

    @Keep
    public void setUpdateTime(long j10) {
        this.updateTime = j10;
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(getId()), getLang(), Integer.valueOf(getSeq()), getContent(), Long.valueOf(getUpdateTime()), getProperties(), Integer.valueOf(getDisplayInterval()), Integer.valueOf(getDisplayTimes()));
    }
}
