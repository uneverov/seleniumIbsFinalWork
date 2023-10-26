package ru.appline.core.steps;

import io.cucumber.java.ru.И;
import ru.appline.core.managers.PageManager;

public class StartPageSteps {
    private final PageManager pageManager = PageManager.getPageManager();

    @И("^Проверка открытия стартовой страницы$")
    public void checkStartPageIsOpened() {
        pageManager.getStartPage().checkStartPageIsOpened();
    }

    @И("^Открыть меню 'Каталог'$")
    public void openCatalogMenu() {
        pageManager.getStartPage().openCatalogMenu();
    }

    @И("^Выбрать раздел '(.+)'$")
    public void selectMainProduct(String Section) {
        pageManager.getStartPage().selectMainProduct(Section);
    }

    @И("^Выбрать подраздел '(.+)'$")
    public void selectSubProduct(String Section) {
        pageManager.getStartPage().selectSubProduct(Section);
    }

}