package co.uan.edu.sistemas.example.api;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "data", path = "data")
public interface DataRepository extends CrudRepository<Data, Long> {

    List<Data> findByName(@Param("name") String name);

    Data findById(long id);

}
