package tp5;

public class Lotissement implements GestionPropriete {
    protected Propriete[] tabProp;
    protected int nombre;

    public Lotissement(int capacite) {
        tabProp = new Propriete[capacite];
        nombre = 0;
    }

    public boolean ajouter(Propriete p) {
        if (nombre < tabProp.length) {
            tabProp[nombre++] = p;
            return true;
        }
        return false;
    }

    public boolean supprimer(Propriete p) {
        for (int i = 0; i < nombre; i++) {
            if (tabProp[i].equals(p)) {
                tabProp[i] = tabProp[--nombre];
                tabProp[nombre] = null;
                return true;
            }
        }
        return false;
    }

    public void afficherProprietes() {
        for (int i = 0; i < nombre; i++) {
            System.out.println(tabProp[i].toString());
        }
    }

    public int getnbPieces() {
        int totalPieces = 0;
        for (int i = 0; i < nombre; i++) {
            if (tabProp[i] instanceof ProprietePrivee) {
                totalPieces += ((ProprietePrivee) tabProp[i]).getNbPieces();
            }
        }
        return totalPieces;
    }
    public Propriete getProprieteByIndice(int i) {
        if (i >= 0 && i < nombre) {
            return tabProp[i];
        } else {
            System.out.println("Indice invalide : " + i);
            return null;
        }
    }

}

