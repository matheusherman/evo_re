package lb;

import kotlin.Metadata;
import kotlin.jvm.internal.m;
import okhttp3.e0;
import okhttp3.x;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Llb/h;", "Lokhttp3/e0;", "", "contentTypeString", "", "contentLength", "Ltb/f;", "source", "<init>", "(Ljava/lang/String;JLtb/f;)V", "f", "()J", "Lokhttp3/x;", "i", "()Lokhttp3/x;", "k", "()Ltb/f;", "c", "Ljava/lang/String;", "d", "J", "e", "Ltb/f;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class h extends e0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final String contentTypeString;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final long contentLength;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final tb.f source;

    public h(String str, long j10, tb.f source) {
        m.f(source, "source");
        this.contentTypeString = str;
        this.contentLength = j10;
        this.source = source;
    }

    @Override // okhttp3.e0
    /* JADX INFO: renamed from: f, reason: from getter */
    public long getContentLength() {
        return this.contentLength;
    }

    @Override // okhttp3.e0
    /* JADX INFO: renamed from: i */
    public x getF16696c() {
        String str = this.contentTypeString;
        if (str != null) {
            return x.INSTANCE.b(str);
        }
        return null;
    }

    @Override // okhttp3.e0
    /* JADX INFO: renamed from: k, reason: from getter */
    public tb.f getSource() {
        return this.source;
    }
}
