package lesson04_interfaces.exercise.n06_military.enums;

public enum Formats {
    ;
    public static final String NEW_LINE     = System.lineSeparator();
    public static final String SPACE        = " ";
    public static final String DOUBLE_SPACE = "  ";
    public static final String SOLDIER      = "Name: %s %s Id: %d";
    public static final String SALARY       = "Salary: %.2f";
    public static final String PRIVATE      =  SOLDIER + SPACE + SALARY;
    public static final String CODE_NUMBER  = "Code Number: %s";
    public static final String PRIVATES     = "Privates:";
    public static final String CORPS        = "Corps: %s";
    public static final String REPAIRS      = "Repairs:";
    public static final String REPAIR       = "Part Name: %s Hours Worked: %d";
    public static final String MISSION      = "Code Name: %s State: %s";

}
