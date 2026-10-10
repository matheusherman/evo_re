package io.netty.channel.nio;

import io.netty.channel.DefaultSelectStrategyFactory;
import io.netty.channel.EventLoop;
import io.netty.channel.EventLoopTaskQueueFactory;
import io.netty.channel.MultithreadEventLoopGroup;
import io.netty.channel.SelectStrategyFactory;
import io.netty.util.concurrent.RejectedExecutionHandler;
import io.netty.util.concurrent.RejectedExecutionHandlers;
import java.nio.channels.spi.SelectorProvider;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class NioEventLoopGroup extends MultithreadEventLoopGroup {
    public NioEventLoopGroup() {
        this(0);
    }

    public NioEventLoopGroup(int i10) {
        this(i10, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.MultithreadEventLoopGroup, io.netty.util.concurrent.MultithreadEventExecutorGroup
    public EventLoop newChild(Executor executor, Object... objArr) {
        SelectorProvider selectorProvider = (SelectorProvider) objArr[0];
        SelectStrategyFactory selectStrategyFactory = (SelectStrategyFactory) objArr[1];
        RejectedExecutionHandler rejectedExecutionHandler = (RejectedExecutionHandler) objArr[2];
        int length = objArr.length;
        return new NioEventLoop(this, executor, selectorProvider, selectStrategyFactory.newSelectStrategy(), rejectedExecutionHandler, length > 3 ? (EventLoopTaskQueueFactory) objArr[3] : null, length > 4 ? (EventLoopTaskQueueFactory) objArr[4] : null);
    }

    public NioEventLoopGroup(int i10, Executor executor) {
        this(i10, executor, SelectorProvider.provider());
    }

    public NioEventLoopGroup(int i10, Executor executor, SelectorProvider selectorProvider) {
        this(i10, executor, selectorProvider, DefaultSelectStrategyFactory.INSTANCE);
    }

    public NioEventLoopGroup(int i10, Executor executor, SelectorProvider selectorProvider, SelectStrategyFactory selectStrategyFactory) {
        super(i10, executor, selectorProvider, selectStrategyFactory, RejectedExecutionHandlers.reject());
    }
}
