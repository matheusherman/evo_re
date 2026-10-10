package io.netty.channel;

import com.pengrad.telegrambot.model.message.origin.MessageOriginChannel;
import io.netty.util.concurrent.CompleteFuture;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.ObjectUtil;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
abstract class CompleteChannelFuture extends CompleteFuture<Void> implements ChannelFuture {
    private final Channel channel;

    @Override // io.netty.util.concurrent.CompleteFuture, io.netty.util.concurrent.Future
    /* JADX INFO: renamed from: await, reason: merged with bridge method [inline-methods] */
    public Future<Void> await2() {
        return this;
    }

    @Override // io.netty.util.concurrent.Future
    public Void getNow() {
        return null;
    }

    @Override // io.netty.util.concurrent.CompleteFuture, io.netty.util.concurrent.Future
    /* JADX INFO: renamed from: addListener, reason: merged with bridge method [inline-methods] */
    public Future<Void> addListener2(GenericFutureListener<? extends Future<? super Void>> genericFutureListener) {
        super.addListener2((GenericFutureListener) genericFutureListener);
        return this;
    }

    @Override // io.netty.channel.ChannelFuture
    public Channel channel() {
        return this.channel;
    }

    @Override // io.netty.util.concurrent.CompleteFuture, io.netty.util.concurrent.Future
    /* JADX INFO: renamed from: removeListener, reason: merged with bridge method [inline-methods] */
    public Future<Void> removeListener2(GenericFutureListener<? extends Future<? super Void>> genericFutureListener) {
        super.removeListener2((GenericFutureListener) genericFutureListener);
        return this;
    }

    protected CompleteChannelFuture(Channel channel, EventExecutor eventExecutor) {
        super(eventExecutor);
        this.channel = (Channel) ObjectUtil.checkNotNull(channel, MessageOriginChannel.MESSAGE_ORIGIN_TYPE);
    }

    @Override // io.netty.util.concurrent.CompleteFuture
    protected EventExecutor executor() {
        EventExecutor eventExecutorExecutor = super.executor();
        if (eventExecutorExecutor == null) {
            return channel().eventLoop();
        }
        return eventExecutorExecutor;
    }

    @Override // io.netty.channel.ChannelFuture
    public ChannelFuture sync() {
        return this;
    }
}
