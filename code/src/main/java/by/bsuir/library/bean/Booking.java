package by.bsuir.library.bean;

public class Booking extends Entity{
	
	private String dateBooking;
    private int userId;
    private int bookId;
    private String book;
    private int isApproved;
    private String name;
    private String surname;
    
    public Booking() {
    	
    }
    
	public Booking(String date, int userId, int bookId, int isApproved) {
		this.dateBooking = date;
		this.userId = userId;
		this.bookId = bookId;
		this.isApproved = isApproved;
	}

    public String getDateBooking() {
        return dateBooking;
    }

    public int getUserId() {
        return userId;
    }

    public int getBookId() {
        return bookId;
    }

    public int getIsApproved() {
        return isApproved;
    }
    
    public String getBook() {
    	return book;
    }

    public void setDateBooking(String dateBooking) {
        this.dateBooking = dateBooking;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setIsApproved(int isApproved) {
        this.isApproved = isApproved;
    }
    
    public void setBook(String book) {
    	this.book = book;
    }

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((dateBooking == null) ? 0 : dateBooking.hashCode());
        result = prime * result + userId;
        result = prime * result + bookId;
        result = prime * result + isApproved;
        result = prime * result + ((book == null) ? 0 : book.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((surname == null) ? 0 : surname.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Booking other = (Booking) obj;
        if (dateBooking == null) {
            if (other.dateBooking != null)
                return false;
        } else if (!dateBooking.equals(other.dateBooking))
            return false;
        if (userId != other.userId)
            return false;
        if (bookId != other.bookId)
            return false;
        if (isApproved != other.isApproved)
            return false;
        if (book == null) {
            if (other.book != null)
                return false;
        } else if (!book.equals(other.book))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (surname == null) {
            if (other.surname != null)
                return false;
        } else if (!surname.equals(other.surname))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "dateBooking: " + dateBooking + "; userId: " + userId + "; bookId: " + bookId + "; isApproved: " + isApproved;
    }
}
