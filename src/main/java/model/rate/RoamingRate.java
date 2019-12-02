package model.rate;

public class RoamingRate extends Rate{
    private double roamingMultiplier;

    public RoamingRate(int internet, int callsWithinNetwork, int callsToOtherNetwork, int sms){
        super(internet, callsWithinNetwork, callsToOtherNetwork, sms);
    }



    private double getRoamingMultiplier(){
    return this.roamingMultiplier;
    }

    public void setRoamingMultiplier(double roamingMultiplier){
        this.roamingMultiplier = roamingMultiplier;
    }

    void setMonthlyCost(){
        this.setCostPerMonth((int) (roamingCostMultiplier * (getInternetMultiplier() * getInternet() +
                getCallsToOtherNetworks() * getCallsToOtherNetworksMultiplier() +
                getCallsWithinNetwork() * getCallsWithinNetworkMultiplier() +
                getSms() * getSmsMultiplier())));
    }
}

