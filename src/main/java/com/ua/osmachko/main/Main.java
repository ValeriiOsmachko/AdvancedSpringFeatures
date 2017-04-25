package com.ua.osmachko.main;


import com.ua.osmachko.configuration.ApplicationConfiguration;
import com.ua.osmachko.phrases.Phrase;
import com.ua.osmachko.screensaver.ColorFrame;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.awt.*;
import java.util.Random;

/**
 * Created by Valerii_Osmachko on 4/24/2017.
 */
public class Main {


    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        context.getBean(Phrase.class).sayPhrase();
        while (true) {
            context.getBean(ColorFrame.class).showOnRandomPlace();
            Thread.sleep(50);
        }

    }
}
