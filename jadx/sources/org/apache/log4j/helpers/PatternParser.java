package org.apache.log4j.helpers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import org.apache.log4j.Layout;
import org.apache.log4j.spi.LocationInfo;
import org.apache.log4j.spi.LoggingEvent;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class PatternParser {
    static final int CLASS_LOCATION_CONVERTER = 1002;
    private static final int CONVERTER_STATE = 1;
    private static final int DOT_STATE = 3;
    private static final char ESCAPE_CHAR = '%';
    static final int FILE_LOCATION_CONVERTER = 1004;
    static final int FULL_LOCATION_CONVERTER = 1000;
    static final int LEVEL_CONVERTER = 2002;
    static final int LINE_LOCATION_CONVERTER = 1003;
    private static final int LITERAL_STATE = 0;
    private static final int MAX_STATE = 5;
    static final int MESSAGE_CONVERTER = 2004;
    static final int METHOD_LOCATION_CONVERTER = 1001;
    private static final int MIN_STATE = 4;
    static final int NDC_CONVERTER = 2003;
    static final int RELATIVE_TIME_CONVERTER = 2000;
    static final int THREAD_CONVERTER = 2001;
    static /* synthetic */ Class class$java$text$DateFormat;
    PatternConverter head;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected int f17066i;
    protected String pattern;
    protected int patternLength;
    PatternConverter tail;
    protected StringBuffer currentLiteral = new StringBuffer(32);
    protected FormattingInfo formattingInfo = new FormattingInfo();
    int state = 0;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class BasicPatternConverter extends PatternConverter {
        int type;

        @Override // org.apache.log4j.helpers.PatternConverter
        public String convert(LoggingEvent loggingEvent) {
            switch (this.type) {
                case PatternParser.RELATIVE_TIME_CONVERTER /* 2000 */:
                    return Long.toString(loggingEvent.timeStamp - LoggingEvent.getStartTime());
                case PatternParser.THREAD_CONVERTER /* 2001 */:
                    return loggingEvent.getThreadName();
                case PatternParser.LEVEL_CONVERTER /* 2002 */:
                    return loggingEvent.getLevel().toString();
                case PatternParser.NDC_CONVERTER /* 2003 */:
                    return loggingEvent.getNDC();
                case PatternParser.MESSAGE_CONVERTER /* 2004 */:
                    return loggingEvent.getRenderedMessage();
                default:
                    return null;
            }
        }

        BasicPatternConverter(FormattingInfo formattingInfo, int i10) {
            super(formattingInfo);
            this.type = i10;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private class CategoryPatternConverter extends NamedPatternConverter {
        CategoryPatternConverter(FormattingInfo formattingInfo, int i10) {
            super(formattingInfo, i10);
        }

        @Override // org.apache.log4j.helpers.PatternParser.NamedPatternConverter
        String getFullyQualifiedName(LoggingEvent loggingEvent) {
            return loggingEvent.getLoggerName();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private class ClassNamePatternConverter extends NamedPatternConverter {
        ClassNamePatternConverter(FormattingInfo formattingInfo, int i10) {
            super(formattingInfo, i10);
        }

        @Override // org.apache.log4j.helpers.PatternParser.NamedPatternConverter
        String getFullyQualifiedName(LoggingEvent loggingEvent) {
            return loggingEvent.getLocationInformation().getClassName();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class DatePatternConverter extends PatternConverter {
        private Date date;

        /* JADX INFO: renamed from: df, reason: collision with root package name */
        private DateFormat f17067df;

        @Override // org.apache.log4j.helpers.PatternConverter
        public String convert(LoggingEvent loggingEvent) {
            this.date.setTime(loggingEvent.timeStamp);
            try {
                return this.f17067df.format(this.date);
            } catch (Exception e10) {
                LogLog.error("Error occured while converting date.", e10);
                return null;
            }
        }

        DatePatternConverter(FormattingInfo formattingInfo, DateFormat dateFormat) {
            super(formattingInfo);
            this.date = new Date();
            this.f17067df = dateFormat;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class LiteralPatternConverter extends PatternConverter {
        private String literal;

        @Override // org.apache.log4j.helpers.PatternConverter
        public String convert(LoggingEvent loggingEvent) {
            return this.literal;
        }

        @Override // org.apache.log4j.helpers.PatternConverter
        public final void format(StringBuffer stringBuffer, LoggingEvent loggingEvent) {
            stringBuffer.append(this.literal);
        }

        LiteralPatternConverter(String str) {
            this.literal = str;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private class LocationPatternConverter extends PatternConverter {
        int type;

        LocationPatternConverter(FormattingInfo formattingInfo, int i10) {
            super(formattingInfo);
            this.type = i10;
        }

        @Override // org.apache.log4j.helpers.PatternConverter
        public String convert(LoggingEvent loggingEvent) {
            LocationInfo locationInformation = loggingEvent.getLocationInformation();
            switch (this.type) {
                case 1000:
                    return locationInformation.fullInfo;
                case 1001:
                    return locationInformation.getMethodName();
                case 1002:
                default:
                    return null;
                case 1003:
                    return locationInformation.getLineNumber();
                case 1004:
                    return locationInformation.getFileName();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class MDCPatternConverter extends PatternConverter {
        private String key;

        @Override // org.apache.log4j.helpers.PatternConverter
        public String convert(LoggingEvent loggingEvent) {
            String str = this.key;
            if (str != null) {
                Object mdc = loggingEvent.getMDC(str);
                if (mdc == null) {
                    return null;
                }
                return mdc.toString();
            }
            StringBuffer stringBuffer = new StringBuffer("{");
            Map properties = loggingEvent.getProperties();
            if (properties.size() > 0) {
                Object[] array = properties.keySet().toArray();
                Arrays.sort(array);
                for (int i10 = 0; i10 < array.length; i10++) {
                    stringBuffer.append('{');
                    stringBuffer.append(array[i10]);
                    stringBuffer.append(',');
                    stringBuffer.append(properties.get(array[i10]));
                    stringBuffer.append('}');
                }
            }
            stringBuffer.append('}');
            return stringBuffer.toString();
        }

        MDCPatternConverter(FormattingInfo formattingInfo, String str) {
            super(formattingInfo);
            this.key = str;
        }
    }

    public PatternConverter parse() throws Throwable {
        this.f17066i = 0;
        while (true) {
            int i10 = this.f17066i;
            if (i10 >= this.patternLength) {
                break;
            }
            String str = this.pattern;
            this.f17066i = i10 + 1;
            char cCharAt = str.charAt(i10);
            int i11 = this.state;
            if (i11 == 0) {
                int i12 = this.f17066i;
                if (i12 == this.patternLength) {
                    this.currentLiteral.append(cCharAt);
                } else if (cCharAt == '%') {
                    char cCharAt2 = this.pattern.charAt(i12);
                    if (cCharAt2 == '%') {
                        this.currentLiteral.append(cCharAt);
                        this.f17066i++;
                    } else if (cCharAt2 != 'n') {
                        if (this.currentLiteral.length() != 0) {
                            addToList(new LiteralPatternConverter(this.currentLiteral.toString()));
                        }
                        this.currentLiteral.setLength(0);
                        this.currentLiteral.append(cCharAt);
                        this.state = 1;
                        this.formattingInfo.reset();
                    } else {
                        this.currentLiteral.append(Layout.LINE_SEP);
                        this.f17066i++;
                    }
                } else {
                    this.currentLiteral.append(cCharAt);
                }
            } else if (i11 == 1) {
                this.currentLiteral.append(cCharAt);
                if (cCharAt == '-') {
                    this.formattingInfo.leftAlign = true;
                } else if (cCharAt == '.') {
                    this.state = 3;
                } else if (cCharAt < '0' || cCharAt > '9') {
                    finalizeConverter(cCharAt);
                } else {
                    this.formattingInfo.min = cCharAt - '0';
                    this.state = 4;
                }
            } else if (i11 == 3) {
                this.currentLiteral.append(cCharAt);
                if (cCharAt < '0' || cCharAt > '9') {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Error occured in position ");
                    stringBuffer.append(this.f17066i);
                    stringBuffer.append(".\n Was expecting digit, instead got char \"");
                    stringBuffer.append(cCharAt);
                    stringBuffer.append("\".");
                    LogLog.error(stringBuffer.toString());
                    this.state = 0;
                } else {
                    this.formattingInfo.max = cCharAt - '0';
                    this.state = 5;
                }
            } else if (i11 == 4) {
                this.currentLiteral.append(cCharAt);
                if (cCharAt >= '0' && cCharAt <= '9') {
                    FormattingInfo formattingInfo = this.formattingInfo;
                    formattingInfo.min = (formattingInfo.min * 10) + (cCharAt - '0');
                } else if (cCharAt == '.') {
                    this.state = 3;
                } else {
                    finalizeConverter(cCharAt);
                }
            } else if (i11 == 5) {
                this.currentLiteral.append(cCharAt);
                if (cCharAt < '0' || cCharAt > '9') {
                    finalizeConverter(cCharAt);
                    this.state = 0;
                } else {
                    FormattingInfo formattingInfo2 = this.formattingInfo;
                    formattingInfo2.max = (formattingInfo2.max * 10) + (cCharAt - '0');
                }
            }
        }
        if (this.currentLiteral.length() != 0) {
            addToList(new LiteralPatternConverter(this.currentLiteral.toString()));
        }
        return this.head;
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static abstract class NamedPatternConverter extends PatternConverter {
        int precision;

        abstract String getFullyQualifiedName(LoggingEvent loggingEvent);

        NamedPatternConverter(FormattingInfo formattingInfo, int i10) {
            super(formattingInfo);
            this.precision = i10;
        }

        @Override // org.apache.log4j.helpers.PatternConverter
        public String convert(LoggingEvent loggingEvent) {
            String fullyQualifiedName = getFullyQualifiedName(loggingEvent);
            if (this.precision <= 0) {
                return fullyQualifiedName;
            }
            int length = fullyQualifiedName.length();
            int iLastIndexOf = length - 1;
            for (int i10 = this.precision; i10 > 0; i10--) {
                iLastIndexOf = fullyQualifiedName.lastIndexOf(46, iLastIndexOf - 1);
                if (iLastIndexOf == -1) {
                    return fullyQualifiedName;
                }
            }
            return fullyQualifiedName.substring(iLastIndexOf + 1, length);
        }
    }

    private void addToList(PatternConverter patternConverter) {
        if (this.head == null) {
            this.tail = patternConverter;
            this.head = patternConverter;
        } else {
            this.tail.next = patternConverter;
            this.tail = patternConverter;
        }
    }

    protected void addConverter(PatternConverter patternConverter) {
        this.currentLiteral.setLength(0);
        addToList(patternConverter);
        this.state = 0;
        this.formattingInfo.reset();
    }

    protected String extractOption() {
        int iIndexOf;
        int i10;
        int i11 = this.f17066i;
        if (i11 >= this.patternLength || this.pattern.charAt(i11) != '{' || (iIndexOf = this.pattern.indexOf(125, this.f17066i)) <= (i10 = this.f17066i)) {
            return null;
        }
        String strSubstring = this.pattern.substring(i10 + 1, iIndexOf);
        this.f17066i = iIndexOf + 1;
        return strSubstring;
    }

    protected void finalizeConverter(char c10) throws Throwable {
        PatternConverter classNamePatternConverter;
        PatternConverter mDCPatternConverter;
        DateFormat simpleDateFormat;
        if (c10 == 'C') {
            classNamePatternConverter = new ClassNamePatternConverter(this.formattingInfo, extractPrecisionOption());
            this.currentLiteral.setLength(0);
        } else if (c10 != 'F') {
            if (c10 == 'X') {
                mDCPatternConverter = new MDCPatternConverter(this.formattingInfo, extractOption());
                this.currentLiteral.setLength(0);
            } else if (c10 == 'p') {
                classNamePatternConverter = new BasicPatternConverter(this.formattingInfo, LEVEL_CONVERTER);
                this.currentLiteral.setLength(0);
            } else if (c10 == 'r') {
                classNamePatternConverter = new BasicPatternConverter(this.formattingInfo, RELATIVE_TIME_CONVERTER);
                this.currentLiteral.setLength(0);
            } else if (c10 == 't') {
                classNamePatternConverter = new BasicPatternConverter(this.formattingInfo, THREAD_CONVERTER);
                this.currentLiteral.setLength(0);
            } else if (c10 == 'x') {
                classNamePatternConverter = new BasicPatternConverter(this.formattingInfo, NDC_CONVERTER);
                this.currentLiteral.setLength(0);
            } else if (c10 == 'L') {
                classNamePatternConverter = new LocationPatternConverter(this.formattingInfo, 1003);
                this.currentLiteral.setLength(0);
            } else if (c10 == 'M') {
                classNamePatternConverter = new LocationPatternConverter(this.formattingInfo, 1001);
                this.currentLiteral.setLength(0);
            } else if (c10 == 'c') {
                classNamePatternConverter = new CategoryPatternConverter(this.formattingInfo, extractPrecisionOption());
                this.currentLiteral.setLength(0);
            } else if (c10 == 'd') {
                String strExtractOption = extractOption();
                if (strExtractOption == null) {
                    strExtractOption = AbsoluteTimeDateFormat.ISO8601_DATE_FORMAT;
                }
                if (strExtractOption.equalsIgnoreCase(AbsoluteTimeDateFormat.ISO8601_DATE_FORMAT)) {
                    simpleDateFormat = new ISO8601DateFormat();
                } else if (strExtractOption.equalsIgnoreCase(AbsoluteTimeDateFormat.ABS_TIME_DATE_FORMAT)) {
                    simpleDateFormat = new AbsoluteTimeDateFormat();
                } else if (strExtractOption.equalsIgnoreCase(AbsoluteTimeDateFormat.DATE_AND_TIME_DATE_FORMAT)) {
                    simpleDateFormat = new DateTimeDateFormat();
                } else {
                    try {
                        simpleDateFormat = new SimpleDateFormat(strExtractOption);
                    } catch (IllegalArgumentException e10) {
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("Could not instantiate SimpleDateFormat with ");
                        stringBuffer.append(strExtractOption);
                        LogLog.error(stringBuffer.toString(), e10);
                        Class clsClass$ = class$java$text$DateFormat;
                        if (clsClass$ == null) {
                            clsClass$ = class$("java.text.DateFormat");
                            class$java$text$DateFormat = clsClass$;
                        }
                        simpleDateFormat = (DateFormat) OptionConverter.instantiateByClassName("org.apache.log4j.helpers.ISO8601DateFormat", clsClass$, null);
                    }
                }
                mDCPatternConverter = new DatePatternConverter(this.formattingInfo, simpleDateFormat);
                this.currentLiteral.setLength(0);
            } else if (c10 == 'l') {
                classNamePatternConverter = new LocationPatternConverter(this.formattingInfo, 1000);
                this.currentLiteral.setLength(0);
            } else if (c10 != 'm') {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("Unexpected char [");
                stringBuffer2.append(c10);
                stringBuffer2.append("] at position ");
                stringBuffer2.append(this.f17066i);
                stringBuffer2.append(" in conversion patterrn.");
                LogLog.error(stringBuffer2.toString());
                classNamePatternConverter = new LiteralPatternConverter(this.currentLiteral.toString());
                this.currentLiteral.setLength(0);
            } else {
                classNamePatternConverter = new BasicPatternConverter(this.formattingInfo, MESSAGE_CONVERTER);
                this.currentLiteral.setLength(0);
            }
            classNamePatternConverter = mDCPatternConverter;
        } else {
            classNamePatternConverter = new LocationPatternConverter(this.formattingInfo, 1004);
            this.currentLiteral.setLength(0);
        }
        addConverter(classNamePatternConverter);
    }

    public PatternParser(String str) {
        this.pattern = str;
        this.patternLength = str.length();
    }

    static /* synthetic */ Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e10) {
            throw new NoClassDefFoundError().initCause(e10);
        }
    }

    protected int extractPrecisionOption() {
        NumberFormatException e10;
        int i10;
        String strExtractOption = extractOption();
        if (strExtractOption == null) {
            return 0;
        }
        try {
            i10 = Integer.parseInt(strExtractOption);
            if (i10 <= 0) {
                try {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Precision option (");
                    stringBuffer.append(strExtractOption);
                    stringBuffer.append(") isn't a positive integer.");
                    LogLog.error(stringBuffer.toString());
                    return 0;
                } catch (NumberFormatException e11) {
                    e10 = e11;
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append("Category option \"");
                    stringBuffer2.append(strExtractOption);
                    stringBuffer2.append("\" not a decimal integer.");
                    LogLog.error(stringBuffer2.toString(), e10);
                    return i10;
                }
            }
            return i10;
        } catch (NumberFormatException e12) {
            e10 = e12;
            i10 = 0;
        }
    }
}
