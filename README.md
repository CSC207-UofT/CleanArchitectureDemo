A course enrolment manager with almost no features. A work in progress toward the Clean Architecture.

Clone, compile, and run this program. You will be prompted for several pieces of information, and then be enrolled in a course. Then the program exits.

The UI (the command line, so `System.in` and `System.out`) has been separated into another layer and injected into the `run` method. That way, other UIs can be injected, and as an example, there is a test case that uses an implementation that reads from a `String` array instead of from the keyboard, and saves output to another `String` array so that it can be checked for correctness in the test case.
