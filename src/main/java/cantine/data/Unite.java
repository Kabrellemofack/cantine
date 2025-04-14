package cantine.data;

import org.springframework.data.annotation.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of="Id_unite")
public class Unite {
	@Id
	private Long Id_unite; 
	private String Nom ; 
	private String Abrev; 
	
	

}
