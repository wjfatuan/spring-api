package co.uan.edu.sistemas.example.api;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface DataRepository extends CrudRepository<Data,Long> {

    List<Data> findByName(String name);

    Data findById(long id);
    
}
