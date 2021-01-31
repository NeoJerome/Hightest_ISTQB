package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/* Classe MailboxPage :
 * Navigateur cible : Google Chrome.
 * Cette classe représente la page d'accueil du site yopmail.
 * Adresse du site : "http://www.yopmail.com/"
 */
public class MailboxPage {
    private WebDriver driver;
    //Constructeur de la classe MailboxPage
    public MailboxPage(WebDriver driver){
        this.driver = driver;
    }

    /* Méthode getResult :
     * Cette méthode permet d'aller sur la page d'accueil de yopmail, de rentrer "norilus" dans le champ "login"
     * de la page puis de cliquer sur le bouton "Vérifier les mails" afin d'accéder au(x) mail(s) reçu(s).
     * Retourne le résultat du test ISTQB écrit au début du mail envoyé par "contact@hightest.nc".
     */
    public String getResult(){
        driver.get("http://www.yopmail.com/");
        driver.findElement(By.id("login")).sendKeys("norilus");
        driver.findElement(By.xpath("//input[@value='Vérifier les mails']")).click();
        driver.switchTo().frame("ifmail");
        WebElement test = driver.findElement(By.xpath("//div[@id='mailmillieu']/div[2]/div/div[2]/div[1]"));
        String result = test.getText();
        return result;
    }

}
