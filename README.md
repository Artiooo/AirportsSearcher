# AirportsSearcher
The program finds the nearest airports at the specified coordinates
Knn linear searcher
Сборка проекта осуществляется с помощью Maven. После сборки исходного кода командой mvn clean package, получаем в качестве артефакта airports-search.jar
Далее пользователь переходит в папку target, где лежит артефакт и запускает его командой java -jar airports-search.jar

Также пытался реализовать поиск с помощью структуры KDTree. Работает быстрее, но пока удалось реализовать поиск только одного ближайшего аэропорта.
https://github.com/Artiooo/AirportsSearchWithKDTree/tree/main
