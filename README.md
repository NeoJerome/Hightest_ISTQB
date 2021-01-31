# Hightest_ISTQB
## Description du projet

Objet du test : Quiz ISTQB niveau Foundation en français.

Objectif du test : Créer un test automatisé permettant de contrôler que le mail "résultat" reçu de la part de "contact@hightest.nc" suite à la réalisation d'un test ISTQB Foundation (en français) sur le site de Hightest indique bien 100 % de bonnes réponses.

## Cas de test à automatise

> - Etape 1 - Cliquer sur "Toolbox"
> - Etape 2 - Cliquer sur le lien vers le quiz ISTQB Fondation en français
> - Etape 3 - Cliquer sur les bonnes réponses du test
> - Etape 4 - Cliquer sur le bouton "Terminer!"
>Etape 6 - Entrer une adresse e-mail yopmail.com (ne pas cocher la case pour la newsletter)
>Etape 7 - Cliquer sur "OK"
>Etape 8 - Ouvrir la page "www.yopmail.com"
>Etape 9 - Vérifier que le mail reçu de la part de "contact@hightest.nc" indique bien la phrase attendue : "Vous avez bien répondu à 20 question(s) sur 20, soit 100 >% de réussite. Félicitations, vous avez obtenu le score maximal !".

## Environnement du test

- Outil utilisé : Selenium => Version 3.141.59 / Java => Version Java 15.0.2 / Framework de test TestNG => Version 6.14.3 
- IDE utilisé : Intelli J IDEA CE
- Navigateur cible : Google Chrome => Version Driver : ChromeDriver 87.0.4280.88
- Design pattern : Page Object Model

