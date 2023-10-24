/**
 * This is BehaviorName class. it has five fields.
 * @author zhenhuai zeng
 * @version Java 21
 * Date: 10/23/2023
 */


package edu.greenriver.sdev.saasproject.models;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Entity
@Data
@NoArgsConstructor
public class BehaviorName
{

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;
    Boolean purchase;
    String name;
    double price;
    double hoursplayedaverage;

    /**
     *
     * @param purchase purchase
     * @param name name
     * @param price price
     * @param hoursplayedaverage hoursplayedaverage
     * This constructor takes 4 parameters.
     */
    public BehaviorName(Boolean purchase, String name, double price, double hoursplayedaverage) {
        this.name = name;
        this.purchase = purchase;
        this.price = price;
        this.hoursplayedaverage = hoursplayedaverage;
    }

}
