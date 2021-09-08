package hw.d23082021;
@Developer
public interface Parse {
    Items toItems(String expression) throws CustomException;

    Item toItem() throws CustomException;
}
