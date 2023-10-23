package edu.greenriver.sdev.saasproject.services;


import edu.greenriver.sdev.saasproject.db.BehaviorRepository;
import edu.greenriver.sdev.saasproject.models.BehaviorName;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BehaviorService
{
    private BehaviorRepository repoOne;

    public BehaviorService(BehaviorRepository repoOne)
    {
        this.repoOne = repoOne;
    }

    public List<BehaviorName> getAllBehavior()
    {
        return repoOne.findAll();
    }

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

    public BehaviorName updateBehaviorByName(BehaviorName name)
    {
        BehaviorName savedBehavior = getBehaviorByName(name.getName());
        savedBehavior.setPurchase(name.getPurchase());
        savedBehavior.setPrice(name.getPrice());
        savedBehavior.setHoursplayedaverage(name.getHoursplayedaverage());
        savedBehavior = repoOne.save(savedBehavior);
        return savedBehavior;
    }
    public BehaviorName addBehavior(BehaviorName bahavior)
    {
        bahavior = repoOne.save(bahavior);

        //returning the joke with new id
        return bahavior;
    }

    public void deleteBehaviorByName(String name)
    {
        BehaviorName behaviorName = getBehaviorByName(name);
        repoOne.delete(behaviorName);
    }

}
