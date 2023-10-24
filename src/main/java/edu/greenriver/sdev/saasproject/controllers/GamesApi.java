/**
 *  GamesAPI Class. This is a REST  controller class. it defines endpoints to access & update model objects through a
 *  service layer. Get,Post,Put, and delete HTTP verb are supported on each endpoint. HTTP end points have error handling
 *  and appropriate HTTP status code.
 * @author zhenhuai zeng
 * @version Java 21
 * Date: 10/23/2023
 */
package edu.greenriver.sdev.saasproject.controllers;
import edu.greenriver.sdev.saasproject.models.BehaviorName;
import edu.greenriver.sdev.saasproject.models.Games;
import edu.greenriver.sdev.saasproject.services.BehaviorService;
import edu.greenriver.sdev.saasproject.services.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class GamesApi
{
    private final GameService service;
    private final BehaviorService serviceOne;
    /**
     * @param service user gameservice as a parameter.
     * @param serviceOne use BehaviorService as a parameter.
     */
    public GamesApi(GameService service, BehaviorService serviceOne)
    {
        this.service = service;
        this.serviceOne = serviceOne;
    }

    /**
     *
     * @return ResponseEntity
     * Retrieves all games
     * 200 (OK) - all games found and returned.
     */

    @GetMapping("games")
    public ResponseEntity<List<Games>> allGames()
    {
        return new ResponseEntity<>(service.getAllGames(), HttpStatus.OK);
    }
    /**
     *
     * @return ResponseEntity
     * 201(Created) - game was created successfully
     * 400 (BAD REQUEST) - No game created, one of the fields was empty.
     * Adds a new game object.
     */
    @PostMapping("games/add")
    public ResponseEntity<Games> addGame(@RequestBody Games game)
    {
        if(game.getName() == null || game.getId() < 0 || game.getDevelopers() == null
        || game.getGenres() == null || game.getPlatforms() == null)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
            return new ResponseEntity<>(service.addGame(game),HttpStatus.CREATED);
    }
    /**
     *
     * @return ResponseEntity
     * 200 (OK) - Game found and returned
     * 404 (NOT FOUND) - Game not found.
     * Retrieves a game that matches the path variable id.
     */
    @GetMapping("games/{gameId}")  //localhost:8080/games/3
    public ResponseEntity<Games> getGameById(@PathVariable int gameId)
    {
        if(service.GameExistById(gameId))
        {
            return new ResponseEntity<>(service.getGamesById(gameId),HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    /**
     *
     * @return ResponseEntity
     * 201 (CREATED) - Game was edited successfully
     * 400 (BAD REQUEST) - No game created, ID doesn't exist.
     * Edit a game object.
     */
    @PutMapping("editGames")
    public ResponseEntity<Games> updatesaGameByID(@RequestBody Games game)
    {
        if(service.GameExistById(game.getId()))
        {
            return new ResponseEntity<>(service.updateGameById(game),HttpStatus.CREATED);
        }
       return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    /**
     * @return ResponseEntity
     * 204 (NO CONTENT) A game object is removed successfully.
     * 404 (NOT FOUND) Can find the object that you are trying to delete.
     * Delete a game object that matches the variable id.
     */
    @DeleteMapping("deleteGames")
    public ResponseEntity<Games> deleteGameById(@RequestBody Games name)
    {
        if(service.GameExistById(name.getId()))
        {
            service.deleteGame(name.getId());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * @return ResponseEntity
     * 200 (OK) - all behaviors found and returned.
     * Retrieves all behaviors
     */
    @GetMapping("behavior")
    public ResponseEntity<List<BehaviorName>> allBehavior()
    {
        return new ResponseEntity<>(serviceOne.getAllBehavior(), HttpStatus.OK);
    }


    /**
     * @return ResponseEntity
     * 201(Created) - behavior was created successfully
     * 400 (BAD REQUEST) - No behavior created, one of the fields was empty.
     * Adds a new behavior object. Here is an example of a request body.
     */
    @PostMapping("behavior/add")
    public ResponseEntity<BehaviorName> addBehavior(@RequestBody BehaviorName behavior)
    {
        if(behavior.getName() == null || behavior.getId() < 0 || behavior.getHoursplayedaverage() < 0
                || behavior.getPrice() < 0  || behavior.getPurchase() == null)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(serviceOne.addBehavior(behavior),HttpStatus.CREATED);
    }


    /**
     * @return ResponseEntity
     * 200 (OK) - behavior found and returned
     * 200 (OK) - behavior found and returned
     * Retrieves a behavior that matches the path variable id.
     */
    @GetMapping("behavior/{behaviorName}")
    public ResponseEntity<BehaviorName> getBehaviorByName(@PathVariable String behaviorName)
    {
        if(serviceOne.behaviorExistsByName(behaviorName))
        {
            return new ResponseEntity<>(serviceOne.getBehaviorByName(behaviorName),HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * @return ResponseEntity
     * 201 (CREATED) - behavior was edited successfully
     * 400 (BAD REQUEST) - No behavior created, ID doesn't exist.
     * Edit a behavior object. Here is an example of a request body.
     */
    @PutMapping("behaviors")
    public ResponseEntity<BehaviorName> updatesBehaviorByName(@RequestBody BehaviorName behavior)
    {
        if(serviceOne.behaviorExistsByName(behavior.getName()))
        {
            return new ResponseEntity<>(serviceOne.updateBehaviorByName(behavior),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * @return ResponseEntity
     * 204 (NO CONTENT) A behavior object is removed successfully.
     * 404 (NOT FOUND) Can find the behavior object that you are trying to delete.
     * Delete a behavior object that matches the variable id.
     */
    @DeleteMapping("behaviorsDelete")
    public ResponseEntity<BehaviorName> deleteJoke(@RequestBody BehaviorName behaviorName)
    {

        if(serviceOne.behaviorExistsByName(behaviorName.getName()))
        {
            serviceOne.deleteBehaviorByName(behaviorName.getName());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
