package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.channel.FileRegion;
import io.netty.handler.codec.EncoderException;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.handler.codec.http.HttpMessage;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.PromiseCombiner;
import io.netty.util.internal.StringUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class HttpObjectEncoder<H extends HttpMessage> extends MessageToMessageEncoder<Object> {
    private static final ByteBuf CRLF_BUF = Unpooled.unreleasableBuffer(Unpooled.directBuffer(2).writeByte(13).writeByte(10)).asReadOnly();
    private static final byte[] ZERO_CRLF_CRLF;
    private static final ByteBuf ZERO_CRLF_CRLF_BUF;
    private int state = 0;
    private float headersEncodedSizeAccumulator = 256.0f;
    private float trailersEncodedSizeAccumulator = 256.0f;
    private final List<Object> out = new ArrayList();

    static {
        byte[] bArr = {48, 13, 10, 13, 10};
        ZERO_CRLF_CRLF = bArr;
        ZERO_CRLF_CRLF_BUF = Unpooled.unreleasableBuffer(Unpooled.directBuffer(bArr.length).writeBytes(bArr)).asReadOnly();
    }

    private void encodeByteBufAndTrailers(int i10, ChannelHandlerContext channelHandlerContext, List<Object> list, ByteBuf byteBuf, HttpHeaders httpHeaders) {
        if (i10 != 1) {
            if (i10 == 2) {
                encodeChunkedHttpContent(channelHandlerContext, byteBuf, httpHeaders, list);
                return;
            } else if (i10 != 3) {
                throw new Error();
            }
        } else if (byteBuf.isReadable()) {
            list.add(byteBuf.retain());
            return;
        }
        list.add(Unpooled.EMPTY_BUFFER);
    }

    private void encodeByteBufHttpContent(int i10, ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, ByteBuf byteBuf2, HttpHeaders httpHeaders, List<Object> list) {
        if (i10 != 1) {
            if (i10 == 2) {
                list.add(byteBuf);
                encodeChunkedHttpContent(channelHandlerContext, byteBuf2, httpHeaders, list);
                return;
            } else if (i10 != 3) {
                throw new Error();
            }
        } else if (encodeContentNonChunk(list, byteBuf, byteBuf2)) {
            return;
        }
        list.add(byteBuf);
    }

    private static int encodeEmptyLastHttpContent(int i10, List<Object> list) {
        if (i10 != 1) {
            if (i10 == 2) {
                list.add(ZERO_CRLF_CRLF_BUF.duplicate());
                return 0;
            }
            if (i10 != 3) {
                throw new Error();
            }
        }
        list.add(Unpooled.EMPTY_BUFFER);
        return 0;
    }

    private void encodeFullHttpMessage(ChannelHandlerContext channelHandlerContext, Object obj, List<Object> list) {
        int i10;
        FullHttpMessage fullHttpMessage = (FullHttpMessage) obj;
        try {
            int i11 = this.state;
            if (i11 != 0) {
                throwUnexpectedMessageTypeEx(obj, i11);
            }
            HttpMessage httpMessage = (HttpMessage) obj;
            ByteBuf byteBufBuffer = channelHandlerContext.alloc().buffer((int) this.headersEncodedSizeAccumulator);
            encodeInitialLine(byteBufBuffer, httpMessage);
            boolean z10 = true;
            if (isContentAlwaysEmpty(httpMessage)) {
                i10 = 3;
            } else {
                i10 = HttpUtil.isTransferEncodingChunked(httpMessage) ? 2 : 1;
            }
            if (i10 != 3) {
                z10 = false;
            }
            sanitizeHeadersBeforeEncode(httpMessage, z10);
            encodeHeaders(httpMessage.headers(), byteBufBuffer);
            ByteBufUtil.writeShortBE(byteBufBuffer, 3338);
            this.headersEncodedSizeAccumulator = (padSizeForAccumulation(byteBufBuffer.readableBytes()) * 0.2f) + (this.headersEncodedSizeAccumulator * 0.8f);
            encodeByteBufHttpContent(i10, channelHandlerContext, byteBufBuffer, fullHttpMessage.content(), fullHttpMessage.trailingHeaders(), list);
        } finally {
            fullHttpMessage.release();
        }
    }

    private void encodeHttpMessageLastContent(ChannelHandlerContext channelHandlerContext, H h10, List<Object> list) throws Throwable {
        Throwable th;
        LastHttpContent lastHttpContent = (LastHttpContent) h10;
        try {
            int i10 = this.state;
            if (i10 != 0) {
                try {
                    throwUnexpectedMessageTypeEx(h10, i10);
                } catch (Throwable th2) {
                    th = th2;
                    lastHttpContent.release();
                    throw th;
                }
            }
            try {
                encodeByteBufHttpContent(this.state, channelHandlerContext, encodeInitHttpMessage(channelHandlerContext, h10), lastHttpContent.content(), lastHttpContent.trailingHeaders(), list);
                this.state = 0;
                lastHttpContent.release();
            } catch (Throwable th3) {
                th = th3;
                th = th;
                lastHttpContent.release();
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    private void encodeHttpMessageNotLastContent(ChannelHandlerContext channelHandlerContext, H h10, List<Object> list) {
        HttpContent httpContent = (HttpContent) h10;
        try {
            int i10 = this.state;
            if (i10 != 0) {
                throwUnexpectedMessageTypeEx(h10, i10);
            }
            encodeByteBufHttpContent(this.state, channelHandlerContext, encodeInitHttpMessage(channelHandlerContext, h10), httpContent.content(), null, list);
        } finally {
            httpContent.release();
        }
    }

    protected abstract void encodeInitialLine(ByteBuf byteBuf, H h10);

    protected abstract boolean isContentAlwaysEmpty(H h10);

    protected abstract void sanitizeHeadersBeforeEncode(H h10, boolean z10);

    private void encodeFileRegionContent(ChannelHandlerContext channelHandlerContext, FileRegion fileRegion, List<Object> list) {
        try {
            int i10 = this.state;
            if (i10 != 1) {
                if (i10 == 2) {
                    encodedChunkedFileRegionContent(channelHandlerContext, fileRegion, list);
                } else {
                    if (i10 != 3) {
                        throw new Error();
                    }
                    list.add(Unpooled.EMPTY_BUFFER);
                }
            } else if (fileRegion.count() > 0) {
                list.add(fileRegion.retain());
            } else {
                list.add(Unpooled.EMPTY_BUFFER);
            }
            fileRegion.release();
        } catch (Throwable th) {
            fileRegion.release();
            throw th;
        }
    }

    private void encodeHttpContent(ChannelHandlerContext channelHandlerContext, HttpContent httpContent, List<Object> list) {
        try {
            encodeByteBufAndTrailers(this.state, channelHandlerContext, list, httpContent.content(), null);
        } finally {
            httpContent.release();
        }
    }

    private void encodeJustHttpMessage(ChannelHandlerContext channelHandlerContext, H h10, List<Object> list) {
        try {
            int i10 = this.state;
            if (i10 != 0) {
                throwUnexpectedMessageTypeEx(h10, i10);
            }
            list.add(encodeInitHttpMessage(channelHandlerContext, h10));
        } finally {
            ReferenceCountUtil.release(h10);
        }
    }

    private void encodeLastHttpContent(ChannelHandlerContext channelHandlerContext, LastHttpContent lastHttpContent, List<Object> list) throws Throwable {
        try {
            try {
                encodeByteBufAndTrailers(this.state, channelHandlerContext, list, lastHttpContent.content(), lastHttpContent.trailingHeaders());
                this.state = 0;
                lastHttpContent.release();
            } catch (Throwable th) {
                th = th;
                Throwable th2 = th;
                lastHttpContent.release();
                throw th2;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private void encodeNotHttpMessageContentTypes(ChannelHandlerContext channelHandlerContext, Object obj, List<Object> list) throws Throwable {
        if (this.state == 0) {
            try {
                if ((obj instanceof ByteBuf) && bypassEncoderIfEmpty((ByteBuf) obj, list)) {
                    ReferenceCountUtil.release(obj);
                    return;
                } else {
                    throwUnexpectedMessageTypeEx(obj, 0);
                    ReferenceCountUtil.release(obj);
                }
            } catch (Throwable th) {
                ReferenceCountUtil.release(obj);
                throw th;
            }
        }
        if (obj == LastHttpContent.EMPTY_LAST_CONTENT) {
            this.state = encodeEmptyLastHttpContent(this.state, list);
            return;
        }
        if (obj instanceof LastHttpContent) {
            encodeLastHttpContent(channelHandlerContext, (LastHttpContent) obj, list);
            return;
        }
        if (obj instanceof HttpContent) {
            encodeHttpContent(channelHandlerContext, (HttpContent) obj, list);
            return;
        }
        if (obj instanceof ByteBuf) {
            encodeByteBufContent(channelHandlerContext, (ByteBuf) obj, list);
        } else {
            if (obj instanceof FileRegion) {
                encodeFileRegionContent(channelHandlerContext, (FileRegion) obj, list);
                return;
            }
            try {
                throwUnexpectedMessageTypeEx(obj, this.state);
            } finally {
                ReferenceCountUtil.release(obj);
            }
        }
    }

    private static int padSizeForAccumulation(int i10) {
        return (i10 << 2) / 3;
    }

    private static void throwUnexpectedMessageTypeEx(Object obj, int i10) {
        throw new IllegalStateException("unexpected message type: " + StringUtil.simpleClassName(obj) + ", state: " + i10);
    }

    private static void writePromiseCombiner(ChannelHandlerContext channelHandlerContext, List<Object> list, ChannelPromise channelPromise) {
        PromiseCombiner promiseCombiner = new PromiseCombiner(channelHandlerContext.executor());
        for (int i10 = 0; i10 < list.size(); i10++) {
            promiseCombiner.add(channelHandlerContext.write(list.get(i10)));
        }
        promiseCombiner.finish(channelPromise);
    }

    @Override // io.netty.handler.codec.MessageToMessageEncoder
    public boolean acceptOutboundMessage(Object obj) {
        return obj == Unpooled.EMPTY_BUFFER || obj == LastHttpContent.EMPTY_LAST_CONTENT || (obj instanceof FullHttpMessage) || (obj instanceof HttpMessage) || (obj instanceof LastHttpContent) || (obj instanceof HttpContent) || (obj instanceof ByteBuf) || (obj instanceof FileRegion);
    }

    @Override // io.netty.handler.codec.MessageToMessageEncoder
    protected void encode(ChannelHandlerContext channelHandlerContext, Object obj, List<Object> list) throws Exception {
        ByteBuf byteBuf = Unpooled.EMPTY_BUFFER;
        if (obj == byteBuf) {
            list.add(byteBuf);
            return;
        }
        if (obj instanceof FullHttpMessage) {
            encodeFullHttpMessage(channelHandlerContext, obj, list);
            return;
        }
        if (!(obj instanceof HttpMessage)) {
            encodeNotHttpMessageContentTypes(channelHandlerContext, obj, list);
            return;
        }
        try {
            HttpMessage httpMessage = (HttpMessage) obj;
            if (httpMessage instanceof LastHttpContent) {
                encodeHttpMessageLastContent(channelHandlerContext, httpMessage, list);
            } else if (httpMessage instanceof HttpContent) {
                encodeHttpMessageNotLastContent(channelHandlerContext, httpMessage, list);
            } else {
                encodeJustHttpMessage(channelHandlerContext, httpMessage, list);
            }
        } catch (Exception e10) {
            ReferenceCountUtil.release(obj);
            throw e10;
        }
    }

    private static void addEncodedLengthHex(ChannelHandlerContext channelHandlerContext, long j10, List<Object> list) {
        String hexString = Long.toHexString(j10);
        ByteBuf byteBufBuffer = channelHandlerContext.alloc().buffer(hexString.length() + 2);
        byteBufBuffer.writeCharSequence(hexString, CharsetUtil.US_ASCII);
        ByteBufUtil.writeShortBE(byteBufBuffer, 3338);
        list.add(byteBufBuffer);
    }

    private static boolean bypassEncoderIfEmpty(ByteBuf byteBuf, List<Object> list) {
        if (!byteBuf.isReadable()) {
            list.add(byteBuf.retain());
            return true;
        }
        return false;
    }

    private void encodeByteBufContent(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Throwable {
        ByteBuf byteBuf2;
        try {
            if (bypassEncoderIfEmpty(byteBuf, list)) {
                byteBuf.release();
                return;
            }
            byteBuf2 = byteBuf;
            try {
                encodeByteBufAndTrailers(this.state, channelHandlerContext, list, byteBuf2, null);
                byteBuf2.release();
                return;
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            byteBuf2 = byteBuf;
        }
        Throwable th3 = th;
        byteBuf2.release();
        throw th3;
    }

    private void encodeChunkedHttpContent(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, HttpHeaders httpHeaders, List<Object> list) {
        int i10 = byteBuf.readableBytes();
        if (i10 > 0) {
            addEncodedLengthHex(channelHandlerContext, i10, list);
            list.add(byteBuf.retain());
            list.add(CRLF_BUF.duplicate());
        }
        if (httpHeaders != null) {
            encodeTrailingHeaders(channelHandlerContext, httpHeaders, list);
        } else if (i10 == 0) {
            list.add(byteBuf.retain());
        }
    }

    private static boolean encodeContentNonChunk(List<Object> list, ByteBuf byteBuf, ByteBuf byteBuf2) {
        int i10 = byteBuf2.readableBytes();
        if (i10 > 0) {
            if (byteBuf.writableBytes() >= i10) {
                byteBuf.writeBytes(byteBuf2);
                list.add(byteBuf);
                return true;
            }
            list.add(byteBuf);
            list.add(byteBuf2.retain());
            return true;
        }
        return false;
    }

    private ByteBuf encodeInitHttpMessage(ChannelHandlerContext channelHandlerContext, H h10) {
        int i10;
        ByteBuf byteBufBuffer = channelHandlerContext.alloc().buffer((int) this.headersEncodedSizeAccumulator);
        encodeInitialLine(byteBufBuffer, h10);
        boolean z10 = true;
        if (isContentAlwaysEmpty(h10)) {
            i10 = 3;
        } else if (HttpUtil.isTransferEncodingChunked(h10)) {
            i10 = 2;
        } else {
            i10 = 1;
        }
        this.state = i10;
        if (i10 != 3) {
            z10 = false;
        }
        sanitizeHeadersBeforeEncode(h10, z10);
        encodeHeaders(h10.headers(), byteBufBuffer);
        ByteBufUtil.writeShortBE(byteBufBuffer, 3338);
        this.headersEncodedSizeAccumulator = (padSizeForAccumulation(byteBufBuffer.readableBytes()) * 0.2f) + (this.headersEncodedSizeAccumulator * 0.8f);
        return byteBufBuffer;
    }

    private void encodeTrailingHeaders(ChannelHandlerContext channelHandlerContext, HttpHeaders httpHeaders, List<Object> list) {
        if (httpHeaders.isEmpty()) {
            list.add(ZERO_CRLF_CRLF_BUF.duplicate());
            return;
        }
        ByteBuf byteBufBuffer = channelHandlerContext.alloc().buffer((int) this.trailersEncodedSizeAccumulator);
        ByteBufUtil.writeMediumBE(byteBufBuffer, 3149066);
        encodeHeaders(httpHeaders, byteBufBuffer);
        ByteBufUtil.writeShortBE(byteBufBuffer, 3338);
        this.trailersEncodedSizeAccumulator = (padSizeForAccumulation(byteBufBuffer.readableBytes()) * 0.2f) + (this.trailersEncodedSizeAccumulator * 0.8f);
        list.add(byteBufBuffer);
    }

    private static void encodedChunkedFileRegionContent(ChannelHandlerContext channelHandlerContext, FileRegion fileRegion, List<Object> list) {
        long jCount = fileRegion.count();
        if (jCount > 0) {
            addEncodedLengthHex(channelHandlerContext, jCount, list);
            list.add(fileRegion.retain());
            list.add(CRLF_BUF.duplicate());
        } else if (jCount == 0) {
            list.add(fileRegion.retain());
        }
    }

    private static void writeOutList(ChannelHandlerContext channelHandlerContext, List<Object> list, ChannelPromise channelPromise) {
        int size = list.size();
        try {
            if (size == 1) {
                channelHandlerContext.write(list.get(0), channelPromise);
            } else {
                if (size > 1) {
                    if (channelPromise == channelHandlerContext.voidPromise()) {
                        writeVoidPromise(channelHandlerContext, list);
                    } else {
                        writePromiseCombiner(channelHandlerContext, list, channelPromise);
                    }
                }
                list.clear();
            }
            list.clear();
        } catch (Throwable th) {
            list.clear();
            throw th;
        }
    }

    private static void writeVoidPromise(ChannelHandlerContext channelHandlerContext, List<Object> list) {
        ChannelPromise channelPromiseVoidPromise = channelHandlerContext.voidPromise();
        for (int i10 = 0; i10 < list.size(); i10++) {
            channelHandlerContext.write(list.get(i10), channelPromiseVoidPromise);
        }
    }

    protected void encodeHeaders(HttpHeaders httpHeaders, ByteBuf byteBuf) {
        Iterator<Map.Entry<CharSequence, CharSequence>> itIteratorCharSequence = httpHeaders.iteratorCharSequence();
        while (itIteratorCharSequence.hasNext()) {
            Map.Entry<CharSequence, CharSequence> next = itIteratorCharSequence.next();
            HttpHeadersEncoder.encoderHeader(next.getKey(), next.getValue(), byteBuf);
        }
    }

    @Override // io.netty.handler.codec.MessageToMessageEncoder, io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) {
        try {
            try {
                try {
                    if (acceptOutboundMessage(obj)) {
                        encode(channelHandlerContext, obj, this.out);
                        if (this.out.isEmpty()) {
                            throw new EncoderException(StringUtil.simpleClassName(this) + " must produce at least one message.");
                        }
                    } else {
                        channelHandlerContext.write(obj, channelPromise);
                    }
                    writeOutList(channelHandlerContext, this.out, channelPromise);
                } catch (EncoderException e10) {
                    throw e10;
                }
            } catch (Throwable th) {
                throw new EncoderException(th);
            }
        } catch (Throwable th2) {
            writeOutList(channelHandlerContext, this.out, channelPromise);
            throw th2;
        }
    }
}
