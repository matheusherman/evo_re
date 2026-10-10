package org.apache.log4j.pattern;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public abstract class PatternConverter {
    private final String name;
    private final String style;

    public abstract void format(Object obj, StringBuffer stringBuffer);

    public final String getName() {
        return this.name;
    }

    public String getStyleClass(Object obj) {
        return this.style;
    }

    protected PatternConverter(String str, String str2) {
        this.name = str;
        this.style = str2;
    }
}
