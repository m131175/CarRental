package hvl.dat109.model;

import java.time.LocalDateTime;

public class Reservation {

    private Address address;
    private LocalDateTime date;
    private RentalOffice rentalOffice;
    private Integer numberOfDays;
    private Customer customer;

    public Reservation(Address address, LocalDateTime date, RentalOffice rentalOffice, Integer numberOfDays, Customer customer) {
        this.address = address;
        this.date = date;
        this.rentalOffice = rentalOffice;
        this.numberOfDays = numberOfDays;
        this.customer = customer;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public RentalOffice getRentalOffice() {
        return rentalOffice;
    }

    public void setRentalOffice(RentalOffice rentalOffice) {
        this.rentalOffice = rentalOffice;
    }

    public Integer getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(Integer numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "address=" + address +
                ", date=" + date +
                ", rentalOffice=" + rentalOffice +
                ", numberOfDays=" + numberOfDays +
                ", customer=" + customer +
                '}';
    }
}
