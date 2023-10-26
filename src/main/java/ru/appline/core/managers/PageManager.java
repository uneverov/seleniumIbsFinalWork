package ru.appline.core.managers;

import ru.appline.core.pages.CategoryPage;
import ru.appline.core.pages.StartPage;

/**
 * @author Neverov Evgeny
 * Класс для управления страничками
 */
public class PageManager {

    /**
     * Менеджер страничек
     */
    private static PageManager pageManager;

    /**
     * Стартовая страница
     */
    private StartPage startPage;

    /**
     * Страница категорий товаров
     */
    private CategoryPage categoryPage;

    /**
     * Ленивая инициализация PageManager
     *
     * @return PageManager
     */
    public static PageManager getPageManager() {
        if (pageManager == null) {
            pageManager = new PageManager();
        }
        return pageManager;
    }

    /**
     * Ленивая инициализация {@link StartPage}
     *
     * @return AuthPage
     */
    public StartPage getStartPage() {
        if (startPage == null) {
            startPage = new StartPage();
        }
        return startPage;
    }

    /**
     * Ленивая инициализация {@link CategoryPage}
     *
     * @return AuthPage
     */
    public CategoryPage getCategoryPage() {
        if (categoryPage == null) {
            categoryPage = new CategoryPage();
        }
        return categoryPage;
    }



}