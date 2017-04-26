# PROJET-DevOps
Projet: On a deux parties
  -Partie client: le client a la possibilit�e d'utiliser hashtable avec cl� String avec �l�ments de type ArrayList( Integer, float, double, String).
  -Partie serveur: On a impl�ment� dans le serveur un ensemble de fonctions qui g�rent la structure hastable(cl�, valeur). Pour les valeurs, on peut avoir des structures g�n�riques.
    fonctions:
       * r�cup�rer l'�l�ment de la  cl� pass�e en parametres
           -structrures g�n�riques: getValue(String Key)
           -structure sp�cialis�e ArrayList: getValueListIndex(K key,int index): r�cup�rer la valeur de l'indice(int index) de l'arrayList( valeur de la cl�(K key) pass�e en parametres)   
       *modifier l'�lement de la cl�:
           -structures g�n�riques: setValue(String key, V valeur)
           -structure sp�cialis�e ArrayList: setValueListIndex(K key, int index,E value): modifier � l'indice(int index) de l'arrayList( valeur de la cl�(K key) pass�e en parametres) par la nouvelle valeur (value) pass�e en parametres   
       * tester si hashtable contient la cl� pass�e en parametres: containsKey(K key)
       * tester si hashtable contient l'�l�ment pass� en parametres:
           -structures g�n�riques: containsValue(V value)
           -structure sp�cialis�e ArrayList: containsValueInList(K key,E value): tester si l'arrayList contient la valeur pass�e en parametres
       * Chercher l'indice de l'�lement pass� en parametres  dans l'arraylist : indexValueInList(K key,E value)
       * Ajouter une valeur � l'�l�ment pass� en parametres
           -structures g�n�riques: addValue(K key,Object val)
           -structure sp�cialis�e ArrayList: addValue(K key,int index,E val): ajouter la valeur pass�e en arguments dans l'indice (index) de l'ArrayList 
       *incrementer l'�l�ment de hashtable
          -structures g�n�riques: incrementer (K key): incr�menter la cl� passer en parametres
          -structure sp�cialis�e ArrayList: incrementer(K key,int index): incr�menter l'indice(int index) de l'arrayList( valeur de la cl�(K key) passer en parametres)  
       *decrementer l'element de hashtable
          -structures g�n�riques: decrementer (K key): d�cr�menter la cl� passer en parametres
          -structure sp�cialis�e ArrayList: decrementer(K key,int index): d�cr�menter l'indice(int index) de l'arrayList( valeur de la cl�(K key) passer en parametres)
       * Ajouter un �lement dans hashtable
          -structures g�n�riques: addElement(K key, V value): ajouter l'element de la cl� pass�e en parametres
          -structure sp�cialis�e ArrayList: addElementInList(K key, E value): ajouter � l'indice(int index) de l'arrayList( valeur de la cl�(K key) pass�e en parametres) un nouveau element. 
       *supprimer un �lement de hashtable
          -structures g�n�riques:  removeElement(K key): supprimer l'element de la cl� pass�e en parametres
          -structure sp�cialis�e ArrayList: removeElementListIndex(K key, int index): supprimer l'element de l'indice(int index) de l'arrayList( valeur de la cl�(K key) pass�e en parametres).
      
       
Pour lancer le projet:
    - il faut lancer:
              - la commande rmiregister & pour activer le RMI.
              - le serveur(classe ServerRMI.java)
              - le client en passant par arguments le nom du serveur(adresse)
    -Pour installer maven: mvn install.
    -Pour lancer les tests: mvn test.
    -le projet est test� par travis.
    -Pour savoir la couverture des tests dans le code: mvn emma:emma avec updates Snapshots
      on a obtenu 75% de couverture dont 7 m�thodes non test�s car:
        -2 m�thodes pour le client
        -2 m�thodes d'�xceptions qui sont d�ja test�es dans les tests de l'impl�mentation du table de hashage
        -3 m�thodes dont 2 m�thodes sont dans la classe qui fournie la  connexion entre le serveur et le client et la 3eme m�thode pour sayHello() 
 
Guide utilisateur: 
    L'utilisateur doit �tablir la connexion vers le serveur et r�cup�rer les objets de hashtable fournit par le serveur:
        Registry registry = LocateRegistry.getRegistry(serverName);
        /* Hashtable With List Of String*/
        HashtableS hS = (HashtableS) registry.lookup("HashtableWithListOfString");
        /* Hashtable With List Of Integer*/
        HashtableS hI = (HashtableS) registry.lookup("HashtableWithListOfInteger");
        /* Hashtable With List Of Float*/
        HashtableS hF = (HashtableS) registry.lookup("HashtableWithListOfFloat");
        /* Hashtable With List Of Double*/
        HashtableS hD = (HashtableS) registry.lookup("HashtableWithListOfDouble");
   Pour la manipulation des hashtables,l'utilisateur doit utiliser les fonctionnalit�es de structures sp�cialis�es cit�es au dessus.         
 
 
 Feedback:
   - bonne pratique des tests junit, utilisation de Maven, Travis(int�gration continue), Eclemma(couverture de tests)
   - utilisation de git
   - pour �voluer le projet, il faut plus de temps: par exemple au lieu d'utiliser les arraylist d�ja impl�ment�es , on impl�mente notre propre structure de list 
 