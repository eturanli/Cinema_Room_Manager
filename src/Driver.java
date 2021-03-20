import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = scanner.nextInt();
        boolean isRunning = true;

        ScreenRoom screenRoom = new ScreenRoom(rows, seats);
        screenRoom.calculateTotalSeats(rows, seats);

        while (isRunning) {
            menu();
            switch (scanner.nextInt()) {
                case 0:
                    isRunning = false;
                    break;
                case 1:
                    screenRoom.printScreenRoom();
                    break;
                case 2:
                    boolean isCorrect = false;
                    while (!isCorrect) {
                        System.out.println("Enter a row number:");
                        int userRow = scanner.nextInt();
                        System.out.println("Enter a seat number in that row:");
                        int userSeat = scanner.nextInt();

                        if (userRow > rows || userRow < 1 || userSeat > seats ||userSeat < 1) {
                            System.out.println("Wrong input!");
                        } else {
                            while (!isCorrect) {
                                if(screenRoom.getScreenRoom(userRow,userSeat).equals("B")) {
                                    System.out.println("That ticket has already been purchased!");
                                    break;
                                }else {
                                    screenRoom.setScreenRoom(userRow, userSeat);
                                    screenRoom.calculateTicketPrice(rows, userRow);
                                    isCorrect = true;
                                }
                            }
                        }
                    }
                    break;
                case 3:
                    System.out.println("Number of purchased tickets: " + (int) screenRoom.getTicketNumberSold());
                    System.out.println("Percentage: " +
                            String.format("%.2f", screenRoom.getTicketNumberSold() / screenRoom.getTotalSeats()*100) + "%");
                    System.out.println("Current income: $" + screenRoom.getCurrentIncome());
                    screenRoom.totalIncome(rows, seats);
            }
        }
    }

    static void menu() {
        System.out.println("1. Show the seats\n" +
                "2. Buy a ticket\n" +
                "3. Statistics\n" +
                "0. Exit");
    }
}
