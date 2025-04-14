package cantine.data;

import java.math.BigDecimal;

import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode( of = { "idIngredient" } )
public class Ingredient {
	
	private int idIngredient;
	private String nom;
	private BigDecimal quantiteStock;
	private BigDecimal prixUnitaire;
	private boolean perissable;
	private String stockage;
	
	 @Column(value = "idUnite")
	    private Integer idUnite;
	 @Transient
	  private Unite unite;

}
