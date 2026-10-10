package io.netty.handler.stream;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.util.internal.ObjectUtil;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class ChunkedStream implements ChunkedInput<ByteBuf> {
    private final int chunkSize;
    private boolean closed;
    private final PushbackInputStream in;
    private long offset;

    public ChunkedStream(InputStream inputStream) {
        this(inputStream, 8192);
    }

    @Override // io.netty.handler.stream.ChunkedInput
    public void close() throws IOException {
        this.closed = true;
        this.in.close();
    }

    public ChunkedStream(InputStream inputStream, int i10) {
        ObjectUtil.checkNotNull(inputStream, "in");
        ObjectUtil.checkPositive(i10, "chunkSize");
        if (inputStream instanceof PushbackInputStream) {
            this.in = (PushbackInputStream) inputStream;
        } else {
            this.in = new PushbackInputStream(inputStream);
        }
        this.chunkSize = i10;
    }

    @Override // io.netty.handler.stream.ChunkedInput
    public boolean isEndOfInput() throws IOException {
        if (this.closed) {
            return true;
        }
        if (this.in.available() > 0) {
            return false;
        }
        int i10 = this.in.read();
        if (i10 < 0) {
            return true;
        }
        this.in.unread(i10);
        return false;
    }

    @Override // io.netty.handler.stream.ChunkedInput
    public long length() {
        return -1L;
    }

    @Override // io.netty.handler.stream.ChunkedInput
    public long progress() {
        return this.offset;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.netty.handler.stream.ChunkedInput
    public ByteBuf readChunk(ByteBufAllocator byteBufAllocator) {
        if (isEndOfInput()) {
            return null;
        }
        int iMin = this.in.available() <= 0 ? this.chunkSize : Math.min(this.chunkSize, this.in.available());
        ByteBuf byteBufBuffer = byteBufAllocator.buffer(iMin);
        try {
            int iWriteBytes = byteBufBuffer.writeBytes(this.in, iMin);
            if (iWriteBytes < 0) {
                byteBufBuffer.release();
                return null;
            }
            this.offset += (long) iWriteBytes;
            return byteBufBuffer;
        } catch (Throwable th) {
            byteBufBuffer.release();
            throw th;
        }
    }
}
