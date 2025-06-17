package eidi2.sose25.weber.felix.sheet06.ex02;

import java.util.Optional;

public class Main {

	public static void main(String[] args) {
		GradeOverview go = new GradeOverview();

		go.addTestResult("Mathe", Pair.of(1.7, 6));
		go.addTestResult("Informatik", Pair.of(2.0, 9));
		go.addTestResult("Physik", Pair.of(1.3, 6));

		System.out.println("ECTS: " + go.currentECTS());
		System.out.println("Durchschnitt: " + go.totalGradeAverage());

		Optional<Pair<Double, Integer>> physik = go.getExamResult("Physik");
		physik.ifPresent(p -> System.out.println("Physik: Note " + p.first + ", ECTS " + p.second));
	}

}
