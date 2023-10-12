package ru.appline.core.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import ru.appline.core.managers.InitManager;
import ru.appline.core.managers.TestPropManager;

import static ru.appline.core.utils.PropConst.BASE_URL;
import static ru.appline.core.utils.PropConst.INSURANCE_URL;

public class Hooks {

    private static final TestPropManager props = TestPropManager.getTestPropManager();
    @Before
    public void before(Scenario scenario) {
        if (scenario.getName().contains("Страхование путешественников")) {
            InitManager.initFramework(props.getProperty(INSURANCE_URL));
        } else {
            InitManager.initFramework(props.getProperty(BASE_URL));
        }
    }

    @After
    public void after() {
        InitManager.quitFramework();
    }
}