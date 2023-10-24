/**
 * This is GamesRepository class
 * @author zhenhuai zeng
 * @version Java 21
 * Date: 10/23/2023
 */


package edu.greenriver.sdev.saasproject.db;

import edu.greenriver.sdev.saasproject.models.Games;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GamesRepository extends JpaRepository<Games, Integer> {

}
