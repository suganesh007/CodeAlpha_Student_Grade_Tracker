
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

// all maths functions
class maths
{

// giving the total array inputs by using the parameter given
public static List <Float> Adding_Grades_Array(int total_student)
{
    List <Float> Total_array_values = new ArrayList<>();
    for (int i = 0; i < total_student; i++)
    {
        
        @SuppressWarnings("resource")
        Scanner in = new Scanner(System.in);
        float Grade = 0;
        try
        {
            System.out.print("Enter grade for student " + (i+1) + " = ");
            Grade = in.nextFloat();
            
        }
        catch (InputMismatchException e)
        {
            System.err.println("Enter the Numbers Only !");
            in.nextLine();
            i--;
        }
        
        Total_array_values.add(Grade);
    }
    return Total_array_values;
}

// function for finding the average of the total marks
public static float calculateAverage(List <Float> grades, int total_students)
{
    float sum = 0;
    for (Float n : grades)
        sum = sum + n;
    return sum/total_students;  
}

// Sorting the Array
public static List <Float> SortingArray(List <Float> grades, int total_students)
{
    for (int i = 0; i < total_students; i++)
    {
        for (int j = i+1; j < total_students; j++)
        {
            if (grades.get(i) > grades.get(j))
            {
                float temp = grades.get(i);
                grades.set(i, grades.get(j));
                grades.set(j, temp);
            }
        }
    }
    return grades;
}


}

// main class
public class Grade_Tracker
{
    public static void main(String[] args)
    {
        
        System.out.println("\n\nGrade summary Generator !");
        while (true)
        {    // Scanner
            @SuppressWarnings("resource")
                Scanner in = new Scanner(System.in);


            // input for total no of students
            boolean flag = false;
            int Total_Student = 0;
            while(!flag)
            {
                try
                {
                    System.out.print("Enter the Total number of students = ");
                    Total_Student = in.nextInt();
                    flag = true;
                }

                catch (InputMismatchException e)
                {
                    System.err.println("\nOnly Integer Value will consider");
                    in.nextLine();
                }
            }


            // array for storing students data
            System.err.println("\nEnter the Students grades..");
            List<Float> Grade_List = maths.Adding_Grades_Array(Total_Student);


            // sorted Grades
            List <Float> Sorted_Arrays = maths.SortingArray(Grade_List, Total_Student);


            // average marks for students
            double Average = maths.calculateAverage(Grade_List, Total_Student);


            // Highest mark of them all
            // double High_Mark = Collections.max(grades);   another method
            float Highest_Mark = Sorted_Arrays.get(Total_Student-1);


            // Lowest mark of them all
            float Lowest_mark = Sorted_Arrays.get(0);

            // Printing the outputs
            // Printing the Average Mark
            System.err.println("\nStudents Grade Summary :");
            System.out.printf("Average Grade =%.2f%n ", Average);

            // Printing the highest Mark
            System.err.printf("Highest Grade = " + Highest_Mark);

            //Printing the Lowest Mark
            System.err.printf("\nLowest Grade = " + Lowest_mark);


            // if interested for again
            int Again = 0;
            Boolean flags = true;
            while (flags)
            {
                try 
                {
                    System.out.print("\nWant to continue (press any number for continue other than 0 , 0 for End) = ");
                    Again = in.nextInt();
                    flags = false;
                }
                catch (InputMismatchException e)
                {
                    System.err.println("Enter only numbers !!");
                    in.nextLine();
                }
            }
            
            if (Again == 0)
            {
                System.err.println("\nThank You !!!\n");
                break;
            }
        }
    }
}