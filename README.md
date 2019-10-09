## Общие требования
1. Использовать возможности ООП: классы, наследование, полиморфизм, инкапсуляция.
2. Каждый класс должен иметь исчерпывающее смысл название и информативный состав.
3. Наследование должно применяться только тогда, когда это имеет смысл - не стоит создавать иерархию классов, изменяя в каждом классе какое-либо поле. Наследование должно менять **поведение** класса.
4. При кодировании должны быть использованы соглашения об оформлении кода java code convention.
5. Классы должны быть грамотно разложены по пакетам.
6. Для хранения параметров инициализации можно использовать файлы.
7. При сортировке использовать встроенные средства Java
8. Сортировку производить при помощи класса Comparator или интерфейса Comparable
9. Использование Java Collection Framework (за исключением java.util.Arrays) запрещено

## Задание
Рыцарь. Определить иерархию амуниции рыцаря. Операции с рыцарем:
1. Вывести характеристики рыцаря
2. Вывести список амуниции рыцаря
3. Экипировать рыцаря, что должно отразиться на его характеристиках (например вес, сила атаки и т.д.)
4. Провести сортировку амуниции на основе одного из параметров
5. Найти элементы амуниции, соответствующие заданному диапазону параметров.

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