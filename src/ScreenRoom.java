public class ScreenRoom {

    private String[][] screenRoom;
    private double ticketNumberSold = 0;
    private int currentIncome = 0;
    private int totalSeats;

    public ScreenRoom(int rows, int seats) {
        this.screenRoom = new String[rows + 1][seats + 1];

        for (int i = 1; i <= seats; i++) {
            this.screenRoom[0][i] = String.valueOf(i);
            for (int j = 1; j <= rows; j++) {
                this.screenRoom[j][i] = "S";
            }
        }

        for (int i = 1; i <= rows; i++) {
            this.screenRoom[i][0] = String.valueOf(i);
        }

        this.screenRoom[0][0] = " ";
    }

    public void printScreenRoom() {
        System.out.println("Cinema:");
        for (String[] strings : this.screenRoom) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
    }

    public void calculateTotalSeats(int row, int seat) {
        this.totalSeats = row*seat;
    }

    public void setScreenRoom(int row, int seat) {
        this.screenRoom[row][seat] = "B";
        this.ticketNumberSold++;
    }

    public void calculateTicketPrice(int rows, int userRow) {
        if (totalSeats <= 60) {
            this.currentIncome += 10;
            System.out.println("Ticket price: $" + 10 + "\n");
        } else {
            int frontRows = rows / 2;
            if (userRow <= frontRows) {
                this.currentIncome += 10;
                System.out.println("Ticket price: $" + 10 + "\n");
            } else {
                this.currentIncome += 8;
                System.out.println("Ticket price: $" + 8 + "\n");
            }
        }
    }

    public void totalIncome(int rows, int seats) {
        if (totalSeats <= 60) {
            System.out.println("Total income: $" + totalSeats*10);
        } else {
            int frontRows = rows / 2;
            int backRows = rows - frontRows;
            System.out.println("Total income: $" + ((frontRows*seats*10) + (backRows*seats*8)));
        }
    }

    public double getTicketNumberSold() {
        return ticketNumberSold;
    }

    public int getCurrentIncome() {
        return currentIncome;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public String getScreenRoom(int row, int seat) {
        return screenRoom[row][seat];
    }
}
