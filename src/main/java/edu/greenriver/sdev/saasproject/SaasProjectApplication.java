
/**
 *  Saasproejctapplication Class
 *
 * @author zhenhuai zeng
 * @version Java 21
 * Date: 10/12/2023
 */

package edu.greenriver.sdev.saasproject;

import edu.greenriver.sdev.saasproject.db.GamesRepository;
import edu.greenriver.sdev.saasproject.models.Games;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SaasProjectApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SaasProjectApplication.class, args);
        GamesRepository repo = context.getBean(GamesRepository.class);

        List<Games> games = new ArrayList<>(List.of(
                new Games("Fornite","Third-person shooter","Xbox Cloud Gaming, Xbox One","Epic Games, People Can Fly"),
                new Games("The Elder Scrolls V: Skyrim","action role-playing"," Nintendo Switch, PlayStation 4, Xbox One, PlayStation 5,",
                        "Bethesda Game Studios"),
                new Games("Fallout 4","First-person shooter, Survival horror","PlayStation 5, PlayStation 4, Xbox One, Microsoft Windows, Xbox Series X and Series S, Xbox Cloud Gaming"
                ,"Bethesda Game Studios"),
                new Games("Left 4 Dead 2"," co-operative action horror FPS","Microsoft Windows","Valve")
        ));



        //add all games
        repo.saveAll(games);
    }

}
