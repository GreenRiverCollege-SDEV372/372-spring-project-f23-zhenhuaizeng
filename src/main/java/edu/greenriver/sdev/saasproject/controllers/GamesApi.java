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
    public Games getGameById(@PathVariable int gameId)
    {
        return service.getGamesById(gameId);
    }

    //Change this to request body.
    @PutMapping("games/{gameId}")
    public ResponseEntity<Games> addGameById(@PathVariable int gameId)
    {
        return new ResponseEntity<>(service.updateGame(service.getGamesById(gameId)),HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("games/delete/{gameId}")
    public void deleteGameById(@PathVariable int gameId)
    {
        service.deleteGame(gameId);
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
    public BehaviorName getBehaviorById(@PathVariable String behaviorName)
    {
        return serviceOne.getBehaviorByName(behaviorName);
    }

    @PutMapping("behaviors")
    public BehaviorName updatesBehaviorByName(@RequestBody BehaviorName behavior)
    {
        return serviceOne.updateBehaviorByName(behavior);
    }

    @DeleteMapping("behaviorsDelete")
    public void deleteJoke(@RequestBody BehaviorName behaviorName)
    {
        serviceOne.deleteBehaviorByName(behaviorName.getName());
    }



}
