package pages;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* Classe IstqbPage :
 * Navigateur cible : Google Chrome.
 * Cette classe représente la page du test ISTQB Foundation en français.
 * Adresse de la page : "https://www.hightest.nc/ressources/test-istqb.php".
 */

public class IstqbPage {
    private WebDriver driver;
    private String path = "./src/test/quizdata/cpc.json";

    //Constructeur de la classe IstqbPage
    public IstqbPage(WebDriver driver){
        this.driver = driver;
    }

    /* Méthode clickRadio() :
     * Cette méthode permet de récupérer les données d'un fichier au format json qui correspondent
     * aux réponses (corrects) du QCM ISTQB Foundation en français.
     * Ce fichier (cpc.json) est situé dans le dossier "quizdata".
     * Une fois les réponses récupérées, des clics sont effectués sur les éléments "radio" correspondant puis le
     * formulaire est validé en cliquant sur le bouton "Terminé !".
     * Retourne une page objet "AnswPage".
     */
    public AnswPage clickRadio() {
        JSONParser parser = new JSONParser();
        WebDriverWait wait = new WebDriverWait(driver,5);
        int sizeQuiz = 20;
        int idAnsw =0;
        int[] goodAnsw = new int[sizeQuiz];

        try {
            JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(path));
            for(int i=0;i<jsonArray.size();i++){
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                long buffer = (long) jsonObject.get("quest");
                goodAnsw[i] = (int) buffer;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        List<WebElement> radios = driver.findElements(By.tagName("input"));

        while(idAnsw<radios.size()) {
            WebElement radio = radios.get(idAnsw);
            if(radio.getAttribute("value").contains("5")) {
                radios.remove(idAnsw);
            }
            idAnsw++;
        }
        Actions action = new Actions(driver);
        for(int i=0;i<sizeQuiz;i++) {
            goodAnsw[i] = 4*i + goodAnsw[i]-1;
            try{
                radios.get(goodAnsw[i]).click();
            } catch (Exception e1) {
                if (goodAnsw[i] < radios.size() - 4) {
                    action.moveToElement(radios.get(goodAnsw[i] + 4)).perform();
                    wait.until(ExpectedConditions.visibilityOf(radios.get(goodAnsw[i] + 4)));
                } else {
                    action.moveToElement(radios.get(radios.size() - 1)).perform();
                    wait.until(ExpectedConditions.visibilityOf(radios.get(radios.size() - 1)));
                }
                radios.get(goodAnsw[i]).click();
            }
        }
        action.moveToElement(driver.findElement(By.xpath("//input[@id='submit']"))).perform();
        action.sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(By.xpath("//input[@id='submit']")).click();
        return new AnswPage(driver);
    }
}
