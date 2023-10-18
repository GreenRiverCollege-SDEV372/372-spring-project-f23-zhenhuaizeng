package edu.greenriver.sdev.saasproject.db;


import edu.greenriver.sdev.saasproject.models.BehaviorName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BehaviorRepository extends JpaRepository<BehaviorName, Integer>
{

}
