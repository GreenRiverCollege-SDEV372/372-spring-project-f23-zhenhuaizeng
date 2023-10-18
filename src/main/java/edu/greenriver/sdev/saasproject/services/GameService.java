package edu.greenriver.sdev.saasproject.services;

import edu.greenriver.sdev.saasproject.db.BehaviorRepository;
import edu.greenriver.sdev.saasproject.db.GamesRepository;
import edu.greenriver.sdev.saasproject.models.BehaviorName;
import edu.greenriver.sdev.saasproject.models.Games;

import java.util.List;
import java.util.Optional;

public class GameService
{
    private GamesRepository repo;
    private BehaviorRepository repoOne;

    public GameService(GamesRepository repo)
    {
        this.repo = repo;
    }
    public GameService(BehaviorRepository repoOne)
    {
        this.repoOne = repoOne;
    }
    public List<Games> getAllGames()
    {
        return repo.findAll();
    }
    public List<BehaviorName> getAllBehavior()
    {
        return repoOne.findAll();
    }
    public Games getGamesById(int id)
    {
        Optional<Games> found = repo.findById(id);
        return found.orElse(null);
    }
    public BehaviorName getBehaviorById(int id)
    {
        Optional<BehaviorName> found = repoOne.findById(id);
        return found.orElse(null);
    }
    public Games addGame(Games games)
    {
        games = repo.save(games);
        //returning the joke with new id
        return games;
    }
    public BehaviorName addBehavior(BehaviorName bahavior)
    {
        bahavior = repoOne.save(bahavior);

        //returning the joke with new id
        return bahavior;
    }
    public Games updateGame(Games updatedgame)
    {
        Games savedgame = getGamesById(updatedgame.getId());
        savedgame.setName(updatedgame.getName());
        savedgame = repo.save(savedgame);

        return savedgame;
    }
    public BehaviorName Behavior(BehaviorName updatedbehavior)
    {
        BehaviorName savedBehavior = getBehaviorById(updatedbehavior.getId());
        savedBehavior.setName(updatedbehavior.getName());
        savedBehavior = repoOne.save(savedBehavior);
        return savedBehavior;
    }

    public void deleteGame(int id)
    {
        repo.deleteById(id);
    }
    public void deleteBehavior(int id)
    {
        repoOne.deleteById(id);
    }

}
