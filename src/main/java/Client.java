import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Client implements Comparable<Client> {
    private static ArrayList<Client> setClients = new ArrayList<>();
    private String name; //Mike
    private int age; //23
    private long phoneNumber; //89676400941
    private String regexForPhoneNumber = "8[0-9]{10}";
    private String email; //mura.m.v@mail.ru

    Logger logger = LoggerFactory.getLogger(Main.class);

    public Client(String name, int age, long phoneNumber, String email) {
        this.name = name;
        this.age = age;

        if (String.valueOf(phoneNumber).matches(regexForPhoneNumber)) {
            this.phoneNumber = phoneNumber;
        } else {
            logger.error("Phone number incorrect from \"" + name + "\"");
            phoneNumber = 0;
        }

        if (email.contains("@")) {
            this.email = email;
        } else {
            logger.error("Email input incorrect from \"" + name + "\"");
            email = null;
        }

        if (phoneNumber != 0 &&
                email != null &&
                !setClients.contains(this)) {
            setClients.add(this);
            logger.info(this.toString());
        }
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return age == client.age && phoneNumber == client.phoneNumber && Objects.equals(name, client.name) && Objects.equals(regexForPhoneNumber, client.regexForPhoneNumber) && Objects.equals(email, client.email) && Objects.equals(logger, client.logger);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, phoneNumber, regexForPhoneNumber, email, logger);
    }

    @Override
    public String toString() {
        return "Name \"" + getName() + "\"" +
                "\nAge \"" + getAge() + "\"" +
                "\nPhone number \"" + getPhoneNumber() + "\"" +
                "\nEmail \"" + getEmail() + "\".\n";
    }
}
