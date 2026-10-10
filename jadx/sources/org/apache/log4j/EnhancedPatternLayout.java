package org.apache.log4j;

import org.apache.log4j.helpers.OptionConverter;
import org.apache.log4j.helpers.PatternConverter;
import org.apache.log4j.helpers.PatternParser;
import org.apache.log4j.pattern.BridgePatternConverter;
import org.apache.log4j.pattern.BridgePatternParser;
import org.apache.log4j.spi.LoggingEvent;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class EnhancedPatternLayout extends Layout {
    public static final String DEFAULT_CONVERSION_PATTERN = "%m%n";
    public static final String PATTERN_RULE_REGISTRY = "PATTERN_RULE_REGISTRY";
    public static final String TTCC_CONVERSION_PATTERN = "%r [%t] %p %c %x - %m%n";
    protected final int BUF_SIZE;
    protected final int MAX_CAPACITY;
    private String conversionPattern;
    private boolean handlesExceptions;
    private PatternConverter head;

    public EnhancedPatternLayout() {
        this("%m%n");
    }

    public EnhancedPatternLayout(String str) throws Throwable {
        this.BUF_SIZE = 256;
        this.MAX_CAPACITY = 1024;
        this.conversionPattern = str;
        PatternConverter patternConverter = createPatternParser(str == null ? "%m%n" : str).parse();
        this.head = patternConverter;
        if (patternConverter instanceof BridgePatternConverter) {
            this.handlesExceptions = !((BridgePatternConverter) patternConverter).ignoresThrowable();
        } else {
            this.handlesExceptions = false;
        }
    }

    protected PatternParser createPatternParser(String str) {
        return new BridgePatternParser(str);
    }

    @Override // org.apache.log4j.Layout
    public String format(LoggingEvent loggingEvent) {
        StringBuffer stringBuffer = new StringBuffer();
        for (PatternConverter patternConverter = this.head; patternConverter != null; patternConverter = patternConverter.next) {
            patternConverter.format(stringBuffer, loggingEvent);
        }
        return stringBuffer.toString();
    }

    public String getConversionPattern() {
        return this.conversionPattern;
    }

    @Override // org.apache.log4j.Layout
    public boolean ignoresThrowable() {
        return !this.handlesExceptions;
    }

    public void setConversionPattern(String str) throws Throwable {
        String strConvertSpecialChars = OptionConverter.convertSpecialChars(str);
        this.conversionPattern = strConvertSpecialChars;
        PatternConverter patternConverter = createPatternParser(strConvertSpecialChars).parse();
        this.head = patternConverter;
        if (patternConverter instanceof BridgePatternConverter) {
            this.handlesExceptions = !((BridgePatternConverter) patternConverter).ignoresThrowable();
        } else {
            this.handlesExceptions = false;
        }
    }

    @Override // org.apache.log4j.spi.OptionHandler
    public void activateOptions() {
    }
}
