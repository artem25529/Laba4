package com.es.service;

import javax.ejb.Singleton;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Singleton
public class MSGService {
    private final List<String> messages = new ArrayList<>();

    public void add(String msg) {
        if (msg.trim().length() >= 4) {
            messages.add(msg);
        }
        if (messages.size() == 10) {
            messages.sort(Comparator.naturalOrder());
            messages.forEach(System.out::println);
            messages.clear();
        }
    }
}
