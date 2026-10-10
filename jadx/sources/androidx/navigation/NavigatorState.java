package androidx.navigation;

import android.os.Bundle;
import androidx.annotation.CallSuper;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.collections.r;
import kotlin.collections.v0;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.flow.d0;
import kotlinx.coroutines.flow.f0;
import kotlinx.coroutines.flow.h;
import kotlinx.coroutines.flow.v;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\bJ!\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0015\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0016\u0010\bJ\u0017\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0017\u0010\bJ\u0017\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0019\u0010\bJ\u0017\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u001a\u0010\bR\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR \u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u001f0\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R \u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\"0\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010!R\"\u0010$\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b$\u0010&\"\u0004\b'\u0010(R#\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u001f0)8\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R#\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\"0)8\u0006¢\u0006\f\n\u0004\b.\u0010+\u001a\u0004\b/\u0010-¨\u00060"}, d2 = {"Landroidx/navigation/NavigatorState;", "", "<init>", "()V", "Landroidx/navigation/NavBackStackEntry;", "backStackEntry", "Lr8/z;", "push", "(Landroidx/navigation/NavBackStackEntry;)V", "pushWithTransition", "Landroidx/navigation/NavDestination;", "destination", "Landroid/os/Bundle;", "arguments", "createBackStackEntry", "(Landroidx/navigation/NavDestination;Landroid/os/Bundle;)Landroidx/navigation/NavBackStackEntry;", "popUpTo", "", "saveState", "pop", "(Landroidx/navigation/NavBackStackEntry;Z)V", "popWithTransition", "onLaunchSingleTop", "onLaunchSingleTopWithTransition", "entry", "markTransitionComplete", "prepareForTransition", "Ljava/util/concurrent/locks/ReentrantLock;", "backStackLock", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/flow/v;", "", "_backStack", "Lkotlinx/coroutines/flow/v;", "", "_transitionsInProgress", "isNavigating", "Z", "()Z", "setNavigating", "(Z)V", "Lkotlinx/coroutines/flow/d0;", "backStack", "Lkotlinx/coroutines/flow/d0;", "getBackStack", "()Lkotlinx/coroutines/flow/d0;", "transitionsInProgress", "getTransitionsInProgress", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class NavigatorState {
    private final v<List<NavBackStackEntry>> _backStack;
    private final v<Set<NavBackStackEntry>> _transitionsInProgress;
    private final d0<List<NavBackStackEntry>> backStack;
    private final ReentrantLock backStackLock = new ReentrantLock(true);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    private boolean isNavigating;
    private final d0<Set<NavBackStackEntry>> transitionsInProgress;

    public abstract NavBackStackEntry createBackStackEntry(NavDestination destination, Bundle arguments);

    public final d0<List<NavBackStackEntry>> getBackStack() {
        return this.backStack;
    }

    public final d0<Set<NavBackStackEntry>> getTransitionsInProgress() {
        return this.transitionsInProgress;
    }

    /* JADX INFO: renamed from: isNavigating, reason: from getter */
    public final boolean getIsNavigating() {
        return this.isNavigating;
    }

    public void markTransitionComplete(NavBackStackEntry entry) {
        m.f(entry, "entry");
        v<Set<NavBackStackEntry>> vVar = this._transitionsInProgress;
        vVar.setValue(v0.j(vVar.getValue(), entry));
    }

    @CallSuper
    public void onLaunchSingleTop(NavBackStackEntry backStackEntry) {
        int iNextIndex;
        m.f(backStackEntry, "backStackEntry");
        ReentrantLock reentrantLock = this.backStackLock;
        reentrantLock.lock();
        try {
            List<NavBackStackEntry> listQ0 = r.Q0(this.backStack.getValue());
            ListIterator<NavBackStackEntry> listIterator = listQ0.listIterator(listQ0.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    iNextIndex = -1;
                    break;
                } else if (m.a(listIterator.previous().getId(), backStackEntry.getId())) {
                    iNextIndex = listIterator.nextIndex();
                    break;
                }
            }
            listQ0.set(iNextIndex, backStackEntry);
            this._backStack.setValue(listQ0);
            z zVar = z.f17874a;
        } finally {
            reentrantLock.unlock();
        }
    }

    @CallSuper
    public void onLaunchSingleTopWithTransition(NavBackStackEntry backStackEntry) {
        m.f(backStackEntry, "backStackEntry");
        List<NavBackStackEntry> value = this.backStack.getValue();
        ListIterator<NavBackStackEntry> listIterator = value.listIterator(value.size());
        while (listIterator.hasPrevious()) {
            NavBackStackEntry navBackStackEntryPrevious = listIterator.previous();
            if (m.a(navBackStackEntryPrevious.getId(), backStackEntry.getId())) {
                v<Set<NavBackStackEntry>> vVar = this._transitionsInProgress;
                vVar.setValue(v0.l(v0.l(vVar.getValue(), navBackStackEntryPrevious), backStackEntry));
                onLaunchSingleTop(backStackEntry);
                return;
            }
        }
        throw new NoSuchElementException("List contains no element matching the predicate.");
    }

    public void pop(NavBackStackEntry popUpTo, boolean saveState) {
        m.f(popUpTo, "popUpTo");
        ReentrantLock reentrantLock = this.backStackLock;
        reentrantLock.lock();
        try {
            v<List<NavBackStackEntry>> vVar = this._backStack;
            List<NavBackStackEntry> value = vVar.getValue();
            ArrayList arrayList = new ArrayList();
            for (Object obj : value) {
                if (m.a((NavBackStackEntry) obj, popUpTo)) {
                    break;
                } else {
                    arrayList.add(obj);
                }
            }
            vVar.setValue(arrayList);
            z zVar = z.f17874a;
        } finally {
            reentrantLock.unlock();
        }
    }

    public void popWithTransition(NavBackStackEntry popUpTo, boolean saveState) {
        NavBackStackEntry navBackStackEntryPrevious;
        m.f(popUpTo, "popUpTo");
        Set<NavBackStackEntry> value = this._transitionsInProgress.getValue();
        if (!(value instanceof Collection) || !value.isEmpty()) {
            Iterator<T> it = value.iterator();
            while (it.hasNext()) {
                if (((NavBackStackEntry) it.next()) == popUpTo) {
                    List<NavBackStackEntry> value2 = this.backStack.getValue();
                    if ((value2 instanceof Collection) && value2.isEmpty()) {
                        return;
                    }
                    Iterator<T> it2 = value2.iterator();
                    while (it2.hasNext()) {
                        if (((NavBackStackEntry) it2.next()) == popUpTo) {
                            break;
                        }
                    }
                    return;
                }
            }
        }
        v<Set<NavBackStackEntry>> vVar = this._transitionsInProgress;
        vVar.setValue(v0.l(vVar.getValue(), popUpTo));
        List<NavBackStackEntry> value3 = this.backStack.getValue();
        ListIterator<NavBackStackEntry> listIterator = value3.listIterator(value3.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                navBackStackEntryPrevious = null;
                break;
            }
            navBackStackEntryPrevious = listIterator.previous();
            NavBackStackEntry navBackStackEntry = navBackStackEntryPrevious;
            if (!m.a(navBackStackEntry, popUpTo) && this.backStack.getValue().lastIndexOf(navBackStackEntry) < this.backStack.getValue().lastIndexOf(popUpTo)) {
                break;
            }
        }
        NavBackStackEntry navBackStackEntry2 = navBackStackEntryPrevious;
        if (navBackStackEntry2 != null) {
            v<Set<NavBackStackEntry>> vVar2 = this._transitionsInProgress;
            vVar2.setValue(v0.l(vVar2.getValue(), navBackStackEntry2));
        }
        pop(popUpTo, saveState);
    }

    @CallSuper
    public void prepareForTransition(NavBackStackEntry entry) {
        m.f(entry, "entry");
        v<Set<NavBackStackEntry>> vVar = this._transitionsInProgress;
        vVar.setValue(v0.l(vVar.getValue(), entry));
    }

    public void push(NavBackStackEntry backStackEntry) {
        m.f(backStackEntry, "backStackEntry");
        ReentrantLock reentrantLock = this.backStackLock;
        reentrantLock.lock();
        try {
            v<List<NavBackStackEntry>> vVar = this._backStack;
            vVar.setValue(r.C0(vVar.getValue(), backStackEntry));
            z zVar = z.f17874a;
        } finally {
            reentrantLock.unlock();
        }
    }

    public void pushWithTransition(NavBackStackEntry backStackEntry) {
        m.f(backStackEntry, "backStackEntry");
        Set<NavBackStackEntry> value = this._transitionsInProgress.getValue();
        if (!(value instanceof Collection) || !value.isEmpty()) {
            Iterator<T> it = value.iterator();
            while (it.hasNext()) {
                if (((NavBackStackEntry) it.next()) == backStackEntry) {
                    List<NavBackStackEntry> value2 = this.backStack.getValue();
                    if (!(value2 instanceof Collection) || !value2.isEmpty()) {
                        Iterator<T> it2 = value2.iterator();
                        while (it2.hasNext()) {
                            if (((NavBackStackEntry) it2.next()) == backStackEntry) {
                                return;
                            }
                        }
                        break;
                    }
                    break;
                }
            }
        }
        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) r.u0(this.backStack.getValue());
        if (navBackStackEntry != null) {
            v<Set<NavBackStackEntry>> vVar = this._transitionsInProgress;
            vVar.setValue(v0.l(vVar.getValue(), navBackStackEntry));
        }
        v<Set<NavBackStackEntry>> vVar2 = this._transitionsInProgress;
        vVar2.setValue(v0.l(vVar2.getValue(), backStackEntry));
        push(backStackEntry);
    }

    public final void setNavigating(boolean z10) {
        this.isNavigating = z10;
    }

    public NavigatorState() {
        v<List<NavBackStackEntry>> vVarA = f0.a(r.l());
        this._backStack = vVarA;
        v<Set<NavBackStackEntry>> vVarA2 = f0.a(v0.e());
        this._transitionsInProgress = vVarA2;
        this.backStack = h.b(vVarA);
        this.transitionsInProgress = h.b(vVarA2);
    }
}
