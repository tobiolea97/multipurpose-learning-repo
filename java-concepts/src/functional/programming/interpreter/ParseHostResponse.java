package functional.programming.interpreter;

@FunctionalInterface
public interface ParseHostResponse <T extends HostResponse> {
    T parse(String response);
}
