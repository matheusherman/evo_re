package org.apache.log4j.pattern;

import com.pengrad.telegrambot.model.chatbackground.BackgroundTypePattern;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.log4j.helpers.Loader;
import org.apache.log4j.helpers.LogLog;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class PatternParser {
    private static final int CONVERTER_STATE = 1;
    private static final int DOT_STATE = 3;
    private static final char ESCAPE_CHAR = '%';
    private static final Map FILENAME_PATTERN_RULES;
    private static final int LITERAL_STATE = 0;
    private static final int MAX_STATE = 5;
    private static final int MIN_STATE = 4;
    private static final Map PATTERN_LAYOUT_RULES;
    static /* synthetic */ Class class$org$apache$log4j$pattern$ClassNamePatternConverter;
    static /* synthetic */ Class class$org$apache$log4j$pattern$DatePatternConverter;
    static /* synthetic */ Class class$org$apache$log4j$pattern$FileDatePatternConverter;
    static /* synthetic */ Class class$org$apache$log4j$pattern$FileLocationPatternConverter;
    static /* synthetic */ Class class$org$apache$log4j$pattern$FullLocationPatternConverter;
    static /* synthetic */ Class class$org$apache$log4j$pattern$IntegerPatternConverter;
    static /* synthetic */ Class class$org$apache$log4j$pattern$LevelPatternConverter;
    static /* synthetic */ Class class$org$apache$log4j$pattern$LineLocationPatternConverter;
    static /* synthetic */ Class class$org$apache$log4j$pattern$LineSeparatorPatternConverter;
    static /* synthetic */ Class class$org$apache$log4j$pattern$LoggerPatternConverter;
    static /* synthetic */ Class class$org$apache$log4j$pattern$MessagePatternConverter;
    static /* synthetic */ Class class$org$apache$log4j$pattern$MethodLocationPatternConverter;
    static /* synthetic */ Class class$org$apache$log4j$pattern$NDCPatternConverter;
    static /* synthetic */ Class class$org$apache$log4j$pattern$PropertiesPatternConverter;
    static /* synthetic */ Class class$org$apache$log4j$pattern$RelativeTimePatternConverter;
    static /* synthetic */ Class class$org$apache$log4j$pattern$SequenceNumberPatternConverter;
    static /* synthetic */ Class class$org$apache$log4j$pattern$ThreadPatternConverter;
    static /* synthetic */ Class class$org$apache$log4j$pattern$ThrowableInformationPatternConverter;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class ReadOnlyMap implements Map {
        private final Map map;

        @Override // java.util.Map
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public boolean containsKey(Object obj) {
            return this.map.containsKey(obj);
        }

        @Override // java.util.Map
        public boolean containsValue(Object obj) {
            return this.map.containsValue(obj);
        }

        @Override // java.util.Map
        public Set entrySet() {
            return this.map.entrySet();
        }

        @Override // java.util.Map
        public Object get(Object obj) {
            return this.map.get(obj);
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return this.map.isEmpty();
        }

        @Override // java.util.Map
        public Set keySet() {
            return this.map.keySet();
        }

        @Override // java.util.Map
        public Object put(Object obj, Object obj2) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public void putAll(Map map) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public Object remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public int size() {
            return this.map.size();
        }

        @Override // java.util.Map
        public Collection values() {
            return this.map.values();
        }

        public ReadOnlyMap(Map map) {
            this.map = map;
        }
    }

    private static int extractConverter(char c10, String str, int i10, StringBuffer stringBuffer, StringBuffer stringBuffer2) {
        stringBuffer.setLength(0);
        if (!Character.isUnicodeIdentifierStart(c10)) {
            return i10;
        }
        stringBuffer.append(c10);
        while (i10 < str.length() && Character.isUnicodeIdentifierPart(str.charAt(i10))) {
            stringBuffer.append(str.charAt(i10));
            stringBuffer2.append(str.charAt(i10));
            i10++;
        }
        return i10;
    }

    static {
        HashMap map = new HashMap(17);
        Class clsClass$ = class$org$apache$log4j$pattern$LoggerPatternConverter;
        if (clsClass$ == null) {
            clsClass$ = class$("org.apache.log4j.pattern.LoggerPatternConverter");
            class$org$apache$log4j$pattern$LoggerPatternConverter = clsClass$;
        }
        map.put("c", clsClass$);
        Class clsClass$2 = class$org$apache$log4j$pattern$LoggerPatternConverter;
        if (clsClass$2 == null) {
            clsClass$2 = class$("org.apache.log4j.pattern.LoggerPatternConverter");
            class$org$apache$log4j$pattern$LoggerPatternConverter = clsClass$2;
        }
        map.put("logger", clsClass$2);
        Class clsClass$3 = class$org$apache$log4j$pattern$ClassNamePatternConverter;
        if (clsClass$3 == null) {
            clsClass$3 = class$("org.apache.log4j.pattern.ClassNamePatternConverter");
            class$org$apache$log4j$pattern$ClassNamePatternConverter = clsClass$3;
        }
        map.put("C", clsClass$3);
        Class clsClass$4 = class$org$apache$log4j$pattern$ClassNamePatternConverter;
        if (clsClass$4 == null) {
            clsClass$4 = class$("org.apache.log4j.pattern.ClassNamePatternConverter");
            class$org$apache$log4j$pattern$ClassNamePatternConverter = clsClass$4;
        }
        map.put("class", clsClass$4);
        Class clsClass$5 = class$org$apache$log4j$pattern$DatePatternConverter;
        if (clsClass$5 == null) {
            clsClass$5 = class$("org.apache.log4j.pattern.DatePatternConverter");
            class$org$apache$log4j$pattern$DatePatternConverter = clsClass$5;
        }
        map.put("d", clsClass$5);
        Class clsClass$6 = class$org$apache$log4j$pattern$DatePatternConverter;
        if (clsClass$6 == null) {
            clsClass$6 = class$("org.apache.log4j.pattern.DatePatternConverter");
            class$org$apache$log4j$pattern$DatePatternConverter = clsClass$6;
        }
        map.put("date", clsClass$6);
        Class clsClass$7 = class$org$apache$log4j$pattern$FileLocationPatternConverter;
        if (clsClass$7 == null) {
            clsClass$7 = class$("org.apache.log4j.pattern.FileLocationPatternConverter");
            class$org$apache$log4j$pattern$FileLocationPatternConverter = clsClass$7;
        }
        map.put("F", clsClass$7);
        Class clsClass$8 = class$org$apache$log4j$pattern$FileLocationPatternConverter;
        if (clsClass$8 == null) {
            clsClass$8 = class$("org.apache.log4j.pattern.FileLocationPatternConverter");
            class$org$apache$log4j$pattern$FileLocationPatternConverter = clsClass$8;
        }
        map.put("file", clsClass$8);
        Class clsClass$9 = class$org$apache$log4j$pattern$FullLocationPatternConverter;
        if (clsClass$9 == null) {
            clsClass$9 = class$("org.apache.log4j.pattern.FullLocationPatternConverter");
            class$org$apache$log4j$pattern$FullLocationPatternConverter = clsClass$9;
        }
        map.put("l", clsClass$9);
        Class clsClass$10 = class$org$apache$log4j$pattern$LineLocationPatternConverter;
        if (clsClass$10 == null) {
            clsClass$10 = class$("org.apache.log4j.pattern.LineLocationPatternConverter");
            class$org$apache$log4j$pattern$LineLocationPatternConverter = clsClass$10;
        }
        map.put("L", clsClass$10);
        Class clsClass$11 = class$org$apache$log4j$pattern$LineLocationPatternConverter;
        if (clsClass$11 == null) {
            clsClass$11 = class$("org.apache.log4j.pattern.LineLocationPatternConverter");
            class$org$apache$log4j$pattern$LineLocationPatternConverter = clsClass$11;
        }
        map.put("line", clsClass$11);
        Class clsClass$12 = class$org$apache$log4j$pattern$MessagePatternConverter;
        if (clsClass$12 == null) {
            clsClass$12 = class$("org.apache.log4j.pattern.MessagePatternConverter");
            class$org$apache$log4j$pattern$MessagePatternConverter = clsClass$12;
        }
        map.put("m", clsClass$12);
        Class clsClass$13 = class$org$apache$log4j$pattern$MessagePatternConverter;
        if (clsClass$13 == null) {
            clsClass$13 = class$("org.apache.log4j.pattern.MessagePatternConverter");
            class$org$apache$log4j$pattern$MessagePatternConverter = clsClass$13;
        }
        map.put("message", clsClass$13);
        Class clsClass$14 = class$org$apache$log4j$pattern$LineSeparatorPatternConverter;
        if (clsClass$14 == null) {
            clsClass$14 = class$("org.apache.log4j.pattern.LineSeparatorPatternConverter");
            class$org$apache$log4j$pattern$LineSeparatorPatternConverter = clsClass$14;
        }
        map.put("n", clsClass$14);
        Class clsClass$15 = class$org$apache$log4j$pattern$MethodLocationPatternConverter;
        if (clsClass$15 == null) {
            clsClass$15 = class$("org.apache.log4j.pattern.MethodLocationPatternConverter");
            class$org$apache$log4j$pattern$MethodLocationPatternConverter = clsClass$15;
        }
        map.put("M", clsClass$15);
        Class clsClass$16 = class$org$apache$log4j$pattern$MethodLocationPatternConverter;
        if (clsClass$16 == null) {
            clsClass$16 = class$("org.apache.log4j.pattern.MethodLocationPatternConverter");
            class$org$apache$log4j$pattern$MethodLocationPatternConverter = clsClass$16;
        }
        map.put("method", clsClass$16);
        Class clsClass$17 = class$org$apache$log4j$pattern$LevelPatternConverter;
        if (clsClass$17 == null) {
            clsClass$17 = class$("org.apache.log4j.pattern.LevelPatternConverter");
            class$org$apache$log4j$pattern$LevelPatternConverter = clsClass$17;
        }
        map.put("p", clsClass$17);
        Class clsClass$18 = class$org$apache$log4j$pattern$LevelPatternConverter;
        if (clsClass$18 == null) {
            clsClass$18 = class$("org.apache.log4j.pattern.LevelPatternConverter");
            class$org$apache$log4j$pattern$LevelPatternConverter = clsClass$18;
        }
        map.put("level", clsClass$18);
        Class clsClass$19 = class$org$apache$log4j$pattern$RelativeTimePatternConverter;
        if (clsClass$19 == null) {
            clsClass$19 = class$("org.apache.log4j.pattern.RelativeTimePatternConverter");
            class$org$apache$log4j$pattern$RelativeTimePatternConverter = clsClass$19;
        }
        map.put("r", clsClass$19);
        Class clsClass$20 = class$org$apache$log4j$pattern$RelativeTimePatternConverter;
        if (clsClass$20 == null) {
            clsClass$20 = class$("org.apache.log4j.pattern.RelativeTimePatternConverter");
            class$org$apache$log4j$pattern$RelativeTimePatternConverter = clsClass$20;
        }
        map.put("relative", clsClass$20);
        Class clsClass$21 = class$org$apache$log4j$pattern$ThreadPatternConverter;
        if (clsClass$21 == null) {
            clsClass$21 = class$("org.apache.log4j.pattern.ThreadPatternConverter");
            class$org$apache$log4j$pattern$ThreadPatternConverter = clsClass$21;
        }
        map.put("t", clsClass$21);
        Class clsClass$22 = class$org$apache$log4j$pattern$ThreadPatternConverter;
        if (clsClass$22 == null) {
            clsClass$22 = class$("org.apache.log4j.pattern.ThreadPatternConverter");
            class$org$apache$log4j$pattern$ThreadPatternConverter = clsClass$22;
        }
        map.put("thread", clsClass$22);
        Class clsClass$23 = class$org$apache$log4j$pattern$NDCPatternConverter;
        if (clsClass$23 == null) {
            clsClass$23 = class$("org.apache.log4j.pattern.NDCPatternConverter");
            class$org$apache$log4j$pattern$NDCPatternConverter = clsClass$23;
        }
        map.put("x", clsClass$23);
        Class clsClass$24 = class$org$apache$log4j$pattern$NDCPatternConverter;
        if (clsClass$24 == null) {
            clsClass$24 = class$("org.apache.log4j.pattern.NDCPatternConverter");
            class$org$apache$log4j$pattern$NDCPatternConverter = clsClass$24;
        }
        map.put("ndc", clsClass$24);
        Class clsClass$25 = class$org$apache$log4j$pattern$PropertiesPatternConverter;
        if (clsClass$25 == null) {
            clsClass$25 = class$("org.apache.log4j.pattern.PropertiesPatternConverter");
            class$org$apache$log4j$pattern$PropertiesPatternConverter = clsClass$25;
        }
        map.put("X", clsClass$25);
        Class clsClass$26 = class$org$apache$log4j$pattern$PropertiesPatternConverter;
        if (clsClass$26 == null) {
            clsClass$26 = class$("org.apache.log4j.pattern.PropertiesPatternConverter");
            class$org$apache$log4j$pattern$PropertiesPatternConverter = clsClass$26;
        }
        map.put("properties", clsClass$26);
        Class clsClass$27 = class$org$apache$log4j$pattern$SequenceNumberPatternConverter;
        if (clsClass$27 == null) {
            clsClass$27 = class$("org.apache.log4j.pattern.SequenceNumberPatternConverter");
            class$org$apache$log4j$pattern$SequenceNumberPatternConverter = clsClass$27;
        }
        map.put("sn", clsClass$27);
        Class clsClass$28 = class$org$apache$log4j$pattern$SequenceNumberPatternConverter;
        if (clsClass$28 == null) {
            clsClass$28 = class$("org.apache.log4j.pattern.SequenceNumberPatternConverter");
            class$org$apache$log4j$pattern$SequenceNumberPatternConverter = clsClass$28;
        }
        map.put("sequenceNumber", clsClass$28);
        Class clsClass$29 = class$org$apache$log4j$pattern$ThrowableInformationPatternConverter;
        if (clsClass$29 == null) {
            clsClass$29 = class$("org.apache.log4j.pattern.ThrowableInformationPatternConverter");
            class$org$apache$log4j$pattern$ThrowableInformationPatternConverter = clsClass$29;
        }
        map.put("throwable", clsClass$29);
        PATTERN_LAYOUT_RULES = new ReadOnlyMap(map);
        HashMap map2 = new HashMap(4);
        Class clsClass$30 = class$org$apache$log4j$pattern$FileDatePatternConverter;
        if (clsClass$30 == null) {
            clsClass$30 = class$("org.apache.log4j.pattern.FileDatePatternConverter");
            class$org$apache$log4j$pattern$FileDatePatternConverter = clsClass$30;
        }
        map2.put("d", clsClass$30);
        Class clsClass$31 = class$org$apache$log4j$pattern$FileDatePatternConverter;
        if (clsClass$31 == null) {
            clsClass$31 = class$("org.apache.log4j.pattern.FileDatePatternConverter");
            class$org$apache$log4j$pattern$FileDatePatternConverter = clsClass$31;
        }
        map2.put("date", clsClass$31);
        Class clsClass$32 = class$org$apache$log4j$pattern$IntegerPatternConverter;
        if (clsClass$32 == null) {
            clsClass$32 = class$("org.apache.log4j.pattern.IntegerPatternConverter");
            class$org$apache$log4j$pattern$IntegerPatternConverter = clsClass$32;
        }
        map2.put("i", clsClass$32);
        Class clsClass$33 = class$org$apache$log4j$pattern$IntegerPatternConverter;
        if (clsClass$33 == null) {
            clsClass$33 = class$("org.apache.log4j.pattern.IntegerPatternConverter");
            class$org$apache$log4j$pattern$IntegerPatternConverter = clsClass$33;
        }
        map2.put("index", clsClass$33);
        FILENAME_PATTERN_RULES = new ReadOnlyMap(map2);
    }

    private static int finalizeConverter(char c10, String str, int i10, StringBuffer stringBuffer, FormattingInfo formattingInfo, Map map, Map map2, List list, List list2) {
        StringBuffer stringBuffer2;
        StringBuffer stringBuffer3 = new StringBuffer();
        int iExtractConverter = extractConverter(c10, str, i10, stringBuffer3, stringBuffer);
        String string = stringBuffer3.toString();
        ArrayList arrayList = new ArrayList();
        int iExtractOptions = extractOptions(str, iExtractConverter, arrayList);
        PatternConverter patternConverterCreateConverter = createConverter(string, stringBuffer, map, map2, arrayList);
        if (patternConverterCreateConverter == null) {
            if (string == null || string.length() == 0) {
                stringBuffer2 = new StringBuffer("Empty conversion specifier starting at position ");
            } else {
                stringBuffer2 = new StringBuffer("Unrecognized conversion specifier [");
                stringBuffer2.append(string);
                stringBuffer2.append("] starting at position ");
            }
            stringBuffer2.append(Integer.toString(iExtractOptions));
            stringBuffer2.append(" in conversion pattern.");
            LogLog.error(stringBuffer2.toString());
            list.add(new LiteralPatternConverter(stringBuffer.toString()));
            list2.add(FormattingInfo.getDefault());
        } else {
            list.add(patternConverterCreateConverter);
            list2.add(formattingInfo);
            if (stringBuffer.length() > 0) {
                list.add(new LiteralPatternConverter(stringBuffer.toString()));
                list2.add(FormattingInfo.getDefault());
            }
        }
        stringBuffer.setLength(0);
        return iExtractOptions;
    }

    public static Map getFileNamePatternRules() {
        return FILENAME_PATTERN_RULES;
    }

    public static Map getPatternLayoutRules() {
        return PATTERN_LAYOUT_RULES;
    }

    public static void parse(String str, List list, List list2, Map map, Map map2) {
        FormattingInfo formattingInfo;
        FormattingInfo formattingInfo2;
        if (str == null) {
            throw new NullPointerException(BackgroundTypePattern.TYPE);
        }
        StringBuffer stringBuffer = new StringBuffer(32);
        int length = str.length();
        FormattingInfo formattingInfo3 = FormattingInfo.getDefault();
        int iFinalizeConverter = 0;
        char c10 = 0;
        while (iFinalizeConverter < length) {
            iFinalizeConverter++;
            int i10 = iFinalizeConverter;
            char cCharAt = str.charAt(i10);
            if (c10 == 0) {
                iFinalizeConverter = iFinalizeConverter;
                formattingInfo3 = formattingInfo3;
                stringBuffer = stringBuffer;
                if (iFinalizeConverter == length) {
                    stringBuffer.append(cCharAt);
                } else if (cCharAt != '%') {
                    stringBuffer.append(cCharAt);
                } else if (str.charAt(iFinalizeConverter) != '%') {
                    if (stringBuffer.length() != 0) {
                        list.add(new LiteralPatternConverter(stringBuffer.toString()));
                        list2.add(FormattingInfo.getDefault());
                    }
                    stringBuffer.setLength(0);
                    stringBuffer.append(cCharAt);
                    formattingInfo3 = FormattingInfo.getDefault();
                    c10 = 1;
                } else {
                    stringBuffer.append(cCharAt);
                    iFinalizeConverter = i10 + 2;
                }
            } else if (c10 == 1) {
                stringBuffer.append(cCharAt);
                if (cCharAt == '-') {
                    iFinalizeConverter = iFinalizeConverter;
                    FormattingInfo formattingInfo4 = formattingInfo3;
                    stringBuffer = stringBuffer;
                    formattingInfo3 = new FormattingInfo(true, formattingInfo4.getMinLength(), formattingInfo4.getMaxLength());
                } else if (cCharAt == '.') {
                    iFinalizeConverter = iFinalizeConverter;
                    formattingInfo3 = formattingInfo3;
                    stringBuffer = stringBuffer;
                    c10 = 3;
                } else if (cCharAt < '0' || cCharAt > '9') {
                    iFinalizeConverter = finalizeConverter(cCharAt, str, iFinalizeConverter, stringBuffer, formattingInfo3, map, map2, list, list2);
                    stringBuffer = stringBuffer;
                    FormattingInfo formattingInfo5 = FormattingInfo.getDefault();
                    stringBuffer.setLength(0);
                    formattingInfo3 = formattingInfo5;
                    c10 = 0;
                } else {
                    formattingInfo3 = new FormattingInfo(formattingInfo3.isLeftAligned(), cCharAt - '0', formattingInfo3.getMaxLength());
                    iFinalizeConverter = iFinalizeConverter;
                    c10 = 4;
                }
            } else if (c10 == 3) {
                stringBuffer.append(cCharAt);
                if (cCharAt < '0' || cCharAt > '9') {
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append("Error occured in position ");
                    stringBuffer2.append(iFinalizeConverter);
                    stringBuffer2.append(".\n Was expecting digit, instead got char \"");
                    stringBuffer2.append(cCharAt);
                    stringBuffer2.append("\".");
                    LogLog.error(stringBuffer2.toString());
                    c10 = 0;
                } else {
                    formattingInfo3 = new FormattingInfo(formattingInfo3.isLeftAligned(), formattingInfo3.getMinLength(), cCharAt - '0');
                    iFinalizeConverter = iFinalizeConverter;
                    c10 = 5;
                }
            } else if (c10 == 4) {
                stringBuffer.append(cCharAt);
                if (cCharAt >= '0' && cCharAt <= '9') {
                    formattingInfo2 = new FormattingInfo(formattingInfo3.isLeftAligned(), (formattingInfo3.getMinLength() * 10) + (cCharAt - '0'), formattingInfo3.getMaxLength());
                    iFinalizeConverter = iFinalizeConverter;
                    formattingInfo3 = formattingInfo2;
                } else if (cCharAt == '.') {
                    c10 = 3;
                } else {
                    iFinalizeConverter = finalizeConverter(cCharAt, str, iFinalizeConverter, stringBuffer, formattingInfo3, map, map2, list, list2);
                    formattingInfo = FormattingInfo.getDefault();
                    stringBuffer.setLength(0);
                    formattingInfo3 = formattingInfo;
                    c10 = 0;
                }
            } else if (c10 == 5) {
                stringBuffer.append(cCharAt);
                if (cCharAt < '0' || cCharAt > '9') {
                    iFinalizeConverter = finalizeConverter(cCharAt, str, iFinalizeConverter, stringBuffer, formattingInfo3, map, map2, list, list2);
                    formattingInfo = FormattingInfo.getDefault();
                    stringBuffer.setLength(0);
                    formattingInfo3 = formattingInfo;
                    c10 = 0;
                } else {
                    formattingInfo2 = new FormattingInfo(formattingInfo3.isLeftAligned(), formattingInfo3.getMinLength(), (formattingInfo3.getMaxLength() * 10) + (cCharAt - '0'));
                    iFinalizeConverter = iFinalizeConverter;
                    formattingInfo3 = formattingInfo2;
                }
            }
            stringBuffer = stringBuffer;
            formattingInfo3 = formattingInfo3;
        }
        StringBuffer stringBuffer3 = stringBuffer;
        if (stringBuffer3.length() != 0) {
            list.add(new LiteralPatternConverter(stringBuffer3.toString()));
            list2.add(FormattingInfo.getDefault());
        }
    }

    private PatternParser() {
    }

    static /* synthetic */ Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e10) {
            throw new NoClassDefFoundError().initCause(e10);
        }
    }

    private static PatternConverter createConverter(String str, StringBuffer stringBuffer, Map map, Map map2, List list) {
        Class clsLoadClass;
        String strSubstring = str;
        Object obj = null;
        for (int length = str.length(); length > 0 && obj == null; length--) {
            strSubstring = strSubstring.substring(0, length);
            if (map != null) {
                obj = map.get(strSubstring);
            }
            if (obj == null && map2 != null) {
                obj = map2.get(strSubstring);
            }
        }
        if (obj == null) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Unrecognized format specifier [");
            stringBuffer2.append(str);
            stringBuffer2.append("]");
            LogLog.error(stringBuffer2.toString());
            return null;
        }
        if (obj instanceof Class) {
            clsLoadClass = (Class) obj;
        } else if (obj instanceof String) {
            try {
                clsLoadClass = Loader.loadClass((String) obj);
            } catch (ClassNotFoundException e10) {
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("Class for conversion pattern %");
                stringBuffer3.append(strSubstring);
                stringBuffer3.append(" not found");
                LogLog.warn(stringBuffer3.toString(), e10);
                return null;
            }
        } else {
            StringBuffer stringBuffer4 = new StringBuffer();
            stringBuffer4.append("Bad map entry for conversion pattern %");
            stringBuffer4.append(strSubstring);
            stringBuffer4.append(".");
            LogLog.warn(stringBuffer4.toString());
            return null;
        }
        try {
            Object objInvoke = clsLoadClass.getMethod("newInstance", String[].class).invoke(null, (String[]) list.toArray(new String[list.size()]));
            if (objInvoke instanceof PatternConverter) {
                stringBuffer.delete(0, stringBuffer.length() - (str.length() - strSubstring.length()));
                return (PatternConverter) objInvoke;
            }
            StringBuffer stringBuffer5 = new StringBuffer();
            stringBuffer5.append("Class ");
            stringBuffer5.append(clsLoadClass.getName());
            stringBuffer5.append(" does not extend PatternConverter.");
            LogLog.warn(stringBuffer5.toString());
            return null;
        } catch (Exception e11) {
            StringBuffer stringBuffer6 = new StringBuffer();
            stringBuffer6.append("Error creating converter for ");
            stringBuffer6.append(str);
            LogLog.error(stringBuffer6.toString(), e11);
            try {
                PatternConverter patternConverter = (PatternConverter) clsLoadClass.newInstance();
                stringBuffer.delete(0, stringBuffer.length() - (str.length() - strSubstring.length()));
                return patternConverter;
            } catch (Exception e12) {
                StringBuffer stringBuffer7 = new StringBuffer();
                stringBuffer7.append("Error creating converter for ");
                stringBuffer7.append(str);
                LogLog.error(stringBuffer7.toString(), e12);
            }
        }
    }

    private static int extractOptions(String str, int i10, List list) {
        int iIndexOf;
        while (i10 < str.length() && str.charAt(i10) == '{' && (iIndexOf = str.indexOf(125, i10)) != -1) {
            list.add(str.substring(i10 + 1, iIndexOf));
            i10 = iIndexOf + 1;
        }
        return i10;
    }
}
