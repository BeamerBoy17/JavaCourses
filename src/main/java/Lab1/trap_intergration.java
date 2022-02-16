/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab1;
import static java.lang.Math.*;
/**
 *
 * @author Mike Lane
 */
public class trap_intergration {
    public static double integrate_cos(double from,double to,double step) {
	int iterations_count = (int)((abs(from)+abs(to))/step);
	double result = 0;
	result += abs(cos(from));
	for (int i = 1; i < iterations_count-1; i++) {
		result += 2*abs(cos(from+step*i));
	}
	result += cos(to);
	return result*(step/2);
    }   
}
