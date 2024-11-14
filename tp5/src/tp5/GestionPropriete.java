package tp5;

public interface GestionPropriete {
    int MAX_PROPRIETES = 10;
    void afficherProprietes();
    boolean ajouter(Propriete p);
    boolean supprimer(Propriete p);
}

