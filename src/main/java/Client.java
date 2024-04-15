import java.util.*;

public class Client implements Comparable<Client> {
    private static TreeSet<Client> setClients = new TreeSet<>();
    private String name; //Mike
    private int age; //23
    private long phoneNumber; //89676400941
    private String email; //mura.m.v@mail.ru

    public Client(String name, int age, long phoneNumber, String email) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
        setClients.add(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int compareTo(Client o) {
        return getName().compareTo(o.getName());

    }

    public static void printInformationAboutClients() {
        for (Client currentClient : setClients) {
            System.out.println(currentClient);
        }
    }

    public static void removeClient(long phoneNumber) {
        Iterator<Client> clientIterator = setClients.iterator();
        while (clientIterator.hasNext()) {
            Client client = clientIterator.next();
            if (client.getPhoneNumber() == phoneNumber) {
                System.out.println("Client \"" + client.getName() + "\" removed");
                clientIterator.remove();
            }
        }
    }

    @Override
    public String toString() {
        return "Name \"" + getName() + "\"" +
                "\nAge \"" + getAge() + "\"" +
                "\nPhone number \"" + getPhoneNumber() + "\"" +
                "\nEmail \"" + getEmail() + "\".\n";
    }
}
