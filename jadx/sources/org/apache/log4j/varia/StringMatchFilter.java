package org.apache.log4j.varia;

import org.apache.log4j.helpers.OptionConverter;
import org.apache.log4j.spi.Filter;
import org.apache.log4j.spi.LoggingEvent;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class StringMatchFilter extends Filter {
    public static final String ACCEPT_ON_MATCH_OPTION = "AcceptOnMatch";
    public static final String STRING_TO_MATCH_OPTION = "StringToMatch";
    boolean acceptOnMatch = true;
    String stringToMatch;

    public boolean getAcceptOnMatch() {
        return this.acceptOnMatch;
    }

    public String[] getOptionStrings() {
        return new String[]{STRING_TO_MATCH_OPTION, ACCEPT_ON_MATCH_OPTION};
    }

    public String getStringToMatch() {
        return this.stringToMatch;
    }

    public void setAcceptOnMatch(boolean z10) {
        this.acceptOnMatch = z10;
    }

    public void setOption(String str, String str2) {
        if (str.equalsIgnoreCase(STRING_TO_MATCH_OPTION)) {
            this.stringToMatch = str2;
        } else if (str.equalsIgnoreCase(ACCEPT_ON_MATCH_OPTION)) {
            this.acceptOnMatch = OptionConverter.toBoolean(str2, this.acceptOnMatch);
        }
    }

    public void setStringToMatch(String str) {
        this.stringToMatch = str;
    }

    @Override // org.apache.log4j.spi.Filter
    public int decide(LoggingEvent loggingEvent) {
        String str;
        String renderedMessage = loggingEvent.getRenderedMessage();
        if (renderedMessage == null || (str = this.stringToMatch) == null || renderedMessage.indexOf(str) == -1) {
            return 0;
        }
        if (!this.acceptOnMatch) {
            return -1;
        }
        return 1;
    }
}
