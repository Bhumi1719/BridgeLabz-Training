class SoftwareEngineer extends JobRole {
    public SoftwareEngineer() {
        super("Software Engineer");
    }

    @Override
    public void screenResume() {
        System.out.println("Screening Software Engineer resume: checking coding skills and projects.");
    }
}

class DataScientist extends JobRole {
    public DataScientist() {
        super("Data Scientist");
    }

    @Override
    public void screenResume() {
        System.out.println("Screening Data Scientist resume: checking statistics, ML skills, and projects.");
    }
}

class ProductManager extends JobRole {
    public ProductManager() {
        super("Product Manager");
    }

    @Override
    public void screenResume() {
        System.out.println("Screening Product Manager resume: checking leadership, roadmap, and product skills.");
    }
}
