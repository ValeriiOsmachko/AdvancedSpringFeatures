package com.ua.osmachko.screensaver;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.*;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Created by Valerii_Osmachko on 4/25/2017.
 */
@Service
@Scope("prototype")
public abstract class ColorFrame extends JFrame {

    public ColorFrame() {
        setSize(200, 200);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void showOnRandomPlace() {
        Random random = new Random();
        setLocation(random.nextInt(1200), random.nextInt(700));
        getContentPane().setBackground(getColor());
        repaint();
    }

    protected abstract Color getColor();
}
