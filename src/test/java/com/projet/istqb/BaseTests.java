package com.projet.istqb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.HomePage;

/* Classe BaseTests :
 * Navigateur cible : Google Chrome.
 * Cette classe représente la classe parente des tests automatisées liés au projet ISTQB Foundation.
 */
public class BaseTests {
    private WebDriver driver;
    protected HomePage homePage;

    /* Méthode setUp :
     * Cette méthode permet de d'instancier un WebDriver de type "ChromeDriver" (navigateur cible = Google Chrome),
     * de lancer la page d'accueil du site Hightest (https://hightest.nc/) puis d'instancier un objet HomePage (la classe
     * HomePage représente la page d'accueil). Cette méthode est lancée avant chaque test automatisé lié au projet ISTQB
     * Foundation.
     */
    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://hightest.nc/");
        homePage = new HomePage(driver);
    }
    /* Méthode tearDown :
     * Cette méthode est lancée après chaque test automatisé lié au projet ISTQB
     * Foundation afin de fermer le navigateur Google Chrome.
     */
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
