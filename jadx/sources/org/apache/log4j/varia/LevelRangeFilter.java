package org.apache.log4j.varia;

import org.apache.log4j.Level;
import org.apache.log4j.spi.Filter;
import org.apache.log4j.spi.LoggingEvent;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class LevelRangeFilter extends Filter {
    boolean acceptOnMatch = false;
    Level levelMax;
    Level levelMin;

    @Override // org.apache.log4j.spi.Filter
    public int decide(LoggingEvent loggingEvent) {
        if (this.levelMin != null && !loggingEvent.getLevel().isGreaterOrEqual(this.levelMin)) {
            return -1;
        }
        if (this.levelMax == null || loggingEvent.getLevel().toInt() <= this.levelMax.toInt()) {
            return this.acceptOnMatch ? 1 : 0;
        }
        return -1;
    }

    public boolean getAcceptOnMatch() {
        return this.acceptOnMatch;
    }

    public Level getLevelMax() {
        return this.levelMax;
    }

    public Level getLevelMin() {
        return this.levelMin;
    }

    public void setAcceptOnMatch(boolean z10) {
        this.acceptOnMatch = z10;
    }

    public void setLevelMax(Level level) {
        this.levelMax = level;
    }

    public void setLevelMin(Level level) {
        this.levelMin = level;
    }
}
