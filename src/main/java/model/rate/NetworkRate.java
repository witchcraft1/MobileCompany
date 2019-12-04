package model.rate;

public class NetworkRate extends Rate{
    private int internetMB = 0;
    private int callsWithinNetwork;
    private int callsOutOfNetwork;

    public NetworkRate(int sms, int clientCount, String name, int callsWithinNetwork, int callsOutOfNetwork) {
        super(sms, clientCount, name);
        this.callsWithinNetwork = callsWithinNetwork;
        this.callsOutOfNetwork = callsOutOfNetwork;
        setCostPerMonth(calculateMonthlyCost());
    }

    public void addInternetPackage(int internetMB){
        this.internetMB = internetMB;
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
        string.append(internetMB == 0 ? "" : ", internet MBs: " + internetMB)
                .append(", minutes within network: ").append(callsWithinNetwork)
                .append(", minutes to other networks: ").append(callsOutOfNetwork);
        return string.toString();
    }
}
