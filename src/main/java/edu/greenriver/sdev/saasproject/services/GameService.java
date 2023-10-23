package edu.greenriver.sdev.saasproject.services;

import edu.greenriver.sdev.saasproject.db.BehaviorRepository;
import edu.greenriver.sdev.saasproject.db.GamesRepository;
import edu.greenriver.sdev.saasproject.models.BehaviorName;
import edu.greenriver.sdev.saasproject.models.Games;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class GameService
{
    private GamesRepository repo;

    public GameService(GamesRepository repo)
    {
        this.repo = repo;
    }

    public List<Games> getAllGames()
    {
        return repo.findAll();
    }

    public Games getGamesById(int id)
    {
        Optional<Games> found = repo.findById(id);
        return found.orElse(null);
    }


    public Games addGame(Games games)
    {
        games = repo.save(games);
        //returning the joke with new id
        return games;
    }

    public Games updateGame(Games updatedgame)
    {
        Games savedgame = getGamesById(updatedgame.getId());
        savedgame.setName(updatedgame.getName());
        savedgame = repo.save(savedgame);

        return savedgame;
    }

    public void deleteGame(int id)
    {
        repo.deleteById(id);
    }


}
