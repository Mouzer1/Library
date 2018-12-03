package by.bsuir.library.bean;

public class Book extends Entity {

	private String name;
    private int amount;
    private String author;
    private int authorId;
    
    public Book() {
    	
    }
    
    public Book(String name, int authorId, int amount) {
    	this.name = name;
    	this.authorId = authorId;
    	this.amount = amount;
    }
    
    public Book(String name, String author, int amount) {
    	this.name = name;
    	this.author = author;
    	this.amount = amount;
    }

    public String getName() {
        return name;
    }
    
    public int getAuthorId() {
        return authorId;
    }

    public int getAmount() {
        return amount;
    }

    public String getAuthor() {
        return author;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    
    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + amount;
        result = prime * result + ((author == null) ? 0 : author.hashCode());
        result = prime * result + authorId;
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
        Book other = (Book) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (amount != other.amount)
            return false;
        if (author == null) {
            if (other.author != null)
                return false;
        } else if (!author.equals(other.author))
            return false;
        if (authorId != other.authorId)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "name: " + name + "; amount" + amount + "; author" + author;
    }

}
