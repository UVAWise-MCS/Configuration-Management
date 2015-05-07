/**
 * 
 */
package tests;

import static org.junit.Assert.fail;

import org.junit.Test;

import CommandLine.Interpreter;

/**
 * 
 * This is a unit test for the CommandLine.Interpreter class. Makes sure invalid inputs are handled gracefully.
 * 
 * @author Bryan Smith
 * @date 4/30/15
 */
public class InterpreterTest {
				
	@Test
	public void test() {

		//Test help
		try {
			String args[] = new String[1];
			args[0] = "help";
			new Interpreter(args);
		} catch (Exception e) {
			System.out.println(e);
			fail(e.getMessage());
		}
		
		//Test loading no files
		try {
			String args[] = new String[1];
			args[0] = "load";
			new Interpreter(args);
		} catch (Exception e) {
			System.out.println(e);
			fail(e.getMessage());
		}
		
		//Test loading fake files
		try {
			String args[] = new String[3];
			args[0] = "load";
			args[1] = "sadfsdf";
			args[2] = "asfdsdf";
			new Interpreter(args);
		} catch (Exception e) {
			System.out.println(e);
			fail(e.getMessage());
		}
	}

}
