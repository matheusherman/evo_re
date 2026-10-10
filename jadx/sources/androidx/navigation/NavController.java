package androidx.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.IdRes;
import androidx.annotation.MainThread;
import androidx.annotation.NavigationRes;
import androidx.annotation.RestrictTo;
import androidx.core.app.TaskStackBuilder;
import androidx.core.os.BundleKt;
import androidx.p000lifecycle.Lifecycle;
import androidx.p000lifecycle.LifecycleEventObserver;
import androidx.p000lifecycle.LifecycleObserver;
import androidx.p000lifecycle.LifecycleOwner;
import androidx.p000lifecycle.ViewModelStore;
import androidx.p000lifecycle.ViewModelStoreOwner;
import androidx.view.OnBackPressedCallback;
import androidx.view.OnBackPressedDispatcher;
import androidx.view.k;
import c9.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.collections.i;
import kotlin.collections.r;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.h0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.y;
import kotlinx.coroutines.flow.b0;
import kotlinx.coroutines.flow.d0;
import kotlinx.coroutines.flow.f;
import kotlinx.coroutines.flow.f0;
import kotlinx.coroutines.flow.u;
import kotlinx.coroutines.flow.v;
import r8.j;
import r8.z;
import ta.h;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000ê\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0016\u0018\u0000 \u0094\u00022\u00020\u0001:\u0006\u0094\u0002\u0095\u0002\u0096\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000bJS\u0010\u0016\u001a\u00020\t*\n\u0012\u0006\b\u0001\u0012\u00020\r0\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017JA\u0010\u001b\u001a\u00020\t*\n\u0012\u0006\b\u0001\u0012\u00020\r0\f2\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00192\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u0014H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ+\u0010\u001b\u001a\u00020\u00192\b\b\u0001\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u0019H\u0003¢\u0006\u0004\b\u001b\u0010 J'\u0010\u001b\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010#J9\u0010&\u001a\u00020\u00192\u0010\u0010$\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\u000e2\u0006\u0010%\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b&\u0010'J1\u0010+\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u001a\u001a\u00020\u00192\u000e\b\u0002\u0010*\u001a\b\u0012\u0004\u0012\u00020)0(H\u0002¢\u0006\u0004\b+\u0010,J\u0019\u0010-\u001a\u00020\u00192\b\b\u0001\u0010\u001e\u001a\u00020\u001dH\u0003¢\u0006\u0004\b-\u0010.J\u0017\u0010-\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020!H\u0003¢\u0006\u0004\b-\u0010/J\u000f\u00100\u001a\u00020\u0019H\u0002¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\u0019H\u0002¢\u0006\u0004\b2\u00101J\u000f\u00103\u001a\u00020\u0019H\u0002¢\u0006\u0004\b3\u00101J\u0019\u00106\u001a\u00020\t2\b\u00105\u001a\u0004\u0018\u000104H\u0003¢\u0006\u0004\b6\u00107J\u0019\u0010:\u001a\u0004\u0018\u00010!2\u0006\u00109\u001a\u000208H\u0002¢\u0006\u0004\b:\u0010;J\u001f\u0010<\u001a\u0004\u0018\u00010\r*\u00020\r2\b\b\u0001\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b<\u0010=J5\u0010@\u001a\u00020\t2\u0006\u0010>\u001a\u00020\r2\b\u0010?\u001a\u0004\u0018\u0001042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0003¢\u0006\u0004\b@\u0010AJ!\u0010B\u001a\u00020\u00192\u0006\u0010>\u001a\u00020\r2\b\u0010?\u001a\u0004\u0018\u000104H\u0002¢\u0006\u0004\bB\u0010CJ5\u0010E\u001a\u00020\u00192\u0006\u0010D\u001a\u00020\u001d2\b\u0010?\u001a\u0004\u0018\u0001042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\bE\u0010FJ\u0017\u0010E\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020!H\u0002¢\u0006\u0004\bE\u0010/J;\u0010G\u001a\u00020\u00192\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e2\b\u0010?\u001a\u0004\u0018\u0001042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\bG\u0010HJ%\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e2\u000e\u0010I\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010(H\u0002¢\u0006\u0004\bJ\u0010KJ9\u0010O\u001a\u00020\t2\u0006\u0010>\u001a\u00020\r2\b\u0010L\u001a\u0004\u0018\u0001042\u0006\u0010M\u001a\u00020\u00062\u000e\b\u0002\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eH\u0002¢\u0006\u0004\bO\u0010PJ\u000f\u0010Q\u001a\u00020\tH\u0002¢\u0006\u0004\bQ\u0010RJ\u0019\u0010U\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\bS\u0010TJ\u0017\u0010X\u001a\u00020\t2\u0006\u0010W\u001a\u00020VH\u0016¢\u0006\u0004\bX\u0010YJ\u0017\u0010Z\u001a\u00020\t2\u0006\u0010W\u001a\u00020VH\u0016¢\u0006\u0004\bZ\u0010YJ\u000f\u0010[\u001a\u00020\u0019H\u0017¢\u0006\u0004\b[\u00101J!\u0010[\u001a\u00020\u00192\b\b\u0001\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u0019H\u0017¢\u0006\u0004\b[\u0010\\J)\u0010[\u001a\u00020\u00192\b\b\u0001\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0017¢\u0006\u0004\b[\u0010 J)\u0010[\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u0019H\u0007¢\u0006\u0004\b[\u0010#J%\u0010a\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00062\f\u0010^\u001a\b\u0012\u0004\u0012\u00020\t0]H\u0000¢\u0006\u0004\b_\u0010`J\u0017\u0010b\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020!H\u0007¢\u0006\u0004\bb\u0010/J\u0019\u0010b\u001a\u00020\u00192\b\b\u0001\u0010\u001e\u001a\u00020\u001dH\u0007¢\u0006\u0004\bb\u0010.J\u000f\u0010c\u001a\u00020\u0019H\u0017¢\u0006\u0004\bc\u00101J\u000f\u0010e\u001a\u00020\tH\u0000¢\u0006\u0004\bd\u0010RJ\u0015\u0010h\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eH\u0000¢\u0006\u0004\bf\u0010gJ\u0019\u0010j\u001a\u00020\t2\b\b\u0001\u0010i\u001a\u00020\u001dH\u0017¢\u0006\u0004\bj\u0010kJ#\u0010j\u001a\u00020\t2\b\b\u0001\u0010i\u001a\u00020\u001d2\b\u00105\u001a\u0004\u0018\u000104H\u0017¢\u0006\u0004\bj\u0010lJ!\u0010j\u001a\u00020\t2\u0006\u0010n\u001a\u00020m2\b\u00105\u001a\u0004\u0018\u000104H\u0017¢\u0006\u0004\bj\u0010oJ\u0019\u0010r\u001a\u00020\u00192\b\u0010q\u001a\u0004\u0018\u00010pH\u0017¢\u0006\u0004\br\u0010sJ\u001b\u0010<\u001a\u0004\u0018\u00010\r2\b\b\u0001\u0010\u001e\u001a\u00020\u001dH\u0007¢\u0006\u0004\b<\u0010tJ\u0019\u0010<\u001a\u0004\u0018\u00010\r2\u0006\u0010\"\u001a\u00020!H\u0007¢\u0006\u0004\b<\u0010uJ\u0019\u0010@\u001a\u00020\t2\b\b\u0001\u0010v\u001a\u00020\u001dH\u0017¢\u0006\u0004\b@\u0010kJ#\u0010@\u001a\u00020\t2\b\b\u0001\u0010v\u001a\u00020\u001d2\b\u0010?\u001a\u0004\u0018\u000104H\u0017¢\u0006\u0004\b@\u0010lJ-\u0010@\u001a\u00020\t2\b\b\u0001\u0010v\u001a\u00020\u001d2\b\u0010?\u001a\u0004\u0018\u0001042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0017¢\u0006\u0004\b@\u0010wJ7\u0010@\u001a\u00020\t2\b\b\u0001\u0010v\u001a\u00020\u001d2\b\u0010?\u001a\u0004\u0018\u0001042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0017¢\u0006\u0004\b@\u0010xJ\u0017\u0010@\u001a\u00020\t2\u0006\u00109\u001a\u00020yH\u0017¢\u0006\u0004\b@\u0010zJ!\u0010@\u001a\u00020\t2\u0006\u00109\u001a\u00020y2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0017¢\u0006\u0004\b@\u0010{J+\u0010@\u001a\u00020\t2\u0006\u00109\u001a\u00020y2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0017¢\u0006\u0004\b@\u0010|J\u0017\u0010@\u001a\u00020\t2\u0006\u0010~\u001a\u00020}H\u0017¢\u0006\u0004\b@\u0010\u007fJ\"\u0010@\u001a\u00020\t2\u0006\u0010~\u001a\u00020}2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0017¢\u0006\u0005\b@\u0010\u0080\u0001J,\u0010@\u001a\u00020\t2\u0006\u0010~\u001a\u00020}2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0017¢\u0006\u0005\b@\u0010\u0081\u0001J\u001a\u0010@\u001a\u00020\t2\b\u0010\u0083\u0001\u001a\u00030\u0082\u0001H\u0017¢\u0006\u0005\b@\u0010\u0084\u0001J$\u0010@\u001a\u00020\t2\b\u0010\u0083\u0001\u001a\u00030\u0082\u00012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0017¢\u0006\u0005\b@\u0010\u0085\u0001J\"\u0010@\u001a\u00020\t2\b\u0010\u0083\u0001\u001a\u00030\u0082\u00012\u0006\u0010\u0013\u001a\u00020\u0012H\u0017¢\u0006\u0005\b@\u0010\u0086\u0001J.\u0010@\u001a\u00020\t2\u0006\u0010\"\u001a\u00020!2\u0014\u0010\u0088\u0001\u001a\u000f\u0012\u0005\u0012\u00030\u0087\u0001\u0012\u0004\u0012\u00020\t0\u0014H\u0007¢\u0006\u0005\b@\u0010\u0089\u0001J0\u0010@\u001a\u00020\t2\u0006\u0010\"\u001a\u00020!2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0007¢\u0006\u0005\b@\u0010\u008a\u0001J\u0013\u0010\u008c\u0001\u001a\u00030\u008b\u0001H\u0016¢\u0006\u0006\b\u008c\u0001\u0010\u008d\u0001J\u0012\u0010\u001a\u001a\u0004\u0018\u000104H\u0017¢\u0006\u0005\b\u001a\u0010\u008e\u0001J\u001c\u0010\u0090\u0001\u001a\u00020\t2\t\u0010\u008f\u0001\u001a\u0004\u0018\u000104H\u0017¢\u0006\u0005\b\u0090\u0001\u00107J\u001c\u0010\u0093\u0001\u001a\u00020\t2\b\u0010\u0092\u0001\u001a\u00030\u0091\u0001H\u0017¢\u0006\u0006\b\u0093\u0001\u0010\u0094\u0001J\u001c\u0010\u0097\u0001\u001a\u00020\t2\b\u0010\u0096\u0001\u001a\u00030\u0095\u0001H\u0017¢\u0006\u0006\b\u0097\u0001\u0010\u0098\u0001J\u001b\u0010\u009a\u0001\u001a\u00020\t2\u0007\u0010\u0099\u0001\u001a\u00020\u0019H\u0017¢\u0006\u0006\b\u009a\u0001\u0010\u009b\u0001J\u001c\u0010\u009e\u0001\u001a\u00020\t2\b\u0010\u009d\u0001\u001a\u00030\u009c\u0001H\u0017¢\u0006\u0006\b\u009e\u0001\u0010\u009f\u0001J\u001e\u0010¢\u0001\u001a\u00030¡\u00012\t\b\u0001\u0010 \u0001\u001a\u00020\u001dH\u0016¢\u0006\u0006\b¢\u0001\u0010£\u0001J\u001c\u0010¤\u0001\u001a\u00020\u00062\b\b\u0001\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0006\b¤\u0001\u0010¥\u0001J\u0018\u0010¤\u0001\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020!¢\u0006\u0006\b¤\u0001\u0010¦\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\u000f\n\u0005\b\u0003\u0010§\u0001\u001a\u0006\b¨\u0001\u0010©\u0001R\u001c\u0010«\u0001\u001a\u0005\u0018\u00010ª\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b«\u0001\u0010¬\u0001R\u001c\u0010®\u0001\u001a\u0005\u0018\u00010\u00ad\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b®\u0001\u0010¯\u0001R\u001b\u0010°\u0001\u001a\u0004\u0018\u00010m8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b°\u0001\u0010±\u0001R\u001b\u0010²\u0001\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b²\u0001\u0010³\u0001R#\u0010¶\u0001\u001a\f\u0012\u0005\u0012\u00030µ\u0001\u0018\u00010´\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¶\u0001\u0010·\u0001R\u0019\u0010¸\u0001\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¸\u0001\u0010¹\u0001R\u001d\u0010º\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060(8\u0002X\u0082\u0004¢\u0006\b\n\u0006\bº\u0001\u0010»\u0001R$\u0010½\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000e0¼\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b½\u0001\u0010¾\u0001R,\u0010À\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000e0¿\u00018GX\u0087\u0004¢\u0006\u0010\n\u0006\bÀ\u0001\u0010Á\u0001\u001a\u0006\bÂ\u0001\u0010Ã\u0001R$\u0010Ä\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000e0¼\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÄ\u0001\u0010¾\u0001R)\u0010Å\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000e0¿\u00018\u0006¢\u0006\u0010\n\u0006\bÅ\u0001\u0010Á\u0001\u001a\u0006\bÆ\u0001\u0010Ã\u0001R$\u0010È\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060Ç\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÈ\u0001\u0010É\u0001R%\u0010Ë\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0005\u0012\u00030Ê\u00010Ç\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bË\u0001\u0010É\u0001R&\u0010Ì\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u001d\u0012\u0006\u0012\u0004\u0018\u00010!0Ç\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÌ\u0001\u0010É\u0001R*\u0010Í\u0001\u001a\u0015\u0012\u0004\u0012\u00020!\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0(0Ç\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÍ\u0001\u0010É\u0001R\u001c\u0010Î\u0001\u001a\u0005\u0018\u00010\u0091\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÎ\u0001\u0010Ï\u0001R\u001c\u0010Ð\u0001\u001a\u0005\u0018\u00010\u0095\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÐ\u0001\u0010Ñ\u0001R\u001c\u0010Ó\u0001\u001a\u0005\u0018\u00010Ò\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÓ\u0001\u0010Ô\u0001R\u001e\u0010Ö\u0001\u001a\t\u0012\u0004\u0012\u00020V0Õ\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÖ\u0001\u0010×\u0001R*\u0010Ù\u0001\u001a\u00030Ø\u00018@@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\bÙ\u0001\u0010Ú\u0001\u001a\u0006\bÛ\u0001\u0010Ü\u0001\"\u0006\bÝ\u0001\u0010Þ\u0001R\u0018\u0010à\u0001\u001a\u00030ß\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bà\u0001\u0010á\u0001R\u0018\u0010ã\u0001\u001a\u00030â\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bã\u0001\u0010ä\u0001R\u0019\u0010å\u0001\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bå\u0001\u0010¹\u0001R\u001a\u0010ç\u0001\u001a\u00030æ\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bç\u0001\u0010è\u0001R1\u0010ê\u0001\u001a\u001c\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\r0\f\u0012\t\u0012\u00070é\u0001R\u00020\u00000Ç\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bê\u0001\u0010É\u0001R'\u0010ë\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bë\u0001\u0010ì\u0001R'\u0010í\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bí\u0001\u0010ì\u0001R$\u0010î\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00190Ç\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bî\u0001\u0010É\u0001R\u0019\u0010ï\u0001\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bï\u0001\u0010ð\u0001R\u001e\u0010ò\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060ñ\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bò\u0001\u0010ó\u0001R!\u0010ø\u0001\u001a\u00030\u00ad\u00018VX\u0096\u0084\u0002¢\u0006\u0010\n\u0006\bô\u0001\u0010õ\u0001\u001a\u0006\bö\u0001\u0010÷\u0001R\u001e\u0010ú\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060ù\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bú\u0001\u0010û\u0001R#\u0010ý\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060ü\u00018\u0006¢\u0006\u0010\n\u0006\bý\u0001\u0010þ\u0001\u001a\u0006\bÿ\u0001\u0010\u0080\u0002R\u0017\u0010\u0083\u0002\u001a\u00020\u001d8BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0081\u0002\u0010\u0082\u0002R'\u0010n\u001a\u00020m2\u0006\u0010n\u001a\u00020m8W@WX\u0096\u000e¢\u0006\u000f\u001a\u0006\b\u0084\u0002\u0010\u0085\u0002\"\u0005\bj\u0010\u0086\u0002R,\u0010\u0087\u0002\u001a\u00030æ\u00012\b\u0010\u0087\u0002\u001a\u00030æ\u00018V@WX\u0096\u000e¢\u0006\u0010\u001a\u0006\b\u0088\u0002\u0010\u0089\u0002\"\u0006\b\u008a\u0002\u0010\u008b\u0002R\u0019\u0010\u008e\u0002\u001a\u0004\u0018\u00010\r8VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u008c\u0002\u0010\u008d\u0002R\u0019\u0010\u0091\u0002\u001a\u0004\u0018\u00010\u00068VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u008f\u0002\u0010\u0090\u0002R\u0019\u0010\u0093\u0002\u001a\u0004\u0018\u00010\u00068VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0092\u0002\u0010\u0090\u0002¨\u0006\u0097\u0002"}, d2 = {"Landroidx/navigation/NavController;", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroidx/navigation/NavBackStackEntry;", "child", "parent", "Lr8/z;", "linkChildToParent", "(Landroidx/navigation/NavBackStackEntry;Landroidx/navigation/NavBackStackEntry;)V", "Landroidx/navigation/Navigator;", "Landroidx/navigation/NavDestination;", "", "entries", "Landroidx/navigation/NavOptions;", "navOptions", "Landroidx/navigation/Navigator$Extras;", "navigatorExtras", "Lkotlin/Function1;", "handler", "navigateInternal", "(Landroidx/navigation/Navigator;Ljava/util/List;Landroidx/navigation/NavOptions;Landroidx/navigation/Navigator$Extras;Lc9/l;)V", "popUpTo", "", "saveState", "popBackStackInternal", "(Landroidx/navigation/Navigator;Landroidx/navigation/NavBackStackEntry;ZLc9/l;)V", "", "destinationId", "inclusive", "(IZZ)Z", "", "route", "(Ljava/lang/String;ZZ)Z", "popOperations", "foundDestination", "executePopOperations", "(Ljava/util/List;Landroidx/navigation/NavDestination;ZZ)Z", "Lkotlin/collections/i;", "Landroidx/navigation/NavBackStackEntryState;", "savedState", "popEntryFromBackStack", "(Landroidx/navigation/NavBackStackEntry;ZLkotlin/collections/i;)V", "clearBackStackInternal", "(I)Z", "(Ljava/lang/String;)Z", "tryRelaunchUpToExplicitStack", "()Z", "tryRelaunchUpToGeneratedStack", "dispatchOnDestinationChanged", "Landroid/os/Bundle;", "startDestinationArgs", "onGraphCreated", "(Landroid/os/Bundle;)V", "", "deepLink", "findInvalidDestinationDisplayNameInDeepLink", "([I)Ljava/lang/String;", "findDestination", "(Landroidx/navigation/NavDestination;I)Landroidx/navigation/NavDestination;", "node", "args", "navigate", "(Landroidx/navigation/NavDestination;Landroid/os/Bundle;Landroidx/navigation/NavOptions;Landroidx/navigation/Navigator$Extras;)V", "launchSingleTopInternal", "(Landroidx/navigation/NavDestination;Landroid/os/Bundle;)Z", IjkMediaMeta.IJKM_KEY_TRACK_ID, "restoreStateInternal", "(ILandroid/os/Bundle;Landroidx/navigation/NavOptions;Landroidx/navigation/Navigator$Extras;)Z", "executeRestoreState", "(Ljava/util/List;Landroid/os/Bundle;Landroidx/navigation/NavOptions;Landroidx/navigation/Navigator$Extras;)Z", "backStackState", "instantiateBackStack", "(Lkotlin/collections/i;)Ljava/util/List;", "finalArgs", "backStackEntry", "restoredEntries", "addEntryToBackStack", "(Landroidx/navigation/NavDestination;Landroid/os/Bundle;Landroidx/navigation/NavBackStackEntry;Ljava/util/List;)V", "updateOnBackPressedCallbackEnabled", "()V", "unlinkChildFromParent$navigation_runtime_release", "(Landroidx/navigation/NavBackStackEntry;)Landroidx/navigation/NavBackStackEntry;", "unlinkChildFromParent", "Landroidx/navigation/NavController$OnDestinationChangedListener;", "listener", "addOnDestinationChangedListener", "(Landroidx/navigation/NavController$OnDestinationChangedListener;)V", "removeOnDestinationChangedListener", "popBackStack", "(IZ)Z", "Lkotlin/Function0;", "onComplete", "popBackStackFromNavigator$navigation_runtime_release", "(Landroidx/navigation/NavBackStackEntry;Lc9/a;)V", "popBackStackFromNavigator", "clearBackStack", "navigateUp", "updateBackStackLifecycle$navigation_runtime_release", "updateBackStackLifecycle", "populateVisibleEntries$navigation_runtime_release", "()Ljava/util/List;", "populateVisibleEntries", "graphResId", "setGraph", "(I)V", "(ILandroid/os/Bundle;)V", "Landroidx/navigation/NavGraph;", "graph", "(Landroidx/navigation/NavGraph;Landroid/os/Bundle;)V", "Landroid/content/Intent;", "intent", "handleDeepLink", "(Landroid/content/Intent;)Z", "(I)Landroidx/navigation/NavDestination;", "(Ljava/lang/String;)Landroidx/navigation/NavDestination;", "resId", "(ILandroid/os/Bundle;Landroidx/navigation/NavOptions;)V", "(ILandroid/os/Bundle;Landroidx/navigation/NavOptions;Landroidx/navigation/Navigator$Extras;)V", "Landroid/net/Uri;", "(Landroid/net/Uri;)V", "(Landroid/net/Uri;Landroidx/navigation/NavOptions;)V", "(Landroid/net/Uri;Landroidx/navigation/NavOptions;Landroidx/navigation/Navigator$Extras;)V", "Landroidx/navigation/NavDeepLinkRequest;", "request", "(Landroidx/navigation/NavDeepLinkRequest;)V", "(Landroidx/navigation/NavDeepLinkRequest;Landroidx/navigation/NavOptions;)V", "(Landroidx/navigation/NavDeepLinkRequest;Landroidx/navigation/NavOptions;Landroidx/navigation/Navigator$Extras;)V", "Landroidx/navigation/NavDirections;", "directions", "(Landroidx/navigation/NavDirections;)V", "(Landroidx/navigation/NavDirections;Landroidx/navigation/NavOptions;)V", "(Landroidx/navigation/NavDirections;Landroidx/navigation/Navigator$Extras;)V", "Landroidx/navigation/NavOptionsBuilder;", "builder", "(Ljava/lang/String;Lc9/l;)V", "(Ljava/lang/String;Landroidx/navigation/NavOptions;Landroidx/navigation/Navigator$Extras;)V", "Landroidx/navigation/NavDeepLinkBuilder;", "createDeepLink", "()Landroidx/navigation/NavDeepLinkBuilder;", "()Landroid/os/Bundle;", "navState", "restoreState", "Landroidx/lifecycle/LifecycleOwner;", "owner", "setLifecycleOwner", "(Landroidx/lifecycle/LifecycleOwner;)V", "Landroidx/activity/OnBackPressedDispatcher;", "dispatcher", "setOnBackPressedDispatcher", "(Landroidx/activity/OnBackPressedDispatcher;)V", "enabled", "enableOnBackPressed", "(Z)V", "Landroidx/lifecycle/ViewModelStore;", "viewModelStore", "setViewModelStore", "(Landroidx/lifecycle/ViewModelStore;)V", "navGraphId", "Landroidx/lifecycle/ViewModelStoreOwner;", "getViewModelStoreOwner", "(I)Landroidx/lifecycle/ViewModelStoreOwner;", "getBackStackEntry", "(I)Landroidx/navigation/NavBackStackEntry;", "(Ljava/lang/String;)Landroidx/navigation/NavBackStackEntry;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Landroid/app/Activity;", "activity", "Landroid/app/Activity;", "Landroidx/navigation/NavInflater;", "inflater", "Landroidx/navigation/NavInflater;", "_graph", "Landroidx/navigation/NavGraph;", "navigatorStateToRestore", "Landroid/os/Bundle;", "", "Landroid/os/Parcelable;", "backStackToRestore", "[Landroid/os/Parcelable;", "deepLinkHandled", "Z", "backQueue", "Lkotlin/collections/i;", "Lkotlinx/coroutines/flow/v;", "_currentBackStack", "Lkotlinx/coroutines/flow/v;", "Lkotlinx/coroutines/flow/d0;", "currentBackStack", "Lkotlinx/coroutines/flow/d0;", "getCurrentBackStack", "()Lkotlinx/coroutines/flow/d0;", "_visibleEntries", "visibleEntries", "getVisibleEntries", "", "childToParentEntries", "Ljava/util/Map;", "Ljava/util/concurrent/atomic/AtomicInteger;", "parentToChildCount", "backStackMap", "backStackStates", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "onBackPressedDispatcher", "Landroidx/activity/OnBackPressedDispatcher;", "Landroidx/navigation/NavControllerViewModel;", "viewModel", "Landroidx/navigation/NavControllerViewModel;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "onDestinationChangedListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroidx/lifecycle/Lifecycle$State;", "hostLifecycleState", "Landroidx/lifecycle/Lifecycle$State;", "getHostLifecycleState$navigation_runtime_release", "()Landroidx/lifecycle/Lifecycle$State;", "setHostLifecycleState$navigation_runtime_release", "(Landroidx/lifecycle/Lifecycle$State;)V", "Landroidx/lifecycle/LifecycleObserver;", "lifecycleObserver", "Landroidx/lifecycle/LifecycleObserver;", "Landroidx/activity/OnBackPressedCallback;", "onBackPressedCallback", "Landroidx/activity/OnBackPressedCallback;", "enableOnBackPressedCallback", "Landroidx/navigation/NavigatorProvider;", "_navigatorProvider", "Landroidx/navigation/NavigatorProvider;", "Landroidx/navigation/NavController$NavControllerNavigatorState;", "navigatorState", "addToBackStackHandler", "Lc9/l;", "popFromBackStackHandler", "entrySavedState", "dispatchReentrantCount", "I", "", "backStackEntriesToDispatch", "Ljava/util/List;", "navInflater$delegate", "Lr8/i;", "getNavInflater", "()Landroidx/navigation/NavInflater;", "navInflater", "Lkotlinx/coroutines/flow/u;", "_currentBackStackEntryFlow", "Lkotlinx/coroutines/flow/u;", "Lkotlinx/coroutines/flow/f;", "currentBackStackEntryFlow", "Lkotlinx/coroutines/flow/f;", "getCurrentBackStackEntryFlow", "()Lkotlinx/coroutines/flow/f;", "getDestinationCountOnBackStack", "()I", "destinationCountOnBackStack", "getGraph", "()Landroidx/navigation/NavGraph;", "(Landroidx/navigation/NavGraph;)V", "navigatorProvider", "getNavigatorProvider", "()Landroidx/navigation/NavigatorProvider;", "setNavigatorProvider", "(Landroidx/navigation/NavigatorProvider;)V", "getCurrentDestination", "()Landroidx/navigation/NavDestination;", "currentDestination", "getCurrentBackStackEntry", "()Landroidx/navigation/NavBackStackEntry;", "currentBackStackEntry", "getPreviousBackStackEntry", "previousBackStackEntry", "Companion", "NavControllerNavigatorState", "OnDestinationChangedListener", "navigation-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class NavController {
    private static final String KEY_BACK_STACK = "android-support-nav:controller:backStack";
    private static final String KEY_BACK_STACK_DEST_IDS = "android-support-nav:controller:backStackDestIds";
    private static final String KEY_BACK_STACK_IDS = "android-support-nav:controller:backStackIds";
    private static final String KEY_BACK_STACK_STATES_IDS = "android-support-nav:controller:backStackStates";
    private static final String KEY_BACK_STACK_STATES_PREFIX = "android-support-nav:controller:backStackStates:";

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final String KEY_DEEP_LINK_ARGS = "android-support-nav:controller:deepLinkArgs";

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final String KEY_DEEP_LINK_EXTRAS = "android-support-nav:controller:deepLinkExtras";

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final String KEY_DEEP_LINK_HANDLED = "android-support-nav:controller:deepLinkHandled";

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final String KEY_DEEP_LINK_IDS = "android-support-nav:controller:deepLinkIds";
    public static final String KEY_DEEP_LINK_INTENT = "android-support-nav:controller:deepLinkIntent";
    private static final String KEY_NAVIGATOR_STATE = "android-support-nav:controller:navigatorState";
    private static final String KEY_NAVIGATOR_STATE_NAMES = "android-support-nav:controller:navigatorState:names";
    private static final String TAG = "NavController";
    private final v<List<NavBackStackEntry>> _currentBackStack;
    private final u<NavBackStackEntry> _currentBackStackEntryFlow;
    private NavGraph _graph;
    private NavigatorProvider _navigatorProvider;
    private final v<List<NavBackStackEntry>> _visibleEntries;
    private Activity activity;
    private l<? super NavBackStackEntry, z> addToBackStackHandler;
    private final i<NavBackStackEntry> backQueue;
    private final List<NavBackStackEntry> backStackEntriesToDispatch;
    private final Map<Integer, String> backStackMap;
    private final Map<String, i<NavBackStackEntryState>> backStackStates;
    private Parcelable[] backStackToRestore;
    private final Map<NavBackStackEntry, NavBackStackEntry> childToParentEntries;
    private final Context context;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    private final d0<List<NavBackStackEntry>> currentBackStack;
    private final f<NavBackStackEntry> currentBackStackEntryFlow;
    private boolean deepLinkHandled;
    private int dispatchReentrantCount;
    private boolean enableOnBackPressedCallback;
    private final Map<NavBackStackEntry, Boolean> entrySavedState;
    private Lifecycle.State hostLifecycleState;
    private NavInflater inflater;
    private final LifecycleObserver lifecycleObserver;
    private LifecycleOwner lifecycleOwner;

    /* JADX INFO: renamed from: navInflater$delegate, reason: from kotlin metadata */
    private final r8.i navInflater;
    private final Map<Navigator<? extends NavDestination>, NavControllerNavigatorState> navigatorState;
    private Bundle navigatorStateToRestore;
    private final OnBackPressedCallback onBackPressedCallback;
    private OnBackPressedDispatcher onBackPressedDispatcher;
    private final CopyOnWriteArrayList<OnDestinationChangedListener> onDestinationChangedListeners;
    private final Map<NavBackStackEntry, AtomicInteger> parentToChildCount;
    private l<? super NavBackStackEntry, z> popFromBackStackHandler;
    private NavControllerViewModel viewModel;
    private final d0<List<NavBackStackEntry>> visibleEntries;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static boolean deepLinkSaveState = true;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087T¢\u0006\f\n\u0004\b\n\u0010\u000b\u0012\u0004\b\f\u0010\u0003R\u0014\u0010\r\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000bR\u0014\u0010\u0011\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000bR\u0014\u0010\u0012\u001a\u00020\t8\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0012\u0010\u000bR\u0014\u0010\u0013\u001a\u00020\t8\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0013\u0010\u000bR\u0014\u0010\u0014\u001a\u00020\t8\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0014\u0010\u000bR\u0014\u0010\u0015\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0015\u0010\u000bR\u0014\u0010\u0016\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u000bR\u0014\u0010\u0017\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u000bR\u0014\u0010\u0018\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u000bR\u0016\u0010\u0019\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Landroidx/navigation/NavController$Companion;", "", "<init>", "()V", "", "saveState", "Lr8/z;", "enableDeepLinkSaveState", "(Z)V", "", "KEY_DEEP_LINK_EXTRAS", "Ljava/lang/String;", "getKEY_DEEP_LINK_EXTRAS$annotations", "KEY_BACK_STACK", "KEY_BACK_STACK_DEST_IDS", "KEY_BACK_STACK_IDS", "KEY_BACK_STACK_STATES_IDS", "KEY_BACK_STACK_STATES_PREFIX", "KEY_DEEP_LINK_ARGS", "KEY_DEEP_LINK_HANDLED", "KEY_DEEP_LINK_IDS", "KEY_DEEP_LINK_INTENT", "KEY_NAVIGATOR_STATE", "KEY_NAVIGATOR_STATE_NAMES", "TAG", "deepLinkSaveState", "Z", "navigation-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        private Companion() {
        }

        @NavDeepLinkSaveStateControl
        public final void enableDeepLinkSaveState(boolean saveState) {
            NavController.deepLinkSaveState = saveState;
        }

        public static /* synthetic */ void getKEY_DEEP_LINK_EXTRAS$annotations() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\u000bJ!\u0010\u0010\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0017\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0019\u0010\u000bJ\u0017\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001a\u0010\u000bR\u001f\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Landroidx/navigation/NavController$NavControllerNavigatorState;", "Landroidx/navigation/NavigatorState;", "Landroidx/navigation/Navigator;", "Landroidx/navigation/NavDestination;", "navigator", "<init>", "(Landroidx/navigation/NavController;Landroidx/navigation/Navigator;)V", "Landroidx/navigation/NavBackStackEntry;", "backStackEntry", "Lr8/z;", "push", "(Landroidx/navigation/NavBackStackEntry;)V", "addInternal", "destination", "Landroid/os/Bundle;", "arguments", "createBackStackEntry", "(Landroidx/navigation/NavDestination;Landroid/os/Bundle;)Landroidx/navigation/NavBackStackEntry;", "popUpTo", "", "saveState", "pop", "(Landroidx/navigation/NavBackStackEntry;Z)V", "popWithTransition", "entry", "markTransitionComplete", "prepareForTransition", "Landroidx/navigation/Navigator;", "getNavigator", "()Landroidx/navigation/Navigator;", "navigation-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    final class NavControllerNavigatorState extends NavigatorState {
        private final Navigator<? extends NavDestination> navigator;
        final /* synthetic */ NavController this$0;

        public NavControllerNavigatorState(NavController navController, Navigator<? extends NavDestination> navigator) {
            m.f(navigator, "navigator");
            this.this$0 = navController;
            this.navigator = navigator;
        }

        public final void addInternal(NavBackStackEntry backStackEntry) {
            m.f(backStackEntry, "backStackEntry");
            super.push(backStackEntry);
        }

        @Override // androidx.navigation.NavigatorState
        public NavBackStackEntry createBackStackEntry(NavDestination destination, Bundle arguments) {
            m.f(destination, "destination");
            return NavBackStackEntry.Companion.create$default(NavBackStackEntry.INSTANCE, this.this$0.getContext(), destination, arguments, this.this$0.getHostLifecycleState$navigation_runtime_release(), this.this$0.viewModel, null, null, 96, null);
        }

        public final Navigator<? extends NavDestination> getNavigator() {
            return this.navigator;
        }

        @Override // androidx.navigation.NavigatorState
        public void markTransitionComplete(NavBackStackEntry entry) {
            NavControllerViewModel navControllerViewModel;
            m.f(entry, "entry");
            boolean zA = m.a(this.this$0.entrySavedState.get(entry), Boolean.TRUE);
            super.markTransitionComplete(entry);
            this.this$0.entrySavedState.remove(entry);
            if (this.this$0.backQueue.contains(entry)) {
                if (getIsNavigating()) {
                    return;
                }
                this.this$0.updateBackStackLifecycle$navigation_runtime_release();
                this.this$0._currentBackStack.a(r.Q0(this.this$0.backQueue));
                this.this$0._visibleEntries.a(this.this$0.populateVisibleEntries$navigation_runtime_release());
                return;
            }
            this.this$0.unlinkChildFromParent$navigation_runtime_release(entry);
            if (entry.getLifecycle().getState().isAtLeast(Lifecycle.State.CREATED)) {
                entry.setMaxLifecycle(Lifecycle.State.DESTROYED);
            }
            i iVar = this.this$0.backQueue;
            if (!k.a(iVar) || !iVar.isEmpty()) {
                Iterator<E> it = iVar.iterator();
                while (it.hasNext()) {
                    if (m.a(((NavBackStackEntry) it.next()).getId(), entry.getId())) {
                    }
                }
                if (!zA && (navControllerViewModel = this.this$0.viewModel) != null) {
                    navControllerViewModel.clear(entry.getId());
                }
            } else if (!zA) {
                navControllerViewModel.clear(entry.getId());
            }
            this.this$0.updateBackStackLifecycle$navigation_runtime_release();
            this.this$0._visibleEntries.a(this.this$0.populateVisibleEntries$navigation_runtime_release());
        }

        @Override // androidx.navigation.NavigatorState
        public void pop(NavBackStackEntry popUpTo, boolean saveState) {
            m.f(popUpTo, "popUpTo");
            Navigator navigator = this.this$0._navigatorProvider.getNavigator(popUpTo.getDestination().getNavigatorName());
            if (!m.a(navigator, this.navigator)) {
                Object obj = this.this$0.navigatorState.get(navigator);
                m.c(obj);
                ((NavControllerNavigatorState) obj).pop(popUpTo, saveState);
            } else {
                l lVar = this.this$0.popFromBackStackHandler;
                if (lVar == null) {
                    this.this$0.popBackStackFromNavigator$navigation_runtime_release(popUpTo, new NavController$NavControllerNavigatorState$pop$1(this, popUpTo, saveState));
                } else {
                    lVar.invoke(popUpTo);
                    super.pop(popUpTo, saveState);
                }
            }
        }

        @Override // androidx.navigation.NavigatorState
        public void popWithTransition(NavBackStackEntry popUpTo, boolean saveState) {
            m.f(popUpTo, "popUpTo");
            super.popWithTransition(popUpTo, saveState);
            this.this$0.entrySavedState.put(popUpTo, Boolean.valueOf(saveState));
        }

        @Override // androidx.navigation.NavigatorState
        public void prepareForTransition(NavBackStackEntry entry) {
            m.f(entry, "entry");
            super.prepareForTransition(entry);
            if (!this.this$0.backQueue.contains(entry)) {
                throw new IllegalStateException("Cannot transition entry that is not in the back stack");
            }
            entry.setMaxLifecycle(Lifecycle.State.STARTED);
        }

        @Override // androidx.navigation.NavigatorState
        public void push(NavBackStackEntry backStackEntry) {
            m.f(backStackEntry, "backStackEntry");
            Navigator navigator = this.this$0._navigatorProvider.getNavigator(backStackEntry.getDestination().getNavigatorName());
            if (!m.a(navigator, this.navigator)) {
                Object obj = this.this$0.navigatorState.get(navigator);
                if (obj != null) {
                    ((NavControllerNavigatorState) obj).push(backStackEntry);
                    return;
                }
                throw new IllegalStateException(("NavigatorBackStack for " + backStackEntry.getDestination().getNavigatorName() + " should already be created").toString());
            }
            l lVar = this.this$0.addToBackStackHandler;
            if (lVar != null) {
                lVar.invoke(backStackEntry);
                addInternal(backStackEntry);
                return;
            }
            Log.i(NavController.TAG, "Ignoring add of destination " + backStackEntry.getDestination() + " outside of the call to navigate(). ");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J)\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\t\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, d2 = {"Landroidx/navigation/NavController$OnDestinationChangedListener;", "", "Landroidx/navigation/NavController;", "controller", "Landroidx/navigation/NavDestination;", "destination", "Landroid/os/Bundle;", "arguments", "Lr8/z;", "onDestinationChanged", "(Landroidx/navigation/NavController;Landroidx/navigation/NavDestination;Landroid/os/Bundle;)V", "navigation-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface OnDestinationChangedListener {
        void onDestinationChanged(NavController controller, NavDestination destination, Bundle arguments);
    }

    /* JADX INFO: renamed from: androidx.navigation.NavController$executePopOperations$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/navigation/NavBackStackEntry;", "entry", "Lr8/z;", "invoke", "(Landroidx/navigation/NavBackStackEntry;)V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    static final class AnonymousClass1 extends o implements l<NavBackStackEntry, z> {
        final /* synthetic */ y $popped;
        final /* synthetic */ y $receivedPop;
        final /* synthetic */ boolean $saveState;
        final /* synthetic */ i<NavBackStackEntryState> $savedState;
        final /* synthetic */ NavController this$0;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(NavBackStackEntry navBackStackEntry) {
            invoke2(navBackStackEntry);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(y yVar, y yVar2, NavController navController, boolean z10, i<NavBackStackEntryState> iVar) {
            super(1);
            this.$receivedPop = yVar;
            this.$popped = yVar2;
            this.this$0 = navController;
            this.$saveState = z10;
            this.$savedState = iVar;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(NavBackStackEntry entry) {
            m.f(entry, "entry");
            this.$receivedPop.element = true;
            this.$popped.element = true;
            this.this$0.popEntryFromBackStack(entry, this.$saveState, this.$savedState);
        }
    }

    /* JADX INFO: renamed from: androidx.navigation.NavController$executePopOperations$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/navigation/NavDestination;", "destination", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class AnonymousClass2 extends o implements l<NavDestination, NavDestination> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        AnonymousClass2() {
            super(1);
        }

        @Override // c9.l
        public final NavDestination invoke(NavDestination destination) {
            m.f(destination, "destination");
            NavGraph parent = destination.getParent();
            if (parent == null || parent.getStartDestId() != destination.getId()) {
                return null;
            }
            return destination.getParent();
        }
    }

    /* JADX INFO: renamed from: androidx.navigation.NavController$executePopOperations$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "destination", "Landroidx/navigation/NavDestination;", "invoke", "(Landroidx/navigation/NavDestination;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class AnonymousClass3 extends o implements l<NavDestination, Boolean> {
        AnonymousClass3() {
            super(1);
        }

        @Override // c9.l
        public final Boolean invoke(NavDestination destination) {
            m.f(destination, "destination");
            return Boolean.valueOf(!NavController.this.backStackMap.containsKey(Integer.valueOf(destination.getId())));
        }
    }

    /* JADX INFO: renamed from: androidx.navigation.NavController$executePopOperations$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/navigation/NavDestination;", "destination", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class AnonymousClass5 extends o implements l<NavDestination, NavDestination> {
        public static final AnonymousClass5 INSTANCE = new AnonymousClass5();

        AnonymousClass5() {
            super(1);
        }

        @Override // c9.l
        public final NavDestination invoke(NavDestination destination) {
            m.f(destination, "destination");
            NavGraph parent = destination.getParent();
            if (parent == null || parent.getStartDestId() != destination.getId()) {
                return null;
            }
            return destination.getParent();
        }
    }

    /* JADX INFO: renamed from: androidx.navigation.NavController$executePopOperations$6, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "destination", "Landroidx/navigation/NavDestination;", "invoke", "(Landroidx/navigation/NavDestination;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class AnonymousClass6 extends o implements l<NavDestination, Boolean> {
        AnonymousClass6() {
            super(1);
        }

        @Override // c9.l
        public final Boolean invoke(NavDestination destination) {
            m.f(destination, "destination");
            return Boolean.valueOf(!NavController.this.backStackMap.containsKey(Integer.valueOf(destination.getId())));
        }
    }

    /* JADX INFO: renamed from: androidx.navigation.NavController$executeRestoreState$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/navigation/NavBackStackEntry;", "entry", "Lr8/z;", "invoke", "(Landroidx/navigation/NavBackStackEntry;)V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    static final class C05293 extends o implements l<NavBackStackEntry, z> {
        final /* synthetic */ Bundle $args;
        final /* synthetic */ List<NavBackStackEntry> $entries;
        final /* synthetic */ kotlin.jvm.internal.z $lastNavigatedIndex;
        final /* synthetic */ y $navigated;
        final /* synthetic */ NavController this$0;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(NavBackStackEntry navBackStackEntry) {
            invoke2(navBackStackEntry);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05293(y yVar, List<NavBackStackEntry> list, kotlin.jvm.internal.z zVar, NavController navController, Bundle bundle) {
            super(1);
            this.$navigated = yVar;
            this.$entries = list;
            this.$lastNavigatedIndex = zVar;
            this.this$0 = navController;
            this.$args = bundle;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(NavBackStackEntry entry) {
            List<NavBackStackEntry> listL;
            m.f(entry, "entry");
            this.$navigated.element = true;
            int iIndexOf = this.$entries.indexOf(entry);
            if (iIndexOf != -1) {
                int i10 = iIndexOf + 1;
                listL = this.$entries.subList(this.$lastNavigatedIndex.element, i10);
                this.$lastNavigatedIndex.element = i10;
            } else {
                listL = r.l();
            }
            this.this$0.addEntryToBackStack(entry.getDestination(), this.$args, entry, listL);
        }
    }

    /* JADX INFO: renamed from: androidx.navigation.NavController$handleDeepLink$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/navigation/NavOptionsBuilder;", "Lr8/z;", "invoke", "(Landroidx/navigation/NavOptionsBuilder;)V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    static final class C05302 extends o implements l<NavOptionsBuilder, z> {
        final /* synthetic */ NavDestination $node;
        final /* synthetic */ NavController this$0;

        /* JADX INFO: renamed from: androidx.navigation.NavController$handleDeepLink$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/navigation/AnimBuilder;", "Lr8/z;", "invoke", "(Landroidx/navigation/AnimBuilder;)V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
        static final class AnonymousClass1 extends o implements l<AnimBuilder, z> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            AnonymousClass1() {
                super(1);
            }

            @Override // c9.l
            public /* bridge */ /* synthetic */ z invoke(AnimBuilder animBuilder) {
                invoke2(animBuilder);
                return z.f17874a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AnimBuilder anim) {
                m.f(anim, "$this$anim");
                anim.setEnter(0);
                anim.setExit(0);
            }
        }

        /* JADX INFO: renamed from: androidx.navigation.NavController$handleDeepLink$2$2, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/navigation/PopUpToBuilder;", "Lr8/z;", "invoke", "(Landroidx/navigation/PopUpToBuilder;)V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
        static final class C00132 extends o implements l<PopUpToBuilder, z> {
            public static final C00132 INSTANCE = new C00132();

            C00132() {
                super(1);
            }

            @Override // c9.l
            public /* bridge */ /* synthetic */ z invoke(PopUpToBuilder popUpToBuilder) {
                invoke2(popUpToBuilder);
                return z.f17874a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PopUpToBuilder popUpTo) {
                m.f(popUpTo, "$this$popUpTo");
                popUpTo.setSaveState(true);
            }
        }

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(NavOptionsBuilder navOptionsBuilder) {
            invoke2(navOptionsBuilder);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05302(NavDestination navDestination, NavController navController) {
            super(1);
            this.$node = navDestination;
            this.this$0 = navController;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(NavOptionsBuilder navOptions) {
            m.f(navOptions, "$this$navOptions");
            navOptions.anim(AnonymousClass1.INSTANCE);
            NavDestination navDestination = this.$node;
            if (navDestination instanceof NavGraph) {
                h<NavDestination> hierarchy = NavDestination.INSTANCE.getHierarchy(navDestination);
                NavController navController = this.this$0;
                for (NavDestination navDestination2 : hierarchy) {
                    NavDestination currentDestination = navController.getCurrentDestination();
                    if (m.a(navDestination2, currentDestination != null ? currentDestination.getParent() : null)) {
                        return;
                    }
                }
                if (NavController.deepLinkSaveState) {
                    navOptions.popUpTo(NavGraph.INSTANCE.findStartDestination(this.this$0.getGraph()).getId(), C00132.INSTANCE);
                }
            }
        }
    }

    /* JADX INFO: renamed from: androidx.navigation.NavController$navigate$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/navigation/NavBackStackEntry;", "it", "Lr8/z;", "invoke", "(Landroidx/navigation/NavBackStackEntry;)V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    static final class AnonymousClass4 extends o implements l<NavBackStackEntry, z> {
        final /* synthetic */ Bundle $finalArgs;
        final /* synthetic */ y $navigated;
        final /* synthetic */ NavDestination $node;
        final /* synthetic */ NavController this$0;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(NavBackStackEntry navBackStackEntry) {
            invoke2(navBackStackEntry);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(y yVar, NavController navController, NavDestination navDestination, Bundle bundle) {
            super(1);
            this.$navigated = yVar;
            this.this$0 = navController;
            this.$node = navDestination;
            this.$finalArgs = bundle;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(NavBackStackEntry it) {
            m.f(it, "it");
            this.$navigated.element = true;
            NavController.addEntryToBackStack$default(this.this$0, this.$node, this.$finalArgs, it, null, 8, null);
        }
    }

    /* JADX INFO: renamed from: androidx.navigation.NavController$navigateInternal$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/navigation/NavBackStackEntry;", "it", "Lr8/z;", "invoke", "(Landroidx/navigation/NavBackStackEntry;)V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    static final class C05311 extends o implements l<NavBackStackEntry, z> {
        public static final C05311 INSTANCE = new C05311();

        C05311() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(NavBackStackEntry it) {
            m.f(it, "it");
        }

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(NavBackStackEntry navBackStackEntry) {
            invoke2(navBackStackEntry);
            return z.f17874a;
        }
    }

    /* JADX INFO: renamed from: androidx.navigation.NavController$popBackStackInternal$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/navigation/NavBackStackEntry;", "it", "Lr8/z;", "invoke", "(Landroidx/navigation/NavBackStackEntry;)V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    static final class C05321 extends o implements l<NavBackStackEntry, z> {
        public static final C05321 INSTANCE = new C05321();

        C05321() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(NavBackStackEntry it) {
            m.f(it, "it");
        }

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(NavBackStackEntry navBackStackEntry) {
            invoke2(navBackStackEntry);
            return z.f17874a;
        }
    }

    /* JADX INFO: renamed from: androidx.navigation.NavController$restoreStateInternal$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "", "invoke", "(Ljava/lang/String;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class C05331 extends o implements l<String, Boolean> {
        final /* synthetic */ String $backStackId;

        @Override // c9.l
        public final Boolean invoke(String str) {
            return Boolean.valueOf(m.a(str, this.$backStackId));
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05331(String str) {
            super(1);
            this.$backStackId = str;
        }
    }

    /* JADX INFO: renamed from: androidx.navigation.NavController$restoreStateInternal$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "", "invoke", "(Ljava/lang/String;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class C05343 extends o implements l<String, Boolean> {
        final /* synthetic */ String $backStackId;

        @Override // c9.l
        public final Boolean invoke(String str) {
            return Boolean.valueOf(m.a(str, this.$backStackId));
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05343(String str) {
            super(1);
            this.$backStackId = str;
        }
    }

    @MainThread
    private final boolean clearBackStackInternal(@IdRes int destinationId) {
        Iterator<T> it = this.navigatorState.values().iterator();
        while (it.hasNext()) {
            ((NavControllerNavigatorState) it.next()).setNavigating(true);
        }
        boolean zRestoreStateInternal = restoreStateInternal(destinationId, null, NavOptionsBuilderKt.navOptions(NavController$clearBackStackInternal$restored$1.INSTANCE), null);
        Iterator<T> it2 = this.navigatorState.values().iterator();
        while (it2.hasNext()) {
            ((NavControllerNavigatorState) it2.next()).setNavigating(false);
        }
        return zRestoreStateInternal && popBackStackInternal(destinationId, true, false);
    }

    private final void popBackStackInternal(Navigator<? extends NavDestination> navigator, NavBackStackEntry navBackStackEntry, boolean z10, l<? super NavBackStackEntry, z> lVar) {
        this.popFromBackStackHandler = lVar;
        navigator.popBackStack(navBackStackEntry, z10);
        this.popFromBackStackHandler = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void popBackStackInternal$default(NavController navController, Navigator navigator, NavBackStackEntry navBackStackEntry, boolean z10, l lVar, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: popBackStackInternal");
        }
        if ((i10 & 4) != 0) {
            lVar = C05321.INSTANCE;
        }
        navController.popBackStackInternal(navigator, navBackStackEntry, z10, lVar);
    }

    private final boolean restoreStateInternal(int id2, Bundle args, NavOptions navOptions, Navigator.Extras navigatorExtras) {
        if (!this.backStackMap.containsKey(Integer.valueOf(id2))) {
            return false;
        }
        String str = this.backStackMap.get(Integer.valueOf(id2));
        r.H(this.backStackMap.values(), new C05331(str));
        return executeRestoreState(instantiateBackStack((i) h0.d(this.backStackStates).remove(str)), args, navOptions, navigatorExtras);
    }

    @MainThread
    public final boolean clearBackStack(String route) {
        m.f(route, "route");
        return clearBackStackInternal(route) && dispatchOnDestinationChanged();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final NavDestination findDestination(@IdRes int destinationId) {
        NavDestination destination;
        NavGraph navGraph = this._graph;
        if (navGraph == null) {
            return null;
        }
        m.c(navGraph);
        if (navGraph.getId() == destinationId) {
            return this._graph;
        }
        NavBackStackEntry navBackStackEntryQ = this.backQueue.q();
        if (navBackStackEntryQ == null || (destination = navBackStackEntryQ.getDestination()) == null) {
            destination = this._graph;
            m.c(destination);
        }
        return findDestination(destination, destinationId);
    }

    public NavBackStackEntry getBackStackEntry(@IdRes int destinationId) {
        NavBackStackEntry navBackStackEntryPrevious;
        i<NavBackStackEntry> iVar = this.backQueue;
        ListIterator<NavBackStackEntry> listIterator = iVar.listIterator(iVar.size());
        do {
            if (!listIterator.hasPrevious()) {
                navBackStackEntryPrevious = null;
                break;
            }
            navBackStackEntryPrevious = listIterator.previous();
        } while (navBackStackEntryPrevious.getDestination().getId() != destinationId);
        NavBackStackEntry navBackStackEntry = navBackStackEntryPrevious;
        if (navBackStackEntry != null) {
            return navBackStackEntry;
        }
        throw new IllegalArgumentException(("No destination with ID " + destinationId + " is on the NavController's back stack. The current destination is " + getCurrentDestination()).toString());
    }

    @MainThread
    public final void navigate(String route) {
        m.f(route, "route");
        navigate$default(this, route, null, null, 6, null);
    }

    @MainThread
    public final boolean popBackStack(String route, boolean z10) {
        m.f(route, "route");
        return popBackStack$default(this, route, z10, false, 4, null);
    }

    @CallSuper
    @MainThread
    public void setGraph(NavGraph graph) {
        m.f(graph, "graph");
        setGraph(graph, (Bundle) null);
    }

    public NavController(Context context) {
        m.f(context, "context");
        this.context = context;
        for (Object obj : ta.k.o(context, NavController$activity$1.INSTANCE)) {
            if (((Context) obj) instanceof Activity) {
                this.activity = (Activity) obj;
                this.backQueue = new i<>();
                v<List<NavBackStackEntry>> vVarA = f0.a(r.l());
                this._currentBackStack = vVarA;
                this.currentBackStack = kotlinx.coroutines.flow.h.b(vVarA);
                v<List<NavBackStackEntry>> vVarA2 = f0.a(r.l());
                this._visibleEntries = vVarA2;
                this.visibleEntries = kotlinx.coroutines.flow.h.b(vVarA2);
                this.childToParentEntries = new LinkedHashMap();
                this.parentToChildCount = new LinkedHashMap();
                this.backStackMap = new LinkedHashMap();
                this.backStackStates = new LinkedHashMap();
                this.onDestinationChangedListeners = new CopyOnWriteArrayList<>();
                this.hostLifecycleState = Lifecycle.State.INITIALIZED;
                this.lifecycleObserver = new LifecycleEventObserver() { // from class: androidx.navigation.a
                    @Override // androidx.p000lifecycle.LifecycleEventObserver
                    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                        NavController.lifecycleObserver$lambda$2(this.f506a, lifecycleOwner, event);
                    }
                };
                this.onBackPressedCallback = new OnBackPressedCallback() { // from class: androidx.navigation.NavController$onBackPressedCallback$1
                    {
                        super(false);
                    }

                    @Override // androidx.view.OnBackPressedCallback
                    public void handleOnBackPressed() {
                        this.this$0.popBackStack();
                    }
                };
                this.enableOnBackPressedCallback = true;
                this._navigatorProvider = new NavigatorProvider();
                this.navigatorState = new LinkedHashMap();
                this.entrySavedState = new LinkedHashMap();
                NavigatorProvider navigatorProvider = this._navigatorProvider;
                navigatorProvider.addNavigator(new NavGraphNavigator(navigatorProvider));
                this._navigatorProvider.addNavigator(new ActivityNavigator(this.context));
                this.backStackEntriesToDispatch = new ArrayList();
                this.navInflater = j.a(new NavController$navInflater$2(this));
                u<NavBackStackEntry> uVarB = b0.b(1, 0, kotlinx.coroutines.channels.a.DROP_OLDEST, 2, null);
                this._currentBackStackEntryFlow = uVarB;
                this.currentBackStackEntryFlow = kotlinx.coroutines.flow.h.a(uVarB);
            }
        }
        obj = null;
        this.activity = (Activity) obj;
        this.backQueue = new i<>();
        v<List<NavBackStackEntry>> vVarA3 = f0.a(r.l());
        this._currentBackStack = vVarA3;
        this.currentBackStack = kotlinx.coroutines.flow.h.b(vVarA3);
        v<List<NavBackStackEntry>> vVarA4 = f0.a(r.l());
        this._visibleEntries = vVarA4;
        this.visibleEntries = kotlinx.coroutines.flow.h.b(vVarA4);
        this.childToParentEntries = new LinkedHashMap();
        this.parentToChildCount = new LinkedHashMap();
        this.backStackMap = new LinkedHashMap();
        this.backStackStates = new LinkedHashMap();
        this.onDestinationChangedListeners = new CopyOnWriteArrayList<>();
        this.hostLifecycleState = Lifecycle.State.INITIALIZED;
        this.lifecycleObserver = new LifecycleEventObserver() { // from class: androidx.navigation.a
            @Override // androidx.p000lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                NavController.lifecycleObserver$lambda$2(this.f506a, lifecycleOwner, event);
            }
        };
        this.onBackPressedCallback = new OnBackPressedCallback() { // from class: androidx.navigation.NavController$onBackPressedCallback$1
            {
                super(false);
            }

            @Override // androidx.view.OnBackPressedCallback
            public void handleOnBackPressed() {
                this.this$0.popBackStack();
            }
        };
        this.enableOnBackPressedCallback = true;
        this._navigatorProvider = new NavigatorProvider();
        this.navigatorState = new LinkedHashMap();
        this.entrySavedState = new LinkedHashMap();
        NavigatorProvider navigatorProvider2 = this._navigatorProvider;
        navigatorProvider2.addNavigator(new NavGraphNavigator(navigatorProvider2));
        this._navigatorProvider.addNavigator(new ActivityNavigator(this.context));
        this.backStackEntriesToDispatch = new ArrayList();
        this.navInflater = j.a(new NavController$navInflater$2(this));
        u<NavBackStackEntry> uVarB2 = b0.b(1, 0, kotlinx.coroutines.channels.a.DROP_OLDEST, 2, null);
        this._currentBackStackEntryFlow = uVarB2;
        this.currentBackStackEntryFlow = kotlinx.coroutines.flow.h.a(uVarB2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addEntryToBackStack(NavDestination node, Bundle finalArgs, NavBackStackEntry backStackEntry, List<NavBackStackEntry> restoredEntries) {
        Bundle bundle;
        i<NavBackStackEntry> iVar;
        NavDestination destination;
        List<NavBackStackEntry> list;
        NavGraph navGraph;
        NavBackStackEntry navBackStackEntryPrevious;
        NavBackStackEntry navBackStackEntryPrevious2;
        List<NavBackStackEntry> list2 = restoredEntries;
        NavDestination destination2 = backStackEntry.getDestination();
        if (!(destination2 instanceof FloatingWindow)) {
            while (!this.backQueue.isEmpty() && (this.backQueue.last().getDestination() instanceof FloatingWindow) && popBackStackInternal$default(this, this.backQueue.last().getDestination().getId(), true, false, 4, null)) {
            }
        }
        i iVar2 = new i();
        NavBackStackEntry navBackStackEntry = null;
        if (node instanceof NavGraph) {
            NavDestination navDestination = destination2;
            while (true) {
                m.c(navDestination);
                NavGraph parent = navDestination.getParent();
                if (parent != null) {
                    ListIterator<NavBackStackEntry> listIterator = list2.listIterator(list2.size());
                    do {
                        if (!listIterator.hasPrevious()) {
                            navBackStackEntryPrevious2 = null;
                            break;
                        }
                        navBackStackEntryPrevious2 = listIterator.previous();
                    } while (!m.a(navBackStackEntryPrevious2.getDestination(), parent));
                    NavBackStackEntry navBackStackEntryCreate$default = navBackStackEntryPrevious2;
                    if (navBackStackEntryCreate$default == null) {
                        bundle = finalArgs;
                        destination = destination2;
                        navBackStackEntryCreate$default = NavBackStackEntry.Companion.create$default(NavBackStackEntry.INSTANCE, this.context, parent, bundle, getHostLifecycleState$navigation_runtime_release(), this.viewModel, null, null, 96, null);
                    } else {
                        bundle = finalArgs;
                        destination = destination2;
                    }
                    iVar2.addFirst(navBackStackEntryCreate$default);
                    if (this.backQueue.isEmpty() || this.backQueue.last().getDestination() != parent) {
                        list = restoredEntries;
                        iVar = iVar2;
                    } else {
                        list = restoredEntries;
                        iVar = iVar2;
                        popEntryFromBackStack$default(this, this.backQueue.last(), false, null, 6, null);
                    }
                } else {
                    bundle = finalArgs;
                    iVar = iVar2;
                    destination = destination2;
                    list = list2;
                }
                if (parent == null || parent == node) {
                    break;
                }
                list2 = list;
                navDestination = parent;
                iVar2 = iVar;
                destination2 = destination;
            }
        } else {
            bundle = finalArgs;
            iVar = iVar2;
            destination = destination2;
            list = list2;
            backStackEntry = backStackEntry;
        }
        NavDestination destination3 = iVar.isEmpty() ? destination : ((NavBackStackEntry) iVar.first()).getDestination();
        while (destination3 != null && findDestination(destination3.getId()) != destination3) {
            NavGraph parent2 = destination3.getParent();
            if (parent2 != null) {
                Bundle bundle2 = (bundle == null || !bundle.isEmpty()) ? bundle : null;
                ListIterator<NavBackStackEntry> listIterator2 = list.listIterator(list.size());
                do {
                    if (!listIterator2.hasPrevious()) {
                        navBackStackEntryPrevious = null;
                        break;
                    }
                    navBackStackEntryPrevious = listIterator2.previous();
                } while (!m.a(navBackStackEntryPrevious.getDestination(), parent2));
                NavBackStackEntry navBackStackEntryCreate$default2 = navBackStackEntryPrevious;
                if (navBackStackEntryCreate$default2 == null) {
                    navGraph = parent2;
                    navBackStackEntryCreate$default2 = NavBackStackEntry.Companion.create$default(NavBackStackEntry.INSTANCE, this.context, navGraph, parent2.addInDefaultArgs(bundle2), getHostLifecycleState$navigation_runtime_release(), this.viewModel, null, null, 96, null);
                } else {
                    navGraph = parent2;
                }
                iVar.addFirst(navBackStackEntryCreate$default2);
            } else {
                navGraph = parent2;
            }
            destination3 = navGraph;
        }
        if (!iVar.isEmpty()) {
            destination = ((NavBackStackEntry) iVar.first()).getDestination();
        }
        while (!this.backQueue.isEmpty() && (this.backQueue.last().getDestination() instanceof NavGraph)) {
            NavDestination destination4 = this.backQueue.last().getDestination();
            m.d(destination4, "null cannot be cast to non-null type androidx.navigation.NavGraph");
            if (((NavGraph) destination4).findNode(destination.getId(), false) != null) {
                break;
            } else {
                popEntryFromBackStack$default(this, this.backQueue.last(), false, null, 6, null);
            }
        }
        NavBackStackEntry navBackStackEntryN = this.backQueue.n();
        if (navBackStackEntryN == null) {
            navBackStackEntryN = (NavBackStackEntry) iVar.n();
        }
        if (!m.a(navBackStackEntryN != null ? navBackStackEntryN.getDestination() : null, this._graph)) {
            ListIterator<NavBackStackEntry> listIterator3 = list.listIterator(list.size());
            while (listIterator3.hasPrevious()) {
                NavBackStackEntry navBackStackEntryPrevious3 = listIterator3.previous();
                NavDestination destination5 = navBackStackEntryPrevious3.getDestination();
                NavGraph navGraph2 = this._graph;
                m.c(navGraph2);
                if (m.a(destination5, navGraph2)) {
                    navBackStackEntry = navBackStackEntryPrevious3;
                    break;
                }
            }
            NavBackStackEntry navBackStackEntryCreate$default3 = navBackStackEntry;
            if (navBackStackEntryCreate$default3 == null) {
                NavBackStackEntry.Companion companion = NavBackStackEntry.INSTANCE;
                Context context = this.context;
                NavGraph navGraph3 = this._graph;
                m.c(navGraph3);
                NavGraph navGraph4 = this._graph;
                m.c(navGraph4);
                navBackStackEntryCreate$default3 = NavBackStackEntry.Companion.create$default(companion, context, navGraph3, navGraph4.addInDefaultArgs(bundle), getHostLifecycleState$navigation_runtime_release(), this.viewModel, null, null, 96, null);
            }
            iVar.addFirst(navBackStackEntryCreate$default3);
        }
        for (NavBackStackEntry navBackStackEntry2 : iVar) {
            NavControllerNavigatorState navControllerNavigatorState = this.navigatorState.get(this._navigatorProvider.getNavigator(navBackStackEntry2.getDestination().getNavigatorName()));
            if (navControllerNavigatorState == null) {
                throw new IllegalStateException(("NavigatorBackStack for " + node.getNavigatorName() + " should already be created").toString());
            }
            navControllerNavigatorState.addInternal(navBackStackEntry2);
        }
        this.backQueue.addAll(iVar);
        this.backQueue.add(backStackEntry);
        for (NavBackStackEntry navBackStackEntry3 : r.C0(iVar, backStackEntry)) {
            NavGraph parent3 = navBackStackEntry3.getDestination().getParent();
            if (parent3 != null) {
                linkChildToParent(navBackStackEntry3, getBackStackEntry(parent3.getId()));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void addEntryToBackStack$default(NavController navController, NavDestination navDestination, Bundle bundle, NavBackStackEntry navBackStackEntry, List list, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addEntryToBackStack");
        }
        if ((i10 & 8) != 0) {
            list = r.l();
        }
        navController.addEntryToBackStack(navDestination, bundle, navBackStackEntry, list);
    }

    private final boolean dispatchOnDestinationChanged() {
        while (!this.backQueue.isEmpty() && (this.backQueue.last().getDestination() instanceof NavGraph)) {
            popEntryFromBackStack$default(this, this.backQueue.last(), false, null, 6, null);
        }
        NavBackStackEntry navBackStackEntryQ = this.backQueue.q();
        if (navBackStackEntryQ != null) {
            this.backStackEntriesToDispatch.add(navBackStackEntryQ);
        }
        this.dispatchReentrantCount++;
        updateBackStackLifecycle$navigation_runtime_release();
        int i10 = this.dispatchReentrantCount - 1;
        this.dispatchReentrantCount = i10;
        if (i10 == 0) {
            List<NavBackStackEntry> listQ0 = r.Q0(this.backStackEntriesToDispatch);
            this.backStackEntriesToDispatch.clear();
            for (NavBackStackEntry navBackStackEntry : listQ0) {
                Iterator<OnDestinationChangedListener> it = this.onDestinationChangedListeners.iterator();
                while (it.hasNext()) {
                    it.next().onDestinationChanged(this, navBackStackEntry.getDestination(), navBackStackEntry.getArguments());
                }
                this._currentBackStackEntryFlow.a(navBackStackEntry);
            }
            this._currentBackStack.a(r.Q0(this.backQueue));
            this._visibleEntries.a(populateVisibleEntries$navigation_runtime_release());
        }
        return navBackStackEntryQ != null;
    }

    @NavDeepLinkSaveStateControl
    public static final void enableDeepLinkSaveState(boolean z10) {
        INSTANCE.enableDeepLinkSaveState(z10);
    }

    private final boolean executePopOperations(List<? extends Navigator<?>> popOperations, NavDestination foundDestination, boolean inclusive, boolean saveState) {
        NavController navController;
        boolean z10;
        y yVar = new y();
        i<NavBackStackEntryState> iVar = new i<>();
        Iterator<? extends Navigator<?>> it = popOperations.iterator();
        while (true) {
            if (!it.hasNext()) {
                navController = this;
                z10 = saveState;
                break;
            }
            Navigator<? extends NavDestination> navigator = (Navigator) it.next();
            y yVar2 = new y();
            navController = this;
            z10 = saveState;
            popBackStackInternal(navigator, this.backQueue.last(), z10, new AnonymousClass1(yVar2, yVar, navController, z10, iVar));
            if (!yVar2.element) {
                break;
            }
            saveState = z10;
        }
        if (z10) {
            if (!inclusive) {
                for (NavDestination navDestination : ta.k.N(ta.k.o(foundDestination, AnonymousClass2.INSTANCE), new AnonymousClass3())) {
                    Map<Integer, String> map = navController.backStackMap;
                    Integer numValueOf = Integer.valueOf(navDestination.getId());
                    NavBackStackEntryState navBackStackEntryStateN = iVar.n();
                    map.put(numValueOf, navBackStackEntryStateN != null ? navBackStackEntryStateN.getId() : null);
                }
            }
            if (!iVar.isEmpty()) {
                NavBackStackEntryState navBackStackEntryStateFirst = iVar.first();
                Iterator it2 = ta.k.N(ta.k.o(findDestination(navBackStackEntryStateFirst.getDestinationId()), AnonymousClass5.INSTANCE), new AnonymousClass6()).iterator();
                while (it2.hasNext()) {
                    navController.backStackMap.put(Integer.valueOf(((NavDestination) it2.next()).getId()), navBackStackEntryStateFirst.getId());
                }
                navController.backStackStates.put(navBackStackEntryStateFirst.getId(), iVar);
            }
        }
        updateOnBackPressedCallbackEnabled();
        return yVar.element;
    }

    private final boolean executeRestoreState(List<NavBackStackEntry> entries, Bundle args, NavOptions navOptions, Navigator.Extras navigatorExtras) {
        NavBackStackEntry navBackStackEntry;
        NavDestination destination;
        ArrayList<List<NavBackStackEntry>> arrayList = new ArrayList();
        ArrayList<NavBackStackEntry> arrayList2 = new ArrayList();
        for (Object obj : entries) {
            if (!(((NavBackStackEntry) obj).getDestination() instanceof NavGraph)) {
                arrayList2.add(obj);
            }
        }
        for (NavBackStackEntry navBackStackEntry2 : arrayList2) {
            List list = (List) r.u0(arrayList);
            if (m.a((list == null || (navBackStackEntry = (NavBackStackEntry) r.s0(list)) == null || (destination = navBackStackEntry.getDestination()) == null) ? null : destination.getNavigatorName(), navBackStackEntry2.getDestination().getNavigatorName())) {
                list.add(navBackStackEntry2);
            } else {
                arrayList.add(r.r(navBackStackEntry2));
            }
        }
        y yVar = new y();
        for (List<NavBackStackEntry> list2 : arrayList) {
            navigateInternal(this._navigatorProvider.getNavigator(((NavBackStackEntry) r.g0(list2)).getDestination().getNavigatorName()), list2, navOptions, navigatorExtras, new C05293(yVar, entries, new kotlin.jvm.internal.z(), this, args));
        }
        return yVar.element;
    }

    private final String findInvalidDestinationDisplayNameInDeepLink(int[] deepLink) {
        NavGraph navGraph;
        NavGraph navGraph2 = this._graph;
        int length = deepLink.length;
        int i10 = 0;
        while (true) {
            NavDestination navDestinationFindNode = null;
            if (i10 >= length) {
                return null;
            }
            int i11 = deepLink[i10];
            if (i10 == 0) {
                NavGraph navGraph3 = this._graph;
                m.c(navGraph3);
                if (navGraph3.getId() == i11) {
                    navDestinationFindNode = this._graph;
                }
            } else {
                m.c(navGraph2);
                navDestinationFindNode = navGraph2.findNode(i11);
            }
            if (navDestinationFindNode == null) {
                return NavDestination.INSTANCE.getDisplayName(this.context, i11);
            }
            if (i10 != deepLink.length - 1 && (navDestinationFindNode instanceof NavGraph)) {
                while (true) {
                    navGraph = (NavGraph) navDestinationFindNode;
                    m.c(navGraph);
                    if (!(navGraph.findNode(navGraph.getStartDestId()) instanceof NavGraph)) {
                        break;
                    }
                    navDestinationFindNode = navGraph.findNode(navGraph.getStartDestId());
                }
                navGraph2 = navGraph;
            }
            i10++;
        }
    }

    private final int getDestinationCountOnBackStack() {
        i<NavBackStackEntry> iVar = this.backQueue;
        int i10 = 0;
        if (k.a(iVar) && iVar.isEmpty()) {
            return 0;
        }
        Iterator<NavBackStackEntry> it = iVar.iterator();
        while (it.hasNext()) {
            if (!(it.next().getDestination() instanceof NavGraph) && (i10 = i10 + 1) < 0) {
                r.u();
            }
        }
        return i10;
    }

    private final List<NavBackStackEntry> instantiateBackStack(i<NavBackStackEntryState> backStackState) {
        NavDestination graph;
        ArrayList arrayList = new ArrayList();
        NavBackStackEntry navBackStackEntryQ = this.backQueue.q();
        if (navBackStackEntryQ == null || (graph = navBackStackEntryQ.getDestination()) == null) {
            graph = getGraph();
        }
        if (backStackState != null) {
            for (NavBackStackEntryState navBackStackEntryState : backStackState) {
                NavDestination navDestinationFindDestination = findDestination(graph, navBackStackEntryState.getDestinationId());
                if (navDestinationFindDestination == null) {
                    throw new IllegalStateException(("Restore State failed: destination " + NavDestination.INSTANCE.getDisplayName(this.context, navBackStackEntryState.getDestinationId()) + " cannot be found from the current destination " + graph).toString());
                }
                arrayList.add(navBackStackEntryState.instantiate(this.context, navDestinationFindDestination, getHostLifecycleState$navigation_runtime_release(), this.viewModel));
                graph = navDestinationFindDestination;
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void lifecycleObserver$lambda$2(NavController this$0, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        m.f(this$0, "this$0");
        m.f(lifecycleOwner, "<anonymous parameter 0>");
        m.f(event, "event");
        this$0.hostLifecycleState = event.getTargetState();
        if (this$0._graph != null) {
            Iterator<NavBackStackEntry> it = this$0.backQueue.iterator();
            while (it.hasNext()) {
                it.next().handleLifecycleEvent(event);
            }
        }
    }

    private final void linkChildToParent(NavBackStackEntry child, NavBackStackEntry parent) {
        this.childToParentEntries.put(child, parent);
        if (this.parentToChildCount.get(parent) == null) {
            this.parentToChildCount.put(parent, new AtomicInteger(0));
        }
        AtomicInteger atomicInteger = this.parentToChildCount.get(parent);
        m.c(atomicInteger);
        atomicInteger.incrementAndGet();
    }

    public static /* synthetic */ void navigate$default(NavController navController, String str, NavOptions navOptions, Navigator.Extras extras, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: navigate");
        }
        if ((i10 & 2) != 0) {
            navOptions = null;
        }
        if ((i10 & 4) != 0) {
            extras = null;
        }
        navController.navigate(str, navOptions, extras);
    }

    private final void navigateInternal(Navigator<? extends NavDestination> navigator, List<NavBackStackEntry> list, NavOptions navOptions, Navigator.Extras extras, l<? super NavBackStackEntry, z> lVar) {
        this.addToBackStackHandler = lVar;
        navigator.navigate(list, navOptions, extras);
        this.addToBackStackHandler = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void navigateInternal$default(NavController navController, Navigator navigator, List list, NavOptions navOptions, Navigator.Extras extras, l lVar, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: navigateInternal");
        }
        if ((i10 & 8) != 0) {
            lVar = C05311.INSTANCE;
        }
        navController.navigateInternal(navigator, list, navOptions, extras, lVar);
    }

    @MainThread
    private final void onGraphCreated(Bundle startDestinationArgs) {
        Activity activity;
        ArrayList<String> stringArrayList;
        Bundle bundle = this.navigatorStateToRestore;
        if (bundle != null && (stringArrayList = bundle.getStringArrayList(KEY_NAVIGATOR_STATE_NAMES)) != null) {
            for (String name : stringArrayList) {
                NavigatorProvider navigatorProvider = this._navigatorProvider;
                m.e(name, "name");
                Navigator navigator = navigatorProvider.getNavigator(name);
                Bundle bundle2 = bundle.getBundle(name);
                if (bundle2 != null) {
                    navigator.onRestoreState(bundle2);
                }
            }
        }
        Parcelable[] parcelableArr = this.backStackToRestore;
        if (parcelableArr != null) {
            for (Parcelable parcelable : parcelableArr) {
                m.d(parcelable, "null cannot be cast to non-null type androidx.navigation.NavBackStackEntryState");
                NavBackStackEntryState navBackStackEntryState = (NavBackStackEntryState) parcelable;
                NavDestination navDestinationFindDestination = findDestination(navBackStackEntryState.getDestinationId());
                if (navDestinationFindDestination == null) {
                    throw new IllegalStateException("Restoring the Navigation back stack failed: destination " + NavDestination.INSTANCE.getDisplayName(this.context, navBackStackEntryState.getDestinationId()) + " cannot be found from the current destination " + getCurrentDestination());
                }
                NavBackStackEntry navBackStackEntryInstantiate = navBackStackEntryState.instantiate(this.context, navDestinationFindDestination, getHostLifecycleState$navigation_runtime_release(), this.viewModel);
                Navigator<? extends NavDestination> navigator2 = this._navigatorProvider.getNavigator(navDestinationFindDestination.getNavigatorName());
                Map<Navigator<? extends NavDestination>, NavControllerNavigatorState> map = this.navigatorState;
                NavControllerNavigatorState navControllerNavigatorState = map.get(navigator2);
                if (navControllerNavigatorState == null) {
                    navControllerNavigatorState = new NavControllerNavigatorState(this, navigator2);
                    map.put(navigator2, navControllerNavigatorState);
                }
                this.backQueue.add(navBackStackEntryInstantiate);
                navControllerNavigatorState.addInternal(navBackStackEntryInstantiate);
                NavGraph parent = navBackStackEntryInstantiate.getDestination().getParent();
                if (parent != null) {
                    linkChildToParent(navBackStackEntryInstantiate, getBackStackEntry(parent.getId()));
                }
            }
            updateOnBackPressedCallbackEnabled();
            this.backStackToRestore = null;
        }
        Collection<Navigator<? extends NavDestination>> collectionValues = this._navigatorProvider.getNavigators().values();
        ArrayList<Navigator<? extends NavDestination>> arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            if (!((Navigator) obj).getIsAttached()) {
                arrayList.add(obj);
            }
        }
        for (Navigator<? extends NavDestination> navigator3 : arrayList) {
            Map<Navigator<? extends NavDestination>, NavControllerNavigatorState> map2 = this.navigatorState;
            NavControllerNavigatorState navControllerNavigatorState2 = map2.get(navigator3);
            if (navControllerNavigatorState2 == null) {
                navControllerNavigatorState2 = new NavControllerNavigatorState(this, navigator3);
                map2.put(navigator3, navControllerNavigatorState2);
            }
            navigator3.onAttach(navControllerNavigatorState2);
        }
        if (this._graph == null || !this.backQueue.isEmpty()) {
            dispatchOnDestinationChanged();
            return;
        }
        if (!this.deepLinkHandled && (activity = this.activity) != null) {
            m.c(activity);
            if (handleDeepLink(activity.getIntent())) {
                return;
            }
        }
        NavGraph navGraph = this._graph;
        m.c(navGraph);
        navigate(navGraph, startDestinationArgs, (NavOptions) null, (Navigator.Extras) null);
    }

    public static /* synthetic */ boolean popBackStack$default(NavController navController, String str, boolean z10, boolean z11, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: popBackStack");
        }
        if ((i10 & 4) != 0) {
            z11 = false;
        }
        return navController.popBackStack(str, z10, z11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void popEntryFromBackStack(NavBackStackEntry popUpTo, boolean saveState, i<NavBackStackEntryState> savedState) {
        NavControllerViewModel navControllerViewModel;
        d0<Set<NavBackStackEntry>> transitionsInProgress;
        Set<NavBackStackEntry> value;
        NavBackStackEntry navBackStackEntryLast = this.backQueue.last();
        if (!m.a(navBackStackEntryLast, popUpTo)) {
            throw new IllegalStateException(("Attempted to pop " + popUpTo.getDestination() + ", which is not the top of the back stack (" + navBackStackEntryLast.getDestination() + ')').toString());
        }
        this.backQueue.removeLast();
        NavControllerNavigatorState navControllerNavigatorState = this.navigatorState.get(get_navigatorProvider().getNavigator(navBackStackEntryLast.getDestination().getNavigatorName()));
        boolean z10 = true;
        if ((navControllerNavigatorState == null || (transitionsInProgress = navControllerNavigatorState.getTransitionsInProgress()) == null || (value = transitionsInProgress.getValue()) == null || !value.contains(navBackStackEntryLast)) && !this.parentToChildCount.containsKey(navBackStackEntryLast)) {
            z10 = false;
        }
        Lifecycle.State state = navBackStackEntryLast.getLifecycle().getState();
        Lifecycle.State state2 = Lifecycle.State.CREATED;
        if (state.isAtLeast(state2)) {
            if (saveState) {
                navBackStackEntryLast.setMaxLifecycle(state2);
                savedState.addFirst(new NavBackStackEntryState(navBackStackEntryLast));
            }
            if (z10) {
                navBackStackEntryLast.setMaxLifecycle(state2);
            } else {
                navBackStackEntryLast.setMaxLifecycle(Lifecycle.State.DESTROYED);
                unlinkChildFromParent$navigation_runtime_release(navBackStackEntryLast);
            }
        }
        if (saveState || z10 || (navControllerViewModel = this.viewModel) == null) {
            return;
        }
        navControllerViewModel.clear(navBackStackEntryLast.getId());
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void popEntryFromBackStack$default(NavController navController, NavBackStackEntry navBackStackEntry, boolean z10, i iVar, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: popEntryFromBackStack");
        }
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        if ((i10 & 4) != 0) {
            iVar = new i();
        }
        navController.popEntryFromBackStack(navBackStackEntry, z10, iVar);
    }

    private final boolean tryRelaunchUpToExplicitStack() {
        int i10 = 0;
        if (!this.deepLinkHandled) {
            return false;
        }
        Activity activity = this.activity;
        m.c(activity);
        Intent intent = activity.getIntent();
        Bundle extras = intent.getExtras();
        m.c(extras);
        int[] intArray = extras.getIntArray(KEY_DEEP_LINK_IDS);
        m.c(intArray);
        List<Integer> listL0 = kotlin.collections.j.L0(intArray);
        ArrayList parcelableArrayList = extras.getParcelableArrayList(KEY_DEEP_LINK_ARGS);
        int iIntValue = ((Number) r.K(listL0)).intValue();
        if (parcelableArrayList != null) {
        }
        if (listL0.isEmpty()) {
            return false;
        }
        NavDestination navDestinationFindDestination = findDestination(getGraph(), iIntValue);
        if (navDestinationFindDestination instanceof NavGraph) {
            iIntValue = NavGraph.INSTANCE.findStartDestination((NavGraph) navDestinationFindDestination).getId();
        }
        NavDestination currentDestination = getCurrentDestination();
        if (currentDestination == null || iIntValue != currentDestination.getId()) {
            return false;
        }
        NavDeepLinkBuilder navDeepLinkBuilderCreateDeepLink = createDeepLink();
        Bundle bundleBundleOf = BundleKt.bundleOf(r8.v.a(KEY_DEEP_LINK_INTENT, intent));
        Bundle bundle = extras.getBundle(KEY_DEEP_LINK_EXTRAS);
        if (bundle != null) {
            bundleBundleOf.putAll(bundle);
        }
        navDeepLinkBuilderCreateDeepLink.setArguments(bundleBundleOf);
        for (Object obj : listL0) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                r.v();
            }
            navDeepLinkBuilderCreateDeepLink.addDestination(((Number) obj).intValue(), parcelableArrayList != null ? (Bundle) parcelableArrayList.get(i10) : null);
            i10 = i11;
        }
        navDeepLinkBuilderCreateDeepLink.createTaskStackBuilder().startActivities();
        Activity activity2 = this.activity;
        if (activity2 != null) {
            activity2.finish();
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x000e  */
    private final void updateOnBackPressedCallbackEnabled() {
        boolean z10;
        OnBackPressedCallback onBackPressedCallback = this.onBackPressedCallback;
        if (this.enableOnBackPressedCallback) {
            z10 = getDestinationCountOnBackStack() > 1;
        }
        onBackPressedCallback.setEnabled(z10);
    }

    public void addOnDestinationChangedListener(OnDestinationChangedListener listener) {
        m.f(listener, "listener");
        this.onDestinationChangedListeners.add(listener);
        if (this.backQueue.isEmpty()) {
            return;
        }
        NavBackStackEntry navBackStackEntryLast = this.backQueue.last();
        listener.onDestinationChanged(this, navBackStackEntryLast.getDestination(), navBackStackEntryLast.getArguments());
    }

    public NavDeepLinkBuilder createDeepLink() {
        return new NavDeepLinkBuilder(this);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void enableOnBackPressed(boolean enabled) {
        this.enableOnBackPressedCallback = enabled;
        updateOnBackPressedCallbackEnabled();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final Context getContext() {
        return this.context;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final d0<List<NavBackStackEntry>> getCurrentBackStack() {
        return this.currentBackStack;
    }

    public NavBackStackEntry getCurrentBackStackEntry() {
        return this.backQueue.q();
    }

    public final f<NavBackStackEntry> getCurrentBackStackEntryFlow() {
        return this.currentBackStackEntryFlow;
    }

    @MainThread
    public NavGraph getGraph() {
        NavGraph navGraph = this._graph;
        if (navGraph == null) {
            throw new IllegalStateException("You must call setGraph() before calling getGraph()");
        }
        m.d(navGraph, "null cannot be cast to non-null type androidx.navigation.NavGraph");
        return navGraph;
    }

    public final Lifecycle.State getHostLifecycleState$navigation_runtime_release() {
        return this.lifecycleOwner == null ? Lifecycle.State.CREATED : this.hostLifecycleState;
    }

    public NavInflater getNavInflater() {
        return (NavInflater) this.navInflater.getValue();
    }

    /* JADX INFO: renamed from: getNavigatorProvider, reason: from getter */
    public NavigatorProvider get_navigatorProvider() {
        return this._navigatorProvider;
    }

    public NavBackStackEntry getPreviousBackStackEntry() {
        Object next;
        Iterator it = r.D0(this.backQueue).iterator();
        if (it.hasNext()) {
            it.next();
        }
        Iterator it2 = ta.k.g(it).iterator();
        while (it2.hasNext()) {
            next = it2.next();
            if (!(((NavBackStackEntry) next).getDestination() instanceof NavGraph)) {
                return (NavBackStackEntry) next;
            }
        }
        next = null;
        return (NavBackStackEntry) next;
    }

    public ViewModelStoreOwner getViewModelStoreOwner(@IdRes int navGraphId) {
        if (this.viewModel == null) {
            throw new IllegalStateException("You must call setViewModelStore() before calling getViewModelStoreOwner().");
        }
        NavBackStackEntry backStackEntry = getBackStackEntry(navGraphId);
        if (backStackEntry.getDestination() instanceof NavGraph) {
            return backStackEntry;
        }
        throw new IllegalArgumentException(("No NavGraph with ID " + navGraphId + " is on the NavController's back stack").toString());
    }

    public final d0<List<NavBackStackEntry>> getVisibleEntries() {
        return this.visibleEntries;
    }

    @MainThread
    public boolean handleDeepLink(Intent intent) {
        int[] intArray;
        NavDestination navDestinationFindNode;
        NavGraph navGraph;
        Bundle bundle;
        int i10 = 0;
        if (intent == null) {
            return false;
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            try {
                intArray = extras.getIntArray(KEY_DEEP_LINK_IDS);
            } catch (Exception e10) {
                Log.e(TAG, "handleDeepLink() could not extract deepLink from " + intent, e10);
                intArray = null;
            }
        } else {
            intArray = null;
        }
        ArrayList parcelableArrayList = extras != null ? extras.getParcelableArrayList(KEY_DEEP_LINK_ARGS) : null;
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = extras != null ? extras.getBundle(KEY_DEEP_LINK_EXTRAS) : null;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        if (intArray == null || intArray.length == 0) {
            NavGraph navGraph2 = this._graph;
            m.c(navGraph2);
            NavDestination.DeepLinkMatch deepLinkMatchMatchDeepLink = navGraph2.matchDeepLink(new NavDeepLinkRequest(intent));
            if (deepLinkMatchMatchDeepLink != null) {
                NavDestination destination = deepLinkMatchMatchDeepLink.getDestination();
                int[] iArrBuildDeepLinkIds$default = NavDestination.buildDeepLinkIds$default(destination, null, 1, null);
                Bundle bundleAddInDefaultArgs = destination.addInDefaultArgs(deepLinkMatchMatchDeepLink.getMatchingArgs());
                if (bundleAddInDefaultArgs != null) {
                    bundle2.putAll(bundleAddInDefaultArgs);
                }
                intArray = iArrBuildDeepLinkIds$default;
                parcelableArrayList = null;
            }
        }
        if (intArray == null || intArray.length == 0) {
            return false;
        }
        String strFindInvalidDestinationDisplayNameInDeepLink = findInvalidDestinationDisplayNameInDeepLink(intArray);
        if (strFindInvalidDestinationDisplayNameInDeepLink != null) {
            Log.i(TAG, "Could not find destination " + strFindInvalidDestinationDisplayNameInDeepLink + " in the navigation graph, ignoring the deep link from " + intent);
            return false;
        }
        bundle2.putParcelable(KEY_DEEP_LINK_INTENT, intent);
        int length = intArray.length;
        Bundle[] bundleArr = new Bundle[length];
        for (int i11 = 0; i11 < length; i11++) {
            Bundle bundle4 = new Bundle();
            bundle4.putAll(bundle2);
            if (parcelableArrayList != null && (bundle = (Bundle) parcelableArrayList.get(i11)) != null) {
                bundle4.putAll(bundle);
            }
            bundleArr[i11] = bundle4;
        }
        int flags = intent.getFlags();
        int i12 = 268435456 & flags;
        if (i12 != 0 && (flags & 32768) == 0) {
            intent.addFlags(32768);
            TaskStackBuilder taskStackBuilderAddNextIntentWithParentStack = TaskStackBuilder.create(this.context).addNextIntentWithParentStack(intent);
            m.e(taskStackBuilderAddNextIntentWithParentStack, "create(context)\n        …ntWithParentStack(intent)");
            taskStackBuilderAddNextIntentWithParentStack.startActivities();
            Activity activity = this.activity;
            if (activity != null) {
                activity.finish();
                activity.overridePendingTransition(0, 0);
            }
            return true;
        }
        if (i12 != 0) {
            if (!this.backQueue.isEmpty()) {
                NavGraph navGraph3 = this._graph;
                m.c(navGraph3);
                popBackStackInternal$default(this, navGraph3.getId(), true, false, 4, null);
            }
            while (i10 < intArray.length) {
                int i13 = intArray[i10];
                int i14 = i10 + 1;
                Bundle bundle5 = bundleArr[i10];
                NavDestination navDestinationFindDestination = findDestination(i13);
                if (navDestinationFindDestination == null) {
                    throw new IllegalStateException("Deep Linking failed: destination " + NavDestination.INSTANCE.getDisplayName(this.context, i13) + " cannot be found from the current destination " + getCurrentDestination());
                }
                navigate(navDestinationFindDestination, bundle5, NavOptionsBuilderKt.navOptions(new C05302(navDestinationFindDestination, this)), (Navigator.Extras) null);
                i10 = i14;
            }
            return true;
        }
        NavGraph navGraph4 = this._graph;
        int length2 = intArray.length;
        for (int i15 = 0; i15 < length2; i15++) {
            int i16 = intArray[i15];
            Bundle bundle6 = bundleArr[i15];
            if (i15 == 0) {
                navDestinationFindNode = this._graph;
            } else {
                m.c(navGraph4);
                navDestinationFindNode = navGraph4.findNode(i16);
            }
            if (navDestinationFindNode == null) {
                throw new IllegalStateException("Deep Linking failed: destination " + NavDestination.INSTANCE.getDisplayName(this.context, i16) + " cannot be found in graph " + navGraph4);
            }
            if (i15 == intArray.length - 1) {
                NavOptions.Builder builder = new NavOptions.Builder();
                NavGraph navGraph5 = this._graph;
                m.c(navGraph5);
                navigate(navDestinationFindNode, bundle6, NavOptions.Builder.setPopUpTo$default(builder, navGraph5.getId(), true, false, 4, (Object) null).setEnterAnim(0).setExitAnim(0).build(), (Navigator.Extras) null);
            } else if (navDestinationFindNode instanceof NavGraph) {
                while (true) {
                    navGraph = (NavGraph) navDestinationFindNode;
                    m.c(navGraph);
                    if (!(navGraph.findNode(navGraph.getStartDestId()) instanceof NavGraph)) {
                        break;
                    }
                    navDestinationFindNode = navGraph.findNode(navGraph.getStartDestId());
                }
                navGraph4 = navGraph;
            }
        }
        this.deepLinkHandled = true;
        return true;
    }

    @MainThread
    public final void navigate(String route, NavOptions navOptions) {
        m.f(route, "route");
        navigate$default(this, route, navOptions, null, 4, null);
    }

    @MainThread
    public boolean popBackStack() {
        if (this.backQueue.isEmpty()) {
            return false;
        }
        NavDestination currentDestination = getCurrentDestination();
        m.c(currentDestination);
        return popBackStack(currentDestination.getId(), true);
    }

    public final void popBackStackFromNavigator$navigation_runtime_release(NavBackStackEntry popUpTo, c9.a<z> onComplete) {
        m.f(popUpTo, "popUpTo");
        m.f(onComplete, "onComplete");
        int iIndexOf = this.backQueue.indexOf(popUpTo);
        if (iIndexOf < 0) {
            Log.i(TAG, "Ignoring pop of " + popUpTo + " as it was not found on the current back stack");
            return;
        }
        int i10 = iIndexOf + 1;
        if (i10 != this.backQueue.size()) {
            popBackStackInternal(this.backQueue.get(i10).getDestination().getId(), true, false);
        }
        popEntryFromBackStack$default(this, popUpTo, false, null, 6, null);
        onComplete.invoke();
        updateOnBackPressedCallbackEnabled();
        dispatchOnDestinationChanged();
    }

    public final List<NavBackStackEntry> populateVisibleEntries$navigation_runtime_release() {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = this.navigatorState.values().iterator();
        while (it.hasNext()) {
            Set<NavBackStackEntry> value = ((NavControllerNavigatorState) it.next()).getTransitionsInProgress().getValue();
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : value) {
                NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj;
                if (!arrayList.contains(navBackStackEntry) && !navBackStackEntry.getMaxLifecycle().isAtLeast(Lifecycle.State.STARTED)) {
                    arrayList2.add(obj);
                }
            }
            r.C(arrayList, arrayList2);
        }
        i<NavBackStackEntry> iVar = this.backQueue;
        ArrayList arrayList3 = new ArrayList();
        for (NavBackStackEntry navBackStackEntry2 : iVar) {
            NavBackStackEntry navBackStackEntry3 = navBackStackEntry2;
            if (!arrayList.contains(navBackStackEntry3) && navBackStackEntry3.getMaxLifecycle().isAtLeast(Lifecycle.State.STARTED)) {
                arrayList3.add(navBackStackEntry2);
            }
        }
        r.C(arrayList, arrayList3);
        ArrayList arrayList4 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (!(((NavBackStackEntry) obj2).getDestination() instanceof NavGraph)) {
                arrayList4.add(obj2);
            }
        }
        return arrayList4;
    }

    public void removeOnDestinationChangedListener(OnDestinationChangedListener listener) {
        m.f(listener, "listener");
        this.onDestinationChangedListeners.remove(listener);
    }

    @CallSuper
    public void restoreState(Bundle navState) {
        if (navState == null) {
            return;
        }
        navState.setClassLoader(this.context.getClassLoader());
        this.navigatorStateToRestore = navState.getBundle(KEY_NAVIGATOR_STATE);
        this.backStackToRestore = navState.getParcelableArray(KEY_BACK_STACK);
        this.backStackStates.clear();
        int[] intArray = navState.getIntArray(KEY_BACK_STACK_DEST_IDS);
        ArrayList<String> stringArrayList = navState.getStringArrayList(KEY_BACK_STACK_IDS);
        if (intArray != null && stringArrayList != null) {
            int length = intArray.length;
            int i10 = 0;
            int i11 = 0;
            while (i10 < length) {
                this.backStackMap.put(Integer.valueOf(intArray[i10]), stringArrayList.get(i11));
                i10++;
                i11++;
            }
        }
        ArrayList<String> stringArrayList2 = navState.getStringArrayList(KEY_BACK_STACK_STATES_IDS);
        if (stringArrayList2 != null) {
            for (String id2 : stringArrayList2) {
                Parcelable[] parcelableArray = navState.getParcelableArray(KEY_BACK_STACK_STATES_PREFIX + id2);
                if (parcelableArray != null) {
                    Map<String, i<NavBackStackEntryState>> map = this.backStackStates;
                    m.e(id2, "id");
                    i<NavBackStackEntryState> iVar = new i<>(parcelableArray.length);
                    Iterator itA = kotlin.jvm.internal.b.a(parcelableArray);
                    while (itA.hasNext()) {
                        Parcelable parcelable = (Parcelable) itA.next();
                        m.d(parcelable, "null cannot be cast to non-null type androidx.navigation.NavBackStackEntryState");
                        iVar.add((NavBackStackEntryState) parcelable);
                    }
                    map.put(id2, iVar);
                }
            }
        }
        this.deepLinkHandled = navState.getBoolean(KEY_DEEP_LINK_HANDLED);
    }

    @CallSuper
    public Bundle saveState() {
        Bundle bundle;
        ArrayList<String> arrayList = new ArrayList<>();
        Bundle bundle2 = new Bundle();
        for (Map.Entry<String, Navigator<? extends NavDestination>> entry : this._navigatorProvider.getNavigators().entrySet()) {
            String key = entry.getKey();
            Bundle bundleOnSaveState = entry.getValue().onSaveState();
            if (bundleOnSaveState != null) {
                arrayList.add(key);
                bundle2.putBundle(key, bundleOnSaveState);
            }
        }
        if (arrayList.isEmpty()) {
            bundle = null;
        } else {
            bundle = new Bundle();
            bundle2.putStringArrayList(KEY_NAVIGATOR_STATE_NAMES, arrayList);
            bundle.putBundle(KEY_NAVIGATOR_STATE, bundle2);
        }
        if (!this.backQueue.isEmpty()) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            Parcelable[] parcelableArr = new Parcelable[this.backQueue.size()];
            Iterator<NavBackStackEntry> it = this.backQueue.iterator();
            int i10 = 0;
            while (it.hasNext()) {
                parcelableArr[i10] = new NavBackStackEntryState(it.next());
                i10++;
            }
            bundle.putParcelableArray(KEY_BACK_STACK, parcelableArr);
        }
        if (!this.backStackMap.isEmpty()) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            int[] iArr = new int[this.backStackMap.size()];
            ArrayList<String> arrayList2 = new ArrayList<>();
            int i11 = 0;
            for (Map.Entry<Integer, String> entry2 : this.backStackMap.entrySet()) {
                int iIntValue = entry2.getKey().intValue();
                String value = entry2.getValue();
                iArr[i11] = iIntValue;
                arrayList2.add(value);
                i11++;
            }
            bundle.putIntArray(KEY_BACK_STACK_DEST_IDS, iArr);
            bundle.putStringArrayList(KEY_BACK_STACK_IDS, arrayList2);
        }
        if (!this.backStackStates.isEmpty()) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            ArrayList<String> arrayList3 = new ArrayList<>();
            for (Map.Entry<String, i<NavBackStackEntryState>> entry3 : this.backStackStates.entrySet()) {
                String key2 = entry3.getKey();
                i<NavBackStackEntryState> value2 = entry3.getValue();
                arrayList3.add(key2);
                Parcelable[] parcelableArr2 = new Parcelable[value2.size()];
                int i12 = 0;
                for (NavBackStackEntryState navBackStackEntryState : value2) {
                    int i13 = i12 + 1;
                    if (i12 < 0) {
                        r.v();
                    }
                    parcelableArr2[i12] = navBackStackEntryState;
                    i12 = i13;
                }
                bundle.putParcelableArray(KEY_BACK_STACK_STATES_PREFIX + key2, parcelableArr2);
            }
            bundle.putStringArrayList(KEY_BACK_STACK_STATES_IDS, arrayList3);
        }
        if (this.deepLinkHandled) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean(KEY_DEEP_LINK_HANDLED, this.deepLinkHandled);
        }
        return bundle;
    }

    @CallSuper
    @MainThread
    public void setGraph(@NavigationRes int graphResId) {
        setGraph(getNavInflater().inflate(graphResId), (Bundle) null);
    }

    public final void setHostLifecycleState$navigation_runtime_release(Lifecycle.State state) {
        m.f(state, "<set-?>");
        this.hostLifecycleState = state;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setLifecycleOwner(LifecycleOwner owner) {
        Lifecycle lifecycle;
        m.f(owner, "owner");
        if (m.a(owner, this.lifecycleOwner)) {
            return;
        }
        LifecycleOwner lifecycleOwner = this.lifecycleOwner;
        if (lifecycleOwner != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
            lifecycle.removeObserver(this.lifecycleObserver);
        }
        this.lifecycleOwner = owner;
        owner.getLifecycle().addObserver(this.lifecycleObserver);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setNavigatorProvider(NavigatorProvider navigatorProvider) {
        m.f(navigatorProvider, "navigatorProvider");
        if (!this.backQueue.isEmpty()) {
            throw new IllegalStateException("NavigatorProvider must be set before setGraph call");
        }
        this._navigatorProvider = navigatorProvider;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setOnBackPressedDispatcher(OnBackPressedDispatcher dispatcher) {
        m.f(dispatcher, "dispatcher");
        if (m.a(dispatcher, this.onBackPressedDispatcher)) {
            return;
        }
        LifecycleOwner lifecycleOwner = this.lifecycleOwner;
        if (lifecycleOwner == null) {
            throw new IllegalStateException("You must call setLifecycleOwner() before calling setOnBackPressedDispatcher()");
        }
        this.onBackPressedCallback.remove();
        this.onBackPressedDispatcher = dispatcher;
        dispatcher.addCallback(lifecycleOwner, this.onBackPressedCallback);
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        lifecycle.removeObserver(this.lifecycleObserver);
        lifecycle.addObserver(this.lifecycleObserver);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setViewModelStore(ViewModelStore viewModelStore) {
        m.f(viewModelStore, "viewModelStore");
        NavControllerViewModel navControllerViewModel = this.viewModel;
        NavControllerViewModel.Companion companion = NavControllerViewModel.INSTANCE;
        if (m.a(navControllerViewModel, companion.getInstance(viewModelStore))) {
            return;
        }
        if (!this.backQueue.isEmpty()) {
            throw new IllegalStateException("ViewModelStore should be set before setGraph call");
        }
        this.viewModel = companion.getInstance(viewModelStore);
    }

    public final NavBackStackEntry unlinkChildFromParent$navigation_runtime_release(NavBackStackEntry child) {
        m.f(child, "child");
        NavBackStackEntry navBackStackEntryRemove = this.childToParentEntries.remove(child);
        if (navBackStackEntryRemove == null) {
            return null;
        }
        AtomicInteger atomicInteger = this.parentToChildCount.get(navBackStackEntryRemove);
        Integer numValueOf = atomicInteger != null ? Integer.valueOf(atomicInteger.decrementAndGet()) : null;
        if (numValueOf != null && numValueOf.intValue() == 0) {
            NavControllerNavigatorState navControllerNavigatorState = this.navigatorState.get(this._navigatorProvider.getNavigator(navBackStackEntryRemove.getDestination().getNavigatorName()));
            if (navControllerNavigatorState != null) {
                navControllerNavigatorState.markTransitionComplete(navBackStackEntryRemove);
            }
            this.parentToChildCount.remove(navBackStackEntryRemove);
        }
        return navBackStackEntryRemove;
    }

    public final void updateBackStackLifecycle$navigation_runtime_release() {
        NavDestination parent;
        AtomicInteger atomicInteger;
        d0<Set<NavBackStackEntry>> transitionsInProgress;
        Set<NavBackStackEntry> value;
        List<NavBackStackEntry> listQ0 = r.Q0(this.backQueue);
        if (listQ0.isEmpty()) {
            return;
        }
        NavDestination destination = ((NavBackStackEntry) r.s0(listQ0)).getDestination();
        if (!(destination instanceof FloatingWindow)) {
            parent = null;
            break;
        }
        Iterator it = r.D0(listQ0).iterator();
        while (true) {
            if (!it.hasNext()) {
                parent = null;
                break;
            }
            parent = ((NavBackStackEntry) it.next()).getDestination();
            if (!(parent instanceof NavGraph) && !(parent instanceof FloatingWindow)) {
                break;
            }
        }
        HashMap map = new HashMap();
        for (NavBackStackEntry navBackStackEntry : r.D0(listQ0)) {
            Lifecycle.State maxLifecycle = navBackStackEntry.getMaxLifecycle();
            NavDestination destination2 = navBackStackEntry.getDestination();
            if (destination != null && destination2.getId() == destination.getId()) {
                Lifecycle.State state = Lifecycle.State.RESUMED;
                if (maxLifecycle != state) {
                    NavControllerNavigatorState navControllerNavigatorState = this.navigatorState.get(get_navigatorProvider().getNavigator(navBackStackEntry.getDestination().getNavigatorName()));
                    if (m.a((navControllerNavigatorState == null || (transitionsInProgress = navControllerNavigatorState.getTransitionsInProgress()) == null || (value = transitionsInProgress.getValue()) == null) ? null : Boolean.valueOf(value.contains(navBackStackEntry)), Boolean.TRUE) || ((atomicInteger = this.parentToChildCount.get(navBackStackEntry)) != null && atomicInteger.get() == 0)) {
                        map.put(navBackStackEntry, Lifecycle.State.STARTED);
                    } else {
                        map.put(navBackStackEntry, state);
                    }
                }
                destination = destination.getParent();
            } else if (parent == null || destination2.getId() != parent.getId()) {
                navBackStackEntry.setMaxLifecycle(Lifecycle.State.CREATED);
            } else {
                if (maxLifecycle == Lifecycle.State.RESUMED) {
                    navBackStackEntry.setMaxLifecycle(Lifecycle.State.STARTED);
                } else {
                    Lifecycle.State state2 = Lifecycle.State.STARTED;
                    if (maxLifecycle != state2) {
                        map.put(navBackStackEntry, state2);
                    }
                }
                parent = parent.getParent();
            }
        }
        for (NavBackStackEntry navBackStackEntry2 : listQ0) {
            Lifecycle.State state3 = (Lifecycle.State) map.get(navBackStackEntry2);
            if (state3 != null) {
                navBackStackEntry2.setMaxLifecycle(state3);
            } else {
                navBackStackEntry2.updateState();
            }
        }
    }

    private final boolean launchSingleTopInternal(NavDestination node, Bundle args) {
        int id2;
        NavDestination destination;
        int iNextIndex;
        NavBackStackEntry currentBackStackEntry = getCurrentBackStackEntry();
        if (node instanceof NavGraph) {
            id2 = NavGraph.INSTANCE.findStartDestination((NavGraph) node).getId();
        } else {
            id2 = node.getId();
        }
        if (currentBackStackEntry != null && (destination = currentBackStackEntry.getDestination()) != null && id2 == destination.getId()) {
            i<NavBackStackEntry> iVar = new i();
            i<NavBackStackEntry> iVar2 = this.backQueue;
            ListIterator<NavBackStackEntry> listIterator = iVar2.listIterator(iVar2.size());
            while (true) {
                if (listIterator.hasPrevious()) {
                    if (listIterator.previous().getDestination() == node) {
                        iNextIndex = listIterator.nextIndex();
                        break;
                    }
                } else {
                    iNextIndex = -1;
                    break;
                }
            }
            while (r.n(this.backQueue) >= iNextIndex) {
                NavBackStackEntry navBackStackEntryRemoveLast = this.backQueue.removeLast();
                unlinkChildFromParent$navigation_runtime_release(navBackStackEntryRemoveLast);
                iVar.addFirst(new NavBackStackEntry(navBackStackEntryRemoveLast, navBackStackEntryRemoveLast.getDestination().addInDefaultArgs(args)));
            }
            for (NavBackStackEntry navBackStackEntry : iVar) {
                NavGraph parent = navBackStackEntry.getDestination().getParent();
                if (parent != null) {
                    linkChildToParent(navBackStackEntry, getBackStackEntry(parent.getId()));
                }
                this.backQueue.add(navBackStackEntry);
            }
            for (NavBackStackEntry navBackStackEntry2 : iVar) {
                this._navigatorProvider.getNavigator(navBackStackEntry2.getDestination().getNavigatorName()).onLaunchSingleTop(navBackStackEntry2);
            }
            return true;
        }
        return false;
    }

    static /* synthetic */ boolean popBackStackInternal$default(NavController navController, int i10, boolean z10, boolean z11, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: popBackStackInternal");
        }
        if ((i11 & 4) != 0) {
            z11 = false;
        }
        return navController.popBackStackInternal(i10, z10, z11);
    }

    private final boolean tryRelaunchUpToGeneratedStack() {
        Bundle matchingArgs;
        NavDestination currentDestination = getCurrentDestination();
        m.c(currentDestination);
        int id2 = currentDestination.getId();
        for (NavGraph parent = currentDestination.getParent(); parent != null; parent = parent.getParent()) {
            if (parent.getStartDestId() != id2) {
                Bundle bundle = new Bundle();
                Activity activity = this.activity;
                if (activity != null) {
                    m.c(activity);
                    if (activity.getIntent() != null) {
                        Activity activity2 = this.activity;
                        m.c(activity2);
                        if (activity2.getIntent().getData() != null) {
                            Activity activity3 = this.activity;
                            m.c(activity3);
                            bundle.putParcelable(KEY_DEEP_LINK_INTENT, activity3.getIntent());
                            NavGraph navGraph = this._graph;
                            m.c(navGraph);
                            Activity activity4 = this.activity;
                            m.c(activity4);
                            Intent intent = activity4.getIntent();
                            m.e(intent, "activity!!.intent");
                            NavDestination.DeepLinkMatch deepLinkMatchMatchDeepLink = navGraph.matchDeepLink(new NavDeepLinkRequest(intent));
                            if (deepLinkMatchMatchDeepLink != null) {
                                matchingArgs = deepLinkMatchMatchDeepLink.getMatchingArgs();
                            } else {
                                matchingArgs = null;
                            }
                            if (matchingArgs != null) {
                                bundle.putAll(deepLinkMatchMatchDeepLink.getDestination().addInDefaultArgs(deepLinkMatchMatchDeepLink.getMatchingArgs()));
                            }
                        }
                    }
                }
                NavDeepLinkBuilder.setDestination$default(new NavDeepLinkBuilder(this), parent.getId(), (Bundle) null, 2, (Object) null).setArguments(bundle).createTaskStackBuilder().startActivities();
                Activity activity5 = this.activity;
                if (activity5 != null) {
                    activity5.finish();
                    return true;
                }
                return true;
            }
            id2 = parent.getId();
        }
        return false;
    }

    @MainThread
    public final boolean clearBackStack(@IdRes int destinationId) {
        return clearBackStackInternal(destinationId) && dispatchOnDestinationChanged();
    }

    public NavDestination getCurrentDestination() {
        NavBackStackEntry currentBackStackEntry = getCurrentBackStackEntry();
        if (currentBackStackEntry != null) {
            return currentBackStackEntry.getDestination();
        }
        return null;
    }

    @MainThread
    public void navigate(@IdRes int resId) {
        navigate(resId, (Bundle) null);
    }

    @MainThread
    public boolean navigateUp() {
        Bundle extras;
        Intent intent;
        if (getDestinationCountOnBackStack() == 1) {
            Activity activity = this.activity;
            int[] intArray = null;
            if (activity != null && (intent = activity.getIntent()) != null) {
                extras = intent.getExtras();
            } else {
                extras = null;
            }
            if (extras != null) {
                intArray = extras.getIntArray(KEY_DEEP_LINK_IDS);
            }
            if (intArray != null) {
                return tryRelaunchUpToExplicitStack();
            }
            return tryRelaunchUpToGeneratedStack();
        }
        return popBackStack();
    }

    @CallSuper
    @MainThread
    public void setGraph(@NavigationRes int graphResId, Bundle startDestinationArgs) {
        setGraph(getNavInflater().inflate(graphResId), startDestinationArgs);
    }

    @MainThread
    private final boolean popBackStackInternal(@IdRes int destinationId, boolean inclusive, boolean saveState) {
        NavDestination destination;
        if (this.backQueue.isEmpty()) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = r.D0(this.backQueue).iterator();
        do {
            if (!it.hasNext()) {
                destination = null;
                break;
            }
            destination = ((NavBackStackEntry) it.next()).getDestination();
            Navigator navigator = this._navigatorProvider.getNavigator(destination.getNavigatorName());
            if (inclusive || destination.getId() != destinationId) {
                arrayList.add(navigator);
            }
        } while (destination.getId() != destinationId);
        if (destination == null) {
            Log.i(TAG, "Ignoring popBackStack to destination " + NavDestination.INSTANCE.getDisplayName(this.context, destinationId) + " as it was not found on the current back stack");
            return false;
        }
        return executePopOperations(arrayList, destination, inclusive, saveState);
    }

    @MainThread
    public void navigate(@IdRes int resId, Bundle args) {
        navigate(resId, args, (NavOptions) null);
    }

    @MainThread
    public boolean popBackStack(@IdRes int destinationId, boolean inclusive) {
        return popBackStack(destinationId, inclusive, false);
    }

    @CallSuper
    @MainThread
    public void setGraph(NavGraph graph, Bundle startDestinationArgs) {
        NavController navController;
        m.f(graph, "graph");
        if (!m.a(this._graph, graph)) {
            NavGraph navGraph = this._graph;
            if (navGraph != null) {
                for (Integer id2 : new ArrayList(this.backStackMap.keySet())) {
                    m.e(id2, "id");
                    clearBackStackInternal(id2.intValue());
                }
                navController = this;
                popBackStackInternal$default(navController, navGraph.getId(), true, false, 4, null);
            } else {
                navController = this;
            }
            navController._graph = graph;
            onGraphCreated(startDestinationArgs);
            return;
        }
        int size = graph.getNodes().size();
        for (int i10 = 0; i10 < size; i10++) {
            NavDestination navDestinationValueAt = graph.getNodes().valueAt(i10);
            NavGraph navGraph2 = this._graph;
            m.c(navGraph2);
            int iKeyAt = navGraph2.getNodes().keyAt(i10);
            NavGraph navGraph3 = this._graph;
            m.c(navGraph3);
            navGraph3.getNodes().replace(iKeyAt, navDestinationValueAt);
        }
        for (NavBackStackEntry navBackStackEntry : this.backQueue) {
            List<NavDestination> listQ = r.Q(ta.k.P(NavDestination.INSTANCE.getHierarchy(navBackStackEntry.getDestination())));
            NavDestination navDestinationFindNode = this._graph;
            m.c(navDestinationFindNode);
            for (NavDestination navDestination : listQ) {
                if (!m.a(navDestination, this._graph) || !m.a(navDestinationFindNode, graph)) {
                    if (navDestinationFindNode instanceof NavGraph) {
                        navDestinationFindNode = ((NavGraph) navDestinationFindNode).findNode(navDestination.getId());
                        m.c(navDestinationFindNode);
                    }
                }
            }
            navBackStackEntry.setDestination(navDestinationFindNode);
        }
    }

    @MainThread
    public void navigate(@IdRes int resId, Bundle args, NavOptions navOptions) {
        navigate(resId, args, navOptions, (Navigator.Extras) null);
    }

    @MainThread
    public boolean popBackStack(@IdRes int destinationId, boolean inclusive, boolean saveState) {
        return popBackStackInternal(destinationId, inclusive, saveState) && dispatchOnDestinationChanged();
    }

    private final NavDestination findDestination(NavDestination navDestination, @IdRes int i10) {
        NavGraph parent;
        if (navDestination.getId() == i10) {
            return navDestination;
        }
        if (navDestination instanceof NavGraph) {
            parent = (NavGraph) navDestination;
        } else {
            parent = navDestination.getParent();
            m.c(parent);
        }
        return parent.findNode(i10);
    }

    @MainThread
    public void navigate(@IdRes int resId, Bundle args, NavOptions navOptions, Navigator.Extras navigatorExtras) {
        NavDestination destination;
        int destinationId;
        if (this.backQueue.isEmpty()) {
            destination = this._graph;
        } else {
            destination = this.backQueue.last().getDestination();
        }
        if (destination != null) {
            NavAction action = destination.getAction(resId);
            Bundle bundle = null;
            if (action != null) {
                if (navOptions == null) {
                    navOptions = action.getNavOptions();
                }
                destinationId = action.getDestinationId();
                Bundle defaultArguments = action.getDefaultArguments();
                if (defaultArguments != null) {
                    bundle = new Bundle();
                    bundle.putAll(defaultArguments);
                }
            } else {
                destinationId = resId;
            }
            if (args != null) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                bundle.putAll(args);
            }
            if (destinationId == 0 && navOptions != null && navOptions.getPopUpToId() != -1) {
                popBackStack(navOptions.getPopUpToId(), navOptions.getPopUpToInclusive());
                return;
            }
            if (destinationId != 0) {
                NavDestination navDestinationFindDestination = findDestination(destinationId);
                if (navDestinationFindDestination == null) {
                    NavDestination.Companion companion = NavDestination.INSTANCE;
                    String displayName = companion.getDisplayName(this.context, destinationId);
                    if (action == null) {
                        throw new IllegalArgumentException("Navigation action/destination " + displayName + " cannot be found from the current destination " + destination);
                    }
                    throw new IllegalArgumentException(("Navigation destination " + displayName + " referenced from action " + companion.getDisplayName(this.context, resId) + " cannot be found from the current destination " + destination).toString());
                }
                navigate(navDestinationFindDestination, bundle, navOptions, navigatorExtras);
                return;
            }
            throw new IllegalArgumentException("Destination id == 0 can only be used in conjunction with a valid navOptions.popUpTo");
        }
        throw new IllegalStateException("no current navigation node");
    }

    private final boolean restoreStateInternal(String route) {
        NavBackStackEntryState navBackStackEntryStateN;
        int iHashCode = NavDestination.INSTANCE.createRoute(route).hashCode();
        if (this.backStackMap.containsKey(Integer.valueOf(iHashCode))) {
            return restoreStateInternal(iHashCode, null, null, null);
        }
        NavDestination navDestinationFindDestination = findDestination(route);
        if (navDestinationFindDestination != null) {
            String str = this.backStackMap.get(Integer.valueOf(navDestinationFindDestination.getId()));
            r.H(this.backStackMap.values(), new C05343(str));
            i<NavBackStackEntryState> iVar = (i) h0.d(this.backStackStates).remove(str);
            NavDestination.DeepLinkMatch deepLinkMatchMatchDeepLink = navDestinationFindDestination.matchDeepLink(route);
            m.c(deepLinkMatchMatchDeepLink);
            if (deepLinkMatchMatchDeepLink.hasMatchingArgs((iVar == null || (navBackStackEntryStateN = iVar.n()) == null) ? null : navBackStackEntryStateN.getArgs())) {
                return executeRestoreState(instantiateBackStack(iVar), null, null, null);
            }
            return false;
        }
        throw new IllegalStateException(("Restore State failed: route " + route + " cannot be found from the current destination " + getCurrentDestination()).toString());
    }

    @MainThread
    public final boolean popBackStack(String route, boolean inclusive, boolean saveState) {
        m.f(route, "route");
        return popBackStackInternal(route, inclusive, saveState) && dispatchOnDestinationChanged();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final NavDestination findDestination(String route) {
        NavGraph destination;
        NavGraph parent;
        m.f(route, "route");
        NavGraph navGraph = this._graph;
        if (navGraph == null) {
            return null;
        }
        m.c(navGraph);
        if (!m.a(navGraph.getRoute(), route)) {
            NavGraph navGraph2 = this._graph;
            m.c(navGraph2);
            if (navGraph2.matchDeepLink(route) == null) {
                NavBackStackEntry navBackStackEntryQ = this.backQueue.q();
                if (navBackStackEntryQ == null || (destination = navBackStackEntryQ.getDestination()) == null) {
                    destination = this._graph;
                    m.c(destination);
                }
                if (destination instanceof NavGraph) {
                    parent = destination;
                } else {
                    parent = destination.getParent();
                    m.c(parent);
                }
                return parent.findNode(route);
            }
        }
        return this._graph;
    }

    @MainThread
    private final boolean clearBackStackInternal(String route) {
        Iterator<T> it = this.navigatorState.values().iterator();
        while (it.hasNext()) {
            ((NavControllerNavigatorState) it.next()).setNavigating(true);
        }
        boolean zRestoreStateInternal = restoreStateInternal(route);
        Iterator<T> it2 = this.navigatorState.values().iterator();
        while (it2.hasNext()) {
            ((NavControllerNavigatorState) it2.next()).setNavigating(false);
        }
        return zRestoreStateInternal && popBackStackInternal(route, true, false);
    }

    public final NavBackStackEntry getBackStackEntry(String route) {
        NavBackStackEntry navBackStackEntryPrevious;
        NavBackStackEntry navBackStackEntry;
        m.f(route, "route");
        i<NavBackStackEntry> iVar = this.backQueue;
        ListIterator<NavBackStackEntry> listIterator = iVar.listIterator(iVar.size());
        do {
            if (!listIterator.hasPrevious()) {
                navBackStackEntryPrevious = null;
                break;
            }
            navBackStackEntryPrevious = listIterator.previous();
            navBackStackEntry = navBackStackEntryPrevious;
        } while (!navBackStackEntry.getDestination().hasRoute(route, navBackStackEntry.getArguments()));
        NavBackStackEntry navBackStackEntry2 = navBackStackEntryPrevious;
        if (navBackStackEntry2 != null) {
            return navBackStackEntry2;
        }
        throw new IllegalArgumentException(("No destination with route " + route + " is on the NavController's back stack. The current destination is " + getCurrentDestination()).toString());
    }

    private final boolean popBackStackInternal(String route, boolean inclusive, boolean saveState) {
        NavBackStackEntry navBackStackEntryPrevious;
        boolean zHasRoute;
        if (this.backQueue.isEmpty()) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        i<NavBackStackEntry> iVar = this.backQueue;
        ListIterator<NavBackStackEntry> listIterator = iVar.listIterator(iVar.size());
        do {
            if (!listIterator.hasPrevious()) {
                navBackStackEntryPrevious = null;
                break;
            }
            navBackStackEntryPrevious = listIterator.previous();
            NavBackStackEntry navBackStackEntry = navBackStackEntryPrevious;
            zHasRoute = navBackStackEntry.getDestination().hasRoute(route, navBackStackEntry.getArguments());
            if (inclusive || !zHasRoute) {
                arrayList.add(this._navigatorProvider.getNavigator(navBackStackEntry.getDestination().getNavigatorName()));
            }
        } while (!zHasRoute);
        NavBackStackEntry navBackStackEntry2 = navBackStackEntryPrevious;
        NavDestination destination = navBackStackEntry2 != null ? navBackStackEntry2.getDestination() : null;
        if (destination == null) {
            Log.i(TAG, "Ignoring popBackStack to route " + route + " as it was not found on the current back stack");
            return false;
        }
        return executePopOperations(arrayList, destination, inclusive, saveState);
    }

    @MainThread
    public void navigate(Uri deepLink) {
        m.f(deepLink, "deepLink");
        navigate(new NavDeepLinkRequest(deepLink, null, null));
    }

    @MainThread
    public void navigate(Uri deepLink, NavOptions navOptions) {
        m.f(deepLink, "deepLink");
        navigate(new NavDeepLinkRequest(deepLink, null, null), navOptions, (Navigator.Extras) null);
    }

    @MainThread
    public void navigate(Uri deepLink, NavOptions navOptions, Navigator.Extras navigatorExtras) {
        m.f(deepLink, "deepLink");
        navigate(new NavDeepLinkRequest(deepLink, null, null), navOptions, navigatorExtras);
    }

    @MainThread
    public void navigate(NavDeepLinkRequest request) {
        m.f(request, "request");
        navigate(request, (NavOptions) null);
    }

    @MainThread
    public void navigate(NavDeepLinkRequest request, NavOptions navOptions) {
        m.f(request, "request");
        navigate(request, navOptions, (Navigator.Extras) null);
    }

    @MainThread
    public void navigate(NavDeepLinkRequest request, NavOptions navOptions, Navigator.Extras navigatorExtras) {
        m.f(request, "request");
        NavGraph navGraph = this._graph;
        m.c(navGraph);
        NavDestination.DeepLinkMatch deepLinkMatchMatchDeepLink = navGraph.matchDeepLink(request);
        if (deepLinkMatchMatchDeepLink != null) {
            Bundle bundleAddInDefaultArgs = deepLinkMatchMatchDeepLink.getDestination().addInDefaultArgs(deepLinkMatchMatchDeepLink.getMatchingArgs());
            if (bundleAddInDefaultArgs == null) {
                bundleAddInDefaultArgs = new Bundle();
            }
            NavDestination destination = deepLinkMatchMatchDeepLink.getDestination();
            Intent intent = new Intent();
            intent.setDataAndType(request.getUri(), request.getMimeType());
            intent.setAction(request.getAction());
            bundleAddInDefaultArgs.putParcelable(KEY_DEEP_LINK_INTENT, intent);
            navigate(destination, bundleAddInDefaultArgs, navOptions, navigatorExtras);
            return;
        }
        throw new IllegalArgumentException("Navigation destination that matches request " + request + " cannot be found in the navigation graph " + this._graph);
    }

    @MainThread
    private final void navigate(NavDestination node, Bundle args, NavOptions navOptions, Navigator.Extras navigatorExtras) {
        boolean z10;
        Iterator<T> it = this.navigatorState.values().iterator();
        while (it.hasNext()) {
            ((NavControllerNavigatorState) it.next()).setNavigating(true);
        }
        y yVar = new y();
        boolean zPopBackStackInternal = (navOptions == null || navOptions.getPopUpToId() == -1) ? false : popBackStackInternal(navOptions.getPopUpToId(), navOptions.getPopUpToInclusive(), navOptions.getPopUpToSaveState());
        Bundle bundleAddInDefaultArgs = node.addInDefaultArgs(args);
        if (navOptions != null && navOptions.getRestoreState() && this.backStackMap.containsKey(Integer.valueOf(node.getId()))) {
            yVar.element = restoreStateInternal(node.getId(), bundleAddInDefaultArgs, navOptions, navigatorExtras);
            z10 = false;
        } else {
            z10 = navOptions != null && navOptions.getSingleTop() && launchSingleTopInternal(node, args);
            if (!z10) {
                navigateInternal(this._navigatorProvider.getNavigator(node.getNavigatorName()), r.e(NavBackStackEntry.Companion.create$default(NavBackStackEntry.INSTANCE, this.context, node, bundleAddInDefaultArgs, getHostLifecycleState$navigation_runtime_release(), this.viewModel, null, null, 96, null)), navOptions, navigatorExtras, new AnonymousClass4(yVar, this, node, bundleAddInDefaultArgs));
            }
        }
        updateOnBackPressedCallbackEnabled();
        Iterator<T> it2 = this.navigatorState.values().iterator();
        while (it2.hasNext()) {
            ((NavControllerNavigatorState) it2.next()).setNavigating(false);
        }
        if (!zPopBackStackInternal && !yVar.element && !z10) {
            updateBackStackLifecycle$navigation_runtime_release();
        } else {
            dispatchOnDestinationChanged();
        }
    }

    @MainThread
    public void navigate(NavDirections directions) {
        m.f(directions, "directions");
        navigate(directions.getActionId(), directions.getArguments(), (NavOptions) null);
    }

    @MainThread
    public void navigate(NavDirections directions, NavOptions navOptions) {
        m.f(directions, "directions");
        navigate(directions.getActionId(), directions.getArguments(), navOptions);
    }

    @MainThread
    public void navigate(NavDirections directions, Navigator.Extras navigatorExtras) {
        m.f(directions, "directions");
        m.f(navigatorExtras, "navigatorExtras");
        navigate(directions.getActionId(), directions.getArguments(), (NavOptions) null, navigatorExtras);
    }

    @MainThread
    public final void navigate(String route, l<? super NavOptionsBuilder, z> builder) {
        m.f(route, "route");
        m.f(builder, "builder");
        navigate$default(this, route, NavOptionsBuilderKt.navOptions(builder), null, 4, null);
    }

    @MainThread
    public final void navigate(String route, NavOptions navOptions, Navigator.Extras navigatorExtras) {
        m.f(route, "route");
        NavDeepLinkRequest.Builder.Companion companion = NavDeepLinkRequest.Builder.INSTANCE;
        Uri uri = Uri.parse(NavDestination.INSTANCE.createRoute(route));
        m.b(uri, "Uri.parse(this)");
        navigate(companion.fromUri(uri).build(), navOptions, navigatorExtras);
    }
}
