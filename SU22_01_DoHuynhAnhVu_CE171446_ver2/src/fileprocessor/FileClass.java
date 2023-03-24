/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileprocessor;

/**
 *
 * @author Dell
 */
public class FileClass {
            //============= THUOC TINH =================
    private String path;
    private String InputContent;          
    private long size;
    
            //=============== KHOI TAO ==================
    public FileClass() {}                   
    
    /**
     *
     */
    public FileClass(String path, String InputContent, long size) throws Exception {
        super();
        this.path = path;
        this.InputContent = InputContent;
        this.size = size;
        
    }
 
    // ======================== GET & SET & toString =======================
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getInputContent() {
        return InputContent;
    }

    public void setInputContent(String InputContent) {
        this.InputContent = InputContent;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "File{" + "path=" + path + ", InputContent=" + InputContent + ", size=" + size + '}';
    }
    
}
