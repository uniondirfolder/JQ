package hw.d04092021;

@Developer
public enum FileExtension {
    CSV(".csv"), TXT(".txt");

    public final String extension;

    FileExtension(String extension) {
        this.extension = extension;
    }
}
