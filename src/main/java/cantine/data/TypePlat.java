package cantine.data;

import java.util.Objects;

import org.springframework.data.annotation.Id;

public class TypePlat {

	// -------
	// Champs
	// -------

	@Id
	private Long	idTypePlat;
	private String	nom;
	private int		rang;

	// -------
	// Getters & Setters
	// -------

	public Long getIdTypePlat() {
		return idTypePlat;
	}

	public void setIdTypePlat( Long idTypePlat ) {
		this.idTypePlat = idTypePlat;
	}

	public String getNom() {
		return nom;
	}

	public void setNom( String nom ) {
		this.nom = nom;
	}

	public int getRang() {
		return rang;
	}

	public void setRang( int rang ) {
		this.rang = rang;
	}

	// -------
	// equals() & hashCode()
	// -------

	@Override
	public boolean equals( Object obj ) {
		if ( this == obj )
			return true;
		if ( obj == null )
			return false;
		if ( getClass() != obj.getClass() )
			return false;
		TypePlat other = (TypePlat) obj;
		return Objects.equals( idTypePlat, other.idTypePlat );
	}

	@Override
	public int hashCode() {
		return Objects.hash( idTypePlat );
	}

}
