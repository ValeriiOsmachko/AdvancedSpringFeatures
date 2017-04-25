package com.ua.osmachko.phrases.impl;

import com.ua.osmachko.customannotations.DeprecatedClass;
import com.ua.osmachko.customannotations.InjectRandomInt;
import com.ua.osmachko.customannotations.PostProxy;
import com.ua.osmachko.customannotations.Profiling;
import com.ua.osmachko.phrases.Phrase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by Valerii_Osmachko on 4/24/2017.
 */
@Profiling
@Component
@DeprecatedClass(newImpl = T1000.class)
public class MessiPhrase implements Phrase {

    @InjectRandomInt(min = 1, max = 10)
    private int repeat;

    @Value("I'll be back")
    private String phrase;

    public MessiPhrase() {
        System.out.println("Phase 1");
    }

    @Override
    @PostProxy
    public void sayPhrase() {
        System.out.println("Phase 3");
        for (int i = 0; i < repeat; i++) {
            System.out.println(phrase);
        }
    }

    @PostConstruct
    public void init() {
        System.out.println("Phase 2");
    }

    public void setRepeat(int repeat) {
        this.repeat = repeat;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }
}
