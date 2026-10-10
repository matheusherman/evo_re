package androidx.paging.multicast;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import c9.p;
import com.pengrad.telegrambot.model.message.origin.MessageOriginChannel;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.b;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.channels.v;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w;
import r8.r;
import r8.z;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import v8.f;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0003\"#$B`\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\"\u0010\f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\u0015\u001a\u00020\u000b2\u0012\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00130\u0012H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u0017\u001a\u00020\u000b2\u0012\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00130\u0012H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0016J\u0013\u0010\u0018\u001a\u00020\u000bH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001b\u001a\f0\u001aR\b\u0012\u0004\u0012\u00028\u00000\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u001dR\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u001eR\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u001fR3\u0010\f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t8\u0002X\u0082\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b\f\u0010 R\u0014\u0010\r\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u001fR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010!\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006%"}, d2 = {"Landroidx/paging/multicast/ChannelManager;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlinx/coroutines/l0;", "scope", "", "bufferSize", "", "piggybackingDownstream", "Lkotlin/Function2;", "Lv8/f;", "Lr8/z;", "onEach", "keepUpstreamAlive", "Lkotlinx/coroutines/flow/f;", "upstream", "<init>", "(Lkotlinx/coroutines/l0;IZLc9/p;ZLkotlinx/coroutines/flow/f;)V", "Lkotlinx/coroutines/channels/v;", "Landroidx/paging/multicast/ChannelManager$Message$Dispatch$Value;", MessageOriginChannel.MESSAGE_ORIGIN_TYPE, "addDownstream", "(Lkotlinx/coroutines/channels/v;Lv8/f;)Ljava/lang/Object;", "removeDownstream", "close", "(Lv8/f;)Ljava/lang/Object;", "Landroidx/paging/multicast/ChannelManager$Actor;", "actor", "Landroidx/paging/multicast/ChannelManager$Actor;", "Lkotlinx/coroutines/l0;", "I", "Z", "Lc9/p;", "Lkotlinx/coroutines/flow/f;", "Actor", "ChannelEntry", "Message", "paging-common"}, k = 1, mv = {1, 4, 1})
public final class ChannelManager<T> {
    private final ChannelManager<T>.Actor actor;
    private final int bufferSize;
    private final boolean keepUpstreamAlive;
    private final p<T, f<? super z>, Object> onEach;
    private final boolean piggybackingDownstream;
    private final l0 scope;
    private final kotlinx.coroutines.flow.f<T> upstream;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\n\u001a\u00020\t2\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u000e\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0012\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0014\u0010\u0011J!\u0010\u0016\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u001a\u001a\u00020\t2\u0012\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00150\u0018H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ!\u0010\u001d\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cH\u0082@ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ!\u0010!\u001a\u00020\t2\f\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u001fH\u0082@ø\u0001\u0000¢\u0006\u0004\b!\u0010\"R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010&R\u0016\u0010(\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u001e\u0010+\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R \u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001f0-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/\u0082\u0002\u0004\n\u0002\b\u0019¨\u00060"}, d2 = {"Landroidx/paging/multicast/ChannelManager$Actor;", "Landroidx/paging/multicast/StoreRealActor;", "Landroidx/paging/multicast/ChannelManager$Message;", "<init>", "(Landroidx/paging/multicast/ChannelManager;)V", "Landroidx/paging/multicast/SharedFlowProducer;", "newProducer", "()Landroidx/paging/multicast/SharedFlowProducer;", "producer", "Lr8/z;", "doHandleUpstreamClose", "(Landroidx/paging/multicast/SharedFlowProducer;)V", "Landroidx/paging/multicast/ChannelManager$Message$Dispatch$Error;", NotificationCompat.CATEGORY_MESSAGE, "doDispatchError", "(Landroidx/paging/multicast/ChannelManager$Message$Dispatch$Error;)V", "activateIfNecessary", "()V", "handle", "(Landroidx/paging/multicast/ChannelManager$Message;Lv8/f;)Ljava/lang/Object;", "onClosed", "Landroidx/paging/multicast/ChannelManager$Message$Dispatch$Value;", "doDispatchValue", "(Landroidx/paging/multicast/ChannelManager$Message$Dispatch$Value;Lv8/f;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/v;", MessageOriginChannel.MESSAGE_ORIGIN_TYPE, "doRemove", "(Lkotlinx/coroutines/channels/v;Lv8/f;)Ljava/lang/Object;", "Landroidx/paging/multicast/ChannelManager$Message$AddChannel;", "doAdd", "(Landroidx/paging/multicast/ChannelManager$Message$AddChannel;Lv8/f;)Ljava/lang/Object;", "Landroidx/paging/multicast/ChannelManager$ChannelEntry;", "entry", "addEntry", "(Landroidx/paging/multicast/ChannelManager$ChannelEntry;Lv8/f;)Ljava/lang/Object;", "Landroidx/paging/multicast/Buffer;", "buffer", "Landroidx/paging/multicast/Buffer;", "Landroidx/paging/multicast/SharedFlowProducer;", "", "dispatchedValue", "Z", "Lkotlinx/coroutines/w;", "lastDeliveryAck", "Lkotlinx/coroutines/w;", "", "channels", "Ljava/util/List;", "paging-common"}, k = 1, mv = {1, 4, 1})
    final class Actor extends StoreRealActor<Message<T>> {
        private final Buffer<T> buffer;
        private final List<ChannelEntry<T>> channels;
        private boolean dispatchedValue;
        private w<z> lastDeliveryAck;
        private SharedFlowProducer<T> producer;

        private final void doDispatchError(Message.Dispatch.Error<T> msg) {
            this.dispatchedValue = true;
            Iterator<T> it = this.channels.iterator();
            while (it.hasNext()) {
                ((ChannelEntry) it.next()).dispatchError(msg.getError());
            }
        }

        @Override // androidx.paging.multicast.StoreRealActor
        public /* bridge */ /* synthetic */ Object handle(Object obj, f fVar) {
            return handle((Message) obj, (f<? super z>) fVar);
        }

        public Actor() {
            super(ChannelManager.this.scope);
            this.buffer = ChannelManagerKt.Buffer(ChannelManager.this.bufferSize);
            this.channels = new ArrayList();
        }

        private final void activateIfNecessary() {
            if (this.producer == null) {
                SharedFlowProducer<T> sharedFlowProducerNewProducer = newProducer();
                this.producer = sharedFlowProducerNewProducer;
                this.dispatchedValue = false;
                m.c(sharedFlowProducerNewProducer);
                sharedFlowProducerNewProducer.start();
            }
        }

        private final void doHandleUpstreamClose(SharedFlowProducer<T> producer) {
            if (this.producer != producer) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Iterator<T> it = this.channels.iterator();
            while (it.hasNext()) {
                ChannelEntry channelEntry = (ChannelEntry) it.next();
                if (channelEntry.getReceivedValue()) {
                    if (ChannelManager.this.piggybackingDownstream) {
                        arrayList.add(channelEntry);
                    } else {
                        channelEntry.close();
                    }
                } else if (this.dispatchedValue) {
                    arrayList2.add(channelEntry);
                } else if (ChannelManager.this.piggybackingDownstream) {
                    arrayList.add(channelEntry);
                } else {
                    channelEntry.close();
                }
            }
            this.channels.clear();
            this.channels.addAll(arrayList2);
            this.channels.addAll(arrayList);
            this.producer = null;
            if (arrayList2.isEmpty()) {
                return;
            }
            activateIfNecessary();
        }

        private final SharedFlowProducer<T> newProducer() {
            return new SharedFlowProducer<>(ChannelManager.this.scope, ChannelManager.this.upstream, new ChannelManager$Actor$newProducer$1(this));
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        final /* synthetic */ Object addEntry(ChannelEntry<T> channelEntry, f<? super z> fVar) {
            ChannelManager$Actor$addEntry$1 channelManager$Actor$addEntry$1;
            boolean z10;
            ChannelEntry channelEntry2;
            Iterator<T> it;
            if (fVar instanceof ChannelManager$Actor$addEntry$1) {
                channelManager$Actor$addEntry$1 = (ChannelManager$Actor$addEntry$1) fVar;
                int i10 = channelManager$Actor$addEntry$1.label;
                if ((i10 & Integer.MIN_VALUE) != 0) {
                    channelManager$Actor$addEntry$1.label = i10 - Integer.MIN_VALUE;
                } else {
                    channelManager$Actor$addEntry$1 = new ChannelManager$Actor$addEntry$1(this, fVar);
                }
            } else {
                channelManager$Actor$addEntry$1 = new ChannelManager$Actor$addEntry$1(this, fVar);
            }
            Object obj = channelManager$Actor$addEntry$1.result;
            Object objC = b.c();
            int i11 = channelManager$Actor$addEntry$1.label;
            if (i11 == 0) {
                r.b(obj);
                List<ChannelEntry<T>> list = this.channels;
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    Iterator<T> it2 = list.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            z10 = true;
                            break;
                        }
                        if (kotlin.coroutines.jvm.internal.b.a(((ChannelEntry) it2.next()).hasChannel(channelEntry)).booleanValue()) {
                            z10 = false;
                            break;
                        }
                    }
                } else {
                    z10 = true;
                    break;
                }
                if (!z10) {
                    throw new IllegalStateException((channelEntry + " is already in the list.").toString());
                }
                if (channelEntry.getReceivedValue()) {
                    throw new IllegalStateException((channelEntry + " already received a value").toString());
                }
                this.channels.add(channelEntry);
                if (this.buffer.getItems().isEmpty()) {
                    w<z> wVar = this.lastDeliveryAck;
                    if (wVar != null) {
                        kotlin.coroutines.jvm.internal.b.a(wVar.r(z.f17874a));
                    }
                } else {
                    channelEntry2 = channelEntry;
                    it = this.buffer.getItems().iterator();
                }
                return z.f17874a;
            }
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            it = (Iterator) channelManager$Actor$addEntry$1.L$1;
            ChannelEntry channelEntry3 = (ChannelEntry) channelManager$Actor$addEntry$1.L$0;
            r.b(obj);
            channelEntry2 = channelEntry3;
            while (it.hasNext()) {
                Message.Dispatch.Value<T> value = (Message.Dispatch.Value) it.next();
                channelManager$Actor$addEntry$1.L$0 = channelEntry2;
                channelManager$Actor$addEntry$1.L$1 = it;
                channelManager$Actor$addEntry$1.label = 1;
                if (channelEntry2.dispatchValue(value, channelManager$Actor$addEntry$1) == objC) {
                    return objC;
                }
            }
            return z.f17874a;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        final /* synthetic */ Object doAdd(Message.AddChannel<T> addChannel, f<? super z> fVar) {
            ChannelManager$Actor$doAdd$1 channelManager$Actor$doAdd$1;
            Actor actor;
            if (fVar instanceof ChannelManager$Actor$doAdd$1) {
                channelManager$Actor$doAdd$1 = (ChannelManager$Actor$doAdd$1) fVar;
                int i10 = channelManager$Actor$doAdd$1.label;
                if ((i10 & Integer.MIN_VALUE) != 0) {
                    channelManager$Actor$doAdd$1.label = i10 - Integer.MIN_VALUE;
                } else {
                    channelManager$Actor$doAdd$1 = new ChannelManager$Actor$doAdd$1(this, fVar);
                }
            } else {
                channelManager$Actor$doAdd$1 = new ChannelManager$Actor$doAdd$1(this, fVar);
            }
            Object obj = channelManager$Actor$doAdd$1.result;
            Object objC = b.c();
            int i11 = channelManager$Actor$doAdd$1.label;
            if (i11 == 0) {
                r.b(obj);
                ChannelEntry<T> channelEntry = new ChannelEntry<>(addChannel.getChannel(), false, 2, null);
                channelManager$Actor$doAdd$1.L$0 = this;
                channelManager$Actor$doAdd$1.label = 1;
                if (addEntry(channelEntry, channelManager$Actor$doAdd$1) == objC) {
                    return objC;
                }
                actor = this;
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                actor = (Actor) channelManager$Actor$doAdd$1.L$0;
                r.b(obj);
            }
            actor.activateIfNecessary();
            return z.f17874a;
        }

        /* JADX WARN: Code duplicated, block: B:26:0x0088  */
        /* JADX WARN: Code duplicated, block: B:32:0x009a A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:34:? A[LOOP:0: B:24:0x0082->B:34:?, LOOP_END, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        final /* synthetic */ Object doDispatchValue(Message.Dispatch.Value<T> value, f<? super z> fVar) {
            ChannelManager$Actor$doDispatchValue$1 channelManager$Actor$doDispatchValue$1;
            Actor actor;
            Message.Dispatch.Value<T> value2;
            Iterator<T> it;
            ChannelEntry channelEntry;
            if (fVar instanceof ChannelManager$Actor$doDispatchValue$1) {
                channelManager$Actor$doDispatchValue$1 = (ChannelManager$Actor$doDispatchValue$1) fVar;
                int i10 = channelManager$Actor$doDispatchValue$1.label;
                if ((i10 & Integer.MIN_VALUE) != 0) {
                    channelManager$Actor$doDispatchValue$1.label = i10 - Integer.MIN_VALUE;
                } else {
                    channelManager$Actor$doDispatchValue$1 = new ChannelManager$Actor$doDispatchValue$1(this, fVar);
                }
            } else {
                channelManager$Actor$doDispatchValue$1 = new ChannelManager$Actor$doDispatchValue$1(this, fVar);
            }
            Object obj = channelManager$Actor$doDispatchValue$1.result;
            Object objC = b.c();
            int i11 = channelManager$Actor$doDispatchValue$1.label;
            if (i11 == 0) {
                r.b(obj);
                p pVar = ChannelManager.this.onEach;
                T value3 = value.getValue();
                channelManager$Actor$doDispatchValue$1.L$0 = this;
                channelManager$Actor$doDispatchValue$1.L$1 = value;
                channelManager$Actor$doDispatchValue$1.label = 1;
                if (pVar.invoke(value3, channelManager$Actor$doDispatchValue$1) != objC) {
                    actor = this;
                }
                return objC;
            }
            if (i11 == 1) {
                value = (Message.Dispatch.Value) channelManager$Actor$doDispatchValue$1.L$1;
                actor = (Actor) channelManager$Actor$doDispatchValue$1.L$0;
                r.b(obj);
            } else {
                if (i11 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                it = (Iterator) channelManager$Actor$doDispatchValue$1.L$1;
                value2 = (Message.Dispatch.Value) channelManager$Actor$doDispatchValue$1.L$0;
                r.b(obj);
            }
            while (it.hasNext()) {
                channelEntry = (ChannelEntry) it.next();
                channelManager$Actor$doDispatchValue$1.L$0 = value2;
                channelManager$Actor$doDispatchValue$1.L$1 = it;
                channelManager$Actor$doDispatchValue$1.label = 2;
                if (channelEntry.dispatchValue(value2, channelManager$Actor$doDispatchValue$1) == objC) {
                    return objC;
                }
            }
            return z.f17874a;
            actor.buffer.add(value);
            actor.dispatchedValue = true;
            if (actor.buffer.isEmpty()) {
                actor.lastDeliveryAck = value.getDelivered();
            }
            Iterator<T> it2 = actor.channels.iterator();
            value2 = value;
            it = it2;
            while (it.hasNext()) {
                channelEntry = (ChannelEntry) it.next();
                channelManager$Actor$doDispatchValue$1.L$0 = value2;
                channelManager$Actor$doDispatchValue$1.L$1 = it;
                channelManager$Actor$doDispatchValue$1.label = 2;
                if (channelEntry.dispatchValue(value2, channelManager$Actor$doDispatchValue$1) == objC) {
                    return objC;
                }
            }
            return z.f17874a;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        final /* synthetic */ Object doRemove(v<? super Message.Dispatch.Value<T>> vVar, f<? super z> fVar) {
            ChannelManager$Actor$doRemove$1 channelManager$Actor$doRemove$1;
            SharedFlowProducer<T> sharedFlowProducer;
            if (fVar instanceof ChannelManager$Actor$doRemove$1) {
                channelManager$Actor$doRemove$1 = (ChannelManager$Actor$doRemove$1) fVar;
                int i10 = channelManager$Actor$doRemove$1.label;
                if ((i10 & Integer.MIN_VALUE) != 0) {
                    channelManager$Actor$doRemove$1.label = i10 - Integer.MIN_VALUE;
                } else {
                    channelManager$Actor$doRemove$1 = new ChannelManager$Actor$doRemove$1(this, fVar);
                }
            } else {
                channelManager$Actor$doRemove$1 = new ChannelManager$Actor$doRemove$1(this, fVar);
            }
            Object obj = channelManager$Actor$doRemove$1.result;
            Object objC = b.c();
            int i11 = channelManager$Actor$doRemove$1.label;
            if (i11 == 0) {
                r.b(obj);
                Iterator<ChannelEntry<T>> it = this.channels.iterator();
                int i12 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        i12 = -1;
                        break;
                    }
                    if (kotlin.coroutines.jvm.internal.b.a(it.next().hasChannel(vVar)).booleanValue()) {
                        break;
                    }
                    i12++;
                }
                if (i12 >= 0) {
                    this.channels.remove(i12);
                    if (this.channels.isEmpty() && !ChannelManager.this.keepUpstreamAlive && (sharedFlowProducer = this.producer) != null) {
                        channelManager$Actor$doRemove$1.label = 1;
                        if (sharedFlowProducer.cancelAndJoin(channelManager$Actor$doRemove$1) == objC) {
                            return objC;
                        }
                    }
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                r.b(obj);
            }
            return z.f17874a;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x0047, code lost:
        
            if (doAdd((androidx.paging.multicast.ChannelManager.Message.AddChannel) r7, r0) == r1) goto L31;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x005a, code lost:
        
            if (doRemove(r7, r0) == r1) goto L31;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0069, code lost:
        
            if (doDispatchValue((androidx.paging.multicast.ChannelManager.Message.Dispatch.Value) r7, r0) == r1) goto L31;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x006b, code lost:
        
            return r1;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Object handle(Message<T> message, f<? super z> fVar) {
            ChannelManager$Actor$handle$1 channelManager$Actor$handle$1;
            if (fVar instanceof ChannelManager$Actor$handle$1) {
                channelManager$Actor$handle$1 = (ChannelManager$Actor$handle$1) fVar;
                int i10 = channelManager$Actor$handle$1.label;
                if ((i10 & Integer.MIN_VALUE) != 0) {
                    channelManager$Actor$handle$1.label = i10 - Integer.MIN_VALUE;
                } else {
                    channelManager$Actor$handle$1 = new ChannelManager$Actor$handle$1(this, fVar);
                }
            } else {
                channelManager$Actor$handle$1 = new ChannelManager$Actor$handle$1(this, fVar);
            }
            Object obj = channelManager$Actor$handle$1.result;
            Object objC = b.c();
            int i11 = channelManager$Actor$handle$1.label;
            if (i11 == 0) {
                r.b(obj);
                if (message instanceof Message.AddChannel) {
                    channelManager$Actor$handle$1.label = 1;
                } else if (message instanceof Message.RemoveChannel) {
                    v<Message.Dispatch.Value<T>> channel = ((Message.RemoveChannel) message).getChannel();
                    channelManager$Actor$handle$1.label = 2;
                } else if (message instanceof Message.Dispatch.Value) {
                    channelManager$Actor$handle$1.label = 3;
                } else if (message instanceof Message.Dispatch.Error) {
                    doDispatchError((Message.Dispatch.Error) message);
                } else if (message instanceof Message.Dispatch.UpstreamFinished) {
                    doHandleUpstreamClose(((Message.Dispatch.UpstreamFinished) message).getProducer());
                }
            } else {
                if (i11 != 1 && i11 != 2 && i11 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                r.b(obj);
            }
            return z.f17874a;
        }

        @Override // androidx.paging.multicast.StoreRealActor
        public void onClosed() {
            Iterator<T> it = this.channels.iterator();
            while (it.hasNext()) {
                ((ChannelEntry) it.next()).close();
            }
            this.channels.clear();
            SharedFlowProducer<T> sharedFlowProducer = this.producer;
            if (sharedFlowProducer != null) {
                sharedFlowProducer.cancel();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0080\b\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B%\u0012\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00040\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001c\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00040\u0003HÂ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0006HÂ\u0003¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0010\u001a\u00020\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\u000f¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u0018\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00040\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u001b\u0010\u0018\u001a\u00020\u00062\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000¢\u0006\u0004\b\u0018\u0010\u001bJ6\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00040\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001f\u001a\u00020\u001eHÖ\u0001¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\"\u001a\u00020!HÖ\u0001¢\u0006\u0004\b\"\u0010#J\u001a\u0010%\u001a\u00020\u00062\b\u0010$\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b%\u0010&R \u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00040\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010'R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010(R\u0011\u0010*\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b)\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006+"}, d2 = {"Landroidx/paging/multicast/ChannelManager$ChannelEntry;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlinx/coroutines/channels/v;", "Landroidx/paging/multicast/ChannelManager$Message$Dispatch$Value;", MessageOriginChannel.MESSAGE_ORIGIN_TYPE, "", "_receivedValue", "<init>", "(Lkotlinx/coroutines/channels/v;Z)V", "component1", "()Lkotlinx/coroutines/channels/v;", "component2", "()Z", "value", "Lr8/z;", "dispatchValue", "(Landroidx/paging/multicast/ChannelManager$Message$Dispatch$Value;Lv8/f;)Ljava/lang/Object;", "", IjkMediaPlayer.OnNativeInvokeListener.ARG_ERROR, "dispatchError", "(Ljava/lang/Throwable;)V", "close", "()V", "hasChannel", "(Lkotlinx/coroutines/channels/v;)Z", "entry", "(Landroidx/paging/multicast/ChannelManager$ChannelEntry;)Z", "copy", "(Lkotlinx/coroutines/channels/v;Z)Landroidx/paging/multicast/ChannelManager$ChannelEntry;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", TransactionPartnerType.OTHER, "equals", "(Ljava/lang/Object;)Z", "Lkotlinx/coroutines/channels/v;", "Z", "getReceivedValue", "receivedValue", "paging-common"}, k = 1, mv = {1, 4, 1})
    public static final /* data */ class ChannelEntry<T> {
        private boolean _receivedValue;
        private final v<Message.Dispatch.Value<T>> channel;

        /* JADX WARN: Multi-variable type inference failed */
        public ChannelEntry(v<? super Message.Dispatch.Value<T>> channel, boolean z10) {
            m.f(channel, "channel");
            this.channel = channel;
            this._receivedValue = z10;
        }

        public final Object dispatchValue(Message.Dispatch.Value<T> value, f<? super z> fVar) {
            this._receivedValue = true;
            Object objB = this.channel.b(value, fVar);
            return objB == b.c() ? objB : z.f17874a;
        }

        public final boolean hasChannel(v<? super Message.Dispatch.Value<T>> channel) {
            m.f(channel, "channel");
            return this.channel == channel;
        }

        public /* synthetic */ ChannelEntry(v vVar, boolean z10, int i10, g gVar) {
            this(vVar, (i10 & 2) != 0 ? false : z10);
        }

        private final v<Message.Dispatch.Value<T>> component1() {
            return this.channel;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        private final boolean get_receivedValue() {
            return this._receivedValue;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ChannelEntry copy$default(ChannelEntry channelEntry, v vVar, boolean z10, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                vVar = channelEntry.channel;
            }
            if ((i10 & 2) != 0) {
                z10 = channelEntry._receivedValue;
            }
            return channelEntry.copy(vVar, z10);
        }

        public final void close() {
            v.a.a(this.channel, null, 1, null);
        }

        public final ChannelEntry<T> copy(v<? super Message.Dispatch.Value<T>> channel, boolean _receivedValue) {
            m.f(channel, "channel");
            return new ChannelEntry<>(channel, _receivedValue);
        }

        public final void dispatchError(Throwable error) {
            m.f(error, "error");
            this._receivedValue = true;
            this.channel.g(error);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ChannelEntry)) {
                return false;
            }
            ChannelEntry channelEntry = (ChannelEntry) other;
            return m.a(this.channel, channelEntry.channel) && this._receivedValue == channelEntry._receivedValue;
        }

        public final boolean getReceivedValue() {
            return this._receivedValue;
        }

        public final boolean hasChannel(ChannelEntry<T> entry) {
            m.f(entry, "entry");
            return this.channel == entry.channel;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v3 */
        public int hashCode() {
            v<Message.Dispatch.Value<T>> vVar = this.channel;
            int iHashCode = (vVar != null ? vVar.hashCode() : 0) * 31;
            boolean z10 = this._receivedValue;
            ?? r10 = z10;
            if (z10) {
                r10 = 1;
            }
            return iHashCode + r10;
        }

        public String toString() {
            return "ChannelEntry(channel=" + this.channel + ", _receivedValue=" + this._receivedValue + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002:\u0003\u0004\u0005\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Landroidx/paging/multicast/ChannelManager$Message;", ExifInterface.GPS_DIRECTION_TRUE, "", "()V", "AddChannel", "Dispatch", "RemoveChannel", "Landroidx/paging/multicast/ChannelManager$Message$AddChannel;", "Landroidx/paging/multicast/ChannelManager$Message$RemoveChannel;", "Landroidx/paging/multicast/ChannelManager$Message$Dispatch;", "paging-common"}, k = 1, mv = {1, 4, 1})
    public static abstract class Message<T> {

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u00028\u00020\u0002B\u001b\u0012\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007R#\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u00040\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/paging/multicast/ChannelManager$Message$AddChannel;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/paging/multicast/ChannelManager$Message;", "Lkotlinx/coroutines/channels/v;", "Landroidx/paging/multicast/ChannelManager$Message$Dispatch$Value;", MessageOriginChannel.MESSAGE_ORIGIN_TYPE, "<init>", "(Lkotlinx/coroutines/channels/v;)V", "Lkotlinx/coroutines/channels/v;", "getChannel", "()Lkotlinx/coroutines/channels/v;", "paging-common"}, k = 1, mv = {1, 4, 1})
        public static final class AddChannel<T> extends Message<T> {
            private final v<Dispatch.Value<T>> channel;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public AddChannel(v<? super Dispatch.Value<T>> channel) {
                super(null);
                m.f(channel, "channel");
                this.channel = channel;
            }

            public final v<Dispatch.Value<T>> getChannel() {
                return this.channel;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0003\u0004\u0005\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Landroidx/paging/multicast/ChannelManager$Message$Dispatch;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/paging/multicast/ChannelManager$Message;", "()V", "Error", "UpstreamFinished", "Value", "Landroidx/paging/multicast/ChannelManager$Message$Dispatch$Value;", "Landroidx/paging/multicast/ChannelManager$Message$Dispatch$Error;", "Landroidx/paging/multicast/ChannelManager$Message$Dispatch$UpstreamFinished;", "paging-common"}, k = 1, mv = {1, 4, 1})
        public static abstract class Dispatch<T> extends Message<T> {

            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0003\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/paging/multicast/ChannelManager$Message$Dispatch$Error;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/paging/multicast/ChannelManager$Message$Dispatch;", IjkMediaPlayer.OnNativeInvokeListener.ARG_ERROR, "", "(Ljava/lang/Throwable;)V", "getError", "()Ljava/lang/Throwable;", "paging-common"}, k = 1, mv = {1, 4, 1})
            public static final class Error<T> extends Dispatch<T> {
                private final Throwable error;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public Error(Throwable error) {
                    super(null);
                    m.f(error, "error");
                    this.error = error;
                }

                public final Throwable getError() {
                    return this.error;
                }
            }

            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0003\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00030\u0004¢\u0006\u0002\u0010\u0005R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00030\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/paging/multicast/ChannelManager$Message$Dispatch$UpstreamFinished;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/paging/multicast/ChannelManager$Message$Dispatch;", "producer", "Landroidx/paging/multicast/SharedFlowProducer;", "(Landroidx/paging/multicast/SharedFlowProducer;)V", "getProducer", "()Landroidx/paging/multicast/SharedFlowProducer;", "paging-common"}, k = 1, mv = {1, 4, 1})
            public static final class UpstreamFinished<T> extends Dispatch<T> {
                private final SharedFlowProducer<T> producer;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public UpstreamFinished(SharedFlowProducer<T> producer) {
                    super(null);
                    m.f(producer, "producer");
                    this.producer = producer;
                }

                public final SharedFlowProducer<T> getProducer() {
                    return this.producer;
                }
            }

            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000*\u0004\b\u0003\u0010\u00012\b\u0012\u0004\u0012\u00028\u00030\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00028\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00028\u00038\u0006¢\u0006\f\n\u0004\b\u0003\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/paging/multicast/ChannelManager$Message$Dispatch$Value;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/paging/multicast/ChannelManager$Message$Dispatch;", "value", "Lkotlinx/coroutines/w;", "Lr8/z;", "delivered", "<init>", "(Ljava/lang/Object;Lkotlinx/coroutines/w;)V", "Ljava/lang/Object;", "getValue", "()Ljava/lang/Object;", "Lkotlinx/coroutines/w;", "getDelivered", "()Lkotlinx/coroutines/w;", "paging-common"}, k = 1, mv = {1, 4, 1})
            public static final class Value<T> extends Dispatch<T> {
                private final w<z> delivered;
                private final T value;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public Value(T t10, w<z> delivered) {
                    super(null);
                    m.f(delivered, "delivered");
                    this.value = t10;
                    this.delivered = delivered;
                }

                public final w<z> getDelivered() {
                    return this.delivered;
                }

                public final T getValue() {
                    return this.value;
                }
            }

            private Dispatch() {
                super(null);
            }

            public /* synthetic */ Dispatch(g gVar) {
                this();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u00028\u00020\u0002B\u001b\u0012\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007R#\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u00040\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/paging/multicast/ChannelManager$Message$RemoveChannel;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/paging/multicast/ChannelManager$Message;", "Lkotlinx/coroutines/channels/v;", "Landroidx/paging/multicast/ChannelManager$Message$Dispatch$Value;", MessageOriginChannel.MESSAGE_ORIGIN_TYPE, "<init>", "(Lkotlinx/coroutines/channels/v;)V", "Lkotlinx/coroutines/channels/v;", "getChannel", "()Lkotlinx/coroutines/channels/v;", "paging-common"}, k = 1, mv = {1, 4, 1})
        public static final class RemoveChannel<T> extends Message<T> {
            private final v<Dispatch.Value<T>> channel;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public RemoveChannel(v<? super Dispatch.Value<T>> channel) {
                super(null);
                m.f(channel, "channel");
                this.channel = channel;
            }

            public final v<Dispatch.Value<T>> getChannel() {
                return this.channel;
            }
        }

        private Message() {
        }

        public /* synthetic */ Message(g gVar) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChannelManager(l0 scope, int i10, boolean z10, p<? super T, ? super f<? super z>, ? extends Object> onEach, boolean z11, kotlinx.coroutines.flow.f<? extends T> upstream) {
        m.f(scope, "scope");
        m.f(onEach, "onEach");
        m.f(upstream, "upstream");
        this.scope = scope;
        this.bufferSize = i10;
        this.piggybackingDownstream = z10;
        this.onEach = onEach;
        this.keepUpstreamAlive = z11;
        this.upstream = upstream;
        this.actor = new Actor();
    }

    public final Object addDownstream(v<? super Message.Dispatch.Value<T>> vVar, f<? super z> fVar) {
        Object objSend = this.actor.send((T) new Message.AddChannel(vVar), fVar);
        return objSend == b.c() ? objSend : z.f17874a;
    }

    public final Object close(f<? super z> fVar) {
        Object objClose = this.actor.close(fVar);
        return objClose == b.c() ? objClose : z.f17874a;
    }

    public final Object removeDownstream(v<? super Message.Dispatch.Value<T>> vVar, f<? super z> fVar) {
        Object objSend = this.actor.send((T) new Message.RemoveChannel(vVar), fVar);
        return objSend == b.c() ? objSend : z.f17874a;
    }

    public /* synthetic */ ChannelManager(l0 l0Var, int i10, boolean z10, p pVar, boolean z11, kotlinx.coroutines.flow.f fVar, int i11, g gVar) {
        this(l0Var, i10, (i11 & 4) != 0 ? false : z10, pVar, (i11 & 16) != 0 ? false : z11, fVar);
    }
}
