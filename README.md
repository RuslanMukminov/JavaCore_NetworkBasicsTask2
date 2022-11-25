# Домашнее задание по теме «Основы работы с сетью. Модель OSI, TCP, UDP»
## Задача 2 (необязательная)
В классе `Server` создан сервер с использованием `ServerSocket`. Сервер будет имитировать игру в города.

Первый игрок (первый подключающийся после старта сервера клиент) на вход от сервера получает строку "???" - так клиент понимает, что он первый игрок и может назвать любой город. Назвать = отправить город в виде одной строки на сервер, сервер в ответ отправляет строку "OK".

Все остальные игроки (т.е. подключающиеся не первыми) получают при подключении на вход строку - последний введённый город в игре. Клиент в ответ отправляет город в виде одной строки; в ответ сервер отправляет либо строку "OK", если отправленный город начинался на букву на которую заканчивался последний город, иначе "NOT OK". В последнем случае введённый игроком город не учитывается для последующих игроков.

Каждый игрок подключается один раз и вводит только один город. Мы доверяем, что слово, введённое игроком - название города. Можно считать, что все города вводятся с маленькой буквы.