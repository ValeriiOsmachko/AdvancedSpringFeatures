package com.ua.osmachko.phrases.impl;

import com.ua.osmachko.phrases.Phrase;

import javax.annotation.PostConstruct;

/**
 * Created by Valerii_Osmachko on 4/25/2017.
 */
public class T1000 extends MessiPhrase implements Phrase{

    @Override
    @PostConstruct
    public void sayPhrase() {
        System.out.println("I'am big");
    }

}
