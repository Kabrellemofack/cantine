package cantine.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;

import cantine.data.Plat;
import cantine.data.TypePlat;

public interface DaoPlat extends CrudRepository<Plat, Long>, PagingAndSortingRepository<Plat, Long> {
	
	Page<Plat> findByNomContaining( String search, Pageable pageable );
	@Query( "SELECT COUNT(*) FROM plat WHERE id_type_plat = :idTypePlat")
	long  compterPourIdTypePlat(@Param("idTypePlat") Long idTypePlat);
}