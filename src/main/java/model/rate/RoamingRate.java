package model.rate;

public class RoamingRate extends Rate{
    private double roamingMultiplier = 3;

    public RoamingRate(int sms, int clientCount, String name) {
        super(sms, clientCount, name);
    }

    /*public RoamingRate(int internet, int callsWithinNetwork, int callsToOtherNetwork, int sms, int clientCount){
        super(internet, callsWithinNetwork, callsToOtherNetwork, sms, clientCount);
    }

    @Override
    int calculateMonthlyCost() {
        return (int) (roamingCostMultiplier * (getInternetMultiplier() * getInternet() +
                getCallsToOtherNetworks() * getCallsToOtherNetworksMultiplier() +
                getCallsWithinNetwork() * getCallsWithinNetworkMultiplier() +
                getSms() * getSmsMultiplier()));
    }*/


    private double getRoamingMultiplier(){
    return this.roamingMultiplier;
    }

    public void setRoamingMultiplier(double roamingMultiplier){
        this.roamingMultiplier = roamingMultiplier;
    }


    void setMonthlyCost(){
        this.setCostPerMonth(calculateMonthlyCost());
    }

    @Override
    int calculateMonthlyCost() {
        return 0;
    }
}

