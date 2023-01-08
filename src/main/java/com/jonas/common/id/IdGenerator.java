package com.jonas.common.id;

import java.net.InetAddress;

/**
 * @author shenjy
 * @createTime 2022/2/24 11:25
 * @description IdGenerator
 */
public class IdGenerator {

    private final Sequence sequence;

    public IdGenerator() {
        this.sequence = new Sequence(null);
    }

    public IdGenerator(InetAddress inetAddress) {
        this.sequence = new Sequence(inetAddress);
    }

    public IdGenerator(long workerId, long dataCenterId) {
        this.sequence = new Sequence(workerId, dataCenterId);
    }

    public IdGenerator(Sequence sequence) {
        this.sequence = sequence;
    }

    public Long nextId() {
        return sequence.nextId();
    }
}
