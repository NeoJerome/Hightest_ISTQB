package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* Classe ToolboxPage :
 * Navigateur cible : Google Chrome.
 * Cette classe représente la page "boite-outils" (liée au lien "Toolbox") du site de Hightest
 * Adresse de la page : "https://hightest.nc/boite-outils".
 */
public class ToolboxPage {
    private WebDriver driver;
    private String testLinkHref = "http://www.hightest.nc/ressources/test-istqb.php";

    //Constructeur de la classe ToolboxPage
    public ToolboxPage (WebDriver driver){
        this.driver = driver;
    }

    /* Méthode ToolboxPage :
     * Cette méthode permet d'identifier un lien souhaité puis de cliquer dessus.
     * Le lien souhaité est celui du test ISTQB Foundation (fr) : "http://www.hightest.nc/ressources/test-istqb.php".
     * Retourne une page objet "IstqbPage".
     */
    public IstqbPage clickLinkByHref() {
        List<WebElement> links = driver.findElements(By.tagName("a"));
        Iterator<WebElement> i = links.iterator();

        while(i.hasNext()) {
            WebElement link = i.next();
            if(link.getAttribute("href").contains(testLinkHref)) {
                link.click();
                break;
            }
        }
        Set<String> openWindows = driver.getWindowHandles();
        Iterator<String> nbrOpenWin = openWindows.iterator();
        while(nbrOpenWin.hasNext()) {
            String openWindow = nbrOpenWin.next();
            driver.switchTo().window(openWindow);
            if(driver.getCurrentUrl().contains(testLinkHref)){
                break;
            }
        }
        return new IstqbPage(driver);
    }

}
