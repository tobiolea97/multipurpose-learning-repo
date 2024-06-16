package functional.programming.interpreter;

import java.util.HashMap;
import java.util.Map;



public class ReponseParserFactory {

    private static Map<String, ParseHostResponse> parsers = new HashMap<>();

    static {
        parsers.put(AppConstants.PFBU_134, (response) -> {
            Pfbu134Response pfbu134Response = new Pfbu134Response();
            pfbu134Response.setId(response.substring(7, 15));
            pfbu134Response.setName(response.substring(16));
            return pfbu134Response;
        });

        parsers.put(AppConstants.PFBU_135, (response) -> {
            Pfbu134Response pfbu134Response = new Pfbu134Response();
            pfbu134Response.setId(response.substring(8, 16));
            pfbu134Response.setName(response.substring(17));
            return pfbu134Response;
        });

    }

    public static ParseHostResponse get(String pfbuName) {
        if(parsers.containsKey(pfbuName))
            return parsers.get(pfbuName);
        return null;
    }

}
