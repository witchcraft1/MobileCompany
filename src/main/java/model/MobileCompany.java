package model;

import model.rate.Rate;
import model.rate.RoamingRate;

/*12. Мобильная связь. Определить иерархию тарифов мобильной компании.
            Создать список тарифов компании.
             Посчитать общую численность клиентов.
             Провести сортировку тарифов на основе размера абонентской платы.
             Найти тариф в компании, соответствующий заданному диапазону параметров.
 */
public class MobileCompany {
    static int client_count = 0;
    Rate[] rate;
    MobileCompany(Rate[] rate){
        this.rate = rate;
    }
    public MobileCompany(){
        rate = new Rate[4];
    }

    public enum Tariffs{
        Smart(new RoamingRate(4000, 1000, 100, 500)),
        SmartMax(new RoamingRate(6000, 1500, 150, 750));

        private RoamingRate rr;
        Tariffs(RoamingRate rr){
            this.rr = rr;
        }
    }

    /*public Rate[] sortRateByPayment(){

    }

    public Rate searchRateWith(){

    }*/
}
