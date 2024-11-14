package tp5;

import java.util.Objects;

public abstract class Propriete {
    protected int id;
    protected Personne responsable;
    protected String adresse;
    protected double surface;
	public Propriete(int id, Personne responsable, String adresse, double surface) {
		this.id = id;
		this.responsable = responsable;
		this.adresse = adresse;
		this.surface = surface;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Personne getResponsable() {
		return responsable;
	}
	public void setResponsable(Personne responsable) {
		this.responsable = responsable;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public double getSurface() {
		return surface;
	}
	public void setSurface(double surface) {
		this.surface = surface;
	}
	@Override
	public String toString() {
		return "Propriete [id=" + id + ", responsable=" + responsable + ", adresse=" + adresse + ", surface=" + surface
				+ "]";
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Propriete other = (Propriete) obj;
		return Objects.equals(adresse, other.adresse) && id == other.id
				&& Objects.equals(responsable, other.responsable)
				&& Double.doubleToLongBits(surface) == Double.doubleToLongBits(other.surface);
	}
	public abstract double calculImpot();

    
    
}

