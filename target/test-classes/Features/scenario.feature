Feature: Wybranie smartwatcha z listy ofert

  Scenario: Wybranie smartwatcha bez abonamentu
    Given Otwórz przeglądarkę
    Then Przeglądarka otworzona
    When Przejdź na stronę "https://www.t-mobile.pl/"
    Then Strona główna jest widoczna
    When Z górnej belki wybierz Urządzenia
    Then Widoczna rozwijana lista
    When Kliknij "Bez abonamentu" z kolumny "Smartwatche i opaski"
    Then Widoczna lista smartwatchy
    When Kliknij w pierwszy element z listy
    Then Widoczna strona produktu
    And Zapamiętaj kwoty "Cena na start" oraz "Rata miesięczna"
    When Dodaj produkt do koszyka
    Then Widoczna strona Twój koszyk.
    And Kwoty "Cena na start" oraz "Rata miesięczna" zgadzają się z kwotami z poprzedniej strony.
    When Przejdź na stronę główną sklepu
    Then Widoczna strona główna.
    And W prawym górnym rogu widoczna jest ikonka koszyka z liczbą produktów w koszyku.
