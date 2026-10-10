package org.apache.log4j.pattern;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class FileDatePatternConverter {
    public static PatternConverter newInstance(String[] strArr) {
        return (strArr == null || strArr.length == 0) ? DatePatternConverter.newInstance(new String[]{"yyyy-MM-dd"}) : DatePatternConverter.newInstance(strArr);
    }

    private FileDatePatternConverter() {
    }
}
