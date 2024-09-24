package PM3;

class Passenger {
    String name;
    Passenger next;

    public Passenger(String name) {
        this.name = name;
        this.next = null;
    }
}

class Flight {
    private Passenger head;

    public Flight() {
        this.head = null;
    }

    public void addPassenger(String name) {
        Passenger newPassenger = new Passenger(name);
        if (head == null) {
            head = newPassenger;
        } else {
            Passenger current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newPassenger;
        }
    }

    public void removePassenger(String name) {
        if (head == null) {
            System.out.println("Daftar penumpang kosong.");
            return;
        }

        if (head.name.equals(name)) {
            head = head.next;
            return;
        }

        Passenger current = head;
        Passenger previous = null;

        while (current != null && !current.name.equals(name)) {
            previous = current;
            current = current.next;
        }

        if (current != null) {
            previous.next = current.next; // Menghapus penumpang
        } else {
            System.out.println("Penumpang dengan nama " + name + " tidak ditemukan.");
        }
    }

    public void displayPassengers() {
        if (head == null) {
            System.out.println("Daftar penumpang kosong.");
            return;
        }

        Passenger current = head;
        while (current != null) {
            System.out.println(current.name);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        Flight flight = new Flight();
        flight.addPassenger("isan");
        flight.addPassenger("alen");
        flight.addPassenger("habib");

        System.out.println("Daftar Penumpang:");
        flight.displayPassengers();

        flight.removePassenger("alen");
        System.out.println("\nSetelah menghapus alen:");
        flight.displayPassengers();

        flight.removePassenger("apri"); // Penumpang tidak ada
    }
}

