package HexSecondProject;
import java.util.*;

class Student{
	int ID;
	String name;
	int [] grades;
	
	Student (int ID,String name,int[] grades){
		this.grades=grades;
		this.ID=ID;
		this.name=name;
	}
	public int averageGrade(int []grades,int subjects) {
		int total=0;
		for (int i=0;i<grades.length;i++) {
			total+=grades[i];
		}
		return total/subjects;
		
	}
	public void displayGrades(int [] grades) {
		for (int i=0;i<grades.length;i++) {
			System.out.print("Grade in subject "+(i+1)+": " +grades[i]+" ");
			if(grades[i]>35) {
				System.out.println("Pass");
			}else {
				System.out.println("Fail");
			}
		}
	}
	
}
public class StudentGradeCalculator {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter your name: ");
		String name=scan.nextLine();
		System.out.print("Enter your ID: (E.g: 5432)");
		int id=scan.nextInt();
		System.out.print("How many subjects you have: ");
		int subjects=scan.nextInt();
		int [] grades= new int[subjects];
		int marks=0;
		for(int i=0;i<subjects;i++) {
			System.out.print("Enter Mark for subject "+(i+1)+": (out of 100) ");
			grades[i]=scan.nextInt();
			marks+=grades[i];
		}
		System.out.println("Total Marks: "+marks);
		System.out.println();
		Student newstudent= new Student(id,name,grades);
		System.out.println("Your average grade is: "+newstudent.averageGrade(grades,subjects));
		System.out.println();
		System.out.println("Result of your subjects: ");
		newstudent.displayGrades(grades);
		
	}

}
