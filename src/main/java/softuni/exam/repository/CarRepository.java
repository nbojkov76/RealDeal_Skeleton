package softuni.exam.repository;

import com.fasterxml.jackson.databind.ser.std.NumberSerializers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Car;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
@Query("SELECT c FROM Car c ORDER BY SIZE(c.pictures) DESC, c.make")
    List<Car> findAllByCarsOrderByPicturesCountThanByMake();



}
