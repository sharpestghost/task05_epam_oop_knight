## Общие требования
1. Использовать возможности ООП: классы, наследование, полиморфизм, инкапсуляция.
2. При кодировании должны быть использованы соглашения об оформлении кода java code convention.
3. Наследование должно **расширять** поведение или состояние класса. 
4. Использование Java Collection Framework (за исключением java.util.Arrays) запрещено
5. При сортировке использовать встроенные средства Java
6. Сортировку производить при помощи класса Comparator или интерфейса Comparable
7. Для хранения параметров инициализации можно использовать файлы.
8. Название классов, методов и полей должно соответствовать их содержимому.

## Задание
Приложение моделирует рыцаря, на которого можно надевать предметы, которые меняют характеристики рыцаря. 
Управление моделью осуществляется через консольное меню, где пользователь вводит номер пункта меню. 
Вывод информации осуществляется через консоль.
Пользователю должны быть доступны следующие операции:
1. Вывести характеристики рыцаря
2. Вывести список амуниции рыцаря
3. Экипировать рыцаря, что должно отразиться на его характеристиках (например вес, сила атаки и т.д.). Пользователю должны быть доступны несколько типов предметов. Характеристики предметов пользователь вводит в консоли (см. пример ввода/вывода).
4. Провести сортировку амуниции на основе одного из параметров
5. Найти элементы амуниции, соответствующие заданному диапазону параметров.

Разные типы предметов должны быть представлены иерархией классов (начиная с интерфейса Ammunition).

## Описание классов шаблона
1. Knight - Класс с данными о рыцаре: надетые предметы и характеристики (stats).
2. KnightAmmunitionManager - Содержит логику добавления экипировки, обновления характеристик, поиска и сортировки экипировки. 
3. ConsoleView - класс для организации ввода и вывода в консоли. 
4. KnightGenerator, AmmunitionGenerator - Создают объекты Knight и Ammunition.
5. KnightController - организует вывод меню, вызов операций на KnightAmmunitionManager, создание объектов через генераторы, т.е. свызывает все части приложения друг с другом.
6. KnightApplication - точка входа в приложение, вызывает главное меню через KnightController. 

## Пример ввода/вывода
```
Main menu:
1. Print knight stats
2. Show ammunition
3. Equip ammunition
4. Sort ammunition
5. Search ammunition
6. Exit
Choose option:
2
Sword{damage=10, weight=20, cost=30}
Helmet{protection=30, weight=10, cost=20}
Main menu:
1. Print knight stats
2. Show ammunition
3. Equip ammunition
4. Sort ammunition
5. Search ammunition
6. Exit
Choose option:
3
What kind of ammunition do you want to equip?
1. Sword
2. Helmet
Choose option:
1
Input sword weight:
100
Input sword cost:
2
Input sword damage:
30
Main menu:
1. Print knight stats
2. Show ammunition
3. Equip ammunition
4. Sort ammunition
5. Search ammunition
6. Exit
Choose option:
2
Sword{damage=10, weight=20, cost=30}
Helmet{protection=30, weight=10, cost=20}
Sword{damage=30, weight=100, cost=2}
Main menu:
1. Print knight stats
2. Show ammunition
3. Equip ammunition
4. Sort ammunition
5. Search ammunition
6. Exit
Choose option:
1
Ammunition cost: 52
Ammunition weight: 130
Ammunition damage: 40
Ammunition protection: 30
Main menu:
1. Print knight stats
2. Show ammunition
3. Equip ammunition
4. Sort ammunition
5. Search ammunition
6. Exit
Choose option:
4
Choose sort type:
1. Cost
2. Weight
Choose option:
2
Helmet{protection=30, weight=10, cost=20}
Sword{damage=10, weight=20, cost=30}
Sword{damage=30, weight=100, cost=2}
Main menu:
1. Print knight stats
2. Show ammunition
3. Equip ammunition
4. Sort ammunition
5. Search ammunition
6. Exit
Choose option:
5
Choose search field:
1. Cost
2. Weight
Choose option:
1
Input minimum cost: 
0
Input maximum cost: 
5
Sword{damage=30, weight=100, cost=2}
Main menu:
1. Print knight stats
2. Show ammunition
3. Equip ammunition
4. Sort ammunition
5. Search ammunition
6. Exit
Choose option:
6
Bye!
```