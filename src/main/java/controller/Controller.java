package controller;

import model.MobileCompany;
import model.Model;
import model.rate.InternetRate;
import model.rate.NetworkRate;
import model.rate.Rate;
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
        kyivstar.addRate(new InternetRate(2,3,"Smart++",5));
        kyivstar.addRate(new NetworkRate(75,100200, "Dd", 44,44));
        System.out.println(kyivstar.calculateClientCount());
        kyivstar.showInfo();//System.out.println(kyivstar.getRates());
        kyivstar.sortRateByPayment();
        kyivstar.showInfo();//System.out.println(kyivstar.getRates());
    }
}
