package testDome;

import java.util.*;

public class DocumentStore {
    private List<String> documents = new ArrayList<String>();
    private int capacity;

    public DocumentStore(int capacity) {
        capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public Collection<String> getDocuments() {
        return Collections.unmodifiableList(documents);
    }

    public void addDocument(String document) {
        if (this.documents.size() > capacity)
            throw new IllegalStateException();

        documents.add(document);
    }

    @Override
    public String toString() {
        return String.format("Document store: %d/%d", documents.size(), capacity);
    }

    public static void main(String[] args) {
        DocumentStore documentStore = new DocumentStore(2);
        documentStore.addDocument("item");
        System.out.println(documentStore);
    }
}
