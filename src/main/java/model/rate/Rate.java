package model.rate;

import model.RateMultipliers;

import java.security.KeyPair;

public abstract class Rate implements RateMultipliers {
    private int costPerMonth; // розмір абонентської плат
    private int internet; //MB
    private int callsWithinNetwork; // звонки внутри этой же сети
    private int callsToOtherNetworks; //
    private int sms;

    public Rate(int internet, int callsWithinNetwork, int callsToOtherNetwork, int sms){
        setInternet(internet);
        setCallsWithinNetwork(callsWithinNetwork);
        setCallsToOtherNetworks(callsToOtherNetwork);
        setSms(sms);
    }
   // abstract void setParameters();

    public double getInternetMultiplier() {
        return INTERNET_MULTIPLIER;
    }

    public double getCallsWithinNetworkMultiplier() {
        return CALLS_WITHIN_NETWORK_MULTIPLIER;
    }

    public double getCallsToOtherNetworksMultiplier() {
        return CALLS_TO_OTHER_NETWORK_MULTIPLIER;
    }

    public double getSmsMultiplier() {
        return SMS_MULTIPLIER;
    }



    public int getCostPerMonth() {
        return costPerMonth;
    }

    public void setCostPerMonth(int costPerMonth) {
        this.costPerMonth = costPerMonth;
    }

    public int getInternet() {
        return internet;
    }

    public void setInternet(int internet) {
        this.internet = internet;
    }

    public int getCallsWithinNetwork() {
        return callsWithinNetwork;
    }

    public void setCallsWithinNetwork(int callsWithinNetwork) {
        this.callsWithinNetwork = callsWithinNetwork;
    }

    public int getCallsToOtherNetworks() {
        return callsToOtherNetworks;
    }

    public void setCallsToOtherNetworks(int callsToOtherNetworks) {
        this.callsToOtherNetworks = callsToOtherNetworks;
    }

    public int getSms() {
        return sms;
    }

    public void setSms(int sms) {
        this.sms = sms;
    }

    @Override
    public String toString(){
        return "costPerMonth: " + costPerMonth + ", internet: " + internet + ", calls within network: " +
                + callsWithinNetwork + ", calls to other networks: " + callsToOtherNetworks + ", sms: " + sms;
    }
}
