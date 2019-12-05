package controller;

import model.MobileCompany;
import model.Model;
import model.rate.InternetRate;
import model.rate.NetworkRate;
import view.View;

public class Controller {
    private Model model;
    private View view;
    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
    }

    public void processUser(){
        MobileCompany kyivstar = new MobileCompany("Kyivstar");
       // MobileCompany lifecell = new MobileCompany("Lifecell");
        view.showInfoAboutAddedRates(kyivstar.addRateAndGetInfo(new InternetRate(2,3,"Smart++",5),
                new NetworkRate(75,100200, "Dd", 44,44),
                new NetworkRate(500,5200, "Network++", 20000,1000)));

        view.print(String.valueOf(kyivstar.calculateClientCount()));
        view.showCompanyInfo(kyivstar.returnInfo(), kyivstar.returnRatesInfo(kyivstar.getRates()));

        kyivstar.sortRateByPayment();
        view.showCompanyInfo(kyivstar.returnInfo(),kyivstar.returnRatesInfo(kyivstar.getRates()));

        view.showCompanyInfo(kyivstar.returnInfo(),
                kyivstar.returnRatesInfo(kyivstar.searchRateByClientCountRange(400,6000)));
    }
}
