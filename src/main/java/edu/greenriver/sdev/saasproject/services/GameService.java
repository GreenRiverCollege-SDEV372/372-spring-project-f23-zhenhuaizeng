package edu.greenriver.sdev.saasproject.services;

/**
 * This is GameService class. this class is written that allow access to model objects. Create, Read, Update, and
 * Delete operations can be performed through methods in this class.
 * @author zhenhuai zeng
 * @version Java 21
 * Date: 10/23/2023
 */



import edu.greenriver.sdev.saasproject.db.GamesRepository;
import edu.greenriver.sdev.saasproject.models.Games;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class GameService
{
    private final GamesRepository repo;

    /**
     *  This constructor takes one parameter and use it for the methods below.
     * @param repo repo
     */
    public GameService(GamesRepository repo)
    {
        this.repo = repo;
    }

    /**
     *  This method fetch data from database.
     * @return all games
     */
    public List<Games> getAllGames()
    {
        return repo.findAll();
    }

    /**
     * This method retrieve a datum from database by looking it id.
     * @param id id
     * @return a game object
     */
    public Games getGamesById(int id)
    {
        Optional<Games> found = repo.findById(id);
        return found.orElse(null);
    }

    /**
     * This method adds a game to the database.
     * @param games games
     * @return newly added game
     */
    public Games addGame(Games games)
    {
        games = repo.save(games);
        //returning the joke with new id
        return games;
    }

    /**
     * This method update a game object by its ID.
     * @param updatedgame updatedgame
     * @return an updated game
     */
    public Games updateGameById(Games updatedgame)
    {
        Games savedgame = getGamesById(updatedgame.getId());
        savedgame.setName(updatedgame.getName());
        savedgame.setDevelopers(updatedgame.getDevelopers());
        savedgame.setGenres(updatedgame.getGenres());
        savedgame.setPlatforms(updatedgame.getPlatforms());
        savedgame = repo.save(savedgame);

        return savedgame;
    }

    /**
     * this method delete a game by its ID
     * @param id id
     */
    public void deleteGame(int id)
    {
        repo.deleteById(id);
    }

    /**
     * This method checks to see if the game can be found by its ID.
     * @param id id
     * @return true if the id exists, otherwise, false.
     */
    public boolean GameExistById(int id)
    {
        return repo.findById(id).isPresent();
    }

}
