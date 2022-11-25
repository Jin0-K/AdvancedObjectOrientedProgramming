import java.util.List;

public class IDE implements Builder {
    String projectName;
    Preprocessor preprocessor;
    Compiler compiler;
    Linker linker;

    IDE(Preprocessor preprocessor, Compiler compiler, Linker linker) {
        this.preprocessor = preprocessor;
        this.compiler = compiler;
        this.linker = linker;
    }

    @Override
    public void createProject(String projectName) {
        this.projectName = projectName;
    }

    @Override
    public Executable build(SourceCode[] code) {
        SourceCode[] processedCode = new SourceCode[code.length];
        ObjectCode[] objs = new ObjectCode[code.length];
        for (int i = 0; i < code.length; i++) {
            processedCode[i] = preprocessor.preprocess(code[i]);
            objs[i] = compiler.compile(processedCode[i]);
        }
        return linker.link(projectName + ".exe", objs);
    }

    @Override
    public Executable build(List<SourceCode> code) {
        SourceCode[] processedCode = new SourceCode[code.size()];
        ObjectCode[] objs = new ObjectCode[code.size()];
        for (int i = 0; i < code.size(); i++) {
            processedCode[i] = preprocessor.preprocess(code.get(i));
            objs[i] = compiler.compile(processedCode[i]);
        }
        return linker.link(projectName + ".exe", objs);
    }
}
