package edu.greenriver.sdev.saasproject.models;

import org.yaml.snakeyaml.events.Event;

public class BehaviorName
{
    private int id;
    Boolean purchase;
    Boolean play;
    int percentage;

    int hoursplayed;

    public BehaviorName(Boolean purchase, Boolean play, int percentage, int hoursplayed) {
        this.purchase = purchase;
        this.play = play;
        this.percentage = percentage;
        this.hoursplayed = hoursplayed;
    }

    public Boolean getPurchase() {
        return purchase;
    }

    public Boolean getPlay() {
        return play;
    }

    public int getPercentage() {
        return percentage;
    }

    public int getHoursplayed() {
        return hoursplayed;
    }

    public void setPurchase(Boolean purchase) {
        this.purchase = purchase;
    }

    public void setPlay(Boolean play) {
        this.play = play;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public void setHoursplayed(int hoursplayed) {
        this.hoursplayed = hoursplayed;
    }

    @Override
    public String toString() {
        return "BehaviorName{" +
                "purchase=" + purchase +
                ", play=" + play +
                ", percentage=" + percentage +
                ", hoursplayed=" + hoursplayed +
                '}';
    }
}
