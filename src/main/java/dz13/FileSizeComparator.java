package dz13;

import java.util.Comparator;

public class FileSizeComparator implements Comparator<FileData> {
    @Override
    public int compare(FileData o1, FileData o2) {
        return Long.compare(o1.getSize(),o2.getSize());
    }
}
