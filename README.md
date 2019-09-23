AUTOMATE CELLULAIRE
===================
      
Informations Globales sur les Frelons.
-------------------------------------

Pour programmer un automate cellulaire nous avons decidé de simuler
l'évolution d'une population de frelons asiatiques.  Voici certaines conditions
de vie du frelon en fonction de : 

1. la saison (Par exemple, en hiver tous les frelon meurent sauf les fondatrices);
2. le type de frelon: mâle et femelle;
3. leur rôle dans leur colonie: les fondatrices qui seront plus tard les reines, 
les ouvrières et les mâles charger d'accouplement avec les fondatrices pour la 
reproduction;
4. la durée de vie: chez les frelons, la fondatrice a un cycle de vie d'un an 
maximum, les ouvrières ont à peu près 2 mois selon une étude. Pour les mâles on 
a pas eu de données dessus et nous avons fait une estimation de 2 mois;
5. le régime alimentaire: il est constitué principalement de fruits murs, 
de nectar, de différents insectes (mouches, guêpes, abeilles,chenilles, etc);
6. la pollution (pesticide) 
          
*Remarque. J'ai remis le premier paragraphe en forme et corrigé des (beaucoup)
fautes d'orthographe. Ça reste moyennement compréhensible.* 

les trois propriétés fondamentales des automates cellulaires *standards* sont:  
-----------------------------------------------------------------------------

        1. Le parallélisme : Un système est dit parallèle si ses constituants évoluent simultanément et de manière indépendante.  
        2. La proximité (locality) : Le nouvel état d'une cellule ne dépend que de son état actuel et de l'état du voisinage immédiat.  
        3. L'homogénéité : Les lois sont universelles, c'est-à-dire communes à l'ensemble de l'espace de l'automate.  

Les règles du jeu.
-----------------
pour les regles de jeu de notre automate cellulaire nous avons fixé ceux-ci:

    -LE VOISINAGE:un frelon peu avoir 8 voisins maximum:gauche,droite, haut,bas et les diagonales.
    -CONDITION DE NAISSANCE:
                a)aucune naissance possible durant la periode d'hiver
                b)Une cellule inactive entourée de 3 felons vivants devient active (« naît ») ;
                
    -CONDITION DE SURVIE ET DE MORT: 
                a)Un frelon vivant entouré de 2 ou 3 frelons vivant reste vivant;  
                b)un frelon ne peut vivre au dela de sa durée de vie
                c)comme dit en haut tous le frelon meurt en hiver sauf les fondatrices,mais comme ces derniers sont en état d'hibernation   
                   nous leur considererons mort pour simplification  
                d) par respect du 3ème principe nous avons décidé que la durée de vie de tous les frelons est de 5 mois.  
   
   
