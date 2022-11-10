import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final String EXE_FILE_NAME = "main.exe";
        
        // 프리프로세서, 컴파일러, 링커 객체 생성
        /*
        
        아래 코드 수정
        
        */
        Preprocessor preprocessor = new Preprocessor() {
            @Override
            public SourceCode preprocess(SourceCode source_code) {
                // Print the file name of the given SourceCode
                System.out.println("Preprocessing C code" + source_code.getFileName());
                // Create new SourceCode and name it
                SourceCode source_code_new = new SourceCode("preprocessed_" + source_code.getFileName());
                // Print the file name of newly created SourceCode
                System.out.println("Generating a new C code: " + source_code_new.getFileName());

                return source_code_new;
            }
        };
        Compiler compiler = new Compiler() {
            @Override
            public ObjectCode compile(SourceCode source_code) {
                String filename = source_code.getFileName();

                // Print the file name of the given SourceCode
                System.out.println("Compiling code: " + filename);
                // Create new ObjectCode with the file name of the given SourceCode
                filename = filename.replace(".c", ".obj");
                ObjectCode object_code = new ObjectCode(filename);
                // Print the file name of the newly created ObjectCode
                System.out.println("Generating object code: " + object_code.getFileName());

                return object_code;
            }
        };
        Linker linker = new Linker() {
            @Override
            public Executable link(String exeFileName, ObjectCode[] objFiles) {
                String files_linked = "";
                // Concatenate ObjectCode in objFiles and put it in files_linked
                System.out.print("Linking");
                for (ObjectCode file : objFiles) {
                    files_linked = files_linked.concat("\n").concat(file.getFileName());
                }
                // Print files by line
                System.out.println(files_linked);

                return new Executable("output.exe", files_linked);
            }

            @Override
            public Executable link(String exeFileName, List<ObjectCode> objFiles) {
                String files_linked = "";
                // Concatenate ObjectCode in objFiles and put it in files_linked
                System.out.print("Linking");
                for (ObjectCode file : objFiles) {
                    files_linked = files_linked.concat("\n").concat(file.getFileName());
                }
                // Print files by line
                System.out.println(files_linked);

                return new Executable("output.exe", files_linked);
            }
        };
        
        // 프리프로세서, 컴파일러, 링커를 각각 따로 사용해서 exe파일 생성하고 실행
        String[] fileNames = { "a.c", "b.c", "c.c" };
        // SourceCode 객체 생성
        System.out.println("\n소스 코드 생성");
        SourceCode[] code = new SourceCode[fileNames.length];
        for (int i = 0; i < fileNames.length; i++) {
            code[i] = new SourceCode(fileNames[i]);
        }

        // preprocess 소스 코드
        System.out.println("\n프리프로세서 사용");
        SourceCode[] preprocessedCode = new SourceCode[fileNames.length];
        for (int i = 0; i < fileNames.length; i++) {
            preprocessedCode[i] = preprocessor.preprocess(code[i]);
        }
        // compile preprocessed 코드
        System.out.println("\n컴파일러 사용");
        ObjectCode[] objs = new ObjectCode[fileNames.length];
        for (int i = 0; i < fileNames.length; i++) {
            objs[i] = compiler.compile(preprocessedCode[i]);
        }
        // link 오브젝트 파일
        System.out.println("\n링커 사용");
        Executable exe = linker.link(EXE_FILE_NAME, objs);
        System.out.println("\n실행");
        exe.execute();

        System.out.println("\nIDE 사용");

        // 퍼사드 패턴을 이용해서 구현한 IDE 객체를 생성한 후 exe파일을 빌드하고 실행
        // IDE를 사용할 때는 배열과 리스트 버전 두 가지 빌드 함수를 각각 사용해서
        // ArrayProject.exe와 ListProject.exe를 생성하는 코드를 추가할 것
        // 배열을 리스트로 변환하는 것은 Arrays.asList() 함수 사용 가능
 
        /*
        
        코드 추가 
        
        */
    }
}
