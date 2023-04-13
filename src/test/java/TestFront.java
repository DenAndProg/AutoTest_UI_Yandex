import ByLocator.ByLocator;
import Methods.*;
import ScreenShot.MakeScreen;
import Wait.Wait;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import InitialDriver.InitialDriver;
import org.openqa.selenium.NoSuchElementException;

@DisplayName("Тесты")
public class TestFront {

    @ParameterizedTest
    @DisplayName("Логин на яндекс почту")
    @ValueSource(strings = { "Chrome"/*, "FireFox"*/ })
    void TestsignInYandex(String name){
        Methods.getMainPage(name);
        Methods.findElementAndClick(ByLocator.close);
        Methods.findElementAndClick(By.xpath("/html/body/main/div[1]/div/a[1]"));
        Methods.inputText(ByLocator.login, "AutotestLogin");
        Methods.findElementAndClick(ByLocator.signIn);
        Methods.inputText(ByLocator.password, "autotestPassword123");
        Methods.findElementAndClick(ByLocator.signIn);
        //Methods.findElementAndClick(By.cssSelector("#root > div > div.passp-page > div.passp-flex-wrapper > div > div > div.passp-auth-content > div.passp-route-forward > div > div > div > div.Info-content > div.Info-action > button"));
        //MakeScreen.makeScreenShot(name);
    }

    @ParameterizedTest
    @DisplayName("Невалидный пароль")
    @ValueSource(strings = { "Chrome", "FireFox" })
    void TestnoSignInYandex(String name){
        Methods.getMainPage(name);
        Methods.findElementAndClick(ByLocator.close);
        Methods.findElementAndClick(By.xpath("/html/body/main/div[1]/div/a[1]"));
        Methods.inputText(ByLocator.login, "AutotestLogin");
        Methods.findElementAndClick(ByLocator.signIn);
        Methods.inputText(ByLocator.password, "NoAutotestPassword");
        Methods.findElementAndClick(ByLocator.signIn);
        String error = Wait.waitElement(By.cssSelector("#field\\:input-passwd\\:hint")).getText();
        assert(error.equals("Неверный пароль"));
    }

    @ParameterizedTest
    @DisplayName("Невалидный логин")
    @ValueSource(strings = { "Chrome", "FireFox" })
    void TestnoValidLoginYandex(String name){
        Methods.getMainPage(name);
        Methods.findElementAndClick(ByLocator.close);
        Methods.findElementAndClick(By.xpath("/html/body/main/div[1]/div/a[1]"));
        Methods.inputText(ByLocator.login, "NoAutotestUser");
        Methods.findElementAndClick(ByLocator.signIn);
        String error = Wait.waitElement(By.cssSelector("#field\\:input-login\\:hint")).getText();
        assert(error.equals("Такого аккаунта нет"));
    }

