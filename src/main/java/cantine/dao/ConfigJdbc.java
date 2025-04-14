package cantine.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.data.relational.core.mapping.event.AfterConvertCallback;

import cantine.data.Plat;


@Configuration 
public  class ConfigJdbc extends AbstractJdbcConfiguration {

	
	 @Bean
	 AfterConvertCallback<Plat> platAfterLoad(@Lazy DaoTypePlat daoTypePlat){
		 return ( plat ) ->{
			 plat.setTypePlat(
					 daoTypePlat.findById( plat.getIdTypePlat() ).get() );
					 return plat;
			 
		 };
	 }
}
