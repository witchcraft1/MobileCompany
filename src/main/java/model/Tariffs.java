package model;


public enum Tariffs {
    NetworkTariff1(100,10000,"Dd",3000,100),
    InternetTariff1(50,320,"Smart++",6000),
    InternetTariff2(0, 500, "WebAccess", 10000),
    NetworkTariff2(300, 5400, "Network+", 10000, 300);
    enum Type{
        Network, Internet;
    }
    private String type;
    private int costPerMonth;
    private int sms;
    private int clientCount;
    private String name;
    private int internetMB;
    private int callsWithinNetwork;
    private int callsOutOfNetwork;

    Tariffs(int sms, int clientCount, String name, int callsWithinNetwork, int callsOutOfNetwork) {
        this.sms = sms;
        this.clientCount = clientCount;
        this.name = name;
        this.callsWithinNetwork = callsWithinNetwork;
        this.callsOutOfNetwork = callsOutOfNetwork;
        this.type = "network";
    }

    Tariffs(int sms, int clientCount, String name, int internetMB) {
        this.sms = sms;
        this.clientCount = clientCount;
        this.name = name;
        this.internetMB = internetMB;
        this.type = "internet";
    }

   public String getType(){ return type;   }

    public int getCostPerMonth() {
        return costPerMonth;
    }

    public int getSms() {
        return sms;
    }

    public int getClientCount() {
        return clientCount;
    }

    public String getName() {
        return name;
    }

    public int getInternetMB() {
        return internetMB;
    }

    public int getCallsWithinNetwork() {
        return callsWithinNetwork;
    }

    public int getCallsOutOfNetwork() {
        return callsOutOfNetwork;
    }
}