    @ParameterizedTest
    @DisplayName("Кнопки")
    @ValueSource(strings = { "FireFox" })
    void Testbuttons(String name) throws InterruptedException {
        Methods.getMainPage(name);
        //Methods.findElementAndClick(ByLocator.close);
        Methods.findElementAndClick(By.xpath("//*[@id=\"text\"]"));
        Methods.findElementAndClick(By.xpath("/html/body/main/div[2]/form/div[2]/div/nav/ul/li[10]/a/div[1]"));
        Methods.findElementClickAndWent(By.cssSelector("body > div.popup2.services-more-popup.services-more-popup_middle_yes.services-more-popup_pinnable_yes.services-more-popup_suggest_yes.popup2_theme_normal.popup2_autoclosable_yes.popup2_services-more_yes.popup2_view_classic.i-bem.popup2_js_inited.services-more-popup_js_inited.popup2_visible_yes > div > div > div.scrollbar__scrollable > div > div.services-more-popup__section.services-more-popup__section-all > div.services-more-popup__section-content > span:nth-child(7) > a > div.services-more-popup__item-icon"),1);
        Thread.sleep(2000);
        assert(InitialDriver.driver.getCurrentUrl().equals("https://yandex.by/video/search?text=%D0%B2%D0%B8%D0%B4%D0%B5%D0%BE"));
        ManageMeth.setWindowHandels(0);
        Methods.findElementClickAndWent(By.cssSelector("body > div.popup2.services-more-popup.services-more-popup_middle_yes.services-more-popup_pinnable_yes.services-more-popup_suggest_yes.popup2_theme_normal.popup2_autoclosable_yes.popup2_services-more_yes.popup2_view_classic.i-bem.popup2_js_inited.services-more-popup_js_inited.popup2_visible_yes > div > div > div.scrollbar__scrollable > div > div.services-more-popup__section.services-more-popup__section-all > div.services-more-popup__section-content > span:nth-child(8) > a"),2);
        Thread.sleep(2000);
        assert(InitialDriver.driver.getCurrentUrl().equals("https://yandex.by/images/"));
        ManageMeth.setWindowHandels(0);
        Methods.findElementClickAndWent(By.cssSelector("body > div.popup2.services-more-popup.services-more-popup_middle_yes.services-more-popup_pinnable_yes.services-more-popup_suggest_yes.popup2_theme_normal.popup2_autoclosable_yes.popup2_services-more_yes.popup2_view_classic.i-bem.popup2_js_inited.services-more-popup_js_inited.popup2_visible_yes > div > div > div.scrollbar__scrollable > div > div.services-more-popup__section.services-more-popup__section-all > div.services-more-popup__section-content > span:nth-child(3) > a"), 3);
        assert(InitialDriver.driver.getCurrentUrl().equals("https://www.kinopoisk.ru/"));
        ManageMeth.setWindowHandels(0);
        Methods.findElementClickAndWent(By.cssSelector("body > div.popup2.services-more-popup.services-more-popup_middle_yes.services-more-popup_pinnable_yes.services-more-popup_suggest_yes.popup2_theme_normal.popup2_autoclosable_yes.popup2_services-more_yes.popup2_view_classic.i-bem.popup2_js_inited.services-more-popup_js_inited.popup2_visible_yes > div > div > div.scrollbar__scrollable > div > div.services-more-popup__section.services-more-popup__section-all > div.services-more-popup__section-content > span:nth-child(2) > a"), 4);
        assert(InitialDriver.driver.getCurrentUrl().equals("https://yandex.by/maps/154/vitebsk/?ll=30.202875%2C55.184219&z=11"));
        ManageMeth.setWindowHandels(0);
        Methods.findElementClickAndWent(By.cssSelector("body > div.popup2.services-more-popup.services-more-popup_middle_yes.services-more-popup_pinnable_yes.services-more-popup_suggest_yes.popup2_theme_normal.popup2_autoclosable_yes.popup2_services-more_yes.popup2_view_classic.i-bem.popup2_js_inited.services-more-popup_js_inited.popup2_visible_yes > div > div > div.scrollbar__scrollable > div > div.services-more-popup__section.services-more-popup__section-all > div.services-more-popup__section-content > span:nth-child(4) > a"), 5);
        assert(InitialDriver.driver.getCurrentUrl().equals("https://translate.yandex.by/?utm_source=yamain&utm_medium=all_services"));
        ManageMeth.setWindowHandels(0);
        Methods.findElementClickAndWent(By.cssSelector("body > div.popup2.services-more-popup.services-more-popup_middle_yes.services-more-popup_pinnable_yes.services-more-popup_suggest_yes.popup2_theme_normal.popup2_autoclosable_yes.popup2_services-more_yes.popup2_view_classic.i-bem.popup2_js_inited.services-more-popup_js_inited.popup2_visible_yes > div > div > div.scrollbar__scrollable > div > div.services-more-popup__section.services-more-popup__section-all > div.services-more-popup__section-content > span:nth-child(9) > a"), 6);
        assert(InitialDriver.driver.getCurrentUrl().equals("https://music.yandex.by/home"));
        ManageMeth.setWindowHandels(0);
        Methods.findElementClickAndWent(By.cssSelector("body > div.popup2.services-more-popup.services-more-popup_middle_yes.services-more-popup_pinnable_yes.services-more-popup_suggest_yes.popup2_theme_normal.popup2_autoclosable_yes.popup2_services-more_yes.popup2_view_classic.i-bem.popup2_js_inited.services-more-popup_js_inited.popup2_visible_yes > div > div > div.scrollbar__scrollable > div > div.services-more-popup__section.services-more-popup__section-all > div.services-more-popup__section-content > span:nth-child(13) > a"), 7);
        assert(InitialDriver.driver.getCurrentUrl().equals("https://yandex.by/metro/minsk"));
    }
}
