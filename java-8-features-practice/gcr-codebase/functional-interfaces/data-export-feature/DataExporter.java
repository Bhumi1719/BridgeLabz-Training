interface DataExporter {
    void exportToCSV(String data);
    void exportToPDF(String data);

    // Using default method for JSON export
    default void exportToJSON(String data) {
        System.out.println("Exporting data to JSON: " + data);
    }
}