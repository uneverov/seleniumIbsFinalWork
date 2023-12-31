#language: ru

@all
Функционал: Поиск товаров

  @firstTest
  Сценарий: Поиск видеокарты
    * Проверка открытия стартовой страницы
    * Открыть меню 'Каталог'
    * Выбрать раздел 'Комплектующие для ПК'
    * Выбрать подраздел 'Видеокарты'
    * Задать параметр поиска по цене от '20000' рублей
    * Выбрать производителя 'Gigabyte'
    * Дождаться выполнения поиска
    * Проверить, что в поисковой выдаче не более 24 товаров
    * Сохранить наименование первого товара в списке
    * В поисковую строку ввести запомненное значение, выполнить поиск
    * Проверить, что в поисковой выдаче не более 1 товаров
    * Проверить, что наименование товара соответствует сохраненному значению

  @secondTest
  Сценарий: Поиск клавиатуры
    * Проверка открытия стартовой страницы
    * Открыть меню 'Каталог'
    * Выбрать раздел 'Периферия'
    * Выбрать подраздел 'Клавиатуры'
    * Задать параметр поиска по цене от '2000' рублей
    * Выбрать производителя 'A4Tech'
    * Дождаться выполнения поиска
    * Проверить, что в поисковой выдаче не более 24 товаров
    * Сохранить наименование первого товара в списке
    * В поисковую строку ввести запомненное значение, выполнить поиск
    * Проверить, что в поисковой выдаче не более 1 товаров
    * Проверить, что наименование товара соответствует сохраненному значению