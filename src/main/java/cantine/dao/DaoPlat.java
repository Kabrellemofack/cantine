package cantine.dao;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.lang.NonNull;

import cantine.data.Plat;
import cantine.data.TypePlat;

public interface DaoPlat extends CrudRepository<Plat, Long>, PagingAndSortingRepository<Plat, Long> {
	@Query("SELECT * FROM TypePlat ORDER BY idTypePlat DESC ")
	@NonNull Iterable<TypePlat> findAll();
}
