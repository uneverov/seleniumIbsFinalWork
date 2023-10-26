package ru.appline.core.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.appline.core.utils.StepsData;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

/**
 * @author Neverov Evgeny
 * Страница авторизации
 */
public class CategoryPage extends BasePage {

    @FindBy(xpath = "//div[@aria-hidden='false']/descendant::input[contains(@class, 'RangeSelector_input') and @name='min']")
    private WebElement priceSelectorMin;

    @FindBy(xpath = "//input[@id='searchInput']")
    private WebElement searchField;

    @FindBy(xpath = "//*[contains(@class, 'Icons_search')]")
    private WebElement searchIcon;

    /**
     * Проверка загрузки страницы категорий товаров
     *
     * @return CategoryPage - т.е. остаемся на этой странице
     */
    public CategoryPage checkCategoryPageIsOpened(String categoryName) {
        WebElement subProductLink = driverManager.getDriver().findElement(By.xpath("//h1[contains(@class, 'PageTitle') and text()=" + "'" + categoryName + "'" + "]"));
        wait.until(ExpectedConditions.visibilityOf(subProductLink));
        return this;
    }

    /**
     * Заполнить поле "цена от"
     *
     * @return CategoryPage - т.е. остаемся на этой странице
     */
    public CategoryPage setStartPrice(String priceValue) {
        priceSelectorMin.click();
        priceSelectorMin.clear();
        priceSelectorMin.sendKeys(priceValue);
        return this;
    }

    /**
     * Выбрать производителя
     *
     * @return CategoryPage - т.е. остаемся на этой странице
     */
    public CategoryPage setProductMaker(String productMaker) {
        WebElement productMakerCheckBox = driverManager.getDriver().findElement(By.xpath("//label[contains(@class, 'Checkbox_text') and text()=" + "'" + productMaker + "'" + "]"));
        productMakerCheckBox.click();
        return this;
    }

    /**
     * Дождаться завершения поиска
     *
     * @return CategoryPage - т.е. остаемся на этой странице
     */
    public CategoryPage waitSearchEnd() {
        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState==\"complete\";"));
        return this;
    }

    /**
     * Проверка количества карточек товара в результатах поиска
     *
     * @return CategoryPage - т.е. остаемся на этой странице
     */
    public CategoryPage checkProductsCount(int count) {
        List<WebElement> productMakerCheckBox = driverManager.getDriver().findElements(By.xpath("//div[contains(@class, 'Card_wrap')]"));
        assertTrue(productMakerCheckBox.size() <= count, String.format("Колличество товаров в поисковой выдаче более %d", count));
        return this;
    }

    /**
     * Сохранить наименование продукта
     *
     * @return CategoryPage - т.е. остаемся на этой странице
     */
    public CategoryPage saveNameFirstProduct() {
        StepsData.nameProduct = driverManager.getDriver().findElement(By.xpath("//div[contains(@class, 'Card_wrap')][1]//h6")).getText();
        return this;
    }

    /**
     * Выпонить поиск продукта
     *
     * @return CategoryPage - т.е. остаемся на этой странице
     */
    public CategoryPage searchProduct() {
        scrollToElementJs(searchField);
        waitUtilElementToBeClickable(searchField);
        searchField.click();
        searchField.sendKeys(StepsData.nameProduct);
        searchIcon.click();
        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState==\"complete\";"));
        return this;
    }

    /**
     * Проверка наименования продукта в результатах поиска
     *
     * @return AuthPage - т.е. остаемся на этой странице
     */
    public CategoryPage checkProductName() {
        String productName = driverManager.getDriver().findElement(By.xpath("//div[contains(@class, 'Card_wrap')][1]//h6")).getText();
        assertEquals(productName, StepsData.nameProduct, ("Наименование товара на странице результата поиска отличается от ожидаемого"));
        return this;
    }
}