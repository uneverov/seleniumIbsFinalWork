package ru.appline.core.steps;

import io.cucumber.java.ru.И;
import ru.appline.core.managers.PageManager;

public class CategoryPageSteps {
    private final PageManager pageManager = PageManager.getPageManager();

    @И("^Задать параметр поиска по цене от '(.+)' рублей$")
    public void setStartPrice(String priceValue) {
        pageManager.getCategoryPage().setStartPrice(priceValue);
    }

    @И("^Выбрать производителя '(.+)'$")
    public void setProductMaker(String productMaker) {
        pageManager.getCategoryPage().setProductMaker(productMaker);
    }

    @И("^Дождаться выполнения поиска$")
    public void waitSearchEnd() {
        pageManager.getCategoryPage().waitSearchEnd();
    }

    @И("^Проверить, что в поисковой выдаче не более (\\d+) товаров$")
    public void checkProductsCount(int count) {
        pageManager.getCategoryPage().checkProductsCount(count);
    }

    @И("^Сохранить наименование первого товара в списке$")
    public void saveNameFirstProduct() {
        pageManager.getCategoryPage().saveNameFirstProduct();
    }

    @И("^В поисковую строку ввести запомненное значение, выполнить поиск$")
    public void searchProduct() {
        pageManager.getCategoryPage().searchProduct();
    }

    @И("^Проверить, что наименование товара соответствует сохраненному значению$")
    public void checkProductName() {
        pageManager.getCategoryPage().checkProductName();
    }
}