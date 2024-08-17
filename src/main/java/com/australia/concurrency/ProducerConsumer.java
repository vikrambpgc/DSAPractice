package com.australia.concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class Data {

}
public class ProducerConsumer {
    private final BlockingQueue<Data> buffer = new LinkedBlockingQueue<>();

    public void produce(Data data) {
        buffer.add(data);
    }

    public Data consume() throws InterruptedException {
        return buffer.take();
    }
}
