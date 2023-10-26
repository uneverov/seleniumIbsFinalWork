package ru.appline.core.steps;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import ru.appline.core.managers.InitManager;

public class Hooks {

    @BeforeAll
    public static void before() {
        InitManager.initFramework();
    }

    @AfterAll
    public static void after() {
        InitManager.quitFramework();
    }
}