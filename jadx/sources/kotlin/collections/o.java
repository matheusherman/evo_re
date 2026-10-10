package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000ø\u0001\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0002\u0010\f\n\u0002\b\u0016\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u001f\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0012\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\u0017\n\u0002\u0010\n\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0013\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0018\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\t\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a*\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001c\u0010\b\u001a\u00020\u0003*\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0007H\u0086\u0002¢\u0006\u0004\b\b\u0010\t\u001a\u001c\u0010\f\u001a\u00020\u0003*\u00020\n2\u0006\u0010\u0002\u001a\u00020\u000bH\u0086\u0002¢\u0006\u0004\b\f\u0010\r\u001a\u001f\u0010\u000e\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u000e\u0010\u000f\u001a!\u0010\u0010\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0010\u0010\u000f\u001a)\u0010\u0000\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u0006\u0010\u0011\u001a\u00020\u0007¢\u0006\u0004\b\u0000\u0010\u0012\u001a\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u0007*\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0007¢\u0006\u0004\b\u0013\u0010\u0014\u001a'\u0010\u0015\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0019\u0010\u0017\u001a\u00020\u0007*\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0007¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0019\u0010\u0019\u001a\u00020\u0007*\u00020\n2\u0006\u0010\u0002\u001a\u00020\u000b¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u001f\u0010\u001b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u001b\u0010\u000f\u001a\u0019\u0010\u001c\u001a\u00020\u0007*\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0007¢\u0006\u0004\b\u001c\u0010\u0018\u001a\u001f\u0010\u001d\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u001d\u0010\u000f\u001a\u0011\u0010\u001e\u001a\u00020\u000b*\u00020\n¢\u0006\u0004\b\u001e\u0010\u001f\u001a!\u0010 \u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0004\b \u0010\u000f\u001a-\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\"\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u0006\u0010!\u001a\u00020\u0007¢\u0006\u0004\b#\u0010$\u001a+\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\"\"\b\b\u0000\u0010\u0000*\u00020%*\f\u0012\b\b\u0001\u0012\u0004\u0018\u00018\u00000\u0001¢\u0006\u0004\b&\u0010'\u001a?\u0010+\u001a\u00028\u0000\"\u0010\b\u0000\u0010)*\n\u0012\u0006\b\u0000\u0012\u00028\u00010(\"\b\b\u0001\u0010\u0000*\u00020%*\f\u0012\b\b\u0001\u0012\u0004\u0018\u00018\u00010\u00012\u0006\u0010*\u001a\u00028\u0000¢\u0006\u0004\b+\u0010,\u001a-\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00000\"\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u0006\u0010!\u001a\u00020\u0007¢\u0006\u0004\b-\u0010$\u001a#\u00101\u001a\u000200*\u00020\u00062\u0006\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u0007H\u0007¢\u0006\u0004\b1\u00102\u001a#\u00104\u001a\u000200*\u0002032\u0006\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u0007H\u0007¢\u0006\u0004\b4\u00105\u001a#\u00107\u001a\u000200*\u0002062\u0006\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u0007H\u0007¢\u0006\u0004\b7\u00108\u001aC\u0010<\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u001a\u0010;\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u000009j\n\u0012\u0006\b\u0000\u0012\u00028\u0000`:¢\u0006\u0004\b<\u0010=\u001aA\u0010>\u001a\b\u0012\u0004\u0012\u00028\u00000\"\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u001a\u0010;\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u000009j\n\u0012\u0006\b\u0000\u0012\u00028\u0000`:¢\u0006\u0004\b>\u0010?\u001a#\u0010@\u001a\u000200*\u00020\u00062\u0006\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u0007H\u0007¢\u0006\u0004\b@\u00102\u001a#\u0010A\u001a\u000200*\u0002032\u0006\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u0007H\u0007¢\u0006\u0004\bA\u00105\u001a#\u0010B\u001a\u000200*\u0002062\u0006\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u0007H\u0007¢\u0006\u0004\bB\u00108\u001a\u0019\u0010C\u001a\u00020\u0006*\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0001¢\u0006\u0004\bC\u0010D\u001a9\u0010E\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0010\b\u0001\u0010)*\n\u0012\u0006\b\u0000\u0012\u00028\u00000(*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u0006\u0010*\u001a\u00028\u0001¢\u0006\u0004\bE\u0010,\u001a+\u0010F\u001a\u00028\u0000\"\u0010\b\u0000\u0010)*\n\u0012\u0006\b\u0000\u0012\u00020\u00070(*\u00020\u00062\u0006\u0010*\u001a\u00028\u0000¢\u0006\u0004\bF\u0010G\u001a%\u0010H\u001a\b\u0012\u0004\u0012\u00028\u00000\"\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0004\bH\u0010'\u001a\u0017\u0010K\u001a\b\u0012\u0004\u0012\u00020J0\"*\u00020I¢\u0006\u0004\bK\u0010L\u001a\u0017\u0010O\u001a\b\u0012\u0004\u0012\u00020N0\"*\u00020M¢\u0006\u0004\bO\u0010P\u001a\u0017\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00070\"*\u00020\u0006¢\u0006\u0004\bQ\u0010R\u001a\u0017\u0010T\u001a\b\u0012\u0004\u0012\u00020S0\"*\u000203¢\u0006\u0004\bT\u0010U\u001a\u0017\u0010W\u001a\b\u0012\u0004\u0012\u00020V0\"*\u000206¢\u0006\u0004\bW\u0010X\u001a\u0017\u0010[\u001a\b\u0012\u0004\u0012\u00020Z0\"*\u00020Y¢\u0006\u0004\b[\u0010\\\u001a\u0017\u0010^\u001a\b\u0012\u0004\u0012\u00020\u00030\"*\u00020]¢\u0006\u0004\b^\u0010_\u001a\u0017\u0010`\u001a\b\u0012\u0004\u0012\u00020\u000b0\"*\u00020\n¢\u0006\u0004\b`\u0010a\u001a%\u0010c\u001a\b\u0012\u0004\u0012\u00028\u00000b\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0004\bc\u0010'\u001a\u0017\u0010d\u001a\b\u0012\u0004\u0012\u00020J0b*\u00020I¢\u0006\u0004\bd\u0010L\u001a\u0017\u0010e\u001a\b\u0012\u0004\u0012\u00020N0b*\u00020M¢\u0006\u0004\be\u0010P\u001a\u0017\u0010f\u001a\b\u0012\u0004\u0012\u00020\u00070b*\u00020\u0006¢\u0006\u0004\bf\u0010R\u001a\u0017\u0010g\u001a\b\u0012\u0004\u0012\u00020S0b*\u000203¢\u0006\u0004\bg\u0010U\u001a\u0017\u0010h\u001a\b\u0012\u0004\u0012\u00020V0b*\u000206¢\u0006\u0004\bh\u0010X\u001a\u0017\u0010i\u001a\b\u0012\u0004\u0012\u00020Z0b*\u00020Y¢\u0006\u0004\bi\u0010\\\u001a\u0017\u0010j\u001a\b\u0012\u0004\u0012\u00020\u00030b*\u00020]¢\u0006\u0004\bj\u0010_\u001a\u0017\u0010k\u001a\b\u0012\u0004\u0012\u00020\u000b0b*\u00020\n¢\u0006\u0004\bk\u0010a\u001a%\u0010m\u001a\b\u0012\u0004\u0012\u00028\u00000l\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0004\bm\u0010n\u001aE\u0010r\u001a\b\u0012\u0004\u0012\u00028\u00010\"\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010o*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u0012\u0010q\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010pH\u0086\bø\u0001\u0000¢\u0006\u0004\br\u0010s\u001a+\u0010v\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000u0t\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0004\bv\u0010w\u001a\u0017\u0010x\u001a\b\u0012\u0004\u0012\u00020\u00070\"*\u00020\u0006¢\u0006\u0004\bx\u0010R\u001a\u0017\u0010z\u001a\b\u0012\u0004\u0012\u00020\u00070y*\u00020\u0006¢\u0006\u0004\bz\u0010{\u001a\u0015\u0010|\u001a\u0004\u0018\u00010\u0007*\u00020\u0006H\u0007¢\u0006\u0004\b|\u0010}\u001a\u0015\u0010~\u001a\u0004\u0018\u00010\u0007*\u00020\u0006H\u0007¢\u0006\u0004\b~\u0010}\u001aN\u0010\u0081\u0001\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0080\u00010\"\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010o*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u000e\u0010\u007f\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00010\u0001H\u0086\u0004¢\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001\u001a\u0090\u0001\u0010\u008d\u0001\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u000f\b\u0001\u0010\u0085\u0001*\b0\u0083\u0001j\u0003`\u0084\u0001*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u0007\u0010\u0086\u0001\u001a\u00028\u00012\n\b\u0002\u0010\u0088\u0001\u001a\u00030\u0087\u00012\n\b\u0002\u0010\u0089\u0001\u001a\u00030\u0087\u00012\n\b\u0002\u0010\u008a\u0001\u001a\u00030\u0087\u00012\t\b\u0002\u0010\u008b\u0001\u001a\u00020\u00072\n\b\u0002\u0010\u008c\u0001\u001a\u00030\u0087\u00012\u0017\b\u0002\u0010q\u001a\u0011\u0012\u0004\u0012\u00028\u0000\u0012\u0005\u0012\u00030\u0087\u0001\u0018\u00010p¢\u0006\u0006\b\u008d\u0001\u0010\u008e\u0001\u001a\u0082\u0001\u0010\u008f\u0001\u001a\u00028\u0000\"\u000f\b\u0000\u0010\u0085\u0001*\b0\u0083\u0001j\u0003`\u0084\u0001*\u00020I2\u0007\u0010\u0086\u0001\u001a\u00028\u00002\n\b\u0002\u0010\u0088\u0001\u001a\u00030\u0087\u00012\n\b\u0002\u0010\u0089\u0001\u001a\u00030\u0087\u00012\n\b\u0002\u0010\u008a\u0001\u001a\u00030\u0087\u00012\t\b\u0002\u0010\u008b\u0001\u001a\u00020\u00072\n\b\u0002\u0010\u008c\u0001\u001a\u00030\u0087\u00012\u0017\b\u0002\u0010q\u001a\u0011\u0012\u0004\u0012\u00020J\u0012\u0005\u0012\u00030\u0087\u0001\u0018\u00010p¢\u0006\u0006\b\u008f\u0001\u0010\u0090\u0001\u001aw\u0010\u0092\u0001\u001a\u00030\u0091\u0001\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\n\b\u0002\u0010\u0088\u0001\u001a\u00030\u0087\u00012\n\b\u0002\u0010\u0089\u0001\u001a\u00030\u0087\u00012\n\b\u0002\u0010\u008a\u0001\u001a\u00030\u0087\u00012\t\b\u0002\u0010\u008b\u0001\u001a\u00020\u00072\n\b\u0002\u0010\u008c\u0001\u001a\u00030\u0087\u00012\u0017\b\u0002\u0010q\u001a\u0011\u0012\u0004\u0012\u00028\u0000\u0012\u0005\u0012\u00030\u0087\u0001\u0018\u00010p¢\u0006\u0006\b\u0092\u0001\u0010\u0093\u0001\u001ai\u0010\u0094\u0001\u001a\u00030\u0091\u0001*\u00020I2\n\b\u0002\u0010\u0088\u0001\u001a\u00030\u0087\u00012\n\b\u0002\u0010\u0089\u0001\u001a\u00030\u0087\u00012\n\b\u0002\u0010\u008a\u0001\u001a\u00030\u0087\u00012\t\b\u0002\u0010\u008b\u0001\u001a\u00020\u00072\n\b\u0002\u0010\u008c\u0001\u001a\u00030\u0087\u00012\u0017\b\u0002\u0010q\u001a\u0011\u0012\u0004\u0012\u00020J\u0012\u0005\u0012\u00030\u0087\u0001\u0018\u00010p¢\u0006\u0006\b\u0094\u0001\u0010\u0095\u0001\u001a'\u0010\u0096\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000t\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0005\b\u0096\u0001\u0010w\u001a)\u0010\u0098\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000\u0097\u0001\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0006\b\u0098\u0001\u0010\u0099\u0001\"%\u0010\u009b\u0001\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00018F¢\u0006\u0007\u001a\u0005\bo\u0010\u009a\u0001\"\u0018\u0010\u009b\u0001\u001a\u00020\u0007*\u00020\u00068F¢\u0006\b\u001a\u0006\b\u009c\u0001\u0010\u009d\u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u009e\u0001"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "element", "", "J", "([Ljava/lang/Object;Ljava/lang/Object;)Z", "", "", "I", "([II)Z", "", "", "H", "([CC)Z", "O", "([Ljava/lang/Object;)Ljava/lang/Object;", "P", "index", "([Ljava/lang/Object;I)Ljava/lang/Object;", ExifInterface.LATITUDE_SOUTH, "([II)Ljava/lang/Integer;", ExifInterface.LONGITUDE_WEST, "([Ljava/lang/Object;Ljava/lang/Object;)I", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "([II)I", "U", "([CC)I", "e0", "f0", "n0", "m0", "([C)C", "o0", "n", "", "L", "([Ljava/lang/Object;I)Ljava/util/List;", "", "M", "([Ljava/lang/Object;)Ljava/util/List;", "", "C", "destination", "N", "([Ljava/lang/Object;Ljava/util/Collection;)Ljava/util/Collection;", "u0", "fromIndex", "toIndex", "Lr8/z;", "k0", "([III)V", "", "l0", "([JII)V", "", "j0", "([FII)V", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "comparator", "s0", "([Ljava/lang/Object;Ljava/util/Comparator;)[Ljava/lang/Object;", "t0", "([Ljava/lang/Object;Ljava/util/Comparator;)Ljava/util/List;", "q0", "r0", "p0", "x0", "([Ljava/lang/Integer;)[I", "w0", "v0", "([ILjava/util/Collection;)Ljava/util/Collection;", "E0", "", "", "y0", "([B)Ljava/util/List;", "", "", "F0", "([S)Ljava/util/List;", "C0", "([I)Ljava/util/List;", "", "D0", "([J)Ljava/util/List;", "", "B0", "([F)Ljava/util/List;", "", "", "A0", "([D)Ljava/util/List;", "", "G0", "([Z)Ljava/util/List;", "z0", "([C)Ljava/util/List;", "", "N0", "H0", "O0", "L0", "M0", "K0", "J0", "P0", "I0", "", "R0", "([Ljava/lang/Object;)Ljava/util/Set;", "R", "Lkotlin/Function1;", "transform", "g0", "([Ljava/lang/Object;Lc9/l;)Ljava/util/List;", "", "Lkotlin/collections/h0;", "S0", "([Ljava/lang/Object;)Ljava/lang/Iterable;", "K", "", "Q0", "([I)Ljava/util/Set;", "h0", "([I)Ljava/lang/Integer;", "i0", TransactionPartnerType.OTHER, "Lr8/p;", "U0", "([Ljava/lang/Object;[Ljava/lang/Object;)Ljava/util/List;", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "buffer", "", "separator", "prefix", "postfix", "limit", "truncated", "Y", "([Ljava/lang/Object;Ljava/lang/Appendable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lc9/l;)Ljava/lang/Appendable;", "X", "([BLjava/lang/Appendable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lc9/l;)Ljava/lang/Appendable;", "", "b0", "([Ljava/lang/Object;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lc9/l;)Ljava/lang/String;", "a0", "([BLjava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lc9/l;)Ljava/lang/String;", "F", "Lta/h;", "G", "([Ljava/lang/Object;)Lta/h;", "([Ljava/lang/Object;)I", "lastIndex", "Q", "([I)I", "kotlin-stdlib"}, k = 5, mv = {2, 2, 0}, xi = 49, xs = "kotlin/collections/ArraysKt")
public class o extends m {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0010\u001c\n\u0002\u0010(\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"kotlin/collections/o$a", "", "", "iterator", "()Ljava/util/Iterator;", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a<T> implements Iterable<T>, d9.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object[] f12309a;

        public a(Object[] objArr) {
            this.f12309a = objArr;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return kotlin.jvm.internal.b.a(this.f12309a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"kotlin/collections/o$b", "Lta/h;", "", "iterator", "()Ljava/util/Iterator;", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b<T> implements ta.h<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object[] f12310a;

        public b(Object[] objArr) {
            this.f12310a = objArr;
        }

        @Override // ta.h
        public Iterator<T> iterator() {
            return kotlin.jvm.internal.b.a(this.f12310a);
        }
    }

    public static List<Double> A0(double[] dArr) {
        kotlin.jvm.internal.m.f(dArr, "<this>");
        int length = dArr.length;
        if (length != 0) {
            return length != 1 ? J0(dArr) : s.e(Double.valueOf(dArr[0]));
        }
        return t.l();
    }

    public static List<Float> B0(float[] fArr) {
        kotlin.jvm.internal.m.f(fArr, "<this>");
        int length = fArr.length;
        if (length != 0) {
            return length != 1 ? K0(fArr) : s.e(Float.valueOf(fArr[0]));
        }
        return t.l();
    }

    public static List<Integer> C0(int[] iArr) {
        kotlin.jvm.internal.m.f(iArr, "<this>");
        int length = iArr.length;
        if (length != 0) {
            return length != 1 ? L0(iArr) : s.e(Integer.valueOf(iArr[0]));
        }
        return t.l();
    }

    public static List<Long> D0(long[] jArr) {
        kotlin.jvm.internal.m.f(jArr, "<this>");
        int length = jArr.length;
        if (length != 0) {
            return length != 1 ? M0(jArr) : s.e(Long.valueOf(jArr[0]));
        }
        return t.l();
    }

    public static <T> List<T> E0(T[] tArr) {
        kotlin.jvm.internal.m.f(tArr, "<this>");
        int length = tArr.length;
        if (length != 0) {
            return length != 1 ? N0(tArr) : s.e(tArr[0]);
        }
        return t.l();
    }

    public static <T> Iterable<T> F(T[] tArr) {
        kotlin.jvm.internal.m.f(tArr, "<this>");
        return tArr.length == 0 ? t.l() : new a(tArr);
    }

    public static List<Short> F0(short[] sArr) {
        kotlin.jvm.internal.m.f(sArr, "<this>");
        int length = sArr.length;
        if (length != 0) {
            return length != 1 ? O0(sArr) : s.e(Short.valueOf(sArr[0]));
        }
        return t.l();
    }

    public static <T> ta.h<T> G(T[] tArr) {
        kotlin.jvm.internal.m.f(tArr, "<this>");
        return tArr.length == 0 ? ta.k.i() : new b(tArr);
    }

    public static List<Boolean> G0(boolean[] zArr) {
        kotlin.jvm.internal.m.f(zArr, "<this>");
        int length = zArr.length;
        if (length != 0) {
            return length != 1 ? P0(zArr) : s.e(Boolean.valueOf(zArr[0]));
        }
        return t.l();
    }

    public static boolean H(char[] cArr, char c10) {
        kotlin.jvm.internal.m.f(cArr, "<this>");
        return U(cArr, c10) >= 0;
    }

    public static final List<Byte> H0(byte[] bArr) {
        kotlin.jvm.internal.m.f(bArr, "<this>");
        ArrayList arrayList = new ArrayList(bArr.length);
        for (byte b10 : bArr) {
            arrayList.add(Byte.valueOf(b10));
        }
        return arrayList;
    }

    public static final boolean I(int[] iArr, int i10) {
        kotlin.jvm.internal.m.f(iArr, "<this>");
        return V(iArr, i10) >= 0;
    }

    public static final List<Character> I0(char[] cArr) {
        kotlin.jvm.internal.m.f(cArr, "<this>");
        ArrayList arrayList = new ArrayList(cArr.length);
        for (char c10 : cArr) {
            arrayList.add(Character.valueOf(c10));
        }
        return arrayList;
    }

    public static <T> boolean J(T[] tArr, T t10) {
        kotlin.jvm.internal.m.f(tArr, "<this>");
        return W(tArr, t10) >= 0;
    }

    public static final List<Double> J0(double[] dArr) {
        kotlin.jvm.internal.m.f(dArr, "<this>");
        ArrayList arrayList = new ArrayList(dArr.length);
        for (double d10 : dArr) {
            arrayList.add(Double.valueOf(d10));
        }
        return arrayList;
    }

    public static List<Integer> K(int[] iArr) {
        kotlin.jvm.internal.m.f(iArr, "<this>");
        return c0.O0(Q0(iArr));
    }

    public static final List<Float> K0(float[] fArr) {
        kotlin.jvm.internal.m.f(fArr, "<this>");
        ArrayList arrayList = new ArrayList(fArr.length);
        for (float f10 : fArr) {
            arrayList.add(Float.valueOf(f10));
        }
        return arrayList;
    }

    public static <T> List<T> L(T[] tArr, int i10) {
        kotlin.jvm.internal.m.f(tArr, "<this>");
        if (i10 >= 0) {
            return u0(tArr, h9.f.c(tArr.length - i10, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
    }

    public static List<Integer> L0(int[] iArr) {
        kotlin.jvm.internal.m.f(iArr, "<this>");
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i10 : iArr) {
            arrayList.add(Integer.valueOf(i10));
        }
        return arrayList;
    }

    public static <T> List<T> M(T[] tArr) {
        kotlin.jvm.internal.m.f(tArr, "<this>");
        return (List) N(tArr, new ArrayList());
    }

    public static final List<Long> M0(long[] jArr) {
        kotlin.jvm.internal.m.f(jArr, "<this>");
        ArrayList arrayList = new ArrayList(jArr.length);
        for (long j10 : jArr) {
            arrayList.add(Long.valueOf(j10));
        }
        return arrayList;
    }

    public static final <C extends Collection<? super T>, T> C N(T[] tArr, C destination) {
        kotlin.jvm.internal.m.f(tArr, "<this>");
        kotlin.jvm.internal.m.f(destination, "destination");
        for (T t10 : tArr) {
            if (t10 != null) {
                destination.add(t10);
            }
        }
        return destination;
    }

    public static <T> List<T> N0(T[] tArr) {
        kotlin.jvm.internal.m.f(tArr, "<this>");
        return new ArrayList(t.i(tArr, false, 1, null));
    }

    public static <T> T O(T[] tArr) {
        kotlin.jvm.internal.m.f(tArr, "<this>");
        if (tArr.length != 0) {
            return tArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final List<Short> O0(short[] sArr) {
        kotlin.jvm.internal.m.f(sArr, "<this>");
        ArrayList arrayList = new ArrayList(sArr.length);
        for (short s10 : sArr) {
            arrayList.add(Short.valueOf(s10));
        }
        return arrayList;
    }

    public static <T> T P(T[] tArr) {
        kotlin.jvm.internal.m.f(tArr, "<this>");
        if (tArr.length == 0) {
            return null;
        }
        return tArr[0];
    }

    public static final List<Boolean> P0(boolean[] zArr) {
        kotlin.jvm.internal.m.f(zArr, "<this>");
        ArrayList arrayList = new ArrayList(zArr.length);
        for (boolean z10 : zArr) {
            arrayList.add(Boolean.valueOf(z10));
        }
        return arrayList;
    }

    public static final int Q(int[] iArr) {
        kotlin.jvm.internal.m.f(iArr, "<this>");
        return iArr.length - 1;
    }

    public static final Set<Integer> Q0(int[] iArr) {
        kotlin.jvm.internal.m.f(iArr, "<this>");
        return (Set) v0(iArr, new LinkedHashSet(p0.e(iArr.length)));
    }

    public static <T> int R(T[] tArr) {
        kotlin.jvm.internal.m.f(tArr, "<this>");
        return tArr.length - 1;
    }

    public static <T> Set<T> R0(T[] tArr) {
        kotlin.jvm.internal.m.f(tArr, "<this>");
        int length = tArr.length;
        if (length != 0) {
            return length != 1 ? (Set) w0(tArr, new LinkedHashSet(p0.e(tArr.length))) : w0.d(tArr[0]);
        }
        return x0.e();
    }

    public static Integer S(int[] iArr, int i10) {
        kotlin.jvm.internal.m.f(iArr, "<this>");
        if (i10 < 0 || i10 >= iArr.length) {
            return null;
        }
        return Integer.valueOf(iArr[i10]);
    }

    public static <T> Iterable<IndexedValue<T>> S0(final T[] tArr) {
        kotlin.jvm.internal.m.f(tArr, "<this>");
        return new i0(new c9.a() { // from class: kotlin.collections.n
            @Override // c9.a
            public final Object invoke() {
                return o.T0(tArr);
            }
        });
    }

    public static <T> T T(T[] tArr, int i10) {
        kotlin.jvm.internal.m.f(tArr, "<this>");
        if (i10 < 0 || i10 >= tArr.length) {
            return null;
        }
        return tArr[i10];
    }

    public static final int U(char[] cArr, char c10) {
        kotlin.jvm.internal.m.f(cArr, "<this>");
        int length = cArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (c10 == cArr[i10]) {
                return i10;
            }
        }
        return -1;
    }

    public static <T, R> List<r8.p<T, R>> U0(T[] tArr, R[] other) {
        kotlin.jvm.internal.m.f(tArr, "<this>");
        kotlin.jvm.internal.m.f(other, "other");
        int iMin = Math.min(tArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(r8.v.a(tArr[i10], other[i10]));
        }
        return arrayList;
    }

    public static final int V(int[] iArr, int i10) {
        kotlin.jvm.internal.m.f(iArr, "<this>");
        int length = iArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (i10 == iArr[i11]) {
                return i11;
            }
        }
        return -1;
    }

    public static <T> int W(T[] tArr, T t10) {
        kotlin.jvm.internal.m.f(tArr, "<this>");
        int i10 = 0;
        if (t10 == null) {
            int length = tArr.length;
            while (i10 < length) {
                if (tArr[i10] == null) {
                    return i10;
                }
                i10++;
            }
            return -1;
        }
        int length2 = tArr.length;
        while (i10 < length2) {
            if (kotlin.jvm.internal.m.a(t10, tArr[i10])) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public static final <A extends Appendable> A X(byte[] bArr, A buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i10, CharSequence truncated, c9.l<? super Byte, ? extends CharSequence> lVar) throws IOException {
        kotlin.jvm.internal.m.f(bArr, "<this>");
        kotlin.jvm.internal.m.f(buffer, "buffer");
        kotlin.jvm.internal.m.f(separator, "separator");
        kotlin.jvm.internal.m.f(prefix, "prefix");
        kotlin.jvm.internal.m.f(postfix, "postfix");
        kotlin.jvm.internal.m.f(truncated, "truncated");
        buffer.append(prefix);
        int i11 = 0;
        for (byte b10 : bArr) {
            i11++;
            if (i11 > 1) {
                buffer.append(separator);
            }
            if (i10 >= 0 && i11 > i10) {
                break;
            }
            if (lVar != null) {
                buffer.append(lVar.invoke(Byte.valueOf(b10)));
            } else {
                buffer.append(String.valueOf((int) b10));
            }
        }
        if (i10 >= 0 && i11 > i10) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final <T, A extends Appendable> A Y(T[] tArr, A buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i10, CharSequence truncated, c9.l<? super T, ? extends CharSequence> lVar) throws IOException {
        kotlin.jvm.internal.m.f(tArr, "<this>");
        kotlin.jvm.internal.m.f(buffer, "buffer");
        kotlin.jvm.internal.m.f(separator, "separator");
        kotlin.jvm.internal.m.f(prefix, "prefix");
        kotlin.jvm.internal.m.f(postfix, "postfix");
        kotlin.jvm.internal.m.f(truncated, "truncated");
        buffer.append(prefix);
        int i11 = 0;
        for (T t10 : tArr) {
            i11++;
            if (i11 > 1) {
                buffer.append(separator);
            }
            if (i10 >= 0 && i11 > i10) {
                break;
            }
            ua.n.a(buffer, t10, lVar);
        }
        if (i10 >= 0 && i11 > i10) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final String a0(byte[] bArr, CharSequence separator, CharSequence prefix, CharSequence postfix, int i10, CharSequence truncated, c9.l<? super Byte, ? extends CharSequence> lVar) {
        kotlin.jvm.internal.m.f(bArr, "<this>");
        kotlin.jvm.internal.m.f(separator, "separator");
        kotlin.jvm.internal.m.f(prefix, "prefix");
        kotlin.jvm.internal.m.f(postfix, "postfix");
        kotlin.jvm.internal.m.f(truncated, "truncated");
        return ((StringBuilder) X(bArr, new StringBuilder(), separator, prefix, postfix, i10, truncated, lVar)).toString();
    }

    public static final <T> String b0(T[] tArr, CharSequence separator, CharSequence prefix, CharSequence postfix, int i10, CharSequence truncated, c9.l<? super T, ? extends CharSequence> lVar) {
        kotlin.jvm.internal.m.f(tArr, "<this>");
        kotlin.jvm.internal.m.f(separator, "separator");
        kotlin.jvm.internal.m.f(prefix, "prefix");
        kotlin.jvm.internal.m.f(postfix, "postfix");
        kotlin.jvm.internal.m.f(truncated, "truncated");
        return ((StringBuilder) Y(tArr, new StringBuilder(), separator, prefix, postfix, i10, truncated, lVar)).toString();
    }

    public static /* synthetic */ String c0(byte[] bArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, c9.l lVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charSequence = ", ";
        }
        if ((i11 & 2) != 0) {
            charSequence2 = "";
        }
        if ((i11 & 4) != 0) {
            charSequence3 = "";
        }
        if ((i11 & 8) != 0) {
            i10 = -1;
        }
        if ((i11 & 16) != 0) {
            charSequence4 = "...";
        }
        if ((i11 & 32) != 0) {
            lVar = null;
        }
        CharSequence charSequence5 = charSequence4;
        c9.l lVar2 = lVar;
        return a0(bArr, charSequence, charSequence2, charSequence3, i10, charSequence5, lVar2);
    }

    public static /* synthetic */ String d0(Object[] objArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, c9.l lVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charSequence = ", ";
        }
        if ((i11 & 2) != 0) {
            charSequence2 = "";
        }
        if ((i11 & 4) != 0) {
            charSequence3 = "";
        }
        if ((i11 & 8) != 0) {
            i10 = -1;
        }
        if ((i11 & 16) != 0) {
            charSequence4 = "...";
        }
        if ((i11 & 32) != 0) {
            lVar = null;
        }
        CharSequence charSequence5 = charSequence4;
        c9.l lVar2 = lVar;
        return b0(objArr, charSequence, charSequence2, charSequence3, i10, charSequence5, lVar2);
    }

    public static <T> T e0(T[] tArr) {
        kotlin.jvm.internal.m.f(tArr, "<this>");
        if (tArr.length != 0) {
            return tArr[R(tArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final int f0(int[] iArr, int i10) {
        kotlin.jvm.internal.m.f(iArr, "<this>");
        int length = iArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i11 = length - 1;
                if (i10 == iArr[length]) {
                    return length;
                }
                if (i11 >= 0) {
                    length = i11;
                }
            }
        }
        return -1;
    }

    public static <T, R> List<R> g0(T[] tArr, c9.l<? super T, ? extends R> transform) {
        kotlin.jvm.internal.m.f(tArr, "<this>");
        kotlin.jvm.internal.m.f(transform, "transform");
        ArrayList arrayList = new ArrayList(tArr.length);
        for (T t10 : tArr) {
            arrayList.add(transform.invoke(t10));
        }
        return arrayList;
    }

    public static Integer h0(int[] iArr) {
        kotlin.jvm.internal.m.f(iArr, "<this>");
        if (iArr.length == 0) {
            return null;
        }
        int i10 = iArr[0];
        int iQ = Q(iArr);
        int i11 = 1;
        if (1 <= iQ) {
            while (true) {
                int i12 = iArr[i11];
                if (i10 < i12) {
                    i10 = i12;
                }
                if (i11 == iQ) {
                    break;
                }
                i11++;
            }
        }
        return Integer.valueOf(i10);
    }

    public static Integer i0(int[] iArr) {
        kotlin.jvm.internal.m.f(iArr, "<this>");
        if (iArr.length == 0) {
            return null;
        }
        int i10 = iArr[0];
        int iQ = Q(iArr);
        int i11 = 1;
        if (1 <= iQ) {
            while (true) {
                int i12 = iArr[i11];
                if (i10 > i12) {
                    i10 = i12;
                }
                if (i11 == iQ) {
                    break;
                }
                i11++;
            }
        }
        return Integer.valueOf(i10);
    }

    public static final void j0(float[] fArr, int i10, int i11) {
        kotlin.jvm.internal.m.f(fArr, "<this>");
        d.INSTANCE.d(i10, i11, fArr.length);
        int i12 = (i10 + i11) / 2;
        if (i10 == i12) {
            return;
        }
        int i13 = i11 - 1;
        while (i10 < i12) {
            float f10 = fArr[i10];
            fArr[i10] = fArr[i13];
            fArr[i13] = f10;
            i13--;
            i10++;
        }
    }

    public static final void k0(int[] iArr, int i10, int i11) {
        kotlin.jvm.internal.m.f(iArr, "<this>");
        d.INSTANCE.d(i10, i11, iArr.length);
        int i12 = (i10 + i11) / 2;
        if (i10 == i12) {
            return;
        }
        int i13 = i11 - 1;
        while (i10 < i12) {
            int i14 = iArr[i10];
            iArr[i10] = iArr[i13];
            iArr[i13] = i14;
            i13--;
            i10++;
        }
    }

    public static final void l0(long[] jArr, int i10, int i11) {
        kotlin.jvm.internal.m.f(jArr, "<this>");
        d.INSTANCE.d(i10, i11, jArr.length);
        int i12 = (i10 + i11) / 2;
        if (i10 == i12) {
            return;
        }
        int i13 = i11 - 1;
        while (i10 < i12) {
            long j10 = jArr[i10];
            jArr[i10] = jArr[i13];
            jArr[i13] = j10;
            i13--;
            i10++;
        }
    }

    public static char m0(char[] cArr) {
        kotlin.jvm.internal.m.f(cArr, "<this>");
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return cArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static <T> T n0(T[] tArr) {
        kotlin.jvm.internal.m.f(tArr, "<this>");
        int length = tArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return tArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static <T> T o0(T[] tArr) {
        kotlin.jvm.internal.m.f(tArr, "<this>");
        if (tArr.length == 1) {
            return tArr[0];
        }
        return null;
    }

    public static void p0(float[] fArr, int i10, int i11) {
        kotlin.jvm.internal.m.f(fArr, "<this>");
        m.z(fArr, i10, i11);
        j0(fArr, i10, i11);
    }

    public static void q0(int[] iArr, int i10, int i11) {
        kotlin.jvm.internal.m.f(iArr, "<this>");
        m.A(iArr, i10, i11);
        k0(iArr, i10, i11);
    }

    public static void r0(long[] jArr, int i10, int i11) {
        kotlin.jvm.internal.m.f(jArr, "<this>");
        m.B(jArr, i10, i11);
        l0(jArr, i10, i11);
    }

    public static final <T> T[] s0(T[] tArr, Comparator<? super T> comparator) {
        kotlin.jvm.internal.m.f(tArr, "<this>");
        kotlin.jvm.internal.m.f(comparator, "comparator");
        if (tArr.length == 0) {
            return tArr;
        }
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, tArr.length);
        kotlin.jvm.internal.m.e(tArr2, "copyOf(...)");
        m.D(tArr2, comparator);
        return tArr2;
    }

    public static <T> List<T> t0(T[] tArr, Comparator<? super T> comparator) {
        kotlin.jvm.internal.m.f(tArr, "<this>");
        kotlin.jvm.internal.m.f(comparator, "comparator");
        return m.d(s0(tArr, comparator));
    }

    public static final <T> List<T> u0(T[] tArr, int i10) {
        kotlin.jvm.internal.m.f(tArr, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
        }
        if (i10 == 0) {
            return t.l();
        }
        int length = tArr.length;
        if (i10 >= length) {
            return E0(tArr);
        }
        if (i10 == 1) {
            return s.e(tArr[length - 1]);
        }
        ArrayList arrayList = new ArrayList(i10);
        for (int i11 = length - i10; i11 < length; i11++) {
            arrayList.add(tArr[i11]);
        }
        return arrayList;
    }

    public static final <C extends Collection<? super Integer>> C v0(int[] iArr, C destination) {
        kotlin.jvm.internal.m.f(iArr, "<this>");
        kotlin.jvm.internal.m.f(destination, "destination");
        for (int i10 : iArr) {
            destination.add(Integer.valueOf(i10));
        }
        return destination;
    }

    public static final <T, C extends Collection<? super T>> C w0(T[] tArr, C destination) {
        kotlin.jvm.internal.m.f(tArr, "<this>");
        kotlin.jvm.internal.m.f(destination, "destination");
        for (T t10 : tArr) {
            destination.add(t10);
        }
        return destination;
    }

    public static int[] x0(Integer[] numArr) {
        kotlin.jvm.internal.m.f(numArr, "<this>");
        int length = numArr.length;
        int[] iArr = new int[length];
        for (int i10 = 0; i10 < length; i10++) {
            iArr[i10] = numArr[i10].intValue();
        }
        return iArr;
    }

    public static List<Byte> y0(byte[] bArr) {
        kotlin.jvm.internal.m.f(bArr, "<this>");
        int length = bArr.length;
        if (length != 0) {
            return length != 1 ? H0(bArr) : s.e(Byte.valueOf(bArr[0]));
        }
        return t.l();
    }

    public static List<Character> z0(char[] cArr) {
        kotlin.jvm.internal.m.f(cArr, "<this>");
        int length = cArr.length;
        if (length != 0) {
            return length != 1 ? I0(cArr) : s.e(Character.valueOf(cArr[0]));
        }
        return t.l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Iterator T0(Object[] objArr) {
        return kotlin.jvm.internal.b.a(objArr);
    }
}
