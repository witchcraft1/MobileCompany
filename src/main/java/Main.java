import controller.Controller;
import model.MobileCompany;
import view.View;

public class Main {
    public static void main(String[] args) {
        /*12. Мобильная связь. Определить иерархию тарифов мобильной компании.
            Создать список тарифов компании.
             Посчитать общую численность клиентов.
             Провести сортировку тарифов на основе размера абонентской платы.
             Найти тариф в компании, соответствующий заданному диапазону параметров.
            */
        Controller controller = new Controller(new MobileCompany(),new View());
        controller.processUser();
    }
}
