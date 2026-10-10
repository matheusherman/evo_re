package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.concurrent.TimeUnit;
import java.util.zip.CRC32;
import java.util.zip.Deflater;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class JdkZlibEncoder extends ZlibEncoder {
    private static final int MAX_INITIAL_OUTPUT_BUFFER_SIZE;
    private static final int MAX_INPUT_BUFFER_SIZE;
    private static final byte[] gzipHeader;
    private static final InternalLogger logger;
    private final CRC32 crc;
    private volatile ChannelHandlerContext ctx;
    private final Deflater deflater;
    private volatile boolean finished;
    private final ZlibWrapper wrapper;
    private boolean writeHeader;

    public JdkZlibEncoder() {
        this(6);
    }

    /* JADX INFO: renamed from: io.netty.handler.codec.compression.JdkZlibEncoder$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$compression$ZlibWrapper;

        static {
            int[] iArr = new int[ZlibWrapper.values().length];
            $SwitchMap$io$netty$handler$codec$compression$ZlibWrapper = iArr;
            try {
                iArr[ZlibWrapper.GZIP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$ZlibWrapper[ZlibWrapper.ZLIB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static {
        InternalLogger internalLoggerFactory = InternalLoggerFactory.getInstance((Class<?>) JdkZlibEncoder.class);
        logger = internalLoggerFactory;
        gzipHeader = new byte[]{31, -117, 8, 0, 0, 0, 0, 0, 0, 0};
        int i10 = SystemPropertyUtil.getInt("io.netty.jdkzlib.encoder.maxInitialOutputBufferSize", 65536);
        MAX_INITIAL_OUTPUT_BUFFER_SIZE = i10;
        int i11 = SystemPropertyUtil.getInt("io.netty.jdkzlib.encoder.maxInputBufferSize", 65536);
        MAX_INPUT_BUFFER_SIZE = i11;
        if (internalLoggerFactory.isDebugEnabled()) {
            internalLoggerFactory.debug("-Dio.netty.jdkzlib.encoder.maxInitialOutputBufferSize={}", Integer.valueOf(i10));
            internalLoggerFactory.debug("-Dio.netty.jdkzlib.encoder.maxInputBufferSize={}", Integer.valueOf(i11));
        }
    }

    public JdkZlibEncoder(int i10) {
        this(ZlibWrapper.ZLIB, i10);
    }

    private ChannelFuture finishEncode(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) {
        if (this.finished) {
            channelPromise.setSuccess();
            return channelPromise;
        }
        this.finished = true;
        ByteBuf byteBufHeapBuffer = channelHandlerContext.alloc().heapBuffer();
        if (this.writeHeader && this.wrapper == ZlibWrapper.GZIP) {
            this.writeHeader = false;
            byteBufHeapBuffer.writeBytes(gzipHeader);
        }
        this.deflater.finish();
        while (!this.deflater.finished()) {
            deflate(byteBufHeapBuffer);
            if (!byteBufHeapBuffer.isWritable()) {
                channelHandlerContext.write(byteBufHeapBuffer);
                byteBufHeapBuffer = channelHandlerContext.alloc().heapBuffer();
            }
        }
        if (this.wrapper == ZlibWrapper.GZIP) {
            int value = (int) this.crc.getValue();
            int totalIn = this.deflater.getTotalIn();
            byteBufHeapBuffer.writeByte(value);
            byteBufHeapBuffer.writeByte(value >>> 8);
            byteBufHeapBuffer.writeByte(value >>> 16);
            byteBufHeapBuffer.writeByte(value >>> 24);
            byteBufHeapBuffer.writeByte(totalIn);
            byteBufHeapBuffer.writeByte(totalIn >>> 8);
            byteBufHeapBuffer.writeByte(totalIn >>> 16);
            byteBufHeapBuffer.writeByte(totalIn >>> 24);
        }
        this.deflater.end();
        return channelHandlerContext.writeAndFlush(byteBufHeapBuffer, channelPromise);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageToByteEncoder
    public final ByteBuf allocateBuffer(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, boolean z10) {
        int iCeil = (int) Math.ceil(((double) byteBuf.readableBytes()) * 1.001d);
        int length = iCeil + 12;
        if (this.writeHeader) {
            int i10 = AnonymousClass4.$SwitchMap$io$netty$handler$codec$compression$ZlibWrapper[this.wrapper.ordinal()];
            if (i10 == 1) {
                length += gzipHeader.length;
            } else if (i10 == 2) {
                length = iCeil + 14;
            }
        }
        return (length < 0 || length > MAX_INITIAL_OUTPUT_BUFFER_SIZE) ? channelHandlerContext.alloc().heapBuffer(MAX_INITIAL_OUTPUT_BUFFER_SIZE) : channelHandlerContext.alloc().heapBuffer(length);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageToByteEncoder
    public void encode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, ByteBuf byteBuf2) {
        if (this.finished) {
            byteBuf2.writeBytes(byteBuf);
            return;
        }
        int i10 = byteBuf.readableBytes();
        if (i10 == 0) {
            return;
        }
        if (byteBuf.hasArray()) {
            encodeSome(byteBuf, byteBuf2);
        } else {
            int iMin = Math.min(i10, MAX_INPUT_BUFFER_SIZE);
            ByteBuf byteBufHeapBuffer = channelHandlerContext.alloc().heapBuffer(iMin, iMin);
            while (byteBuf.isReadable()) {
                try {
                    byteBuf.readBytes(byteBufHeapBuffer, Math.min(byteBufHeapBuffer.writableBytes(), byteBuf.readableBytes()));
                    encodeSome(byteBufHeapBuffer, byteBuf2);
                    byteBufHeapBuffer.clear();
                } catch (Throwable th) {
                    byteBufHeapBuffer.release();
                    throw th;
                }
            }
            byteBufHeapBuffer.release();
        }
        this.deflater.setInput(EmptyArrays.EMPTY_BYTES);
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) {
        this.ctx = channelHandlerContext;
    }

    public JdkZlibEncoder(ZlibWrapper zlibWrapper, int i10) {
        this.crc = new CRC32();
        this.writeHeader = true;
        ObjectUtil.checkInRange(i10, 0, 9, "compressionLevel");
        ObjectUtil.checkNotNull(zlibWrapper, "wrapper");
        ZlibWrapper zlibWrapper2 = ZlibWrapper.ZLIB_OR_NONE;
        if (zlibWrapper != zlibWrapper2) {
            this.wrapper = zlibWrapper;
            this.deflater = new Deflater(i10, zlibWrapper != ZlibWrapper.ZLIB);
        } else {
            throw new IllegalArgumentException("wrapper '" + zlibWrapper2 + "' is not allowed for compression.");
        }
    }

    private void deflate(ByteBuf byteBuf) {
        int iDeflate;
        if (PlatformDependent.javaVersion() < 7) {
            deflateJdk6(byteBuf);
        }
        do {
            int iWriterIndex = byteBuf.writerIndex();
            iDeflate = this.deflater.deflate(byteBuf.array(), byteBuf.arrayOffset() + iWriterIndex, byteBuf.writableBytes(), 2);
            byteBuf.writerIndex(iWriterIndex + iDeflate);
        } while (iDeflate > 0);
    }

    private void deflateJdk6(ByteBuf byteBuf) {
        int iDeflate;
        do {
            int iWriterIndex = byteBuf.writerIndex();
            iDeflate = this.deflater.deflate(byteBuf.array(), byteBuf.arrayOffset() + iWriterIndex, byteBuf.writableBytes());
            byteBuf.writerIndex(iWriterIndex + iDeflate);
        } while (iDeflate > 0);
    }

    private void encodeSome(ByteBuf byteBuf, ByteBuf byteBuf2) {
        byte[] bArrArray = byteBuf.array();
        int iArrayOffset = byteBuf.arrayOffset() + byteBuf.readerIndex();
        if (this.writeHeader) {
            this.writeHeader = false;
            if (this.wrapper == ZlibWrapper.GZIP) {
                byteBuf2.writeBytes(gzipHeader);
            }
        }
        int i10 = byteBuf.readableBytes();
        if (this.wrapper == ZlibWrapper.GZIP) {
            this.crc.update(bArrArray, iArrayOffset, i10);
        }
        this.deflater.setInput(bArrArray, iArrayOffset, i10);
        while (true) {
            deflate(byteBuf2);
            if (!byteBuf2.isWritable()) {
                byteBuf2.ensureWritable(byteBuf2.writerIndex());
            } else if (this.deflater.needsInput()) {
                byteBuf.skipBytes(i10);
                return;
            }
        }
    }

    @Override // io.netty.channel.ChannelOutboundHandlerAdapter, io.netty.channel.ChannelOutboundHandler
    public void close(final ChannelHandlerContext channelHandlerContext, final ChannelPromise channelPromise) {
        ChannelFuture channelFutureFinishEncode = finishEncode(channelHandlerContext, channelHandlerContext.newPromise());
        channelFutureFinishEncode.addListener2((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.codec.compression.JdkZlibEncoder.2
            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(ChannelFuture channelFuture) {
                channelHandlerContext.close(channelPromise);
            }
        });
        if (!channelFutureFinishEncode.isDone()) {
            channelHandlerContext.executor().schedule(new Runnable() { // from class: io.netty.handler.codec.compression.JdkZlibEncoder.3
                @Override // java.lang.Runnable
                public void run() {
                    channelHandlerContext.close(channelPromise);
                }
            }, 10L, TimeUnit.SECONDS);
        }
    }
}
