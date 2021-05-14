package one.innovation.digital.Person.repository;


import one.innovation.digital.Person.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
