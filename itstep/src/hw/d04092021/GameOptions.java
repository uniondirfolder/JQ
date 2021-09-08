package hw.d04092021;

@Developer
public enum GameOptions {
    FILE_USER("C:\\REPO\\JQ\\src\\com\\nvv\\itstep\\hw\\d04092021\\user.dat"),
    FILE_QUESTIONS("C:\\REPO\\JQ\\src\\com\\nvv\\itstep\\hw\\d04092021\\questions.csv"),
    GAME_FOLDER("C:\\REPO\\JQ\\src\\com\\nvv\\itstep\\hw\\d04092021\\game");

    public final String value;

    GameOptions(String value) {
        this.value = value;
    }
}
