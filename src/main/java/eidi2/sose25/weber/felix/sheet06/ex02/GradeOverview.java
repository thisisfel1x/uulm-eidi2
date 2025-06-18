package eidi2.sose25.weber.felix.sheet06.ex02;

import java.util.HashMap;
import java.util.Optional;

public class GradeOverview {
	private final HashMap<String, Pair<Double, Integer>> GRADEOVERVIEW = new HashMap<>();
	
	public void addTestResult(String lectureName, Pair<Double, Integer> gradeAndECTS) {
		this.GRADEOVERVIEW.put(lectureName, gradeAndECTS);
	}
	
	public int currentECTS() {
		int totalEcts = 0;

		for (Pair<Double, Integer> value : this.GRADEOVERVIEW.values()) {
			totalEcts += value.second;
		}


		return this.GRADEOVERVIEW.values().stream().mapToInt(value -> value.second).sum();
	}
	
	public Optional<Pair<Double, Integer>> getExamResult(String lectureName) {
		return Optional.ofNullable(this.GRADEOVERVIEW.get(lectureName));
	}
	
	public double totalGradeAverage() {
		int totalECTS = 0;
		double weightedSum = 0.0;

		for (Pair<Double, Integer> entry : this.GRADEOVERVIEW.values()) {
			weightedSum += entry.first * entry.second;
			totalECTS += entry.second;
		}

		return totalECTS > 0 ? weightedSum / totalECTS : 0.0;
	}
}
