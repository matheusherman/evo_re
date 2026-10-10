package org.apache.log4j.varia;

import org.apache.log4j.Level;
import org.apache.log4j.helpers.OptionConverter;
import org.apache.log4j.spi.Filter;
import org.apache.log4j.spi.LoggingEvent;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class LevelMatchFilter extends Filter {
    boolean acceptOnMatch = true;
    Level levelToMatch;

    public void setLevelToMatch(String str) {
        this.levelToMatch = OptionConverter.toLevel(str, null);
    }

    @Override // org.apache.log4j.spi.Filter
    public int decide(LoggingEvent loggingEvent) {
        Level level = this.levelToMatch;
        if (level != null && level.equals(loggingEvent.getLevel())) {
            return this.acceptOnMatch ? 1 : -1;
        }
        return 0;
    }

    public boolean getAcceptOnMatch() {
        return this.acceptOnMatch;
    }

    public String getLevelToMatch() {
        Level level = this.levelToMatch;
        if (level == null) {
            return null;
        }
        return level.toString();
    }

    public void setAcceptOnMatch(boolean z10) {
        this.acceptOnMatch = z10;
    }
}
