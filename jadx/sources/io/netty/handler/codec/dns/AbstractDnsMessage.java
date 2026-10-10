package io.netty.handler.codec.dns;

import io.netty.util.AbstractReferenceCounted;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.ReferenceCounted;
import io.netty.util.ResourceLeakDetector;
import io.netty.util.ResourceLeakDetectorFactory;
import io.netty.util.ResourceLeakTracker;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class AbstractDnsMessage extends AbstractReferenceCounted implements DnsMessage {
    private Object additionals;
    private Object answers;
    private Object authorities;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private short f11364id;
    private final ResourceLeakTracker<DnsMessage> leak = leakDetector.track(this);
    private DnsOpCode opCode;
    private Object questions;
    private boolean recursionDesired;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private byte f11365z;
    private static final ResourceLeakDetector<DnsMessage> leakDetector = ResourceLeakDetectorFactory.instance().newResourceLeakDetector(DnsMessage.class);
    private static final int SECTION_QUESTION = DnsSection.QUESTION.ordinal();

    public DnsMessage addRecord(DnsSection dnsSection, DnsRecord dnsRecord) {
        addRecord(sectionOrdinal(dnsSection), dnsRecord);
        return this;
    }

    public DnsMessage clear() {
        for (int i10 = 0; i10 < 4; i10++) {
            clear(i10);
        }
        return this;
    }

    @Override // io.netty.handler.codec.dns.DnsMessage
    public int count(DnsSection dnsSection) {
        return count(sectionOrdinal(dnsSection));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DnsMessage)) {
            return false;
        }
        DnsMessage dnsMessage = (DnsMessage) obj;
        if (id() != dnsMessage.id()) {
            return false;
        }
        if (this instanceof DnsQuery) {
            if (!(dnsMessage instanceof DnsQuery)) {
                return false;
            }
        } else if (dnsMessage instanceof DnsQuery) {
            return false;
        }
        return true;
    }

    @Override // io.netty.handler.codec.dns.DnsMessage
    public <T extends DnsRecord> T recordAt(DnsSection dnsSection, int i10) {
        return (T) recordAt(sectionOrdinal(dnsSection), i10);
    }

    public DnsMessage setId(int i10) {
        this.f11364id = (short) i10;
        return this;
    }

    public DnsMessage setRecord(DnsSection dnsSection, DnsRecord dnsRecord) {
        setRecord(sectionOrdinal(dnsSection), dnsRecord);
        return this;
    }

    private void addRecord(int i10, DnsRecord dnsRecord) {
        checkQuestion(i10, dnsRecord);
        Object objSectionAt = sectionAt(i10);
        if (objSectionAt == null) {
            setSection(i10, dnsRecord);
            return;
        }
        if (!(objSectionAt instanceof DnsRecord)) {
            ((List) objSectionAt).add(dnsRecord);
            return;
        }
        ArrayList<DnsRecord> arrayListNewRecordList = newRecordList();
        arrayListNewRecordList.add(castRecord(objSectionAt));
        arrayListNewRecordList.add(dnsRecord);
        setSection(i10, arrayListNewRecordList);
    }

    private static <T extends DnsRecord> T castRecord(Object obj) {
        return (T) obj;
    }

    private static DnsRecord checkQuestion(int i10, DnsRecord dnsRecord) {
        if (i10 != SECTION_QUESTION || (ObjectUtil.checkNotNull(dnsRecord, "record") instanceof DnsQuestion)) {
            return dnsRecord;
        }
        throw new IllegalArgumentException("record: " + dnsRecord + " (expected: " + StringUtil.simpleClassName((Class<?>) DnsQuestion.class) + ')');
    }

    private void clear(int i10) {
        Object objSectionAt = sectionAt(i10);
        setSection(i10, null);
        if (objSectionAt instanceof ReferenceCounted) {
            ((ReferenceCounted) objSectionAt).release();
            return;
        }
        if (objSectionAt instanceof List) {
            List list = (List) objSectionAt;
            if (list.isEmpty()) {
                return;
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ReferenceCountUtil.release(it.next());
            }
        }
    }

    private int count(int i10) {
        Object objSectionAt = sectionAt(i10);
        if (objSectionAt == null) {
            return 0;
        }
        if (objSectionAt instanceof DnsRecord) {
            return 1;
        }
        return ((List) objSectionAt).size();
    }

    private static ArrayList<DnsRecord> newRecordList() {
        return new ArrayList<>(2);
    }

    private <T extends DnsRecord> T recordAt(int i10, int i11) {
        Object objSectionAt = sectionAt(i10);
        if (objSectionAt == null) {
            throw new IndexOutOfBoundsException("index: " + i11 + " (expected: none)");
        }
        if (!(objSectionAt instanceof DnsRecord)) {
            return (T) castRecord(((List) objSectionAt).get(i11));
        }
        if (i11 == 0) {
            return (T) castRecord(objSectionAt);
        }
        throw new IndexOutOfBoundsException("index: " + i11 + "' (expected: 0)");
    }

    private Object sectionAt(int i10) {
        if (i10 == 0) {
            return this.questions;
        }
        if (i10 == 1) {
            return this.answers;
        }
        if (i10 == 2) {
            return this.authorities;
        }
        if (i10 == 3) {
            return this.additionals;
        }
        throw new Error();
    }

    private static int sectionOrdinal(DnsSection dnsSection) {
        return ((DnsSection) ObjectUtil.checkNotNull(dnsSection, "section")).ordinal();
    }

    private void setRecord(int i10, DnsRecord dnsRecord) {
        clear(i10);
        setSection(i10, checkQuestion(i10, dnsRecord));
    }

    private void setSection(int i10, Object obj) {
        if (i10 == 0) {
            this.questions = obj;
            return;
        }
        if (i10 == 1) {
            this.answers = obj;
        } else if (i10 == 2) {
            this.authorities = obj;
        } else {
            if (i10 != 3) {
                throw new Error();
            }
            this.additionals = obj;
        }
    }

    @Override // io.netty.handler.codec.dns.DnsMessage
    public int id() {
        return this.f11364id & 65535;
    }

    @Override // io.netty.handler.codec.dns.DnsMessage
    public boolean isRecursionDesired() {
        return this.recursionDesired;
    }

    @Override // io.netty.handler.codec.dns.DnsMessage
    public DnsOpCode opCode() {
        return this.opCode;
    }

    public DnsMessage setOpCode(DnsOpCode dnsOpCode) {
        this.opCode = (DnsOpCode) ObjectUtil.checkNotNull(dnsOpCode, "opCode");
        return this;
    }

    public DnsMessage setRecursionDesired(boolean z10) {
        this.recursionDesired = z10;
        return this;
    }

    public DnsMessage setZ(int i10) {
        this.f11365z = (byte) (i10 & 7);
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public DnsMessage touch(Object obj) {
        ResourceLeakTracker<DnsMessage> resourceLeakTracker = this.leak;
        if (resourceLeakTracker != null) {
            resourceLeakTracker.record(obj);
        }
        return this;
    }

    @Override // io.netty.handler.codec.dns.DnsMessage
    public int z() {
        return this.f11365z;
    }

    protected AbstractDnsMessage(int i10, DnsOpCode dnsOpCode) {
        setId(i10);
        setOpCode(dnsOpCode);
    }

    @Override // io.netty.util.AbstractReferenceCounted
    protected void deallocate() {
        clear();
        ResourceLeakTracker<DnsMessage> resourceLeakTracker = this.leak;
        if (resourceLeakTracker != null) {
            resourceLeakTracker.close(this);
        }
    }

    public int hashCode() {
        return (id() * 31) + (!(this instanceof DnsQuery) ? 1 : 0);
    }

    @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public DnsMessage retain() {
        return (DnsMessage) super.retain();
    }
}
