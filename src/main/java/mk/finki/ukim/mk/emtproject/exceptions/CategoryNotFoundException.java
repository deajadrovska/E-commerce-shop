package mk.finki.ukim.mk.emtproject.exceptions;



public class CategoryNotFoundException extends RuntimeException{
    public CategoryNotFoundException() {
        super("Category Not Found");
    }
}
