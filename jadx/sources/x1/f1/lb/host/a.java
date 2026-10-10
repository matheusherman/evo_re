package x1.f1.lb.host;

import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import of.f;
import q6.c;
import r8.z;
import retrofit2.g0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0006\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u000f\u001a\u0004\u0018\u00018\u00002\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0011\u001a\u0004\u0018\u00018\u00002\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0011\u0010\u0010R\u001c\u0010\u0015\u001a\n \u0013*\u0004\u0018\u00010\u00120\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0019R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u001aR\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u001cR\u0018\u0010 \u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006!"}, d2 = {"Lx1/f1/lb/host/a;", ExifInterface.GPS_DIRECTION_TRUE, "", "", "key", "Ljava/lang/Class;", "clazz", "<init>", "(Ljava/lang/String;Ljava/lang/Class;)V", "e", "()Ljava/lang/String;", "", "retryCnt", "d", "(I)Ljava/lang/String;", "a", "(I)Ljava/lang/Object;", "c", "Lq6/b;", "kotlin.jvm.PlatformType", "Lq6/b;", "logger", "b", "I", "index", "Ljava/lang/String;", "Ljava/lang/Class;", "", "Ljava/util/List;", "oldServers", "f", "Ljava/lang/Object;", "api", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final q6.b logger;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int index;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final String key;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Class<T> clazz;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private List<String> oldServers;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private T api;

    private final String d(int retryCnt) {
        synchronized (this) {
            int i10 = this.index;
            int i11 = i10 + 1;
            List<String> listE = b.f20720a.e(this.key);
            if (listE == null) {
                return "";
            }
            if (i11 >= listE.size()) {
                i11 = 0;
            }
            if (x1.f1.lb.config.b.f20643a.t()) {
                this.logger.a("retry[" + retryCnt + "] next " + this.key + " server " + i10 + " -> " + i11 + " : " + ((Object) listE.get(i11)), new Object[0]);
            } else {
                this.logger.a("retry[" + retryCnt + "] next " + this.key + " server " + i10 + " -> " + i11, new Object[0]);
            }
            this.index = i11;
            z zVar = z.f17874a;
            return e();
        }
    }

    public final T c(int retryCnt) {
        if (retryCnt < 2) {
            g0 g0VarC = f.f16593a.c(e());
            if (g0VarC != null) {
                return (T) g0VarC.b(this.clazz);
            }
            return null;
        }
        g0 g0VarC2 = f.f16593a.c(d(retryCnt));
        if (g0VarC2 != null) {
            return (T) g0VarC2.b(this.clazz);
        }
        return null;
    }

    public a(String key, Class<T> clazz) {
        m.f(key, "key");
        m.f(clazz, "clazz");
        this.logger = c.d(a.class);
        this.oldServers = new ArrayList();
        this.key = key;
        this.clazz = clazz;
    }

    public static /* synthetic */ Object b(a aVar, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 0;
        }
        return aVar.a(i10);
    }

    private final String e() {
        List<String> listE = b.f20720a.e(this.key);
        List<String> list = listE;
        if (list == null || list.isEmpty()) {
            return "";
        }
        int i10 = this.index;
        return (i10 >= listE.size() || i10 < 0) ? listE.get(0) : listE.get(i10);
    }

    public final T a(int retryCnt) {
        T t10 = null;
        if (!m.a(this.clazz, uf.b.class)) {
            if (retryCnt < 2) {
                g0 g0VarB = f.f16593a.b(e());
                if (g0VarB != null) {
                    return (T) g0VarB.b(this.clazz);
                }
                return null;
            }
            g0 g0VarB2 = f.f16593a.b(d(retryCnt));
            if (g0VarB2 != null) {
                return (T) g0VarB2.b(this.clazz);
            }
            return null;
        }
        List<String> listE = b.f20720a.e(this.key);
        if (listE == null) {
            return null;
        }
        if (m.a(this.oldServers, listE)) {
            t10 = this.api;
        } else {
            T t11 = this.api;
            if (t11 != null) {
                ((uf.b) t11).g();
            }
            this.api = null;
        }
        if (t10 == null) {
            t10 = (T) new uf.b((String[]) listE.toArray(new String[0]), f.f16593a.a());
            this.api = t10;
        }
        if (!m.a(this.oldServers, listE)) {
            this.oldServers = listE;
        }
        return t10;
    }
}
