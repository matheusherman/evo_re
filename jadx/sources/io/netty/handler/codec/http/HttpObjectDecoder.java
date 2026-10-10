package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.PrematureChannelClosureException;
import io.netty.handler.codec.TooLongFrameException;
import io.netty.util.AsciiString;
import io.netty.util.ByteProcessor;
import io.netty.util.internal.AppendableCharSequence;
import io.netty.util.internal.ObjectUtil;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class HttpObjectDecoder extends ByteToMessageDecoder {
    private final boolean allowDuplicateContentLengths;
    private final boolean allowPartialChunks;
    private long chunkSize;
    private final boolean chunkedSupported;
    private long contentLength;
    private State currentState;
    private final HeaderParser headerParser;
    private final LineParser lineParser;
    private final int maxChunkSize;
    private HttpMessage message;
    private CharSequence name;
    private volatile boolean resetRequested;
    private LastHttpContent trailer;
    protected final boolean validateHeaders;
    private CharSequence value;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class HeaderParser implements ByteProcessor {
        private final int maxLength;
        private final AppendableCharSequence seq;
        int size;

        public void reset() {
            this.size = 0;
        }

        protected final void increaseCount() {
            int i10 = this.size + 1;
            this.size = i10;
            int i11 = this.maxLength;
            if (i10 > i11) {
                throw newException(i11);
            }
        }

        protected TooLongFrameException newException(int i10) {
            return new TooLongHttpHeaderException("HTTP header is larger than " + i10 + " bytes.");
        }

        public AppendableCharSequence parse(ByteBuf byteBuf) {
            int i10 = this.size;
            this.seq.reset();
            int iForEachByte = byteBuf.forEachByte(this);
            if (iForEachByte == -1) {
                this.size = i10;
                return null;
            }
            byteBuf.readerIndex(iForEachByte + 1);
            return this.seq;
        }

        @Override // io.netty.util.ByteProcessor
        public boolean process(byte b10) {
            char c10 = (char) (b10 & 255);
            if (c10 != '\n') {
                increaseCount();
                this.seq.append(c10);
                return true;
            }
            int length = this.seq.length();
            if (length < 1) {
                return false;
            }
            int i10 = length - 1;
            if (this.seq.charAtUnsafe(i10) != '\r') {
                return false;
            }
            this.size--;
            this.seq.setLength(i10);
            return false;
        }

        HeaderParser(AppendableCharSequence appendableCharSequence, int i10) {
            this.seq = appendableCharSequence;
            this.maxLength = i10;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private final class LineParser extends HeaderParser {
        LineParser(AppendableCharSequence appendableCharSequence, int i10) {
            super(appendableCharSequence, i10);
        }

        @Override // io.netty.handler.codec.http.HttpObjectDecoder.HeaderParser
        protected TooLongFrameException newException(int i10) {
            return new TooLongHttpLineException("An HTTP line is larger than " + i10 + " bytes.");
        }

        @Override // io.netty.handler.codec.http.HttpObjectDecoder.HeaderParser, io.netty.util.ByteProcessor
        public boolean process(byte b10) {
            if (HttpObjectDecoder.this.currentState == State.SKIP_CONTROL_CHARS) {
                char c10 = (char) (b10 & 255);
                if (Character.isISOControl(c10) || Character.isWhitespace(c10)) {
                    increaseCount();
                    return true;
                }
                HttpObjectDecoder.this.currentState = State.READ_INITIAL;
            }
            return super.process(b10);
        }

        @Override // io.netty.handler.codec.http.HttpObjectDecoder.HeaderParser
        public AppendableCharSequence parse(ByteBuf byteBuf) {
            reset();
            return super.parse(byteBuf);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private enum State {
        SKIP_CONTROL_CHARS,
        READ_INITIAL,
        READ_HEADER,
        READ_VARIABLE_LENGTH_CONTENT,
        READ_FIXED_LENGTH_CONTENT,
        READ_CHUNK_SIZE,
        READ_CHUNKED_CONTENT,
        READ_CHUNK_DELIMITER,
        READ_CHUNK_FOOTER,
        BAD_MESSAGE,
        UPGRADED
    }

    protected HttpObjectDecoder(int i10, int i11, int i12, boolean z10) {
        this(i10, i11, i12, z10, true);
    }

    private static String[] splitInitialLine(AppendableCharSequence appendableCharSequence) {
        int iFindNonSPLenient = findNonSPLenient(appendableCharSequence, 0);
        int iFindSPLenient = findSPLenient(appendableCharSequence, iFindNonSPLenient);
        int iFindNonSPLenient2 = findNonSPLenient(appendableCharSequence, iFindSPLenient);
        int iFindSPLenient2 = findSPLenient(appendableCharSequence, iFindNonSPLenient2);
        int iFindNonSPLenient3 = findNonSPLenient(appendableCharSequence, iFindSPLenient2);
        int iFindEndOfString = findEndOfString(appendableCharSequence);
        return new String[]{appendableCharSequence.subStringUnsafe(iFindNonSPLenient, iFindSPLenient), appendableCharSequence.subStringUnsafe(iFindNonSPLenient2, iFindSPLenient2), iFindNonSPLenient3 < iFindEndOfString ? appendableCharSequence.subStringUnsafe(iFindNonSPLenient3, iFindEndOfString) : ""};
    }

    protected abstract HttpMessage createInvalidMessage();

    protected abstract HttpMessage createMessage(String[] strArr);

    protected abstract boolean isDecodingRequest();

    /* JADX INFO: renamed from: io.netty.handler.codec.http.HttpObjectDecoder$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State = iArr;
            try {
                iArr[State.SKIP_CONTROL_CHARS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.READ_CHUNK_SIZE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.READ_INITIAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.READ_HEADER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.READ_VARIABLE_LENGTH_CONTENT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.READ_FIXED_LENGTH_CONTENT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.READ_CHUNKED_CONTENT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.READ_CHUNK_DELIMITER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.READ_CHUNK_FOOTER.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.BAD_MESSAGE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.UPGRADED.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    protected HttpObjectDecoder(int i10, int i11, int i12, boolean z10, boolean z11) {
        this(i10, i11, i12, z10, z11, 128);
    }

    private long contentLength() {
        if (this.contentLength == Long.MIN_VALUE) {
            this.contentLength = HttpUtil.getContentLength(this.message, -1L);
        }
        return this.contentLength;
    }

    private HttpContent invalidChunk(ByteBuf byteBuf, Exception exc) {
        this.currentState = State.BAD_MESSAGE;
        byteBuf.skipBytes(byteBuf.readableBytes());
        DefaultLastHttpContent defaultLastHttpContent = new DefaultLastHttpContent(Unpooled.EMPTY_BUFFER);
        defaultLastHttpContent.setDecoderResult(DecoderResult.failure(exc));
        this.message = null;
        this.trailer = null;
        return defaultLastHttpContent;
    }

    private HttpMessage invalidMessage(ByteBuf byteBuf, Exception exc) {
        this.currentState = State.BAD_MESSAGE;
        byteBuf.skipBytes(byteBuf.readableBytes());
        if (this.message == null) {
            this.message = createInvalidMessage();
        }
        this.message.setDecoderResult(DecoderResult.failure(exc));
        HttpMessage httpMessage = this.message;
        this.message = null;
        return httpMessage;
    }

    private static boolean isOWS(char c10) {
        return c10 == ' ' || c10 == '\t';
    }

    private static boolean isSPLenient(char c10) {
        return c10 == ' ' || c10 == '\t' || c10 == 11 || c10 == '\f' || c10 == '\r';
    }

    private State readHeaders(ByteBuf byteBuf) {
        HttpMessage httpMessage = this.message;
        HttpHeaders httpHeadersHeaders = httpMessage.headers();
        AppendableCharSequence appendableCharSequence = this.headerParser.parse(byteBuf);
        if (appendableCharSequence == null) {
            return null;
        }
        if (appendableCharSequence.length() > 0) {
            do {
                char cCharAtUnsafe = appendableCharSequence.charAtUnsafe(0);
                CharSequence charSequence = this.name;
                if (charSequence == null || !(cCharAtUnsafe == ' ' || cCharAtUnsafe == '\t')) {
                    if (charSequence != null) {
                        httpHeadersHeaders.add(charSequence, this.value);
                    }
                    splitHeader(appendableCharSequence);
                } else {
                    String strTrim = appendableCharSequence.toString().trim();
                    this.value = String.valueOf(this.value) + ' ' + strTrim;
                }
                appendableCharSequence = this.headerParser.parse(byteBuf);
                if (appendableCharSequence == null) {
                    return null;
                }
            } while (appendableCharSequence.length() > 0);
        }
        CharSequence charSequence2 = this.name;
        if (charSequence2 != null) {
            httpHeadersHeaders.add(charSequence2, this.value);
        }
        this.name = null;
        this.value = null;
        httpMessage.setDecoderResult(new HttpMessageDecoderResult(this.lineParser.size, this.headerParser.size));
        AsciiString asciiString = HttpHeaderNames.CONTENT_LENGTH;
        List<String> all = httpHeadersHeaders.getAll(asciiString);
        if (!all.isEmpty()) {
            HttpVersion httpVersionProtocolVersion = httpMessage.protocolVersion();
            boolean z10 = true;
            if (httpVersionProtocolVersion.majorVersion() >= 1 && (httpVersionProtocolVersion.majorVersion() != 1 || httpVersionProtocolVersion.minorVersion() != 0)) {
                z10 = false;
            }
            long jNormalizeAndGetContentLength = HttpUtil.normalizeAndGetContentLength(all, z10, this.allowDuplicateContentLengths);
            this.contentLength = jNormalizeAndGetContentLength;
            if (jNormalizeAndGetContentLength != -1) {
                httpHeadersHeaders.set(asciiString, Long.valueOf(jNormalizeAndGetContentLength));
            }
        }
        if (isContentAlwaysEmpty(httpMessage)) {
            HttpUtil.setTransferEncodingChunked(httpMessage, false);
            return State.SKIP_CONTROL_CHARS;
        }
        if (!HttpUtil.isTransferEncodingChunked(httpMessage)) {
            return contentLength() >= 0 ? State.READ_FIXED_LENGTH_CONTENT : State.READ_VARIABLE_LENGTH_CONTENT;
        }
        if (!all.isEmpty() && httpMessage.protocolVersion() == HttpVersion.HTTP_1_1) {
            handleTransferEncodingChunkedWithContentLength(httpMessage);
        }
        return State.READ_CHUNK_SIZE;
    }

    private LastHttpContent readTrailingHeaders(ByteBuf byteBuf) {
        AppendableCharSequence appendableCharSequence = this.headerParser.parse(byteBuf);
        if (appendableCharSequence == null) {
            return null;
        }
        LastHttpContent defaultLastHttpContent = this.trailer;
        if (appendableCharSequence.length() == 0 && defaultLastHttpContent == null) {
            return LastHttpContent.EMPTY_LAST_CONTENT;
        }
        if (defaultLastHttpContent == null) {
            defaultLastHttpContent = new DefaultLastHttpContent(Unpooled.EMPTY_BUFFER, this.validateHeaders);
            this.trailer = defaultLastHttpContent;
        }
        CharSequence charSequence = null;
        while (appendableCharSequence.length() > 0) {
            char cCharAtUnsafe = appendableCharSequence.charAtUnsafe(0);
            if (charSequence == null || !(cCharAtUnsafe == ' ' || cCharAtUnsafe == '\t')) {
                splitHeader(appendableCharSequence);
                CharSequence charSequence2 = this.name;
                if (!HttpHeaderNames.CONTENT_LENGTH.contentEqualsIgnoreCase(charSequence2) && !HttpHeaderNames.TRANSFER_ENCODING.contentEqualsIgnoreCase(charSequence2) && !HttpHeaderNames.TRAILER.contentEqualsIgnoreCase(charSequence2)) {
                    defaultLastHttpContent.trailingHeaders().add(charSequence2, this.value);
                }
                charSequence = this.name;
                this.name = null;
                this.value = null;
            } else {
                List<String> all = defaultLastHttpContent.trailingHeaders().getAll(charSequence);
                if (!all.isEmpty()) {
                    int size = all.size() - 1;
                    String strTrim = appendableCharSequence.toString().trim();
                    all.set(size, all.get(size) + strTrim);
                }
            }
            appendableCharSequence = this.headerParser.parse(byteBuf);
            if (appendableCharSequence == null) {
                return null;
            }
        }
        this.trailer = null;
        return defaultLastHttpContent;
    }

    private void resetNow() {
        HttpResponse httpResponse;
        HttpMessage httpMessage = this.message;
        this.message = null;
        this.name = null;
        this.value = null;
        this.contentLength = Long.MIN_VALUE;
        this.lineParser.reset();
        this.headerParser.reset();
        this.trailer = null;
        if (!isDecodingRequest() && (httpResponse = (HttpResponse) httpMessage) != null && isSwitchingToNonHttp1Protocol(httpResponse)) {
            this.currentState = State.UPGRADED;
        } else {
            this.resetRequested = false;
            this.currentState = State.SKIP_CONTROL_CHARS;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:102:0x018c A[Catch: Exception -> 0x0170, TryCatch #0 {Exception -> 0x0170, blocks: (B:80:0x0146, B:83:0x014d, B:87:0x015b, B:91:0x0169, B:96:0x0172, B:98:0x017b, B:100:0x017e, B:102:0x018c, B:104:0x0190, B:106:0x0196, B:107:0x019d, B:108:0x019e), top: B:114:0x0146 }] */
    /* JADX WARN: Code duplicated, block: B:104:0x0190 A[Catch: Exception -> 0x0170, TryCatch #0 {Exception -> 0x0170, blocks: (B:80:0x0146, B:83:0x014d, B:87:0x015b, B:91:0x0169, B:96:0x0172, B:98:0x017b, B:100:0x017e, B:102:0x018c, B:104:0x0190, B:106:0x0196, B:107:0x019d, B:108:0x019e), top: B:114:0x0146 }] */
    /* JADX WARN: Code duplicated, block: B:106:0x0196 A[Catch: Exception -> 0x0170, TryCatch #0 {Exception -> 0x0170, blocks: (B:80:0x0146, B:83:0x014d, B:87:0x015b, B:91:0x0169, B:96:0x0172, B:98:0x017b, B:100:0x017e, B:102:0x018c, B:104:0x0190, B:106:0x0196, B:107:0x019d, B:108:0x019e), top: B:114:0x0146 }] */
    /* JADX WARN: Code duplicated, block: B:108:0x019e A[Catch: Exception -> 0x0170, TRY_LEAVE, TryCatch #0 {Exception -> 0x0170, blocks: (B:80:0x0146, B:83:0x014d, B:87:0x015b, B:91:0x0169, B:96:0x0172, B:98:0x017b, B:100:0x017e, B:102:0x018c, B:104:0x0190, B:106:0x0196, B:107:0x019d, B:108:0x019e), top: B:114:0x0146 }] */
    /* JADX WARN: Code duplicated, block: B:120:0x010f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:127:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:132:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:59:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:62:0x0105  */
    /* JADX WARN: Code duplicated, block: B:65:0x0115 A[LOOP:0: B:61:0x0103->B:65:0x0115, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:82:0x014c  */
    /* JADX WARN: Code duplicated, block: B:83:0x014d A[Catch: Exception -> 0x0170, TryCatch #0 {Exception -> 0x0170, blocks: (B:80:0x0146, B:83:0x014d, B:87:0x015b, B:91:0x0169, B:96:0x0172, B:98:0x017b, B:100:0x017e, B:102:0x018c, B:104:0x0190, B:106:0x0196, B:107:0x019d, B:108:0x019e), top: B:114:0x0146 }] */
    /* JADX WARN: Code duplicated, block: B:85:0x0158  */
    /* JADX WARN: Code duplicated, block: B:87:0x015b A[Catch: Exception -> 0x0170, TryCatch #0 {Exception -> 0x0170, blocks: (B:80:0x0146, B:83:0x014d, B:87:0x015b, B:91:0x0169, B:96:0x0172, B:98:0x017b, B:100:0x017e, B:102:0x018c, B:104:0x0190, B:106:0x0196, B:107:0x019d, B:108:0x019e), top: B:114:0x0146 }] */
    /* JADX WARN: Code duplicated, block: B:98:0x017b A[Catch: Exception -> 0x0170, TryCatch #0 {Exception -> 0x0170, blocks: (B:80:0x0146, B:83:0x014d, B:87:0x015b, B:91:0x0169, B:96:0x0172, B:98:0x017b, B:100:0x017e, B:102:0x018c, B:104:0x0190, B:106:0x0196, B:107:0x019d, B:108:0x019e), top: B:114:0x0146 }] */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
        State headers;
        int i10;
        long jContentLength;
        int iWriterIndex;
        int i11;
        int i12;
        int iMin;
        if (this.resetRequested) {
            resetNow();
        }
        int[] iArr = AnonymousClass1.$SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State;
        switch (iArr[this.currentState.ordinal()]) {
            case 1:
            case 3:
                try {
                    AppendableCharSequence appendableCharSequence = this.lineParser.parse(byteBuf);
                    if (appendableCharSequence == null) {
                        return;
                    }
                    String[] strArrSplitInitialLine = splitInitialLine(appendableCharSequence);
                    if (strArrSplitInitialLine.length < 3) {
                        this.currentState = State.SKIP_CONTROL_CHARS;
                        return;
                    }
                    this.message = createMessage(strArrSplitInitialLine);
                    this.currentState = State.READ_HEADER;
                    try {
                        headers = readHeaders(byteBuf);
                        if (headers == null) {
                            return;
                        }
                        this.currentState = headers;
                        i10 = iArr[headers.ordinal()];
                        if (i10 != 1) {
                            list.add(this.message);
                            list.add(LastHttpContent.EMPTY_LAST_CONTENT);
                            resetNow();
                            return;
                        }
                        if (i10 != 2) {
                            if (this.chunkedSupported) {
                                throw new IllegalArgumentException("Chunked messages not supported");
                            }
                            list.add(this.message);
                            return;
                        }
                        jContentLength = contentLength();
                        if (jContentLength != 0 && (jContentLength != -1 || !isDecodingRequest())) {
                            list.add(this.message);
                            if (headers == State.READ_FIXED_LENGTH_CONTENT) {
                                this.chunkSize = jContentLength;
                                return;
                            }
                            return;
                        }
                        list.add(this.message);
                        list.add(LastHttpContent.EMPTY_LAST_CONTENT);
                        resetNow();
                        return;
                    } catch (Exception e10) {
                        list.add(invalidMessage(byteBuf, e10));
                        return;
                    }
                } catch (Exception e11) {
                    list.add(invalidMessage(byteBuf, e11));
                    return;
                }
            case 2:
                try {
                    AppendableCharSequence appendableCharSequence2 = this.lineParser.parse(byteBuf);
                    if (appendableCharSequence2 == null) {
                        return;
                    }
                    int chunkSize = getChunkSize(appendableCharSequence2.toString());
                    this.chunkSize = chunkSize;
                    if (chunkSize == 0) {
                        this.currentState = State.READ_CHUNK_FOOTER;
                        return;
                    }
                    this.currentState = State.READ_CHUNKED_CONTENT;
                    int iMin2 = Math.min((int) this.chunkSize, this.maxChunkSize);
                    if ((!this.allowPartialChunks || byteBuf.readableBytes() >= iMin2) && (iMin = Math.min(iMin2, byteBuf.readableBytes())) != 0) {
                        DefaultHttpContent defaultHttpContent = new DefaultHttpContent(byteBuf.readRetainedSlice(iMin));
                        this.chunkSize -= (long) iMin;
                        list.add(defaultHttpContent);
                        if (this.chunkSize != 0) {
                            return;
                        }
                        this.currentState = State.READ_CHUNK_DELIMITER;
                        iWriterIndex = byteBuf.writerIndex();
                        i11 = byteBuf.readerIndex();
                        while (iWriterIndex > i11) {
                            i12 = i11 + 1;
                            if (byteBuf.getByte(i11) == 10) {
                                this.currentState = State.READ_CHUNK_SIZE;
                                i11 = i12;
                                byteBuf.readerIndex(i11);
                                return;
                            }
                            i11 = i12;
                        }
                        byteBuf.readerIndex(i11);
                        return;
                    }
                    return;
                } catch (Exception e12) {
                    list.add(invalidChunk(byteBuf, e12));
                    return;
                }
            case 4:
                headers = readHeaders(byteBuf);
                if (headers == null) {
                    return;
                }
                this.currentState = headers;
                i10 = iArr[headers.ordinal()];
                if (i10 != 1) {
                    list.add(this.message);
                    list.add(LastHttpContent.EMPTY_LAST_CONTENT);
                    resetNow();
                    return;
                }
                if (i10 != 2) {
                    if (this.chunkedSupported) {
                        throw new IllegalArgumentException("Chunked messages not supported");
                    }
                    list.add(this.message);
                    return;
                }
                jContentLength = contentLength();
                if (jContentLength != 0) {
                    list.add(this.message);
                    if (headers == State.READ_FIXED_LENGTH_CONTENT) {
                        this.chunkSize = jContentLength;
                        return;
                    }
                    return;
                }
                list.add(this.message);
                list.add(LastHttpContent.EMPTY_LAST_CONTENT);
                resetNow();
                return;
            case 5:
                int iMin3 = Math.min(byteBuf.readableBytes(), this.maxChunkSize);
                if (iMin3 > 0) {
                    list.add(new DefaultHttpContent(byteBuf.readRetainedSlice(iMin3)));
                    return;
                }
                return;
            case 6:
                int i13 = byteBuf.readableBytes();
                if (i13 == 0) {
                    return;
                }
                int iMin4 = Math.min(i13, this.maxChunkSize);
                long j10 = iMin4;
                long j11 = this.chunkSize;
                if (j10 > j11) {
                    iMin4 = (int) j11;
                }
                ByteBuf retainedSlice = byteBuf.readRetainedSlice(iMin4);
                long j12 = this.chunkSize - ((long) iMin4);
                this.chunkSize = j12;
                if (j12 != 0) {
                    list.add(new DefaultHttpContent(retainedSlice));
                    return;
                } else {
                    list.add(new DefaultLastHttpContent(retainedSlice, this.validateHeaders));
                    resetNow();
                    return;
                }
            case 7:
                int iMin5 = Math.min((int) this.chunkSize, this.maxChunkSize);
                if (this.allowPartialChunks) {
                    break;
                }
                DefaultHttpContent defaultHttpContent2 = new DefaultHttpContent(byteBuf.readRetainedSlice(iMin));
                this.chunkSize -= (long) iMin;
                list.add(defaultHttpContent2);
                if (this.chunkSize != 0) {
                    return;
                }
                this.currentState = State.READ_CHUNK_DELIMITER;
                iWriterIndex = byteBuf.writerIndex();
                i11 = byteBuf.readerIndex();
                while (iWriterIndex > i11) {
                    i12 = i11 + 1;
                    if (byteBuf.getByte(i11) == 10) {
                        this.currentState = State.READ_CHUNK_SIZE;
                        i11 = i12;
                        byteBuf.readerIndex(i11);
                        return;
                    }
                    i11 = i12;
                }
                byteBuf.readerIndex(i11);
                return;
            case 8:
                iWriterIndex = byteBuf.writerIndex();
                i11 = byteBuf.readerIndex();
                while (iWriterIndex > i11) {
                    i12 = i11 + 1;
                    if (byteBuf.getByte(i11) == 10) {
                        this.currentState = State.READ_CHUNK_SIZE;
                        i11 = i12;
                        byteBuf.readerIndex(i11);
                        return;
                    }
                    i11 = i12;
                }
                byteBuf.readerIndex(i11);
                return;
            case 9:
                try {
                    LastHttpContent trailingHeaders = readTrailingHeaders(byteBuf);
                    if (trailingHeaders == null) {
                        return;
                    }
                    list.add(trailingHeaders);
                    resetNow();
                    return;
                } catch (Exception e13) {
                    list.add(invalidChunk(byteBuf, e13));
                    return;
                }
            case 10:
                byteBuf.skipBytes(byteBuf.readableBytes());
                return;
            case 11:
                int i14 = byteBuf.readableBytes();
                if (i14 > 0) {
                    list.add(byteBuf.readBytes(i14));
                    return;
                }
                return;
            default:
                return;
        }
    }

    protected boolean isContentAlwaysEmpty(HttpMessage httpMessage) {
        if (!(httpMessage instanceof HttpResponse)) {
            return false;
        }
        HttpResponse httpResponse = (HttpResponse) httpMessage;
        int iCode = httpResponse.status().code();
        if (iCode < 100 || iCode >= 200) {
            return iCode == 204 || iCode == 304;
        }
        return (iCode == 101 && !httpResponse.headers().contains(HttpHeaderNames.SEC_WEBSOCKET_ACCEPT) && httpResponse.headers().contains((CharSequence) HttpHeaderNames.UPGRADE, (CharSequence) HttpHeaderValues.WEBSOCKET, true)) ? false : true;
    }

    protected HttpObjectDecoder(int i10, int i11, int i12, boolean z10, boolean z11, int i13) {
        this(i10, i11, i12, z10, z11, i13, false);
    }

    private static int findEndOfString(AppendableCharSequence appendableCharSequence) {
        for (int length = appendableCharSequence.length() - 1; length > 0; length--) {
            if (!Character.isWhitespace(appendableCharSequence.charAtUnsafe(length))) {
                return length + 1;
            }
        }
        return 0;
    }

    private static int findNonSPLenient(AppendableCharSequence appendableCharSequence, int i10) {
        while (i10 < appendableCharSequence.length()) {
            char cCharAtUnsafe = appendableCharSequence.charAtUnsafe(i10);
            if (isSPLenient(cCharAtUnsafe)) {
                i10++;
            } else {
                if (!Character.isWhitespace(cCharAtUnsafe)) {
                    return i10;
                }
                throw new IllegalArgumentException("Invalid separator");
            }
        }
        return appendableCharSequence.length();
    }

    private static int findNonWhitespace(AppendableCharSequence appendableCharSequence, int i10) {
        while (i10 < appendableCharSequence.length()) {
            char cCharAtUnsafe = appendableCharSequence.charAtUnsafe(i10);
            if (!Character.isWhitespace(cCharAtUnsafe)) {
                return i10;
            }
            if (isOWS(cCharAtUnsafe)) {
                i10++;
            } else {
                throw new IllegalArgumentException("Invalid separator, only a single space or horizontal tab allowed, but received a '" + cCharAtUnsafe + "' (0x" + Integer.toHexString(cCharAtUnsafe) + ")");
            }
        }
        return appendableCharSequence.length();
    }

    private static int findSPLenient(AppendableCharSequence appendableCharSequence, int i10) {
        while (i10 < appendableCharSequence.length()) {
            if (isSPLenient(appendableCharSequence.charAtUnsafe(i10))) {
                return i10;
            }
            i10++;
        }
        return appendableCharSequence.length();
    }

    private static int getChunkSize(String str) {
        String strTrim = str.trim();
        for (int i10 = 0; i10 < strTrim.length(); i10++) {
            char cCharAt = strTrim.charAt(i10);
            if (cCharAt == ';' || Character.isWhitespace(cCharAt) || Character.isISOControl(cCharAt)) {
                strTrim = strTrim.substring(0, i10);
                break;
            }
        }
        return Integer.parseInt(strTrim, 16);
    }

    private void splitHeader(AppendableCharSequence appendableCharSequence) {
        char cCharAtUnsafe;
        int length = appendableCharSequence.length();
        int iFindNonWhitespace = findNonWhitespace(appendableCharSequence, 0);
        int i10 = iFindNonWhitespace;
        while (i10 < length && (cCharAtUnsafe = appendableCharSequence.charAtUnsafe(i10)) != ':' && (isDecodingRequest() || !isOWS(cCharAtUnsafe))) {
            i10++;
        }
        if (i10 != length) {
            int i11 = i10;
            while (i11 < length) {
                if (appendableCharSequence.charAtUnsafe(i11) == ':') {
                    i11++;
                    break;
                }
                i11++;
            }
            this.name = appendableCharSequence.subStringUnsafe(iFindNonWhitespace, i10);
            int iFindNonWhitespace2 = findNonWhitespace(appendableCharSequence, i11);
            if (iFindNonWhitespace2 == length) {
                this.value = "";
                return;
            } else {
                this.value = appendableCharSequence.subStringUnsafe(iFindNonWhitespace2, findEndOfString(appendableCharSequence));
                return;
            }
        }
        throw new IllegalArgumentException("No colon found");
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    protected void decodeLast(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
        super.decodeLast(channelHandlerContext, byteBuf, list);
        if (this.resetRequested) {
            resetNow();
        }
        HttpMessage httpMessage = this.message;
        if (httpMessage != null) {
            boolean zIsTransferEncodingChunked = HttpUtil.isTransferEncodingChunked(httpMessage);
            if (this.currentState == State.READ_VARIABLE_LENGTH_CONTENT && !byteBuf.isReadable() && !zIsTransferEncodingChunked) {
                list.add(LastHttpContent.EMPTY_LAST_CONTENT);
                resetNow();
            } else {
                if (this.currentState == State.READ_HEADER) {
                    list.add(invalidMessage(Unpooled.EMPTY_BUFFER, new PrematureChannelClosureException("Connection closed before received headers")));
                    resetNow();
                    return;
                }
                if (!isDecodingRequest() && !zIsTransferEncodingChunked && contentLength() <= 0) {
                    list.add(LastHttpContent.EMPTY_LAST_CONTENT);
                }
                resetNow();
            }
        }
    }

    protected void handleTransferEncodingChunkedWithContentLength(HttpMessage httpMessage) {
        httpMessage.headers().remove(HttpHeaderNames.CONTENT_LENGTH);
        this.contentLength = Long.MIN_VALUE;
    }

    protected boolean isSwitchingToNonHttp1Protocol(HttpResponse httpResponse) {
        if (httpResponse.status().code() != HttpResponseStatus.SWITCHING_PROTOCOLS.code()) {
            return false;
        }
        String str = httpResponse.headers().get(HttpHeaderNames.UPGRADE);
        if (str != null) {
            if (str.contains(HttpVersion.HTTP_1_0.text()) || str.contains(HttpVersion.HTTP_1_1.text())) {
                return false;
            }
            return true;
        }
        return true;
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder, io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void userEventTriggered(ChannelHandlerContext channelHandlerContext, Object obj) {
        super.userEventTriggered(channelHandlerContext, obj);
    }

    protected HttpObjectDecoder(int i10, int i11, int i12, boolean z10, boolean z11, int i13, boolean z12) {
        this(i10, i11, i12, z10, z11, i13, z12, true);
    }

    protected HttpObjectDecoder(int i10, int i11, int i12, boolean z10, boolean z11, int i13, boolean z12, boolean z13) {
        this.contentLength = Long.MIN_VALUE;
        this.currentState = State.SKIP_CONTROL_CHARS;
        ObjectUtil.checkPositive(i10, "maxInitialLineLength");
        ObjectUtil.checkPositive(i11, "maxHeaderSize");
        ObjectUtil.checkPositive(i12, "maxChunkSize");
        AppendableCharSequence appendableCharSequence = new AppendableCharSequence(i13);
        this.lineParser = new LineParser(appendableCharSequence, i10);
        this.headerParser = new HeaderParser(appendableCharSequence, i11);
        this.maxChunkSize = i12;
        this.chunkedSupported = z10;
        this.validateHeaders = z11;
        this.allowDuplicateContentLengths = z12;
        this.allowPartialChunks = z13;
    }
}
