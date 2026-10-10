package com.koushikdutta.async;

import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
class w extends m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    SocketChannel f5164b;

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) {
        return this.f5164b.read(byteBuffer);
    }

    @Override // com.koushikdutta.async.m
    public boolean b() {
        return this.f5164b.isConnected();
    }

    @Override // com.koushikdutta.async.m
    public void c() {
        try {
            this.f5164b.socket().shutdownOutput();
        } catch (Exception unused) {
        }
    }

    @Override // com.koushikdutta.async.m
    public int d(ByteBuffer[] byteBufferArr) {
        return (int) this.f5164b.write(byteBufferArr);
    }

    @Override // java.nio.channels.ScatteringByteChannel
    public long read(ByteBuffer[] byteBufferArr) {
        return this.f5164b.read(byteBufferArr);
    }

    w(SocketChannel socketChannel) {
        super(socketChannel);
        this.f5164b = socketChannel;
    }

    @Override // java.nio.channels.ScatteringByteChannel
    public long read(ByteBuffer[] byteBufferArr, int i10, int i11) {
        return this.f5164b.read(byteBufferArr, i10, i11);
    }
}
