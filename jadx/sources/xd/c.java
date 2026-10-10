package xd;

import java.io.Serializable;
import java.util.Stack;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
class c implements Serializable, Cloneable {
    private static final long serialVersionUID = 1;
    private int height;
    private final int initialHeight;
    private int nextIndex;
    private u tailNode;
    private boolean initialized = false;
    private boolean finished = false;

    void g(int i10) {
        this.tailNode = null;
        this.height = this.initialHeight;
        this.nextIndex = i10;
        this.initialized = true;
        this.finished = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public c clone() {
        c cVar = new c(this.initialHeight);
        cVar.tailNode = this.tailNode;
        cVar.height = this.height;
        cVar.nextIndex = this.nextIndex;
        cVar.initialized = this.initialized;
        cVar.finished = this.finished;
        return cVar;
    }

    int c() {
        if (!this.initialized || this.finished) {
            return Integer.MAX_VALUE;
        }
        return this.height;
    }

    int d() {
        return this.nextIndex;
    }

    public u e() {
        return this.tailNode;
    }

    boolean h() {
        return this.finished;
    }

    boolean i() {
        return this.initialized;
    }

    void j(u uVar) {
        this.tailNode = uVar;
        int iA = uVar.a();
        this.height = iA;
        if (iA == this.initialHeight) {
            this.finished = true;
        }
    }

    void k(Stack<u> stack, k kVar, byte[] bArr, byte[] bArr2, j jVar) {
        if (jVar == null) {
            throw new NullPointerException("otsHashAddress == null");
        }
        if (this.finished || !this.initialized) {
            throw new IllegalStateException("finished or not initialized");
        }
        j jVar2 = (j) new j.b().g(jVar.b()).h(jVar.c()).p(this.nextIndex).n(jVar.e()).o(jVar.f()).f(jVar.a()).l();
        i iVar = (i) new i.b().g(jVar2.b()).h(jVar2.c()).n(this.nextIndex).l();
        g gVar = (g) new g.b().g(jVar2.b()).h(jVar2.c()).n(this.nextIndex).k();
        kVar.h(kVar.g(bArr2, jVar2), bArr);
        u uVarA = v.a(kVar, kVar.e(jVar2), iVar);
        while (!stack.isEmpty() && stack.peek().a() == uVarA.a() && stack.peek().a() != this.initialHeight) {
            g gVar2 = (g) new g.b().g(gVar.b()).h(gVar.c()).m(gVar.e()).n((gVar.f() - 1) / 2).f(gVar.a()).k();
            u uVarB = v.b(kVar, stack.pop(), uVarA, gVar2);
            u uVar = new u(uVarB.a() + 1, uVarB.b());
            gVar = (g) new g.b().g(gVar2.b()).h(gVar2.c()).m(gVar2.e() + 1).n(gVar2.f()).f(gVar2.a()).k();
            uVarA = uVar;
        }
        u uVar2 = this.tailNode;
        if (uVar2 == null) {
            this.tailNode = uVarA;
        } else if (uVar2.a() == uVarA.a()) {
            g gVar3 = (g) new g.b().g(gVar.b()).h(gVar.c()).m(gVar.e()).n((gVar.f() - 1) / 2).f(gVar.a()).k();
            uVarA = new u(this.tailNode.a() + 1, v.b(kVar, this.tailNode, uVarA, gVar3).b());
            this.tailNode = uVarA;
        } else {
            stack.push(uVarA);
        }
        if (this.tailNode.a() == this.initialHeight) {
            this.finished = true;
        } else {
            this.height = uVarA.a();
            this.nextIndex++;
        }
    }

    c(int i10) {
        this.initialHeight = i10;
    }
}
