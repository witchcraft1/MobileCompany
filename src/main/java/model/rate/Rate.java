package model.rate;

import model.RateMultipliers;

public abstract class Rate implements RateMultipliers {
    private int costPerMonth; // розмір абонентської плат
    private int sms;
    private int clientCount;
    private String name;

    Rate(int sms, int clientCount, String name){
        this.sms = sms;
        this.clientCount = clientCount;
        this.name = name;
    }

    abstract int calculateMonthlyCost();

    public int getCostPerMonth() {
        return costPerMonth;
    }

    public void setCostPerMonth(int costPerMonth) {
        this.costPerMonth = costPerMonth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSms() {
        return sms;
    }

    public void setSms(int sms) {
        this.sms = sms;
    }

    public int getClientCount(){
        return clientCount;
    }

    public void setClientCount(int clientCount){
        this.clientCount = clientCount;
    }

    @Override
    public String toString(){
        return "%s -- " + name + ":\n %s: " + costPerMonth + ", %s: " + sms + ", %s: " + clientCount ;
    }
}
