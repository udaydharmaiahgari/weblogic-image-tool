/* Copyright (c) 2019 Oracle and/or its affiliates. All rights reserved. */

package com.oracle.weblogicx.imagebuilder.util;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class CloseableList<E extends Closeable> extends ArrayList<E> implements Closeable {

    public CloseableList(int initialCapacity) {
        super(initialCapacity);
    }

    public CloseableList() {
        super();
    }

    public CloseableList(Collection<? extends E> c) {
        super(c);
    }

    @Override
    public void close() {
        this.forEach(x -> {
            try {
                x.close();
            } catch (IOException e) {
                //suppress exception
            }
        });
    }
}