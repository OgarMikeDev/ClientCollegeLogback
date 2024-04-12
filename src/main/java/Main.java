import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Client clientOne = new Client(
                "Vadim", 32, 89676400941l, "sotnikov.v.v@mail.ru");

        Client clientTwo = new Client(
                "Alex", 39, 89676400942l, "rybyhin.a.v@mail.ru");

        Client clientThree = new Client(
                "Seva", 30, 89676400943l, "ostrovscki.v.a@mail.ru");

        Client clientFour = new Client(
                "Rad", 14, 89676400944l, "juravlev.r.k@mail.ru");

        Client clientFive = new Client(
                "Sasha", 20, 89676400945l, "karpinskiy.v.v@mail.ru");

        Client clientSix = new Client(
                "Ulyana", 16, 89676400946l, "frolova.u.i@mail.ru");

        Client clientSeven = new Client(
                "Dima", 17, 89676400947l, "minosyan.d.v@mail.ru");

        Client clientEight = new Client(
                "Andy", 16, 89676400948l, "grigorov.a.g@mail.ru");

        System.out.println("Input on the console command \"PrintInformationAboutClients\", \"Remove\":");
        String command = new Scanner(System.in).nextLine();
        if (command.equals("PrintInformationAboutClients")) {
            Client.printInformationAboutClients();
        } else if (command.equals("Remove")) {
            System.out.println("Input criterion for remove client: ");
            long number = new Scanner(System.in).nextLong();
            Client.removeClient(number);
        }
    }
}
