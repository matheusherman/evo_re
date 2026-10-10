package xd;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class a implements Serializable {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private transient k f22065a;
    private List<u> authenticationPath;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private transient int f22066b;
    private int index;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f22067k;
    private Map<Integer, u> keep;
    private Map<Integer, LinkedList<u>> retain;
    private u root;
    private Stack<u> stack;
    private final List<c> treeHashInstances;
    private final int treeHeight;
    private boolean used;

    a(a aVar) {
        this.f22065a = new k(aVar.f22065a.d());
        this.treeHeight = aVar.treeHeight;
        this.f22067k = aVar.f22067k;
        this.root = aVar.root;
        ArrayList arrayList = new ArrayList();
        this.authenticationPath = arrayList;
        arrayList.addAll(aVar.authenticationPath);
        this.retain = new TreeMap();
        for (Integer num : aVar.retain.keySet()) {
            this.retain.put(num, (LinkedList) aVar.retain.get(num).clone());
        }
        Stack<u> stack = new Stack<>();
        this.stack = stack;
        stack.addAll(aVar.stack);
        this.treeHashInstances = new ArrayList();
        Iterator<c> it = aVar.treeHashInstances.iterator();
        while (it.hasNext()) {
            this.treeHashInstances.add(it.next().clone());
        }
        this.keep = new TreeMap(aVar.keep);
        this.index = aVar.index;
        this.f22066b = aVar.f22066b;
        this.used = aVar.used;
    }

    private a(a aVar, fc.u uVar) {
        this.f22065a = new k(new m(uVar));
        this.treeHeight = aVar.treeHeight;
        this.f22067k = aVar.f22067k;
        this.root = aVar.root;
        ArrayList arrayList = new ArrayList();
        this.authenticationPath = arrayList;
        arrayList.addAll(aVar.authenticationPath);
        this.retain = new TreeMap();
        for (Integer num : aVar.retain.keySet()) {
            this.retain.put(num, (LinkedList) aVar.retain.get(num).clone());
        }
        Stack<u> stack = new Stack<>();
        this.stack = stack;
        stack.addAll(aVar.stack);
        this.treeHashInstances = new ArrayList();
        Iterator<c> it = aVar.treeHashInstances.iterator();
        while (it.hasNext()) {
            this.treeHashInstances.add(it.next().clone());
        }
        this.keep = new TreeMap(aVar.keep);
        this.index = aVar.index;
        this.f22066b = aVar.f22066b;
        this.used = aVar.used;
        g();
    }

    private c a() {
        c cVar = null;
        for (c cVar2 : this.treeHashInstances) {
            if (!cVar2.h() && cVar2.i() && (cVar == null || cVar2.c() < cVar.c() || (cVar2.c() == cVar.c() && cVar2.d() < cVar.d()))) {
                cVar = cVar2;
            }
        }
        return cVar;
    }

    private void e(byte[] bArr, byte[] bArr2, j jVar) {
        if (jVar == null) {
            throw new NullPointerException("otsHashAddress == null");
        }
        i iVar = (i) new i.b().g(jVar.b()).h(jVar.c()).l();
        g gVar = (g) new g.b().g(jVar.b()).h(jVar.c()).k();
        for (int i10 = 0; i10 < (1 << this.treeHeight); i10++) {
            jVar = (j) new j.b().g(jVar.b()).h(jVar.c()).p(i10).n(jVar.e()).o(jVar.f()).f(jVar.a()).l();
            k kVar = this.f22065a;
            kVar.h(kVar.g(bArr2, jVar), bArr);
            n nVarE = this.f22065a.e(jVar);
            iVar = (i) new i.b().g(iVar.b()).h(iVar.c()).n(i10).o(iVar.f()).p(iVar.g()).f(iVar.a()).l();
            u uVarA = v.a(this.f22065a, nVarE, iVar);
            gVar = (g) new g.b().g(gVar.b()).h(gVar.c()).n(i10).f(gVar.a()).k();
            while (!this.stack.isEmpty() && this.stack.peek().a() == uVarA.a()) {
                int iA = i10 / (1 << uVarA.a());
                if (iA == 1) {
                    this.authenticationPath.add(uVarA);
                }
                if (iA == 3 && uVarA.a() < this.treeHeight - this.f22067k) {
                    this.treeHashInstances.get(uVarA.a()).j(uVarA);
                }
                if (iA >= 3 && (iA & 1) == 1 && uVarA.a() >= this.treeHeight - this.f22067k && uVarA.a() <= this.treeHeight - 2) {
                    if (this.retain.get(Integer.valueOf(uVarA.a())) == null) {
                        LinkedList<u> linkedList = new LinkedList<>();
                        linkedList.add(uVarA);
                        this.retain.put(Integer.valueOf(uVarA.a()), linkedList);
                    } else {
                        this.retain.get(Integer.valueOf(uVarA.a())).add(uVarA);
                    }
                }
                g gVar2 = (g) new g.b().g(gVar.b()).h(gVar.c()).m(gVar.e()).n((gVar.f() - 1) / 2).f(gVar.a()).k();
                u uVarB = v.b(this.f22065a, this.stack.pop(), uVarA, gVar2);
                u uVar = new u(uVarB.a() + 1, uVarB.b());
                gVar = (g) new g.b().g(gVar2.b()).h(gVar2.c()).m(gVar2.e() + 1).n(gVar2.f()).f(gVar2.a()).k();
                uVarA = uVar;
            }
            this.stack.push(uVarA);
        }
        this.root = this.stack.pop();
    }

    private void f(byte[] bArr, byte[] bArr2, j jVar) {
        List<u> list;
        u uVarRemoveFirst;
        byte[] bArr3;
        byte[] bArr4;
        if (jVar == null) {
            throw new NullPointerException("otsHashAddress == null");
        }
        if (this.used) {
            throw new IllegalStateException("index already used");
        }
        int i10 = this.index;
        if (i10 > this.f22066b - 1) {
            throw new IllegalStateException("index out of bounds");
        }
        int iB = a0.b(i10, this.treeHeight);
        if (((this.index >> (iB + 1)) & 1) == 0 && iB < this.treeHeight - 1) {
            this.keep.put(Integer.valueOf(iB), this.authenticationPath.get(iB));
        }
        i iVar = (i) new i.b().g(jVar.b()).h(jVar.c()).l();
        g gVar = (g) new g.b().g(jVar.b()).h(jVar.c()).k();
        int i11 = 0;
        if (iB == 0) {
            jVar = (j) new j.b().g(jVar.b()).h(jVar.c()).p(this.index).n(jVar.e()).o(jVar.f()).f(jVar.a()).l();
            k kVar = this.f22065a;
            kVar.h(kVar.g(bArr2, jVar), bArr);
            this.authenticationPath.set(0, v.a(this.f22065a, this.f22065a.e(jVar), (i) new i.b().g(iVar.b()).h(iVar.c()).n(this.index).o(iVar.f()).p(iVar.g()).f(iVar.a()).l()));
        } else {
            int i12 = iB - 1;
            g gVar2 = (g) new g.b().g(gVar.b()).h(gVar.c()).m(i12).n(this.index >> iB).f(gVar.a()).k();
            k kVar2 = this.f22065a;
            kVar2.h(kVar2.g(bArr2, jVar), bArr);
            u uVarB = v.b(this.f22065a, this.authenticationPath.get(i12), this.keep.get(Integer.valueOf(i12)), gVar2);
            this.authenticationPath.set(iB, new u(uVarB.a() + 1, uVarB.b()));
            this.keep.remove(Integer.valueOf(i12));
            for (int i13 = 0; i13 < iB; i13++) {
                if (i13 < this.treeHeight - this.f22067k) {
                    list = this.authenticationPath;
                    uVarRemoveFirst = this.treeHashInstances.get(i13).e();
                } else {
                    list = this.authenticationPath;
                    uVarRemoveFirst = this.retain.get(Integer.valueOf(i13)).removeFirst();
                }
                list.set(i13, uVarRemoveFirst);
            }
            int iMin = Math.min(iB, this.treeHeight - this.f22067k);
            for (int i14 = 0; i14 < iMin; i14++) {
                int i15 = this.index + 1 + ((1 << i14) * 3);
                if (i15 < (1 << this.treeHeight)) {
                    this.treeHashInstances.get(i14).g(i15);
                }
            }
        }
        j jVar2 = jVar;
        while (i11 < ((this.treeHeight - this.f22067k) >> 1)) {
            c cVarA = a();
            if (cVarA != null) {
                bArr3 = bArr;
                bArr4 = bArr2;
                cVarA.k(this.stack, this.f22065a, bArr3, bArr4, jVar2);
            } else {
                bArr3 = bArr;
                bArr4 = bArr2;
            }
            i11++;
            bArr = bArr3;
            bArr2 = bArr4;
        }
        this.index++;
    }

    private void g() {
        if (this.authenticationPath == null) {
            throw new IllegalStateException("authenticationPath == null");
        }
        if (this.retain == null) {
            throw new IllegalStateException("retain == null");
        }
        if (this.stack == null) {
            throw new IllegalStateException("stack == null");
        }
        if (this.treeHashInstances == null) {
            throw new IllegalStateException("treeHashInstances == null");
        }
        if (this.keep == null) {
            throw new IllegalStateException("keep == null");
        }
        if (!a0.l(this.treeHeight, this.index)) {
            throw new IllegalStateException("index in BDS state out of bounds");
        }
    }

    protected int b() {
        return this.index;
    }

    public int c() {
        return this.f22066b;
    }

    public a d(byte[] bArr, byte[] bArr2, j jVar) {
        return new a(this, bArr, bArr2, jVar);
    }

    public a h(fc.u uVar) {
        return new a(this, uVar);
    }

    private a(a aVar, byte[] bArr, byte[] bArr2, j jVar) {
        this.f22065a = new k(aVar.f22065a.d());
        this.treeHeight = aVar.treeHeight;
        this.f22067k = aVar.f22067k;
        this.root = aVar.root;
        ArrayList arrayList = new ArrayList();
        this.authenticationPath = arrayList;
        arrayList.addAll(aVar.authenticationPath);
        this.retain = new TreeMap();
        for (Integer num : aVar.retain.keySet()) {
            this.retain.put(num, (LinkedList) aVar.retain.get(num).clone());
        }
        Stack<u> stack = new Stack<>();
        this.stack = stack;
        stack.addAll(aVar.stack);
        this.treeHashInstances = new ArrayList();
        Iterator<c> it = aVar.treeHashInstances.iterator();
        while (it.hasNext()) {
            this.treeHashInstances.add(it.next().clone());
        }
        this.keep = new TreeMap(aVar.keep);
        this.index = aVar.index;
        this.f22066b = aVar.f22066b;
        this.used = false;
        f(bArr, bArr2, jVar);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        int i10;
        objectInputStream.defaultReadObject();
        if (objectInputStream.available() != 0) {
            i10 = objectInputStream.readInt();
        } else {
            i10 = (1 << this.treeHeight) - 1;
        }
        this.f22066b = i10;
        int i11 = this.f22066b;
        if (i11 <= (1 << this.treeHeight) - 1 && this.index <= i11 + 1 && objectInputStream.available() == 0) {
        } else {
            throw new IOException("inconsistent BDS data detected");
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.f22066b);
    }

    private a(k kVar, int i10, int i11, int i12) {
        this.f22065a = kVar;
        this.treeHeight = i10;
        this.f22066b = i12;
        this.f22067k = i11;
        if (i11 <= i10 && i11 >= 2) {
            int i13 = i10 - i11;
            if (i13 % 2 == 0) {
                this.authenticationPath = new ArrayList();
                this.retain = new TreeMap();
                this.stack = new Stack<>();
                this.treeHashInstances = new ArrayList();
                for (int i14 = 0; i14 < i13; i14++) {
                    this.treeHashInstances.add(new c(i14));
                }
                this.keep = new TreeMap();
                this.index = 0;
                this.used = false;
                return;
            }
        }
        throw new IllegalArgumentException("illegal value for BDS parameter k");
    }

    a(x xVar, int i10, int i11) {
        this(xVar.i(), xVar.b(), xVar.c(), i11);
        this.f22066b = i10;
        this.index = i11;
        this.used = true;
    }

    a(x xVar, byte[] bArr, byte[] bArr2, j jVar) {
        this(xVar.i(), xVar.b(), xVar.c(), (1 << xVar.b()) - 1);
        e(bArr, bArr2, jVar);
    }

    a(x xVar, byte[] bArr, byte[] bArr2, j jVar, int i10) {
        this(xVar.i(), xVar.b(), xVar.c(), (1 << xVar.b()) - 1);
        e(bArr, bArr2, jVar);
        while (this.index < i10) {
            f(bArr, bArr2, jVar);
            this.used = false;
        }
    }
}
