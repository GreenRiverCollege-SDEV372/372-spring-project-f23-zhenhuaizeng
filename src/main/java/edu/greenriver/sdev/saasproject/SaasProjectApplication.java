
/*
 *  Saasproejctapplication Class
 *
 * @author zhenhuai zeng
 * @version Java 21
 * Date: 10/12/2023
 */

package edu.greenriver.sdev.saasproject;

import edu.greenriver.sdev.saasproject.db.BehaviorRepository;
import edu.greenriver.sdev.saasproject.db.GamesRepository;
import edu.greenriver.sdev.saasproject.models.BehaviorName;
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
        BehaviorRepository repoOne = context.getBean(BehaviorRepository.class);
        List<Games> games = new ArrayList<>(List.of(
                new Games("Fornite","Third-person shooter","Xbox Cloud Gaming, Xbox One","Epic Games, People Can Fly"),
                new Games("The Elder Scrolls V: Skyrim","action role-playing"," Nintendo Switch, PlayStation 4, Xbox One, PlayStation 5,",
                        "Bethesda Game Studios"),
                new Games("Fallout 4","First-person shooter, Survival horror","PlayStation 5, PlayStation 4, Xbox One, Microsoft Windows, Xbox Series X and Series S, Xbox Cloud Gaming"
                ,"Bethesda Game Studios"),
                new Games("Left 4 Dead 2"," co-operative action horror FPS","Microsoft Windows","Valve")
        ));


        List<BehaviorName> behavior = new ArrayList<>(List.of(
                new BehaviorName(false,"Path of Exile",0,8.1),
        new BehaviorName(true,"Poly Bridge",9.99,7.5),
        new BehaviorName(false,"Team Fortress 2",0,2.8),
        new BehaviorName(false,"Grand Theft Auto IV",39.98,0.6),
        new BehaviorName(false,"Realm of the Mad God",0,0.5),
        new BehaviorName(false,"Dota 2",0,0.5)
        ));
        //add all games
        repo.saveAll(games);
        repoOne.saveAll(behavior);
    }

}
