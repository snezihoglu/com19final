package iaau.webapp;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;
@Repository
@EnableSwagger2
public interface DatalarRepository extends CrudRepository<Datalar, Integer> {

}
