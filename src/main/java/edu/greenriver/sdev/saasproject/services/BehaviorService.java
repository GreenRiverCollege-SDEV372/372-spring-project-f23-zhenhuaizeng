/**
 * This is BehaviorService class. this class is written that allow access to model objects. Create, Read, Update, and
 * Delete operations can be performed through methods in this class.
 * @author zhenhuai zeng
 * @version Java 21
 * Date: 10/23/2023
 */




package edu.greenriver.sdev.saasproject.services;
import edu.greenriver.sdev.saasproject.db.BehaviorRepository;
import edu.greenriver.sdev.saasproject.models.BehaviorName;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BehaviorService
{
    private final BehaviorRepository repoOne;

    /**
     *  This constructor takes BehaviorRepository as a parameter
     * @param repoOne repoOne
     */
    public BehaviorService(BehaviorRepository repoOne)
    {
        this.repoOne = repoOne;
    }

    /**
     * This method fetch all the data from database
     * @return all the game from repoOne.
     */
    public List<BehaviorName> getAllBehavior()
    {
        return repoOne.findAll();
    }

    /**
     * This method check to see if the name that user put in is in the database.
     * @param name name
     * @return nam if the word exist, else return null.
     */
    public BehaviorName getBehaviorByName(String name)
    {
        for(BehaviorName nam : repoOne.findAll())
        {
            if(nam.getName().equals(name))
            {
                return nam;
            }
        }
        return null;
    }

    /**
     * This method update a behavior.
     * @param name name
     * @return updatedBehavior
     */
    public BehaviorName updateBehaviorByName(BehaviorName name)
    {
        BehaviorName savedBehavior = getBehaviorByName(name.getName());
        savedBehavior.setPurchase(name.getPurchase());
        savedBehavior.setPrice(name.getPrice());
        savedBehavior.setHoursplayedaverage(name.getHoursplayedaverage());
        savedBehavior = repoOne.save(savedBehavior);
        return savedBehavior;
    }

    /**
     *  This method adds a behavior to the database.
     *
     * @param bahavior behavior
     * @return saved hehavior
     */
    public BehaviorName addBehavior(BehaviorName bahavior)
    {
        bahavior = repoOne.save(bahavior);

        //returning the joke with new id
        return bahavior;
    }

    /**
     * This method delete a datum
     * @param name name
     */
    public void deleteBehaviorByName(String name)
    {
        BehaviorName behaviorName = getBehaviorByName(name);
        repoOne.delete(behaviorName);
    }

    /**
     * This method is checking the name that user put in to see if the name is in data.
     * @param name
     * @return
     */
    public boolean behaviorExistsByName(String name)
    {
        return getBehaviorByName(name) != null;
    }

}
