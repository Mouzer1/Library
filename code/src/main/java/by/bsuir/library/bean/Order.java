package by.bsuir.library.bean;

public class Order extends Entity {

    private String dateTaking;
    private String book;
    private int bookingId;
    private int isReturned;
    private String name;
    private String surname;
    
    public Order() {
    	
    }
    
    public Order(String date, int bookingId, int isReturned) {
    	this.dateTaking = date;
    	this.bookingId = bookingId;
    	this.isReturned = isReturned;
    }

    public String getName() {
		return name;
	}
    
	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
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

	public String getDateTaking() {
        return dateTaking;
    }

    public String getBook() {
        return book;
    }

    public int getIsReturned() {
        return isReturned;
    }

    public void setDateTaking(String dateTaking) {
        this.dateTaking = dateTaking;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public void setIsReturned(int isReturned) {
        this.isReturned = isReturned;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((dateTaking == null) ? 0 : dateTaking.hashCode());
        result = prime * result + ((book == null) ? 0 : book.hashCode());
        result = prime * result + isReturned;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((surname == null) ? 0 : surname.hashCode());
        result = prime * result + bookingId;
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
        Order other = (Order) obj;
        if (dateTaking == null) {
            if (other.dateTaking != null)
                return false;
        } else if (!dateTaking.equals(other.dateTaking))
            return false;
        if (book == null) {
            if (other.book != null)
                return false;
        } else if (!book.equals(other.book))
            return false;
        if (isReturned != other.isReturned)
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
        if (bookingId != other.bookingId)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "dateTaking: " + dateTaking + "; book: " + book + "; isReturned: " + isReturned;
    }
}
