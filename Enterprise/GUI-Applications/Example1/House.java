package JavaGui.Example1;

public class House {
    private int room;
    private int bathroom;
    private String owner;

    public House(){
        this.room = 0;
        this.bathroom = 0;
        this.owner = null;
    }


    public House(int room, int bathroom, String owner) {
        this.room = room;
        this.bathroom = bathroom;
        this.owner = owner;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public int getBathroom() {
        return bathroom;
    }

    public void setBathroom(int bathroom) {
        this.bathroom = bathroom;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void printDetails(){
        System.out.println("Owner: " + owner + " Rooms: " + room + " Bathrooms: " + bathroom);
    }
}
