package Web.Bean;

import Module.WeddingManagement.UseCase.ListBooking;

public class TestCallData {

    public static void main(String[] args) {
        System.out.println((new ListBooking()).GetList());
    }
}
