package annotation.be.apt.mirror.apt;
// https://docs.oracle.com/javase/7/docs/jdk/api/apt/mirror/com/sun/mirror/apt/RoundState.html

@LevelH(0)
public interface RoundState {
    boolean finalRound();
    boolean errorRaised();
    boolean sourceFilesCreated();
    boolean classFilesCreated();
}
