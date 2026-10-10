package com.koushikdutta.async;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.channels.spi.AbstractSelectableChannel;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
abstract class m implements ReadableByteChannel, ScatteringByteChannel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AbstractSelectableChannel f5123a;

    public boolean a() {
        return false;
    }

    public abstract boolean b();

    public abstract void c();

    public abstract int d(ByteBuffer[] byteBufferArr);

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f5123a.close();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return this.f5123a.isOpen();
    }

    m(AbstractSelectableChannel abstractSelectableChannel) throws IOException {
        abstractSelectableChannel.configureBlocking(false);
        this.f5123a = abstractSelectableChannel;
    }
}
