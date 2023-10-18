package edu.greenriver.sdev.saasproject.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;


@Getter
@Entity
@Data
@NoArgsConstructor
public class BehaviorName
{

    @jakarta.persistence.Id
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;
    Boolean purchase;
    String name;
    double price;
    double hoursplayedaverage;

    public BehaviorName(Boolean purchase, String name, double price, double hoursplayedaverage) {
        this.name = name;
        this.purchase = purchase;
        this.price = price;
        this.hoursplayedaverage = hoursplayedaverage;
    }

    public int getId() {
        return id;
    }

    public Boolean getPurchase() {
        return purchase;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getHoursplayedaverage() {
        return hoursplayedaverage;
    }

    public void setPurchase(Boolean purchase) {
        this.purchase = purchase;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double percentage) {
        this.price = percentage;
    }

    public void setHoursplayedaverage(double hoursplayed) {
        this.hoursplayedaverage = hoursplayed;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "BehaviorName{" +
                "purchase=" + purchase +
                ", name=" + name +
                ", percentage=" + price +
                ", hoursplayed=" + hoursplayedaverage +
                '}';
    }

}
