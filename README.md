[![Build status](https://ci.appveyor.com/api/projects/status/gsltqy2oru5y2y24?svg=true)](https://ci.appveyor.com/project/Alexander43884/debetcardformtest)

## Автоматический тест формы заявки на дебетовую карту

___

* Создать папку, открыть терминал по адресу папки и инициализировать систему Git `git init`
* Склонировать репозиторий `git clone https://github.com/AlexanderKachalov/DebetCardFormTest.git`
* Перейти в директорию artifacts `cd artifacts` и выполнить команду `java -jar app-order.jar`
* Форма заявки находится по адресу `localhost:9999`
* Вернуться в директорию с проектом `cd /DebetCardFormTest`
* Выполнить команду `./gradlew test` (`./gradlew.bat test` для Windows)
* Отчет о выполнении тестов в директории `build/reports/tests/test`
___
* Тестируемая форма:

![](DebetCardForm.png)
