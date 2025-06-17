package eidi2.sose25.weber.felix.sheet06.material.ex02;

public class Main {

	public static void main(String[] args) {
		GradeOverview go = new GradeOverview();
		go.addTestResult("EidI 1", Pair.of(1.3, 6));
		go.addTestResult("EidI 2", Pair.of(2.3, 8));
		System.out.println(go.currentECTS());
		System.out.println(go.totalGradeAverage());
	}

}
