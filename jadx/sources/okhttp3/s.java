package okhttp3;

import com.pengrad.telegrambot.request.ContentTypes;
import java.io.EOFException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00192\u00020\u0001:\u0002\u0012\u0010B%\b\u0000\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\r\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0017R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017¨\u0006\u001a"}, d2 = {"Lokhttp3/s;", "Lokhttp3/c0;", "", "", "encodedNames", "encodedValues", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "Ltb/e;", "sink", "", "countBytes", "", "j", "(Ltb/e;Z)J", "Lokhttp3/x;", "b", "()Lokhttp3/x;", "a", "()J", "Lr8/z;", "i", "(Ltb/e;)V", "Ljava/util/List;", "c", "d", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class s extends c0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final x f16948e = x.INSTANCE.a(ContentTypes.GENERAL_MIME_TYPE);

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final List<String> encodedNames;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final List<String> encodedValues;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\b\u0007\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\t\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\nJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u000fR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0011R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0011¨\u0006\u0014"}, d2 = {"Lokhttp3/s$a;", "", "Ljava/nio/charset/Charset;", "charset", "<init>", "(Ljava/nio/charset/Charset;)V", "", "name", "value", "a", "(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/s$a;", "b", "Lokhttp3/s;", "c", "()Lokhttp3/s;", "Ljava/nio/charset/Charset;", "", "Ljava/util/List;", "names", "values", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final Charset charset;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final List<String> names;

        /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final List<String> values;

        /* JADX WARN: Multi-variable type inference failed */
        public a() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public a(Charset charset) {
            this.charset = charset;
            this.names = new ArrayList();
            this.values = new ArrayList();
        }

        public final a a(String name, String value) {
            kotlin.jvm.internal.m.f(name, "name");
            kotlin.jvm.internal.m.f(value, "value");
            List<String> list = this.names;
            v.Companion companion = v.INSTANCE;
            list.add(v.Companion.b(companion, name, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, false, this.charset, 91, null));
            this.values.add(v.Companion.b(companion, value, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, false, this.charset, 91, null));
            return this;
        }

        public final a b(String name, String value) {
            kotlin.jvm.internal.m.f(name, "name");
            kotlin.jvm.internal.m.f(value, "value");
            List<String> list = this.names;
            v.Companion companion = v.INSTANCE;
            list.add(v.Companion.b(companion, name, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, false, this.charset, 83, null));
            this.values.add(v.Companion.b(companion, value, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, false, this.charset, 83, null));
            return this;
        }

        public final s c() {
            return new s(this.names, this.values);
        }

        public /* synthetic */ a(Charset charset, int i10, kotlin.jvm.internal.g gVar) {
            this((i10 & 1) != 0 ? null : charset);
        }
    }

    @Override // okhttp3.c0
    public long a() {
        return j(null, true);
    }

    public s(List<String> encodedNames, List<String> encodedValues) {
        kotlin.jvm.internal.m.f(encodedNames, "encodedNames");
        kotlin.jvm.internal.m.f(encodedValues, "encodedValues");
        this.encodedNames = hb.d.S(encodedNames);
        this.encodedValues = hb.d.S(encodedValues);
    }

    private final long j(tb.e sink, boolean countBytes) throws EOFException {
        tb.d bufferField;
        if (countBytes) {
            bufferField = new tb.d();
        } else {
            kotlin.jvm.internal.m.c(sink);
            bufferField = sink.getBufferField();
        }
        int size = this.encodedNames.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (i10 > 0) {
                bufferField.writeByte(38);
            }
            bufferField.T(this.encodedNames.get(i10));
            bufferField.writeByte(61);
            bufferField.T(this.encodedValues.get(i10));
        }
        if (!countBytes) {
            return 0L;
        }
        long size2 = bufferField.getSize();
        bufferField.a();
        return size2;
    }

    @Override // okhttp3.c0
    /* JADX INFO: renamed from: b */
    public x getContentType() {
        return f16948e;
    }

    @Override // okhttp3.c0
    public void i(tb.e sink) throws EOFException {
        kotlin.jvm.internal.m.f(sink, "sink");
        j(sink, false);
    }
}
