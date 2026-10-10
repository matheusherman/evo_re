package org.apache.log4j.pattern;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public abstract class NamePatternConverter extends LoggingEventPatternConverter {
    private final NameAbbreviator abbreviator;

    protected final void abbreviate(int i10, StringBuffer stringBuffer) {
        this.abbreviator.abbreviate(i10, stringBuffer);
    }

    protected NamePatternConverter(String str, String str2, String[] strArr) {
        super(str, str2);
        if (strArr != null && strArr.length > 0) {
            this.abbreviator = NameAbbreviator.getAbbreviator(strArr[0]);
        } else {
            this.abbreviator = NameAbbreviator.getDefaultAbbreviator();
        }
    }
}
