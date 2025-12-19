package data;

public enum Subject {
    en("English"),
    ch("Chemistry"),
    cs("Computer Science"),
    co("Commerce"),
    ec("Economics"),
    ss("Social Studies"),
    ar("Arts"),
    his("History"),
    ma("Maths"),
    ac("Accounting"),
    ph("Physics"),
    bi("Biology"),
    hin("Hindi"),
    ci("Civics");

    public final String subject;

    Subject(String subject) {
        this.subject = subject;
    }
}
