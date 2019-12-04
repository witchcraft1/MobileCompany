package model.rate;

public class InternetRate extends Rate{
    private int internetMB;
    private int callsWithinNetwork = 0;
    private int callsOutOfNetwork = 0;
    public InternetRate( int sms, int clientCount, String name, int internetMB) {
        super(sms, clientCount, name);
        this.internetMB = internetMB;
        setCostPerMonth(calculateMonthlyCost());
    }

    public int getInternetMB(){
        return internetMB;
    }

    public void addCallsWithinNetworkPackage(int minutesInsideNetwork){
        this.callsWithinNetwork = minutesInsideNetwork;
    }
    public void addCallsOutOfNetworkPackage(int minutesOutsideOfNetwork){
        this.callsOutOfNetwork = minutesOutsideOfNetwork;
    }

    int calculateMonthlyCost() {
        return (int) (INTERNET_MULTIPLIER * internetMB +
                callsOutOfNetwork * CALLS_TO_OTHER_NETWORK_MULTIPLIER +
                callsWithinNetwork * CALLS_WITHIN_NETWORK_MULTIPLIER +
                getSms() * SMS_MULTIPLIER);
    }

    @Override
    public String toString(){
        StringBuilder string = new StringBuilder(super.toString());
        string.append(", %s: ").append(internetMB)
                .append(", %s: ").append(callsWithinNetwork)
                .append(", %s: ").append(callsOutOfNetwork);
        return string.toString();
    }
}
