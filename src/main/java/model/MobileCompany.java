package model;

import model.rate.InternetRate;
import model.rate.NetworkRate;
import model.rate.Rate;

import java.util.ArrayList;
import java.util.Comparator;

public class MobileCompany {
    private String companyName;
    private ArrayList<Rate> rates;
    MobileCompany(ArrayList<Rate> rates){
        this.rates = rates;
    }
    public MobileCompany(String name){
        this.companyName = name;
        rates = new ArrayList<Rate>();
        getRatesFromEnum();
    }

    private void getRatesFromEnum(){
        Rate rateFromEnum;
        int sms, clientCount;
        String name;
        Tariffs[] tariffs = Tariffs.values();
        for (Tariffs tariff : tariffs) {
            sms = tariff.getSms();
            clientCount = tariff.getClientCount();
            name = tariff.getName();
            if(tariff.getType().equals("internet")){
                int internet = tariff.getInternetMB();
                rateFromEnum = new InternetRate(sms,clientCount,name,internet);
            }else {
                int callsWithinNetwork = tariff.getCallsWithinNetwork(),
                        callsOutOfNetwork = tariff.getCallsOutOfNetwork();
                rateFromEnum = new NetworkRate(sms,clientCount,name,callsWithinNetwork,callsOutOfNetwork);
            }
            rates.add(rateFromEnum);
        }
    }

    private boolean doesTheRateExist(Rate checkedRate){
        for (Rate rate:rates) {
            if(rate.getName().equals(checkedRate.getName())){
                return true;
            }
        }
        return false;
    }

    public ArrayList<Rate> getRates(){
        return this.rates;
    }

    public String returnInfo(){
        return "\n%s - " + companyName;
    }

    public String[] returnRatesInfo(ArrayList<Rate> rates){
        String[] str = new String[rates.size()];
        for (int i = 0; i < rates.size(); i++) {
            str[i] = i + 1 + ". " + rates.get(i);
        }
        return str;
    }

    public ArrayList<ArrayList<String>> addRateAndGetInfo(Rate ...newRates){
        ArrayList<String> infoAboutAddedRates = new ArrayList<>();
        ArrayList<String> infoAboutNotAddedRates = new ArrayList<>();
        ArrayList<ArrayList<String>> allInfo = new ArrayList<>();

        for (Rate newRate:newRates) {
            if(doesTheRateExist(newRate))
                infoAboutNotAddedRates.add("%s " + newRate.getName() + " %s");
            else {
                rates.add(newRate);
                infoAboutAddedRates.add("%s " + newRate.getName() + " %s");
            }
        }

        allInfo.add(infoAboutAddedRates);
        allInfo.add(infoAboutNotAddedRates);
        return allInfo;
    }

    public int calculateClientCount(){
        int clientCount = 0;
        for (Rate rate:rates) {
            clientCount += rate.getClientCount();
        }
        return clientCount;
    }

    public void sortRateByPayment(){
        rates.sort(Comparator.comparingInt(Rate::getCostPerMonth));
    }

    public ArrayList<Rate> searchRateByClientCountRange(int min, int max){
        ArrayList<Rate> ratesWithClientCountInRange = new ArrayList<>();
        for (Rate rate : rates) {
            if(rate.hasClientCountInRange(min,max))
                ratesWithClientCountInRange.add(rate);
        }
        return ratesWithClientCountInRange;
        //return new InternetRate(1,1,"Smart", 2);
    }
}
