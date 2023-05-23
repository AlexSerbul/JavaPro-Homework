package dz13;

import java.io.File;
import java.util.*;

public class FileNavigator {
    private Map<String, List<FileData>> files;

    public FileNavigator() {
        this.files = new HashMap<>();
    }

    public void add(String path){
        File file = new File(path);
        if(file!=null){
            List<FileData> fileList;
            if(files.get(path)!=null){
                fileList = files.get(path);
            }else {
                fileList = new ArrayList<>();
            }
            fileList.add(new FileData(file.getName(),file.length(),file.getPath()));
            files.put(path,fileList);
        }
    }

    public List<FileData> find(String path){
        return files.get(path);
    }

    public List<FileData> filterBySize(long maxSize){
        List<FileData> filteredFiles = new ArrayList<>();
        for(Map.Entry entry: files.entrySet()){
            List<FileData> fileDataList = (List<FileData>) entry.getValue();
            for(FileData fileData: fileDataList){
                if(fileData.getSize()<=maxSize){
                    filteredFiles.add(fileData);
                }
            }
        }
        return filteredFiles;
    }

    public void remove(String path){
        files.remove(path);
    }

    public List<FileData> sortBySize(){
        List<FileData> sortedFiles = new ArrayList<>();
        for (Map.Entry entry: files.entrySet()){
            sortedFiles.addAll((List<FileData>) entry.getValue());
        }
        FileSizeComparator comparator = new FileSizeComparator();
        Collections.sort(sortedFiles,comparator);
        return sortedFiles;
    }

    public Map<String, List<FileData>> getFiles() {
        return files;
    }
}
