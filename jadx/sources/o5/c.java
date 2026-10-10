package o5;

import ac.g;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final q6.b f16457a = q6.c.d(c.class);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static List<String> f16458b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static List<Object> f16459c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String[] f16460d = {"^(\\+?55|0)\\-?[1-9]{2}\\-?[2-9]{1}\\d{3,4}\\-?\\d{4}$", "^(\\+?351)?9[1236]\\d{7}$", "^(\\+?213|0)(5|6|7)\\d{8}$", "^(!?(\\+?963)|0)?9\\d{8}$", "^(!?(\\+?966)|0)?5\\d{8}$", "^(\\+?1)?[2-9]\\d{2}[2-9](?!11)\\d{6}$", "^(\\+?0?86\\-?)?1[3456789]\\d{9}$", "^(\\+?420)? ?[1-9][0-9]{2} ?[0-9]{3} ?[0-9]{3}$", "^(\\+?49[ \\.\\-])?([\\(]{1}[0-9]{1,6}[\\)])?([0-9 \\.\\-\\/]{3,20})((x|ext|extension)[ ]?[0-9]{1,4})?$", "^(\\+?45)?(\\d{8})$", "^(\\+?30)?(69\\d{8})$", "^(\\+?61|0)4\\d{8}$", "^(\\+?44|0)7\\d{9}$", "^(\\+?852\\-?)?[569]\\d{3}\\-?\\d{4}$", "^(\\+?91|0)?[789]\\d{9}$", "^(\\+?64|0)2\\d{7,9}$", "^(\\+?27|0)\\d{9}$", "^(\\+?26)?09[567]\\d{7}$", "^(\\+?34)?(6\\d{1}|7[1234])\\d{7}$", "^(\\+?358|0)\\s?(4(0|1|2|4|5)?|50)\\s?(\\d\\s?){4,8}\\d$", "^(\\+?33|0)[67]\\d{8}$", "^(\\+972|0)([23489]|5[0248]|77)[1-9]\\d{6}$", "^(\\+?36)(20|30|70)\\d{7}$", "^(\\+?39)?\\s?3\\d{2} ?\\d{6,7}$", "^(\\+?81|0)\\d{1,4}[ \\-]?\\d{1,4}[ \\-]?\\d{4}$", "^(\\+?6?01){1}(([145]{1}(\\-|\\s)?\\d{7,8})|([236789]{1}(\\s|\\-)?\\d{7}))$", "^(\\+?47)?[49]\\d{7}$", "^(\\+?32|0)4?\\d{8}$", "^(\\+?47)?[49]\\d{7}$", "^(\\+?48)? ?[5-8]\\d ?\\d{3} ?\\d{2} ?\\d{2}$", "^(\\+?7|8)?9\\d{9}$", "^(\\+3816|06)[- \\d]{5,9}$", "^(\\+?90|0)?5\\d{9}$", "^(\\+?84|0)?((1(2([0-9])|6([2-9])|88|99))|(9((?!5)[0-9])))([0-9]{7})$", "^(\\+?886\\-?|0)?9\\d{8}$"};

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a extends ArrayList {
        a() {
            add("+55");
        }
    }

    public static boolean a(String str) {
        return str.contains("@") && str.contains(".") && !str.startsWith("@") && !str.endsWith("@");
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String strR = g.r(str);
        if (strR.indexOf("+") != 0) {
            return false;
        }
        return TextUtils.isDigitsOnly(strR.substring(1));
    }
}
