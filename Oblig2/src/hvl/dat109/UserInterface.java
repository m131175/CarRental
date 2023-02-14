package hvl.dat109;

import hvl.dat109.factory.CarFactory;
import hvl.dat109.factory.Factory;
import hvl.dat109.model.*;

import java.time.LocalDateTime;
import java.util.*;

public class UserInterface {
    static Factory f = new Factory();
    private static List<CarCategory> carCategories = f.carCategoriesFactory();
    private static List<RentalOffice> rentalOffices = f.rentalOfficesFactory();

    public static void welcome() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Velkommen til Bilutleie" + "\nFor hvilket utlånskontor ønsker du å se vår bilpark?");
        for(int i = 0; i < f.carCategoriesFactory().size(); i++) {
            System.out.println(rentalOffices.get(i).getOfficeNumber() + ": " + rentalOffices.get(i).getAddress().getCity());
        }
        Integer locationChoice = sc.nextInt();
        reservation(locationChoice);
    }

    public static void reservation(Integer locationNumber) {
        CarFactory cF = new CarFactory();
        Scanner sc = new Scanner(System.in);

        List<Car> cars = cF.carFactory();

        System.out.println("Hvilken bilklasse ønsker du å se?");
        System.out.println("A: Liten bil" + "\nB: Mellomstor bil" + "\nC: Stor bil" + "\nD: Stasjonsvogn");
        String categoryChoice = sc.nextLine();

        RentalGroup rg = RentalGroup.A;
        switch (categoryChoice) {
            case "A":
                rg = RentalGroup.A;
                break;
            case "B":
                rg = RentalGroup.B;
                break;
            case "C":
                rg = RentalGroup.C;
                break;
            case "D":
                rg = RentalGroup.D;
                break;
        }

        Integer carChoiceIndex;
        System.out.println("Velg bil som kan være interessant?");
        for(int i = 0; i < cF.carFactory().size(); i++) {
            if (rg == cars.get(i).getCarCategory().getRentalgroup()
                    && Objects.equals(locationNumber, cars.get(i).getRentalOffice().getOfficeNumber())
                    && cars.get(i).getAvailable()) {
                System.out.println(i + " " + cars.get(i).getBrand() + " " + cars.get(i).getType());
            }
        }
        carChoiceIndex = sc.nextInt();

        System.out.println(cars.get(carChoiceIndex).toString());
        System.out.println("Ønsker du å reservere denne bilen? Ja/Nei");
        String choice = sc.next();
        choice = choice.toLowerCase();

        Car pickedCar = cars.get(carChoiceIndex);
        if (choice.equals("ja")) {
            System.out.println("Vi må registrere noe informasjon om deg.\nHva er fornavnet ditt?");
            String fornavn = sc.next();
            System.out.println("Hva er etternavnet ditt?");
            String etternavn = sc.next();
            System.out.println("Hva er mobilnummeret ditt?");
            Integer mobil = sc.nextInt();
            System.out.println("Vi trenger adressen din.\nPostnummer?");
            Integer postnummer = sc.nextInt();
            System.out.println("Poststed?");
            String poststed = sc.next();
            System.out.println("Gateadresse?");
            String gateAdresse = sc.next();
            System.out.println("Vi trenger kredittkort informasjon.\nKortnummer?");
            Long cnum = sc.nextLong();
            System.out.println("Utløpsdato?");
            String dato = sc.next();
            System.out.println("Hvor mangen dager ønsker du å reservere bilen for?");
            Integer numOfDays = sc.nextInt();
            Reservation res = new Reservation(pickedCar.getRentalOffice().getAddress(), LocalDateTime.now(), pickedCar.getRentalOffice(), numOfDays,
                    new Customer(fornavn, etternavn, new Address(poststed,postnummer,gateAdresse), mobil));
            pickedCar.setAvailable(false);
            System.out.println("Takk! Her er din reservasjon: \n" + res.toString());
        } else if (choice == "nei"){
            reservation(locationNumber);
        }
    }
}
