package com.example.music.controller;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Map;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class MusicControllerTest {

    @Autowired
    private MusicController musicController;

    @org.junit.Test
    public void score() {

           Map result = musicController.score();

           result.forEach((k,v)->{
               System.out.println(k+":"+v);
           });



           BigDecimal a = new BigDecimal(0);
           BigDecimal b = new BigDecimal(8);

           a = a.add(b);

        System.out.println(a);


    }
}