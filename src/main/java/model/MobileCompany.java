package model;

import model.rate.InternetRate;
import model.rate.NetworkRate;
import model.rate.Rate;
import model.rate.RoamingRate;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/*12. Мобильная связь. Определить иерархию тарифов мобильной компании.
            Создать список тарифов компании.
             Посчитать общую численность клиентов.
             Провести сортировку тарифов на основе размера абонентской платы.
             Найти тариф в компании, соответствующий заданному диапазону параметров.
 */
public class MobileCompany {
  //  private int client_count = 0;
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
        int sms, clientCount,costPerMonth;
        String name;
        Tariffs[] tariffs = Tariffs.values();
        for (Tariffs tariff : tariffs) {
            sms = tariff.getSms();
            clientCount = tariff.getClientCount();
            name = tariff.getName();
            costPerMonth = tariff.getCostPerMonth();
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

    public ArrayList<Rate> getRates(){
        return this.rates;
    }
    public void showInfo(){
        System.out.println("Company name - " + companyName);
        for (int i = 0; i < rates.size(); i++) {
            System.out.println(i + 1 + ". " + rates.get(i) );
        }
        System.out.println();
    }
    public void addRate(Rate ...newRates){
        outside:for (Rate newRate:newRates) {
            for (Rate rate:rates) {
                if(rate.getName().equals(newRate.getName())){
                    System.out.println("Tariff " + newRate.getName() + " exists");
                    continue outside;
                }
            }
            rates.add(newRate);
        }
        //this.rates.addAll(Arrays.asList(newRates));
    }

    public int calculateClientCount(){
        int count = 0;
        for (Rate rate:rates) {
            count+= rate.getClientCount();
        }
        return count;
    }

    public void sortRateByPayment(){
        //ArrayList<Rate> ratesClone = rates;
        rates.sort(Comparator.comparingInt(Rate::getCostPerMonth));
        //return ratesClone;
    }

    public ArrayList<InternetRate> sortRateByInternet(){
        ArrayList<InternetRate> alrate = new ArrayList<>();
        for (Rate rate:rates) {
            if(rate.getClass() == InternetRate.class){
                alrate.add((InternetRate) rate);
            }
        }
        alrate.sort(Comparator.comparingInt(InternetRate::getInternetMB));
        return alrate;
       // InternetRate ir = (InternetRate) rates.get(0);
       // Rate rr = new InternetRate(3,4,"5",5);
    }

    //Map<Integer, String>
    public Rate searchRateWith(int ...parameters){
        return new InternetRate(1,1,"Smart", 2);
    }
}
