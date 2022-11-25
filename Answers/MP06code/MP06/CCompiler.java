public class CCompiler implements Compiler {
    @Override
    public ObjectCode compile(SourceCode code) {
        System.out.println("Compiling code: " + code.getCodeFileName());
        String name = code.getCodeFileName();
        name = name.substring(0, name.length() - 2) + ".obj";
        System.out.println("Generating object code: " + name);
        return new ObjectCode(name);
    }
}
