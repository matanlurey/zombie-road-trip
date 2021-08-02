package data;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataReaderTest {
    private static final DataReader dataReader = new DataReader();
    
    @Test
    void readString() {
        String string = "(0, 1, 394), (0, 2, 4)";
        List<Path> actual = dataReader.readPaths(string);
        Path path1 = new Path(0, 1, 394);
        Path path2 = new Path(0, 2, 4);
        assertEquals(List.of(path1, path2), actual);
    }
}
