package model.rate;

public class RoamingRate extends Rate {
    public enum RoamingTariff {
        Family(),
        Smart(),
        SmartPlus(),
        SmartMax()
    }

    private double roamingMultiplier;

    public RoamingRate(int internet, int callsWithinNetwork, int callsToOtherNetwork, int sms){
        super(internet, callsWithinNetwork, callsToOtherNetwork, sms);
    }

    public double setRoamingMultiplier(double roamingMultiplier){
        this.roamingMultiplier = roamingMultiplier;
    }

    double monthlyCost(){
        return roamingCostMultiplier * (getInternetMultiplier() * getInternet() +
                getCallsToOtherNetworks() * getCallsToOtherNetworksMultiplier() +
                getCallsWithinNetwork() * getCallsWithinNetworkMultiplier() +
                getSms() * getSmsMultiplier());
    }


}
