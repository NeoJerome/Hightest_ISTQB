package com.projet.istqb;


import org.testng.annotations.Test;
import pages.AnswPage;
import pages.IstqbPage;
import pages.MailboxPage;
import pages.ToolboxPage;

import static org.testng.Assert.assertEquals;

/* Classe TestCpc :
 * Navigateur cible : Google Chrome.
 * Cette classe représente le test "Cent pout Cent" qui consiste à vérifier que le mail reçu, de la part de
 * "contact@hightest.nc", contient bien la phrase : "Vous avez bien répondu à 20 question(s) sur 20, soit 100 %
 * de réussite. Félicitations, vous avez obtenu le score maximal !". Cette phrase est écrite uniquement en cas de
 * résussite à 100 %.
 */
public class TestCpc extends BaseTests{
    private String expResult = "Vous avez bien répondu à 20 question(s) sur 20, soit 100 % de réussite. Félicitations, vous avez obtenu le score maximal !";
    private String email = "norilus@yopmail.com";

    /* Méthode testSucessfulCpc :
     * Cette méthode permet d'exécuter le cas de test avec le scénario suivant :
     * Etape 1 - Cliquer sur "Toolbox"
     * Etape 2 - Cliquer sur le lien vers le quiz ISTQB Fondation en français
     * Etape 3 - Cliquer sur les bonnes réponses du test
     * Etape 4 - Cliquer sur le bouton "Terminer!"
     * Etape 6 - Entrer une adresse e-mail yopmail.com (ne pas cocher la case pour la newsletter)
     * Etape 7 - Cliquer sur "OK"
     * Etape 8 - Ouvrir la page "www.yopmail.com"
     * Etape 9 - Vérifier que le mail reçu de la part de "contact@hightest.nc" indique bien la phrase attendue :
     * "Vous avez bien répondu à 20 question(s) sur 20, soit 100 % de réussite. Félicitations, vous avez obtenu
     *  le score maximal !".
     */
    @Test
    public void testSucessfulCpc(){
        ToolboxPage toolboxPage = homePage.clickToolboxLink();
        IstqbPage istqbPage = toolboxPage.clickLinkByHref();
        AnswPage answPage = istqbPage.clickRadio();
        MailboxPage mailboxPage = answPage.emailResult(email);
        String result = mailboxPage.getResult();
        assertEquals(result,expResult);
    }
}
