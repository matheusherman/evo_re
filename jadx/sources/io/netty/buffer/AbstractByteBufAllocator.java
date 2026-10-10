package io.netty.buffer;

import io.netty.util.ResourceLeakDetector;
import io.netty.util.ResourceLeakTracker;
import io.netty.util.internal.MathUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class AbstractByteBufAllocator implements ByteBufAllocator {
    private final boolean directByDefault;
    private final ByteBuf emptyBuf;

    protected AbstractByteBufAllocator() {
        this(false);
    }

    protected static ByteBuf toLeakAwareBuffer(ByteBuf byteBuf) {
        ResourceLeakTracker<ByteBuf> resourceLeakTrackerTrack;
        int i10 = AnonymousClass1.$SwitchMap$io$netty$util$ResourceLeakDetector$Level[ResourceLeakDetector.getLevel().ordinal()];
        if (i10 == 1) {
            ResourceLeakTracker<ByteBuf> resourceLeakTrackerTrack2 = AbstractByteBuf.leakDetector.track(byteBuf);
            if (resourceLeakTrackerTrack2 != null) {
                return new SimpleLeakAwareByteBuf(byteBuf, resourceLeakTrackerTrack2);
            }
        } else if ((i10 == 2 || i10 == 3) && (resourceLeakTrackerTrack = AbstractByteBuf.leakDetector.track(byteBuf)) != null) {
            return new AdvancedLeakAwareByteBuf(byteBuf, resourceLeakTrackerTrack);
        }
        return byteBuf;
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf buffer(int i10) {
        return this.directByDefault ? directBuffer(i10) : heapBuffer(i10);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf directBuffer(int i10) {
        return directBuffer(i10, Integer.MAX_VALUE);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf heapBuffer() {
        return heapBuffer(256, Integer.MAX_VALUE);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf ioBuffer() {
        return (PlatformDependent.hasUnsafe() || isDirectBufferPooled()) ? directBuffer(256) : heapBuffer(256);
    }

    protected abstract ByteBuf newDirectBuffer(int i10, int i11);

    protected abstract ByteBuf newHeapBuffer(int i10, int i11);

    /* JADX INFO: renamed from: io.netty.buffer.AbstractByteBufAllocator$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$util$ResourceLeakDetector$Level;

        static {
            int[] iArr = new int[ResourceLeakDetector.Level.values().length];
            $SwitchMap$io$netty$util$ResourceLeakDetector$Level = iArr;
            try {
                iArr[ResourceLeakDetector.Level.SIMPLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$util$ResourceLeakDetector$Level[ResourceLeakDetector.Level.ADVANCED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$util$ResourceLeakDetector$Level[ResourceLeakDetector.Level.PARANOID.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        ResourceLeakDetector.addExclusions(AbstractByteBufAllocator.class, "toLeakAwareBuffer");
    }

    protected AbstractByteBufAllocator(boolean z10) {
        this.directByDefault = z10 && PlatformDependent.hasUnsafe();
        this.emptyBuf = new EmptyByteBuf(this);
    }

    private static void validate(int i10, int i11) {
        ObjectUtil.checkPositiveOrZero(i10, "initialCapacity");
        if (i10 > i11) {
            throw new IllegalArgumentException(String.format("initialCapacity: %d (expected: not greater than maxCapacity(%d)", Integer.valueOf(i10), Integer.valueOf(i11)));
        }
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public int calculateNewCapacity(int i10, int i11) {
        ObjectUtil.checkPositiveOrZero(i10, "minNewCapacity");
        if (i10 > i11) {
            throw new IllegalArgumentException(String.format("minNewCapacity: %d (expected: not greater than maxCapacity(%d)", Integer.valueOf(i10), Integer.valueOf(i11)));
        }
        if (i10 == 4194304) {
            return 4194304;
        }
        if (i10 <= 4194304) {
            return Math.min(MathUtil.findNextPositivePowerOfTwo(Math.max(i10, 64)), i11);
        }
        int i12 = (i10 / 4194304) * 4194304;
        return i12 > i11 - 4194304 ? i11 : i12 + 4194304;
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public CompositeByteBuf compositeBuffer(int i10) {
        return this.directByDefault ? compositeDirectBuffer(i10) : compositeHeapBuffer(i10);
    }

    public CompositeByteBuf compositeDirectBuffer(int i10) {
        return toLeakAwareBuffer(new CompositeByteBuf(this, true, i10));
    }

    public CompositeByteBuf compositeHeapBuffer(int i10) {
        return toLeakAwareBuffer(new CompositeByteBuf(this, false, i10));
    }

    public ByteBuf directBuffer(int i10, int i11) {
        if (i10 == 0 && i11 == 0) {
            return this.emptyBuf;
        }
        validate(i10, i11);
        return newDirectBuffer(i10, i11);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf heapBuffer(int i10) {
        return heapBuffer(i10, Integer.MAX_VALUE);
    }

    public String toString() {
        return StringUtil.simpleClassName(this) + "(directByDefault: " + this.directByDefault + ')';
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf heapBuffer(int i10, int i11) {
        if (i10 == 0 && i11 == 0) {
            return this.emptyBuf;
        }
        validate(i10, i11);
        return newHeapBuffer(i10, i11);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf buffer(int i10, int i11) {
        if (this.directByDefault) {
            return directBuffer(i10, i11);
        }
        return heapBuffer(i10, i11);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public ByteBuf ioBuffer(int i10) {
        if (!PlatformDependent.hasUnsafe() && !isDirectBufferPooled()) {
            return heapBuffer(i10);
        }
        return directBuffer(i10);
    }

    protected static CompositeByteBuf toLeakAwareBuffer(CompositeByteBuf compositeByteBuf) {
        ResourceLeakTracker<ByteBuf> resourceLeakTrackerTrack;
        int i10 = AnonymousClass1.$SwitchMap$io$netty$util$ResourceLeakDetector$Level[ResourceLeakDetector.getLevel().ordinal()];
        if (i10 == 1) {
            ResourceLeakTracker<ByteBuf> resourceLeakTrackerTrack2 = AbstractByteBuf.leakDetector.track(compositeByteBuf);
            if (resourceLeakTrackerTrack2 != null) {
                return new SimpleLeakAwareCompositeByteBuf(compositeByteBuf, resourceLeakTrackerTrack2);
            }
        } else if ((i10 == 2 || i10 == 3) && (resourceLeakTrackerTrack = AbstractByteBuf.leakDetector.track(compositeByteBuf)) != null) {
            return new AdvancedLeakAwareCompositeByteBuf(compositeByteBuf, resourceLeakTrackerTrack);
        }
        return compositeByteBuf;
    }
}
