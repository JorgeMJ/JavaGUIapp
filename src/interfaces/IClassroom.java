package interfaces;

/*
 * Interface for Classroom
 */

public interface IClassroom {
        
    public void setRoomNumber(String p_roomNumber);    
    public void setTypeOfRoom(String p_roomType);
    public void setCapacity(int p_capacity);
    
    public String getRoomNumber(); 
    public String getTypeOfRoom();
    public int    getCapacity();
    
}
