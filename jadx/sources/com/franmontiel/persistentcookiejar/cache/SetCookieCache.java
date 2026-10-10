package com.franmontiel.persistentcookiejar.cache;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import okhttp3.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class SetCookieCache implements CookieCache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Set<IdentifiableCookie> f1479a = new HashSet();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private class SetCookieCacheIterator implements Iterator<m> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Iterator<IdentifiableCookie> f1480a;

        public SetCookieCacheIterator() {
            this.f1480a = SetCookieCache.this.f1479a.iterator();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public m next() {
            return this.f1480a.next().b();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1480a.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f1480a.remove();
        }
    }

    @Override // java.lang.Iterable
    public Iterator<m> iterator() {
        return new SetCookieCacheIterator();
    }

    @Override // com.franmontiel.persistentcookiejar.cache.CookieCache
    public void addAll(Collection<m> collection) {
        for (IdentifiableCookie identifiableCookie : IdentifiableCookie.a(collection)) {
            this.f1479a.remove(identifiableCookie);
            this.f1479a.add(identifiableCookie);
        }
    }
}
