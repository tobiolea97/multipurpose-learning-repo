package functional.programming.interpreter;


public class Client {

    private static final String PFBU_134_MOCK_RESPONSE = "PFBU134 40379479TOBIAS OLEA MARTINEZ";
    private static final String PFBU_135_MOCK_RESPONSE = "PFBU134  40379479TOBIAS OLEA MARTINEZ";

    public static void main(String[] args) {
        ParseHostResponse pfbu134ResponseParser = ReponseParserFactory.get(AppConstants.PFBU_134);
        Pfbu134Response pfbu134Response = (Pfbu134Response) pfbu134ResponseParser.parse(PFBU_134_MOCK_RESPONSE);
        System.out.println(pfbu134Response);
    }

}
