Feature: Hepsiburada Tablet Satın Alma

  Scenario: Apple tablet seçimi ve sepete ekleme
    Given Kullanıcı Hepsiburada ana sayfasına gider
    When Tablet kategorisine gider
    And Apple ve 13.2 inç filtrelerini seçer
    And En pahalı ürüne tıklar
    And Ürünü sepete ekler
    Then Ürünün sepete eklendiği doğrulanır
    And Sepetteki fiyat ürün detay sayfasındaki fiyat ile aynı olmalıdır 