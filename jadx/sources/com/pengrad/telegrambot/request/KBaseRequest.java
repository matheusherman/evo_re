package com.pengrad.telegrambot.request;

import androidx.exifinterface.media.ExifInterface;
import b9.a;
import c9.l;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.response.BaseResponse;
import i9.d;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import r8.i;
import r8.j;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u0000*\u0014\b\u0000\u0010\u0002*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0001B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000f\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0000¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u0013\u001a\u00028\u00002\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00110\u0010H\u0004¢\u0006\u0004\b\u0013\u0010\u0014R!\u0010\u001b\u001a\u00028\u00008DX\u0084\u0084\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/pengrad/telegrambot/request/KBaseRequest;", "Lcom/pengrad/telegrambot/request/BaseRequest;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/pengrad/telegrambot/response/BaseResponse;", "R", "Li9/d;", "clazz", "<init>", "(Li9/d;)V", "", "name", "", "value", "addParameter$library", "(Ljava/lang/String;Ljava/lang/Object;)Lcom/pengrad/telegrambot/request/BaseRequest;", "addParameter", "Lkotlin/Function1;", "Lr8/z;", "block", "applySelf", "(Lc9/l;)Lcom/pengrad/telegrambot/request/BaseRequest;", "self$delegate", "Lr8/i;", "getSelf", "()Lcom/pengrad/telegrambot/request/BaseRequest;", "getSelf$annotations", "()V", "self", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class KBaseRequest<T extends BaseRequest<T, R>, R extends BaseResponse> extends BaseRequest<T, R> {

    /* JADX INFO: renamed from: self$delegate, reason: from kotlin metadata */
    private final i self;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KBaseRequest(d<R> clazz) {
        super(a.b(clazz));
        m.f(clazz, "clazz");
        this.self = j.a(new KBaseRequest$self$2(this));
    }

    public final T addParameter$library(String name, Object value) {
        m.f(name, "name");
        T tAdd = add(name, value);
        m.e(tAdd, "add(...)");
        return tAdd;
    }

    protected final T applySelf(l<? super T, z> block) {
        m.f(block, "block");
        BaseRequest self = getSelf();
        block.invoke(self);
        return self;
    }

    protected final T getSelf() {
        return (T) this.self.getValue();
    }

    protected static /* synthetic */ void getSelf$annotations() {
    }
}
