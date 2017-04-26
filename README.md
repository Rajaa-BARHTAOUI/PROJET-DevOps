# PROJET-DevOps
Projet: On a deux parties
  -Partie client: le client a la possibilitée d'utiliser hashtable avec clé String avec élèments de type ArrayList( Integer, float, double, String).
  -Partie serveur: On a implémenté dans le serveur un ensemble de fonctions qui gérent la structure hastable(clé, valeur). Pour les valeurs, on peut avoir des structures génériques.
    fonctions:
       * récupérer l'élèment de la  clé passée en parametres
           -structrures génériques: getValue(String Key)
           -structure spécialisée ArrayList: getValueListIndex(K key,int index): récupérer la valeur de l'indice(int index) de l'arrayList( valeur de la clé(K key) passée en parametres)   
       *modifier l'élement de la clé:
           -structures génériques: setValue(String key, V valeur)
           -structure spécialisée ArrayList: setValueListIndex(K key, int index,E value): modifier à l'indice(int index) de l'arrayList( valeur de la clé(K key) passée en parametres) par la nouvelle valeur (value) passée en parametres   
       * tester si hashtable contient la clé passée en parametres: containsKey(K key)
       * tester si hashtable contient l'élèment passé en parametres:
           -structures génériques: containsValue(V value)
           -structure spécialisée ArrayList: containsValueInList(K key,E value): tester si l'arrayList contient la valeur passée en parametres
       * Chercher l'indice de l'élement passé en parametres  dans l'arraylist : indexValueInList(K key,E value)
       * Ajouter une valeur à l'élèment passé en parametres
           -structures génériques: addValue(K key,Object val)
           -structure spécialisée ArrayList: addValue(K key,int index,E val): ajouter la valeur passée en arguments dans l'indice (index) de l'ArrayList 
       *incrementer l'élèment de hashtable
          -structures génériques: incrementer (K key): incrémenter la clé passer en parametres
          -structure spécialisée ArrayList: incrementer(K key,int index): incrémenter l'indice(int index) de l'arrayList( valeur de la clé(K key) passer en parametres)  
       *decrementer l'element de hashtable
          -structures génériques: decrementer (K key): décrémenter la clé passer en parametres
          -structure spécialisée ArrayList: decrementer(K key,int index): décrémenter l'indice(int index) de l'arrayList( valeur de la clé(K key) passer en parametres)
       * Ajouter un élement dans hashtable
          -structures génériques: addElement(K key, V value): ajouter l'element de la clé passée en parametres
          -structure spécialisée ArrayList: addElementInList(K key, E value): ajouter à l'indice(int index) de l'arrayList( valeur de la clé(K key) passée en parametres) un nouveau element. 
       *supprimer un élement de hashtable
          -structures génériques:  removeElement(K key): supprimer l'element de la clé passée en parametres
          -structure spécialisée ArrayList: removeElementListIndex(K key, int index): supprimer l'element de l'indice(int index) de l'arrayList( valeur de la clé(K key) passée en parametres).
      
       
Pour lancer le projet:
    - il faut lancer:
              - la commande rmiregister & pour activer le RMI.
              - le serveur(classe ServerRMI.java)
              - le client en passant par arguments le nom du serveur(adresse)
    -Pour installer maven: mvn install.
    -Pour lancer les tests: mvn test.
    -le projet est testé par travis.
    -Pour savoir la couverture des tests dans le code: mvn emma:emma avec updates Snapshots
      on a obtenu 75% de couverture dont 7 méthodes non testés car:
        -2 méthodes pour le client
        -2 méthodes d'éxceptions qui sont déja testées dans les tests de l'implémentation du table de hashage
        -3 méthodes dont 2 méthodes sont dans la classe qui fournie la  connexion entre le serveur et le client et la 3eme méthode pour sayHello() 
 
Guide utilisateur: 
    L'utilisateur doit établir la connexion vers le serveur et récupérer les objets de hashtable fournit par le serveur:
        Registry registry = LocateRegistry.getRegistry(serverName);
        /* Hashtable With List Of String*/
        HashtableS hS = (HashtableS) registry.lookup("HashtableWithListOfString");
        /* Hashtable With List Of Integer*/
        HashtableS hI = (HashtableS) registry.lookup("HashtableWithListOfInteger");
        /* Hashtable With List Of Float*/
        HashtableS hF = (HashtableS) registry.lookup("HashtableWithListOfFloat");
        /* Hashtable With List Of Double*/
        HashtableS hD = (HashtableS) registry.lookup("HashtableWithListOfDouble");
   Pour la manipulation des hashtables,l'utilisateur doit utiliser les fonctionnalitées de structures spécialisées citées au dessus.         
 
 
 Feedback:
   - bonne pratique des tests junit, utilisation de Maven, Travis(intégration continue), Eclemma(couverture de tests)
   - utilisation de git
   - pour évoluer le projet, il faut plus de temps: par exemple au lieu d'utiliser les arraylist déja implémentées , on implémente notre propre structure de list 
 