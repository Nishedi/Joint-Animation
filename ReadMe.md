* Konrad Pempera
     * Celem projektu było oprogramowanie animacji prostej maszyny
     * Projekt składa się z dwóch widoków
     * 1) widok animacji
     * 2) widok umożliwiający zmianę danych oraz widok wyświetlający predkość oraz jej składowe
     * Aplikacja została napisana w Java Swing. Realizowana jest w niezależnym wątku, kąt ramienia napędowego zmienia się co jeden stopień co 10 ms.
     * Drugi widok umożliwia modyfikacje następujących danych l1 - długość ramienia zaczepionego w środku układu, l2 - długość ramienia zaczepionego przez koniec l1 oraz przechodząca przez punkt o wspłórzednych d i h, które również są modyfikowalne.
     * Aktualizacja wykresu realizowana jest poprzez przechwytywanie zdarzeń generowanych przez timer zewnętrzny co 100 ms.
     * Dane wprowadzone przez użytkownika są sprawdzane, w przypadku wystąpienia błedu generowany jest wyjątek przez obiekt własnoręcznie skonstruowany klasy pochodnej od exception. Jest on przechwytywany w klasie AppCOntroller i syngalizowany jest oknem messagebox.
     * Podczas projektowania aplikacji zastosowano podział na moduły zgodny z dobrymi praktykami zawartymi w MVC
     * aplikacja została skompliwona za pomocą wywołania z katalogu gdzie znajuje się aplikacja następujących poleceń:
     *javac -d bin src\exception\IncorectDataexception.java javac -d bin src\model\FlyWheel.java javac -d bin src\model\GObject.java javac -d bin src\model\History.java javac -d bin src\view\FlyWheelView.java javac -d bin src\view\SpeedPanel.java javac -d bin src\view\SpeedFrame.java javac -d bin src\main\MyPanel.java javac -d bin src\view\MyThread.java javac -d bin src\main\MainFrame.java javac -d bin src\controller\AppController.java javac -d bin src\main\Simulator.java
     * Plik jar został wygenerowany z następującego polecenia
     * jar -cfv Animation.jar -C bin .
     * Plik jar jest możliwy do uruchomienia z następującego polecenia
     * java -p Animation.jar -m Animation/main.Simulator
