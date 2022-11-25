import java.util.ArrayList;
import java.util.List;

public class CLinker implements Linker {
    @Override
    public Executable link(String exeFileName, ObjectCode[] objFiles) {
        String linkedFiles = null;
        if (objFiles.length > 0) {
            linkedFiles = "\n" + objFiles[0].getObjectFileName();
            for (int i = 1; i < objFiles.length; i++) {
                linkedFiles += ("\n" + objFiles[i].getObjectFileName());
            }
            System.out.println("Linking " + linkedFiles);
        }
        return new Executable(exeFileName, linkedFiles);
    }

    @Override
    public Executable link(String exeFileName, List<ObjectCode> objFiles) {
        String linkedFiles = "";
        if (objFiles.size() > 0) {
//            linkedFiles = "\n" + objFiles.get(0).getObjectFileName();
            for (int i = 0; i < objFiles.size(); i++) {
                linkedFiles += ("\n" + objFiles.get(i).getObjectFileName());
            }
        }
        return new Executable(exeFileName, linkedFiles);
    }
}
