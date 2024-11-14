package tp5;

public class LotissementPrivee extends Lotissement {

    public LotissementPrivee(int capacite) {
        super(capacite);
    }

    @Override
    public boolean ajouter(Propriete p) {
        if (p instanceof ProprietePrivee) {
            return super.ajouter(p);
        } else {
            System.out.println("Erreur : Seules les propriétés privées peuvent être ajoutées au LotissementPrivee.");
            return false;
        }
    }

    @Override
    public ProprietePrivee getProprieteByIndice(int i) {
        if (i >= 0 && i < nombre && tabProp[i] instanceof ProprietePrivee) {
            return (ProprietePrivee) tabProp[i];
        } else {
            System.out.println("Indice invalide ou la propriété n'est pas privée.");
            return null;
        }
    }

    @Override
    public int getnbPieces() {
        int totalPieces = 0;
        for (int i = 0; i < nombre; i++) {
            if (tabProp[i] instanceof ProprietePrivee) {
                totalPieces += ((ProprietePrivee) tabProp[i]).getNbPieces();
            }
        }
        return totalPieces;
    }
}
