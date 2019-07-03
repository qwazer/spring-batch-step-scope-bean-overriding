package com.github.qwazer.sbssbo;

import org.springframework.batch.item.ItemReader;

public class DummyReader implements ItemReader {
    @Override
    public Object read() {
        return null;
    }
}
