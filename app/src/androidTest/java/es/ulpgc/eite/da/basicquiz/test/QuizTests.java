package es.ulpgc.eite.da.basicquiz.test;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

// Project: Basic Quiz
// Created by Luis Hernandez on 10/6/24.
// Copyright (c) 2024 EITE (ULPGC).
@RunWith(Cucumber.class)
@CucumberOptions(
    glue =  "es.ulpgc.eite.da.basicquiz.steps" ,
    features = "features"
)
public class QuizTests {

}
