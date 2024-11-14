package tp5;

public class Fiscalite {

    public static void main(String[] args) {
        Personne p1 = new Personne(1, "Dupont", "Jean");
        Personne p2 = new Personne(2, "Martin", "Sophie");
        Personne p3 = new Personne(3, "Lefevre", "Alex");

        Lotissement lotissement = new Lotissement(10);

        lotissement.ajouter(new ProprietePrivee(1, p1, "Corniche", 350, 4));
        lotissement.ajouter(new Villa(2, p2, "Dar Chaabane", 400, 6, true));
        lotissement.ajouter(new Appartement(3, p2, "Hammamet", 1200, 8, 3));
        lotissement.ajouter(new ProprieteProfessionnelle(4, p3, "Korba", 1000, 50, true));
        lotissement.ajouter(new ProprieteProfessionnelle(5, p1, "Bir Bouragba", 2500, 400, false));

        System.out.println("Informations sur les propriétés du lotissement :");
        for (int i = 0; i < lotissement.nombre; i++) {
            Propriete propriete = lotissement.getProprieteByIndice(i);
            System.out.println(propriete.toString() + ", Impôts à payer: " + propriete.calculImpot() + " DT");
        }

        System.out.println("\nNombre global de pièces dans les propriétés privées : " + lotissement.getnbPieces());

        ProprietePrivee proprieteMin = null;
        double minImpot = Double.MAX_VALUE;

        for (int i = 0; i < lotissement.nombre; i++) {
            if (lotissement.getProprieteByIndice(i) instanceof ProprietePrivee) {
                ProprietePrivee proprietePrivee = (ProprietePrivee) lotissement.getProprieteByIndice(i);
                double impot = proprietePrivee.calculImpot();
                if (impot < minImpot) {
                    minImpot = impot;
                    proprieteMin = proprietePrivee;
                }
            }
        }

        if (proprieteMin != null) {
            System.out.println("\nPropriété privée avec le moins d’impôts :");
            System.out.println("Propriétaire : " + proprieteMin.getResponsable());
            System.out.println("Montant des impôts : " + minImpot + " DT");
        }
        System.out.println("\nSuppression de l'appartement de Hammamet...");
        Propriete appartementHammamet = new Appartement(3, p2, "Hammamet", 1200, 8, 3);
        lotissement.supprimer(appartementHammamet);

        System.out.println("\nListe des propriétés après suppression de l'appartement de Hammamet :");
        lotissement.afficherProprietes();

        System.out.println("\nCréation d'un LotissementPrivée :");
        LotissementPrivee lotissementPrivee = new LotissementPrivee(10);

        lotissementPrivee.ajouter(new ProprietePrivee(6, p1, "Centre Ville", 500, 5));
        lotissementPrivee.ajouter(new Villa(7, p2, "Sidi Bou Said", 450, 7, false));
        lotissementPrivee.ajouter(new Appartement(8, p3, "La Marsa", 200, 3, 2));

        System.out.println("\nListe des propriétés dans le LotissementPrivée :");
        lotissementPrivee.afficherProprietes();

        System.out.println("\nNombre total de pièces dans le LotissementPrivée : " + lotissementPrivee.getnbPieces());
    }
}

