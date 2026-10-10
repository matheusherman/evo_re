package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.Arrays;
import kotlin.reflect.jvm.internal.impl.descriptors.h0;
import kotlin.reflect.jvm.internal.impl.types.o0;
import org.apache.log4j.spi.LocationInfo;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class e extends o<Character> {
    private final String c(char c10) {
        if (c10 == '\b') {
            return "\\b";
        }
        if (c10 == '\t') {
            return "\\t";
        }
        if (c10 == '\n') {
            return "\\n";
        }
        if (c10 == '\f') {
            return "\\f";
        }
        if (c10 == '\r') {
            return "\\r";
        }
        return e(c10) ? String.valueOf(c10) : LocationInfo.NA;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.g
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public o0 a(h0 module) {
        kotlin.jvm.internal.m.f(module, "module");
        o0 o0VarU = module.l().u();
        kotlin.jvm.internal.m.e(o0VarU, "module.builtIns.charType");
        return o0VarU;
    }

    public e(char c10) {
        super(Character.valueOf(c10));
    }

    private final boolean e(char c10) {
        byte type = (byte) Character.getType(c10);
        if (type != 0 && type != 13 && type != 14 && type != 15 && type != 16 && type != 18 && type != 19) {
            return true;
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.g
    public String toString() {
        String str = String.format("\\u%04X ('%s')", Arrays.copyOf(new Object[]{Integer.valueOf(b().charValue()), c(b().charValue())}, 2));
        kotlin.jvm.internal.m.e(str, "format(this, *args)");
        return str;
    }
}
