package cantine.data;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode( of = { "idPlat" } )
public class Plat {

    @Transient
	private TypePlat typePlat;

	// -------
	// Champs
	// -------

	@Id
	private Long		idPlat;
	private String		nom;
	private int			nbPersonnes;
	private BigDecimal	cout;
	private Long		idTypePlat;

}
