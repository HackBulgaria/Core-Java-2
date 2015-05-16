package com.hackbulgaria.corejava2;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import com.hackbulgaria.corejava2.data.Gender;
import com.hackbulgaria.corejava2.data.Student;

public class StudentOperationsImpl implements StudentOperations {

    private List<Student> students;

    public StudentOperationsImpl(List<Student> students) {
	this.students = students;
    }

    @Override
    public List<Student> getAllPassing() {
	return students.stream().filter(s -> s.getGrade() >= 3.0f).collect(Collectors.toList());
    }

    @Override
    public List<Student> getAllFailing() {
	return students.stream().filter(s -> s.getGrade() < 3.0f).collect(Collectors.toList());
    }

    @Override
    public double getAverageMark() {
	return (float) students.stream().mapToDouble(s -> s.getGrade()).average().getAsDouble();
    }

    @Override
    public Map<Boolean, List<Student>> splitStudentsByMarks(float splitMark) {
	return students.stream().collect(Collectors.partitioningBy(s -> s.getGrade() >= splitMark));
    }

    @Override
    public List<Student> orderByMarkDescending() {
	Comparator<? super Student> comparator = (s1, s2) -> Double.valueOf(s1.getGrade()).compareTo(Double.valueOf(s2.getGrade()));
	return students.stream().sorted(comparator.reversed()).collect(Collectors.toList());
    }

    @Override
    public List<Student> orderByMarkAscending() {
	Comparator<? super Student> comparator = (s1, s2) -> Double.valueOf(s1.getGrade()).compareTo(Double.valueOf(s2.getGrade()));
	return students.stream().sorted(comparator).collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Double>> getMarksDistributionByAge() {
	return students.stream().collect(Collectors.groupingBy(Student::getAge)).entrySet().stream()
		.collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue().stream().map(Student::getGrade).collect(Collectors.toList())));
    }

    @Override
    public Map<Gender, Double> getAverageMarkByGender() {
	return students.stream().collect(Collectors.groupingBy(Student::getGender, Collectors.averagingDouble(Student::getGrade)));
    }

    @Override
    public Map<Double, Integer> getMarksDistribution() {
	return students.stream().collect(Collectors.groupingBy(Student::getGrade)).entrySet().stream()
		.collect(Collectors.<Entry<Double, List<Student>>, Double, Integer> toMap(e -> e.getKey(),
				e -> Integer.valueOf((int) e.getValue().stream().map(Student::getGrade).count())));
    }

    @Override
    public String getEmailToHeader() {
	return students.stream().map(Student::getEmail).collect(Collectors.joining(", "));
    }

    @Override
    public Map<Gender, Map<Integer, List<Student>>> splitStudentMarksByGenderAndThenByAge() {
	return students.stream().collect(Collectors.groupingBy(Student::getGender)).entrySet().stream()
		.collect(Collectors.<Entry<Gender, List<Student>>, Gender, 
			Map<Integer,List<Student>>> toMap(e -> e.getKey(), e -> e.getValue().stream().collect(Collectors.groupingBy(Student::getAge))));
    }

    @Override
    public List<Student> getStudentsWithLowestMarks() {
	Comparator<? super Student> comparator = (s1, s2) -> Double.compare(s1.getGrade(), s2.getGrade());
	Map<Double, List<Student>> collect = students.stream().collect(Collectors.groupingBy(Student::getGrade));
	return collect.get(collect.keySet().stream().mapToDouble(d->d).min().getAsDouble());
    }

    @Override
    public List<Student> getStudentsWithHighestMarks() {
	Comparator<? super Student> comparator = (s1, s2) -> Double.compare(s1.getGrade(), s2.getGrade());
	Map<Double, List<Student>> collect = students.stream().collect(Collectors.groupingBy(Student::getGrade));
	return collect.get(collect.keySet().stream().mapToDouble(d->d).max().getAsDouble());
    }

}
