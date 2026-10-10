package org.apache.log4j.pattern;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.Date;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class IntegerPatternConverter extends PatternConverter {
    private static final IntegerPatternConverter INSTANCE = new IntegerPatternConverter();

    private IntegerPatternConverter() {
        super("Integer", TypedValues.Custom.S_INT);
    }

    public static IntegerPatternConverter newInstance(String[] strArr) {
        return INSTANCE;
    }

    @Override // org.apache.log4j.pattern.PatternConverter
    public void format(Object obj, StringBuffer stringBuffer) {
        if (obj instanceof Integer) {
            stringBuffer.append(obj.toString());
        }
        if (obj instanceof Date) {
            stringBuffer.append(Long.toString(((Date) obj).getTime()));
        }
    }
}
