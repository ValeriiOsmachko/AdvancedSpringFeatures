package com.ua.osmachko.customannotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Valerii_Osmachko on 4/25/2017.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface DeprecatedClass {

    Class newImpl();
}
