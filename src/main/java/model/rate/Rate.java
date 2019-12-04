package model.rate;

import model.RateMultipliers;

public abstract class Rate implements RateMultipliers {
    private int costPerMonth; // розмір абонентської плат
  //  private int internet; //MB
   // private int callsWithinNetwork; // звонки внутри этой же сети
   // private int callsToOtherNetworks; //
    private int sms;
    private int clientCount;
    private String name;

    public Rate(int sms, int clientCount, String name){
        //this.costPerMonth = costPerMonth;
        this.sms = sms;
        this.clientCount = clientCount;
        this.name = name;
       // this.costPerMonth = calculateMonthlyCost(); // можливо, в ІнтернетРейт ще не проініціалізується поле ІНтернетМБ
    }
   // abstract void setParameters();

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

    /*  public int getInternet() {
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
*/

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

   /* public double getInternetMultiplier() {
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
    }*/

    @Override
    public String toString(){
        return "Rate -- " + name + ":\n cost per month: " + costPerMonth + ", sms: " + sms + ", client count: " + clientCount ;
    }
}
