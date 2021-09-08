package hw.d06092021_p2.GoF.behavioral.Visitor;

public class Project implements ProjectElement{
    ProjectElement[] projectElements;

    public Project() {
        this.projectElements = new ProjectElement[] {
                new ProjectClass(),
                new Database(),
                new Test()
        };
    }

    @Override
    public void beWritten(Developer developer) {
        for (ProjectElement element : projectElements) {
            element.beWritten(developer);
        }
    }
}
