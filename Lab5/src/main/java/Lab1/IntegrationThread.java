/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab1;

import static java.lang.Math.abs;

/**
 *
 * @author tront
 */
class IntegrationThread extends Thread {
	double from;
	double to;
	double step;
	double result;
	IntegrationThread(double from, double to, double step){
		this.from = from;
		this.to = to;
		this.step = step;
	}
	IntegrationThread(){
		from = to = step = result = 0;
	}
	public void run() {
		result = TrapIntergration.integrate_cos(from,to,step);
	}
	public synchronized double getResult(){
		return result;
	}
}


