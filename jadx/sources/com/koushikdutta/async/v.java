package com.koushikdutta.async;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
class v extends m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    ServerSocketChannel f5163b;

    @Override // com.koushikdutta.async.m
    public boolean b() {
        return false;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        throw new IOException("Can't read ServerSocketChannel");
    }

    @Override // com.koushikdutta.async.m
    public int d(ByteBuffer[] byteBufferArr) throws IOException {
        throw new IOException("Can't write ServerSocketChannel");
    }

    public SelectionKey f(Selector selector) {
        return this.f5163b.register(selector, 16);
    }

    @Override // java.nio.channels.ScatteringByteChannel
    public long read(ByteBuffer[] byteBufferArr) throws IOException {
        throw new IOException("Can't read ServerSocketChannel");
    }

    v(ServerSocketChannel serverSocketChannel) {
        super(serverSocketChannel);
        this.f5163b = serverSocketChannel;
    }

    @Override // java.nio.channels.ScatteringByteChannel
    public long read(ByteBuffer[] byteBufferArr, int i10, int i11) throws IOException {
        throw new IOException("Can't read ServerSocketChannel");
    }

    @Override // com.koushikdutta.async.m
    public void c() {
    }
}
