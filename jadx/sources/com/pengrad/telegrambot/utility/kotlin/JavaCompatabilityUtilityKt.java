package com.pengrad.telegrambot.utility.kotlin;

import com.pengrad.telegrambot.request.AbstractSendRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0002\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0000H\u0086\b¢\u0006\u0004\b\u0002\u0010\u0003*\n\u0010\u0005\"\u00020\u00042\u00020\u0004*\n\u0010\u0007\"\u00020\u00062\u00020\u0006¨\u0006\b"}, d2 = {"Lcom/pengrad/telegrambot/request/AbstractSendRequest;", "Lr8/z;", "checkDeprecatedConstructorParameters", "(Lcom/pengrad/telegrambot/request/AbstractSendRequest;)V", "Ljava/lang/Integer;", "JavaInteger", "Ljava/lang/Long;", "JavaLong", "library"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class JavaCompatabilityUtilityKt {
    public static final void checkDeprecatedConstructorParameters(AbstractSendRequest<?> abstractSendRequest) {
        m.f(abstractSendRequest, "<this>");
        if (abstractSendRequest.getChatId() == null && abstractSendRequest.getChannelUsername() == null) {
            throw new IllegalArgumentException("chatId parameter must be either Long or String");
        }
    }
}
