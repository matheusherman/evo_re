package org.apache.log4j;

import org.apache.log4j.helpers.PatternConverter;
import org.apache.log4j.helpers.PatternParser;
import org.apache.log4j.spi.LoggingEvent;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class PatternLayout extends Layout {
    public static final String DEFAULT_CONVERSION_PATTERN = "%m%n";
    public static final String TTCC_CONVERSION_PATTERN = "%r [%t] %p %c %x - %m%n";
    protected final int BUF_SIZE;
    protected final int MAX_CAPACITY;
    private PatternConverter head;
    private String pattern;
    private StringBuffer sbuf;

    public PatternLayout() {
        this("%m%n");
    }

    @Override // org.apache.log4j.Layout
    public boolean ignoresThrowable() {
        return true;
    }

    public PatternLayout(String str) {
        this.BUF_SIZE = 256;
        this.MAX_CAPACITY = 1024;
        this.sbuf = new StringBuffer(256);
        this.pattern = str;
        this.head = createPatternParser(str == null ? "%m%n" : str).parse();
    }

    protected PatternParser createPatternParser(String str) {
        return new PatternParser(str);
    }

    @Override // org.apache.log4j.Layout
    public String format(LoggingEvent loggingEvent) {
        if (this.sbuf.capacity() > 1024) {
            this.sbuf = new StringBuffer(256);
        } else {
            this.sbuf.setLength(0);
        }
        for (PatternConverter patternConverter = this.head; patternConverter != null; patternConverter = patternConverter.next) {
            patternConverter.format(this.sbuf, loggingEvent);
        }
        return this.sbuf.toString();
    }

    public String getConversionPattern() {
        return this.pattern;
    }

    public void setConversionPattern(String str) {
        this.pattern = str;
        this.head = createPatternParser(str).parse();
    }

    @Override // org.apache.log4j.spi.OptionHandler
    public void activateOptions() {
    }
}
