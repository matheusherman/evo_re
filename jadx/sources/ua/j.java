package ua;

import java.util.Iterator;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\b\u001a\u0004\u0018\u00010\u0001H\u0016¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001a\u0010\u0013\u001a\u00020\u000e8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u001eR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010 ¨\u0006\""}, d2 = {"Lua/j;", "Lua/i;", "Ljava/util/regex/Matcher;", "matcher", "", "input", "<init>", "(Ljava/util/regex/Matcher;Ljava/lang/CharSequence;)V", "next", "()Lua/i;", "a", "Ljava/util/regex/Matcher;", "b", "Ljava/lang/CharSequence;", "Lua/h;", "c", "Lua/h;", "getGroups", "()Lua/h;", "groups", "", "", "d", "Ljava/util/List;", "groupValues_", "Ljava/util/regex/MatchResult;", "e", "()Ljava/util/regex/MatchResult;", "matchResult", "Lh9/e;", "()Lh9/e;", "range", "()Ljava/util/List;", "groupValues", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
final class j implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Matcher matcher;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final CharSequence input;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final h groups;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private List<String> groupValues_;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"ua/j$a", "Lkotlin/collections/d;", "", "", "index", "h", "(I)Ljava/lang/String;", "getSize", "()I", "size", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a extends kotlin.collections.d<String> {
        a() {
        }

        @Override // kotlin.collections.b, java.util.Collection, java.util.List
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof String) {
                return f((String) obj);
            }
            return false;
        }

        @Override // kotlin.collections.d, kotlin.collections.b
        /* JADX INFO: renamed from: getSize */
        public int get_size() {
            return j.this.e().groupCount() + 1;
        }

        @Override // kotlin.collections.d, java.util.List
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public String get(int index) {
            String strGroup = j.this.e().group(index);
            return strGroup == null ? "" : strGroup;
        }

        @Override // kotlin.collections.d, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof String) {
                return i((String) obj);
            }
            return -1;
        }

        @Override // kotlin.collections.d, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof String) {
                return k((String) obj);
            }
            return -1;
        }

        public /* bridge */ boolean f(String str) {
            return super.contains(str);
        }

        public /* bridge */ int i(String str) {
            return super.indexOf(str);
        }

        public /* bridge */ int k(String str) {
            return super.lastIndexOf(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0007H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0096\u0002¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"ua/j$b", "", "Lkotlin/collections/b;", "Lua/g;", "", "isEmpty", "()Z", "", "iterator", "()Ljava/util/Iterator;", "", "index", "i", "(I)Lua/g;", "getSize", "()I", "size", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b extends kotlin.collections.b<MatchGroup> implements h {
        @Override // kotlin.collections.b, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        b() {
        }

        @Override // kotlin.collections.b, java.util.Collection, java.util.List
        public final /* bridge */ boolean contains(Object obj) {
            if (obj == null ? true : obj instanceof MatchGroup) {
                return h((MatchGroup) obj);
            }
            return false;
        }

        @Override // kotlin.collections.b
        /* JADX INFO: renamed from: getSize */
        public int get_size() {
            return j.this.e().groupCount() + 1;
        }

        public MatchGroup i(int index) {
            h9.e eVarH = m.h(j.this.e(), index);
            if (eVarH.getStart().intValue() < 0) {
                return null;
            }
            String strGroup = j.this.e().group(index);
            kotlin.jvm.internal.m.e(strGroup, "group(...)");
            return new MatchGroup(strGroup, eVarH);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final MatchGroup k(b bVar, int i10) {
            return bVar.i(i10);
        }

        public /* bridge */ boolean h(MatchGroup matchGroup) {
            return super.contains(matchGroup);
        }

        @Override // kotlin.collections.b, java.util.Collection, java.lang.Iterable
        public Iterator<MatchGroup> iterator() {
            return ta.k.J(kotlin.collections.r.Z(kotlin.collections.r.m(this)), new c9.l() { // from class: ua.k
                @Override // c9.l
                public final Object invoke(Object obj) {
                    return j.b.k(this.f19459a, ((Integer) obj).intValue());
                }
            }).iterator();
        }
    }

    public j(Matcher matcher, CharSequence input) {
        kotlin.jvm.internal.m.f(matcher, "matcher");
        kotlin.jvm.internal.m.f(input, "input");
        this.matcher = matcher;
        this.input = input;
        this.groups = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MatchResult e() {
        return this.matcher;
    }

    @Override // ua.i
    public List<String> b() {
        if (this.groupValues_ == null) {
            this.groupValues_ = new a();
        }
        List<String> list = this.groupValues_;
        kotlin.jvm.internal.m.c(list);
        return list;
    }

    @Override // ua.i
    public i.b a() {
        return i.a.a(this);
    }

    @Override // ua.i
    public h9.e c() {
        return m.g(e());
    }

    @Override // ua.i
    public i next() {
        int i10;
        int iEnd = e().end();
        if (e().end() == e().start()) {
            i10 = 1;
        } else {
            i10 = 0;
        }
        int i11 = iEnd + i10;
        if (i11 <= this.input.length()) {
            Matcher matcher = this.matcher.pattern().matcher(this.input);
            kotlin.jvm.internal.m.e(matcher, "matcher(...)");
            return m.e(matcher, i11, this.input);
        }
        return null;
    }
}
