# VillageSimulation
### [Dokumentacja projektu](VillageSimulationDocs.pdf)<br>
Projekt domyślnie uruchamia się z wyjściem do konsoli oraz wejściem w postaci parametrów znajdujących się w klasie [DefaultInput](src/main/java/Simulation/Input/DefaultInput.java)  <br>
W celu wybrania innej opcji należy aplikację uruchomić z argumentami<br> 
###### "\wejscie wyjscie opcjonalny_plik_wejscia.txt opcjonalny_plik_wyjscia.txt"
Gdzie ścieżki plików są opcjonalne i w przypadku ich braku zostaną wybrane domyślne z klasy [SimulationConsts](src/main/java/Simulation/App/SimulationConsts.java)
<br>
Do wyboru dostępne są:<br>
###### "console" - wejscie/wyjscie w konsoli <br>
###### "file" - wejscie/wyjscie do pliku <br>
###### "default" - dla wyjscia przypisuje dane domyslne, dla wyjscia wypisuje do konsoli
