# Hepsiburada Test Otomasyon Projesi

Bu proje, Hepsiburada web sitesinde tablet satın alma sürecini test eden bir otomasyon projesidir.

## Kullanılan Teknolojiler

- Java 11
- Selenium WebDriver 4.11.0
- Cucumber 7.11.0
- JUnit 4.13.2
- Maven

## Proje Yapısı

- `src/test/java/pages`: Page Object Model sınıfları
- `src/test/java/stepdefinitions`: Cucumber step tanımlamaları
- `src/test/resources/features`: Cucumber feature dosyaları

## Test Senaryosu

1. Hepsiburada ana sayfasına git
2. Tablet kategorisine git (Tüm Kategoriler -> Elektronik -> Tablet)
3. Apple marka ve 13.2 inç ekran boyutu filtrelerini seç
4. En yüksek fiyatlı ürünü seç
5. Ürünü sepete ekle
6. Sepetteki ürün fiyatının doğruluğunu kontrol et

## Projeyi Çalıştırma

1. Projeyi klonlayın
2. Maven dependencies'leri yükleyin
3. ChromeDriver'ı sisteminize kurun ve PATH'e ekleyin
4. Feature dosyasını veya test runner'ı çalıştırın

## Notlar

- Proje Page Object Model (POM) tasarım desenini kullanmaktadır
- BDD yaklaşımı için Cucumber framework'ü kullanılmıştır
- Web otomasyon için Selenium WebDriver kullanılmıştır 