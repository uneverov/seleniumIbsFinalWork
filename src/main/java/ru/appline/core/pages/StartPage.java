package ru.appline.core.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * @author Neverov Evgeny
 * Страница авторизации
 */
public class StartPage extends BasePage {

    @FindBy(xpath = "//button[contains(@class, 'Button_button')]/span[text()='Каталог']")
    private WebElement buttonCatalog;

    @FindBy(xpath = "//body[@style='overflow: hidden;']")
    private WebElement frameCatalog;

    /**
     * Проверка загрузки стартовой страцы
     *
     * @return StartPage - т.е. остаемся на этой странице
     */
    public StartPage checkStartPageIsOpened() {
        wait.until(ExpectedConditions.visibilityOf(buttonCatalog));
        return this;
    }

    /**
     * Открытие меню каталога
     *
     * @return StartPage - т.е. остаемся на этой странице
     */
    public StartPage openCatalogMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonCatalog));
        buttonCatalog.click();
        wait.until(ExpectedConditions.visibilityOf(frameCatalog));
        return this;
    }

    /**
     * Выбор главного продукта
     *
     * @return StartPage - т.е. остаемся на этой странице
     */
    public StartPage selectMainProduct(String nameSection) {
        WebElement mainProduct = driverManager.getDriver().findElement(By.xpath("//a[contains(@class, 'Catalog_mainCategory') and contains(.//div, " + "'" + nameSection + "'"+ ")]"));
        scrollToElementJs(mainProduct).click();
        return this;
    }

    /**
     * Выбор вторичного продукта
     *
     * @return CategoryPage - т.е. остаемся на этой странице
     */
    public CategoryPage selectSubProduct(String nameProduct) {
        WebElement subProduct = driverManager.getDriver().findElement(By.xpath("//a[contains(@class, 'Category_subTitle') and text()="+ "'" + nameProduct + "'" + "]"));
        subProduct.click();
        return pageManager.getCategoryPage().checkCategoryPageIsOpened(nameProduct);
    }
}
