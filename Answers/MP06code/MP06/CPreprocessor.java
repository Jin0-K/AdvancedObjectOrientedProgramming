public class CPreprocessor implements Preprocessor {
    public SourceCode preprocess(SourceCode code) {
        System.out.println("Preprocessing code: " + code.getCodeFileName());
        String newFileName = "preprocessed_" + code.getCodeFileName();
        System.out.println("Generating a new code: " + newFileName);
        return new SourceCode(newFileName);
    }
}
