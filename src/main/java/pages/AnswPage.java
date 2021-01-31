package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/* Classe AnswPage :
 * Navigateur cible : Google Chrome.
 * Cette classe représente la page "Résultats du test en ligne - Hightest". Cette page demande une adresse mail
 * pour y envoyer les résultats du test ISTQB.
 * Adresse de la page : "https://www.hightest.nc/ressources/reponses-test-istqb.php"
 */
public class AnswPage {
    private WebDriver driver;

    //Constructeur de la classe AnswPage
    public AnswPage(WebDriver driver){
        this.driver = driver;
    }

    /* Méthode ToolboxPage :
     * Donnée en entrée : email.
     * Cette méthode permet de rentrer un e-mail dans le champ "Votre adresse e-mail :" ainsi que de cliquer sur le
     * bouton "OK" pour envoyer les résultats du test à l'adresse indiquée.
     * Retourne une page objet "MailboxPage" qui correspond à la boîte de réception de la personne ayant passé le test.
     */
    public MailboxPage emailResult(String email){
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("submitMail")).click();
        return  new MailboxPage(driver);
    }
}
