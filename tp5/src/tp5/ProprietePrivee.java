package tp5;

public class ProprietePrivee extends Propriete {
    private int nbPieces;

    public ProprietePrivee(int id, Personne responsable, String adresse, double surface, int nbPieces) {
        super(id, responsable, adresse, surface);
        this.nbPieces = nbPieces;
    }


	@Override
    public double calculImpot() {
        return (50 * surface / 100) + (10 * nbPieces);
    }


	public int getNbPieces() {
		return nbPieces;
	}


	
}

