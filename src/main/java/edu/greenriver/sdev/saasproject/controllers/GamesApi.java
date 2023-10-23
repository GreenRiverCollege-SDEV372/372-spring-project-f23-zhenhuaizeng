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
    private GameService service;
    private BehaviorService serviceOne;
    public GamesApi(GameService service, BehaviorService serviceOne)
    {
        this.service = service;
        this.serviceOne = serviceOne;
    }

    @GetMapping("games")
    public ResponseEntity<List<Games>> allGames()
    {
        return new ResponseEntity<>(service.getAllGames(), HttpStatus.OK);
    }

    @PostMapping("games/add")
    public ResponseEntity<Games> addGame(@RequestBody Games game)
    {
            return new ResponseEntity<>(service.addGame(game),HttpStatus.CREATED);
    }

    @GetMapping("games/{gameId}")  //localhost:8080/games/3
    public ResponseEntity<Games> getGameById(@PathVariable int gameId)
    {
        if(service.GameExistById(gameId))
        {
            return new ResponseEntity<>(service.getGamesById(gameId),HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PutMapping("games/{gameId}")
    public ResponseEntity<Games> updatesaGameByID(@PathVariable int gameId)
    {
        if(service.GameExistById(gameId))
        {
            return new ResponseEntity<>(service.updateGameById(service.getGamesById(gameId)),HttpStatus.CREATED);
        }
       return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("games/delete/{gameId}")
    public ResponseEntity<Games> deleteGameById(@PathVariable int gameId)
    {
        if(service.GameExistById(gameId))
        {
            service.deleteGame(gameId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @GetMapping("behavior")
    public ResponseEntity<List<BehaviorName>> allBehavior()
    {
        return new ResponseEntity<>(serviceOne.getAllBehavior(), HttpStatus.OK);
    }

    @PostMapping("behavior/add")
    public ResponseEntity<BehaviorName> addBehavior(@RequestBody BehaviorName behavior)
    {
        return new ResponseEntity<>(serviceOne.addBehavior(behavior),HttpStatus.CREATED);
    }

    @GetMapping("behavior/{behaviorName}")
    public ResponseEntity<BehaviorName> getBehaviorById(@PathVariable String behaviorName)
    {
        if(serviceOne.behaviorExistsByName(behaviorName))
        {
            return new ResponseEntity<>(serviceOne.getBehaviorByName(behaviorName),HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("behaviors")
    public ResponseEntity<BehaviorName> updatesBehaviorByName(@RequestBody BehaviorName behavior)
    {
        if(serviceOne.behaviorExistsByName(behavior.getName()))
        {
            return new ResponseEntity<>(serviceOne.updateBehaviorByName(behavior),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

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
