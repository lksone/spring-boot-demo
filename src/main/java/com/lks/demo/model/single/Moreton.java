package com.lks.demo.model.single;

import java.util.List;

/**
 * @author lks
 * @Time 2019/11/12
 **/
public class Moreton {

    private Moreton() {
    }

    private static volatile List<Object> instance;
}
