package model;

import model.rate.MobileRate;
import model.rate.Rate;

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

    public Rate[] sortRateByPayment(){

    }

    public Rate searchRateWith(){

    }
}
