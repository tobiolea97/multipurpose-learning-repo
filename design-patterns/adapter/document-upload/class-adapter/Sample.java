public interface DocumentUploader {
    void upload();
}

public class PdfDocumentUploader implements DocumentUploader {
    @Override
    public void upload() {
        System.out.println("Preparing PDF document...");
        System.out.println("Uploading PDF document");
    }
}

//this doesnot implement DocumentUploader
public class WordDocumentUploader {

    public void uploadWordDocument() {
        System.out.println("Preparing Word document");
        System.out.println("Uploading Word document");
    }
}

public class WordDocumentAdapter extends WordDocumentUploader implements DocumentUploader {

    @Override
    public void upload() {
        uploadWordDocument();
    }

    @Override
    public void uploadWordDocument() {
        System.out.println("Preparing Word document...");
        System.out.println("Uploading Word document");
    }
}

public class OnlineApplication {

    private final DocumentUploader documentUploader;

    public OnlineApplication(DocumentUploader documentUploader) {
        this.documentUploader = documentUploader;
    }
    
    public void uploadDocument() {
        documentUploader.upload();
    }
}


public class App {

    public static void main(String[] args) {
        var pdfDocumentUploader = new PdfDocumentUploader();
        var onlineApplication = new OnlineApplication(pdfDocumentUploader);
        onlineApplication.uploadDocument();

        var wordDocumentUploader = new WordDocumentAdapter();
        var onlineApplication2 = new OnlineApplication(wordDocumentUploader);
        onlineApplication2.uploadDocument();
    }

}